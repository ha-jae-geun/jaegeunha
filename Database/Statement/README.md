# Statement와 PreparedStatement
```java
Statement vs PreparedStatement
우선 속도 면에서 PreparedStatement가 빠르다고 알려져 있다. 이유는 쿼리를 수행하기 전에 이미 쿼리가 컴파일 되어 있으며, 
반복 수행의 경우 프리 컴파일된 쿼리를 통해 수행이 이루어지기 때문이다.

PreparedStatement에는 보통 변수를 설정하고 바인딩하는 static sql이 사용되고 Statement에서는 쿼리 자체에 조건이 들어가는 
dynamic sql이 사용된다. PreparedStatement가 파싱 타임을 줄여주는 것은 분명하지만 static sql을 사용하는데 
따르는 퍼포먼스 저하를 고려하지 않을 수 없다.

하지만 성능을 고려할 때 시간 부분에서 가장 큰 비중을 차지하는 것은 테이블에서 레코드(row)를 가져오는 과정이고 SQL 
문을 파싱하는 시간은 이 시간의 10 분의 1 에 불과하다. 그렇기 때문에 SQL Injection 등의 문제를 보완해주는 PreparedStatement를 
사용하는 것이 옳다.
```

# #과 {}
```java
1. #
<select id="selectPerson" parameterType="int" resultType="hashmap">
  SELECT * FROM PERSON WHERE ID = #{id}
</select>
이 구문의 이름은 selectPerson이고 int타입의 파라미터를 가진다. 그리고 결과 데이터는 HashMap 에 저장된다.

파라미터 표기법을 보자.

#{id}
이 표기법은 마이바티스에게 PreparedStatement파라미터를 만들도록 지시한다.
 JDBC를 사용할 때 PreparedStatement에는 “?”형태로 파라미터가 전달된다. 즉 결과적으로 위 설정은 아래와 같이 작동하게 되는 셈이다.

```

## $
```java
#{} 문법은 마이바티스로 하여금 PreparedStatement프로퍼티를 만들어서 PreparedStatement파라미터(예를들면 ?)에 
값을 셋팅하도록 할 것이다. 이 방법이 안전하기는 하지만 빠른 방법이 선호되기도 한다. 가끔은 SQL 구문에 변하지 않는 
값으로 삽입하길 원하기도 한다. 예를들면 ORDER BY와 같은 구문들이다.

ORDER BY ${columnName}
여기서 마이바티스는 문자열을 변경하거나 이스케이프 처리하지 않는다.

String Substitution can be very useful when the metadata(i.e. table name or column name) 
in the sql statement is dynamic, for example, if you want to select from a table by any one of its columns, 
instead of writing code like:

@Select("select * from user where id = #{id}")
User findById(@Param("id") long id);

@Select("select * from user where name = #{name}")
User findByName(@Param("name") String name);

@Select("select * from user where email = #{email}")
User findByEmail(@Param("email") String email);

// and more "findByXxx" method
you can just write:

@Select("select * from user where ${column} = #{value}")
User findByColumn(@Param("column") String column, @Param("value") String value);
in which the ${column} will be substituted directly and the #{value} will be "prepared". 
Thus you can just do the same work by:

User userOfId1 = userMapper.findByColumn("id", 1L);
User userOfNameKid = userMapper.findByColumn("name", "kid");
User userOfEmail = userMapper.findByColumn("email", "noone@nowhere.com");
```
* 사용자로부터 받은 값을 이 방법으로 변경하지 않고 구문에 전달하는 건 안전하지 않다. 이건 잠재적으로 SQL 
주입 공격에 노출된다. 그러므로 사용자 입력값에 대해서는 이 방법을 사용하면 안된다. 사용자 입력값에 대해서는 
언제나 자체적으로 이스케이프 처리하고 체크해야 한다.

```java
PrepareStatment(#)와 Statment($)를 정확히 모르고 사용하시는 분들이 있어 정리해봤습니다.

 - 간혹 Statment를 숫자일때 사용한다.. 라고 생각하시는 분들고 계시고 정확한 의미를 모르는 분들이 계십니다. 
 정리된 내용 보시기 바랍니다.



1. #의 사용 (PrepareStatment)

 - #을 사용할 경우 오라클의 PreparedStatment를 사용하게 된다.



  예제(name=John)

   a. mybatis mapper

      SELECT NAME FROM TEST WHERE NAME=#{name}

   b. 오라클에서 받은 쿼리

      SELECT NAME FROM TEST WHERE NAME = ?



실제 수행 쿼리

SELECT NAME FROM TEST WHERE NAME='John'



2. $의 사용(Statment)

 - $는 간단히 스트링 자체를 변환(REPLACE)해 버린다



  예제(score=99)

   a. mybatis mapper 

      SELECT NAME FROM TEST WHERE SCORE=${score}

   b. 오라클에서 받은 쿼리 

      SELECT NAME FROM TEST WHERE SCORE=99



실제 수행 쿼리

SELECT NAME FROM TEST WHERE NAME=99



3. 차이

두 가지가 똑같아 보이지만 붉게 처리된 부분을 볼 경우 1번은 오라클에서 변수를 바인드 처리 하기 때문에

NAME 값이 달라질 경우 같은 쿼리로 인식하게 됩니다.

(반드시는 아니지만 일반적으로 오라클의 쿼리 파싱, 캐시 등의 이점으로 CPU 및 수행 속도 차이가 나게 됩니다)



2번의 경우 b부분을 봤을때 쿼리 자체가 변경되어 들어가기 때문에 SCORE가 다른값이 올 경우


 
오라클은 이를 완전 다른 쿼리로 인식하기 때문에 새로 파싱 등의 작업을 하게 되고 속도가 느려질 우려가 있습니다.



그럼 Statment의 경우 어떻때 쓰는게 좋을까요?



SELECT ${column_name} FROM SCORE



위 쿼리같이 Bind를 할수 없는 경우 Statment를 사용하게 됩니다.

하지만 문자열 자체가 변형되기 때문에 보안상 취약할 수 있습니다.



예를 들면 아래와 같은 경우입니다.

user를 'admin'--로 세팅, password='aaa'

SELECT * FROM USER WHERE ID=${user} AND PASSWORD=${password}

실제 수행 쿼리

SELECT * FROM USER WHERE ID='admin'-- AND PASSWORD='aaa'



녹색 부분이 주석처리되어 admin으로 접속이 가능하게 되었습니다.



출처: https://www.donnert.net/65 [donnert.net]
```
