# Generic
```java
자바 제네릭 클래스 (Java Generic Class)

제네릭 클래스느 타입 파라미터를 한 개 이상 받는 클래스다.

public class Entry<K, V>{

private K key;

private V value;

public Entry(K key, V value){

this.key = key;

this.value = value;

}

public K getKey(){ return key;}

public V getValue(){ return value;}

}

위에서 K, V 는 타입파라미터다.

* 파라미터 타입으로 기본타입이 올 수 없다.

제네릭 클래스 생성

Entry<String , Integer> entry = new Entry<>("Fred",42); // <> 안의 생략 가능

제네릭 메서드

public class Arrays{

public static <T> void swap(T[] array, int i, int j){

T temp = array[i];

array[i] = array[j];

array[j] = temp;

}

}

배열에 들어 있는 요소의 타입이 기본타입만 아니면 swap 메서드로 배열에 들어있는 요소를 교환할 수 있다.

제네릭 메서드를 선언할 때는 타입 파라미터를 제어자(public, static)와 반환타입 사이에 둔다.

타입 경계

제네릭 클래스나 제네렉 메서드가 받는 타입 파라미터에 진짜 아무거나 오는게 아니라 제한해야할 때가 있다.

이때 타입 경계를 지정한다. 그러면 특정 클래스를 확장하게 하거나 인터페이스를 구현하게 할 수 있다.

public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception{

for (T elem : elems) elem.close();

}

* extends AutoCloseable이 AutoCloseable의 서브타입임을 보장한다.

위 예에서 ArrayList<PrintStream>은 가능하지만 ArrayList<String>은 불가능하다. PrintStream이 AutoCloseable의 서브타입 이기 때문에.

타입가변성과 와일드카드

public static void process(Employee[] staff){..}

이런 메서드에서 Manager가 Employee의 서브클래스면 Manager[]도 Employee[]의 서브타입이므로 Manager[]배열을 이 메서드에 전달할 수 있다.

그런데 ArrayList<Manager>는 ArrayList<Employee>의 서브타입이 아니다. 이럴땐 어떻게 할까?

public static void printNames(ArrayList<? extends Employee> staff){...}

와일드카드 타입 "? extends Employee" 를 사용해서 미지의 Employee 서브타입을 가리키면 된다.

단, extends Employee를 Employee로 변환할 수 있지만, 어떤 것도 절대 ? extends Employee로는 변환할 수 없다. 

바로 이 점이 ArrayList<? extends Employee>에서 
읽을 수는 있지만 쓸 수 없는 이유다.
```
