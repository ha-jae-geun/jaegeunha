
# 대칭키 암호의 장점
* 암/복호화 속도가 빠르다.
* 키의 크기가 작다.

# 대칭키 암호의 단점
* 키 관리가 어렵다.
  * 잘못된 키 값으로 복호화 하려고 했을 때 PC가 잘못을 인식하지 못한다.
* 키 분배가 힘들다.
 * 통신 상대가 많아질수록 키 관리가 어렵다. – n(n-1)/2개의 키 필요



# 대칭키 알고리즘의 종류
## DES, 3DES
* Data Encryption Standard. 약 70000조개의 키를 가짐. 더 이상 안전하지 않음.


## AES
* Advanced Encryption Standard(2000년). DES의 암호화 강도가 점점 약해지면서 새롭게 개발된 알고리즘. 키 길이 128/192/256비트 지원
  * 하드웨어의 발전으로 256비트 사용


## ARIA
* 국가보안기술연구소(NSRI) 주도로 학계, 국가정보원 등의 암호전문가들이 힘을 모아 개발한 국가 암호화 알고리즘. 키 길이128/192/256비트 지원


## SEED
* 개인정보와 같은 중요한 정보를 보호하기 위해 1999년 2월 한국인터넷진흥원과 국내 암호전문가들이 순수 국내기술로 개발한 128비트 블록 암호 알고리즘.

```java
런데 정부가 원하는 보안 기준에는 보안 알고리즘을 국내에서 제공하는 국산 알고리즘을 사용해야 한다는 조건을 붙인다. 
그 당시에는 SEED, 지금은 ARIA 알고리즘이 그 예인데 이렇게 했던 이유는 
암호화 알고리즘은 국가 기반 자원으로 분류되었기 때문이다. 
2000년대 초에 미국에서는 AES 암호화 알고리즘을 메인 알고리즘으로 사용했지만 미국 이외에서는 사용할 수 없었다
(미국이 오픈을 안시켰기 때문이다). 2000년대 중반부터 AES 알고리즘을 본격적으로 해외에서도 사용할 수 있었다. 
정부가 SEED나 ARIA를 고집하는 이유 중에 하나가 암호화 알고리즘의 국가 기간 자원화 때문도 있다. 
어찌되었던 MS가 만든 해외 어플리케이션인 IE6에는 당연히 SEED 알고리즘 지원이 없었다. 
그것을 해결하기 위해서는 외부의 플러그인 도움이 필요하고 딱 맞게 ActiveX를 이용해서
SEED 알고리즘을 지원할 수 있게 만들었던 것이다. 또한 키보드를 통한 해킹이나 화면을 
조작하는 위법행위로부터 보호받기 위해서는 다양한 보안 모듈이 필요했는데 그 시대에는 
가장 많이 사용하는 환경에서 돌아가게 하기 위해서 ActiveX를 쓰는 것이 당연시 되는 때였다.
즉, ActiveX의 범람은 어쩔 수 없는 시대적 배경이 있었다는 얘기다.

 
```


## LEA
* Lightweight Encryption Algorithm. 빅데이터, 클라우드 등 고속 환경 및 모바일기기 등 경량 환경에서 기밀성을 제공하기 위해 개발된 128비트 블록암호 알고리즘.



# 블록 암호 운영 모드
* ECB 모드
* CBC 모드
* CFB 모드
* OFB 모드
* CTR 모드


# 패딩
* 블록화 하여 암호화하는 블록 암호 특성상 평문의 길이가 블록보다 작을 경우가 생긴다.

## 패딩의 종류
### Zero Padding
* 평문의 길이가 블록 보다 작을 경우 ‘0’ 을 붙이는 방법.


### PKCS7 Padding
* 평문의 길이가 블록 보다 작을 경우 비어 있는 공간의 크기 값을 붙이는 방법.