# [얄파한 코딩사전 JVM](https://youtu.be/VvVruEDCSSY)

# [기본기를 쌓는 정아마추어 JVM](https://jeong-pro.tistory.com/148?category=793347)
* 운영체제의 메모리 영역에 접근하여 메모리를 관리하는 프로그램(메모리 관리, Garbage Collector 수행)
* C, C++는 컴파일 플랫폼과 타겟 플랫폼이 다른 경우 프로그램이 동작하지 않았다(환경 플랫폼 = 운영체제 + CPU 아키텍처)
      * 개발할 때는 동일한 플랫폼에서 컴파일과 실행을 같이 한다면 프로그램은 아무 문제가 없다
      * 배포할 때 플랫폼이 달라질 경우 타겟 플랫폼에서 프로그램이 동작하지 않는다.
* 크로스 컴파일: 타겟 플랫폼에 맞춰 컴파일 하는 것을 '크로스 컴파일'이라 한다.
* 자바 바이트코드는 타겟 플랫폼에 상관없이 JVM 위에 동작한다. 물론 JVM은 타겟 플랫폼에 의존한다.(해당 운영체제의 JVM만 설치하면 됨)
* WORA; Write Once Run Anywhere

## JVM이 나온 이유
* 자바는 네트워크에 연결된 모든 디바이스에서 작동하는 것이 목적이었다
* 디바이스마다 운영체제나 하드웨어가 다르기 때문에 자연스럽게 플랫폼에 의존하지 않도록 언어를 설계했다. 그 결과가 자바 바이트코드

## 자바 코드 실행되는 과정
* 컴파일러 프론트엔드: 소스 코드 -> Lexical Analyzer -> Syntax Analyzer -> Semantic Analyzer -> Intermediate Code Generator(자바 바이트 코드)
      * Java Compiler(javac)가 진행
* 컴파일러 백엔드: Code Optimizer(JIT Compiler) -> Code Generator -> Target Assembly Program
      * JVM이 진행

# 자바의 구동원리
1. 컴파일러를 통해 JAVA 코드 검증과 JVM이 이해할 수 있는 바이트코드(.CLASS)로 만듬
2. .CLASS를 찾아 JVM으로 가져옴
3. 바이트코드 검증
4. 인터프린트(재해석
5. 바이트코드를 바이너리코드로 변경(바이너리 코드는 JVM의 클래스 영역에 저장)
6. 런타임 과정에서는 클래스들의 static  변수를 자동 초기화
7. static 블록 수행
8. 인스턴스 블록 수행
9. 생성자 호출
10. main 함수 호출

# JVM의 특징 
1. 스택기반의 가상머신
2. 가바지 컬렉션
3. 플랫폼에 독립적
* JAVA Compiler 이 java코드를 byte Code로 변환 -> Class Loadder System 을 통해 Class파일들을 JVM으로 로딩* -> 로딩된 Class 파일들은 Execution Engine을 통해 해석됨 -> 해석된 프로그램은 Runtime Data Areas에 배치되어 실질적인 수행이 이루어짐 
* -> 실행과정속에서 JVM은 필요에 따라 Thread Synchronization 과 Garbage Collection 같은 관리 작업을 수행하게 됨

```java
1. static 변수 선언부 : 클래스가 로드 될 때 (메모리 모델상 Methd area 에 올라감) 변수가 제일 먼저 초기화 됨

2. 필드 변수 선언부 : 객체 생성 될 때 (메모리 모델상 Heap area에 올라감) 생성자 block 보다 앞서 초기화 함

3. 생성자 block : 객체 생성 될 때 (메모리 모델상 Heap area에 올라감)

JVM이 내부적으로 locking (thread safe 영역임)

필드 변수 중 final 변수의 가시화는 (다른 스레드에 공개하는 시점은) 생성자 block이 끝난 다음.

필드 변수 선언부에서 이미 초기화 되었다면 그 값들은 덮어 씀


초기화 시점

    * 클래스변수의 초기화시점 : 클래스가 처음 로딩될 때 단 한번 초기화 된다. 

    * 인스턴스변수의 초기화시점 : 인스턴스가 생성될 때마다 각 인스턴스별로 초기화가 이루어진다.


초기화 순서

    * 클래스변수의 초기화순서 : 기본값 -> 명시적초기화 -> 클래스 초기화 블럭 

    * 인스턴스변수의 초기화순서 : 기본값 -> 명시적초기화 -> 인스턴스 초기화 블럭 -> 생성자


```

# [가비지 컬렉터](https://www.youtube.com/watch?v=vZRmCbl871I&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=28)
# [가비지 컬렉터 brunch](https://d2.naver.com/helloworld/329631)
# [GC 테코톡](https://www.youtube.com/watch?v=Fe3TVCEJhzo)
## 가비지 컬렉터 과정(Mark and Sweep)
1. 가비지 컬렉터가 스택의 모든 변수를 스캔하면서 각각 어떤 객체를 참조하고 있는지 찾아서 마킹한다.
2. Reachable Object가 참조하고 있는 객체도 찾아서 마킹한다.
3. 마킹되지 않은 객체를 Heap에서 제거한다.


## New Generation
* Eden  Survival0  Survival1  
* 새로운 객체는 Eden 영역에 할당된다. 

### Major GC
* Eden 영역이 다 사용되었으면 GC 발생(Minor) 
* Eden 영역의 Reachable 객체는 Survival 0으로 옮겨진다.
      * Eden 영역의 Unreachable 객체는 메모리에서 해제된다.
* survial0 영역이 다차면 객체는 Survival1 영역으로 이동한다(이동한 객체는 Age 값 증가)
   * Survival1에 객체가 차면 0은 비어있는 상태여야 한다. 0이 채워져있으면 1이 비워있는 상태 유지

## Old Generation
* age가 특정 값 이상이 되면 Old Generation 영역으로 옮겨진다.(이 과정을 Promotion 이라고 한다.)

### Major GC
* Old Generation의 값이 다차면 major gc가 일어난다 



# Garbage Collector 종류
## Serial GC
* GC를 처리하는 스레드가 1개이다.
* CPU 코어가 1개만 있을 때 사용하는 방식
* Mark-Compact collection 알고리즘 사용

## Parallel GC
* GC를 처리하는 스레드가 여러개이다.
* Serial GC보다 빠르게 객체를 처리할 수 있다.
* Parallel GC는 메모리가 충분하고 코어의 개수가 많을 때 사용하면 좋다.

## Stop-The-Wolrd
* GC를 실행하기 위해 JVM이 애플리케이션 실행을 멈추는 것이다.
* Stop-the-World가 발생하면 GC를 실행하는 스레드를 제외한 나머지 스레드는 모두 작업을 멈춘다.
* GC 작업을 완료한 이후에 중단한 작업을 다시 시작한다.


## Concurrent Mark Sweep GC(CMS GC)
* Stop-the-world 시간이 짧다
* 애플리케이션의 응답 시간이 빨라야 할 때 CMS GC를 사용한다.
* 다른 GC보다 메모리와 CPU를 더 많이 사용한다.
* Compaction 단계가 제공되지 않는다.

## G1 GC
* 각 영역을 Region 영역으로 나눈다
* GC가 일어날 때, 전체영역(Eden, Survival, Old generation)을 탐색하지 않는다.
* G1, GC는 바둑판의 각 영역에 객체를 할당하고 GC를 실행한다.
* 그러다가 해당 영역이 꽉 차면 다른 빈 영역에 객체를 할당하고 GC를 실행한다.
* 이 GC는 STW 시간이 짧다
* Compaction을 사용한다.


# JVM 구조
* JVM의 구성을 살펴보면 크게 4가지(Class Loader, Execution Engine, Garbage Collector, Runtime Data Area)로 나뉜다.
* 클래스 로더 서브 시스템 <> Runtime Data Areas <> execution engine

```java
1. Class Loader

자바에서 소스를 작성하면 Person.java 처럼 .java파일이 생성된다.

.java 소스를 자바컴파일러가 컴파일하면 Person.class 같은 .class파일(바이트코드)이 생성된다.

이렇게 생성된 클래스파일들을 엮어서 JVM이 운영체제로부터 할당받은 메모리영역인 Runtime Data Area로
적재하는 역할을 Class Loader가 한다. (자바 애플리케이션이 실행중일 때 이런 작업이 수행된다.)



2. Execution Engine

Class Loader에 의해 메모리에 적재된 클래스(바이트 코드)들을 기계어로 변경해 명령어 단위로 실행하는 역할을 한다.

명령어를 하나 하나 실행하는 인터프리터(Interpreter)방식이 있고 JIT(Just-In-Time) 컴파일러를 이용하는 방식이 있다.

JIT 컴파일러는 적절한 시간에 전체 바이트 코드를 네이티브 코드로 변경해서 Execution Engine이 
네이티브로 컴파일된 코드를 실행하는 것으로 성능을 높이는 방식이다.



3. Garbage Collector

Garbage Collector(GC)는 Heap 메모리 영역에 생성(적재)된 객체들 중에 참조되지 
않는 객체들을 탐색 후 제거하는 역할을 한다.

GC가 역할을 하는 시간은 정확히 언제인지를 알 수 없다. (참조가 없어지자마자 해제되는 것을 보장하지 않음)

또 다른 특징은 GC가 수행되는 동안 GC를 수행하는 쓰레드가 아닌 다른 모든 쓰레드가 일시정지된다.

특히 Full GC가 일어나서 수 초간 모든 쓰레드가 정지한다면 장애로 이어지는 치명적인 문제가 생길 
수 있는 것이다. (GC와 관련된 내용은 아래 Heap영역 메모리를 설명할 때 더 자세히 알아본다.)



4. Runtime Data Area

JVM의 메모리 영역으로 자바 애플리케이션을 실행할 때 사용되는 데이터들을 적재하는 영역이다.

이 영역은 크게 Method Area, Heap Area, Stack Area, PC Register, Native Method Stack로 나눌 수 있다.

```

# Runtime Data Areas
## method area
* 모든 스레드가 공유
* 클래스 로더가 클래스 파일을 읽어오면 클래스 정보를 파싱해서 저장

## heap
* 모든 스레드가 공유
* 프로그램을 실행하면서 생성한 모든 객체를 Heap에 저장

## Java stacks
* 각 스레드마다 존재
* 자바 스택은 스레드 별로 1개만 존재하고, 스텍 프레임은 메서드가 호출될 때마다 생성된다
* 메서드 실행이 끝나면 스택 프레임은 pop되어 스택에서 제거된다.

### Stack Frame
* Java Stacks 안에 들어있는 스텍 프레임
* 스택 프레임은 메서드가 호출될 때마다 새로 생겨 스택에 push된다
* 스택 프레임은 Local variables array, Operand Stack, Frame Data를 갖는다
* Frame Data는 Constant Pool, 이전 스택 프레임에 대한 정보, 현재 메서드가 속한 클래스/객체에 대한 참조 등의 정보를 갖는다.

## PC registers
* 각 스레드마다 존재
* 각 스레드는 메서드를 실행하고 있고, pc는 그 메서드 안에서 몇 번째 줄을 실행해야 하는지를 나타내는 역할

## native method stacks
* 각 스레드마다 존재
* 자바 바이트코드가 아닌 다른 언어로 작성된 메소드를 의미한다.


## 재설명 2
```java
1. Method area (메소드 영역)

클래스 멤버 변수의 이름, 데이터 타입, 접근 제어자 정보같은 필드 정보와 메소드의 이름, 리턴 타입, 
파라미터, 접근 제어자 정보같은 메소드 정보, Type정보(Interface인지 class인지), Constant Pool
(상수 풀 : 문자 상수, 타입, 필드, 객체 참조가 저장됨), static 변수, final class 변수등이 생성되는 영역이다.

2. Heap area (힙 영역)
new 키워드로 생성된 객체와 배열이 생성되는 영역이다.
메소드 영역에 로드된 클래스만 생성이 가능하고 Garbage Collector가 참조되지 않는 메모리를 확인하고 제거하는 영역이다.

3. Stack area (스택 영역)
지역 변수, 파라미터, 리턴 값, 연산에 사용되는 임시 값등이 생성되는 영역이다.
int a = 10; 이라는 소스를 작성했다면 정수값이 할당될 수 있는 메모리공간을 a라고 잡아두고 
그 메모리 영역에 값이 10이 들어간다. 즉, 스택에 메모리에 이름이 a라고 붙여주고 값이 10인 메모리 공간을 만든다.

클래스 Person p = new Person(); 이라는 소스를 작성했다면 Person p는 스택 영역에 
생성되고 new로 생성된 Person 클래스의 인스턴스는 힙 영역에 생성된다.

그리고 스택영역에 생성된 p의 값으로 힙 영역의 주소값을 가지고 있다. 즉,
스택 영역에 생성된 p가 힙 영역에 생성된 객체를 가리키고(참조하고) 있는 것이다.

메소드를 호출할 때마다 개별적으로 스택이 생성된다.

4. PC Register (PC 레지스터)

Thread(쓰레드)가 생성될 때마다 생성되는 영역으로 Program Counter 즉,
현재 쓰레드가 실행되는 부분의 주소와 명령을 저장하고 있는 영역이다. (*CPU의 레지스터와 다름)

이것을 이용해서 쓰레드를 돌아가면서 수행할 수 있게 한다.

5. Native method stack

자바 외 언어로 작성된 네이티브 코드를 위한 메모리 영역이다.

보통 C/C++등의 코드를 수행하기 위한 스택이다. (JNI)



쓰레드가 생성되었을 때 기준으로

1,2번인 메소드 영역과 힙 영역을 모든 쓰레드가 공유하고,

3,4,5번인 스택 영역과 PC 레지스터, Native method stack은 각각의 쓰레드마다 생성되고 공유되지 않는다.
```
