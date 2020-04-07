



# 웹 서버 언어
## CGI(Common Gateway Interface)
- ⎼ 는 의 약어로 응용 프로그램과 웹 CGI Common Gateway Interface 서버 사이의 정보를 주고받는 방식이나 규약들을 정해 놓은 것을 말한다.
- ⎼크게 보면 JSP나 PHP, Perl, ASP 등이 모두 CGI의 범주에 들어간다고 볼 수 있는데 CGI가 개발된 이유는 단순한 HTML 방식으로는 동적인 웹 페이지를 만들기 어렵기 때문에 서버 측에서 동적인 데이터를 처리해 클라이언트에
HTML 문서로 전송해 줄 수 있는 응용 프로그램의 필요성 때문이다.
⎼초기 CGI 프로그래밍에서 사용된 Perl 웹 프로그램의 경우 파일 DB인 텍스트 파일이나 MDB 등의 사용은 편리하지만 데이터베이스(DBMS)와의 연동이 매우 불편하고 쉽게 익히기 어려운 단점이 있다.

## ASP
- Active Server Page의 약어로 동적인 웹 페이지의 구현을 위해 Visual Basic 언어를 기반으로 만들어진 VBScript라는 스크립트 언어를 사용해서 구성된 웹 프로그래밍 기술이다.
- ⎼스크립트 언어(Script Language)는 컴파일이 필요 없이 해석기(인터프리터)에 의해 즉시 실행될 수 있는 프로그램 언어를 스크립트 언어로 대표적으로는 브라우저에 의해 해석되어 실행되는 JavaScript 등이 있다.
- ⎼ASP는 Visual Basic을 기반으로 하여 만들어 졌기 때문에 쉬운 문법을 가지고 있어서 빠르고 쉽게 개발할 수 있고 Active-X 및 DDL 컴포넌트를 사용하여 어느 정도의 확장성도 갖추었다고 할 수 있지만 웹 서버로 오직 Windows NT 기반의 IIS (Internet Inforrnation Server)만을 사용할 수 있기 때문에 플랫폼에 비독립적이라는
큰 단점을 가지고 있다.
- ⎼ASP.NET이 ASP와 유사하지만 실제로는 아주 다르고 ASP.NET은 전적으로 객체 기반이며 모든 객체는 그 자신의 프로퍼티, 메서드 그리고 이벤트들을 가질 수 있다.
- ⎼웹 어플리케이션들을 개발할 때 객체 지향 접근을 제공하므로 ASP.NET은 모든 개발자에게 웹 어플리케이션 개발을 더욱 쉽고 다양하게 그리고 유용하게 개발할 수 있게 해준다.
- ⎼Java 기반의 JSP에 비해 시스템 자원의 효율성과 확장성이 떨어진다는 단점이 있다.


## PHP
- PHP는 ASP와 유사한 스크립트 기반의 언어이지만 ASP와는 다르게 C를 기반으로 만들어진 언어이기 때문에 빠른 속도를 가지고 있다.
- ⎼다양한 플랫폼에서 사용이 가능하며 개인적인 용도로 개발된 언어이기 때문에 100% 무료로 사용할 수 있다는 장점이 있지만 서버 측의 자원 인프라가 매우 부족하며 확장성이 떨어지고 기업형의 복잡한 시스템 구조에 적용하기가 힘들 뿐만 아니라 보안상의 약점을 가지고 있다는 단점이 있다.







# 브라우저; 톰켓 이용 <>http; 컨트롤러(http 파라미터) <> 자바(모델, 서비스, DAO) <> DB 
- 컨트롤러가 자바면 JSP, C#이면 ASP, PHP면 PHP
- 자바에서 중간 연결체: 클래스 -> 웹과 연동을 하는 클래스: 서블릿이라고 부름
- jsp도 서블릿 역할; 컨트롤러 역할도 함# 리눅스
* 무료고 오픈소스라서 다양한 소프트웨어가 돌아감
* 콘솔에서 소프트웨어 설치 가능
* 코드는 오픈소스 무료이고 깃허브에서 코드 볼수 있고 파일을 커스터마이징 가능
* 아마존 서버는 리눅스 서버에서 돌아감



## 쿠키의 룰
1. 같은 도메인에서만 한정
* 자동적으로 보냄
* 자동적으로 세팅
* 페이스북이 만든 쿠키는 페이스북안에서만 보내질 수 있지만 페이스북의 좋아요 버튼이 들어간 링크에의 쿠키가 페북으로 들어감
- 보내주는 방법: 1. 새로운 request 생성(redirect)  2. 기존의 request 유지(forward)
- 포워드 방식을 자주 사용




















## 필터(Fiter) 
* 필터의 개요 ⎼필터는 특정한 요청을 처리하기 전이나 후에 특정한 작업을 처리하는 기능이다. 
* 필터는 의 요청과 응답을 변경할 수 있는 재사용 가능한 객체이다 http . 
* 클라이언트의 특정 또는 공통의 요청 정보를 점검하거나 알맞게 변경하는 등 다음과 같은 것들을 할 수 있다
* 인증 로깅 요청 처리 데이터 변환 암호화 체크 



## web.xml
- 자바 -- web.xml -- 웹, 모바일
- web.xml을 어노테이션으로 구현(코드의 불필요 부분을 줄임)
- 존슨이 Spring을 이용하여 EJB를 사용하지 않고 구성.
1. 파일의 성격을 구성
2. 오류 페이지 구성
3. http 프로토콜의 영향 설정
4. 리스너 -> TCP/IP
5. 공통된 인코딩 설정 가능
- web.xml 파일은 <web-app> 태그로 시작하고 종료하는 문서로서 web.xml 파일에서는 정의된 Web Application 으로 구성된 임의의 디렉토리는 다음과 같은 것들이 존재한다.
1.  JSP 와 HTML 파일 그리고 이미지 파일과 같은 정형 데이터 파일 등 클라이언트에서 수행되는 파일
2. DD(Deployment Desciptor) 파일
3. 환경 파일
4. Servlet 과 같은 서버 상에서 수행되는 클래스 파일


## 설정파일
- 자바 -> JDK 필요
- 웹, 모바일 -> 서블릿(추상클래스; 자바와 웹을 연동)
- xml: 매핑, 상속

## 실행
- Servlet이 control 역할을 하면 jsp를 바로 실행 못하고 Servlet을 실행시켜야 한다.

## ajax
- put, delete는 ajax와 같이 사용

## HttpServlet

## jsp의 서블릿
- 톰켓 서버의 web.xml 보면 서블릿 이름이 jsp가 있어 동작하게 하는 기본 서블릿이 있다.


## 클래스
- 각 클래스 마다 1개의 서블릿 필요; 입력 서블릿, 수정 서블릿, 삭제 서블릿, 검색 서블릿

## 서블릿 설정
* xml에서 등록 안해놓으면 자바 코드에서 @servlet 찾음
-   <!-- 1. aliases 설정 -->
-     <servlet>
-         <servlet-name>welcome</servlet-name>
-         <servlet-class>servlets.WelcomeServlet</servlet-class>
-     </servlet>

-     <!-- 2. 매핑 -->
-     <servlet-mapping>
-         <servlet-name>welcome</servlet-name>
-         <url-pattern>/welcome</url-pattern>
-     </servlet-mapping>

### url-pattern
- *.me 는 모든 걸 동작시킴
- /클래스 이름; 충돌 방지 위해 클래스와 이름을 매칭함.

### aliases 설정
- 서블릿 이름을 실제 서블릿 클래스에 연결
- <servlet-name>welcome</servlet-name>과 아래 매핑 설정에서의 servlet-name은 반드시 같아야 한다.
- <servlet-class>servlets.WelcomeServlet</servlet-class>은 개발자에 의해 작성된 실제 클래스 이름으로 설정해야 한다.
- Ex. (패키지 이름).(서블릿 클래스 이름)
- 매핑
- URL을 서블릿 이름에 연결
- <url-pattern>/welcome</url-pattern>은 클라이언트(browser)의 요청 URL에서 앱(프로젝트) 이름 뒤에 오는 부분으로, 슬래시(‘/’)로 시작해야 한다.

## 경로
- navigator에서 build와 webContent를 같은 위치로 보고 classes와 WEB-INF와 META-INF가 같은 위치라고 본다. classes 안의 패키지는 경로로 보지 않는다.

# http
## ://
- http 프로토콜을 하위 디렉토리에 영향을 주겠다.


## ASP, PHP, JSP, 서블릿
- ASP는 IIS라는 웹서버에서 동작하는 언어이며 비베스크립트라고 불리운다.
- PHP는 APACHE 혹은  PHP용 웹서버가 있는 웹서버에서 동작하는 언어. 가볍다 빠르다.
IIS에서도 돌릴 수 있다.
- JSP는 자바에서 나온 웹언어. 자바용 서버인  TOMCAT이나 RESIN, JSERV에서 돌릴수 있다.
- APACHE : 공개용 웹서버, 작고 빠르기때문에 중소형 웹서버에 많이 쓰인다. APCHE는 보통 리눅스                  에 많이 설치한다. 무료인데다가 안정성 또한 우수하기 때문이지~
- 스프링 프레임워크가 서블릿 사용: 서블릿

# 커넥터 풀
## tomcat-dbcp
-  톰켓을 사용하지 않을수도 있으니 잘 사용 안함.

## response.setContentType("text/html;charset=UTF-8");



# 액션 태그; 커스텀 테그
- 서블릿 통합

## 종류

- forward, include 액션 사용 안함, useBean만 액션 사용

## useBean
-  <jsp:useBean id="com" class="a.b.c.dto.Command" scope="page" ></jsp:useBean>
- scope=”page”는 이 파일에서만 사용하겠다.
- <jsp:setProperty property="name" name="com" value="길동홍"/>


- 이걸 사용하면 new 선언할 필요 없이 id가 instance 뒤가 클래스
- Command com = new Command(); 와 동일

## EL

### 널 연산자
- a. 사용법 : empty
- b. 내용 : 값이 null 일 경우 true를 반환한다.

## JSP 커스텀 태그; 개발자가 만든 액션 태그; 
- 표준 액션 태그의 기능을 내장하고 있다.

## taglib 다운 
- 1.2버전: http://tomcat.apache.org/taglibs/standard/; impl, el, spec, compat 4개 다운

# import
- 웹은 war파일 export, import

## redirect
- web container는 redirect 명령이 들어오면 웹 브라우저에게 다른 페이지로 이동하라는 명령을 내린다.(두번째 사례의 경우, 고객은 전화를 끊고 124번으로 다시 전화를 건다.
- 웹 브라우저는 URL을 지시된 주소로 바꾸고 그 주소로 이동한다.
- 새로운 페이지에서는 request,response 객체가 새롭게 생성된다. (123번에서 고객이 요청했던 문의사항은 124번으로 다시 걸어서 요청한 문의사항을 다시 말해야한다.)
- redirect의 경우 최초 요청을 받은 URL1에서 클라이언트에 redirect할 URL2를 리턴하고, 클라이언트에게 새로운 요청을 생성하여 URL2에 다시 요청을 보낸다. 따라서 처음 보냈던 최초의 요청정보는 더이상 유효 하지 않다.

# page import
- <%@ page import="java.lang.String" %>


# CheckBox 배열 값 받기; pg308
- paramValues로 배열값 받기

- <c:forEach var="hobby" items="${paramValues.hobby}" varStatus="status">
- ${hobby}
- </c:forEach>





# XPath 개요
- xml 소스 트리의 정확한 위치를 지정해주기 위한 경로지정 문법이고 XSLT 와 XPointer 를 위해서 만들어진 것이며 xml 엘리먼트들을 노드(node)로 접근하고 XSLT 언어에 사용될 목적으로 설계되었다.
- .XML 문서는 트리 구조로 구조화 되어 있기에 XPath 라는 [약속된 경로 표기법]을 사용한다.
- .XML 문서의 프로그래밍 API 인 DOM(Document Object Mode)에서 노드를 검색할 때 사용한다.
- XPath 를 사용하려면 xalan.jar 라이브러리가 필수적으로 필요하며 다음과 같은 특성이 있다.
- ① XPath 는 절대 경로와 상대 경로 사용가능하며 절대경로 /(슬래시) 로 시작하고 상대 경로는 '.'(현재 단계 점1개)'..'(상위단계 점2개)을 사용한다.
- ② //(쌍 슬래시)로 시작할 경우는 모든 영역에서 해당 엘리먼트를 선택하게 된다.
- ③ 동일한 엘리먼트들이 있을 경우 [ ] 안에 포함된 숫자는 엘리먼트의 순번이며 조건식이 올 경우 해당하는 것이 선택된다.
- ④ last 메서드 일 경우는 맨 마지막 엘리먼트를 표시한다.
- ⑤ 속성은 at 기호(@)로 시작된다.
- ⑥ normalize-space 함수는 앞뒤 공백을 제거하는 trim 메서드의 역할을 한다.


