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
