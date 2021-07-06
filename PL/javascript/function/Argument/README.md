# [argument](https://gunnkimkr.github.io/posts/javascript-functions-parameter/)
```javascript
Ⅰ. 함수의 매개변수
1. 매개변수
function sum() {
  let total = 0;

  for(arg in arguments) {
    total += arguments[arg];
  }
  console.log(total);
}

sum(10, 5); // 15
sum(10, ' 더하기 ', 5, '는?'); // 10 더하기 5는?
sum함수의 매개변수를 선언하지 않았지만 sum함수를 호출할 때 여러 개의 인자를 매개변수로 넘겼다.

하지만 인터프리터는 에러로 판단하지 않으며, 프로그램은 정상적으로 동작한다.

이는 자바스크립트의 언어의 특징으로 함수 시그니처를 약타입으로 정의하기 때문에 함수에 
선언된 매개변개수나 타입에 상관없이 인자로 값을 전달할 수 있다.

자바스크립트의 매개변수는 다음과 같은 특징이 있다.

자바스크립트 함수의 매개변수는 내부적으로 배열로 표현되기 때문에 함수 시그니처를 만들고 
매개변수의 개수나 타입을 체크하지 않는다.1
매개변수는 함수 내부에서 arguments라는 객체를 통해 매개변수의 값에 접근할 수 있다.
2. arguments 객체
function sum(num1, num2, num3) {

   if(arguments.length == 1) {
       console.log(arguments[0] + 10);
   } else if (arguments.length == 2) {
     console.log(arguments[0] + arguments[1]);
   } else if (arguments.length == 3) {
     console.log(arguments[0] + arguments[1] + num3);
   }
}

sum(10); // 20
sum(10, 5); // 15
sum(10, 5, 15); // 30
매개변수로 전달된 인자가 1개이면 if문이 실행되고, 2개 또는 3개이면 else if문이 실행된다.

arguments 객체를 사용해 num1, num2, num3 변수의 값에 접근했다.

이런 자바스크립트 언어의 특징을 이용하면 내부적으로 매개변수의 개수나 타입을 체크하지 않더라도 
오버로딩과 비슷하게 동작하는 함수를 만들 수 있다.

arguments 객체는 다음과 같은 특징이 있다.

arguments는 [] 표기법으로 매개변수 값에 접근할 수 있다.
매개변수명 대신에 arguments를 사용할 수 있고, 혼용해서 사용할 수도 있다.
arguments.length로 매개변수의 개수를 알 수 있어 배열처럼 동작하지만 Array의 인스턴스는 아니다.
n 번째 매개변수의 값과 n 번째 argument[n] 값은 서로 대응 관계이기 때문에 
어느 한쪽에 값이 바뀌면 다른 한쪽에서도 값이 바뀐다. 
하지만 같은 메모리 공간을 사용하는 것은 아니다.
strict mode에서 n번째 매개변수의 값과 argument[n] 값은 서로 대응하지 않는다.
- 4번 특징 예시

function sum(num1, num2) {
  arguments[0] = 20;

  console.log(num1, num2);
  console.log(arguments[0], num2);
  num1 = 10;
  console.log(arguments[0], num2);
}

sum(10, 20);
// 20 20
// 20 20
// 10 20
non-strict mode에서 arguments[0]값과 num1값은 서로 대응하기 때문에 어느 쪽에서 값이 바뀌면 다른 한쪽에도 바뀐 값이 반영된다.

하지만 strict mode에서는 두 값이 서로 대응하지 않는다.

- 5번 특징 예시

"use strict" // Using strict mode

function sum(num1, num2) {
  arguments[0] = 20;

  console.log(num1, num2);
  console.log(arguments[0], num2);
  num1 = 10;
  console.log(arguments[0], num2);
}

sum(10, 20);
// 10 20
// 20 20
// 20 20
strict mode를 선언했기 때문에 arguments[0] 값과 num1 값은 서로 대응하지 않는다.

arguments 객체에는 값을 재할당하는 것이 가능하다.

단, strict mode에서는 에러를 발생시킨다.

function sum(num1, num2) {
  arguments = [20, 30];
  console.log(arguments[0], arguments[1]);
}

sum(10, 20);
// 20 30
각주
자바스크립트의 함수 시그니처(signature)는 약타입(loosely typed)으로 정의한다
```

# [...](https://ko.javascript.info/rest-parameters-spread)
```javascript
요약
"..."은 나머지 매개변수나 전개 문법으로 사용됩니다.

나머지 매개변수와 전개 문법은 아래의 방법으로 구분할 수 있습니다.

...이 함수 매개변수의 끝에 있으면 인수 목록의 나머지를 배열로 모아주는 '나머지 매개변수’입니다.
...이 함수 호출 시 사용되면 배열을 목록으로 확장해주는 '전개 문법’입니다.
사용 패턴:

인수 개수에 제한이 없는 함수를 만들 때 나머지 매개변수를 사용합니다.
다수의 인수를 받는 함수에 배열을 전달할 때 전개 문법을 사용합니다.
둘을 함께 사용하면 매개변수 목록과 배열 간 전환을 쉽게 할 수 있습니다.

조금 오래된 방법이긴 하지만 arguments라는 반복 가능한 유사 배열 객체를 사용해도 인수 모두를 사용할 수 있
```

# [call, apply, bind](https://www.zerocho.com/category/JavaScript/post/57433645a48729787807c3fd)

# 유사배열
* 위 메소드들을 쓰는 예로, 함수의 arguments를 조작할 때 사용합니다. arguments는 함수라면 처음부터 갖고 있는 숨겨진 속성인데요. 
* 바로 함수에 들어온 인자를 배열 형식으로(배열은 아닙니다. 유사 배열이라고 부릅니다.) 반환합니다.

# arguments
```javascript
‘arguments’ 변수
arguemnts라는 특별한 유사 배열 객체(array-like object)를 이용하면 인덱스를 사용해 모든 인수에 접근할 수 있습니다.

예시:

function showName() {
  alert( arguments.length );
  alert( arguments[0] );
  alert( arguments[1] );

  // arguments는 이터러블 객체이기 때문에
  // for(let arg of arguments) alert(arg); 를 사용해 인수를 나열할 수 있습니다.
}

// 2, Julius, Caesar가 출력됨
showName("Julius", "Caesar");

// 1, Bora, undefined가 출력됨(두 번째 인수는 없음)
showName("Bora");
나머지 매개변수는 비교적 최신의 문법입니다. 과거엔 함수의 인수 전체를 
얻어내는 방법이 arguments를 사용하는 것밖에 없었습니다. 
물론 지금도 arguments를 사용할 수 있습니다. 오래된 코드를 보다 보면 arguments를 만나게 되죠.

arguments는 유사 배열 객체이면서 이터러블(반복 가능한) 객체입니다. 
어쨌든 배열은 아니죠. 따라서 배열 메서드를 사용할 수 없다는 단점이 있습니다. 
arguments.map (...)을 호출할 수 없죠.

여기에 더하여 arguments는 인수 전체를 담기 때문에 
나머지 매개변수처럼 인수의 일부만 사용할 수 없다는 단점도 있습니다.

따라서 배열 메서드를 사용하고 싶거나 인수 일부만 사용하고자 할 때는 
나머지 매개변수를 사용하는 것이 좋습니다.

화살표 함수에는 \'arguments\'가 없습니다.
화살표 함수에서 arguments 객체에 접근하면, 외부에 있는 ‘일반’ 함수의 arguments 객체를 가져옵니다.

예시:

function f() {
  let showArg = () => alert(arguments[0]);
  showArg();
}

f(1); // 1
앞서 배운 바와 같이 화살표 함수는 자체 this를 가지지 않습니다. 
여기에 더하여 arguments 객체도 없다는 것을 위 예시를 통해 확인해 보았습니다.
```

# 나머지
```javascript
나머지 매개변수는 항상 마지막에 있어야 합니다.
나머지 매개변수는 남아있는 인수를 모으는 역할을 하므로 아래 예시에선 에러가 발생합니다.

function f(arg1, ...rest, arg2) { // ...rest 후에 arg2가 있으면 안 됩니다.
  // 에러
}
...rest는 항상 마지막에 있어야 합니다.
```

