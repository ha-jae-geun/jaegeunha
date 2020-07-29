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




### RDBMS
- ① 오라클(Oracle) 
- ② MS-SQL 
- ③ MySQL 
- ④ 사이베이스(Sybase) 
- ⑤ 인포믹스(Infomix) 
- ⑥ DB2 ⎼RDBMS는 정형화된 데이터 항목들의 집합체로서 확장이 용이하다는 장점을 가지는데 처음 데이터베이스를 만든 후 관련되는 응용 프로그램들을 변경하지 않고도 새로운 데이터 항목을 데이터베이스에 추가할 수 있다. 
- RDBMS 2 (column) (record) 는 차원 테이블 구조로 데이터를 관리하며 열을 컬럼 이라고 하고 행을 레코드 라고 한다. ⎼데이터의 중복 및 무결성을 보장하기 위해서 다양한 제약조건을 지정할 수 있다.
- SQLite: 파이썬도 지원


# [오라클 스토리지 구조](https://www.youtube.com/watch?v=Z-xgqtUJDes&list=PLyQR2NzLKOCbOYNJHKpCax4ija38yCqBN&index=12)
* Blcok < Extent < Segment < Tablespace
* block: 데이터가 저장되는 가장 작은 공간
	* Select 할 때 IO 해야 하는 가장 기본적인 단위다.
	* 테이블의 데이터들이 ROW 단위로 들어가있다. 테이블의 컬럼수가 많으면 적은 수의 ROW가 한 BLOCK에 들어간다.
	* 컬럼 하나를 SELECT 하든 모든 컬럼을 SELECT 하든 IO하는 블록읙 갯수는 동일하다.
	* 블록의 사이즈는 DB_BLOCK_SIZE 라는 파라미터로 지정을 할 수 있다.(2K, 4K, 8K 처럼 2의 N승으로 지정 가능)
* EXTENT: 데이터베이스가 공간을 할당하는 가장 작은 단위
	* 테이블에서 데이터를 쌓다고 공간이 부족해지면 데이터베이스에서 하나의 EXTENT를 할당해준다
	* 예를 들어 블록이 4K, EXTENT가 32K면 8개의 블록이 하나의 EXTENT를 이룬다.
* SEGEMENT는 OBJECT라고 생각하면 된다. OBJECT중에서 저장 공간을 사용을 하는 OBJECT다.1.8
	* VIEW와 SYNONYM 은 저장 구조를 갖지 않는 OBJECT이다.
	* SEGMENT는 저장 공간을 사용한다
	* HWM-High Water Mark
* TABLESPACE는 SEGMENT들을 담고있는 거대한 컨테이너다

## HWM-High Water Mark
* 쉽게 생각하면 책갈피이다. SEGMENT 내에서 내가 이 블록까지 쓴적 있어라고 표시해 두는 것
* FULL SCAN할 때 이 아래에 있는 블럭들을 스캔하는데 중간에 구멍이 뚫린 공간들이 많다면 비효율이 발생할 것이다.
	* FREE BLOCK들이 많이 발생헤 비효율이 발생하면 TRUNCATE 같은 명령어들로 HVM를 초기화시킬 수 있다.

## OBJECT
* SEGEMENT, TABLE, INDEX, VIEW, SYNONYM
* VIEW와 SYNONYM 은 저장 구조를 갖지 않는 OBJECT이다.

## MSSM( Manual Segment Space Management) 방식
* 오라클 9i 이전
* 공간에 대한 사이즈 할당을 수동으로 관리
* 세그먼트를 할당하고, 사용하고, 재사용하기 위해 FREELISTS, FREELIST GROUPS, PCTUSED 및 기타 다양한 파라미터를 수동으로 지정한다.

## ASSM(Automatic Segment Space Management) 방식
* 10g 이후
* 오라클에서 자동으로 알맞은 사이즈를 할당
* ASSM은 공간 할당을 지정하고, 고수준의 동시성을 제어하기 위해 수많은 파라미터 설정 튜닝 방안을 찾아야 하는 노력을 제거 하기 위해 오라클 9i 릴리즈 1에서 처음 소개되었다.
* 예를 들어 FREELISTS 파라미터가 디폴트 값인 1로 설정되어 있다면, INSERT/UPDATE가 집중적으로 발생하는 세그먼트에서는 FREE SPACE를 할당하기 위한 경합이 발생할 것이다.
* 오라클은 테이블에 한 로우를 INSERT하거나, 인덱스 키 엔트리를 UPDATE하거나, 로우 이전(row migration)을 일으키는 UPDATE를 진행할 때 해당 세그먼트의 프리블록 리스트로부터 추가 블록을 할당받을 필요가 있다.
* 오직 하나의 프리 블록 리스트만 존재한다면, 하나의 트랜잭션만이 리스트를 읽을 수 있고 수정할 수 있기 때문에 다른 트랜잭션은 기다려야만 한다.
* 이럴 때 여러 개의 FREELISTS와 FREELIST GROUPS를 구성하면 동시성을 증가시킬 수 있다.
* 트랜잭션은 각기 다른 리스트를 사용하기 때문에 서로 경합을 발생시키지 않게 될 것이다.
저장공간 설정 방법을 간단히 살펴보면서 수동과 자동 세그먼트에 대한 공간 관리 파라미터를 소개하겠지만, ASSM 세그먼트 방식일 때는 다음 파라미터만이 저장공간 및 세그먼트의 특성에 영향을 준다.
    * BUFFER_POOL

    * PCTFREE

    * INITRANS

    * MAXTRANS(9i에서만 사용됨. 10g 이상 버전에서는 모든 세그먼트에 무시된다.)
* 나머지 저장공간 유지 및 물리적 특징을 위한 파라미터들은 ASSM 세그먼트에는 적용되지 않는다.
* 세그먼트 공간 관리방법은 세그먼트가 속한 테이블스페이스의 파라미터로부터 결정된다.
* ASSM 세그먼트 방식을 위해서는 세그먼트가 ASSM 방식의 테이블스페이스에 존재해야 한다.
