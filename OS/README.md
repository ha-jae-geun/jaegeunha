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
