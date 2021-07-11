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
