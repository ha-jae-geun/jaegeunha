# [Spread Syntax](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Spread_syntax)
* 전개 구문 (spread 프로퍼티인 경우 제외) 은 iterable 객체에만 적용됩니다.


## spraed 배열 복사
```javascript
  const data = [
    {id: 1, name: '강호동', age: 20},
    {id: 2 name: '고민지', age: 3},
    {id: 3 name: '유재석', age: 4},
    {id: 4 name: '이효리', age: 5},
    {id: 5 name: '제시', age: 6},
  ];
  const data1 = [
    ...data,
    {
      id: 6,
      name: "김철수",
      age: 20
    }
  ]
```

## id가 3인 사람 수정/갱신
```javascript
  const data = [
    {id: 1, name: '강호동', age: 20},
    {id: 2, name: '고민지', age: 3},
    {id: 3, name: '유재석', age: 4},
    {id: 4, name: '이효리', age: 5},
    {id: 5, name: '제시', age: 6},
  ];
  
  const data2 = data.map( (item, index) => {
    if( item.id === 3) {
      return {
        ...item,
        name: "이수근",
        age: 10
      }
    } else {
      return item;
    }
  })
  
  console.log(data2);
```

## id가 3인 사람 수정/갱신
```javascript
  const data = [
    {id: 1, name: '강호동', age: 20},
    {id: 2, name: '고민지', age: 3},
    {id: 3, name: '유재석', age: 4},
    {id: 4, name: '이효리', age: 5},
    {id: 5, name: '제시', age: 6},
  ];
  
 const data3 = data.map( (item, index) => item.id === 1 ? {...item, name:"이승기", age:20} : item)
  
  console.log(data3);
```
