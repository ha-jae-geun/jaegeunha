# 로깅
```java
로깅

자바개발자 대부분은 문제가 있는 코드에 System.out.println호출을 집어넣어 프로그램 동작을 살펴보는 과정에 익숙하다.

이해하고나면 출력문을 지우고 문제가 다시 생기면 다시 넣는다. 이를 해결하기 위해 로깅API가 설계되었다.

간단한 로깅

정보 메시지를 로그로 기록하려면 info 메서드를 사용해야한다.

Logger.getGlobal().info("Opening file" + filename);

Logger.getGlobal().info( () -> "Opening file" + filename ); // 람다식표현 이용

로거

전문적인 애플리케이션에서는 보통 전역 로거 하나로 모든 레코드를 로그로 기록하지 않는다.

대신 로거를 직접 정의해서 사용한다.

Logger logger = Logger.getLogger("com.mycompany.myapp");

패키지 이름과 유사하게 로거 이름은 계층구조다.

로깅 레벨은 SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST가 있다. 기본적으로는 INFO 이상만 로그로 기록하지만 변경가능하다.

logger.setLevel(Level.FINE); // FINE이상 레벨을 다 로그로 출력

기타 로깅메서드

void entering(String className, String methodName)

void exiting(String className, String methodName)

예기치 못한 예외를 로그로 기록 할 때

void log(Level l , String message, Throwable t)

void throwing(String className, String methodName, Throwable t)

로그핸들러

로거는 레코드를 ConsoleHandler로 보낸다. ConsoleHandler는 레코드를 System.err 스트림에 출력한다.
```
