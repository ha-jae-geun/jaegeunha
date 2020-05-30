# [JCT](https://github.com/ha-jae-geun/jaegeunha/tree/master/PL/java/JCF/README.md)

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

## 큐
* 큐, 우선순위 큐, 환형 큐, 데큐

# 우선순위 큐
* 완전이진 트리

# 데큐
* C++ 에서는 양쪽으로 추가하는 건 데큐가 더 빠르고 한쪽은 백터가 더 빠르다

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

## 우선순위 큐
```java
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

우선순위 큐의 삭제는 가장 높은 우선 순위의 데이터 삭제를 의미 한다.

힙에서 루트 노드를 삭제한다는 것은 그다지 어렵지 않다.

하지만 루트 노드를 삭제한 뒤에 빈 루트노드를 어떻게 채울까???
마지막 노드를 루트 노드의 자리로 옮긴 뒤 자식 노드와의 비교를 통해 제자리를 찾아가게 한다!

 
```

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

## HashMap Iterator
```java
Map인터페이스를 구현한 컬렉션 클래스도 iterator()를 사용할 수 있다. 하지만 키(key)와 값(value)을 쌍으로 저장하고 있기
때문에 iterator()를 직접 호출할 수 없고, 그 대신 keySet(), entrySet()과 같은 메서드를 통해서 
키와 값을 각각 따로 Set의 형태로 얻어온 후 다시 iterator()를 호출해야만 Iterator를 얻을 수 있다.

Map map = new HashMap();
Iterator iterator = map.keySet().iterator();
Java
Iterator 예제 1
public class IteratorEx1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
Java
1
2
3
4
5
None
List클래스들은 저장순서를 유지하기 때문에 Iterator를 이용해서 읽어온 결과 역시 저장순서와 
동일하지만 Set클래스의 경우는 각 요소간의 순서가 유지되지 않기 때문에 Iterator를 이용해서 
저장된 요소들을 읽어오더라도 처음 저장한 순서와 동일하지 않다.
```

## ListIterator
```java
3. ListIterator, Enumeration
Enumeration : Iterator의 구버전
ListIterator : Iterator에 양방향 조회기능 추가(List인터페이스를 구현한 경우만 사용가능)
ListIterator 예제 1
public class ListIteratorEx1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        ListIterator listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            // 순반향으로 진행하면서 읽어옴
            System.out.println(listIterator.next());
        }
        System.out.println();

        while (listIterator.hasPrevious()) {
            // 역방향으로 진행하면서 읽어옴
            System.out.println(listIterator.previous());
        }
        System.out.println();
    }
}

Iterator는 단방향으로만 이동하기 때문에 컬렉션의 마지막 요소에 다다르면 더이상 사용할 수 없다.
ListIterator는 양방향으로 이동하기 때문에 각 요소간의 이동이 자유롭다.
이동하기 전에는 반드시 hasNext()나 hasPrevious()를 호출해서 이동할 수 있는지를 확인해야한다.
Iterator 예제 2
public class IteratorEx2 {
    public static void main(String[] args) {
        ArrayList original = new ArrayList(10);
        ArrayList copy1 = new ArrayList(10);
        ArrayList copy2 = new ArrayList(10);

        for (int i = 0; i < 10; i++)
            original.add(i +"");

        Iterator iterator = original.iterator();

        while (iterator.hasNext())
            copy1.add(iterator.next());

        System.out.println("original에서 copy1으로 복사");
        System.out.println("original : " + original);
        System.out.println("copy1 : " + copy1);
        System.out.println();

        // Iterator는 재사용이 안되기 때문에 다시 얻어와야함
        iterator = original.iterator();

        while (iterator.hasNext()) {
            copy2.add(iterator.next());
            iterator.remove();
        }

        System.out.println("original에서 copy2으로 이동");
        System.out.println("original : " + original);
        System.out.println("copy2 : " + copy2);
    }
}

original에서 copy1으로 복사
original : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
copy1 : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

original에서 copy2으로 이동
original : []
copy2 : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
None
Iterator의 remove()는 단독으로 쓰일 수 없고, next()와 같이 써야한다.
특정위치의 요소를 삭제하는 것이 아니라 읽어온 것을 삭제한다.
만약 next()의 호출 없이 remove()를 호출하면 IllegalStateException이 발생한다.
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


