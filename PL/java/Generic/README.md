# 제네릭
* [정아마추어](https://jeong-pro.tistory.com/100?category=793347)

# Generic
* 제네릭은 자바에서 안정성을 맡고 있다고 할 수 있다. 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에서 사용하는 것으로, 컴파일 과정에서 타입체크를 해주는 기능이다. 객체의 타입을 컴파일 시에 체크하기 때문에 객체의 타입 안전성을 높이고 형변환의 번거로움이 줄어든다. 자연스럽게 코드도 더 간결해진다. 예를 들면, Collection에 특정 객체만 추가될 수 있도록, 또는 특정한 클래스의 특징을 갖고 있는 경우에만 추가될 수 있도록 하는 것이 제네릭이다. 이로 인한 장점은 collection 내부에서 들어온 값이 내가 원하는 값인지 별도의 로직처리를 구현할 필요가 없어진다. 또한 api를 설계하는데 있어서 보다 명확한 의사전달이 가능해진다.

## wrapper
* 기본 자료형(Primitive data type)에 대한 클래스 표현을 Wrapper class라고 한다. Integer, Float, Boolean 등이 Wrapper class의 예이다. int를 Integer라는 객체로 감싸서 저장해야 하는 이유가 있을까? 일단 컬렉션에서 제네릭을 사용하기 위해서는 Wrapper class를 사용해줘야 한다. 또한 null 값을 반환해야만 하는 경우에는 return type을 Wrapper class로 지정하여 null을 반환하도록 할 수 있다. 하지만 이러한 상황을 제외한 일반적인 상황에서는 Wrapper class를 사용해야 하는 이유는 객체지향적인 프로그래밍을 위한 프로그래밍이 아니고서야 없다. 일단 해당 값을 비교할 때, Primitive data type인 경우에는 ==로 바로 비교해줄 수 있다. 하지만 Wrapper class인 경우에는 .intValue() 메소드를 통해 해당 Wrapper class의 값을 가져와 비교해줘야 한다.

## autoboxing
* JDK 1.5 부터는 AutoBoxing과 AutoUnBoxing을 제공한다. 이 기능은 각 Wrapper class에 상응하는 Primitive data type일 경우에만 가능하다.
```java
List<Integer> lists = new ArrayList<>();
lists.add(1);
```
* 우린 Integer라는 Wrapper class로 설정한 collection에 데이터를 add할 때 Integer 객체로 감싸서 넣지 않는다. 자바 내부에서 AutoBoxing해주기 때문이다.

