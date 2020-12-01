# [개인키 분석](https://m.blog.naver.com/PostView.nhn?blogId=miku77&logNo=80175213138&proxyReferer=https:%2F%2Fwww.google.com%2F)

# PKCS
* 인증서나 개인키를 인코딩하는 방식은 PEM과 DER 방식이 있습니다.
* PEM :  header + base64 encoding + foot
* DER :  asn.1으로 볼 수 있으며 바이너리 상태

# PKCS#1과 PKCS#7 API의 차이
* PKCS#1은 바이너리 코드 반환
* PKCS#7은 Certificate, Data 반환

# [PKCS#1, PCKS#8, PKCS#5 차이](https://tocgic.tistory.com/m/183)
* PKCS#1 : RSA 개인키를 PEM 형태로 인코딩한 상태( 비밀번호로 암호화 되지 않은 상태)
* PKCS#8 : RSA 개인키를 PKCS#8 저장 포맷(PEM)에 따라 비밀번호로 암호화가 된 상태
* PKCS#5 : RSA개인키를 대칭키로 암호화된 상태(예, triple DES)
```java
PKCS#8을 PKCS#5로 변경하거나 그 반대로 변경하는 경우 바로 변경이 되지 않음
PKCS#8  ==>  PKCS#1 ==> PKCS#5 순서로 변경해야 함. 그 반대도 동일함.
```

# PKCS5
* 공인증서 개인키 포멧은 기관마다 약간씩 차이가 있다.
* 기본적으로 PKCS#8 RSA 개인키를 PKCS#5 스펙에 맞춰 발급한다.
* 위치는 공인인증서가 포함된 디렉토리에 signPri.key 로 저장된다.
* DES, Triple DES 등 64Bit (8Byte) 블록 암호화 기반 알고리즘에 잘 적용된 표준.

## PKCS7 등장 이유
* 128Bit (16Byte) 이상의 블록 암호화 알고리즘의 발표로 표준 또한 확장이 필요하면서 PKCS #7 이 등장

## [VID 인증](https://m.blog.naver.com/PostView.nhn?blogId=miku77&logNo=80175982388&proxyReferer=https:%2F%2Fwww.google.com%2F)

## [개인키 복호화](https://m.blog.naver.com/PostView.nhn?blogId=miku77&logNo=80175213138&proxyReferer=https:%2F%2Fwww.google.com%2F)

# PKCS7
* 128Bit (16Byte) 이상의 블록 암호화 알고리즘의 발표로 표준 또한 확장이 필요하면서 PKCS #7 이 등장


## PKCS#7 API
* JAVA의 경우 PKCS #7이 존재하지 않지만 PKCS #5가 PKCS #7의 기능을 함
* SignedData API
* EnvelopedData API


# PKCS8
* 기본적으로 PKCS#8 RSA 개인키를 PKCS#5 스펙에 맞춰 발급한다.
 * 암호화된 개인키를 복호화 하기 위해서 키 유도함수와 필수 파라미터가 명시되어 있다.
* Private Key 는 PKCS #8 의 형태의 Syntax를 적용 해야(.key 확장자) 하고,PKCS #5 표준을 적용하여 Private Key를 패스워드 기반으로 암호화.
  * (파일 형태로 보관된 Private Key의 안전한 보호를 위해 암호화를 통해 이중 잠금 진행) 
