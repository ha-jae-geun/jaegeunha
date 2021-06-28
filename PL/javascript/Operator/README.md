# [엘리](https://www.youtube.com/watch?v=YBjufjBaxHo&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=4)

# [null이나 undefined와 비교하기](https://ko.javascript.info/comparison)
```javascript
null이나 undefined를 다른 값과 비교할 땐 예상치 않은 일들이 발생합니다. 
일단 몇 가지 규칙을 먼저 살펴본 후, 
어떤 예상치 않은 일들이 일어나는지 구체적인 예시를 통해 살펴보도록 하겠습니다.

일치 연산자 ===를 사용하여 null과 undefined를 비교
두 값의 자료형이 다르기 때문에 일치 비교 시 거짓이 반환됩니다.

alert( null === undefined ); // false
동등 연산자 ==를 사용하여 null과 undefined를 비교
동등 연산자를 사용해 null과 undefined를 비교하면 특별한 규칙이 적용돼 true가 반환됩니다. 
동등 연산자는 null과 undefined를 '각별한 커플’처럼 취급합니다. 
두 값은 자기들끼리는 잘 어울리지만 다른 값들과는 잘 어울리지 못합니다.

alert( null == undefined ); // true
산술 연산자나 기타 비교 연산자 <, >, <=, >=를 사용하여 null과 undefined를 비교
null과 undefined는 숫자형으로 변환됩니다. null은 0, undefined는 NaN으로 변합니다.

이제 위에서 살펴본 세 가지 규칙들이 어떤 흥미로운 에지 케이스(edge case)를 만들어내는지 알아봅시다. 
이후, 어떻게 하면 에지 케이스가 만들어내는 함정에 빠지지 않을 수 있을지에 대해 알아보겠습니다.

null vs 0
null과 0을 비교해 봅시다.

alert( null > 0 );  // (1) false
alert( null == 0 ); // (2) false
alert( null >= 0 ); // (3) true
위 비교 결과는 논리에 맞지 않아 보입니다. 
(3)에서 null은 0보다 크거나 같다고 했기 때문에, (1)이나 (2) 중 하나는 참이어야 하는데 둘 다 거짓을 반환하고 있네요.

이런 결과가 나타나는 이유는 동등 연산자 ==와 기타 비교 연산자 <, >, <=, >=의 동작 방식이 다르기 때문입니다. 
(1)에서 null > 0이 거짓을, 
(3)에서 null >= 0이 참을 반환하는 이유는 (기타 비교 연산자의 동작 원리에 따라) null이 숫자형으로 변환돼 0이 되기 때문입니다.


그런데 동등 연산자 ==는 피연산자가 undefined나 null일 때 형 변환을 하지 않습니다.
undefined와 null을 비교하는 경우에만 true를 반환하고, 
그 이외의 경우(null이나 undefined를 다른 값과 비교할 때)는 무조건 false를 반환합니다. 이런 이유 때문에 (2)는 거짓을 반환합니다.

비교가 불가능한 undefined
undefined를 다른 값과 비교해서는 안 됩니다.

alert( undefined > 0 ); // false (1)
alert( undefined < 0 ); // false (2)
alert( undefined == 0 ); // false (3)
위 예시를 보면 undefined는 0을 매우 싫어하는 것처럼 보입니다. 항상 false를 반환하고 있네요.

이런 결과는 아래와 같은 이유 때문에 발생합니다.

(1)과(2)에선 undefined가 NaN으로 변환되는데(숫자형으로의 변환), 
NaN이 피연산자인 경우 비교 연산자는 항상 false를 반환합니다.
undefined는 null이나 undefined와 같고, 그 이외의 값과는 같지 않기 때문에 (3)은 false를 반환합니다.
함정 피하기
위와 같은 에지 케이스를 왜 살펴보았을까요? 이런 예외적인 경우를 꼭 기억해 놓고 있어야만 할까요? 
그렇지는 않습니다. 개발을 하다 보면 자연스레 이런 경우를 만나고 점차 익숙해지기 때문에 지금 당장 암기해야 할 필요는 없습니다. 
하지만 아래와 같은 방법을 사용해 이런 예외 상황을 미리 예방할 수 있다는 점은 알아두시길 바랍니다.

일치 연산자 ===를 제외한 비교 연산자의 피연산자에 undefined나 null이 오지 않도록 특별히 주의하시기 바랍니다.
또한, undefined나 null이 될 가능성이 있는 변수가 <, >, <=, >=의 피연산자가 되지 않도록 주의하시기 바랍니다. 
명확한 의도를 갖고 있지 않은 이상 말이죠. 
만약 변수가 undefined나 null이 될 가능성이 있다고 판단되면, 이를 따로 처리하는 코드를 추가하시기 바랍니다.

```

# [첫 번째 truthy를 찾는 OR 연산자 ‘||’](https://ko.javascript.info/logical-operators)
```javascript
첫 번째 truthy를 찾는 OR 연산자 ‘||’
지금까진 피연산자가 불린형인 경우만을 다뤘습니다. 
전통적인 방식이죠. 이제 자바스크립트에서만 제공하는 논리연산자 OR의 '추가’기능에 대해 알아보겠습니다.

추가 기능은 아래와 같은 알고리즘으로 동작합니다.

OR 연산자와 피연산자가 여러 개인 경우:

result = value1 || value2 || value3;
이때, OR ||연산자는 다음 순서에 따라 연산을 수행합니다.

가장 왼쪽 피연산자부터 시작해 오른쪽으로 나아가며 피연산자를 평가합니다.
각 피연산자를 불린형으로 변환합니다. 
변환 후 그 값이 true이면 연산을 멈추고 해당 피연산자의 변환 전 원래 값을 반환합니다.
피연산자 모두를 평가한 경우(모든 피연산자가 false로 평가되는 경우)엔 마지막 피연산자를 반환합니다.
여기서 핵심은 반환 값이 형 변환을 하지 않은 원래 값이라는 것입니다.

정리해 보자면 이렇습니다. OR "||" 연산자를 여러 개 체이닝(chaining) 하면 
첫 번째 truthy를 반환합니다. 피연산자에 truthy가 하나도 없다면 마지막 피연산자를 반환합니다.

예시:

alert( 1 || 0 ); // 1 (1은 truthy임)

alert( null || 1 ); // 1 (1은 truthy임)
alert( null || 0 || 1 ); // 1 (1은 truthy임)

alert( undefined || null || 0 ); // 0 (모두 falsy이므로, 마지막 값을 반환함)
이런 OR 연산자의 추가 기능을 이용하면 여러 용도로 OR 연산자를 활용할 수 있습니다.

변수 또는 표현식으로 구성된 목록에서 첫 번째 truthy 얻기

firstName, lastName, nickName이란 변수가 있는데 이 값들은 모두 옵션 값이라고 해봅시다.

OR ||을 사용하면 실제 값이 들어있는 변수를 찾고, 그 값을 보여줄 수 있습니다. 
변수 모두에 값이 없는 경우엔 익명를 보여줍시다.

let firstName = "";
let lastName = "";
let nickName = "바이올렛";

alert( firstName || lastName || nickName || "익명"); // 바이올렛
모든 변수가 falsy이면 "익명"이 출력되었을 겁니다.

단락 평가

OR 연산자 ||가 제공하는 또 다른 기능은 '단락 평가(short circuit evaluation)'입니다.

위에서 설명해 드린 바와 같이 OR||은 왼쪽부터 시작해서 오른쪽으로 평가를 진행하는데, 
truthy를 만나면 나머지 값들은 건드리지 않은 채 평가를 멈춥니다. 이런 프로세스를 '단락 평가’라고 합니다.

단락 평가의 동작 방식은 두 번째 피연산자가 변수 할당과 
같은 부수적인 효과(side effect)를 가지는 표현식 일 때 명확히 볼 수 있습니다.

아래 예시를 실행하면 두 번째 메시지만 출력됩니다.

true || alert("not printed");
false || alert("printed");
첫 번째 줄의 || 연산자는 true를 만나자마자 평가를 멈추기 때문에 alert가 실행되지 않습니다.

단락 평가는 연산자 왼쪽 조건이 falsy일 때만 명령어를 실행하고자 할 때 자주 쓰입니다.
```

# 첫 번째 falsy를 찾는 AND 연산자 ‘&&’
```javascript
AND 연산자와 피연산자가 여러 개인 경우를 살펴봅시다.

result = value1 && value2 && value3;
AND 연산자 &&는 아래와 같은 순서로 동작합니다.

가장 왼쪽 피연산자부터 시작해 오른쪽으로 나아가며 피연산자를 평가합니다.
각 피연산자는 불린형으로 변환됩니다. 변환 후 값이 false이면 평가를 멈추고 해당 피연산자의 변환 전 원래 값을 반환합니다.
피연산자 모두가 평가되는 경우(모든 피연산자가 true로 평가되는 경우)엔 마지막 피연산자가 반환됩니다.
정리해 보자면 이렇습니다. AND 연산자는 첫 번째 falsy를 반환합니다. 피연산자에 falsy가 없다면 마지막 값을 반환합니다.

위 알고리즘은 OR 연산자의 알고리즘과 유사합니다. 차이점은 AND 연산자가 첫 번째 falsy를 반환하는 반면, OR은 첫 번째 truthy를 반환한다는 것입니다.

예시:

// 첫 번째 피연산자가 truthy이면,
// AND는 두 번째 피연산자를 반환합니다.
alert( 1 && 0 ); // 0
alert( 1 && 5 ); // 5

// 첫 번째 피연산자가 falsy이면,
// AND는 첫 번째 피연산자를 반환하고, 두 번째 피연산자는 무시합니다.
alert( null && 5 ); // null
alert( 0 && "아무거나 와도 상관없습니다." ); // 0
AND 연산자에도 피연산자 여러 개를 연속해서 전달할 수 있습니다. 첫 번째 falsy가 어떻게 반환되는지 예시를 통해 살펴봅시다.

alert( 1 && 2 && null && 3 ); // null
아래 예시에선 AND 연산자의 피연산자가 모두 truthy이기 때문에 마지막 피연산자가 반환됩니다.

alert( 1 && 2 && 3 ); // 마지막 값, 3
&&의 우선순위가 ||보다 높습니다.
AND 연산자 &&의 우선순위는 OR 연산자 ||보다 높습니다.

따라서 a && b || c && d는 (a && b) || (c && d)와 동일하게 동작합니다.

if를 ||나 &&로 대체하지 마세요.
어떤 개발자들은 AND 연산자 &&를 if문을 ‘짧게’ 줄이는 용도로 사용하곤 합니다.

예시:

let x = 1;

(x > 0) && alert( '0보다 큽니다!' );
&&의 오른쪽 피연산자는 평가가 && 우측까지 진행되어야 실행됩니다. 즉, (x > 0)이 참인 경우에만 alert문이 실행되죠.

위 코드를 if 문을 써서 바꾸면 다음과 같습니다.

let x = 1;

if (x > 0) alert( '0보다 큽니다!' );
&&를 사용한 코드가 더 짧긴 하지만 if문을 사용한 예시가 코드에서 무엇을 구현하고자 하는지 
더 명백히 드러내고, 가독성도 좋습니다. 그러니 if 조건문이 필요하면 if를 사용하고 AND 연산자는 연산자 목적에 맞게 사용합시다.
```

# NOT 연산자는 인수를 하나만 받고, 다음 순서대로 연산을 수행합니다.
```javascript
피연산자를 불린형(true / false)으로 변환합니다.
1에서 변환된 값의 역을 반환합니다.
예시:

alert( !true ); // false
alert( !0 ); // true
NOT을 두 개 연달아 사용(!!)하면 값을 불린형으로 변환할 수 있습니다.

alert( !!"non-empty string" ); // true
alert( !!null ); // false
이때, 첫 번째 NOT 연산자는 피연산자로 받은 값을 불린형으로 변환한 후 이 값의 역을 반환하고, 
두 번째 NOT 연산자는 첫 번째 NOT 연산자가 반환한 값의 역을 반환합니다. 
이렇게 NOT을 연달아 사용하면 특정 값을 불린형으로 변환할 수 있습니다.

참고로, 내장 함수 Boolean을 사용하면 !!을 사용한 것과 같은 결과를 도출할 수 있습니다.

alert( Boolean("non-empty string") ); // true
alert( Boolean(null) ); // false
NOT 연산자의 우선순위는 모든 논리 연산자 중에서 가장 높기 때문에 항상 &&나 || 보다 먼저 실행됩니다.
```

# [null 병합 연산자](https://ko.javascript.info/nullish-coalescing-operator)
``` javascript
null 병합 연산자(nullish coalescing operator) ??를 사용하면 
짧은 문법으로 여러 피연산자 중 그 값이 ‘확정되어있는’ 변수를 찾을 수 있습니다.

a ?? b의 평가 결과는 다음과 같습니다.

a가 null도 아니고 undefined도 아니면 a
그 외의 경우는 b
null 병합 연산자 ??없이 x = a ?? b와 동일한 동작을 하는 코드를 작성하면 다음과 같습니다.

x = (a !== null && a !== undefined) ? a : b;
비교 연산자와 논리 연산자만으로 null 병합 연산자와 같은 기능을 하는 코드를 
작성하니 코드 길이가 길어지네요.

또 다른 예시를 살펴봅시다. firstName, lastName, nickName이란 변수에 
사용자 이름이나 별명을 저장하는데, 사용자가 아무런 정보도 입력하지 않는 케이스도 허용한다고 해보겠습니다.

화면엔 세 변수 중 실제 값이 있는 변수의 값을 출력하는데, 
세 변수 모두 값이 없다면 '익명의 사용자’가 출력되도록 해보죠.

이럴 때 null 병합 연산자 ??를 사용하면 값이 정해진 변수를 간편하게 찾아낼 수 있습니다.

let firstName = null;
let lastName = null;
let nickName = "바이올렛";

// null이나 undefined가 아닌 첫 번째 피연산자
alert(firstName ?? lastName ?? nickName ?? "익명의 사용자"); // 바이올렛
'??'와 '||'의 차이
null 병합 연산자는 OR 연산자 ||와 상당히 유사해 보입니다. 
실제로 위 예시에서 ??를 ||로 바꿔도 그 결과는 동일하기까지 하죠. 
관련 내용은 이전 챕터에서 살펴본 바 있습니다.

그런데 두 연산자 사이에는 중요한 차이점이 있습니다.

||는 첫 번째 truthy 값을 반환합니다.
??는 첫 번째 정의된(defined) 값을 반환합니다.
null과 undefined, 숫자 0을 구분 지어 다뤄야 할 때 이 차이점은 매우 중요한 역할을 합니다.

예시를 살펴봅시다.

height = height ?? 100;
height에 값이 정의되지 않은경우 height엔 100이 할당됩니다.

이제 ??와 ||을 비교해봅시다.

let height = 0;

alert(height || 100); // 100
alert(height ?? 100); // 0
height || 100은 height에 0을 할당했지만 0을 falsy 한 값으로 취급했기 때문에 
null이나 undefined를 할당한 것과 동일하게 처리합니다. 따라서 height || 100의 평가 결과는 100입니다.

반면 height ?? 100의 평가 결과는 height가 정확하게 null이나 undefined일 
경우에만 100이 됩니다. 예시에선 height에 0이라는 값을 할당했기 때문에 얼럿창엔 0이 출력됩니다.

이런 특징 때문에 높이처럼 0이 할당될 수 있는 변수를 사용해 기능을 개발할 땐 ||보다 ??가 적합합니다.
```

# concentration
* console.log('string: ${1+2}');

# increment and decrement operators
* ++
* --

# assignment operators
* x+=y

# comparision operators
* > <

# Logical operatioors
* ||
  * 연산이 복잡한 것을 뒤에 위치

## nullableObject


# [equality](https://www.youtube.com/watch?v=YBjufjBaxHo&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=4)
* [Equality table](https://dorey.github.io/JavaScript-Equality-Table/)
* ==(loose equality)
  * with type conversion

* ===(strct equality)
  * no type conversion


# Ternary opertor: ?
* console.log(name === 'ellie' ? 'yes' : 'no');


# switch


# loops


# +연산자
```javascript
직접 실행해보면 아시겠지만 foo의 값은 1020이 나오게 됩니다.

그 이유는 자바스크립트에서 + 연산자는 문자열을 합치는 concat 기능이 있고 그것을 먼저 고려하기 때문입니다.

+, -, *, / 의 사칙연산중 오직 +만 양쪽 피연산자 중 한쪽에 문자열이 존재할 때 다른 한쪽도 문자열로 바꾸어버립니다.

나머지 연산들은 문자열과 함께 엮였을 때 다른 한쪽에 Number 형변환을 적용하여 연산합니다.
```


# 소수 덧셈
```javascript

Q: (0.1 + 0.2) == 0.3의 결과는 무엇일까요

(0.1 + 0.2) == 0.3 //?
A:
정답은 false입니다.

자바스크립트는 double-precision 64-bit binary format IEEE 754의 형태로 숫자를 저장합니다.

기본적으로 이진수로 숫자를 저장하는데, 소수를 저장할 때는 가끔 이진수로 완전하게 표현이 불가능한 소수들이 있습니다.

예를 들면 10진수 0.2는 2진수로 표현하려 해도 대략적으로 0.0011 0011 0011...의 반복으로만 표현할 수 있을 뿐 정확히 표현이 불가능합니다.

이러한 특성 덕에 0.1 + 0.2이 올바르게 계산되지 못하고 0.3과 같지도 않다고 나옵니다.

올바른 결과를 위해서는
1. 소수점 반올림 함수를 이용하여도 되고
2. 소수에 10을 곱해 10진수로 만든 뒤에 계산 후 다시 소수로 만드는 방법이 있습니다.

IEEE 754의 내부 구조는
Sign bit: 1 bit
Exponent: 11 bits
Significand precision: 53 bits (52 explicitly stored)
위와 같이 이루어져있습니다.
```
