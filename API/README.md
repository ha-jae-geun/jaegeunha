# API
* Application Programming Interface : 응용프로그램에서 사용할 수 있도록, 운영체제나 프로그래밍 언어가 제공하는 기능을 제공할 수 있게 만든 인터페이스
* 웹환경에서 API는 다른 서비스에 요청을 보내고 응답을 받기 위해 정의된 명세라고 표현할 수 있다.

# RESTful API 정의
* 클라이언트(웹브라우저,모바일)가 필요한 자원이 있을때, 서버에게 요청하는 방식을 정의한 API 디자인

* 먼저, REST는 REpresentational State Transfer의 약자이다. API 설계의 중심에 자원(resource)이 있고, HTTP Method를 통해 자원을 처리하도록 설계하는 방식이다. REST API는, 자원,행위,표현으로 구성이 된다.

## REST의 특징
```java
Uniform Interface(유니폼 인터페이스)
Uniform Interface는 URI로 지정한 리소스에 대한 조작을 통일되고 한정적인 인터페이스로 수행하는 아키텍쳐 스타일이다.

Stateless(무상태성)
REST는 무상태성 성격을 갖는다. 작업을 위한 상태정보를 따로 저장하고 관리하지 않는다. 
세션 정보나 쿠키 정보를 별도로 저장하고 관리하지 않기 때문에 API서버는 들어오는 요청만을 단순히 처리하면 된다. 
서비스의 자유도가 높어지고 구현이 단순하고 확장이 용이하다


Cacheable(캐시 가능)
HTTP라는 기존 웹표준을 그대로 사용하기 때문에, 웹에서 사용하는 인프라를 그대로 활용 가능하다. 
HTTP 프로토콜 표준에서 사용하는 Last-Modified태그나 E-Tag를 이용하면 캐싱 구현이 가능


Self-descriptiveness(자체 표현 구조)
REST API메시지만 보고도 이를 쉽게 이해할 수 있는 자체 표현 구조로 되어 있어야 한다.


Client-Server구조
REST서버는 API제공, 클라이언트는 사용자 인증이나 세션,로그인 정보등을 직접 관리하는 구조로 
각각의 역할이 확실히 구분되서 의존성이 줄어든다.


계층형 구조
REST서버는 다중 계층오러 구성될 수 있으며 보안,로드 밸런싱, 암호화 계층을 추가해 구조상의 유연성을 둘 수 있고, PROXY,게이트웨이 같은 네트워크 기반의 중간매체를 사용할 수 있게 한다.


```

## REST API 디자인
* URI는 정보의 자원을 표현해야 한다. 자원에 대한 행위는 HTTP Method로 표현해야 한다.
* URI는 정보의 자원을 표현해야 한다.(리소스명은 동사보다 명사 사용)
* [잘못된 REST 디자인]
* URI는 자원을 표현하는데 중점을 둬야한다. delete와 같은 행위에 대한 표현이 들어가면 안된다.
  * GET /members/delete/1
* [올바른 REST 디자인]
* DELETE /members/1


## REST API 장단점
```java
장점
open API 제공 용이
멀티 플랫폼 지원 및 연동 용이
원하는 타입으로 데이터를 주고 받을 수 있다.
기존 웹 인프라(http)를 그대로 사용할 수 있다.


단점
사용할 수 있는 메서드가 4가지 밖에없다.
분산환경에는 부적합
HTTP 통신 모델에만 적용 가능하다.
```

# 1.2.3
* 1번째 버전: 대규모 업데이트; 코드를 변경하고 업데이트 필요
* 2번째: 소규모 버전; 기능의 추가
* 3번쨰: 패치, 버그의 수정 

# 자바
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

# 회원가입

# beautifulsoup

# selenium api
