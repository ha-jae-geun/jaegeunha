# [값 복사](https://gunnkimkr.github.io/posts/javascript-primitive-and-reference-values-copying-values/)
```javascript
값 복사
값에 의한 값 복사
let num1 = 5;
let num2 = num1;

num1 = 10;
console.log(num2); // 5
num1에는 5가 저장되어 있다. num1을 num2에 대입하면 
num1에 저장된 값 5를 새로 생성한 뒤에 값 복사가 이루어진다.

num1과 num2는 각각 독립적인 존재이기 때문에 
어느 한쪽에서 값이 바뀌어도 다른 쪽에는 영향이 없다.

참조에 의한 값 복사
참조 값 같은 경우 변수를 다른 변수로 복사할 때 
원시 값과는 다른 방식으로 값 복사가 이루어진다.

참조 값은 변수에 객체 자체가 저장되는 것이 아니라 
객체에 대한 참조 값이 저장되기 때문에 다른 변수에 복사할 때도 객체 자체가 아닌 참조 값이 복사된다.

let obj1 = new Object();
let obj2 = obj1;

obj1.name = 'Gunn';
console.log(obj2.name); // 'Gunn'
obj1에 Object의 인스턴스를 할당하고 obj2에 obj1을 대입했다.

obj1과 obj2는 같은 참조 값을 갖고 있으므로 obj1에 프로퍼티를 추가하면 obj2에서도 해당 프로퍼티에 접근할 수 있다.

객체 복제
얕은 복사
객체를 복사할 때 참조 값을 복사하는 것이 아닌 값으로서 독립적인 객체를 만드는 방법은 다음과 같다.

let person = {
  name: 'Gunn',
  age: 30
};

let clone = {};

for(let key in person) {
    clone[key] = person[key];
}

console.log(person, clone, person === clone); // false

clone.name = 'Jun';
console.log(person.name);
for...in문으로 객체의 모든 프로퍼티를 순회하면 원시 타입의 값 복사가 가능하다.

12번 줄에서 person과 clone를 출력해 두 객체의 프로퍼티가 같은 것을 확인했다.

하지만 두 변수의 참조 값이 다르기 때문에 비교 연산에서 false가 된다.

한편 객체의 프로퍼티는 또 다른 객체의 참조 값을 가질 수도 있다. 
이런 경우 참조 값이 복사되기 때문에 완전히 복사가 되었다고 할 수 없다.

이런 값 복사를 가리켜 얕은 복사(shallow copy)라고 한다.

깊은 복사
중첩 객체까지 완전히 복사하는 것을 가리켜 깊은 복사(deep copy)라고 한다.

let student = {
  name: 'Gunn',
  age: 30,
  grades: {
    korean: 96,
    english: 70,
    math: 90
  }
};

let clone = JSON.parse(JSON.stringify(student));

console.log(
    student.grades,
    clone.grades,
    student.grades === clone.grades); // false
JSON.stringify 메서드는 값을 JSON 문자열로 변환해준다.

JSON.parse 메서드는 JSON 문자열을 분석해서 값이나 객체로 생성해준다.

중첩 객체를 포함한 전체를 원시 값인 문자열로 바꾼 뒤 객체를 생성하기 때문에 참조 값은 복사되지 않는다.

하지만 JSON.stringify 메서드를 사용해 문자열로 변환하는 과정에서 
undefined, function, symbol은 소실되거나 null로 변환되기 때문에 주의가 필요하다.

- 재귀 함수를 사용한 깊은 복사

재귀 함수를 직접 정의해서 사용하면 중첩 객체는 물론 모든 값을 복사할 수 있다.

function cloneObj(obj) {
  let cloneObject = {};
  for (let key in obj) {
    if (typeof obj[key] == 'object' && obj[key] != null) {
      cloneObject[key] = cloneObject(obj[key]);
    } else {
      cloneObject[key] = obj[key];
    }
  }

  return cloneObject;
}
```

## spraed 객체 복사
```javascript
const dog = {name: "치와와", age:2, addr: "서울"};

// 갱신, 수정
//{...객체복사, 키:값} -> 해당 키 값이 수정
const dog1 = {...dog, name: "고양이"};
console.log(dog1);
```

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
