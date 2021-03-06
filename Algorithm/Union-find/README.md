# [Union Find](https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html)
# [Union Find 개념](https://hombody.tistory.com/m/86?category=845480)
# [동빈나 영상](https://www.youtube.com/watch?v=AMByrd53PHM)
* Disjoint Set을 표현할 때 사용하는 알고리즘

## 정의
```java
서로 중복되지 않는 부분 집합들 로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조

즉, 공통 원소가 없는, 즉 “상호 배타적” 인 부분 집합들로 나눠진 원소들에 대한 자료구조이다.
Disjoint Set = 서로소 집합 자료구조
```

## 효율적인 구조
```java
Disjoint Set을 표현할 때 사용하는 알고리즘

집합을 구현하는 데는 비트 벡터, 배열, 연결 리스트를 이용할 수 있으나 그 중 가장 효율적인 트리 구조 (아래 참고*)를 이용하여 구현한다.
```


## 시간복잡도
```java
union(x, y)
배열의 모든 원소를 순회하면서 y의 집합 번호를 x의 집합 번호로 변경한다.
시간 복잡도: O(N)

find(x)
한 번만에 x가 속한 집합 번호를 찾는다.
시간 복잡도: O(1)
```
