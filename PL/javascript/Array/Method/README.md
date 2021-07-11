# 불변성 유지
```javascript
const arr = [10, 20, 30, 40, 50]

// 불변성 유지가 안됨
arr.push(60)

// 불변성 유지
const arr1 = [10, 20, 30, 40, 50];
const arr2 = arr1.concat(60);

```

## [불변성 유지 메서드](https://opentogether.tistory.com/106)

# find
* 해당하는 1개의 값 찾을때
```javascript
const data2 = [
  {id:1, name: "강호동", age:20},
  {id:2, name: "고민지", age:20},
  {id:3, name: "유재석", age:20},
  {id:4, name: "이효리", age:20},  
];

const test2 = data.find( item => item.id === 3)
```

# filter
* 결과값이 배열로 return됨 <> find

```javascript
const data = [
  {id:1, name: "강호동", age:20},
  {id:2, name: "고민지", age:20},
  {id:3, name: "유재석", age:20},
  {id:4, name: "이효리", age:20},  
];

const test = data.filter( item => item.id === 3)

```
