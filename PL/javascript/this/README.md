# [this란?](https://www.zerocho.com/category/JavaScript/post/5b0645cc7e3e36001bf676eb)
```java
* 생성자로 함수를 호출하는 경우 this는 생성되는 self 객체를 가리킵니다.
* apply, call, bind를 사용하는 경우 this는 호출 시 바인딩 시킨 객체입니다.
* object.method()와 같이 호출하는 경우, this는 함수가 속한 객체입니다.
* 엄격 모드인 ('use strict') 경우 this는 전역 객체 대신 undefined가 됩니다.
* 함수가 ES2015의 화살표 함수인 경우, 상위 스코프의 객체를 받게됩니다.
* 이 외의 경우 this는 window객체로 보면 됩니다.

```

# [5가지 상황에서의 this](https://beomy.tistory.com/6)
```javascript
this가 만들어지는 경우,

1. 일반 함수에서 this -> window

2. 중첩 함수에서 this -> window

3. 이벤트에서 this -> 이벤트 객체

4. 메소드에서 this -> 메소드 객체

5. 메소드 내부의 중첩 함수에서 this -> window

```

# [객체의 내부 함수에서 this](https://wormwlrm.github.io/2019/03/04/You-should-know-JavaScript-this.html)

# this와 $(this)의 차이
```java
[this - Javascript]
Javascript의 경우에는 이벤트가 발생한 태그 요소가 표시됩니다!

[ $(this) - Jquery]
Jquery의 경우에는 이벤트가 발생한 요소의 정보들이 Object로 표시됩니다!
```


# [call, apply 차이](https://velog.io/@chris/front-end-interview-handbook-js-1#foreach-%EB%A3%A8%ED%94%84%EC%99%80-map-%EB%A3%A8%ED%94%84-%EC%82%AC%EC%9D%B4%EC%9D%98-%EC%A3%BC%EC%9A%94-%EC%B0%A8%EC%9D%B4%EC%A0%90%EC%9D%84-%EC%84%A4%EB%AA%85%ED%95%A0-%EC%88%98-%EC%9E%88%EB%82%98%EC%9A%94-%EC%99%9C-%EB%91%98-%EC%A4%91-%ED%95%98%EB%82%98%EB%A5%BC-%EC%84%A0%ED%83%9D%ED%95%A0-%EA%B2%83%EC%9D%B8%EA%B0%80%EC%9A%94)
```javascript
.call과 .apply의 차이점은 무엇인가요?
.call과 .apply는 모두 함수를 호출하는데 사용되며, 첫 번째 매개변수는 함수 내에서 this의 값으로 사용됩니다. 

그러나 .call은 쉼표로 구분된 인수를 두 번째 인수로 취하고 .apply는 인수의 배열을 두 번째 인수로 취합니다. 
call은 C: Comma 로 구분되며, apply는 인수 배열인 A: arguments 라고 기억하면 쉽습니다.
```

# [new 연산자와 생성자](https://ko.javascript.info/constructor-new)

생성자 함수(짧게 줄여서 생성자)는 일반 함수입니다. 
다만, 일반 함수와 구분하기 위해 함수 이름 첫 글자를 대문자로 씁니다.
생성자 함수는 반드시 new 연산자와 함께 호출해야 합니다. 
new와 함께 호출하면 내부에서 this가 암시적으로 만들어지고, 마지막엔 this가 반환됩니다.
생성자 함수는 유사한 객체를 여러 개 만들 때 유용합니다.

# 생성자와 return문
```javascript
생성자 함수엔 보통 return 문이 없습니다. 
반환해야 할 것들은 모두 this에 저장되고, 
this는 자동으로 반환되기 때문에 반환문을 명시적으로 써 줄 필요가 없습니다.

그런데 만약 return 문이 있다면 어떤 일이 벌어질까요? 
아래와 같은 간단한 규칙이 적용됩니다.

객체를 return 한다면 this 대신 객체가 반환됩니다.
원시형을 return 한다면 return문이 무시됩니다.
return 뒤에 객체가 오면 생성자 함수는 해당 객체를 반환해주고, 
이 외의 경우는 this가 반환되죠.

아래 예시에선 첫 번째 규칙이 적용돼 return은 this를 무시하고 객체를 반환합니다.

function BigUser() {

  this.name = "원숭이";

  return { name: "고릴라" };  // <-- this가 아닌 새로운 객체를 반환함
}

alert( new BigUser().name );  // 고릴라
아무것도 return하지 않는 예시를 살펴봅시다. 
원시형을 반환하는 경우와 마찬가지로 두 번째 규칙이 적용됩니다.

function SmallUser() {

  this.name = "원숭이";

  return; // <-- this를 반환함
}

alert( new SmallUser().name );  // 원숭이
return문이 있는 생성자 함수는 거의 없습니다. 
여기선 튜토리얼의 완성도를 위해 특이 케이스를 소개해보았습니다.

괄호 생략하기
인수가 없는 생성자 함수는 괄호를 생략해 호출할 수 있습니다.

let user = new User; // <-- 괄호가 없음
// 아래 코드는 위 코드와 똑같이 동작합니다.
let user = new User();
명세서엔 괄호를 생략해도 된다고 정의되어 있지만, '좋은 스타일’은 아닙니다.
```
