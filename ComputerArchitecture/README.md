## 폰 노이만 구조
* 입력 장치 -> CPU(제어장치 / 산술+논리장치) <> 메모리 -> 출력장치
* 폰노이만 구조는 크게 CPU, 메모리, 입출력 장치로 구성되어 있으며, CPU안에는 산술/논리장치, 프로세서 레지스터를 포함하고 있는 처리 장치(Processing Unit)와 명령어 레지스터와 프로그램 카운터를 포함하는 제어장치로 구성된다. 메모리는 데이터와 명령어를 함께 저장할 수 있다.

## IOT
* OS + CPU + 메모리 + 

## 영상
* Decoder -> codec (열 많이 냄)

## 열 발생
* CPU, 그래픽 카드

## CPU
### Cisc
* x86 아키텍처가 리틀 엔디언을 쓰기 때문에, 오늘날 x86 아키텍처를 사용하는 대부분의 데스크톱 컴퓨터는 리틀 엔디언을 쓰며 이를 ‘인텔 포맷’이라 한다. 거꾸로 네트워크에서는 주소를 빅 엔디언으로 쓰는데, 역사적으로 라우팅이 전화를 거는 식으로 접두 부호로 이루어졌기 때문이다. 이의 영향으로 많은 프로토콜과 몇몇 파일 포맷이 빅 엔디언을 사용하고 있다. 모토로라 프로세서들은 일반적으로 빅 엔디언을 사용하며, ARM 프로세서들은 성능 향상을 위해 빅 엔디언과 리틀 엔디언을 선택할 수 있도록 되어 있다.
* 명령어가 복잡하기 때문에 명령어를 해석하는 데 시간이 오래 걸리며, 명령어 해석에 필요한 회로도 복잡하다.
* CISC란 소프트웨어 특히, 컴파일러 작성을 쉽게 하기 위해 하드웨어화할 수 있는 것은 가능한 모두 하드웨어에게 맡긴다는 원칙 아래 설계된 컴퓨터이다. 
* 뒤에서부터 스택에 PUSH
* 계산연산에서 빅 엔디안보다 속도가 빠름

### Risc
* RISC의 특징을 CISC와 비교하여 알아보면 다음과 같다. 첫째, 명령의 대부분은 1머신 사이클에 실행되고, 명령길이는 고정이며, 명령세트는 단순한 것으로 구성되어 있는데, 가령 메모리에 대한 액세스는 Load/Store 명령으로 한정되어 있다. 둘째, 어드레싱 모드가 적으며, 마이크로 프로그램에 의한 제어를 줄이고, 와이어드 로직을 많이 이용하고 있다. 반면에 레지스터수가 많으며 마이크로 프로그램을 저장하는 칩의 공간에 레지스터를 배치한다. 셋째, 어셈블러 코드를 읽기 어려울 뿐 아니라 파이프라인을 효과적으로 사용하기 위해서 일부 어셈블러 코드를 시계열로 나열하지 않은 부분이 존재하여 컴파일러의 최적화가 필요하다. 최적화를 하지 않으면 파이프라인을 유효하게 이용할 수 없고, RISC을 사용하는 의미가 없어진다.
* RISC는 CISC 형식의 CPU내 ROM에 소프트웨어적으로 적재된 내부 명령어들을 하드웨어적으로 구성해 제어기가 제거된 부분에 프로세서 레지스터 뱅크와 캐시를 둡니다. 이렇게 함으로써 CPU가 상대적으로 느린 메인 메모리에 접근하는 횟수를 줄여 시스템 수행속도를 향상시킬 수 있습니다.  
* 반면 RISC는 실행 속도를 높히기 위해 가능한 한 복잡한 처리는 소프트웨어에게 맡기는 방법을 택한 컴퓨터이다.
* Unix 의 RISC계열의 프로세서가 사용하는 바이트 오더링
* 네트워크에서 사용하는 바이트 오더링
* 앞에서부터 스택에 PUSH
* 비교연산에서 리틀 엔디안보다 속도가 빠름
* Intel 계열의 프로세서가 사용하는 바이트 오더링
* RISC 프로세서의 경우 CISC 프로세서보다 파이프라인 효율이 좋다. RISC는 명령어가 한 클록에 처리되므로, 한 명령어를 오래 처리해서 다음 명령어의 처리가 늦어지지 않기 때문이다. 또한, 메모리에 접근하는 경우, 매우 오랜 처리시간이 걸리는데, RISC는 LOAD나 STORE 명령어만으로 메모리에 접근하므로 비효율적인 접근이 CISC보다 적기 때문이다.
* 최대의 단점은 코드밀도가 감소하여 같은 내용을 처리하는 데 더 많은 코드 용량이 필요하게 되었다는 점이다. 그 원인은 또 다음과 같이 분류할 수 있다.
  + 항상 16bit 혹은 32bit를 차지하는 고정 길이 명령어는 상황에 따라 8~32bit를 오가는 CISC의 가변 길이 명령어에 비해 코드밀도 면에서 원천적으로 불리하다.
  + 메모리를 대상으로 하는 연산 명령어의 경우 CISC에서는 1개 명령어로 표현 가능한데 RISC에서는 load-execute-store로 3개의 명령어가 필요하다.
  + 마이크로코드로 한 줄로 구현된 CISC명령어를 몇 개, 혹은 수십개의 RISC명령어로 변환해야 한다.

### Cisc, Risc 차이점
* Complex
  + CISC의 단점이자 RISC의 장점은 CISC의 경우 하드웨어의 회로가 복잡해져서 RISC에 비해 가격이 비싸지고 발열이 많고 전력소모가 많게 됩니다.
  +  RISC 명령어가 단순히 명령어 수를 줄인 것이 아니라 명령어 해석기에서의 마이크로코드의 의존도를 제거하고 관련 로직을 단순화하여 성능을 올리는 방향으로 발전했다는 것을 상기하라.
* Instruction
  + RISC: CPI(Clock Per Instruction)을 1 이하로 줄이는 것임, 동급의 CISC에 비해 더 높은 clock frequency를 실현하는 것임
  + RISC 프로세서의 경우 CISC 프로세서보다 파이프라인 효율이 좋다. RISC는 명령어가 한 클록에 처리되므로, 한 명령어를 오래 처리해서 다음 명령어의 처리가 늦어지지 않기 때문이다. 또한, 메모리에 접근하는 경우
  + CISC에서는 여러 clock을 차지하는 복잡한 연산을 하는 명령어들이 종종 있었다. 심지어 for 루프를 실행하는 명령어가 존재했을 정도였다. 이는 과거에 컴파일러의 성능이 부족했기 때문에, 컴파일러를 사용한 후에도 최적화를 하기 위해서 기계어 코드를 수정하는 등 프로그래머가 기계어를 직접 다루는 경우가 많았기 때문이다. 
* Set
  + CPU는 메모리 접근을 피하기 위해 인자나 지역변수를 저장하는데에도 레지스터를 사용한다.
  + 즉, CISC 각각의 명령어는 머신코드는 길지만 전체 프로그램 사이즈는 RISC보다 작습니다. 따라서 코드를 수행할 때 RISC가 메모리를 더 많이 참조해야 하므로.... [CISC가 RISC보다 빠른 요인이 됩니다.] CISC는 복잡한 하드웨어를 가지게 되므로 보통 hard wired방식 보다는 microprogram 방식을 사용하게 됩니다. RISC는 hard wired 방식을 사용할 수 있습니다. [RISC가 CISC보다 빠른 요인이 됩니다.]
  CISC는 레지스터의 양이 많을 필요가 없고 RISC는 레지스터의 양이 많아야 하므로.... (예>함수에 파라미터를 메모리에 저장하는 경우와 레지스터에 저장하는 경우의 차이)
CISC가 메모리의 access가 많아지게 됩니다. [RISC가 CISC보다 빠른 요인이 됩니다.] RISC머신이 파이프라인구현이 용이하다라고 합니다..
* Stack
  + CISC: 일반적으로 하드웨어 스택이 내장되어 있어서 서브루틴 리턴 주소나 인자, 지역변수, 기타 임시 값을 저장하는데 사용한다. Call, ret, push, pop 같은 기계어 명령어를 사용할 경우 stack의 데이터는 자동적으로 관리된다.
  + RISC; Stack 관련 명령어가 존재하지 않음; Return address 나 기타 stack 자료 구조는 SW 적으로 처리해주어야 한다.; Power PC 의 경우, 함수의 인자를 전달하기 위해 8개의 레지스터를 따로 준비하고 있다. 인자값을 메모리에 접근하는 stack operation에 비해 register에 load 한다. 지역변수를 저장하기 위해 stack을 사용할 필요가 없다. 대부분의 짧은 프로시저나 함수를 호출할 때 리턴주소를 SW stack에 저장하기 위해 stack을 사용할 필요가 없다.

## bus
* CPU와 메인 메모리 사이에 데이터를 저장하기 위한 터미널이다.  
  ^bus is terminal between CPU and Main memory to save data
* Address bus, Data bus, Control bus
* [Bus link](http://ssoonidev.tistory.com/14)
* [Bus link2](http://contents.kocw.net/KOCW/document/2015/cup/leesangkwan/6.pdf)

##SSD HDD
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


## Clipboard
* 윈도우 뿐만 아니라 다른 OS에도 있다.  
    ^Not only on Windows, but also on other operating systems.

## Process
* 프로그램을 운영하는 기초 단위  
    ^basuc unit of running program
* Concurrent
* Code, Stack, Heap, Data
* Stack:  

## Multi Process
* time sharing
* 1. 프로세스 복사(fork function -> exec function) 2. 프로세스 생성  
    ^copy process(fork function -> exec function) 2. create process
* 단점: 프로세스 간에 정보 교환이 힘들다.
    ^cons: it's hard to exchange information among processes

##Thread
* Parallel
* 프로그렘의 흐름
* 코드, 데이터, 힙을 공유하고 자기만의 스택 영역이 있다.  
    ^it shares code, data and heap area. It has own stack area.
* 스택을 공유하지 않기 때문에 여러개의 스레드가 붙으면 오류가 날 수 있다.
* Context Switching이 (프로세스는 필요 없음) 이루어져야 하기 때문에 오류가 난다.
* CPU의 코어가 많지 않으면 스레드를 만드는 개수에 한계가 있다.  
    ^If the number of cpu's core is not much, there is a limit to make threads
  - java thread
    + 1. interface runnable 2. thread
    + start method

## Multi Thread
* Contact and switching context cost is cheap
* 하나의 스레드가 데이터를 망가뜨리면, 다른 스레드에도 영향을 줄 수 있다.  
    ^If one thread breaks data space, it could affect the rest of threads
   + Synchronized 
    - Critical Section
      + 두 개 이상의 스레드가 동시에 실행되면 정적 변수에 영향을 줄 수 있습니다.  
          ^if threads more than two are excuted at the same time, it could affect static variable.
        * Mutual Exclusion; synchronized
        * Progress
        * Bounded Waiting

## Memory structure
* Data; initialized
  - static variable, global variable
  - 프로그램이 종료 될 때까지 먼저 호출되고 남아 있습니다.  
      ^it is called first and remain until programs terminate 
  - -> it's fixed
  - BSS (Block Stated Symbol); uninitialized
* Stack(function): local variable, parameter, return, pointer variable
  - 모든 프로그램은 스택을 가지고 있다. 나중에 프로그램을 백업시키는데 도움을 준다.  
      ^ALl programs have stacks. It helps to go back
  - 밑에서 위로 저장된다.  
      ^from bottom to top
  - funcion이 호출되면 스택이 시작됩니다.  
      ^when the funcion is called, it starts to be stacked. (recursive)
  - 메모리가 할당되면 스택 영역을 확장해야합니다 (컴파일 시간)  
      ^when memory is allocated, stack area has to be extended(compile time)
  - 컴파일 될 때 스택 크기가 결정됩니다.  
      ^At compile time, stack size has to be decided
  - 함수가 종료되면 스택도 사라집니다.  
      ^if the function is terminated, stack is also deleted
  - -> it's static
  - 배열의 길이는 일정해야 합니다.  
      ^Array's length has to be a constant
  - 스택 사이즈는 고정입니다.  
      ^stack size is fixed
* Heap; dynamic(malloc, free)  C++: new()
  - 위에서 아래로 저장됩니다.  
      ^from top to bottom
  - 스택과 다르게 실행 시간에 데이터가 저장됩니다.  
    <> stack; running time 
* Text(Code); assembly code about function; function, statement, constant
* SMA(Static Memory Allocation): data, stack   | DMA(Dynamic Memory Allocation): Heap Area
* 스택과 힙은 반비례 관계이다.  
    ^Stack and heap are in inverse proportion




