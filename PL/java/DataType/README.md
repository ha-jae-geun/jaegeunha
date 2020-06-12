# 데이터 타입
```java
컴퓨터 메모리에는 비트의 패턴이 저장된다. 이것이 무엇을 의미할지는 순전히 어떻게 쓰여질지에 따라 달려있다.

 
이렇게 어떻게 쓰일지를 결정하는게 바로 데이터 타입이다.


Data Type

데이터가 어떻게 표현되고 사용될지를 결정한다.
데이터 타입에 따라 컴퓨터가 어떻게 데이터를 다룰지 알 수 있다.
컴퓨터에 저장된 모든 값은 데이터타입에 의해서 표현될 수 있다.
- 자바는 데이터를 표현하기 위한 가장 기본적인 몇가지 내장된 데이터 타입을 가지고 있다.


이것을 primitive data type라고 한다. 자바는 8개의 primitive 데이터 타입을 가지고 있다.


[ byte, short, int, long, float, double, char, boolean ]
 

같이 비트로 저장되어 있는 데이터 일지라도 데이터타입의 의해서 다시 해석되어 사용될때 표현이 달라질수 있다는 점을

명심해야한다.


```

# 변수란
```java
우리가 변수를 사용하기 위해서는 변수를 우선 선언을 하고 나서 사용을 해야만 한다.

변수를 선언한다는 것은 메모리 공간에 데이터타입에 맞는 저장 공간이 확보되어 사용할 준비가 되는 것입니다.

변수를 선언할 때에는 우리가 사용하고자 하는 용도에 맞게 변수의 데이터타입을 지정해 줘야되는데

데이터타입에는 크게 두가지 분류로 나누어 볼수 있다.

 
⑴ java Compiler가 지원하는 데이터타입 8가지

⑵ User defined types의 데이터타입

쉽게 기억하자면 기본적으로 지원하는 8가지를 제외하고는 모두 사용자들이 만들어 내는 데이터타입이다 보시면 됩니다.


그럼 저 데이터타입을 가지고 어떻게 변수를 선언하는지 보도록 하자.

기본 데이터타입을 분류해 보면 논리형, 문자형, 정수형, 실수형 으로 나누어 볼수 있다.

```

# 기본 타입
```java
JAVA 실행

JAVA실행은 두단계를 거친다

(1) javac 명령으로 자바 소스를 컴파일해서 클래스 파일에 저장한다. ( .class 파일 생성 )

(2) java 명령으로 가상 머신을 구동하고 클래스파일(.class)을 로딩해서 바이트 코드를 실행한다.

JAVA 기본 타입

(1) 정수 : int, long, short, byte

* int의 범위가 최대 20억정도인데, 연습에서는 아무렇지 않게 int를 쓰더라도 금융쪽에서 개발할 때와 같이 다루는 
숫자의 규모가 커질 때를 유념하고 이용할 것.

long타입으로도 충분하지 않을 때는 BigInteger 클래스를 사용하도록 한다.

(2) 부동소수점 : float, double

무한대 - Double.POSITIVE_INFINITY , Double.NEGATIVE_INFINITY

NaN (Not a Number) - '숫자가 아닌' Double.isNaN(x)로 검사해야함 x==Double.NaN 은 틀림

(3) 문자 : char

(4) boolean : boolean의 값은 false/true만 가능 * boolean이 숫자타입이 아니다. 0,1과 아무 관련이 없음.

JAVA 연산 이슈

시침 위치를 조정한 후 숫자를 0과 11사이로 정규화하려고 할 때, (position + adjustment) % 12 로 간단하게 얻을 수 있다. 
하지만 adjustment가 음수로 만들어 버리면 값은 음수로 내려가 버린다. 따라서 branch를 도입하거나 ((position + adjustment) % 12 + 12) % 12를 
사용해야 한다. 근데 둘다 불편하다.

따라서 Math.floorMod 메소드를 사용하는 방법을 이용한다.

Math.floorMod(position + adjustment, 12)는 언제나 0~11사이 값을 준다.

* floorMod는 나누는 수가 음수면 음수값을 결과로 준다. 하지만 이런 상황은 잘 나오지 않는다.

수학 / 숫자타입변환

10억 곱하기 3은 -1294967296으로 계산된다. int의 범위 2억을 넘기 때문에 오버플로우 된 것이다. 따라서 예외로 잡는 함수를 사용해야한다. Math.multiplyExact(1000000000, 3)을 호출하면 예외로 잡는다.

숫자타입변환의 기본

피연산자중 하나가 double이면 다른 하나를 double로 만들고

피연산자중 하나가 float이면 다른 하나를 float으로 만들고

피연산자중 하나가 long이면 다른 하나를 long으로 만들고

이 외에는 두 피연산자를 int로 변환다.

특히, 작은 타입에서 큰 타입으로 변환은 언제나 합법적이나 큰 타입에서 작은 타입으로 변환할 때는 항상 주의해야한다. 
소수부가 버려지거나 마지막 바이트만 보존되는 경우가 생긴다.

논리 연산 이슈

&&, || (and, or) 연산를 할 때 신경써야할 부분은 && 앞에 조건이 false면 두 번째 이후 조건을 평가하지 않는다는 것과 
|| 앞에 조건이 true면 두 번째 이후 조건을 평가하지 않는다는 것을 유념하고 일일이 테스트 해야한다.

큰 숫자

int 나 double의 정밀도로 충분하지 않을 때 java.math 패키지의 BigInteger와 BigDecimal 클래스로 전환하면 된다.

BigInteger n = BigInteger.valueOf( 879464894561511548L );

부동소수점 뺄셈에서 2.0 - 1.1의 결과가 0.899999999999999999999999 로 나오는 이유는

10진수로 1/3을 정확히 표현할 수 없듯, 2진수로 1/10을 정확히 표현할 수 없기 떄문이다.

그래서 이러한 경우에는 BigDecimal클래스로 정확히 계산할 수 있다.

BigDecimal.valueOf(2,0).subtract(BigDecimal.valueOf(11,1)) = 0.9

문자열

문자열은 문자의 시퀀스다.

* String클래스는 절대 변하지 않는다.

문자열 연결은 +로 가능 / 문자열 구분자로 구분해서 결합하려면 join 사용

String names = String.join("," , "Peter", "pro" , "Jeong");

(names은 "Peter,pro,Jeong")

String Builder클래스 이용하면 더 간단하게 문자열 연결 가능 append

substring : 추출할 문자열의 시작위치와 끝위치를 인자로 받아 추출

equals : 문자열 비교 절대로 == 연산자사용하면 안됨. 이런 비교는 메모리에서 같은 객체일 때만 true반환하기 때문에 equals 사용

"" 과 null 은 다르다.

대소문자 구별하지 않고 비교 equalsIgnoreCase()

(parseInt / toString , 문자->숫자 / 숫자->문자)

문자열 API는 찾아보도록 하자

boolean startsWith(String str) / boolean endsWith(String str) / boolean contains(CharSequence str)

 - 문자열이 지정한 문자열로 시작/종료하거나 지정한 문자열을 포함하는지 검사

int indexOf(String str) / int lastIndexOf(String str) / int indexOf(String str, int fromIndex) /
int lastIndexOf(String str, int fromIndex)

 - 전체 문자열이나 fromIndex에서 시작하는 부분 문자열을 검색해서 str이 처음 또는 마지막으로 나타난 위치를 얻는다

String replace(CharSequence oldString, CharSequence newString)

 - oldString이 나타난 부분을 모두 newString으로 교체한 문자열을 반환

toUpperCase() , toLowerCase()

 - 모두 대문자, 소문자로 변환

trim()

 - 앞뒤 공백 제거
```


# Value 타입과 Reference 타입
 ```java
 □값 형식(Value Type)

먼저 기본 자료형(string을 제외한)과 사용자 정의 구조체의 변수는 값 형식이며 스택에 저장됩니다.

ex) int x  = 10; // 변수 x는 스택에 저장.

값 형식으로 저장된 변수들은 범위 밖을 나가면 스택에서 제거됩니다.

 

□참조 형식(Reference Type)

이번엔 참조형식인데 인스턴스 변수(클래스,배열)들은 참조 형식이며 힙 영역에 저장됩니다.

 

ex) Student stu = new Student();    // 인스턴스 변수 stu는 힙 영역에 저장.

 

참조 형식으로 저장된 변수들은 C#에서 효율적인 메모리 관리를 위해 가비지 컬렉터란 것이 소멸 되는 시점을 판단하여 객체를 수거해갑니다.

 

이 두개의 차이점은 엑세스에 있는데요. 값 형식은 효율적이지만 
수명이 제한되어 서로 다른 클래스 간에 데이터를 공유하는 데 적합하지 않고, 

참조 형식은 다른 클래스에서 엑세스하는데 적합하지만 오버헤드가 커진다는 단점이 있습니다.
 ```
 
 ```java
 자바에서 각각 객체가 동일한지 확인하는 방법

자바 프로그래밍에서 객체가 동일한지 확인하는 분기문은 상당히 많이 작성할 것이다.

예를 들면 '==' 연산자로 비교할 수도 있고 'equals()', 'hashCode()' 로 비교할 수도 있다.

이제 앞에서 언급한 3개의 방법의 원리를 정리하고 적용해본다.

== 연산자

== 연산자는 피연산자가 primitive type(int, double, boolean, ...)일 때는 값이 같은지 비교하고, 피연산자가

그 외 객체, reference type일 때 가리키는 주소가 같은지를 검사한다.


String str1 = "hello";
String str2 = "hello";
System.out.println(str1 == str2);//true
String str3 = new String("hello");
String str4 = new String("hello");
String str5 = str4;
System.out.println(str3 == str4);//false
System.out.println(str4 == str5);//true


위의 예제가 String 객체라서 조금 어렵게 설명이 될 수 있다. (String 클래스는 조금 특별하므로...)

str1과 str2는 String을 리터럴로 생성한 객체로 heap에 생성된 "hello"를 같이 가리키고 있는 것이다.

따라서 str1이 가리키는 주소("hello"의 주소)와 str2가 가리키는 주소("hello"의 주소)가 같기 때문에 true를 리턴하는 것을 알 수 있다.

str3과 str4는 생성자를 이용해서 생성한 객체로 각각의 메모리에 "hello"라는 String을 만든 것과 같다.

아까와는 다르게 각각의 메모리(주소공간)에 "hello"가 존재하고 가리키고 있으므로 서로 주소가 달라 false를 리턴한다. 

str4와 str5의 경우는 str5는 str4가 가리키는 값(주소)를 대입했으므로 같은 주소를 가리킨다. 따라서 true를 리턴한다.

다시 정리하면 '==' 연산자는 두 객체가 같은 것을 가리킬 때만 true를 준다고 보면 된다.

equals()

equals는 내용이 같은지를 검사하는 메서드다.

명확하게는 default로 primitive type은 내용이 같은지 검사하고, reference type은 객체의 주소가 같은지 검사한다.

(Object클래스의 메서드이므로 모든 객체는 equals()메서드를 사용할 수 있다.)

'==' 연산자와 다른 점은 완전히 같은 객체를 가리키지 않아도 개발자가 true로 만들 수 있다는 것이다.


String str1 = "hello";
String str2 = "hello";
System.out.println(str1.equals(str2));//true
String str3 = new String("hello");
String str4 = new String("hello");
System.out.println(str3.equals(str4));//true
cs
str1과 str2는 같은 주소를 가리키고 있을 뿐만아니라 내용(값)도 같으므로 equals메서드의 결과 true를 리턴한다.

str3과 str4는 가리키는 주소는 달라도 내용(값)이 같으므로 equals메서드의 결과 true를 리턴한다.

* 하지만 String 클래스는 조금 특별하다고 했다.

자바에서 String 클래스 내부적으로 equals메서드를 오버라이드(재정의) 해서 이런 결과가 나타난 것이다.

즉, String클래스가 아닌 개발자가 생성한 클래스의 객체는 자바가 내용이 같은지를 판단하기는 어렵다.

다른 클래스로도 알아보자.

public class Person {
    private String name;
    private int age;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
Colored by Color Scripter


임의로 Person이라는 클래스를 만들어보았다.

여기서는 일반적으로 사용하는 getter/setter, 생성자, toString() 메서드만 추가했다.


Person person1 = new Person("jeong-pro", 27);
Person person2 = new Person("jeong-pro", 27);
System.out.println(person1 == person2);//false
System.out.println(person1.equals(person2));//false


결과는 둘다 false가 나온다.

'==' 연산자를 복습해보면 당연히 두 객체가 각각 다른 주소에 생성되었기 때문에 person1과 person2는 '==' 연산에 대해 false를 리턴한다.

그런데 내용이 같으면 true를 준다던 equals()메서드가 false를 리턴했다.

문제는 자바에서 내용이 같은지를 모른다는 것이다.

왜냐하면 개발자의 의도에 따라 name만 같으면 두 객체를 같게 볼 수도 있고 name, age 둘 다 같아야 같다고 볼지 모르기 때문이다.

따라서 equals() 메서드를 오버라이드(재정의)해서 두 객체의 내용이 같은지를 정의해줘야 올바르게(의도한대로) 작동한다.

* equals() 메서드를 재정의하지 않고 아래와 같이 쓸 수도 있다.

1
System.out.println(person1.getName().equals(person2.getName()) || person1.getAge() == person2.getAge());
cs
어떻게 보면 위와 같은 방법이 코드를 따라갈 때에는 더 명확하게 무엇을 비교하는지 알 수 있어서 좋을 수도 있을 것이다.

(이게 포인트가 아니므로 일단 넘어간다)

 age와 name 모두 같아야 같은 것으로 확인하는 equals()메서드를 만들었다. (IDE가 만들어 주었다.)


@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Person other = (Person) obj;
    if (age != other.age)
        return false;
    if (name == null) {
        if (other.name != null)
            return false;
    } else if (!name.equals(other.name))
        return false;
    return true;
}
Colored by Color Scripter
cs
equals 메서드를 오버라이드했더니 이제는 person1.equals(person2) 가 true를 리턴한다.

* 참고로 eclipse(IDE)에서는 equals() 메서드를 generate 시켜주는 기능을 가지고 있는데 자연스럽게 hashCode()도 함께 
generate 시켜준다. 즉, equals()와 hashCode()를 같이 재정의하게 한다는 것이다.



hashCode()를 정리하기 전 미리 말하면,

equals()만 재정의해서는 안되고 반드시 equals()와 hashCode()를 함께 재정의해야만 부작용이 없다.

예를 들면 아래와 같은 부작용이 있을 수 있다.

equals만 재정의해서 어떤 두 객체가 같다고 했는데 hash를 사용하는 Collection(HashSet, HashMap, ...)에 
넣을 때는 같다고 생각하지 않아서 문제가 생길 수 있다. 아래에서 확인해보자.


Set<Person> hset = new HashSet<>();
Person person1 = new Person("jdk", 27);
Person person2 = new Person("jdk", 27);
System.out.println("person1 : "+person1.hashCode());//2018699554
System.out.println("person2 : "+person2.hashCode());//1311053135
System.out.println(person1.equals(person2));//true
hset.add(person1);
hset.add(person2);
System.out.println(hset.size());//2
cs
person1과 person2의 해시코드가 다른 것을 위에서 확인할 수 있고 그 때문에 중복을 자동으로 없애주는 Set에 

넣었음에도 불구하고 set의 사이즈는 2가 나와버린 것이다.

이런 문제를 모르고 코딩하다가는 나중에 꼬여버린 탓에 곤란을 겪을 수 있다. 따라서 equals와 hashcode는 반드시 함께 재정의해야 한다.

즉, equals로 같은 객체라면 반드시 hashCode도 같은 값이여야만 한다.

하지만 반대로 hashCode가 같은 값이더라도 equals로 같은 객체가 아닐 수 있다는 것을 유의해야 한다.

또한 아주 중요한 점이 같은 파라미터를 이용해야 한다는 것이다.

(* 실제 equals의 파라미터는 반드시 Object 타입이어야 한다. 내부적으로 비교하는 파라미터를 같게 하라는 의미.

파라미터 타입을 Object에서 다른 타입으로 바꿀 경우는 오버로딩으로 인식하여 기존의 equals 메서드가 남아있게 된다.)

예를들어 equals를 판단하는 파라미터에는 name만 이용했는데 hashcode에서는 age를 이용한다든지

name과 age를 같이 사용해버린다든지 하면 부작용이 많이 일어날 수 있다.

결론적으로 반드시 같은 파라미터를 이용하면 될 것이다.

hashCode


@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
}
Colored by Color Scripter


hashCode()는 메모리에서 가진 hash주소 값을 기본적으로 반환해준다.

기본적으로 hash는 다른 객체여도 같을 '수'가 있기 때문에 비교에 적합하지 않으나 hash함수를 
쓰는 collection같은 객체가 있으므로 함께 사용하는 것으로 이해하도록 한다.


 ```
 
 # String 타입이 아닌 Char 타입을 쓰는 이유
 * char은 (는) 한 문자입니다. String이 (가) 0 자 이상입니다.
* char은 기본 유형입니다. String은 (는) 클래스입니다.
 
 
 
 
 # char 배열과 String 배열의 차이
 ```java
 예외적으로 char배열은 println메서드로 출력하면 각 요소가 구분자없이 그대로 출력되는데, 
 이것은 println메서드가 char배열일 때만 이렇게 동작하도록 작성되었기 때문이다.

for문 대신 System클래스의 arraycopy()를 사용하면 보다 간단하고 빠르게 배열을 복사할 수 있다.


 
자바에서 char배열이 아닌 String클래스를 이용해서 문자열을 처리하는 이유는 
String클래스가 char배열에 여러 가지 기능을 추가하여 확장한 것이기 때문이다.
char배열과 String클래스의 한 가지 중요한 차이는, String객체(문자열)는 읽을 수만 있을 뿐 내용을 변경할 수 없다. 
(변경 가능한 문자열을 다루려면, StringBuffer 클래스를 사용하면 된다.)
 ```
 
 
 
 # equals와 ==의 차이
* equals () 는 메소드 입니다. 객체끼리 내용을 비교할 수 있도록 합니다.
* == 은 비교를 위한 연산자 입니다.
```java
equals 메소드는 비교하고자 하는 대상의 내용 자체를 비교하지만,

== 연산자는 비교하고자 하는 대상의 주소값을 비교합니다.

주소값이라는 것은 확실하게 집주소나 이메일주소처럼 확정적으로 정해져서 보여지는 것은 아니지만

대상을 구별할 수 있게하는 값이라고 알아두시면 됩니다.

이는 Call By Reference, Call By Value에 대한 공부를 하시면 이해할 수 있는 부분입니다.

 
CBV(Call By Value. 이하 CBV) 는 기본적으로 대상에 주소값을 가지지 않는 것으로 
값을 할당받는 형태로 사용됩니다. 예를 들어 int, float, double, byte 등 primitive type에 해당됩니다.


CBR(Call By Reference. 이하 CBR) 는 대상을 선언했을 때, 주소값이 부여됩니다.

그래서 어떠한 객체를 불러왔을 때는 그 주소값을 불러온다고 봅니다.

Class, Object(객체)가 CBR에 해당됩니다.


예를 들어, String 클래스를 이용해 문자열을 생성해보겠습니다.

 

String a = "aaa";

String b = a;

String c = new String ("aaa");

 

a, b, c 모두 "aaa" 라는 내용을 가지고 있지만 주소값에 대해서는 다른 값을 가지는 변수가 존재합니다. 
세 문자열이 주소값을 할당받는 내용을 그림으로 표현해보았습니다.

회색 테두리가 문자열 변수 a, b, c를 표현한 내용입니다.

그림에서는 a, b, c 모두 같은 aaa라는 문자열 내용을 가지고 있지만, a, b는 500이라는 임의의 주소값을 할당 받았으며, 
c는 600이라는 임의의 주소값을 할당받았습니다.



내용은 같지만 c가 다른 주소값을 할당받은 이유는 "aaa" 라는 문자열을 대입한 것이 아니라 
new String ("aaa") 를 통해 새로운 문자열을 선언하였기 때문입니다. 
```

## equals 예외
* equals()만 재정의해서는 안되고 반드시 equals()와 hashCode()를 함께 재정의해야만 부작용이 없다.
* [출처]('https://jeong-pro.tistory.com/172')
```java
public class Person {
    private String name;
    private int age;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
Colored by Color Scripter


임의로 Person이라는 클래스를 만들어보았다.

여기서는 일반적으로 사용하는 getter/setter, 생성자, toString() 메서드만 추가했다.


Person person1 = new Person("jeong-pro", 27);
Person person2 = new Person("jeong-pro", 27);
System.out.println(person1 == person2);//false
System.out.println(person1.equals(person2));//false


결과는 둘다 false가 나온다.

'==' 연산자를 복습해보면 당연히 두 객체가 각각 다른 주소에 생성되었기 때문에 
person1과 person2는 '==' 연산에 대해 false를 리턴한다.

그런데 내용이 같으면 true를 준다던 equals()메서드가 false를 리턴했다.

문제는 자바에서 내용이 같은지를 모른다는 것이다.

왜냐하면 개발자의 의도에 따라 name만 같으면 두 객체를 같게 볼 수도 있고 name, age 둘 다 같아야 같다고 볼지 모르기 때문이다.

따라서 equals() 메서드를 오버라이드(재정의)해서 두 객체의 내용이 같은지를 정의해줘야 올바르게(의도한대로) 작동한다.

* equals() 메서드를 재정의하지 않고 아래와 같이 쓸 수도 있다.

1
System.out.println(person1.getName().equals(person2.getName()) || person1.getAge() == person2.getAge());
cs
어떻게 보면 위와 같은 방법이 코드를 따라갈 때에는 더 명확하게 무엇을 비교하는지 알 수 있어서 
좋을 수도 있을 것이다. (이게 포인트가 아니므로 일단 넘어간다)

 age와 name 모두 같아야 같은 것으로 확인하는 equals()메서드를 만들었다. (IDE가 만들어 주었다.)



출처: https://jeong-pro.tistory.com/172 [기본기를 쌓는 정아마추어 코딩블로그]
```


## HashCode
* Key의 hashcode를 통해 Value값을 더 쉽게 찾아낼 수 있다고 합니다.
[출처] [기초부터자바] hashcode란? hashcode와 equals의 관계(1)|작성자 footprint


```java
equals만 재정의해서 어떤 두 객체가 같다고 했는데 hash를 사용하는 Collection(HashSet, HashMap, ...)에 
넣을 때는 같다고 생각하지 않아서 문제가 생길 수 있다. 아래에서 확인해보자.


Set<Person> hset = new HashSet<>();
Person person1 = new Person("jdk", 27);
Person person2 = new Person("jdk", 27);
System.out.println("person1 : "+person1.hashCode());//2018699554
System.out.println("person2 : "+person2.hashCode());//1311053135
System.out.println(person1.equals(person2));//true
hset.add(person1);
hset.add(person2);
System.out.println(hset.size());//2
cs
person1과 person2의 해시코드가 다른 것을 위에서 확인할 수 있고 그 때문에 중복을 자동으로 없애주는 
Set에 넣었음에도 불구하고 set의 사이즈는 2가 나와버린 것이다.

이런 문제를 모르고 코딩하다가는 나중에 꼬여버린 탓에 곤란을 겪을 수 있다. 
따라서 equals와 hashcode는 반드시 함께 재정의해야 한다.

즉, equals로 같은 객체라면 반드시 hashCode도 같은 값이여야만 한다.

하지만 반대로 hashCode가 같은 값이더라도 equals로 같은 객체가 아닐 수 있다는 것을 유의해야 한다.

또한 아주 중요한 점이 같은 파라미터를 이용해야 한다는 것이다.

(* 실제 equals의 파라미터는 반드시 Object 타입이어야 한다. 내부적으로 비교하는 파라미터를 같게 하라는 의미.

파라미터 타입을 Object에서 다른 타입으로 바꿀 경우는 오버로딩으로 인식하여 기존의 equals 메서드가 남아있게 된다.)

예를들어 equals를 판단하는 파라미터에는 name만 이용했는데 hashcode에서는 age를 이용한다든지
name과 age를 같이 사용해버린다든지 하면 부작용이 많이 일어날 수 있다.

결론적으로 반드시 같은 파라미터를 이용하면 될 것이다.

hashCode


@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
}
Colored by Color Scripter


hashCode()는 메모리에서 가진 hash주소 값을 기본적으로 반환해준다.

기본적으로 hash는 다른 객체여도 같을 '수'가 있기 때문에 비교에 적합하지 않으나
hash함수를 쓰는 collection같은 객체가 있으므로 함께 사용하는 것으로 이해하도록 한다.

```

## StringPool
* [출처]('https://doohong.github.io/2018/03/04/java-string-pool/')
* [출처]('https://dololak.tistory.com/718')
* Java에서 가장 많이 사용되는 데이터 타입은 String이 아닐까 싶습니다. 사람이 가장 이해하기 쉬운것이 Text이기 때문이지요. 그런데 Java에서 문자열을 표현하는 String 타입의 객체는 불변성(Immutable)이라는 성질을 가지고 있으며 같은값의 문자열에 대해서는 단 하나의 문자열 객체만을 생성하도록 설계 되어있습니다.
* Java에서 String이 이러한 성질을 갖는 이유는 몇가지 장점이 있기 때문인데 가장 큰 장점은 성능입니다. 같은 값을 갖는 문자열 객체는 JVM의 객체가 생성되는 공간인 Heap에 매번 새로 생성하게 되면 메모리 공간적 측면에서 비효율적이기 때문이지요. 즉 문자열 객체를 캐싱(Caching) 하는것입니다. 문자열의 불변성에 대한 자세한 내용은 상단의 연관글을 참고해주시기 바랍니다.

## String, StringBuffer, StringBuilder
* [정아마추어](https://jeong-pro.tistory.com/85?category=793347)


# 참조 타입의 주소값
* 참조 타입의 주소값은 Stack에 저장된다.
