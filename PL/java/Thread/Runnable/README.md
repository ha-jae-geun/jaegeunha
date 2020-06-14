# Daemon
```java
쓰레드(Thread)를 올바르게 생성, 시작하는 방법

쓰레드, 프로세스가 무엇이고 어떻게 생성하는지는 다른 포스트에 이미 있으니 생략한다.

http://jeong-pro.tistory.com/71?category=773575 



▶ 쓰레드를 생성할 때는 Runnable 인터페이스를 상속한 Runnable객체를 생성시키는 방법을 사용해라.

쓰레드를 생성하는 일반적인 방법으로 두 가지가 있다.

    1. Thread 클래스를 상속받고 run()메소드를 오버라이딩해서 정의한 후 실행하는 방법

    2. Runnable 인터페이스를 확장해 run()메소드를 구현해 정의한 후 실행하는 방법

왜 Runnable 인터페이스를 확장하는 것이 좋을까?

그 답은 상속과 인터페이스에 있다.  자바 다중상속을 지원하지 않기 때문에 상속은 하나의 클래스만 받을 수 있다는 것도 걸림돌이

되지만, 사실 더 중요한 것은 내가 받고 싶지 않은 메소드도 상속을 통해서 받게 되는 문제다.

상속을 하게되면 private이 아닌 메서드나 변수를 자식 클래스가 받게 되고 그로 인해 재정의되거나 코드가 길어지고 낭비되는 문제가 생길 수 있다.

따라서 Runnable 인터페이스를 확장하는 것이 필요한 기능만 갖게 되고 클래스간의 결합도도 낮춰 객체지향적으로 좋다.

* 상속은 깊게 생각해보고 상속받는 것이 좋을 때에만 적절히 사용하는게 바람직하다.

쓰레드(Thread) 중지시키는 방법

멀티쓰레드 프로그램에서 쓰레드를 어떻게 중지시켜야 할까?

1. flag를 이용한 쓰레드 중지 (좋지 않은 방법)


package nio;
 
class StopThread implements Runnable{
    private boolean stopped = false;
    public void run() {
        while(!stopped){
            System.out.println("Thread is alive...");
            try {
                Thread.sleep(500);//5초간 멈춤
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread is dead...");
    }
    public void stop() {
        stopped = true;
    }
}
 
public class Test1 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.process();
    }
    public void process() {
        StopThread st  = new StopThread();
        Thread thread = new Thread(st);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        st.stop();
    }
}
Colored by Color Scripter


위 코드는 boolean타입의 stopped 라는 변수를 만들어놓고 중단 신호가 오면 while문에서 판단하고 중지하는 코드다.

위 코드에서는 잘 중단되는 것으로 보이나 위험한 문제가 있다.

만약 쓰레드가 run()메소드 안에서 특정 로직이 무한루프를 도는 곳이 있거나 조건 루프를 도는 시간이 너무 오래걸리면 

즉시 정지하지 못하는 문제가 생긴다.

굳이 이 방법을 사용하려면 코드 중간중간 계속해서 flag를 확인하는 코드를 넣어야할 것이다.



2. interrupt() 메소드를 이용한 중지


package nio;
 
class StopThread implements Runnable{
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Thread is alive...");
                Thread.sleep(500);//5초간 멈춤
            }
        } catch(Exception e) {
            // TODO: handle finally clause
        }finally {
            System.out.println("Thread is dead...");            
        }
    }
}
 
public class Test1 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.process();
    }
    public void process() {
        StopThread st  = new StopThread();
        Thread thread = new Thread(st);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
 
}
Colored by Color Scripter


위 코드에서는 Thread에 interrupt가 발생하면 즉시 쓰레드를 중지시키고 finally{} 부분을 실행하므로 소켓이나 

DB커넥션등을 종료시킬 수 있다.

쓰레드(Thread)가 언제 죽는지 아나?

자바는 모든 쓰레드가 끝나야 JVM이 종료된다는 기본 원칙이 있다.

따라서 자바 애플리케이션에서 main쓰레드가 죽는다고 자바프로그램이 완전히 종료된 것이 아니다.

자바 애플리케이션에서 백그라운드 서비스에 일반 쓰레드를 쓰면 영원히 정지하지 않을 수 있다.

이러면 안되기 때문에 Daemon thread라는 개념이 생겼다.


package nio;
 
public class Test1 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("sub 쓰레드 종료");
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        //데몬쓰레드로 지정하기
        t.setDaemon(true);
        t.start();
        
        System.out.println("main 쓰레드 종료");
    }
}
Colored by Color Scripter


사용하는 것도 너무 쉽다.

단순히 백그라운드로 main쓰레드가 종료되었을 때 같이 종료해도 되는 쓰레드를 .setDaemon(true) 메소드로 지정해주기만 하면 된다.

* 주의할 점은 실행하기 전에 setDaemon을 시켜야한다. 실행한 후에는 해봐야 소용없다.



그럼 반대로 main쓰레드가 다른 쓰레드들을 기다려줘야 할 때는 어떻게 할까?

join()이라는 메소드를 사용하면 된다.

package nio;
 
public class Test1 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("sub 쓰레드 종료");
                    Thread.sleep(2000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main 쓰레드 종료");
    }
}
Colored by Color Scripter


메인 쓰레드에서 Thread t를 join시키면 메인 쓰레드는 t 쓰레드가 종료될때까지 기다린다.
```
