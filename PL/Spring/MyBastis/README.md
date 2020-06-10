# SelectKey
```java
DB작업을 하다보면 먼저 사전에 어떤 키값을 가져와서 증가시켜서 입력하거나 혹은 입력후에 증가된 키값을 가져올 필요가 있다.

이럴때 mybatis에서 제공하는 selectKey를 이용하면 별도의 쿼리로직을 등록할 필요없이 해당 메소드에서 일괄처리할 수가 있다.

샘플로 아래와 같은 board테이블이 있다고 하자(mysql, mariadb)

create table board(
 iq int not null auto_increment,
 boardID varchar(20) not null,
 title varchar(50) not null,
 content text not null,
 primary key(iq),
 unique(boardID)
);
iq는 자동증가값이고 boardID는 unique하게 증가되서 입력되어야 한다(실제로 이렇게 테이블을 설계하지는 않겠지만, 예를 들어 만든 것이다)

보통 작업시 두가지 경우가 생기게 된다.

1.입력하기전에 특정키값을 가져온 다음 그 값을 이용해서 처리하고 싶다.
아래처럼 만약 Board라는 게시판에서 입력을 수행시 boardID값을 기존에 최대값에 +1한 다음에 그 값을 입력하고 싶다면 아래의 같이 처리하면 된다.

<insert id="insertBoard" parameterType="Board">
    <selectKey resultType="string" keyProperty="boardID" order="BEFORE">
        SELECT MAX(boardID)+1 FROM board        
    </selectKey>    
    INSERT INTO board(boardID, title, content)
    VALUES(#{boardID}, #{title}, #{content})
</insert>  
<selectKey>구문을 <insert>구문에 넣어준다. resultType은 해당 컬럽의 타입을 정해주면 된다. keyProperty는 
컬럼명이다. Board 클래스에서는 boardID가 setter, getter메소드가 존재해야 한다. (getBoard(), setBoardID())

order는 해당 쿼리의 순서를 의미하다. BEFORE라면 insert쿼리문 수행전에 selectKey가 실행된다. 위에서는 기존의 boardID를 
가져오는 부분이기 때문에 당연히 order=BEFORE를 사용했다.

2. 방금 입력한 값의 특정값을 리턴해주고 싶다.
만약, 입력한후에 입력된 값의 컬럼값(자동증가값)을 가져오고 싶다면 아래와 같이 진행한다.
SELECT LAST_INSERT_ID()은 mysql(mariadb)에서 사용한다. 방금입력한 테이블의 auto_increment로 증가된 컬럼값을 가져오는 
쿼리이다. order=AFTER로 설정한다. 따라서 아래처럼 xml에 추가해주면 된다.

<insert id="insertSurveyInfo" parameterType="Board">
    INSERT INTO board(boardID, title, content)
    VALUES(#{boarID}, #{title}, #{content})
    <selectKey resultType="int" keyProperty="iq" order="AFTER">
        SELECT LAST_INSERT_ID()
    </selectKey>        
</insert>
이때, 리턴값은 parameterType에 넘겨준 객체에 넘어간다. 즉, 위에서는 이 메소드를 호출한 클래스에서 파라미터로 넘긴
board에서 바로 board.getIq()로 해당값을 가져올 수 있다.

이처럼 selectKey를 사용하려면 applicationContext.xml에서 아래처럼 BATCH 기본설정부분이 주석처리되거나 없어야 한다 
(없앤다고 배치가 안되는 것은 아니다. 다만 아래처럼 하면 모든 insert,update,delete가 배치형태로 진행이 된다)

<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
    <constructor-arg index="0" ref="sqlSessionFactory" />      
    <!--<constructor-arg index="1" value="BATCH" /> -->
</bean>  
이렇게 하지 않으면 값을 가져오는 부분에서 모두 -2147482646 로 처리되면서 원하는 값을 얻어오지 못하게 된다.
```
