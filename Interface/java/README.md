# 인터페이스
```java
인터페이스

서비스 공급자와 자신의 객체가 해당 서비스를 사용할 수 있게 하려는 클래스가 있을 때, 이 두 클래스 사이의 계약을 표현하는 매커니즘

* 인터페이스의 모든 메서드는 자동으로 public이 된다.

타입변환

상위 인터페이스 타입의 변수는 하위 인터페이스에서 상위인터페이스를 구현한 어떤 클래스의 객체라도 참조할 수 있다.

가끔 역으로 슈퍼타입에서 서브타입으로 하는 것도 필요하다. 이럴 때는 변환을 해야한다.

IntSequence sequence = ......;

DigitSequence digits = (DigitSequence) sequence;

System.out.println(digits.rest());

여기서 rest()는 IntSequence의 메서드가 아니라 DigitSequence의 메서드다. 따라서 타입변환을 해서 사용했다.

instanceof

instanceof 연산자로 객체의 타입을 검사할 수 있다.

객체 instanceof 타입  => if(sequence instanceof DigitSequence){}

여러인터페이스 구현하기

인터페이스는 몇개든 구현할 수 있다. implements ~~,~~,~~,~~,....{}

인터페이스에서 상수는 자동으로 public static final이다.

* 인터페이스 안에는 인스턴스 변수를 둘 수 없다. 인터페이스는 객체의 상태가 아니라 동작을 명시한다. (**메서드)


좋아요공감
공유하기 글 요소구독하기

```

```java
인터페이스 기본메서드

인터페이스 메서드 중 어느 것이든 기본 구현을 작성할 수 있다. (추상클래스는 안됨)

인터페이스 메서드 충돌

public interface Person{

default int getId(){return 0;}

}

public interface Identified{

default int getId(){return Math.abs(hashCode());}

}

이렇게 두개의 인터페이스가 있을 때 하나의 클래스에서 두 인터페이스를 상속받으면 어떻게 해야할까?

방법은 고유의 getId()를 클래스에서 새로 작성하거나, 명시하는 방법이다.

public class Employee implements Person , Identified{

public int getId() {return Identified.super.getId();}

}

인터페이스 예

Comparable 인터페이스 / Comparator 인터페이스 / Runnable 인터페이스 등...

찾아보고 사용해보도록 하자.


```

```java
1. 자바 인터페이스 변경점
자바 8에서 대대적인 변화중 하나인 인터페이스에 변경점이 있습니다.

과거에는 인터페이스와 추상클래스의 차이점에 대한 질문이 면접에 가끔 등장했으나, 요새는 인터페이스의 변경점으로 인해 
인터페이스에 대해 물어보는 질문이 더 자주 등장하는 것 같습니다.

(자바8은 2014년에 나왔고, 현재 2020년에는 JDK14가 나왔는데 뒤늦게 뭔 자바8이야? 라고 하실 수 있지만, 결국 해당 변경점이 
어떤 문제를 해결하기 위한 변경 혹은 기술인지 이해하고 사용하는게 중요하기 때문에 공부한 내용을 정리했습니다.)

각설하고... 자바 인터페이스의 변경점은 두 가지가 있습니다.

Default Method
Static Method
기존(자바7 이전)에는 추상 메서드 선언 및 상수 정의만 가능했습니다.

그런데 자바8부터는 default method와 static method를 추가 정의할 수 있게 되었습니다.

2. Default Method
default method는 인터페이스에서 기본 구현을 갖는 메서드입니다.

인터페이스라 함은 추상 메서드를 정의하고 인터페이스를 구현하는 클래스에서 추상 메서드를 구현하는 것이었습니다.

그런데 이제는 그 구현마저 인터페이스에서 해줄 수 있다는 것입니다.

2.1 사용 예시
interface 인터페이스이름{

    //인터페이스의 추상 메서드
    리턴타입 메서드명(파라미터, ...);

    //default method
    default 리턴타입 메서드이름(파라미터, ...){
        //... 구현 부분
    }

}
위와 같이 default 라는 키워드를 메서드에 붙여주고 일반 함수를 구현하듯이 구현 부분을 작성하기만 하면 됩니다.

아래에서는 실제 Iterable인터페이스의 코드를 가져왔습니다.

public interface Iterable<T> {
    Iterator<T> iterator();

    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

    default Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}
주석은 제거한 코드 이며 자바7 이전에는 아래와 같이 단일 추상메서드를 갖는 인터페이스였습니다.

public interface Iterable<T> {
    Iterator<T> iterator();
}
2.2 어떤 문제를 해결하기 위한 기술인가?
이유야 여러가지가 있겠지만 단편적으로는 하위호환성과 유연성입니다. (개인 의견이 포함되어 있습니다.)

iterable인터페이스를 자바7 프로젝트 소스 코드에서 많이 구현해놓은 상황이라고 가정해봅시다.

자바8에서 람다가 생기면서 새로운 인터페이스 메서드 forEach(Consumer<? super T> action)을 추가해야한다면 어떻게 해야할까요?

iterable인터페이스에 default method가 아닌 그냥 추상메서드로 forEach()를 추가해버리면, 기존에 자바7 이전의 소스 코드를 
구현한 프로젝트에서 자바8로 자바 버전을 업할 때는 iterable를 구현한 모든 클래스에서 forEach메서드를 구현해줘야합니다.

근데 인터페이스가 이것만 있을까요? 우리가 자주 쓰는 Map<K, V>도 인터페이스입니다. 여러 인터페이스가 변경이 생기고 그거에 
대응하려면 굉장히 불편하고 쉽게 인터페이스를 바꿀 수 없을 것입니다.

결과적으로 수 많은 인터페이스에 뭔가 변경이 일어나면 같이 변경해야줘야 구현체가 훨씬 많아진다는 겁니다.

그래서 default method로 기본 구현을 제공해주면 기존 인터페이스를 구현했던 클래스에서 굳이 추가된 메서드를 구현해주지 않아도 
문제가 생기지 않습니다.

추후에 프로젝트에서 필요에 따라 해당 default method를 구현해서 쓸 수도 있습니다.

이렇게 해서 하위호환성을 지켜주면서 인터페이스 변경에 유연하게 대처할 방안을 만들어 둔 것과 같습니다.

추가로 만약 기존의 인터페이스를 deprecated 시키고 싶으면 어떻게 할까요?

public interface Iterator<E> {

    boolean hasNext();

    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
Iterator인터페이스의 remove()메서드 처럼 해주면 됩니다.

자바7 이전에 구현한 사람들은 remove()도 반드시 구현해줬어야해서 구현했겠지만, 자바8이후부터는 굳이 override하지 않으면 
구현을 안 하고 잊혀지게(?) 할 수 있습니다.

3. Static Method
클래스에서의 static method와 같이 인터페이스에서의 static method입니다.

3.1 사용 예시
interface 인터페이스이름{

    //인터페이스의 추상 메서드
    리턴타입 메서드명(파라미터, ...);

    //static method
    public static 리턴타입 메서드이름(파라미터, ...){
        //... 구현 부분
    }

}
실제 Comparator 인터페이스의 static method는 아래와 같습니다.

@FunctionalInterface
public interface Comparator<T> {
    //생략...
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
            (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }
    //...생략
}
정렬을 위한 비교를 할 때, Comparator.comparing(Function) 으로 간단하게 축약하는 유틸리티 메서드를 이용할 수 있는 것을 볼 수 있습니다.

3.2 어떤 문제를 해결하기 위한 기술인가?
굳이 왜 인터페이스에 static method를 쓰는가할 수 있지만 여느 static method처럼 유틸 메서드를 갖게하기 위함인 것 같습니다. (개인의견...)

Collection 인터페이스가 있는데 Collections.sort()같이 Collections라는 유틸 메서드를 위한 클래스가 따로 있는 상황이죠.

이런 상황을 개선하기 위해서 직관성을 위해(?) 인터페이스의 static method를 만들지 않았을까합니다.

3.3 참고할 것
static method는 재정의(override) 불가하다.
public static final 상수 선언할 때는 static block에서 초기화 할 수 없고 반드시 선언과 동시에 초기화 해야한다.
참고
```
