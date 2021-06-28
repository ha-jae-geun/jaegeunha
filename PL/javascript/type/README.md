# [typeof vs Object.protocol.toString.call 차이](https://tonks.tistory.com/218)


# [type conversion](https://ko.javascript.info/type-conversions)

# [number](https://ko.javascript.info/types)
```javascript
let n = 123;
n = 12.345;
숫자형(number type) 은 정수 및 부동소수점 숫자(floating point number)를 나타냅니다.

숫자형과 관련된 연산은 다양한데, 곱셈 *, 나눗셈 /, 덧셈 +, 뺄셈 - 등이 대표적입니다.

숫자형엔 일반적인 숫자 외에 Infinity, -Infinity, NaN같은 '특수 숫자 값(special numeric value)'이 포함됩니다.

Infinity는 어떤 숫자보다 더 큰 특수 값, 무한대(∞)를 나타냅니다.

어느 숫자든 0으로 나누면 무한대를 얻을 수 있습니다.

alert( 1 / 0 ); // 무한대
Infinity를 직접 참조할 수도 있습니다.

alert( Infinity ); // 무한대
NaN은 계산 중에 에러가 발생했다는 것을 나타내주는 값입니다. 
부정확하거나 정의되지 않은 수학 연산을 사용하면 계산 중에 에러가 발생하는데, 이때 NaN이 반환됩니다.

alert( "숫자가 아님" / 2 ); // NaN, 문자열을 숫자로 나누면 오류가 발생합니다.
NaN은 여간해선 바뀌지 않습니다. NaN에 어떤 추가 연산을 해도 결국 NaN이 반환됩니다.

alert( "숫자가 아님" / 2 + 5 ); // NaN
연산 과정 어디에선가 NaN이 반환되었다면, 이는 모든 결과에 영향을 미칩니다.

수학 연산은 안전합니다.
자바스크립트에서 행해지는 수학 연산은 '안전’하다고 볼 수 있습니다.
0으로 나눈다거나 숫자가 아닌 문자열을 숫자로 취급하는 등의 이례적인 연산이 자바스크립트에선 가능합니다.

말이 안 되는 수학 연산을 하더라도 스크립트는 치명적인 에러를 내뿜으며 죽지 않습니다. 
NaN을 반환하며 연산이 종료될 뿐입니다.

현실에선 특수 숫자 값을 숫자로 취급하진 않습니다. 
하지만 자바스크립트에선 특수 숫자 값을 숫자형으로 분류합니다.

숫자를 다루는 방법에 대해선 숫자형 챕터에서 자세히 알아보도록 하겠습니다.
```

## [0.1+0.2](https://velog.io/@coin46/0.1-0.2-0.3)
