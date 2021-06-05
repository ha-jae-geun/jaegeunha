# [에반문 CORS](https://evan-moon.github.io/2020/05/21/about-cors/)
# [테코톡 CORS](https://www.youtube.com/watch?v=_sLjXviYivM&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=24)
# [나봄의 CORS](https://youtu.be/-2TgkKYmJt4)

```java
프론트엔드 서버와 백엔드 서버를 따로 구성하는 경우가 많다.
이렇게 출처(origins)가 다른 경우 보안상 문제로 요청을 주고받을 수 없는 것이 웹 브라우저 기본 정책이다. 
하지만 CORS (Cross Origin Resource Sharing)라는 방식을 통하면 서로 다른 출처라도 요청을 주고받을 것이 가능하다.

SOP (Same Origin Policy)
웹 애플리케이션 중요한 보안 개념 중 하나가 동일 출처 정책이다.
동일 출처란 같은 도메인, 프로토콜, 포트를 의미한다.
같은 도메인, 같은 포트에 있는 리소스를 불러올 때는 문제가 없지만 다른 출처의 리소스를 요청하는 것을 제한하는 보안 방식이다.



참고자료 - poiemaweb.com

CORS (Cross Origin Resource Sharing)
서로 다른 출처(origin)로 상호작용을 하기 위해 서버와 클라이언트가 정해진 헤더를 통해 서로 요청이나 응답에 반응할지 결정하는 방식이다.

server
HTTP 응답 헤더 Access-Control-Allow-Origin : * 혹은 Access-Control-Allow-Origin: 허용하고자 하는 도메인을 설정해 준다.

express
const express = require('express')
const cors = require('cors')
const app = express()
 app.use(cors())  // cors(*)
client
서버에서 서버로 보내는 요청은 CORS 에러가 적용되지 않는다.
프록시 서버를 추가로 만들어서 클라이언트에서 우리가 새로 만든 프록시 서버로 요청을 보내고 프록시 서버에서 
원하는 타깃 서버에 요청을 보내면 브라우저가 개입되지 않았기 때문에 CORS 에러를 해결할 수 있다.

프록시 서버 : 브라우저와 서버를 통신하는 과정 중간에서 정보교환을 도와주는 중간 서버이다.
( 브라우저 - 프록시 서버 - 서버 )
프록시 서버는 헤더를 추가하거나 요청을 허용/거부하는 역할을 중간에서 해준다. (Access-Control-Allow-Origin :
*의 헤더를 담아 응답해 준다.)


출처 - 위키백과

react
src/setupProxy.js

const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
  app.use(
    '/api',
    createProxyMiddleware({
      target: `${process.env.REACT_APP_FETCHING_SERVER_URL}`,
      changeOrigin: true,
    })
  );
};
```
# 동일 출처 정책(SOP: Same-Origin Policy)
* 어떤 출처에서 불러온 문서나 스크립트가 다른 출처에서 가져온 리소스와 상호작용 하는 것을 제한하는 중요한 보안 방식
* 출처가 같다는 것은 두 URL의 프로토콜, 호스트, 포트 세 개가 모두 같다는 것


## 크로스 도메인 이슈
* SOP 때문에 자바스크립트(XMLHttpRequest)로 다른 웹 페이지에 접근할 때 같은 출처의 페이지에만 접근 가능
* SOP를 우회해서 서로 다른 도메인 간에 통신을 할 수 있게 해줄 무언가 필요
* 개발자들이 몇 가지 해결책 만듦
* 그 중 가장 많이 이용한 방법
    * JSONP
    * Reverse Proxy
    * Flash Socket

# CORS의 등장
* 크로스 도메인 이슈를 해결하는 표준의 필요성 대두
* W3C에서 권장사항으로 CORS 사양 발표
* 현재 활발하게 유지 고나리되는 사양은 WHATWG의 'Fetch Living Standard'


# CORS(Cross-Origin Resource Sharing)
* 웹 브라우저에서 외부 도메인 서버와 통신하기 위한 방식을 표준화한 스펙
* 서버와 클라이언트가 정해진 헤더를 통해 서로 요청이나 응답에 반응할지 결정하는 방식

## CORS의 동작 방식
* 간단한 요청(Simple Requests)
* 사전 요청(Preflight Requests)
* 인증을 이용하는 요청(Credential Requests)

## 간단한 요청
* 기존 데이터에 사이드 이팩트를 일으키지 않는 요청
* CORS 사전 요청을 발생시키지 않는 요청
* 조건
    * GET, HEAD, POST 중 한 가지 방식을 사용
    * Custom Header가 존재하지 않음
    * POST일 경우 Content-Type이 아래 셋 중 하나를 만족
        * application/x-www-form-unlencoded
        * multipart/form-data
        * text/plain
        
        
## 사전 요청(Preflight Requests)
* 본 요청을 보내기 전에 사전 요청을 보내 서버가 이에 응답이 가능한지 확인하는 방법
* 사진 요청을 보내는 경우
    * GET, HEAD, POST 이외의 요청
    * POST일 경우 Content-Type이 아래 셋 다 아닐때
        * application/x-www-form-unlencoded
        * multipart/form-data
        * text/plain
        * 커스텀 헤더가 포함된 경우
* 사전 요청 과정
     1. 동일한 URI에 OPTIONS method로 요청
     2. <1>요청에 대해 서버에서는 허용되는 메서드, 허용되는 헤더, 쿠키 허용 여부를 응답
     3. <2> 요청의 응답이 요청을 허용하는 조건이라면 본 요청을 보냄



## 인증을 이용하는 요청(Credential Requests)
  * XHR은 기본적으로 요청을 보낼 때 쿠키를 전송하지 않음
  * 요청에 쿠키를 포함하고 싶다면 XMLHttpRequest 객체의 withCredentials 프로퍼티 값을 true로 설정
  * 서버 측도 Access-Control-Allow-Credentials 응답 헤더를 true로 설정
