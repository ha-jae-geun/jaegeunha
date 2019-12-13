# API
* 인간이 아닌 코드끼리 소통할 수 있게 만들어 진 것
* Application Programming Interface : 응용프로그램에서 사용할 수 있도록, 운영체제나 프로그래밍 언어가 제공하는 기능을 제공할 수 있게 만든 인터페이스
* 웹환경에서 API는 다른 서비스에 요청을 보내고 응답을 받기 위해 정의된 명세라고 표현할 수 있다.

# RESTful API 정의
* 클라이언트(웹브라우저,모바일)가 필요한 자원이 있을때, 서버에게 요청하는 방식을 정의한 API 디자인

* 먼저, REST는 REpresentational State Transfer의 약자이다. API 설계의 중심에 자원(resource)이 있고, HTTP Method를 통해 자원을 처리하도록 설계하는 방식이다. REST API는, 자원,행위,표현으로 구성이 된다.

## REST API 탄생
* REST는 Representational State Transfer라는 용어의 약자로서 2000년도에 로이 필딩 (Roy Fielding)의 박사학위 논문에서 최초로 소개되었습니다. 로이 필딩은 HTTP의 주요 저자 중 한 사람으로 그 당시 웹(HTTP) 설계의 우수성에 비해 제대로 사용되어지지 못하는 모습에 안타까워하며 웹의 장점을 최대한 활용할 수 있는 아키텍처로써 REST를 발표했다고 합니다.

## REST 구성
* 자원(RESOURCE) - URI
* 행위(Verb) - HTTP METHOD
* 표현(Representations)

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


## 메소드 설명
```java
POST	POST를 통해 해당 URI를 요청하면 리소스를 생성합니다.
GET	GET를 통해 해당 리소스를 조회합니다. 리소스를 조회하고 해당 도큐먼트에 대한 자세한 정보를 가져온다.
PUT	PUT를 통해 해당 리소스를 수정합니다.
DELETE	DELETE를 통해 리소스를 삭제합니다.
```

## URI 설계 시 주의할점
```java
1) 슬래시 구분자(/)는 계층 관계를 나타내는 데 사용
    http://restapi.example.com/houses/apartments
    http://restapi.example.com/animals/mammals/whales
    
2) URI 마지막 문자로 슬래시(/)를 포함하지 않는다.
URI에 포함되는 모든 글자는 리소스의 유일한 식별자로 사용되어야 하며 
URI가 다르다는 것은 리소스가 다르다는 것이고, 역으로 리소스가 다르면 URI도 달라져야 합니다. 
REST API는 분명한 URI를 만들어 통신을 해야 하기 때문에 혼동을 주지 않도록 URI 경로의 마지막에는 슬래시(/)를 사용하지 않습니다.

    http://restapi.example.com/houses/apartments/ (X)
    http://restapi.example.com/houses/apartments  (0)
    
3) 하이픈(-)은 URI 가독성을 높이는데 사용
URI를 쉽게 읽고 해석하기 위해, 불가피하게 긴 URI경로를 사용하게 된다면 하이픈을 사용해 가독성을 높일 수 있습니다.


4) 밑줄(_)은 URI에 사용하지 않는다.
글꼴에 따라 다르긴 하지만 밑줄은 보기 어렵거나 밑줄 때문에 문자가 가려지기도 합니다. 
이런 문제를 피하기 위해 밑줄 대신 하이픈(-)을 사용하는 것이 좋습니다.(가독성)


5) URI 경로에는 소문자가 적합하다.
URI 경로에 대문자 사용은 피하도록 해야 합니다. 대소문자에 따라 다른 리소스로 인식하게 되기 때문입니다. 
RFC 3986(URI 문법 형식)은 URI 스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정하기 때문이지요.

    RFC 3986 is the URI (Unified Resource Identifier) Syntax document
    
6) 파일 확장자는 URI에 포함시키지 않는다.
    http://restapi.example.com/members/soccer/345/photo.jpg (X)
REST API에서는 메시지 바디 내용의 포맷을 나타내기 위한 파일 확장자를 URI 안에 포함시키지 않습니다. 
Accept header를 사용하도록 합시다.

    GET / members/soccer/345/photo HTTP/1.1 Host: restapi.example.com Accept: image/jpg
```

## 리소스 간의 관계를 표현하는 방법
```java
REST 리소스 간에는 연관 관계가 있을 수 있고, 이런 경우 다음과 같은 표현방법으로 사용합니다.

    /리소스명/리소스 ID/관계가 있는 다른 리소스명

    ex)    GET : /users/{userid}/devices (일반적으로 소유 ‘has’의 관계를 표현할 때)
만약에 관계명이 복잡하다면 이를 서브 리소스에 명시적으로 표현하는 방법이 있습니다. 
예를 들어 사용자가 ‘좋아하는’ 디바이스 목록을 표현해야 할 경우 다음과 같은 형태로 사용될 수 있습니다.

    GET : /users/{userid}/likes/devices (관계명이 애매하거나 구체적 표현이 필요할 때
```

## 자원을 표현하는 Colllection과 Document
```java
Collection과 Document에 대해 알면 URI 설계가 한 층 더 쉬워집니다. 
DOCUMENT는 단순히 문서로 이해해도 되고, 한 객체라고 이해하셔도 될 것 같습니다. 
컬렉션은 문서들의 집합, 객체들의 집합이라고 생각하시면 이해하시는데 좀더 편하실 것 같습니다. 
컬렉션과 도큐먼트는 모두 리소스라고 표현할 수 있으며 URI에 표현됩니다. 예를 살펴보도록 하겠습니다.

    http:// restapi.example.com/sports/soccer
위 URI를 보시면 sports라는 컬렉션과 soccer라는 도큐먼트로 표현되고 있다고 생각하면 됩니다. 좀 더 예를 들어보자면

    http:// restapi.example.com/sports/soccer/players/13
sports, players 컬렉션과 soccer, 13(13번인 선수)를 의미하는 도큐먼트로 URI가 이루어지게 됩니다. 
여기서 중요한 점은 컬렉션은 복수로 사용하고 있다는 점입니다. 좀 더 직관적인 REST API를 위해서는 
컬렉션과 도큐먼트를 사용할 때 단수 복수도 지켜준다면 좀 더 이해하기 쉬운 URI를 설계할 수 있습니다.
```


##  HTTP 응답 상태 코드
* 마지막으로 응답 상태코드를 간단히 살펴보도록 하겠습니다. 잘 설계된 REST API는 URI만 잘 설계된 것이 아닌 그 리소스에 대한 응답을 잘 내어주는 것까지 포함되어야 합니다. 정확한 응답의 상태코드만으로도 많은 정보를 전달할 수가 있기 때문에 응답의 상태코드 값을 명확히 돌려주는 것은 생각보다 중요한 일이 될 수도 있습니다. 혹시 200이나 4XX관련 특정 코드 정도만 사용하고 있다면 처리 상태에 대한 좀 더 명확한 상태코드 값을 사용할 수 있기를 권장하는 바입니다.
* 상태코드에 대해서는 몇 가지만 정리하도록 하겠습니다.

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
