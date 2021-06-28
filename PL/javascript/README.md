# [자바스크립트 MND](https://developer.mozilla.org/ko/)
# [Javascript info](https://ko.javascript.info/)
# [특정 엔진 지원 여부](https://kangax.github.io/compat-table)
# [암호화 관련 기능 지원 여부](http://caniuse.com/#feat=cryptography)
```javascript
레퍼런스와 튜토리얼
프로그래밍을 공부하기 위한 자료는 크게 레퍼런스(reference)와 tutorial(안내서)가 있다. 

통상 튜토리얼은 언어의 문법을 설명하고, 레퍼런스는 명령어의 사전을 의미하다. 
본 수업은 자바스크립트에 대한 일종의 안내서라고 할 수 있고, 자바스크립트 사전은 레퍼런스라고 할 수 있다. 

자바스크립트의 API
자바스크립트의 API는 크게 자바스크립트 자체의 API와 자바스크립트가 동작하는 호스트 환경의 API로 구분된다. 

자바스크립트 API 문서
ECMAScript (표준문서)
자바스크립트 사전 (생활코딩)
자바스크립트 레퍼런스 (MDN)
jscript 레퍼런스 (MSDN)
```

# [프로그래머스 면접 질문](https://programmers.co.kr/posts/tag/%EA%B8%B0%EC%88%A0%EB%A9%B4%EC%A0%91%EB%8C%80%EB%B9%84)
# [프론트엔드 기본](https://joshua1988.github.io/web-development/javascript/javascript-basic-summary/)
# [프론트엔드 인터뷰 문제](https://joshua1988.github.io/)
# [프론트엔드 인터뷰 문제2](https://sunnykim91.tistory.com/121)
# [프론트엔드 인터뷰 문제3](https://ksw1652.github.io/2018/08/02/front-end-interview-html-question/)
# [프론트엔드 인터뷰 문제4](https://velog.io/@chris/front-end-interview-handbook-js-1#%EB%8B%A4%EC%9D%8C%EC%9D%B4-iife%EB%A1%9C-%EC%9E%91%EB%8F%99%ED%95%98%EC%A7%80-%EC%95%8A%EB%8A%94-%EC%9D%B4%EC%9C%A0%EB%A5%BC-%EC%84%A4%EB%AA%85%ED%95%98%EC%84%B8%EC%9A%94-function-foo-%EB%A5%BC-iife%EB%A1%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0-%EC%9C%84%ED%95%B4%EC%84%9C%EB%8A%94-%EB%AC%B4%EC%97%87%EC%9D%84-%EB%B0%94%EA%BF%94%EC%95%BC%ED%95%98%EB%82%98%EC%9A%94)
# [프론트엔드 인터뷰 문제5](https://realmojo.tistory.com/300)
# [null, undefined 차이](https://velog.io/@jakeseo_me/%ED%94%84%EB%A1%A0%ED%8A%B8%EC%97%94%EB%93%9C-%EC%9D%B8%ED%84%B0%EB%B7%B0-%EB%AC%B8%EC%A0%9C-%EB%8B%B5%ED%95%B4%EB%B3%B4%EA%B8%B0-10-%ED%94%84%EB%A1%9C%ED%86%A0%ED%83%80%EC%9E%85-%EC%83%81%EC%86%8D%EA%B3%BC-null-undefined%EC%9D%98-%EC%B0%A8%EC%9D%B4)
# [웹 브라우저, html](https://devowen.com/271)

# [caniuse](https://caniuse.com/)
# [zerocho](https://www.zerocho.com/category/JavaScript?page=1)

# 'user strict';
* 선언되지 않은 변수 사용 금지

# Angular, React, Vue
* SPA 프레임워크라고 한다. SIngle Page Application
* 안드로이드와 IOS는 자체적인 시스템이 있어서 서버에서 데이터만 보여주만 화면을 보여줄 수 있다.
* 하지만 웹에서는 그게 불가능했는데 위의 언어를 쓰면 브라우저에서 주어진 데이터에 따라 HTML 웹페이지를 랜더링한다. 
* 브라우저는 HTML + CSS + SPA 프레임워크를 패키징 해서 가져가면 화면을 렌더링해서 모니터에 띄어준다
* Vue: Evan You란 개인이 만들었고 코드가 깔끔하고 배우기 쉬운 특성 때문에 다른 둘에 비해 후발 주자임에도 불구하고 빠른 속도로 성장
* React: 페이스북에서 만들언쓴데 막강한 커뮤니티와 자료들을 갖추고 있다. 다름 서비스들과 잘 융합하기 때문에 유연성을 요하는 서비스들에 권장
	* 라이브러리의 특성을 갖는다.
* Angular: 구글에서 Typescript라는 자바스크립트를 보완한 언어로 안정적이고 탄탄한 앱을 만들 수 있다. 대신 상대적으로 무겁고 배우기 어렵다. 
	* 프레임워크의 특성이 뚜렸하다




# CSS
## 우선순위
- css가 제일 우선순위가 높다.
- id가 class보다 우선순위가 높다.

## id 와 class 의 차이점

- id는 한페이지에 하나의 정의(style/css)로 하나의 태그(id="")만 사용할 수 있다. 즉 로고, 상단메뉴, 하단정보 같은 스타일을 정의할 때 id를 사용한다
- class는 한페이지에 반복적으로 사용되는 스타일을 정의할 수 있다.
- 반복적으로 사용되는 스타일에는 class를 이용하여 정의하고, 그 내부에 세부 스타일을 정의할 때 id를 사용해주면 효과적이다.

# block과 inline 차이
## inline
-  width/height 적용 불가
- margin/padding-top/bottom 적용 불가
- line-height 원하는 대로 적용 불가(span에 적용안되고 감싸고 있는 div 전체 크기에만 영향 등)


## block
- 반면 block은 무조건 한줄을 점유하고, 다음 태그는 다음 줄로 가버리죠.
- width/height 적용 가능
- margin/padding-top/bottom 적용 가능
- line-height 적용 가능
- 다만 고려해야 할 것이 있습니다.
- inline-block 끼리 공백이 생기게 되는데, 이때는 상위 div에 { font-size: 0; } 를 적용하면 해결이 됩니다.
- inline-block 끼리 높이가 안맞을시 상위 공백이 생기는데, 이때는 { vertical-align: ---; } 값으로 top 등을 줘서 맞춰주시면 됩니다. 
- 디테일한 보정이 필요하고 예민하신 분들은 inline-block 쓰시는게 낫고,
text 내의 특정 부분 스타일 등 간단한 것들은 그냥 inline 쓰시면 됩니다.




# font-family
- 파이썬 라이브러리에서 이미지의 한글 인식 위한 것.

# form
## action
- <form action="#"> </form>; 자기 자신 문서를 의미


## 체크박스
- 1차원 배열; jsp에서 request 객체에서 getParameterValues

## 유효성 검사
- <input type="text" name="name" required>
- input 요소의 required 속성으로 입력 필드의 내용에 대한 유효성 검사를 한다.


## required
- required 속성보다 jQuery로 코딩할 것.


## HTML, CSS, 자바스크립트
```java
① HTML ⎼웹 페이지의 구조를 작성한다. 
② CSS ⎼웹 페이지에 구조에 대한 디자인적인 요소를 구현한다. 
	⎼이 과정까지 진행되었을 때 웹 페이지는 웹 브라우저를 통해 사용자에게 잘 정돈된 를 
	제공할 UI(User Interface) 수 있게 되지만 있는 모양 그대로만을 사용자에게 제공할 뿐 사용자의 입력에 반응하거나 
	다이내믹한 요소를 제공하기 위한 대화식 웰 페이지로서의 기능은 갖추지 못한다. ③ JavaScript 
	⎼ 는 웹 페이지에 정적인 화면에 동작을 부여하여 웹 페이지를 사용자와의 의사소통을 
	위한 대화식 JavaScript 웹 페이지로 재구성한다. 
```

## 특징
```java
⎼ 년 넷스케이프사의 브렌던 아이크 가 라이브스크립트 를 개발했고 후에 자바스크립트 1995 (Brendan Eich) (LiveScript) 로 개명했다.
⎼자바스크립트는 인터프리터형 프로그래밍으로 문서의 한계성을 극복하고자 개발되었다 HTML . 
⎼자바스크립트는 정적인 문서와 달리 동적인 화면을 웹페이지에 구현하기 위해 사용하는 스크립트 언어이며 
HTML 객체 지향 스크립트 언어이기 때문에 필요한 객체를 호출해 문서 속에서 바로 작업할 수 있다 HTML . 
⎼ 문서 내에 포함되어 일반 응용 프로그램처럼 컴파일러 과정을 거치지 않고 웹 브라우저를 통해 바로 실행되어 
HTML 보여주는 웹 스크립팅 언어로 경량 프로그래밍 언어이다. 
⎼자바스크립트는 페이지에 삽입 할 수 있는 코드를 프로그래밍하며 자바스크립트 코드는 모든 
웹 브라우저에서 HTML 실행할 수 있다. 
⎼자바스크립트는 의 HTML script 요소에 선언되어 사용되며 form 요소를 이용하여 제어할 수 있다. 
⎼ 객체지향 프로그래밍 의 성격을 가지고 있지만 클래스의 개념이 없고 상속할 수 없는 특징을 가지고 있다 OOP( ) . 
⎼자바스크립트는 데이터타입을 설정하지 않아도 되며 자바스크립트는 문장 구분을 위해서 사용되는 세미콜론 을 (;) 사용하는 것이 원칙이다. 
⎼자바스크립튼 대소문자와 공백도 구분하며 단독 문서로 저장 할 때는 확장자를 로 지정해야 한다 js . 


(1) 장점 
⎼구조적인 컴파일러용 언어에 비해 쉽고 더 빠르게 코딩할 수 있으며 컴파일 언어에 비해 처리에 
더 시간이 걸리지만 짧은 프로그램들을 사용하기에는 매우 유용하다. 
⎼자바스크립트는 소스 코드 안에서 바로 인식하여 전송하기 때문에 운영체제에 제한을 받지 않는다 HTML . 
⎼자바스크립트는 많은 객체와 복잡한 문법을 가지고 있지 않기 때문에 복잡한 프로그램도 손쉽게 만들 수 있다. 

(2) 단점 
⎼ 소스 코드 안에 자바스크립트가 포함되어 있어 소스 코드의 노출이 불가피하다 HTML . 
⎼자바스크립트는 한정된 객체와 메서드를 가지고 있기 때문에 다양한 프로그램을 만들 수 없다. 
```

## 자바스크립트 선언
* ⎼자바스크립트 코드를 에 적용하는 가장 기본적인 방법은 문서 안에 자바스크립트를 사용하기 위한 HTML HTML 블록을 생성하고 그 안에 자바스크립트 명령문을 코딩 하는 것이다. 
* ⎼ 에서 자바스크립트 블록은 HTML <script> 태그로 정의되며 <script> 태그 사이에 자바스크립트를 포함한다. 
* ⎼자바스크립트가 시작하고 끝나는 위치를 <script>와 </script>를 선언하고 script 요소인 type 속성의 값에 MIME 형식인 text/javascript으로 지정한다

## null
- null 객체라고 함.
- ⎼str 변수의 내용을 검사하여 “”을 출력하고 null을 할당하는 것 보다 웹에서는 “”을 할당하는 것을 권장한다


## script
- head나 body 어디든 적어도 되나 특수한 경우엔 어떤 것에만 놓아야 하는 경우가 있음.

## head 태그
- jQuery 라이브러리(jquery-1.11.2.min.js)를 HTML 문서 내에 포함하는 방법은 일반적으로 head 태그 내에 스타일 시트를 읽어들인 다음 자바스크립트를 읽어 들이는 순서를 따르며 이 때 다른 스크립트를 로드하기 전에 jQuery 스크립트를 우선하여 로드해야 한다.
- ⎼head 태그에 기술한 jQuery는 적용이 되지 않는데 그 이유는 브라우저 내의 HTML 인터프리터에 의해서 DOM 트리가 생성되기 전에 span 엘리먼트를 검색하려고 시도했기 때문이다. 
* body 아닌 head에 script를 넣고 function을 실행하려면 페이지를 다 불러오고 실행하라는 window.onload = funcion(){}를 붙여야 함

# document
## getElementById
- document.getElementById: id에 따라 찾기
- 만약 해당하는 id 를 가진 태그가없을경우 null 에러가 발생한다.


## getElementsByTagName() 함수 , 

- 이 함수는 태그의 있는 div, li, p 와 같은 특정 태그명을 가지고 있는 element 의 집합을 가져오는 함수이다.
- 따라서 반환되는 값은 HTML컬렉션 객체이며 for문 등을 사용하여 element 객체를 사용할수있다.

##  getElementsByClassName() 
- 이 함수는 태그의 class="" 속성을 사용하여 접근한다.

- 동일한 class명이 존재할수 있기때문에  ( id속성은 html 문서에 동일한 id속성이 존재하면 안된다..) 

- id 속성을 사용하여 접근하는 getElementById() 와 달리 getElementsByClassName() 은 컬렉션 객체를 반환한다.

- 따라서 for문을 사용하거나 특정 index에 위치한 element를 반환받아 사용할수있다. 사용예는 아래와 같다.


## innerHTML
- innerHTML 을 사용하면 HTML 문서안에는 태그의 내용을 가져오거나 변경할수있다.
- sample.innerHTML = "bye"


## write()
- document.write()는 문서안의 텍스트 또는 연산된 숫자를 넣을수있다.

## console.log
- console.log는 말그대로 콘솔에 로그를 남길때 사용하는데, 콘솔은 개발자모드(F12) 에서 확인할수있다. 주로 디버깅용도로 사용한다.

# Tern
- 웹 단축키; 매번 configure 가서 설정해 주어야 함.

# 타입
## 기본 타입
- 숫자
- 모든 숫자를 64bit 부동 소수점 형태로 저장하며 정수와 실수의 구분이 없다 
- 문자열
- 불린값
- undefined
- null

## 참조타입
- 객체
- 배열
- 함수
- 정규표현식

# 속성값
- 객체, 함수, 메소드 기능 포함

# 따옴표
- R: 큰 따옴표
- 자바 스크립트: 큰 따옴표
- 파이썬: 작은 따옴표; 
- 제이슨: 큰 따옴표

## ==
- ⎼동등 연산자는 1 == "1" 은 두 피연산자의 타입이 다르므로 같은 타입으로 변환해서 두 값이 같다고 판단해서 document 객체의 write 메서드로 true를 출력한다.  
- ⎼동등 연산자의 비교는 타입변환에 따른 결과를 얻을 수 있으므로 대부분의 자바 스크립트 코딩 가이드에서 동등 연산자로 비교하는 것을 추천하지 않는다. 

## ===  Strict Equal Operator
- a = 1;  b=”1”;  브라우저에서 같은값으로 인식 가능;  ==으로하면 같은값 인식
-  10 : document.write(a === b); ⎼일치 연산자는 1 === "1" 은 두 피연산자의 타입이 다르므로 document 객체의 write 메서드로 false를 출력한다.
- 값과 타입 둘다 비교

### undefined와 null 의 비교 
- undefined == null => true
- undefined === null => false


## 크롤링
- R, 자바 스크립트, 제이슨

## typeof
- typeof는 unary 오퍼레이터이다. unary 오퍼레이터로는 ! 라던가 - 등과 같이 인자를 하나만 받을 수 있는 연산자를 뜻한다. 즉, 함수가 아니고 연산자이기 때문에 괄호를 사용하면 안된다.

### null 확인법
- 자바 스크립트는 null이라는 객체이다.
- if(typeof yourVariable === 'object') { /* 오브젝트 처리 */}
- 하지만 위와 같이 하게 되면 만약 yourVariable이 null이라면 결과가 true로 나타난다. 따라서 null인 경우 false의 결과를 나타내고 싶다면,
- if(yourVariable != null && typeof yourVariable === 'object') {/*오브젝트 처리*/} 
- if(!!yourVariable && typeof yourVariable === 'object') {/*오브젝트 처리*/}


## instance of
- : instanceof 는 비교 연산자로 >,<,== 와 같이 두개의 인자를 받는 연산자로 앞의 비교 연산자들을 이용하는 기분으로 사용하면 된다. 하지만 결과로 리턴하는 것은 typeof와는 성질이 조금 다르다. instanceof는 해당하는 변수가 사용하고 있는 prototype의 chain을 2번째 인자와 쭉 비교해서 true/false 값을 리턴한다.
- 쉬운말로 하자면, 해당하는 변수의 클래스와 비교해서 리턴해주는, java에서 많이 쓰던것과 비슷하다고 볼 수 있다.
- 자바스크립트는 instanceof 연산자가 존재한다. 이 연산자는 생성된 인스턴스 객체가 어떤 생성자 함수를 사용하여 생성되었는지 확인하고 불리언값으로 반환하여 주는 유용한 연산자이다. 이 연산자를 사용해 생성자 함수를 확인하는 과정을 예제를 통하여 알아보고자 한다.


# 연산자
- 쉬프트연산자는 산술연산자보다 우선순위는 나르지만 계산 속도가 더 빠르다.
- 비트 연산자도 관계예산자보다 우선순위는 낮지만 속도가 더 빠르다.
# 객체 표기법
- 파이썬에서는 딕셔너리, 자바에서는 맵이라고 표현
- 객체 표기법 - 제이슨
- 몽고디비, 카산드라는 객체표기법 사용

## 예제
- var person = 
- {
- 		fname : "홍", 
- 		lname : "길동",
- 		age : 25
- };


# 배열리스트  []
- 자바에서는 리스트, 파이썬에서는 리스트라고 함.


# for문

## for in 반복문과 for of 반복문의 차이점
- for in 반복문 : 객체의 모든 열거 가능한 속성에 대해 반복
- for of 반복문 : [Symbol.iterator] 속성을 가지는 컬렉션 전용; 인덱스로 접근 가능
- for...in iterates over the enumerable properties of an object
- for...of iterates over the property values of objects
- basic for문과 for in은 반복변수에 index를 리턴하지만 forEach 와 for of 는 해당 값을 리턴하기 때문이죠.
- forEach는 위와같이 callback 함수가 필요합니다. 굳이 이걸 쓸 필요 없이 같은 기능을 하기 위해 나온것이 for of이죠.
- for ... of 문은 반복가능한 객체(Array, Map, Set, String, TypeArray, arguments 객체등)를 반복하는 문법입니다.





## for in
- for(var i = 0; i < array.length; i++){
-       alert(array[i]);
-    }

위와 아래 같은 역할 

- for(var i in array){
-       alert(array[i]);
-    }


# 함수
- 반복해서 호출해서 사용할 수가 있다.
- 메소드는 복제 기능이 없다(= 객체를 통해서 사용하는 것이 없다)
- 함수는 복제, 메소드는 상속을 통해 재사용성을 가진다.
- // 변수나 함수는 동급이다. 둘 다 객체다.
- // 변수는 정적 객체고 함수나 메소드는 동적 객체다.
- 같은 객체이기 때문에 함수를 변수에 복제 가능(프로토 타입)
	- 정적 객체지만 속성은 동적 객체를 가질 수 있음.


## 변수에 함수 복제
- 매개변수에 들어가기 위해서 변수에 복제
- function sot() {
	
- document.write("함소 호출");
- }

- var minsot = sot;

- minsot(); 

## 정적 객체에 동적 객체 바로 할당
- 매개변수에 들어가기 위해서 변수에 복제
- var minsot1 = function sot() {
	
- document.write("함소 호출");
- }

## 정적 객체에 동적 객체 바로 할당 2
- 매개변수에 들어가기 위해서 변수에 복제
- var sot = function sot() {
	
- document.write("함소 호출");
- }
- sot(); // 정적 객체와 동적 객체의 래퍼런스가 다르기 때문에 같은 이름 대입 가능


# 프로토타입 기반
- R, 자바 스크립트

# DB 언어
- SQL: 오라클, ms-sql, my-sql
- No-SQL: 몽고디비, 카산드라

# 스크립트 기반
- 파이썬, 루비, 자바스크립트, 몽고디비, 카산드라 : 인터프리터 식, 함수형 언어



# 프로토타입
- 복제 기능 담보
- 함수 1. 완전 복제(레퍼런스 복제) 2. 부분 복제(레퍼런스 변경)
1. 원래있던 객체 복제 2. 빈객체를 선언해서 생성하는 방법

# 프로토타입 객체
- 함수를 생성하면 동시에 생성되는 프로토타입을 new 키워드로 함수에서 찍어낸
모든 객체들이 이 프로토타입을 참조하기 때문입니다.
- JavaScript에서는 기본 데이터 타입인 boolean, number, string, 그리고 특별한 값인 null, undefined 빼고는 모두 객체입니다. 사용자가 정의한 함수도 객체이고, new라는 연산자를 통해 생성된 것도 객체입니다. 객체 안에는 proto(비표준) 속성이 있습니다. 이 속성은 객체가 만들어지기 위해 사용된 원형인 프로토타입 객체를 숨은 링크로 참조하는 역할을 합니다.

## 리스트, 그래프에서 프로토타입
- 프로토타입 방식으로 function을 var에 저장하여 사용하면 그때그때 함수를 호출할 필요가 없기 때문에 그래프가 빠르게 만들어진다.
- 리스트 같은 경우도 게시판처럼 한번만 만들 필요가 있는 것은 그때그때 호출해도 상관 없지만 여러번 호출이 필요할 경우 프로토타입을 사용한다.

## function과 prototype
- 먼저 함수를 선언하면 위와 같은 구조의 2개의 객체가 생성이 됩니다. 하나는 function 객체이고, 다른 하나는 prototype 객체입니다. 단순히 2개의 객체가 생성된 것만 아니라 두 객체는 서로 이어져 있는데 함수에서는 프로토타입 객체에 prototype이라는 내부변수로 접근 할 수 있고, 프로토타입에서는 constructor라는 변수로 함수에 접근 할 수 있게 됩니다. 서로를 참조하는 레퍼런스 변수를 통해 두 객체는 접근 뿐만 아니라 변경도 가능합니다.
- 함수는 프로토타입을 생성하지만, 함수 스스로가 프로토타입으로부터 값을 얻지 못함을 알 수 있습니다. 설정은 해놓고 쓸수 없다면 의미가 없죠. 그렇다면 프로토타입이 원형 이라는 자신의 이름값을 하기 위해서는 다른 방식접근해야 하는데 그 방법은 바로 인스턴스를 생성하는 것입니다.



# 원형
- {}, [], 문자열은 아님(‘’와 “” 둘다 존재)
- 스택 구조에 저장됨, 그리고 index를 통해 수정 가능


## 원형을 객체에 할당
 * = 
 * var people = {};
 * people.name = "홍길동";
 * 
 * 
 * people.setName = function() {
 * 	document.write(this.name);	
 * }
 * 	
 * 	people.getName = function() {
 * 		
 * 		return this.name;
 * 	}
 * 
 * 
 * people.sayInfo = function() {
 * 	document.write(this.getName);
 * }
 * 
 * 
 * - 원형에서 선언되었기 때문에 전역적 역할을 하게 된다.


# navigator

## userAgent 프로퍼티
- 인코딩 위해 필요


## minetype


# window.open
- width: 옵션


# this, self


# location
- action과 비슷

# 엑셀
- 무겁다, 엑셀필요, 지원범위 좁다

# xml
- 무겁다, 지원범위 좁다



## ready
- $(document).ready(fns)
- 이 구문은 개발자로 하여금 어떤 함수 또는 코드가 호출 또는 실행되는 시점을 스케쥴링할 수 있게 해준다. 그 시점은 바로 문서객체모델이라고 하는 DOM (Document Object Model)이 모두 로딩되었을 때인데 이렇게 $(document).ready() 안에 위치한 코드를 DOM이 모두 준비된 이후에 실행되게끔 해준다. 
- jQuery가 나오기 오래 전부터 자바스크립트를 해 본 사람이라면 자바스크립트 window 객체의 onload  이벤트핸들러에 함수를 지정하는 것과 비슷한 역할을 하는 것이 아닐까 생각할 수 있는데 onload 이벤트 핸들러는 페이지를 구성하는 모든 리소스 즉, HTML 뿐만 아니라 이미지까지  불러온 시점에서 호출되는 데 반해 $(document).ready() 함수는 리소스가 아닌 DOM 객체가 생성되어 준비되는 시점에서 호출된다. 따라서 많은 이미지로 구성된 페이지의 경우라면 순서상 ready() 함수가 먼저 실행되고 그 다음에 onload 이벤트 핸들러가 실행된다. 즉, $(document).ready() 함수는 페이지를 구성하고 있는 모든 이미지가 브라우저상에 렌더링될 때까지 기다릴 필요없이 DOM이 준비되기만 하면 바로 실행된다. 

# 옵션
- 인자 없는 함수의 형태(  a()  )  는 옵션의 기능을 한다.

# 데이터
- 엑셀, CSV, XML 덩크, json은  
- a = {} 이렇게 구성되어 있음. 2. a = []

# jQuery 버전
- 1.xx 는 구형 브라우저 버전을 대부분 지원하며 가장 안정적인 release 이다. 
주로 공공기관 사이트나 국가 관련 사이트 등 구형 브라우저를 사용하는 사용자가 많을 것으로 예측되는 사이트에 사용된다.
- ※ 이슈) 1.9 이전의 버전과 그 후의 버전 간의 호환성 문제가 발생하여 최신버전의 jQuery를 필요로 하는 플러그인 이나 스크립트를 삽입할 때 제대로 작동하지 않을 수 있다. 따라서 jQuery Migrate를 삽입하여 문제를 해결한다.

## 2.xx 버전
- 2.xx 부터는 익스의 6~8 버전을 지원하지 않는 등 간소화? 하여 1.xx 보다 용량이 적다. 익스 6~8 버전 보다 높은 버전을 사용할것으로 예상되는 사용자만 접속한다는 가정하에 이 버전들을 쓰는 것이 좋다.

## migrate
- jQuery는 1.9 버전 이전에 작성된 코드와 이후에 작성된 코드간의 호환성에 문제가 발생할 수 있습니다. 구형 jQuery로 작성된 페이지에 최신버전의 jQuery를 필요로하는 플러그인이나 기타 스크립트를 삽입하다보면 발생하는 문제인데 이를 해결하는 방법중에 하나로 jQuery Migrate를 사용할 수 있습니다.
- 우리는 이전 버전의 jQuery에서 이전을 단순화하기 위해 jQuery Migrate 플러그인 을 만들었습니다. 플러그인은 더 이상 사용되지 않는 기능 및 동작을 복원하여 최신 버전의 jQuery에서 이전 코드가 계속 제대로 실행되도록합니다. 압축되지 않은 개발 버전을 사용하여 호환성 문제를 진단하면 문제를 확인하고 수정하는 데 사용할 수있는 경고가 콘솔에 생성됩니다. 압축 된 제품 버전을 사용하여 콘솔 경고를 생성하지 않고 호환성 문제를 간단하게 해결할 수 있습니다.

## min.js
- jquery.js 개발자 버전: 소스를 분석할수 있도록 공백을 포함하여 구성
- jquery.min.js: 공백없이 구성
- jquery의 경우 디버깅이 가능하도록 코드가 정렬되어있다
- 사이즈와 속도는 당연히 jquery.min.js가 좋다; 배포용
- jquery-1.x.x.min.js는 변수 등 내용들이 간소화되어 있고, 일렬로 길게 늘어서 있는데, 이는 페이지를 로딩할 때마다 jquery-1.x.x.min.js를 불러오는데 크기를 최소화하여 속도를 내기 위함
-  단순 개행, 공백의 제거뿐아니라 변수이름도 a, b, c와 같이 줄여서 전반적으로 임포트해서 쓰기에 좋은 형태( 불필요한 용량 제거 )로 가공을 해줍니다. 


# jQuery 순서
- script type = "text/javascript" src = "../JS/jquery-1.11.2.js"
		- 먼저 수행되어야 함.
- script type = "text/javascript" src = "../JS/jquery-migrate-1.11.2.js"

# 객체에 함수 담기
- 매개변수가 있을 때는 var t = function s(a, b) {} 이렇게 밖에 선언 못함;
- 매개변수가 없을 때만 var t = s(); 이렇게 선언 가능


# 콜백 함수
1. 함수 이름으로 호출하지 않는다.
2. 함수를 매개변수처럼 사용한다.
3. 매개함수는 익명함수가 되어야 한다.
- $(function() {
- $("#hello").html("안녕하세요");	
- } );


# jQuery 방식
 맵 방식
- 내에 속성과 값을 콜론(:)를 구분자로 쌍으로 기술하여 속성에 값을 설정하는 방식으로 여러 개의 속성에 대해서 값을 설정할 경우에는 콤마(,)로 속성과 값을 여러 번 반복해서 기술한다.
- $('div span:first-child, div span:last-child').css('text-decoration':'underline','color':'red','font-size':'20pt');

2. 체인 방식
- 메서드 호출이 완료된 후 메서드에 마침표(.)를 찍어 연속적으로 메서드를 호출하는 방식으로 체인 방 식을 사용하면 한 문장으로 여러 메서드를 호출할 수 있다.
- $('div span:first-child, div span:last-child').css('text-decoration','underline').css('color','red').css('font-size','20pt');

# 파싱
## 자식
## 자손
- 자식: div > em; 가장 겉에 있는 1개의 자식만
- 자손: div em; 같은 위치에 있는 자식 포함해서 자손들도


## 형제
- +, 한개만 검색 가능
- -; 형제 다 찾기


## 아이디로 찾기
- $('span[id="simpletext1"]').addClass('redtext');



# 부트 스트랩
- https://datatables.net/

