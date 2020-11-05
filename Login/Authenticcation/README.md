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


# 인증 동향
```java
ID/PASSWORD  - HASH
Request/Response –지정질문, OTP, 공유된 대칭키
OTP (One Time Password) – time base or challenge/response base
PKI – 사설인증서 , 공인인증서

기기기반 패턴/PIN – 안드로이드 잠금화면
FIDO - 생체 인증
3rd Party 기반 인증 – 휴대폰, 계좌번호, 신용카드, 카카오인증

무자각인증 – AI, BigData 기반
(얼굴, 음성, 걸음걸이, 키스트로크/마우스 다이나믹스, 문체 등) 

```
