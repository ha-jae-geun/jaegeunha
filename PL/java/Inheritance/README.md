# [상속보다는 Composition](https://www.youtube.com/watch?v=YJ4JJsGy8rY&list=PLgXGHBqgT2TvpJ_p9L_yZKPifgdBOzdVH&index=8)

# 상속
```java
슈퍼클래스와 서브클래스

Employee 클래스의 몇 가지 기능을 보유하면서 관리자가 직원과 어떻게 다른지 명시하는 클래스 작성

public class Manager extends Employee{

추가된 필드

추가된 메서드 또는 오버라이딩 메서드

}

* 슈퍼클래스는 부모 클래스고 서브클래스는 부모클래스의 기능을 상속받는 자식클래스다.

* 단, 슈퍼클래스라고 더 우월하지 않다는 점이다. 오히려 서브클래스가 슈퍼클래스보다 많은 기능이 있다.

메서드 오버라이딩

public class Manager extends Employee{

...

public double getSalary(){ // 슈퍼클래스의 메서드를 오버라이드한다.

return super.getSalary() + bonus;

}

}

* super는 this와 달리 객체에 대한 참조가 아니다. super는 동적 메서드 조회를 우회하는 지시자이며 특정 메서드를 호출한다.

* 오버라이드를 할떄는 파라미터 타입이 정확하게 일치해야한다.

서브클래스 생성에서 슈퍼클래스의 private인스턴스 변수에 접근할 수 없다. 따라서 슈퍼클래스의 생성자로 해당 인스턴스 변수를 초기화해야한다.

public Manager(String name, double salary){

super(name,salary);

bouns = 0;

}

슈퍼클래스 할당

서브클래스의 객체를 슈퍼클래스의 타입 변수에 할당할 수 있다.

Manager boss = new Manager();

Employee empl = boss; //슈퍼클래스 변수에 할당해도 된다.



double salary = empl.getSalary();

empl의 타입이 Employee 인데도 Manager.getSalary 메서드가 호출된다. *****중요*****

Manager(슈퍼클래스)객체를 Employee에 변수에 할당하는 이유는 뭘까? 이렇게 하면 직원이든 관리자든 문지기든 상관없이 
모든 직원에 동작하는 코드를 작성할 수 있기 때문이다. *****

Employee[] staff = new Employee[...];

staff[0] = new Employee(..);

staff[1] = new Manager(..);

staff[2] = new Janitor(..);

슈퍼클래스의 메서드만 호출할 수 있는 단점
Employee empl = new Manager(..);

empl.setBonus(10000); // 컴파일 시간 오류

위와 같이 setBonus메서드(서브클래스의 메서드)를 호출하려고하면 에러가 생긴다.

인터페이스와 마찬가지로 instanceof 연산자로 검사 후 타입변환 연산자를 이용해서 서브클래스 참조로 변환하고 이용하면 된다.

if(empl instanceof Manager){

Manager mgr = (Manager) empl;

mgr.setBonus(10000);

}

final 메서드와 final 클래스

메서드를 final로 선언하면 어느 서브클래스도 해당 메서드를 오버라이드 할 수 없다.

예로 Object의 getClass를 final로 선언하지 않게해서 오버라이드 할 수 있게 했다면 자신이 속한 클래스를 속이는 상황이 생길 수 있다.

자신이 만든 클래스의 서브클래스를 만들지 못하게 하고 싶을 때, final 클래스로 정의할 수 있다.

예로 String, LocalTime, URL같은 final 클래스가 있다.

추상클래스와 추상메서드

클래스는 구현이 없는 메서드를 정의해서 서브클래스가 해당 메서드를 구현하도록 강제할 수 있다.

이렇게 구현이 없는 메서드를 추상메서드라고하고 추상메서드가 포함된 클래스를 추상클래스라고 한다.

* 추상클래스는 인터페이스와 달리 인스턴스 변수와 생성자를 가질 수 있다. **

* 추상클래스는 인스턴스를 생성할 수 없다.

추상클래스와 인터페이스 충돌

public interface Named{

default String getName(){return "";}

}

public class Person{

...

public String getName(){return name;}

}

public class Student extends Person implements Named{.....}

이 상황에서는 항상 인터페이스 구현보다 슈퍼클래스 구현이 우선한다. 그러므로 충돌문제를 해결할 필요가 없다.

클래스우선 규칙은 자바7고의 호환성을 보장한다.
```

```java
Object 슈퍼클래스

자바에서 모든 클래스는 Object클래스를 직/간접적으로 확장한다. 클래스에 명시적인 슈퍼클래스가 없으면 암시적으로 Object클래스를 확장한다.

Object클래스는 모든 자바 객체에 적용할 수 있는 메서드를 정의한다.

이 중 몇가지를 살펴본다.

toString

객체의 문자열 표현을 돌려준다.

x.toString() 대신에 "" + x 로 작성할 수도 있다. 이 표현식은 x가 null이거나 기본 타입 값일 때도 제대로 동작한다.

배열 출력

Arrays.toString(배열참조변수이름)

equals

객체가 같은지 검사하는 메서드

두 객체가 같은 내용을 담고 있을 때 같다고 보는 상태기반 동등성 검사가 필요한 경우에만 equals 메서드를 오버라이드 한다.

인스턴스 변수가 배열이면 정적메서드 Arrays.equals를 사용해서 배열의 길이가 같은지 검사하고 대응하는 배열 요소가 같은지 검사한다.

* equals는 따로 연구해볼 필요가 있다.

if(!(otherObject instanceof Item))return false;

이렇게 하면 otherObject가 Item의 서브클래스에 속해도 검사할 수 있다.

예를 들면 Item과 DiscountedItem을 비교할 수 있다. 하지만 이런 비교는 동작하지 않는다. equals 메서드는 
대칭으로 동작해야 한다. 다시말해 null이 아닌 x와 y가 있을때는 x.equals(y)와 y.equals(x)가 같은 값을 반환해야한다.

hashCode

해시코드는 객체에서 파생되는 정숫값이다. 해쉬코드 값이 중복될 수 있다. 하지만 그 빈도는 낮아야 한다.

hashCode와 equals 메서드는 반드시 호환되어야 한다.

x.equals(y) 면 x.hashCode() == y.hashCode() 여야한다.

equals를 재정의할 때 hashCode메서드도 재정의해서 equals와 호환되게 만들어야 한다.

이렇게 하지 않으면 클래스의 사용자가 해시 집합이나 해시 맵에 객체를 넣다가 객체를 잃게 될 수 도 있다.

인터페이스에서 Object클래스의 메서드를 재정의해서 기본 메서드로 만들 수 없다.

인터페이스에서는 특히 toString, equals, hashCode를 기본 메서드로 정의할 수 없다.

클래스 우선 규칙에 따라 이런 메서드는 Object.toString이나 Object.equals보다 우선할 수 없다.

clone

 * clone()은 오버라이드 하지 말아야 한다.

clone메서드의 목적은 객체의 복제본, 즉 원본과 같은 상태의 객체를 만드는 것이다.

두 객체중 하나의 상태를 변경해도 나머지 하나는 변하지 않는다.

clone은 얕은 복사를 수행한다.

인스턴스 변수가 기본타입이거나 불변 객체일 때는 얕은 복사로도 충분하지만 그렇지 않을 때는 원본과 복제본이 
변경 가능한 상태를 공유하므로 문제가 될 수 있다.
```
