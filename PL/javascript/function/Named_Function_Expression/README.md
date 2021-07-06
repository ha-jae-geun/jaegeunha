# [NFE](https://ko.javascript.info/function-object)
```javascript
기명 함수 표현식
기명 함수 표현식(Named Function Expression, NFE)은 이름이 있는 함수 표현식을 나타내는 용어입니다.

먼저, 일반 함수 표현식을 살펴봅시다.

let sayHi = function(who) {
  alert(`Hello, ${who}`);
};
여기에 이름을 붙여보겠습니다.

let sayHi = function func(who) {
  alert(`Hello, ${who}`);
};
이렇게 이름을 붙인다고 해서 뭐가 달라지는 걸까요? "func"이라는 이름은 어떤 경우에 붙이는 걸까요?

먼저 이렇게 이름을 붙여도 위 함수는 여전히 함수 표현식이라는 점에 주목해야 합니다. 
function 뒤에 "func"이라는 이름을 붙이더라도 여전히 표현식을 할당한 형태를 유지하기 때문에 함수 선언문으로 바뀌지 않습니다.

이름을 추가한다고 해서 기존에 동작하던 기능이 동작하지 않는 일은 발생하지 않습니다.

sayHi()로 호출하는 것도 여전히 가능합니다.

let sayHi = function func(who) {
  alert(`Hello, ${who}`);
};

sayHi("John"); // Hello, John
대신 func과 같은 이름을 붙이면 두 가지가 변화가 생깁니다. 이 두 변화 때문에 기명 함수 표현식을 사용하는 것이죠.

이름을 사용해 함수 표현식 내부에서 자기 자신을 참조할 수 있습니다.
기명 함수 표현식 외부에선 그 이름을 사용할 수 없습니다.
함수 sayHi를 예시로 이에 대해 살펴봅시다. 함수 sayHi는 who에 값이 없는 경우, 인수 "Guest"를 받고 자기 자신을 호출합니다.

let sayHi = function func(who) {
  if (who) {
    alert(`Hello, ${who}`);
  } else {
    func("Guest"); // func를 사용해서 자신을 호출합니다.
  }
};

sayHi(); // Hello, Guest

// 하지만 아래와 같이 func를 호출하는 건 불가능합니다.
func(); // Error, func is not defined (기명 함수 표현식 밖에서는 그 이름에 접근할 수 없습니다.)
그런데 여기서 왜 중첩 호출을 할 때 sayHi대신 func을 사용했을까요?

사실 대부분의 개발자는 아래와 같이 코드를 작성하곤 합니다.

let sayHi = function(who) {
  if (who) {
    alert(`Hello, ${who}`);
  } else {
    sayHi("Guest");
  }
};
하지만 이렇게 코드를 작성하면 외부 코드에 의해 sayHi가 변경될 수 있다는 문제가 생깁니다. 
함수 표현식을 새로운 변수에 할당하고, 기존 변수에 null을 할당하면 에러가 발생하죠.

let sayHi = function(who) {
  if (who) {
    alert(`Hello, ${who}`);
  } else {
    sayHi("Guest"); // TypeError: sayHi is not a function
  }
};

let welcome = sayHi;
sayHi = null;

welcome(); // 중첩 sayHi 호출은 더 이상 불가능합니다!
에러는 함수가 sayHi를 자신의 외부 렉시컬 환경에서 가지고 오기 때문에 발생합니다. 
지역(local) 렉시컬 환경엔 sayHi가 없기 때문에 외부 렉시컬 환경에서 sayHi를 찾는데, 
함수 호출 시점에 외부 렉시컬 환경의 sayHi엔 null이 저장되어있기 때문에 에러가 발생합니다.

함수 표현식에 이름을 붙여주면 바로 이런 문제를 해결할 수 있습니다.

코드를 수정해 봅시다.

let sayHi = function func(who) {
  if (who) {
    alert(`Hello, ${who}`);
  } else {
    func("Guest"); // 원하는 값이 제대로 출력됩니다.
  }
};

let welcome = sayHi;
sayHi = null;

welcome(); // Hello, Guest (중첩 호출이 제대로 동작함)
"func"이라는 이름은 함수 지역 수준(function-local)에 존재하므로 외부 렉시컬 환경에서 찾지 않아도 됩니다. 
외부 렉시컬 환경에선 보이지도 않죠.
함수 표현식에 붙인 이름은 현재 함수만 참조하도록 명세서에 정의되어있기 때문입니다.

이렇게 기명 함수 표현식을 이용하면 sayHi나 welcome 같은 외부 변수의 변경과 관계없이
func이라는 '내부 함수 이름’을 사용해 언제든 함수 표현식 내부에서 자기 자신을 호출할 수 있습니다.

함수 선언문엔 내부 이름을 지정할 수 없습니다.
지금까지 살펴본 '내부 이름’은 함수 표현식에만 사용할 수 있고, 함수 선언문엔 사용할 수 없습니다.
함수 선언문엔 ‘내부’ 이름을 지정할 수 있는 문법이 없습니다.

개발을 하다 보면 믿을만한 내부 이름이 필요할 때가 생기곤 합니다. 
이 때 바로 함수 선언문을 기명 함수 표현식으로 다시 정의하면 됩니다.
```
