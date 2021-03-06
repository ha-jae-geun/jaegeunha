# Ajax
* ⎼ 는 자바스크립트로 요청을 보내서 응답을 받아서 사용하는 기술로서 요청을 보내면 Ajax HTTP XML HTTP XML 문서를 응답으로 받게 되므로 사용자가 보고 있는 페이지를 새로 고침 할 필요 없이 서버에 요청하여 (refresh) 데이터를 가져와 특정 부분만을 변경하는 것이 가능하다.
- 클라이언트 - Ajax(XMLHttpRequest) - 웹서버(자바로 보낼 땐 http request로 바뀜) - 서블릿 - 자바
- 새로고침과 같은 기능
- ⎼Ajax는 Asynchronous(비동기) JavaScript and XML의 약어로 비동기로 데이터 통신을 처리하기 위한 기술로 특정 언어나 플랫폼 혹은 프레임워크나 라이브러리를 뜻하는 것이 자바스크립트로 원격지로부터 데이터 를 읽어오는 데 필요한 처리 기술들의 집합체를 뜻한다.
- Ajax는 자바스크립트로 HTTP 요청을 보내서 XML 응답을 받아서 사용하는 기술로서 HTTP 요청을 보내면 XML 문서를 응답으로 받게 되므로 사용자가 보고 있는 페이지를 새로 고침(refresh)할 필요 없이 서버에 요청하여 데이터를 가져와 특정 부분만을 변경하는 것이 가능하다.
- 새로 고침이라는 말을 풀어서 쓰면 http 프로토콜의 request 객체를 계속 사용한다는 말과 같다. 이는 비동기식 방법이고 기존은 동기식 방식이다.
- 비동기식 방식: 포워드;   동기식: 리다이렉트 -> 상태줄이 바뀐다.
* ⎼ 가 적용된 페이지는 전체 이 아닌 이나 형식으로 구성된 새로운 데이터만을 Ajax HTML XML JSON XMLHttpRequest 객체를 통해 받아오기 때문에 페이지 이동 없이 새로운 내용을 사용자에게 제공할 수 있다.
*  는 웹 페이지에 보여야 할 데이터를 웹 프로그램에서 생성하고 그 데이터를 자바스크립트를 통해 페이지 Ajax 이동 없이 화변에 출력한다. 
* 의 특성을 통해 웹 프로그래머와 웹 퍼블리셔의 작업 영역이 완전히 분리되면 더욱 효율적인 작업이 가능하다 Ajax . 

## (1) 웹 퍼블리셔 영역 
* ⎼ 를 사용한 웹 페이지의 를 구성한다 HTML+CSS UI . ⎼ 를 사용하여 사용자가 입력한 내용을 웹 서버에 전달 요청 하고 그에 따른 결과를 화면에 출력하기 위해 Ajax ( ) 을 제어한다 DOM . 

### 웹 프로그래머 영역 
* 웹 페이지의 요청에 따른 데이터를 이나 으로 구성하여 자바스크립트에 전달한다 XML JSON . 
* 데이터를 구성하는 과정에서 데이터베이스를 통한 입력 수정 삭제 조회 등의 작업이 처리될 수 있다 / / / .

## ajax가 필요한 이유
1. 필연적인 페이지 처리 
* Redirect ⎼웹페이지의 동작에는 반드시 요청과 응답의 관계가 성립 되어야 하므로 페이지 처리가 필수적이기 Redirect 때문에 사용자 입장에서는 모든 처리마다 페이지 이동이 발생하는 것처럼 느껴질 수 밖에 없다. 
* 동기식 데이터 통신 처리 는 아주 약간의 변경사항을 보여주기 위해서일지라도 전체 코드를 재전송해야하는 HTML 비효율적인 측면이 있고 그 과정에서 과도한 트래픽을 발생시키게 되고 서버의 유지비용이 더 크게 발생하게 된다. 

2. 작업의 비효율성 ⎼웹 페이지의 를 구성한 퍼블리싱의 결과물에 웹 프로그래머가 재 작업하여 웹 프로그램을 추가하는 기존 UI 방식에서는 웹프로그래머가 퍼블리싱의 결과물이 있어야 작업을 진행할 수 있기에 기간이 오래 걸리고 서로간의 결과물이 뒤섞여 유지보수가 어렵게 된다.

## ajax의 객체 생성
- 경로가 바뀌는 것이 아니라 객체가 생성되는 것임, 예를 들어 메모장에서 파일을 연 것이 아니라 웹에서만 바뀌고 웹 주소에서는 경로가 이동된 것처럼 보여지지만 객체만 생성된 것임.

# request
- 클라이언트   (request 객체; http 프로토콜) ->  ajax -> 서버
- 클라이언트가 보낸 request가 서버에 닿기 전에 ajax가 request 객체를 담아서 XMLHttpRequest 객체를 생성하여 서버로 보내준다. 그럼 페이지가 바뀌지 않고 새로고침 필요없이 특정 부분만을 변경하는 것이 가능하다.
- request만 가로채서 XMLHttpRequest에 담는다.
- 클라이언트 - Ajax(XMLHttpRequest) - 웹서버(자바로 보낼 땐 http request로 바뀜) - 서블릿 - 자바
- 자바에서 서버로 다시 보낼 때 http request를 XMLHttpRequest로 바꿔줘야 하는데 이 때 MIME 확장자로 변경해주어야 한다. 변경해 주지 않으면 XMLHTTPREQUEST값이 null 값이 나옴(MIME 쓸 때는 자바를 이용해서 DB에 있는 정형 데이터를 가져오는 것임)


# Ajax 처리의 크로스 도메인 제약의 극복
- 자바스크립트의 경우에는 동일 출처 정책의 영향을 받지만 웹 프로그램 언어의 경우 동일 출처 정책의 영향을 받지 않는다.
- 웹 프로그램은 서버에서 실행되지만 자바스크립트는 클라이언트 브라우저에서 실행되기 때문에 크로스 도메인 처리를 위해서는 자바스크립트가 하지 못하는 일을 웹 프로그램에 의존하여 처리하는 방법이 가장 일반적으로 사용된다.
- 자바스크립트에서 XMLHttpRequest 객체를 사용하여 원격지의 다른 파일을 페이지 이동 없이 로드하는 기술이 Ajax의 핵심이다.
- Ajax와 같은 원리의 기술은 다른 언어들에서도 구현 가능하며 코드에서의 표현방법은 다르지만 원리는 모두 동일한 것이다.
- 자바스크립트가 자신과 동일한 도메인의 웹 프로그램 에게 요청을 보내면 해당 웹 프로그램은 그 요청을 외부의 다른 도메인에 소속된 페이지로 대신 전달하고 응답을 받는 것이다.
- 웹 프로그램은 자신이 받은 외부로부터의 응답을 자바스크립트에게 전달해 주는데 이처럼 요청과 응답의 중간다리 역할을 하는 페이지를 프록시 페이지라고 한다.


# XML
## XML 데이터 구조
- 텍스트 데이터는 데이터 형식이 비정형적이기 때문에 구조적인 데이터를 표현하기에는 한계가 있으므로 복잡한 데이터 계층을 구별하기가 쉽지 않다.
- 복잡한 계층의 데이터도 어렵지 않게 표현 가능한 XML이 Ajax를 통해 전달되고 읽혀지게 되는 데이터의 구조를 담당하게 된다.
- XML(Extensible Markup Language)은 W3C에서 권장하는 다목적 마크업 언어로 다른 특수 목적의 마크업 언어를 만드는 용도에 주효하며 수많은 종류의 데이터를 기술하는 데 적합하다.
- XML은 주로 다른 시스템끼리 데이터를 쉽게 주고받을 수 있게 하여 HTML의 한계를 극복할 목적으로 만들어졌다.
- XML은 HTML과 같이 문서구조를 트리 형태로 하여 객체화 할 수 있는 DOM(Document Object Model) 구조이다


# 3-1. XMLHttpRequest의 주요 속성
1. readyState 속성
- Ajax 객체의 상태를 나타내는 숫자이다.
- 처음 Ajax 객체를 생성하면 0이고 get 함수로 요청할 페이지 정보를 설정하면 1이 되고 send 함수로 요청을 보내면 2가 되고 서버에서 응답이 오기 시작하면 3이 되고 서버 응답이 완료되면 4가 된다.
- readyState 속성은 읽기 권한을 가진다.

2. status 속성
- 서버로부터 받은 응답의 상태를 나타내는 숫자이다.
- 정상적으로 응답을 받는 읽기전용 경우 200이고 페이지를 찾지 못한 경우 404가 된다.
- status 속성은 읽기 권한을 가진다.
3. statusText 속성
- 서버로부터 받은 응답의 상태를 나타내는 문자열 이다.
- 정상적으로 응답을 읽기전용 받으면 OK가 되고 파일을 찾지 못하면 Not Found가 된다.
- statusText 속성은 읽기 권한을 가진다.

4. responseText 속성
- 서버 응답 내용을 나타내는 문자열이다.
- responseText 속성은 읽기 권한을 가진다.

5. responseXML 속성
- 서버 응답 내용을 나타내는 XML 객체이다.
- responseXML 속성은 읽기 권한을 가진다.

6. onreadystatechange 속성
- readyState 속성이 바뀌었을 때 실행할 이벤트 핸들러를 지정한다.
- onreadystatechange 속성은 읽기와 쓰기 권한을 가진다.
