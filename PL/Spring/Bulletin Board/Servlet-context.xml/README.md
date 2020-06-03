# controller가 client의 요청을 받을 수 있도록 kr.co.controller로 설정을 해줍니다. 
```java
src/main/webapp/spring/appServlet/servlet-context.xml로 들어갑니다.

아마 처음에 프로젝트만들때 패키지를 kr.co.study로 만드셨다면 kr.co.study로 설정 되어있으실겁니다.

<context:component-scan base-package="kr.co.controller" />
```
