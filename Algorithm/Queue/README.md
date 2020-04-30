# 우선순위 큐
* 완전이진 트리

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
