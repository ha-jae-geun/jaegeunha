# static
```javascript
Class Article {
  static publisher = 'Dream Coding;
  constructor(articleNumber) {
    this.articleNumber = articleNumber;
  }
}

console.log(Article.publisher);
// 클래스 자체로 호출해야 함
```

# private
```javascript
class Experiment {
  publicField = 2;
  #privatefield = 0;
}

// 같은 클래스 내에서만 호출 가능
// 앞에 #으로 표현
```

# Getter and Setter
```javascript
class User {
  constructor(firstName, lastName, age) {
     this.firstName = firstName;
     this.lastName = lastName;
     this.age = age;
  }
  
  get age() {
    return this._age;
  }
  
  set age(value) {
  this._age = value;
}
```

# assign
* 깊은 복사
```javascript
const mixed = Object.assign({}, fruit1, fruit2})

뒤에 있는 것으로 덮어 씌움
```