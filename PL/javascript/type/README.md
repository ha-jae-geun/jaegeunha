# [poeimaWeb type coercion](https://poiemaweb.com/js-type-coercion)

# 자료형
*    부동 소수점은 메모리를 많이 차지, 자동으로 지수 ->  정수 표현식으로 사용
*    0과 -0은 부호비트가 다르다
```javascript
자바스크립트에는 여덟 가지 기본 자료형이 있습니다.

숫자형 – 정수, 부동 소수점 숫자 등의 숫자를 나타낼 때 사용합니다. 정수의 한계는 ±253 입니다.
bigint – 길이 제약 없이 정수를 나타낼 수 있습니다.
문자형 – 빈 문자열이나 글자들로 이뤄진 문자열을 나타낼 때 사용합니다. 단일 문자를 나타내는 별도의 자료형은 없습니다.
불린형 – true, false를 나타낼 때 사용합니다.
null – null 값만을 위한 독립 자료형입니다. null은 알 수 없는 값을 나타냅니다.
undefined – undefined 값만을 위한 독립 자료형입니다. undefined는 할당되지 않은 값을 나타냅니다.
객체형 – 복잡한 데이터 구조를 표현할 때 사용합니다.
심볼형 – 객체의 고유 식별자를 만들 때 사용합니다.
typeof 연산자는 피연산자의 자료형을 알려줍니다.

typeof x 또는 typeof(x) 형태로 사용합니다.
피연산자의 자료형을 문자열 형태로 반환합니다.
null의 typeof 연산은 "object"인데, 이는 언어상 오류입니다. null은 객체가 아닙니다.
이어지는 챕터에선 원시 자료형에 대해 학습해 볼 예정입니다. 원시형에 어느 정도 익숙해지면 객체형에 대해 알아보도록 하겠습니다.
```

# [typeof vs Object.protocol.toString.call 차이](https://tonks.tistory.com/218)


## 자료형 확인방법
```javascript
- 1.typeOf
> typeof는 함수가 아닌 연산자이다. 
즉, 괄호를 사용하지 않고 !value, ~value와 같이 사용할 수 있는 단항 연산자이다.<br>

### 단 null 은 하나의 object로 인식하기 때문에 
typeof를 통해 타입을 확인하면 object가 반환됨.
{% highlight js %}

typeof 3; // === 'number' 
typeof 'str'; // === 'string' 
typeof {}; // === 'object' 
typeof []; // === 'object' 
typeof function () {}; // === 'function' 
typeof null; // === 'object'

* let value = null;
typeof value === "object" //true

var value = null;
value !== null && typeof value === "object"


{% endhighlight %}
- 2.instanceof
>instanceof 는 비교 연산자로 >,<,== 와 같이 
두개의 인자를 받는 연산자로 앞의 비교 연산자들을 이용하는 기분으로 사용하면 된다.(다항연산자)
{% highlight js %}

var Person = function(){ 
    this.name = "unikys"; 
}; 
"foo" instanceof String; // === false 
"foo" instanceof Object; // === false 
true instanceof Boolean; // === false 
true instanceof Object; // === false 
[0,1] instanceof Array; // === true 
{0:1} instanceof Object; // === true 

var color1 = new String("red"); 
var color2 = "red"; 
color1 == color2; // === true

"foo".constructor instanceof String; // === false 
"foo".constructor === String; // === true?!

{% endhighlight %}

> object literal인 []와 {}에 대해서 typeof는 둘다 object를 리턴했지만, 
instanceof는 각각 Array와 Object를 리턴한 것도 관심을 가져야할 결과이다. 
{% highlight js %}
"foo".constructor instanceof String; // === false 
"foo".constructor === String; // === true?!


String 
function String() { [native code] }

{% endhighlight %}

> 크롬에서 String을 실행하면 위와같이 나온다. <br>
"foo".constructor 는 Function의 instance인 것이다. 
instance의 개념에 대해서 다시한번 돌이켜보면 어쩌면 당연한 결과이기도 하다. <br>
즉, String 자체는 Function의 instance인 것이다.
이렇게 살펴보면 결국 두가지의 연산자는 각각 다른 용도로 활용하면 될 것이다.<br> 
primitive type을 구분할 때에는 typeof를 사용하고 클래스의 타입을 구분할 때에는 instanceof를 사용하면 된다.

- 3.constructor

- 4.Object.prototype.toString.call(obj) === ‘[object type]’

```




# [type conversion](https://ko.javascript.info/type-conversions)




# String/Number/Boolean를 생성자론 쓰지 맙시다.
```javascript
Java 등의 몇몇 언어에선 new Number(1) 또는 new Boolean(false)와 
같은 문법을 사용해 원하는 타입의 "래퍼 객체"를 직접 만들 수 있습니다.

자바스크립트에서도 하위 호환성을 위해 이 기능을 남겨 두었는데, 
이런 식으로 래퍼 객체를 만드는 건 추천하지 않습니다. 
몇몇 상황에서 혼동을 불러일으키기 때문입니다.

예시:

alert( typeof 0 ); // "number"

alert( typeof new Number(0) ); // "object"!
객체는 논리 평가 시 항상 참을 반환하기 때문에, 아래 예시에서 얼럿창은 무조건 열립니다.

let zero = new Number(0);

if (zero) { // 변수 zero는 객체이므로, 조건문이 참이 됩니다.
  alert( "그런데 여러분은 zero가 참이라는 것에 동의하시나요!?!" );
}
그런데, new를 붙이지 않고 String / Number / Boolean을 사용하는 건 괜찮습니다.
new 없이 사용하면 상식에 맞게 인수를 원하는 형의 원시값(문자열, 숫자, 불린 값)으로 바꿔줍니다. 아주 유용하죠.

예시:

let num = Number("123"); // 문자열을 숫자로 바꿔줌
```
