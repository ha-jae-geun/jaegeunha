# 데이터 베이스
- 한 조직의 여러 응용 시스템들이 공동으로 사용하기 ( ) 공유하기 위해 통합하고 저장한 데이터들로써 중복을 최소화하 여 컴퓨터 기억 장치에 모아 놓은 집합체이다.
- DBMS(사용자와 데이터 베이스를 연결시켜 주는 소프트 웨어) + 데이터베이스(데이터를 모아둔 토대) + 데이터 모델(데이터가 저장되는 기법에 관련된 내용ㅇ



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


### RDBMS . 는 주요 소프트웨어는 다음과 같다 
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



# 트랜잭션
- ⎼오라클에서 발생하는 여러 개의 SQL . 문들을 하나의 논리적인 작업단위로 처리하는데 이를 트랜잭션이라고 한다 
- 트랜잭션의 결과는 반드시 모두 성공하거나 모두 실패 하거나 둘 중 하나이므로 반드시 명시적으로 종료를 시켜주어야 된다


## ACID
- 1. 트랜잭션 : 데이터베이스 처리의 기본 단위. 
- Atomicity : 모두 수행되거나 모두 수행되지 않는다.
- Consistency: 트랜잭션 수행 후에는 데이터의 일관성을 보장한다.
- Isolation : 트랜잭션은 서로 독립적이다. 여러 트랜잭션이 수행되도 영향을 주지 않음.
- Durability : 트랜잭션이 완료되면 데이터는 지속된다.



## 트랜잭션의 특징
- 첫번째로, 원자성은 트랜잭션이 데이터베이스에 모두 반영되던가, 아니면 전혀 반영되지 않아야 한다는 것이다.  트랜잭션은 사람이 설계한 논리적인 작업 단위로서, 일처리는 작업단위 별로 이루어 져야 사람이 다루는데 무리가 없다. 만약 트랜잭션 단위로 데이터가 처리되지 않는다면, 설계한 사람은 데이터 처리 시스템을 이해하기 힘들 뿐만 아니라, 오작동 했을시 원인을 찾기가 매우 힘들어질것이다.
-  두번째로, 일관성은 트랜잭션의 작업 처리 결과가 항상 일관성이 있어야 한다는 것이다.  트랜잭션이 진행되는 동안에 데이터베이스가 변경 되더라도 업데이트된 데이터베이스로 트랜잭션이 진행되는것이 아니라, 처음에 트랜잭션을 진행 하기 위해 참조한 데이터베이스로 진행된다. 이렇게 함으로써 각 사용자는 일관성 있는 데이터를 볼 수 있는 것이다.
-  세번째로, 독립성은 둘 이상의 트랜잭션이 동시에 병행 실행되고 있을 경우에 어느 하나의 트랜잭션이라도 다른 트랜잭션의 연산을 끼어들 수 없다.   하나의 특정 트랜잭션이 완료될때까지, 다른 트랜잭션이 특정 트랜잭션의 결과를 참조할 수 없다.
-  네번째로, 지속성은 트랜잭션이 성공적으로 완료됬을 경우, 결과는 영구적으로 반영되어야 한다는 점이다.


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

## RDBMS
- 2차원 표 형태로 데이터를 관리하는 데이터베이스로서, 친근한 구조로 인해 사람에게 자연스럽고 직관적인 이해를 할 수 있는 특징이 있습니다. 또한 프로그래밍 언어를 몰라도 데이터를 쉽게 조작할 수 있도록 설계된 언어인 SQL을 통하여 데이터 조작을 할 수 있어 편리하단 장점이 있습니다. 하지만 데이터의 일관성을 엄격히 준수하고 중복을 최소화하는 특징에 의해 속도가 비교적 느리고, 유연성이 낮습니다. 따라서 데이터를 수많은 서버에 분산 저장하는 data sharding이 어려워 서버 확장이 힘들다는 단점이 있습니다.

## NoSQL
- 빅데이터에서 쏟아져 나오는 방대한 양의 비정형 데이터를 처리하기 위해 설계된 데이터베이스로서 기존의 RDB는 정형화된 데이터만 처리할 수 있는 문제 때문에 빅데이터 환경에서 이를 대처하기 위해 사용되었습니다. 데이터의 일관성을 보장하지 않는 대신 빠른 속도를 가지고, schema-less 구조이기에 유연성이 높습니다. 데이터의 중복을 허용하는 구조때문에 scale out 방식 중 하나인 sharding 적용이 쉬워 서버 확장이 쉽다는 특징을 가집니다. 하지만 결국 데이터 손실 위험을 있고, 복잡한 join이 어렵다는 단점이 있습니다.


# index
## Index 개념, 쓰는 이유와 장단점
- 테이블의 읽기속도를 높이기 위해 사용되는 자료구조로서 테이블의 컬럼 인덱스를 설정하여 검색시 full scan이 아닌 index 파일 검색으로 검색속도를 빠르게 합니다.

## 장점
- 테이블 검색과 정렬 속도를 향상시킵니다. 또한 index를 기본키로 자동설정하여 관리가 편합니다.

## 단점
- 인덱스 파일을 별도로 만들어야함으로 파일의 크기가 늘어나고 인덱스를 처음에 생성하는데 시간이 많이 소요될 수 있습니다. 또한 인덱스된 컬럼값이 변경되거나 인덱스를 업데이트해야하기에 성능이 떨어지게 됩니다.

## 인덱스를 사용해야 될 때
- 위와 같은 단점에 따라 변경이 잦은 컬럼에는 인덱싱을 피하고, true/false 값을 같는 컬럼처럼 중복도가 높은 컬럼은 인덱스로 만들어도 고유성이 없기에 효용이 없습니다. where절과 join, order by 등에 자주 사용되는 컬럼의 경우 인덱스로 선정하면 검색 속도를 효과적으로 높일 수 있습니다.

## 인덱스 구조
- 검색의 효율을 높이기 위해 B-tree 또는 B+tree 구조를 사용합니다.

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


