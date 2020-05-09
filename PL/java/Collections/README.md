# Collecions
```java
자바의 컬렉션은 안드로이드를 비롯한 현재의 자바 프로그램을 작성하는데 빼놓을 수 없는 중요한 도구에요.

일단 컬렉션이란 쉽게 말해서 객체들의 모음, 객체들의 컨테이너 정도로 말할 수 있어요.

자바의 JDK는 소위 자료 구조과목에서 배운 중요한 자료 구조들을 컬렉션으로 만들어 제공하기 때문에 이 부분을

잘 이애할 필요가 있어요.

여기서 컬렉션은 제네릭이라는 기법으로 구현되어 있어 제네릭에 대한 학습도 필요하구요

 

컬렉션을 사용하는 가장 큰 이유는

응용프로그램들은 실행 중에 생겨나고 사라지는 객체들의 개수를 예측할 수 없기 때문에 고정 크기의 배열을 사용한다면

프로그램 작성에 매우 어려움을 느낄거에요.

하지만 컬렉션은 이런 고정 크기의 배열이 가지는 단점을 극복하고 가변 개수의 객체들을 쉽게 삽입하고,

삭제와 검색을 할 수 있는 가변 크기의 컨테이너에요.

컬렉션은 요소(element)​라고 불리는 가변 개수의 객체들의 모임이라고 할 수 있으며

요소들을 관리하기 위해 요소의 추가, 삭제, 검색 등의 기능을 제공해요
```

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

## Array(배열)
* 원소에 대해 빠르게 접근할 수 있을 뿐만 아니라, 원소들이 메모리에 연속해 배치해 있어 CPU 캐시 효율도 더욱 높기 때문입니다.
* 배열의 원소를 삭제할 경우 삭제한 원소보다 큰 인덱스를 가진 원소들을 옮겨줘야(Shift) 하기 때문에 시간 복잡도 O(n)이 걸린다.
* 삽입의 경우, 새로운 원소를 추가하고 모든 원소들의 인덱스를 1씩 Shift 해줘야 하므로 시간 복잡도 O(n)이 걸린다

## ArrayList
* ArrayList 는 array 를 이용한 List 구현 방법입니다. 
* ArrayList 클래스는 내부적으로 배열을 이용하여 요소를 저장한다.

## LinkedList
* LinkedList의 경우 인자로 전달된 인덱스의 요소를 가져오기위해서는 항상 첫 노드에서부터 찾아 들어가야하기때문에 get()의 시간복잡도는 O(n)이다. for문과 결합되면 2중 반복문으로 돌아서 O(n^2)이 되는것이다. 

## ArrayList와 LinkedList 차이
```java
검색
데이터 검색 시에는 ArrayList는 LinkedList에 비해 굉장히 빠르다. ArrayList는 인덱스 기반의 자료 구조이며 
get(int index) 를 통해 O(1) 의 시간 복잡도를 가진다. 그에 비해 LinkedList는 검색 시 모든 요소를 
탐색해야 하기 때문에 최악의 경우에는 O(N)의 시간 복잡도를 가진다.

삽입, 삭제
LinkedList에서의 데이터의 삽입, 삭제 시에는 ArrayList와 비교해 굉장히 빠른데, LinkedList는 이전 노드와 
다음 노드를 참조하는 상태만 변경하면 되기 때문이다. 삽입, 삭제가 일어날 때 O(1)의 시작 복잡도를 가진다. 
반면 ArrayList의 경우 삽입, 삭제 이후 다른 데이터를 복사해야 하기 때문에 최악의 경우 O(N) 의 성능을 내게 된다.
```

### LinkedList 삽입 삭제
```java
삽입의 경우
일단, LinkedList는 어느 곳에 삽입하던지 O(n)의 시간복잡도를 갖는다. 
(만약, 중간 삽입이 없다면 즉 맨 앞과 맨 뒤에만 삽입한다면 -> 시간 복잡도 : O(1))

삭제의 경우
삭제의 경우도 삽입과 마찬가지이다. 어느 곳에 삽입하던지 O(n)의 시간 복잡도를 갖는다.
(만약, 중간 삭제가 없고 맨 앞과 뒤에서만 삭제한다면 -> 시간 복잡도 : O(1))
```

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
* HashMap
* TreeMap
* HashTable
* Properties
* 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합이다.
* 순서는 유지되지 않고, 키는 중복을 허용하지 않으며 값의 중복을 허용한다

## Map Interface
* Key와 Value의 쌍으로 연관지어 저장하는 객체


## [firework](https://firework-ham.tistory.com/11)
1. 먼저 키가 null인지 체크하고 null이면 hashcode는 0이기 때문에 위치 0에 저장됩니다.
2. hascode를 매소드를 호출하여 hascode를 적용 합니다.
   배열의 한도 내에서 값을 얻기 위해 key.hashcode()가 호출되고 일부 시프팅 연산을 수행합니다.
3. indexFor() 매소드는 Entry 객체를 저장할 정확한 위치를 가져올 때 사용합니다.
4. 만약, 두개의 다른 객체가 같은 hashcode를 가진다면 충돌이 이러나기 때문에 이를 처리하기 위해 next 속성을 가집니다. 같은 haschcode를 가지는 객체들은 서로 옆에 위치하게 됩니다.
5. 충돌이 나면 next 속성의 값을 체크하고 만약 null 이면 그 위치에 Entry 객체를 넣고 null이 아니면 next 객체의 next를 다시 불러 null일때까지 확인하고 객체를 저장합니다.

## Hashmap 중복
* HaspMap 내부에서 equals를 사용하고 동일한 것을 사용하다면 값을 대체 합니다.
* HashMap에서 중복되는 키 값을 막는 방법은? HashMap은 중복되는 키를 허용하지 않습니다.  동일한 키를 넣으면 오버라이드 되며 가장 최근 값이 반환됩니다.

```java

import java.util.HashMap;
import java.util.Map;
 
public class HashMapEg{
    public static void main(String[] args) {
            Map map = new HashMap();
            map.put(1,"sam");  
            map.put(1,"Ian");  
            map.put(1,"Scott");  
            map.put(null,"asdf");
 
            System.out.println(map); 
        }
}
```
* 위 예제에서는 null은 "asdf", 1은 "Scott"를 가지게 됩니다.

