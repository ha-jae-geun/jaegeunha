# 프로세스와 스레드
```java
프로세스(Process)
프로세스는 실행 중인 프로그램으로 디스크로부터 메모리에 적재되어 CPU 의 할당을 받을 수 있는 것을 말한다. 
운영체제로부터 주소 공간, 파일, 메모리 등을 할당받으며 이것들을 총칭하여 프로세스라고 한다. 구체적으로 살펴보면 
프로세스는 함수의 매개변수, 복귀 주소와 로컬 변수와 같은 임시 자료를 갖는 프로세스 스택과 전역 변수들을 수록하는
데이터 섹션을 포함한다. 또한 프로세스는 프로세스 실행 중에 동적으로 할당되는 메모리인 힙을 포함한다.

프로세스 제어 블록(Process Control Block, PCB)
PCB 는 특정 프로세스에 대한 중요한 정보를 저장 하고 있는 운영체제의 자료구조이다. 운영체제는 프로세스를 관리하기
위해 프로세스의 생성과 동시에 고유한 PCB 를 생성 한다. 프로세스는 CPU 를 할당받아 작업을 처리하다가도 프로세스 전환이
발생하면 진행하던 작업을 저장하고 CPU 를 반환해야 하는데, 이때 작업의 진행 상황을 모두 PCB 에 저장하게 된다. 
그리고 다시 CPU 를 할당받게 되면 PCB 에 저장되어있던 내용을 불러와 이전에 종료됐던 시점부터 다시 작업을 수행한다.

PCB 에 저장되는 정보

프로세스 식별자(Process ID, PID) : 프로세스 식별번호
프로세스 상태 : new, ready, running, waiting, terminated 등의 상태를 저장
프로그램 카운터 : 프로세스가 다음에 실행할 명령어의 주소
CPU 레지스터
CPU 스케쥴링 정보 : 프로세스의 우선순위, 스케줄 큐에 대한 포인터 등
메모리 관리 정보 : 페이지 테이블 또는 세그먼트 테이블 등과 같은 정보를 포함
입출력 상태 정보 : 프로세스에 할당된 입출력 장치들과 열린 파일 목록
어카운팅 정보 : 사용된 CPU 시간, 시간제한, 계정번호 등

스레드(Thread)
스레드는 프로세스의 실행 단위라고 할 수 있다. 한 프로세스 내에서 동작되는 여러 실행 흐름으로 프로세스 내의 
주소 공간이나 자원을 공유할 수 있다. 스레드는 스레드 ID, 프로그램 카운터, 레지스터 집합, 그리고 스택으로 구성된다. 
같은 프로세스에 속한 다른 스레드와 코드, 데이터 섹션, 그리고 열린 파일이나 신호와 같은 운영체제 자원들을 공유한다.
하나의 프로세스를 다수의 실행 단위로 구분하여 자원을 공유하고 자원의 생성과 관리의 중복성을 최소화하여 수행 능력을 
향상시키는 것을 멀티스레딩이라고 한다. 이 경우 각각의 스레드는 독립적인 작업을 수행해야 하기 때문에 각자의 스택과
PC 레지스터 값을 갖고 있다.

스택을 스레드마다 독립적으로 할당하는 이유
스택은 함수 호출 시 전달되는 인자, 되돌아갈 주소값 및 함수 내에서 선언하는 변수 등을 저장하기 위해 사용되는 
메모리 공간이므로 스택 메모리 공간이 독립적이라는 것은 독립적인 함수 호출이 가능하다는 것이고 이는 독립적인 실행
흐름이 추가되는 것이다. 따라서 스레드의 정의에 따라 독립적인 실행 흐름을 추가하기 위한 최소 조건으로 독립된 스택을 할당한다.

PC Register 를 스레드마다 독립적으로 할당하는 이유
PC 값은 스레드가 명령어의 어디까지 수행하였는지를 나타나게 된다. 스레드는 CPU 를 할당받았다가 스케줄러에 의해 
다시 선점당한다. 그렇기 때문에 명령어가 연속적으로 수행되지 못하고 어느 부분까지 수행했는지 기억할 필요가 있다. 
따라서 PC 레지스터를 독립적으로 할당한다.

뒤로/위로


멀티 스레드
멀티 스레딩의 장점
프로세스를 이용하여 동시에 처리하던 일을 스레드로 구현할 경우 메모리 공간과 시스템 자원 소모가 줄어들게 된다. 
스레드 간의 통신이 필요한 경우에도 별도의 자원을 이용하는 것이 아니라 전역 변수의 공간 또는 동적으로 할당된 
공간인 Heap 영역을 이용하여 데이터를 주고받을 수 있다. 그렇기 때문에 프로세스 간 통신 방법에 비해 스레드 간의 
통신 방법이 훨씬 간단하다. 심지어 스레드의 context switch 는 프로세스 context switch 와는 달리 캐시 메모리를 
비울 필요가 없기 때문에 더 빠르다. 따라서 시스템의 throughtput 이 향상되고 자원 소모가 줄어들며 자연스럽게 
프로그램의 응답 시간이 단축된다. 이러한 장점 때문에 여러 프로세스로 할 수 있는 작업들을 하나의 프로세스에서 
스레드로 나눠 수행하는 것이다.


멀티 스레딩의 문제점
멀티 프로세스 기반으로 프로그래밍할 때는 프로세스 간 공유하는 자원이 없기 때문에 동일한 자원에 동시에 접근하는 일이 
없었지만 멀티 스레딩을 기반으로 프로그래밍할 때는 이 부분을 신경써줘야 한다. 서로 다른 스레드가 데이터와 힙 영역을 
공유하기 때문에 어떤 스레드가 다른 스레드에서 사용중인 변수나 자료구조에 접근하여 엉뚱한 값을 읽어오거나 수정할 수 있다.

그렇기 때문에 멀티스레딩 환경에서는 동기화 작업이 필요하다. 동기화를 통해 작업 처리 순서를 컨트롤 하고 공유 자원에 
대한 접근을 컨트롤 하는 것이다. 하지만 이로 인해 병목현상이 발생하여 성능이 저하될 가능성이 높다. 그러므로 과도한
락으로 인한 병목현상을 줄여야 한다.


멀티 스레드 vs 멀티 프로세스
멀티 스레드는 멀티 프로세스보다 적은 메모리 공간을 차지하고 문맥 전환이 빠르다는 장점이 있지만, 오류로 인해 
하나의 스레드가 종료되면 전체 스레드가 종료될 수 있다는 점과 동기화 문제를 안고 있다. 반면 멀티 프로세스 방식은 
하나의 프로세스가 죽더라도 다른 프로세스에는 영향을 끼치지 않고 정상적으로 수행된다는 장점이 있지만, 멀티 
스레드보다 많은 메모리 공간과 CPU 시간을 차지한다는 단점이 존재한다. 이 두 가지는 동시에 여러 작업을 수행한다는 
점에서 같지만 적용해야 하는 시스템에 따라 적합/부적합이 구분된다. 따라서 대상 시스템의 특징에 따라 적합한 동작 
방식을 선택하고 적용해야 한다.
```

# Multi-Thread 환경에서의 개발
* 개발을 시작하는 입장에서 멀티 스레드를 고려한 프로그램을 작성할 일이 별로 없고 실제로 부딪히기 힘든 문제이기 때문에 많은 입문자들이 잘 모르고 있는 부분 중 하나라고 생각한다. 하지만 이 부분은 정말 중요하며 고려하지 않았을 경우 엄청난 버그를 양산할 수 있기 때문에 정말 중요하다.

# Field member
* 필드(field)란 클래스에 변수를 정의하는 공간을 의미한다. 이곳에 변수를 만들어두면 메소드 끼리 변수를 주고 받는 데 있어서 참조하기 쉬우므로 정말 편리한 공간 중 하나이다. 하지만 객체가 여러 스레드가 접근하는 싱글톤 객체라면 field 에서 상태값을 갖고 있으면 안된다. 모든 변수를 parameter 로 넘겨받고 return 하는 방식으로 코드를 구성해야 한다.


# 동기화(Synchronized)
* 필드에 Collection 이 불가피하게 필요할 때는 어떠한 방법을 사용할까? Java 에서는 synchronized 키워드를 사용하여 스레드 간 race condition 을 통제한다. 이 키워드를 기반으로 구현된 Collection 들도 많이 존재한다. List를 대신하여 Vector를 사용할 수 있고, Map을 대신하여 HashTable을 사용할 수 있다. 하지만 이 Collection 들은 제공하는 API 가 적고 성능도 좋지 않다.
* 기본적으로는 Collections라는 util 클래스에서 제공되는 static 메소드를 통해 이를 해결할 수 있다. Collections.synchroziedList(), Collections.synchroziedSet(), Collections.synchroziedMap() 등이 존재한다. JDK 1.7 부터는 concurrent package를 통해 ConcurrentHashMap이라는 구현체를 제공한다. Collections util 을 사용하는 것보다 synchronized 키워드가 적용된 범위가 좁아서 보다 좋은 성능을 낼 수 있는 자료구조이다.


# ThreadLocal
* 스레드 사이에 간섭이 없어야 하는 데이터에 사용한다. 멀티스레드 환경에서는 클래스의 필드에 멤버를 추가할 수 없고 매개변수로 넘겨받아야 하기 때문이다. 즉, 스레드 내부의 싱글톤을 사용하기 위해 사용한다. 주로 사용자 인증, 세션 정보, 트랜잭션 컨텍스트에 사용한다.
* 스레드 풀 환경에서 ThreadLocal 을 사용하는 경우 ThreadLocal 변수에 보관된 데이터의 사용이 끝나면 반드시 해당 데이터를 삭제해 주어야 한다. 그렇지 않을 경우 재사용되는 쓰레드가 올바르지 않은 데이터를 참조할 수 있다.

## ThreadLocal 을 사용하는 방법은 간단하다.

* ThreadLocal 객체를 생성한다.
* ThreadLocal.set() 메서드를 이용해서 현재 스레드의 로컬 변수에 값을 저장한다.
* ThreadLocal.get() 메서드를 이용해서 현재 스레드의 로컬 변수 값을 읽어온다.
* ThreadLocal.remove() 메서드를 이용해서 현재 스레드의 로컬 변수 값을 삭제한다.

```java
자바 쓰레드 (JAVA Thread)

쓰레드 : 프로세스(실행중인 프로그램)에서 하나의 실행 흐름.

자바는 멀티 쓰레드를 지원하는 언어로 멀티 쓰레드란 말 그대로 하나의 프로그램에서 여러 개의 실행 흐름을 만들고 실행 할 수

있다는 것이다.

멀티쓰레드를 사용 하는 이유 : 외부와의 연계같이 대기 시간이 발생했을 때 기다리는 동안 다른 일을 처리할 수 있게 해서 처리 

속도를 빠르게 하기 위함이다.

* 단, CPU코어 수가 적으면 쓰레드를 그 만큼 만들 수 없기 때문에 드라마틱하게 빨라지지 않고, 처리하는 데이터 양이 적을 

때에도 속도가 많이 빨라지지 않기 때문에 쓰레드를 적절한 경우에 사용하는 것이 좋다.

쓰레드 만드는 법

1. Runnable 인터페이스를 상속(확장)한 클래스를 만든다. (Runnable 인터페이스를 상속받으면 run()메서드를 구현해야 한다.)

2. 1에서 상속한 클래스 객체를 만든다. (Runnable 객체 / 실행가능한 객체)

3. 2에서 만든 객체를 가진 실행흐름(Thread) 객체를 만든다. (자바에서 제공)

4. 쓰레드를 실행시킨다. (필요에 따라 중지도 시킴)

기본 예제


package com.tistory.jeongpro;
 
public class MultiThreadSample implements Runnable {
    private static final String MSG_TEMPLATE = "출력중 [%s][%d회]";
    private final String threadName;
    public MultiThreadSample(String threadName){
        this.threadName = threadName;
    }
    public void run(){
        for(int i =1;i<100;i++){
            System.out.println(String.format(MSG_TEMPLATE, threadName,i));
        }
    }
    public static void main(String[] args){
        MultiThreadSample runnable1 = new MultiThreadSample("thread1");
        MultiThreadSample runnable2 = new MultiThreadSample("thread2");
        MultiThreadSample runnable3 = new MultiThreadSample("thread3");
        
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
 
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
 
Colored by Color Scripter


Runnable 인터페이스를 상속받은 클래스를 작성하였고 run()메서드(1~99회까지 문자열 출력)를 구현했다.

Runnable 객체를 만들었고 그것을 실행시켜줄 쓰레드도 만들었다.

만든 쓰레드를 실행했다.

쓰레드 풀(Thread Pool)

위에서는 3개의 쓰레드를 만들었지만 동적으로 프로그램에 접속한 사람 수 만큼 쓰레드를 생성하게된다면 어떨까?

아마 제한하지 않으면 메모리를 다 잡아먹을 만큼의 쓰레드를 만들어 버릴 것이다.

따라서 쓰레드풀을 이용해서 쓰레드 생성할때 최대 개수를 지정해본다.


package com.tistory.jeongpro;
 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
 
public class MultiThreadSample implements Runnable {
    private static final String MSG_TEMPLATE = "출력중 [%s][%d회]";
    private final String threadName;
    public MultiThreadSample(String threadName){
        this.threadName = threadName;
    }
    public void run(){
        for(int i =1;i<100;i++){
            System.out.println(String.format(MSG_TEMPLATE, threadName,i));
        }
    }
    public static void main(String[] args){
        MultiThreadSample runnable1 = new MultiThreadSample("thread1");
        MultiThreadSample runnable2 = new MultiThreadSample("thread2");
        MultiThreadSample runnable3 = new MultiThreadSample("thread3");
        
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(runnable1);
        executorService.execute(runnable2);
        executorService.execute(runnable3);
        
        executorService.shutdown();
        try{
            if(!executorService.awaitTermination(5, TimeUnit.MINUTES)){
                executorService.shutdownNow();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
            executorService.shutdownNow();
        }
    }
}
 
Colored by Color Scripter
cs
아까 예제에서 직접 쓰레드를 생성하지 않고 쓰레드풀을 생성해서 쓰레드개수를 3개로 제한하고 실행시켰다.

* 쓰레드풀을 3개로 제한하고 많은 Runnable객체를 4개 이상 만든다면 앞에서 Runnable객체가 먼저 실행하고 실행이 끝나면 다음

Runnable객체가 들어가게 된다.

* .shutdown() 메서드는 실행중인 작업 뿐만 아니라 작업 큐에 대기하고 있는 모든 작업들을 다 '처리'하고 쓰레드풀을 중지시킨다. 

(shutdownNow()는 인터럽트로 즉시 중지시킨다.)

* .awaitTermination은 shutdown()메서드 호출이후 해당 시간만큼안에 쓰레드풀의 작업이 전부 수행하지 못하면 실행중이던 

쓰레드에 인터럽트를 발생시키고 false 반환한다. (예제에선 5,TimeUnit.MINUTES 즉 5분이다)

쓰레드 세이프 (Thread Safe)

멀티쓰레드로 동작하는 프로그램에서 개발자가 의도한 대로 동작하는 것을 가리킨다.

전혀 다른 일을 처리할 때는 발생상황이 없겠으나 공유자원을 참조할 때라면 개발자는 반드시 처리해야한다.


package com.tistory.jeongpro;
 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
public class UnsafeSample {
    public static void main(String[] args){
        //안전하지 않은 객체
        DateFormat unsafeDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1989,Calendar.MARCH,10);//1989/03/10
        Date date1 = cal1.getTime();
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2020, Calendar.JUNE,20);//2020/06/20
        Date date2 = cal2.getTime();
        
        Thread thread1 = new Thread(() ->{
            for(int i=0;i<100;i++){
                try{
                    String result = unsafeDateFormat.format(date1);
                    System.out.println("Thread1: " + result);
                }catch(Exception e){
                    e.printStackTrace();
                    break;
                }
            }
        });
        Thread thread2 = new Thread(() ->{
            for(int i=0;i<100;i++){
                try{
                    String result = unsafeDateFormat.format(date2);
                    System.out.println("Thread2: " + result);
                }catch(Exception e){
                    e.printStackTrace();
                    break;
                }
            }
        });
        
        thread1.start();
        thread2.start();
    }
}
 
Colored by Color Scripter


단순히 결과를 예측해보면 Thread1은 1989/03/10 만 100번 나오고 Thread2는 2020/06/20 만 100번 나와야 한다.

그러나 자세히보면 2020/06/10, 1989/03/20 이런 내용이 섞여나온다. 왜일까?

답은 SimpleDateFormat 클래스를 동시에 사용하려고 했기때문이다.

내부적으로 처리 속도가 상당히 빠른데 그 와중에 겹쳐서 date1의 1989/03/까지 찍고 있는데 갑자기 date2도 

SimpleDateFormat클래스를 이용해서 20을 찍어버리는 결과가 나올 수 있기 때문이다.

이렇게되면 개발자가 기대하는 대로 프로그램이 수행되지 않게 되는 것이다.

다양한 많은 해결법중 단순한 방법 하나 - synchronized 사용하기


package com.tistory.jeongpro;
 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
public class SynchronizedSample {
    public static void main(String[] args){
        //안전하지 않은 객체
        DateFormat unsafeDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1989,Calendar.MARCH,10);//1989/03/10
        Date date1 = cal1.getTime();
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2020, Calendar.JUNE,20);//2020/06/20
        Date date2 = cal2.getTime();
        
        Thread thread1 = new Thread(() ->{
            for(int i=0;i<100;i++){
                try{
                    String result;
                    synchronized (unsafeDateFormat) {
                        result= unsafeDateFormat.format(date1);
                    }
                    System.out.println("Thread1: " + result);
                }catch(Exception e){
                    e.printStackTrace();
                    break;
                }
            }
        });
        Thread thread2 = new Thread(() ->{
            for(int i=0;i<100;i++){
                try{
                    String result;
                    synchronized (unsafeDateFormat) {
                        result= unsafeDateFormat.format(date2);
                    }
                    System.out.println("Thread2: " + result);
                }catch(Exception e){
                    e.printStackTrace();
                    break;
                }
            }
        });
        
        thread1.start();
        thread2.start();
    }
}
 
Colored by Color Scripter


바뀐 것은 딱 각각 한줄이다. unsafeDateFormat을 사용하는 줄.

String result = unsafeDateFormat.format(date1);

위 문장을 

String result;
                    synchronized (unsafeDateFormat) {
                        result= unsafeDateFormat.format(date1);
                    }
이 문장으로 바꿨다.

synchronized를 통해서 해당 인수(unsafeDateFormat)에 락을 걸어서 쓰레드끼리 동시에 사용하지 못하게 막은 것이다. 

누군가 unsafeDateFormat 객체를 쓰려고하면 쓰고있는지 검사해서 기다리게 하거나 사용하게 해준다.

따라서 기다리는 시간이 있다보니 기존에 멀티쓰레드를 그냥 쓰던 방법보다 속도는 느리게 나오나 개발자가 기대하는대로 

실행되기때문에 적절한 프로그래밍을 한 것이다.

synchronized를 사용하게 되면 그냥 멀티쓰레드를 사용하는것보다 보통 100배정도 속도가 느리게 나온다.

이것을 개선한 방법도 있으니 찾아보고 공부하면 좋겠다.
```
