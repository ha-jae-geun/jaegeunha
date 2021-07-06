# [globalThis](https://ko.javascript.info/global-object)
```javascript
브라우저에서 let이나 const가 아닌 
var로 선언한 전역 함수나 전역 변수는 전역 객체의 프로퍼티가 됩니다.

var gVar = 5;

alert(window.gVar); // 5 (var로 선언한 변수는 전역 객체 window의 프로퍼티가 됩니다)
하위 호환성 때문에 이런 방식으로 전역 객체를 사용해도 동작은 하지만, 
이 방법은 쓰지 않으시길 바랍니다. 
모듈을 사용하는 모던 자바스크립트는 이런 방식을 지원하지 않습니다.

var 대신 let을 사용하면 위 예시와는 달리 전역 객체를 통해 변수에 접근할 수 없습니다.

let gLet = 5;

alert(window.gLet); // undefined (let으로 선언한 변수는 전역 객체의 프로퍼티가 되지 않습니다.)
중요한 변수라서 모든 곳에서 사용할 수 있게 하려면, 
아래와 같이 전역 객체에 직접 프로퍼티를 추가해 주시기 바랍니다.

// 모든 스크립트에서 현재 사용자(current user)에 접근할 수 있게 이를 전역 객체에 추가함
window.currentUser = {
  name: "John"
};

// 아래와 같은 방법으로 모든 스크립트에서 currentUser에 접근할 수 있음
alert(currentUser.name);  // John

// 지역 변수 'currentUser'가 있다면
// 지역 변수와 충돌 없이 전역 객체 window에서 이를 명시적으로 가져올 수 있음
alert(window.currentUser.name); // John
전역 변수는 되도록 사용하지 않는 것이 좋습니다. 

함수를 만들 땐 외부 변수나 전역 변수를 사용하는 것보다 
‘인풋’ 변수를 받고 이를 이용해 '아웃풋’을 만들어내게 해야 테스트도 쉽고, 에러도 덜 만들어냅니다.
```
