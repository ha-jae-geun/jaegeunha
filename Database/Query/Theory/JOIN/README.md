# 내부조인
* 내부조인은 테이블의 값이 일치하지 않는다면 해당 레코드는 출력되지 않는다.


# 중첩 루프 조인

# HASH 


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


# Union과 Union ALl 차이
* Union은 합집합을 구했을 때 교집합이 되는 부분을 Distinct를 해서 하나의 row로 출력해주는 명령어
* Union All은 말 그대로 교집합 부분도 가감없이 모두 출력해주는 명령어

## Union All를 사용해야 할 때
* union은 Sort 연산을 발생시키는 명령어이기 때문에 굳이 중복값을 제고하지 않아도 되는 상황 PK 컬럼이 잉써서 row의 유니크함이 보장되는 상황일 떄는 Union ALl을 사용하는 것이 좋다.

## Union 처럼 sort 명령어를 사용하는 명령어
