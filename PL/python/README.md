Reference: [Life Coding](https://opentutorials.org/course/1750/9689)
  [Pycharm](https://www.jetbrains.com/pycharm/)
  [Ruby](https://www.jetbrains.com/ruby)
  [python common mistake](http://hamait.tistory.com/851?category=79136)

# 머신러닝, 딥러닝 차이
* 머신러닝: 기계가 자발적으로 판단하는 것이 아니다
* 머신러닝은 AI를 달성하기 위한 방법
  * Supervised: * 인간이 준 레이블을 기준으로 학습
  * Unsupervised: * 인간은 데이터를 분류하지 않는다. 기계로 하여금 엄청난 프로세싱 파워와 데이터를 토대로 학습시키는 것임
* 딥러닝: 머신러닝을 달성하기 위한 방법
  * 뇌처럼 작용하는 알고리즘이 있는 Neural Network를 사용한다는 차이; 
* AI를 위한 가장 유명한 프레임워크: 텐서플로우 혹은 BrainJS

## 범위
* 딥러닝 < 머신러닝 < AI

## 머신러닝 종류
* Supervised: 지도 학습(Supervised Learning)은 데이터에 대한 레이블(Label)-명시적인 정답-이 주어진 상태에서 컴퓨터를 학습시키는 방법이다.
  * 범주형, 연속형
  * 인간이 준 레이블을 기준으로 학습
* Unsupervised: 즉, (데이터(data)) 형태로 학습을 진행하는 방법이다. 예를 들어서, 아래와 데이터가 무작위로 분포되어 있을때, 이 데이터를 비슷한 특성을 가진 세가지 부류로 묶는 클러스터링(Clustering) 알고리즘이 있다.  데이터의 숨겨진(Hidden) 특징(Feature)이나 구조를 발견하는데 사용된다.
  * 군집화
  * 인간은 데이터를 분류하지 않는다. 기계로 하여금 엄청난 프로세싱 파워와 데이터를 토대로 학습시키는 것임
* 강화학습: 앞서 살펴본 알고리즘들이 데이터(data)가 주어진 정적인 상태(static environment)에서 학습을 진행하였다면, 강화 학습(Reinforcement Learning)은 에이전트가 주어진 환경(state)에 대해 어떤 행동(action)을 취하고 이로부터 어떤 보상(reward)을 얻으면서 학습을 진행한다. 이때, 에이전트는 보상(reward)을 최대화(maximize)하도록 학습이 진행된다. 즉, 강화학습은 일종의 동적인 상태(dynamic environment)에서 데이터를 수집하는 과정까지 포함되어 있는 알고리즘이다.
# 빅데이터
* 연속형 변수(X): 연속형 반응변수(Y): 선형회귀보델
* 연속형 변수(X): 범주변수(Y): 로지스틱 모형
* 범주 변수(X): 연속형 반응변수(Y): 분산분석
* 범주 변수(X):  범주변수(Y): 분할표 분석(하나의 X) 로지스틱 모형 또는 로그 선형 모형(여러개의 Xs)
* 연속형 변수(X) + 범주 변수(X): 연속형 반응변수(Y): 공분산분석 선형회귀(가변수) 모형
* 연속형 변수(X) + 범주 변수(X): 연속형 범주변수(Y): 로지스틱 모형

## 정확도
* 의사결정: 해석 <> 신경망: 정확성



# 귀무가설, 대립가설
* 예를 들어 회귀분석의 경우 귀무가설은 "설명변수(x)는 반응변수(y)에 영향을 주지 않는다." 이고 대립가설은 "설명변수(x)는 반응변수(y)에 영향을 준다." 이다. 그래서 편하게 기억하자면,  귀무가설은 차이가 없다, 영향력이 없다, 연관성이 없다, 효과가 없다. 대립가설은 차이가 있다, 영향력이 있다, 연관성이 있다, 효과가 있다. 라고 기억하는 게 편하다.
* 대립가설(Alternative Hypothesis)은 통계학에서 귀무가설에 대립하여 '모집단에서 독립변수와 결과변수 간에 관련이 있다'라고 기술하는 명제를 말한다. 연구가설 혹은 유지가설이라고도 하며 어떤 가능성에 대해 확률적인 가설검정을 할 때 귀무가설과 함께 사용된다. 이 가설은 귀무가설처럼 검정을 직접 수행하기는 불가능하며 귀무가설을 기각함으로써 받아들여지는 반증의 과정을 거쳐 받아들여질 수 있다. 대립가설은 양측대립가설과 단측대립가설이 있다.

# 파이썬 
- 클래스 방식은 컴파일러 -> pyc파일 -> 인터프리터; 
- 함수: 인터프리터 방식

# 빅데이터 과정
## 파이썬 수집 -> 기본 파이썬
- 웹 크롤링 -> 스크래핑
- 데이터 세트

## 파이썬 분석
- 판다스

## 머신러닝
* knn 알고리즘, SVM, 의사결정트리, 나이브베이즈, 신경망 알고리즘
* 크로스 벨리데이스, 그리드 서치, 형태소 분석

## 딥러닝
* 신경망: 텐서 플로우, 케라스


# 파이참
## 세팅
* 모듈 확인: Project Interpreter 혹은 conda prompt 에서 conda list 혹은 conda search request

## 파이참 단축키
* Ctrl+ Q, F4

# 옵션
* 옵션을 객체로 사용 가능
``` python
print(sys.stdout.encoding)

```

# 모듈
## requests 모듈
* 아나콘다 프롬프트에서 conda install requests


## beautifulsoup
* BeautifulSoup4 패키지는 lxml 패키지와 html5lib 패키지가 설치된 경우에 더 잘 작동하므로 설치가 되어있지 않을 경우에 설치하는 것을 권장한다.

### BeautifulSOup 분석기 종류
* 가. Python’s html.parser : 'html.parser'
* 나. lxml’s HTML parser : 'lxml'
* 다. lxml’s XML parser : 'lxml-xml', 'xml'
* 라. html5lib : 'html5lib'

# 객체지향 프로그래밍 형태
* 클래스 기반 | 프로토타입 기반
* 클래스 |  객체
* 인스턴스 |  객체
* 부모 클래스 |  프로토타입
* 상속 |  복제
* 클래스 메소드 |   메소드
* 인스턴스 메소드 |  메소드

# return
* return 코드영역으로 반환, pass 함수 지정하면 최소 1자리 이상

# hash
* 해시값은 컴퓨터에서 부여한 주소의 값이라고 생각하면 된다.

# id
* 파이썬에서 부여한 주소의 값이라고 생각하면 된다; id 사용 권장

# map
* map 함수를 사용하지 않을 때는 append 메소드로 하나씩 x 인자를 함수에 대응 후에 결과값을 추가한다.
* map 함수는 쌍을 지어주므로 x 인자가 5개이면 수행 결과의 인자도 5개가 된다. 결과값은 [1, 4, 9, 16, 25] 이다.

```python
a=[1, 2, 3, 4, 5]
print(list(map(lambda x: x*x, a)))
```

# 파이썬 설치
 * 아직까지 3.6버전까지 머신러닝 지원
 * Windows x86-64 web-based installer // 나중에 웹에서 다운받아야 함
 * Windows x86-64 executable installer
 * Windows x86-64 embeddable zip file // 나중에 환경변수 지정 필요
- Add Python 3.6 to Path: 환경 변수 자동 설정해줌
- Advanced Options: 전부 체크

# 정확도와 속도 차이
## 논리 연산자
- 자바에서는 속도 때문에 &&   ||  등 2개 짜리를 권장한다.
- &&는 앞이 거짓이면 뒤 검증 안함, || 도 앞이 참이면 뒤 검증 안함.

## switch 문
* 비순차적 문장
 * 머신러닝 같이 데이터 검출을 목표로 할 때는 if 문을 쓰는 것이 맞다. 순차적으로 모두 확인해야 한다.
 * :(영역 변경) 뒤에 {} 생략 가능; 파이썬 방식

# 파이썬과 자바
## void
- -자바와 다르게 파이썬은 함수를 제외하고 모든 메소드는 기본적으로 void 형이다. return을 쓰는 함수, void를 쓰는 메소드 2가지 사용한다.

# 주석
- #
- """ """

# _
## _식별자
- 선행 싱글 언더스코어는 한 모듈 내부에서만 사용하는 private 접근 제한자를 선언할 때 사용하는 규약이다. 파이썬에서는 실질적인 private 접근 제한자을 지원하고 있지는 않기 때문에 private 접근 제한자를 완전히 강제할 수는 없지만 직접 가져다 쓰거나 호출을 할 경우엔 사용이 가능하다. from 모듈 import * 절로 임포트를 하면은 싱글 언더스코어로 시작하는 것들은 모두 임포트에서 무시된다.

# 식별자
- 후행 싱글 언더스코어는 파이썬의 키워드와의 충돌을 피하기 위해 사용하는 규약이다. 

# __식별자
- 선행 더블 언더스코어는 규약이라기보다는 하나의 문법적인 요소이다. 선행 더블 언더스코어는 클래스 속성명을 맹글링하여 클래스 간 속성명의 충돌을 방지하기 위한 용도로 사용된다. 맹글링은 컴파일러나 인터프리터가 객체와 함수명을 그대로 사용하지 않고 일정한 규칙에 의해 변형시키는 것을 말한다. 선행 더블 언더스코어로 지정된 속성명은 맹글링이 되기 때문에 일반적인 접근 방식으로는 접근이 되지 않으므로 선행 더블 언더스코어를 사용해 private 접근 제한자처럼 강제하는 경우가 있는데 이런 방식으로 사용하는 것을 권장하지 않는다.  ④ 

# __식별자__
- 선행후행 더블 언더스코어는 특별한 객체나 특별한 메소드에 사용되는 규약이다. 선행후행 더블 언더스코어로 선언된 ˍˍinitˍˍ 메소드와 같은 특별 메소드는 특정한 문법적 기능을 제공하거나 특정한 일을 수행한다. 

# 파이썬 논리연산자
- (a==10) & (b==5)  // ()는 강제 형변환; 잘 사용 안함
- and, or, not 을 논리 연산자로 쓰고  &는 보통 비트 연산자로 사용한다.


# 객체
- 공간에 이름을 부여한다: 객체 / 네임 스페이스
- 사물에 대한 가리킴 -> 공간을 통해서 함수를 수행한다.
- 메소드: 공간을 통해서 함수를 실행시키는 방법.

## 일급 객체
- 일급 객체의 특징은 다음과 같다. 
  - ① 변수나 자료 구조 안에 담을 수 있다. 
  - ② 파라미터로 전달 할 수 있다. 
  - ③ 반환값으로 사용할 수 있다. 
  - ④ 할당에 사용된 이름과 관계없이 고유한 구별이 가능하다. 
  - ⑤ 동적으로 프로퍼티 할당이 가능하다. 

# strength(Guido van Rossum)
* simple syntax
* have a lot of libraries
* dynamic typing = type 
* can access to object's member whenever i want
* slower than c, c++(make native binary file)
* git can operate fast
* have garbage collector and support unicode


# 파이썬 자료형
 * 원시 자료형: 직접 접근
 * 수치 타입
 * 정수타입: byte, short, int, long, char(자판기; 쓰면 아스키코드로 바뀜)
 * 기본형은 int 형
 * 부동 소수점: float, double
 * 기본이 double이라 float형은 f 붙여 주어야 함.
 * 불리언 타입
 * 원시 자료형은 크기가 작고 고정적이기 때문에 메모리의 스택에 저장이 된다.
 * 자바에서는 원시 타입을 제외하고는 다 참조다. 하지만 파이썬, R은 다 참조다.(원시타입이 존재하지 않는다.)
 * 2진수, 8진수, 10진수(올림형), 16진수로 표현 가능하고, 정수형 중 음수는 보수를 사용한다.
 *   -  3.6버전에 신경망 알고리즘 등 대다수 존재, 3.7부터는 _ 공백 문자 등이 등장했지만 알고리즘 지원 안함

## 자료형 차이
- 리스트: 분석의 토대, 튜플: 저장의 토대, 딕셔너리: 외부 저장의 토대

## 레퍼런스
- 레퍼런스는 파이썬 인터프리터가 관리하는 식별자이다. 
- ✍ print(a is b) ⎼is 키워드로 a 객체와 b 객체의 레퍼런스를 확인하며 레퍼런스가 동일하지 않으므로 False를 호출하고 출력한다.  ⎼

## 접근방법
* 숫자형: 직접접근, 변경 불가능, 리터럴 저장 모델
* 문자열: 시퀀스 접근, 변경 불가능, 리터럴 저장 모델
* 리스트: 시퀀스, 변경 가능, 컨테이너 저장 모델; []
  * a=[]; 빈값; a=[ ]; 공백 한개 들어가있는 리스트
* 튜플: 시퀀스, 변경 불가능, 컨테이너 저장 모델; ()
* 딕셔너리: 매핑, 변경 가능, 컨테이너 저장 모델; {}
  * 인덱스가 존재하지 않아서 키 값으로만 호출 가능
* 리스트랑 딕셔너리만 접근 가능

## 시퀀스 접근
- 시퀀스 접근은 다른 자료를 포함하는 인덱스를 갖는 집합적 자료형으로 문자열과 리스트 그리고 튜플이 있다. 
- 시퀀스 접근을 하는 자료형을 시퀀스 자료형이라고 하며 시퀀스 자료형은 저장된 각 요소를  인덱스를 이용하여 참조가 가능한 자료형이며 문자열, 리스트, 튜플이 있고 대표적인 자료형은 문자열이다.
- 저장된 각 요소를 정수 인덱스를 이용하여 참조가 가능한 자료형으로 공통적인 기능을 가지며 주요 공통적인 기능은 다음과 같다. ① 인덱싱 기능 ② 슬라이싱 기능 ③ 연결 기능 ④ 반복 기능 ⑤ 멤버십 테스트 기능

## 슬라이싱
- 값을 변경할 수 없는 문자열과 튜플은 슬라이싱을 이용하여 값을 변경한 것이 아니라 새로운 객체 생성 필요
- 시작 인덱스는 포함하고 끝나는 인덱스 포함하지 않는다.
- print(a[0:5])
- 문자열의 슬라이싱은 [ ](브래킷) 안에 인덱스 번호와 :(콜론)을 입력하여 인덱스를 기준으로 문자열의 요소를 자른다. 

## 리스트
- 파이썬 2는 리스트반환을 기본으로 설정했지만, 파이썬 3은 리스트 반환을 하고자 한다면 반드시 list 함수를 사용해야 한다.

# 문자
- 문자나 문자열은 같이 취급한다.

## 긴 문자열
```python
html = """

"""
```

# ''
- 파이썬은 ''가 기본이다.

## \'
- \(역슬래시)를 사용하면은 '(싱글 쿼터)와 "(더블 쿼터)를 문자열에 포함시킬 수 있다. \(역슬래시) 기호는 다음 라인이 현재 라인의 뒤에 이어짐을 나타낸다.   

## +
- print('안'+''+'녕'+' '+'여러분') ⎼+(플러스) 기호에 의해서 문자열을 연결해서 출력한다. ⎼빈 문자열 ''은 아무 값도 할당받지 않은 상태이다. ⎼공백 문자열은 ' '은 한 칸 공백을 의미한다. 


## 튜플
- 넘파이, 사이파이(그래프의 효율성 높여줌); 선형대수

### ,
- ,가 붙으면 튜플이라고 보면 된다.

## 딕셔너리
- 무작위 선택 -> 스위치 문을 구현할 수 있다.
* 변경 불가능하기 때문에 변경 가능한 리스트를 넣으면 오류가 난다.

### 아이템
- 키와 값이 있는 딕셔너리

### 딕셔너리 언패킹 
```python
item방식
if total > 180:

    for sub, val in subject.items():
        if val < 40:
            print('{}점이지만 {}과목이 {}점이므로 과락입니다.'.format(total, sub, val))
            a = 0
        else:
            a = 1

    if(a == 1):
        print('{}점으로 합격입니다.'.format(total))
else:
    print('{}점으로 불합격입니다.'.format(total))
```

### 딕셔너리 밀어넣기
```python
a = {}
a["kor"] = int(input("국어 점수: "))
a["math"] = int(input("수학 점수: "))
a["eng"] = int(input("영어 점수: "))
a["total"] = a.get("kor") + a.get("math") + a.get("eng")

if(a.get("total") > 180):
  for test in a:
    if a.get(test) < 40:
      print("과목 중 하나가 {} 이므로 탈락".format(a.get(test)))

else:
 print("총점이 {} 여서 탈락".format(a.get("total")))

```

## 세트
* 딕셔너리처럼 빈 함수가 없다.
* 단일 요소만 가능하다
* 변경 가능한 요소를 사용한다.


## null
* 존재하지 않는 값 and 인식하지 못하는 값

# 객체지향 프로그래밍의 형태
- 클래스 기반: 

# Development Environment
* window: python, Mac¤ýUbuntu: python3
* install python -> PC properties -> System settings -> system variable -> edit path -> ;path -> C:\Python34\ -> cmd -> python path


# 네임스페이스
* 빌트인: 내장객체
* 전역: 글로벌
* 지역: 로컬

# 클래스
- 메타 클래스(자바의 오브젝트 클래스), 일반 클래스, 인스턴스

## 클래서 함수 선언
```python
class Song
  b = 1
a = Song()
```

# 복사
* 얕은복사; 레퍼런스까지 복사; 
* 깊은복사: 완전히 다른 레퍼런스 

# 데이터를 저장시키는 방법
- 생성자: CPU와 관계를 가진다; 메모리에 저장하는 용도
- 맴버변수: CPU와 전혀 관계 없다; 데이터베이스 저장 용도
  * 모듈: set/get


# 모듈
- py파일

## import
1. import A.B.C.mod
2. from A.B.C import mod;  패키지로 되어있는 것은 from 키워드 

## 써드파티

## 표준 모듈

## 사용자 모듈


## __init__.py
* 서로 다른 경로에 있는 것을 사용할 때 __init__.py 파일이 있어야 한다.
* 디렉토리가 파이썬의 패키지로 인정받으려면 ˍ ˍ initˍ ˍ .py 파일을 경로에 갖고 있어야 한다.
* ˍ ˍ initˍ ˍ .py 파일이 없다면 파이썬은 해당 디렉터리의 모듈을 가져오지 못한다.
* 파이썬 3.3부터는 ˍ ˍ initˍ ˍ .py 파일이 없어도 패키지로 인식하지만 파이썬의 하위 버전에 대한 호환성을 위해서라도 유지하는 것이 필요하다.


# 파일

## b모드
- 인코딩이 지원이 안된다.

## open
* f = open('test.txt', 'w'); encoding을 설정 안하면 none이 default 설정값이 되어 OS의 default 값을 설정하게 된다.

## 딕셔너리
```python
s = {'가':1, '나':2}
f.write(''.join(s))
  # 키 값만 들어간다.
f.close
```


## 리스트
* 리스트의 내용을 파일에 쓰려고 하면은 write 메소드는 리스트를 지원하지 않으므로 오류가 발생한다.
* 리스트의 내용을 파일에 쓰기 작업을 하기 위해서는 join 메소드와 같이 사용해야 한다.
``` python
s = ['1234', '4567', '89']
f = open('test.txt', 'w', encoding='utf-8')
f.write(''.join(s))
f.close( )
```

## write
* ⎼ f 객체의 write 메소드의 인자인 문자열 s의 내용은 a 모드에 의해서 파일의 뒷부분에 추가된다.

## BOM 제거
* utf-8로 인코딩된 파일의 BOM을 제거하기 위해서는 open 함수의 encoding 옵션의 옵션값인
* utf-8에 -sig을 덧붙여 지정하며 sig는 signature의 약자이다

```python
f = open('test.txt', encoding='utf-8-sig')
s = f.read( )
f.close( )
print(s)
```

# 특별 메소드
## __str__
```python
class ArgumentClass:
  def ˍˍinitˍˍ(self, obj):
    self.obj=obj
  def ˍˍstrˍˍ(self):
    return str(self.obj)
call = ArgumentClass(10)
print(call)
```
* print하려고 하는데 print할 게 없다면 __str__이나 __repr__로 이동하여 return 

## 숫자 연산자 메소드
```python
class AddOperator:
  def ˍˍinitˍˍ(self, obj):
    self.obj = obj
  def ˍˍstrˍˍ(self):
    return str(self.obj)
  def ˍˍaddˍˍ(self, other):
    return self.obj+other
call1 = AddOperator(10)
call2 = call1+10
print(call2)
```
* 더하면 자동으로 add 함수가 호출되는데 안에있는 매개변수의 수가 같아야 실행됨.


# 데코레이터
```python
class MethodClass:
  @staticmethod
  def call(x, y):
    print(x, y)
f = MethodClass( )
f.call(5, 6)
```
- call 메소드는 @staticmethod 데코레이터로 선언된 메소드이므로 스태틱 메소드가 되고 스태틱 메소드는 첫 번째 인자에 self 인자를 선언하지 않아도 된다.

## 클래스 메소드
* 클래스 메소드는 첫번째 인자로 클래스 객체를 자동으로 받는 메소드이다.
* 클래스 메소드는 해당 클래스의 생성자를 할당한 인스턴스를 통해서도 호출이 가능하다.
* 클래스 메소드는 해당 클래스로 생성된 객체마다 생성이 되지 않는다.
* 생성된 모든 객체가 동일한 메소드로 접근을 하게 되면은 클래스 메소드는 첫번쨰 인자로 해당 클래스 인자를 받게된다.

```python
class MethodClass:
  @classmethod
  def call(classobject, x, y):
   print(classobject, x, y)
MethodClass.call(3, 4)
f = MethodClass( )
f.call(5, 6)
```

# 클래스
* 프로그램에서 클래스를 적용하면 중복성을 배제하는 등의 다양한 효과를 얻을 수 있다.
* 파이썬의 클래스는 하나의 틀이다.
* 틀에 의해서 인스턴스를 생성하며 인스턴스 별로 독립적인 성격을 갖는다.
* 클래스의 인스턴스는 동적 인스턴스와 정적 인스턴스로 구성되어 진다.
* 파이썬의 모든 클래스는 메타 클래스에 의해 만들어진다.

# 입출력
* 출력: 1. 단순 출력 2. 예외 출력

## 표준
* 현재의 시스템에서 입력의 시작이 되는 장비 또는 파일


# 다형성
* 자료형 선언이 없다는 점에서 파이썬에서는 다형성을 적용하기가 더욱 용이하다.
* 실시간으로 객체의 자료형이 결정되므로 단 하나의 메소드에 의해 처리될 수 있는 객체의 종류에 제한이 없다.
* 다양한 객체들에게 유사한 작업을 수행시킬 수 있으며 소스 코드의 가독성을 높혀준다.
* 다른 언어보다 프로그램 작성시 코드의 양이 더욱 줄어든다.

# 데이터

# 정형 데이터
* 정형 데이터는 정형화된 자료로 고정된 필드에 저장되는 자료를 의미한다. 정형 데이터는 관계형 데이터베이스가 대표적이다. 데이터베이스에 미리 생성되어 있는 테이블은 고정된 필드들로 구성이 되는데 이렇게 일정한 형식을 갖추고 저장되는 자료가 정형 데이터이다. 정형 데이터는 솔루션을 이용하여 비교적 쉽게 보관하고 분석하여 처리 작업을 진행할 수 있다. 
* 독립적으로 연산

# 반정형 데이터
* 반정형 데이터는 고정된 필드로 저장되어 있지는 않지만 XML이나 HTML 같이 메타 데이터나 MS 워드 등으로 작성한 자료 등을 포함하는 자료를 의미한다. 소셜 네트워크 서비스 사용자가 생성하는 자료들이 반정형 데이터에 해당한다.
* xml

# 비정형 데이터
* 비정형 데이터는 고정된 필드에 저장되어 있지 않은 자료를 의미한다. 비정형 데이터는 텍스트 분석이 가능한 텍스트 문서, 유튜브에서 업로드하는 동영상 자료, 메신저로 주고 받은 대화 내용, 스마트폰에서 기록되는 위치 정보 등이 비정형 데이터이다.
* 계산을 독립적으로 못한다.

# 데이터 수집방법
 ## (1) ETL
* ETL(Extraction Transformation Loading)은 자료의 추출, 변환, 로드를 의미한다. ETL은 다양한 소스 자료를 취합해 자료를 추출하고 하나의 공통된 형식으로 변환하여 자료를 적재하는 과정을 지원한다. 

## (2) 크롤링
* 크롤링은 웹 사이트를 정기적으로 돌며 정보를 추출하는 기술이다. 크롤링하는 프로그램을 크롤러 또는 스파이더라고 한다. 
* 웹에서 자료를 다운받는다.

## (3) 스크레이핑
* 스크레이핑은 웹 사이트에 있는 특정 정보를 추출하는 기술이다. 스크레이핑은 웹에서 자료를 추출 하는 것 뿐만 아니라 구조도 분석한다. 스크레이핑은 로그인해서 필요한 웹 페이지에 접근 하는 기술이 필요하다. 
* 웹소스를 분석해서 특정 정보를 추출한다.

## 4) 로그 수집기
* 로그 수집기는 내부에 있는 서버의 로그를 수집하는데 웹 로그, DB의 로그 데이터 등을 수집한다. 

## (5) 응용프로그램
* RSS 리더와 오픈 API에서 자료를 수집한다. 

## (6) 센서
* 각종 센서로 자료를 수집한다



# 라이브러리
## 표준 라이브러리
* https://docs.python.org/3.6/library/index.html

# pip
* 파이썬에서 제공하는 패키지 관리도구


# http; hypertext transfer protocol
* hyper: 정보가 동일선 상에 위치하지 않고 다중으로 연결 상태; text: 목차없이 접근; transfer: 메소드; protocol: 규약
* naver.com -> 네임 스페이스 -> 디렉터리 정책

## 헤더
* 일반헤더: 정보  
* 요청헤더: 파라미터, MIME
* 객체헤더: REQUEST
* 응답헤더

# DOM
* 요소: 데이터
* 속성: 프로퍼티

------------

# python, Ruby

## Grammar

## string
```python
 print(¡®Hello ¡® +  :world¡¯)
 print(¡®Hello ¡® *3)
 print(¡®Hello ¡® [0])
 print(¡®Hello ¡®.capitalize())
 print( len(¡®hello world¡¯))
replace
upcase

*str(number) // when you convert the number to string
```

```ruby
·python 
   //doesn¡¯t work escape

 puts(¡®Hello ¡® +  :world¡¯)
 puts(¡®Hello ¡® *3)
 print(¡®Hello ¡®.capitalize())
 print(¡®Hello ¡®.length()): 
 sub
 upcase
print()
*number.to_s()  // when you convert the number to string
```

---

## #Variable
```python
*print(x+y)
*title=¡±python & ruby¡± // string variable
*print()
```

## python #Variable
```ruby
*print(x+y)
*title=¡±python & ruby¡± // string variable

## boolean
```

###  #boolean
```python
*print(True) // first letter end capital
```

### python #boolean
```ruby
*print(true) // small letter, lower case
```

## ##statement
```python
*if condition: / else:  // python doesn¡¯t need end operation. Indent will  distinguish the group
*if condition:  / elif condition: / else: / end
```

## python  ##statement
```ruby
*if  condition  end  // if the conditon is true, setence until end will be executed
*if condition  / elsif condition / else / end
```

## #input
```python
*variable = input() // input is command, it¡¯s string
*variable = input(variable.upper() + ¡°asdf.¡±) // input is command
```


## python #input
```ruby
*in_str = gets.chomp() | puts(in_str + ¡°World!¡±)
```

## #logical operation // and, or, not
```python
if and/or/not
```

## python #logical operation // and, or, not
```ruby
*if and/or/not
```


### Cheat Sheet  https://opentutorials.org/course/1750/9689
## python #Cheat Sheet
---------------------

## annotation
```
*¡¯¡¯¡¯ ¡®¡¯¡¯  // Until next ¡®¡¯¡¯, it is string type. But if we don¡¯t store values, we can use it as annotation
```

## python #annotation
```
*#
*=begin =end // It 8=is not formal annotation. 2. Toggle Comments in atom
```

### container
```python
* [¡®egoing¡¯, ¡®leezche¡¯] // Those strings belong to a list
*variable = [¡®¡®egoing¡¯, ¡®leezche¡¯] -> print(variable) / print(variable[number]
*egoing[1]= ¡®busan¡¯ // we can change the value
*// we call element that belongs to container and they have their own index
*variable.append
*del(al[0])
```




## def

```python
  *def__init__(self, variable): // variable is local bariable
    #self.v1 = v1 // self means instance
```

* In python, we can approach instance directly
* Reason why we use object

### getValue(self)
    *return self.value

### Array
* push
* join

### type
  print(type(variable))

### class
* put(variable.class)
* isinstance  // check out if its internal class
    #if isinstance(v1, int):
  
## object
* add
* subtract

### documentation
```python
*python homepage -> documentation: Tutorial / Library Rreference / Language Reference
```

## python #documentation
```ruby
*ruby homepage ->
*puts(arr[1..4])
 ```


### iteration
```python
*while condition:
*break
*while i < len(members):  // you can use this statement in most languages
*for   in list  // more convenient than while
*for item in [0, 1, 2, 3, 4]: // This statement makes program iterate 5 times
*for item in range(5): // range is function
*for item in range (5, 9): // 5 to 9
```

## python #iteration
```ruby
*while <condition> do   end
*break
*while i < members.length
*for  in list do
*for item in (0..10) do  <statement>  end
```

## #function = function
```python
*def <function name>():
*def <function name>(): return; // after return function, function is over immediately
*def <function name>(parameter):  print(parameter)
```

## python #function
```ruby
*def <function name>()  end
```


## #package manager; #pypi.python.org

---

## python #pacakge manager;  #rubygems.org
* type gem in cmd

---

## python -> documentation -> Library Reference
```python
  $Grouping functions linked to each other
python
*math; import math
*from egoing import a as z-> print(z())  // In this case, you don¡¯t have to write egoing
```

## Ruby module
```ruby
*// you don¡¯t have to declare import, because it contains it
```
  ---

## Mixin
### python


### Ruby
* It doesn¡¯t offer #multi inheritance, but ruby supports mixin
* include module // you can¡¯t include class, just module

---
## OOP
* string class
  - name1 = String.new('jaegeun')
  - Correspondence: function-logic, variable-data


---

## memory
  python
* Tips for memory
  + avoid string concatenation -> use map function
  + use a little scope as possible -> using with
* python's variable has memory address
  + id function is similar to pointer funcion in C
*  is vs == //
  1. == is faster than --
  2. is operation can't use override function


## copy
copy.copy()
* same function as [:], .copy()
copy.deepcopy()
* allocate new object
Singleton
* share the same memory address in every instance
String interning
* store string once in memory


  ##Empty memory
* del_keyword
  + remove the variables  
* Reference count
* Garbage Collection
* module 'weakref'
* Monkey patch
