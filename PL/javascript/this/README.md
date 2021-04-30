# [this란?](https://www.zerocho.com/category/JavaScript/post/5b0645cc7e3e36001bf676eb)
```java
* 생성자로 함수를 호출하는 경우 this는 생성되는 self 객체를 가리킵니다.
* apply, call, bind를 사용하는 경우 this는 호출 시 바인딩 시킨 객체입니다.
* object.method()와 같이 호출하는 경우, this는 함수가 속한 객체입니다.
* 엄격 모드인 ('use strict') 경우 this는 전역 객체 대신 undefined가 됩니다.
* 함수가 ES2015의 화살표 함수인 경우, 상위 스코프의 객체를 받게됩니다.
* 이 외의 경우 this는 window객체로 보면 됩니다.

```

# this와 $(this)의 차이
```java
[this - Javascript]
Javascript의 경우에는 이벤트가 발생한 태그 요소가 표시됩니다!

[ $(this) - Jquery]
Jquery의 경우에는 이벤트가 발생한 요소의 정보들이 Object로 표시됩니다!
```
