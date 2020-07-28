# RestAPI
* [restapi](https://velopert.com/231)
* [정아마추어](https://jeong-pro.tistory.com/180?category=793347)
* [2]('https://brownbears.tistory.com/450')
* [테코톡](https://www.youtube.com/watch?v=xY7cpMuWh4w&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=47)
* [Naverd2](https://www.youtube.com/watch?v=RP_f5dMoHFc)


* 개발자들 사이에서 기술이나 제품이 아니라 널리 쓰이는 일종의 형식
  * 무슨 프레임워크를 쓰든 소프트웨어를 만들든 공통적인 형식을 사용하는 것
  * 지정된 혀식으로 요청, 명령을 받을 수 있는 수단
  * 예를들어 시스템이나 하드웨어에 대한 세세한 지식 없어도 소프트웨어를 짤 수 있는 윈도우 API에 맞게 코드를 짜면 됨

## 제약조건 5가지
1. 클라이언트-서버; 둘다
  * 클라이언트와 서버의 기능은 완벽히 분리되어야 한다
2. 무상태성(Stateless); 클라이언트
  * 요청을 통해 클라이언트의 상태를 서버에 저장해서는 안된다. 대신 캐시나 JWT(Json Web Token) 등ㅇ을 이용해야 한다.
3. 캐시 처리 가능(Cacheable); 서버
  * 클라이언트는 응답을 캐싱할 수 있어야 한다. 이는 클라이언트가 중복 요청하는 것을 막아 서버의 부담을 줄여줄 수 있다.
4. 계층화(layered System); 그외
  * 서버와 클라이언트 사이에 캐시 서버나 로드 밸런스 등의 중간 서버룰 둘 수 있다. 클라이언트는 대상 서버에 직접 연결되었는지 혹은 중간 서버에 연결도었는지 알 수 없다.
5. Code on demand; 그외
* 서버는 클라이언트가 직접 실행시킬 수 있는 로직을 전송할 수 있다.
6. 인터페이스 일관성(uniform Interface)
  * 각각의 요청은 URI 등으로 식별된다. 서버가 가지고 있는 리소스는 클라이언트의 응답과는 구별된다
  * 클라이언트는 서버로부터 전송받아 가지고 있는 정보만으로 리소스를 변경하거나 삭제할 수 있다
  * 각각의 요청은 처리 방법에 대한 충분한 정보를 담고 있다.
  * HateOAS: 해당 리소스에 대해 할 수 있는 모든 동작에 대해 URI를 제공한다.

## RestAPI
* 슬래시로 계층 관계를 나타낸다
* URI를 이루는 리소스명ㅇ느 동사보다는 명사로(REST는 상태나 행위를 가지거나 표현하지 않는다.)
* 언더바, 대문자, 파일 확장자는 URI에 포함시키지 않아야 한다(최대한 간결하게 만들고 혼동을 피하기 위함)
* 리소스에 대한 행위는 HTTP 메소드를 이용

## HTTP 메소드
* Create
  * POST: 요청에 바디가 있음, 응답에 바디가 있음
* READ
  * GET: 요청에 바디가 없음, 응답에 바디가 있음
* UPDATE
  * PUT: 요청에 바디가 있음, 응답에 바디가 있음
* DELETE
  * DELETE: 요청에 바디가 없음, 응답에 바디가 있음
* READ와 DELETE는 주소에 리소스가 드러나기 때문에 바디가 필요 없음

```java
우선, 위키백과의 정의를 요약해보자면 다음과 같다.

월드 와이드 웹(World Wide Web a.k.a WWW)과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 
아키텍처의 한 형식으로 자원을 정의하고 자원에 대한 주소를 지정하는 방법 전반에 대한 패턴

REST란, REpresentational State Transfer 의 약자이다. 여기에 ~ful 이라는 형용사형 어미를 붙여
~한 API 라는 표현으로 사용된다. 즉, REST 의 기본 원칙을 성실히 지킨 서비스 디자인은 'RESTful'하다라고 표현할 수 있다.

REST가 디자인 패턴이다, 아키텍처다 많은 이야기가 존재하는데, 하나의 아키텍처로 볼 수 있다. 
좀 더 정확한 표현으로 말하자면, REST 는 Resource Oriented Architecture 이다. API 설계의 중심에 
자원(Resource)이 있고 HTTP Method 를 통해 자원을 처리하도록 설계하는 것이다.

REST 6 가지 원칙
Uniform Interface
Stateless
Caching
Client-Server
Hierarchical system
Code on demand
cf) 보다 자세한 내용에 대해서는 Reference 를 참고해주세요.
RESTful 하게 API 를 디자인 한다는 것은 무엇을 의미하는가.(요약)
리소스 와 행위 를 명시적이고 직관적으로 분리한다.
리소스는 URI로 표현되는데 리소스가 가리키는 것은 명사로 표현되어야 한다.
행위는 HTTP Method로 표현하고, GET(조회), POST(생성), PUT(기존 entity 전체 수정), 
PATCH(기존 entity 일부 수정), DELETE(삭제)을 분명한 목적으로 사용한다.
Message 는 Header 와 Body 를 명확하게 분리해서 사용한다.
Entity 에 대한 내용은 body 에 담는다.
애플리케이션 서버가 행동할 판단의 근거가 되는 컨트롤 정보인 API 버전 정보, 응답받고자 하는 MIME 타입 등은 header 에 담는다.
header 와 body 는 http header 와 http body 로 나눌 수도 있고, http body 에 들어가는 json 구조로 분리할 수도 있다.
API 버전을 관리한다.
환경은 항상 변하기 때문에 API 의 signature 가 변경될 수도 있음에 유의하자.
특정 API 를 변경할 때는 반드시 하위호환성을 보장해야 한다.
서버와 클라이언트가 같은 방식을 사용해서 요청하도록 한다.
브라우저는 form-data 형식의 submit 으로 보내고 서버에서는 json 형태로 보내는 식의 분리보다는 json 으로 보내든, 
둘 다 form-data 형식으로 보내든 하나로 통일한다.
다른 말로 표현하자면 URI 가 플랫폼 중립적이어야 한다.
어떠한 장점이 존재하는가?
Open API 를 제공하기 쉽다
멀티플랫폼 지원 및 연동이 용이하다.
원하는 타입으로 데이터를 주고 받을 수 있다.
기존 웹 인프라(HTTP)를 그대로 사용할 수 있다.
단점은 뭐가 있을까?
사용할 수 있는 메소드가 4 가지 밖에 없다.
분산환경에는 부적합하다.
HTTP 통신 모델에 대해서만 지원한다.
위 내용은 간단히 요약된 내용이므로 보다 자세한 내용은 다음 Reference 를 참고하시면 됩니다 :)
```

```JAVA
REST가 무엇인가?

REST는 분산 시스템 설계를 위한 아키텍처 스타일이다.

아키텍처 스타일이라는건 쉽게 말하면 제약 조건의 집합이라고 보면 된다.

RESTful은 무엇인가?

RESTful은 위의 제약 조건의 집합(아키텍처 스타일, 아키텍처 원칙)을 모두 만족하는 것을 의미한다.

REST라는 아키텍처 스타일이 있는거고 RESTful API라는 말은 REST 아키텍처 원칙을 모두 만족하는 API라는 뜻이다.

우리가 REST와 RESTful을 동일한 의미로 사용하곤 하는데 엄격하게는 다르다는 것을 알 수 있다.

->이로써 REST와 RESTful, RESTful API가 무엇인지, 어떻게 다른지를 말할 수 있게 되었다.

REST가 필요한 이유는 뭘까?

1. 위에서 말한 것과 같이 분산 시스템을 위해서다.

거대한 애플리케이션을 모듈, 기능별로 분리하기 쉬워졌다. RESTful API를 서비스하기만 하면 어떤 
다른 모듈 또는 애플리케이션들이라도 RESTful API를 통해 상호간에 통신을 할 수 있기 때문이다.

2. WEB브라우저 외의 클라이언트를 위해서다. (멀티 플랫폼)

웹 페이지를 위한 HTML 및 이미지등을 보내던 것과 달리 이제는 데이터만 보내면 여러 클라이언트에서 
해당 데이터를 적절히 보여주기만 하면 된다.

예를 들어 모바일 애플리케이션으로 html같은 파일을 보내는 것은 무겁고 브라우저가 모든 앱에 있는 것은 아니기 
때문에 알맞지 않았는데 RESTful API를 사용하면서 데이터만 주고 받기 때문에 여러 클라이언트가 자유롭고 부담없이
데이터를 이용할 수 있다.

서버도 요청한 데이터만 깔끔하게 보내주면되기 때문에 가벼워지고 유지보수성도 좋아졌다.

REST의 구성 요소

HTTP URI = 자원

HTTP Method = 행위

MIME Type = 표현 방식

1
2
GET /100 HTTP/1.1
Host : jeong-pro.tistory.com
cs
위와 같은 Request 메세지가 있으면 URI자원은 "/100" 이고, HTTP Method는 "GET" 이다.

MIME 타입은 보통 Response Http header 메세지에 Content-type으로 쓰인다. 여기서는 없다.

그러면 이해하기를 jeong-pro.tistory.com 서버에 /100 이라는 자원을 GET(조회)하고 싶다는 요청으로 해석이 가능하다.
이게 REST 방식을 이용한 Request 예시다. (참고로 이것은 이해를 위한 것일 뿐 RESTful 하다고는 못한다.) 

1
2
3
4
HTTP/1.1 200 OK
Content-Type : application/json-patch+json
 
[{"title": "helloworld", "author": "jeong-pro"}]


이런 Response가 왔다고 해보자.

그러면 Content-Type을 보고 클라이언트는 IANA라는 타입들의 명세를 모아놓은 사이트에 가서 
application/json-patch+json 이라는 타입의 명세를 확인하고 아래 Body의 내용이 json타입이구나를 알 수 있는 것이다.

REST는 알겠고 그러면 그 제약 조건이 뭔데요?

1. Client/Server

2. Stateless : 각 요청에 클라이언트의 context가 서버에 저장되어서는 안된다.

3. Cacheable : 클라이언트는 응답을 캐싱할 수 있어야 한다.

4. Layered System : 클라이언트는 서버에 직접 연결되었는지 미들웨어에 연결되었는지 알 필요가 없어야 한다.

5. Code on demand(option) : 서버에서 코드를 클라이언트에게 보내서 실행하게 할 수 있어야 한다.

6. uniform interface : 자원은 유일하게 식별가능해야하고, HTTP Method로 표현을 담아야 하고, 
메세지는 스스로를 설명(self-descriptive)해야하고, 하이퍼링크를 통해서 애플리케이션의 상태가 전이(HATEOAS)되어야 한다.

왜 uniform interface에 강조가 되어있냐면, 1~5번의 제약 조건은 HTTP를 기반으로하는 REST는 HTTP에서 
이미 충분히 지켜지고 있는 부분이라서 비교적 덜 주의를 기울여도 된다.

RESTful하려면 저 uniform interface를 잘 지켜야 한다.

그 중에서도 HATEOAS와 self-descriptive를 잘 지켜야 한다.

필자가 주로 쓰는 Spring에는 spring-data-rest, spring hateoas, spring-rest-doc으로 두 제약을 지키기위해 
사용할 수 있는 라이브러리가 있다. (이 포스트는 면접을 위한 포스트일 뿐 사용법과 테스트는 다른 포스트에서 한다.)

HATEOAS는 Link 라는 HTTP 헤더에 다른 리소스를 가리켜 주는 값을 넣는 방법으로 해결한다.

HTTP/1.1 200 OK
Content-Type : application/json
Link : </spring/1>; rel="previous",
        </spring/3>; rel="next";
{
    "title" : "spring의 모든 것"
    "author" : "jeong-pro"
}
Colored by Color Scripter
cs
위와 같이 해당 정보에서 다른 정보로 넘어갈 수 있는 하이퍼링크를 명시해야 한다는 것이다.

완벽한 REST는 무엇일까? WEB이다.

어떤 Application이 생겼다고 브라우저는 버전을 업데이트할 필요가 없고, 브라우저가 해당 
application으로 어떻게 요청하는지를 알게 해야할 필요가 없다.

* 장점

- 메세지를 단순하게 표현할 수 있고 WEB의 원칙인 확장에 유연하다. (멀티플랫폼)

- 별도의 장비나 프로토콜이 필요없이 기존의 HTTP 인프라를 이용할 수 있다. (사용이 용이함)

- server, client를 완전히 독립적으로 구현할 수 있다.

* 단점

- 표준, 스키마가 없다. 결국은 API 문서가 만들어지는 이유다.

- 행위에 대한 메소드가 제한적이다. (GET, POST, PUT, DELETE, HEAD, ...)



* REST는 분산 시스템 설계를 위한 이키텍처 스타일이라고 했다.

마이크로서비스라는 말을 들어보았을 것이다. 이 쪽으로 질문이 연계될 수 있다.

RESTful API를 이용해서 하나의 큰 서비스 애플리케이션을 여러 모듈화된 작은 서비스 
애플리케이션(마이크로 서비스)들로 나눌 수 있게 됐기 때문이다.



* REST를 공부하니까 URI와 URL의 차이점에 대해서도 이해할 수 있게되었다.

Uniform Resource Identifier, Uniform Resource Locator

REST에서는 모든 것을 Resource로 표현한다. 그리고 그 자원은 유일한 것을 나타낸다. Identifier, 식별자라는 것이다.

반면에 과거의 웹에서는 Identifier의 개념이 따로 필요없었다. html같은 파일들을 주고
받았기 때문에 파일의 위치를 가리키는 Locator를 썼다고 이해하면 된다.

URI가 파일뿐만 아니라 여러 자원들 까지도 포함하는 개념으로 이해할 수 있다.
```

## REST 생긴 과정
* [강의]('https://www.youtube.com/watch?v=RP_f5dMoHFc')
1. WEB(1991)
* 어떻게 인터넷 정보를 공유할 것인가? 
 * 정보를 하이퍼 텍스트로 연결한다. 
 * 표현형식: HTML, 식별자: URI, 전송방법: HTTP

2. HTTP/1.0(1994-1996); 로이 필딩
 * 해결책: HTTP Object Model

3. REST(1998); 로이필딩
4. REST(2000); 로이 필딩 박사 논문으로 발표
5. CMIS(2008); CMS를 위한 표준으로 REST 바인딩 지원
 * 로이 필딩은 REST는 없다고 말함
6. Microsoft REST API Guidelines(2016)
 * uri 형식 지정
 * GET, PUT, DELETE, POST, HEAD, PATCH, OPTIONS를 지원
 * API 버저닝은 Major,minor로 하고 uri에 버전 정보를 포함시킨다
 * 로이 필딩은 REST API 아니라고 선언
7. 로이필딩
 * REST API는 반드시 하이퍼텍스트 기반이어야 한다.
 * 최고의 버저닝 전략은 버저닝을 안하는 것이다. 
 * 분산 하이퍼미디어 시스템(웹)을 위한 아키텍쳐 스타일

## REST를 구성하는 스타일
* client-server
* stateless
* cache
* uniform interface
* layered system
* code-on-demand(optional)

## API
1. XML-RPC(1998); 마이크로소프트 -> SOAP; api
2. SalesForce API(2000.2); api
3. flicer API(2004.8)


### SOAP과 REST의 비교
* SOAP은 복잡하고 규칙 많고 어렵다
* REST는 단순하고 규칙적고 쉽다

# POST 방식과 GET 방식
- HTTP 프로토콜을 이용하여 서버에 요청방법 중 하나로서 요청방법에 따라 GET과 POST로 나뉩니다. 이때 필요에 따라 데이터를 보낼수 있는데 이때 데이터는 url 뒤에 쿼리스트링으로 입력하여 보내기에 외부에 쉽게 노출된다는 단점이 있습니다.

## GET method
- GET 방식은 서버에 데이터를 요청하는 방식으로서 특정 웹페이지 등을 요청할 때 쓰입니다.
* GET은 Request를 할 때, 필요한 데이터를 쿼리 스트링에 담아서 전송한다.
  * 쿼리 스트링 이란, URL의 끝에 ? 다음으로 Key와 Value로 이루워진 파라미터를 의미한다. 다양한 파라미터를 전송하기 위해서는 &로 연결하면 된다.
* 서버에서 어떤 데이터를 가져와서 보여주는 행위를 의미
* 서버 데이터나 상태를 변경하는 행위는 하지 않는다.
* GET요청은 브라우저에서 캐싱할 수 있다. 따라서, 데이터 크기가 작고 보안이슈가 없다고 GET요청을 보내면 기존에 캐싱된 데이터가 응답할 가능성이 있다.
* 브라우저 히스토리에 히스토리에 쿼리 문자열이 기록됨.
* 	캐시될 수 있음.

## POST medthod
- POST 방식은 서버에 데이터를 전송을 요청하는 방식으로서 웹 페이지의 폼에 입력한 데이터를 서버에 보낼 때 쓰입니다. 데이터는 HTTP의 body에 담아 보이기에 GET처럼 대놓고 보이지 않아 안정적이라 말할 수 있으나, 암호화 되어 있지 않아 쉽게 발견될 수 있습니다.
* 서버의 상태나 값을 변경하거나 추가하는데 사용한다.


## Delete Method
* 자원을 삭제할 것을 요청
* 특정 자원에 대한 DELETE의 경우 자원을 더 이상 이용할 수 없어야 하므로 ,DELETE요청을 다시 호출한 경우도 자원은 여전히 사용할 수 없는 상태여야 한다.

## put method
* POST와 달리, 멱등성을 가지고있다.
  * idempotent(멱등)은 수학용어로 해당 연산을 해도 결과에 변화가 없다는 특성을 표현한다.
  * (100 * 1 = 100 이므로 곱셈에대해 1을 멱등원 이라하고, 1을 곱하는 연산이 멱등 연산)
* post연산의 경우 리소스를 추가하는 연산이기 때문에, 멱등하지 않지만, put은 반복 수행해도 멱등하다.
* POST와 달리 클라이언트가 이미 변경 대상 리소스의 위치를 알고 있어서, 대상 리소스를 갱신할 수 있다.(리소스 결정권이 클라이언트에게 있다.)

## 잘못된 사용
* 게시글 업로드 요청인데 GET으로 데이터를 전송하면, 해당 GET요청과 그에 대한 응답이 브라우저에 의해 캐싱되었다가 다시 사용될 우려가 있다.
* 브라우저 캐시에 의해 자동으로 동일한 글이 서버에 전송되서 같은글이 업로드될 수 있다.
* google accelerator사건
  * 사용자가 웹페이지에 접근했을때, accelerator가 모든 url을 클릭해서 브라우저 캐싱처리함
  * URL에는 GET/POST를 용도에 맞지않게 사용해서 (GET인데 삭제를 하는 행위가 포함되는등) 의도치 않게 데이터가 삭제되는 일이 발생

## get보다 post 방식 사용하는 이유
* GET은 idempotent(멱등), POST는 non-idempotent하다.
  * idempotent(멱등)은 수학용어로 해당 연산을 해도 결과에 변화가 없다는 특성을 표현한다.
  * (100 * 1 = 100 이므로 곱셈에대해 1을 멱등원 이라하고, 1을 곱하는 연산이 멱등 연산)
* GET은 해당 요청을 몇번을 수행해도 요청에 대한 결과가 계속 동일하게 돌아오는 것을 의미
  * POST는 해당 요청이 수행되면 서버에서 무언가가 변경되고, 동일한 결과가 돌아오는 것을 보장할 수 없음을 의미
  * GET을 이용해서 게시판 업로드 기능을 요청한다면, 멱등성 성질을 무시하고 문제 발생 여지가 있다.
1. 데이터 생성, 변경 등 원본 파일의 수정이 발생하는 경우
2. 중요한 정보를 전달할 때
  * body에 담기 떄문에 기본적인 보안; 하지만 post로 전달되는 데이터도 URL에 노출만 안될뿐 똑같이 쉽게 확인할 수 있따.
  * 그렇기 때문에 Postㄹ 전달할 때 많은 데이터들이 암호화된 상태로 전송된다.
  * 이렇게 암호화된 데이터는 클라이언트 사이드에서 decrypt 해준다. 반대로 서버로 전달핼 때도 클라이언트 사이드에서 encrypt한 후 보내면 Post 로그를 통해 데이터가 누출되는 일을 막을 수 있다.
3 전송 데이터의 양이 많을 때
  * 전송 길이에 제한이 없다

## Restfult API에서의 URL과 일반적인 HTTP 에서의 URL의 차이
- 일반적인 HTTP의 URL은 기능에 중점을 두어 설계를하기 때문에 회원정보를 가져온다면 ‘/getUser’ 와 같이 설계를 하지만 Restful API에서는 자원에 중점을 두고 설계를 합니다. 따라서 ‘/user’로 설계를 하되 기능에 대한 구분은 POST, GET, DELETE, PUT 등의 HTTP 메서드를 통하여 설계하는 차이가 있습니다.

## Restful API
- ROA(Resource Oriented Architecture) 구조를 지향하여 이미지, 텍스트, DB 등 모든 자원에 대하여 고유한 URL을 부여하도록 설계하는 방식을 말합니다.
## Get 방식(그 어떤 방식이든간에)의 URL을 통해서 데이터를 전달시 보안성 취약 해결방법
- SSL을 이용한 HTTPS 프로토콜로 데이터 전송을 암호화하여 보냅니다. 그러면 URL 뒤에 붙는 쿼리스트링 내용 모두 암호화되어 전송되기 때문에 보안성을 강화할 수 있습니다.

### 메소드
* Get: 데이털를 read, 조회하는데 사용
* Post: 새로운 정보를 추가하는데 사용
* put, patch를 사용해서 변경, Update
  * put: 정보를 통쨰로 갈아끼울 때
  * patch: 정보 중 일부를 특정 방식으로 변경하거나 update할 때

# GraphQL
* GraphQL 은 페이스북에서 만든 어플리케이션 레이어 쿼리 언어입니다. 기존의 웹 혹은 모바일 어플리케이션의 API 를 구현 할 때는, 통상적으로 REST API 가 사용됩니다. 기존의 REST API 를 사용하여 API 를 구현을 한다면, 우리가 클라이언트사이드에서 어떠한 기능이 필요 할 때마다 그때 그때 새로운 API를 만들어주었어야했습니다.
* 예를들어 여러분의 어플리케이션에 Account 라는 모델이 있고, /accounts 라는 endpoint 가 있다고 가정해봅시다.
* 쿼리를 통하여 딱 필요한 데이터만 fetching 을 하기 때문에 overfetch 혹은 underfetch 를 할 걱정을 할 필요가 없습니다.

```java

장점
요청메세지가 값이 없는 JSON과 비슷하며 받는 데이터는 JSON형태이다.
요청에 따른 응답데이터 구조를 예측할수 있다.
직관적이다.
단일요청으로 원하는 데이터를 한번에 가져올수 있다.
REST API의 N+1 Problem을 해결 할 수 있다.
GraphQL은 type system을 지원한다.
개발 혹은 사용시 좀 더 명확한 오류메세지를 제공할 수 있다.
GraphiQL 등의 강력한 도구(통신 테스트 도구 등)를 사용할 수 있다.
확장이 용이하다.


단점
러닝커브 가 조금 있다.
GraphQL의 type을 정의한 코드, mutation을 정의한 코드가 추가되면서 단순한 App에서는 코드가 더 복잡해진다.
캐싱 기능의 구현이 복잡하다(하지만 대부분의 라이브러리가 지원한다.)
출시한지 얼마 안되어 안정성 문제가 생길수 있다.(하지만 facebook과 github등에서 사용한다고 한다.)
JSON이 선호되며 JSON을 사용하지 않으면 불편할수 있다. Spec


용어정의
Query : 읽기작업을 하는 GraphQL문을 의미한다.
field : query에 있는 값(속성)
Mutation : 데이터 수정작업을 하는 GraphQL문을 의미한다.
schema : Query와 Mutation의 retrun type과 arguments type 및 custom type, 
custom interface, enum type 등과 input value의 default값 등을 정의한 코드를 의미한다.
resolver : schema에서 정의된 Query와 Mutation의 구조에 맞추어 retrun type과 arguments type에 맞추어 설정한 코드를 의미한다.

참고로 위 구성요소중 resolver만 GraphQL를 구현한 Server Library에 의존되고 나머지는 GraphQL에 의존됩니다.

즉, Query, Mutation은 schema에서 구조가 정의되고. resolver에서 행동이 정의되며 
schema에서 정의된 구조에 맞춰서, 클라이언트에서 Query, Mutation문으로 request하고 서버에서 JSON으로 response 합니다.
```

```JAVA
onnectionless(비 연결지향)
클라이언트에서 서버에 요청을 보내면 서버는 클라이언트에 응답을 하고 접속을 끊는 특성이 있습니다. 
(HTTP1.1에서 Connection 헤더에 keep-alive라고 설정하면 컨넥션을 유지할 수 있습니다)

Stateless(상태정보유지안함)
HTTP 통신은 요청을 응답하고 접속을 끊기 때문에 클라이언트의 상태정보를 알 수 없습니다. 이를 Stateless하다고 합니다.
만약 로그인을 하고 그 상태를 유지한 채로 웹 서비스를 제공하려면 어떻게 해야할까요? 이를 위하여 쿠키와 세션이라는 방법이 존재합니다.

```

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



# 회원가입

# beautifulsoup

# selenium api

