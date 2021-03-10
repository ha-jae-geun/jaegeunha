# 인코딩
```java
웹 컨테이너가 JSP페이지를 읽어올 때 사용할 케릭터 셋을 결정하는 기본 과정

1)기본 인코딩을 파일을 읽은 후, pageEncoding을 찾는다.

2)pageEncoding을 찾으면 해당 속성을 사용하고, 없으면 contentType을 검색한다.

3)contentType을 찾으면 해당 속성의 charset을 사용한다.

4)모두 해당되지 않는경우 ISO-8859-1 을 사용한다.

#)단, (1)번 과 (3)번의 경우 대상을 찾기 이전에 ASCII문자 이외의 글자가 포함되어 있지 않은 경우에 한해 적용된다.

 

JSP페이지를 구현할때는 "EUC-KR"을, 응답결과는 "UTF-8"로 하고싶다면?

<%@ page contentType="text/html; charset=utf-8" %>

<%@ page pageEncoding="euc-kr" %>



출처: https://unabated.tistory.com/entry/JSP-pageEncoding속성-케릭터셋charset [랄라라]
```
