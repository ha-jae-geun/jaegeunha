# [실행 컨텍스트](https://mingcoder.me/2020/02/28/Programming/JavaScript/execute-context/)

# [제로조 실행 컨텍스트](https://www.zerocho.com/category/JavaScript/post/5741d96d094da4986bc950a0)


# 실행 컨텍스트 (Execution Context)란?
* 자바스크립트의 코드들이 실행되기 위환 환경이다.
* 전역 컨텍스트와 함수 컨텍스트 2가지가 존재한다.
* 전역 컨텍스트 생성 후에 함수가 호출할 때마다 함수 컨텍스트가 생성된다.
* 컨텍스트 생성 시 변수객체, 스코프 체인, this가 생성된다.
* 컨텍스트 생성 후 함수에 사용되는 변수들은 변수 객체 안에서 값을 찾고, 없다면 스코프 체인을 따라 올라가며 찾는다.
* 함수 실행이 마무리 되면 해당 컨텍스트는 사라지고, 페이지가 종료되면 전역 컨텍스트 사라진다.
* 즉 JS의 코드가 실행되기 위해서는 변수객체, 스코프체인, this 정보들을 담고 있는 곳을 실행컨텍스트라고 한다.


# [함수의 숨김 프로퍼티 environment와 closure](https://ko.javascript.info/closure)
