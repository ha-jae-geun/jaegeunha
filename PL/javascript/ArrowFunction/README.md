# [javainfo 화살표 함수](https://ko.javascript.info/arrow-functions)
# [Arrow Function 사용하는 이유](https://blog.rhostem.com/posts/2020-04-14-fe-interview-handbook-js-3)

# this
* 일반 함수는 함수를 선언할 때 this에 바인딩할 객체가 정적으로 결정되는 것이 아니고, 함수를 호출할 때 함수가 어떻게 호출되었는지에 따라 this에 바인딩할 객체가 동적으로 결정된다고 하였다.
* 화살표 함수는 함수를 선언할 때 this에 바인딩할 객체가 정적으로 결정된다. 동적으로 결정되는 일반 함수와는 달리 화살표 함수의 this 언제나 상위 스코프의 this를 가리킨다. 이를 Lexical this라 한다. 
* 화살표 함수는 앞서 살펴본 Solution 3의 Syntactic sugar이다.


# [화살표 함수 주의할점](https://poiemaweb.com/es6-arrow-function)
