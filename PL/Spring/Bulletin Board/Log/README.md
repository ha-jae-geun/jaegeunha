# 	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);


# logger.info("writeView");


# SLF4J를 써야하는 이유
```JAVA
java진영에는 무수히 많은 로깅관련 모듈이 존재합니다.
전통적인 apache commons logging, log4j. 그리고 최근 사용되고 있는 logback이나 log4j2등이 있는데요. 
어떤것을 사용하든 개인 취향이긴 하지만 가급적이면 현재까지도 계속 버전업이 되고 있는 logback이나 log4j2를 사용하시라고 
권해드리고 싶습니다. 특히 log4j같은 경우에는 앞으로 나오게될 Java9버전에서 호환 이슈로 아예 동작하지 않는다는 
카더라통신이 있습니다. 그러므로 가급적 지금이라도 log4j를 쓰는 코드가 존재하다면 log4j2나 logback으로 교체하는 편이 
좋습니다. 물론 이쪽을 쓰는게 퍼포먼스 측면에서도 우월합니다.

그런데 말입니다.

만일 log4j를 걷어내고 logback으로 교체하는 업무가 주어졌다고 가정 해봅니다.
우리는 우선 maven이나 gradle에서 log4j의 dependency를 exclude하고 다시 logback을 추가를 합니다.

와 IDE에 시뻘건 불이 수백개가 번쩍 거리네요!!

요렇게 기존에 import했던 log4j의 수백개의 클래스가 뻘건줄을 내뿜기 시작했습니다.

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/// 생략 ///
Logger log = Logger.getLogger(this.getClass());
/// 생략 ///
log.info("blah blah log")
하지만 이정도로는 당황하지 않습니다. 다행히도 우리의 Eclipse와 Intellij는 한꺼번에 파일 텍스트를 replace해줄 
수 있는 기능이 있습니다. 아주 간단히 모든 import와 구문을 한꺼번에 바꿨습니다!! 그리고 이제 commit을 해야겠죠… 
수백개의 파일이 한꺼번에 커밋이 됩니다… 심지어 다른 사람이 지금 작성중인 소스들까지 모두 교체가 됩니다. 수십개의 
내가 모르는 파일이 Conflict가 납니다. 하나하나 파일을 손보지 않으면 방법이 없습니다. 이건 IDE도 어찌할 방법이 
없습니다. 오늘도 야근이네요.

이런 일이 발생하지 않기 위해서 slf4j를 써야합니다. Simple Logging Facade for Java (SLF4J)는 java의 로깅 
모듈들의 추상체라고 보시면 됩니다.

사용방법은 간단합니다. 그냥 사용하고 있는 패키지 매니저에 추가만 해주면 됩니다.
maven

<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
gradle

compile group: 'org.slf4j', name: 'slf4j-api', version: '1.7.25'
그리고 사실 알게모르게 이미 프로젝트에 추가 되있을 가능성이 매우 큽니다.

slf4j를 써야하는 이유는 간단하게 우리가 java 어플리케이션을 만들면서 왜 interface를 써야하는가와 이유가 
동일합니다. 우리는 실제 코드상에서는 slf4j의 interface코드를 사용하고 실제 로깅을 하는 구현체는 추가로 참조한 라이브러리에서 구현됩니다.

그리고 실제로 slf4j를 쓴다면 다음과 같은 코드가 되겠지요.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/// 생략 ///
Logger logger = LoggerFactory.getLogger(this.getClass());
/// 생략 ///
log.info("blah blah log")
이러면 만일 기존에 쓰고있던 log4j의 dependency를 제거한다 하더라도 수백개의 파일을 고치거나 내가 잘 모르는 영역을 
건드려야 된다거나 하는일이 발생하지 않습니다. log4j의 패키지나 class가 소스상에서 모두 사라졌으니깐요.

그리고 내가 다른 로깅 라이브러리를 쓴다고 하면 그냥 기존의 참조를 지우고 새로운 로깅 모듈을 붙이기만 하면 됩니다.

예를들면 마치 내가 헤어드라이기를 쓰기위해 220v 어뎁터에서 플러그를 하나 뽑고 헤어드라이기 플러그를 꼽는것처럼 
내가 쓰고싶은 로깅모듈을 플러그 꼽듯 slf4j에 꼽기만 하면 됩니다.

그리고 왠만한 java의 logging 모듈들은 slf4j의 브릿지를 이미 제공해주고 있습니다. 그 이야기는 내가 slf4j와 logback을 
연결하기 위해서 추가로 무언가를 구현 할필요가 없다는 얘기입니다. 이미 만들어진 브릿지를 mvnrepository에서 찾아서 넣기만 
하면 됩니다. logback을 쓰고 싶으면 slf4j-api를 log4j2를 쓰고 싶다면 log4j-slf4j-impl과 log4j-api를 추가하면 됩니다.

이미지처럼 어떤 모듈을 쓴다하더라도 slf4j로 접근할 수 있습니다.

개발자는 어떤 상황에든 대처하고 확장될 수 있는 느슨하고 유연한 코드를 만들어야 합니다. 따라서 하나의 라이브러리에 
너무 종속적이 되버리는 코드는 가급적 작성하지 않는쪽이 좋습니다. 그렇기에 어떤 라이브러리를 쓰든 동일하게 동작하는 
코드를 만들어야하고 그것이 slf4j를 써야하는 이유입니다.

근데 사실 이글을 작성하지 않더라도 이미 자바 개발자라면 다 아는 내용이고 거의 slf4j를 쓰고 있었을거 같긴한데 갑자기 
이 얘기를 꺼내는 이유는 우리가 자주 사용하는 오픈소스에도 위와 같은 문제를 보이는 코드를 발견해서…

(log4j를 exclude하려고 하는데 hadoop에서 에러가나서 결국 Exclude는 못하고 원치않게 어플리케이션 한개에 두개의 로깅 
모듈이 붙어버렸습니다. 로깅은 한개만 두고 싶은데.)
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
