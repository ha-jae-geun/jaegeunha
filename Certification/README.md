# 알고리즘
## 시간복잡도
* 알고리즘의 소요 시간을 정량화하기 위해 알고리즘이 처리해야 할 연산의 수가 증가할 때 시간이 증가하는 대략적인 패턴을 수치화 한 것.


# 실무 워드
* As-Is 분석이 현재의 업무 프로세스를 분석하는 것을 의미한다면 To-Be 분석은 미래에 구현하고자 하는 업무 프로세스를 정의하는 분석이다.


# 최신경향
## 파밍; 파도
- 합법적으로 소유하고 있는 사용자의 도메인을 탈취하는 기술

## 스파이웨어
- 사용자의 컴퓨터의 설치되어 사용자의 개인 정보를 몰래 유출하는 소프트웨어

## 트로이 목마; 유용한
- 사용자들에게 유용한 프로그램인 것처럼 접근하여 뒤로는 다른 작업을 하는 악성코드

## 혹스
- 실제로는 악성 코드로서 행동은 하지 않으면서 겉으로는 악성코드인 것처럼 가장하여 행동하는 소프트웨어


## 드롭퍼; dropper
- 다른 악성 코드를 특정한 플랫폼에 떨어뜨리고 퍼뜨리는 데 사용되는 소프트웨어



## Webaholism; 웨바홀리즘
- 인터넷중독 혹은 사이버중독이라고도 하며, 일상생활에 지장을 느낄 정도로 지나치게 인터넷에 몰두하고 인터넷에 접속하지 않으면 불안감을 느끼는 등의 증상을 보이는 경우를 말한다.

## 스니핑
* 네트워크의 중간에서 남의 패킷 정보를 도청하는 해킹 유형의 하나로 수동적 공격에 해당한다.

## 살라미
* 기법은 장기간 보관하여 두고 조금씩 얇게 썰어서 먹는 이탈리아 소시지에서 따 온 말로, 많은 대상으로부터 눈치 채지 못할 만큼의 적은 금액이나 양을 빼내는 컴퓨터 사기 기법을 의미한다.

## 다크 데이터
* 수집된 후 저장은 되어 있지만 분석에 활용되지는 않는 다량의 데이터를 의미한다. ( 3 )는 향후 사용될 가능성이 있다는 이유로 삭제되지 않아 공간만 차지하고 있으며, 보안 위협을 초래하기도 한다.


## SDN
* )은(는) 네트워크를 컴퓨터처럼 모델링하여 여러 사용자가 각각의 소프트웨어 프로그램들로 네트워킹을 가상화 하여 제어하고 관리하는 네트워크이다. ( ) 기술은 네트워크 비용 및 복잡성을 해결할 수 있는 기술로 간주되어 기존 네트워킹 기술의 폐쇄형 하드웨어 및 소프트웨어 기술을 개방형으로 변화시키는 미래 인터넷 기술로 떠오르고 있다.

## 스턱스넷
* 2010년 6월에 발견된 웜 바이러스이다. 마이크로소프트 윈도를 통해 감염되어, 지멘스 산업의 소프트웨어 및 장비를 공격한다. 이 웜이 산업시설을 공격하는 최초의 악성 소프트웨어는 아니지만, 산업시설을 감시하고 파괴하는 악성 소프트웨어로는 최초이다.


## thin client
 CPU, 메모리 등 필수적인 하드웨어 장치만 탑재해 네트워크로 연결된 중앙서버에서 모든 업무를 관리하도록 설계된 업무용 PC를 일컫는다.


# 데이터베이스
 - select [distinct] { *, column|expression [alias] } ，… from 테이블명… [where 조건식] [order by 열 리스트[asc/desc]];
- insert into 테이블명 (column1, columnN) values( 1, N);
- update 테이블명 set column = 새로운 값 where 조건식;
- update dept set dname = '기획실’ where deptno = 50; select * from dept
- delete from 테이블명 where 조건식;
- delete from dept where deptno = 50; select * from dept
- create table 테이블명 ( column1 datatype primary key, column2 datatype [default 값], column3 datatype not null, columnN datatype );
	- references
- alter 테이블명 ( [add (column datatype);] [modify (column);] [add [constraint 제약조건이름] (column);] 제약조건 [drop (column);] )
	- alter table salesman add (sal number(7,2)); desc salesman;
- [drop table 테이블명;] [show recyclebin;] [flashback 테이블명 to before drop;] [purge recyclebin;]
	- drop table copy_board; select * from tab;
- rename 변경 전 테이블명… to 변경 후 테이블명…;
	- rename copy_board to copy_board2;
- truncate 테이블명…;
	- delete 절은 rollback이 가능하지만 truncate 절은 rollback . 이 불가능하다
- ② delete 절은 테이블의 데이터만 삭제되지만 truncate 절은 테이블의 데이터 및 저장구조가 삭제되므로 메모리를 효율적으로 관리 가능하다.
- ⎼모든 트랜잭션 작업이 성공하여 완료를 시켜주는 commit 키워드가 있고 모든 SQL문을 취소시키는 rollback 키워드가 있다. ⎼묵시적으로 트랜잭션을 종료시켜 주는 방법도 있는데 정전같은 비정상적인 방법으로 종료되면 자동으로 롤백으로 트랜잭션이 종료되며 정상적인 방법으로 종료하면 커밋으로 트랜잭션이 종료된다. ⎼트랜잭션내의 책갈피 기능을 하는 savepoint 키워드로 현재 트랜잭션 내에 저장 지점을 만든다. 
- rollback 명령문으로 모든 트랜잭션 작업을 취소시키며 실제적인 물리적 디스크에서 정보를 취소한다.

