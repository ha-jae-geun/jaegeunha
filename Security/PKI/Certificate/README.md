# CRL LDAP(Certificate Revocation List)
* 기존에는 CRL (Cerficate Revocation List) 를 이용하여 인증서의 무결성 (Validation) 여부를 확인하였습니다. CRL이란 인증서 폐기 목록 입니다. 
* 다시말해 현재 사용중인 인증서가 만료된건지 정상인지를 판단 할 수 있는 신뢰 할 수 있는 인증서 폐기목록이라는 말이지요.
* 일반 DB에 비해 빠르다

# OCSP
* 실시간으로 조회 가능(DB에 직접 접근)

