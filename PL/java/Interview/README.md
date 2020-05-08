# 기술면접
```java

1. (자바 스레드 객체는 start 메소드를 두 번 호출할 수 있나요?)                              
  (아니요, IllegalThreadStateException가 발생합니다.)
 
2. static 메소드를 오버라이드 할 수 있나요?
  static 메소드를 오버라이드 할 수 없습니다. static 메소드들은 객체가 아닌 클래스에 속해 있습니다. 
  상속은 클래스 멤버에 적용되지 않습니다.
  
3. serialization 메소드들을 나열할 수 있나요?
  Serialization 인터페이스는 메소드를 가지고 있지 않습니다. 이것은 마커 인터페이스이고 
  단지 클래스가 직렬화 될 수 있다는 것만 알려줍니다

4. What is the difference between super() and this()?
(super()와 this()의 차이점은?)
  this()는 같은 클래스의 생성자를 호출하거나, 매개 변수가 있는 생성자를 호출하는 것을 의미하는 반면, 
  super()는 super 클래스의 생성자를 호출하는 데 사용됩니다.
  
5. 메소드 overridden 방지 법은?
  메소드에 final 키워드를 지정하여 서브 클래스에서 재정의를 방지할 수 있습니다.
  마찬가지로 클래스에 final을 지정하여 서브 클래스 생성(상속)을 막을 수 있습니다.

6. 추상 메소드 없이 추상 클래스를 만들 수 있나요?
  추상 메소드 없이 추상 클래스를 만들 수 있습니다.

7. transient 변수?
  (Transient 변수는 직렬화 할 수 없습니다. 직렬화 과정에서 transient 변수 상태는 직렬화 되지 않습니다
 
8. try block이 끝날 때 return이 없다면 finally block이 실행될까요?
  예, finally block은 try block의 끝에서 상태를 return 하더라도 실행합니다. System.exit()이 아닌 이상 항상 실행합니다.

9. 추상 클래스? 추상 메소드?
  추상 클래스의 인스턴스는 서브 클래스에서만 만들 수 있다. abstract 키워드를 클래스 앞에 붙이면 된다
  추상 클래스는 추상 메소드를 포함할 수 도, 안 할 수도 있습니다. 추상 메소드는 단지 메소드를 선언만 했지,  
  어떤 구현도 포함하지 않습니다. 서브 클래스에서 추상 메소드의 구현을 반드시 해줘야 합니다.

10. boolean의 기본 값은? false

11. 언제 LinkedList나 ArrayList를 사용하나요?
  특정  element 접근은 하나하나씩 elements를 거쳐야 하는 LinkedList 보다는 index 기반의 ArrayList가 더 빠릅니다
  그러나 삽입, 삭제는 LinkedList가 더 빠릅니다. 왜냐면 LinkedList는 해당 노드의 앞, 
  뒤 노드 포인터만 바꿔 주면 되기 때문입니다. ArrayList는 삽입, 삭제 시 index 값들을 조정해야 되기 때문에 느립니다

12. Java에서는 각각의 스레드가 별도의 스택을 이용합니까?
  (Java에서는 모든 스레드는 자신의 별도의 런타임 스택이라 불리는 스택을 유지한다. 하지만 동일한 메모리를 공유한다.

13. try block에서 system.exit()이 실행되면 finally block을 실행할까?
  finally block이 실행되지 않는다. System.exit() 이후 프로그램은 종료된다
  
14. (final은 키워드이다. 변수 앞에 붙으면 한 번만 초기화되고 수정이 불가능하다. 
클래스 앞에 붙으면 상속이 안되고 메소드 앞에 붙으면 오버라이드가 안된다.
(finally는 block이다. finally block은 try block 이후 항상 실행된다. 심지어 예상치 못한 exception에서도 실행된다
finalize는 메소드이다. 객체가 gc 되기 이전에 런타임 시스템은 finalize() 메소드를 호출한다. 
gc 하기 전에 시스템 자원은 finalize 메소드에서 해제 코드를 작성할 수 있습니다

15. Java에서 wait 메소드와 sleep 메소드의 차이점은?
  sleep: Thread 클래스의 static method이다. 특정 시간만큼 스레드 상태를 "Not Runnable" 상태로 만든다
  wait: (Object 클래스의 메소드이다. 현재 스레드 상태를 "Not Runnable" 상태로 만든다. Wait는 스레드가 아닌 객체에서 불립니다.

16. 현재시간을 얻는 방법은?
  System.currentTimeMillis()는 현재시간을 리턴한다. static 메소드이며 long 타입 값을 리턴한다

17. String, StringBuffer
  (String은 immutable 객체이다. String 객체를 한번 초기화하면 값을 바꿀 수 없다. 
  만약 값을 바꾸면 기존의 객체의 값을 바꾸지 않고 새로운 String 객체를 생산 한다. 
  만약 값을 계속 수정해야 한다면 StringBuffer를 이용하자. StringBuffer는 새로운 객체를 생성하지 않고도 값을 바꿀 수 있다.

18. Java에서 wrapper 클래스란?
  Java에선 primitives(int, short, long, boolean, char, float, double, byte)를 제외하고 다 객체이다.  
  primitives는 객체가 아니기 때문에 객체나 객체들의 collection으로 반환할 수 없다. java는 이를 위해
  wrapper class(Integer, Long, Boolean, etc. )를 제공한다

19. Iterator는 클래스?
  (Iterator는 클래스가 아닌 인터페이스이다. 각각의 list에 있는 모든 요소를 통해 Iterator 하는 데 사용됩니다.
  Iterator는 Iterator 디자인 패턴을 통해 구현된다.)

20. Exception과 Error의 super 클래스?
  The super class or base class for Exception and Error is Throwable.

21. interface는 final이 될 수 있는가?
  될 수 없다. final 키워드는 클래스의 상속을 막으므로 서브 클래스를 통해 구현되어야 할 interface는 final 키워드를 쓸 수 없다

22. exception과 error의 차이점은?
  rror는 out of memory처럼 런타임 도중 발생하는 예측 불가능한 상황에서 일어난다. 
  이런 jvm 에러들은 런타임 시 처리할 수 없다.
  Exception들은 런타임 시 쉽게 처리할 수 있는 실패 상황들이다.
 
 23. 초기화되지 않은 final 변수를 초기화할 수 있나요?
  예. 오직 생성자안에서만 빈 final 변수를 초기화할 수 있습니다. 단 final 변수가 not-static일 경우에만

24. 추상 메소드에 final을 선언할 수 있나요?
  아니요. 서브클래스에서 추상 메소드를 구현해야 하기 때문에 오버라이딩을 막는 final을 선언할 수 없다

25. catch block 없이 finally block을 쓸 수 있나요?
  예. catch block 없이도 finally block을 쓸 수 있습니다
 
26. What is pass by value and pass by reference?
  Pass by value: Passing a copy of the value, not the original reference.
  (오리지널 레퍼런스가 아닌 복사한 값만 넘긴다.)
  
  Pass by reference: Passsing the address of the object, so that you can access the original object.
  (객체의 주소를 넘겨 오리지널 객체에 접근할 수 있다.)
  
28. 메인 메소드를 private로 선언할 수 있나요?
  예. 메인 메소드를 private로 선언할 수 있다. 컴파일 시 아무 문제없지만 런타임 시 문제가 발생한다

29. 클래스의 static 영역을 직렬화 할 수 있나요?
  static 영역은 객체가 아닌 클래스 소속이기 때문에 serializationd은 static 영역은 무시한다

30. ArrayList와 Vector 중 뭐가 더 빠른가? 왜?
  ArrayList가 Vector보다 더 빠르다. 왜냐면 동기화 때문이다. Vector는 자동으로 동기화된다. 동기화는 성능을 저하시킨다.
  
31. 생성자를 private로 선언할 수 있나?
  만약 다른 클래스들이 객체를 인스턴스화 시키기 원하지 않으면 private 생성자를 이용할 수 있다. 
  주로 싱글톤 패턴이나 팩토리 패턴에서 쓰인다

32. 증가(++) 동작의 prefix와 postfix 차이점은?
  (prefix 형태는 처음에 증가 동작을 수행하고 이 동작의 값을 리턴 한다. postfix 형태는 현재 값을 리턴하고 증가 동작을 수행한다.

33. Hashtable과 HashMap의 차이점은?
  * Hashtable : 동기화, null 값 안됨.
  * HashMap :  비동기화, null 허용.
  
34. C++과 Java의 차이는?
  Java는 pointer를 지원하지 않는다
  Java는 다중 상속을 지원하지 않는다. 대신 상속 객체가 그 상속된 메소드를 구현해야 한다는 
  조건으로 서로 다른 인터페이스에서 여러 메소드들을 상속할 수 있도록 다중 인터페이스 상속을 지원합니다
  Java는 structure나 union을 포함하지 않는다.
  (Java는 소멸자를 제공하지 않지만 finalize() 메소드를 제공한다. 
  finalize 메소드는 객체가 점유된 메모리를 회수하기 전에 gc에 의해 호출됩니다.  즉 객체가 언제 finalize 될지 모른다는 것을 의미한다
  Java가 자동으로 gc 하는 동안 C ++은 명시 적으로 메모리 관리가 필요합니다

35. Java에서 generics 이 왜 필요한가?
  1. (컴파일 시 강한 타입 검사 : Java 컴파일러는 generic 코드와 문제 에러에 강한 타입 검사를 
  적용하여 잘못된 코드로부터 안전하게 한다. 컴파일 에러 수정이 런타임 에러 수정보다 찾기 편하고 쉽다.
  2. 캐스트 제거 : generics 사용하는 경우, 명시 적 형 변환이 필요하지 않습니다
  3. 프로그래머들이 generic 알고리즘을 구현하기 위해 이용 : generics을 이용하면, 
  프로그래머는 커스터마이즈 된 다른 타입의 collection들을 가지고 generic 알고리즘을 안전하고 
  좀 더 쉽게 이해하여 구현할 수 있습니다
```
