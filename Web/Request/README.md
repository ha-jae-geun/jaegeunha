# META-INF
- 자바 패키징 기술인 jar의 일부
- META-INF폴더는 자바에서 설정관련 파일을 저장하는 폴더
- jar 파일들을 풀어보면 META-INF 폴더 아래 MANIFEST.MF 라는 파일이 있고 사양서 내용이 있다.
- 스프링 설정 파일을 META-INF에 두는 이유는  해당 애플리케이션을 war가 아닌 jar로 패키징해서 배포할 수 있기 때문.

# 세션
- 세션 id를 가지고 유지를 시킨다.
- HTTP 프로토콜은 요청(request)과 응답(response)의 구조로 되어 있어 서버가 요청에 대한 응답을 전송하고 나면 연결이 끊어지게(Stateless) 된다.
- 클라이언트의 정보가 유지되어야 할 필요가 있는 경우를 위해 가상 연결(Virtual Connection)이라는 개념의 세션이 등장하였고 JSP 에서는 이러한 세션을 session 내장 객체를 이용하여 구현한다.
- session 객체는 브라우저가 종료되어야 해제된다.
- session 객체는 강제로 끊어주거나 웹브라우저를 닫지 않는 한 계속 정보를 유지할 수 있다.



# request 객체의 request 문자열 인코딩과 요청 파라미터 관련 메서드
1. setCharacterEncoding 메서드
- setCharacterEncoding( ) 메서드는 문자열 인코딩 정보와 관련된 메서드로 문자를 인코딩을 해서 JSP로 전달해주며 한글일 경우 웹 페이지에서 꼭 필요하다.

2. getParameter 메서드
- getParameter(name) 메서드는 지정한 name 의 이름으로 지정된 파라미터에 할당된 값을 리턴 하므로 인자의 문자열과 같은 파라미터 값을 가져온다.
- getParameter(name) 메서드는 지정한 name 의 이름의 파라미터가 없으면 null 을 리턴한다.

3. getParameterValues 메서드
- getParameterValues(name) 메서드는 name 의 이름으로 지정된 파라미터의 모든 값을 문자열 배열로 리턴하고 하나의 이름으로 여러 개의 값을 가질 수 있다.
- getParameterValues(name) 메서드는 HTML 의 checkbox 요소와 같은 태그를 사용했을 때에 주로 사용되고 인자의 문자열과 같은 파라미터의 값을 배열로 가져온다.
- 하나의 이름에 하나의 값만 가지는 파라미터는 getParameter( ) 메서드를 사용하는 것이 좋다.

4. getParameterNames 메서드
- getParameterNames( ) 메서드는 요청에 포함된 모든 파라미터 이름을 Enumeration 인터페이스의 객체로 리턴하고 파라미터의 이름들을 나열하여 넘겨준다.

## request 객체의 쿠키 정보와 세션 정보 관련 메서드
1. getCookies 메서드
- getCookies( ) 메서드는 쿠키 정보와 관련된 메서드로 HTTP 요청 메시지의 헤더에 포함된 쿠키를 Cookie 클래스 배열로 리턴하고 모든 쿠키값을 배열 형태로 가져온다.

2. getSession 메서드
- getSession(Boolean create) 메서드는 세션 정보와 관련된 메서드로 요청한 클라이언트에 지정된 HttpSession 인터페이스의 객체를 반환하고 이전에 생성된 HttpSession 인터페이스의 객체가 없으면 새로운 객체를 생성해 할당한다.
- getSession(Boolean create) 메서드에 인자로 true 지정하면 getSession( ) 메서드와 동일한 결과를 리턴 하지만 false 로 지정하면 이전에 생성된 HttpSession 인터페이스의 객체가 없을 경우 null 을 리턴한다.

3. getRequestedSessionld 메서드
- getRequestedSessionld( ) 메서드는 세션 정보와 관련된 메서드로 요청한 클라이언트에 지정된 세션의 ID를 문자열로 리턴한다.

4. isRequestedSessionldValid 메서드
- isRequestedSessionldValid( ) 메서드는 세션 정보와 관련된 메서드로 요청한 포함된 클라이언트의 세션 ID가 유효하면 true 를 아니면 false 를 리턴한다.
