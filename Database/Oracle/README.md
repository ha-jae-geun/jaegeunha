
# 오라클 스토리지 구조
* Blcok < Extent < Segment < Tablespace
* block: 데이터가 저장되는 가장 작은 공간
	* Select 할 때 IO 해야 하는 가장 기본적인 단위다.
	* 테이블의 데이터들이 ROW 단위로 들어가있다. 테이블의 컬럼수가 많으면 적은 수의 ROW가 한 BLOCK에 들어간다.
	* 컬럼 하나를 SELECT 하든 모든 컬럼을 SELECT 하든 IO하는 블록읙 갯수는 동일하다.
	* 블록의 사이즈는 DB_BLOCK_SIZE 라는 파라미터로 지정을 할 수 있다.(2K, 4K, 8K 처럼 2의 N승으로 지정 가능)
* EXTENT: 데이터베이스가 공간을 할당하는 가장 작은 단위
	* 예를 들어 블록이 4K, EXTENT가 32K면 8개의 블록이 하나의 EXTENT를 이룬다.
* SEGEMENT는 OBJECT라고 생각하면 된다. OBJECT중에서 저장 공간을 사용을 하는 OBJECT다.1.8
	* VIEW와 SYNONYM 은 저장 구조를 갖지 않는 OBJECT이다.
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
