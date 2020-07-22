# CallByValue
* [블로그](https://deveric.tistory.com/92)
```java
 call by reference가 아닌 또다른 이유는 자바에서는 객체의 주소를 가져오는 방법이 없다. 
 만약 call by reference 지원한다면 주소를 가져오는 방법을 지원해야 할 것인데 말이다.

그럼 우리는 call by reference가 어떤건지 보자. c는 call by reference 를 지원하니 c코드를 보자. 정확히는 c++.. 
오랜만에 c로 코딩할려니 문법조차 다 까먹었다.. Xcode도 거의 4년? 5년만에 열었..
```

# [펭귄](https://gmlwjd9405.github.io/2017/10/01/basic-concepts-of-development-java.html)
```java
class Person {
  private String name;
  public Person(String name) {
      this.name = name;
  }
  public void setName(String name) {
      this.name = name;
  }
  @Override
  public String toString() {
      return "name is " + this.name;
  }
}
public class FunctionCallTest {
  public static void assignNewPerson(Person p) {
    p = new Person("hee");
  }
  public static void changeName(Person p) {
    p.setNaem("hee");
  }
  public static void main(String[] args) {
    Person p = new Person("doy");

    assignNewPerson(p);
    System.out.println(p); // name is doy

    changeName(p);
    System.out.println(p); // name is hee
  }
}
기본자료형은 Call By Value이고, 참조자료형은 Call By Reference이다??
오해 1. 특정 메서드 내에서 전달 받은 객체의 상태를 변경 할 수 있다.
changeName 메서드는 참조변수 p가 가리키는 [이름 속성이 “doy”인 Person 객체]를 [이름 속성이 “hee”인 새로운 Person 객체]로 변경한 것이 아니라, 단지 이름 속성만 변경했을 뿐이다.
오해 2. 참조변수는 임의의 객체에 대한 레퍼런스를 저장하므로 메서드로 전달한 값이 레퍼런스(Call by Reference)이다.
전달 된 레퍼런스는 참조변수 p 자체의 레퍼런스가 아닌 p가 저장하고 있는 값(이것도 레퍼런스)이다.
만약 Java가 Call by Reference를 지원한다면 assignNewPerson 메서드 실행 후에 p 참조변수가 가리키는 객체가 [이름 속성이 “hee”인 새로운 Person 객체]로 변경되어야 한다.
또한 참조변수 p 자체의 레퍼런스를 얻을 수 있는 방법이 있어야 한다. 그러나 Java는 이 방법을 지원하지 않는다.
따라서 Java는 항상 Call by Value 이다.
여기서 value 란?
기본자료형의 값 또는 객체에 대한 레퍼런스
기본자료형의 경우 해당하는 변수의 값을 복사해서 전달한다.
참조자료형의 경우 해당하는 변수가 가지는 값이 레퍼런스이므로 인자로 넘길 때 Call by Value에 의해 변수가 가지고 있는 레퍼런스가 복사되어 전달된다.
https://gmlwjd9405.github.io/2017/10/01/basic-concepts-of-development-java.html
```
