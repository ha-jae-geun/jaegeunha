# 익명함수
```javascript
🌟 함수를 작성할 때 언제 (;) 세미콜론을 붙이고 언제 안 붙일까
=> 일반적으로 함수 선언문 방식으로 선언된 함수의 경우 ; 를 붙이지 않고, 함수 표현식으로 생성된 경우 ; 를 붙입니다.

함수 선언문으로 만들기

function add(x, y) {
   return x + y;
}
객체 리터럴 {}, 배열 리터럴 [] 과 같은 맥락으로 함수도 위와 같은 형태의 코드로
함수 리터럴을 이용해 생성할 수 있습니다. 위 코드에서 add라는 함수명이 존재하지 않는 경우를 익명 함수라고 합니다.

함수 선언문 생성 방식은 반드시 함수명이 정의되어 있어야 한다는 특징이 있습니다.

함수 표현식으로 만들기

// 1
var add = function(x, y) {
   return x + y;
};

// 2
var add = function sum(x, y) {
   return x + y;
};



  1. 선언적 함수 : 함수에 이름이 있는 함수로 호이스팅의 대상이 된다.(호이스팅은 별도로 정리)

      function circle(radius){

        ~~

        return something;

      }

    2. 익명 함수 : 함수에 이름이 없어 주로 변수에 대입해서 사용하는 함수(호이스팅의 대상이 되지 않음)

                    -> 따라서 순차적으로 수행되기 때문에 요즘은 익명함수로 선언하는 것이 추천됨.

      var anonymousFunc = function(raidus){

        ~~

        return something;

      }

    3. 람다 함수 : 일회성으로 사용하기 위한 목적으로 사용되는 함수

      (function(radius){

        ~~

        return something;

      })(25)

```
