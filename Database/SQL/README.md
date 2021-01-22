# SQL; Structured Query Language
- 언어라기보다는 수학적 기호를 언어로 표시한 것.
```java
▷ 개체 무결성 제약조건(Entity Integrity Constraint)
릴레이션의 기본 키를 구성하는 어떤 애트리뷰트도 널(NULL)값
을 가질 수 없고 튜플을 유일하게 식별해야 한다.
▷ 도메인 무결성 제약조건(Domain Constraint)
각 애트리뷰트 값이 반드시 원자값이어야 하며, 허용된 유형의
데이터 값들만 입력이 가능하다.
▷ 참조 무결성 제약조건(Referential Integrity Constraint)
두 개의 릴레이션이 기본키·외래키를 통해 참조 관계를 형성할
경우, 참조하는 외래키의 값은 참조되는 릴레이션에 기본키로 존
재해야 한다.
▷ 키 제약조건(Key Constraint)
애트리뷰트에 중복된 값이 존재해서는 안 된다.
▷ 사용자 정의 무결성 제약조건(user define integrity constraint)
사용자가 다른 무결성 범주에 포함되지 않는 특정 업무 규칙을
정의하여 사용한다.


문 3. 직원 테이블 emp 의 모든 레코드를 근무연수
wyear 에 대해서는 내림차순으로, 동일 근무연수에 대
해서는 나이 age 의 오름차순으로 정렬한 결과를 얻기
위한 SQL 질의문은?
1 SELECT * FROM emp ORDER BY age, wyear DESC;
2 SELECT * FROM emp ORDER BY age ASC, wyear;
3 SELECT * FROM emp ORDER BY wyear DESC, age;
4 SELECT * FROM emp ORDER BY wyear, age ASC;

답 3
3 오름차순을 설정할 때는 ASC, 내림차순을 설정할 때는 DESC를
사용한다. 설정을 하지 않을 때 기본값은 오름차순이다.


관계형 데이터베이스의 표준 질의어인 SQL(Structured Query Language)에서 CREATE TABLE문에 대한 설명으로 옳지 않은 것은? 4번
① CREATE TABLE문은 테이블 이름을 기술하며 해당 테이블에 속하는 칼럼에 대해서 칼럼이름과 데이터타입을 명시한다.
② PRIMARY KEY절에서는 기본키 속성을 지정한다.
③ FOREIGN KEY절에서는 참조하고 있는 행이 삭제되거나 변경될 때의 옵션으로 NO ACTION, CASCADE, SET NULL, SET DEFAULT 등을 사용할 수 있다.
④ CHECK절은 무결성 제약 조건으로 반드시 UPDATE 키워드와 함께 사용한다.

∙ CHECK절에는 조건식이 들어가야 합니다.


문 14. 관계 데이터베이스 스키마 STUDENT( SNO, NAME, AGE )에
대하여 다음과 같은 SQL 질의 문장을 사용한다고 할 때,
이 SQL 문장과 동일한 의미의 관계대수식은? (단, STUDENT
스키마에서 밑줄 친 속성은 기본키 속성을, 관계대수식에서
사용하는 관계대수 연산자 기호 는 프로젝트 연산자를, 는
셀렉트 연산자를 나타낸다) 2


<SQL 질의문>

SELECT SNO, NAME
FROM STUDENT
WHERE AGE > 20;

1 SNONAME
AGE STUDENT

2 SNONAME
AGE STUDENT

3 AGE SNONAME
STUDENT

4 AGE SNONAME
STUDENT

[해설]
- 셀렉트(SELECT, σ) : 선택 조건을 만족하는 릴레이션의 수평적 부분
집합(horizontal subset), 행의 집합
표기 형식 → σ<선택조건> (테이블 이름)
- 프로젝트(PROJECT, π) : 수직적 부분 집합(vertical subset), 열
(column)의 집합
표기 형식 → π<속성 리스트> (테이블 이름)
```

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




# rownum
* 변경하기 위해 DML을 사용할 수 없다
* order by 전에 부여되며 order by 는 맨 나중에 실행된다
* rownumb = 1은 사용 가능하지만 1도다 큰 수는 데이터가 추출되지 않는다.(도달할 수 없는 값)

# rowid
* 인덱스의 핵심 중 하나는 ROWID다. ROWID는 데이터베이스 내 데이터 공유의 주소로, 이를 통해 데이터에 접근할 수 있어 DBA라면 반드시 이해해야 할 개념이다.
* select where 전에 사용될 수 있고 insert, update, delete 로 변경할 수는 없다.
* 유일한 주소값이지만 테이블의 PK처럼 사용할 수 없다
* 삭제 후 다시 동일한 레코드를 입력한다고 행쓸 때 rowid는 변경되며 레코드를 삭제했다면 삭제된 레코드의 rowid는 나중에 입력되는 다른 코드에 부여도리 ㅅ 있다.













