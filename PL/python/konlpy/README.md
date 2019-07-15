# 설치
* https://www.lfd.uci.edu/~gohlke/pythonlibs/#jpype
  1. 에서 JPype1-0.6.3-cp36-cp36m-win_amd64.whl 다운
  2. 아나콘다에 복사
  3. pip install JPype1-0.6.3-cp36-cp36m-win_amd64.whl
  4. pip install konlpy


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
