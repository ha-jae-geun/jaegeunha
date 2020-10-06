# [테코톡 로깅](https://www.youtube.com/watch?v=MxxeKXydn4A)

# 로그 파일
```java
src/main/resources에서 우 클릭 > new > Other...클릭
file을 검색하면 General에 File을 클릭하고 Next

File name에 log4jdbc.log4j2.properties 적어주시고 Finish클릭

그럼 log4jdbc.log4j2.properties파일을 열어줍니다.

파일에 코드를 추가해주고 저장합니다
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator

 
```

# SLF4J를 써야하는 이유
* [블로그](https://gmlwjd9405.github.io/2019/01/04/logging-with-slf4j.html)
```JAVA
프로그램 개발 중이나 완료 후 발생할 수 있는 오류에 대해 디버깅하거나 운영 중인 프로그램 상태를 모니터링 하기 위해
필요한 정보(로그)를 기록하는 것

애플리케이션 실행에 대한 추적을 기록하기 위해 어딘가에 메시지 (콘솔, 파일, 데이터베이스 등)를 작성하는 것
Logging을 어디에 이용할까
디버깅
사용자 상호 작용 기록 (발생하는 이벤트 기록)
Java의 주요 Logging Framework
native java.util.logging: 별로 사용하지 않는다.
Log4J: 몇 년 전까지 사실상 표준으로 사용했다.
Logback: Log4J 개발자가 만든 Log4J의 후속 버전, 현재 많은 프로젝트에서 사용되고 있다.
SLF4J(Simple Logging Facade for Java): Log4J 또는 Logback과 같은 백엔드 Logger Framework의 facade pattern(아래 참고)
tinylog: 사용하기 쉽게 최적화된 Java용 최소형(75KB Jar) 프레임워크
VS Debuggger
장점
Logging은 응용 프로그램 실행에 대한 정확한 컨텍스트(이벤트 순서)를 제공한다.
전체적인 app의 흐름이나 타이밍 error도 확인할 수 있다.
error 종류: 논리적 에러, 타이밍 에러(multi-thread) 등
일단 코드에 삽입되면 logging output이 만들어질 때 사용자 개입이 필요 없다.
로그 출력은 나중에 살펴볼 수 있도록 영구 매체에 저장할 수 있다.
disk에 기록을 남겨 유용한 로깅 정보를 추적할 수 있다.
Logging Framework는 Debuggger보다 간단하고 배우기 쉽고 사용하기 쉽다.
단점
출력문이 들어가기 때문에 응용 프로그램 속도를 늦출 수 있다.
너무 장황할 수 있다. (오버헤드)
메시지 level을 나누는 기능
고급 사용은 구성을 확실히 알아야 한다.
VS Plain Output(System.out.println())
장점
높은 유연성
우선순위 level 이상의 출력 메시지를 선택할 수 있다.
—trace, debug, info, warn, error—> high
모든 모듈 또는 특정 모듈 또는 클래스에 대해 메시지를 출력할 수 있다.
로그 메시지의 형식을 제어할 수 있다.
매개 변수화된 로그 메시지 지원
출력 위치를 지정할 수 있다.
SLF4J(Simple Logging Facade for Java)란
Log4J 또는 Logback과 같은 백엔드 Logging Framework의 facade pattern

다양한 Logging Framework에 대한 추상화
SLF4J는 추상 로깅 프레임워크이기 때문에 단독으로는 사용하지 않는다.
SLF4J api를 사용하면 구현체의 종류에 상관없이 일관된 로깅 코드를 작성할 수 있다.
배포할 때 원하는 Logging Framework를 선택할 수 있다.
Ex) logback/log4j/jdk14 - SLF4J - app
개발할 때, SLF4J API를 사용하여 로깅 코드를 작성한다.
배포할 때, 바인딩된 Logging Framework가 실제 로깅 코드를 수행한다.

 
교환 가능
Logging Framework 간에 쉬운 전환이 가능하다.
SLF4J는 세 가지 모듈을 제공한다. (API / Binding / Bridging)
SLF4J API 활성화
slf4j-api-1.7.25.jar (2017년 기준)
slf4j-api-1.8.0-beta2.jar (2019년 기준)
SLF4J 바인딩(.jar)
SLF4J 인터페이스를 로깅 구현체와 연결하는 어댑터 역할을 하는 라이브러리
사용하길 원하는 Logging Framework에 대한 SLF4J 바인딩을 추가해야 한다.
(반드시 한개만 사용)
SLF4J Bridging Modules
다른 로깅 API로의 Logger 호출을 SLF4J 인터페이스로 연결(redirect)하여 SLF4J API가 대신 처리할 수 있도록 하는
일종의 어댑터 역할을 하는 라이브러리
다른 로깅 API -> Bridge(redirect) -> SLF4J API
참고 facade pattern

여러 개의 클래스가 하나의 역할을 수행할 때, 대표적인 인터페이스만을 다루는 클래스를 두어 원하는 기능을 처리할수 있게 도와주는 패턴이다.
클라이언트는 Facade에 요청을 전송하여 Subsystem과 통신하며, Facade는 해당 요청을 적절한 Subsystem 객체로 전달한다.
Subsystem 객체가 실제 작업을 수행하지만 Facade는 인터페이스를 Subsystem 인터페이스로 변환하기 위해 자체 작업을 수행해야 할 수도 있다.
즉, 공통된 Interface를 적절하게 변환해서 연결한다.
Facade를 사용하는 클라이언트는 Subsystem 객체에 직접 액세스할 필요가 없다.
즉, 클라이언트는 Subsystem을 알 필요 없이 Common Interface에만 접근한다.
1) SLF4J API - “Hello World” using SLF4J
1. class path에 slf4j-api-1.7.25.jar 추가 (pom.xml)
<!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
2. HelloWorld 클래스를 컴파일하고 실행
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class HelloWorld {   
    public static void main(String[] args) {      
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);  
        logger.info("Hello World");   
    }
}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder". 
SLF4J: Defaulting to no-operation (NOP) logger implementation 
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
이 경고는 class path에서 slf4j 구현체를 찾을 수 없기 때문에 출력된다.
즉, class path에 사용하길 원하는 Logging Framework에 대한 slf4j 바인딩(.jar)을 추가해야 한다.
이때, 둘 이상의 slf4j 바인딩(반드시 하나만)을 두면 안된다.
Logging Framework를 전환하려면 class path에서 slf4j 바인딩을 변경한다.
Ex) java.util.logging —> log4j로 전환하려면
slf4j-jdk14-1.7.25.jar —> slf4j-log4j12-1.7.25.jar로 변경
2) SLF4J Binding
SLF4J 인터페이스를 로깅 구현체(Logging Framework)와 연결하는 어댑터 역할을 하는 라이브러리
SLF4J binding with a Logging Framework
각각의 SLF4J binding(.jar)은 compile time에 오직 하나의 Logging Framework를 사용하도록 바인딩한다.
class path에서 바인딩된 구현체가 발견되지 않으면 slf4j는 기본적으로 no-operation으로 설정된다. (즉, 출력되는 것이 없음)
사용하길 원하는 Logging Framework에 대한 SLF4J 바인딩을 추가해야 한다.
SLF4J binding 종류
사용하길 원하는 Logging Framework에 대한 SLF4J 바인딩을 추가해야 한다. (반드시 한개만 사용)
SLF4J binding(.jar))	Description
slf4j-log4j12-{version}.jar	널리 사용되는 로깅 프레임워크인 log4j 버전 1.2에 대한 바인딩.
또한 log4j.jar을 클래스 경로에 배치해야 한다.
slf4j-jdk14-{version}.jar	java.util.logging(JDK1.4 로깅)에 대한 바인딩.
slf4j-nop-{version}.jar	NOP에 대한 바인딩. 모든 로깅을 자동으로 삭제합니다.
slf4j-simple-{version}.jar	모든 이벤트를 System.err에 출력하는 단순 구현 바인딩.
INFO 이상의 메시지만 출력되므로 작은 응용 프로그램에서 유용하다.
slf4j-jcl-{version}.jar	JCL(Jakarta Commons Logging)에 대한 바인딩.
모든 SLF4J 로깅을 JCL에 위임한다.
logback-classic-{version}.jar	(logback-core-{version}.jar 필요) native implement
Logback의 클래스는 SLF4J의 인터페이스를 직접 구현한 것으로, SLF4J 프로젝트 외부에 SLF4J 바인딩이 있다.
따라서 Logback과 함께 SLF4J를 사용하면 메모리 및 오버헤드가 발생하지 않는다.
Logback의 ch.qos.logback.classic.Logger 클래스는 SLF4J의 org.slf4j.Logger 인터페이스를 직접 구현한 것이다.
예시: SLF4J binding with Logback

기본 Logging Framework로 logback-classic을 사용하려면
<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
    <exclusions>
        <exclusion>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
        </exclusion>
    </exclusions>
    <scope>compile</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-core -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-core</artifactId>
    <version>1.2.3</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
pom.xml에 ch.qos.logback:logback-classic" dependency 추가
이 dependency 하나만 추가해도 된다.
logback-classic가 의존하는 logback-core-1.2.3.jar뿐만 아니라 slf4j-api-1.7.25.jar를 자동으로 가져온다.
하지만 해당 artifact의 올바른 버전을 사용하는데 필요하기 때문에 모두 명시적으로 선언하는 것이 좋다.
애플리케이션 레이어에서 SLF4J를 사용해서 Logging 코드를 작성하면 실제 로그를 출력하는 행위는 Logback이 하게 된다.
3) SLF4J Bridging Modules
(SLF4J 이외의) 다른 로깅 API로의 Logger 호출을 SLF4J 인터페이스로 연결(redirect)하여 SLF4J API가 대신 처리할 수 
있도록 하는 일종의 어댑터 역할을 하는 라이브러리
Consolidate logging via SLF4J

프로젝트는 다양한 components로 구성된다.
components 중 일부는 SLF4J 이외의 로깅 API에 의존한다.
Ex) spring-context는 JCL(Jarkarta Commons Logging) API를 사용
이러한 상황을 처리하기 위해 SLF4J에는 여러 Bridging Module이 제공된다.
Bridging legacy logging APIs

여러 다른 로깅 API를 사용하는 components에 대해 single channel을 통해 Logging을 통합하는 것이 바람직하다.
이를 위해 SLF4J에서 log4j API, JCL(Jakarta Commons Logging) API 및 JUL(Java Util Logging) API에 대한 호출을 대신
SLF4J API에 대한 것처럼 리디렉션하는 여러 Bridging Modules을 제공한다.
SLF4J가 제공하는 Bridge의 종류
겉으로는 다른 로깅 API를 사용하는 것 같지만 내부에서는 SLF4J API를 호출하도록 일종의 어댑터 역할을 해주는 라이브러리
다른 로깅 API -> Bridge -> SLF4J API
SLF4J binding(.jar))	Description
jcl-over-slf4j.jar	JCL API에 의존하는 클래스들을 손상시키지 않고 JCL로 들어오는 호출을 JCL-over-SLF4J를 이용해서 SLF4J API를 호출한다.
즉, 이 모듈을 사용하면 JCL을 사용하는 기존 소프트웨어와의 호환성을 손상시키지 않으면서 프로젝트를 SLF4J로 단편적으로 마이그레이션할 수 있다.
log4j-over-slf4j.jar	이 모듈을 사용하면 log4j 호출을 SLF4J API로 리디렉션할 수 있다.
jul-to-slf4j.jar	이 모듈을 사용하면 java.util.logging 호출을 SLF4J API로 리디렉션할 수 있다.
사용 시 주의할 점

jcl-over-slf4j.jar
JCL API 사용 X —> 의존성에서 commons-logging.jar 제거
SLF4J Binding인 slf4j-jcl-{version}.jar와 같이 쓸 수 없다. (무한루프)
log4j-over-slf4j.jar
Log4J API 사용 X —> 의존성에서 log4j.jar 제거
SLF4J Binding인 slf4j-log4j12-{version}.jar와 같이 쓸 수 없다. (무한루프)
jul-to-slf4j.jar
java.util.logging은 교체 불가능 (LogRecord 객체를 사용해서 위임)
SLF4J Binding인 slf4j-jdk14-{version}.jar와 같이 쓸 수 없다. (무한루프)
참고 JCL(Jakarta Commons Logging)

Log4j, LogKit, JDK1.4과 같은 다른 Logging Framework에 대한 추상화 계층을 제공하는 인터페이스
로깅 라이브러리가 아니라 로깅 추상화 라이브러리
로깅 라이브러리 선택권은 애플리케이션 개발자의 것이다.
따라서 프레임워크는 주로 로깅 추상화 라이브러리를 사용하는 것이 좋다.
단점
실제 Logging Framework을 선택하는 시점이 runtime이라 클래스 로더 문제
클래스 로더에 의존적인 방법으로 구현체(Logging Framework)를 찾는다.
런타임 시 오버헤드
예시: Logging with SLF4J and Logback


필요한 라이브러리
... 
    위의 SLF4J binding with Logback 내용과 동일 
    logback-classic
    logback-core
    slf4j-api
...
<!-- https://mvnrepository.com/artifact/org.slf4j/log4j-over-slf4j -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>log4j-over-slf4j</artifactId>
    <version>1.7.25</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.slf4j/jcl-over-slf4j -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>jcl-over-slf4j</artifactId>
    <version>1.7.25</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.slf4j/jul-to-slf4j -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>jul-to-slf4j</artifactId>
    <version>1.7.25</version>
</dependency>
SLF4J API (인터페이스)
로깅에 대한 추상 레이어를 제공
사용자가 이 interface를 통해 로깅 코드를 작성한다.
slf4j-api
SLF4J Binding(.jar)
SLF4J 인터페이스를 로깅 구현체로 연결하는 어댑터 역할을 하는 라이브러리
SLF4J에 구현체(Logging Framework)를 바인딩하기 위해 사용한다.
여러 바인딩 중 하나만 사용할 것
[Logback] logback-classic / [Log4J] slf4j-log4j12

 
Logging Framework
실제 로깅 코드를 실행할 Logging Framework를 정한다.
[Logback] logback-core / [Log4J] log4j-core
SLF4J Bridging Module
다른 로깅 API -> Bridge(redirect) -> SLF4J API
다른 로깅 API로의 Logger 호출을 SLF4J 인터페이스로 연결(redirect)하여 SLF4J API가 대신 처리할 수 있도록 
하는 일종의 어댑터 역할을 하는 라이브러리

log4j-over-slf4j, jcl-over-slf4j, jul-to-slf4j
Logging Framework를 변경하고 싶으면 2, 3번을 교체
SLF4J 특징
배포시 Logging Framework 선택 가능
compile time에 오직 하나의 Logging Framework를 사용하도록 바인딩
빠른 속도로 작동
클래스가 JVM에 의해 로드되는 방식으로 인해 프레임워크 바인딩은 초기에 자동으로 확인된다.
널리 사용되는 Logging Framework를 위한 바인딩 제공
log4j, java.util.logging, 단순 로깅 및 NOP를 지원
logback 프로젝트는 기본적으로 SLF4J를 지원
Bridging legacy logging API
log4j API, JCL(Jakarta Commons Logging) API 및 java.util.logging API에 대한 호출을 대신 SLF4J API에 대한 것처럼 리디렉션하는 여러 Bridging Modules을 제공
Migrate your source code
SLF4J-Migrator utility를 사용하면 SLF4J를 사용하는 소스를 마이그레이션할 수 있다.
매개 변수화된 로그 메시지 지원
https://gmlwjd9405.github.io/2019/01/04/logging-with-slf4j.html
```


# 로그백
```JAVA
package dololak;
 
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
 
public class LoggerTest {
     public static void main(String[] args) {
         //패키지 경로를 포함한 클래스명 또는 .class를 통해  Logger를 얻는다.
         Logger logger = LoggerFactory.getLogger("dololak.LoggerTest");
//       Logger logger = LoggerFactory.getLogger(LoggerTest.class);
         logger.debug("Hello world.");
     }
}
Colored by Color Scripter
cs


프로젝트에 정상적으로 라이브러리를 설정해 두었다면 코드 실행 결과는 다음과 같을것입니다. 
실행 시간대나 패키지명에 따라 다르게 출력될 수 있지만 Hello world 라는 로그가 출력됩니다.

 
13:24:38.457 [main] DEBUG dololak.LoggerTest - Hello world.
cs


먼저 logging을 하기 위해 Logger 객체를 얻어야 하는데 static 메서드인 LoggerFactory.getLogger() 
메서드를 통해 얻을 수 있습니다. getLogger() 메서드에는 얻고자 하는 Logger명을 지정해 주어야 합니다.
 
패키지 경로를 포함한 클래스명 또는 클래스.class를 전달하여 얻을 수 있습니다. 프로젝트에는 slf4j-api를 
구현한 logback을 등록해 두었기 때문에 LoggerFactory.getLogger()는 내부적으로 logback이 구현한 Logger 타입의 인스턴스를 돌려줄것입니다.
Logger logger = LoggerFactory.getLogger("dololak.LoggerTest"); 또는
Logger logger = LoggerFactory.getLogger(LoggerTest.class);
cs


위의 코드의 import문을 보면 알겠지만 모두 org.slf4j의 클래스만을 사용한것을 볼 수 있습니다. logback은 slf4j 
API를 구현하였기 때문에 logback 클래스를 직접적으로 사용하지 않고도 logback을 사용하여 로깅을 할 수 있습니다. 
이렇게 하면 slf4j를 구현한 다른 로깅 프레임워크를 사용하게 되더라도 이식하기가 편하고 어플리케이션(slf4j를 사용하는)은
slf4j에 대한 스펙만 알면 된다는 장점이 있습니다.




Logback 설정 파일이 없는데 어떻게 로그가 출력되었나?
Logback에서는 다음과 같은 우선순위로 설정을 참고합니다.

1. classpath 경로에 logback-test.xml이 있는지 확인하고 있으면 그것을 logback 설정으로 사용합니다.
2. classpath 경로에 logback.groovy가 있는지 확인하고 있으면 그것을 logback 설정으로 사용합니다.
3. classpath 경로에 logback.xml이 있는지 확인하고 있으면 그것을 logback 설정으로 사용합니다.
4. 만약 모두 찾지 못했다면 기본 설정인 BasicConfigurator를 사용합니다.

더욱 자세한 내용은  https://logback.qos.ch/manual/configuration.html 를 참고합니다.




설정파일이 없는 경우 사용되는 BasicConfigurator 전략
logback 설정을 따로 하지 않는 경우 기본 설정을 참고하게 되는데, 콘솔로 로그를 출력하는 ConsoleAppender를 
사용하며, 출력 패턴은 아래와 같은 포맷을 사용하게 됩니다.
%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n
cs



Logback XML 설정하기(logback.xml)
앞서 설명했지만 Logback은 어플리케이션에 설정되어있는 classpath 경로상에 logback-test.xml, logback.groovy, 
logback.xml 파일이 있는지 검사하여 존재하는 경우 우선순위에 따라 설정파일로 사용합니다.

보통은 logback.xml파일을 classpath 경로에 작성해 두고 사용합니다.(예를 들어 myapp/src/main/resources/logback.xml 
등으로 작성해 둘 수 있습니다.)
여튼 가장 심플하고 기본적인 설정 내용은 다음과 같습니다.
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
 
 
  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <!-- encoders are assigned the type
         ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
    <encoder>
      <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
    </encoder>
  </appender>
 
 
  <root level="debug">
    <appender-ref ref="STDOUT" />
  </root>
</configuration>
Colored by Color Scripter
cs



Appender 설정
logback 설정은 <configuration>태그 하위에 작성합니다. <appender>는 Appender에 관한 설정으로 로그 출력 
대상에 대한 설정입니다. 종류에 따라 로그파일이 될수도 있고, 콘솔(터미널)이 될수도 있고, 네트워크상의 다른 어플리케이션이나
DBMS일수도 있습니다. 여기서는 콘솔에 로그를 출력하기 위한 ConsoleAppender를 설정했습니다.

자세한 설명은 다음의  https://logback.qos.ch/manual/appenders.html 경로를 참고합니다.



출력 패턴(pattern) 설정
<pattern>은 PatternLayoutEncoder를 통해 로그를 출력할 때 로그 출력 패턴 형식을 지정할 수 있습니다.
예를 들어 %d{시간형식} 등 입니다.
자세한 설명은 https://logback.qos.ch/manual/layouts.html 경로를 참고합니다.


Root Logger
<root> 설정은 루트 Logger 에 대한 설정입니다.
로거(Logger)는 logback 안에 여러개가 설정될 수 있습니다. 하나의 어플리케이션이라고 하더라도 패키지별 또는 
기능별로 다른 로그파일에 출력한다든지 오류는 A.log 파일에, 기본 로그는 콘솔에 출력한다든지 여러가지의 Logger가 필요할 수 있기 때문입니다.

이후에 시간이 된다면 logback 설정에 대해 자세히 다루어볼 예정인데 <logger> 라는 태그로 여러개의 로거를 설정할 
수 있고 각 로거별로 구분할 수 있는 이름(name)을 지정할 수 있습니다.

로거에 설정된 이름(name)은 LoggerFactory.getLogger(logger 이름) 으로 로거를 구해올 때 어떤 로거를 리턴해줄것인지에 대한 구분조건이 됩니다. 
그런데 getLogger()에 지정해준 이름에 해당하는 로거가 존재하지 않는 경우 기본적으로 이 Root Logger가 리턴됩니다.


출처: https://dololak.tistory.com/631 [코끼리를 냉장고에 넣는 방법]
```
