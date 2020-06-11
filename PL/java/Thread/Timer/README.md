# Thread Timer
```java
자바 쓰레드를 거의 정확한 주기로 실행하는 방법 (사족)

"정확한 주기"로 실행하는 방법을 쓰게된 이유는 거의 비슷할 것이다.

어떤 애플리케이션을 개발할 때 백그라운드에서 일정 주기마다 어떤 값을 검사하거나 보내는 등의 특정 로직을 수행하는 
기능(쓰레드)이 필요하기 때문이다.

나 역시도 데이터를 짧은 주기마다 보내야하는 로직이 필요했다.

그래서 쓰레드의 주기하면 단순하게 떠오르는 것이 Thread.sleep() 메소드였다.



- sleep()으로 될까?

단순하게 쓰레드의 run() 메소드에 sleep(1000);을 적어서 1초쉬고 해당로직을 수행하게 했다.

시간(주기)이 애플리케이션에서 치명적이지 않다면 간단하면서 쉬운 방법이다.

하지만 시간이 정확해야하는 애플리케이션에서는 로직 수행시간이 추가되면서 지속적인 오차 또는 시간 밀림 현상이 나타난다.

  1초 != sleep(1000) + 로직 수행 시간



- 동적 sleep()을 줘볼까?

그래서 생각해낸게 로직 수행 시간을 계산해서 주기(1초)에서 뺀 만큼만 sleep()을 걸면 어떨까? 라는 생각이었다.

예를들어 로직수행시간이 0.1초가 걸리면 0.9초(sleep(900))만큼 쓰레드를 중지시키는 것이다.

이제 걸리는 시간을 System.nanoTime() 를 사용해서 계산했다. (System.currentTimeMillis()로는 계산이 불가할 정도로 짧은 수행시간..)

계산 결과를 적용할 수 있는 sleep이 있나 찾아보니 실제로 Thread.sleep(long , long) 메소드가 있었다.

첫 번째 파라미터는 밀리초 단위의 long값이고 두 번째 파라미터는 나노초 단위의 long값이다.

이 메소드는 밀리초 + 나노초 시간 만큼 sleep한다. (단, 뒤에 나노초는 ns<1,000,000)

결론부터 말하면 1밀리초정도 밀린다.

* 계산하는 로직(실험에서는 for문 100만번 반복하며 + 연산)이 실행되는 환경마다도 다르고 수행시간을 계산하는 시간은
또 포함이 안되었기 때문에 보정을 해줘서 조금 덜 밀릴수는 있지만 어쨋든 밀린다.



- setInterval(), 콜백 메소드 같이 쉬운거 없나? 

자바스크립트가 그리웠다... 콜백메서드로 해당 주기로 실행만 위임시키고 싶었다..



자바 쓰레드를 거의 정확한 주기로 실행하는 방법

sleep()을 버리고 적당한 것을 찾았다.

바로 Timer 클래스를 이용하는 방법이다.

import java.util.Timer;
import java.util.TimerTask;
public class JavaTimerTest {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int result = 0;
                // 특정 로직
                for(int i=0;i<10000;i++) {
                    for(int j=0;j<10000;j++) {
                        result = i+j;
                    }
                }
                //이부분에 send()같은 것이 들어갈 것
                System.out.println(System.currentTimeMillis());
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
Colored by Color Scripter


TimerTask를 만들고 특정로직은 for로 100,000,000번 반복하는 코드로 대체했다.

그리고 timer객체의 .scheduleAtFixedRate(task, delay, period) 메소드를 호출했다.

해당 메소드는 task를 delay만큼 지연시킨 후에 period마다 실행하는 메소드다.



currentTimeMillis()로 찍은 내용으로 끝에서 4번째 자리를 통해 1초 주기마다 정확히 찍고 있는 것을 알 수 있고 이하 
자리를 보면, 특히 가장 마지막자리인 1밀리초단위를 보면 9 또는 0으로 미묘한 차이만 있을 뿐 거의 정확한 주기로 실행되고 
있음을 알 수 있다.



하지만 좀 더 알아보니 Timer클래스는 특유의 문제가 있다고 한다.

명확히 그 문제가 무엇인지 찾아보지 않았지만 어쨋든 나는 주기적으로 쓰레드를 여러 개를 돌릴 것이기 때문에 더 정확하고 효율적인 것을 찾아보았다.

바로 ScheduledExecutorService 라는 클래스다.

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
 
public class JavaTimerTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            int result=0;
            @Override
            public void run() {
                for(int i=0;i<10000;i++) {
                    for(int j=0;j<10000;j++) {
                        result = i+j;
                    }
                }
                //이부분에 send()같은 것이 들어갈 것
                System.out.println(System.currentTimeMillis());
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 100, TimeUnit.MILLISECONDS);
    }
}
 
Colored by Color Scripter
cs
해당 서비스를 만들어서 Timer와 유사하게 scheduleAtFixedRate(실행가능객체, 지연시간, 주기, 단위)를 사용한다.

특징은 TimeUnit이라는 단위가 여러가지가 있다. (초, 밀리초, 마이크로초, 나노초 등...)

그래서 해당 주기가 100이지만 밀리초를 썼기때문에 결국 0.1초마다 runnable 객체를 실행하는 것이다.



0.1초 단위이기 때문에 끝에서 세 번째자리를 보면 1씩 올라가는 것을 볼 수 있고, 마지막 자리인 
1밀리초 자리도 9~2 사이로 왔다갔다하는 약간의 오차가 있지만 거의 정확하게 0.1초마다 수행하는 것을 알 수 있다.



결과적으로는 자바 쓰레드를 특정 주기마다 수행하고 싶은 경우에 ScheduledExecutorService를 만들어서 사용하면 된다.

위에 처럼 꼭 newSingleThreadScheduledExecutor()로 만들 필요는 없고 쓰레드풀로 만들어 써도 된다.
```
