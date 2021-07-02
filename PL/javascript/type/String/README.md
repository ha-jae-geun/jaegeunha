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

# 문자열 함수
```javascript
 문자형
자바스크립트는 타 언어와 같이 글자 하나만 저장하는 자료형이 없다.

모든 글자는 문자열 형태로 저장되며, 인코딩 방식에 상관없이 UTF-16 형식을 따른다.1

'use strict'

let str = 'Hello';

str[0] = 'J'; // TypeError: Attempted to assign to readonly property.
console.log(str[0]); // 'H'
자바스크립트의 문자열은 immutable이기 때문에 글자를 바꾸려고 하면 읽기 전용 속성에 할당을 시도했다며 TypeError가 발생한다.

문자열을 바꾸려면 새로운 문자열을 생성한 후 변수에 할당하면 된다.

⚪️ 문자열 관련 메서드
👉 특정 위치의 글자 찾기
- charAt

let str = 'Hello';

str[0]; // 'H'
str.charAt(0); // 'H'


str[9]; // undefined
str.charAt(9); // ''
두 방법 모두 특정 위치의 글자에 접근할 수 있지만 접근하려는 위치에 글자가 없으면 []는 undefined를 반환하고, charAt은 빈 문자열을 반환한다.

문법
str.charAt(index)
👉 부분 문자열 찾기
- indexOf

let str = 'Hello Human!';

str.indexOf('H'); // 0
str.indexOf('H', 1); // 6
str.indexOf('man'); // 8
첫 번째 인자로 문자열을 입력하면 문자열의 첫 글자가 어느 위치부터 시작하는지를 알 수 있다.

두 번째 인자로 정수값을 넘기면 문자열을 찾기 시작하는 위치를 지정할 수 있다.

글자의 위치를 찾을 수 없으면 -1을 반환한다.

문법
str.indexOf(searchValue[, fromIndex])
- includes

let str = 'Hello Human!';

str.includes('Hello'); // true
str.includes('girl'); // false

str.includes('l', 4); // false
단순히 문자열의 포함 여부만 확인할 수 있다.

두 번째 인자로 정수값을 넘기면 문자열을 찾기 시작하는 위치를 지정할 수 있다.

문법
str.includes(searchString[, position])
- startsWith

let str = 'Hello Human!';

str.startsWith('Hello'); // true
str.startsWith('Human'); // false

str.startsWith('Human', 6); // true
첫 번째 인자로 넘긴 문자열로 시작하는지의 여부를 확인할 수 있다.

두 번째 인자로 정수값을 넘기면 그 위치부터 확인한다.

endsWith 메서드는 첫 번째 인자로 넘긴 문자열로 끝나는지의 여부를 확인할 수 있다.

문법
str.startsWith(searchString[, position])
str.endsWith(searchString[, length])
```
