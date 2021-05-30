# [엘리](https://www.youtube.com/watch?v=YBjufjBaxHo&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=4)

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
