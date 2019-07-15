# 설치
* KONLPy 라이브러리는 자바 JDK 1.7 이상인 자바가 설치되어 있어야 한다.
* KONLPy 라이브러리는 운영체제에 맞는 버전을 사이트에서 다운 받아 설치한다.
* https://www.lfd.uci.edu/~gohlke/pythonlibs/#jpype
  1. 에서 JPype1-0.6.3-cp36-cp36m-win_amd64.whl 다운
  2. 아나콘다에 복사
  3. pip install JPype1-0.6.3-cp36-cp36m-win_amd64.whl
  4. pip install konlpy


# 라이브러리 설명
* KONLPy 라이브러리의 konlpy는 코엔엘파이라고 읽는다.
* KONLPy 라이브러리는 한국어 정보처리를 위한 파이썬 라이브러리이다.
* KONLP 라이브러리의 내용은 웹 페이지에서 확인 할 수 있다.

# 클래스
* KONLPy 라이브러리에서는 형태소 분석기인 Okt 클래스, Kkma 클래스, Hannanum 클래스,
* Komoran 클래스, Mecab 클래스를 지원하며 Mecab 클래스는 윈도우에서는 사용할 수가 없다.
* KONLP 라이브러리의 형태소 분석기에 대한 설명 웹 페이지에서 확인 할 수 있다.


# 국립국어원
* 데이터베이스 자료 - 말뭉치 - 토지: https://ithub.korean.go.kr/user/total/database/corpusView.do
* pip install wordcloud

# 형태소 분석
```python
from konlpy.tag import Okt, Kkma, Hannanum, Komoran
okt = Okt( )
oktlist = okt.pos("아버지가방에들어가신다.")
print("Okt 클래스의 결과")
print(oktlist)
# kkma = Kkma( )
# kkmalist = kkma.pos("아버지가방에들어가신다.")
# print("Kkma 클래스의 결과")
# print(kkmalist)
# hannanum = Hannanum( )
# hannanumlist = hannanum.pos("아버지가방에들어가신다.")
# print("Hannanum 클래스의 결과")
# print(hannanumlist)
# komoran = Komoran( )
# komoranlist = komoran.pos("아버지가방에들어가신다.")
# print("Komoran 클래스의 결과")
# print(komoranlist)
```


