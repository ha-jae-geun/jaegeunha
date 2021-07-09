# [Primitive Type](https://gunnkimkr.github.io/posts/javascript-primitive-and-reference-values-dynamic-properties/)
```javascript
원시 값과 참조 값
자바스크립트의 변수에는 원시 값과 참조 값 두 가지 타입의 값을 저장할 수 있다.

원시 값
string, number, bigint, boolean, undefined, symbol, null
참조 값
object
변수에 값이 할당되면 자바스크립트 엔진은 할당된 값이 원시 값인지 참조 값인지 
판단하게 되는데 어떤 값이냐에 따라 값에 접근하는 방식이 다르다.

원시 값은 변수에 실제 값이 저장되기 때문에 값으로 접근하지만 
참조 값은 객체 자체가 저장되는 것이 아니라 객체에 대한 참조 값이 저장되기 때문에 참조로 접근한다.

즉, 참조 값을 저장하고 있는 변수는 메모리에 객체를 가리키는 포인터 역할을 하는 것이다.

💡 원시 값은 변경할 수 없다?

let str = 'Hello';
str[0] = 'J';

console.log(str[0], str); // 'H' 'Hello'

str = 'Jello';
console.log(str); // 'Jello'
모든 원시 값은 변경할 수 없다.

변수에 새로운 문자열을 재할당해서 값을 변경하는 것만 가능하다.

6번 줄에서 str 변수에 새로운 문자열 Jello가 할당되면 Hello는 소멸된다.

동적 프로퍼티
let person = new Object();

person.name = 'Gunn';
person.sayName = function () {
    console.log(`저의 이름은 ${this.name} 입니다.`);
}

console.log(person.name); //  'Gunn'

let name = 'Gunn';
name.age = 30;

console.log(name.age); // undefined
객체를 생성해 person이란 변수에 저장하고 person 객체에 name 프로퍼티와 sayName 메서드를 추가했다.

이처럼 참조 값에는 프로퍼티와 메서드를 추가하거나 삭제할 수 있다.

반면에, 원시 값에는 프로퍼티나 메서드를 추가할 수 없다.

프로퍼티를 추가하고 접근하려하면 non-strict mode에서는 13번 줄과 같이 
undefined를 반환하고, strict mode에서는 에러가 발생한다.

원시 래퍼 객체
null과 undefined를 제외한 모든 원시 값은 객체처럼 메서드를 호출할 수 있는데,
원시 값을 래핑한 객체를 갖기 때문이다.12

원시 래퍼 객체는 원시 값의 타입에 따라 관련 프로토타입을 상속한다.

let str = 'Hello';

console.log( str.toUpperCase() ); // 'HELLO'
문자열이 저장된 str 변수에 메서드를 호출했을 때 자바스크립트 내부적으로 다음과 같이 동작한다.

먼저 원시 값이 프로퍼티에 접근하는 순간 특별한 객체인 래퍼 객체가 생성된다.

이 래퍼 객체는 Number 객체의 프로토타입을 상속한다.

toUpperCase 메서드가 실행되면 새로운 문자열을 반환하고 래퍼 객체는 소멸된다.

각주
자바스크립트 창안자는 원시 값을 다룰 때 작업을 수월하게 수행하기 위한 방법으로 원시 래퍼 객체라는 개념을 도입했다. ↩

원시 래퍼 객체는 원시 값의 타입에 따라 종류가 다르며, 상속하는 메서드도 다르다. 
```

# [원시 래퍼 객체](https://developer.mozilla.org/ko/docs/Glossary/Primitive)
