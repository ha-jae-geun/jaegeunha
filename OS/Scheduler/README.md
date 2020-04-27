# 스케줄링
## CPU 스케쥴링 목적
* [블로그](https://dailyheumsi.tistory.com/131?category=855210)
```java
다중 프로그래밍을 함으로써, 항상 실행할 수 있는 프로세스를 있도록 하여,
CPU 사용 효율을 극대화 하는 것이 목적이다.

* CPU, I/O burst
프로세스는 계산과 입출력의 반복.
계산(CPU burst) / 입출력(I/O burst)

* 선점 / 비선점 스케쥴링
선점은 RUN 중인 프로세스를 갑자기 중단시키고 다른 프로세스가 RUN 할 수 있는 방식
비선점은 RUN 중인 프로세스를 중간에 갑자기 중단 불가능.
일단 한 번 할당 받으면, 시간이 다 되거나, 완료 될 때까지 다른 프로세스들이 기다려야함.

* Dispatcher
스케쥴러가 선택한 프로세스를 CPU에 할당해주는 요소를 가르킴
Dispatch latency
	A 프로세스 STOP -> B 프로세스 RUN 하는 동안 소요되는 시간

```

## 용어정리
```java
CPU utilization (이용률)

전체 시간 중에서 CPU가 놀지 않고 일한 시간의 비율

Throughput (처리량)

주어진 시간동안 얼마의 작업을 처리했는가

<프로세스 입장에서의 성능척도>

Turnaround time (소요시간, 반환시간)

CPU를 할당받기 위해 Ready queue에서 대기한 시간부터 모든 프로세스 작업을 마치고 반환하기 까지 걸린 시간

Waiting time (대기 시간)

CPU를 할당받기 위해 Ready queue에서 대기한 시간의 총합

Response time (응답 시간)

Ready queue에 들어와서 첫 번째로 CPU를 할당받기까지 걸린 시간
```

## 스케쥴링 기준
```java
스케쥴링 알고리즘을 선택할 때, 고려되는 기준을 살펴본다.

처리율 (Throughput)
시간당 완료되는 프로세스의 수

반환시간 (Turnaround time)
한 프로세스가 큐에 들어간 시점부터 실행완료할 때까지 걸리는 시간

대기시간 (Waiting time)
한 프로세스가 큐에서 대기한 총 시간

응답시간 (Response time)
큐에 들어가고, 첫 번째 실행 때까지 걸리는 시간
처리율은 높이고, 반환, 대기, 응답시간은 낮추는게 가장 이상적인 알고리즘이다.

```
## 스케쥴링 종류
* FCFS, RR: 공평성(Fairness)
* SPN(Starvation), SRTN(현실적으로 불가능), HRRN: 효율성/성능
	* 문제점: 실행시간 예측 부하

## 3. 스케쥴링 알고리즘
```java
3.1. 싱글레벨 큐
하나의 큐만 사용한다.

* FCFS (First Come First Served)
비선점 방식
FIFO 형태. 큐로 쉽게 구현
Convoy 효과
하나의 큰 프로세스가 CPU를 양보할 때 까지 다른 모든 프로세스가 기다리는 현상

* SJF (Shortest Job First)
현재 큐에 들어와있는 프로세스 중, CPU burst 시간이 제일 짧은 프로세스 순으로 스케쥴링
평균 대기 시간 측면에서는 그나마 최적에 가까움.
다음 CPU burst 시간 예측의 어려움
	지수 평균 방법으로 예측
선점방식일 경우, 다음 방법으로 선점여부 결정
	새 프로세스가 큐에 도착하면, 이 프로세스의 다음 CPU burst 시간(A) 예측
	현재 RUN 중인 프로세스의 남은 CPU burst 시간(B) 계산
	이 두 시간 A, B 를 비교해서 A < B 이면, 새 프로세스가 CPU 선점
	이 방식은 SRTF (Shortest Remaining Time First) 라고 함.
	
* 우선순위 스케쥴링
	우선순위가 높은 프로세스가 먼저 CPU를 선점함
	SJF 도 이 스케쥴링의 일종임.
우선순위는 OS 또는 사용자에 의해 지정될 수 있음
영구 대기(infinite blocking), 굶주림(starvation) 이 발생할 수 있음.
즉 우선순위가 낮은 프로세스는 영원히 실행되지 않는 문제
이를 극복하기 위해 우선순위를 점진적으로 낮춰주는 aging 기법을 사용함

* RR (Round robin)
시간 조각(time quantum) 을 정의하여, 이 시간이 경과할 때마다 CPU를 선점하는 프로세스를 바꿈.
예를 들어, 시간 조각 q=4ms 이면, 4ms 동안 프로세스 A가 선점한 후, 다음 4ms 에는 프로세스 B가 선점.
일반적으로 CPU burst 시간의 80% 는 시간 조각보다 적어야 가장 바람직함.


3.2. 다중레벨 큐
여러 개의 큐를 사용한다.

큐 간 독자적인 스케쥴링 알고리즘을 사용한다.
프로세스는 여러 개의 큐간 이동하며 수행된다.
이 스케쥴링의 주 목표는 CPU burst 시간 특성이 다른 프로세스들을 분리하여,
굶주림과 호위 효과 현상을 제거하는 것이다.
예를 들어, 입출력 중심의 프로세스는 상위 큐에, CPU 중심의 프로세스는 하위 큐에 할당된다.
다음과 같은 사항을 고려하여, 다중레벨 큐를 만들 수 있다.
	큐의 개수
	각 큐의 스케쥴링 알고리즘
	aging 혹은 그 반대로 만드는 방법
	큐 이동 순서

``
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
```


# CFS 스케줄러
* 스케줄러는 CPU 자원을 프로세스들에게 분배하는 OS의 중요한 일부분이다.
* 2007년 발표 된 리눅스 커널의 스케줄러인 CFS(Completely Fiar Scheduler) RSDL(Rotating Staircase Deadline) 스케줄러를 기초로 한 RB-트리(Red-Black Tree) 데이터 구조를 사용하는 O(logN) 성능을 가지는 스케줄러이다.
* CFS는 시간단위로 나노초를 사용한다.

* 만약 A, B 두 개의 태스크가 진행되고 있다면 A와 B의 CPU 사용시간은 항상 1:1로 같아야한다.
* 그러나 두 태스크가 번갈아 가며 수행되므로 임의의 시점에 두 태스크의 CPU 사용 시간이 항상 1:1로 같을 수 없다.
* 따라서 CFS는 정해진 ‘시간 단위’로 봤을때 시스템에 존재하는 태스크들에게 공평한 CPU 시간을 할당하는 것을 목표로 한다.
* 만약 1초를 ‘시간 단위’로 한다면 0.5초 동안 A 태스크를 수행시키고, 그런 뒤 0.5초간 B 태스크를 수행시킴으로써 1초가 지난 이후 A와 B의 CPU 사용시간이 1:1이 되도록 하는 것이다.
* CFS의 기본 개념은 작업에 프로세서 시간을 제공할 때 밸런스(공평성)를 유지하는 것이다.
* 즉 프로세스에 공평한 양의 프로세서(=CPU)가 제공되어야 한다.
* 작업 시간의 밸런스가 무너진 경우에는(다른 작업에 비해 하나 이상의 작업에 공평한 양의 시간이 주어지지 않은 경우) 작업 시간이 적게 지정된 작업에 실행 시간이 주어져야 한다.

## 가상 런타임
* CFS에서는 밸런스를 결정하기 위해 가상 런타임이라는 지정된 작업에 제공된 시간의 양을 관리한다.
* 작업의 가상 런타임이 작을수록 즉, 프로세서에 액세스할 수 있도록 허용된 시간이 작은 작업일수록 더 많은 프로세서 시간이 필요하다.

## 대기자 공평성
* 이 개념은 현재 실행할 수 없는 작업(예를 들어, I/O를 대기 중인 작업)이 나중에 프로세서가 필요할 때 대기했던 시간에 상응하는 프로세서 시간을 받을 수 있도록 보장한다.

## RB-트리
* 하지만 CFS는 이전 Linux 스케줄러와는 달리 실행 큐에서 작업을 관리하지 않고 시간순으로 정렬된 RB-트리를 유지한다.
* 첫 번째는 스스로 밸런스를 조절한다는 것이다.
* 즉, 이 트리의 모든 경로는 다른 경로보다 두 배 이상 길어지지 않는다.
* 두 번째는 트리에 대한 작업이 O(log n) 시간(여기서 n는 트리의 노드 수임) 내에 발생한다는 것이다.
* 따라서 작업을 빠르고 효율적으로 삽입하거나 삭제할 수 있다.
