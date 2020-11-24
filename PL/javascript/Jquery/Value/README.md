# [val, text, html 차이](https://secretroute.tistory.com/entry/jQuery-val-text-html의-차이)
```java
★ val() : Form Element 의 값을 받아오는데 쓰인다. (주로 input 이나 textarea 정도?)

- 주의해야할 점은 Form Element 이외의 값은 받아오질 못한다는 점.

★ val(value) : value의 경우 string 또는 string의 배열(이 경우 value들의 matching을 잘 시켜야 오류를 피할 수 있다) 

또는 함수(function(index, value) 이런 형태)로 넣을 수 있다.

이 함수 역시 Form Element의 Value 값을 Set할 때 주로 쓰인다.



● text() : XML과 HTML 문서에서 둘다 사용될 수 있다. input elements 의 value를 받아오지 못한다(이 경우 val을 사용)

아주 쉬운 예로 <button>1</button> <button>2</button> <button>3</button> : button 대신 li 라던가.

$('button').text() 의 결과는 1 2 3 이다. 이런 식으로 사용된다. 

tag attribute의 value가 아니라(대표적으로 form 요소들) <tag>_____</tag>에서 _____에 해당하는 value를 get한다.

참고 사이트에 의하면 The .text() method cannot be used on form inputs or scripts. 

라고 적혀있다. ( form inputs 의 경우 val()를 말하는 거고 scripts 의 경우 html()을 가르킨다. )

● text(value) : textString 또는 함수(function(index, text) 이런 형태)로 넣을 수 있다. 이 역시 Set 하기위해 쓰인다.



◆ html() : XML 문서는 사용 불가, HTML만 가능. value가 아니라 html code(contents)자체를 get한다.

class 네임이 여러 개 매칭되는 경우 제일 처음 매칭되는 class 안에 속하는 html code만 가져온다.

api 설명에 의하면 IE의 경우 알파벳 문자를 포함하고 있는 속성값들의 경우 " ' " (quote)를 빼먹고 get 할 수도 있다고 한다.

◆ html(value) : htmlString 또는 함수(function(index, oldhtml) 이런 형태)로 넣을 수 있다. 이 역시 Set 하기위해 쓰인다.

class 네임이 여러 개 매칭되는 경우 매칭되는 모든 class 내부에 html code를 삽입.

만약 class 내부에 이미 어떤 code가 삽입되있는 경우, Set 할 html code로 완전히 Replace 해버린다.

```
