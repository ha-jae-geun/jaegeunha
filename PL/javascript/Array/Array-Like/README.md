# 이터러블과 유사 배열
* 비슷해 보이지만 아주 다른 용어 두 가지가 있다. 헷갈리지 않으려면 두 용어를 잘 이해하고 있어야 한다.
* 이터러블(iterable)은 위에서 설명한 바와 같이 메서드 Symbol.iterator가 구현된 객체임.
* 유사 배열(array-like)은 인덱스와 length 프로퍼티가 있어서 배열처럼 보이는 객체임.
* Array.from
    * 범용 메서드 Array.from는 이터러블이나 유사 배열을 받아 진짜 Array를 만들어준다. 이 과정을 거치면 이터러블이나 유사 배열에 배열 메서드를 사용할 수 있다.

```javascript
// 유사 배열
const arrayLike = {
  0: 1,
  1: 2,
  length: 2
};

console.log(Array.from(arrayLike).pop());

// iterable
const iter = {
  [Symbol.iterator]() {
    return this;
  },
  arr: [1, 2, 3, 4, 5],
  next() {
    return {
      done: this.arr.length === 0,
      value: this.arr.pop()
    };
  }
};


/*
pop을 하면서 반복하는 iterable 객체이므로
Array.from(iter)
 = [5,4,3,2,1]
*/

console.log(Array.from(iter).pop());

// 출력
// 2
// 1
```
