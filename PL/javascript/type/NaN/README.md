# NaN
```javascript
숫자형
15; // 15
15.134; // 15.134

010 // 8
0xA // 10

2 ** 9999 // Infinity
(-2) ** 9999 // -Infinity

15.00 // 15

1 * (10 ** 21) // 1e+21
1 / 10000000 // 1e-7

1 / '문자' // NaN
4번 줄은 8진법으로 숫자 8을 표현했다. 8진수는 첫 번째 숫자가 0으로 시작해야 한다.

5번 줄은 16진법으로 숫자 10을 표현했다. 16진수는 0x로 시작해야 한다.

7번과 8번 줄은 ECMAScript로 나타낼 수 있는 숫자 범위를 벗어났기 때문에 양의 무한대 Infinity와 음의 무한대 -Infinity로 결과가 출력됐다.

연산 결과로 Infinity 값을 반환하면 더 이상 연산을 수행할 수 없다.

10번 줄의 부동소수점 15.00과 같이 소수점 이하 숫자가 0이면 정수로 나타낸다.

12번과 13번 줄은 숫자의 크기가 너무 크거나 작기 때문에 지수 표기법으로 나타낸다.

부동소수점의 경우 소수점 이하 숫자의 개수가 7이상이면 지수 표기법으로 변환한다.

자바스크립트의 숫자 자료형은 다음과 같은 특징이 있다.

ECMAScript는 IEEE 754의 64비트 배정밀도 형식을 통해 부동소수점을 나타낸다.1
숫자 리터럴은 기본적으로 10진법을 사용하며, 8진법과 16진법을 사용해 진수를 나타낼 수 있다.
나타낼 수 있는 숫자 범위를 벗어나면 Infinity 또는 -Infinity 값을 반환한다.
부동소수점 숫자를 메모리에 저장할 때 정수 보다 큰 메모리 공간을 사용하기 때문에 소수점 이하 숫자가 0이면 정수로 표현한다.
나타낼 숫자가 너무 크거나 작으면 지수 표기법으로 나타낸다.
부정확한 연산은 NaN 값을 반환한다.
Infinity, -Infinity, NaN의 자료형은 number이다.
⚪️ NaN - Not a Number
숫자형 값 중에 NaN는 숫자를 반환할 것으로 의도한 실행이 실패했을 때 반환하는 값으로 Not a Number의 줄임말이다.

NaN는 에러를 발생시키거나 코드 실행을 멈추지 않기 때문에 어느 단계에서 NaN 값이 반환됐는지 파악하기 어렵다.

let value = 1 / 'string';

if (value == NaN) {
    console.log('숫자가 아님.');
}
1번 줄은 숫자와 문자열의 나눗셈이기 때문에 변수 value에는 NaN의 값이 대입되었다.

변수 value 값이 NaN이면 if문이 실행되기를 기대했지만 if문은 실행되지 않는다.

NaN은 NaN을 포함하여 어떤 값과도 일치하지 않기 때문에 if문이 실행되지 않은 것이다.

☑️ NaN 값 판별
- Number.isNaN

Number.isNaN(NaN); // true
Number.isNaN("NaN"); // false

Number.isNaN(10); // false
Number.isNaN('10'); // false

Number.isNaN('string'); // false
Number.isNaN(true); // false


Number.isNaN({}); // false
Number.isNaN(undefined); // false
Numberl.isNaN 함수는 매개변수 값의 자료형이 number이고 값이 NaN이면 true, 아니면 false를 반환한다.

Number.isNaN 함수를 사용하면 정확하게 NaN 값만 판단할 수 있다.

Object.is 함수를 사용하면 보다 엄격하게 값을 판별할 수 있다.

- Object.is

Object.is(NaN, NaN); // true
Object.is('string', 'string'); // true
Object.is(window, window); // true
Object.is(undefined, undefined); // true

Object.is('string', 'Str'); // false
Object.is({}, {}); // false
Object.is([], []); // false

var obj = { key: 'value' };
Object.is(test, test); // true
Object.is(null, null); // true

Object.is(0, -0); // false
Object.is(-0, -0); // true
Object.is(NaN, 0/0); // true
== 연산은 형 변환 후 값을 비교하고, === 연산은 0과 -0을 같게 여기기 때문에 
정확한 판별이 어려울 수 있지만 Object.is는 엄격한 규칙을 적용하기 때문에 정확한 판별이 가능하다.

다음 조건 중 하나를 만족하면 ture를 반환한다.

두 값이 undefined 일 때
두 값이 null 일 때
두 값이 true 또는 false 일 때
두 값이 같은 문자에 같은 길이인 문자열 일 때
두 값이 같은 객체 일 때
📌 각주
IEEE 754는 IEEE에서 개발한 표준으로 컴퓨터에서 부동소수점을 표현하는 4가지 형식을 정의한다. 
```
