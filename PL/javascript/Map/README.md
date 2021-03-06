# [맵 자료형](https://ko.javascript.info/map-set)

# 맵과 객체 차이점
* 맵은 삽입 순서를 기억합니다.
  * 맵은 값이 삽입된 순서대로 순회를 실시합니다. 객체가 프로퍼티 순서를 기억하지 못하는 것과는 다릅니다.
* map[key]는 Map을 쓰는 바른 방법이 아닙니다.
  * map[key] = 2로 값을 설정하는 것 같이 map[key]를 사용할 수 있긴 합니다. 하지만 이 방법은 map을 일반 객체처럼 취급하게 됩니다. 따라서 여러 제약이 생기게 되죠.
  * map을 사용할 땐 map전용 메서드 set, get 등을 사용해야만 합니다.
  * 맵이 키를 비교하는 방식: 맵은 SameValueZero라 불리는 알고리즘을 사용해 값의 등가 여부를 확인합니다. 이 알고리즘은 일치 연산자 ===와 거의 유사하지만, NaN과 NaN을 같다고 취급하는 것에서 일치 연산자와 차이가 있습니다. 따라서 맵에선 NaN도 키로 쓸 수 있습니다. 이 알고리즘은 수정하거나 커스터마이징 하는 것이 불가능합니다.


## 3가지 활용
```javascript

var data = [
 {id: "하재근", name: "ha", age: 13},
 {id: "하재근2", name: "ha2", age: 15}
];

// return 사용
data.map( (item, index) => {
 return ( console.log(item.id, item.name, item.age))
})

// return 생략
data.map( (item,index) => {
 console.log(item.id, item.name, item.age)
})

// 출력이 1개일때
data.map( (item,index) => console.log(item.id, item.name, item.age))

```
