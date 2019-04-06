# picture
## request
- 클라이언트   (request 객체; http 프로토콜) ->  ajax -> 서버
- 클라이언트가 보낸 request가 서버에 닿기 전에 ajax가 request 객체를 담아서 XMLHttpRequest 객체를 생성하여 서버로 보내준다. 그럼 페이지가 바뀌지 않고 새로고침 필요없이 특정 부분만을 변경하는 것이 가능하다.
- request만 가로채서 XMLHttpRequest에 담는다.
- 클라이언트 - Ajax(XMLHttpRequest) - 웹서버(자바로 보낼 땐 http request로 바뀜) - 서블릿 - 자바
- 자바에서 서버로 다시 보낼 때 http request를 XMLHttpRequest로 바꿔줘야 하는데 이 때 MIME 확장자로 변경해주어야 한다. 변경해 주지 않으면 XMLHTTPREQUEST값이 null 값이 나옴
