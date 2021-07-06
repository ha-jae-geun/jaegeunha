# [call, apply, bind](https://www.zerocho.com/category/JavaScript/post/57433645a48729787807c3fd)

# 유사배열
* 위 메소드들을 쓰는 예로, 함수의 arguments를 조작할 때 사용합니다. arguments는 함수라면 처음부터 갖고 있는 숨겨진 속성인데요. 
* 바로 함수에 들어온 인자를 배열 형식으로(배열은 아닙니다. 유사 배열이라고 부릅니다.) 반환합니다.

# arguments
```javascript
‘arguments’ 변수
arguemnts라는 특별한 유사 배열 객체(array-like object)를 이용하면 인덱스를 사용해 모든 인수에 접근할 수 있습니다.

예시:

function showName() {
  alert( arguments.length );
  alert( arguments[0] );
  alert( arguments[1] );

  // arguments는 이터러블 객체이기 때문에
  // for(let arg of arguments) alert(arg); 를 사용해 인수를 나열할 수 있습니다.
}

// 2, Julius, Caesar가 출력됨
showName("Julius", "Caesar");

// 1, Bora, undefined가 출력됨(두 번째 인수는 없음)
showName("Bora");
나머지 매개변수는 비교적 최신의 문법입니다. 과거엔 함수의 인수 전체를 
얻어내는 방법이 arguments를 사용하는 것밖에 없었습니다. 
물론 지금도 arguments를 사용할 수 있습니다. 오래된 코드를 보다 보면 arguments를 만나게 되죠.

arguments는 유사 배열 객체이면서 이터러블(반복 가능한) 객체입니다. 
어쨌든 배열은 아니죠. 따라서 배열 메서드를 사용할 수 없다는 단점이 있습니다. 
arguments.map (...)을 호출할 수 없죠.

여기에 더하여 arguments는 인수 전체를 담기 때문에 
나머지 매개변수처럼 인수의 일부만 사용할 수 없다는 단점도 있습니다.

따라서 배열 메서드를 사용하고 싶거나 인수 일부만 사용하고자 할 때는 
나머지 매개변수를 사용하는 것이 좋습니다.

화살표 함수에는 \'arguments\'가 없습니다.
화살표 함수에서 arguments 객체에 접근하면, 외부에 있는 ‘일반’ 함수의 arguments 객체를 가져옵니다.

예시:

function f() {
  let showArg = () => alert(arguments[0]);
  showArg();
}

f(1); // 1
앞서 배운 바와 같이 화살표 함수는 자체 this를 가지지 않습니다. 
여기에 더하여 arguments 객체도 없다는 것을 위 예시를 통해 확인해 보았습니다.
```

# 나머지
```javascript
나머지 매개변수는 항상 마지막에 있어야 합니다.
나머지 매개변수는 남아있는 인수를 모으는 역할을 하므로 아래 예시에선 에러가 발생합니다.

function f(arg1, ...rest, arg2) { // ...rest 후에 arg2가 있으면 안 됩니다.
  // 에러
}
...rest는 항상 마지막에 있어야 합니다.
```
