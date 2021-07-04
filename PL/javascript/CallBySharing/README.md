# [Call by sharing](https://perfectacle.github.io/2017/10/30/js-014-call-by-value-vs-call-by-reference/)

# [위키 정의](https://velog.io/@aiden/call-by-value-vs-call-by-reference-feat.-call-by-sharing)

# callbyvalue
* Call by reference (or pass by reference) is an evaluation strategy where a function receives an implicit reference to a variable used as argument, rather than a copy of its value.
* 직역하자면 함수를 참조로 호출한다. 참조가 뭐냐? 메모리 주소다.
* call by value는 caller의 argument 값을 복사해 callee로 넘겨주는 반면,
* call by reference는 caller의 argument 원본 객체의 메모리 주소를 callee로 넘겨준다.

