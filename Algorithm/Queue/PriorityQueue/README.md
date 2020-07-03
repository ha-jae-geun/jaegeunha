# 우선순위 큐
* 모든 데이터가 우선순위 데이터를 가지고 있고 들어온 순서와 상관 없이 우선순위가 높은 데이터가 먼저 출력되는 큐.

```java
우선순위 큐를 구현하는 방법은 세 가지로 나뉘어진다.

1. 배열을 기반으로 구현하는 방법
2. 연결리스트를 기반으로 구현 하는 방법
3. 힙(Heap)을 이용하는 방법
 

배열이나 연결리스트를 이용해서 우선순위 큐를 구현할 경우

간단하게 구현이 가능하다.

 

하지만 배열의 경우에는 이러한 단점이 따른다.

"데이터 삽입 및 삭제과정에서 데이터를 한 칸씩 당기거나 밀어야 하는 연산을 계속 하여야 한다."

그리고 또 하나의 문제가 있다.

"삽입의 위치를 찾기 위해 배열에 저장된 모든 데이터와 우선순위를 비교해야 한다."

이 경우는 우선순위가 가장 낮은 데이터를 저장하는 경우에 발생할 최악의 경우이다.

꼭 이런 최악의 경우가 아니더라도 이러한 일이 빈번하게 일어날수 있다.

 

그러면 연결리스트의 경우는 어떠할까??

배열의 첫번째 문제는 별로 되지 않지만

"삽입의 위치를 찾기 위해 첫번째 노드에서부터 시작해 마지막 노드에 저장된 데이터와 우선순위를 비교를 진행할지도 모른다."

이 경우 데이터가 적을 경우에는 별 단점이 될 수는 없겠지만 데이터가 많아질 때 노드의 수에 비례해서 비교할 대상이 증가하므로

성능이 저하된다.

 

그래서 우선순위 큐는 주로 힙(Heap)을 이용해서 구현하는 것이 일반적이다..

 

힙을 기반으로 우선 순위 큐를 구현하고자 한다.

힙의 구현을 위해서 데이터의 저장과 삭제 방법을 알아보자

(데이터의 저장 과정을 '최소 힙'을 기준으로 설명하려고 한다)

https://hannom.tistory.com/36
```