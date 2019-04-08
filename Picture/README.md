# picture
## request
- 클라이언트   (request 객체; http 프로토콜) ->  ajax -> 서버
- 클라이언트가 보낸 request가 서버에 닿기 전에 ajax가 request 객체를 담아서 XMLHttpRequest 객체를 생성하여 서버로 보내준다. 그럼 페이지가 바뀌지 않고 새로고침 필요없이 특정 부분만을 변경하는 것이 가능하다.
- request만 가로채서 XMLHttpRequest에 담는다.
- 클라이언트 - Ajax(XMLHttpRequest) - 웹서버(자바로 보낼 땐 http request로 바뀜) - 서블릿 - 자바
- 자바에서 서버로 다시 보낼 때 http request를 XMLHttpRequest로 바꿔줘야 하는데 이 때 MIME 확장자로 변경해주어야 한다. 변경해 주지 않으면 XMLHTTPREQUEST값이 null 값이 나옴


# 서버 페이지
- form -> 서버 페이지(자바는 서블릿; jsp) -> 데이터베이스
- 1. sun에서 개발한 서블릿: JSP 2. 개발자가 개발한 서블릿
- 입력폼(JSP)  -> 컨트롤러(커스텀 서블릿; 개발자가 개발)  ->  자바(모델) -> DB -> 모델 -> 컨트롤러(커스텀 서블릿; 개발자가 개발) -> 출력폼(JSP)
- 컨트롤러 역할까지 했던 예전과 달리 지금 JSP는 뷰 역할만 한다.
- 입력폼 -> 웹 서버 -> 웹 어플리케이션 서버 -> 데이터 베이스 -> 웹 어플리케이션 서버 -> 웹서버 -> 출력폼
- 톰켓 8부터는 별도의 설정하지 않아도 인코딩이 된다.
