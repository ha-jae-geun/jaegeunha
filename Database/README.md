# 데이터 베이스
- 한 조직의 여러 응용 시스템들이 공동으로 사용하기 ( ) 공유하기 위해 통합하고 저장한 데이터들로써 중복을 최소화하 여 컴퓨터 기억 장치에 모아 놓은 집합체이다.
- DBMS(사용자와 데이터 베이스를 연결시켜 주는 소프트 웨어) + 데이터베이스(데이터를 모아둔 토대) + 데이터 모델(데이터가 저장되는 기법에 관련된 내용ㅇ

# 정규화
* [정규화](https://3months.tistory.com/193 [Deep Play]```)
1. 불필요한 데이터(data redundancy)를 제거한다.
2. 데이터 저장을 "논리적으로" 한다.
```java
1차 정규형
1차 정규형은 각 로우마다 컬럼의 값이 1개씩만 있어야 합니다. 이를 컬럼이 원자값(Atomic Value)를 갖는다고 합니다. 
예를 들어, 아래와 같은 경우 Adam의 Subject가 Biology와 Maths 두 개 이기 때문에 1차 정규형을 만족하지 못합니다.

2정규형
2차 정규화부터가 본격적인 정규화의 시작이라고 볼 수 있습니다. 2차 정규형은 테이블의 모든 컬럼이 완전 함수적 종속을 만족하는 것입니다. 
이게 무슨 말이냐면 기본키중에 특정 컬럼에만 종속된 컬럼(부분적 종속)이 없어야 한다는 것입니다. 
위 테이블의 경우 기본키는 (Student, Subject) 두 개로 볼 수 있습니다. 이 두 개가 합쳐져야 한 로우를 구분할 수가 있습니다. 
근데 Age의 경우 이 기본키중에 Student에만 종속되어 있습니다. 즉, Student 컬럼의 값을 알면 Age의 값을 알 수 있습니다. 
따라서 Age가 두 번 들어가는 것은 불필요한 것으로 볼 수 있습니


3차 정규형
이와 같은 데이터 구성을 생각해봅시다. Student_id가 기본키이고, 기본키가 하나이므로 2차 정규형은 만족하는 것으로 볼 수 있습니다. 
하지만 이 데이터의 Zip컬럼을 알면 Street, City, State를 결정할 수 있습니다. 
또한 여러명의 학생들이 같은 Zip코드를 갖는 경우에 Zip코드만 알면 Street, City, State가 결정되기 때문이 
이 컬럼들에는 중복된 데이터가 생길 가능성이 있습니다. 
정리하면 3차 정규형은 기본키를 제외한 속성들 간의 이행적 함수 종속이 없는 것 입니다. 
풀어서 말하자면, 기본키 이외의 다른 컬럼이 그외 다른 컬럼을 결정할 수 없는 것입니다.


4차 정규형
BCNF는 (Boyce and Codd Normal Form) 3차 정규형을 조금 더 강화한 버전으로 볼 수 있습니다. 
이는 3차 정규형으로 해결할 수 없는 이상현상을 해결할 수 있습니다. BCNF란 3차정규형을 만족하면서 
모든 결정자가 후보키 집합에 속한 정규형입니다. 아래와 같은 경우를 생각해보면, 
후보키는 수퍼키중에서 최소성을 만족하는 건데, 이 경우 (학생, 과목) 입니다. (학생, 과목)은 그 로우를 유일하게 구분할 수 있습니다. 
근데 이 테이블의 경우 교수가 결정자 입니다. (교수가 한 과목만 강의할 수 있다고 가정) 즉, 교수가 정해지면 과목이 결정됩니다. 
근데 교수는 후보키가 아닙니다. 따라서 이 경우에 BCNF를 만족하지 못한다고 합니다. 
3차 정규형을 만족하면서 BCNF는 만족하지 않는 경우는 언제일까요? 바로 일반 컬럼이 후보키를 결정하는 경우입니다.


```

## 이상
* 삽입 이상 (Insertion Anomaly): 테이블에 데이터를 삽입할 때 의도와는 상관없이 원하지 않은 값들로 인해 삽입할 수 없게 되는 현상
* 삭제 이상 (Deletion Anomaly): 테이블에서 한 튜플을 삭제할 때 의도와는 상관없는 값들도 함께 삭제되는, 즉 연쇄 삭제가 발생하는 현상
* 갱신 이상 (Update Anomaly): 테이블에서 튜플에 있는 속성 값을 갱신 시 일부 튜플의 정보만 갱신되어 정보에 불일치성(Incosistency)이 생기는 현상

## 함수적 종속
* 속성 X의 값 각각에 대해 시간에 관계없이 항상 속성 Y의 값이 오직 하나만 연관되어 있을 때
* Y는 X에 함수적 종속 또는 X가 Y를 함수적으로 결정한다고 하고,
* X -> Y로 표기한다.
* X -> Y의 관계를 갖는 속성 X와 Y에서 X를 결정자(Determinant)라 하고, Y를 종속자(Dependent)라고 한다.

```JAVA
완전 함수적 종속이라는 말은 어떤 속성이 기본키에 대해 완전히 종속적 일 때를 말한다.
부분 함수적 종속이라는 말은 기본키가 2개 이상 구성된 합성키이고,
합성키를 구성하는 하나의 속성에 함수적 종속성을 갖을 때 부분 함수적 종속이라 한다.
```

## Integrity
* Integrity란 데이터베이스에 저장된 값과 실제 값이 일치하는 정확성을 의미

1. NULL 무결성
* 릴레이션의 특정 속성 값이 NULL이 될 수 없도록 하는 규정

2. 고유(Unique) 무결성
* 릴레이션의 특정 속성에 대해 각 튜플이 갖는 속성 값들이 서로 달라야 한다는 규정

3. 도메인(Domain) 무결성
* 특정 속성의 값이 그 속성이 정의된 도메인에 속한 값이어야 한다는 규정

4. 키(Key) 무결성
* 하나의 릴레이션에는 적어도 하나의 키가 존재해야 한다는 규정

5. 관계(Relationship) 무결성
* 릴레이션에 어느 한 튜플의 삽입 가능 여부 or 한 릴레이션과 다른 릴레이션의 튜플들 사이의 관계에 대한 적절성 여부를 지정한 규정

6. 참조(Referential) 무결성
* 외래키 값은 NULL or 참조 릴레이션의 기본키 값과 동일해야 한다는 규정

7. 개체(Entity) 무결성
* 기본 릴레이션의 기본키를 구성하는 어떤 속성도 NULL 일 수 없다는 규정


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

# 오라클
- MySQL과 달리 오라클은 대용량 데이터 베이스라고 하는데, 대용량 데이터 타입(CLOB; 4GB까지 가능) 까지 가질 수 있다.
- 오라클 # 버전; 11g 사용; 12g는 명령어 다 바뀜
- SQL Developer도 같이 설치
- 10g: 한글 코드 2바이트로 인식; 11g: 한글 코드 3바이트로 인식
- 12g: 비정형 데이터 연동 원활하게 함
- 데이터베이스 11g 엔터프라이즈 / 표준 에디션: 오라클 관리자
- 데이터베이스 11g Express Edition: 개발자용; exe 파일로 쉽게 지우기 가능.; 개발자용

## 오라클 버전
### 오라클의 한글 및 기타 언어 지원( ) 영문 제외 
- ① 10g 버전 이하 ⎼영문: 1바이트 ⎼영문 이외의 한글 등: 2바이트 
- ② 11g 버전 이상 ⎼영문: 1바이트 ⎼영문 이외의 한글 등: 3바이트 

## 오라클 명령어
- dba로 접속: 1. sqlplus 2. sys as sysdba | 1234  3. quit / exit(윈도우 빠지기)
- as: 1. 충돌 방지 2. 

### 오라클 유저
- 1. 데이터 베이스 추가 2. 이름: sys 3. 롤: SYSDBA 4. 로컬 이름: 127.0.0.1
- 유저 검색
- select username from all_users;
- 연습 계정: scott 추가: 1. app\product\18.0.0\dbhome\rdbms\admin\scott.sql 실행
- 유저 계정 변경
	- alter user scott account unlock; // 락 풀기
	- alter user scott identified by tiger; // tiger로 변경
	- conn scott/tiger // 접속
	- 벗어날 때: exit

## 포트 충돌
- 가. 포트 번호 확인(listener.ora) - - - 
- ⎼D:\app\s\product\11.2.0\dbhome_1\NETWORK\ADMIN ⎼(ADDRESS = (PROTOCOL = TCP)(HOST = SONG-PC)(PORT = 1521))

## SI 변경; 전역자
- 나. SID (tnsnames.ora) 확인 
- ⎼D:\app\s\product\11.2.0\dbhome_1\NETWORK\ADMIN ⎼(SERVICE_NAME = orcl)

### 오라클 서비스
- OracleServiceXE: 오라클과 직접 연동; 메모리 많이 안잡음
- Protocol Adapter Error 유발
- OracleXETNSLISTENER; 디벨로퍼, 이클립스 연동; 메모리 많이 잡음
- ① OracleServiceORCL ⎼오라클 서버의 인스턴스로서 반드시 필요한 서비스이다. 
- ② OracleOraDb11g_home1TNSListener ⎼오라클 리스너 서비스이며 원격지에서 오라클 서버에 접속하려면 반드시 필요한 서비스이다. 
- ③ OracleDBConsoleorcl ⎼오라클 서버를 웹 브라우저에서 관리할 수 있도록 해 주는 일종의 웹 어플리케이션이다. 

## 대소문자
- 값, 계정은 대소문자 구분, 명령어는 구분하지 않는다.
- - ⎼문자 리터럴의 경우에는 대소문자를 구별하며 검색시 대문자로 입력한 내용을 소문자로 검색하면 검색이 되지 않는다. ⎼오라클 데이터베이스는 세기, , , , , , 년 월 일 시 분 초를 나타내는 내부 숫자 형식으로 날짜를 저장하며 기본 날짜 표시 형식은 DD-MON-RR . 
- select empno, ename from emp where ename = 'FORD';

### lower로 대문자 검색하기
- select * from emp
- where lower(ename) = 'ford';

### 첫 문자만 대문자 나머지는 소문자로 출력 예제
- select initcap(dname) from dept;


## 관계형 데이터 베이스
- 관계형 데이터베이스 시스템(Relational DataBase Management System : RDBMS) DBMS 은 다양한 중에서 가장 알려진 소프트웨어이다. 
- 관계형 데이터베이스는 관계형 모델을 구성하고 다음과 같은 요소를 가진다. 
- ① 데이터를 저장하는 객체 또는 관계 모음 ② 관계에서 다른 관계를 생성하는 데 사용할 수 있는 연산자 집합 
- ③ 정확성 및 일관성을 보장하는 데이터 무결성 ⎼관계형 데이터베이스는 관계 또는 2 . 차원 테이블을 사용하여 정보를 저장한다 

# DBMS
## 비정규화
- 정규화로 인해 여러 개로 분해된 릴레이션들에서 원하는 정보를 얻기 위해서는 조인을
사용하여 다시 연결해야 하는데, 지나치게 자주 조인을 사용하면 응답 속도가 떨어지므로 정규화에 위배되지만 성능 향상을 위해 다시 테이블을 합쳐야 한다. 이것을 비정규화라고 한다.



1. 일반 사용자 
* -> 질의어 -> 질의어 처리기 -> 런타임 데이터베이스 처리기(<>트랜잭션 관리자) -> 저장 데이터 관리자 <> 데이터 사전, 데이터 베이스

2. 응용 프로그래머
* 응용 프로그램/DML ->> DML 컴파일러 -> 런타임 데이터베이스 처리기(<>트랜잭션 관리자) -> 저장 데이터 관리자 <> 데이터 사전, 데이터 베이스

3. 데이터베이스 관리자
* 스키마/DDL -> DDL 컴파일러/DDL 처리기, DDL 번역기 -> 저장 데이터 관리자 <> 데이터 사전, 데이터 베이스
* 런타임 데이터베이스 처리기 생략


# 회복
 * 회복(Recovery)은 트랜잭션들을 실행하는 도중 장애(Failure)가 발생하여 데이터베이스가 손상되었을 경우 손상되기 이전의 정상 상태로 복구하는 작업이다.

## 회복 장애
 *  * ᆞ실행 장애(Action Failure) : 사용자의 실수, 무결성 규정 위반 등으로 질의 실행이 실패하는 현상
 *  * ᆞ트랜잭션 장애(Transaction Failure) : 트랜잭션 내부에서 입력 데이터 오류, 불명확한 데이터, 시스템 자원
 *  * 요구의 과다 등 비정상적인 상황으로 인하여 트랜잭션 실행이 중지되는 현상
 * ᆞ( 1 ) 장애(System Failure) : 데이터베이스에는 손상을 입히지 않으나 하드웨어 오동작, 정전, 소프트웨어(운영체제나 DBMS 등) 오류, 교착 상태 등에 의해 실행중인 모든 트랜잭션들이 더 이상 실행을 계속할 수 없는 현상; 시스템 장애
 * ᆞ미디어 장애(Media Failure) : 저장 장치인 디스크 블록의 손상이나 디스크 헤드의 충돌 등에 의해 데이터 베이스의 일부 또는 전부가 물리적으로 손상되는 현상
 * 
 * 회복 관리기는 로그(Log), 메모리 ( 2 ) 등을 이용하여 회복 기능을 수행하는 DBMS의 핵심 구성 요소이다. 회복 관리기는 트랜잭션 실행이 성공적으로 완료되지 못하면 로그를 이용하여 트랜잭션이 데이터베이스에 생성했던 모든 변화를 취소(Undo)시켜서, 트랜잭션 실행 이전의 원래 상태로 되돌리는 역할을 담당한다. 덤프


## 회복기법의 종류
 * ᆞ연기 갱신(Deferred Update) 기법 : 연기 갱신 기법은 트랜잭션이 성공적으로 종료될 때까지 데이터베이스에 대한 실질적인 갱신을 연기하는 기법이다.
 * ᆞ즉각 갱신(Immediate Update) 기법 : 즉각 갱신 기법은 트랜잭션이 데이터를 변경하면 트랜잭션이 부분 완료되기 전이라도 즉시 실제 데이터베이스에 반영하는 기법이다.
 * ᆞ그림자 페이지(Shadow Paging) 기법 : 그림자 페이지 기법은 갱신 이전의 데이터베이스를 일정 크기의 페이지 단위로 구성하여 각 페이지마다 복사본인 그림자 페이지로 별도 보관해 두고, 실제 페이지를 대상으로 트랜잭션에 대한 변경 작업을 수행하는 기법이다.
 * ᆞ( 3 ) 기법 : 시스템 장애가 발생하였을 경우, Redo와 Undo를 수행하기 위해 로그 전체를 조사해야 하는 경우를 피하기 위한 기법이다. 검사점


### RDBMS
- ① 오라클(Oracle) 
- ② MS-SQL 
- ③ MySQL 
- ④ 사이베이스(Sybase) 
- ⑤ 인포믹스(Infomix) 
- ⑥ DB2 ⎼RDBMS는 정형화된 데이터 항목들의 집합체로서 확장이 용이하다는 장점을 가지는데 처음 데이터베이스를 만든 후 관련되는 응용 프로그램들을 변경하지 않고도 새로운 데이터 항목을 데이터베이스에 추가할 수 있다. 
- RDBMS 2 (column) (record) 는 차원 테이블 구조로 데이터를 관리하며 열을 컬럼 이라고 하고 행을 레코드 라고 한다. ⎼데이터의 중복 및 무결성을 보장하기 위해서 다양한 제약조건을 지정할 수 있다.
- SQLite: 파이썬도 지원

# SQL; Structured Query Language
- 언어라기보다는 수학적 기호를 언어로 표시한 것.

## 날짜
- where hiredate > '1982-01-01';  '1981/01/01' ;  둘다 가능


## SQL 전용 언어
- T-SQL: 마이바티스로 대체
- PL/SQL

## SQL 문의 특징
- ⎼SQL . 문은 대소문자를 구분하지 않으나 대문자 사용을 권장한다. 리터럴은 대소문자를 구분한다. 
- ⎼SQL . 문은 한 줄 또는 여러 줄에 입력할 수 있다. 한 줄 입력은 금지, 여러줄 권장;
- select * from table where; // 권장하지 않는다.
- ⎼키워드는 약어로 표기하거나 여러 줄에 걸쳐 입력할 수 없다. 
- ⎼키워드는 일반적으로 대문자로 입력하지만 테이블 이름 및 열 이름 등의 다른 단어는 모두 소문자로 입력한다; 다른 언어와 연동해서 쓰이기 때문에 모든 언어는 대문자를 권장한다.
- ⎼절은 대개 별도의 줄에 입력한다.
-  ⎼가독성을 높이기 위해 들여쓰기를 사용한다. 
- ⎼SQL Developer SQL (;) SQL 에서 문은 선택적으로 세미콜론 으로 끝날 수 있으며 세미콜론은 여러 문을 실행하는 경우에 필요하고 SQLplus SQL (;) .

# SQL문의 종류
- ① DQL(Data Query Language, ) 
- 질의어 ⎼select 문은 데이터를 검색한다. 
- ② DML(Data Manipulation Language, ) 조작어 
- ⎼insert 문은 데이터를 입력한다. 
- ⎼update 문은 데이터를 수정한다. 
- ⎼delete 문은 데이터를 삭제한다. 
- ③ DDL(Data Definition Language, ) 정의어 
- ⎼create 문은 객체를 생성한다. 
- ⎼alter 문은 객체를 수정한다. 
- ⎼drop 문은 객체를 삭제한다.
-  ⎼rename 문은 객체이름을 변경한다. 
- ⎼truncate 문은 객체저장 공간을 삭제한다. 
- ④ TCL(Transaction Control Language, ) 처리어 
- ⎼commit 명령어는 트랜잭션을 저장한다. // 메모장 같은거 저장할 때 ‘저장’ 이라는 말이 나오는 것; 물리적으로 데이터를 저장 시키는 것.
- ⎼rollback 명령어는 트랜잭션을 취소한다. 
- ⎼savepoint 명령어는 트랜잭션내의 책갈피 기능을 한다. 
- ⑤ DCL(Data Control Language, ) 제어어 ⎼
- grant 명령어는 권한을 부여한다. 
- ⎼revoke 명령어는 권한을 취소한다.

## 리터럴
- ⎼문자데이터와 날짜데이터의 리터럴에는 반드시 단일 따옴표(‘) . 를 사용하여 표현한다 
- ⎼SQL . 문의 자체는 대소문자를 구별하지 않지만 리터럴은 대소문자를 구별한다


## SQL null 의 값 
- ⎼데이터베이스에서 null . 은 매우 중요한 데이터이다 
- ⎼우선 오라클에서의 null 은 다음과 같이 데이터 검색시 컬럼의 값이 비어있는 형태로 보여 진다. 
- ⎼오라클은 컬럼에 기본적으로 null null . 값을 허용하며 제약조건을 이용해서 값을 허용하지 않을 수도 있다 
- ⎼주의할 점은 null null .


## 오류 메세지
- ① ORA-00001: . 무결성제약 조건에 위배됩니다 ⎼테이블에 기본키를 지정해두었지만 그 기본키 값과 중복되는 내용을 집어넣으려 했을 때 발생하는 오류로 중복된 값이 있는 확인한다. 
- ② ORA-00054: 자원이 사용중이고 NOWAIT가 지정되어 있습니다. ⎼테이블에 데이터가 사용중이라는 뜻으로 락이 걸려서 발생하는 오류로 오라클 시스템 계정으로 접속해서 사용 중인 정보의 세션을 중지 시킨다. 
- ③ ORA-00900: SQL . 문이 부적합합니다 ⎼SQL SQL . 문이 잘못 쓰였을 때 발생하는 오류로 잘못된 문을 수정한다 
- ④ ORA-00905: 누락된 키워드 ⎼SQL . 문에서 키워드가 누락되어 있을 경우에 발생하는 오류로 누락된 키워드를 삽입한다 
- ⑤ ORA-00917: 누락된 콤마 ⎼SQL . 문에서 콤마가 누락되어 있을 경우에 발생하는 오류로 누락된 콤마를 삽입한다 
- ⑥ ORA-00919: . 함수가 부적합합니다 ⎼SQL 문에서 오라클의 함수가 잘못되어서 발생하는 오류가 아니라 콤마 대신에 점을 사용할 경우에 발생하는 오류로 오타 부분을 확인한다. 
- ⑦ ORA-00920: 관계 연산자가 부적합합니다. ⎼SQL 문에서 관계 연산자를 사용할 때 사용할 절을 잘못 사용할 경우에 발생하는 오류로 관계 연산자 다음에 오는 절을 확인한다. 
- ⑧ ORA-00937: . 단일 그룹의 그룹 함수가 아닙니다 ⎼SQL 문에서 그룹 함수 다음에 오는 절을 잘못 사용할 경우에 발생하는 오류로 그룹 함수 다음에 오는 절을 확인한다. 
- ⑨ ORA-01400: NULL OOO . 을 에 입력할 수 없습니다 ⎼SQL 문에서 insert 문 혹은 update 문 할 때 나타나는 오류로써 not null 컬럼에 빈값을 넣으려 할 때 발생하는 오류로 컬럼의 조건을 확인한다. 
- ⑩ ORA-01405: NULL . 인출된 열의 값은 입니다 ⎼SQL . 문의 조인문에서 발생하는 오류로 조인문을 확인한다 
- ⑪ ORA-01422: . 실제 인출은 요구된 것보다 많은 수의 행을 추출합니다 ⎼SQL into 문에서 프로시저에서 를 썼을 때 들어가는 값이 두 개 이상인 경우에 발생하는 오류로 프로시저를 확인한다. 
- ⑫ ORA-01722: . 수치가 부적합합니다 ⎼SQL . 문의 컬럼 타입이 맞지 않을 때 발생하는 오류로 컬럼 타입을 확인한다; 자료형이 맞지 않는다.
- ⑬ ORA-01747: . 열명을 올바르게 지정해 주십시오 ⎼SQL . 문에서 컬럼명을 잘못 사용할 경우에 발생하는 오류로 컬럼명을 확인한다 
- ⑭ ORA-01481: . 숫자 형식 모델이 부적합합니다 ⎼SQL date date varchar2 문에서 날짜를 데이터타입으로 입력해서 불러오는 데이터가 데이터타입이 아니라 데이터타입으로 호출하면 발생하는 오류로 날짜 데이터타입을 확인한다. 
- ⑮ ORA-01843: . 지정한 월이 부적합합니다 ⎼SQL 문에서 to_date( ) 함수를 사용할 때 월에 들어가야 할 값이 이상한 값이 들어가 있을 때 발생하는 오류로 to_date( ) . 

## 데이터 타입
1. 스칼라; 원시 타입; 내장되어 있는 타입; Built in; 한번에 하나의 값만 보유할 수 있는 원자량
2. 사용자 정의 데이터 타입
- - MySQL과 달리 오라클은 대용량 데이터 베이스라고 하는데, 대용량 데이터 타입(CLOB; 4GB까지 가능) 까지 가질 수 있다.
- 오라클은 ANSI에서 제공하는 모든 데이터 타입을 지원한다.


## 공백
- char는 공백 포함; varchar는 공백 제외

## SQL 문
- 테이블 소유자 확인; select * from tab; 
- emp 테이블에서 중복을 제외한 job 값을 구한다. select distinct job from emp; 
- * 사용; select sal 12 연봉 from emp;

### |
- select empno || '-' || ename from emp; // 연결 연산자,  사이에 ‘’ 만 사용 가능

### as; 별칭;  select distinct job as 직종 from emp; // 한글 사이에 ‘ ‘ 사용하지 않는다.
- 별칭에 공백을 사용할 때는 “ “ 사이에 쓴다; select distinct job as "직 종" from emp;
- as는 1. 이름에 대한 충돌 방지
- select job 직급 from emp; // 생략 가능, 보안에 좋기 때문에


### =
- 같다라고 할 때 ‘=’을 사용
- a=b 와 b=a는 같을 수도 있고 같지 않을 수도 있다. 집합으로 봤을 때 

## 질의어
- 단일 질의어: 1개의 테이블
- 더블 질의어: 2개의 테이블 이상 통해서 질의(조인을 사용)

## CDATA
- XML에서의 비교연산 사용 ⎼CDATA xml <> & . 키워드는 문서 내 쿼리 안에 등의

## Select문
- select [distinct] { *, column|expression [alias] } ，… 
 - from 테이블명… where 조건식;


## create 문

## 복사 예제; 이러면 데이터도 다 복사 되서 의미 없음
 * - 복사: create table copy_dept
 * as 
 * select * from dept;

## 데이터 복사 안하고 복사하기
 * create table copy2_dept
 * as 
 * select * from dept
 * where 2=3;  // 거짓인 조건 주기


##  rownum 슈도 컬럼
- ⎼오라클 데이터베이스 이외 db rownum . 테이블의 을 처리할 수 있다 
- ⎼rownum (Pseudo) mysql limit . 은 오라클에 있는 슈도 컬럼이며 의 키워드와 같은 기능이다 
- ⎼쿼리의 결과에 차례대로 숫자 1 1 . 부터 시작해 씩 더해가며 순서 값을 만들어주는 컬럼이다 
- ⎼rownum은 where 절에 순서 값이 붙여지므로 where 절과 group by 절 그리고 order by 절에는 영향을 받지 않는다.
### 사용 할 때
- ⎼rownum . 은 다음 일 때 사용한다
-  ① update 사용시 다중 건이 나올 때 첫번째건만 갱신할 때 where 절에 사용한다. 
- ② delete 사용시 다중 건이 나올 때 첫번째건만 삭제할 때 where 절에 사용한다

### 예제
- select rownum, ename from(select * from emp order by empno) where rownum <=10; 

## 리터럴
- ⎼문자와 날짜 리터럴은 반드시 단일 따옴표(‘) . 를 사용하지만 숫자 상수는 단일 따옴표를 사용하지 않아도 된다 
- ⎼문자 리터럴의 경우에는 대소문자를 구별하며 검색시 대문자로 입력한 내용을 소문자로 검색하면 검색이 되지 않는다. ⎼오라클 데이터베이스는 세기, , , , , , 년 월 일 시 분 초를 나타내는 내부 숫자 형식으로 날짜를 저장하며 기본 날짜 표시 형식은 DD-MON-RR . 
- select empno, ename from emp where ename = 'FORD';

## between
- select column1, column2… from 테이블명… where column [not] between A and B;
- 이상과 이하일때만 사용; 초과 미만은 <> 사용

## in
- 여러 개의 값을 동시에 비교하여 일치하는 데이터를 얻을 때 사용한다.
- 지정된 값 집합에서 값을 테스트하려면 in 연산자를 사용한다.
- in 연산자를 사용하여 정의한 조건을 멤버 조건이라고도 한다.
- not 연산자를 사용하여 비교 범위를 제외한다.
- select column1, column2… from 테이블명… where column [not] in(열 리스트); 

## in 예제
- select empno, ename, job from emp
-  where job in ('MANAGER','SALESMAN', 'SALESOMAN');


## like
- ⎼정확하게 일치하는 경우가 아닌 그 위치에 어느 문자가 들어가도 좋다는 것을 나타내는 문자인 임의의 문자(와일드카 드) . 또는 문자열 을 포함한 데이터를 검색할 때 사용한다 
- like 연산자를 사용하여 유효한 검색 문자열 값의 대체 문자 검색을 수행한다. 
- ⎼like 연산자를 사용하여 문자 패턴이 일치하는 행을 선택할 수 있다. 
- ⎼not 연산자를 사용하여 비교 범위를 제외한다. ⎼문자 패턴을 일치시키는 작업을 대체 문자 검색이라고 한다. ⎼%( ) _( ) Escape 퍼센트 기호 및 언더스코어 기호는 임의 리터럴 문자 결합에서 사용할 수 있으며 식별자를 이용할 수 있다. 

## %
- ① %( ) 퍼센트 기호 ⎼없거나 여러 개의 문자를 대체하고 0 . 개 이상의 임의의 문자 시퀀
- ‘%N%’    N이 포함된 사람 다 뽑아라.


## _
- ② _( ) 언더스코어 기호 ⎼하나의 문자를 대체하고 임의의 단일 문자를 나타낸다. 
- %와 다른 것은 임의의 단일 문자만 나타내는 기호

## null
- ⎼is null 조건은 null null null .
- ① null . 값은 사용할 수 없는 값이다 
- ② null . 값은 할당되지 않은 값이다 
- ③ null . 값은 알 수 없는 값이다 
- ④ null . 값은 적용할 수 없는 값이다

## null 키워드
- select column1, column2… from 테이블명… where column is [not] null; 

## asc
## desc
- order by hiredate desc; 
- order by sal asc; 

## inst; 특정 이름만 검색
- 컬럼안의 내용만 검색하는 것; 컬럼이 ()안에 들어갈 수 없음.

### inst 예제
- select deptno, dname, loc from dept where instr(loc,'DALLAS')<1;  // loc 컬럼에 dallas 안들어가 있는 것; inst는 단어가 들어가 있으면 1을 출력

## trim
- 윈도우 특성상 값의 양쪽에

## replace
- 양쪽의 공백만 없앨 수 있는 trim 말고 가운데 공백 없애기 위해 replace 사용.
- select replace(loc, ‘ ‘, ‘’) from dept

## translate
- translate(column1|expression1, string1, string2) 함수는 인자인 컬럼이나 표현식에 특정 문자열을 대체하는 함수로 string1 string2 . 문자열을 문자열로 대체한다
- select translate(loc, ‘ ‘, ‘’) from dept
- TRANSLATE의 경우도 대체문자열이 지정되지 않으면 지정된 문자는 삭제되어 리턴됩니다. 이것 역시 대체문자가 null이라고 생각하시면 될것 같습니다. 

### replace와 translate 차이
- REPLACE와 TRANSLATE의 차이점은 문자열 단위, 문자단위의 차이이다.
- SELECT TRANSLATE('a1a2a3a4a5','a','A') FROM DUAL;
- ->결과 : A1A2A3A4A5
- SELECT REPLACE('a1b2c4','a1','BB') FROM DUAL;
- -> 결과는 a1을 BB로 대체해 'BBb2c4'가 나온다

# 함수
## 함수 종속
- 함수 종속(functional dependency)이란 데이터베이스의 릴레이션(relation)에서 두 개의 애트리뷰트(attribute) 집합 간 제약의 일종이다.
- A이면 B이고 동시에 A이면 C일 수 없지만, B이면 반드시 A인 것은 아니다. 재미있는 말로하자면, A는 B라는 한명의 파트너만 만나야하지만 정작 A의 파트너인 B는 A이외의 파트너도 만날 수 있는 난봉꾼입니다. 때문에 A는 B에 종속적이라고 표현합니다.



## 결정자

## 종속자

## 완전 함수 종속
어떤 애트리뷰트(속성)가 기본키에 대해 완전히 종속적인 경우 완전 함수 종속이라고 한다.

## 이행적 함수 종속

한 릴레이션의 속성 X, Y, Z가 주어졌을 때 함수적 종속성 X → Y와 Y → Z가 성립되면 논리적 결과로 X → Z가 성립한다. 이 때 속성 Z는 X에 이행적 함수적 종속성이라고 한다.




# 이상
- ᆞ원인 : 테이블에서 일부 속성들의 종속으로 인해 데이터의 중복이 발생하고, 이 중복(Redundancy)으로 인해 테이블 조작 시 문제가 발생하는 현상

## 삭제이상(deletion anomaly)
 * : 어떤 정보를 삭제할 때, 삭제되지 않아야 할 정보까지 같이 삭제되는 현상
 * - <열심히>학원테이블에서 ‘소문난’학생이 학원을 그만 두어서 ‘소문난’학생의 정보를 삭제
 *   하는 경우, 만약 ‘장미’반의 학생이 유일하게 ‘소문난’학생 한 명이었다면 반이름, 과목명,
 *   강사명 등 삭제되지 않아야 할 정보가 같이 삭제된다.
 
 
## 삽입이상(insertion anomaly)
 * : 어떤 정보를 입력할 때, 입력이 불가능하거나 불필요한 정보까지 입력해야 하는 현상
 * -  위 테이블에서 과학반을 신설하는 경우, 아직 등록학생이 하나도 없는 경우이므로 과학반
 *    을 신설할 수가 없다(<-학생번호가 Primary Key여서 Null값을 가질 수 없기 때문).
 
 
## 수정이상(modification anomaly)
 * : 반복된 데이터 중 일부만 수정하여 데이터 불일치가 발생하는 현상
 * - 위 테이블에서 장미반의 담당강사가 ‘아무개’에서 ‘갑을병’으로 바뀌는 경우, 장미반에 해
 *   당하는 모든 tuple을 다 수정해야 한다.


# 변환함수
- 모든 데이터를 문자열로 받기 때문에 그때 그때 변환시켜주는 것보다 실무에서는 to_char 사용
- ⎼데이터 유형 변환은 오라클 서버에 의해 암시적으로 수행되거나 유저에 의해 명시적으로 수행될 수 있다.
- ⎼명시적 데이터 유형 변환은 변환 함수를 사용하여 수행되며 변환 함수는 값의 데이터 유형을 변환한다.
- ⎼일반적으로 함수 이름의 형식은 data type TO data type 규칙을 따르며 첫번째 데이터 유형은 입력 데이터 유형이고 두번째 데이터 유형은 출력 데이터 유형이다.
- ⎼암시적 데이터 유형 변환은 오라클 서버는 자동으로 표현식에서 데이터 유형 변환을 수행하고 일반적으로 오라클 서버에서는 데이터 유형 변환이 필요한 경우 표현식에 대한 규칙을 사용한다.
- ⎼날짜 형식 모델의 요소는 날짜 출력 포맷과 시간 출력 포맷 그리고 숫자 출력 포맷 형식이 있다.

## to_char 규칙
- 자바, C언어, 자바스크립트 등 언어마다 날짜 format이 다른데 그때마다 변환하기는 복잡하니 언어끼리는 String으로 교환하고 마지막에 오라클에서 to_char로 바꿔날짜로 바꿔주면 다른 코드들도 짧아지고 편해진다.
- 넘겨주기 전 언어가 Comparable, Serializable 등 기능을 가진 언어여야 함.(객체지향 언어는 대부분 보유; PHP같은 언어는 안됨)
- ① 형식 모델은 단일 따옴표로 묶어야 하며 대소문자를 구분한다. 
- ② 형식 모델은 임의의 유효한 날짜 형식 요소를 포함할 수 있지만 쉼표를 사용하여 날짜값을 형식 모델과 구분해야 한다. 
- ③ 자동으로 출력의 일 및 월 이름은 공백으로 채워진다. 
- ④ 채워진 공백을 제거하거나 선행 0 fmt . 을 출력하지 않으려면 채우기 모드 요소를 사용한다

## 예제
- select sysdate, to_char(sysdate, 'YYYY-mm-dd') from dual;
- 대체문자 사용: select sysdate, to_char(sysdate, 'YYYY"년"-mm"월"-dd') from dual;
- ‘’안에 “” 사용해서 대체문자 사용 가능


# 그룹함수
- ⎼그룹 함수는 select 절 뒤에 배치하고 여러 그룹 함수를 쉼표(,) . 로 구분하여 함께 사용할 수 있다
-  ⎼distinct 키워드는 함수가 중복되지 않는 값만 사용한다. 
- ⎼all 키워드는 중복된 값을 포함하여 모든 값을 사용하고 기본값은 all 키워드이므로 별도로 all 키워드를 지정할 필요는 없다. 
- ⎼expr 인수를 사용하는 함수의 데이터 유형은 char, varchar2, number 또는 date 가 될 수 있다. 
- ⎼모든 그룹 함수는 null . 



# Group by
- Group by와 Having은 중첩 select문을 사용하기 위해 씀; 서브쿼리로 대체 가능

# Having
- Group by와 Having은 중첩 select문을 사용하기 위해 씀; 서브쿼리로 대체 가능

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


# create
## primary key
- 중복 안됨, 자동 not null

## varchar
- title varchar // MySQL꺼  varchar2 // 오라클 꺼

# delete
- delete from board; 이렇게 하면 모든 데이터가 삭제된다. 커밋 전에는 rollback으로 되돌리기

# insert
## insert JDBC
 * 			connection = DriverManager.getConnection(url, userid, password);
 * 				System.out.println(connection);
 * 				statement = connection.createStatement(); // statement를 사용할 수 있도록 만듬
 * 				String sql = "insert into deptno(deptno, dname, loc) values(70, '연구부', '광주')";
 * 				statement.executeUpdate(sql);
 * - result 필요 없음, executeUpdate 사용



#  데이터베이스
## Transaction
* 데이터베이스에서 하나의 논리적 기능을 수행하기 위한 일련의 연산 집합으로서 작업의 단위이다.
* 트랜잭션(Transaction)은 데이터베이스의 완전성을 보장하기 위한 것입니다.
* 상태를 변화시키기 해서 수행하는 하나의 작업의 단위를 뜻합니다.
- ⎼오라클에서 발생하는 여러 개의 SQL . 문들을 하나의 논리적인 작업단위로 처리하는데 이를 트랜잭션이라고 한다 
- 트랜잭션의 결과는 반드시 모두 성공하거나 모두 실패 하거나 둘 중 하나이므로 반드시 명시적으로 종료를 시켜주어야 된다

### 원자성 (Atomicity)
* all or nothing
 * 트랜잭션과 관련된 작업들이 부분적으로 실행되다가 중단되지 않는 것을 보장하는 것을 의미한다.
 * 원자성은 이와 같이 중간 단계까지 실행되고 실패하는 일이 없도록 하는 것이다.

### 일관성 (Consistency)
 * 트랜잭션이 실행을 성공적으로 완료하면 언제나 일관성 있는 데이터베이스 상태로 유지하는 것을 의미한다.
 * 일관성 있는 데이터베이스 상태라는 것은 다양한 제약 조건(constraints, cascades, triggers)등에 만족한다는 것이다. - Software Level

### 독립성 (Isolation)
 * 트랜잭션을 수행 시 다른 트랜잭션의 연산 작업이 끼어들지 못하도록 보장하는 것을 의미한다.
 * 트랜잭션 밖에 있는 어떤 연산도 중간 단계의 데이터를 볼 수 없음을 의미한다.

### 지속성 (Durability)
 * 성공적으로 수행된 트랜잭션은 영원히 반영되어야 함을 의미한다. - Hardware Level
 * 전력문제, 시스템 문제, DB 일관성 체크 등을 하더라도 유지되어야 함을 의미한다.
 * 전형적으로 모든 트랜잭션은 로그로 남고 시스템 장애 발생 전 상태로 되돌릴 수 있다.
 * 트랜잭션은 로그에 모든 것이 저장된 후에만 commit 상태로 간주될 수 있다.


## Rollback
* 트랜잭션 처리가 비정상으로 종료되어 데이터베이스의 일관성이 깨졌을 때 트랜잭션이 행한 모든 변경 작업을 취소하고 이전 상태로 되돌리는 연산

### 트랜잭션(Transaction)을 사용하며 주의해야 할점?
* 언제나 얻는 것이 있으면 잃는 것도 있다.
* 트랜잭션은 데이터를 완전성을 보장하기 위해 많은 자원들을 사용하게 된다. 자원을 사용하며 Lock을 걸게 되면 다른 사용자들은 Lock이 해제될 때까지 기다려야한다. 기다린다는 것은 성능에 좋지 않다는 의미이다. 따라서 Transaction의 범위를 최소화하여 적용하는 것이 좋다.

## 병행 제어(Concurrency Control)의 개념
- 동시에 여러개의 트랜잭션을 병행 수행할 때, 트랜잭션들이 DB의 일관성을 파괴하지 않도록 트랜잭션 간의 상호작용을 제어하는 것.
- 병행성 : 트랜잭션을 동시에 인터리빙(Interleaving)하게 실행되는 것.
- 인터리빙 : 트랜잭션이 번갈아가며 조금씩 처리를 수행하는 것.

### 병행 제어의 목적
- DB의 공유도 최대화.
- 시스템 활용도 최대화.
- 응답 시간 최소화.
- 단위 시간당 트랜잭션 처리 건수 최대화.
- DB의 일관성 유지

### 병행제어의 필요성
- 갱신 분실 (Lost Update): ・같은 데이터를 공유하여 갱신할 때 갱신 결과의 일부가 사라지는 현상.
- 모순성 (Inconsistency) ・동시에 같은 데이터를 갱신할 때, 데이터의 상호 불일치가 발생하는 현상. ・불일치 분석(Inconsistent Analysis)이라고도 한다.
- 연쇄 복귀 (Cascading Rollback) ・트랜잭션 중 하나에 문제가 생겨 Rollback 되는 경우, 다른 트랜잭션들도 함께 Rollback 되는 현상.

## 병행 제어 기법의 종류

### 2-단계 잠금 규약(Two-Phase Lock Protocol) 기법
- 트랜잭션 스케쥴의 직렬성을 보장하는 대표적인 기법
- 2단계는 다음과 같다.
- 확장(Growing) 단계 : 잠금만 수행할 수 있음. (해제 불가)
- 축소(Shrinking) 단계 : 해제만 수행할 수 있음. (잠금 불가)
- 장점 : 직렬성 보장 / 단점 : 교착 상태 예방 불가능

### 타임 스탬프(Time Stamp Ordering) 기법
- 시스템에 도착한 순서대로 타임 스탬프를 부여하여, 순서대로 실행하도록 한다.
- 교착 상태가 발생하지 않는다.
- 출처: https://cbts.tistory.com/250 [IT일기장]


## 로킹
* 상호배제와 접근제어 기능
* Lock을 걸어 그 Lock을 건 트랜잭션만이 Lock을 해제 할 수 있다.
* 하나의 Transaction이 사용하는 DB내의 data를 다른 Transaction이 접근하지 못하게 Lock을 설정하여  다른 Transaction이 접근하지 못하도록 한다. 실행 완료 후엔 Lock을 해제한다.

### 로킹의 특징
* 로킹 단위가 크면 로크 수가 적어 관리하기 쉽지만 병행성 수준이 낮아진다.
* 로킹 단위가 작으면 로크 수가 많아 관리하기는 복잡하지만 병행성 수준이 높아집니다.

### 2단계 로킹 규약(Two-Phase Locking Protocol)
 * 트랜잭션은 lock만 수행할 수 있고, unlock은 수행할 수 없는 확장 단계가 있다.
 * 
 * 확장단계(Growing Phase)
 * Lock을 설정하는 단계
 * 새로운 lock 연산만 수행할 수 있고 unlock 연산은 수행할 수 없는 단계
 * 축소단계(Shirinking Phase)
 * Lock을 해제하는 단계
 * unlock 연산만 실행할 수 있고 일단 unlock 연산을 실행하면 lock 연산은 실행할 수 없는 단계
 * 교착상태(Deadlock)이 발생할 수있다.
 * 
 * 2단계 로킹 규약 준수 o –> 직렬가능 
 * 2단계 로킹 규약 준수 x –> 직렬가능성을 보장 할 수없다. 직렬이 가능할수도, 가능하지 않을수도…


# 사용자 관리
- 사용자가 접속 한 후에 테이블을 생성하고 데이터를 조회, , , 입력 수정 삭제 등을 하기 위해서는 특별한 권한이 필요하다. 
- ⎼권한의 종류도 시스템 권한과 객체 권한으로 나누어지며 여러 개의 권한을 묶어서 롤(role) 이라는 개념으로 사용한다. 
- ⎼개별적인 권한보다 롤을 사용하는 것이 더 효율적이며 새로운 계정 및 권한 부여는 DBA .

## 롤
- 권한들의 묶음

## grant
- RESOURCE : 개체를 생성, 변경, 제거 할 수 있는 권한 ( DDL, DML사용이가능함)
- CONNECT : 데이터베이스에 연결할 수 있는 권한
- DBA : 데이터베이스 관리자 권한
- GRANT CREATE TABLE TO 유저명             // 테이블을 생성할 수 있는 권한
- GRANT DROP ANY TABLE TO 유저명         // 테이블을 제거할 수 있는 권한
- grant connect, resource to test1;  resource: 테이블 삭제 수정
- grant create sequence to test1;
-  test 계정에게 권한을 부여하며 sequence 키워드는 시 퀀스를 생성할 수 있도록 시퀀스에 대한 권한을 부여한다. 
- grant create view to test1;

## revoke
- revoke 권한 및 롤 from 계정; 
- revoke create sequence from test;

# 키
- 키는 테이블에서 행들을 구별할 수 있는 속성 또는 속성들의 집합을 말합니다. 특징으로 모든 행에서 유일값을 가져야하는 유일성, 최소한의 속성들로만 키를 구성하는 최소성이 있습니다. 대표적으로 슈퍼키, 후보키, 기본키, 대체키, 외래키가 있습니다.

## 슈퍼키
- 유일성을 만족하는 키, 즉 고유하게 식별하는 모든 조합을 슈퍼키라고 합니다.

## 후보키
- 기본키로 선정될 수 있는 후보라는 의미로 유래된 이름이며, 유일성과 최소성을 만족하는 키입니다.

## 슈퍼키와 후보키의 차이점
- 슈퍼키의 조합에서 더 줄일 수 없이 꼭 필요한 키로 구성된 조합을 후보키라고 합니다. 예를 들어 ‘마을ID’, ‘도시명’, ‘도명’이 있는 테이블에 {마을ID, 도시명, 도명} 으로 구성된 키는 슈퍼키가 될수 있으며, {마을ID}, {도시명, 도명}이 후보키가 될 수 있습니다.

## 기본키
- 후보키 중에서 설계자에 의해 선택된 키입니다.

## 대체키
- 후보키 중에서 기본키로 선택되지 못한 키입니다.

## 외래키
- 다른 테이블의 기본키를 참조하는 속성을 외래키라고 합니다.

# 기본키와 외래키 조인의 문제점
- 기본키와 외래키 사이의 참조 무결성 지키기 위해 복잡해진다.

# 기본키와 외래키 조인의 장점
- 보안성이 좋아진다.


# NoSQL과 RDBMS가 뭔지 설명
- NoSQL과 RDBMS는 데이터베이스 종류 중 하나입니다. 데이터 보존 형식에 따라 구분이 되는데 RDBMS는 2차원 표형식으로 데이터를 관리하는 데이터베이스이며, NoSQL은 ‘Not Only SQL’의 준말로써, 관계형 데이터베이스 특성 뿐만 아니라 여러 특성을 가지는 확장성 높은 데이터베이스입니다.

## NoSQL 등장배경
```java
지난 20년간, 데이터를 저장하는 데에는 관계형 데이터베이스가 사용되었다.

트랜잭션을 통한 안정적인 데이터 관리가 가장 중요한 이슈였기 때문이다.

하지만 웹 2.0 환경과 빅데이터가 등장하면서 RDBMS는 난관에 부딪히게 되었는데,
바로 데이터를 처리하는 데 필요한 비용의 증가때문이다.

데이터와 트래픽의 양이 기하급수적으로 증가함에 따라
한 대에서 실행되도록 설계된 관계형 데이터베이스를 사용하는 것은 하드웨어적으로 큰 비용이 들게 되었다.

장비의 성능이 좋을수록 성능을 향상시키는 데(Scale-up : 수직적 확장) 비용이 기하급수적으로 증가하기 때문이다.

NoSQL은 데이터의 일관성을 약간 포기한 대신
여러 대의 컴퓨터에 데이터를 분산하여 저장하는 것(Scale-out : 수평적 확장)을 목표로 등장하였다.

NoSQL의 등장으로 작고 값싼 장비 여러 대로 대량의 데이터와 컴퓨팅 부하를 처리하는 것이 가능하게 되었다.
```

## CAP 이론
```java
다음과 같은 질문을 할 수 있다.

RDBMS에서는 ACID라는 개념이 있다.
ACID(원자성, 일관성, 고립성, 지속성)는 데이터베이스 트랜젝션이 안전하게 수행된다는 것을 보장하기 위한 성질

그렇다면 NoSQL에서는?

ACID는 RDBMS에서 매우 중요하게 생각하는 성질이라 할 수 있다.

그런데 NoSQL에서는 찾아보기 힘든 단어이다.

CAP이론은 분산 시스템에서는 위 그림의 3개 속성을 모두 가지는 것이 불가능하다! 이다.

1. Consistency

CAP이론에서 말하는 Consistency는 ACID의 C가 아니다.

ACID의 ‘C’는 데이터는 항상 일관성 있는 상태를 유지해야 하고 데이터의 조작 후에도 무결성을 해치지 말아야 한다는 속성이다.

CAP의 ‘C’는 Single request/response operation sequence의 속성을 나타낸다.

그 말은 쓰기 동작이 완료된 후 발생하는 읽기 동작은 마지막으로 쓰여진 데이터를 리턴해야 한다는 것을 의미한다.

정리해보면 Consistency라는 단어보다는 Atomic이라는 단어가 더 정확하게 특징을 나타낸다고 할 수 있다.

일관성은 동시성 또는 동일성이라고도 하며
다중 클라이언트에서 같은 시간에 조회하는 데이터는
항상 동일한 데이터임을 보증하는 것을 의미한다.

이것은 관계형 데이터베이스가 지원하는 가장 기본적인 기능이지만
일관성을 지원하지 않는 NoSQL을 사용한다면
데이터의 일관성이 느슨하게 처리되어 동일한 데이터가 나타나지 않을 수 있다.
느슨하게 처리된다는 것은 데이터의 변경을 시간의 흐름에 따라 여러 노드에 전파하는 것을 말한다.

이러한 방법을 최종적으로 일관성이 유지된다고 하여 최종 일관성 또는 궁극적 일관성을 지원한다고 한다.

각 NoSQL들은 분산 노드 간의 데이터 동기화를 위해서 두 가지 방법을 사용한다.

첫번째로 데이터의 저장 결과를 클라이언트로 응답하기 전에 모든 노드에 데이터를 저장하는 동기식 방법이 있다.
그만큼 느린 응답시간을 보이지만 데이터의 정합성을 보장한다.

두번째로 메모리나 임시 파일에 기록하고 클라이언트에 먼저 응답한 다음
특정 이벤트 또는 프로세스를 사용하여 노드로 데이터를 동기화하는 비동기식 방법이 있다.
빠른 응답시간을 보인다는 장점이 있지만, 쓰기 노드에 장애가 발생하였을 경우 데이터가 손실될 수 있다.

분산 시스템에서 일관성을 유지하기 위해서는 희생이 따른다.

카산드라(Cassandra DB)의 일관성 레벨

가용성과 분할 허용성을 지원하는 카산드라는 최종 일관성을 지원한다.

또한 설정값을 조절하여 강한 일관성을 지원할 수 있다.

많은 NoSQL 솔루션은 읽기와 쓰기의 성능 향상을 위해 데이터를 메모리에 임시로 기록한 다음
클라이언트에 응답하고 백그라운드 쓰레드(혹은 프로세스)로 해당 데이터를 디스크에 기록한다.

방금 전에 언급했듯이 이 경우에는 데이터 손실의 위험이 존재하게 되는데
카산드라와 HBase에서는 이러한 손실을 방지하기 위해
메모리에 저장하기 전에 커밋로그 및 WAL파일에 먼저 정보를 기록하는 방법을 사용하고 있다.

Redis에도 AOF(Append Only File)라는 기능이 존재한다.

2. 특정 노드가 장애가 나도 서비스가 가능해야 한다라는 의미를 가진다.

데이터 저장소에 대한 모든 동작(read, write 등)은 항상 성공적으로 리턴되어야 한다.

명확해 보이는 단어이기는 하지만 분산 시스템에서의 특징을 말하는 것이기 때문에
서비스가 가능하다와 성공적으로 리턴이라는 표현이 애매하다.

얼마동안 기다리는 것 까지를 성공적이라고 할 수 있느냐에 대한 문제가 남아있다.

20시간정도 기다렸더니 리턴이 왔어! Availability가 있는 시스템이야! 라고 할 수 없기 때문이다.

다시한번 성공적으로 리턴 에 대해서 보면
모든 동작에 대해서 시스템이 Fail 이라는 리턴을 성공적으로 보내준다면
그것을 Availability가 있다고 해야 하느냐에 대해서도 애매하다.

CAP를 설명하는 문서들 중 Fail 이라고 리턴을 하는 경우도 성공적인 리턴 이라고 설명하는 것을 보았다.

NoSQL은 클러스터 내에서 몇 개의 노드가 망가지더라도 정상적인 서비스가 가능하다.

몇몇 NoSQL은 가용성을 보장하기 위해 데이터 복제(Replication)을 사용한다.

동일한 데이터를 다중 노드에 중복 저장하여 그 중 몇 대의 노드가 고장나도 데이터가 유실되지 않도록 하는 방법이다.

데이터 중복 저장 방법에는 동일한 데이터를 가진 저장소를 하나 더 생성하는 Master-Slave 복제 방법과
데이터 단위로 중복 저장하는 Peer-to-Peer 복제 방법이 있다.

* 단일 고장점이란?

단일 고장점이란 시스템을 구성하는 개별 요소 중에서 하나의 요소가 망가졌을 때
시스템 전체를 멈추게 만드는 요소를 말한다.

단일 고장점을 가진 NoSQL은 자체적으로 가용성을 지원하지 못하기 때문에
이를 지원하기 위해 별도의 솔루션을 함께 사용하기도 한다.

단일 고장점을 가진 솔루션들은 분산 환경에서 전체 서비스가 중단되는
심각한 문제가 발생할 수 있기 때문에 기피 대상이다.

3. Tolerance to network Partitions

분할 허용성이란 지역적으로 분할된 네트워크 환경에서 동작하는 시스템에서
두 지역 간의 네트워크가 단절되거나 네트워크 데이터의 유실이 일어나더라도
각 지역 내의 시스템은 정상적으로 동작해야 함을 의미한다.

원래는 Tolerance to network Partitions인데 보통은 Partition-tolerance라고도 한다.

즉 노드간에 통신 문제가 생겨서 메시지를 주고받지 못하는 상황이라도 동작해야 한다.

Availablity와의 차이점은 Availability는 특정 노드가 장애가 발생한 상황에 대한 것이고

Tolerance to network Partitions는 노드의 상태는 정상이지만
네트워크 등의 문제로 서로 간의 연결이 끊어진 상황에 대한 것이다.

```

## NoSQL의 종류
```java
1. Key-Value Model

가장 기본적인 형태의 NoSQL이며 키 하나로 데이터 하나를 저장하고 조회할 수 있는 단일 Key-Value 구조를 갖는다.

키는 값에 접근하기 위한 용도로 사용되며, 값은 어떠한 형태의 데이터라도 담을 수 있다.

심지어는 이미지나 비디오도 가능하다.

또한 간단한 API를 제공하는 만큼 질의의 속도가 굉장히 빠른 편이다.

단순한 저장구조로 인하여 복잡한 조회 연산을 지원하지 않는다.

고속 읽기와 쓰기에 최적화된 경우가 많다.

사용자의 프로필 정보, 웹 서버 클러스터를 위한 세션 정보, 장바구니 정보, URL 단축 정보 저장 등에 사용한다.

하나의 서비스 요청에 다수의 데이터 조회 및 수정 연산이 발생하면
트랜잭션 처리가 불가능하여 데이터 정합성을 보장할 수 없다.

Key-Value 모델을 사용하는 NoSQL 데이터베이스로는 Memcached, Riak, Redis, Amazon Dynamo DB, LevelDB 등이 있다.

2. Document Model

Key-Value 모델에서 한층 진화한 모델로 생각할 수 있다.

검색에 최적화되어 있는데, 이는 Key-Value 모델의 특징과 동일하다.

데이터는 키와 도큐먼트(Document)의 형태로 저장된다.

키는 문서에 대한 ID로 표현된다.

또한 저장된 문서를 컬렉션으로 관리하며 문서 저장과 동시에 문서 ID에 대한 인덱스를 생성한다.

문서 ID에 대한 인덱스를 사용하여 O(1)시간 안에 문서를 조회할 수 있다.

Key-Value 모델과 다른 점이라면 Value가 계층적인 형태인 도큐먼트로 저장된다는 것이다.

객체 지향에서의 객체와 유사하며 이들은 하나의 단위로 취급되어 저장된다.

다시 말해 하나의 객체를 여러 개의 테이블에 나눠 저장할 필요가 없어진다는 뜻이다.

또한 Document 모델에서는 도큐먼트 내의 Item을 이용한 쿼리가 가능하다.

다만 이를 위해서는 Xquery나 다른 도큐먼트 질의 언어가 필요하다.

도큐먼트 모델에서는 질의의 결과가 JSON이나 XML 형태로 출력되기 때문에
그 사용 방법이 RDBMS에서의 질의 결과를 사용하는 방법과 다르다.

그렇기에 쿼리를 사용하는데 익숙해지기까지 다소 어려움이 있을 수 있다.

대부분의 문서 모델 NoSQL은 B트리 인덱스를 사용하여 2차 인덱스를 생성한다.

B트리는 크기가 커지면 커질수록 새로운 데이터를 입력하거나 삭제할 때 성능이 떨어지게 된다.

그렇기 때문에 읽기와 쓰기의 비율이 7:3 정도일 때 가장 좋은 성능을 보인다.

중앙 집중식 로그 저장, 타임라인 저장, 통계 정보 저장 등에 사용된다.

Document 모델을 사용하는 NoSQL 데이터베이스로는 MongoDB, CouchDB, MarkLogic 등이 있다.

3. Column Model

하나의 키에 여러 개의 컬럼 이름과 컬럼 값의 쌍으로 이루어진 데이터를 저장하고 조회한다.

모든 컬럼은 항상 타임 스탬프 값과 함께 저장된다.

컬럼형 NoSQL은 구글의 Big Table 영향을 받았다.

이러한 이유로 Row key, Column Key, Column Family 같은 Big Table 개념이 공통적으로 사용된다.

저장의 기본 단위는 컬럼으로 컬럼은 컬럼 이름과 컬럼 값, 타임스탬프로 구성된다.

이러한 컬럼들의 집합이 Row(Row)이며, Row키(Row key)는 각 Row를 유일하게 식별하는 값이다.

이러한 Row들의 집합은 키 스페이스(Key Space)가 된다.

대부분의 컬럼 모델 NoSQL은 쓰기와 읽기 중에 쓰기에 더 특화되어 있다.

데이터를 먼저 커밋 로그와 메모리에 저장한 후 응답하기 때문에 빠른 응답 속도를 제공한다.

그렇기 때문에 읽기 연산 대비 쓰기 연산이 많은 서비스나
빠른 시간 안에 대량의 데이터를 입력하고 조회하는 서비스를 구현할 때 가장 좋은 성능을 보인다.

채팅 내용 저장, 실시간 분석을 위한 데이터 저장소 등의 서비스 구현에 적합하다.

클러스터링이 쉽게 이뤄지며 Time stamp가 존재해 값이 수정된 히스토리를 알 수 있다.

또한 값들은 일련의 바이너리 데이터로 존재하기 때문에 어떤 형태의 데이터라도 저장될 수 있다.

다만 위의 두 모델들과는 다르게 Blob 단위의 쿼리가 불가능하며 로우와 컬럼의 초기 디자인이 중요하다.

Schema Less이긴 하지만 새로운 필드를 만드는 데 드는 비용이 크기 때문에
사실상 결정된 스키마를 변경하는 것이 어렵다.

Column-family 모델을 사용하는 NoSQL 데이터베이스로는 Google Big Table, HBase, Cassandra, Hypertable 등이 있다.
```

## NoSQL이 필요한 이유
```java
예를 들어 
구매 내역이나 게임의 로그 같은 데이터들은 매 초마다 엄청난 양이 생성되지만 한번 저장되고 난 뒤에는 수정 될 일이 거의 없다. 
이런 데이터들을 저장하는 데 데이터의 일관성을 보장하기 위해 ACID 트랜잭션을 지원할 필요는 없을 것이다. 
거기다 생성되는 데이터의 양도 많기 때문에 장비의 성능에도 상당한 영향을 미칠 것이다. 

NoSQL은 이러한 데이터들을 효율적으로 저장할 수 있다. 
여러 대의 장비에 빠른 속도로 저장이 가능하며, 
데이터의 양이 누적되더라도 얼마든지 수평적 확장이 가능하기 때문이다.

실제로 페이스북이나 트위터 같은 소셜 네트워크 서비스에서는 게시글들을 저장하는 데 NoSQL 데이터베이스를 사용하고 있다.
매 초에 수백 기가 ~ 수 테라 바이트씩 생성되는 데이터들을 RDBMS를 사용해 저장한다면, 
글 작성 버튼을 누른 후 
글이 중앙 데이터베이스에 저장되기까지 한참을 기다려야 글을 성공적으로 게시할 수 있을 것이다. 
하지만 NoSQL의 분산 데이터베이스를 사용한다면 
부하가 분산되기 때문에 우리가 글쓰기 버튼을 누르고 한참을 기다릴 필요가 없게 된다.

하지만 데이터의 일관성이 보장되어야 하거나 여러번의 조인 연산이 필요한 데이터라면 
NoSQL을 사용하는 것 보다 RDBMS를 사용하는 것이 좋을 것이다. 
NoSQL은 RDBMS를 대체하기 위한 데이터베이스가 아니라 
상호 보완할 수 있는 데이터베이스이며 
따라서 목적에 맞게 사용하는 것이 중요하다.
```

## RDBMS
- 2차원 표 형태로 데이터를 관리하는 데이터베이스로서, 친근한 구조로 인해 사람에게 자연스럽고 직관적인 이해를 할 수 있는 특징이 있습니다. 또한 프로그래밍 언어를 몰라도 데이터를 쉽게 조작할 수 있도록 설계된 언어인 SQL을 통하여 데이터 조작을 할 수 있어 편리하단 장점이 있습니다. 하지만 데이터의 일관성을 엄격히 준수하고 중복을 최소화하는 특징에 의해 속도가 비교적 느리고, 유연성이 낮습니다. 따라서 데이터를 수많은 서버에 분산 저장하는 data sharding이 어려워 서버 확장이 힘들다는 단점이 있습니다.

## NoSQL
- 빅데이터에서 쏟아져 나오는 방대한 양의 비정형 데이터를 처리하기 위해 설계된 데이터베이스로서 기존의 RDB는 정형화된 데이터만 처리할 수 있는 문제 때문에 빅데이터 환경에서 이를 대처하기 위해 사용되었습니다. 데이터의 일관성을 보장하지 않는 대신 빠른 속도를 가지고, schema-less 구조이기에 유연성이 높습니다. 데이터의 중복을 허용하는 구조때문에 scale out 방식 중 하나인 sharding 적용이 쉬워 서버 확장이 쉽다는 특징을 가집니다. 하지만 결국 데이터 손실 위험을 있고, 복잡한 join이 어렵다는 단점이 있습니다.

### shrading 
* 관계형 데이터베이스는 데이터를 수많은 서버에 분산 저장하는 data sharding이 어려워 서버 확장이 힘들다는 단점이 있습니다.
- 데이터의 정합성 문제와 갱신에 의한 성능 저하가 발생하는 shared disk의 문제를 해결하기 위해 고안된 아키텍쳐가 shared nothing이며 이 개념에 기반하여 구글에서 만든 구조가 sharding 입니다. sharding은 데이터를 여러 저장소에 분할 저장함으로써 동기화에 대한 이슈를 제거했기에 속도 또한 빠릅니다. 분할된 구조를 통해 병합 문제를 해결하였습니다. 하지만 특정 저장소에 정해진 데이터가 저장되어있기에 데이터를 찾으려면 특정 저장소를 찾아가야한다는 문제점이 있으며, 하나의 DB 서버가 다운이 되면 복구할 수가 없다는 문제가 있습니다. 이러한 문제는 커버링이라는 구성을 통해 하나의 DB 서버가 다운되었을 때 그것을 이어받아 처리하는 조치가 필요합니다.

### NoSQL 그림
* 테이블 - 중복 최소화(속도, 유연성)
	1. shrading(서버 확장) + 데이터 손실 위험
	2. 복잡한 join이 어렵다.

# index
## Index 개념, 쓰는 이유와 장단점
- 테이블의 읽기속도를 높이기 위해 사용되는 자료구조로서 테이블의 컬럼 인덱스를 설정하여 검색시 full scan이 아닌 index 파일 검색으로 검색속도를 빠르게 합니다.
* 인덱스는 지정한 컬럼들을 기준으로 메모리 영역에 목차를 생성하는 것
* insert,update,delete의 성능을 떨어뜨리고, select의 성능을 향상 시킨다.
* 이때, insert,update,delete의 성능이 떨어지는 것이지, insert,update,delete하기 위해 데이터를 조회하는 것은 인덱싱에 의해서 빠르게 조회가 된다.
* 인덱스가 없는 컬럼을 조건으로 UPDATE,DELETE하게 되면 굉장히 느려지므로, 많은 양의 데이터를 삭제 해야하는 상황에서는 인덱스로 지정된 컬럼을 기준으로 삭제하길 권고
B* +트리, 해시등의 알고리즘을 사용한다.

## 장점
- 테이블 검색과 정렬 속도를 향상시킵니다. 또한 index를 기본키로 자동설정하여 관리가 편합니다.

## 단점
- 인덱스 파일을 별도로 만들어야함으로 파일의 크기가 늘어나고 인덱스를 처음에 생성하는데 시간이 많이 소요될 수 있습니다. 또한 인덱스된 컬럼값이 변경되거나 인덱스를 업데이트해야하기에 성능이 떨어지게 됩니다.

## 인덱스를 사용해야 될 때
- 위와 같은 단점에 따라 변경이 잦은 컬럼에는 인덱싱을 피하고, true/false 값을 같는 컬럼처럼 중복도가 높은 컬럼은 인덱스로 만들어도 고유성이 없기에 효용이 없습니다. where절과 join, order by 등에 자주 사용되는 컬럼의 경우 인덱스로 선정하면 검색 속도를 효과적으로 높일 수 있습니다.

## 인덱스 구조
- 검색의 효율을 높이기 위해 B-tree 또는 B+tree 구조를 사용합니다.

## 인덱스 원리
* 인덱스를 컬럼에 부여하면 초기 TABLE생성시 만들어진 myd,myi,frm 3개의 파일 중에서 myi에 해당 컬럼을 색인화 하여 저장한다.
* 사용자가 SELECT쿼리로 index가 사용하는 쿼리를 사용시 해당 table을 검색하는 것이 아니라 빠른 tree로 정리해둔 myi파일의 내용을 검색한다.
* 만약, index를 사용하지 않은 select쿼리라면 해당 table을 full scan하여 속도가 느리다.

## B-Tree
- B-Tree는 검색성능을 높이기 위한 Balanced-Tree 자료구조의 종류 중 하나로서 이진트리와 다르게 하나의 노드에 여러자료가 배치되고 2개이상의 자식노드를 가질 수 있는 Tree 구조입니다. 루트를 제외한 모든 노드의 자료수는 LIMIT/2개여야하며, 자식노드의 수는 (부모노드의 자료수 + 1)개여야하는 특징이 있습니다. 이것의 이유는 B-Tree의 구조 때문에 생긴 특징입니다. 따라서 삽입, 삭제시에도 트리 균형을 유지할 수 있는 특징과, 언제나 균등한 탐색속도를 보장하는 특징이 있지만, 트리의 균형을 유지하기 위해 복잡한 연산을 해야하며, 무엇보다 중위순회방식을 사용하기에 순회탐색이 비효율적이라는 단점이 있습니

## B+Tree
- B+Tree는 B-Tree에서 순회탐색의 비효율을 보완한 구조로서, 노드의 데이터들이 연결리스트로 연결되어 있어 순차적 처리가 가능하여 순회탐색이 빠릅니다. 트리의 최하단 노드에만 데이터들이 연결리스트로 정렬되어 있으며 나머지 노드들은 키값만 가지고 있는 구조입니다.

## Balanced-Tree
- Tree 자료형의 기본적인 구조인 이진트리는 좌우 균형이 안 맞아 비효율적이라는 단점을 가지는데 이것은 해결한 자료구조가 Balanced-Tree 구조입니다. Balanced-Tree는 한쪽으로 몰린 depth를 균일하게 재배치함으로서 모든 자식 노드들의 depth를 균일하게 합니다. 따라서 어떠한 상횡에서도 검색성능을 O(logN)까지 일관된 속도를 보장하는 구조입니다.


## Replication
- 리플리케이션이란 데이터베이스를 접근하는 DB서버와 데이터를 저장하는 저장소를 구성하는 하나의 세트를 복제하여 여러 세트로 구성함으로써 위험을 분산하는 구조를 말합니다. 이러한 구조를 저장소를 공유한다 하여 shared disk라고 부릅니다. 분산처리를 통해 성능 향상을 기대할 수 있는 장점이 있는 반면, 여러 데이터가 복제되어 있는 만큼 데이터의 정합성을 유지하기 어렵습니다. 따라서 갱신 주기를 어떻게 하느냐가 중요한데 이것은 성능과 데이터의 정합성에 트레이드오프 관계가 발생하는 단점이 있습니다.

## Sharding
- 데이터의 정합성 문제와 갱신에 의한 성능 저하가 발생하는 shared disk의 문제를 해결하기 위해 고안된 아키텍쳐가 shared nothing이며 이 개념에 기반하여 구글에서 만든 구조가 sharding 입니다. sharding은 데이터를 여러 저장소에 분할 저장함으로써 동기화에 대한 이슈를 제거했기에 속도 또한 빠릅니다. 분할된 구조를 통해 병합 문제를 해결하였습니다. 하지만 특정 저장소에 정해진 데이터가 저장되어있기에 데이터를 찾으려면 특정 저장소를 찾아가야한다는 문제점이 있으며, 하나의 DB 서버가 다운이 되면 복구할 수가 없다는 문제가 있습니다. 이러한 문제는 커버링이라는 구성을 통해 하나의 DB 서버가 다운되었을 때 그것을 이어받아 처리하는 조치가 필요합니다.


# 시퀀스
- ⎼시퀀스는 값이 일정한 규칙에 의해서 연속적으로 자동 증가하거나 감소해야 하는 경우에 적용 시킬 수 있는 오라클 객체이며 테이블내의 정수값을 가지는 기본키 에 사용될 수 있다
- 중간에 인덱스가 삭제되면 삭제된 인덱스는 점프해서 생성된다.


# 조인
- 컬럼대 컬럼(기본키와 외래키); 부모
1. (1) 크로스 조인 Cross Join( ) ⎼특별한 키워드 없이 테이블을 콤마로 연결해서 사용한다. 
2. (2) 이퀴 조인 Equi Join( ) ⎼동일 컬럼을 기준으로 조인한다. ⎼조인 조건이 정확히 일치하는 경우 사용하며 일반적으로 와 를 사용한다 PK FK . 
3. (3) 논 이퀴 조인 Non-Equi Join( ) ⎼동일 컬럼이 없이 다른 조건을 사용하여 조인한다. ⎼조인 조건이 정확히 일치하지 않은 경우 사용한다 등급 학점 등 .( , ) … 
4. (4) 셀프 조인 Self Join( ) ⎼한 테이블 내에서 조인한다. ⎼하나의 테이블에서 행들을 조인하고자 할 경우에 사용한다. 
5. (5) 아우터 조인 Outer Join( ) ⎼조인 조건에 만족하지 않는 행도 나타낸다. ⎼조인 조건이 정확히 일치하지 않는 경우에도 모든 행들을 출력한다.

## 조인과 서브쿼리 차이
- 조인은 컬럼대 컬럼 대상, 서브쿼리는 값대 값; 값을 통한 조인

# 서브쿼리
- in을 가장 많이 사용.

## in 과 any 차이
- in은 비교대상 필요 없고 any는 비교대상 필요
- any 연산자는 메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 하나 이상만 일치하면 참이다.
- exist: exists 연산자는 서브쿼리에서 적어도 개의 행을 리턴하면 논리식은 참이고 그렇지 않으면 거짓이 되는 연산자이다 1 . ⎼exists 연산자는 서브 쿼리의 결과값이 참이 나오기만 하면 바로 메인 쿼리의 결과값을 리턴한다.

## exist와 in 차이
- EXISTS는 단지 ROW가 존재하는지만 체크하고 더 이상 수행 되지 않으나, IN은 실제 존재하는 데이터들의 모든 값까지 확인한다. 따라서, EXISTS 연산자가 더 좋은 성능을 보이므로 가능하면 EXISTS를 사용하는 것이 바람직해 보인다. 
- 또 다른 한가지는, JOIN되는 COLUMN에 NULL을 갖는 ROW가 존재한다면 NOT EXISTS는 TRUE값을, NOT IN은 FALSE값이 리턴된다. 즉, NOT IN을 사용하면 조건에 맞는 데이터가 있다고 하더라도 NULL이 존재하면 "NO ROWS SELECTED"라고 나오게 된다. 따라서 NVL을 이용한 NULL 처리가 꼭 필요하다.



# 뷰
- 가상테이블; 한개의 테이블에서 한 개만 생성
- 용도: 자주 검색하는 항목; 보안되는 항목

# Group by
- GROUP BY 절은 집계 함수 없이도 사용 될 수 있다.(DISTINCT와 용도가 비슷해 짐)
- 집계함수를 사용하여 특정 그룹으로 구분 할 때는GROUP BY 절을 사용하며, 특정 그룹 구분없이 중복된 데이터를 제거할 경우에는 DISTINCT 절을 사용 하도록 하자

## 중복 제거하는 Group by와 Distinct
- -- DISTINCT를 사용한 중복 데이터 제거
- SELECT DISTINCT deptno FROM emp;
 
 
-- GROUP BY를 사용한 중복 데이터 제거
- SELECT deptno FROM emp GROUP BY deptno;



# Having
- HAVING 절
- WHERE 절에서는 집계함수를 사용 할 수 없다.
- HAVING 절은 집계함수를 가지고 조건비교를 할 때 사용한다.
- HAVING절은 GROUP BY절과 함께 사용이 된다.

## Having 예제
 * SELECT b.dname, COUNT(a.empno) "사원수"
 *   FROM emp a, dept b
 *  WHERE a.deptno = b.deptno
 *  GROUP BY dname
 * HAVING COUNT(a.empno) > 5;
 
# PL/SQL
- 스프링이나 다른 프레임워크에서 동적 쿼리를 제공하고 있어 잘 사용하지 않는다.
- ⎼데이터베이스 내의 데이터를 조작하기 위해서 오라클이 제공해 주는 SOL SOL 문을 사용했는데 의 장점은 쿼리문 하나로 원하는 데이터의 검색과 조작할 수 있다는 점이다. 
- ⎼SOL 자체는 비절차 언어이기에 몇 개의 쿼리문 사이에 어떠한 연결 및 절차성이 있어야 하는 경우에는 사용할 수 없는데 이 점을 극복하기 위해 오라클 사에서 SOL 언어에 절차적인 프로그래밍 언어를 가미해 만든 것이 PL/SQL . 이다 
- ⎼PL/SQL Oracle's Procedural Language extension to SQL . 은 의 약자이다 
- ⎼SOL ANSI PL/SQL 은 표준 언어로 어떤 제품군도 사용 가능하지만 은 오라클이 고유하게 제시하는 것으로 다른 제품군에서 사용할 수 없다. 
- ⎼PL/SQL C sql procedure language 은 언어와 유사한 문법을 사용하는 블록구조의 언어로 에 대한 의 확장이며 컴파일한 후 결과를 실행한다. 
- ⎼PL/SQL , function, package ansi-sql data sql data type . 은 프로시저 등을 만들 때 사용하며 조작명령과 을 지원한다 
- ⎼PL/SQL sql , , (if), (loop, while, 은 구문을 지원하는 것 이외에도 프로시저와 함수선언 변수정의 조건처리 반복처리 for) . 등을 지원한다 
- ⎼PL/SQL . 은 변수 선언과 같은 표준 프로그래밍 구조를 제공한다
 
## 코드
- set serveroutput on; ⎼오라클의 환경 변수 serveroutput은 오라클에서 제공해 주는 프로시저를 사용하여 출 력해 주는 내용을 화면에 보여주도록 설정하는 환경 변수이다.
 
## 특징
- ⎼변수, SQL . 상수 등을 선언하여 과 절차형 언어에서 사용한다 
- ⎼if . 문을 사용하여 조건에 따라 문장들을 분기한다 ⎼loop . 문을 사용하여 일련의 문장을 반복적으로 실행한다 
- ⎼커서를 사용하여 여러 행을 검색하며 커서의 종류를 다음과 같다. 
- ① 암시적 커서 : DML PL/SQL 모든 과 의 select 절에 대해서 선언된다. 
- ② 명시적 커서 : 프로그래머에 의해 선언되며 이름이 있는 커서다

## declare
### 변수
- 스칼라
- 참조: 변수명; 참조변수명 %type
	변수명: 테이블명 %rowtype
 
# 저장 프로시저
- 메소드의 역할



# 바인드 변수
- 프로시저 안에 동작되고 나중에 출력으로 사용
- 외부 접근
- print
- 외부로 출력이 가능한 변수

# 커서
-  - SQL 커서는 Oracle 서버에서 할당한 전용 메모리 영역에 대한 포인터이다.
 - 질의의 결과로 얻어진 여러 행이 저장된 메모리상의 위치.
 - 커서는 SELECT 문의 결과 집합을 처리하는데 사용된다.
- 오라클 DB에서 실행되는 모든 SQL문장은 암시적인 커서가 생성되며, 커서 속성을 사용 할 수 있다.
 - 모든 DML과 PL/SQL SELECT문에 대해 선언됨
 - 암시적인 커서는 오라클이나 PL/SQL실행 메커니즘에 의해 처리되는 SQL문장이 처리되는 곳에 대한 익명의 주소이다.
 - Oracle 서버에서 SQL문을 처리하기 위해 내부적으로 생성하고 관리한다.
 - 암시적 커서는 SQL 문이 실행되는 순간 자동으로 OPEN과 CLOSE를 실행 한다.
 - SQL 커서 속성을 사용하면 SQL문의 결과를 테스트할 수 있다.

## 형식
 * DECLARE
 * 	CURSOR [커서이름] IS [SELECT 구문];
 * BEGIN
 * 	OPEN [커서이름];
 * 	FETCH [커서이름] INTO [로컬변수];
 * 	CLOSE [커서이름];
 * END;


## OPEN(커서열기)
 - OPEN문을 사용하여 커서를 연다.
 - 커서안의 검색이 실행되며 아무런 데이터행을 추출하지 못해도 에러가 발생하지 않는다
 
## FETCH(커서패치)
 - 현재 데이터 행을 OUTPUT변수에 반환한다
 - 커서의 SELECT문의 컬럼의 수와 OUTPUT변수의 수가 동일해야 한다 
 - 커서 컬럼의 변수타입과 OUTPUT변수의 데이터 타입도 역시 동일해야 한다
 - 커서는 한 라인씩 데이터를 FETCH한다
 - 문법 : FETCH cursor_name INTO variable1, variable2;
 
## CLOSE(커서닫기)
 - 사용을 마친 커서는 반드시 닫아주어야 한다
 - 필요시 커서를 다시 열 수 있다
 - 커서를 닫은 상태에서 FETCH는 불가능하다
 - 문법 : CLOSE cursor_name;



# 커서와 패치
- 대용량 데이터베이스에서 사용.


# 트리거
- 대용량 데이터베이스에서 위험성 때문에 사용하지 않는다.
- 테이블에 대한 이벤트에 반응하여 자동으로 실행되는 작업을 말합니다. 여기서 이벤트는 특정 행이나 속성 전체에 INSERT, UPDATE, DELETE 가 발생할 때는 말합니다.



# 모드
- 자신 언어에서 실행되지 않고 외부에 의해서 실행을 의존한다.


# in
- 매개변수를 통해서 프로시저로 전달하는 값

# out
- 매개변수를 통해서 외부로 전달하는 값	

# inout
- . inout 키워드 ⎼inout 키워드는 두 가지 목적에 모두 사용된다. 

# 스크립트 실행
- 인터프리터 방식으로 한줄씩 실행해서 결과를 바로 보여줌.

# on
## 프로시저 결과를 화면에 출력하고 싶을 때
- 프로시저 결과를 화면에 출력하고 싶을때 사용


- SQL> show serveroutput
- serveroutput OFF
- SQL> set serveroutput on

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


# NoSQL의 장점
- RDBMS는 데이터 일관성과 중복 최소화를 위해서 schema를 구성할 때, 여러 테이블로 나누어서 구성하는 것이 기본이다. 따라서 데이터들을 많은 수의 서버로 분산하여 나누는 data sharding을 RDBMS 자체에서 지원하는 것이 어렵다. 
보통 RDBMS에서는 서버의 수를 늘리는 확장(Scale Out)은 3-5대가 최대 수준이며, 서버를 더 대형으로 교체하는 확장(Scale Up)이 필요하게 된다. Scale up은 Scale Out에 비해서 비용과 서비스 중단 시간 측면에서 교체 부담이 훨씬 크다.
NoSQL은 RDBMS의 이런 단점을 극복하고 Scale Out이 잘 될 수 있도록 설계되었으므로 많은 서버로 확장하는 것이 가능하다.


2. 장점 
	1. NoSQL에서는 많은 서버로 확장(Sclae-out)이 가능하다.
	- NoSQL에서는 서버 확장성을 위해서 데이터 중복이 생기더라도 가급적 테이블들을 쪼개지 않고 하나의 큰 테이블(Big Table이라는 이름이 생긴 이유?)에 모두 담아서 저장한다. 그래서 한 테이블을 여러 서버에 나누어 저장하는 Sharding이 쉬워진다.
	좀 더 구체적으로 설명하면 NoSQL에서 주로 사용하는 데이터 모델은 key -> value 형태 즉 map 방식이다. 예를들어 user라는 테이블에서 user_id = 12를 key 값으로 가지는 데이터는 12 -> { james, man, 34, manager} 와 같이 저장된다. 이 때 value에 해당하는 { ... } 내에 들어가는 내용은 각 user별로 그 순서와 포맷이 달라도 된다. 사실 NoSQL은 value 내부의 포맷은 상세하게 관리하지 않고 RDBMS에 비해서 단순하게 처리하는 것이라고 할 수도 있다. 이렇게 구현하였기 때문에 오히려 key값에 따른 Sharding이 더 쉽게 된다.
	그런데, 개발자들은 value내에 원하는 대로 데이터를 저장할 수 있는 유연성에서 RDBMS에서 누리지 못하던 유연성을 덤으로 얻게 되었다. 특히 최근에 서비스 내용 업데이트 주기가 빨라지고 SNS처럼 다양한 데이터 유형을 다루는 서비스가 증가하면서 데이터 유연성이 더욱 장점으로 부각되게 되었다.
	2. 장점 2. NoSQL에서는 가변적인 구조로 데이터를 저장할 수 있다.

# NoSQL의 단점
- 앞에서 설명한대로 데이터 중복이 있고 포맷이 가변적인 커다란 table의 특징 때문에 NoSQL에서는 여러 테이블간의 Join이 불가능하다. 또 테이블 내의 어떤 값에 대해서 indexing 하는 것도 어렵다. 따라서 NoSQL에서의 데이터 쿼리는 Key값을 기준으로 value를 read하거나 write하는 단순한 방식이며, RDBMS 처럼 복잡한 쿼리는 불가능하다.
1. 단점 1. NoSQL에서는 다양하고 복잡한 데이터 쿼리는 불가능하다.
- NoSQL는 sharding 방식을 사용해서 큰 테이블을 여러 서버에 나누어 저장한다. 또 fault tolerancy를 위해서 데이터는 두 개 이상의 서버에 저장된다. 어떤 데이터의 값에 update가 발생한 경우, NoSQL는 중복 저장된 모든 서버들에 해당 업데이트가 다 될 때까지는 조금 시간이 걸린다.(서버가 아주 많을 수 있다는 점을 생각하자.)
- RDBMS에서는 최대 서버수가 기껏 3~5대이기 때문에 모든 서버를 업데이트되기 전까지는 해당 데이터 또는 table에 lock을 걸어서 읽기를 금지한다. 따라서 데이터를 읽어갈 때는 어떤 서버에서 읽더라도 항상 같은 값이 보장된다. 하지만 NoSQL에서는 lock을 하게될 경우 전체 속도가 너무 느려지게 되므로 RDBMS와 같은 lock을 하지 않는다. 따라서 NoSQL의 일부 서버에서는 아주 잠시 동안은 old data가 제공될 수 있다. 물론 시간이 좀 지나면 모든 서버는 결국 같은 값을 가지게 된다. (= Eventual consistency)
- 단점 2. NoSQL에서는 데이터 일관성이 항상 보장되지 않는다.



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


# 이클립스
## 프로젝트 생성
- static project: 자바와 연동 안하겠다.
- dynamic project: 자바와 연동

## META-INF
- DB관련 xml이 들어감

## WEB-INF
- 라이브러리 용;
- html, jsp 등의 파일은 실행하지 못한다; 404 오류 유발


# HTML
## !DOCTYPE
- ⎼DOCTYPE 요소는 태그가 아닌 현재 페이지가 어떤 버전의 마크업 언어로 작성되었는지를 웹 브라우저에 알려주는 부분이다. 
- ⎼DOCTYPE 요소가 없는 웹 문서는 웹 브라우저가 문서를 렌더링 할 기준이 없으므로 자체적으로 판단한 기준에 따라 문서를 표시한다. 
- ⎼DOCTYPE 요소가 없는 웹 문서는 명확한 기준이 없으므로 작성자가 의도한 것과 사용자가 바라보는 화면이 전혀 다를 수 있다. 
- ⎼모든 브라우저에 같은 화면을 표시하기 위하여 DOCTYPE 요소를 표시한다. 

# checkbox
- value 값 필요

# Radio button
- value 값 필요

# button
- 자바 스크립트와 연동하기 위해 사용

## onclick
- 함수


# form
- 데이터베이스와 연동
- 폼 안에 폼 사용 불가

## name
- form의 name은 자바스크립트로 연동할 때 사용
- 그리고 html을 만들때 가장 많이 사용하는 드림위버에서 input을 만들면 name속성만 지정된다. (따로 옵션설정이 가능한지 모르겠지만...) 그래서 드림위버에서 만든 html을 받으면 id속성이 하나도 없다. 하지만 둘다 주는게 더욱 좋다. 특별한 이유가 아니면 보통 id랑 name을 같은 이름으로 준다.



## autocomplete
- 크롤링 할 때 off 되어있으면 제한이 있음.
- off하면 보안성은 좋음.

## action
- 파라미터를 받을 페이지
- 전송방식: 메소드를 필요로 함.
- action = ‘#’ 하면 자기 자신 호출


## method
- http 프로토콜안의 메소드 사용
- get 메소드
- post 메소드
-  put 메소드
- delete 메소드

## enctype
- 파일 업로드를 구현하려면 enctype이 바뀌어야 한다.

## hidden
- 문서상에서 보이지 않고 서버 페이지(action)에서 재설정한다.

##  formenctype 속성 
- formenctype 속성은 서버에 전송 될 때 데이터를 전송하는 타입을 지정한다 
- ⎼위의 코드는 input 요소의 type 속성의 속성값에 submit 키워드와 value 속성의 속성값에 전송을 지정하여 전송 버튼에 전송이라는 글자를 설정하고 submit 키워드는 폼에 입력한 내용을 전송한다. 
⎼formenctype 속성으로 multipart/form-data 로 파일 업로드를 전송하는 타입을 지정하고 전송방식은 MIME 반드시 방식이어야 한다 post . 

# 서버 http 메시지
- 상태라인
- 헤더
- 바디
- 응답 메시지
- response

# 클라이언트 http 메시지
- 요청라인
- 헤더
- 일반 헤더
- 요청 헤더
- 엔티티 헤더
- 바디
- 요청 메시지
- request; 소멸객체
- 객체가 계속 새로 생성됨; 홈페이지 주소가 바뀌는게 아니라 request 새로운 객체가 생성되는 것
- 새로고침 하면 기존 request 사용

## get 방식
- 파라미터 가져올 때 사용
- 파라미터 양 적을때 사용
- 요청 라인 -> 상태 라인; 주소창에 ? 등 파라미터 보임; 보안에 약함 하지만 속도는 빠름

## post 방식
- 파라미터 가져올 때 사용
- 요청라인 -> 바디

## delete 방식
- 파일 가져올 때
- 요청라인 -> 바디

## put 방식
- 파일 가져올 때
- 요청라인 -> 바디


# 정규 표현식
- 파이썬 크롤링때 사용

## label
- 데이터의 안정성; 많은 데이터가 들어올 때 안전하게 해줌.
- label for 동일시 input name과 같이 해서 


