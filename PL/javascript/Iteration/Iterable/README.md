# [Iterable, Iterator](https://pks2974.medium.com/javascript%EC%99%80-iterator-cdee90b11c0f)
# [Javascript Info Iterable](https://ko.javascript.info/iterable)
# [generator 테코톡](https://youtu.be/fsmekO1fQcw)

# for of
```javascript
const arr = ['a', 'b'];
for (const [index, element] of arr.entries()) {
    console.log(`${index}. ${element}`);
}

// Output:
// 0. a
// 1. b

const map = new Map([
    [false, 'no'],
    [true, 'yes'],
]);
for (const [key, value] of map) {
    console.log(`${key} => ${value}`);
}
```
* entries() 메서드는 배열의 각 인덱스에 대한 키/값 쌍을 가지는 새로운 Array Iterator 객체를 반환합니다.

# 전개문법과 iterable
```javascript
let arr = [3, 5, 1];
let arr2 = [8, 9, 15];

let merged = [0, ...arr, 2, ...arr2];

alert(merged); // 0,3,5,1,2,8,9,15 (0, arr, 2, arr2 순서로 합쳐집니다.)
앞선 예시들에선 배열을 대상으로 전개 문법이 어떻게 동작하는지 살펴보았습니다. 
그런데 배열이 아니더라도 이터러블 객체이면 전개 문법을 사용할 수 있습니다.

전개 문법을 사용해 문자열을 문자 배열로 변환 시켜 보겠습니다.

let str = "Hello";

alert( [...str] ); // H,e,l,l,o
전개 문법은 for..of와 같은 방식으로 내부에서 iterator(반복자)를 사용해 요소를 수집합니다.

문자열에 for..of를 사용하면 문자열을 구성하는 문자가 반환됩니다.
...str도 "H","e","l","l","o"가 되는데, 
이 문자 목록은 배열 초기자(array initializer) [...str]로 전달됩니다.

메서드 Array.from은 문자열 같은 이터러블 객체를 배열로 바꿔주기 때문에 
Array.from을 사용해도 동일한 작업을 할 수 있습니다.

let str = "Hello";

// Array.from은 이터러블을 배열로 바꿔줍니다.
alert( Array.from(str) ); // H,e,l,l,o
[...str]와 동일한 결과가 출력되는 것을 확인할 수 있습니다.

그런데 Array.from(obj)와 [...obj]에는 다음과 같은 미묘한 차이가 있습니다.

Array.from은 유사 배열 객체와 이터러블 객체 둘 다에 사용할 수 있습니다.
전개 문법은 이터러블 객체에만 사용할 수 있습니다.
이런 이유때문에 무언가를 배열로 바꿀 때는 전개 문법보다 Array.from이 보편적으로 사용됩니다.
```

# for in
## 배열
```javascript
var arr = ['a', 'b', 'c'];

for (var item in arr) {
  console.log(item); // 0, 1, 2
}

인덱스 출력
```


## 객체
```javascript
var obj = {
  a: 1,
  b: 2,
  c: 3
};

for (var item in obj) {
  console.log(item) // a, b, c
}

key 값 출력
```

* 객체의 key 값에 접근할 수 있지만, value 값에 접근하는 방법은 제공하지 않습니다. 
* 자바스크립트에서 객체 속성들은 내부적으로 사용하는 숨겨진 속성들을 가지고 있습니다. 
* 그 중 하나가 [[Enumerable]]이며, for in 구문은 이 값이 true로 셋팅되어 속성들만 반복할 수 있습니다. 
* 이러한 속성들을 열거형 속성이라고 부르며, 객체의 모든 내장 메서드를 비롯해 각종 내장 프로퍼티 같은 비열거형 속성은 반복되지 않습니다.



# for of
## 배열
```javascript
var arr = ['a', 'b', 'c'];

for (var item of arr) {
  console.log(item); // a, b, c 출력
}

값 출력
```

## 객체
 ```javascript
 var obj = {
  a: 1,
  b: 2,
  c: 3
};

for (var item of obj) {
  console.log(item) // Uncaught TypeError: obj is not iterable
}
 ```
 
 * ES6에 추가된 새로운 컬렉션 전용 반복 구문입니다.
 * for of 구문을 사용하기 위해선 컬렉션 객체가 [Symbol.iterator] 속성을 가지고 있어야만 합니다(직접 명시 가능).
    *  배열은 대표적인 이터러블입니다. 배열 외에도 다수의 내장 객체가 반복 가능합니다. 



## for in 반복문과 for of 반복문의 차이점
* for in 반복문 : 객체의 모든 열거 가능한 속성에 대해 반복
* for of 반복문 : [Symbol.iterator] 속성을 가지는 컬렉션 전용


# Iterable
* iterable은 객체의 맴버를 반복할 수 있는 객체입니다.
* Javascript 에서 객체가 iterable 하기 위해서는, object 에는 [@@iterator] 메소드가 구현되어 있어야 합니다.
* Javascript 에서는 object property 에 Symbol.iterator 를 추가해야 합니다.
* 객체는 반드시 하나의 Symbol.iterator 만을 가질수 있습니다.
* for of 를 이용해서 iterator의 값을 반복할 수 있습니다.


## 객체를 iterable 객체로 만들기

```javascript
const test = new Object();

test[Symbol.iterator] = function* () {
  yield 1;
  yield 2;
  yield 3;
};

console.log([...test]); // 1 2 3
for(var value of test) {
    console.log(value); // 1 2 3
}
```

* 자바스크립트에서 build-in object 중 iterable 를 가지고 있는 객체는 Array, TypedArray, String, Map, Set




## Iterable 객체

### for of 동작 순서
* for..of가 시작되자마자 for..of는 Symbol.iterator를 호출합니다(Symbol.iterator가 없으면 에러가 발생합니다). Symbol.iterator는 반드시 이터레이터(iterator, 메서드 next가 있는 객체) 를 반환해야 합니다.
* 이후 for..of는 반환된 객체(이터레이터)만을 대상으로 동작합니다.
* for..of에 다음 값이 필요하면, for..of는 이터레이터의 next()메서드를 호출합니다.
* next()의 반환 값은 {done: Boolean, value: any}와 같은 형태이어야 합니다. done=true는 반복이 종료되었음을 의미합니다. done=false일땐 value에 다음 값이 저장됩니다.


## range를 반복 가능한 객체로 만들어주는 javascript info 예제
```javascript

let range = {
  from: 1,
  to: 5
};

// 1. for..of 최초 호출 시, Symbol.iterator가 호출됩니다.
range[Symbol.iterator] = function() {

  // Symbol.iterator는 이터레이터 객체를 반환합니다.
  // 2. 이후 for..of는 반환된 이터레이터 객체만을 대상으로 동작하는데, 이때 다음 값도 정해집니다.
  return {
    current: this.from,
    last: this.to,

    // 3. for..of 반복문에 의해 반복마다 next()가 호출됩니다.
    next() {
      // 4. next()는 값을 객체 {done:.., value :...}형태로 반환해야 합니다.
      if (this.current <= this.last) {
        return { done: false, value: this.current++ };
      } else {
        return { done: true };
      }
    }
  };
};

// 이제 의도한 대로 동작합니다!
for (let num of range) {
  alert(num); // 1, then 2, 3, 4, 5
}
```

# 이터레이터를 명시적으로 호출하기
* 메서드 Symbol.iterator는 for..of에 의해 자동으로 호출되는데, 개발자가 명시적으로 호출하는 것도 가능합니다.

```javascript
let str = "Hello";

// for..of를 사용한 것과 동일한 작업을 합니다.
// for (let char of str) alert(char);

let iterator = str[Symbol.iterator]();

while (true) {
  let result = iterator.next();
  if (result.done) break;
  alert(result.value); // 글자가 하나씩 출력됩니다.
}
```

* 이터레이터를 명시적으로 호출하는 경우는 거의 없는데, 이 방법을 사용하면 for..of를 사용하는 것보다 반복 과정을 더 잘 통제할 수 있다는 장점이 있습니다. 
* 반복을 시작했다가 잠시 멈춰 다른 작업을 하다가 다시 반복을 시작하는 것과 같이 반복 과정을 여러 개로 쪼개는 것이 가능합니다.

* iterator 은 객체를 next 메서드로 순환 할 수 있는 객체다.
* iterator는 next() 메소드를 가지고 있습니다.
  * next 메소드는 arguments 가 없습니다.
  * next 메소드의 반환자는 done: boolean 과 value: any 를 포함하는 object 를 반환해야 합니다.
  * next 메소드의 반복이 끝날때 done 은 true 를 반환해야 합니다.


### 문자열 역시 이터러블의 예입니다.
```javascript
var test = "test"

for(var item of test) {
    console.log(item);  // t e s t 출력
}
```

### 문자열 Symbol.iterator 속성 검색
```javascript
var a = "test"

a[Symbol.iterator]
```

# 출처
* [javascript info](https://ko.javascript.info/iterable)
* [Andrew Park](https://pks2974.medium.com/javascript%EC%99%80-iterator-cdee90b11c0f)
