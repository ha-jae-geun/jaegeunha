# datasource
* xe/orcl, id 조심
```java
	<bean
		class="org.springframework.jdbc.datasource.DriverManagerDataSource"
		id="dataSource">
		<property name="driverClassName"
			value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy" />
		<property name="url"
			value="jdbc:log4jdbc:oracle:thin:@localhost:1521/xe" />
		<property name="username" value="system" />
		<property name="password" value="1234" />
	</bean>
```
