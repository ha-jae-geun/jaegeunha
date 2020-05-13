# 데이터 타입
1. 스칼라; 원시 타입; 내장되어 있는 타입; Built in; 한번에 하나의 값만 보유할 수 있는 원자량
2. 사용자 정의 데이터 타입
- - MySQL과 달리 오라클은 대용량 데이터 베이스라고 하는데, 대용량 데이터 타입(CLOB; 4GB까지 가능) 까지 가질 수 있다.
- 오라클은 ANSI에서 제공하는 모든 데이터 타입을 지원한다.

# as; 별칭;  select distinct job as 직종 from emp; // 한글 사이에 ‘ ‘ 사용하지 않는다.
- 별칭에 공백을 사용할 때는 “ “ 사이에 쓴다; select distinct job as "직 종" from emp;
- as는 1. 이름에 대한 충돌 방지
- select job 직급 from emp; // 생략 가능, 보안에 좋기 때문에


## 질의어
- 단일 질의어: 1개의 테이블
- 더블 질의어: 2개의 테이블 이상 통해서 질의(조인을 사용)



# 리터럴
- ⎼문자와 날짜 리터럴은 반드시 단일 따옴표(‘) . 를 사용하지만 숫자 상수는 단일 따옴표를 사용하지 않아도 된다 
- ⎼문자 리터럴의 경우에는 대소문자를 구별하며 검색시 대문자로 입력한 내용을 소문자로 검색하면 검색이 되지 않는다. ⎼오라클 데이터베이스는 세기, , , , , , 년 월 일 시 분 초를 나타내는 내부 숫자 형식으로 날짜를 저장하며 기본 날짜 표시 형식은 DD-MON-RR . 
- select empno, ename from emp where ename = 'FORD';



# between
- select column1, column2… from 테이블명… where column [not] between A and B;
- 이상과 이하일때만 사용; 초과 미만은 <> 사용

# null 의 값 
- ⎼데이터베이스에서 null . 은 매우 중요한 데이터이다 
- ⎼우선 오라클에서의 null 은 다음과 같이 데이터 검색시 컬럼의 값이 비어있는 형태로 보여 진다. 
- ⎼오라클은 컬럼에 기본적으로 null null . 값을 허용하며 제약조건을 이용해서 값을 허용하지 않을 수도 있다 
- ⎼주의할 점은 null null .

# Rownum
* 의사 칼럼으로 참조만 될 뿐 데이터베이스에 저장되지 않는다.
* DESC 명령으로 비이지 않는 의사 칼럼
* SELECT절에 의해 추출되는 데이터에 붙는 순번이다
* ROWNUM은 ORDERBY 전에 부여되며, ORDER BY는 맨 나중에 실행된다.
* ROWNUM을 변경하기 위해 DML을 사용할 수 없다.
* 주로 <, <=를 사용하며 반대 부등포는 동작하지 않는다.
* ROWNUM=1 은 사용 가능하지만 ROWNUM = 2는 동작하지 않는다. 



# ROWID
* 테이블의 레코드(행, row, record)를 유일하게 구별하는 행의 주소 값이다.
* 테이블에 행이 삽입되면 자동으로 생성된다.
* 테이블의 행을 액세스하기 위한 가장 빠른 방법으로 사용자 임의로 변경은 불가능 하며 10bytes로 구성된다.
* ROWID는 의사컬럼으로 db에 저장되지 않지만 select, where 절에 사용될 수 있고, insert, update, delete 등으로 변경할 수는 없다.
* 유일한 주소값이지만 테이블의 PK 처럼 사용될 수는 없다. 
* 삭제 후 다시 동일한 레코드를 입력한다고 했을 때 ROWID는 변경되며 레코드를 삭제했다면 삭제된 레코드의 ROWID는 나중에 입력되는 다른 레코드에 부여될 수 있따.

# 서브쿼리
- in을 가장 많이 사용.

## 서브쿼리 종류
1. select 절에 존재; scalar subquery
2. from절: inline view
3. where절: 중첩 서브쿼리

## 상관 서브쿼리
* 서브커리와 메인쿼리간에 서로 상관 참조하는 쿼리로, Inner Query에서 Outer query의 어떤 컬럼을 이용하는 경우다
* 일반적인 Query는 서브 쿼리의 결과를 메인에서는 단순히 이용만 하지만 상관 서브 쿼리에서는 서브 쿼리가 메인 쿼리의 값을 이용하여 값을 구하면 그 값을 다시 메인 쿼리에서 이용하는 구조이므로 서브쿼리는 ㄱ밧을 확인하는 확인자 역할을 하게 된다
 
## 스칼라 서브쿼리
* 하나의 단읽밧을 나타내기 위해 SELECT 구문을 SELECT LIST, WHERE절, ORDER BY절, DML 등에 사용하는 서브쿼리를 지칭한다.
* 데이터건수가 적을 경우 조인 방식보다 유리하며 유요한 수식이 사용될 수 있는 곳이라면 어디든 사용가능하며 반드시 하나의 결과만 되돌려야 한다.
* 만약 일치하는 데이터가 없다면 NULL을 리턴한다..
* 건수가 많지 않은 테이블과 조인해서 데이터를 추출하는 경우 불필요한 조인을 줄이기 위해 사용한다.


# with 구문
* 이름이 부여된 서브컬리 블록으로 global temporary tables, virtual table or an inline view 처럼 작동된다.
2. 복장된 SQL에서 동일 쿼리블록이 반족적으로 사용되는 경우 그 블록에 이름을 부여하여 한곳에서 정의하고 이름 재활용 하 수 있게 함으로 쿼리문 코딩강도 줄이고 성능도 향상시킬 수 있다.


# Self Join
* 자기자신 테이블과 조인을 하는 경우
* 같은 테이블을 두 번 사용하므로 테이블 별칭을 반드시 사용해야 한다.
* 특별한 경우로 ㅎ나 테이블의 외래키칼럼이 자기 자신 테이블의 주키를 참조하는 경우 이용하게 된다.
* emp 테이블의 MGR 칼럼은 외래키로서 자기자신 테이블 EMP의 EMPNO를 참조한다.


## 서브 쿼리 사용 말고 Self Join 사용할 때
```SQL
select e1.ename
from emp e1, emp e2
where e1.deptno = e2.deptno
and e2.eanme = 'Smith'
```


# on
## 프로시저 결과를 화면에 출력하고 싶을 때
- 프로시저 결과를 화면에 출력하고 싶을때 사용


- SQL> show serveroutput
- serveroutput OFF
- SQL> set serveroutput on

# exist
* 서브쿼리가 적어도 하나의 행을 돌려주면 True

# in 과 any 차이
- in은 비교대상 필요 없고 any는 비교대상 필요
- any 연산자는 메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 하나 이상만 일치하면 참이다.
- exist: exists 연산자는 서브쿼리에서 적어도 개의 행을 리턴하면 논리식은 참이고 그렇지 않으면 거짓이 되는 연산자이다 1 . ⎼exists 연산자는 서브 쿼리의 결과값이 참이 나오기만 하면 바로 메인 쿼리의 결과값을 리턴한다.

## exist와 in 차이
- EXISTS는 단지 ROW가 존재하는지만 체크하고 더 이상 수행 되지 않으나, IN은 실제 존재하는 데이터들의 모든 값까지 확인한다. 따라서, EXISTS 연산자가 더 좋은 성능을 보이므로 가능하면 EXISTS를 사용하는 것이 바람직해 보인다. 
- 또 다른 한가지는, JOIN되는 COLUMN에 NULL을 갖는 ROW가 존재한다면 NOT EXISTS는 TRUE값을, NOT IN은 FALSE값이 리턴된다. 즉, NOT IN을 사용하면 조건에 맞는 데이터가 있다고 하더라도 NULL이 존재하면 "NO ROWS SELECTED"라고 나오게 된다. 따라서 NVL을 이용한 NULL 처리가 꼭 필요하다.



# case-when
* 간단한 case-when은 decode로 대체 가능
```sql
decode(gender, 'boy', '남', 'girl', '여', '혼성')
```

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


# trim
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



# 조인
## 내부조인
* 내부조인은 테이블의 값이 일치하지 않는다면 해당 레코드는 출력되지 않는다.



# HINT
## result cache
* 쿼리 결과를 캐싱하라는 힌트이다.
* 조회 용도의 select되는 데이터 건이 많지 않고 값이 변하지 않는 데이터 즉 과거 매출 데이터 등의 집계/분석하는 쿼리에 RESULT CACHE 힌트를 사용하면 좋다.
* 고려할 점은 캐시할 데이터의 사이즈가 커서 result_cache_max_size, result_cache_max_result 파라미터 값을 넘어간다면 캐싱 기능을 사용할 수 없다
* DATA Dictionary 및 Temporary Table에 대한 쿼리 또는 시퀀스에 대한 CURVAL< NEXTVAL에 대한 쿼리는 캐시되지 않는다.



# Union과 Union ALl 차이
* Union은 합집합을 구했을 때 교집합이 되는 부분을 Distinct를 해서 하나의 row로 출력해주는 명령어
* Union All은 말 그대로 교집합 부분도 가감없이 모두 출력해주는 명령어

## Union All를 사용해야 할 때
* union은 Sort 연산을 발생시키는 명령어이기 때문에 굳이 중복값을 제고하지 않아도 되는 상황 PK 컬럼이 잉써서 row의 유니크함이 보장되는 상황일 떄는 Union ALl을 사용하는 것이 좋다.

## Union 처럼 sort 명령어를 사용하는 명령어
* 

