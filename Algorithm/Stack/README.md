# 문제
```java
다음 중 큐가 컴퓨터 시스템에서 이용되는 경우는? 3번
① 부프로그램을 처리할 때 레지스터들의 내용 및 복귀주소를 저장할 때
② 순환적 프로그램(recursive program)을 처리할 때
③ 다중 프로그래밍의 운영체제가 대기하고 있는 프로그램들에게 처리기를 할당할 때
④ 그래프를 컴퓨터 내부에 나타낼 때
⑤ 후위 표기방식으로 표현된 수식을 계산할 때

∙ 보기 ①, ②, ④, ⑤는 스택이 컴퓨터 시스템에 이용되는 경우입니다.


스택(Stack)구조의 컴퓨터에서 수식을 계산하기 위해서는 먼
저 수식을 어떠한 형태로 바꾸어야 하는가? 3
① Infix 형태
② John 형태
③ Postfix 형태
④ Prefix 형태
```

# 배열, 연결리스트 차이
* [차이](https://sycho-lego.tistory.com/23)

# 스택의 사용 사례
```java
1. 재귀 알고리즘
재귀적으로 함수를 호출해야 하는 경우에 임시 데이터를 스택에 넣어준다.
재귀함수를 빠져 나와 퇴각 검색(backtrack)을 할 때는 스택에 넣어 두었던 임시 데이터를 빼 줘야 한다.
스택은 이런 일련의 행위를 직관적으로 가능하게 해 준다.
또한 스택은 재귀 알고리즘을 반복적 형태(iterative)를 통해서 구현할 수 있게 해준다.

2. 웹 브라우저 방문기록 (뒤로가기)
3. 실행 취소 (undo)
4. 역순 문자열 만들기
5. 수식의 괄호 검사 (연산자 우선순위 표현을 위한 괄호 검사)
Ex) 올바른 괄호 문자열(VPS, Valid Parenthesis String) 판단하기
6. 후위 표기법 계산
https://gmlwjd9405.github.io/2018/08/03/data-structure-stack.html
```

# 스텍
```java
class Stack {

	int top;
	int[] stack;
	int size;

	public Stack(int size) {
		top = -1;
		stack = new int[size];
		this.size = size;
	}

	public int peek() {
		return stack[top];        
	}

	public void push(int value) {
		stack[++top] = value;
		System.out.println(stack[top] + " PUSH !");
	}

	public int pop() {
		System.out.println(stack[top] + " POP !");
		return stack[top--];
	}

	public void printStack() {
		System.out.println("-- STACK LIST --");
		for (int i = top; i >= 0; i--)
			System.out.println(stack[i]);
		System.out.println("-- END OF LIST --");
	}
}

```
