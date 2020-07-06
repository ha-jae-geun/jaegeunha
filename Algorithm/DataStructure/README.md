# List, Set, Map의 차이
# List
* LinkedList
* Stack
* Vector
* ArrayList
 * 순서가 있는 데이터의 집합, 데이터의 중복을 허용한다.
 * List와 Set은 공통적으로 Iterator을 사용할 수 있다. 
 * List, Set => Collection => Iterable의 순서로 implements 하고 있다.

## List Interface
* List Interface 
* Collection 인터페이스를 확장한 자료형으로 요소들의 순서를 저장하여 색인(Index)를 사용하여 특정 위치에 요소를 삽입하거나 접근할 수 있으며 중복 요소 허용

## LinkedList
* LinkedList의 경우 인자로 전달된 인덱스의 요소를 가져오기위해서는 항상 첫 노드에서부터 찾아 들어가야하기때문에 get()의 시간복잡도는 O(n)이다. for문과 결합되면 2중 반복문으로 돌아서 O(n^2)이 되는것이다. 

### List와for-each문
* [출처](' https://multifrontgarden.tistory.com/130')
* LinkedList의 경우 인자로 전달된 인덱스의 요소를 가져오기위해서는 항상 첫 노드에서부터 찾아 들어가야하기때문에 get()의 시간복잡도는 O(n)이다. for문과 결합되면 2중 반복문으로 돌아서 O(n^2)이 되는것이다. 
* for-each 문은 인덱스를 명시할 필요없이 알아서 리스트 사이즈만큼 반복되기때문에 에러여지도 없어지고 코드도 간결해지는 매우 유용한 문법이지만 한가지 치명적인 문제점이 있다. 그것은 인덱스를 사용할 수 없다는 것이다. 얼마전 현업에서 이 문제에 부딪힌적이 있었는데 아무생각없이 인덱스를 사용하기 위한 반복문을 돌렸다.
* 뭐 특별한 해결법은 없다. 다만 개인적으로 인덱스가 필요한 경우는 메서드 분리나 구조변경을 통해 리팩토링이 가능한 경우가 많았다.
* List를 반복할때는 꼭 for-each나 Iterator를 사용하고, 인덱스가 필요한 경우는 명시적으로 인덱스를 사용하지않을 수 있게 리팩토링할 수는 없는지 고민해보자.


# foreach
* [출처]('https://namocom.tistory.com/754')
* 1번의 forEach 정의는 일단 Iterable이라는 인터페이스에 정의되어 있다.


# Iterator, Iterable 차이점
1. Iterator 그리고 Iterable은 자바 컬렉션 인터페이스에서 제공을 하며 매우 비슷하고 종종 혼란을 주긴 하지만 Iterator, Iterable 다른 점이 있다. 만약 어떤 클래스에 iterable 인터페이스를 implements를 하면 iterator를 사용해 클래스를 반복 작업을 할 수 있는 능력이 생긴다.
2. Iterable interface를 implements 하는 클래스는 iterator()를 오버라이드를 해야하고 iterable interface에서 메소드를 제공한다. Iterator interface를 implements 하는 클래스는 hasNext(), next() 메소드를 오버라이드 해야한다. iterator interface에서 메소드를 제공한다.
3. Iterator instance는 iteration 상태를 모아둔 곳이다. 현재 element에 대해 다음 element가 존재하고 다음 element로 이동하는 유용한 메소드를 Iterator는 제공을 한다. Iterator는 컬렉션 내의 현재 위치를 기억한다. 다른 한편인 Iterable은 어떠한 iteration 상태 값을 가지지 못한다.
4. Iterable은 iterator() 메소드가 호출이 될 때마다 iterator의 새로운 instance를 생성해야 한다. 이러한 이유는 Iterator 인스턴스는 iteration상태를 유지해야하고 구현이 같은 iterator를 두 번리턴하는 일이 없어야 하기 때문이다.
* iterable은 순회할 수 있는 컬렉션을 나타낸다. Iterable 인터페이스를 implement하면 객체는 for-each loop를 사용할 수 있게 해준다. (내부적으로 iterator() 메소드를 객체에 호출해서 가능) 아래의 예제는 컬렉션 인터페이스가 iterable 인터페이스를 상속하고 있음을 보여준다
5. Iterable :ㄴ public Iterator iterator();  메소드를 구현하게 강제하기 위한 인터페이스.
6. Iterator : ㄴ public boolean hasNext();   /  public E next();  메소드를 구현하게 강제하기 위한 인터페이스
- Collection 인터페이스가 Iterable 인터페이스를 상속하고 있다. 
- Iterable 인터페이스는 내부에 Iterator 인터페이스를 리턴하는 메소드를 정의하고 있다.
- List와 Set을 구현하는 클래스에서는 Iterable의 iterator() 메소드를 구현해야 한다. 
- iterator() 메소드는 Iterator 인터페이스를 리턴한다. Iterator 인터페이스는 hasNext(), next() 메소드를 정의하고 있다 ( 이 부분을 구현하는 클래스를 내부적으로 구현해야 한다 )
- Itr 내부 클래스를 만들고 implements Iterator 하여 실제 hasNext(), next() 메소드와 기타 필요한 메소드를 구현하여 return 한다.
- 우리가 실제 사용하는 Iterator it = list.iterator() 는 어떤 List / Set 의 구현 클래스인지(ArrayList, LinkedList, HashSet, LinkedSet) 에 따라 Iterator의 메소드도 달라진다고 볼 수 있겠다. 

```java
List <String> persons = new ArrayList<>(Arrays.asList("A", "B", "C"));
for (String person: persons) {
System.out.println(person);
}
```
* 다른 한편으로는 Iterator 인터페이스는 다른 객체, 다른 종류의 컬렉션을 순회하게 해준다. Iterator를 사용해 순회하기 위해서는 hasNext() + next() 메소드를 사용할 수가 있다.

```java
Iterator <Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();
while (iterator.hasNext()) {
        System.out.println(iiterator.next());
}
```

* for-each loop에서 람다를 사용해서 Iterable 안의 Iterator로 컨버팅을 할 수 있다.
```java
for (Integer i: (Iterable<Interger>) () -> iterator) {
System.out.println(i);
}
```

# Set
* HashSet
* TreeSet
* 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다. 
* List와 Set은 공통적으로 Iterator을 사용할 수 있다. 
  * List, Set => Collection => Iterable의 순서로 implements 하고 있다.

## Set Interface
* 집합을 정의하며 요소의 중복을 허용하지 않음. 상위 메소드만 사용함




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
