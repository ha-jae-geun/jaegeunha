# [함수의 범위](https://www.zerocho.com/category/JavaScript/post/5740531574288ebc5f2ba97e)

# [함수 표현식, 선언식](https://joshua1988.github.io/web-development/javascript/function-expressions-vs-declarations/)

# 끝에 세미 콜론은 왜 있나요?
      함수 표현식의 끝에 왜 세미 콜론 ;이 붙는지 의문이 들 수 있습니다. 함수 선언문에는 세미 콜론이 없는데 말이죠.

      function sayHi() {
        // ...
      }

      let sayHi = function() {
        // ...
      };
      이유는 간단합니다.

      if { ... }, for { }, function f { } 같이 중괄호로 만든 코드 블록 끝엔 ;이 없어도 됩니다.
      함수 표현식은 let sayHi = ...;과 같은 구문 안에서 값의 역할을 합니다. 코드 블록이 아니고 값처럼 취급되어 변수에 할당되죠. 모든 구문의 끝엔 세미 콜론 ;을 붙이는 게 좋습니다. 함수 표현식에 쓰인 세미 콜론은 함수 표현식 때문에 붙여진 게 아니라, 구문의 끝이기 때문에 붙여졌습니다.


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

    
    4. 기명 함수
    기명 함수 표현 (Named function expression)
기명 함수 표현의 예를 들어보겠습니다.

var x = function square(y) {
   return y * y;
};
console.log(x(2)); // 4
기명 함수 표현
기명 함수 표현



여기서 저는 궁금한 점이 하나 생겼습니다. 기명 함수 표현으로 함수의 이름이 있다면 함수 이름으로 함수 실행이 가능 할까..?

var x = function square(y) {
   return y * y;
};
square(2);
기명 함수 표현
함수이름으로 함수 실행이 되지 않는다



안됩니다.... 그렇다면, 왜 기명 함수 표현을 사용하는 걸까요?



One of the benefit of creating a named function expression is that in case we encounted an error,

the stack trace will contain the name of the function, making it easier to find the origin of the error.



MDS에서는, 장점 하나는 에러가 발생 했을 때, stack trace가 함수의 이름을 포함하여 
출력하기 때문에 에러를 찾기 쉬운 것이 기명 함수 표현의 장점이라고 이야기 함니다.
```

# [즉시 실행 함수를 사용하는 이유](https://beomy.tistory.com/9)

# [iife 4 reasons](https://youtu.be/8GDk8sj0YgQ)

# [iife closure](https://youtu.be/1S8SBDhA7HA)


# return과 값 사이에 절대 줄을 삽입하지 마세요.
      반환하려는 값이 긴 표현식인 경우, 아래와 같이 지시자 return과 반환하려는 값 사이에 새 줄을 넣어 코드를 작성하고 싶을 수도 있습니다.

      return
       (some + long + expression + or + whatever * f(a) + f(b))
      자바스크립트는 return문 끝에 세미콜론을 자동으로 넣기 때문에 이렇게 return문을 작성하면 안 됩니다. 위 코드는 아래 코드처럼 동작합니다.

      return;
       (some + long + expression + or + whatever * f(a) + f(b))
      따라서 반환하고자 했던 표현식을 반환하지 못하고 아무것도 반환하지 않는 것처럼 되어버립니다.

      표현식을 여러 줄에 걸쳐 작성하고 싶다면 표현식이 return 지시자가 있는 줄에서 시작하도록 작성해야 합니다. 또는 아래와 같이 여는 괄호를 return 지시자와 같은 줄에 써줘도 괜찮습니다.

      return (
        some + long + expression
        + or +
        whatever * f(a) + f(b)
        )
      이렇게 하면 의도한 대로 표현식을 반환할 수 있습니다.
