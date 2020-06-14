# WatchService
```java
Java File Change Notification, Monitoring, WatchService

0. 긴~~ 사족

다양하게 키워드를 준비해봤다.

업무에서 Application Runtime중에 어떤 파일의 데이터(meta-data, properties 등...)가 변경되면 이벤트를 받아 다시 데이터를 

메모리로 적재하는(reload) 기능이 필요했다.

이 기능은 꽤나 광범위하게 쓰이고 있다.

eclipse, IntelliJ 같은 IDE에서 파일이 변경되면 즉시 변경된 파일에 (*)별 표시가 뜨는 것과 Spring 같은 경우는 devtools를

dependency로 추가하면 파일이 변경될 때마다 서비스를 재시작해주는 기능등이 있다.

또한 설정 값(Properties) 변경을 알려주는 기능은 그냥봐도 너무 많다.

apache commons configuration2 오픈 소스 라이브러리로 감지 가능
File클래스의 lastModified(); 메소드로 수정된 날짜를 받아와서 변경 감지하는 기능
Spring Cloud Config로 config server를 만들고 github에 있는 파일이 변경되면 client들에게 변경된 값을 가져갈 수 있게 하는 기능 
Spring의 ReloadableResourceBundleMessageSource 클래스 사용해서 감지하는 기능
Java API WatchService로 변경된 파일 감지하는 기능
여기서 중점적으로 소개하고자 하는 자바 API는 WatchService다. (since java 1.7)

바로 이 WatchService라는 인터페이스가 어떠한 디렉토리를 감시하고 수정사항이 생겼을 때 알림을 받아서 어떠한 액션을 취할 수 있게 해준다.

사실 위에서 가장 핫(?)한 기능은 Spring Cloud Config다.

똑같은 기능을 하는 여러 대의 Server에 변경된 Configuration을 한 번에 지정하는 식의 서비스라 아주 유용하다.

그런데 이것은 오픈된 서비스(?) 웹 서비스같은 데에서 사용하기 좋고 개인적으로 업무에서 폐쇄망이기 때문에 따로 유레카와

같은 Config server를 둔다는 것은 꽤나 피곤한 일이다.

따라서 나는 쉽고, 빠르고, 강력한 자바 API를 이용할 계획에 코드를 짜보았다.

* 참고로 오픈 소스보다 Java API인 WatchService가 더 성능적으로 좋다는 글들이 보인다.

(https://www.baeldung.com/java-watchservice-vs-apache-commons-io-monitor-library

https://stackoverflow.com/questions/32887364/apache-commons-io-file-monitoring-vs-jdk-watchservice

https://www.reddit.com/r/java/comments/5k8hr8/java_watchservice_api_vs_apache_commons_io_monitor/)

사용법

package com.example.demo.controller;
 
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
 
import javax.annotation.PostConstruct;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class TestController {
    //프로젝트 경로
    private static final String projPath = System.getProperty("user.dir");
    
    private WatchKey watchKey;
    
    @PostConstruct
    public void init() throws IOException {
        //watchService 생성
        WatchService watchService = FileSystems.getDefault().newWatchService();
        //경로 생성
        Path path = Paths.get(projPath);
        //해당 디렉토리 경로에 와치서비스와 이벤트 등록
        path.register(watchService,
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_DELETE,
            StandardWatchEventKinds.ENTRY_MODIFY,
            StandardWatchEventKinds.OVERFLOW);
        
        Thread thread = new Thread(()-> {
            while(true) {
                try {
                    watchKey = watchService.take();//이벤트가 오길 대기(Blocking)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<WatchEvent<?>> events = watchKey.pollEvents();//이벤트들을 가져옴
                for(WatchEvent<?> event : events) {
                    //이벤트 종류
                    Kind<?> kind = event.kind();
                    //경로
                    Path paths = (Path)event.context();
                    System.out.println(paths.toAbsolutePath());//C:\...\...\test.txt
                    if(kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
                        System.out.println("created something in directory");
                    }else if(kind.equals(StandardWatchEventKinds.ENTRY_DELETE)) {
                        System.out.println("delete something in directory");
                    }else if(kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
                        System.out.println("modified something in directory");
                    }else if(kind.equals(StandardWatchEventKinds.OVERFLOW)) {
                        System.out.println("overflow");
                    }else {
                        System.out.println("hello world");
                    }
                }
                if(!watchKey.reset()) {
                    try {
                        watchService.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
    @GetMapping("/")
    public String test() {
        System.out.println(projPath);        
        return "hello";
    }
}
 
Colored by Color Scripter
cs
1. WatchService 인터페이스 생성

WatchService watchService = FileSystem.getDefault().newWatchService();

2. 모니터링하고 싶은 디렉토리 패스 클래스 생성

Path path = Paths.get("원하는 경로");

3. 경로에 생성한 와치서비스와 감지하고 싶은 이벤트 등록

path.register(watchService, StandardWatchEventKinds...);

4. WatchKey로 watchService에 이벤트가 오면 받아뒀다가 이벤트 검사해서 원하는 액션취하기

watchKey = watchService.take();

주의 사항, 알아야 할 것

위와 같은 순서로 작성하면 되고 알아둬야 할 것은 아래와 같다.

- watchKey는 한 번 사용하고 나면 반드시 reset()을 호출해줘야 다시 이벤트를 받을 수 있다.

reset()메소드는 올바르게 리셋되면 true를 리턴해주고 감지하던 디렉토리가 없어지는 등의 어떠한 문제가 발생하면 false를 리턴해준다.

추가적으로 무언가 문제가 생기면 watchService도 close()시켜주는 것이 좋다.

- watchService는 이벤트 방식이다.

polling하는 식의, 무언가 interval을 두고 계속해서 checking하는 형식이 아닌 것으로 알고 있다. (정확히는 모르겠음)

테스트해보니까 while(true)가 걸려 있는데 sleep도 따로 없고 cpu 사용량이 엄청나게 늘어나는 것은 보지 못했다.

아마 운영체제단에서 이벤트를 주면 자고 있는 쓰레드를 깨우는? 방식인 것으로 추측해볼 수 있다.

- 한 번에 여러개의 이벤트가 발생할 수 있다.

여러 번은 아님. 같은 이벤트가 여러 번 잡히지는 않는다.

다만 테스트해본 결과 처음 txt파일을 만들었을 때 '생성' 이벤트와 '변경' 이벤트가 같이 올라왔다.

아마 파일이 생성된 것을 알려주고 디렉토리 입장에서는 파일이 생기면서 변경이 일어나서 변경 이벤트도 주는 것 같다.

파일 내부를 수정했을 때는 '변경' 이벤트만 올라왔고 삭제도 마찬가지로 '변경'과 '삭제' 둘 다 일어났다.

필자의 경우에는 '변경' 이벤트만 걸어두면 될 것 같다.

watchKey.pollEvents()로 이벤트를 List로 주는 것만 봐도 알 수 있다. 여러 개의 이벤트가 발생할 수 있음을...

- 파일을 지정할 수 없다.

감지하는 경로로 반드시 디렉토리를 지정해야한다.

하나의 파일만 감지하는 것은 없는 것 같다. 파일을 감지하고 싶을 때는 위에 event.context()로 이벤트가 발생한 파일 이름을 가져올 

수 있으니 따로 처리해야 할 것 같다.

- 무한 루프 주의

이벤트가 감지될 때마다 로그를 찍고 있는 상황에서 로그 디렉토리를 감지하면 어떻게 될까..?

이벤트 발생 -> 로깅 -> 이벤트 -> 로깅 -> 이벤트 -> 로깅 -> ...

무한으로 루프가 돌면서 PC 자원을 잡아먹을 것이다.

- 디렉토리의 서브 디렉토리(하위 디렉토리)에 변경 사항이 생겨도 감지한다.

위의 무한루프같은 경우에도 일부러 저렇게는 지정 안하겠지만 나도 모르게 서브디렉토리에 로그폴더가 있어서 변경이 감지되는 경우도 있을 것이다.

변경을 감지하는 디렉토리는 웬만하면 하위디렉토리면 좋고 파일의 수도 많지 않은 것이 좋을 것 같다.
```
