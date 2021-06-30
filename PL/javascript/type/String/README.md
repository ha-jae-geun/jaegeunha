# [문자열 처리](https://ko.javascript.info/string)

# 문자형
* 자바스크립트에선 문자열(string)을 따옴표로 묶습니다.  

```javascript
let str = "Hello";
let str2 = 'Single quotes are ok too';
let phrase = `can embed another ${str}`;
따옴표는 세 종류가 있습니다.

큰따옴표: "Hello"
작은따옴표: 'Hello'
역 따옴표(백틱, backtick): `Hello`
큰따옴표와 작은따옴표는 ‘기본적인’ 따옴표로, 
자바스크립트에서는 이 둘에 차이를 두지 않습니다.

역 따옴표로 변수나 표현식을 감싼 후 ${…}안에 넣어주면, 
아래와 같이 원하는 변수나 표현식을 문자열 중간에 손쉽게 넣을 수 있습니다.

let name = "John";

// 변수를 문자열 중간에 삽입
alert( `Hello, ${name}!` ); // Hello, John!

// 표현식을 문자열 중간에 삽입
alert( `the result is ${1 + 2}` ); // the result is 3
${…} 안에는 name 같은 변수나 1 + 2 같은 수학 관련 표현식을 넣을 수 있습니다. 
물론 더 복잡한 표현식도 넣을 수 있죠. 무엇이든 들어갈 수 있습니다. 
이렇게 문자열 중간에 들어간 변수나 표현식은 평가가 끝난 후 문자열의 일부가 됩니다.

큰따옴표나 작은따옴표를 사용하면 중간에 표현식을 넣을 수 없다는 점에 주의하시기 바랍니다. 
이 방법은 역 따옴표를 써야만 가능합니다.

alert( "the result is ${1 + 2}" ); // the result is ${1 + 2} 
(큰따옴표는 확장 기능을 지원하지 않습니다.)
문자열은 문자열챕터에서 더 자세히 다루도록 하겠습니다.

글자형은 없습니다.
일부 언어는 글자 하나를 저장할 때 쓰이는 자료형, '글자(character)'형을 따로 지원합니다. 
C 언어와 Java의 char가 대표적인 예입니다.

자바스크립트는 글자형을 지원하지 않습니다. 문자형만 있을 뿐입니다. 
여기엔 글자가 하나 혹은 여러 개 들어갈 수 있습니다.
```


# 문자열 비교
```javascript
문자열 비교
자바스크립트는 '사전’순으로 문자열을 비교합니다. '사전편집(lexicographical)'순 
이라고 불리기도 하는 이 기준을 적용하면 사전 뒤쪽의 문자열은 사전 앞쪽의 문자열보다 크다고 판단됩니다.

실제 단어를 사전에 실을 때 단어를 구성하는 문자 하나하나를 비교하여 등재 순서를 정하는 
것과 같이 자바스크립트도 문자열을 구성하는 문자 하나하나를 비교해가며 문자열을 비교합니다.

예시:

alert( 'Z' > 'A' ); // true
alert( 'Glow' > 'Glee' ); // true
alert( 'Bee' > 'Be' ); // true
문자열 비교 시 적용되는 알고리즘은 다음과 같습니다.

두 문자열의 첫 글자를 비교합니다.
첫 번째 문자열의 첫 글자가 다른 문자열의 첫 글자보다 크면(작으면), 
첫 번째 문자열이 두 번째 문자열보다 크다고(작다고) 결론 내고 비교를 종료합니다.
두 문자열의 첫 글자가 같으면 두 번째 글자를 같은 방식으로 비교합니다.
글자 간 비교가 끝날 때까지 이 과정을 반복합니다.
비교가 종료되었고 문자열의 길이도 같다면 두 문자열은 동일하다고 결론 냅니다. 
비교가 종료되었지만 두 문자열의 길이가 다르면 길이가 긴 문자열이 더 크다고 결론 냅니다.
예시의 'Z' > 'A'는 위 알고리즘의 첫 번째 단계에서 비교 결과가 도출됩니다. 
반면, 문자열 'Glow'와 'Glee'는 복수의 문자로 이루어진 문자열이기 때문에, 아래와 같은 순서로 문자열 비교가 이뤄집니다.

G는 G와 같습니다.
l은 l과 같습니다.
o는 e보다 크기 때문에 여기서 비교가 종료되고, o가 있는 첫 번째 문자열 'Glow'가 더 크다는 결론이 도출됩니다.
정확히는 사전순이 아니라 유니코드 순입니다.
자바스크립트의 문자열 비교 알고리즘은 사전이나 전화번호부에서 사용되는 정렬 알고리즘과 아주 유사하지만, 완전히 같진 않습니다.

차이점 중 하나는 자바스크립트는 대·소문자를 따진다는 것입니다. 
대문자 'A'와 소문자 'a'를 비교했을 때 소문자 'a'가 더 큽니다. 
자바스크립트 내부에서 사용되는 인코딩 표인 유니코드에선 소문자가 대문자보다 
더 큰 인덱스를 갖기 때문이죠. 이와 관련한 자세한 내용은 문자열 챕터에서 다루도록 하겠습니다.
```