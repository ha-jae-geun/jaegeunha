# 톰켓
- apache-8.5.39
- 톰켓 8부터는 별도의 설정하지 않아도 인코딩이 된다.
- 톰켓 7버전은 get방식일 때 별도의 설정을 해주어야 한다. 실무에서는 아직 7버전을 많이 사용한다.
- ⎼POST 방식은 문제가 없지만 GET 방식으로 전송된 파라미터에 대해서는 request.setCharacterEncoding( ) 메서드로 지정한 캐릭터 셋이 적용되지 않는다.
- ⎼Server 디렉토리의 server.xml 파일을 XML Editor로 열고 Source를 선택한 후 Connetctor 요소에 추가 할 코드를 추가하고 파일을 저장한 후 서버를 반드시 재 시작한다.
- ⎼추가 할 요소는 URIEncoding= “UTF-8” 와 useBodyEncodingForURI= “true” 로 두 요소를 모두 추가해주는 것이 인코딩에 효율적이므로 권장한다.
- <Connector connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="8443" URIEncoding= “UTF-8” useBodyEncodingForURI= “true” />

## 톰켓 환경변수 
1. 환경변수 이름: CATALINA_HOME(매번 버전 바뀌면 Path 그때마다 바꿔줘야하기 때문에 해줌)
2. PATH 추가: %CATALINA_HOME%\bin
- 혹은 bin을 바로 PATH에서 추가해주어도 됨
* 확인방법: cmd에서 bin 안에 있는 startup/tomcat8w 실행 가능

## 톰켓 이클립스 설정
- window preference - Runtime Envirionment - Add - 톰켓 폴더 설정

## 포트충돌
* 오라클과 8080 포트충돌; 
	* conf -> server.xml -> 포트변경
