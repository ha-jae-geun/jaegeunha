# [배열 기초](https://www.youtube.com/watch?v=yOdAVDuHUKQ&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=8)
# [배열 API](https://www.youtube.com/watch?v=3CUjtKJ7PJg&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=9)

# [reduce와 map](https://www.zerocho.com/category/JavaScript/post/5acafb05f24445001b8d796d)
# [Spread 문법과 apply](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Spread_syntax)

# 불변성 유지
```javascript
const arr = [10, 20, 30, 40, 50]

// 불변성 유지가 안됨
arr.push(60)

// 불변성 유지
const arr1 = [10, 20, 30, 40, 50];
const arr2 = arr1.concat(60);


```

# Array 타입 체크
* Object.prototype.toString.call(password) === '[object Array]'

# 배열 값 찾기
```javascript
배열 탐색하기
배열 내에서 무언가를 찾고 싶을 때 쓰는 메서드에 대해 알아봅시다.

indexOf, lastIndexOf와 includes
arr.indexOf와 arr.lastIndexOf, arr.includes는 같은 이름을 가진 문자열 메서드와 문법이 동일합니다. 
물론 하는 일도 같습니다. 연산 대상이 문자열이 아닌 배열의 요소라는 점만 다릅니다.

arr.indexOf(item, from)는 인덱스 from부터 시작해 item(요소)을 찾습니다. 
요소를 발견하면 해당 요소의 인덱스를 반환하고, 발견하지 못했으면 -1을 반환합니다.
arr.lastIndexOf(item, from)는 위 메서드와 동일한 기능을 하는데, 검색을 끝에서부터 시작한다는 점만 다릅니다.
arr.includes(item, from)는 인덱스 from부터 시작해 item이 있는지를 검색하는데, 해당하는 요소를 발견하면 true를 반환합니다.

예시:

let arr = [1, 0, false];

alert( arr.indexOf(0) ); // 1
alert( arr.indexOf(false) ); // 2
alert( arr.indexOf(null) ); // -1

alert( arr.includes(1) ); // true
위 메서드들은 요소를 찾을 때 완전 항등 연산자 === 을 사용한다는 점에 유의하시기 바랍니다. 
보시는 바와 같이 false를 검색하면 정확히 false만을 검색하지, 0을 검색하진 않습니다.

요소의 위치를 정확히 알고 싶은게 아니고 
요소가 배열 내 존재하는지 여부만 확인하고 싶다면 arr.includes를 사용하는 게 좋습니다.

includes는 NaN도 제대로 처리한다는 점에서 
indexOf/lastIndexOf와 약간의 차이가 있습니다.

const arr = [NaN];
alert( arr.indexOf(NaN) ); // -1 (완전 항등 비교 === 는 NaN엔 동작하지 않으므로 0이 출력되지 않습니다.)
alert( arr.includes(NaN) );// true (NaN의 여부를 확인하였습니다.)
```

# 선언
* cost arr1 = new Array();
const arr2 = [1,2]

# index position
* console.log(fruits[0])

# looping
```javascript
for(let i=0; i<fruits.length; i++_ {
 console.log(fruits[i]);
}

for(let fruit of fruits) {
  console.log(fruit);


fruits.forEach(function(fruit, index, array) {
  console.log(fruit, index
};

fruits.forEach{ (fruit) => console.log(fruit));

```

# Addition
* push(add an item to the end)
 * fruits.push(' ')
* pop: remove an item from the end
 * fruits.pop();
* unshift: add an item to the beginning
 * fruits.unshift(' ');
* shift: remove an item from the beginning
 * fruits.shift();

* shift와 unshift는 pop과 push보다 느리다
 * 배열의 위치를 이동시켜야 함
 * 배열의 크기가 길수록 부담이 더 크다.
 
* splice
 * fruits.splice(start, count)
  * 지우고 싶은 개수
 * fruits.splice(start, count, 원하는 것 추가)
 
 # combine
 * const newFruits = fruits.concat(fruits2);


# search
* console.log(fruits.indexOf(' ');
 * 값이 없으면 -1 출력
 * 값의 첫번째 인덱스 리턴
* console.log(fruits.includes(' ');
* console.log(fruits.lastIndexOf(' ');
 * 값의 마지막 인덱스 리턴

# 응용
* const result = students.map((studentt ) => studetn.score).filter((score => score>=50).join();

# join
* 배열을 string으로 변환
* const rsult = fruits.join(',')

# split
* string을 배열로 변환
* const reusult = fruits.split(',', 2)
  * 뒤에 2는 optional
  
# reverse
* 배열 순서 변경
* const result = array.reverse();

# splice와 slice 차이
* splice는 배열 자체를 변환

## slice
* const result = array.slice(2,5)

# find
* 조건에 처음으로 충족하는 배열을 return 

```javascript
  const result = result.find(function(strudent, index) {
  return student.score ===  90;
};
```

```javascript
  const result = students.find((student) => student.score === 90);
```

# filter
```javascript
  const result = studentss.filter((student) => student.enrolled);

```

# map
* 배열 안의 요소들을 원하는 함수룰 호출하여 값을 출력하기 위함

```javascript
  const result = students.map((student) => student.score);
```

# some
* 배열의 일부가 충족
* return: true/false
```javascript
  const result = students.some((student) => student.score < 50);
```


# every
* 배열의 모든 요소들이 충족
* return: true/false
```javascript
  const result = students.every((student) => student.score < 50);
```

# reduce
* 값을 누적할 때 사용
* return한 값이 prev로 저장

```javascript
const result = students.reduce((prev, curr) => {
  console.log(prev);
  console.log(curr);
  return prev + curr.scor   e;
  }, 0);
}
```
* 0은 initial value

``javascript
 reuslt = students.reduce((prev, curr) => prev + curr.score, 0);
```

# sort
```javascript
const result = students.map(student => student.score)
                       .sort((a, b) => b-a)
                       .join();
```
