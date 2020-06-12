# Optional
```java
Java8 Optional

자바8이 나온지도 3년이 되었고 오라클 JDK의 LTS 버전인 자바11도 나왔는데 웬 자바8의 기능을 소개하냐! 하는 분도 있겠지만, 
이제서야 자바8을 도입하는 회사들도 많이 있고 제 공부를 위한 것이니 즐겁게 사용해봅시다.

Optional은 Null Pointer Exception(이하 NPE) 처리를 돕는 Wrapper Class다.

보통 자바 개발을 하면서 당연하게 객체(Object)를 만들어 사용한다.

그런데 C,C++에서 사용하던 포인터를 감췄다는 자바에서도 객체에는 포인터를 사용한다. (reference)

그렇기 때문에 모든 객체는 NPE에 대한 검사가 필요하고 방지하는 코드도 필요하다.

1
2
List<String> list = getList();
List<String> listOpt = list != null ? list : new ArrayList<>();
cs
위의 예와 같이 어떤 메소드로 부터 리턴받은 객체가 null일 수 있기에 사용하기 전에 조건문(if)으로 항상 검사하고 대비책을 적용했다.

근데 이게 자바프로그래밍에서 쓰이는 객체가 수십개도 아니고 엄청나게 많은게 문제다.

그것을 일일이 처리해주면 소프트웨어 안정성을 얻는 대신, 비즈니스 서비스 외에 불필요하게(?) 코드가 길어지고 읽기 어려워지는 문제가 생긴다.

그렇다고 NPE를 처리하지 않을 수도 없다.

그래서 적용가능한 아이디어로 Optional 이라는 "Wrapper" 클래스가 생겼다.

Wrapper를 강조하는 이유는 Optional<>로 어떤 객체든 Optional로 감싸 적용이 가능하고,

Optional도 클래스이기 때문에 객체를 다루는 유용한 메서드들이 많이 있어 사용하기만 하면 되기 때문이다.

Optional 예제


public Family method1() {
    Family family = new Family();
    //...
    family.setCount(3);
    //...
    return family;
}
 
public void test(){
    //해당 객체의 null을 검사할 수 있는 wrapper 클래스를 만든다.
    Optional<Family> optFamily = Optional.ofNullable(method1());
    //ifPresent로 직접 해당객체가 null이 아닐 때 action을 줄 수 있고
    optFamily.ifPresent(x->System.out.println(x.getCount()));
    //orElse로 받아온 객체가 null일 때는 빈 객체를 만들어서 리턴받을 수도 있다.
    Family family = optFamily.orElse(new Family());
}
Colored by Color Scripter
cs
예제를 만들어 봤다.

사용법

1. Optional.ofNullable(object)로 어떤 object를 감싸는 Optional 클래스 객체를 생성한다.

위에서는 method1()으로 부터 Family객체 하나를 받아오고 그것을 감싸는 Optional 클래스를 생성했다.

2. Optional 객체가 제공하는 메서드들을 이용해서 null 체크 및 작업을 수행한다.

위에서는 ifPresent()라는 메서드를 이용해서 내부에 object가 null이 아니고 존재할 때에 객체 x로 받아와서 수행할 함수까지 준것이고

또 다른 방법으로 orElse()라는 메서드를 이용해서 만약 object가 null이면 대신할 객체를 넣어주는 방법을 사용해봤다.

큰 틀에서 보면 Optional<>로 객체를 생성하고, 메서드로 null 검사 및 수행이다.

그러면 생성하는 방법과 메서드 api를 익히면 얼마든지 사용할 수 있는 것이다.

다음에서 

Optional을 생성하는 방법 3가지

1. Optional.empty(); : 빈 Optional 객체를 만드는 방법.

2. Optional.of(obj); : obj를 감싸는 Optional 객체를 만드는데 이 객체(obj)는 절대 null이 발생하지 않을 
것이라는 것을 알고 생성하는 방법. (= null 체크를 하는 지금 상황에 맞지 않음) 

3. Optional.ofNullable(obj); : Nullable. 말 그대로 안에 객체가 null일 수 있다는 의미로 생성하는 방법.

=> 결국은 실무에 적용할 때 Optional.ofNullable(...)만 쓸 것 같다. (뭔가 특수한 상황을 제외하곤...)

위의 3가지 방법으로 Optional 객체를 생성할 수 있다.

위에서 사용한대로 Optional<클래스명>의 변수에 담고 이용하면 된다.

Optional Method API

isPresent(), ifPresent(), get() :

1
2
3
if(optFamily.isPresent()) {
    Family f = optFamily.get();
}


isPresent()는 null인지 아닌지를 boolean 값으로 리턴하고, get()은 Optional로 감싸져 있는 object를 다시 풀어서 가져오는 메서드다.

ifPresent같은 경우에는 예제에서 보여줬듯이 파라미터로 컨슈머를 받아서 해당 객체가 있을 때 action까지 줄 수 있는 메서드다.



filter(Predicate<T>) : 스트림에서는 여러 데이터에서 filter로 걸러서 조건을 만족하는 데이터'들'로 줄였지만 
단일 객체를 감싸는 Optional의 경우에서는 조건을 만족하는지 확인하는 용도로 쓰는 filter 기능이다.

역시나 filter는 null이 아닐 때에 적용된다. (즉, null도 아니고 해당 조건도 만족하는 Optional<T>를 리턴)



map(Function<T,R>) : map은 어떤 T의 값을 R로 변경시켜주는 메서드다. R은 그냥 객체다.

flatMap(Function<T,R>) : flatMap은 map과 똑같이 T를 R로 변경시켜주는 메서드지만 R이 여기서는 그냥 객체가 
아닌 Optional<객체>다. 즉 파라미터로 Optional을 리턴하는 람다식을 받는 것이다.

따라서 flatMap을 이용하면 계속해서 Optional 객체를 사용할 수 있다.



orElse(T) : 내부 객체를 반환하되 만약 내부 객체가 null이면 파라미터로 들어간 기본 값(T)을 반환한다.

orElseGet() : orElse()가 어떤 객체를 리턴한다면 orElseGet()은 파라미터로 supplier 메서드를 넣어서 해당 
람다표현식이 반환하는 결과값(객체)를 받아올 수 있는 것이다. 

orElseThrow() : 내부 객체를 반환하되 존재하지 않으면 파라미터에 있는 예외를 발생시킨다.

* 보통 클래스안에 기본 클래스만 있는 것이 아니라 여러가지 클래스들이 멤버변수로 존재하기 때문에 그것들을 검사할 때는 
전체적으로 바뀌어야할 것이 많다.

예를 들어 내부에 depth를 따라가서 만나는 클래스의 null을 확인하려면 중간중간 리턴하는 객체들을 다 Optional로 
지정해서 flatMap으로 하위 클래스로 변경하면서 찾는다든지 하는 작업이 필요하다...

또 다른 견해와 의문

일부 개발자들은 Optional이 엄청 좋은 코드인지에 대한 의문을 갖는다.

따지고보면 그렇게 드라마틱하게 좋은 해결방법이 아닐 수 있다.

리턴 타입이나 파라미터가 Optional이면 객체 직렬화/역직렬화에 악영향을 끼칠 우려가 있고,

디버깅할 때 에러를 찾을 때 어디서 빈 객체가 들어갔는지 확인하는데에 시간이 오래걸릴 수 있고,

기존의 방법중 객체에 초기값을 주는 코드로 많은 부분을 해결할 수도 있다.

하지만 지극히 개인적으로 생각했을 때, 새로 나온 것에 거부감을 느끼면 별로 좋지 않고 괜히 나온 것이 아니라 
여겨지기 때문에 Optional을 사용할 수 있는 환경이라면 사용해볼 것이다.

다른 분들도 직접 사용해보긴 했으면 좋겠다.
```
