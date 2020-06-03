# 네임 스페이스
```java
src/main/webapp/WEB-INF/spring/root-context.xml을 열고

아래에 Namespaces클릭한후 빨간박스에 있는것들을 체크해줍니다.

그리고 Namespaces 왼쪽에 Source탭에 들어갑니다.

	<!-- 오라클 접속 -->
    <bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" id="dataSource">
        <property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"/>
        <property name="url" value="jdbc:log4jdbc:oracle:thin:@localhost:1521/orcl"/>
        <property name="username" value="MelonPeach"/>
        <property name="password" value="1234"/>
    </bean>
   
    <!-- Mybatis 연동 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
         <property name="dataSource" ref="dataSource"></property>
         <property name="configLocation" value="classpath:/mybatis-config.xml"></property>
         <property name="mapperLocations" value="classpath:mappers/**/*Mapper.xml"/>
    </bean>
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
        <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"></constructor-arg>
    </bean>
```
* orcl/xe 조심

# 이제 스프링이 스캔 할수 있도록 root-context.xml파일에 코드를 추가해줍니다.
```java
    <!-- scan -->
    <context:component-scan base-package="kr.co.service"></context:component-scan>
    <context:component-scan base-package="kr.co.dao"></context:component-scan>
    <context:component-scan base-package="kr.co.vo"></context:component-scan>
```
