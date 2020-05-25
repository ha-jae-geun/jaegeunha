

#SQL GATE

# MYSQL
* Open Source 형태로 개발된 데이터 베이스
* MySQL AB에서 개발 -> SUN(자바) -> Oracle
  * Oracle 정책에 대한 반발로 나와서 MariaDB 탄생
  * MariaDB는 MySQL과 완벽한 호환

# 데이터 베이스
- 한 조직의 여러 응용 시스템들이 공동으로 사용하기 ( ) 공유하기 위해 통합하고 저장한 데이터들로써 중복을 최소화하 여 컴퓨터 기억 장치에 모아 놓은 집합체이다.
- DBMS(사용자와 데이터 베이스를 연결시켜 주는 소프트 웨어) + 데이터베이스(데이터를 모아둔 토대) + 데이터 모델(데이터가 저장되는 기법에 관련된 내용ㅇ


# Relation은 데이터를 원자 값으로 갖는 이차원의 테이블
* Column = Attribute
* Row = Tuple
* 하나의 Attribute가 취할 수 있는 같은 타입의 원자 값들의 집합을 도메인이라 함

# 데이터
- 웹에서 연동되는 데이터는 int형이 없기 때문에 무조건 더블쿼터(제이슨)


## 데이터 정의서
 * 웹 페이지 내용		자바타입	DB타입		내용 및 기술
 * 이름(name, 12)		String		varchar(12)	필수정보, 아이디 확인
 * 아이디
 * 비밀번호						특수문자 포함

# 데이터 확인법
1. 로그 기록 2 .데이터베이스 3. 크롤링


# 데이터 베이스 계정
- create 계정 -> grant 권한 -> 접속 -> 



# 데이터베이스 테스트
- 서블릿
 * Connection connection = null;
 * 		try {
 * 			Context context = new InitialContext();
 * 			BasicDataSource basicdataSource = (BasicDataSource) context.lookup("java:comp/env/jdbc/db");
 * 			try {
 * 				connection = basicdataSource.getConnection();
 * 				System.out.println(connection);
 * 			} catch (SQLException e) {
 * 				// TODO Auto-generated catch block
 * 				e.printStackTrace();
 * 			}
 * 		} catch (NamingException e) {
 * 			// TODO Auto-generated catch block
 * 			e.printStackTrace();
 * 		}
 * 

# 대용량
## StringBuffer
- 대용량 데이터 담을 때는 반드시 StringBuffer로 담아야 한다;(# clob 데이터형); TCP 역할

## StringBuilder
- UDP 역할; 데이터 손실이 있음


# 스키마; 서류; 규격화 되어있는 형식

## (1) 외부 스키마 외부 단계 (external schema, ) 
- 사용자의 관점에 따라 여러 개의 부분집합으로 나누어지는 것을 말하며 의 개념이다 view . 
- 일반 사용자나 응용 프로그래머가 접근하는 계층으로 전체 데이터베이스 중에서 하나의 논리적인 부분을 의미한다. 
- 사용자가 직접 접근할 수 있는 바깥쪽의 스키마를 말하며 데이터베이스 프로그래머가 작성해야 할 일차적인 내용이다. 
- 온라인상에서 바라보면 회원등록의 폼 자료실의 형태와 내용 등을 말한다고 할 수 있다 , . 


## (2) 개념 스키마 개념 단계 (conceptual schema, ); 인간이 알 수 있는 단어로 적는 것
- 논리적인 데이터베이스 전체의 구조를 말하며 전체 데이터베이스의 정의를 의미한다. 
- 통합 조직별로 하나만 존재하며 가 관리를 한다 DBA . 
- 개념 스키마 는 저장장치에 독립적으로 기술되며 데이터와 관계 제약사항 무결성에 대한 (conceptual schema) , , 내용이 포함된다. 
- 데이터베이스 파일에 저장되어 있는 데이터의 형태를 나타낸다. 




## (3) 내부 스키마 내부 단계 (internal schema, ) 
- 물리적인 데이터의 구조를 말하며 기억장치 내에 데이터가 저장되어 있는 데이터의 물리적인 설계도이다. 
- 물리적 저장 장치에 데이터베이스가 실제로 저장되는 방법의 표현이다. 
- 내부 스키마 는 하나며 인덱스 데이터 레코드의 배치 방법 데이터 압축 등에 관한 사항이 포함된다 (intenal schema) , , . 

# 데이터베이스별 차이
1. 자료형
- 오라클; 4GB CLOB형, float형 존재
- SQLite; float형이 아니고 real형, date형이 아니라 text형 사용


# 데이터 모델링
- 요구사항 수집 및 분석 - 설계(개논물) - 데이터베이스 구현

1. 테이블 정의서
- 항목 명칭, 항목 ID, 자료형, 길이, NULL, PK, FK, 비고

## 형태
- 컬럼명, 데이터타입, 길이, 널, 기본키, 비고

2. ERD
 * ## eXERD 프로그램

# (6) 포워드 엔지니어링(Forward Engineering)  
- ⎼준비된 E-R DBMS DDL . 모델을 에 을 이용하여 생성하는 기능이다 


# (7) 리버스 엔지니어링(Reverse Engineering)
- ⎼DBMS E-R . 의 객체들을 모델로 가져오는 기능이다 
 * (1) 비식별 관계 
 * 외래키들을 기본키로 사용하지않고 일반 속성으로 취급하는 관계를 비식별관계라고 표현한다. 눈매가 예리한 사람들은 느꼈겠지만 ERD에서 비식별 관계는 관계를 점선으로 표시한다. 기본키 포스팅에서도 말했지만 추후 비즈니스 모델 변경에도 영향을 최소화하기위해 이런 관계 테이블에도 식별 관계보다는 인조키를 이용한 비식별 관계를 권장한다.

## 비 식별  종류
① 비식별 종속관계 (Non-Identifying Mandatory Relationship) 
- ⎼부모의 주 식별자는 자신의 non-key . 영역으로 이주하고 자신을 식별하는 데 관계하지 않는다 ⎼자식은 자신의 각 인스턴스의 식별을 위해 부모 엔티티에 독립적이고, . 부모 없이 존재할 수 없다 
- ② 비식별 비종속관계(Non-Identifying Non-Mandatory Relationship) ⎼부모의 주 식별자는 자신의 non-key , . 영역으로 이주하고 자신을 식별하는 데 관계하지 않는다 ⎼자식은 자신의 각 인스턴스의 식별을 위해 부모 엔티티에 독립적이고 부모 없이 존재할 수도 있다.



## JDBC
- ① JDBC-ODBC 브리지 타입 ⎼JDBC ODBC ODBC . 에 들어온 모든 명령을 형으로 변환해 드라이버로 전달한다 
- ② Native-API/Partly Java 타입 ⎼JDBC DBMS . 에 들어온 데이터베이스 명령을 시스템 호출에 맞춰서 변환한 후 그 명령을 전달한다 
- ③ 명령어 변환 타입 ⎼JDBC에 들어온 모든 명령을 데이터베이스 접근 미들웨어로 전송하고 이를 데이터베이스에 적합한 명령어로 변환한다. 
- ④ 직접 전송 타입 ⎼자바로 구현된 JDBC . 

## 드라이버
- 오라클에서는 라이브러리를 ‘드라이버’라고 표현






# 이클립스
## 프로젝트 생성
- static project: 자바와 연동 안하겠다.
- dynamic project: 자바와 연동

## META-INF
- DB관련 xml이 들어감

## WEB-INF
- 라이브러리 용;
- html, jsp 등의 파일은 실행하지 못한다; 404 오류 유발
