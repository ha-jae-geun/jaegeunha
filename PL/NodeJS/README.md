# [ZeroCho](https://www.zerocho.com/category/NodeJS/post/57387cb8715202c8679b3af1)

# [ NODE JS란](https://velopert.com/node-js-tutorials)
```java
Javascript는 브라우저에 내장되어있다고 말했었지 여기로 들어와서 검사(Inspect)모드로 가면
브라우저에서 이것저것 할 수 있어 console.log로...아무거나 표시하면 작동할거야
왜냐면 JS가 브라우저에 내장되어 있으니까 Node.js가 한 일이 뭐냐면 
JS를 브라우저 밖으로 가지고 나와서 유저가 사용할 수 있게 한거지 유저의 컴퓨터에서 돌아가게 말야
브라우저 밖에서 말이지 이 말의 의미는 브라우저 밖의 Javascript가 되는거지 Node.js란 그런거야
브라우저 밖의 Javascript 그래서 우리가 할 수 있는게 뭐냐면 file system을 다룰 수도 있지
즉, Javascript를 이용해서 예를 들어 서버를 만들 수도 있고 우리가 앞으로 만들 서버도 그렇고
또 Javascript를 이용해서 Web Scrapper를 만들어서 웹페이지에 접속해서 정보들을 수집할 수 있어
왜냐면 Javascript는 프로그래밍 언어이기 때문이야 브라우저 밖으로 꺼내서 활용할 수 있는거야
브라우저와는 관계없이 말야 그러니까 Javascript를 이용해서 브라우저와는 별도로 작동하는 걸 만들 수 있는거지
브라우저 밖의 Javascript일 뿐이고, Open Source이고...
alert은 브라우저에서만 되는거군... 좋아 지금 본 것처럼 브라우저 밖의 Javascript
우린 node를 이용해서 모바일 앱을 만들수도 있고, 그리고 electron 어플도 만들 수 있어 왜냐면 더이상 브라우저가 필요가 없거든
우리의 console에서 사용할 수 있게 된거지 가능성이 무한해졌어
```

#  [Apache MPM vs NGINX vs Node.js](https://www.youtube.com/watch?v=QeBqwwbsBbM&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=27)


 # Apache MPM 
## MPM(Multi-Processing Modules)
* 서버는 시스템의 네트워크 포트에 연결하고, 요청을 받아들이며, 받아들인 요청을 처리하기 위해 자식들에게 분배하는 다중처리 모듈을 선택할 수 있다.
* 커넥션 생성(binding, accept)
* 커넥션 분배
    * 프로세스든 스레드든 해당 커넥션에 대한 요청을 담당합니다.
* 모듈 종류(Unix 계열)
    * prefork
        * 프로세스
    * worker
        * 스레드
    * event

## C10K Problem
* 10000개의 연결이 동시에 처리가 된다면?
    * 메모리, 컨텍스트 스위칭 고려해야 한다

 # NGINX 
 * 웹 서버이다
 * 확장성에 대한 대응방식은 node.js와 비슷
 * 웹서버라는 역할에 최적화
    * 좀 더 비동기 방식에 적합한 입력들(CPU 점유를 적게하는)
 
 
 ## 사용 예
 * 로드 밸런서
    * 효율성
    * 안정성(누군가 죽어도 다른 애가 있음)
 * 리버스 프록시
    * 보안, 유연성
  * 레이턴시 감소
      * 암축
      * SSL 암호화
      * 캐시
  * Node.js에서 조심해야 할 부분들을 많이 채워줌
      * 웹서버, 웹 어플리케이션 서버의 부담도 덜어줌
 
 # Node.js
 * Chrome V8 Javascript 엔진으로 빌드된 JavaScript 런타임입니다.
 * 비동기 이벤트 주도 JavaScript 런타임으로써 Node.js는 확장성 있는 네트워크 애플리케이션을 만들 수 있도록 설계되었다
 * 싱글 스레드로 돌려서 최대한 해야할 일만 할 수 있도록(컨텍스트 스위칭 영향 줄이기)
 * 기다려야 할 시간을 최소화(비동기 + 이벤트)
     * 네트워크 애플리케이션이 적용하기 딱 좋은 경우
 
 ## 주의해야할 점
 * 하나의 흐름(함수)이 완전히 끝나기 전에는 다른 흐름이 실행될 기회가 없다
 * CPU를 많이 사용할 경우를 주의해라
 * 조심해야하는 입력들
    * 정규표현식(REDOS)
    * Synchronous expensive API
        * 암호화
        * 파일 io
        * DNS에 요청
        * 프로세스 fork
    * JSON DOS

## 내부 처리 방식
* 이벤트 루프
    * 이벤트를 통해 일이 등록됨
    * 등록을 통해 제공 받은 일을 실행
* 자체적으로 다음에 어떤 일을 할지 스케줄링(커널에 맡기는 것이 아님)
