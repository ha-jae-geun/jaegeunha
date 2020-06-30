# 큐
* 선형큐(배열을 이용한 큐), 순환큐(배열 이용; 선형큐 극복), Linked Queue
* 큐, 우선순위 큐, 환형 큐, 데큐
* [큐 그림](https://galid1.tistory.com/483)
```java
배열을 이용한 큐

1. 선형 큐(linear queue)

배열을 선형으로 사용해 큐를 구현

삽입을 계속하기 위해 요소들을 이동시켜야함

문제점이 많아 사용되지 않음

* 초기에 front와 rear는 -1을 가르킴


2. 원형큐

배열을 원형으로 사용해 큐를 구현



* 항상 front는 비어있어야 함

* Enqueue 명령시 FULL인지 확인하는 절차 필요

   (r+1) % MAX_SIZE = f 이면 값을 넣을 수 없음 (Queue FULL 발생)

* Dequeue 명령시 (f==r)이면 (Queue EMPTY 발생)




연결된 큐(linked queue)

front포인터는 삭제와 관련되며 rear 포인터는 삽입

front는 연결 리스트 맨앞의 요소를 가르키며, rear 포인터는 맨 뒤에 있는 요소를 가르킴

큐에 요소가 없는 경우 front와 rear는 NULL

연결리스트로 구현된 큐



덱(deque, Double-ended queue)

큐의 전단(front)와 후단(rear)에서 모두 삽입과 삭제가 가능한 큐

양쪽에서 삽입, 삭제가 가능하여야 하므로 일반적으로 이중연결 리스트 사용

일반적으로 Queue Full이 생기지 않음, 메모리가 가득차면 Full
```

```java
큐는 스택과 마찬가지로 일종의 리스트
데이터 삽입은 한쪽 끝에서, 삭제는 반대쪽 끝에서만 일어난다
삽입이 일어나는 쪽을 rear, 삭제가 일어나는 쪽을 front라고 부른다.
FIFO(First-in, First-Out)

Queue(큐)에서 지원하는 연산
insert, enqueue, offer, push : queue의 rear에 새로운 원소를 삽입하는 연산

remove, dequeue, poll, pop : queue의 front에 있는 원소를 queue로부터 삭제하고 반환하는 연산

peek, element, front : 큐의 front에 있는 원소를 제거하지 않고 반환하는 연산

is_empty : 큐가 비었는지 검사

Queue(큐)의 응용
cpu 스케쥴링 : multitasking 환경에서 프로세스들은 큐에서 cpu가 할당되기를 기다린다.

데이터 버퍼 : 네트워크를 통해 전송되는 패킷들은 도착한 순서대로 버퍼에 저장되어 처리되기를 기다린다

자원을 공유하는 대부분의 경우에 큐가 사용 된다


![image.png](https://images.velog.io/post-images/p
a324/88b5f5b0-9fa4-11e9-8684-dd86c4efd59d/image.png)

Queue(큐)의 구현
배열 혹은 연결리스트를 이용해서 구현할 수 있다.

1.Linked List로 구현

rear에서는 삽입, front에서는 삭제가 일어난다. 따라서 연결리스트의 앞쪽을 front, 뒤쪽을 rear로 하는것이 유리하다.

삽입을 하기 위해서는 마지막 노드의 주소를 항상 기억해야 한다.

※동적메모리 할당
변수를 선언하는 대신 프로그램의 요청으로 메모리를 할당할 수 있다. 이것을 동적메모리 할당 (dynamic memory allocation)이라고 부른다.
malloc 함수를 호출하여 동적메모리할당을 요청하면 요구하는 크기의 메모리를 할당하고 그 시작 주소를 반환한다.
```

# 큐의 사용사례
```java
데이터가 입력된 시간 순서대로 처리해야 할 필요가 있는 상황에 이용한다.

너비 우선 탐색(BFS, Breadth-First Search) 구현
처리해야 할 노드의 리스트를 저장하는 용도로 큐(Queue)를 사용한다.
노드를 하나 처리할 때마다 해당 노드와 인접한 노드들을 큐에 다시 저장한다.
노드를 접근한 순서대로 처리할 수 있다.
캐시(Cache) 구현
우선순위가 같은 작업 예약 (인쇄 대기열)
선입선출이 필요한 대기열 (티켓 카운터)
콜센터 고객 대기시간
프린터의 출력 처리
윈도 시스템의 메시지 처리기
프로세스 관리
```

# 우선순위 큐
* 완전이진 트리

# 데큐
* C++ 에서는 양쪽으로 추가하는 건 데큐가 더 빠르고 한쪽은 백터가 더 빠르다

# 프린터 큐
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken());

		for (int t = 0; t < testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int docCount = Integer.parseInt(st.nextToken());
			int wantToKnowNumOrder = Integer.parseInt(st.nextToken());
			PriorityQueue priority = new PriorityQueue<>(Collections.reverseOrder());
			int[] priorities = new int[docCount];
			int answer = 1;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < docCount; i++) {
				int importanceNum = Integer.parseInt(st.nextToken());
				priority.add(importanceNum);
				priorities[i] = importanceNum;
			}

			while (!priority.isEmpty()) {
				for (int i = 0; i < priorities.length; i++) {
					if (priorities[i] == (int) priority.peek()) {
						if (i == wantToKnowNumOrder) {
							System.out.println(answer);
							priority.clear();
							break;
						}
						priority.poll();
						answer++;
					}
				}
			}

		}
	}
}
```
