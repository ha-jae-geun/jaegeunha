# 세미 조인
* 내부적으로 수행 원리에 의해서 나타나느 조인의 방식
* 주로 in이나 exists를 사용했을 때 실행계획에서 볼 수 있는 조인 구문

## 특징
1. 서브쿼리가 옵티마이저에 의해서 조인으로 풀린다
2. 조인으로 풀린 서브쿼리 집한은 후행처리가 된다
3. Outer 테이블에서 inner 테이블로 조인을 시도했을 때 하나의 로우가 조인에 성공을 하면 진행을 멈추고 Outer 테이블의 다음 로우를 처리하는 방식이다

## 서브 쿼리 집합이 선행처리가 되는 경우
* Hash Join Right
* Driving Semi Join

## 세미 조인 종류
* Nested Loop Semi Join
* Hash Semi Join
* Merge Semi Join

## 세미 조인 사용 안하는 힌트
* '*+NO_UNREST*/' 

## rownum<=1
* 세미 조인을 풀지 않게 함


# 내부조인
* 내부조인은 테이블의 값이 일치하지 않는다면 해당 레코드는 출력되지 않는다.


# 중첩 루프 조인
* 중첩 for문이라고 생각하면 된다; Outer Table에서 Inner Table로 원하는 그룹 찾는 것
  * Outer Table에서 소녀시대 맴버를 찾으러 inner table에서 맴버 찾고, Outer table에서 21 멤버찾으러 Innertable가고
  * inner table에서 조인 컬럼이 인덱스가 걸려있지 않으면 비효율이적이다.
  * 건건이 데이터를 찾기 때문에 대량 데이터를 찾는데는 적절하지 않고 OLTP성 환경에 적절하다
  * 1:M이라고 할 때 1에 해당하는 테이블이 Outer table이 되는게 유리하다.
* 일반적으로 조인조건에 '=' 연산자가 사용될 경우 옵티마이저는 NLJ를 선택하게 된다.
* 해시조인과 중첩루프조인은 조인시 발생하는 랜덤엑세스에 대한 부하가 없는 조인방식이다.
* 중첩 조인을 사용하기에 inner table에 적절한 인덱스가 없을 때 사용

## 특징
```java
첫 번째 로우를 받는 시간은 빠르지만, 전체 결과를 받기까지는 시간이 걸린다.
NLJ는 메모리가 필요 없는 조인 방법으로 추가적인 메모리 비용이 들지 않는다.
어떤 테이블을 드라이빙 테이블로 선택하느냐가 중요하다. 전체적인 성능은 드라이빙 테이블에 
있는 데이터가 몇 건인지가 관건이 되며, 드라이빙 테이블의 크기가 전체 쿼리를 수행함에 큰 영향을 미친다.
NLJ 방식은 대부분 InnER 테이블 검색시 인덱스를 사용해서 검색이 수행되므로 Inner 테이블의 
인덱스 효율이 좋아야 한다. 또한 드라이빙 테이블 검색 시에는 Full Table Scan 이나 Index Scan 방식을 사용한다.
적은 수의 로우를 검색하는 경우 NLJ를 사용한다.
일반적으로 조인조건에 '=' 연산자가 사용될 경우 옵티마이저는 NLJ를 선택하게 된다.
```

## 예제
```JAVA
한 집합의 원소 값을 다른 집합의 원소 값과 매칭해 나가는 방법

(가능한 모든 경우를 조회하여 결과 집합을 찾는 방법)

 

성능을 높이기 위한 방법

  가) 후행테이블의 크기가 작을수록

  나) 요소들의 비교가 빠르게 이루어 지도록 인덱스가 미리 설정되어 있어야 한다.

 

* 선행테이블(Driving Table) : 찾는 주체가 되는 테이블

* 후행테이블(Driven Table) : 비교 대상이 되는 테이블

 

▷ 예제

 --Nested-Loop Join

SELECT *

FROM pubs.dbo.employee e inner loop join pubs.dbo.jobs j

on e.job_id = j.job_id

 

[쿼리 분석기에서 Ctrl+L 을 눌러 실행계획을 실행]



옵티마이저는 통계를 기반으로 로우의 크기가 작은 쪽을 후행테이블로 선택한다. 
여기서 선행 테이블(Driving Table)은 Employee 테이블이다. 선행 테이블 Employee 를 
기준으로 Nested Loop 해서 Jobs 테이블을 조인한다.

쿼리 분석기의 실행계획에서는 선행테이블의 선이 굵게 나타난다. Nested Loop 조인은 
가장 기본적인 조인 전략으로 데이터 량이 적은 경우에는 이보다 확실한 방법이 없다.
```

## HINTS FOR JOIN ORDERS(ORDERED)
* ORDERED 힌트는 FROM 뒤에 기술되는 테이블이 순서대로 조인이 일어나도록 해주는 구문이며, 대부분 단독으로 사용되지 않고 USE_NL(중첩 루프 조인을 유도), USE_MERGE(머지 소트 조인을 유도), USE(HASH 등과 같이 사요된다.
* USE_NL/USE_MMERGE/USE_HASH 등의 인자로 사용되는 테이블은 FROM 절에서 두 번째로 나타나는 테이블 이어야 하는데, FROM절에 처음 나타나는 테이블이 드라이빙 테이블이 되고 나중에 나타나는 테이블이 PROBED TABLE(INNER TABLE)이 된다.

# HASH 
* 배치에서 쓰면 좋다, 대용량 테이블을 Join할 떄 사용하면 좋다
  * 해시 영역에 들어가는 키값의 중복이 없을수록 유용하고 해새 영역에 들어가는 데이터가 크면 PGA영역이 아니라 디스크 영역을 사용하게 되어 비효율적이다
* 해쉬 조인은 조인조건에 동증조건(=)이 사용되었을 때만 가능하다.
 * 두 테이블 중 작은 테이블을 메모리에 조인키를 기반으로 해시테이블을 생성하고 해시 테이블 내에 행들을 위치시키기 위해 해시 함수를 이용하며 나머지 테이블을 스캔하면서 메모리에 있는 해시테이블과 조인 조건을 만족하는 데이터를 찾는 조인이다.
 * 해시조인과 중첩루프조인은 조인시 발생하는 랜덤엑세스에 대한 부하가 없는 조인방식이다.
 * 관계형 데이터베이스에서 가장 비용이 많이 들어가는 조인방법으로 주로 작은 테이블과 큰테이블의 조인 시 사용되며, 드라이빙 조건과 상관없이 좋은 성능을 발휘할 수 있는 조인방법이며 대체로 제일 빠르다.
 * 해시 조인은 안티조인과 병ㄹ렬처리와 잘 맞으며 범위 검색이 아닌 동등비교(Where 절에서 등호로 비교하는 경우)에 적합하다. 한쪽 테이블이 Hash Area에 담길 정도로 충분히 작아야 하고 Build Input 해시 키 컬럼에 중복 값이 거의 없아야 한다. 
 * 해시테입르을 만드는 단계는 전체범위처리 불가피, Probe Inputㅇ르 스캔하는 단계는 NL 조인처럼 부분 범위 처리 가능하다.
 * 해시 테이블을 생성하는 비용이 수반됨으로 Build Input이 작을 때 효과적이며 PGA 내부 PRivate SQL Area의 Runtime-Area 내부 SqL Work Area에 할당되는 Hash Area에 담길 정도로 충분히 작아야 한다.
 ( 소트 머진 조인하기에는 두 테이블이 너무 ㅋ 소트 부하가 심할 때 유리하며 수행 빈도가 낮고 쿼리 수행 시간이 오래 걸리는 대용량 테이블을 조인할 때 좋으며 해시 테이블은 단 하나의 쿼리를 위해 생성하고 조인이 끝나면 곧바로 소멸하는 자료구조이다.
* /*+USE_HASH(TABLE[TABLE])*/
* /*+NO_USE_HASH(TABLE[TABLE])*/
```JAVA
해시를 사용하는 경우는 해당 조인 키가 전혀 정렬되어 잇지 않고, 인덱스도 존재하지 않으면서 비교해야 할 대상은 많은 때이다.


▷ 예제

 --Hash Join

SELECT *

FROM pubs.dbo.employee e inner hash join pubs.dbo.jobs j

on e.job_id = j.job_id

 

[쿼리 분석기에서 Ctrl+L 을 눌러 실행계획을 실행]
```
```JAVA
해시 조인(Hash-Join)은 두 테이블 중 하나를 기준으로 비트맵 해시 테이블을 메모리에 올린 후 
나머지 테이블을 스캔 하면서 해싱 테이블을 적용하여 메모리에 로딩된 테이블과 비교하여 매칭되는 
데이터를 추출하는 방식의 조인이다.
RDBMS에 서 비용이 가장 많이 들어가는 Join 방법으로 주로 작은 Table과 큰 Table 의 Join 시 사용되어 지며 , 
Driving 조건과 상관없이 좋은 성능을 발휘할 수 있다.


1. 작은 테이블(Build Input)을 읽어 Hash Area에 해시 테이블 생성한다.
(해시 함수에서 리턴 받은 버킷 주소로 찾아가 해시 체인에 엔트리를 연결)
2. 큰테이블 집합(Probe Input)을 읽어 해시 테이블을 탐색하면서 조인하는 방식이다.
(해시 함수에서 리턴 받은 버킷 주소로 찾아가 해시 체인을 스캔하면서 데이터를 찾는다)


[특징]

- 해시 조인은 안티 조인과 병렬처리와 잘 맞으며 범위 검색(Range scan)이 아닌 동등 비교(Equi-Join,
where절에서 등호로 비교하는 경우)에 더 적합하다.
- NL조인 과 달리 Random 액세스 부하가 없다.(단, 양쪽집합을 읽는 과정에서 인덱스를 이용한다면 Random 액세스 발생)
- NL조인 과 달리 Hash Area에 미리 생성해 둔 해시 테이블(또는 해시 맵)을 이용한다.
(해시테이블을 만드는 단계는 전체범위처리 불가피, Probe Input을 스캔하는 단계는 NL조인처럼 부분범위처리가능)
- 소트머지조인과 달리 조인 전에 미리 양쪽 집합을 정렬하는 부담이 없으며 NL조인 과 달리 래치획득 과정없이 
PGA에서 빠르게 데이터 탐색한다.
- 해시 테이블을 생성하는 비용이 수반됨으로 Build Input이 작을때 효과적이며 PGA(or SGA) 메모리에 할당되는
Hash Area에 담길 정도로 충분히 작아야 한다. 해시키 값으로 사용되는 컬럼에 중복값이 거의 없을 때 효과적이다.
- SQL 문장에서 옵티마이저는 해쉬 조인으로 수행하기 위해 작은 테이블을 메모리에 로드 한 후 큰 테이블을 
여러 Partition으로 분리하여 메모리에 로드가 되어 있는 작은 테이블을 해쉬 알고리즘에 의하여 탐색하게 되고
여러 Partition 으로 나뉘어 지는 테이블은 HASH_AREA_SIZE 에 명시된 메모리에 상주되며 메모리가 충분치 않아
메모리에 모두 상주 시킬수 있는 상황이라면 디스크에 위치하게 된다. (충분한 hash_area_size 제공필요)
- 해시조인을 사용하기 위해서는 USE_HASH hint를 사용 한다.


해시 조인 사용기준

- 기준
1. 한쪽 테이블이 Hash Area에 담길 정도로 충분히 작아야함.
2. Build Input 해시 키 컬럼에 중복 값이 거의 없어야 함.

- 조건
1. 조인 컬럼에 적당한 인덱스가 없어 NL조인이 비효율적일때
2. 조인 컬럼에 인덱스가 있더라고 NL 조인 드라이빙 집합에서 Inner 쪽 집합으로서의 조인 액세스량이 많아
Random 액세스 부하가 심할 때
3. 소트 머지 조인하기에는 두 테이블이 너무 커 소트 부하가 심할때
4. 수행빈도가 낮고 쿼리 수행 시간이 오래 걸리는 대용량 테이블을 조인할때

- 결과
1. 해시테이블은 단 하나의 쿼리를 위해 생성하고 조인이 끝나면 곧바로 소멸하는 자료구조이다.
2. 수행빈도가 낮고, 쿼리수행 시간이 오래 걸리는, 대용량테이블을 조인할 때
```

## 예외
* USE_HASH 인자는 비드라이빙(PROBE INPUT)이 오는데, 큰 테이블을 드라이빙하라고 하면 힌트를 무시한다.
* 이 때 강제로 해시조인이 걸리게 아려면 강압적인 힌트 ORDERED를 사용하면 된다.
* /* ordered_use_hash(d) */

# 정렬 병합 조인(SMJ)
* 중첩 조인을 사용하기에 inner table에 적절한 인덱스가 없을 때 사용
* 일반적으로 조인조건에 사용되는 연산자가 >, >=, <, <=와 같은 비동등 연산자가 사용될 경우 옵티마이저는 SMJ을 사용하게 된다.
* 두 테이블을 각각 정렬(Sort)한 다음 조인조건에 맞는 건을 찾아 합치는(merge) 방식의 조인 방법이다. SMJ 는 NLJ와 다르게 드라이빙 테이블이 존재하지 않고, 두 테이블 모두 독립적으로 동등한 레벨에 있다.

## 특징
```JAVA
첫 번째 로우를 받는 시간은 느리지만, 전체 로우가 반환되는 시간은 빠르다. 
(두 테이블의 데이터를 각각 정렬 후 병합하므로, 정렬작업이 끝날 때까지는 어떤 로우도 반환되지 않기 때문)
정렬 작업을 위해 추가적인 메모리를 사용한다. 정렬 작업을 수행하면서 일정 값 이상의
메모리를 사용하게 되면 TEMP 테이블스페이스를 사용하게 되므로 디스크 I/O가 발생하게 된다. 
(SORT_AREA_SIZE 파라미터에 명시된 값 사용)
NLJ 보다는 많은 양의 데이터를 처리할 때 유리하며,메모리만 사용해서 정렬 작업을 수행한다면 
넓은 범위의 값을 검색하는데 유용한다.
두 테이블의 데이터를 각각 정렬하는 작업이 전체 성능에 영향을 많이 끼치게 된다. 따라서 
SELECT 리스트에서 불필요한 컬럼은 제거해서 부하를 적게 해줘야 한다.
일반적으로 조인조건에 사용되는 연산자가 >, >=, <, <=와 같은 비동등 연산자가 사용될 경우 옵티마이저는 SMJ을 사용하게 된다.
```

## 예제
```JAVA
한집합과 다른 집합을 합하기 위해서 양쪽 다 정렬이 되어 이썽야만 비교 가능하다. 
그리고 Sort Merge의 경우 대등하게 합병되기 때문에 선행 또는 후행 테이블이 존재하지 않는다.

 

▷ 예제

 --Sort Merge Join

SELECT *

FROM pubs.dbo.employee e inner merge join pubs.dbo.jobs j

on e.job_id = j.job_id

 

[쿼리 분석기에서 Ctrl+L 을 눌러 실행계획을 실행]
```

# PGA 영역
* SMJ의 Sort Area나 Hash 영역은 PGA에 위치한다, 그래서 처리 속도가 매우 빠르다
* [PGA](https://github.com/ha-jae-geun/jaegeunha/blob/master/Database/Oracle/PGA/README.md)
```java
오라클이 사용하는 메모리는 크게 두 가지가 존재한다.

SGA(System Global Area) - 모든 사용자가 공유 가능하여 사용
PGA(Program Global Area) - 사용자마다 공유하지 않고 개별적으로 사용
위와 같이 두 가지 종류의 메모리가 존재하며 각각의 특징을 확인해 보자.



출처: https://1duffy.tistory.com/18 [밀림속의 동물원]
```


# OLTP성 환경
* [OLTP](https://github.com/ha-jae-geun/jaegeunha/blob/master/Database/OLTP/README.md)


# 리모트 조인

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

# 드라이빙 테이블
```JAVA
TABLE에 대한 JOIN시 먼저 ACCESS되서 ACCESS PATH를 주도하는

TABLE을 DRIVING TABLE이라 한다.

DRIVING TABLE로 결정되는 것은 INDEX의 존재 및 우선순위 혹은

FROM절에서의 TABLE지정순서에 영향을 받으며 어느 TABLE이 먼저

ACCESS되느냐에 따라 속도의 차이가 크게 날 수 있으므로 매우

중요하다. 기본적으로 대상 TABLE의 행 중 작업대상이 되는 행의 수 가

적은 쪽이 먼저 ACCESS되어야 전체 일 양이 줄어든다. Driving table의

결정 규칙은 다음과 같다.



. JOIN 되는 컬럼의 한쪽에만 INDEX가 있는 경우는 INDEX가 지정된

TABLE이 DRIVING TABLE이 된다.



WHERE emp.deptno = dept.deptno 문장에서 dept.deptno에 index가 있는

경우는 Dept 테이블이드라이빙 테이블이 된다.

WHERE emp.deptno = dept.deptno 문장에서 emp.deptno에 index가 있는

경우는 Emp 테이블이 드라이빙 테이블이 된다.



WHERE emp.deptno = dept.deptno

AND emp.empno=7788

AND loc like 'Ca%'



deptno, empno컬럼이 조합해서 인덱스 . loc와 deptno컬럼이 조합해서

인덱스가 이루어져 있는경우 Dept 테이블이 드라이빙 테이블이 되고

만일 인덱스가 empno와deptno컬럼이 조합해서 인덱스,

deptno와loc컬럼이 조합해서 인덱스로 구성되어 있으면 Emp 테이블이

드라이빙 테이블이 된다..조건절에 두 테이블 조인 조건외에 다른 비교

조건이 지정된 경우 INDEX의 우선순위에 따라 먼저 수행된는 테이블이

드라이빙 테이블이 된다.



WHERE emp.deptno = dept.deptno

AND emp.empno = 1166

AND dept.loc like 'da%'

emp.deptno, dept.deptno, empno,loc에 인덱스가 있는 경우는 empno와

loc중 우선순위가 높은 empno 인덱스를 먼저 사용하여 검색한다. 만일

이때 loc 라는 인덱스를 사용하고 싶으면 emp.empno=1166을

rtrim(empno)=1166 로 바꾸어 사용하면 empno의 인덱스 사용을 억제할수

있다.



더욱 이해를 돕기위해 다음의 예를 살펴보자.

DEPT.DEPTNO 컬럼에 Unique 인덱스

LOC 컬럼에 Unique 인덱스

EMP.JOB 과 EMP.ENAME 컬럼을 조합한 Unique Index

EMP.DEPTNO 에 인덱스 가 있다고 가정하자



WHERE d.deptno = e.deptno AND job='PRESIDENT'

AND ename='KING' AND loc='NEW YORK'

AND dname='ACCOUNTING' 의 문장 수행을 위한 내부적인 수행은 다음과 같다.



만일 DEPT 테이블이 드라이빙 테이블이라면

loc='NEW YORK'

dname = 'ACCOUNTING'



만일 EMP 테이블이 드라이빙 테이블이라면

job= 'PRESIDENT'

ename =' KING' 이다.



즉 DEPT 테이블이 unique 인덱스 를 사용하고 EMP 테이블은 컬럼이

조합된 unique 인덱스를 사용하므로 우선순위가 높은 DEPT 테이블이

DRIVING TABLE이 된다.
```


# Union과 Union ALl 차이
* Union은 합집합을 구했을 때 교집합이 되는 부분을 Distinct를 해서 하나의 row로 출력해주는 명령어
* Union All은 말 그대로 교집합 부분도 가감없이 모두 출력해주는 명령어

## Union All를 사용해야 할 때
* union은 Sort 연산을 발생시키는 명령어이기 때문에 굳이 중복값을 제고하지 않아도 되는 상황 PK 컬럼이 잉써서 row의 유니크함이 보장되는 상황일 떄는 Union ALl을 사용하는 것이 좋다.

## Union 처럼 sort 명령어를 사용하는 명령어


