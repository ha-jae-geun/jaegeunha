# [.forEach 루프와 .map() 루프 사이의 주요 차이점을 설명할 수 있나요? 왜 둘 중 하나를 선택할 것인가요?](https://velog.io/@chris/front-end-interview-handbook-js-1#%EB%8B%A4%EC%9D%8C%EC%9D%B4-iife%EB%A1%9C-%EC%9E%91%EB%8F%99%ED%95%98%EC%A7%80-%EC%95%8A%EB%8A%94-%EC%9D%B4%EC%9C%A0%EB%A5%BC-%EC%84%A4%EB%AA%85%ED%95%98%EC%84%B8%EC%9A%94-function-foo-%EB%A5%BC-iife%EB%A1%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0-%EC%9C%84%ED%95%B4%EC%84%9C%EB%8A%94-%EB%AC%B4%EC%97%87%EC%9D%84-%EB%B0%94%EA%BF%94%EC%95%BC%ED%95%98%EB%82%98%EC%9A%94)


# [loop에서 closure, var/let](https://joshua1988.github.io/web-development/javascript/javascript-interview-3questions/)

# 반복문 실행 순서
for (let i = 0; i < 3; i++) { // 0, 1, 2가 출력됩니다.
  alert(i);
}
이제 for문의 구성 요소를 하나씩 살펴봅시다.

구성 요소		
begin	i = 0	반복문에 진입할 때 단 한 번 실행됩니다.
condition	i < 3	반복마다 해당 조건이 확인됩니다. false이면 반복문을 멈춥니다.
body	alert(i)	condition이 truthy일 동안 계속해서 실행됩니다.
step	i++	각 반복의 body가 실행된 이후에 실행됩니다.


# 인라인 변수 선언
```javascript
지금까진 ‘카운터’ 변수 i를 반복문 안에서 선언하였습니다. 
이런 방식을 ‘인라인’ 변수 선언이라고 부릅니다. 이렇게 선언한 변수는 반복문 안에서만 접근할 수 있습니다.

for (let i = 0; i < 3; i++) {
  alert(i); // 0, 1, 2
}
alert(i); // Error: i is not defined
인라인 변수 선언 대신, 정의되어있는 변수를 사용할 수도 있습니다.

let i = 0;

for (i = 0; i < 3; i++) { // 기존에 정의된 변수 사용
  alert(i); // 0, 1, 2
}

alert(i); // 3, 반복문 밖에서 선언한 변수이므로 사용할 수 있음
```
