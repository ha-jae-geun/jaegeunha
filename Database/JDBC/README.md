# Persistence
* 데이터를 생성한 프로그램의 실행이 종료되더라도 사라지지 않는 데이터의 특성(프로세스에서 만들어낸 램에 있는 데이터를 영구히 저장하려 하는 것)

# JDBC API 구조
* Java Application > JDBC API > JDBC Driver Manager
* JDBC Driver Manager 아래에
  * JDBC Driver -> MySQL/Oracle/SQL Server/ODBC Driver
  * JDBC Driver Manger만 바꿔주면 JDBC API에 맞게 응답할 수 있게 할 수 있음
* DriverManger를 이용해서 Ceonnection 인스턴스를 얻는다
  * Connecton을 통해서 Statement를 얻는다
  * Statement를 이용해 REsultSet을 얻는다

# SQL Mapper

## JDBC SQLMAPPER
* Application(DAO) > JDBC Interface(Spring JDBC) <- DataSource > JDBC Implements(JDBC Driver) > Database

## MyBastis
* SQL을 분리하자
* Query를 Java에서 XML로 옮겨서 작성
* ResultSet과 같이 결곽밧을 맵핑하는 객체 없음


# ORM(Ojbect-Relational Mapping)
* 이전에는 물리적으로 SQL과 JDBC API를 데이터 접근 계층에 숨기는데 성공했을지 몰라도 논리적으로는 엔티티와 아주 강한 의존관계를 가지고 있다.
* 패러다임의 불일치(연과 관계(객체 참조), 상속)

## JPA
* 애플리케이션 -> JPA 표준 인터페이스 -> Hibernate/EclipseLink/DataNucleus

### 엔티티 메니저
* [어노테이션]((https://dev-troh.tistory.com/151)
* [전체 설명](https://ultrakain.gitbooks.io/jpa/chapter1/chapter1.1.html)
* 컨텍스트를 4개로 분리
  1. Managed
  2. Transient
  3. Detached
  4. Removed
* Transient (Persist/Save entity) -> Managed (flush)-> DB
* 영속성 컨텍스트
* LazyLoading
* Dirty Checking
* Caching

## Hibernate

## Spring JPA
* 엔티티 메니저 대신 Repository 사용
  * Repository 내부 코드에 엔티티 매니저가 있다.
* Spring Application -> Spring Data JDBC -> JDBC API > JDBC Driver Manager > JDBC Driver > DBMS

# JDBC 역사
* 1990년대 중반 인터넷 보급, DB 산업 성장
  * 온라인 비즈니스의 투자 증가, DB Connector에 대한 니즈
  * 자바 지녕의 Database 연결 표준 인터페이스
 
# jdbc
## 외부에 있는 오라클 라이브러리로 JDBC 사용하기(가장 안정된 User Library)
1. C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 복사
- ojdbc6_g: 개발자 용;  서버에는 ojdbc6만 사용
2. windows-preference - java - build path - user libraries - new(이름 무작위) - add external jars - ojdbc 추가 - JDBC 프로젝트 마우스 우측해서 build configure - add libray - 추가한 lib 추가
- 패키지 임포트 -> JDBC 드라이버 Load -> Connection 객체 생성 -> Statement 객체 생성 -> query 수행 -> Result 객체로부터 데이터 추출 -> Resultset Close -> Statement 객체 Close -> Connection 객체 Close

## jdbc 연동 자바 코드
- sql문을 뺴고 바뀔 것은 없다.
- Class.forName() 을 이용해서 드라이버 로드 - - 
- DriverManager.getConnection() 으로 연결 얻기
- Connection 인스턴스를 이용해서 Statement 객체 생성
- Statement 객체의 결과를 ResultSet 이나 int에 받기
- syso로 sql을 중간에 찍어보는 습관 가지기
- String sql = “select deptno, dname, loc” + “ from dept”; 연결 연산자 사용하기

 * import java.sql.Connection;
 * import java.sql.DriverManager;
 * import java.sql.ResultSet;
 * import java.sql.SQLException;
 * import java.sql.Statement;
 * 
 * public class ConA {
 * 
 * 	public static void main(String[] args) {
 * 
 * 		// Oracle.jdbc.driver 안에 oracledriver class를 적은 것.
 * 		String driver = "oracle.jdbc.driver.OracleDriver";
 * 		// express는 전역자 SID는 xe, Standard는 orc
 * 		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
 * 		String userid = "scott";
 * 		String password = "tiger";
 * 		Connection connection = null;
 * 		Statement statement = null;
 * 		ResultSet resultSet = null; // 결과 호출
 * 
 * 		try {
 * 			Class.forName(driver); // Class.forName() 을 이용해서 드라이버 로드, try catch 예외로 잡는다
 * 			try {
 * 				connection = DriverManager.getConnection(url, userid, password);
 * 				System.out.println(connection);
 * 				statement = connection.createStatement(); // statement를 사용할 수 있도록 만듬
 * 				String sql = "select deptno, dname, loc from dept";
 * 				resultSet = statement.executeQuery(sql);
 * 				System.out.println(resultSet);
 * 
 * 				while (resultSet.next()) {
 * 
 * 					int deptno = resultSet.getInt("deptno");
 * 					String dname = resultSet.getString("dname");
 * 					String loc = resultSet.getString("loc");
 * 
 * 					System.out.println(deptno + " " + dname + " " + loc);
 * 
 * 				}
 * 
 * 				System.out.println(statement);
 * 			} catch (SQLException e) {
 * 				// TODO Auto-generated catch block
 * 				e.printStackTrace();
 * 			}
 * 		} catch (ClassNotFoundException e) {
 * 			// TODO Auto-generated catch block
 * 			e.printStackTrace();
 * 		} finally {
 * 			try {
 * 				resultSet.close(); // 역순으로 자원 해제
 * 				statement.close(); // 역순으로 자원 해제
 * 				connection.close(); // 역순으로 자원 해제
 * 			} catch (SQLException e) {
 * 				// TODO Auto-generated catch block
 * 				e.printStackTrace();
 * 			}
 * 
 * 		}
 * 
 * 	}
 * 
 * }

## jdbc 메소드
### Class.forName()
- "com.mysql.jdbc.Driver" 클래스가 메모리에 로드된다. 메모리에 로드되면서 static 절이 실행된다. 특별히 다른 과정을 거치지 않았음에도 불구하고 JDBC Driver가 자동으로 등록되는 이유이다.
- forName(String className) 메소드는 분자열로 주어진 클래스나 인터페이스 이름을 객체로 리턴한다.
- MySQL: Class.forName("com.mysql.jdbc.Driver");
- 오라클: Class.forName("oracle.jdbc.driver.OracleDriver");
- Class.forName()은 클래스로더 라는 녀석을 통해서 해당 데이터베이스 드라이버를 로드할 뿐 데이터베이스와의 연결에 관해서는 아무런 동작도 하지 않는다고 합니다. 리턴값도 받지 않는다.
- 동적 로딩이란 : 어떠한 클래스가 로딩 될지 모르기 때문에 Class 클래스의 forName()함수를 이용해서 해당 클래스를 메모리로 로드 하는 것입니다.
 -   Class classExample=null;
     - classExample=Class.forName(args[0]);  
- 메모리로 로드 된다고 해서 인자로 받은 클래스가 객체로 생성되어서 메모리로 로드 되는것이 아니라 이는 static으로 선언한 변수, 함수에 한해서 메모리 공간 static 영역에 로드 되는 것입니다.
- getClass() 메소드는 해당 클래스로 객체를 생성했을 때만 사용할 수 있는데, 객체를 생성하기 전에 직접 Class 객체를 얻을 수도 있습니다. Class는 생성자를 감추고 있기 때문에 new 연산자로 객체를 만들 수 없고, 정적 메소드인 forName()을 이용해야 합니다. forName() 메소드는 클래스 전체 이름(패키지가 포함된 이름)을 파라미터로 받고 Class 객체를 리턴합니다.
 
 
 
### Connection
- Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest", "jspid","jsptest");
- Connection 객체를 연결하는 것으로 DriverManager에 등록된 각 드라이버들을 getConnection(String url) 메소드를 사용해서 식별한다. 이때 url 식별자와 같은 것을 찾아서 매핑(mapping)한다. 찾지 못하면 no suitable error 가 발생한다.


### Statement
- 3단계 (Statement/PreparedStatement/CallableStatement 객체 생성)
- sql 쿼리를 생성/실행하며, 반환된 결과를 가져오게 할 작업 영역을 제공한다.
- Statement 객체는 Connection 객체의 createStatement() 메소드를 사용하여 생성된다
- Statement stmt = conn.createStatement();

## 4단계 (Query 수행)
- - Statement 객체가 생성되면 Statement 객체의 executeQuery() 메소드나 executeUpdate() 메소드를 사용해서 쿼리를 처리한다.
- - stmt.executeQuery : recordSet 반환 => Select 문에서 사용
- ResultSet rs = stmt.executeQuery("select * from 소속기관"); // select문만
- - stmt.executeUpdate() : 성공한 row 수 반환 => Insert문, Update문, Delete문에서 사용

## 5단계
- - executeQuery() 메소드는 결과로 ResultSet을 반환한다. 이 ResultSet으로부터 원하는 데이터를 추출하는 과정을 말한다.
- - 데이터를 추출하는 방법은 ResultSet 에서 한 행씩 이동하면서 getXxx()를 이용해서 원하는 필드 값을 추출하는데, 이때 rs.getString("name") 혹은 rs.getString(1) 을 사용한다.
- - ResultSet의 첫 번째 필드는 1 부터 시작한다.
- - 한 행이 처리되고 다음 행으로 이동 시 next() 메소드를 사용한다.


# JDBC
1. ① 데이터베이스와 연결하는 드라이버 파일을 찾아서 인스턴스를 발생시킨다. 
- 드라이브를 로딩하기 위해서는 반드시 String 클래스 타입으로 지정한다. = 오라클에 클래스를 등록한다. 2. 경로를 지정해준다.(URL은 각 회사들이 지정해 두었다.)
2. ② 연결을 관리하는 Connection 인터페이스 인스턴스를 생성한다. 
3. ③ 작업을 처리할 Statement 인터페이스와 PreparedStatement 인터페이스 그리고 을 PL/SQL 지원하는 CallableStatement 인터페이스 인스턴스를 생성한다. 
- PreparedStatement 인터페이스는 바인드 변수를 사용하고 ‘?’를 사용한다.
4. ④ 반환되는 결과는 ResultSet 인터페이스 인스턴스에 담는다. 
5. ⑤ 접속을 종료한다




## forName
 * 		String driver = "oracle.jdbc.driver.OracleDriver";
 * 		String url = “jdbc:oracle:thin@127.0.0.1:1521:xe”
 * 		
 * 		System.out.println(driver);
 * 
 * 		try {
 * 			Class.forName(driver);
 * 		} catch (ClassNotFoundException e) {
 * 			// TODO Auto-generated catch block
 * 			e.printStackTrace();
 * 		}
 * 	}
 * 
 * Class.forName(“oracle.jdbc.driver.OracleDriver”) //이렇게 표현해도 됨 

## static을 이용한 forName
 * 	static {
 * 		try {
 * 			Class.forName("oracle.jdbc.driver.Oracle");
 * 		} catch (ClassNotFoundException e) {
 * 			// TODO Auto-generated catch block
 * 			e.printStackTrace();
 * 		}
 * 	}
- OracleDriver 클래스는 초기화 블록에서 드라이버를 로드하므로 로딩하자마자 드라이버를 메모리에 올린다 static . 
- ⎼읽어 들일 클래스가 존재하지 않을 수 있으므로 ClassNotFoundException 예외를 처리한다. 
- ⎼클래스의 forName 메서드는 특정 클래스를 읽어서 인스턴스를 메모리에 올리는 역할을 하므로 드라이버 클래스를 읽어서 메모리에 올리는 부분이다. 
- 

# Statement
- ⎼Statement 인터페이스는 삽입 수정 삭제 검색을 처리하는 문을 사용한다 , , , DML . - ⎼Statement 인터페이스는 Connection 인터페이스 인스턴스의 연결 정보를 가져와서 에 접근하므로 이 인스턴스를 DB 사용하기 위해서는 접속 상태인 Connection 인터페이스 인스턴스가 먼저 존재해야 한다.


## Statement 단점
 ⎼Statement 인터페이스는 새로운 레코드를 여러 번 저장하는 경우에 동일한 insert 문을 여러 번 작성해야 되며 문자 데이터 및 날짜 데이터인 경우에는 반드시 단일 따옴표 를 지정해야 된다 (‘) . 
- ⎼Statement 인터페이스는 중복 코드가 많아져서 성능 면에서 떨어지고 단일 따옴표 을 지정하지 않으면 예외가 (‘) 발생되기 때문에 코드 작업이 비효율적이다. 

## Statement 예제
 * statement = connection.createStatement( ); String sql = "select deptno, dname, loc from dept "; resultSet = statement.executeQuery(sql); while (resultSet.next( )) { int deptno = resultSet.getInt("deptno"); String dname = resultSet.getString("dname"); String loc = resultSet.getString("loc"); System.out.println(deptno + " " + dname + " " + loc); } 

## Statement 예제2
 * statement = connection.createStatement( ); String sql = "insert into dept(deptno,dname,loc) " + 연구 부산 " values ( 50,' ',' ')"; int i = statement.executeUpdate(sql); System.out.println(i + 개의 레코드가 저장되었습니다 " .");



# PreparedStatement
- String sql = "insert into dept (deptno,dname,loc) values (?,?,?)";



## PreparedStatement 예제
 * String sql = "insert into dept (deptno,dname,loc) "; 
 * sql += " values (?, ?, ?) "; preparedStatement = connection.prepareStatement(sql); preparedStatement.setInt(1, 60);  // 1은 1번째 인덱스를 의미, 2는 값
 * preparedStatement.setString(2, 관리 " "); 
 * preparedStatement.setString(3, 부산 " "); 


## PreparedStatement 메소드
① 메서드 setInt 
- ⎼setInt인덱스 매개변수 메서드는 레코드 값을 지정한 ( , ) setter 메서드로 int 자료형으로 수정하고 인덱스는 와일드카 드(? 의 인덱스 값이며 매개변수는 컬럼명이다 ) . 


2. ② 메서드 setString 
- ⎼setString 인덱스 매개변수 메서드는 레코드 값을 지정한 ( , ) setter 메서드로 String 클래스 자료형으로 수정하고 인덱스는 와일드카드(? 의 인덱스 값이며 매개변수는 컬럼명이다 ) . 


3. ③ 메서드 setDate 
- ⎼setDate 인덱스 매개변수 메서드는 레코드 값을 지정한 ( , ) setter 메서드로 Date 클래스 자료형으로 수정하고 인덱스는 와일드카드(? 의 인덱스 값이며 매개변수는 컬럼명이다 

## Statement와 PreparedStatement 차이
- statement = connection.createStatement();  // Statement 공간 먼저 만들기
- 				String sql = "";  2. SQL만들기
- predpared statement는 		PreparedStatement preparedStatement = null; 만 해주면 Statement 공간 만들어 줄 필요 없다.



# Command
- 입력 - 모델 - 서비스 - 출력

# DTO
- 입력 - DTO(데이터베이스 연동) - 서비스 - 출력

# DAO
- 입력 - 모델 - 서비스 - 출력

## 서비스 메소드
1. - 기존의 서비스
2. - DB 연동 서비스: DAO(쿼리문이 들어감)


# 와일드카드
- 특정 문자를 변수처럼 사용

# 커넥션 풀
- 웹같이 동시 접속자수가 많을 때 사용하지만 커넥션 풀을 쓰려면 라이브러리가 필요해서 무겁다.
- 자원해제(close)를 해줄 필요도 없다.
- 연동하기 위해서는 드라이버를 로드하고 로 접속하여 JDBC JDBC URL Connection 인터페이스 인스턴스를 얻어 오는 단계를 거쳐야 하는데 커넥션 풀은 데이터베이스와 연결된 Connection 인터페이스 인스턴스를 미리 생성하여 풀 속에 저장해 두고 필요할 때마다 
- 이 풀에 접근하여 (Pool) Connection 인터페이스 인스턴스를 사용하고 작업이 끝나면 다시 반환하는 것을 말한다. 
- ⎼커넥션 풀은 사용자의 요청에 따라 Connection 인터페이스 인스턴스를 생성하다 보면 많은 수의 연결이 발생했을 때 서버에 과부하가 걸리게 되므로 이러한 상황을 방지하기 위해 미리 일정 수의 Connection 인터페이스 인스턴스를 만들어 풀에 담아 뒀다가 사용자의 요청이 발생하면 연결을 해주고 연결 종료 시 풀에 다시 반환하여 보관하는 것이다.

## 커넥션 풀 필요한 이유
```java
해당 웹 사이트에서 접속자는 게시판을 확인하고 자신이 쓴 게시물을 수정하고 또 새로운 게시글을 등록합니다.

그럼 이 한명의 접속자로 인해 DB접속은 아래와 같이 발생합니다.

1. 데이터 취득 2. 검색 후 데이터 취득  3. 데이터 갱신  4. 데이터 새등록

한명의 접속자로 인해 단 시간에 4번의 DB 접속이 일어난다.

만약 접속자가 1000명 이라면 몇번의 DB 접속이 일어날까?

이러한 오버헤드를 방지하기위해 미리 Connection 객체를 생성하고 해당 Connection 객체를 관리하는것을 의미한다.

즉 Connection Pool에 DB와 연결을 해 놓은 객체를 두고

필요할 때마다 Connection Pool에서 빌려오는 것 이라고 생각하면 된다.

그리고 연결이 끝나면 다시 Pool에 돌려준다.

Connection Pool을 너무 크게 해놓으면 당연히 메모리 소모가 크게 되고

적게 해놓으면 Connection이 많이 발생할 경우 대기 시간이 발생하기 때문에

웹 사이트 동시 접속자 수 등 서버 부하에 따라 크기를 조정해야 한다.
```

## 커넥션 풀 장점
* 그만큼 어플리케이션의 실행 속도가 빨라지며 또한 한 번에 생성될 수 있는 Connection 수를 제어하기 때문에 동시 접속자 수가 몰려도 웹 어플리케이션이 쉽게 다운되지 않는다.

## 커넥션 풀 단점
* Connection Pool에서 생성되어 있는 Connection의 수는 한정적이기 때문에 Connection Pool에 있는 Connection의 수보다 동시 접속자가 많아지면 Connection을 갖지 못한 사용자는 대기 상태로 전환되고 Connection이 반환되면 대기하고 있는 순서대로 Connection이 제공된다.

## 커넥션 풀 구현
1. ① 직접 구현 ⎼개발자가 직접 인터페이스를 구현하거나 직접 새로운 형태의 커넥션 풀을 구현하는 방법이다 javax.sql.DataSource . 
2. ② 아파치 자카르타 를 이용한 구현 (Apache Jakarta) DBCP API ⎼아파치 그룹의 공개된 데이터베이스 커넥션 풀 인 을 이용하는 방법이다 API DBCP(DataBase Connection Pool) . 
3. ③ 어플리케이션 서버 제공 ⎼어플리케이션에서 제공되는 커넥션 풀을 사용하는 방법으로 웹 어플리케이션 서버들은 javax.sql.DataSource 인터페이스를 따르는 커넥션 풀을 제공하므로 호환에는 큰 문제가 없고 이 경우 네이밍 서비스 JNDI (Java 를 통해 커넥션 풀을 사용할 수 있다 Naming and Directory Interface) . 
4. ④ 프레임워크 제공; 스프링에서 제공 ⎼어플리케이션 서버와는 별도로 스프링과 같은 어플리케이션 프레임워크에서 제공하는 커넥션 풀을 사용하는 방법이다. 


# 커넥션 풀의 구조
- ⎼커넥션 풀을 사용할 때 커넥션 풀 개수와 스레드의 수 그리고 커넥션 풀의 재 사용시 초기화가 제대로 되는지 등을 확인해야 하며 그렇지 않으면 메모리 부족 또는 응 답 시간 초과로 인한 에러가 발생하거나 입력한 값이 제대로 나오지 않을 수 있다.


# Statement 인터페이스
* statement 인터페이스는 실제 데이터베이스에 쿼리를 보내기 위해 필요한 객체로 일반적인 문을 전송할 SQL 때 사용하는 이다 API .
* Statement 인터페이스는 삽입 수정 삭제 검색을 처리하는 문을 사용한다 , , , DML . ⎼Statement 인터페이스는 Connection 인터페이스 객체의 연결 정보를 가져와서 에 접근하므로 이 객체를 사용하기 DB 위해서는 접속 상태인 Connection 인터페이스 객체가 먼저 존재해야 한다. ⎼
* tatement 인터페이스는 새로운 레코드를 여러 번 저장하는 경우에 동일한 insert 문을 여러 번 작성해야 되며 문자 데이터 및 날짜 데이터인 경우에는 반드시 이중 따옴표 를 지정해야 된다 (‘) . 
* Statement 인터페이스는 중복 코드가 많아져서 성능 면에서 떨어지고 이중 따옴표 을 지정하지 않으면 예외가 (‘) 발생되기 때문에 코드 작업이 비효율적이다. 

## PreparedStatement 
* PreparedStatement 인터페이스가 하는 일은 Statement 인터페이스와 같으며 문을 한번만 작성하고 데이터만 SQL 나중에 추가로 설정하면서 작업을 할 수 있는 이다 API .
* reparedStatement 인터페이스 객체를 이용하게 되면 Statement 인터페이스 객체로는 할 수 없는 기능을 쉽게 구현할 수 있다. * PreparedStatement 인터페이스는 새로운 레코드를 여러 번 저장하는 경우에 한번만 insert 문을 생성하면 되기 때문에 중복 코드가 제거되어 성능이 뛰어나다. ⎼
* reparedStatement 인터페이스는 가독성이 높으며 문자 데이터나 날짜 데이터에 이중 따옴표 를 실수로 지정하지 (‘) 못해서 발생되는 예외도 막을 수 있다. 
* PreparedStatement 인터페이스는 Statement 인터페이스의 하위 인터페이스로 Statement 인터페이스가 정적인 문장을 실행하는 데 주로 사용된다면SQL PreparedStatement 인터페이스는 동적인 문장을 실행하는데 SQL 주로 사용된다. 
* PreparedStatement 인터페이스는 객체를 생성할 때 구문을 미리 파싱하고 오라클에서는 오라클의 바인딩 SQL 변수 처리 방식을 이용하는 것이 PreparedStatement 인터페이스 객체이며 바인딩 변수인 와일드카드(? 로 조건 ) 값을 받도록 하면 조건 값만 바뀌어서 반복해서 전송되어 오는 문장을 다른 문장으로 판단하지 않기 SQL SQL 때문에 파싱 작업을 다시 하지 않아서 처리 속도가 빨라진다. 


# API 개요
- http://jakarta.apache.org/ 
- collection, dbcp, pool, logging 다운
1. ① commons-collections4-4.0.jar ⎼확장 또는 자바 컬렉션 프레임워크를 확장한다. ⎼자바 컬렉션 프레임워크는 추가 되었으며 응용 프로그램의 개발을 가속화 많은 강력한 JDK 1.2 Java 데이터 구조를 추가할 수 있다. 
2. ② commons-dbcp2-2.0.jar ⎼데이터베이스 연결 풀링 서비스를 제공한다. ⎼연결 풀링 서비스는 관계 데이터베이스에서 새로운 연결을 위한 필요한 데이터베이스 트랜잭션을 수 행 시간에서 걸리는 시간을 최소화 할 수 있다. 
- 환경설정 -> 클래스; BasicDataSource
3. ③ commons-pool2-2.2.jar ⎼일반 인스턴스 풀링 구성 요소이다. ⎼아파치 커먼즈 풀 오픈 소스 소프트웨어 라이브러리는 인스턴스 풀링 및 개체 풀 구현을 제공한 API 다. 
- 커넥션을 담는 것
4. ④ commons-logging-1.2.jar ⎼로깅 구현의 다양한 클래스로 라이브러리 정보를 기록한다 API . ⎼log 인스턴스를 가져와서 쓰는 창구 역할로 실제 구현체는 의 나 그리고 기타 java logging API log4j 로거 모듈을 가져다 사용한다. ⎼ 은 로깅 요청을 기존에 존재하는 다양한 에 전 Common Logging(JCL) logging API implementations 달하는 역할을 한다. ⎼ 을 사용할 경우에 로깅 요청이 왔을 때 해당 라이브러리를 이용해서 를 출력할 수 있게 해 주 JCL log 며 전달받는 구현체를 바꿀 수 있어서 어떠한 를 사용하던 logging API logging API implementations 지에 상관없이 동일한 방법을 개발을 할 수 있다. 
- logging 사용하면 sys처럼 실행에 영향주지 않고 결과 확인 가능


# 2-1. DataSource 인터페이스의 기능 
- connection 풀을 DataSource 안에 담어두기 때문에 close 사용 필요
- ⎼커넥션 풀은 DataSource 인터페이스를 사용하여 구현할 수 있으며 DataSource 인터페이스는 데이터베이스에 대한 연결을 제공하는 서비스로 다양한 방식의 데이터베이스 연결을 제공하고 이에 대한 추상화 계층을 제공함으로써 업무 로직과 데이터베이스 연결 방식 간의 종속성을 배제한다.
- DataSource 인터페이스는 close 메서드로 커넥션을 풀로 복귀시킨다.  close 메서드로 반드시 자원을 해제해야 한다.




1. ① 기본 구현체 ⎼표준 커넥션 인스턴스를 생산한다. 
2. ② 커넥션 풀링 구현체 ⎼자동으로 커넥션 풀에 참여하는 커넥션 인스턴스를 생산하며 이 구현체는 커넥션 풀링 매니저와 함께 작업한다. 
3. ③ 분산 트랜잭션 구현체 ⎼분산 트랜잭션을 위한 커넥션 풀에 참여하는 커넥션 인스턴스를 생산하며 이 구현체는 트랜잭션 매니 저와 커넥션 풀링 매니저와 함께 작업하고 패키지의 javax.sql DataSource 인터페이스를 구현한다. 
- ⎼커넥션 풀을 사용시 주의할 점은 작업이 완료되었으면 기존처럼 Connection 인터페이스 인스턴스의 close 메서드를 사용하여 자원을 반납하지 않고 Connection 인터페이스 인스턴스를 저장소에 복귀시켜야 하는 것은 지금껏 사용했 던 커넥션이며 커넥션 풀링용 커넥션인 DataSource 인터페이스는 close 메서드로 커넥션을 풀로 복귀시킨다. 
- ⎼DataSource 인터페이스는 close 메서드로 반드시 자원을 해제해야 한다.


# 대용량
## StringBuffer
- 대용량 데이터 담을 때는 반드시 StringBuffer로 담아야 한다;(# clob 데이터형); TCP 역할


## StringBuilder
- UDP 역할; 데이터 손실이 있음


# 데이터 연동
- 트랜젝션 처리(커밋, 롤백)


# DAO; Data Access Object
- 데이터 접근하는 동적 객체

# DTO
- get, set, toString 등 VO와 달리 여러 기능.
- VO와 비교를 하여 보면 DTO는 같은 시스템에서 사용되는 것이 아닌 다른 시스템으로 전달하는 작업을 처리하는 객체이다.
-       Layer간의 통신 용도로 오가는 객체를 말하기도 한다.
-       현재의 개발 환경에서 보통 데이터는 다음과 같이 흐름으로 이동한다.
n   서버 측 : Database Column Data -> DTO -> API(JSON or XML) -> Client
n   클라이언트 측 : Server -> API(JSON or XML) -> DTO -> View or Local Database System

# VO; Value Object
- getter, settter만 사용
- ⎼데이터 그 자체로 의미 있는 것을 담고 있는 객체이며 DTO Read Only .
- ⎼간단한 독립체(Entity) . 를 의미하는 작은 객체를 의미하며 관계데이터베이스의 레코드에 대응되는 자바클래스이다
- ⎼형태는 데이터베이스 레코드를 구성하는 필드들을 VO Attribute Getter 의 로 하고 해당 변수에 접근 할 수 있는 와 Setter .
- ⎼거의 불변성을 가지고 equals .s 로 비교할 때 객체의 모든 값을 비교해야 한다 ⎼VO DTO 는 사용 되는 값이 객체로 표현 되며 값 변경이 없는 경우를 말하고 는 데이터의 전송을 위한 객체이며 비즈니스 로직까지 담아서 사용하기 한다
- Value Object는 관계데이터베이스의 레코드에 대응되는 자바클래스입니다. 형태는 db레코드를 구성하는 필드들을 Value Object의 Attribute로 하고 해당 변수에 접근 할 수 있는 Getter Setter 메소드의 조합으로 클래스를 형성되어진 클래스입니다. 특성은 대체로 불변성이고 equals()로 비교할 때 객체의 모든 값을 비교해야 합니다.



## VO의 장점
- 필요성: Network traffic을 줄임으로 인해서 효과적입니다.
- 기대효과: Network traffic이 줄어듭니다.
- 장점으로는 비 서버 측 클라이언트도 네트워크 오버헤드 없이 영속성 데이터에 액세스 할 수 있다는 점입니다. 데이터 전달을 위해 가장 효율적인 방법이지만, 클래스의 선언을 위해 많은 코드가 필요합니다. 즉 파일수가 많아지게 되고 관리도 힘들어지게 됩니다.



# DTO와 VO의 차이
- 예를 들어 외부 시스템과 데이터 통신을 할 경우에는 DTO로, DB에서 가져오는 Data는 VO로 정의해서 사용한다고 약속을 하면, 향후 DTO/VO를 수정할 경우 좀 더 고민할 여지가 생길것 같다.
- vo는 특정한 비즈니스 값을 담는 객체를 vo라 하고 dto는 레이어간의 통신용도로 오가는 객체를 dto라고 합니다.
- . DTO는 메소드 호출 횟수를 줄이기 위해 데이터를 담고 있는 녀석으로, VO는 값이 같으면 동일 오브젝트라고 볼 수 있는 녀석으로 표현을 하고 있습니다.
- VO는 DB부터 View까지 양방향적으로 사용되는데 반해, DTO는 뷰에서 컨트롤러 방향으로 일방향 적으로 사용된다.
 
 
 

# 자바빈
- ⎼일반적으로 데이터를 효율적으로 관리하기 위해서는 자바빈 클래스와 컬렉션 API . 를 함께 사용하게 된다 
- ⎼자바빈 클래스는 일반적으로 DTO(Data Transfer Object) DTO 클래스라고 불리기도 하며 클래스는 데이터를 효율적으로 전송 및 관리하기 위해서 사용되는 클래스를 의미한다. 
- ⎼DTO 클래스는 넓게는 네트워크 환경에서 좁게는 메서드 간에 데이터를 전송할 때 유용하게 사용되는 클래스이며 DTO DTO . 클래스를 사용하는 패턴을 패턴이라고 한다 
- ⎼네트워크 및 메서드 간의 데이터 전송시 여러 번 데이터를 나누어 전송 하는 것 보다는 한꺼번에 전송하는 것이 효율적이므로 한꺼번에 저장 및 전송하기 위한 방법으로 자바빈즈 클래스와 컬렉션 API . 를 같이 사용하게 된다


# MVC 패턴 웹
- - 웹 브라우저; http 프로토콜 <->   서블릿(경로 통해서 매개변수 전달)<->   자바 -   모델(DAO, VO, DTO) <-> 오라클
- 뷰(웹브라우저의 입력창, 출력창),  컨트롤러(서블릿(경로 통해서 매개변수 전달); 프론트 컨트롤러
- 웹 브라우저의 뷰에서 모델 쪽을 안건든다.
- - 객체를 통한 재생산성을 사용할 때 함수(복제기능) 보다는 클래스(재생산성)를 사용한다.


# MVC 패턴 2
- MVC + 프론트

# html

# CSS
- 자바 스크립트의 라이브러리 이용
- JQuery

## 스크립트
- 인터프리터 형식
- 클라이언트: 자바 스크립트
- 서버: ASP, PHP, JSP

# 웹 서버
- 리눅스: 아파치
- 윈도우: IIS(인터넷 서비스 관리자)
- 엔터프라이즈 서버

1. 메일: SMTP    
2. 파일전송: FTP     
3. 애플리케이션 -> 스크립트 언어 -> DB 연동
4. 디렉토리 관리 -> 가상 디렉토리
5. 예외처리 기능
6. 포트 및 시작 페이지 조정


# WAS
- 웹 서버 중 3개의 기능만 가지고 있음.
- 예시: 톰켓

## WAS 기능
- 분산 트랜잭션, 보안, 메시징, 쓰레드 처리 등의 기능을 처리하는 분산 환경에서 사용된다.
- 주로 DB 서버와 같이 수행된다



## WAS 기능
- 여러개의 WAS 만들어서 한 개의 웹서버에 연동할 수 있음.
1. 애플리케이션 -> 스크립트 언어 -> DB 연동
2. 예외처리 기능
3. 포트 및 시작 페이지 조정


## IIS에서의 WAS
- World Wide Web 서비스

## 톰켓
- 아파치에서 제공한 톰켓; 웹서버가 아닌 WAS임
- http://tomcat.apache.org/


### 윈도우 10 기본 WAS (80 포트 사용)
- 프로그램 추가 - 인터넷 정보 서비스(IIS) 체크 해제
