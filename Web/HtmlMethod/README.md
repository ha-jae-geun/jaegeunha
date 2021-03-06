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
  
# Safe Method
```java
Safe Methods
리소스를 수정하지 않는 메소드들(OPTIONS, GET, HEAD 등)을 Safe하다고 말한다.

대부분의 경우 Idempotent하면 Safe하다.

물론 예외도 있는데 DELETE는 Idempotent 하지만 리소스를 변경하므로 Safe하지 않다.

HEAD 는 Response-Body 없이 Header만 얻기 위해 사용한다.

OPTIONS 는 해당 리소스에 대해 가능한 Operation이 무엇인지 응답을 얻기 위해 사용한다.

만약 OPTIONS에 대한 응답이 온다면 response Allow 에 가능한 Operation을 사용해야한다.

RFC2616 에는 다음과 같이 나와있다.
```

# Cacheable Method
```java
왜 OPTIONS 메소드에 대한 응답은 캐시가 불가능한걸까?


즉 리소스는 주어진 URI에 대한 정보인데 OPTIONS는 정보를 가지고 오는 것이 아니다.

OPTIONS는 그 URL에 대해 어떤 연산이 가능한지를 알려준다.

HTTP에서 이뤄지는 캐싱은 정보에 대해 이뤄진다.

그렇기 때문에 GET이나 HEAD 같이 정보를 돌려주는 연산에만 캐싱할 수 있다.
```

# Trace, Connect
```java
TRACE는 클라이언트가 방금 보낸 요청을 다시 달라고 서버에게 요청하는 것이다.

CONNECT는 HTTP 터널링을 할때 쓰인다.

중간의 프록시 서버를 위해서는 CONNECT로 요청하고
마지막 프록시에서 end-point로는 GET 또는 CONNECT를 날린다.

HTTPS라면 CONNECT를
HTTP라면 둘 중 아무거나 써도 상관 없다.
```
