# [FIDO](https://pongdang-pooh.tistory.com/7)
1. UAF protocol (Universal Authentication Framework ) 
 * ╶ 지문, 음성, 얼굴 인식 등의 사용자 고유 생체 정보를 인식하여 인증하는 모바일 중심의 인증 방식
   ╶ 스마트폰 등 사용자 단말기의 생체 정보를 이용하여 사용자를 인증한 후 비 대칭키 쌍(개인키, 공개키)을 생성하고 서비스 제공 서버에 공개키를 등록하여 원격 인증 수행
2. U2F protocol  (Universal 2nd Factor) – ID/PWD + USB/NFC 등
 * ╶ 아이디, 비밀번호 방식으로 1차 인증 후 1회용 보안키가 저장된 USB 또는 스마트카드를 이용하여 2차 인증하는 PC 중심의 인증 방식

## FIDO 역사
* FIDO Alliance
* FIDO 1.0 
* FIDO 2.0 – 브라우저 지원
 * 결국엔 PKI
 
## 문제
* 부인방지 기능은?

# FIDO 구조
* Registration
* Authentication
* Transaction Confirmation
* Deregistration
   * 사용자 단말에 저장된 개인키를 삭제하여 해당 서버에 대한 FIDO 등록을 해지

## FIDO User Device
1. App
2. FIDO Client
   * FIDO 서버의 정책에 따라 인증자를 필터링 하고 ASM과 RP 클라이언트 간의 중계 역할
3. ASM
   * FIDO 클라이언트의 요청을 인증자로 전달하고 인증자에서 생성된 응답 값을 FIDO 클라이언트로 전달하는 중계역할을 수행
4. FIDO AUthentication
5. Secure Storage

## FIDO Server
1. Seb Server
2. FIDO SERVER
3. FIDO Metadata Service

## [FIDO Line](https://engineering.linecorp.com/ko/blog/fido-at-line/)


# 지문 인식
* 우리나라는 신분증 만들 때 사용
* 손가락을 떼어갈 수 있음
  * 2005년도 벤츠 도난
  * 젤라틴으로 복사
* 겹치는 경우가 생김

# 얼굴 인식
* 쌍둥이가 뚫을 수 있음

# 혈관 인식

# 홍채 인식
* 매우 안정적
  * 눈을 적출해도 홍채 색깔이 달라짐
  * 쌍둥이도 안통함
* 겹칠 확률이 10억분의 1

## 망막 인식

# 필적 인식
