# 람다
```java
람다표현식

한번이든 여러번이든 나중에 실행할 수 있게 전달하는 코드 블록.

문법 : (String first , String second) -> first.length() - second.length()

(String first , String second) ->{

int difference = first.length() < second.length();

if(difference < 0) return -1;

else if(difference >0) return 1;

else return 0;

}

여러 줄로 작성할 떄는 메서드를 작성하는 것처럼 작성한다.

람다 표현식이 파라미터를 받지 않으면 파라미터가 없는 메서드처럼 빈 괄호를 붙임

Runnable task = () -> {for (int i=0;i<1000;i++) doWork(); }

파라미터 타입을 추론할 수 있으면 파라미터 생략 가능

(first , second) -> first.length() - second.length();

함수형 인터페이스

Runnable이나 Comparator처럼 액션을 표현하는 인터페이스가 많은데 람다표현식은 그런것들과 호환된다.

람다표현식은 추상메서드가 한개만 포함된 인터페이스에만 사용할 수 있다.

이러한 것들을 함수형 인터페이스라고 한다.

메서드 참조

1. 클래스::인스턴스메서드

2. 클래스::정적메서드

3. 객체::인스턴스메서드

1번의 예 String::compareToIgnoreCase 는 (x,y) -> x.compareToIgnoreCase(y)와 같다.

2번의 예 Object::isNull은 x ->Object.isNull(x)와 같다. 모든 파라미터가 정적 메서드로 전달된다.

3번의 예 System.out::println 은 x-> System.out.println(x) 와 같다.

생성자 참조

생성자 참조는 메서드 참조에서 메서드만 new로 바뀐것이다.

Employee::new
```

# 람다표현식 처리
```java
람다를 사용하는 핵심 목적은 지연 실행이다.

어떤 코드를 당장 사용하고 싶으면 람다를 사용할 필요가 없다.

* 별도의 스레드에서 코드 실행

* 코드를 여러번 실행

* 알고리즘의 올바른 지점에서 코드 실행

* 어떤 일이 일어날 때 코드 실행

* 필요할때만 코드 실행

람다를 받으려면 함수형 인터페이스를 선택or구현 해야한다.

public static void repeat(int n, Runnable action){

for(int i=0;i<n;i++) action.run();

} 

람다표현식 구현부는 action.run() 이 호출될 때 실행된다.


```
[타입 추론](https://bk-investing.tistory.com/47)

```java
자바 람다 입문
1. 람다란?
단 하나의 abstract method를 갖는 인터페이스를 구현한 익명 클래스 인스턴스를 표현하는 함수다.

(필자가 생각한 정의다.)

만약, 익명 클래스를 축약 표현(syntactic sugar)한 거라고 생각하면 되냐?! 라고 한다면 그건 또 아니다.

익명클래스는 내부 변수를 가질 수 있으나 람다는 불가능하다. this가 가리키는 것도 다르고 내부 동작도 좀 다르다고 한다. 

(근데 람다를 쓰면 익명의 클래스가 생성됨)

'람다식' 이라고도 표현하는데 대부분 람다를 쓸 때 표현식 즉, "코드 조각"으로 구현하기 때문에 그렇지 않을까한다.

2. 람다는 어떤 문제를 해결하기 위한 기술인가?
자바에서 람다는 함수형 프로그래밍 패러다임으로 전환하기 위한 하나의 '단계'다.

따라서 람다는 객체 지향 프로그래밍에서 발생할 수 있는 단점들 (익명 클래스 구현에서 발생하는 군더더기 코드 또는 작은 기능을 만들기 

위해 클래스와 메서드를 생성하면서 생기는 가독성 저하, 병렬처리에서 공유되는 자원에 대한 동시성 문제 등...)을 해결하기 위한 기술이다.

→ 꼭 객체 지향 프로그래밍만의 단점이라고 할 수 없지만, 발생할 수 있는 문제를 함수형 프로그래밍을 했을 때 얻는 장점으로 

커버하는 모습을 보인다. (필자 의견)

2.1 어떻게 문제를 해결했는가
함수(람다표현식)를 파라미터(인자)로 전달받거나, 함수의 결과로 함수(람다표현식)를 반환하도록 했다.
함수(람다표현식)를 변수에 할당할 수 있게 했다.
함수를 값처럼 취급할 수 있게 했다.
메서드를 매번 정의할 필요없이 바로 쓸 수 있게 했다.
→ 결국 익명 클래스의 인스턴스이기 때문에 기존의 정책대로 인스턴스는 함수의 리턴 타입이나 파라미터로 쓰일 수 있는 것이고, 

변수에 할당하면 일종의 값처럼 취급할 수 있게 된 것이다.

이렇게 가능하게 된 것도 인터페이스의 abstract method가 1개니까 인터페이스의 해당 메서드(함수)만 구현해주면 되기 때문이다.

파라미터나 리턴 타입을 인터페이스로 정의할 때 사전에 정의하기 때문에 표현식에서 타입을 따로 기입하지 않아 간결하고 명확하게 쓸 수 있다.

2.2 자바 람다의 한계
자바에서 람다를 함수형으로 새롭게 정의한 것이 아니라, 기존에 쓰던 인터페이스의 형태를 축약형으로 표현하기 때문에 

완전히 함수형 프로그래밍 패러다임에 적용할 수 없는 한계가 있다.

= 오직 함수형 인터페이스를 기대하는 곳에서만 람다를 사용할 수 있다.

또한 람다식 내부에서 가리키는 외부 변수에 대해서 라이프 사이클을 연장할 수 없다.(=클로저 지원 불가)

필요에 따라 함수형 인터페이스를 만들 수 있긴 하다만... 다소 번거롭고 해당 인터페이스를 같이 개발하는 개발자가 일일이 확인해야하는 불편도 있다.

람다 표현법을 알기 전에 함수형 인터페이스에 대해 알아본다.

3. Functional Interface
3.1 @FunctionalInterface
단 하나의 "추상 메서드(abstract method)"를 갖는 인터페이스를 함수형 인터페이스라고 한다.

자바8부터는 인터페이스가 static method, default method를 가질 수 있기 때문에 단순히 함수가 하나만 존재하는 

인터페이스라고 얘기하면 엄밀하게 얘기하면 틀린 얘기다.

아래 코드는 java.util.function 패키지에 있는 Function<T, R>인터페이스에서 주석을 제거한 소스 코드다.

보다시피 default 메서드와 static 메서드가 있는 것을 볼 수 있다.

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
3.2 @FunctionalInterface가 적용된 인터페이스 만들기
이미 자바에서 제공하는 Function, Supplier, Consumer 등이 있으나 내가 필요에 의해서 만들 수 있다.

@FunctionalInterface
public interface TripleConsumer<T, U, V> {
        void accept(T t, U u, V v);
}
BiConusmer<T, U>를 자바에서 제공하는데, TripleConsumer라는 파라미터를 3개를 갖는 컨슈머 인터페이스를 만들어봤다.

사실 이렇게 일일이 함수형 인터페이스를 만들고, 구현하는 람다식을 활용하는 일은 개인적으로 거의 없었다.

하지만 자바에서 이미 만들어서 제공하는 인터페이스를 쓰는 일은 많았다.

입문을 하는 것이라면 '함수형 인터페이스가 제공되야 하는 구나' 정도 알고 넘어가고 '람다 표현식이 어떻게 쓰이는 구나'정도 알면 된다.

4. 람다 표현식
(param1, param2) -> {System.out.println(param1 + ", " + param2);}
'->'(화살표 모양)을 기준으로 왼쪽에는 함수형 인터페이스의 파라미터에 해당하는 값이 기술하는 부분이고,

'->'(화살표 모양)은 람다 표현식의 본문과 파라미터는 분리하는 역할이라고 보면 된다.

위의 예시에서 {}중괄호로 묶은 부분을 본문(Body)이라하고 구현하고자 하는 내용을 기술하는 부분이다.

파라미터값이 없는 경우에는 ()->{...} 이렇게 설정할 수도 있고, 본문의 내용이 한 줄이면 굳이 중괄호를 쓰지 않고 표현할 수도 있다.

또한 return 값이 있을 때도 한 줄이면 굳이 {return ...} 이렇게 표현하지 않아도 된다.

4.1 활용 예시
List<Apple> apples = new ArrayList<>();
//apples.add(new Apple(...))
//... 사과 추가 과정 생략
int sum = apples.stream()
                .filter(apple -> apple.getWeight() > 150)
                .map(apple -> apple.getPrice())
                .reduce(0, (a, b) -> a + b);
apples는 사과 클래스의 인스턴스들이 담겨있는 리스트라고 가정하고 스트림과 연계하여 다양한 람다를 활용해봤다.

filter는 Predicate, map은 Function<T, R>, reduce는 BiFunction + BinaryOperator 를 구현한 예제다.

로직을 간단히 설명하면, 사과의 무게가 150g이상인 것들을 필터링하고 그 사과들의 가격으로 스트림으로 변환 후, 그 가격들을 다 더하여 sum으로 나타낸 것이다.

반복문을 직접 구현하며 로직을 구성하는 것 대비 훨씬 코드가 간결할 뿐더러 가독성에도 큰 도움이 된다.

람다와 관련된 포스트이므로 스트림의 효과는 생략하겠다.

5. 메서드 참조
람다표현식을 매 번 직접 구현해서 사용했는데 경우에 따라서는 함수형 인터페이스와 메서드 시그니처가 맞는 즉, 파라미터, 리턴 타입 등이 같은 메서드의 경우 적용이 가능하다.

map()도 Function<T, R> 이니까 T타입의 객체를 받아 R타입의 객체로 변환하는 기능을 한다.

public class Apple{
    private int price;
    //...
    public int getPrice(){
        return this.price;
    }
    //...
}
Apple클래스의 getPrice()도 같은 시그니처를 갖는다. 사과 클래스에서 가격 정보를 int형으로 변환해준다.

이 경우에는 '메서드 참조'라는 것을 이용해서 더 간결하게 표현할 수도 있다.

//예시
ClassName::staticMethod
ClassName::instanceMethod

int sum = apples.stream()
                .filter(apple -> apple.getWeight() > 150)
                .map(Apple::getPrice) //메서드 참조
                .reduce(0, (a, b) -> a + b);
6. 생성자 참조
메서드 참조랑 유사한 형태고 생성자도 메서드라고 볼 수 있으므로 사용이 가능하다.

만약 Supplier 함수형 인터페이스를 구현해야한다고 할 때 다음과 같이 쓸 수 있다.

Apple::new
기본적인 람다 입문을 이렇게 정리하고 스트림을 공부하고 연계하면서 더 알아가는 것으로 마무리한다.

별첨 함수형 프로그래밍의 핵심 아이디어 2가지
람다를 일급 객체로 사용한다.
가변 공유 상태 값이 없이 병렬 실행하여 효율적이고 안전한 함수 또는 메서드 호출이 가능하다.
참고 자료

도서 - 모던 자바 인 액션(Modern Java in Action) - 한빛미디어
```


# [익명클래스보다는 람다](https://bk-investing.tistory.com/47)

# [람다보다는 메서드 참조](https://bk-investing.tistory.com/48)
