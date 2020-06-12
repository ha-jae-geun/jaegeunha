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
