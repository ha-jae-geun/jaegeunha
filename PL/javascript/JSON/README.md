# [zerocho JSON](https://www.zerocho.com/category/JavaScript/post/57432adfa48729787807c3fb)

# [json parser](http://json.parser.online.fr/)

# [Json beautifier](https://codebeautify.org/jsonviewer)

# [json diff](http://www.jsondiff.com/)

# [json validator](https://jsonlint.com/)

# [try catch](https://blog.voidmainvoid.net/205)


# json 툴
* json parser
* Json beautifier
* json diff
* json validator


# json
- ⎼ 안에서 배열을 값으로 사용할 경우에는 하나의 이름 안에 배열로 구성된 여러 개의 데이터 를 포함시킬 JSON 수 있지만 하나의 데이터는 오직 하나의 값으로만 구성되기 때문에 결국 단순한 키워드의 나열과 같은 경우 밖에 사용할 수 없다는 단점이 있다. 

## json 배열
- JSON 데이터에서의 배열 사용하는 방법과 계층 JSON 데이터 방법의 장점만 조합한 형태로 JSON 안에 새로운
- JSON이 포함되는 계층형 구조에서 각각의 데이터가 독립적 이라는 점을 배열로 보완하여 하나의 키 이름 안에서 여러 개의 데이터를 JSON으로 표현할 수 있다.
- 구성된 데이터는 하나의 키에 대응되는 값들이 배열로 구성되고 각 배열의 요소들이 동일한 구조의 JSON으로 구성된다.
- 하나의 JSON 키에 배열이 할당되어 있고 배열에 포함된 데이터들이 JSON 일 경우에 각 배열 요소들이 반드시
- 동일한 구조로 구성 될 필요는 없지만 규칙성 있는 JSON으로 배열이 구성될 경우는 프로그램의 처리 과정을 구성하는데 있어서 일정한 형식의 코드를 작성할 수 있다는 이점 때문에 대부분의 경우 배열의 각 요소는 동일한 구조를 갖는 JSON이 사용된다.
- 배열 안에 새로운 JSON을 포함하는 복합구조는 게시판과 같이 동일한 구조의 복합 데이터가 반복적으로 나타나는 형태에 적용 할 수 있고 이 복합구조가 Ajax에서 가장 많이 사용되는 데이터 구조이다.


## json 배열 읽기
- ⎼ 데이터의 기본 접근 방법은 객체명이름 의 형식지만 이름에 할당된 데이터가 배열이라면 그 배열의 JSON . 인덱스 번호까지 함께 명시 해 주어야 한다.
- 객체명이름 인덱스 . [ ];

## json 하위
- ⎼ 데이터 안에 새로운 데이터가 포함되어 있는 구조는 데이터가 계층적으로 구성될 수 있기 때문에 JSON JSON 데이터간의 포함관계를 표현하기가 쉽다는 장점이 있지만 하위 객체로 포함된 의 이름들이 독립적이기 JSON 때문에 하나의 객체 안에 존재하는 하위 객체들 간의 연관성이 적다는 단점도 지니고 있다.
- 객체명하위객체명이름

## json 하위 형태
- var 객체명 = { 
하위객체명 이름 값 이름 값 이름 값 :   { (key): (value), (key): (value), (key): (value) }, … 
하위객체명 이름 값 이름 값 이름 값 : { (key): (value), (key): (value), (key): (value) } … 
- };


## [XML과 JSON](http://tcpschool.com/json/json_intro_xml)
### 공통점
1. 둘 다 데이터를 저장하고 전달하기 위해 고안되었습니다.
2. 둘 다 기계뿐만 아니라 사람도 쉽게 읽을 수 있습니다.
3. 둘 다 계층적인 데이터 구조를 가집니다.
4. 둘 다 다양한 프로그래밍 언어에 의해 파싱될 수 있습니다.
5. 둘 다 XMLHttpRequest 객체를 이용하여 서버로부터 데이터를 전송받을 수 있습니다.


### 차이점
1. JSON은 종료 태그를 사용하지 않습니다.
2. JSON의 구문이 XML의 구문보다 더 짧습니다.
3. JSON 데이터가 XML 데이터보다 더 빨리 읽고 쓸 수 있습니다.
4. XML은 배열을 사용할 수 없지만, JSON은 배열을 사용할 수 있습니다.
5. XML은 XML 파서로 파싱되며, JSON은 자바스크립트 표준 함수인 eval() 함수로 파싱됩니다.
6. XML 문서는 XML DOM(Document Object Model)을 이용하여 해당 문서에 접근합니다.
7. 하지만 JSON은 문자열을 전송받은 후에 해당 문자열을 바로 파싱하므로, XML보다 더욱 빠른 처리 속도를 보여줍니다.
8. 따라서 HTML과 자바스크립트가 연동되어 빠른 응답이 필요한 웹 환경에서 많이 사용되고 있습니다.

### JSON의 장점
* 보안: XML은 적절하게 파싱(Parsing)을 거쳐도 BL(Billion Laughs) 공격 또는 EE(External Entity) 공격 같은 보안 취약성을 일부 갖고 있습니다. 페리는 "XML은 이런 기능을 실수로 활성화하면 시스템이 상당히 위험에 처하게 되지만 JSON은 그렇지 않다. JSON을 이용해 이런 위험에 노출되는 툴을 개발하기는 어렵다. 반면 XML을 사용할 때는 반드시 개발자가 능동적으로 확인하고 피해야 한다"라고 말했습니다.

```json 배열
JSON 배열
JSON 배열은 대괄호([])로 둘러쌓아 표현합니다.
또한, JSON 배열은 쉼표(,)를 사용하여 여러 JSON 데이터를 포함할 수 있습니다.
다음 예제는 배열의 이름이 "dog"이고, 3개의 JSON 객체를 요소로 가지는 JSON 배열의 예제입니다.

"dog": [
    {"name": "식빵", "family": "웰시코기", "age": 1, "weight": 2.14},
    {"name": "콩콩", "family": "포메라니안", "age": 3, "weight": 2.5},
    {"name": "젤리", "family": "푸들", "age": 7, "weight": 3.1}
]
```
