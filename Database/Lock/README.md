# LOCK
```JAVA
운영체제에서 잠금(Lock)과 유사하게 데이터베이스에서도 잠금(Lock)이 있다.

멀티 트랜잭션 환경에서 데이터베이스의 일관성과 무결성을 유지하려면 트랜잭션의 순차적 진행을 보장할 수 있는 직렬화 장치가 필요하다.

예를들어 한 명이 도서관의 좌석을 예약하는 중에 다른 한 명이 같은 좌석을 예약할 수 없게하여 정확히 한 명만 좌석을 배정받을 수 있게 한다.

이런 이유로 이런 기능을 하는 Lock 이라는 기술이 등장했다.

다양한 격리수준이 존재하고 그에 따른 lock들이 많이 있지만 크게 두 가지로 정리한다.

Exclusive lock (배타적 잠금)

쓰기 잠금(Write lock)이라고도 불린다.

어떤 트랜잭션에서 데이터를 변경하고자 할 때(ex . 쓰고자 할 때) 해당 트랜잭션이 완료될 때까지 
해당 테이블 혹은 레코드(row)를 다른 트랜잭션에서 읽거나 쓰지 못하게 하기 위해 Exclusive lock을 걸고 트랜잭션을 진행시키는  것이다.

=> exclusive lock에 걸리면 shared lock을 걸 수 없다. (shared lock은 아래에서 설명)

=> exclusive lock에 걸린 테이블,레코드등의 자원에 대해 다른 트랜잭션이 exclusive lock을 걸 수 없다.

Shared lock (공유 잠금)

읽기 잠금(Read lock)이라고도 불린다.

어떤 트랜잭션에서 데이터를 읽고자 할 때 다른 shared lock은 허용이 되지만 exclusive lock은 불가하다.

쉽게 말해 리소스를 다른 사용자가 동시에 읽을 수 있게 하되 변경은 불가하게 하는 것이다.

=> 어떤 자원에 shared lock이 동시에 여러개 적용될 수 있다.

=> 어떤 자원에 shared lock이 하나라도 걸려있으면 exclusive lock을 걸 수 없다.

* Lock은 DBMS가 자동으로도 적용하기도 하고 수동으로도 줄 수 있다.

* Lock은 잠금 비용과 동시성비용을 고려해야한다.

만약 lock을 걸어야할 페이지가 많다면, 그럴바에 테이블 전체에 lock을 걸어버리는 편이 한번에 처리하니까 
잠금 비용에 낮아져 효율적이다.

하지만 lock의 범위가 넓어질수록 동시에 접근할 수 없는 자원이 많아지므로 동시성 비용이 높아져 효율이 떨어진다.

* Lock이 엄청나게 다양하다.

row lock / table lock 부터 시작해서 그 안에 RX, RS, S, SRX, X등이 있다.

* 격리수준에 따라 Lock종류가 많아진다. 예를 들면 SQL select문에서 Shared lock을 걸지 않게하는 것도 있다.

SELECT * FROM TABLENAME WITH (READUNCOMMITTED) WHERE PK = 5



면접이나 테스트에서는 Exclusive lock과 shared lock에 대해서 확실히 알아갈 것.
```
