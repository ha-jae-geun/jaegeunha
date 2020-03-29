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
