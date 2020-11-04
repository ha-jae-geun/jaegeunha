# [개인키 분석](https://m.blog.naver.com/PostView.nhn?blogId=miku77&logNo=80175213138&proxyReferer=https:%2F%2Fwww.google.com%2F)

# PKCS#1과 PKCS#7 API의 차이
* PKCS#1은 바이너리 코드 반환
* PKCS#7은 Certificate, Data 반환


# PKCS5
* 공인증서 개인키 포멧은 기관마다 약간씩 차이가 있다.
* 기본적으로 PKCS#8 RSA 개인키를 PKCS#5 스펙에 맞춰 발급한다.
* 위치는 공인인증서가 포함된 디렉토리에 signPri.key 로 저장된다.

# PKCS#7 API
* JAVA의 경우 PKCS #7이 존재하지 않지만 PKCS #5가 PKCS #7의 기능을 함
* SignedData API
* EnvelopedData API
