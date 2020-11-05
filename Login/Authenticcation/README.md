# [테코톡 인증 token](https://www.youtube.com/watch?v=y0xMXlOAfss)
# [테코톡_인증 OAuth](https://www.youtube.com/watch?v=JZgD8aPkHSc&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=45)

# 인증(Authentication)
* 보호된 리소스에 접근하는 것을 허용하기 이전에 등록된 유저의 신원을 입증(validating)하는 과정
```java
Identification : ID
Authentication : ID +PASSWORD
Authorization : 권한
Certification : 증명, 자격

```

# Factor 인증
1. Something Possessed
   * ID CARD
   * Security OU software
   * token
   * cell phone
2. Something Inherent
   1. 지문
   2. 홍책
3. Something known
   1. 패스워드
   * PIN

# 채널 인증
1. PC(인터넷)
2. ARS
3. 스마트폰 앱

# 인가(Authorization)
* 보호된 리소스에 접근할 수 있는 권한이 있는 인증된 유저인지를 입증하는 과정

# 순서
* 인증 -> 인가

## 인증되엇지만 권한이 없다
* 인가가 없다는 뜻

## 인가되었지만 인증은 되지 않았다

# 웹에서의 인증/인가
* 요청 헤더
* 세션 쿠키
* 토큰
* OAuth


# [OAuth](https://jeong-pro.tistory.com/99?category=793347)
* 다른 웹사이트 상의 자신들의 정보에 대해 접근 권한을 부여할 수 있는 공통적인 수단(개방형 표준)
* 구글 로그인, 페이스북 로그인, 깃헙 로그인
```java
OAuth는 Open Authorization, Open Authentication 뜻하는 것으로 애플리케이션(페이스북,구글,트위터)(Service Provider)
의 유저의 비밀번호를 Third party앱에 제공 없이 인증,인가를 할 수 있는 오픈 스탠다드 프로토콜이다. 
OAuth 인증을 통해 애플리케이션 API를 유저대신에 접근할 수 있는 권한을 얻을 수 있다. 
OAuth가 사용되기 전에는 외부 사이트와 인증기반의 데이터를 연동할 때 인증방식의 표준이 없었기 때문에 
기존의 기본인증인 아이디와 비밀번호를 사용하였는데, 이는 보안상 취약한 구조였다. 유저의 비밀번호가 
노출될 가망성이 크기 때문이다. 그렇기 때문에 이 문제를 보안하기 위해 OAuth의 인증은 API를 제공하는 서버에서 진행하고, 
유저가 인증되었다는 Access Token을 발급하였다. 그 발급된 Access token으로 Third party(Consumer)애플리케이션에서는 
Service Provider의 API를 안전하고 쉽게 사용할 수 있게 되었다.
```

## 개념
```java
User	Service Provider에 계정을 가지고 있으면서, Consumer앱을 이용하려는 사용자
Service Provider	OAuth를 사용하는 Open API를 제공하는 서비스 (facebook,google등)
Protected Resource	Service Provider로부터 제공되어지는 API 자원들
Consumer	OAuth 인증을 사용해 Service Provider의 기능을 사용하려는 애플리케이션이나 웹 서비스
Consumer Key	Consumer가 Service Provider에게 자신을 식별하는 데 사용하는키
Consumer Secret	Consumer Key의 소유권을 확립하기 위해 Consumer가 사용하는 Secret
Request Token	Consumer가 Service Provider에게 접근 권한을 인증받기 위해 사용하는 값. 인증이 완료된 후에는 Access Token으로 교환한다.
Access Token	인증 후 Consumer가 Service Provider의 자원에 접근하기 위한 키를 포함한 값
Token Secret	주어진 토큰의 소유권을 인증하기 위해 소비자가 사용하는 Secret
```

## 인증절차
* 유저 브라우저 - 서비스 - OAuth 제공

# OAuth 2.0(Authorization Code Grant)
* 클라이언트가 다른 사용자 대신 특정 리소스에 접근을 요청할 때 사용
```java
OAuth의2는 OAuth의1의 유저의 인증플로우, 전반적인 목적만 공유하고 OAuth의1.0을 새로 작성한것이다. 
OAuth의1.0과 OAuth의2.0의 차이는 앱 애플리케이션, 웹 애플리케이션, 데스크탑 애플리케이션등의 인증방식을 강화하고 
Consumer에 개발 간소화를 중심으로 개발 되었다.


OAuth의1.0 과 OAuth의2.0차이점
아래는 OAuth 1.0 에서 OAuth2.0 차이점은 일단 인증 절차 간소화 됨으로써 개발자들이 구현하기 더쉬워졌고, 
기존에 사용하던 용어도 바뀌면서 Authorizaiton server와 Resource서버의 분리가 명시적으로 되었다. 
또한 다양한 인증 방식을 지원하게 됐다. 아래는 1.0과 2.0의 차이점을 나열한것이다.

인증 절차 간소화
기능의 단순화, 기능과 규모의 확장성 등을 지원하기 위해 만들어 졌다.
기존의 OAuth1.0은 디지털 서명 기반이었지만 OAuth2.0의 암호화는 https에 맡김으로써 
복잡한 디지털 서명에관한 로직을 요구하지 않기때문에 구현 자체가 개발자입장에서 쉬워짐.

용어 변경
Resource Owner : 사용자 (1.0 User해당)
Resource Server : REST API 서버 (1.0 Protected Resource)
Authorization Server : 인증서버 (API 서버와 같을 수도 있음)(1.0 Service Provider)
Client : 써드파티 어플리케이션 (1.0 Service Provider 해당)


Resource Server와 Authorization Server서버의 분리
커다란 서비스는 인증 서버를 분리하거나 다중화 할 수 있어야 함.
Authorization Server의 역할을 명확히 함.


다양한 인증 방식(Grant_type)
Authorization Code Grant
Implicit Grant
Resource Owner Password Credentials Grant
Client Credentials Grant
Device Code Grant
Refresh Token Grant


Authorization Code Grant
일반적인 웹사이트에서 소셜로그인과 같은 인증을 받을 때 가장 많이 쓰는 방식으로 기본적으로 지원하고 있는 방식이다. 
아래는 Authorization Code Grant type 으로 Access Token을 얻어오는 시퀀스 다이어그램이다.

먼저 클라이언트가 Redirect URL을 포함하여 Authorization server 인증 요청을 한다.
AuthorizationServer는 유저에게 로그인창을 제공하여 유저를 인증하게 된다.
AuthorizationServer는 Authorization code를 클라이언트에게 제공해준다.
Client는 코드를 Authorization server에 Access Token을 요청한다.
Authorization 서버는 클라이언트에게 Access token을 발급해준다.
그 Access token을 이용하여 Resource server에 자원을 접근할 수 있게 된다.
그이후에 토큰이 만료된다면 refresh token을 이용하여 토큰을 재발급 받을 수 있다.
```

1. 인증 절차 간소화
    * 기능 단수화 및 규모 확장성 지원을 위해 디지털 서명 기반의 암호화
    * HTTPS의 암호화에 맡김

2. 용어 변경
    * 다양한 인증 방식 제공

3. 다양한 인증방식 제공


## OAuth 장점
* 사용자 입장: 서비스에 ID/PW를 알려주지 않아도 됨
    * 원할 때 액세스 토큰의 권한 취소가 가능
* 서비스 입장
    * 유저의 액세스 토큰만 가지고 있으면 됨
    * 사용자의 ID/PW를 몰라도 허가 받은 API 접근 가능


## 심화
* [굿깃](https://goodgid.github.io/OAuth/)
