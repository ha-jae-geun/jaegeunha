# 복사
```java
배열과 배열 리스트

배열 초기화에 new 연산자 필요하다.

배열이름.length로 배열의 길이를 얻을 수 있다.

기본타입이 아닌 객체배열을 생성했을 때는 초기화도 따로 해야한다.

배열리스트 = 제네릭클래스 ArrayList

기본 타입의 래퍼클래스 ArrayList<Integer> numbers = new ArrayList<>();

* 기본타입과 래퍼 타입 사이의 변환에서 유의할 것은 단 하나다. if( numbers.get(i) == numbers.get(j) ) 에서 처럼 ==을 

이용하면 안되고 equals를 이용해야 비교,검사가 된다는 것이다.

배열에서 복사

얕은 복사

int[] numbers = primes;

numbers[5] = 42; 하면 primes도 같은 배열을 참조하게 된다. 따라서 primes[5]도 같이 바뀐다.

이런 공유를 원하지 않는다면 정적메서드 Arrays.copyOf 를 사용한다.

깊은 복사

int[] copiedPrimes = Arrays.copyOf(primes,primes.length);

배열리스트에서 복사

얕은 복사

ArrayList<String> people = friends;

people.set(0,"Mary"); // friends.get(0)도 "Mary"다.

깊은 복사

Arraylist<String> copiedFriends = new ArrayList<>(friends);

복사하려면 기존 배열리스트에서 새로운 배열리스트를 생성해야 한다.

* 만약 배열을 배열리스트로 복사할 때는 ArrayList생성자를 이용하면된다.

단 , Arrays.asList로 배열을 리스트로 감싸야한다.

ArrayList<String> friends = new ArrayList<>(Arrays.asList(names)); // names는 배열

배열 알고리즘

Arrays와 Collections 클래스는 알고리즘 구현을 제공한다.

Arrays.fill(numbers, 0); // int[]

Collections.fill(friends, ""); // ArrayList<String>

Arrays.sort(names);

Collections.sort(friends);


```
