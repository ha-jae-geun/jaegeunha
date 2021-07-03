---
layout: post
toc: true
title: "자바스크립트 변수"
categories: javascript
tags: [javascript]
author:
  - Jack
---

# 변수
## 변수 명명 규칙
* 자바스크립트에선 변수 명명 시 두 가지 제약 사항이 있습니다.

1. 첫 글자는 숫자가 될 수 없습니다.

```javascript
잘못된 변수명의 예시

let 1a; // 변수명은 숫자로 시작해선 안 됩니다.
let my-name; // 하이픈 '-'은 변수명에 올 수 없습니다.
```
  
2. 변수명에는 오직 문자와 숫자, 그리고 기호 $와 _만 들어갈 수 있습니다.

```javascript
let $ = 1; // '$'라는 이름의 변수를 선언합니다.
let _ = 2; // '_'라는 이름의 변수를 선언합니다.

console.log($ + _); // 3
```
  
## 변수 선언 방법
```javascript
1. 한 줄에 작성하기

let message = 'Hello!'; // 변수를 정의하고 값을 할당합니다.


2. 한 줄에 여러 변수를 선언하기

let user = 'John', age = 25, message = 'Hello';


3. 여러줄에 작성하기
let user = 'John',
  age = 25,
  message = 'Hello';
  
  
4. 여러줄에 ‘쉼표가 먼저 오는’ 방식으로 작성하기

let user = 'John'
  , age = 25
  , message = 'Hello';
```
  
## 변수 선언 키워드
## var/let/const

## 1. var 변수의 특징

### (1) 변수의 중복 선언이 가능
```javascript
var name = 'Jack';
var name = 'Jack2'; // 정상 동작

let name = 'Jack';
let name = 'Jack2'; // Uncaught SyntaxError: Identifier 'name' has already been declared

const name = 'Jack';
const name = 'Jack2'; // Uncaught SyntaxError: Identifier 'name' has already been declared
```
  
### (2) var 키워드 생략 가능
```javascript
var globalVar = 'globalVar';

if (globalVar === 'globalVar') {
  globlVar = 'globlVar' // 오타
}

console.log(globalVar) // globalVar!
console.log(globlVar) // globlVar?
```

### (3) "use strict"
```javascript
"use strict"

testvar = 4;  // Uncaught ReferenceError: testvar is not defined
```
* 선언하지 않고 변수를 만들 수 없습니다.


### (3-2) "use strict" 위치
```javascript
testvar = 4
// 하단에 위치한 "use strict"는 스크립트 상단에 위치하지 않으므로 무시됩니다.

"use strict";

// 엄격 모드가 활성화되지 않습니다.
```
* "use strict"는 최상단에 위치시킨다.
* use strict를 취소할 방법은 없습니다.
* 자바스크립트 엔진을 이전 방식으로 되돌리는 "no use strict"같은 지시자는 존재하지 않습니다.


### (4) 함수레벨 스코프
* 메모리 누수, 디버깅이 어렵고 가독성이 떨어지는 함수 스코프 레벨 변수  

```javascript
var test = "Jack";
function print() {
    var test2 = "John";
    console.log(test);        //Jack - 전역변수. 출력가능.
    if(true) {
        var test3 = "Tom";
        console.log(test2);    //John - 해당 함수 내 선언한 변수. 출력 가능.
    }
    console.log(test3);        //Tom - 해당 함수 내 선언한 변수. 출력 가능.
}

print();
function printTwo() {
    var test4 = "Michael";
    console.log(test4);    //Michael - 해당 함수 내 선언한 변수. 출력 가능.
    console.log(test);    //전역변수. 출력가능.
    console.log(test2);    //해당 함수 내 선언한 변수가 아님. Error
    console.log(test3);    //해당 함수 내 선언한 변수가 아님. Error
}

printTwo();
```
  

### (5) 호이스팅
* 호이스팅: 스코프 안에 있는 선언들을 모두 스코프의 최상단으로 끌어올리는 것을 말합니다.
* [let은 hoist 안되는 것이 아니라 TDZ에 들어가 있어 참조에러를 일으킵니다.](https://evan-moon.github.io/2019/06/18/javascript-let-const/)  

```javascript
console.log(test);

var test = "test";
```


## 2. let 변수의 특징
1. 변수의 중복 선언이 불가능합니다.
2. let 키워드는 생략이 불가능합니다.
3. 블록 레벨 스코프를 사용합니다.

### - 블록레벨 스코프
* 중괄호{}로 경계를 구분하는 블록레벨 스코프
  
```javascript
let test = "Jack";
if(true) {
    let test2 = "Tom";
    console.log(test);   //Jack
    console.log(test2);   //Tom
}

console.log(test);   //Jack
console.log(test2);   //Uncaught ReferenceError: test2 is not defined.
```



## 3. const 변수의 특징
### (1) 값의 재할당이 불가능
```javascript
const test = 'Hello, World!';
test = 'Bye, World!'; // Uncaught TypeError: Assignment to constant variable.
```
  
### - Call by Reference 값 변경(에러)
```javascript
const obj = { name: 'Jack' }
obj = { name: 'Jack' } // Uncaught TypeError: Assignment to constant variable.
```
  
### - 객체 내부의 프로퍼티들은 const 키워드의 영향을 받지 않습니다.
```javascript
const obj = { name: 'Jack' }
obj.name = 'John'
console.log(obj) // { name: 'John' }
```

### - 객체를 동결하는 함수 freeze
```javascript
"use strict"

const obj = { name: 'Jack' }

Object.freeze(obj)  //  반환되는 객체: {name: 'Jack'}
obj.name = 'John'
console.log(obj) // Uncaught TypeError: Cannot assign to read only property 'name' of object '#<Object>'
```
* 동결된 객체는 새로운 속성을 추가하거나 존재하는 속성을 제거하는 것을 방지하며 존재하는 속성의 불변성, 설정 가능성(configurability), 작성 가능성이 변경되는 것을 방지하고, 존재하는 속성의 값이 변경되는 것도 방지합니다.
* 구문: Object.freeze(obj)
  * 매개변수: 동결할 객체
  * 반환 값: 함수로 전달된 객체


### - 얕은 범위의 동결
```javascript
"use strict"

const obj = { foo: {} }

var test = Object.freeze(obj)
obj.foo.test = 'John'  // 오류가 나지 않음
console.log(obj) 
```

### (2) const 키워드를 사용하는 경우 반드시 선언과 동시에 값을 할당해줘야 합니다.
```javascript
const test; // Uncaught SyntaxError: Missing initializer in const declaration
```

### (2) 대문자 상수
* 기억하기 힘든 값을 변수에 할당해 별칭으로 사용하는 것은 널리 사용되는 관습입니다.  
  
```javascript
const COLOR_ORANGE = "#FF7F00";

// 색상을 고르고 싶을 때 별칭을 사용할 수 있게 되었습니다.
let color = COLOR_ORANGE;
alert(color); // #FF7F00

```

* 대문자로 상수를 만들어 사용할 때의 장점
  * COLOR_ORANGE는 "#FF7F00"보다 기억하기가 훨씬 쉽습니다.
  * COLOR_ORANGE를 사용하면 "#FF7F00"를 사용하는 것보다 오타를 낼 확률이 낮습니다.
  * COLOR_ORANGE가 #FF7F00보다 훨씬 유의미하므로, 코드 가독성이 증가합니다.
  * 대문자 상수는 ‘하드 코딩한’ 값의 별칭을 만들 때 사용하면 좋다.




## 반복문에서의 var

```javascript
  const arr = [10, 12, 15, 21];
  for (var i = 0; i < arr.length; i++) {
    setTimeout(function() {
      console.log('The index of this number is: ' + i);
    }, 3000); 
  }
```  


## [반복문에서의 let](http://exploringjs.com/es6/ch_variables.html#sec_let-const-loop-heads)
```javascript
 const arr = [10, 12, 15, 21];
  for (let i = 0; i < arr.length; i++) {
    setTimeout(function() {
      console.log('The index of this number is: ' + i);
    }, 3000);
  }
```
* ES6 의 let 은 함수가 호출 될 때 마다 인덱스 i 값이 바인딩 되는 새로운 바인딩 기법을 사용합니다.
