# 서블릿 관련
* servlet-api.jar, jsp-api.jar

# 로그인 관련
* commons-logging-1.2.jar


## connection 풀
- http://jakarta.apache.org/ 
- collection, dbcp, pool, logging 다운
1. ① commons-collections4-4.0.jar ⎼확장 또는 자바 컬렉션 프레임워크를 확장한다. ⎼자바 컬렉션 프레임워크는 추가 되었으며 응용 프로그램의 개발을 가속화 많은 강력한 JDK 1.2 Java 데이터 구조를 추가할 수 있다. 
2. ② commons-dbcp2-2.0.jar ⎼데이터베이스 연결 풀링 서비스를 제공한다. ⎼연결 풀링 서비스는 관계 데이터베이스에서 새로운 연결을 위한 필요한 데이터베이스 트랜잭션을 수 행 시간에서 걸리는 시간을 최소화 할 수 있다. 
- 환경설정 -> 클래스; BasicDataSource
maven: 자동빌드;의존 관계가 있는 라이브러리를 자동으로 등록해주는 기능이다; 파이썬의 아나콘다
3. ③ commons-pool2-2.2.jar ⎼일반 인스턴스 풀링 구성 요소이다. ⎼아파치 커먼즈 풀 오픈 소스 소프트웨어 라이브러리는 인스턴스 풀링 및 개체 풀 구현을 제공한 API 다. 
- 커넥션을 담는 것
4. ④ commons-logging-1.2.jar ⎼로깅 구현의 다양한 클래스로 라이브러리 정보를 기록한다 API . ⎼log 인스턴스를 가져와서 쓰는 창구 역할로 실제 구현체는 의 나 그리고 기타 java logging API log4j 로거 모듈을 가져다 사용한다. ⎼ 은 로깅 요청을 기존에 존재하는 다양한 에 전 Common Logging(JCL) logging API implementations 달하는 역할을 한다. ⎼ 을 사용할 경우에 로깅 요청이 왔을 때 해당 라이브러리를 이용해서 를 출력할 수 있게 해 주 JCL log 며 전달받는 구현체를 바꿀 수 있어서 어떠한 를 사용하던 logging API logging API implementations 지에 상관없이 동일한 방법을 개발을 할 수 있다. 
- logging 사용하면 sys처럼 실행에 영향주지 않고 결과 확인 가능


# 오라클
```java
가. ojdbc14.jar 파일
⎼JDK1.4를 지원하는 파일이므로 JDBC3과 JDBC4 특징들이 구현되어 있지 않다.
나. ojdbc5.jar 파일
⎼JDK5의 JDBC API를 구현한 드라이버 클래스 파일로 JDK5, 6, 7, 8에서 사용할 수 있다.
다. ojdbc6.jar 파일
⎼JDK 6의 JDBC API를 구현한 드라이버 클래스 파일로 JDK6, 7, 8에서 사용할 수 있다.
라. ojdbc7.jar 파일
⎼JDK7의 JDBC API를 구현한 드라이버 클래스 파일로 JDK7, 8에서 사용할 수 있다.
② ojdbc6_g.jar 파일
⎼ojdbc6_g.jar 파일은 javac -g 옵션으로 컴파일 된 파일이다.
⎼-g 옵션은 모든 디버그 정보를 생성하는 옵션으로 프로그램의 실행에 관한 정보를 기록하기 위한 로깅의 특별한
사용 소스인 트레이싱 코드를 포함한다는 점만 ojdbc6.jar 파일과 다르다.
⎼개발시에는 ojdbc6_g.jar 파일이 오류를 추적하기 더 좋지만 운영시에 ojdbc6_g.jar 파일은 불필요한 로그를
생성시킬 수 있으므로 ojdbc6.jar 파일을 사용하는 것이 좋다.
```

# DataSource
```java
JDK 1.4부터 생긴 DataSource 인터페이스는 커넥션 공장으로 3종류의 구현체가 있다.
⎼context.xml 의 factory 속성에서 톰켓 DBCP 와 자카르타 DBCP 의 설정에 관계없이 공통으로 사용하자고 할
때는 DataSource 인터페이스를 사용하며 예외처리가 발생하지 않도록 하기 위해 일반적으로 권장한다.
① 기본 구현체 : 표준 커넥션 객체를 생산한다.
② 커넥션 풀링 구현체 : 자동으로 커넥션 풀에 참여하는 커넥션 객체를 생산하며 이 구현체는 미들 티어 커넥션
풀링 매니저와 함께 작업한다.
③ 분산 트랜잭션 구현체 : 분산 트랜잭션을 위한 커넥션 풀에 참여하는 커넥션 객체를 생산하며 이 구현체는
미들 티어 트랜잭션 매니저와 커넥션 풀링 매니저와 함께 작업한다.
DBCP 는 javax.sql 패키지의 DataSource 인터페이스를 구현한다.
⎼커넥션 풀을 사용시 주의할 점은 작업이 완료되었으면 기존처럼 Connection 인터페이스 객체의 close 메서드를
사용하여 자원을 반납하지 않고 Connection 인터페이스 객체를 저장소에 복귀시켜야 하는 것은 지금껏 사용했던
커넥션이며 커넥션 풀링용 커넥션인 DataSource 인터페이스는 close 메서드로 커넥션을 풀로 복귀시킨다.
⎼DataSource 인터페이스는 close 메서드로 반드시 자원을 해제해야 한다.
```

# DBCP
```java
⎼커넥션 풀의 Connection 인터페이스 객체는 재사용이 가능하기 때문에 사용자가 접속할 때마다 계속해서 Connection
인터페이스 객체를 생성할 필요가 없으므로 커넥션 풀을 사용하면 프로그램 효율과 성능이 전체적으로 증가하게
된다.
⎼

웹 애플리케이션과 같이 다수의 사용자의 정보 저장이 필요할 때 주로 DB를 이용하는데 DBMS나 기타 외부와의
접속이 빈번하게 필요한 시스템에는 반드시 있어야 하는 기능 가운데 하나가 커넥션 풀이다.
⎼Java 프로그램에서 데이터베이스 Connection 인터페이스 객체를 맺는 일은 매우 느리며 자원을 많이 소모하는
작업이며 불특정 다수의 사용자들이 동시에 데이터베이스의 Connection 인터페이스 객체를 요구한다면 최악의
경우 서버가 다운되기도 하므로 이것을 방지하기 위해 커넥션 풀을 이용한다.

(1) 톰켓 DBCP
⎼톰켓 의 폴더에 파일은 라이브러리가 7 lib tomcat-dbcp.jar dbcp 내장되어 있어 별도의 라이브러리를 등록하지
않아도 되지만 권장하지 않는다.

(2) 자카르타 DBCP
⎼자카르타 DBCP API는 널리 쓰이는 커넥션 풀 중 하나이며 자카르타 DBCP API를 사용하기 위해서는 먼저 자카르타
DBCP API 관련 jar 파일을 설치해야 하며 DBCP에 관한 정보 설정을 위해 유틸 클래스 파일을 작성해야 한다.
⎼자카르타 DBCP API 관련 commons-collections4-4.0.jar, commons-dbcp2-2.0.jar, commons-pool2-2.2.jar,
commons-logging-1.2.jar를 다운받아서 USer Libraries 에 등록한다.
① commons-collections4-4.0.jar
⎼ 확장 또는 자바 컬렉션 프레임워크를 확장한다.
⎼자바 컬렉션 프레임워크는 JDK 1.2 추가 되었으며 Java 응용 프로그램의 개발을 가속화 많은 강력한
데이터 구조를 추가할 수 있다.
② commons-dbcp2-2.0.jar
⎼ 데이터베이스 연결 풀링 서비스를 제공한다.
⎼ 연결 풀링 서비스는 관계 데이터베이스에서 새로운 연결을 위한 필요한 데이터베이스 트랜잭션을 수
행 시간에서 걸리는 시간을 최소화 할 수 있다.
③ commons-pool2-2.2.jar
⎼ 일반 개체 풀링 구성 요소이다.
⎼아파치 커먼즈 풀 오픈 소스 소프트웨어 라이브러리는 객체 풀링 API 및 개체 풀 구현을 제공한다.
④ commons-logging-1.2.jar
⎼로깅 API 구현의 다양한 클래스로 라이브러리 정보를 기록한다.
⎼log 객체를 가져와서 쓰는 창구 역할로 실제 구현체는 java 의 logging API 나 log4j 그리고 기타 로
거 모듈을 가져다 사용한다.
⎼Common Logging(JCL) 은 로깅 요청을 기존에 존재하는 다양한 logging API implementations 에 전
달하는 역할을 한다.
⎼JCL 을 사용할 경우에 로깅 요청이 왔을 때 해당 라이브러리를 이용해서 log 를 출력할 수 있게 해
주며 전달받는 logging API 구현체를 바꿀 수 있어서 어떠한 logging API implementations를 사용하
던 지에 상관없이 동일한 방법을 개발을 할 수 있다.
(3) Connection Pool API 다운
경로 http://jakarta.apache.org
```

# Jstl
```java
⎼자카르타에서는 자주 사용하는 커스텀 태그를 JSTL(JSP Standard Tag Library) 형태로 제공해준다.
⎼자바 코드를 최대한 줄이기 위해 거의 모든 자바 코드를 커스텀 태그로 구현하려면 개발이 효율적이기보다는
오히려 개발 시간이 훨씬 늘어날 것이며 기본 기능까지도 직접 커스텀 태그로 개발할 필요는 없다.
⎼JSTL 은 자주 사용되는 필요한 기능들을 모아 놓은 커스텀 태그이므로 태그는 코드를 간결하게 해주고 가독성을
높이는 장점이 있기 때문에 JSTL 을 잘 사용한다면 효율적인 코딩을 하는 데 많은 도움을 준다.
⎼JSTL은 용도에 따라 사용하는 기능이 달라지는데 크게 4 가지로 core, fmt, xml, sql 와 함수로 나누어진다.
① core : 기본적인 기능들을 제공한다.
② fmt : format의 약자로 형식화에 관한 기능들을 제공한다.
③ xml : XML 처리에 좀 더 편한 기능을 제공한다.
④ sql : SQL 처리에 편한 기능을 제공한다.
⑤ 함수: 컬렉션과 문자열 처리 기능을 제공한다.
⎼spring 프레임워크에서도 JSTL 및 별도의 커스텀 태그를 지원하며 대부분의 view 영역에서 사용하고 있으므로
커스텀 태그 사용법은 매우 중요하다.
⎼JSTL의 특징은 다음과 같다.
① 자주 사용하는 커스텀 태그(Custom Tag)의 표준이다.
② JSP 어플리케이션을 간단한 태그로 캡슐화 한다.
③ JSP 의 스크립트 코드보다 가독성이 좋다.
④ JSP 의 스크립트와 HTML 개발의 편리성을 제공하긴 하지만 코드의 복잡성을 증가시키는 문제점이 있다.
⑤ JSP 코드를 태그로 대치시켜서 HTML과 같이 태그로 이루어진 코딩 방법이 제시된 것이다.
⑥ 태그는 시작 태그와 종료 태그의 쌍으로 이루어지며 단독 태그도 가능하다.
```
