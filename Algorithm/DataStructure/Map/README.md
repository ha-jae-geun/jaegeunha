# [MAP](https://gmlwjd9405.github.io/2017/10/01/basic-concepts-of-development-java.html)
```java

java Map 인터페이스 구현체의 종류

# HashMap
* Entry<K,V>의 배열로 저장되며, 배열의 index는 내부 해쉬 함수를 통해 계산된다.
* 내부 hash값에 따라서 키순서가 정해지므로 특정 규칙없이 출력된다.
* key와 value에 null값을 허용한다.
* 비동기 처리
* 시간복잡도: O(1)


# LinkedHashMap
* HaspMap을 상속받으며, Linked List로 저장된다.
* 입력 순서대로 출력된다.
* 비동기 처리
* 시간복잡도: O(n)

# TreeMap
* 내부적으로 레드-블랙 트리(Red-Black tree)로 저장된다.
* 키값이 기본적으로 오름차순 정렬되어 출력된다.
* 키값에 대한 Compartor 구현으로 정렬 방법을 지정할 수 있다.
* 시간복잡도: O(logn)
* ConCurrentHashMap
* multiple lock
* update할 때만 동기 처리
* key와 value에 null값을 허용하지 않는다.

# HashTable
* single lock
* 모든 메서드에 대해 동기 처리
* key와 value에 null값을 허용하지 않는다.
```


# Map 
# HashMap
* TreeMap
* HashTable
* Properties
* 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합이다.
* 순서는 유지되지 않고, 키는 중복을 허용하지 않으며 값의 중복을 허용한다

## Ordered Map
* map 은 기본적으로(대부분의 STL 컨테이너들이 그렇듯이) 레드블랙 트리(Red-Black Tree 이하 RB Tree) 기반으로 되어있습니다. 때문에 모든 데이터는 정렬되어 저장됩니다.

## Unordered Map(HashMap)
* 헤시 테이블로 구성되어 있다.

## Map Interface
* Key와 Value의 쌍으로 연관지어 저장하는 객체

## Map의 용도
* 연관있는 두 개의 값을 관리하는 경우
* 검색을 빠르게 하고 싶은 경우

## BigO
* map 은 O(logN)의 탐색 속도를, unordered_map은 O(1)의 탐색 속도
