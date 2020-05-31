# 동일 출처 정책(SOP: Same-Origin Policy)
* 어떤 출처에서 불러온 문서나 스크립트가 다른 출처에서 가져온 리소스와 상호작용 하는 것을 제한하는 중요한 보안 방식
* 출처가 같다는 것은 두 URL의 프로토콜, 호스트, 포트 세 개가 모두 같다는 것


## 크로스 도메인 이슈
* SOP 때문에 자바스크립트(XMLHttpRequest)로 다른 웹 페이지에 접근할 때 같은 출처의 페이지에만 접근 가능
* SOP를 우회해서 서로 다른 도메인 간에 통신을 할 수 있게 해줄 뭉너가 필요
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
