# [Scale up/down, SPOF](https://www.youtube.com/watch?v=_sLjXviYivM&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=24)
# [Sharding](https://www.youtube.com/watch?v=js4y5VDknfA&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=20)

# Scale up(수직 스케일)
* 서버 자체를 증강시켜 처리 능력을 향상
* 장점
      * 구축 설계가 쉬움
      * 컨트롤러나 네트워크 인프라 비용은 별도로 발생하지 않는다.
* 단점
      * 스토리지 컨트롤러 확장성 한계
      * 용량, 성능 확장 제한
      * 비싸다
      * 트래픽 부하로 인한 장애 영향도 증가
* 주요 기술
      * 고성능 CPu
      * Memory 확장
      * SSD

## 사용
* 정합성 유지가 어려운 경우
* OLTP(온라인 트랜잭션 처리)
* 데이터베이스 서버



# Scale out = 수평 스케일
* 서버의 대수를 증가시켜 처리 능력 향상
* 장점
      * 지속적인 확장성 가능
      * 분산처리 -> 장애 가능성 낮아짐
      * Scale up보다 저렴하다
* 단점
      * 설계 구현의 복잡성
      * 관리 비용 증가
      * 기본적인 직렬화 존재
      * 기술적인 문제
      * 코어 개수와 성능이 비례
* 주요 기술
      * Sharding
      * In memory Cache
      * NoSQL

## 사용
* 높은 병렬성을 실현하기 쉬운 경우
* 정합성 유지가 쉬운 경우
* 메일 게시판 서버, 데이터 읽기 전용 어플리케이션, 웹 서버 등


# 정합성, 무결성
```java
정합성에 어긋난다 == 데이터가 일치하지 않는다(같은 성격?의 데이터를 다루는 테이블들 간에)
무결성이 어긋난다 == 말이 안되는 데이터가 들어있다(말이 안되는 값, 부모가 없는 자식 등등)
```

# SPOF(Single Point of Failure)
* 전체 시스템 중에 일부가 고장나면 전체 시스템이 중단
* 단일 장애점(고장점, 실패점)
* 예를 들어 라우터
* 예방하는 법
      * 복잡한 시스템인지 판별
      * 단일 장애점 파악 및 제거
      * 높은 신뢰성은 단일 컴포넌트의 의존 X
* 방법
      * 복잡도 낮추기
      * 복제
      * 다양성
      * 문서화
* 웹 브라우저 -> 웹 서버
      * 로드 밸런스
      * 해결 방안: N대의 웹서버 or L4, L7
* 웹 서버 -> WAS
      * 개발자의 코드로 인한 문제점 발생
      * 해결 방안: N대의 WAS 구축
* 데이터베이스
      * 용량 부족으로 인한 장애 발생
      * 해결 방안: RAID, NAS 등

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
