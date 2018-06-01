## IOT
* OS + CPU + 메모리 + 

## 영상
* Decoder -> codec (열 많이 냄)

## 열 발생
* CPU, 그래픽 카드

## bus
* CPU와 메인 메모리 사이에 데이터를 저장하기 위한 터미널이다.
  bus is terminal between CPU and Main memory to save data
* Address bus, Data bus, Control bus
* [Bus link](http://ssoonidev.tistory.com/14)
* [Bus link2](http://contents.kocw.net/KOCW/document/2015/cup/leesangkwan/6.pdf)

##SSD HDD
* Hdd: 디스크가 돌아야 한다.
  Hdd: disk has to spin
* 기가바이트 회사가 HDD를 RAM으로 만들었었다.
  Gigabyte Company made the HDD with RAM. It didn't release
* SSD는 HDD보다 약 5배 빠르다.
  SSD is 5times faster than HDD
* SSD는 읽기위 쓰기를 하는 개수에 한계가 있다.
  Reading and writing have a limit in SSD
* SSD: Flash memory(Like USB) + Controller
  - 읽기가 쓰기보다 빠르다
    Reading is faster than writing
  - Cell(Memory Storation way) SLC(single) > MLC(Multi) > TLC(triple)  //Usually we use MLC
    + 셀의 개수가 SSD의 가격을 결정한다.
      The number of cell decides SSD's price
    + SLC: 1비트가 1개의 방에 저장된다.
      SLC: 1 bit will be stored in one room
    + SLC: 컨트롤러를 복잡하게 만들고, 불안정하게 한다.
      SLC: It makes a controller complicated and it makes it unstable


## Clipboard
* 윈도우 뿐만 아니라 다른 OS에도 있다.
  Not only on Windows, but also on other operating systems.

## Process
* 프로그램을 운영하는 기초 단위
  basuc unit of running program
* 공존
  Concurrent
* Code, Stack, Heap, Data
* Stack:  

## Multi Process
* time sharing
* 1. 프로세스 복사(fork function -> exec function) 2. 프로세스 생성
  copy process(fork function -> exec function) 2. create process
* 단점: 프로세스 간에 정보 교환이 힘들다.
  cons: it's hard to exchange information among processes

##Thread
* Parallel
* 프로그렘의 흐름
* 코드, 데이터, 힙을 공유하고 자기만의 스택 영역이 있다.
  it shares code, data and heap area. It has own stack area.
* CPU의 코어가 많지 않으면 스레드를 만드는 개수에 한계가 있다.
  If the number of cpu's core is not much, there is a limit to make threads
  - java thread
    + 1. interface runnable 2. thread
    + start method

## Multi Thread
* Contact and switching context cost is cheap
* 하나의 스레드가 데이터를 망가뜨리면, 다른 스레드에도 영향을 줄 수 있다.
  If one thread breaks data space, it could affect the rest of threads
   + Synchronized 
    - Critical Section
      + 두 개 이상의 스레드가 동시에 실행되면 정적 변수에 영향을 줄 수 있습니다.
        if threads more than two are excuted at the same time, it could affect static variable.
        * Mutual Exclusion; synchronized
        * Progress
        * Bounded Waiting

## Memory structure
* Data; initialized
  - static variable, global variable
  - 프로그램이 종료 될 때까지 먼저 호출되고 남아 있습니다.
    it is called first and remain until programs terminate 
  - -> it's fixed
  - BSS (Block Stated Symbol); uninitialized
* Stack(function): local variable, parameter, return, pointer variable
  - 모든 프로그램은 스택을 가지고 있다. 나중에 프로그램을 백업시키는데 도움을 준다.
    ALl programs have stacks. It helps to go back
  - 밑에서 위로 저장된다.
    from bottom to top
  - funcion이 호출되면 스택이 시작됩니다.
    when the funcion is called, it starts to be stacked. (recursive)
  - 메모리가 할당되면 스택 영역을 확장해야합니다 (컴파일 시간)
    when memory is allocated, stack area has to be extended(compile time)
  - 컴파일 될 때 스택 크기가 결정됩니다.
    At compile time, stack size has to be decided
  - 함수가 종료되면 스택도 사라집니다.
    if the function is terminated, stack is also deleted
  - -> it's static
  - 배열의 길이는 일정해야 합니다.
    Array's length has to be a constant
  - 스택 사이즈는 고정입니다.
    stack size is fixed
* Heap; dynamic(malloc, free)  C++: new()
  - 위에서 아래로 저장됩니다.
    from top to bottom
  - 스택과 다르게 실행 시간에 데이터가 저장됩니다.
    <> stack; running time 
* Text(Code); assembly code about function; function, statement, constant
* SMA(Static Memory Allocation): data, stack   | DMA(Dynamic Memory Allocation): Heap Area
* Stack and heap are in inverse proportion




