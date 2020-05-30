#  Sharding, Clustering, Replication
* 데이터 베이스를 여러개로 만든다.

#  Sharding
* 데이터가 너무 많아서 검색이 느린데 더 빠르게 할 수는 없을까? 테이블을 나너서 검색하자!
* 테이블을 ROW단위로 나눠서 분산 저장

## Sharding의 고민
* 분산된 데이터베이스에 데이터를 어떻게 잘 분산시켜서 저장할 것인가?
* 분산된 데이터베이스에서 데이터를 어떻게 읽을 것인가?

## Shard Key
* 나눠진 Shard 중 어떤 Shard를 선택할 지 결정하는 키
* Shard Key 결정 방식에 따라 Sharding 방법이 나뉜다.

### Hash Sharding
* 장점: Shard의 수만큼 해싱을 하면 되기 때문에 구현 방식이 간단하다
* 단점: Shard가 늘어나면 hash 함수가 달라져야 하기 때문에 기존의 데이터 정합성이 깨질 수 있다.(=확장성이 떨어진다.)
    * 단순히 키를 기준으로 나누기 때문에 공간에 대한 효율을 고려하지 않는다.

### Dynamic Sharding
* Locator service 테이블 형식의 구성요소를 가지고 shard키를 결정한다.
* 장점: Shard키가 추가 되더라도 Locator Service에 Shard 키만 추가하는 서비스만 필요
    * 확장에 유연하다
* 단점: 데이터를 재배치시 Locator Service도 동기화 해야 한다
    * Locator에 의존적이라 Loccator에 문제가 생기면 DB에도 문제가 생긴다.

### Entity Group
* 관계가 되어있는 Entity끼리 같은 Shard 내에 공유하도록 하는 것
* 장점: 단일 shard내에서 쿼리가 효율적이고 강한 응집도를 가진다.
* 단점: 다른 Shard의 Entity와 연관이 되는 경우 비효율적이다.

# Clustering
* 데잍터베이스가 죽을 것을 대비하여 서버를 여러개 만듬

## Active-Active 클러스터링
* 장점
    * 시스템 전체가 정지하는 것을 방지할 수 있다.
    * 서버의 개수가 늘어났기 때문에 CPU나 메모리를 많이 쓸 수 있다.
 * 단점
    * 스토리를 공유하는 경우 병목현상이 일어날 수 있다.
    * 비용이 비싸다

## Active-Standby 클러스터링
* 하나는 가동, 하나는 대기
* 장점: 비용이 저럼하다
* 단점: Active가 죽었을 때 전환시 시간이 오래 걸린다.

# Replication

## (단순 백업)
* 저장된 데이터가 손상될 경우를 대비하여 실제 데이터가 저장되는 저장소도 복제
* Master-Slave
  * 마스터 DB에서 CRUD 과정을 거치면 그 과정을 슬레이브 DB로 데이터 동기화

## 부하 분산
* 마스터는 INSERT, UPDATE, DELETE
* SLAVE를 백업 용도로만은 낭비이기 때문에 READ 용도로 남겨서 부하 분산(SELECT용)
