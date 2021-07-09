# null 타입
```javascript
1.1.5 null
null 타입의 값은 null이 유일하다. 
자바스크립트는 대소문자를 구별(case-sensitive)하므로 null은 Null, NULL등과 다르다.

프로그래밍 언어에서 null은 의도적으로 변수에 값이 없다는 것을 명시할 때 사용한다. 
이는 변수가 기억하는 메모리 어드레스의 참조 정보를 제거하는 것을 의미하며 
자바스크립트 엔진은 누구도 참조하지 않는 메모리 영역에 대해 가비지 콜렉션을 수행할 것이다.

var foo = 'Lee';
foo = null;  // 참조 정보가 제거됨
또는 함수가 호출되었으나 유효한 값을 반환할 수 없는 경우, 명시적으로 null을 반환하기도 한다. 
예를 들어, 조건에 부합하는 HTML 요소를 검색해 반환하는 Document.querySelector()는 조건에 
부합하는 HTML 요소를 검색할 수 없는 경우, null을 반환한다.

var element = document.querySelector('.myElem');
// HTML 문서에 myElem 클래스를 갖는 요소가 없다면 null을 반환한다.
console.log(element); // null
타입을 나타내는 문자열을 반환하는 typeof 연산자로 null 값을 연산해 보면 
null이 아닌 object가 나온다. 이는 자바스크립트의 설계상의 오류이다.

var foo = null;
console.log(typeof foo); // object
따라서 null 타입을 확인할 때 typeof 연산자를 사용하면 안되고 일치 연산자(===)를 사용하여야 한다.

var foo = null;
console.log(typeof foo === null); // false
console.log(foo === null);        // true
```
