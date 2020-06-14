# 스레드풀
```java
ThreadPool을 조심해라?
이 글을 쓰게 된 이유는 나의 안일함 때문이었다.

주기적으로 장비의 데이터를 수집하고 메세지를 만들어서 상위 시스템으로 데이터를 전송해야 하는 업무를 하고 있어서  

ScheduledThreadPoolExecutor를 사용하게 되었다.

이미 13개월전에 Timer를 비롯해서 정확한 주기로 작업을 실행해주는 것이라며 자랑스럽게(?) 올린 포스트가 있다.

그런데 ThreadPool 단어에 낚여 오해한 채 사용하고 있었다. 그래서 그 문제를 주의하고 정리하는 차원에서 글을 작성한다.

ThreadPool하면 떠오는 것 

자주 보이는 것 중 생각나는 것은 DBCP나 WAS의 ThreadPool이 떠오른다.

간단하게 설명하면, 각각의 Request에 대해서 각각의 쓰레드를 생성해서 수행하지 않고, ThreadPool에 Thread들을 미리 만들어놓고 

재사용하는 것으로 설명할 수있다.

재사용이니까 당연히 ThreadPool내의 Thread가 작업을 마치면, 작업 큐에 대기하고 있는 작업을 실행시키는 것으로 생각된다.

근데 ScheduledThreadPoolExecutor의 것은 조금 달랐다.

처음에는 위에서 설명한 방식과 마찬가지로 수행될 줄 알았다. 그래서 머릿속으로 아래와 같은 그림을 그렸다.


"ScheduledExecutorService는 잘은 모르겠지만 내부적으로 Timer같은 어떤 시간을 재주는 무언가 있을 것이고,

그 객체(Timer)가 설정한 주기(period)를 맞춘 후, 수행해야할 시간이 되면 작업(task)을 작업 큐에 넣어줄 것이고,

쓰레드풀에 있는 유휴(idle) 상태의 쓰레드가 있다면 그 쓰레드가 큐에 있는 작업을 수행해줄 것이다!"

뭐 이정도로 생각했다.

테스트도 없이 예상한 것이 맞겠지 하는 마음에 그냥 적용했다가 삽질만 했다.

@RestController
public class TestController {
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	private ScheduledExecutorService scheduledExecutorService;
	
	public TestController() {
		scheduledExecutorService = Executors.newScheduledThreadPool(8);
	}
	
	@PostConstruct
	public void test() {
		//수행시간이 긴 task (약 3초)
		Runnable task = () -> {
			logger.info("start");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("finish");
		};
		//0.1초마다 한번씩 task를 수행시켜주길 바라고 만듦
		scheduledExecutorService.scheduleAtFixedRate(task, 0, 100, TimeUnit.MILLISECONDS);
	}
}
위의 코드를 갖는 프로젝트를 만들어서 테스트를 해봤다.

코드설명을 하면 수행시간이 3초 정도 걸리는 Runnable task를 만들었고, 그 작업을 8개 쓰레드가 있는 ScheduledThreadPoolExecutor에 

100ms마다 수행하도록 등록했다.

그러면 task는 0.1초마다 수행되고, 작업은 3초씩 걸리니까 최초 수행 후 0.8초가 지나면, 쓰레드 8개가 전부 작업을 수행하고 있을 것이다.

그리고 최초 수행했을 때부터 0.1초마다 "start"가 찍히고 3초 후에는 0.1초 간격으로 "finish"가 찍히겠지 했지만... 결과는 아래와 같았다. 


쓰레드 번호는 바뀌는 모습은 그럴싸해 보이지만,

왼쪽에 로그가 찍히는 시간을 봐도 예상과 다름을 알 수 있고,

실제 로그 메세지가 start, finish가 번갈아 나오는 것을 보고도 이상함을 알 수 있다.

그래서 메서드 내부를 한 번 봤다. (실력이 부족해서 자세히는 못 봤다...)

그랬더니 결과적으로는 ScheduledThreadPoolExecutor에 등록된 task(runnable)별로 큐가 따로 존재하는 것 같았다.

* queue가 별도인지 확인하는 테스트는 아래와 같다.

@RestController
public class TestController {
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	private ScheduledExecutorService scheduledExecutorService;
	
	public TestController() {
		scheduledExecutorService = Executors.newScheduledThreadPool(8);
	}
	
	@PostConstruct
	public void test() {
		//수행시간이 긴 task (약 3초)
		Runnable task = () -> {
			logger.info("start");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("finish");
		};
		Runnable task2 = () -> {
			logger.info("1");
			logger.info("1");
		};
		//0.1초마다 한번씩 task를 수행시켜주길 바라고 만듦
		scheduledExecutorService.scheduleAtFixedRate(task, 0, 100, TimeUnit.MILLISECONDS);
		scheduledExecutorService.scheduleAtFixedRate(task2, 0, 1000, TimeUnit.MILLISECONDS);
	}
}
하나의 큐에 작업이 쌓인다면 0.1초마다 등록되는 task 때문에 수행시간이 짧은 task2마저 밀려서 실행이 안되야하는데 아래 

결과처럼 잘 찍힌다. * 고로 별도의 큐.


앞에 task가 수행시간이 길어져서 여전히 수행 중인지 확인하고 수행 중이라면 큐에만 넣고 다른 Thread는 그냥 유휴 상태로 있는다.

결국 8개의 쓰레드를 쓰레드풀에 만들어 놓았지만 ScheduledThreadPoolExecutor에 task가 하나만 등록되면 동시에 하나의 쓰레드만 일을 할 것이다.

그러면 ThreadPool을 왜 쓸까?

지금 위와 같은 경우는 ScheduledThreadPoolExecutor에 하나의 task만 넣었지만 주기가 다양한 task를 넣는다면 쓰레드를 계속 

생성하지않고 쓰레드풀의 쓰레드를 재사용할 것이다.

이것도 모르고 수행시간이 들쭉날쭉한 task를 넣어 놓고 왜 ScheduledThreadPoolExecutor가 제 때 실행시켜주지 않는가에 

대해서 꽤 오랜 시간 고민했었다.

다른 분들은 이 글을 보고 오해하지 않고 사용했으면 좋겠다.
```
