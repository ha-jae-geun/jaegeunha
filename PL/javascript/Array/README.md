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
