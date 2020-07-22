# [Reflection](https://ktko.tistory.com/entry/%EC%9E%90%EB%B0%94%EC%9D%98-%EB%A6%AC%ED%94%8C%EB%A0%89%EC%85%98Reflection-%EA%B0%9C%EB%85%90)
* 자바 리플렉션(Reflection)이란 컴파일된 자바 코드에서 역으로 클래스를 불러서 메소드(Method) 및 변수(Field)를 구해오는 방법으로 클래스를 동적 로딩하여 사용할때 많이 사용되고 디컴파일할때에도 자주 사용되는 기법이다.
* 자바에서 제공하는 리플렉션(Reflection)은 C, C++과 같은 언어를 비롯한 다른 언어에서는 볼 수 없는 기능입니다. 이미 로딩이 완료된 클래스에서 또 다른 클래스를 동적으로 로딩(Dynamic Loading)하여 생성자(Constructor), 멤버 필드(Member Variables) 그리고 멤버 메서드(Member Method) 등을 사용할 수 있도록 합니다.
* 그러니까, 컴파일 시간(Compile Time)이 아니라 실행 시간(Run Time)에 동적으로 특정 클래스의 정보를 객체화를 통해 분석 및 추출해낼 수 있는 프로그래밍 기법이라고 표현할 수 있습니다.

```java
많은 입문용 자바 서적에서 잘 다루지 않는 Reflection이라는 개념에 대해서 알아보려고 합니다.
자바의 Reflection은 JVM에서 실행되는 애플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능이 필요한 프로그램에서 사용됩니다.
쉽게 말하자면, 클래스의 구조를 개발자가 확인할 수 있고, 값을 가져오거나 메소드를 호출하는데 사용됩니다.
Reflection을 사용하는 기술을 나열하자면, 우리가 잘 아는 스프링 프레임워크, 대표적 ORM 기술인 하이버네이트, jackson라이브러리 등에 사용됩니다.
Reflection을 사용해서 스프링에서는 런타임 시에 개발자가 등록한 빈을 애플리케이션에서 가져와 사용할 수 있게 되는 것입니다.
그럼 예제를 통해서 Reflection이 어떤 것인지 알아보도록 하겠습니다.
예제 코드는 깃허브에 있습니다.
Object.getClass()를 통해 클래스의 정보를 로드합니다.
//임의의 클래스를 가져오는 방법
Class c = "foo".getClass();
System.out.println(c);      //class java.lang.String
//Array는 객체이므로 Array 인스턴스에서 클래스 정보를 로드할 수 있습니다.
byte[] b = new byte[1024];
Class c1 = b.getClass();
System.out.println(c1);     //class [B
Set<String> s = new HashSet<>();
Class c2 = s.getClass();
System.out.println(c2);     //class java.util.HashSet
.class 문법을 사용합니다.
//.class 문법
boolean bl;
Class c3 = bl.getClass();   //컴파일 에러 발생
Class c4 = boolean.class;
이처럼 boolean형은 원시 유형이기 때문에, b1.getClass()를 사용하면 컴파일 에러가 발생합니다.
Class c5 = java.io.PrintStream.class;
System.out.println(c5);     //class java.io.PrintStream
Class c6 = int[][].class;
System.out.println(c6);     //class [[I
변수 c5는 java.io 유형에 해당하는 PrintStream이 됩니다. 다차원 배열 또한 .class 구문이 사용가능합니다.
Class.forName() 문법을 사용합니다.
//아래와 같이 패키지 명으로 클래스를 로드할 수 있습니다.
Class c7 = Class.forName("ko.maeng.reflection.ReflectionApplication");
Class doubleArray = Class.forName("[D");    //class [D
Class stringArray = Class.forName("[[Ljava.lang.String;");  //class [[Ljava.lang.String;
변수 doubleArray는 double형 배열의 클래스를 로드한 것과 같고, 변수 stringArray는 2차원 문자열 배열의 클래스를 로드한 것과 같습니다.
TYPE Field를 통한 원시형 클래스 반환 방법.
Class c8 = Double.TYPE;     //double
Class c9 = Void.TYPE;       //void
Method를 활용한 클래스 반환 방법.
class.getSuperClass() : 슈퍼 클래스를 반환합니다.
class.getClass() : 상속된 클래스를 포함하여 모든 공용 클래스, 인터페이스 및 열거형을 반환합니다.
class.getDeclaredClass() : 명시적으로 선언된 모든 클래스 및 인터페이스, 열거형을 반환합니다.
class.getDeclaringClass() : 클래스에 구성된 클래스(명시적으로 선언된)를 반환합니다.
class.getEnclosingClass() : 클래스의 즉시 동봉된 클래스를 반환합니다.
클래스의 정보를 로드해 봤으니, c가 A의 인스턴스인지 확인합니다.
public static void main(String[] args) {
    try{
        Class c = Class.forName("ko.maeng.reflection.A");
        boolean b = c.isInstance(new Integer(22));
        System.out.println(b);  //false
        boolean b1 = c.isInstance(new A());
        System.out.println(b1); //true
    } catch (ClassNotFoundException e){
        e.printStackTrace();
    }
}
임의의 클래스에서 메소드 정보를 반환해봅니다.

출력 결과

생성자(Constructor)에 대한 정보를 반환합니다.

출력 결과

클래스의 필드(property)를 찾아서 반환해봅시다.

출력 결과

마지막으로 필드의 값을 변경해봅니다.

출력 결과

마지막으로 Reflection의 특징과 단점을 알아보겠습니다.
확장성 특징 : 애플리케이션은 정규화된 이름을 사용하여 확장성 객체의 인스턴스를 생성하여 외부 사용자 정의 클래스를 사용할 수 있습니다.
클래스 브라우저 및 시각적 개발 환경을 제공합니다 : 클래스 브라우저는 클래스의 Method, Property, Constructor를 열거할 수 있어야 합니다. 
시각적 개발 환경은 개발자가 올바른 코드를 작성하는데 도움이 되도록 Reflection에서 사용할 수 있는 형식 정보를 사용하면 도움이 됩니다.
디버거 및 테스트 도구입니다 : 디버거는 개인 Property, Method, Constructor를 검사할 수 있어야 합니다. 테스트 장치는 Reflection을 사용하여 
클래스에 정의된 발견 가능한 세트 API를 체계적으로 호출하여 테스트에서 높은 수준의 코드 커버리지를 보장합니다.
Reflection의 주의사항 및 단점.
Reflection은 강력한 도구이지만, 무분별하게 사용해서는 안됩니다. Reflection을 사용하지 않고 수행 가능하다면, 사용하지 않는 것이 좋습니다. 
Reflection을 통해 코드에 접근할 때는 다음 사항을 염두에 두어야 합니다.
Performance의 오버헤드 : Reflection에는 동적으로 해석되는 유형이 포함되므로, 특정 JVM 최적화를 수행할 수 없습니다. 따라서 Reflection 
작업이 비 Reflection 작업보다 성능이 떨어지며, 성능에 민감한 애플리케이션에서 자주 호출되는 코드엔 사용하지 않아야 합니다.
보안 제한 사항 : Reflection에는, 시큐리티 매니저의 실행 시에 존재하지 않는 실행 시 액세스 권한이 필요합니다. 이것은 애플릿과 같이 제한된 
보안 컨텍스트에서 실행되어야 하는 코드에 대한 중요한 고려 사항입니다.
캡슐화를 저해할 수 있습니다 : Reflection은 private한 Property및 Method에 액세스하는 것과 같이 비 Reflection 코드에서 작동하지 않는 
코드를 수행할 수 있으므로, Reflection을 사용하면 예기치 않은 부작용이 발생하여 코드 기능이 저하되고 이식성이 손상될 수 있습니다. 
또한 Reflection은 추상화를 깨뜨려 플랫폼 업그레이드 시 동작이 변경될 수 있습니다.
```

# Class.forName
```java
리플렉션(Reflection)이란?
자바에서 제공하는 리플렉션(Reflection)은 C, C++과 같은 언어를 비롯한 다른 언어에서는 볼 수 없는 기능입니다. 이미 로딩이 완료된 
클래스에서 또 다른 클래스를 동적으로 로딩(Dynamic Loading)하여 생성자(Constructor), 멤버 필드(Member Variables) 그리고 멤버 메서드(Member Method) 
등을 사용할 수 있도록 합니다.

그러니까, 컴파일 시간(Compile Time)이 아니라 실행 시간(Run Time)에 동적으로 특정 클래스의 정보를 객체화를 통해 분석 및 추출해낼 수 
있는 프로그래밍 기법이라고 표현할 수 있습니다.



어떻게 사용할까?
리플렉션은 간단하게 Class.forName("클래스이름").newInstance 와 같은 코드처럼 클래스의 이름으로부터 인스턴스를 생성할 수 있고 이를 
이용하여 클래스의 정보를 가져올 수 있습니다.

import java.lang.reflect.Method;

/**
 * 리플렉션 예제 - Vector Class
 *
 * @author Kimtaeng
 * Created on 2018. 1. 5
 */
public class MadPlay {

    public void reflectionTest() {
        try {
            Class vectorClass = Class.forName("java.util.Vector");

            Method[] methods = vectorClass.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println(method.toString());
            }

        } catch (ClassNotFoundException e) {
            // Exception Handling
        }
    }

    public static void main(String[] args) {
        new MadPlay().reflectionTest();
    }
}
Java
13번 라인에서 자바의 벡터(Vector) 클래스의 경로를 Class.forName() 메서드의 인자로 주어 Class 객체를 가져옵니다. 한편 메서드의 
내부를 살펴보면 클래스를 찾을 수 없는 경우에 발생하는 ClassNotFoundException이 선언되어 있기 때문에 위의 try-catch 문처럼 예외를 
핸들링할 수 있도록 합니다.

@CallerSensitive
public static Class<?> forName(String className)
            throws ClassNotFoundException {
    Class<?> caller = Reflection.getCallerClass();
    return forName0(className, true, ClassLoader.getClassLoader(caller), caller);
}
Java
위의 벡터 클래스 객체를 가져오고, 선언된 모든 메서드의 이름을 출력하는 코드의 실행 결과는 어떻게 될까요? 예상했던 것과 같이 클래스 내에 선언된 메서드의 목록이 출력됩니다. (많아서 중간 생략했습니다)

Vector 클래스의 메서드



뿐만아니라 메서드의 매개변수와 반환 타입들도 확인할 수 있습니다.

import java.lang.reflect.Method;

/**
 * 리플렉션 예제 - Parameter Types
 *
 * @author Kimtaeng
 * Created on 2018. 1. 5
 */
public class MadPlay {

    public void reflectionTest() {

        try {
            Class vectorClass = Class.forName("java.util.Vector");

            Method[] methods = vectorClass.getDeclaredMethods();

            /* 임의의 메서드 지정, 이름으로 확인 */
            Method method = methods[25];
            System.out.println("Class Name : " + method.getDeclaringClass());
            System.out.println("Method Name : " + method.getName());
            System.out.println("Return Type : " + method.getReturnType());

            /* Parameter Types */
            Class[] paramTypes = method.getParameterTypes();
            for(Class paramType : paramTypes) {
                System.out.println("Param Type : " + paramType);
            }

            /* Exception Types */
            Class[] exceptionTypes = method.getExceptionTypes();
            for(Class exceptionType : exceptionTypes) {
                System.out.println("Exception Type : " + exceptionType);
            }

        } catch (ClassNotFoundException e) {
            // Exception Handling
        }
    }

    public static void main(String[] args) {
        new MadPlay().reflectionTest();
    }
}
Java


메서드 이름으로 호출도 가능할까?
결론부터 말하자면 가능합니다. 아래 예제로 살펴봅시다.

import java.lang.reflect.Method;

/**
 * 리플렉션 예제 - Call method by name
 *
 * @author Kimtaeng
 * Created on 2018. 1. 5
 */
class MadLife {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}

public class MadPlay {

    public void reflectionTest() {

        try {
            Class myClass = Class.forName("MadLife");
            Method method = myClass.getMethod("sayHello", new Class[]{String.class});
            method.invoke(myClass.newInstance(), new Object[]{new String("Kimtaeng")});

        } catch (Exception e) {
            // Exception Handling
        }
    }

    public static void main(String[] args) {
        new MadPlay().reflectionTest();
    }
}
Java
위의 20번 라인에서 Class.forName() 메서드의 매개변수로 찾을 클래스의 이름을 넘겨주었고 바로 아래 21번 라인에서 이름과 
매개변수의 타입을 입력하여 메서드를 찾습니다. 그리고 마지막 22번 라인에서 newInstance() 메서드를 이용하여 메서드를 실행할 객체를 
지정한 후 최종적으로 출력할 문자열 매개변수를 전달합니다.

다른 클래스의 멤버 필드의 값도 수정 가능합니다.

import java.lang.reflect.Field;

/**
 * 리플렉션 예제 - Modify member variable in class
 *
 * @author Kimtaeng
 * Created on 2018. 1. 5
 */
class MadLife {
    public int number;

    public void setNumber(int number) {
        this.number = number;
    }
}

public class MadPlay {

    public void reflectionTest() {

        try {
            Class myClass = Class.forName("MadLife");

            Field field = myClass.getField("number");
            MadLife obj = (MadLife) myClass.newInstance();
            obj.setNumber(5);

            System.out.println("Before Number : " + field.get(obj));
            field.set(obj, 10);
            System.out.println("After Number : " + field.get(obj));
        } catch (Exception e) {
            // Exception Handling
        }
    }

    public static void main(String[] args) {
        new MadPlay().reflectionTest();
    }
}
Java
이름을 매개변수로 전달하여 받은 멤버 필드(위의 24번 라인)를 get(), set() 메서드로 해당 객체의 멤버 필드 값을 임의로 변경할 수 있습니다.



리플렉션은 왜 사용할까?
리플렉션을 왜 사용할까요? 앞에서 언급한 것처럼 실행 시간에 다른 클래스를 동적으로 로딩하여 접근할 때, 클래스와 멤버 필드 그리고 메서드 등에 
관한 정보를 얻어야할 때 등등이 있겠지요. 물론 리플렉션이 없더라도 완성도 높은 코드를 구현할 수 있지만 사용한다면 조금 더 유연한 코드를 
만들 수 있습니다.

자바 관련 서적 또는 참고 자료를 인용하자면 자바의 리플렉션으로는 클래스의 패키지 정보, 접근 지정자, 수퍼 클래스, 
어노테이션(Annotation) 등도 얻을 수 있다고 합니다.


```

```java
열거 enum

public enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE };

* 열거 타입 값을 비교할 때는 간단히 ==를 사용하라 equals를 호출해도 결국 ==로 검사함.

* Size notMySize = Size.valueOf("SMALL");

-> notMySize를 Size.SMALL로 설정한다.

* Size[] allValues = Size.values();

-> values() 함수를 쓰면 모든 인스턴스를 배열로 리턴해줌.

Class 클래스

어떤 객체의 참조를 저장하는 Object타입 변수가 있는 상태에서 해당 객체의 더 많은 정보를 얻고 싶다면?

Object obj = ...;

Class<?> cl = obj.getClass(); // <?>를 빠뜨리면 IDE가 경고를 준다.

Class 객체를 얻고 나면 클래스의 이름을 알 수 있다.

Class.forName을 사용해서 Class 객체를 얻는 방법도 있다.

Class.forName 메서드의 용도는 컴파일 시간에 알려지지 않은 클래스의 Class 객체를 생성하는 것이다.

* 자바에서 배열은 클래스지만 인터페이스, 기본타입, void는 클래스가 아니다.

리소스 로드하기

Class 클래스의 유용한 서비스 중 하나는 설정파일이나 이미지처럼 프로그램 리소스를 찾아오는 일이다.

InputStream stream = MyClass.class.getResourceAsStream("config.txt");

Scanner in = new Scanner(stream);

getResource메서드는 해당 리소스에 대응하는 URL을 반환한다.

리소스에는 서브디렉터리가 포함될 수 있으며, 해당 서브디렉터리를 상대경로나 절대경로로 지정할 수 있다.

MyClass.class.getResourceAsStream("/config/menus.txt")는 MyClass가 속한 패키지의 루트를 담고있는 디렉터리에서
config.menus.txt를 찾아온다.

클래스 로더

자신마의 URLClassLoader 인스턴스를 생성하면 클래스 패스에 없는 디렉터리나 JAR 파일에서 클래스를 로드할 수 있다. (플러그인 로드)

URL[] urls = {

new URL("file:///path/to/directory/");

new URL("file://path/to/jarfile.jar");

};

String className = "com.mycompany.plugin.Entry";

try(URLClassLoader loader = new URLClassLoader(urls)){

Class<?> cl = Class.forName(className,true,loader);

// cl의 인스턴스 생성

}

이름으로 클래스를 로드하는 메서드를 작성할 때는 단순히 해당 메서드가 속한 클래스의 클래스 로더를 사용하면 안된다. 
메서드를 호출하는 쪽에서 명시적인 클래스 로더를 전달하거나 컨텍스트 클래스 로더를 사용하는 방법 중에서 선택할 수 있게 하는게 좋다.

서비스 로더

ServiceLoader 클래스를 이용하면 공통 인터페이스를 준수하는 플러그인을 손쉽게 로드할 수 있다.

프로그램에서 서비스 로더 초기화는 한번만 수행해야한다.
```

# 주의해야할 점
```java
주의할 점은 없을까?
다른 언어에서는 찾아볼 수 없는 강력한 기능이지만, 주의해야할 점도 있습니다. 외부에 공개되지 않는 private 멤버도 접근과 조작이 
가능하므로 주의해야 합니다. 
private 멤버는 Field.setAccessible() 메서드를 true 지정하면 접근이 가능합니다.


리플렉션보다는 인터페이스를 사용하라

- 리플렉션은 컴파일타임에 타입검사를 할 수 없기때문에 없는 메서드를 호출하려한다든지 하면 에러가 발생할 수 있는 단점이 있다.

또한 리플렉션을 이용하면 코드가 지저분해지고 성능이 떨어진다.

상식적으로 생각해도 그냥 메서드를 호출하는 것보다 클래스를 찾아서 메서드 리스트를 받아서 찾아서 호출하는 식이 느리다.

리플렉션은 딱 인스턴스 생성에만 쓰고, 그렇게 생성된 인스턴스는 인터페이스나 상위클래스로 참조해 사용하면 좋다.

막상 예제를 테스트해보니 잘 안된다.

느낌만 이해하고 그것을 설명하면, 리플렉션으로 런타임중에 사용되는 어떤 클래스를 Class.forName("java.lang.String"); 
처럼 클래스 이름으로 찾고, Class 객체의 getDeclaredConstructor()로 생성자를 찾아 .newInstance()로 인스턴스까지 생성을 한 후,
그 인스턴스를 가리킬 수있는 super 클래스 혹은 인터페이스로 참조하고 해당 기능을 직접사용하는 것이다.
```
