# [복수 반환](https://poiemaweb.com/js-function)
```javascript
반환값
함수는 자신을 호출한 코드에게 수행한 결과를 반환(return)할 수 있다. 이때 반환된 값을 반환값(return value)이라 한다.


return 키워드는 함수를 호출한 코드(caller)에게 값을 반환할 때 사용한다.
함수는 배열 등을 이용하여 한 번에 여러 개의 값을 리턴할 수 있다.
함수는 반환을 생략할 수 있다. 

이때 함수는 암묵적으로 undefined를 반환한다.
자바스크립트 해석기는 return 키워드를 만나면 함수의 실행을 중단한 후, 
함수를 호출한 코드로 되돌아간다. 
만일 return 키워드 이후에 다른 구문이 존재하면 그 구문은 실행되지 않는다.

function calculateArea(width, height) {
  var area = width * height;
  return area; // 단일 값의 반환
}
console.log(calculateArea(3, 5)); // 15
console.log(calculateArea(8, 5)); // 40

function getSize(width, height, depth) {
  var area = width * height;
  var volume = width * height * depth;
  return [area, volume]; // 복수 값의 반환
}

console.log('area is ' + getSize(3, 2, 3)[0]);   // area is 6
console.log('volume is ' + getSize(3, 2, 3)[1]); // volume is 18
```
