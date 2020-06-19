# url
```java
같은 출처와 다른 출처의 구분
사실 두 개의 출처가 서로 같다고 판단하는 로직 자체는 굉장히 간단한데, 두 URL의 구성 요소 중 Scheme, Host, Port, 이 3가지만 동일하면 된다.

https://evan-moon.github.io:80라는 출처를 예로 들면 https:// 이라는 스킴에 evan-moon.github.io 호스트를 가지고 :80번 포트를 사용하고 있다는 것만 같다면 나머지는 전부 다르더라도 같은 출처로 인정이 된다는 것이다.

필자의 블로그 출처인 https://evan-moon.github.io와 같은 출처로 인정되는 예시는 대략 이런 느낌이다.

URL	같은 출처	이유
https://evan-moon.github.io/about	O	스킴, 호스트, 포트가 동일
https://evan-moon.github.io/about?q=안뇽	O	스킴, 호스트, 포트가 동일
https://user:password@evan-moon.github.io	O	스킴, 호스트, 포트가 동일
http://evan-moon.github.io	X	스킴이 다름
https://api.github.io	X	호스트가 다름
https://evan-moon.naver.com	X	스킴이 다름
https://evan-moon.github.com	X	스킴이 다름
https://evan-moon.github.io:8000	?	브라우저의 구현에 따라 다름
```
```java
1. URL ( Uniform Resource Locator ) : 자원

    - 예전에는 URL이 가리키는게 파일소스 였다. 하지만 요즘은 Rewrite 등의 Apache, IIS, Tomcat 등의 핸들러 때문에 자원 이라고 부른다. 
    즉, 웹 사이트 주소가 (http://bong.com/bongwork/bk) 라고 했을때 요청하는 주소가 파일이라기 보다는 구분자로 보는 것이며 사용자의
    라우팅에 따라 실제로 웹 사이트의 bongwork/bk 라는 파일이 있을수도 없을수도 있다. 즉, 웹 상에서 서비스를 제공하는 각 서버들에 있는
    파일들의 위치를 표시하기 위한 것으로 접속할 서비스의 종류, 도메인명, 파일의 위치 등을 포함한다.

       ex) 예를 들어 http://bong.com/work/test.pdf 는 bong.com 서버에서 work폴더안의 test.pdf를 요청하는 URL이다.


* 예전에는 URL이 가르키는게 파일 소스
* 요즘은 Rewrite등의 아파치,톰켓등의 핸들러 때문에 자원이라고 부름
* 웹사이트 주소가 요청하는 파일이라기 보다는, 구분자로 보는 것
* 웹 상에 서비스를 제공하는 각 서버들에 있는 파일의 위치를 표시하기 위한 것
* http://blong.com/work/test.pdf 는 blog.com서버에서 work폴더안의 test.pdf를 요청



2. URI ( Uniform Resource Identifier ) : 통합 자원 식별자

    - 인터넷에 있는 자원을 나타내는 유일한 주소이다. URI의 존재는 인터넷에서 요구되는 기본조건으로서 인터넷 프로토콜에 항상 붙어다닌다. 
    URI의 하위 개념으로 URL, URN 이 있다.

       ex)  프로토콜 (HTTP 혹은 FTP) + : + // + 호스트이름 + 주소 -> 예 : http://bong.com

    - URI의 가장 보편적인 형태는 바로 웹페이지 주소인 URL인데 이것은 URI의 특별한 형태이자 부분집합으로 볼 수 있다. 대체로 아래와 같이 
    설명할 수 있다.

      (1) 자원에 접근하기 위해 사용되는 절차

      (2) 어떤 자원을 가지고 있는 특정한 컴퓨터

      (3) 컴퓨터 상의 유니크한 자원의 이름(파일명) 
      
* URI 특징
- 인터넷에 있는 자원을 나타내는 유일한 주소이다.
- URI의 존재는 인터넷에서 요구되는 기본조건으로서, 인터넷 프로토콜에 항상 붙어다님

- ex) http://www.naver.com (http프로토콜임을 명시하고 있음)
- URI의 하위개념에 URL,URN이 포함되어 있다.

- URI의 보편적인 형태가 URL인데, URI의 부분집합으로 볼 수 있다.

- 자원에 접근하기 위해 사용되는 절차
- 어떤 자원을 가지고 있는 특정한 컴퓨터
- 컴퓨터 상의 유니크한 자원의 이름(파일명)
- http://test.com/test.pdf?docid=111 이라는 주소는 URI이지만 URL은 아니다.
- http://test.com/test.pdf 까지만 URL임(주소의 위치)
- docid=111이라는 쿼리스트링의 값에 따라 결과가 달라지게됨, 따라서 식별자 역할을 하고 있음
- http://test.com/test.pdf?docid=111 ,http://test.com/test.pdf?docid=112는 같은 URL을 가지고 다른 URI를 가짐



* 위 2번 내용중에 URN이라는 개념은 좀 생소할 것 이다. URN이란 Uniform Resource Name 의 약자로 리소스 위치와 상관없이 리소스의 이름값을 이용  하여 접근하는 방식이다. 

예를 들어 네이버나 구글 검색에 노출된 URL http://bong.com/bongwork/323 이라 하면

http://bong.com/bongwork/bk/323 라고 변경 했을 경우에 만약 포털 사이트를 통해 링크를 클릭하여 접근하면 페이지를 찾을 수 없는 404에러를 표시 할 것이다. 이러한 부분을 보완하기 위하여 나온것이 위치 정보와는 상관 없이, 위치 정보가 바뀌어도 리소스를 찾을 수 있게 해당 리소스의 위치정보가 아닌 실제 리소스 이름으로 사용하는 방식이다.



출처: https://bkjeon1614.tistory.com/6 [아무거나]
```
