# JSX
* JSX 는 JavaScript 문법 확장(JavaScript eXtension). 으로 구문이 HTML 과 유사합니다. React 애플리케이션 제작시 꼭 JSX 가 필요한 것은 아니지만, JavaScript 로 UI View 를 구성하는 마크업하는 것은 매우 까다로우므로 특별한 경우가 아니라면 JSX 사용을 권장합니다.
* JSX 가 하는 일은 React 요소(Element)를 만드는 겁니다. React 요소는 실제 DOM 요소가 아니라, JavaScript 객체입니다.
* JSX : javascript + xml


## 규칙
1. 태그는 반드시 닫아줘야 한다.
2. 최상단에서는 반드시 div 로 감싸주어야 한다. ( Fragment 사용 , <> 상황에따라 )
3. JSX 안에서 자바스크립트 값을 사용하고 싶을때는 {}를 사용한다.
변수값 출력예시 참고 -> { name }
4. 조건부 렌더링을 하고싶으면 &&연산자나 삼항연산자를 사용한다.
5. 인라인 스타일링은 항상 객체형식으로 작성한다.
6. 별도의 스타일파일을 만들었으면 class 대신 className 을 사용한다.
7. 주석은 {/* */}을 사용해 작성한다.


```html
1. 태그는 반드시 닫아줘야 한다.

2. 최상단에서는 반드시 div 로 감싸주어야 한다.
return (
<div>
<p>hello react!</p>
<input type="text" />
</div>
)

3. JSX 안에서 자바스크립트 값을 사용하고 싶을때는 { }를 사용한다.
return (
<div>
hello {name}
</div>
)

4. 조건부 렌더링을 하고싶으면 &&연산자나 삼항연산자를 사용한다.
return (
<div>
{ true ? console.log('참') : console.log('거짓') }
</div>
)

5. 인라인 스타일링은 항상 객체형식으로 작성한다.
스타일 작성시 – 빼고 첫글자는 대문자로 작성한다
font-size : fontSize , background-color : backgroundColor , line-height : lineHeight , text-indent :
textIndent
const style ={ bckgroundColor :’red’ }
<div style= { style }>react</div>
<div style={{ backgroundColor: 'red' }}>react</div>

6. 별도의 스타일파일을 만들었으면 class 대신 className 을 사용한다. ( 권장사항 )
<div className="App"> react </div>

7. 주석은 {/* */}을 사용해 작성한다.
<div>
{/* 주석은 이렇게 */}
<h1 // 태그안에서 주석작용 >
react
</h1>
</div>
```
