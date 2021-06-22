# [this란?](https://www.zerocho.com/category/JavaScript/post/5b0645cc7e3e36001bf676eb)
```java
* 생성자로 함수를 호출하는 경우 this는 생성되는 self 객체를 가리킵니다.
* apply, call, bind를 사용하는 경우 this는 호출 시 바인딩 시킨 객체입니다.
* object.method()와 같이 호출하는 경우, this는 함수가 속한 객체입니다.
* 엄격 모드인 ('use strict') 경우 this는 전역 객체 대신 undefined가 됩니다.
* 함수가 ES2015의 화살표 함수인 경우, 상위 스코프의 객체를 받게됩니다.
* 이 외의 경우 this는 window객체로 보면 됩니다.

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
