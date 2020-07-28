# [제네릭](https://www.youtube.com/watch?v=n28M8iryFPw&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=12)
* [정아마추어](https://jeong-pro.tistory.com/100?category=793347)
* 제네릭은 형변환의 번거로움을 줄이괴, 의도하지 않는 타입이 들어오는 것을 막기 위한 것(강력한 타입 체크)

## 참조변수와 생성자에 대입된 타입이 일치해야 한다
```java
Box<Fruit> fruitBox = new Box<Apple>();
Apple이 Fruit를 상속했어도 불가능하다
```

## 제네릭 클래스가 상속 관계인 것은 괜찮다
* Box<Fruit> fruitBox = new FruitBox<Fruit<>()
  * 제네릭 클래스가 상속 관계이므로 가능하다.
* Box<Fruit> grapeBox = new FruitBox<Apple>();
  * 단 여전히 대입되는 타입은 같아야 한다.

## 제네릭 메서드의 타입과 제네릭 클래스의 타입은 사로 다른 것이다
```java
public <T> void printParamClass(T time){
}
```

## 와일드카드
* 와일드 카드는 '?' 기호로 표현하고, 와일드 카드는 어떠한 타입도 될 수 있다.
* 와일드 카드를 사용하여 모든 타입이 들어올 수 있도록 수정할 수 있다.

```java
public static void printList(List<? extends Object> list) {

for(Objeect elem : list) {
 System.out.println();
}
```

# Generic
* 제네릭은 자바에서 안정성을 맡고 있다고 할 수 있다. 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에서 사용하는 것으로, 컴파일 과정에서 타입체크를 해주는 기능이다. 객체의 타입을 컴파일 시에 체크하기 때문에 객체의 타입 안전성을 높이고 형변환의 번거로움이 줄어든다. 자연스럽게 코드도 더 간결해진다. 예를 들면, Collection에 특정 객체만 추가될 수 있도록, 또는 특정한 클래스의 특징을 갖고 있는 경우에만 추가될 수 있도록 하는 것이 제네릭이다. 이로 인한 장점은 collection 내부에서 들어온 값이 내가 원하는 값인지 별도의 로직처리를 구현할 필요가 없어진다. 또한 api를 설계하는데 있어서 보다 명확한 의사전달이 가능해진다.


# [욱이의 몸부림](https://m.blog.naver.com/PostView.nhn?blogId=1stwook&logNo=220057269268&proxyReferer=https:%2F%2Fwww.google.com%2F)
```java
첫째로, 컬렉션은 제네릭이라는 기법으로 구현되어 있어요.

컬렉션 클래스나 인터페이스의 이름에는 위에 그림에서 보셨듯이 <E>, <K>, <V> 등이 항상 포함되요.

이들은 타입 매개 변수​로 불리며, 컬렉션의 요소를 일반화시킨 타입이에요.

예를 들어, E 대신 구체적인 타입을 지정하면, Vector<Integer>는 정수 값만 저장하는 벡터이고,

Vector<String>은 문자열만 저장하는 벡터라는 거에요.

특정 타입만 다루지 않고, 여러 종류의 타입으로 변신할 수 있도록 컬렉션을 일반화시키기 위해 <E>를 사용하는 것이죠.

그러므로 E를 일반화시킨 타입 혹은 제네릭 타입이라고도 불러요.

컬렉션은 여러 타입의 값을 다룰 수 있또록 변신이 가능한 자료 구조이지만, 

실행 중에 컬렉션을 생성하고 사용할 때는 오직 한 타입의 값만 저장하고 다룬답니다.

 

두번째로, 컬렉션의 요소는 객체들만 가능해요.

int, char, double 등의 기본 타비의 데이터는 기본적으로 컬렉션의 요소로 불가능하지만,

기본 타입의 값이 삽입되면 자동박싱(auto boxing)에 의해 Wrapper 클래스로 변환되며 객체 형태로 저장해요.

이 부분에 대한 자세한 내용은 추후 필요시에 Wrapper 클래스에 대해 공부하시면 될 거 같아요.

별건 아니고.. 기본 타입인 int를 객체 타입인 Integer로 객체로 박싱하거나

반대로 객체를 기본타입으로 언박싱하는 내용이에요.

 

● 제네릭의 기본 개념

 

JDK 1.5 버전에서 제네릭이 도입되었다고 하는데요.

제네릭은 모든 종류의 타입을 다룰 수 있도록 일반화된 타입 매개 변수로 클래스나 메소드를 선언하는 
기법으로 C++과 동일하다네요.

 

Stack<E> 클래스의 예를 들어보자면

Stack<E> 클래스는 제네릭 타입 <E>를 가진 제네릭 클래스이며 그 모양은 아래와 같아요.
```

## wrapper
* 기본 자료형(Primitive data type)에 대한 클래스 표현을 Wrapper class라고 한다. Integer, Float, Boolean 등이 Wrapper class의 예이다. int를 Integer라는 객체로 감싸서 저장해야 하는 이유가 있을까? 일단 컬렉션에서 제네릭을 사용하기 위해서는 Wrapper class를 사용해줘야 한다. 또한 null 값을 반환해야만 하는 경우에는 return type을 Wrapper class로 지정하여 null을 반환하도록 할 수 있다. 하지만 이러한 상황을 제외한 일반적인 상황에서는 Wrapper class를 사용해야 하는 이유는 객체지향적인 프로그래밍을 위한 프로그래밍이 아니고서야 없다. 일단 해당 값을 비교할 때, Primitive data type인 경우에는 ==로 바로 비교해줄 수 있다. 하지만 Wrapper class인 경우에는 .intValue() 메소드를 통해 해당 Wrapper class의 값을 가져와 비교해줘야 한다.

## autoboxing
* JDK 1.5 부터는 AutoBoxing과 AutoUnBoxing을 제공한다. 이 기능은 각 Wrapper class에 상응하는 Primitive data type일 경우에만 가능하다.
```java
List<Integer> lists = new ArrayList<>();
lists.add(1);
```
* 우린 Integer라는 Wrapper class로 설정한 collection에 데이터를 add할 때 Integer 객체로 감싸서 넣지 않는다. 자바 내부에서 AutoBoxing해주기 때문이다.

