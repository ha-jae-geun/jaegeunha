* [Linux](./Linux/README.md)
* [Android](./Android/README.md)

# 운영체제 개념
## 윈도우 특징

## 리눅스 특징

## CLI와 GUI 차이

## 윈도우 부팅 시 시작프로그램 핸들링 하는 명령어: msconfig



# Process
* 프로그램을 운영하는 기초 단위  
    ^basuc unit of running program
* Concurrent
* Code, Stack, Heap, Data
* Stack:  
# 프로세스
- https://bowbowbow.tistory.com/16 
- 프로그램 -> 실행 내용 -> 프로세스 -> 중앙처리장치(CPU)
- 프로그램은 일반적으로 하드 디스크 등에 저장되어 있는 실행코드를 뜻하고, 프로세스는 프로그램을 구동하여 프로그램 자체와 프로그램의 상태가 메모리 상에서 실행되는 작업 단위를 지칭한다. 예를 들어, 하나의 프로그램을 여러 번 구동하면 여러 개의 프로세스가 메모리 상에서 실행된다.
- 프로세스와 프로그램의 차이는 정말 명확합니다. 프로그램자체는 생명이 없습니다. 프로그램은 보조 기억장치(하드디스크, SSD)에 존재하며 실행되기를 기다리는 명령어(코드)와 정적인 데이터의 묶음입니다. 이 프로그램의 명령어와 정적 데이터가 메모리에 적재되면 생명이 있는 프로세스가 됩니다.

## 프로세스가 접근할 수 있는 메모리 공간
- 이 주소 공간은 Text, Data, BSS, Heap, Stack 영역으로 구성됩니다. 아래 그림에서 각 영역에 프로그램의 어떤 정보를 저장하는지 나타냈습니다.
- Text: 기계어; Data: 초기화된 전역 변수, static 변수, BSS: 초기화되지 않은 전역 변수, static 변수, Heap: malloc으로 동적 할당된 변수   stack: 지역 변수




## PCB
- 프로세스에 대한 정보는 프로세스 제어블록(PCB, Process Control Block)또는 프로세스 기술자(process descriptor)라고 부르는 자료구조에 저장됩니다. 대부분 PCB라고 부릅니다. 이 자료구조 크게 다음과 같은 정보를 담고있습니다. 
- 운영체제가 각 프로세스를 식별하기 위해 부여된 프로세스 식별번호(PID, Process IDentification)입니다.
- CPU는 프로세스를 빠르게 교체하면서 실행하기 때문에 실행중인 프로세스도 있고 대기 중인 프로세스도 있습니다. 그런 프로세스의 상태를 저장합니다.
- CPU가 다음으로 실행할 명령어를 가리키는 값입니다. CPU는 기계어를 한 단위씩 읽어서 처리하는데 프로세스를 실행하기 위해 다음으로 실행할 기계어가 저장된 메모리 주소를 가리키는 값입니다.
- 운영체제는 여러개의 프로세스를 동시에 실행하는 환상을 제공합니다. 운영체제가 여러 개의 프로세스가 CPU에서 실행되는 순서를 결정하는 것을 스케줄링이라고 합니다. 이 스케줄링에서 우선순위가 높으면 먼저 실행될 수 있는데 이를 스케줄링 우선순위라고 합니다.
- 프로세스가 접근할 수 있는 자원을 결정하는 정보입니다. 안드로이드 앱을 예로 들면 아무 앱이나 휴대폰 통화내역을 볼 수 있는 권한을 가지면 이를 악의적으로 이용하는 앱이 등장하겠죠? 그래서 프로세스마다 어디까지 접근할 수 있는지에 대한 권한이 필요합니다.
- 최초로 생성되는 init 프로세스를 제외하고 모든 프로세스는 부모 프로세스를 복제해서 생성되고 이 계층관계는 트리를 형성합니다. 그래서 각 프로세스는 자식 프로세스와 부모프로세스에 대한 정보를 가지고 있습니다.
 
 * 출처: https://bowbowbow.tistory.com/16 [멍멍멍]

## 프로세스의 상태
- 생성(create) : 프로세스가 생성되는 중이다.
- 실행(running) : 프로세스가 CPU를 차지하여 명령어들이 실행되고 있다.
- 준비(ready) : 프로세스가 CPU를 사용하고 있지는 않지만 언제든지 사용할 수 있는 상태로, CPU가 할당되기를 기다리고 있다. 일반적으로 준비 상태의 프로세스 중 우선순위가 높은 프로세스가 CPU를 할당받는다.
- 대기(waiting) : 보류(block)라고 부르기도 한다. 프로세스가 입출력 완료, 시그널 수신 등 어떤 사건을 기다리고 있는 상태를 말한다.
- 종료(terminated) : 프로세스의 실행이 종료되었다.

##상태전이
- 디스패치(dispatch)
- 준비 리스트의 맨 앞에 있던 프로세스가 CPU를 점유하게 되는 것, 즉 준비 상태에서 실행 상태로 바뀌는 것을 디스패치라고 하며 다음과 같이 표시한다.
- dispatch (processname) : ready → running

- 보류(block)
- 실행 상태의 프로세스가 허가된 시간을 다 쓰기 전에 입출력 동작을 필요로 하는 경우 프로세스는 CPU를 스스로 반납하고 보류 상태로 넘어 간다. 이것을 보류라고 하며 다음과 같이 표시한다.
- block (processname) : running → blocked

- 깨움(wakeup)
- 입출력 작업 종료 등 기다리던 사건이 일어났을 때 보류 상태에서 준비 상태로 넘어가는 과정을 깨움이라고 하며 다음과 같이 표시한다.
- wakeup (processname) : blocked → ready



- 시간제한(timeout)
- 운영체제는 프로세스가 프로세서를 계속 독점해서 사용하지 못하게 하기 위해 clock interrupt를 두어서 프로세스가 일정 시간동안만 (시분할 시스템의 time slice) 프로세서를 점유할 수 있게 한다
- timeout(processname) : running -> ready


## Multi Process
* time sharing
* 1. 프로세스 복사(fork function -> exec function) 2. 프로세스 생성  
    ^copy process(fork function -> exec function) 2. create process
* 단점: 프로세스 간에 정보 교환이 힘들다.
    ^cons: it's hard to exchange information among processes

## Thread
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


## Time Sharing

## Context Switching

## Log
* 이벤트 뷰어  
  ^Window: Event viewer(systemlog > application program)
* 파일 형식으로 되어 있음  
  Linux: 1. /var/log  2. History
* 소프트웨어 측면에서는 시스템 로그에 로그를 남길 수 있지만 시스템과 관련이없는 경우 파일에 로그를 남깁니다.  
  ^In terms of software, they can leave log on system log but if they are not related to system, they leave logs on files

## Linux, WIndow

### Regestry(regedit)
* 과거에 INI 파일은 각 프로그램의 구성을 저장하는 데 사용됐찌만 여기저기 퍼져 있었기 때문에 찾기가 어려워 레지스트리가 나왔다.  
    ^Back in the day, INI file is used to contain each programs' configuration. But it's hard to find because they are spread. That's why the registry came out.
* [1]('https://www.youtube.com/watch?v=_U78iAem3uo')
* [2]('http://editorizer.tistory.com/239')
* [3]('http://pastime0.tistory.com/66')
* File location
  - C:\Windows\System32\config
  - System Reserved\Boot\BCD
  - C:\Users\User_Account\NTUSER.DAT
* Registry <> Linux file
* 레지스트리는 하드웨어, 소프트웨어, 환경 설정 및 사용자에 대한 설정 및 옵션을 저장하는 데이터베이스입니다.  
    ^Registry is the database that stores settings and options for Hardware, Software, preferences and users
* 클래스 객체 : 그것이 나타내는 객체로 할 수있는 것을 정의하는 명명 된 함수 그룹  
    ^class object: a named group of functions that defines what you can do with the object it represents 
* Registry keys(similar to folders) and Registry values(files) are components
* HKey_LOCAL_MACHINE
  - SAM: security accounts manager
* HKEY_CURRENT_CONFIG
  - Current Hardware information
  - 런타임에 수집 된 정보가 포함되어 있습니다. 정보를 여기에 저장하면이 키는 영구적으로 디스크에 저장되지 않습니다.  
      ^It contains information gathered at runtime; information stored here, this key is not permantently stored on disk
* HKEY_CLASSES_ROOT
  - 파일 연결과 같은 등록 된 응용 프로그램에 대한 정보가 들어 있습니다.  
      ^contains information about registered applicatoins, such as file associations
* HKEY_CURRENT_USER
  - 현재 로그인 한 사용자에게 특정한 설정을 저장합니다.  
      ^stores settings that are specific to the currently logged-in user
* Type of registry
  - Binary data, String values, unsigned integers, symbolic links, multi-string values, resource list, resource descriptor, 64-bit integers
