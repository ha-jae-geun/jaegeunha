# [주소값 복사](https://jmjmjm.tistory.com/m/63)
# [Call by sharing](https://perfectacle.github.io/2017/10/30/js-014-call-by-value-vs-call-by-reference/)

# [위키 정의](https://velog.io/@aiden/call-by-value-vs-call-by-reference-feat.-call-by-sharing)

# callbyvalue
* Call by reference (or pass by reference) is an evaluation strategy where a function receives an implicit reference to a variable used as argument, rather than a copy of its value.
* 직역하자면 함수를 참조로 호출한다. 참조가 뭐냐? 메모리 주소다.
* call by value는 caller의 argument 값을 복사해 callee로 넘겨주는 반면,
* call by reference는 caller의 argument 원본 객체의 메모리 주소를 callee로 넘겨준다.

# Call By Value

```javascript
const test = 1;

function change(val) { // callee
    val = 10;
}
change(test); // caller
console.log(test); // 1 출력
```
* argument로 value(값)이 넘어온다. 이때 넘어올 때는 "복사된 값"이 넘어옵니다.
* 호출하는 자가 인자를 복사해서 넘겨줬기 때문에 호출된 자에서 받은 인자를 아무리 수정하더라도 caller는 영향받지 않습니다.
* 인자를 넘겨줄 때마다 메모리 공간을 할당하기 때문에 공간을 잡아먹는 단점 존재합니다.



# Call By Reference

```javascript
const test = {
  name : 'Jack'
};
function changeName(person) {
  person.name = 'Joo'
};
console.log(tset); // { name : 'Jack' }
changeName(test);
console.log(test); // {name : 'Joo' }
```

* 참조 타입을 인자로 넘기면 참조 값에 대한 복사본이 넘어갑니다.
* argument로 reference가 넘어온다. (reference : 값에 대한 참조 주소, 메모리 주소를 담고 있는 변수)
* caller는 인자를 복사해서 넘긴 것이 아니라 참조값을 넘겼기 떄문에 callee가 받은 인자를 수정하면 caller도 영향을 받습니다.


# [Call By Sharing](https://velog.io/@jimmyjoo/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%ED%8F%89%EA%B0%80%EC%A0%84%EB%9E%B5-Call-By-Value-vs-Call-By-Reference-vs-Call-By-Sharing)

```javascript
const test = {
  name: 'Jack'
};

function changeName(person) {
  person = { name: 'Joo' };
}

console.log(test); // { name: 'Jack' }

changeName(test); //caller

console.log(test); // { name: 'Jack' }
```
