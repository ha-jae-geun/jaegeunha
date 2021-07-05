# [Iterable, Iterator](https://pks2974.medium.com/javascript%EC%99%80-iterator-cdee90b11c0f)

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


### 문자열 역시 이터러블의 예입니다.
```javascript
var test = "test"

for(var item of test) {
    console.log(item);  // t e s t 출력
}
```

### 문자열 iterator 메소드 검색
```javascript
var a = "test"

a[Symbol.iterator]
```

## for in 반복문과 for of 반복문의 차이점
* for in 반복문 : 객체의 모든 열거 가능한 속성에 대해 반복
* for of 반복문 : [Symbol.iterator] 속성을 가지는 컬렉션 전용


# Iterable
* iterable은 객체의 맴버를 반복할 수 있는 객체입니다.
* Javascript 에서 객체가 iterable 하기 위해서는, object 에는 [@@iterator] 메소드가 구현되어 있어야 합니다.
* Javascript 에서는 object property 에 Symbol.iterator 를 추가해야 합니다.
* 객체는 반드시 하나의 Symbol.iterator 만을 가질수 있습니다.
* for of 를 이용해서 iterator의 값을 반복할 수 있습니다.


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
