# [개인키 분석](https://m.blog.naver.com/PostView.nhn?blogId=miku77&logNo=80175213138&proxyReferer=https:%2F%2Fwww.google.com%2F)

# PKCS#1과 PKCS#7 API의 차이
* PKCS#1은 바이너리 코드 반환
* PKCS#7은 Certificate, Data 반환


# PKCS5
* 공인증서 개인키 포멧은 기관마다 약간씩 차이가 있다.
* 기본적으로 PKCS#8 RSA 개인키를 PKCS#5 스펙에 맞춰 발급한다.
* 위치는 공인인증서가 포함된 디렉토리에 signPri.key 로 저장된다.
* DES, Triple DES 등 64Bit (8Byte) 블록 암호화 기반 알고리즘에 잘 적용된 표준.

## PKCS7 등장 이유
* 128Bit (16Byte) 이상의 블록 암호화 알고리즘의 발표로 표준 또한 확장이 필요하면서 PKCS #7 이 등장


# PKCS7
* 128Bit (16Byte) 이상의 블록 암호화 알고리즘의 발표로 표준 또한 확장이 필요하면서 PKCS #7 이 등장


## PKCS#7 API
* JAVA의 경우 PKCS #7이 존재하지 않지만 PKCS #5가 PKCS #7의 기능을 함
* SignedData API
* EnvelopedData API


# PKCS8
* 기본적으로 PKCS#8 RSA 개인키를 PKCS#5 스펙에 맞춰 발급한다.
* Private Key 는 PKCS #8 의 형태의 Syntax를 적용 해야(.key 확장자) 하고,PKCS #5 표준을 적용하여 Private Key를 패스워드 기반으로 암호화.
  * (파일 형태로 보관된 Private Key의 안전한 보호를 위해 암호화를 통해 이중 잠금 진행) 
