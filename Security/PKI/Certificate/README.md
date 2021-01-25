# 문제
```java
X.509 인증서(버전 3)의 확장(Extensions) 영역에 포함되지
않는 항목은?
1 인증서 정책(Certificate Policies)
2 기관 키 식별자(Authority Key Identifier)
3 키 용도(Key Usage)
4 서명 알고리즘 식별자(Signature Algorithm Identifier)
 기본 영역
∘ 버전(Version) ∘ 일련번호(Serial Number)

∘ 알고리즘 식별자(Algorithm Identifier) 
∘ 발행자(Issuer) ∘ 유효 개시시간(Validity From) ∘ 유효 만기시간(Validity To) ∘ 주체(Subject) 
주체 공개키 정보(Subject Public-Key Information) ∘ 알고리즘(Algorithm) ∘ 서명(Signature)

 확장 영역
∘ 키와 정책 정보(key and policy information) - 기관키 식별자(authority key identifier)
- 사용자키 식별자(subject key identifier)
- 키 사용(key usage) - 인증서 정책(certificate policies) ∘ 사용자와 발행자 속성(subject and issuer attribute) 
- 사용자 대체 이름(subject alternative name) - 발급자 대체 이름(issuer alternative name) 
∘ 인증 경로 제약조건(certification path constraints) - 기본 제한(basic constraints) 
- 이름 제한(name constraints) - 정책 제한(policy constraints)
4 서명 알고리즘 식별자는 기본 영역에 포함된다. 4
```

# [CRL LDAP(Certificate Revocation List)](https://rsec.kr/?p=386)
* 기존에는 CRL (Cerficate Revocation List) 를 이용하여 인증서의 무결성 (Validation) 여부를 확인하였습니다. CRL이란 인증서 폐기 목록 입니다. 
* 다시말해 현재 사용중인 인증서가 만료된건지 정상인지를 판단 할 수 있는 신뢰 할 수 있는 인증서 폐기목록이라는 말이지요.
* 일반 DB에 비해 빠르다

## [LDAP](https://jabcholove.tistory.com/m/89)
* LDAP은 Lightweight Directory Access Protocol의 약자로, 인터넷 기반의 분산 디렉터리 서비스를 제공하는 공개된 프로토콜입니다. 인터넷 기반과 공개된 프로토콜은 쉽게 이해가 되는데, 분산도 애매하고, 디렉터리 서비스는 뭔지 쉽게 와 닿지 않습니다.

# OCSP
* 실시간으로 조회 가능(DB에 직접 접근)
* OCSP는 RFC2560에서 소개되었으며 목적은 인증서의 상태를 실시간으로 체크하기 위한 프로토콜이라고 보시면 되겠습니다. OCSP는 인증서의 시리얼을 통하여 실시간으로 인증서의 만료여부를 CA 인증서 DB에 직접 요청합니다. 이렇게 OCSP는 실시간으로 인증서의 만료여부를 확인 할 수 있으며 CRL과 같이 불필요한 목록을 모두 받아 볼 필요가 없어 그 속도가 빠릅니다.
* 간단하게 말해 OCSP는 인증서 폐지내역을 화이트리스트로 관린한다고 보시면 되겠습니다. OCSP프로토콜은 인증서의 시리얼을 포함하여 CA기관에 인증서 만료여부를 요청하게 되며



# 3. OCSP Stapling (Online Certificate Status Protocol Stapling)
* 위에서 살펴본 바와 같이 OCSP는 CRL의 단점을 매우 많이 개선하였습니다. 하지만 OCSP도 단점이 있는데, OCSP는 모든 클라이언트들의 인증서의 만료여부 확인 요청을 모두 처리해 주어야 한다는 것이지요.
* 만약 웹서버로 수많은 HTTPS 요청이 발생할 경우, 각 클라이언트에서 OCSP 서버로의 요청도 HTTPS 요청만큼 발생하게 되는 것이죠. 이는 보안상 취약점과 함께 웹사이트가 느려지는 문제가 발생하게 되며, 만약 OCSP가 과부하되어 응답을 하지 못할 경우 false warning 메시지와 함께 유저가 강제로 접속하거나 접속을 끊도록 선택해야 하는 상황이 발생하여 Secure Connection을 보장 해 줄 수 없는 상태가 되는것이죠. 하여 이와 같은 문제를 개선하기 위해서 OCSP Stapling 이라는 기술이 만들어졌습니다.
* 위의 화면과 같이 클라이언트가 직접 OCSP를 통하여 인증서 만료여부를 확인하는 것이 아니라 서비스를 제공하는 웹서버에서 중간에게 OCSP를 통한 인증서 만료여부를 중계하는 것이죠. 실제 인증서 만료여부는 중간자인 웹서버가 OCSP서버와 확인하도록 되어 있고, 클라이언트는 웹서버 접속시 웹서버를 통하여 인증서 만료여부까지 확인 하는 것이죠.
* 따라서 OCSP 서버 (OCSP Responder) 는 쿼리수가 현저하게 적어질 것이며 자원을 보호 할 수 있는 것이죠.


# [CA](http://www.ktword.co.kr/abbr_view.php?m_temp1=2123)
