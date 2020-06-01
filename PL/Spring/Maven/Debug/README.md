# Missing artifact org.springframework.boot:spring-boot-starter-parent:jar:1.3.2.RELEASE
```java
Why?
스프링부트 프로젝트 생성하였는데 오류가 발생(위에 오류메시지)
기존에 존재하던 Library 오류가 원인 가능성 높다.
###Solution

기존의 라이브러리를 삭제 -> 다시 다운로드 진행
" C:\사용자폴더\사용자계정폴더\m2 " 로 진입.
m2폴더 안에 repository 폴더를 삭제(Spring을 종료 한 상태에서).
스프링 재 시작.
스프링부트 프로젝트 다시 생성하기. (library를 다시 다운받으므로 시간이 평소보다 더 소요된다)
```
