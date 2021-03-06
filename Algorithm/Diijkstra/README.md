# [다익스트라](https://alswnsdl.tistory.com/12)
# [동빈나](https://www.youtube.com/watch?time_continue=1&v=611B-9zk2o4&feature=emb_logo)

# 최단거리 구하는 알고리즘
```java
ㅁ다익스트라 알고리즘

ㅁ벨만포드 알고리즘

ㅁ플로이드 와샬 알고리즘  
```

## 주의사항
```java
다익스트라 알고리즘은 한점(시작점)을 기준으로 나머지 모든 점에 대해서 최단거리를 구하는 것입니다.

주의사항은 다익스트라는 모든 가중치(값)가 음수가 아닐때만 사용할수 있습니다.



다익스트라의 기본원리 : 

ㅁ 방문하지않은 점중 값이 가장 작은 점을 방문한다

ㅁ 그점을 통해서 갈 수 있는 점 중에서 아직 방문하지 않은점의 값이 이전에 기록한 값보다 작으면 그 거리를 갱신한다.

```

## 과정
```java
  1. 출발 노드를 설정합니다.
  2. 출발 노드를 기준으로 각 노드의 최소 비용을 저장합니다.
  3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택합니다.
  4. 해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 최소 비용을 갱신합니다.
  5. 위 과정에서 3번 ~ 4번을 반복합니다.
```


## [코드](https://www.crocus.co.kr/546)


# AStar
```java
길찾기 알고리즘이라고 하면 보통 가장 먼저 떠오르는 알고리즘은 기초적으로 배우는 다익스트라 
알고리즘(Dijkstra algorithm)이라고 생각합니다. 최단거리를 찾아주는 대표적인 알고리즘이지만, 
실제 프로그램에 적용하기에 문제가 되는 부분이 있습니다. 다익스트라 알고리즘은 경로를 찾을 때 
각 노드에서 목적지 까지의 모든 경로에 대한 실제 비용을 계산하여 비교하기 때문에 알고리즘 수행 시간이 많이 든다는 것입니다.1

이러한 문제를 해결하기 위해서 다음 노드로의 분기를 모든 노드가 아닌 가장 적은 추정 비용을 갖는 
노드로 이동할 수 있게 휴리스틱 함수(Heuristic Function)2를 적용한다면 각 노드에서 분기를 줄일 수 있습니다. 
이를 대표하는 탐색 알고리즘인 A*A Star에 대해 알아보겠습니다.
```
