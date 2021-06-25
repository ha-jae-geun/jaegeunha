# [HTTP 공통/요청 헤더](https://www.zerocho.com/category/HTTP/post/5b3ba2d0b3dabd001b53b9db)
# [HTTP X 관련헤더](https://www.zerocho.com/category/HTTP/post/5b611b9e33b4636aa8bb1fc4)
# [HTTP 응답헤더](https://www.zerocho.com/category/HTTP/post/5b4c4e3efc5052001b4f519b)
# [HTTP 쿠키&캐시 헤더](https://www.zerocho.com/category/HTTP/post/5b594dd3c06fa2001b89feb9)
* www에서 쓰이는 핵심 프로토콜로 문서의 전송을 위해 쓰이며, 오늘날 거의 모든 웹 애플리케이션에서 사용되고 있다.
      * 음성, 화상 등 여러 종류의 데이터를 MIME로 정의하여 전송 가능
* Request/Response 동작에 기반하여 서비스 제공

## 통신과정
1. 3Way HandSHake
2. Http 요청
3. Http 응답

# [요청 프로토콜의 구조](https://www.youtube.com/watch?v=rxaBwwI_JnI&list=PL0d8NnikouEWcF1jJueLdjRIC4HsUlULi&index=26)
* Request Line
* Headers
* 공백
* Body

## Request Line
* 요청타입 + 공백 + URI + 공백 + HTTP 버전

## 요청 타입(메소드)
* Get
     * Client가 Server로부터 문서를 읽어오려 할 때 사용
     * 데이터를 보낼 수 도 있음
* Post
     * 클라이언트가 서버에게 정보를 전송할 때 사용
     * 데이터를 읽어올 수 있음
* PUT
     * 클라이언트가 서버에 특정 자원을 업로드할 때 사용
     * 사진 같은 업로드는 JSP, ASP, PHP 같은 CGI가 업로드 해주는 것임(보안상 막아놓음)
* Delete
     * 서버에서 문서를 제거하기 위해 사용(보안상 막아놓음)

# URI 구조
* scheme://host[:port][/path][?query]
     * ex) http://IP주소:포트/폴더이름/파일이름
     * ip주소는 도메인 주소가 ip주소로 바뀜
     * 포트번호는 https의 경우 443 포트가 생략이 됨


# [응답 프로토콜](https://www.youtube.com/watch?v=kuucNF4Zvbs&list=PL0d8NnikouEWcF1jJueLdjRIC4HsUlULi&index=30)
* Status Line + Headers + 공백 + Body

## Status Line
* HTTP 버전 + 공백 + 상대 코드 + 공백 + 상태 문구

## 상대 코드
* 100-199: 단순한 정보
* 200-299: 클라이언트의 요청이 성공
    * 200: OK
* 300-399: 클라이언트의 요청이 수행되지 않아 다른 URL로 재지정
* 400-499: 클라이언트의 요청이 불완전하여 다른 정보가 필요
    * 403: Forbidden: 클라이언트가 권한이 없는 페이지를 요청했을 때
    * 404: Not Found: 클라이언트가 찾을 수 없는 페이지를 요청했을 때
* 500-599: 서버의 오류를 만나거나 클라이언트의 요청 수행 불가
    * 500: Internal Server Error: 서버의 일부가 멈췄거나 설정 오류가 발생
    * 503: Service Unavailable: 최대 Session 수를 초과했을 때


# Http 요청 응답의 구조
1. 사용자가 브라우저에게 URL을 입력한다
2. 브라우저가 요청 메세지를 보낸다.
3. 서버가 URL을 프로그램 또는 정적 파일로 연결한다
4. 서버가 응답 메시지를 반환한다
5. 브라우저가 응답을 형식에 맞춰 표시한다


# [HTTP 헤더 포맷](https://www.youtube.com/watch?v=mQTGmxendk8&list=PL0d8NnikouEWcF1jJueLdjRIC4HsUlULi&index=31)
## 일반 헤더
* Content-Length: 메시지 바디 길이를 나타낼 때 쓰인다
* Content-Type: 메시지 바디에 들어있는 콘텐츠 종류

## 요청 헤더
* Cookie: 서버로부터 받은 쿠키를 다시 서버에게 보내주는 역할을 한다
* Host: 요청에 URL에 나타난 호스트명을 상세하게 표시(HTTP1.1은 필수)
* User-Agent: 클라이언트 프로그렘에 대한 식별 가능 정보를 제공
    * PC 버전인지 모바일 버전인지

## 응답 헤더
* Server: 사용하고 있는 웹서버의 소프트웨어에 댛나 정보를 포함
* Set-Cookie: 쿠키를 생성하고 브라우저에 보낼 때 사용. 해당 쿠키 값을 브라우저가 서버에게 다시 보낼 때 사용한다.

# 헤더
```java
HTTP Header 정리를 하는 이유

KOCW의 "컴퓨터 네트워크 - 한양대학교 이석복 교수님" 강의 중에 이런 표현이 있다.

"TCP를 이해하려면 TCP Header를 이해하면 된다."

"UDP를 이해하려면 UDP Header를 이해하면 된다."

실제로 토씨 하나 안 틀리고 위와 같이 말씀하신 것은 아니지만 비슷한 문장(맥락)이었다.

결국, 어떤 프로토콜을 이해하려면 프로토콜의 헤더만 알면 된다는 얘기었다.

왜 그럴까?

특정 프로토콜의 헤더의 내용은 특정 프로토콜의 기능을 제공하기 위해 담고 있는 최소한의 정보기 때문이다.

헤더에 그 프로토콜에 불필요한 내용을 담으면 네트워크로 전송되는 데이터의 크기가 커져서 빠른 전송이 불가능하기 때문에 

프로토콜을 설계할 때부터 꼭 필요한 내용만 담아야 하고, 모든 기능이 표현되어야 한다.

우리가 주로 사용하는 TCP에 대한 이해가 충분히 있어야 하지만, 먼저 다가가기 쉬운 HTTP를 정리해보고자 한다. (HTTP 헤더 정리 = HTTP 이해)

* 여러 블로그를 돌아다니면서 최대한 내용을 많이 모으고, 이해하고 검증하려고 노력했으나 실제로 HTTP 헤더를 열어보았을 때

아래에 기재된 내용이 무조건 들어있지 않기 때문에 포맷이나 설명이 실제와 다를 수 있습니다.

* 잘못된 정보가 있다면 지적해주시면 감사하겠습니다. 그러면 고쳐서 제대로된 정보가 공유되도록 하겠습니다.

HTTP Header

- 공통 헤더

Date : 현재시간 (Sat, 23 Mat 2019 GMT)

Pragma : 캐시제어 (no-cache), HTTP/1.0에서 쓰던 것으로 HTTP/1.1에서는 Cache-Control이 쓰인다.

Cache-Control : 캐시 제어

+ no-store : 캐시를 저장하지 않겠다.

+ no-cache : 모든 캐시를 쓰기 전에 서버에 해당 캐시를 사용해도 되는지 확인하겠다.

+ must-revalidate : 만료된 캐시만 서버에 확인하겠다.

+ public : 공유 캐시에 저장해도 된다.

+ private : '브라우저' 같은 특정 사용자 환경에만 저장하겠다.

+ max-age : 캐시의 유효시간을 명시하겠다.

Transfer-Encoding : body 내용 자체 압축 방식 지정

'chunked'면 본문의 내용이 동적으로 생성되어 길이를 모르기 때문에 나눠서 보낸다는 의미다.

본문에 데이터 길이가 나와서 야금야금 브라우저가 해석해서 화면에 뿌려줄 때 이 기능을 사용한다.

Upgrade : 프로토콜 변경시 사용 ex) HTTP/2.0

Via : 중계(프록시)서버의 이름, 버전, 호스트명

Content-Encoding : 본문의 리소스 압축 방식 (transfer-encoding은 body 자체이므로 다름)

Content-type : 본문의 미디어 타입(MIME) ex) application/json, text/html

Content-Length : 본문의 길이

Content-language : 본문을 이해하는데 가장 적절한 언어 ex) ko

한국사이트여도 본문을 이해하는데 영어가 제일 적절하면 영어로 지정된다.

Expires : 자원의 만료 일자

Allow : 사용이 가능한 HTTP 메소드 방식 ex) GET, HEAD, POST

Last-Modified : 최근에 수정된 날짜

ETag : 캐시 업데이트 정보를 위한 임의의 식별 숫자

Connection : 클라이언트와 서버의 연결 방식 설정 HTTP/1.1은 kepp-alive 로 연결 유지하는게 디폴트.

- 요청 헤더

Host : 요청하려는 서버 호스트 이름과 포트번호

User-agent : 클라이언트 프로그램 정보 ex) Mozilla/4.0, Windows NT5.1

이 정보를 통해서 서버는 클라이언트 프로그램(브라우저)에 맞는 최적의 데이터를 보내줄 수 있다.

Referer : 바로 직전에 머물렀던 웹 링크 주소(해당 요청을 할 수 있게된 페이지)

Accept : 클라이언트가 처리 가능한 미디어 타입 종류 나열 ex) */* - 모든 타입 처리 가능, application/json - json데이터 처리 가능.

Accept-charset : 클라이언트가 지원가능한 문자열 인코딩 방식

Accept-language : 클라이언트가 지원가능한 언어 나열

Accept-encoding : 클라이언트가 해석가능한 압축 방식 지정 ex) gzip, deflate

압축이 되어있다면 content-length와 content-encoding으로 압축을 해제한다.

Content-location : 해당 개체의 실제 위치

Content-disposition : 응답 메세지를 브라우저가 어떻게 처리할지 알려줌. ex) inline, attachment; filename='jeong-pro.xlsx'

Content-Security-Policy : 다른 외부 파일을 불러오는 경우 차단할 리소스와 불러올 리소스 명시

ex) default-src https -> https로만 파일을 가져옴

ex) default-src 'self' -> 자기 도메인에서만 가져옴

ex) default-src 'none' -> 외부파일은 가져올 수 없음

If-Modified-Since : 여기에 쓰여진 시간 이후로 변경된 리소스 취득. 페이지가 수정되었으면 최신 페이지로 교체하기 위해 사용된다.

Authorization : 인증 토큰을 서버로 보낼 때 쓰이는 헤더

Origin : 서버로 Post 요청을 보낼 때 요청이 어느 주소에서 시작되었는지 나타내는 값

이 값으로 요청을 보낸 주소와 받는 주소가 다르면 CORS 에러가 난다.

Cookie : 쿠기 값 key-value로 표현된다. ex) attr1=value1; attr2=value2

- 응답 헤더

Location : 301, 302 상태코드일 떄만 볼 수 있는 헤더로 서버의 응답이 다른 곳에 있다고 알려주면서 해당 위치(URI)를 지정한다.

Server : 웹서버의 종류 ex) nginx

Age : max-age 시간내에서 얼마나 흘렀는지 초 단위로 알려주는 값

Referrer-policy : 서버 referrer 정책을 알려주는 값 ex) origin, no-referrer, unsafe-url

WWW-Authenticate : 사용자 인증이 필요한 자원을 요구할 시, 서버가 제공하는 인증 방식

Proxy-Authenticate : 요청한 서버가 프록시 서버인 경우 유저 인증을 위한 값
```
