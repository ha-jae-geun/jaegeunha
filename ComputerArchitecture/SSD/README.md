# SSD
* 우리가 사용하는 메모리카드, USB, SSD 등의 저장매체에는 낸드플래시(NAND Flash) 메모리가 사용됩니다. 그리고 낸드플래시 타입은 최소단위인 셀(Cell)에 몇 비트(bit)를 저장할 수 있느냐에 따라 SLC, MLC, TLC, QLC 방식으로 나뉘는데요. 동일한 용량일지라도 이 네 가지 방식에 따라 성능의 차이가 발생하고 가격 또한 달라지게 됩니다. 오늘 <궁금한 반도체 WHY> 4탄에서는 낸드플래시 메모리의 데이터 저장 방식이 각각 어떻게 다른지 알아보도록 하겠습니다.

## SSD의 단점
1. 배드블록
 * 배드 블록이 1개라도 있으면 SSD를 교체해야 함
 * 이를 방지 하기 위해 대부분의 SSD에는 이를 교체하기 위한 예비 블록들이 있음(그래서 SSD의 기본 용량에서 조금 부족한 용량)
2. 쓰기/읽기 방해
3. 리텐션 에러
 * 너무 오래 사용안하면 전자가 도망감


## SSD HDD
* Hdd: 디스크가 돌아야 한다.  
    ^Hdd: disk has to spin
* 기가바이트 회사가 HDD를 RAM으로 만들었었다.  
    ^Gigabyte Company made the HDD with RAM. It didn't release
* SSD는 HDD보다 약 5배 빠르다.  
    ^SSD is 5times faster than HDD
* SSD는 읽기위 쓰기를 하는 개수에 한계가 있다.  
    ^Reading and writing have a limit in SSD
* SSD: Flash memory(Like USB) + Controller  
  - 읽기가 쓰기보다 빠르다
      ^Reading is faster than writing
  - Cell(Memory Storation way) SLC(single) > MLC(Multi) > TLC(triple)  //Usually we use MLC
    + 셀의 개수가 SSD의 가격을 결정한다.  
        ^The number of cell decides SSD's price
    + SLC: 1비트가 1개의 방에 저장된다.  
        ^SLC: 1 bit will be stored in one room
    + SLC: 컨트롤러를 복잡하게 만들고, 불안정하게 한다.  
        ^SLC: It makes a controller complicated and it makes it unstable



### SSD 메모리 셀의 타입
* 데이터를 저장하는 방식은 SLC(Single Level Cell), MLC(Multi Level Cell), TLC(Triple Level Cell), QLC(Quadruple Level Cell)로 나눌 수 있습니다. 이는 데이터를 저장하는 최소 단위인 셀(Cell)에 몇 비트(bit)를 저장할 수 있느냐에 따라 분류한 개념입니다. SLC는 1bit, MLC는 2bits, TLC는 3bits, QLC는 4bits 을 저장할 수 있죠
* SLC, MLC, TLC
* TLC는 용량이 큼, 동작 속도가 느림(하나에 3개의 비트가 들어가 있음)
 * 전자 가출률 높음(컴퓨터를 지속적으로 사용해야 함)
* 데이터를 저장(Write)한다는 의미는 지정된 셀의 storage 영역에 전자를 주입하는 동작을 통해 기존 Erase ‘1’ 셀을 Program ‘0’ 셀로 변환하여, 셀들을 이진법적으로 ‘1’ 과 ‘0’ 상태로 구분 가능하게 만드는 것입니다. 만약 셀의 구분 가능한 상태를 2n개로 확장하면 저장 가능한 데이터의 비트 수(n)가 증가합니다.
* SLC는 ‘1’과 ‘0’ 2개 (N=1), MLC는 ‘11’~’00’ 4개 (N=2), TLC는 ‘111’~’000’ 8개 (N=3), QLC는 ‘1111’ ~ ‘0000’ 16개 (N=4)로 구분할 수 있도록 셀 상태를 조절합니다.
* 물리적 셀 집적도(density)는 동일하지만, 동작 조건만으로 SLC에서 QLC로 정보 저장 비트 수가 증가하면서 각각 가격과 성능의 차이가 발생합니다. 동일한 정보 저장 용량에서 물리적 집적도가 감소하면 생산 원가가 감소되어 SLC → MLC → TLC → QLC 순으로 가격이 하락합니다. 동작 횟수가 증가하고 Read 전압과 VT 분포간 간격이 좁은 SLC → MLC → TLC → QLC 순으로 Write time, Read time, 신뢰성과 같은 성능과 품질도 하락됩니다. 
* 그래서 사용자가 저렴한 가격을 원하면 QLC, 고성능을 추구하면 SLC, 가격과 성능의 적절한 조합이 필요하면 TLC 또는 MLC를 적용한 제품을 선택할 수 있습니다. 향후 SLC는 커넥티드 카(Connected Car), 인공위성 등과 같은 고성능&고사양 제품에 적용될 것입니다. 반면, QLC는 고성능을 요하지 않는 USB 메모리와 사용빈도가 높지 않고 다른 저장 장치(ex. HDD)에 비해 성능 대비 구매/유지 비용이 저렴한 분야(ex. Server) 등에 적용될 것으로 보입니다.


### 슈퍼 컴퓨터의 IO 노드
* 예를 들어 54코어 CPU + 여러 SSD(TLC, QLC) + SLC/MLC(용량 작지만 속도 빠른) + 램(계층별로) 

### SSD의 장점
* 발전 속도가 빠름(용량/속도)
* 충격에 강함(전자적으로 처리하기 때문에; HDD는 헤드가 머리카락 크기정도의 간격으로 처리하기 때문에 약함)
* 크기가 작고 가벼움
* 병렬처리가 쉬움

### SSD의 단점
1. 배드블록; FTL(Flash Translation layer; 요청을 SSD가 알 수 있게 변환)
    * 읽고 쓰기 횟수가 정해져 있음
    * 사용 가능한 블록이 없을 때 GC(Garbage Collection)에서 사용된 블록 정리
    * OP(Over Provisioning 영역)에서 배드 블록을 교환해줄 수 있는게 들어있음.(SSD가 128GB라고 하면 할당 안됐던 부분)
    * 배드 블록이 생길 가능성
     1. 블록 내구도 초과
     2. 자연 배드 블록
     3. 쓰기/읽기 방해
     4. 리텐션 에러
        * 새 SSD는 오히려 더 
