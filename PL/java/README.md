# JAVA









# 메모리 누수가 무엇인가
* 프로세스가 메모리 할당 후, 해제하지 않아서 생기는 소프트웨어 오류
* 프로세스를 장기간 동작시켜야 하는 서버 프로그램같은 소프트웨어들이 매우 위험함


## 메모리 누수를 막기위해 어떻게 해야하나
* 프로세스가 끝나는 시점에서 할당된 변수를 항상 제거


# static에 대해 설명해봐라 
* C(절차지향) 에서의 static 은 지역변수와 지역변수 둘의 성질을 함께 가짐
* 선언된 함수 내에서만 사용가능하지만 한번 초기화 되면 종료될때까지 메모리 공간에 존재함
* 객체지향에서의 static은 일반적으로 클래스 맴버라고 부른다. 그 이유는 클래스 내에 선언이 되어 클래스 기반으로 선언된 모든 객체들이 static맴버를 참조할 수 있기 때문이다.





# 인자
* 5개 이상 인자를 받을 때 오류가 난다는 논문

# Call by Value
* 결론부터 말하자면 java는 항상 call by value이다. 흔히 java의 오해를 살 수 있는 부분을 살펴보자.
* call by reference가 아닌 또다른 이유는 자바에서는 객체의 주소를 가져오는 방법이 없다. 만약 call by reference 지원한다면 주소를 가져오는 방법을 지원해야 할 것인데 말이다.
```java
public class CallByValue {

  public static void main(String[] args) {
    Person p = new Person("wonwoo");
    System.out.println("p.name: " + p.name);
    callByValue(p);
    System.out.println("p.name: " + p.name);
  }

  public static void callByValue(Person p) {
    p = new Person("kevin");
  }
}

class Person  {
  String name;

  public Person(String name) {
    this.name = name;
  }
}

callByValue 메서드부분만 바뀌었다. callByValue 메서드를 보면 이름을 kevin으로 다시 생성해서 할당한다. 만약 자바가 call by reference라면 아까와 동일하게 출력 되어야만 한다. 하지만 이 코드를 출력해보면 다음과 같다.

p.name: wonwoo
p.name: wonwoo
```

# ArrayList, LInkedList 차이
## 데이터의 검색, 삽입, 삭제시 성능 비교
### 검색
* 데이터 검색 시에는 ArrayList는 LinkedList에 비해 굉장히 빠르다. ArrayList는 인덱스 기반의 자료 구조이며 get(int index) 를 통해 O(1) 의 시간 복잡도를 가진다. 그에 비해 LinkedList는 검색 시 모든 요소를 탐색해야 하기 때문에 최악의 경우에는 O(N)의 시간 복잡도를 가진다.

### 삽입, 삭제
* LinkedList에서의 데이터의 삽입, 삭제 시에는 ArrayList와 비교해 굉장히 빠른데, LinkedList는 이전 노드와 다음 노드를 참조하는 상태만 변경하면 되기 때문이다. 삽입, 삭제가 일어날 때 O(1)의 시작 복잡도를 가진다. 반면 ArrayList의 경우 삽입, 삭제 이후 다른 데이터를 복사해야 하기 때문에 최악의 경우 O(N) 의 성능을 내게 된다.

# Hashmap, Hashtable, TreeMap, LinkedHashmap
* Hashmap: 키나 값에 null값 가능, thread safe 하지 않음; Hashtable 반대

## hashmap
* O(1)
* key 값을 중복이 불가능 하고 value는 중복이 가능. value에 null값도 사용 가능하다.


## Treemap
* O(logn) 성능을 보인다.
* TreeMap은 SortedMap 인터페이스를 구현하고 있어 Key 값을 기준으로 정렬이 되어 있는데, 이는 Comparator를 구현하여 정렬 순서를 변경할 수 있다.


## LinkedHashMap
* doulbly-linked list로 저장됨(linked-list 자료구조로 저장된다는 거군요.)
* linked-list므로 당연하게도, 넣은 순서대로 빠져나옵니다.
* HashMap과 마찬가지로 다중쓰레드 사용시에 synchronized가 되지 않습니다.



## System.out.println
```java
java.lang.System은 시스템에 대한 유용한 기능들을 모아놓은 유틸 클래스이고, 그 중에서도 시스템의 표준 출력은 System.out으로 접근할 수 있는데 이는 해당 변수가 public static으로 선언되어 있기 때문이고, 표준출력은 java.io.OutputStream의 일종인데 println 같이 줄바꿈 등을 편하게 하는 메소드 사용을 위해 java.io.PrintStream으로 래핑을 한 것이고, 이는 디자인 패턴으로 말하면 데코레이터 패턴이고....

사실 System.out.println이 뭐냐고 질문해놓고 이런 식으로 답하라면 딴지를 걸기 위한 의도라고 봐야겠죠; 

그럼에도 불구하고 가끔은 왜 그렇게 많은 초중급 자바 개발자 중에 가장 흔히 쓰는 System.out.println에 대해 단 몇 명이라도 javadoc을 뒤져서 정확한 의미를 파악해보려는 사람이 없었을까 의아하기도 합니다.

위와 같이 길게 대답은 못해도 최소한 out이라는 게 PrintStream의 인스턴스다 정도는 인지하고 있어야 하는 게 아닐까요? 아니, 적어도 개발자라면 'System.out.println'이라는 '모양'을 외워서 타이핑을 해서는 안되는 게 아닐까요? 

```









# 자바
- 파일
- 네트워크; 채팅(소켓통신)
- 스레드
- 컬렉션
- 람다식
- 브라우저; 브라우저와 연동: JSP, 스프링
- 데이터베이스; DB와 연동: JDBC


# 특징
* appliance -> support all OS
* oop + 
* JVM
* C++과 다르게 다중 상속을 지원하지 않는다.  
    ^don't support multi inheritance
* no pointer

# 구성맴버
- 클래스의 구성 멤버 - 필드/생성자/메서드

# 라이브러리
- rt.jar


# 인스턴스
- 참조 자료형은 메모리상에 인스턴스(객체라고 하면 오브젝트와 헷갈림)가 있는 주소를 저장한다.
- 객체이기도 하고 힙에 저장 되어있기에 인스턴스라고 한다. 인스턴스로 저장되는 이유는 생명주기가 길어 일정하게 정보를 유지할 수 있다.
- 인스턴스화: 영어 단어인 의 사전적 의미는 예시하다 등이 있으며 여기에서는 인스턴스화라는 instantiate 의미가 된다. new 키워드를 사용하여 생성하고 생성된 인스턴스화된 오브젝트는 힙에 저장이 된다.
- A a = new A()
- A a // 사실상 이거는 스택에 공간 할당 위한 것
- new A() 가 인스턴스화 객체를 만든 것.


# 프로퍼티
- 영어 단어인 의 사전적 의미는 소유물 등이 있으며 여기에서는 속성이라는 의미가 된다 property . 자바의 속성은 직접 호출하지 못하고 메소드로 호출해서 변경해야 한다. 속성은 private 접근 제한자로 선언한 멤버변수를 멤버변수 자신을 가리키는 this 키워드로 접근하여 변경한다. 

# 생성자
- 영어 단어인 constructor의 사전적 의미는 제작자 등이 있으며 여기에서는 생성자라는 의미가 된다. 생성자는 클래스인 오브젝트를 초기화하여 오브젝트가 인스턴스화되는 시점에서 호출된다. 
- 역할은 초기화; 파이썬에서는 초기화라 부름 

# 캡슐화
- 영어 단어인 의 사전적 의미는 캡슐에 넣음 등이 있으며 여기에서는 캡슐화라는 Encapsulation 의미가 된다. 캡슐화는 특정 인스턴스 변수를 오브젝트 내에서만 적용할 수 있도록 정의하여 외부 접근을 허용하지 않는 것이다. 자바에서는 인스턴스 변수에 private 접근 제한자를 선언하여 캡슐화한다. 캡슐화된 인스턴스 변수는 메소드에 의해서만 호출이나 변경이 가능하다.
- 멤버 변수들의 집합이다.  멤버 변수 앞에 접근 제한자 private를 붙여 메소드에 의해서만 호출이나 변경을 가능하게 한다.
- 1. # 커맨드(DB와 연동 안함)  2. # DTO(데이터 베이스와 연동) 3. # VO(DB와 연결하지만 get-set만 사용)
- 접근법: 1. 생성자 2. get-set 3. toString


# 추상화
- 영어 단어인 abstraction의 사전적 의미는 관념 등이 있으며 여기에서는 추상화라는 의미가 된다. 추상하는 복잡한 상속을 통한 오브젝트의 속성의 결합은 반드시 현실 세계를 모의 실험을 할 수 있어야 한다는 것이다.

# 메소드
- 영어 단어인 의 사전적 의미는 방법 등이 있으며 여기에서는 기능이라는 의미가 된다 method . 메소드는 오브젝트에 의해서 접근하여 퍼렌씨시스 안의 매개변수를 통해서 인스턴스의 ( )( ) 값을 전달하고 호출한다. 

# 필드
- 매개 변수를 필드라 부르기도 하며 클래스 안의  멤버 변수 등도 필드라 한다.

# 상속
- 영어 단어인 inheritance의 사전적 의미는 상속 등이 있으며 여기에서는 상속이라는 의미가 된다. 상속은 부모 클래스에 의해서 자식 클래스로 생성하는 방법으로 일반적으로 메소드를 사용한다.
- 상속 받았다고 하면 대다수 메소드를 상속받은 것이다.

# 다형성
- 영어 단어인 의 사전적 의미는 동질 이상 등이 있으며 여기에서는 다형성이라는 polymorphism 의미가 된다. 화학에서 동질 이상은 화학 조성이 같은 물질이지만 다른 결정 구조를 갖는 것을 의미하는 것과 같이 프로그래밍에서의 다형성은 오브젝트들이 같은 메소드를 정의하지만 구현하는 방법이 다른 것을 말한다. 
- 상속에 의해서 이루어짐.

# java beans
- 자바빈즈(JavaBeans)는 자바로 작성된 소프트웨어 컴포넌트이다.
- 자바빈즈의 사양은 썬 마이크로시스템즈에서 다음과 같이 정의되었다. "빌더 형식의 개발도구에서 가시적으로 조작이 가능하고 또한 재사용이 가능한 소프트웨어 컴포넌트이다."
- 많은 측면에서 유사성을 보임에도 불구하고 자바빈즈는 엔터프라이즈 자바빈즈(EJB)와 혼동하지 말아야 한다. EJB는 자바 플랫폼, 엔터프라이즈 에디션(Java EE)의 일부로서 서버 계열의 컴포넌트이다.
- set-get
- Arrraylist 처럼 담는 것보다는 출력적 역할을 하는 것을 담는 역할(모델, 비즈니스모델)

### 조건
- 클래스는 직렬화되어야 한다.(클래스의 상태를 지속적으로 저장 혹은 복원 시키기 위해)
- 클래스는 기본 생성자를 가지고 있어야 한다.
- 클래스의 속성들은 get, set 혹은 표준 명명법을 따르는 메서드들을 사용해 접근할 수 있어야 한다.
- 클래스는 필요한 이벤트 처리 메서드들을 포함하고 있어야 한다.




# java
## 도스
* 관리자 명령어 
* cd .., cd  2. md 3. C:, D:  4. dir
* 디렉터리명 특정 디렉터리로 이동한다 cd : . 
* 상위 디렉터리로 이동한다 cd.. : .       
* 최상위 디렉터리로 이동한다 cd/ : . 
* del

## 번역기
* # 번역기 종류: 컴파일/인터프리터
* # 컴파일: 문법에 맞는지 확인
* # 인터프리터; 문법에 관계없이 확인(종료 없이 일단 수행 후 알려줌) -> 예외처리




## 디렉터리의 기능 
* 디렉터리 bin ⎼자바 개발에서 실행하는데 필요한 도구와 유틸리티가 있다; begin의 약자라고 생각하면 쉬움(즉 실행시켜주는 파일)
* 디렉터리 db ⎼데이터 관련 도구와 유틸리티가 있다. 
* 디렉터리 include ⎼네이티브 코드 프로그래밍에 필요한 헤더 파일이 있다. 
⎼네이티브 코드는 와 운영체제가 직접 실행할 수 있는 코드를 의미한다 CPU . 
* 디렉터리 jre ⎼자바 런타임 환경으로 클래스 라이브러리 등의 실행에 필요한 파일이 있다 JVM, 
* 디렉터리 lib ⎼ 의 기본 라이브러리 외에 추가 라이브러리와 개발 도구에서 필요한 여러 파일이 있다 


# 클래스 파일
- java는 그냥 읽어오는 것; 클래스 파일을 찾기 위한 과정; 실행하는 것은 class 파일; javac __.java; class 파일 나오고 .java 파일 삭제해도 실행됨.
- 자바는 클래스 파일로 생성되는데 이를 자바코드로 인식하게 하는 것이 소스코드; java 이름

##  CLASSPATH 설정
* 변수 이름인 는 실행 시에 클래스 파일의 위치와 참조 파일들의 위치 지정한다 CLASSPATH . 에는 등의 도구 본채가 있으므로 를 설정하면 어디에서나 tools.jar javac.exe JDK CLASSPATH 클래스 파일을 실행시킬 수 있다. 이상 버전에서는 를 설정하지 않아도 되지만 이하 버전에서는 개발의 JDK 7 CLASSPATH JDK 6 편리성을 위해서 를 반드시 설정해야 한다 CLASSPATH .
* 라. 환경 변수의 등록 확인 환경 변수 설정 후에는 명령 프롬프트에서 으로 자바의 컴파일 버전을 확인한다 javac -version . 자바의 버전이 출력되면 환경 변수 설정이 제대로 되었다는 의미가 된다. 자바 버전이 출력되지 않고 은는 내부 또는 외부 명령으로 실행할 수 있는 프로그램 또는 javac ( ) 배치 파일이 아닙니다 라고 나오면 환경 설정이 제대로 되지 않았으므로 환경 변수 설정을 수정한다 . . 새로운 환경 변수를 수정하고 나면은 기존에 실행한 명령 프롬프트는 종료하고 반드시 새로운 명령 프롬프트에서 확인을 해야 한다. 새로운 명령 프롬프트가 아니면 환경 변수에서 수정한 내용을 인식하지 않는다. 환경 변수 설정 후에 도스 명령어가 실행되지 않으면 에 를 path %SystemRoot%\system32 추가 해주면 된다.
* CLASSPATH 설정 변수값을설정할때주의할점은 설정할 때 도트 기호 부분을 .( ) 명확하게 해 주어야 한다. 도트 기호는 컴퓨터의 자신을 가리킨다.

## Path
 * Path Path . 일반적으로 프로그램의 실행 디렉터리의 이름은 의 약자인 으로 되어 있다 binary bin . 변수 값을 뒤에 추가를 해 주면 끝에 세미콜론 이 없다면 세미콜론 을 추가한다 
 * * 설정 AVA_HOME 변수인 은 JAVA_HOME 자바의 홈 디렉터리로 자바가 설치된 경로를 의미한다.
 * Path 설정 는실행 디렉터리의 위치를Path 지정한다. 자바의 디렉터리가 위치한 bin 경로이다.
 * 자바의 bin
 * 시스템 변수에 C:\Program Files\Java\jdk1.8.0_202\bin  를 추가함으로 인해 자바 소스코드를 자바 폴더안에만 넣을 필요가 없음
 * 시스템 변수 PATH에 넣기
 *  혹은 시스템 변수 새로 만들기 - 변수 이름 지정(JAVA_HOME)/경로 넣기
 *   C:\Program Files\Java\jdk1.8.0_202;  버전 바뀌면 자바 홈만 변경
 * %JAVA_HOME%\bin             
 * 윈도우 7이엇으면 ;
* javac -version: 으로 확인; 명령 프롬프트를 재실행 해주어야 함.
* java -version: 자바 안의 프로그램 구조


# java 특징
* appliance -> support all OS
* oop + 
* JVM
* 다중 상속을 지원하지 않는다.  
  ^don't support multi inheritance
* no pointer
 * 다. 안전하다. 자바는 분산 환경에서 실행될 수 있도록 개발 환경과 실행 환경이 분리되어 있다. 자바 가상 머신인 은 의 약자이며 무결성에 대한 필수적인 검사를 JVM Java Virtual Machine 수행한다.
 * 라. 견고하다. 자바는 다양한 컴퓨터에서 실행되어야 하므로 높은 신뢰성이 요구되므로 견고하다. 엄격한 자료형의 검사를 지원하며 프로그램 실행할 때에 오류가 발생하면 예외로 처리한다.
 * 구조에 중립적이고 이식성이 높다. 자바는 에서 실행되는 바이트 코드를 사용함으로 특정 컴퓨터에 종속되지 않는다 JVM . 자바는 한번 작성되면 이 설치된 모든 종류의 컴퓨터에서 실행할 수 있다 JVM . 자바는 언어의 문법뿐만 아니라 시스템 종속적인 부분까지도 시스템 구조에 대하여 중립적으로 설계되어 있어 높은 이식성을 제공한다.
 * 바. 높은 성능을 가지고 있다. 자바가 지원하는 바이트 코드는 인터프리터에 의해 효율적으로 수행될 수 있도록 설계되다. 자바 번역기는 바이트 코드 생성 시에 자동 레지스터 할당과 최적화를 수행하여 효율적인 바이트 코드를 생성한다. 실행의 효율성을 제공하기 위해 컴파일러를 제공한다 JIT . 는 의 약자이며 프로그램을 실행하는 시점에서 필요한 부분을 즉석에서 JIT Just In Iime Compiler 컴파일 하는 방식이다. 
 * 사. 멀티스레드를 지원한다. 자바는 동시에 수행하여야 하는 작업들을 스레드 기술할 수 있으며 스레드의 편리한 사용을 위한 라이브러리를 제공한다. 하나의 프로그램에서 여러 개의 스레드가 병렬적으로 수행되기 때문에 프로그램이 효율적으로 실행될 수 있다. 서블릿에서도 클라이언트의 요청에 대해서 하나하나를 스레드 단위로 처리해 주기 때문에 성능이 우수하다. 
 * 아. 플랫폼에 독립적이다. 플랫폼에 상관없이 한번 작성되어 컴파일 된 파일은 어떤 플랫폼에서도 동일하게 실행된다  
 * 자. 동적이다. 자바는 변화하는 환경에 적응되도록 설계된 언어로서 기존의 프로그램에 영향을 주지 않고 라이브러리에 새로운 메소드나 속성들을 추가할 수 있다. 프로그래밍 실행시에 프로그램 실행에 필요한 라이브러리들을 연결하는 기능을 제공한다. 
 * 차. 보안이 강하다. 자바는 네트워크 프로그래밍을 수행할 때 외부에서의 데이터 접근을 허용하지 않는다. 자바는 어플리케이션 구조나 데이터에 접근하지 못하게 할 수 있다.
 * 카. 분산 환경에 적합하다. 자바는 네트워크 또는 인터넷을 통하여 효율적으로 수행될 수 있도록 설계되었다. 자바는 프로토콜 등과 연관된 라이브러리를 제공한다 HTTP, FTP . 
 * 타. 가 적용된다 RTTI . 는 의 약자이다 RTTI Run Time Type Information . 는 다형성에 나오는 개념으로 호출하는 메소드 결정을 런타임 시에 결정하므로 다형성을RTTI 사용할 수 있다. 
 * 파. 인터프리터에 의해 실행된다. 자바는 컴파일과 인터프리터를 동시에 수행하는 독특한 실행 방식으로 실행된다.



# 기반
* 프로토타입 기반: 복제를 통한 프로그래밍(자바의 인터페이스)
* 클래스 기반: 상속을 통한 프로그래밍


# import; 패키지명.클래스명
* import 키워드는 패키지의 클래스를 사용하기 위하여 선언한다. 임포트를 사용하게 되면 패키지가 서로 달라도 접근이 가능하다. 중에서 패키지는 최상위 패키지이므로 임포트하지 않아도 패키지의 클래스를 API java.lang 사용할 수 있는 유일한 패키지이다. 임포트의 선언은 클래스 선언보다 먼저 선언되어야 한다. 패키지를 선언할 경우에는 패키지 선언 다음에 임포트의 선언을 해야한다. 클래스명 대신에 모든 클래스를 의미하는 아스테리스크 기호를 사용할 수도 있지만 가독성이 ( ) 떨어지므로 권장하지 않는다.  모두 다 찾아와서 속도를 늦춰 권장하지 않는다.
 * java.lang에 있는 것들은 import 필요 없음
 * java.util 은 다른 사람들이 만든 것을 공유해 주는 것

## java.lang
- import 쓰고 있지 않아도 가지고 있는 패키지
- lang의 조상은 Object^
- java.lang은 자바 프로그램에서 가장 많이 사용되는 패키지로서 자바 프로그램내에 'import' 문을 사용하지 않아도 자동으로 포함된다. 그만큼 자바 프로그램의 기본이 되는 클래스들과 인터페이스들이 포함되어 있다.

## java.util

# StringTokenizer 
- StringTokenizer 클래스는 지정한 문자열을 특정 구분자로 분리하여 분리된 문자열들을 토큰으로 반환한다. 
- StringTokenizer 클래스는 특정 데이터들이 특정 구분자로 해당 데이터들을 구분자로 분리하여 데이터들을 추출할 수 있다. 
- StringTokenizer 클래스는 문자열에서 단어를 분리하는 기능을 가지고 있으며 각각의 단어는 구분 기호인 delimiter . 에 의해 토큰으로 분리된다 
- 다음은 어깨동무 자바는 자바 강의의 혁명이다. 라는 문자열을 공백 문자를 구분 기호로 사용하여 토큰으로 분리하므로 5 . 개의 토큰이 생긴다

## 주요 메소드
- ① countTokens 메소드 countTokens 메소드는 StringTokenizer 클래스에 저장되어 있는 전체 토큰 개수를 반환한다. 
- ② hasMoreTokens 메소드 hasMoreTokens 메소드는 작업을 할 수 있는 토큰이 더 있는지를 판단한다. 
- ③ nextToken 메소드 nextToken 메소드는 다음 토큰을 반환한다

## split 과의 차이
- 이번에는 StringTokenizer 클래스에 대해 알아보려고 하는데요. split과 둘의 차이점이라고 한다면 split은 String클래스의 메소드로 추출한 문자를 배열로 저장하고, StringTokenizer는 메소드가 아니라 java.util에 포함되어 있는 자체 클래스입니다. 그렇기 때문에 사용하는 방법이 다르고 StringTokenizer클래스는 내부에 꼭 넣어야 하는 메소드가 존재합니다.




# random
- 1. Math 밑에 random 2. Random Class; 보통 이것 사용
- 이메일 검증할 때 사용;
- seed 값: 시간에 따라서
난수에 대한 필요성은 빈번히 발생하는데 특히 보안코드를 생성할 때 난수를 사용한다. 
- Random 클래스는 임의의 값을 발생시켜 주는 의사난수 발생기이다. Random 클래스는 일정 범위의 값들에서 한 개의 수를 임의로 선택한다. 
- Random 클래스의 인스턴스를 호출시 생성되는 난수들이 달라지는 seed 값으로 임의의 난수값을 얻는다. 
- seed . 값을 인자로 사용하여 매번 다르게 주어 매번 다른 의사난수를 추출하여 사용한다 seed . 
- 값은 일반적으로 현재 시간을 이용한다 매 순간 현재 시간이 바뀌며 한 번 지나간 시간은 다시 돌아오지 않는다는 특성은 이전에 발생했던 의사난수를 다시 재연 불가능하게 만들며 시간이 밀리초 단위로 섬세하게 표현된다면 사람에 의한 임의적 조작도 사실상 불가능해진다. 
- int 형의 정수 랜덤값을 추출하기 위해서는 Random 클래스의 인스턴스에 nextInt 메소드를 호출하면 된다. 
- nextInt 메소드 호출시에 매개변수를 넣어 주지 않으면 int 타입의 전체 범위에서 랜덤값을 추출한다.

## 차이점
- Math.random()과 Random의 차이점 : 종자값(seed)을 설정할 수 있다는 것이다. 종자값(seed)는 쉽게 생각해서 "기준점"이라고 생각하면 되겠다. 같은 종자값(1)을 사용하기 때문에 같은 실행결과를 얻는다.

# 랜덤 예제
 * package a.b.c;
 * 
 * import java.util.Random;
 * 
 * public class A {
 *   static String string = "java";
 * 
 *   public static void main(String[] args) {
 * 
 *     Random random = new Random(10);
 *     for (int i = 0; i < 2; i++) {
 *       System.out.println("random 값" + random.nextInt());
 *     }
 * 
 *     Random random2 = new Random(10);  // 객체를 두개 만들고 seed 값을 같게 하면 같은 결과 출력;  한개의 객체에 두번 출력하면 다른 값출력; 절차적인 언어인 C언어와 달리 객체는 동시에 실행되니 두개의 객체를 만들면 같은 시간에 실행된다고 생각.
 *     for (int i = 0; i < 2; i++) {
 *       System.out.println("random 값" + random2.nextInt());
 *     }
 *   }
 * }


# System.out.println
* System.out.println 방식의 출력은 시스템 리소스를 필요 이상으로 잡아먹는다는 한계가 존재합니다. 시간과 리소스를 고려한다는 측면에서 우리는 빠른 입출력 방식인 BufferedWriter를 사용할 수 있습니다.

## Random 메소드
- ① next 메소드
= next 메소드는 다음의 의사 난수를 생성한다.
- ② nextFloat 메소드
- nextFloat 메소드는 0.0에서 1.0의 범위에서 float 자료형으로 의사 난수를 반환한다.
- ③ nextInt 메소드
- nextInt 메소드는 int 자료형의 의사 난수를 반환한다.

# Date
- Date 클래스는 날짜와 시간에 관한 정보 클래스이다.
-  Date 클래스는 JDK가 버전업되면서 많은 메소드가 더 이상 사용되지 않고 앞으로는 사라지게 되었다. 
- Date 클래스는 toString 메소드가 재 정의되어 있어 인스턴스를 직접 출력하면 날짜 및 시간이 출력된다. 
- Date 클래스 보다는 가능하면 Calendar 추상 클래스를 사용하는 것을 권장한다


## Date 메소드
- ① after 메소드 after 메소드는 날짜가 현재 날짜 이후면 true로 아니면 false를 반환한다. 
- ② before 메소드 before 메소드는 날짜가 현재 날짜 이전이면 true로 아니면 false를 반환한다.
- ③ compareTo 메소드 compareTo 메소드는 다른 날짜 오브젝트와 비교하여 음수, , 양수 0의 결과를 반환한다. 
- ④ equals 메소드 equals 메소드는 날짜의 값을 비교하여 그 결과를 반환한다. 
- ⑤ getTime 메소드 getTime 메소드는 1970년 1월 1일 0시 0분 0초로부터의 시간을 1/1000초 단위로 반환한다. 
- ⑥ setTime 메소드 setTime 메소드는 1970년 1월 1일 0시 0분 0초로부터의 시간을 1/1000초 단위로 설정한다.

## Calendar
- Calendar 추상 클래스는 Date 클래스처럼 날짜와 시간에 관한 정보를 표현할 때 사용한다. 
- Date 클래스에서 사라진 메소드 중에 같은 기능의 메소드가 Calendar 추상 클래스에서 제공된다. 
- Calendar 추상 클래스는 getInstance 스태틱 메소드를 이용하여 인스턴스를 생성한다. 
- Calendar 추상 클래스의 주요 상수는 다음과 같다. 
- ① YEAR : 현재 년도 
- ② MONTH : 현재 월 
- ③ DATE : 현재 월의 날짜 
- ④ WEEK_OF_YEAR : 현재 년도의 주 
- ⑤ WEEK_OF_MONTH : 현재 월의 주 
- ⑥ DAY_OF_YEAR : 현재 년도의 날짜 
- ⑦ DAY_OF_MONTH : 현재 월의 날짜 
- ⑧ DAY_OF_WEEK : 현재 요일로 일요일은 1, 토요일은 7이다. 
- ⑨ HOUR : 12시간제의 현재 시간 
- ⑩ HOUR_OF_DAY : 24시간제의 현재 시간 
- ⑪ MINUTE : 현재 분 
- ⑫ SECOND : 현재 초 

## Calendar 예제
 * package min.f.dateclass;
 * import java.util.Calendar;
 * public class CalendarCall {
 * public static void main(String[ ] args) {
 * //인스턴스를 생성한다.
 * Calendar calendar = Calendar.getInstance( );
 * //년을 구한다.
 * int year = calendar.get(Calendar.YEAR);
 * // 1 . 을 더해서 현재의 월을 구한다
 * int month = calendar.get(Calendar.MONTH) + 1;
 * //현재의 일을 구한다.
 * int day = calendar.get(Calendar.DAY_OF_MONTH);
 * System.out.print(year + " " 년 );
 * System.out.print(month + " " 월 );
 * System.out.print(day + " " 일 );
 * }
 * }

 - Calendar calendar = Calendar.getInstance( ); ⎼Calendar 클래스는 추상 클래스이므로 new 키워드로 인스턴스를 생성할 수 없으므로 getInstance 메소드로 현재 시스템의 날짜를 통해 인스턴스를 생성한다. 
- ✍ int year = calendar.get(Calendar.YEAR); ⎼Calendar 추상 클래스의 YEAR 상수로 년도를 가져온다. 
- ✍ int month = calendar.get(Calendar.MONTH) + 1; ⎼Calendar 추상 클래스의 MONTH 상수로 월의 가져온다. ⎼월의 인덱스의 범위가 0에서 11이므로 실제 월을 출력하기 위해서는 1를 더해 주어야 한다. 
- ✍ int day = calendar.get(Calendar.DAY_OF_MONTH); ⎼Calendar 추상 클래스의 DAY_OF_MONTH 상수로 날짜를 가져온다.


### 기준일로부터의 경과일 
 * package a.b.c;
 * 
 * import java.util.Calendar;
 * import java.util.Date;
 * 
 * public class A {
 * 
 *   public static void main(String[] args) {
 *     Date date = new Date();
 *     Calendar calendar = Calendar.getInstance();
 *     // 현재 날짜를 지정한다.
 *     calendar.setTime(date);
 *     Calendar calendar2 = Calendar.getInstance();
 *     calendar2.set(2016, 12 - 1, 12);
 *     int count = 0;
 *     // 현재 날짜를 비교한다.
 *     while (!calendar2.after(calendar)) {
 *       count++;
 *       // 설정된 날짜에서 지정된 숫자만큼 가산하여 다음날로 바꾼다.
 *       calendar2.add(Calendar.DATE, 1);
 *     }
 *     System.out.println("기준일로부터 " + count + "일이 지났습니다  .");
 *   }
 * }


- ✍ calendar.setTime(date); ⎼calendar 인스턴스의 setTime 메소드로 인자값인 Date 클래스의 date 인스턴스로 현재의 날짜를 지정한다. 
- ✍ calendar2.set(2016, 12-1, 12); ⎼calendar2 인스턴스의 set 메소드로 현재 인스턴스의 특정 날짜를 설정한다. ⎼현재 월을 출력하기 위해 월의 기본 정보다 1이 많도록 조건을 설정했으므로 -1을 한다. 
- ✍ calendar2.add(Calendar.DATE, 1); ⎼calendar2 인스턴스의 add 메소드에 설정된 날짜에 지정된 숫자만큼 가산하여 다음날로 바뀐다. 




# class
* 영어 단어인 의 사전적 의미는 학급 등과 같이 여러가지가 있으며 여기에서는 부류라는 class 의미가 된다. 품사는 단어를 기능 형태 의미에 따라 나눈 갈래인데 영어로는 라고 한다 , , word class . 에서의 를 가져다가 적용한 것이 word class class class 키워드라고 생각하면 된다. class 키워드는 클래스를 선언하며 클래스명 앞에 선언하며 소문자로 작성해야 한다.

# main 키워드
* 영어 단어인 main의 사전적 의미는 중요한 등과 같이 여러가지가 있으며 여기에서는 주된이라는 의미가 된다. 
* main 키워드는 메소드의 이름이며 main 메소드는 자동으로 실행하는 특수한 메소드이다. main 메소드는 프로그램의 시작점으로 자동 실행되어 나머지 필요한 메소드를 호출하여 실행한다. 일반적인 메소드는 호출되어야 실행되지만 main 메소드는 호출되지 않아도 실행될 수 있는 유일한 메소드이다. 
* 자바 프로그램은 main 메소드 내에서 클래스의 인스턴스를 생성 한 다음에 그 인스턴스에 메시지를 보내어 원하는 결과를 얻는다.
* main 메소드의 매개변수인 String[ ] args는 프로그램 실행시에 초기값을 전달한다.

# 메인함수 public static void main( String[] args)
- String[] args: 문자열 형태로 하나씩 나열해서 들어간다.
- 연속적인 문자열 데이터가 들어가는 저장공간 이라고 생각하며 됩니다.
- args 는 단순한 변수명입니다. 아무변수명이나 넣어도 상관없죠~ 

## 메인함수 변경 가능
1. public, static 순서는 바뀌어도 상관없으나 리턴타입은 반드시 메쏘드 명 앞에 와야함
2. main(String[] args)를 아래와 같이 바꿔도 실행됨 
   - > main(String []args) 
   - > main(String args[])


3. args대신 어느 자바 구별자로 사용 가능


4. main(String[] args)에서 main(String... args)로 변경 가능(자바 v1.5이상부터)


5. final, synchronized, strictfp(자바 v1.2부터) modifier를 main()와 같이 선언할 수 있음


## 메인함수 예제
 * public class SampleProject {
 *  
 *     public static void main(String[] args) {
 *          
 *         args = new String[3]; //3개의 저장공간을 가진 배열 초기화
 *         args[0] = "안녕"; //배열의 첫번째 공간에 데이터입력
 *         args[1] = "반가워"; //배열의 두번째 공간에 데이터입력
 *         args[2] = "버물리라고해"; //배열의 세번째 공간에 데이터입력
 *          
 *         System.out.println(args[0]);
 *         System.out.println(args[1]);
 *         System.out.println(args[2]);
 *          
 *     }
 *  
 * }


# print
* print 메소드는 동기화가 되지 않고 출력한다.  println . 메소드는 동기화가 되어 출력한다
1. 공간을 만든다, 주소 생성(절대, 상대)
2. 패키지는 충돌을 방지
3. 사람이 소수일 땐 print(속도가 빠름), 많을 땐 println

# printf
 * System.out.printf("%5c", 'A');  // 5칸 띄어서 출력
 *  가운데 ,는 연결 자료형


# static
 * 영어 단어인 의 사전적 의미는 정지 상태 등과 같이 여러가지가 있으며 여기에서는 공유라는 static 의미가 된다. 
 * static 키워드는 new 키워드로 인스턴스를 생성하지 않고도 main 메소드를 실행시킬 수 있다. 
 * static 키워드로 지정된 멤버변수나 메소드는 메모리에서 같은 주소를 계속해서 사용한다. 
 * static 키워드를 사용하면 메모리에 제일 먼저 전달이 되므로 main 메소드 앞에 지정해야 한다. 
 * static 멤버변수나 메소드에 의해 호출이 되면은 클래스를 초기화 할 때에 맨 처음으로 메모리에 적재된다.
- static 안달면 스택에 직접 접근할 수 있는 방법이 사라져 Class에서 불러올 경우 new 로 힙으로 당긴 후 값을 가져와야 한다.

# static
- 영어 단어인 의 사전적 의미는 정지 상태 등이 있으며 여기에서는 공유라는 의미가 된다
- static 지정어는 클래스 변수 메소드의 지정자로 사용할 수 있으며 단 한번만 생성된다
- static 지정어는 전역적 의미로 선언을 하면 어디에서 접근하든 그 상태를 유지할 수 있는 공유의 기능을 가진다. 
- static 지정어로 선언한 변수는 공유 변수이므로 메소드에서 오버라이딩이 불가능하다.

### static 멤버변수 
- static 멤버변수는 프로그램이 실행할 때 자동 생성되고 프로그램이 종료될 때 자동 삭제되므로 인스턴스 생성과 전혀 관련이 없으므로 생성된 모든 인스턴스에서 공유가 가능하며 클래스로 직접 접근할 수 있다. 

### static 메소드
- static 메소드 안에서는 인스턴스 멤버변수를 사용할 수 없는데 static 지정어가 초기화 시점이 인스턴스 멤버변수보다 빠르기 때문이다. static 메소드 내에서는 일반 메소드도 호출할 수 없다. 
- 인스턴스 멤버변수나 일반 메소드를 static 메소드 안에서 참조하려면 인스턴스를 생성한 후 인스턴스를 통해서 참조해야 한다. 

###  static 임포트 
 static 임포트는 버전에서 추가된 기능으로 JDK 1.5 static 변수나 static 메소드를 임포트 하는 기능으로 자바에서 특정 클래스를 임포트 한다.
- import static 패키지명클래스명멤버변수명 . . ; 
- import static 패키지명클래스명메소드명 . . ; 
- import static 패키지명클래스명
- 자주 사용되는 유틸성 클래스 안의 메소드들을 static 지정어로 정의하고 다른 클래스에서 static 임포트를 정의해서 사용한다.




### 예제
 * public class Child extends Parent {
 * 
 *   static {
 *     System.out.println("333");
 *   }
 *   {
 *     System.out.println("33");
 *   }
 *   {
 *     System.out.println("33");
 *   }
 * 
 * }
 * 
 * B b = new B();
 * B b1 = new B();
 * 두개 생성해도 static꺼는 한개만 나온다. -> 공유 기능이 있다.



# 패키지 만들기
 * 디렉토리 만들기: javac -d . PackageCall.java; 이러면 import 안의 경로로 class가 들어감;  d는 패키지 선언
 * java 민.내가만든.패키지관련.PackageCall;  명령 프롬프트에서 이렇게 실행


# 이클립스
 * https://www.eclipse.org/downloads/
 * 자바 버전에 맞게 다운 받기
 * 자바는 힙 크기 조절해 주어야 함(new 사용이 많음)
 * OpenPerspective 자바 변경

## delete
- 쓰지 않는 프로젝트 delete(완전삭제 안하기)  

## import
- 이클립스 import - General - Existing projects into workspace
- 버전 안맞으면 Build path - Configure Path

## export
- export -> java -> JAR file



## 이클립스 설정
 * eclipse 설정 클릭
 * -Dfile.encoding=UTF-8

## 이클립스 단축키
 * Ctrl + I : 들여쓰기 자동 수정
 * Ctrl + Shift + O : 자동 import 
 * Ctrl + Shift + L    단축키 표시
 * Ctrl + Shift + F 줄정렬
 * Ctrl + / 주석처리
 
# 컴파일
 * 자바의 컴파일 과정은 간단하다. 개발자가 작성한 자바 코드(.java)를 컴파일러가 기계어인 자바 바이트 코드(.class)로 변환시켜 주고, 변환된 코드를 인터프리터가 한줄씩 실행시키면서 애플리케이션을 실행하게 된다.
 
# 클래스 파일
 * 자바 소스는 에서 실행될 수 있는 기계어인 바이트 코드로 번역되며 번역된 바이트 코드는 JVM 바이트 코드 해석기가 있는 어떠한 기종의 컴퓨터 환경에서도 실행될 수 있다. 


# 힙
 * 자바는 힙 크기 조절해 주어야 함(new 사용이 많음)
- 힙은 개발자가 관리하는 가상 메모리
- 값의 변경이 불가하다.
- 값의 변경이 불가하기 떄문에 중괄호가 없는(return 값 받을 수 없는) 값 생성 의미없음
- 힙에 저장되는 주소: System.out.println(s.hashCode());
    - 눈에 안보이는 힙에 저장되는 주소
  - 누구나 접근 가능하지만 값을 수정할 수는 없다. 누구나 수정할 수 있는 스택과 다르다; 여기서 ‘누구나’는 개발자가 아니라 사용자를 말한다.
- 메모리의 힙(heap) 영역은 사용자가 직접 관리할 수 있는 '그리고 해야만 하는' 메모리 영역입니다.
- 힙 영역은 사용자에 의해 메모리 공간이 동적으로 할당되고 해제됩니다.
- 힙 영역은 메모리의 낮은 주소에서 높은 주소의 방향으로 할당됩니다.


# 스택
- 스택이 수정 가능한 이유; 내가 그걸 쓰면 바로 소멸되기 때문.
* 모든 데이터는 스텍으로 구성된다. 여기서 new로 객체 생성하면 힙으로 옮겨진다.
- 모든 데이터가 담기는 곳; 자동으로 소멸
- 스택은 값의 변경이 가능하다
- InputStreamReader inputStreamReader = new InputStreamReader(System.in);
뒤에 있는 힙 값을 변경하기 위해서는 스택에 저장을 해야 함.
* 오브젝트: 스택에 저장
* 스택의 자료를 힙에 저장: new; 힙에 저장됨으로 인해 접근이 가능하다.(파이썬에서는 자동으로 new를 안써도 생성해줌)
* 인스턴스: 힙에 저장됨
- 누구나 수정할 수 있지만 누구나 접근할 수 있는 힙과 다르다. (static 하면 접근 가능); 여기서 ‘누구나’는 개발자가 아니라 사용자를 말한다.
- 자바의 메소드는 변수적 역할이라 스택에 쌓이고 C는 함수적 역할이라 코드 영역으로 취급한다.
- 메소드, 지역 변수, 매개변수 등 호출되면 값이 소멸된다.


# jar
 * rt.jar; 자바에서 기본 제공하는 단어들
 * 속성 - Java Source Attachment -> external -> C:\Program Files\Java\jdk1.8.0_202\src 열기
 * java.lang -string

# 주소
- 스택에 저장되는 주소:  
- System.out.println(System.identityHashCode(a));
     - 힙에 저장되는 주소: System.out.println(s.hashCode());

## @
- jg.begin.start.jae_0305.B@15db9742; // @ 주소값에 0305 패키지 안의 B 클래스 값이 저장되어 있다.


# 플러그인
 * Eclipse market place - jad 
 *  -> preference-> Editor -> file assosiation -> default -> class deomplier ‘default’ 설정

# 똑똑하게 압축풀기
 * OS마다 길이 제한
 * 한글 사용 오류 가능성

# 동기화
 * print 메소드는 동기화가 되지 않고 출력한다.  println . 메소드는 동기화가 되어 출력한다
 * 사람이 소수일 땐 print(속도가 빠름), 많을 땐 println 

* 필드에 Collection이 불가피하게 필요할 때는 어떠한 방법을 사용할까? Java에서는 synchronized 키워드를 사용하여 스레드 간 race condition을 통제한다. 이 키워드를 기반으로 구현된 Collection들도 많이 존재한다. List를 대신하여 Vector를 사용할 수 있고, Map을 대신하여 HashTable을 사용할 수 있다. 하지만 이 Collection들은 제공하는 API가 적고 성능도 좋지 않다.
* 기본적으로는 Collections라는 util 클래스에서 제공되는 static 메소드를 통해 이를 해결할 수 있다. Collections.synchroziedList(), Collections.synchroziedSet(), Collections.synchroziedMap() 등이 존재한다. JDK 1.7 부터는 concurrent package를 통해 ConcurrentHashMap이라는 구현체를 제공한다. Collections util을 사용하는 것보다 synchronized 키워드가 적용된 범위가 좁아서 보다 좋은 성능을 낼 수 있는 자료구조이다.

# 실수형
 * 고정; 고정 소수점 방식
 * 가변; 부동 소수점 방식; 컴퓨터가 가지고있는 기능에 맡기겠다.
 * 고정(32비트)
 * 가변(64비트)
-  float f = 1f / 3f;
  -  double f = 1f / 3f;  // 더 정밀도가 있고 double형도 f를 써도 된다.
  - double f = .1f / .3f;  // 0 생략 가능
  - double f = 1.f / .3f; // 1.0f는 1.0이라는 의미다.

# ()
 * 무조건 실행; 타입 검증

# IDE; 통합개발환경
 * 이클립스, 파이참

# static
 * 스택

# UTF
 * UTF-8; 가변적 인코딩 방식; UTF-16; 고정적 인코딩 방식

# 패키지
 * 유사 단어들의 모임
 * 충돌 방지
 * import 보다 먼저 선언되어야 한다.
 * java.으로 시작하면 안된다.(sun에서 독점); javax는 외부개발자들의 패키지를 같이 배포해주는 패키지 명이기에 사용 가능. 하지만 안쓰는게 좋다.
 * 보통 자기 이니셜을 1번에 놓는다. jg.begin.start
- implement java.io.Serializable; 이렇게 쓰면 import 안하고 쓸 수 있지만 줄이 길어지는 단점
- 충돌 방지
- import 키워드를 사용하지 않는 경우에는 클래스의 실제 이름으로 지정한다. 
- ☞예시 java.util.Scanner scanner = new java.util.Scanner(System.in);


# 진수
 * 2진수: 0 b숫자
 * 16진수: 0xB
 * int be = 000111; // 0을 붙이면 8진수로 인식

# char
 * 정수타입: byte, short, int, long, char(자판기; 쓰면 아스키코드로 바뀜)
- 배열의 공백 인식한다.


### varchar
- 배열의 공백 인식 안한다.


# string
 * 클래스형 타입; 클래스도 자료형(타입)이 될 수 있다
 * 특별한 클래스이다; 영역이 틀려도 값만 같으면 같은 클래스로 참조한다.
 * 예시
 * String s = “홍길동”’  // A클래스
 * String d = “홍길동”; // B 클래스
 * System.out.println(System.identityHashCode(); 하면 같은 주소 가짐
 * System.out.println(s.hashcode(); 하면 같은 주소 가짐
 * - new를 안쓰고 쓸 수 있는 참조 래퍼런스
-  이미 만들어진 클래스인 String 클래스는 스택과 힙이 서로 다른 주소 가짐
- “ “ 안에 데이터가 들어가지만 사실상 문자열 하나씩 나열되어서 들어간다.


## String 클래스
- 3가지의 동사로 이루어짐
- Sequence Character; 문자가 순차적으로 들어온다.
- Serializable, Comparable<String>, CharSequence 인퍼페이스
- toString 메소드는 CharSequence 인터페이스에만 해당

### String 메소드
- ① length 메소드 length 메소드는 문자열의 길이를 반환한다.
- ② equals 메소드 equals 메소드는 문자열이 일치하는지를 검사한다. 
- ③ substring 메소드 substring 메소드는 부분열을 구한다.  // 경로에 관련된 내용; 중복되는 것을 놔두고 추가 되는 것을 추가해줌
- ④ replace 메소드 replace 메소드는 문자열을 대치한다.  // 양끝 공백을 제거해서 가운데 공백을 없앨 수 없는  trim과 다르게 공백 문자열 없애는 중요 메소드
- ⑤ toUpperCase 메소드 toUpperCase 메소드는 문자열을 대문자로 바꾼다. 
- ⑥ toLowerCase 메소드 toLowerCase 메소드는 문자열을 소문자로 바꾼다. 
- ⑦ charAt 메소드 charAt 메소드는 특정 문자를 반환한다. 
- ⑧ trim 메소드 trim 메소드는 양끝의 공백문자를 제거한다.  // replace와 다르게 양끝의 공백만 가능; 가운데 공백을 지우지 못한다.
- ⑨ concat 메소드 concat 메소드는 문자열을 연결한다. 
- ⑩ endsWith 메소드 endsWith 메소드는 문자열에 지정된 접미사로 끝날지 어떨지를 판단한다. 
- ⑪ indexOf 메소드 indexOf 메소드는 문자열 내에서 지정된 문자가 최초로 출현하는 위치의 인덱스를 반환한다. 
- ⑫ isEmpty 메소드 isEmpty 메소드는 길이가 0인 경우에 한해 true 를 반환한다. // 참조 타입은 Null인 경우; 자주 사용됨.


## String 생성자
-  public String() {
        this.value = "".value;  // 다른언어에서는 몰라도 자바에서는 “” 가 기본것
    }



## toString
-  인스턴스에 대한 정보를 문자열로 제공하기 위한 목적으로 정의됨. 인스턴스를 출력하게되면 toString이 콜됨.
- toString 메소드는 CharSequence 인터페이스에만 해당
- 주소값을 문자열로 변환시켜주는 기능 = 주소값을 실제값으로 변환. 대화체로 변경시켜줌
  - <> Integer.toString(); 값 자체가 실제로 바뀜

### toString 생활코딩 설명
- Object 클래스에 있는 메소드를 오버라이드해서 사용하는 것
- (자바와 같은) 객체지향 언어들은 객체에 toString이라는 메소드를 기본적으로 제공한다.
- 일반적으로 toString은 그 객체를 설명해주는 문자열을 리턴한다.
- 그리고 객체의 toString을 덮어쓰기(overriding)하면 다른 형식의 문자열을 리턴할 수 있다.
- 문자열이 기대되는 곳에서 문자열이 아닌 객체를 사용하면 시스템은 암시적으로 toString을 호출한다.
- 예를들어 alert는 인자로 문자열이 기대되는데, alert([1,2])와 같이 배열을 전달하면 시스템은 [1,2].toString()을 호출한다. 그 결과는 1,2가 된다.
자바스크립트에서는 prototype을 이용해 객체의 메소드를 덮어쓰기(override)할 수 있다.

### 예제
- 컬렉션의 자료 구조의 종류
- var value = flag.toString();
- alert(value); // string, true

### 예제2
- 자바에서는
- Card c=new Card();
- System.out.println(c)와 System.out.println(c.toString())과 같다.


## Comparable
- toString의 123은 오라클에서 문자로 인식, string의 123은 오라클에서 숫자로 인식

## Serializable
 * - 받는 데이터가 
 * 
 * package d.e.f;
 * 
 * public class A {
 * 
 *   public static void main(String[] args) {
 * 
 *     String s = "홍길동";
 *     System.out.println(System.identityHashCode(s));
 *   }
 * }
 * 
 * package a.b.c;
 * 
 * public class A {
 * 
 *   public static void main(String[] args) {
 * 
 *     String s = "홍길동";
 * 
 *     System.out.println("다른 패키지" + System.identityHashCode(s));
 * 
 *   }
 * }
 * 
 * 
 * - 값만 같드면 서로 다른 패키지인데도 같은 주소를 가지고 있음.


### toString 예제
 * package jg.begin.start.jae_0308;
 * 
 * public class A {
 * 
 *   private String name;
 *   private int age;
 * 
 *   public A(String name, int age) {
 *     this.name = name;
 *     this.age = age;
 *   }
 * 
 *   // 주소값을 실제값으로 반환한다.
 *   @Override
 *   public String toString() {
 *     return "ToStringPersonCommand [name=" + name + ", age=" + age + "]";
 *   }
 * 
 * }
 * 
 * 
 * package jg.begin.start.jae_0308;
 * 
 * public class B {
 * 
 *   public static void main(String[] args) {
 *     // 인스턴스를 생성한다.
 *     A command = new A("홍길동", 44);
 *     // 실제값을 호출한다.
 *     System.out.println(command); 
 * -  //메소드로 인스턴스를 참조하는 참조 변수를 출력할 때에 인스턴스의 실제값을 문자열로 변경시키기 위해서 자동으로 호출된다. Command 호출할 때 아니면 출력 안됨
 *   }
 * }


## StringBuffer
- 대용량으로 데이터 받을 때; 동기화가 이루어진다. 일반적으로 사용된다.
- println과 동일
- 외부 데이터(xml) 에서 데이터를 받을 때는 StringBuffer로 받는 게 좋다.
- 대용량 데이터 담을 때는 반드시 StringBuffer로 담아야 한다;(# clob 데이터형); TCP 역할

## StringBuilder
- print와 동일; 빅데이터에서 데이터를 받을 때 문제가 생김
- 데이터를 끊김없이 받을 때 사용된다.
- UDP 역할; 데이터 손실이 있음




## String, StringBuffer, StringBuilder의 장단점 및 차이점
- String과 (StringBuffer, StringBuilder)의 차이점은 String은 immutable(불변)하고 StringBuffer, StringBuilder는 mutable(가변)하다는 점이다.
- 쉽게 말해서 String은 new 연산을 통해 생성되면 그 인스턴스의 메모리 공간은 절대 변하지 않는다.
- 그래서 + 연산이나 concat을 이용해서 문자열에 변화를 줘도 메모리 공간이 변하는 것이 아니라 새로운 String객체를 new로 만들어서 새로운 메모리 공간을 만드는 것이다.
- 이렇게 새로운 문자열이 만들어지면 기존의 문자열은 가비지 콜렉터에 의해 제거되야 하는 단점(언제 제거될지 모름)이 있다.
- 또한 이러한 문자열 연산이 많아질 때 계속해서 객체를 만드는 오버헤드가 발생하므로 성능이 떨어질 수 밖에 없는 단점이 있다. (+연산에 내부적으로 char배열을 사용함)
- 대신 String 클래스의 객체는 불변하기 때문에 단순하게 읽어가는 조회연산에서는 타 클래스보다 빠르게 읽을 수 있는 장점이 있다. (+불변하기 때문에 멀티쓰레드환경에서 동기화를 신경쓸 필요가 없음(장점))
- JDK1.5이상부터 String에서 +연산으로 작성하더라도 StringBuilder로 컴파일하게 만들어 놨다지만 여전히 String클래스의 객체 생성하는 부분을 동일하므로 StringBuffer,StringBuilder 사용이 필요함.
- + StringBuffer, StringBuilder의 경우 buffer size를 초기에 설정해야하는데 이런 생성, 확장 오버로드가 걸려 버퍼사이즈를 잘못 초기화할 경우 성능이 좋지 않을 수 있음.
- + String클래스가 컴파일러분석단계에서 최적화될 가능성이 있기때문에 간혹 성능이 잘나오는 경우도 있음. 문자열 연산이 많지 않은 경우는 그냥 사용해도 무방.
- 런타임에서 문자열조합이 많아질 경우 String은 여전히 성능이 아주 안좋기 때문에! +, concat을 사용하는 사고(?)를 치면 안된다. 특히 현업에서....



## StringBuffer와 StringBuilder의 차이
- 즉 문자열 연산에 있어서 클래스를 한번만 만들고(new), 연산이 필요할 때 크기를 변경시켜서 문자열을 변경한다.
- 그러므로 문자열 연산이 자주 있을 때 사용하면 성능이 좋다!
- 심지어 StringBuffer와 StringBuilder 클래스의 메서드들이 같으므로 호환(?)이 가능하다.
- 차이점은 StringBuffer는 멀티쓰레드환경에서 synchronized키워드가 가능하므로 동기화가 가능하다. 즉, thread-safe하다.
- StringBuilder는 동기화를 지원하지 않기 때문에 멀티쓰레드환경에서는 적합하지 않다.
- 대신 StringBuilder가 동기화를 고려하지 않기 때문에 싱글쓰레드 환경에서 StringBuffer에 비해 연산처리가 빠르다.
- 결론 => String 클래스는 문자열 연산이 적고 조회가 많을 때 멀티쓰레드 환경에서 사용하면 좋음.
- 문자열 연산이 많을 때 멀티쓰레드환경에서는 StringBuffer, 싱글쓰레드또는 쓰레드를 신경쓰지 않아도 되는 환경에서는 StringBuilder를 사용하는 것이 적절하다.


# Object 클래스


## Math
- 사사오입: 자바, python 2.7 이전
- 오사오입: 과학이나 데이터에 사용; python 2.7 이후

## Number 클래스

### Wrapper 클래스
- Object 클래스 밑에 Number 밑에 Byte, Double, Float, Integer, Long, Short

## Class
- Class: 외래어 만드는 것; 외래어 만드는 것: # 로드했다.


## Process

## String 
- 객체지향의 꽃
- 1. 문자 나열 2. 문자 비교 3. 외부로 문자가 적힌 형태 그대로 변동하지 않고 전송하는 기능

### string 자료형
- 자바에서는 문자와 문자열이 다르다. 문자(character)는 글자 하나를 의미하고, 문자열은 글자들의 집합을 의미한다. 그럼 문자열은 메모리를 얼마나 사용할까? 문자열은 문자의 집합이라고 했다. 문자는 char 형이고, char는 2byte의 메모리를 사용한다. 따라서 6글자를 담고 있는 String 타입의 변수는 12바이트의 공간을 차지하게 된다. 


### String과 ==, equals
String str1 = new String("java");   불변성 때문에 고유 주소값(참조 주소값)은 일치하지 않는다. 
String str2 = new String("java");  
String str3 = "java";  문자열은 컴파일하면 자동으로 고유 주소값과 주소값이 일치한다.
String str4 = "java"; 


# 예약어 = 키워드
 * 미리 만들어 놓은 단어; 식별자로 쓸 수 없음.

# 인코딩
 * A라는 문자가 들어오면 같은 형태의 글꼴로 인식할 수 있도록 코드로 변환해 주는 것
 * 가변적, 고정적 모두 존재
 * UTF-8; 가변적 인코딩 방식; UTF-16; 고정적 인코딩 방식

# 식별자
 * 개발자가 사용하는 단어 <>예약어
 *  변수:  일반적으로 변수의 첫 글자는 소문자로 작성한다. 변수가 두 단어가 합쳐질 경우에는 두 번째 단어의 첫 문자를 대문자로 작성한다.

# _ 
 * 원래의 용도에서 확장 되었다.
 * 저장은 되는데 검색이 안되어 _ 를 사용
 * 출력할 때는 안보이고 _ 없이 검색 가능
 * 밑줄 문자인 언더스코어는 컴퓨터에서 공백 문자를 대신하여 사용하기 위하여 고안된 기호로서 _( ) 아스키 코드 번에 해당한다.
 * ( ) 지금도 프로그램 등에서 변수의 이름처럼 공백을 쓰지 못하는 경우에 공백 문자를 대신하여 사용되고 있다.
 * JDK 7부터 제공하는 언더스코어 JDK 7 ( )로 정수 리터럴 값의 자릿수 구분을 위한 구분자로 사용한다. 



# ‘’
 * 자바에서는 char 표시할 때 ‘’만 쓸 수 있다. 이유는 main 매개변수 string을 보면 this.value = "".value; 라고 표기되어있기 때문이다.

# 공백 문자
 * 저장은 되는데 검색이 안되어 _ 를 사용

# 소스코드
 * 자바 코드를 클래스 파일로 보여주는 것


# UML 
 * http://objectaid.com/

# 브라우저
 * 인터넷을 이용해서 사용자에게 보여주는 그래픽 화면

# 주석
 * 프로그램 실행에도 영향을 주지 않지만 로그에도 남지 않는다.
- 주석문의 용도는 소스 코드에 필요한 추가 정보를 추가해서 가독성을 높이기 위한 방법으로 주로 사용된다. 
- 주석문으로 자바 소스 코드 내에 프로그램 수행에 불필요한 코드를 주석 처리 할 수 있으므로 프로그램 수정에도 활용이 된다. 
중간에 과정 찍은 print 문 주석처리
# 로그
 * 주석은 프로그램 실행에도 영향을 주지 않지만 로그에도 남지 않는다.

# static
* _ _ i  // 파이썬
- 따라서 일단 static 객체에서 static 이 아닌 객체를 호출하는것은 불가능합니다. static 이 먼저 정의가 되기때문에 아직 정의되지 않은 객체는 호출할수 없기때문입니다. 순서를 생각해보면 금방 이해될 내용입니다.
- 이렇게 호출된 것들은 다른 녀석들과는 다르게 프로그램이 종료되는 시점까지 계속 유지가 된다는 점이다. 다른 클래스, 메소드, 변수 등의 경우 Java Virtual Machine의 Garbage Collector에 의해 인스턴스화 되어 사용이 되어진다 하더라도, 일정 용도를 끝 마친 후에는 다시 메모리에서 삭제가 되거나, 다른 부분에서 참조가 되지 않는 부분 등이 있는데, static으로 선언된 것은 끝까지 살아남아 계속 참조를 할 수 있는 특징이 있으므로, 프로그램에서 시작과 끝을 함께하는 main 메소드가 일정 시간만 살아있고 폐기되어서는 곤란하므로 계속 살아남아 역할을 하기위해서는 static 명령어가 꼭 필요하다고 할 수 있다.


# 자료형
1. 원시 자료형: 직접 접근
 * 수치 타입
 * 정수타입: byte, short, int, long, char(자판기; 쓰면 아스키코드로 바뀜)
 * 기본형은 int 형
 * 부동 소수점: float, double
 * 기본이 double이라 float형은 f 붙여 주어야 함.
 * 불리언 타입
 * 원시 자료형은 크기가 작고 고정적이기 때문에 메모리의 스택에 저장이 된다.
 * 자바에서는 원시 타입을 제외하고는 다 참조다. 하지만 파이썬, R은 다 참조다.(원시타입이 존재하지 않는다.)
 * 2진수, 8진수, 10진수(올림형), 16진수로 표현 가능하고, 정수형 중 음수는 보수를 사용한다
 * char 자료형은 기본적으로 아스키 코드를 기반으로 한 문자 데이터이므로 int 자료형으로 변환을 하면은 아스키 코드인 숫자를 반환한다. 
 * char 자료형은 한글이나 영문 그리고 특수 문자 등의 모든 글자 형태는 동일하게 한 문자씩만 인식하며 비트 유니코드 문자 데이터로 최대 자를 표현할 수 있다 16 65,536 . 
 * char 자료형은 하나의 문자로 유니코드 값을 표현하므로 두 문자를 할당하면 예외가 발생한다.
 *  char 자료형은 반드시 싱글 쿼터를 사용해서 표현하고 더블 쿼터를 사용하면 예외가 발생한다 ‘( ) “( ) . 유니코드는 각 나라별 언어를 모두 표현하기 위해 나온 코드 체계이며 사용중인 운영체제, 프로그램 언어에 관계없이 문자마다 고유한 코드 값을 제공하는 새로운 개념의 코드이다 , .

 2. 참조 자료형(레퍼런스); 간접 접근; 주소값과 실제값으로 나뉘고 유저가 선택한 값을 ‘리터럴’이라고 함; 힙에 저장(자바의 new)
 * 클래스, 인터페이스, 배열, 열거
 * 클래스형 타입; 클래스도 자료형(타입)이 될 수 있다; string; 
      - 항상 자료형의 공간이 만들어지고 그에 값이 들어가면 가비지컬렉션에 의해 처리된다.
      - 참조 자료형은 메모리상에 인스턴스(객체라고 하면 오브젝트와 헷갈림)가 있는 주소를 저장한다. 
      - 참조 자료형은 가변적이고 동적이기 때문에 동적으로 관리되는 임시 기억장치인 힙 영역에 저장이 되며 주소값을 가진다. 
      - 자바에서는 원시 타입을 제외하고는 다 참조다. 하지만 파이썬은 다 참조다.(원시타입이 존재하지 않는다.)


# 배열
- 원시 타입을 메모리에 테이블처럼 저장하는 것
- 참조타입을 저장할 수 있음.
- 리스트, 튜플(인덱스의 크기를 가지고 접근) | 세트 | 딕셔너리(배열의 리터럴 방식을 확장, 특정 내용만 인덱스로 접근하고 나머지는 인덱스로 접근불가) // 배열의 확장
- 목표: 메모리에 저장하고 유지권을 가지고 데이터를 꺼내오기 위함.
- int [][] num;     int num[][];  모두 가능
- 자료형이 다른 것도 배열에 들어갈 수 있다. 대신에 리스트와 다른건 다른 자료형이 들어가면 뭉쳐서 A라고 부르고 리스트는 각각의 타입을 구분한다. 클래스도 하나의 자료형이다. 하지만 클래스 안에 모든 자료형을 넣기 귀찮으니 나온게 리스트다.
- 배열이 쓰이는 이유: 1. 고정적이여서 하나의 요소도 빠지면 안되는 프로그램을 짤 때; ex)  RGB  2. 일정한 값을 가져야 하는 수치적 계산 
- 출력: System.out.println(num); // 주소값 나온다
배열의 빈 값은 0으로 출력된다..
- int[] num = { 1, 2, 3, 4 }; // 중괄호로 배열 사용 가능; 배열의 리터럴; 선언과 초기화 동시
- int[ ] number 스택 ;  
- number = new int 힙  // number는 참조 변수
- 3차원 배열 [면; 엑셀의 시트] [행] [열]
- 동적 배열: 행은 무조건 있어야 함, 열은 생략 가능


## 초기화
- 초기화: 영역의 밖이라는 것을 강조하기 위해


## 배열 기호
- 2차원: [ [],1]; 1차원 안에 1차원

## 동적 배열 -1
    - int num[][] = new int[3][2];
    - num[0] = new int[2];  // 행 개수 만큼 선언해 주어야 함; 열은 관련 없음
    - num[1] = new int[2];  // 행 개수 만큼 선언해 주어야 함; 열은 관련 없음
    - num[2] = new int[2];  // 행 개수 만큼 선언해 주어야 함; 열은 관련 없음



## 동적 배열 -2
-     int[][] num = { { 1, 2 }, { 4, 5 }, { 1, 2, 3, 4, 5, 6, 7, 8 } };

### 배열의 for문
- 배열 문;  초기식 인덱스 조건식증감식 ( ; ; ); length 사용

### 향상된 for문 
- for (선언한 배열의 자료형 변수명 배열명 : )
- for (String string : name) { ~ } ⎼
- 향상된 for 문으로 배열명으로 배열을 반복하여 나열한다. 
- 향상된 for 문은 배열의 인덱스를 사용하지 않고 배열명만을 사용하기 때문에 배열의 인덱스를 잘못 사용해서 발생할 수 있는 예외에 대한 위험을 제거 할 수 있다.

#### 향상된 for문 예제 -1
-     for (int[] is : num) {
-       for (int is2 : is) {  // 위의 배열이 아래 값으로 들어옴
-         System.out.println(is2);
-       }
-     }



## 2차원 배열
- for (int j = 0; j < num[i].length; j++); // 열의 길이 구하는 법


### 2차원 배열 구구단 예제
 * public class GugudanArray {
 * public static void main(String[] args) {
 *  //2차원 구구단 배열 선언
 *  int[][] gugudan = new int[10][9];
 *   //첫번째 행의 배열에 단을 입력할 수 넣기
 *  for (int k = 0; k < 9; k++) {
 *   gugudan[0][k] = k + 1;
 *  }
 *   //2번쨰 행부터 구구단 결과값 넣기
 *  for (int i = 1; i < 10; i++) {
 *   for (int j = 0; j < 9; j++) {
 *    gugudan[i][j] = i * (j + 1);
 *   }
 *  }
 *   //구구단 출력
 *  for (int n = 0; n < 10; n++) {
 *   for (int m = 0; m < 9; m++) {
 *    if (gugudan[n][m] > 9) {
 *     //두자리 수는 공백수 하나 적음
 *     System.out.print("  " + gugudan[n][m] + "  ");
 *    } else {
 *    
 *     System.out.print("  " + gugudan[n][m] + "   ");
 *    }
 *   }
 *   if (n == 0) {
 *    //첫번째 단의 수 표시하기 위해서
 *    System.out.println();
 *    System.out.println("--------------------------------------------------");
 *   } else {
 *    //구구단 결과값 표시 9단까지 표시후 줄바꿈
 *    System.out.println();
 *   }
 *  }
 * }
 * }



### 배열 생성의 형태
- ① byte 자료형 : 0 
② short 자료형 : 0 
③ int 자료형 : 0 
④ long 자료형 : 0L 
⑤ float 자료형 : 0.0f 
⑥ double 자료형 : 0.0 
⑦ char 자료형 : '\u0000'  // 키보드의 null을 의미한다.



# 리스트
 - 자료형이 다른 것도 배열에 들어갈 수 있다. 대신에 리스트와 다른건 다른 자료형이 들어가면 뭉쳐서 A라고 부르고 리스트는 각각의 타입을 구분한다. 클래스도 하나의 자료형이다. 하지만 클래스 안에 모든 자료형을 넣기 귀찮으니 나온게 리스트다.

## ArrayList
- 출력하면 비어있는 값은 출력 안하고 출력되지도 않는다. -> 가변적이다.
- B b = new B(); 같이 클래스를 추가하면 주소값으로 들어가고 나중에 실제값으로 바꾸면 값을 표현할 수 있다.


# 컬렉션
- 참조타입을 메모리에 테이블처럼 저장하는 것
- 원시타입을 저장할 수 있음.

# 자료형 변환
 * System.out.println("한글" + (int) eword); // 아스키 코드값

# 리터럴
 * 참조 자료형(레퍼런스); 간접 접근; 주소값과 실제값으로 나뉘고 유저가 선택한 값을 ‘리터럴’이라고 함; 힙에 저장(자바의 new)
 * 실제값
* 원시 자료형의 변수는 실제 데이터를 리터럴로 저장한다. 참조 자료형의 변수는 실제 데이터가 저장된 주소로 저장한다. 참조 자료형의 자료값을 주소값이라고 한다.
- int[] num = { 1, 2, 3, 4 }; // 중괄호로 배열 사용 가능; 배열의 리터럴; 선언과 초기화 동시


# 진수
 * 16진수: 2진수로 표현하는 것을 가변적으로 변화; 공간 활용 위해 사용.
 * 8진수: 주로 이미지 표현을 위해 사용함.

# 객체지향
 * 클래스 기반: 힙 만들 때 ‘new’ 사용
 * 자바는 프로토타입 패턴에 의거하여 클래스, 배열, 열거(enum), interface 사용
 * 프로토타입 기반: 힙 만들 때 복제



# 아스키 코드
 * 10번 \n  과 13번 \r이 합쳐지면 엔터
 * 48번 0;  65번 대문자 A
 *   ​char a = (char) System.in.read();
   *  이 함수가 입력되는 것은 0-255까지의 아스키코드 값이므로 char형으로 받고 싶다면 형변환을 하여서 받아야한다.​모든 아스키코드는 char에 담을 수도 있고 데이터의 손실또한 없다는 겁니다.
- int i = System.in.read() - 48; // 사용자가 입력한 숫자로 변환하기 위해 48(0)을 뺌
-   public static void result(int a, char b, int c, int d) {
    - System.out.println("연산 결과");
    - System.out.println(a + b); // 아스키 코드가 더한 값이 나옴




# wrapper
- 참조 자료형은 메모리상에 인스턴스가 있는 주소를 저장하며 주소를 레퍼런스라고도 한다. 참조 자료형의 데이터 크기는 가변적이고 동적이기 때문에 동적으로 관리되는 임시 기억장치인 힙 영역에 저장이 되며 주소값을 가진다. 
- 참조 자료형은 인스턴스에 대한 레퍼런스를 가지고 있으며 매개변수인 값을 전달한다. new 키워드를 이용하여 인스턴스를 생성하여 데이터가 생성된 주소를 참조하는 자료형이다. 참조 자료형에서 더 이상 참조하는 변수가 없을 때는 가비지 컬렉션에 의해 삭제된다. 개의 원시 자료형을 제외한 자료형은 참조 자료형으로 종류는 다음과 같다
- 1. 클래스 자료형 2. 인터페이스 자료형 3. 배열 자료형 4. 열거 자료형

# ()
- 동작한다; 
- 클래스(); // 클래스를 동작한다.

# byte
 * ⎼byte 자료형을 int 형인 i 변수로 강제 자료형 변환을 하고 b 변수에 할당한다. 
 * ⎼int 형의 255, 256, 257은 byte 형의 -1, 0, 1로 변환된다.

# 수행 > 실행
 * 런타임을 ‘수행’했다고 한다. 수행이 더 큰 개념.
 * 실행: 결과를 보여줌

# 자료형 크기
 * byte: 1바이트; 8번째 자리 버리고 -125 - 124
 * short: 16비트; 2의 15승까지 계산 가능
 * int: 2의 31승까지 계산 가능.

#  자료형 변환
 *  크기가 작은 자료형에서 큰 자료형으로 자동으로 변환한다.
 * 묵시적 자료형 변환을 자동 자료형 변환이라고도 한다. 
 * 수치 자료형은 상호간에 묵시적 자료형 변환이 가능하다. 
 * 큰 자료형에서 작은 자료형으로 묵시적 자료형 변환을 하면은 예외가 발생한다.

# 명시적
 * 강제 <> 묵시적
 * ⎼byte 자료형을 int 형인 i 변수로 강제 자료형 변환을 하고 b 변수에 할당한다. 
 * ⎼int 형의 255, 256, 257은 byte 형의 -1, 0, 1로 변환된다.
 1.
 *     int i = 48;  // int를 char로 명시적 변환
 * 
 *     char a;
 *     a = (char) i;
 2.
 *     System.out.println(a);  // 아스키 코드 값 ‘0’으로 출력
 *     byte i;  // byte를 int로 명시적 변환
 * 
 *     int a = 255;
 *     i = (byte) a;
 * 
 *     System.out.println(i); // -1 결과값 출력; 바이트수에 보수 탑재
 3. choice = (char) System.in.read( );  // read할 때 char 좋으니 강제

# []
 * 리스트; 배열

# ()
 * 튜플

# {}
- 세트
- {} 안에 들어와야 상속되어 System클래스나 기타 작업을 할 수 있다.

# {키와 값]
 * 딕셔너리

# 변수
 * 변수명 만들어주는 사이트: https://curioustore.com/#!/ 
 * 공간의 위치; 이 위치를 알기 위해 이름을 부여(변수명)
 * 공간의 위치에 따른 변수의 역할
 * 멤버변수(C 언어의 전역변수); 클래스 안의 변수
 * 멤버 변수는 0으로 자동으로 초기화됨; 생성자에 의해 이루어 짐
 * 인스턴스 변수: private int age1 = 9; // 메소드로만 호출 가능(get, set)
 * 프로퍼티; this; 맴버변수 = 매개변수
 *           -     공유 변수 = C 언어의 전역 변수:  static int age2 = 29;
 *         - System.out.println(A.age2);
 *         - main 함수에 직접 접근하려면 static으로 접근하여 
 *   같은 영역을 만들어주어야 한다.
 *                     -     일반 멤버 변수
 * 로컬변수(지역변수); 메소드 안의 변수
 * 초기화 선언이 따로 필요!
 * 블록 안에 있는 것이 보유(유지) 되지 않고 소멸된다.
 * 매개 변수(parameter)
 * 다 소문자; 두개의 명사 붙일 때 _ 사용

## static 변수
- 

## 멤버 변수
- 데이터 저장 기능; 외부에서 데이터 값 접근 

## 인스턴스 변수
- A a \ new A()
- a.name = "홍길동";

# 프로퍼티
- 메소드를 통해 관리되는 데이터를 프로퍼티(property) 라고 부르며 get, set 을 뗀 나머지 부분에서 첫문자를 소문자로 바꾼 이름을 프로퍼티 이름으로 취급한다.
- Bean을 주입 받을 경우에는 ref속성을 쓰고, 기본 데이터 타입 및 STring 클래스 타입의 경우는 value 속성을 사용한다.

# 매개변수
# 파라미터
- 파라미터는 자바 환경이 아닌 곳에서 받은 데이터

# 전달인자
 * sum(10,20);
 * 위의 sum함수를 호출하였을때 (10,20)이 변수를 전달인자라고 부릅니다. 이때 전달인자에는 값이 존재하는것을 볼 수 있습니다.


## 변수 선언 주의사항
- int i = 10; // 바로 선언하는 건 이 숫자만 사용하겠다는 암묵적 의미
- int i;  먼저 선언하고 나중에 값을 지정하는 것을 권장
  - int i, y; // 변수를 동시에 선언하는 것도 비권장


### 변수 종류 예
- 필드 : 클래스 안에서 선언되는 멤버 변수, 인스턴스 변수라고도 함.
- 지역 변수(local variable) : 메소드나 블록 안에서 선언되는 변수
- 매개변수(parameter) : 메소드 선언에서의 변수

 * class
 * {
 *   public int speed ->필드
 *   ...
 *   void start(int s) ->매개변수
 *   {
 *     int t; ->지역 변수
 *     ...
 *   }
 * }



# null
 * 모든 참조 타입의 기본값;

# http
 * hyper: 뛰어넘다; text: 무작위로 선택할 수 있는 것; 목차에 관계없이 접근


# ; 
 * 영역의 종료

# :
 * 영역의 변경
 * System.out.println("클래스 클래스다.");

# 로컬변수
 * 가. 로컬변수의 개요 로컬변수는 메소드 안에서만 선언한 변수이다. (메소드 만이 아니라 {}(코드 블록) 내에 선언된 변수 
 * 로컬변수는 멤버변수와 같이 선언과 동시에 초기화가 이루어지지 않으므로 자료형의 초기값을 할당해야 한다. 
 * 실행 영역인 코드 블록 내에서 선언된 로컬 변수는 코드 블록의 범위를 벗어나면 자동으로 { }( ) 삭제된다. 

# {} -  
 * 코드 블록 {} 
 * 네임 스페이스; public class A

# scanner
 * import java.util.Scanner;
 * Scanner sc = new Scanner(System.in);
 * 이렇게 객체생성을 하며 System.in은 입력한 값을 바이트 단위로 읽는 것을 뜻합니다.
 * next()라는 메소드가 있는데 이 next() 메소드는 공백 이전까지의 문자열을 입력 받습니다.
 * sc 보다는 scanner; 클래스를 알아보기 위해
 * nextLine() // 라인을 추가한다.(두줄이 띄어져서 잘 안씀 -> next())
 * name = scanner.next(); // 사용자 편의성 위해 변수에 직접 넣어준다.
- - c = input.next().charAt(0); // char 값 가져오기
- 스택에 저장하는 이유: 나중에 값을 int 형 등으로 형 변환 위해
- 엔터(\n  \r)  탑재 되어있음.
  * System.in.skip(2); 를 하면 System.in.read()를 2번 넘어간 것과 같은현상


## scanner 클래스
- Scanner 클래스는 정규 표현을 사용해 구문 분석이 가능한 단순한 텍스트 스캐너이다.
- Scanner 클래스는 텍스트 스캔 기능으로 지원되는 모든 형태의 텍스트를 스캔한다고 생각하면 된다.
- Scanner 클래스는 예외처리를 가지고 있으므로 별도로 예외처리를 해 주지 않아도 된다.

### buffered와 차이
=- Scanner는 커서 문제, 예외처리 문제 있음.


### nextInt 단점
- 우리에게 이러한 문제점이 생긴 이유는, nextInt 메소드가 라인을 소모하지 않기 때문이었습니다.  그렇다면 입력 이후에 추가로 라인을 소모해주면 되지 않을까요.

### 권장, 변환하기
 *  Scanner scanner = new Scanner(System.in);
 * 
 *       ArrayList<String> list = new ArrayList<>();
 * 
 *       int k = Integer.parseInt(scanner.nextLine());
 * 
 *       for(int i = 0; i < k; i++) {
 * 
 *         list.add(scanner.nextLine());
 * 
 *       }
 * 
 *  scanner.close();


### 추가로 라인 변경
 * Scanner scanner = new Scanner(System.in);
 * 
 *       ArrayList<String> list = new ArrayList<>();
 * 
 *       int k = scanner.nextInt();
 * 
 *       scanner.nextLine();  // 추가로 라인 변경해주는 것; 
 * 
 *       for(int i = 0; i < k; i++) {
 * 
 *         list.add(scanner.nextLine());
 * 
 *       }
 * 
 *       scanner.close();


## CharAt
- c = input.next().charAt(0); // 0인덱스의 값 가져옴


# static
 * 공유: 키워드에 의해서 멤버변수는 전역적인 범위가 될 수가 있다

# 캡슐화 
 * private 키워드에 의해서 멤버변수는 캡슐화가 되어 메소드에 의해서만 접근이 가능하다

# 상수 
 * final 키워드에 의해서 멤버변수나 로컬변수는 상수가 된다.

# private
 * private 키워드에 의해서 멤버변수는 캡슐화가 되어 메소드에 의해서만 접근이 가능하다
 * get/set 으로 호출

# get/set
 * private 키워드에 의해서 멤버변수는 캡슐화가 되어 메소드에 의해서만 접근이 가능하다

# final
 * ① 클래스의 상수 선언 클래스에서 상수의 선언는 final 키워드로 선언한다. 상수는 선언할 때 단 한번 초기화를 하며 상수 앞에 static 키워드를 붙여서 final 키워드로 선언하면 전역적인 상수가 된다. 클래스의 상수는 일반적으로 static final로 선언해서 전역적인 상수 변수를 만들어서 사용하는 경우가 많다.
 * ② 인터페이스의 상수 선언 인터페이스에서 멤버변수를 선언하면 자동으로 상수가 되며 그 이유는 인터페이스에서는 생성자가 없기 때문이다.
 * 클래스에 final 붙이면 상속 불가
- 사용하면 상속 불가하고 set 메소드도 사용할 수 없다.
- 초기화가 필요함; final int age = 0

## final class
* 다른 클래스에서 상속하지 못한다.

## final method
* 다른 메소드에서 오버라이딩하지 못한다.

## final variable
* 변하지 않는 상수값이 되어 새로 할당할 수 없는 변수가 된다.


## finally
* try-catch or try-catch-resource 구문을 사용할 때, 정상적으로 작업을 한 경우와 에러가 발생했을 경우를 포함하여 마무리 해줘야하는 작업이 존재하는 경우에 해당하는 코드를 작성해주는 코드 블록이다.

## finalize()
* keyword도 아니고 code block도 아닌 메소드이다. GC에 의해 호출되는 함수로 절대 호출해서는 안 되는 함수이다. Object 클래스에 정의되어 있으며 GC가 발생하는 시점이 불분명하기 때문에 해당 메소드가 실행된다는 보장이 없다. 또한 finalize() 메소드가 오버라이딩 되어 있으면 GC가 이루어질 때 바로 Garbage Collecting 되지 않는다. GC가 지연되면서 OOME(Out of Memory Exception)이 발생할 수 있다.


# 생성자
② 인터페이스의 상수 선언 인터페이스에서 멤버변수를 선언하면 자동으로 상수가 되며 그 이유는 인터페이스에서는 생성자가 없기 때문이다.
멤버 변수는 0으로 자동으로 초기화됨; 생성자에 의해 이루어 짐


# # read()
 * choice = (char) System.in.read( );  // read할 때 char 좋으니 강제
 *   ​char a = (char) System.in.read();
 *  이 함수가 입력되는 것은 0-255까지의 아스키코드 값이므로 char형으로 받고 싶다면 형변환을 하여서 받아야한다.​모든 아스키코드는 char에 담을 수도 있고 데이터의 손실또한 없다는 겁니다.
 

 *  문
 * 비순차적 문장
 * 머신러닝 같이 데이터 검출을 목표로 할 때는 if 문을 쓰는 것이 맞다. 순차적으로 모두 확인해야 한다.
 * :(영역 변경) 뒤에 {} 생략 가능; 파이썬 방식

# MVC
 * M(Model): 멤버 변수가 모여 있음
 * V(View)
 * C(Control): 유일하게 변경할 수 있음; ex) API

# 연산자
- 단항: a++
- 이항: 5 + 5
- 삼항
- 조건(수식)? A:B  // 와일드 카드
- ?: 플레이스 홀더

##  연산자의 결합 방향
- 오른쪽에서 왼쪽으로 결합 이라는 수식은 오른쪽에서 왼쪽으로 결합하여 연산을 한다 a = b = c . 

# 배열과 리스트 차이
- 배열은 한개의 타입(자료형)만 넣을 수 있음.
- 리스트는 여러 개의 타입(자료형)을 넣을 수 있음.


# instance of
- System.out.println(string instanceof String);
- 외부에서 실제값을 확인하는 것; 객체를 비교하는 것이 아니다.
- 기본값인 ‘null’은  
 * String string = null;  
 * System.out.println(string instanceof String)  // 하면 false
⎼ String 클래스형의 string 로컬변수에 기본값인 null을 할당하고 instanceof 연산자로 비교하면은 할당된 null은 String 클래스형인지를 확인할 수가 없으므로 false를 반환한다. 
- ⎼instanceof 연산자는 참조 자료형에 할당된 자료값에 대한 정확한 자료형을 검증한다.


## 자료형 확인
- System.out.println(string instanceof String);

# ==(더블 이퀄)
- 일반적으로 수를 비교
- 문자열을 비교할 때는 equals 라는 메소드로 비교한다.

# 비교
- ‘==’는 일반적으로 수를 비교
- 문자열을 비교할 때는 equals 라는 메소드로 비교한다.

# 논리 연산자
- 자바에서는 속도 때문에 &&   ||  등 2개 짜리를 권장한다.
- &&는 앞이 거짓이면 뒤 검증 안함, || 도 앞이 참이면 뒤 검증 안함.


## &
- 파이썬에서는  and, or, not 을 논리 연산자로 쓰고  &는 보통 비트 연산자로 사용한다.


## |
 - 버티컬바 |( ) 연산자



# 복합 대입 연산자
- 복합 대입 연산자는 다른 연산자보다 우선순위가 낮아 생각지 못한 결과가 발생할 수 있으므로 유의해야한다. 자주 사용하지 않는다.

# 증감 연산자
- a++ 보다는 a = a+1 을 사용하기를 권장한다.

## ~     - Tilde; 틸드
- ~숫자;  // +1 한 값 앞에 마이너스 기호 붙이기
- 컴퓨터에는 마이너스 개념이 없어서 2의 보수를 통해 표현

## ^
 - 서컴플렉스;  Circumflex 




# 비트 연산자
- 컴퓨터 입장에서 인식이 빨라 정확도와 속도 모두 빠르다. 
- &,  |,  ^,  ~
- 시프트 연산자; <<, >>; C++ 에서 자주 사용
- 더블 레프트 앵글브래킷❷ 연산자로 만큼 이동한 비트의 연산을 하고 이동하여 비어있는 2 8 공간은 0으로 채운다
- 더블 라이트 앵글브래킷 연산자는 4>>2 4/2/2 4 2 누어 주면 되는 것 같이 이동한 숫자만큼 로 나누어준다 2 .
- 컴퓨터에는 마이너스 개념이 없어서 2의 보수를 통해 표현

# 보수
- 각 자리의 숫자의 합이 어느 일정한 수가 되게 하는 수이다.
- 2진수에는 1의 보수와 2의 보수가 있으며 의 보수와 의 보수를 구하면 다음과 같다. 결과를 비교해 보면은 2의 보수는 1의 보수에 1을 더한 것과 같으므로 1의 보수에서 1을 더해주면 의 보수를 구할 수 있다 
- 9의 보수와 10의 보수의 차이는 끝자리에 1을 더했느냐의 차이이다.
- 2의 보수는 그래서 1을 더하고 -을 붙여준다.
- 1의 보수: 모두 1로 맞추는 작업 -> 2의 보수: 1을 더해서 자리 올림을 만들어 그 1을 부호로 만든다. 

# 조건 연산자
int c = (a > b) ? a : b;  이렇게 값을 변수로 지정한다.


# 연결 연산자
- 연결 연산자를 사용할 때 앞에 문자열이 있으면 뒤에 정수도 안더해진다. ( +를 연결 연산자로 인식)
- System.out.println(“ “ + 정수 + 정수)


# +
- 연결 연산자를 사용할 때 앞에 문자열이 있으면 뒤에 정수도 안더해진다. ( +를 연결 연산자로 인식)
- System.out.println(“ “ + 정수 + 정수)


# StringBuffer 클래스
- StringBuffer bu  = new StringBuffer();
      - System.out.println(bu.append(s).append(t));

# 문자열
# StringBuffer 클래스
- StringBuffer bu  = new StringBuffer();
      - System.out.println(bu.append(s).append(t));

      2. - 연결 연산자를 사용할 때 앞에 문자열이 있으면 뒤에 정수도 안더해진다. ( +를 연결 연산자로 인식)
- System.out.println(“ “ + 정수 + 정수)
- 잘 쓰지 않고 StringBuffer를 사용한다.

# “”
- String number = ""; 
- ⎼String 클래스형인 numbe 변수에 아무 값도 할당받지 않은 상태인 빈 문자열 ""를 할당하여 문자열을 저장할 임시 공간을 설정한다. 
- String number = " "; // 공백문자라고 함. 


# 배열
- for 문과 주로 같이 쓰임
- 자바의 배열은 C언어의 포인터 배열
 - 1차원 배열: 일반 for문, 2차원 배열: 중첩 for문 
- 차원이 증가하는 건 1차원이 포함되었다고 표현; 사실상 2차원의 개념은 없다.

# for문
- 일반 for문, 배열 for문, 컬렉션 for 문, 향상된 for문
- 길이를 알고 있을 때; 배열, 리스트
- 메모리에 임시저장 시킬 때 for문
- 목적 달성 전치사
      - 1차원 배열: 일반 for문, 2차원 배열: 중첩 for문 
     - 다중 for문: 중첩 for문을 2개 이상 쓴 것.

## foreach
- for (int i: num)  // num은 배열
System.out.println(i);  // 배열 안의 하나씩 출력됨


## for문 실행 순서
 * for( 식1 ; 조건1 ; 식2)
 * {
 *    코드 1
 * }
 * 정답
 * 식1 수행 --> 조건1 검사 --> 코드1 수행 --> 식2 수행 --> 조건1 검사 --> 코드1 수행 --> 식2 수행 --> 조건1 검사 ...
 * 오답
 * 식1 수행 --> 조건1 검사 --> 코드1 수행 --> 조건1 검사 --> 식2 수행 --> 코드1 수행 --> 조건1 검사 --> 식2 수행 ...

# while 문
- 일반 while문, do-while 문
- 규격에 맞게 학습
- 무한 반복 때 사용.

# break
- 실행이 아니라 수행을 종료
- 블록을 벗어날 수 있다.
- break
  - ForLabel: for (int i = 2; i <= 9; i++) { ~ }
  - break ForLabel;

# return
- 값의 변경이 불가하기 떄문에 중괄호가 없는(return 값 받을 수 없는) 값 생성 의미없음


# if
 * 조건이 거짓이면 실행이 안되는 것이 아니라 default 값 실행.
 * else; 는 뒤에 {} 가 있어도 같이 사용되지 않음.
 * 정렬을 위해 if문이 존재

# 다중 if 문
 * else 에서 범위를 확장 시킬 때 다중 if 구문이라고 한다. <> 중첩 if문
 * else의 조건을 확장시킬 때 사용, 용도에 맞게 사용해야 함.

# 중첩 if문
 * 밖의 조건을 먼저 만족하고 안에 있는 문을 확인한다.
 * else 가 아닌 if 조건 안에 쓰는 것이다. <> 다중 if 문



# do-while
- do {  } while (condition);  // while 뒤에 종료 ; 표시


## {}
- 코드블럭 없이 한 줄 아래는 문 안에 속하지만 자바에서는 한줄만 있을 때 블럭을 치지 않는다.


# 입력
 * scanner
   * 강제로 형변환(parseInt)가 엇음.
   * Scanner scanner = new Scanner(System.in);
 * System.in.readin(); int a =  System.in.read() - 48
   * - 한글자만 넣을 수 있음.
   * - char형일 때는  c >= 'A' & c <= 'Z'
 * Stream
   * InputStreamReader inputStreamReader = new InputStreamReader(System.in);

## scanner
- scanner.close(); // 자원 해제


## 입력 차이
Space Enter를 모두 경계로 인식하기에 입력받은 데이터를 가공하기 매우 편리합니다. 하지만 그에비해 BufferedReader는 Enter만 경계로 인식하고 받은 데이터가 String으로 고정되기때문에 입력받은 데이터를 가공하는 작업이 필요할경우가 많습니다. Scanner에 비해 다소 사용하기 불편하죠. 하지만 많은 양의 데이터를 입력받을경우 BufferedReader를 통해 입력받는 것이 효율면에서 훨씬 낫습니다. 입력시 Buffer 메모리줌으로써 작업속도 차이가 많이납니다.

# Stream
 * - read() 대신에 버퍼에 저장할 수 있게 해주는 -> 
 * InputStreamReader name = new InputStreamReader(System.in)
 * 키보드에 연속적으로 입력받아 버퍼에 저장하고, 
 * BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
 *  데이터를 버퍼에서 읽어 오겠다
 * Integer은 문자열을 숫자로 변경할 수 있다.
 * su1 = Integer.parseInt(bufferedReader.readLine());.
 * 문자열을 받아들일 때; string = bufferedReader.readLine();
 * 문자열 비교할 때; string.equals("DF")

# equals
* 공백을 처리하기 때문에 ==과 차이점
 * string.equals("DF")
 * string.equalsIgnoreCase("GK") // 대소문자 구분 없이
- String형은 Serialzable 인퍼페이스를 상속해서 주소값이 같다.
- 무조건 참조 자료형이라고 해서 equals를 사용할 필요는 없다.
- equals 메소드는 인스턴스의 값에 대한 동등 비교할 때 사용한다. equals 메소드는 두 개의 인스턴스를 비교해서 값이 같으면 true로 다르면 false를 리턴한다. 원시 자료형은 ==( ) 더블 이퀄 연산자로 동등 비교를 하지만 참조 자료형은 equals 메소드를 사용한다.


## equals 와 ==의 차이
 * equals () 는 메소드 입니다. 객체끼리 내용을 비교할 수 있도록 합니다. == 은 비교를 위한 연산자 입니다.
 * equals 메소드는 비교하고자 하는 대상의 내용 자체를 비교하지만, == 연산자는 비교하고자 하는 대상의 주소값을 비교합니다.
- 주소값만 비교(@)
- == 연산자의 경우 메모리에 저장되에 있는 값의 비교로 equals 메소드는 메모리에서 참조하고 있는 주소값의 비교로 보셔도 되겠네요...
- 외부에서 받아오는 값은 equals 사용한다.


# 가비지 컬렉터
 * 가비지 컬렉터 제공 언어: managed language; 
 * JVM은 메모리를 부여받고 열심히 프로그램들을 실행하다가 메모리가 부족해지는 순간이 오면 OS에게 추가로 메모리를 더 요청하게 된다. 바로 이 메모리를 더 달라고 요청하는 때에 가비지 컬렉터(Garbage Collector)가 실행된다.
 * 또, 서버 프로그램인 경우에는 24시간 내내 돌아가는데, 이 때에는 JVM이 한가할 때(idle time) 가비지 컬렉터가 실행된다.
 * (JVM이 종료되면, 당연히 사용하던 모든 메모리는 OS에게 반납된다.)

## Mark and sweep

## 

## 자원 해제
※ 자원 해제 
- ◽자원 해제는 메모리 해제 또는 메모리 삭제로 이해하면 된다. 
- ◽새로운 객체가 필요할 때 자바는 요구된 크기의 메모리를 할당하고 객체가 사용 완료되면 가비지 컬렉션을 통해 자동으로 회수한다. 
- ◽자바의 가비지 컬렉션은 자원을 관리하기 위해서가 아니라 메모리를 관리하기 위한 의도로   개발되었다. 
- ◽ 의 사전적 의미는 쓰레기 등과 같이 여러가지가 있으며 여기에서는 쓰레기라는 garbage 의미가 된다. 
- ◽가비지 컬렉션은 객체를 참조하는 참조가 증가하면 객체에 몇 개나 참조하는지 카운트를 하고 카운트가 0이 되는 것들을 모아서 주기적으로 쓰레기인 가비지를 처리하게 된다. 
- ◽프로그램이 메모리 등을 할당한 후에 해당 메모리가 필요하지 않음에도 해제되지 않을 경우에는 자원이 세는 메모리 누수의 문제가 발생할 수 있다. 
- ◽메모리 누수는 더 이상 필요하지 않은 메모리가 해제되지 않고 남아있는 버그를 가리킨다. 
- ◽메모리 누수 현상이 있으면 창을 열고 닫을 때마다 그리고 문서를 열고 닫을 때마다 지속적으로 메모리가 증가되어 성능 저하뿐만 아니라 결국에는 메모리 오류 발생으로 프로그램이 종료되는 심각한 현상이 발생한다. 
- ◽자바에서는 가비지 컬렉션에 의해 메모리가 자동으로 관리되어 메모리 누수를 방지하지만 가비지 컬렉션에서 관리하지 못하는 객체에 대해서는 메모리 누수가 발생할 수 있다. 
- ◽실제로 사용되지 않는 객체의 참조를 프로그램에서 잡고 있으면 그 객체는 가비지 컬렉션에 의해 처리되지 않고 프로그램 내에서도 접근하여 사용될 수 없는 사실상 쓰레기로서 메모리를 점유하게 된다. 
- ◽자바의 가비지 컬렉션에서 관리하지 못하는 객체의 메모리 누수 현상을 방지하기 위해서 close 메소드를 호출하여 메모리 누수를 방지한다.


## 객체
* 기본 자료형을 제외한 모든 요소들이 객체로 
 * 인스턴스: Scanner scanner =  // 앞부분은 객체를 생성한 것이 아니라 참조형 변수를 지정해 준 것; 즉 인스턴스화를 의미한다; 객체 생성은 뒷부분만을 의미하는 것임.
 * 확장성을 주기 위한 것
 * 객체생성: new Scanner(System.in) // new 를 통해 객체를 생성했다.

## 정렬
 * 정렬을 위해 if문이 존재

## while
 * 무한정 루프를 돌릴때 사용; 무한 루프의 가능성이 있어 잘 사용하지 않음.

# Integer
 * 문자열로 들어오는 것을 강제로 숫자로 변경할 수 있다.
 *  su1 = Integer.parseInt(bufferedReader.readLine( )); ⎼Integer 클래스의 parseInt 메소드의 인자인 bufferedReader 인스턴스의 readLine 메소드로 자료를 문자열로 읽어오고 정수로 강제로 변환한다. 
 * su1 = Integer.parseInt(bufferedReader.readLine( )) // buffer에서 받은 문자열을 숫자로
 * su1 = Integer.parseInt(scanner.next()); // scanner에서 받은 문자열을 숫자로


## toString과의 차이점
- toString 메소드는 주소값을 문자열로 변환시켜주는 기능 = 주소값을 실제값으로 변환. 대화체로 변경시켜줌
  - <> Integer.toString(); 값 자체가 실제로 바뀜


# try-catch
 * 자원해제 방지

## “”
- 자바 String 나타낼 때 사용

## ‘’
- 파이썬 자연어 검색때 사용

# switch
 * 조건식에 따라 case 옆 자료형이 달라짐.
 * byte, short, char, int, string, enum 만 조건식에 들어갈 수 있음.
 * byte, short, char, int를 이용하여 접근할 때 다중 if 문보다 향상되어 있다.
 * JDK 1.7버전부터 지원하는 String 클래스 자료형이다. 
 * switch 문은 순서에 관계없이 선택할 수 있으며 위치 이동을 제어한다. 
 * switch 문은 case 문의 값은 각각 달라야 하고 값의 크기와 순서는 무관하다.
 * 다른말로 인덱스로 접근하지 않는다.

# 초기화
 * 원상태의 공간으로
- 초기화가 되면 접근과 수정이 가능하다.

## 생성자와 setter
 * 생성자와 setter는 값을 설정한다는 점에서 같은 역할을 담당할 수 있습니다.
 * 다만, 생성자는 "인스턴스 생성 시"라는 시점에 초점이 더 맞춰져 있다고 볼 수 있고, 세터는 시점과 상관 없이 값을 set하는 메소드라고 볼 수 있습니다.
 * 그렇기 때문에 생성자의 파라미터로 초기값을 설정하고 후에 세터를 통해서 값을 변경하는 경우도 있을 수 있겠죠:)




# 인덱스
 * switch 문은 case 문의 값은 각각 달라야 하고 값의 크기와 순서는 무관하다.
 * 다른말로 인덱스로 접근하지 않는다.

# 가변
 * 값의 크기가 무관하다 = 가변적이다.
 * switch 문은 case 문의 값은 각각 달라야 하고 값의 크기와 순서는 무관하다.
 * 다른말로 인덱스로 접근하지 않는다.

# 순서
 * 순서와 무관하다는 말은 인덱스로 접근하지 않는다는 의미
 * switch 문은 case 문의 값은 각각 달라야 하고 값의 크기와 순서는 무관하다.
 * 다른말로 인덱스로 접근하지 않는다.


## =
 * <=, 사용하지 않는다.


## 이스케이프 문자
 * \t: 8칸; 수평 맞추기; 구구단 줄 맞추기


# 증감 연산자
 * 후위 연산자
   * num3 = num1;
   * num1 = num1 + 1;
 * 전위 연산자
   * num1 = num1 + 1;
   * num3 = num1;
   * -  System.out.println(i++) 의 출력값은 i가 1만큼 증가되어 1 이 출력되어야 할 것 같지만 0 이 출력되었다. 그렇다면 변수 i의 값이 증가되지 않은것일까? 그 다음 문장인 System.out.println(i) 의 출력값을 확인 해 보니 1이 나온다. 그렇다면 i의 값이 증가는 된 것이다.


# 스태틱 메소드
 * - Math.random() // 0.0 - 0.9까지 난수 발생
 * 1부터 100까지 구하려면 100 해준다.


# 실수
 * 기본값 double; float 표현하려면 0.0f


# System
 * 에러가 없이 정상적으로 종료되었을 때는 System.exit(0);
 * 이렇게 0을 운영체제에 돌려주고, 에러가 있을 때에는 0이 아닌 값을, System.exit(1);
 * System.exit(-1); // 완전하거나 불안전하거나 그냥 종료
 * System.out.format; // 정규식 사용
- System.err.println(a + " " + b + " " + c + "=" + d); // 오류가 빨갛게 표시
- System.in.read(); // 두개를 집어 넣으면 엔터키 기능을 한다; 처음껀 \n(아스키 13)을 인식, 두 번째는 \r을 인식  
- System.in.skip(2); 를 하면 System.in.read()를 2번 넘어간 것과 같은현상


## printf
 * System.out.printf("평균 = %.2f\n", avg); // 소수 두번째 자리까지 표현

## 동적
- 동적 할당: 자료형을 자동으로 생성
- 동적 배열: 행은 무조건 있어야 함, 열은 생략 가능

# 클래스 기반
- 생성자로 접근; ex) 메소드
-힙으로 데이터 관리할 수 있게 하는 것: new;  new는 클래스 기반
- 웹과 연동할 때는 클래스 기반을 사용하는 것이 좋다. 빠르기 때문이다.
- 클래스 기반의 클래스는 오브젝트의 기본적인 기능인 구조와 동작 방식을 정의하고 인스턴스는 특정 클래스의 양식인 상태를 기반으로 한다. 
- 클래스 기반의 클래스는 동작 방식인 메소드로 동작하고 모든 인스턴스는 오브젝트의 자료를 가지고 있다. 
- 클래스 기반의 클래스의 생성자를 통하여 인스턴스를 새로 만들고 결과로 만들어진 인스턴스는 선택된 클래스의 설계와 행동을 따르게 된다. 
- 클래스 기반 언어로는 등이 있다 C++, C#, Java, Python, Ruby . 
- 클래스 기반을 프로토 타입 방식으로 쓰기 위해 JDK8 부터 람다식이 나왔다.

## new
 * int num = new Scanner(System.in).nextInt();  // 이렇게 접근 가능
-  힙으로 데이터 관리할 수 있게 하는 것: new;  new는 클래스 기반
추상 클래스는 new로 힙 공간 못만듬; {} return 이 없는 완벽한 값이 아니다.
- 메인 메소드에 new가 많으면 비효율적이다. new는 다른 곳에서 만들고 main에서는 메소드만 사용하는 것이 좋다.

# 프로토 타입 기반
- 복제; ex) 함수
- new를 안쓰고 복제하여 한번에 접근과 저장 동시에 가능.
  - 데이터를 접근해서 분석이나 시각화 작용을 하려면 프로토 타입을 사용하는 것이 좋다. 안정성 때문이다.
     - 프로토타입 기반은 오브젝트를 직접 사용하여 오브젝트를 생성하고 복제의 개념으로 재사용한다. 
     - 프로토타입 기반은 프로토타입의 복제 과정을 통하여 오브젝트가 가지고 있는 동작 방식을 다시 사용할 수 있다. 
     - 프로토타입 기반 언어는 동적으로 자유롭게 오브젝트의 구조와 동작 방식을 바꿀 수 있다. 프로토타입 기반 언어로는 자바스크립트 등이 있다
- sum() 를 sum 으로 변수처럼 직접적으로 사용 가능; 원래는 함수인 것을 사용.


# 클래스
- 클래스를 만들면 Object 클래스를 상속합니다.


# 내부 클래스

## InnerClass
- inner Class : 클래스 내부의 클래스
- innerClass를 이용하는 이유 : 바깥을 감싸고 있는 필드나 메소드를 얼마든지 참조할 수 있다.
- local inner Class : 메소드 안의 클래스
* GUI 애플리케이션에서 이벤트처리에 주로 ㅏㅅ용된다.
* 외부클래스$내부클래스로 컴파일된다.

### 장점
* 내부 클래스에서 외부클래스에 쉽게 접근할 수 있다.

### 단점
* 코드의 재사용이 어렵다.

1. Member
https://donggeuri0320.tistory.com/entry/%EC%9E%90%EB%B0%94java-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4Inner-class
-  멤버 변수나 멤버 메서드들과 같이 클래스가 정의된 경우에 사용한다;  잘 쓰임
- 객체를 생성해야만 사용할 수 있는 멤버들과 같은 위치에 정의되는 클래스를 말한다.
-  MemberInner.Inner inner = new MemberInner().new Inner();

2.  Local 
- 특정한 메서드 내에 클래스가 정의된 경우에 사용한다. 잘 안쓰임

3. Static
-  static 변수(클래스 변수)와 같이 클래스가 static으로 선언된 경우에 사용한다;  잘 안쓰임; 내부 클래스 객체 생성 안하고 직접 접근


4. Anonymous 
- 참조할 수 있는 이름이 없는 경우에 사용한다; 잘 쓰임
 * Test t1 = new Test(){ 
 * public int num = 10; 
 * @Override 
 * public int getNum(){
 *  return this.num; } 
 * }; 
- 인스턴스 옆에 블럭이 있다는 점이겠다. 언뜻 보면 new Test()라는 소스코드 때문에 이 인스턴스는 Test의 이름을 가질 것 같지만, 결코 아니다. 이 인스턴스야 말로 정말 어떠한 이름도 없는 인스턴스 인 것이다. 해당 주장이 맞는 주장인지 근거를 제시해보겠다.
- 먼저, 해당 인스턴스의 블럭안에는 @Override 어노테이션 주석이 존재한다. 즉, 원래의 Test 클래스에 존재하던 getNum 메서드가 아닌 재정의된 메서드 인점, 또한, 이 인스턴스의 this.num을 출력했을 경우 10이 나온다는 점이다.  오히려 이 인스턴스는 Test 클래스를 상속받은 클래스라고 바꿔 말해도 될 것이다.  평소에 자바언어를 사용하는 사용자라면, 상속을 어떻게 쓰는지 알 것이다. 클래스명 extends 상속받을 클래스     구조로 사용하는데 위의 소스 코드는 클래스명이 존재 하지 않고 무명의 어떠한 클래스가 부모클래스로 부터(Test) 상속을 받은 인스턴스 인 것이다. 즉 이름이 없으므로 생성자를 선언 할 수도 없는것이다.


## 내부 클래스 예제
 * package jg.begin.start.jae_0307;
 * 
 * public class Outer {
 * 
 *   private int i = 20;
 *   static int j = 30;
 * 
 *   class Inner {
 * 
 *     public void call() {
 *       System.out.println(i);
 *       System.out.println(j);
 * 
 *       // 외부 클래스 접근 가능
 *     }
 *   }
 * 
 *   public static void main(String[] args) {
 * 
 *     Outer outer = new Outer();
 *     Outer.Inner inner = outer.new Inner();
 * inner.call();
 *   }
 * }


## 지역 중첩 클래스
 * package jg.begin.start.jae_0307;
 * 
 * public class Outer {
 * 
 *   private int i = 20;
 *   static int j = 30;
 * 
 *   public void outerMethod() {
 * 
 *     final int so = 90;  // 스택에 들어간 메소드의 값에서 so가 소멸되지 않도록 상수 선언
 * 
 *     class Inner {
 * 
 *       public void call() {
 *         System.out.println(i);
 *         System.out.println(j);
 *         System.out.println(so); 
 *         // 외부 클래스 접근 가능
 *       }
 *     }
 *     Inner inner = new Inner(); // 메소드 안에서 객체 생성해야 함.
 *     inner.call();   // 메소드가 실행되고 나서 (final int so = 90;는 이미 지나감) 함수 호출; 이미 지나감
 * 
 *   }
 * 
 *   public static void main(String[] args) {
 * 
 *     Outer outer = new Outer();
 *     outer.outerMethod();
 *   }
 * }

- final은  JDK 1.8에서는 내장, 1.7은 내장되어 있지 않음

 * ※ 생명주기의 안전성 보장 
- 영역이 다르기 때문에 static이 아니라 final 사용
- ◽지역 중첩 클래스에서 외부의 로컬변수를 사용하기 위해서는 final 지정어을 사용해야만 사용이 가능하다. 
- ◽로컬변수는 final 지정어에 의해서 상수가 되어서 지역 중첩 클래스의 접근이 가능하다. 
- ◽메소드가 수행을 마치면 로컬변수는 해제되어 지는데 로컬변수가 해제되어 있는 시점에서도 지역 중첩 클래스의 인스턴스가 해제된 로컬변수를 참조할 경우가 발생할 수 있기 때문에 final 키워드를 지정해야 한다. 
- ◽로컬변수를 final 지정어로 지정하면 의 상수풀에서 별도로 로컬변수를 관리하므로 JVM 지역 중첩 클래스를 포함하고 있는 메소드와 메소드 안에 있는 final 지정어를 지정한 로컬변수는 생명주기가 달라진다.  // # 생명주기가 다르다.
- ◽생명주기가 달라지므로 메소드가 가비지 컬렉션에 반납되어도 메소드 안의 final 로컬변수는 상수풀에서 계속 보관하고 있기 때문에 이를 참조하고 있는 지역 중첩 클래스의 인스턴스는 문제없이 동작할 수 있다. 
- ◽생명주기가 달라지면 동작의 안전성을 보장하지 못하므로 지역 중첩 클래스에서 외부의 로컬변수를 사용하기 위해서는 final 지정어로 지정된 로컬변수를 사용하도록 하고 있다.




#
# 다형성
* 부모가 자료형, 자식이 new면; 자식 메소드 사용 가능
1. 인터페이스; 모두 다 강제하겠다.
2. 어노테이션; 모두 다 강제하지만 반환타입이 존재하는 것만 사용하겠다.
3. 추상 클래스; 강제성을 가지지만 구상 메소드도 가진다. 다형성이 부분적으로 일어난다.
4. 구상 클래스; 강제성이 없다.
- 다형성은 구상 클래스, , 추상 클래스 인터페이스를 사용하여 구현할 수 있지만 실질적으로 다형성은 인터페이스에서 구현한다. 대부분의 API . 는 인터페이스를 사용하여 다형성을 구현한다 중복 제거와 재사용성을 위해서 메소드의 인자를 지정할 때 다형성을 많이 적용한다. 다형성은 반드시 상속 관계가 성립되어야 한다. 다형성이 적용된 메소드는 하위 오브젝트의 메소드를 먼저 수행하고 하위 오브젝트에 해당 메소드가 없다면 부모 오브젝트의 메소드를 실행한다. 
- 실질적으로 인터페이스에서 구현한다. 대부분의 개발은 외부에서 라이브러리를 가져와서 하는데 이 때문에 인터페이스가 다형성의 기준이 된다.

# enum
- 상수 열거
- 어노테이션을 도와주기 위해 사용
- 배열로 되어있다.
- 무조건 대문자로 사용, 세미클론 사용하지 않는다.


# 인터 페이스
추상 클래스와 달리 여러 곳에 접근하게 할 때 사용.
- - 추상 클래스는 미완성 클래스라 하고 구상 클래스는 완성된 설계라고 한다. 인터페이스는 설계도라고 한다.
- 상수와 추상 메소드로 이루어 짐.

# 객체
- 속성과 동작을 가진다. 이 값을 표현할 수 없기 때문에 값이 아니라 주소값을 가진다.
- 컴퓨터에서는 모든 것이 객체로 이루어짐. 
1. 사물적 개념
2. 이름 부여
- 객체가 되면 두개의 주소를 가진다. 이를 참조 변수라 한다.(Call By Reference); 1개는 스택(identityHashCode(a)), 1개는 힙에 저장(s.hashCode())
- 파이썬은 모든 것이 객체다; 
int a 값도 id(a)로 주소값 구할 수 있고(힙에 저장) hash(a)로 접근할 수도 있다(스택에 저장).
누구나 수정하는 스택과 누구나 접근할 수 있는 스택이 합쳐진 것이 객체다.

## 파이썬 객체
- 파이썬은 모든 것이 객체다; 
- int a 값도 id(a)로 주소값 구할 수 있고 hash(a)로 접근할 수도 있다.

## 인스턴스
- 참조 자료형은 메모리상에 인스턴스(객체라고 하면 오브젝트와 헷갈림)가 있는 주소를 저장한다.
- 객체이기도 하고 힙에 저장 되어있기에 인스턴스라고 한다. 인스턴스로 저장되는 이유는 생명주기가 길어 일정하게 정보를 유지할 수 있다.
- 인스턴스화: 영어 단어인 의 사전적 의미는 예시하다 등이 있으며 여기에서는 인스턴스화라는 instantiate 의미가 된다. new 키워드를 사용하여 생성하고 생성된 인스턴스화된 오브젝트는 힙에 저장이 된다.
- A a = new A()
- A a // 사실상 이거는 스택에 공간 할당 위한 것
- new A() 가 인스턴스화 객체를 만든 것.

## 객체 생성
- A a = new A(); a 입장에서 힙에도 저장하고 스택에도 저장하여 객체 생성이라고 한다.

## 객체의 저장 영역
* 가. 메소드 영역 (method) 
- 메소드 영역은 자바에서 사용되는 클래스에 대한 정보와 함께 멤버 변수가 저장된다. 
- 특정 클래스가 사용되면 해당 클래스의 클래스 파일을 읽어들여 해당 클래스에 대한 정보를 메소드 영역에 저장한다. 

* 나. 힙 영역 (heap) 
- 힙 영역은 자바에서 사용되는 모든 인스턴스 변수가 저장되는 영역으로 메소드로 호출하여도 스택 영역처럼 소멸되지 않고 유지하므로 긴 생명주기를 가지는 자료들이 저장된다.  // # 긴 생명주기
- 힙에서 생성된 자료 중에 불필요한 자료들은 가비지 컬렉션이 해제한다. 
- 힙 영역은 사용자가 관리하는 영역으로 사용자에 의해서 메모리 공간이 동적으로 할당되고 해제된다. 
- 힙 영역은 메모리의 낮은 주소에서 높은 주소의 방향으로 할당된다. 
* 다. 스택 영역 (stack) 스택 영역은 자바에서 메소드가 호출될 때 메소드의 스택 프레임이 저장되는 영역이다. 
- 자바에서 메소드가 호출되면 메소드의 호출과 관계되는 로컬변수와 매개변수를 스택 영역에 저장한다. 
- 스택 영역은 메소드의 호출과 함께 할당되며 메소드의 호출이 완료되면 소멸한다. 
- 스택 영역에 저장되는 메소드의 호출 정보를 스택 프레임이라고 한다. 
- 스택 영역은 동작으로 데이터를 저장하고 동작으로 데이터를 인출한다
-  push pop . 스택은 후입선출 방식에 따라 동작하므로 가장 늦게 저장된 데이터가 가장 먼저 인출된다. 
- 스택 영역은 메모리의 높은 주소에서 낮은 주소의 방향으로 할당된다.

## 객체의 종류
### 오브젝트
 * - 가. 인스턴스 영어 단어인 의 사전적 의미는 사례 등이 있으며 여기에서는 객체라는 의미가 된다 instance . 인스턴스는 오브젝트에 의해서 생성되는 객체이지만 메모리에 저장되는 공간은 힙이 된다. 힙의 영역은 사용자에 의해서 메모리 공간이 동적으로 할당되고 해제된다. 힙은 사용자가 관리할 수 있는 공간이므로 오브젝트가 힙에 저장되어지면 자유롭게 접근하여 필요한 오브젝트의 요소를 가져다가 사용할 수가 있다. 사용자는 스택에 있는 오브젝트의 주소를 통해서 인스턴스의 정보에 접근하여 실제값을 전달하고 전달된 실제값은 스택에 있는 오브젝트의 주소에 의해서 실제값이 변경된다. 힙의 영역에 저장되는 정보는 메소드나 생성자에 의해서 호출하여도 스택 영역처럼 정보를 해제하지 않고 유지하기 때문에 스택 영역을 활용해야 한다. 참조 변수는 저장되는 메모리 주소는 스택 영역에 저장이 되고 주소가 가리키는 메모리는 모두 힙에 저장이 되므로 객체의 저장 공간은 상호 연관성을 가지고 있다.
- 

### 인스턴트
- 오브젝트는 객체의 본래 성격으로 자료와 자료에 관련된 절차 방법 기능 동작 등을 포함하는 , , , 의미이다. 오브젝트는 스택 영역에 저장이 되며 스택 영역은 컴퓨터가 관리하는 공간이므로 일반적으로 가비지 컬렉션에서 해제되는 것이 아니라 호출이 완료되면 해제한다. 스택 영역에 저장이 되는 것은 반환값 로컬변수 매개변수 등이 있다 , , . 오브젝트 안에는 오브젝트에 필요한 요소들이 가질 수가 있다. 오브젝트의 요소에는 속성인 정적인 요소와 동작인 동적인 요소가 있다. ① 정적인 요소 스태틱 멤버변수 인스턴스 멤버변수 생성자의 매개변수인 필드 : , , ② 동적인 요소 메소드 기본 생성자 필드 생성자 
- 유사 개념이지만 오브젝트가 포괄적 개념.


## 객체 예제
 * package jg.begin.start.jae_0305;
 * 
 * public class Object {
 * 
 *   String string = "문자열입니다.";
 * 
 *   public static void main(String[] args) {
 * 
 *     new Object().string = "인스턴스화 오브젝트입니다."; // 힙은 수정이 안되는데 힙에 저장하고 있다.
 *     System.out.println(new Object().string); // 위의 문자열이 출력된다.
 *     Object a = new Object(); // A를 생성하여 A 라는 스택에 저장한다.
 *     a.string = "인스턴스로 접근한다.";
 *     System.out.println(a.string);  // 인스턴스로 접근한다가 출력된다.
 *   }
 * }
  - 누구나 접근 가능하지만 값을 수정할 수는 없다.



## 객체 예제 2
 * package jg.begin.start.jae_0305;
 * 
 * public class Object {
 * 
 * public static void main(String[] args) {
 *  B b = new B();
 * 
 *  System.out.println(b);
 *  System.out.println(System.identityHashCode(b));
 *  System.out.println(b.hashCode());
 * 
 * }
 * }
- //서로 같은 결과 출력; 힙의 주소를 스택이 가지게 되기 때문.
- // 이미 만들어진 클래스인 String 클래스는 스택과 힙이 서로 다른 주소 가짐


# toString()
- 주소값을 값으로 변환해주는 메소드
- 힙에 있는 주소로 접근하게 되면 힙이 스택에 있는 값을 알려준다.(static을 하지 않으면 스택으로 직접적으로 접근할 수 없다.)
- 주소값을 실제값으로 변경해주는 것.
- 생성자의 매개변수를 통해서 데이터 값을 입력할 때 실제값을 주기 위해사 사용.
- 검증할 때 사용한다.



# 메모리
## Static area(스태틱 메모리 영역)
-  하나의 JAVA 파일은 크게 필드(field), 생성자(constructor), 메소드(method)로 구성된다. 그중 필드 부분에서 선언된 변수(전역변수)와 정적 멤버변수(static이 붙은 자료형) Static 영역에 데이터를 저장한다. Static 영역의 데이터는 프로그램의 시작부터 종료가 될 때까지 메모리에 남아있게 된다. 다르게 말하면 전역변수가 프로그램이 종료될 때까지 어디서든 사용이 가능한 이유이기도 하다. 따라서 전역변수를 무분별하게 많이 사용하다 보면 메모리가 부족할 우려가 있어 필요한 변수만 사용할 필요가 있다.(전역변수와 생성자에 관한 포스팅은 별도 진행 예정)

## Stack area(스택 메모리 영역)
 - 우리가 현재까지 작성하던 메소드 내에서 정의하는 기본 자료형(int, double, byte, long, boolean 등)에 해당되는 지역변수(매개 변수 및 블럭문 내 변수 포함)의 데이터의 값이 저장되는 공간이 Stack(스택) 영역이다. 해당 메소드가 호출될 때 메모리에 할당되고 종료되면 메모리가 해제된다. 

## Heap area(힙 메모리 영역)
-  이전 포스팅에서 객체와 인스턴스에 대해서 알아보았었다. 인스턴스를 생성하는 방법은 "클래스 변수 =  new 클래스();" 라는 것을 기억하면서 밑에 내용을 확인해 보자.
-  참조형(Reference Type)의 데이터 타입을 갖는 객체(인스턴스), 배열 등은 Heap 영역에 데이터가 저장된다. 이때 변수(객체, 객체변수, 참조변수)는 Stack 영역의 공간에서 실제 데이터가 저장된 Heap 영역의 참조값(reference value, 해시코드 / 메모리에 저장된 주소를 연결해주는 값)을 new 연산자를 통해 리턴받는다. 다시 말하면 실제 데이터를 갖고 있는 Heap 영역의 참조 값을 Stack 영역의 객체가 갖고 있다. 이렇게 리턴 받은 참조 값을 갖고 있는 객체를 통해서만 해당 인스턴스를 핸들 할 수 있다.

# 상속
- 강제하기: 부모 클래스에 abstract 메소드
- 강제성 동반; 상속은 메소드를 상속하기 위함
- 멤버 변수의 이름을 다르게 하면, 
- final 클래스는 상속할 수 없다.
-  자식 클래스가 부모 클래스로부터 상속을 받게 되면 부모 클래스의 필드와 메서드를 물려받게 된다. 단, 접근제어자가 private을 갖는 필드나 메소드는 상속이 불가하고, 패키지가 다를 경우 접근제어자가 default인 경우도 상속이 불가하다
- 추상 클래스 상속받으면 추상 메소드 사용 강제

# 상속의 생성자
 * public class B extends A {
 * 
 *   public B(String name, int salary) {
 *     super(name, salary);
 *     // TODO Auto-generated constructor stub
 *   }
 * 
 * }  
- 부모 클래스의 생성자를 만들어 주어야 한다.

### 상속 생성자 필드 추가하기
 *   private String depart;
 *   
 *   public B(String name, int salary, String depart) {
 *     super(name, salary);
 *     this.depart = depart;  // 뒤에 this로 추가해주면 됨
 *   }


## import와의 차이
- 상속은 다형성에 기준을 잡는다. 그래서 구상 클래스의 상속은 의미가 없다. 그래서 메소드를 받지 않으면 의미가 없다. 추상 클래스에서는 자동으로 강제성을 부여하기에 의미가 있다.




# 초기화
- ① 묵시적 초기화 멤버변수가 선언되었을 때에 생성자에 의해 자동으로 초기화 한다. 
- ② 명시적 초기화 명시적으로 멤버변수에 값을 초기화 한다. 
- ③ 생성자에 의한 초기화 클래스의 생성자를 호출하여 초기화한다. 클래스의 내부에서 명시적으로 생성자를 호출하면은 기본 생성자라고 한다. new 키워드로 클래스의 생성자를 호출하여 인스턴스를 생성하면은 생성자에 의해서 초기화한다. 


# 접근 지정자
- 접근 지정자는 접근을 허용시켜주는 것이고 접근 제한자는 선택권을 의미한다.^

# 접근 제한자
- 동일 패키지에서는 적용 안됨.
- 접근 지정자는 접근을 허용시켜주는 것이고 접근 제한자는 선택권을 의미한다.^
- public: 누구나 접근 가능
- private -> 클래스 내에서만 사용한다. (메소드나 생성자 통해 접근 가능)
- protected: 같은 패키지 일때는 상관 없고, 다른 패키지일 때 일반 클래스는 접근 못하고 상속한 자식 클래스만 사용 가능
- 서블릿에서 사용; 서블릿은 단지 웹에서 데이터를 받아 넘겨주는 역할만 하기 때문에 서블릿의 메소드를 건드릴 필요는 없기 때문에 protected를 사용한다.
- protected 접근 제한자는 추상 클래스와 궁합이 잘 맞음

# 초기화
- 소괄호나 대괄호 안에 아무것도 없는 것;
- 메인 함수; public static void main( String[] args)
- new 키워드 없어도 초기화 가능

# 생성자
- 기본 생성자는 자료를 제일 처음에 저장하는 역할을 한다. 초기화 기능을 한다. (스택 -> 힙) $
- 필드 생성자는 저장된 자료를 수정과 조회하는 역할을 한다. $
- 필드 생성자는  toString과 짝이다
- 생성자 안의 () 는 임시로 저장하겠다는 뜻
- 공통적으로 메소드의 역할을 가지고 있지만 메소드보다 우선순위권을 가진다. ^
- 전역적으로 초기화 시키는 건 생성자, 지역적으로 초기화 시키는 건 메소드
- 안드로이드에서 사용
- 인터페이스는 생성자가 없다. 이는 전역적 초기화를 안하겠다는 거고, 지역적으로 사용하겠다는 뜻. 
- private로 변수를 묶어 수정하지 못하게 만든다.

## 생성자 호출 방법
1. A a = new A();  // 구체적인 코드블록이 없다. 다른 것에 의해 실행
2. public A() { }; // 즉시 실행

## 생성자 종류
- 기본 생성자: 매개변수 있는 메소드
- 필드 생성자: 매개변수 없는 메소드

## 생성자 예제
//1
  {
    i = 20;
    System.out.println("안녕");
  }


//2
  public A() {
    i = 200;
    System.out.println("기본 생성자 호출");
  }

//3
  {
    i = 30;
    System.out.println("안녕");
  }

// 1번 -> 3번 -> 2번 순서대로 실행된다. 생성자는 순서가 정해져 있지 않다.
// {} 와 생성자는 기능이 같지만 블록은 1회성이고 생성자는 아니다. 생성자는 초기화 하면 그 값이 고정된다.


# 인터페이스
- 인터페이스는 생성자가 없다. 이는 전역적 초기화를 안하겠다는 거고, 지역적으로 사용하겠다는 뜻.

# 모델
- 멤버변수만 모아놓은 것; 모든 함수의 시작, 호출 저장을 모델에다가 함
- 사용법: 1. 필드 생성     2. get-set
- 한 개의 모델은 데이터베이스의 한개의 테이블과 같다.
- 변수 명도 테이블의 순서와 동일하게 적어라
- DB 연동한다(정형 데이터) -> 개별적을 저장하는 반면, DB 연동아닌 시스템에 있는 내용은 일괄적으로 저장한다.
- 시스템 저장은- setter 개별 저장; 필드 생성자 저장
- getter 개별 호출
- toString;  한꺼번에 호출; 권장
- 순서: 모델 -> 뷰 -> 서비스

## 모델 예제
 * public class DateCommand {
 * //  한 개의 모델은 데이터베이스의 한개의 테이블과 같다.
 * //  변수 명도 테이블의 순서와 동일하게 적어라
 * 
 *   private int day;
 *   private int month;
 *   private int year;
 * 
 * public DateCommand() {
 *   }  // 초기화
 * 
 * 
 *   public DateCommand(int day, int month, int year) {
 *     super();
 *     this.day = day;
 *     this.month = month;
 *     this.year = year;
 *   }  // 필드 생성
 * 
 *   @Override
 *   public String toString() {
 *     return "DateCommand [day=" + day + ", month=" + month + ", year=" + year + "]";
 *   } // 주소를 값으로 출력
 * 
 *   // DB 연동한다. -> 개별적을 저장한다.
 *   // DB 연동아닌 시스템에 있는 내용은 일괄적으로 저장한다
 * 
 * }

# 함수
- 함수는 복제하는 것이기 때문에 return형이 필요하다.

# 함수와 메소드
- 가장 큰 차이는 함수는 독립적으로 존재하며,    로직 처리 이후 사용자가 원하는 결과를 반환한다는 것이며
- 메서드는 클래스에 종속되어 존재하며, 해당 클래스에 대한 객체가 생성되어야 (static의 경우는 생각하지 말자) 사용할 수 있다는 것이다.

## 함수
 * - ● 함수(Function) : 함수는 특정 작업을 수행하는 "코드조각"이에요. 전역, 지역이던 "독립된 기능"을 수행하는 단위죠. 
 * - 이런거요. 저 "코드조각" 하는 일을 알 수 있는 이름을 "함수의 이름"으로 부여해요. 그리고 이 "이름"은 함수를 "호출"하여 해당작업을 수행합니다.  함수를 메소드보다 먼저 말씀드린 이유는, 함수가 메소드를 포함하고 있기 때문이에요. 

## 메소드
- ● 메소드(Method) :  클래스, 구조체, 열거형에 포함되어있는 "함수"를 메소드라고 부릅니다. 메소드를 다른말로 "클래스 함수"라고도 해요. 


## 람다 함수 = 익명함수 = 이름 없는 함수

# 메소드
- 코드블럭을 개별적으로 호출하기 위한 기법이다. 
- 전역적 역할을 하는 생성자와 달리 지역적 역할을 하고 초기화는 ‘return’이 하고 주소값 대신 위치만 받을 때는 ‘void’를 사용한다.
- 메소드 안의 메소드 선언: 불가하다. 메소드 안에 메소드 호출은 가능해도 선언은 불가하다.

## void
- -자바와 다르게 파이썬은 함수를 제외하고 모든 메소드는 기본적으로 void 형이다. return을 쓰는 함수, void를 쓰는 메소드 2가지 사용한다.
- return이 없는게 아니라 값이 없는 것
- 1. 이름 호출 2. 값 호출 3. 레퍼런스


# 가변인자
- 크기가 관계 없다.  

## 가변인자 예제
 * public class A {
 * 
 * 
 *   public void arrayCall(String... strings) {
 * 
 * 
 *     for (String string : strings) {
 *       System.out.println(string + "\n");
 *     }
 *   }
 * 
 * 
 * }

# Call By Reference
- Reference 라는 것은 주소를 참조한 다는 것;
- void call(int age)

## 예제
 * public void call(String name) {
 * 
 *     System.out.println(name.hashCode());
 *     System.out.println(name + "님 안녕하세요");
 *   }

B클래스
 * System.out.println("name1" + name1.hashCode());
 *     a.call(name1);  // 둘의 주소가 같다.



## 예제
- int age = “홍길동”
- call(age);  // 위와 아래의 ‘age’의 주소가 같다.

# 임베디드
- 메소드도 1회성이긴 하지만, 1회성으로 강력하게 사용하기 위해 람다식을 사용.
- 이름이 없는 것으로 접근하면 1회성.

# this
- this 지정어는 인스턴스를 참조하며 멤버변수명과 매개변수명을 동일하게 사용한다.

### this 예제
 * private int price; 
 * private int size; 
 * private String kind;
 *  public Property(int price, int size, String kind) {
 *  this.price = price; 
 * this.size = size; 
 * this.kind = kind; 
 * } 
 * public Property(int price) { 
 * this(price, 40, 아파트 " "); 인스턴스 멤버변수 초기화 // 
 * } 
 * public Property(int price, int size) { 
 * this(price, size, 빌라 " "); 인스턴스 멤버변수 초기화 // 
 * }

## 생성자
 *   public Property(int price, int size, String kind) {
 *     this.price = price;
 *     this.size = size;
 *     this.kind = kind;
 *   }
 * 
 *   public Property() {
 *     this(100, 32, "아파트");
 *     System.out.println("아파트 가격을 확인합니다.");
 *   }  // 기본 생성자가 항상 있어야 한다.
 * 

## hashCode
- 일반적으로 해시 코드는 해시 함수를 적용하여 나온 고정된 길이의 값이다. 해시 함수는 임의의 길이를 갖는 임의의 자료에 대해 고정된 길이의 자료로 매핑한다. 객체 지향 프로그래밍에서의 해시는 해시 테이블을 이용하여 자료를 저장한다. 자료를 저장할 때에는 특별한 알고리즘을 이용하여 자료의 고유한 숫자값을 만들어 인덱스로 사용한다. 
- 알고리즘을 구현한 메소드를 해시 메소드라고 하며 해시 메소드에 의해 반환된 자료에 대한 고유의 숫자값을 해시 코드라고 한다. 자바에서는 hashCode 메소드를 모든 객체의 해시 코드를 쉽게 구할 수 있다. 해시 코드를 통하여 인스턴스에 대한 고유한 주소값을 설정하는데 인스턴스의 메모리 주소를 숫자로 바꾼 고유한 주소라고 할 수 있다.
- hashCode 메소드는 인스턴스를 구별하기 위해 고유한 정수값으로 출력시켜 주는 메소드이다. 인스턴스 참조 변수를 출력할 때 출력되는 참조 주소는 인스턴스의 내부 주소를 정수값으로 변환하는 형태로 구현되는데 형식은 16진수이다. 주소값은 메모리에서 해당 인스턴스들을 구분할 수 있는 유일한 값이므로 인스턴스의 고유한 주소를 가진다. 인스턴스가 고유한 주소를 가진다는 것은 인스턴스가 고유한 ID를 가진다는 의미로 풀이할 수 있다. .

### 주소
 * package jg.begin.start.jae_0308;
 * 
 * public class A {
 * 
 *   String name = "홍길동";
 * 
 *   public static void main(String[] args) {
 * 
 *     Object object = new Object();
 *     System.out.println(object.hashCode());
 *     System.out.println(System.identityHashCode(object));
 *   }
 * 
 * }

- Object 해시 코드와 System의 Hash코드가 같은 값이면 관리하기 쉽다.
- 얕은복사: 주소값(object의 해시코드) 만 복사
- 깊은 복사: object의 해시코드와 System의 해시코드 모두 복사


# 디자인 패턴
- (1) 디자인 패턴의 개요 디자인 패턴은 프로그래밍 설계에 있어서 공통된 문제들에 대한 표준적인 해법이다. 
- 디자인 패턴은 프로그램 개발에서 자주 나타나는 과제를 해결하기 위한 방법이다. 


## 종류
- 가. 싱글톤 패턴 하나의 인스턴스만을 생성하기 위한 패턴이다. 
- 모든 객체지향의 오브젝트는 다 싱글톤이다.
- 스프링에서 만든 모든 객체는 싱글톤이다.
- 주소의 효율성; 모든 참조 변수, 객체지향은 모두 싱글톤
- 나. 팩토리 패턴 메인 메소드에서 인스턴스를 생성하지 않고 메소드로 호출하는 패턴이다. 
-  구현 클래스 - 팩토리 - 클래스 - 인터페이스 사용  
- BeanFactory라는 인터페이스를 이용하여 annotation를 변환시켜서 사용할 것임
- 팩토리 패턴은 서브 클래스인 팩토리(서브 클래스)에서 인스턴스를 생성하므로 서브 클래스인 팩토리를 호출하는 코드로 충분하다. 
- 즉, new 키워드를 사용하는 부분을 서브클래스에 위임함으로 써 객체 생성을 캡술화하고 구상클래스에 대한 의존성이 줄어든다는 이점을 얻을 수 있습니다. 이렇게 생성자를 별도의 인터페이스로 분리하여 객체를 만들어내는 공장(factory)로 이용하는 것이 팩토리 메서드 패턴입니다. # 의존성이 줄어든다.
- 구현 클래스를 변경하고자 할 때에는 서브 클래스인 팩토리에서 수정하므로 호출하는 클래스에 영향을 주지 않는다.
- 객체를 생성하기 위한 인터페이스를 정의하는데, 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하게 만든다. 즉 팩토리 메소드 패턴을 이용하면 클래스의 인스턴스를 만드는 일을 서브클래스에게 맡기는 것.
- - 바뀔 수 있는 부분을 찾아내서 바뀌지 않는 부분하고 분리시켜야 한다는 원칙.
- 다. 커맨드 패턴 오브젝트를 캡슐화하여 메소드를 통해서 인스턴스에 접근하는 패턴이다. 
- 라. 프록시 패턴 오브젝트를 캡슐화하여 인스턴스에 대한 접근을 제어하는 패턴이다. 
- 메소드가 동작을 할 때 (전처리, 실행, 후처리) 중 전처리와 후처리 만을 이용하는 것(스프링의 AOP에서 사용)
- 마. 프로토타입 패턴 동일한 인스턴스를 여러 번 생성해야 하는 비용을 줄이기 위한 패턴이다. 
- 바. MVC 패턴 사용자 인터페이스와 비즈니스 로직을 분리하여 개발하는 패턴이다. 
- 비즈니스 로직: DB 연동; 사용자 인터페이스(사용자가 입력, 접속하는 기기): 콘솔, 브라우저, GUI
- M: setter, getter; 모든 데이터의 입력
- V: 1. 화면(출력(컨트롤러 -> 모델 -> 뷰), 입력)  2 경로(웹 주소)
- C: 1. 파라미터 전송 2. 경로 전송; 모든 데이터의 매개체
- V와 C가 합쳐지면 디자인과 개발자가 동시 개발이 안되었다.

# 어노테이션
- 초창기엔 SOURCE까지만 정보를 알려주었기 때문에 어노테이션(주석)이라고 불렸음.
- 어노테이션의 @는 참조라는 뜻, 그래서 다른 것과 달리 @가 안나옴
- 열거형 함수
- java.lang.annotation
- 설정 파일에서 가져오기 위해 사용; 메타데이터 사용
- 패턴을 효율적으로 사용하기 위함.
- void라는 반환 타입과 상속이 없는 인터페이스를 어노테이션이라 한다.
- 파일에서 가져오는 것이니(xml, 프로퍼티 파일) void가 불가하다.
- xml 파싱의 기능; xml에서 오라클로 부터 데이터 받아오고 중간에서 매개체가 되어 나에게 데이터를 준다.; 
- 3가지의 정책이 있음; 타겟 -> 클래스, 메소드
1. SOURCE: 소스 코드에 정보만 알려주는 기능; 오버라이드
2. CLASS: 소스코드와 컴파일에도 알려주지만 리플렉션을 못한다.
3. RUNTIME: 소스 코드, 컴파일, 리플렉션 모드 적용.

## 리플렉션; 외래어
- 

## override
* 상속에서 나온 개념; 상위 클래스의 메소드를 하위 클래스에서 받은 상태에서 본문 수정

# 오버로딩
- 상속과 관련없다
- 한 클래스에서 같은 이름의 메소드를 여러개 정의하는 것
- 매개변수의 타입이 다르거나 개수가 달라야 한다.
* 같은 클래스 내에 return value와 메소드명이 동일한 메소드를 매개변수만 다르게 만들어 다양한 상황에 메소드가 호출될 수 있도록 하는 것입니다.

## Override 어노테이션
- @Target(ElementType.METHOD); 
+ 메소드를 타겟으로만 사용 가능
- @Retention(RetentionPolicy.SOURCE)  
public @interface Override {
}

## Deprecated
 * @Documented
 * @Retention(RetentionPolicy.RUNTIME)
 * @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
 * + 다양하게 지원
 * public @interface Deprecated {
 * }
 * - 곧 사라질 것이라고 인식

## annotation 생성 예제
 * package jg.begin.start.jae_0311;
 * 
 * import java.lang.annotation.ElementType;
 * import java.lang.annotation.Retention;
 * import java.lang.annotation.RetentionPolicy;
 * import java.lang.annotation.Target;
 * 
 * @Target(ElementType.TYPE)
 * @Retention(RetentionPolicy.CLASS)
 * 
 * public @interface ClassAnno {
 * //  public String val();
 * 
 *   public String defaultVal() default "홍길동";
 * 
 * }


## 차이
- 채팅: 추상 클래스
- jsp: 웹과 연동: 인터페이스
- 설정 파일과 연동: 어노테이션
- 스프링: 어노테이션


# 번역기
## 인터프리터
- 인터프리터는 고레벨 언어를 바로 기계어로 변환하는 것이 아닌 중간형태로 변환 한다음 실행한다. 컴파일러는 고레벨언어를 바로 기계어로 변환한다. 
- 인터프리터 방식은 수정이 어렵다.
-  이 방식이 편리하기는 하지만 인터프리터가 컴퓨터에 미리 설치되어 있어야 하는 단점도 있다. 파이썬 인터프리터 프로그램을 줄여서 ‘파이썬’이라고 부를 때가 많다. ‘파이썬’이라고 하면 언어를 뜻할 때도 있고, 인터프리터 프로그램을 뜻할 때도 있다. 파이썬 인터프리터는 잠시후 함께 설치해 볼 것이다.
- 파이썬의 경우 런타임중의 컴파일 과정에 렉서(lexer), 파서(parser) 를 거쳐서 바이트 코드를 만들어낸다. (렉서 : 요소를 하나하나 쪼갠다. / 파서 : abstract syntax tree, 구문분석)
- 어셈블리어는 cpu에 의존적이나, (예: 인텔 계열의 어셈블리어) 바이트코드는 그렇지 않다.
- 바이트코드는 가상머신(virtual machine) 위에서 돌아가기 때문에 어떤 cpu 위에서도 돌아갈 수 있다.
- 파이썬 초기 설치시 window용, mac용, linux용을 따로 받는 이유는 바이트코드에서 어떤 기계어로 바꿀지를 결정하기 위해서이다.
- Java, python 모두 바이트코드를 사용하기 때문에 vm(virtual machine)이 필요하다.
## 바이트 코드
 바이트코드는 가상머신(virtual machine) 위에서 돌아가기 때문에 어떤 cpu 위에서도 돌아갈 수 있다.
- 파이썬 초기 설치시 window용, mac용, linux용을 따로 받는 이유는 바이트코드에서 어떤 기계어로 바꿀지를 결정하기 위해서이다.
- Java, python 모두 바이트코드를 사용하기 때문에 vm(virtual machine)이 필요하다.



### 인터프리터 과정
- python 코드 --> 실행 & 런타임 시작 --> (컴파일) --> 바이트코드 --> VM --> 기계어



## 컴파일러
- 컴파일러는 소스 코드를 기계어로 미리 번역해 둘 때 사용하는 프로그램이다. 인터프리터는 실행이 필요할 때 소스 코드를 실시간으로 해석해서 그에 맞는 명령을 컴퓨터에게 지시하는 프로그램이다.
- 어셈블리어는 cpu에 의존적이기 때문에, 컴파일된 코드들은 여러종류의 프로세서를 자유롭게 옮겨다니며 사용될 수 없다. (.exe, .dmg)
- 컴파일 이전의 소스코드도 운영체제별 특징이 있어 각각의 라이브러리를 요구한다.
- 컴파일러와 어셈블러를 함쳐서 컴파일이라고 부르며, 코드가 기계어로 변환되는 과정을 컴파일 타임이라고 부른다.
- 어셈블리어와 기계어는 1:1 매칭이다.
- 기계어에서 어셈블리어로 변환시키는 것을 disassemble이라고 한다.
- 자바는 런타임 전에 기계어가 아닌 바이트코드로 컴파일 되며, 런타임중에 기계어로 바뀐다. 하지만 컴파일 시점이 런타임 이전이기 때문에 컴파일언어에 속한다.


### 예시
- `C 코드` --(컴파일러)-->> `어셈블리어` --(어셈블러)-->> `기계어` --(링커)-->> `실행파일` -->> `런타임` 시작

### 컴파일, 인터프리터 차이
- ◆ 컴파일러의 실행과정 
  1. 어휘분석(Lexical Analysis)
  2. 구분 분석(Parsing) 
  3. 의미분석(Semantics Analysis) 
  4. 중간 코드 생성
  5. 기계어 코드 생성
- ◆ 인터프리터의 프로그램 실행 과정
  1. 한명령어를 메모리에서 가져온다. 
  2. 가져온 명령어를 해석한다. 
  3. 필요한 데이터를 가져온다. 
  4. 명령을 실행한다.
 
- 인터프리터의 경우에는 실행시킬 때마다 번역이 선행 되므로 시간이 많이 걸리지만 컴파일의 경우에는 한 번만 번역을 하고 실행 파일이 생기므로 실행시에는 번역하는 시간이 걸리지 않아서 수행 속도가 빠르다.
- 또한 컴파일러는 컴파일 시에 전체 프로그램 코드가 생성되므로 사용하는 메모리가 많아지게 되고, 때에 따라서는 '메모리 부족 에러'를 발생 하기도 한다.  
- 그러나 인터프리터의 경우에는 번역시 그때 그때 필요한 실행 코드를 생성하므로 사용하는 메모리가 작다. 




- 목적 프로그램: 컴파일러는 번역후 저장을 위해 필요, 인터프리터는 바로 수행하므로 불필요
- 기억 장소: 컴파일러 많이 필요, 인터프리터 적게 필요

### 언어별 번역기
- 자바는 컴파일러, 인터프리터 둘다 가지고있음; 웹과 연동
- 컴파일: 오류 만나면 수행 멈춤; 에러 
- 인터프리터: 오류 만나도 수행 안멈춤; 한줄 번역; 예외 처리
      - - 예외 처리는 인터프리터 방식
- 자바스크립트는 컴파일러 없이 인터프리터 방식만 이용; 파싱
- C언어는 컴파일러만 있음.
- 파이썬은 데이터 분석쪽은 인터프리터 방식




# 루틴; 프로그램 실행할 때의 경로
- 루틴 강제로 넣기 환경변수 잡기;
- 윈도우에서 아이콘 우측클릭 했을 때 대상 위치
- 자바 io를 이용하여 경로에 파일 생성

# 스레드
- Thread th = new Thread();

1. 스레드 상속   2. run 메소드 오버라이드  3.인스턴스의 start 메소드를 가동

## 스레드 로컬
* 스레드 사이에 간섭이 없어야 하는 데이터에 사용한다. 멀티스레드 환경에서는 클래스의 필드에 멤버를 추가할 수 없고 매개변수로 넘겨받아야 하기 때문이다. 즉, 스레드 내부의 싱글톤을 사용하기 위해 사용한다. 주로 사용자 인증, 세션 정보, 트랜잭션 컨텍스트에 사용한다.
* 스레드 풀 환경에서 ThreadLocal을 사용하는 경우 ThreadLocal 변수에 보관된 데이터의 사용이 끝나면 반드시 해당 데이터를 삭제해 주어야 한다. 그렇지 않을 경우 재사용되는 쓰레드가 올바르지 않은 데이터를 참조할 수 있다.

* ThreadLocal을 사용하는 방법은 간단하다.
* ThreadLocal 객체를 생성한다.
* ThreadLocal.set() 메서드를 이용해서 현재 스레드의 로컬 변수에 값을 저장한다.
* ThreadLocal.get() 메서드를 이용해서 현재 스레드의 로컬 변수 값을 읽어온다.
* ThreadLocal.remove() 메서드를 이용해서 현재 스레드의 로컬 변수 값을 삭제한다.

## Runnable
- 싱글 인터페이스 - 메소드 1개; 람다식이 가능하다.
- 1회성(이벤트적 효과) 일 때만 사용한다.

## Runnable 인터페이스
 * @FunctionalInterface  // 메소드는 1개만 사용 할 수 있다. 즉 한 개의 run만 쓸 수 있다.
 * public interface Runnable {
 * public abstract void run();
 * }
 * }


# @FunctionalInterface
 * @FunctionalInterface  // 메소드는 1개만 사용 할 수 있다. 즉 한 개의 run만 쓸 수 있다.
 * public interface Runnable {
 * public abstract void run();
 * }
 * }


## Runnable과 스레드 차이
- 쓰레드를 구현하는 방법은 Thread클래스를 상속받는 방법과 Runnable인터페이스를 구현하는 방법, 모두 2가지가 있다. 이 두 가지 방법 중 어느 쪽을 사용해도 별 차이는 없지만 Thread클래스를 상속받으면 다른 클래스를 상속받을 수 없기 때문에, Runnable인터페이스를 구현하는 방법이 일반적이다.
- Runnable인터페이스를 구현하는 방법은 재사용성(reusability)이 높고 코드의 일관성(consistency)을 유지할 수 있다는 장점이 있기 때문에 보다 객체지향적인 방법이라 할 수 있겠다.

## 인스턴스 생성 방법

### 스레드
 * ThreadExtends te = new ThreadExtends();
 * te.start()

### Runnable
 * Runnable r = new RunnableImplements();
 * Thread t = new Thread(r);
 * t.start();


## start()와 run()에 대한 차이와 쓰레드가 실행되는 과정
- run()을 호출하는 것은 생성된 쓰레드를 실행시키는 것이 아니라 단순히 클래스에 속한 메서드 하나를 호출하는 것이다. 반면에 start()는 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택(call stack)을 생성한 다음에 run()을 호출해서, 생성된 호출스택에 run()이 첫 번째로 저장되게 한다.
 
1. main메서드에서 쓰레드의 start메서드를 호출한다.
2. start메서드는 쓰레드가 작업을 수행하는데 사용될 새로운 호출스택을 생성한다.
3. 생성된 호출스택에 run메서드를 호출해서 쓰레드가 작업을 수행하도록 한다.
4. 이제는 호출스택이 2개이기 때문에 스케줄러가 정한 순서에 의해서 번갈아 가면서 실행된다.
5. Thread는 상속을 받으며 Runnable은 인터페이스로서 구현한다
6. Thread는 재사용이 불가능하며 Runnable은 가능하다
7. Thread 사용시 다른 클래스를 상속받을 수 없다 (1번과 똑같은 의미겠죠?)
8. Runnable Implements는 보다 객체지향적이다 (독립된 class 선언)
 
잠깐, 너무 Thread 상속이 안좋은것 같잖아요!
9. Thread 사용시 그 class를 바로 사용할 수 있다. (해당 class의 Method를 사용가능함)
 - Runnable 사용시 다른 클래스에서 implements를 할 경우 해당 class Method 이용불가 // 인터페이스는 추상 메소드만 사용 가능
- - Runnable인터페이스를 구현하는 방법은 재사용성(reusability)이 높고 코드의 일관성(consistency)을 유지할 수 있다는 장점이 있기 때문에 보다 객체지향적인 방법이라 할 수 있겠다. 
- 코드의 일관성: run이라는 메소드밖에 없다 = 다형성 = 일관성
  * 하지만 4번 항목과 더불어 객체지향의 특징일 수 있겠죠!?

- 한 쓰레드에서 예외가 발생해서 종료되어도 다른 쓰레드의 실행에는 영향을 미치지 않는다. 

## 작업 흐름의 상태
- ① 상태 Startable 스레드를 인스턴스 생성한 상태로 Thread 클래스를 상속받거나 Runnable 인터페이스를 구현한 클래스를 생성한다. 
- ② 상태 Runnable 스레드의 인스턴스를 통해 start 메소드를 호출할 때에 스레드를 생성한다. 생성된 스레드에 start 메소드를 호출하는 경우의 상태로 스레드가 실제로 실행되지 않으며 단지 실행하기 위한 준비 단계를 의미한다. 
- ③ 상태 Blocked 실행되고 있던 스레드가 run 메소드를 모두 끝마치지 못하고 중간에 중지되어 있는 상태이다. 입출력이나 인터럽트 요청 같은 경우에 발생되며 sleep 메소드, yield 메소드, join 메소드와 같은 메소드 요청 시에도 발생 될 수 있다. 
- ④ 상태 Running 스레드는 run 메소드를 실행한다. 상태의 스레드를 상태로 이동하여 실제로 스레드가 동작하는 상태이다 Runnable running . ⑤ 상태 Dead run 메소드의 실행이 끝나면 스레드를 종료하므로 다시 스레드를 실행 할수가 없다. 실행되고 있던 스레드가 run 메소드를 모두 처리하여 스레드가 제거되는 상태이다.

## sleep
- ① 메소드 블락의 기능 sleep 스레드는 우선순위 방식으로 실행이 되기 때문에 우선순위가 낮은 스레드는 최악의 경우에 실행되지 못하고 항상 Runnable 인터페이스 상태로 있을 수도 있으며 이런 상태를 기아 상태라고 한다. 기아 상태를 방지하기 위해서 우선순위가 낮은 스레드에게도 실행될 수 있는 기회를 줘야 하며 이때 사용가능한 메소드가 sleep 메소드이다. sleep 메소드 인자로 지정된 시간만큼 실행 중인 스레드가 블락되며 기아 상태를 방지할 목적으로 sleep 메소드는 일반적으로 항상 사용된다. 

## yield
② 메소드 블락의 기능 yield yield 메소드의 용도는 다른 스레드에게 실행할 기회를 주기 위해서 사용된다. yield 메소드로 우선순위가 동일한 스레드에게 실행할 기회를 제공한다. 


## join
- ③ 메소드 블락의 기능 join 여러 개의 스레드가 실행 중인 멀티스레드 환경에서는 어떤 스레드가 먼저 실행되고 끝날지를 예측할 수 없으므로 순전히 스케줄러에 따라서 실행이 결정된다. 스레드를 여러 개 동시에 실행할 때는 어떤 스레드가 실행될지 정확히 제어하기가 힘들다. 특정한 스레드가 실행된 후에 다른 스레드가 실행되게 하려면 일정한 처리를 해 주어야 하는데 이럴 경우에 사용할 수 있는 메소드가 join 메소드이다. 스레드의 종료 순서를 지정할 수 있는 방법으로 join 메소드를 사용 할 수 있다. join 메소드를 호출한 스레드가 종료하기 전까지 현재 실행 중인 스레드가 블락된다. join 메소드는 join 메소드로 호출한 스레드 작업이 모두 끝날 때까지 다른 스레드가 대기하게 하는 기능을 제공한다.

## 스레드의 동기화
- 여러 스레드가 하나의 데이터를 공유할 수 있다. 스레드의 공유 구조는 성능과 자원의 효율성에서는 좋지만 데이터 일관성에 있어서는 문제가 발생될 수 있다. 스레드는 하나의 프로세스에서 여러 작업을 동시에 실행할 수 있는 역할을 하지만 하나의 프로세스에서 동시에 작업을 하다 보니 여러 스레드가 동일한 자원에 작업을 하는 경우가 생긴다. 동일한 자원에서 작업하는 문제점을 데이터베이스의 락이라는 개념을 적용시켜 하나의 작업이 끝날 때까지 다른 작업을 기다리게 하는 방법으로 문제를 해결한다.


- 자바는 동기화라는 개념으로 다른 스레드에서는 해당 메소드에 접근할 수 없게 처리한다. 동기화는 여러 스레드가 하나의 데이터를 공유할 때 하나의 스레드가 해야 되는 작업이 끝날 때까지 공유되지 않도록 보장 해주는 방법으로 synchronized 지정어를 사용하여 동기화를 적용한다. 

## 동기화 메소드의 형식
 * 접근제한자 synchronized 반환형 메소드명 (
 * [인자 인자 인자 1, 2, N] … ) { 
 * 실행 내용… … 
 * }

## 동기화 블럭의 형식
 * 접근제한자 지정어 반환형 메소드명 (
 * [인자 인자 인자 1, 2, N] … ) { 
 * synchronized 공유 객체 ( ){ 
 * } 
 * }
- 메소드 내에서 synchronized 지정어를 사용한다. B. 동기화 블락의 개요 메소드 내의 모든 코드가 아닌 synchronized 블락만 동기화되므로 전체 메소드를 동기화하는 방법보다 더 효율적이다.


##  Object 클래스에서 제공하는 동기화의 주요 메소드 
- 동기화 블락 안에서 특정한 상황에서는 다른 스레드와 제어권을 서로 주고받을 수 있다면 CPU 훨씬 효과적인 프로그래밍을 할 수 있다. 
- Objcet 클래스에서는 동기화에 사용되는 메소드를 제공하며 동기화에 사용되는 메소드들은 동기화 블락 안에서만 사용할 수 있고 일반 메소드에서는 사용할 수 없다.

- ① 메소드 wait wait 메소드는 현재 실행 중인 스레드를 대기한다. 
- ② 메소드 notify notify 메소드는 대기 중인 스레드 중 하나를 Runnable 인터페이스 상태로 만든다. 
- ③ 메소드 notifyAll notifyAll 메소드는 대기 중인 모든 스레드를 Runnable 인터페이스 상태로 만든다.


# 동기화
- Vector: 동기화 <> ArrayList 동기화 안됨
- println: 동기화 <> print: 비동기화
- 동기식 <> 비동기식

## 동기식, 비동기식
### 동기(synchronous : 동시에 일어나는)
 - 동기는 말 그대로 동시에 일어난다는 뜻입니다. 요청과 그 결과가 동시에 일어난다는 약속인데요. 바로 요청을 하면 시간이 얼마가 걸리던지 요청한 자리에서 결과가 주어져야 합니다.
- -> 요청과 결과가 한 자리에서 동시에 일어남
- -> A노드와 B노드 사이의 작업 처리 단위(transaction)를 동시에 맞추겠다.
 
### 비동기(Asynchronous : 동시에 일어나지 않는)
 - 비동기는 동시에 일어나지 않는다를 의미합니다. 요청과 결과가 동시에 일어나지 않을거라는 약속입니다. 
- -> 요청한 그 자리에서 결과가 주어지지 않음
- -> 노드 사이의 작업 처리 단위를 동시에 맞추지 않아도 된다.


### 동기식 예제
1. A의 계좌는 10,000원을 뺄 생각을 하고 있다.
2. A의 계좌가 B의 계좌에 10,000원을 송금한다.
3. B의 계좌는 10,000원을 받았다는 걸 인지하고, A의 계좌에 10,000원을 받았다고 전송한다.
4. A, B 계좌 각 각 차감과 증가가 동시에 발생하였다.
 
- 순서를 보면 아시겠지만 A의 계좌와 B의 계좌는 서로 요청과 응답(1-3과정)을 확인한 후 같은 일을 동시에 진행하였습니다. (4번 과정) '계좌이체'같은 작업은 동기방식으로 처리해야 A에서 보냈는데 B는 못받는 상황이 없겠죠?

### 비동기식 예제
1. 학생은 시험문제를 푼다
2. 시험문제를 모두 푼 학생은 선생님에게 전송한다.
3. 선생은 학생의 시험지를 채점한다.
4. 채점이 다 된 시험지를 학생에게 전송한다.
5. 학생은 선생이 전송한 시험지를 받아 결과를 확인한다.
 
 
- 학생과 선생은 시험지라는 연결고리가 있지만 시험지에 행하는 행위(목적)은 서로 다릅니다. 학생은 시험지를 푸는 역할을 하고 선생은 시험지를 채점하는 역할을 하였습니다. 서로의 행위(목적)가 다르기때문에 둘의 작업 처리 시간은 일치하지 않고, 일치하지 않아도 됩니다.
- 어떤 루틴을 완전히 끝내고 제어를 반납하면 동기식 동작이 안 끝났어도 일단 제어권을 반납한 후 지 할일 계속하면 비동기식입니다
- 이러한 비동기식은 DOS같은 단일 운영체제에서는 근본적으로 불가능하고 windows같은 multi task 환경에서만 가능합니다.
- 요청의 결과값이 리턴값과 동일한 것이 동기, 요청의 결과값이 리턴값과 다른 것이 비동기이다.
명령이 끝날때 까지 사용자에게 제어권을 돌려 주지 않는 것이 동기, 명령이 끝나기전 사용자에게 제어권을 돌려 주는 것이 비동기이다.
- Point! 어떤 루틴이 끝날때까지 제어권이 돌아오지 않으면 동기식 그렇지 않으면 비동기식인 것이다. 
- 동기 방식으로 할 경우 웹 브라우저에 따라 동작 방식이 다를 수 있기 때문에, 대부분 비동기 방식을 사용
- 동기, 비동기의 원래 의미는 통신에서 상대방의 일정 신호에 의해서 다음 동작이 이루어지면 동기, 상대방의 상태와 관계없이 일방적으로 동작하면 비동기 이다.
- 즉, 상대방이 받을준비 됐다는 신호를 받아서 한byte 보내고,수신측에서 한byte받은 후 또 보내도 된다는 신호를 보내고 이 신호 확인후 보내고.. 이런식이 동기식이다.
이에 반하여 비동기에서는 일단 한번 전송 시작되면 좌--악 보낸다. 이와 비슷한 개념으로 일반 software에서 동기식이라 함은 어떤 루틴을 완전히 끝내고 제어를 반납하면 동기식, 동작이 안 끝났어도 일단 제어권을 반납한 후 지 할일 계속하면 비동기식이다.


## 동기식과 비동기식의 특징
 * 순서에 맞게 빨리빨리 진행되는 장점이 있지만, 여러 가지의 일을 동시에 처리할 수 없는 단점이 있다. 이러한 점이 자바스크립트 비동기 방식의 탄생 배경이라 짐작된다.
 * - - 비동기 방식**은,
 * 여러가지 일을 한꺼번에 처리할 수 있지만, 동기 방식보다 처리 속도가 조금 떨어질 수도 있다.
 * 해당 요청작업은 별도의 쓰레드에서 실행하게 되며, 비동기 요청처리 결과 전달 방법에는 콜백(Call Back) - 요청 처리가 완료되면 콜백 호출과 결과 조회 - Future. 비동기 작업 결과를 조회해볼 수 있는 핸들러. 요청이 완료되었는지 확인가능가 있다.
 * 비동기로직의 사용처 * 프레임에 너무 많은 명령을 적재하면 최초 1프레임의 렌더링이 늦어져 유저가 화면을 볼 수 있는 대기 시간이 길어진다. * 애니메이션 처럼 시간자체를 지연하고 싶어 지연한다. * 시스템이 수신하는 데이터(이벤트)는 시스템만 루프를 돌며 대기하고 스크립트는 발생한 후 통보를 받는 식으로 하여 부하를 줄일 수 있다. * 한 프레임에서 실행되는 명령에는 시간 제약이 있으므로 무거운 로직은 여러 프레임에 걸쳐 처리하도록 해야한다.
 * Promise
 * - 콜백 함수가 난무하게 되면 개발자가 코드를 알아보기 힘들뿐더러 디버깅, 유지보수 하기 매우 힘들어진다. 아래의 예시 사진은 callbackhell이라는 사이트에서 사용되는 한 이미지다. 콜백이 정말 많아서 한눈에 읽기 굉장히 불편하다.

# 데이터 입출력
- 데이터 입력출력은 클래스로 인해 이루어지고 데이터 흐름은 스트림으로 이뤄진다.
- 데이터흐름(스트림) -> 데이터 전송(저장) -> 연속성(데이터베이스)
- 입력  -  파이프  - 컴퓨터  - 저장 방법
- 메모리: 배열
- 파일, 데이터베이스(메모리에 연속성 부여 위해)
- 외부 자원: - 원격 네트워크, 키보드/모니터, 파일, DMBS

## 직렬화: 
- (컴퓨터 - 파일) 사이에서 이루어지는 것
- 자바에서는 인터페이스로 이루어짐
- 직렬화(直列化) 또는 시리얼라이제이션(serialization)은 컴퓨터 과학의 데이터 스토리지 문맥에서 데이터 구조나 오브젝트 상태를 동일하거나 다른 컴퓨터 환경에 저장(이를테면 파일이나 메모리 버퍼에서, 또는 네트워크 연결 링크 간 전송)하고 나중에 재구성할 수 있는 포맷으로 변환하는 과정이다.[1]
- 오브젝트를 직렬화하는 과정은 오브젝트를 마샬링한다고도 한다.[2] 반대로, 일련의 바이트로부터 데이터 구조를 추출하는 일은 역직렬화 또는 디시리얼라이제이션(deserialization)이라고 한다.

```java
직렬화란 무엇인가

자바에서 입출력에 사용되는 것은 스트림이라는 데이터 통로를 통해 이동했습니다. 
하지만 객체는 바이트형이 아니라서 스트림을 통해 파일에 저장하거나 네트워크로 전송할 수 없습니다. 
따라서 객체를 스트림을 통해 입출력하려면 바이트 배열로 변환하는 것이 필요한데, 
이를 '직렬화' 라고 합니다. 반대로 스트림을 통해 받은 직렬화된 객체를 원래 모양으로 만드는 과정을 역직렬화라고 합니다.

serialVersionUID를 선언해야 하는 이유

자바가상기계 (JVM)은 직렬화와 역직렬화를 하는 시점의 클래스에 대한 버전 번호를 부여합니다. 
만약 그 시점에 클래스의 정의가 바뀌어 있다면 새로운 버전 번호를 할당합니다. 
그래서 직렬화할 때의 버전 번호와 역직렬화를 할 때의 버전 번호가 다르면 역직렬화가 
불가능하게 될 수도 있습니다. 이런 문제를 해결하기 위해 SerialVerionUID를 사용합니다.

간단명료하게 serialVersionUID값을 저장할 때 클래스 버전이 맞는지 확인하기 위한 용도입니다.
만약 직렬화할 때 사용한 serialVersionUID의 값과 역직렬화 하기 위해 사용했던
serialVersionUID값이 다르다면 InvalidClassException이 발생할 수 있습니다.


```

# 텍스트, 바이너리
- 자바에서 추상클래스로 이루어짐

## 텍스트
- 텍스트 파일을 보내고 나면 자원 해제를 꼭 해주어야 한다.


# 스트림의 특징
1. 파이프 구조 
- 스트림은 먼저 보내진 데이터가 먼저 도착한다. 
- 스트림은 데이터 발생지와 데이터 도착지에서 데이터의 순서가 바뀌지 않는다. 

2. 일방통행 구조 
- 출력 스트림은 출력 용도로만 사용되고 입력 스트림은 입력 용도로만 사용된다. 
- 양방향으로 데이터가 움직이기 위해서는 데이터를 내보내는 출력 스트림과 데이터를 가져오는 입력 스트림 두 개가 필요하다

3. 데이터 흐름의 추상화 
- 데이터를 보내는 측과 데이터를 받는 측의 형태가 어떠한 것이든 간에 그들 간의 데이터 흐름을 스트림을 통해서 추상화 할 수 있다


# 바이너리

# 입출력 계열
1. Node 계열 
- Node 계열은 입출력의 기본 처리를 가공되지 않은 데이터인 원시 데이터를 직접 처리하는 클래스 계열로 상위 클래스인 추상 클래스들이다. 
- FileInputStream, FileOutputStream: byte, 그림 등
- FilreReader, FileWriter: Char 계열(문자 등)
2. Filter 계열 
- Node Filter 계열만 사용해서는 비효율적으로 처리가 되기 때문에 계열로 데이터를 효율적으로 처리한다
## InputStream
- FileInputStream
- FilterInputStream
-  BufferedInputStream
- DataInputStream
- ObjectInputStream
## OutputStream
- FileoutputStream
- FilteroutptStream
- BufferedOutputStream
- DataoutputStream
- PrintStream
- ObjectoutputStream


## DataInputStream
- FileInputStream / FileOutputStream 과의 차이점은 자바 기본 자료형 데이터를 입/출력 할 수 있다는 것이다.
- FileInputStream / FileOutputStream 은 byte[] 단위의 데이터만 입/출력을 할 수 있었다.  하지만 DataStream Filter를 적용함으로써, 자바 기본 자료형(char, int, long, ...) 으로 데이터를 입력하고 출력할 수 있다
- 하지만 만약에 숫자 데이터를 읽어야 하는데 이 숫자 데이터를 읽기만 하면 문자나, 데이터 형식으로 읽을 수 밖에 없습니다. 그래서 코드상에서 읽고 쓸때 마다 항상 숫자 데이터로 변환을 해주야 하죠. 이렇게 데이터를 변환까지 해주어서 파일을 읽고 쓰는 클래스가 "DataInputStream", "DataOutputStream" 입니다.
- 왜냐하면 "DataOutputStream" 클래스는 스스로 파일과 연동할수 없기 때문에 "FileOutputStream" 클래스의 도움을 받습니다.  한가지 팁이라고 할것도 없지만 클래스 이름에 "File"이라고 붙어있어야 직접적으로 파일에 읽고 쓰는게 가능합니다. 즉, 이번에 배울 "DataInputStream"과 "DataOutputStream"은 직적접으로 파일에 읽고 쓸 수는 없습니다.
"readLine" 메소드도 있는데 이 메소드들은 원래는 한 라인씩 읽어 오는 메소드 인데, 자바에서는 사용하지 않기를 권장하고 있습니다.

# Buffered
1. 버퍼를 사용하는 이유는 빈번한 하드 디스크 접근을 막아 속도를 향상시킵니다.
2. "BufferedInputStream", "BufferedOutputStream"는 바이트 단위로 읽고 쓰고,                       "BufferedReader","BufferedWriter"는 문자를 읽고 씁니다. 
- 버퍼의 장점은 라인 단위로 스트링을 읽어들일 수 있고, 속도면에서 빠르다.


## BufferedInputStream
- 예를 들어서 CPU 랑 메모리의 성능이 아무리 좋다고 해도 하드 디스크의 입출력 늦다면 프로그램의 실행 성능은 하드 디스크의 처리 속도에 따라 맞춰갑니다. 네트워크도 느린 네트워크 환경이라면 컴퓨터의 성능이 좋더라도 메신저 또는 게임의 속도가 느려집니다. 이에 대한 완전한 해결책은 없는데요, 프로그램이 입출력 소스와 직접 작업하는 대신에 중간에 메모리 버퍼와 작업함으로써 실행 성능을 어느 정도 향상 시킬 수는 있습니다. BufferedInputStream 과 BufferedOutputStream은 바이트 기반의 성능 향상 보조 스트림이고, BufferedReader 와 BufferedWriter는 문자 기반 성능 향상 스트림입니다. BufferedInputStream과 BufferedReader :  BufferedInputStream은 바이트 입력 스트림에 연결되어서 버퍼를 제공해주는 보조 스트림입니다. BufferedReader는 문자 입력 스트림에 연결되어서 버퍼를 제공해주는 스트림입니다. 위의 스트림은 둘 다 입력 소스로부터 자신의 내부 버퍼 크기만큼 데이터를 미리 읽고 버퍼에 저장합니다. 생성자 매개값으로 준 입력 스트림과 연결되어 8918 내부 버퍼 사이즈를 갖습니다. BufferedInputStream bis = new BufferedInputStream(바이트 입력 스트림); //  최대 8912 바이트 BufferedReader br = new BufferedReader(문자 입력 스트림); // 최대 8912 문자



### BufferedInputStream 크기
- public BufferedInputStream(InputStream in) 주어진 바이트 입력 스트림에 대한 BufferedInputStream 객체를 생성하고, 내부 버퍼의 크기인 512 바이트로 설정합니다.
- public BufferedInputStream(InputStream in, int size) 주어진 바이트 입력 스트림에 대한 BufferedInputStream 객체를 생성하고, 내부 버퍼의 크기를 주어진 크기로 설정합니다.
- public BufferedOutputStream(OutputStream out) 주어진 바이트 출력 스트림에 대한 BufferedOutputStream 객체를 생성하고, 내부 버퍼의 크기인 512 바이트로 설정합니다.
- public BufferedOutputStream(OutputStream out, int size) 주어진 바이트 출력 스트림에 대한 BufferedOutputStream 객체를 생성하고, 내부 버퍼의 크기를 주어진 크기로 설정합니다

# Object
## Reader
  - BufferedReader
  - InputStreamReader
    - FileReader

# Object
## writer
- BufferedWriter
- OutputStreamWriter 
- FileWrite
  - PrintWriter 



## (1) File 클래스의 개요
- File 클래스는 시스템에 존재하는 자원에 접근하여 프로그램에서 오브젝트로 이용할 수 있는 클래스이다.
- File 클래스는 파일과 디렉토리에 관련된 메타데이터인 파일 생성, , , 파일명 읽기와 쓰기 모드, 파일 크기 등과 같은 처리 작업을 담당한다.


## (2) File 클래스의 주요 메소드 
- 가. createNewFile 메소드 createNewFile 메소드는 해당 파일을 생성해 주고 파일이 생성되면 true 를 반환한다. 
- 나. delete 메소드 delete 메소드는 해당 파일을 삭제한다. 
- 다. exists 메소드 exists 메소드는 해당 파일이 존재하는지를 판단한다. 
- 라. getParent 메소드 getParent 메소드는 해당 파일의 상위 디렉토리 이름을 반환한다. 
- 마. getName 메소드 getName 메소드는 해당 파일의 이름을 반환한다. 
- 바. getPath 메소드 getPath 메소드는 해당 파일의 경로를 반환한다. 
- 사. isFile 메소드 isFile 메소드는 파일인지를 판단한다. 
- 아. length 메소드 length 메소드는 파일의 크기를 바이트 값으로 반환한다. 
- 자. list 메소드 list 메소드는 파일 이름들을 반환한다. 
- 차. lastModified 메소드 lastModified 메소드는 파일이 마지막에 변경된 시각을 반환한다. 
- 카. mkdir 메소드 mkdir 메소드는 해당 이름의 디렉토리를 생성한다. 

# 경로 구분자
- \\ : 자바 내부적으로 돌아갈 때
- /: 웹쪽으로 연동한다는 느낌

# 바이너리 입출력
## FileInputStream
- 파일을 생성하지 못한다. 이미 있는 파일만 생성 가능하다.

### FileInputStream 클래스의 주요 메소드 
- A. finalize 메소드 finalize 메소드는 더 이상 참조하는 것이 없을 경우에 close 메소드를 호출한다.
- B. getChannel 메소드 getChannel 메소드는 FileChannel 클래스 인스턴스를 반환한다. 

## ByteArraylnputStream 클래스
- A. mark 메소드 mark 메소드는 스트림의 현재 표시된 위치를 설정한다. 
- B. reset 메소드 reset 메소드는 버퍼를 표시된 위치로 재설정한다


## SequencelnputStream 클래스
- SequencelnputStream 클래스는 여러 개의 입력 스트림을 하나의 입력 스트림으로 연결해서 데이터를 읽어온다. 
- SequencelnputStream 클래스는 각 입력 스트림의 끝에 도달할 때까지 읽는다. 
- SequencelnputStream 클래스는 해당 스트림을 닫고 자동으로 다음 입력 스트림으로 전환한다. 

### SequencelnputStream 클래스의 주요 메소드 
- A. read 메소드 read 메소드는 입력 스트림에서 다음 데이터의 바이너리를 읽는다. 
- B. close 메소드 close 메소드는 입력 스트림을 닫고 스트림과 연관된 시스템 자원을 해제한다.

## FileOutputStream
- FileOutputStream 클래스를 생성할 때에 지정한 경로에 파일이 없으면 자동으로 생성해 준다. (디렉토리는 제외하고)
- OutputStream 추상 클래스는 바이너리 출력 스트림의 최상위 클래스이다. 
- OutputStream 추상 클래스의 서브 클래스를 정의해야 하는 프로그램은 항상 바이너리의 출력을 기록하는 메소드를 최소한 하나는 제공해야 한다.

### OutputStream 추상 클래스의 주요 메소드 
- 가. write 메소드 write 메소드는 내용을 기록한다. 
- 나. flush 메소드 flush 메소드는 버퍼에 담겨 있는 데이터들을 호출한다. 
- 다. close 메소드 close 메소드는 스트림을 해제한다

### OutputStream 추상 클래스의 하위 클래스
### FileOutputStream 클래스
- ① FileOutputStream 클래스의 개요 FileOutputStream 클래스는 특정한 대상 파일로 바이너리 단위로 내용을 출력한다. 
- FileOutputStream 클래스를 생성할 때에 지정한 경로에 파일이 없으면 자동으로 생성해 준다. 
- FileOutputStream 클래스는 추가 처리를 위한 인자로 가지고 있으며 true로 설정되면 기존에 존재하고 있는 파일의 가장 뒷부분에 연결하여 출력된다. 

### 주요 메소드
- A. getChannel 메소드 getChannel 메소드는 OutputStream 추상 클래스와 연관된 FileChannel 클래스의 인스턴스를 반환한다. 
- B. getFD 메소드 getFD 메소드는 OutputStream 추상 클래스와 연관된 FileDescriptor 클래스의 인스턴스를 반환한다.

# 파일 만들기 예제
 * package jg.begin.start.jae_0313;
 * 
 * import java.io.File;
 * import java.io.IOException;
 * 
 * public class A {
 * 
 *   public static void main(String[] args) throws IOException {
 *     // 외부자원으로 연결하는 인스턴스는 무조건 로컬변수로 지정한다.
 * 
 *     File file = null;
 * 
 * //    file = new File("C:\\javaio\\jaetest11.txt");  // 둘다 가능
 *     file = new File("C:\\javaio", "jaetest11.txt"); // 둘다 가능
 *     file.createNewFile();
 *   }
 * 
 * }


## 파일 클래스 구현 후 파일 메소드 연습하기
 * package jg.begin.start.jae_0313;
 * 
 * import java.io.File;
 * import java.io.IOException;
 * import java.util.Date;
 * 
 * public class A {
 * 
 *   public static void main(String[] args) throws IOException {
 *     // 외부자원으로 연결하는 인스턴스는 무조건 로컬변수로 지정한다.
 * 
 *     File file = null;
 * 
 * //    file = new File("C:\\javaio\\jaetest11.txt");  // C:\\javaio 경로에 jaetest11.txt 파일 생성
 *     file = new File("C:\\javaio", "jaetest11.txt"); // C:\\javaio 경로에 jaetest11.txt 파일 생성; 위의 메소드와 동일
 *     file.createNewFile(); // 해당 파일을 생성해 주고 파일이 생성되면 true 를 반환
 *     // file.delete(); // 해당 파일을 삭제한다.
 * 
 *     System.out.println(file.getParent()); // 해당 파일의 상위 디렉토리 이름을 반환
 *     System.out.println(file.getPath()); // 해당 파일의 경로를 반환
 *     System.out.println(new Date(file.lastModified())); // 파일이 마지막에 변경된 시각을 반환한다
 * 
 *     if (file.exists()) { // 해당 파일이 존재하는지를 판단
 *       System.out.println("있다.");
 *     } else {
 * 
 *     }
 *   }
 * 
 * }

## 파일의 리스트 확인
 * package jg.begin.start.jae_0313;
 * 
 * import java.io.File;
 * import java.io.IOException;
 * import java.util.Date;
 * 
 * public class A {
 * 
 *   public static void main(String[] args) throws IOException {
 *     // 외부자원으로 연결하는 인스턴스는 무조건 로컬변수로 지정한다.
 * 
 *     File file = null;
 * 
 *     file = new File("C:\\javaio"); // C:\\javaio 경로에 jaetest11.txt 파일 생성; 위의 메소드와 동일
 * 
 *     // 파일의 리스트를 호출하고 1차원 배열에 저장한다.
 *     File[] files = file.listFiles();
 * 
 *     // 파일의 리스트를 반복한다.
 *     for (int i = 0, j = 0; i < files.length; i++) {
 * 
 *       // 파일의 마지막 글자 형태를 확인한다.
 *       if (files[i].getName().endsWith(".txt")) {
 *         System.out.println(j++ + 1 + " : " + files[i].getName());
 *       }
 * 
 *     }
 * 
 *   }
 * 
 * }


## inputstream 값 받기
 * package jg.begin.start.jae_0313;
 * 
 * import java.io.IOException;
 * import java.io.InputStream;
 * 
 * public class B {
 * 
 *   public static void main(String[] args) throws IOException {
 * 
 *     InputStream inputStream = System.in; // bufferedInputStream 출력됨.
 *     int num = inputStream.read() - 48;
 * //    char num = (char) inputStream.read();  // 타입을 입력과 출력 때 변경하는 것은 비효율적
 * 
 *     System.out.println(num);
 *     System.out.println(inputStream.read());  // 캐리지 리턴 13 출력
 *     System.out.println(inputStream.read());  // 캐리지 리턴 10 출력
 * 
 *   }
 * 
 * }
 * 

# 텍스트
- 자원해제를 반드시 해주어야 한다.
- Reader와 Writer는 장소를 기억한다.

## FileWriter
- AutoClose 기능 가지고 있음.

## Printwriter
- 서블릿에서 사용; Printwriter out
-  인코딩 성격도 같이 보내주기 때문에 좋음
- PrintWriter를 쓰기 위해선 close 필수, 메모리에서 해제되기 전에 값 저장 안됨.
- AutoClose기능을 가지고 있지만 반드시 close로 닫아줘야 한다는게 명시되어 있음.
- PrintWriter 클래스는 데이터를 포맷해서 파일로 기록하므로 설정된 인코딩로 함께 기록한다. 
- PrintWriter 클래스는 텍스트 출력 스트림에 대한 인스턴스의 인쇄 형식으로 표현하며 서블릿에서 사용한다. 
- PrintWriter 클래스의 메소드는 입출력 예외를 던지지 않으며 클라이언트 코드는 예외가 발생할 경우에는 checkError 메소드를 호출하여 조회할 수 있다.

### 웹 response view 생략
- PintWriter out = response.getWriter();
- out.println("이름: " + name + "<br/>");
- out.println("이름: " + subject + "<br/>");
- String file_name = filename;
- file_name = URLEncoder.encode(file_name, "UTF-8");
- out.println("파일명 : " + "<a href='./Download.do?file_name=" + file_name + "'>" + origfilename + "</a>");


### 주요 메소드
#### A. checkError 메소드 
- checkError 메소드는 스트림을 출력하고 오류 상황을 점검한다. 
#### B. print 메소드 
- print 메소드는 매개변수에 지정한 데이터를 출력한다. 


#### C. println 메소드 
- println 메소드는 행의 단락 캐릭터 라인을 기입하고 현재의 행을 종료시킨다. println 메소드는 Object 클래스의 인스턴스 동기화를 이루고 print 메소드와 println 메소드를 반환한다. println 메소드는 print 메소드와 같이 매개변수에 지정한 데이터를 출력한다. 


### D. write 메소드 
- write 메소드는 문자와 문자의 배열 그리고 캐릭터 라인을 기록한다.



## PrintWriter 예제
 * package jg.begin.start.jae_0313;
 * 
 * import java.io.BufferedWriter;
 * import java.io.File;
 * import java.io.FileWriter;
 * import java.io.IOException;
 * import java.io.PrintWriter;
 * 
 * public class C {
 * 
 *   public static void main(String[] args) throws IOException {
 *     File file = new File("C:\\javaio\\jae.html");
 * 
 *     FileWriter fileWriter = new FileWriter(file);
 *     // 버퍼링
 * 
 *     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
 *     PrintWriter out = new PrintWriter(bufferedWriter);  // 인코딩 성격도 같이 보내주기 때문에 좋음
 *     out.println("<marquee> 자바 정복 </marquee>");
 *     out.close(); // PrintWriter를 쓰기 위해선 close 필수, 메모리에서 해제되기 전에 값 저장 안됨.
 *   }
 * }


# Buffered
1. 버퍼를 사용하는 이유는 빈번한 하드 디스크 접근을 막아 속도를 향상시킵니다.
2. "BufferedInputStream", "BufferedOutputStream"는 바이트 단위로 읽고 쓰고,                       "BufferedReader","BufferedWriter"는 문자를 읽고 씁니다. 
- BufferedReader b_reader = new BufferedReader(f_reader, 1024)

## BufferedReader
- BufferedReader 클래스는 Reader 추상 클래스의 스트림에 버퍼 기능을 추가한다. 
- BufferedReader 클래스는 버퍼로부터 데이터를 차례대로 읽어 들이기 때문에 성능이 좋아진다. 
- BufferedReader 클래스는 문자행을 효율적으로 읽기위해서 문자를 버퍼링하며 버퍼 크기를 지정하거나 기본 크기를 사용할 수 있다. 
- 여기서 특이한 점은 "readLIne"이라는 메소드가 눈에 보입니다. "FileReader"에서는 볼수 없었던 메소드인데요. 의미는 한 라인씩 읽어 오는 메소드 입니다. 개행문자 "\n"을(줄바꿈 문자) 기준으로 읽어 온다고 생각하시면 됩니다.



## Scanner와의 차이
- Java를 처음 접하시는 분들이 주로 받는 입력방식은 Scanner입니다. Scanner를 통해 입력을 받을경우 Space Enter를 모두 경계로 인식하기에 입력받은 데이터를 가공하기 매우 편리합니다. 하지만 그에비해 BufferedReader는 Enter만 경계로 인식하고 받은 데이터가 String으로 고정되기때문에 입력받은 데이터를 가공하는 작업이 필요할경우가 많습니다. Scanner에 비해 다소 사용하기 불편하죠. 하지만 많은 양의 데이터를 입력받을경우 BufferedReader를 통해 입력받는 것이 효율면에서 훨씬 낫습니다. 입력시 Buffer 메모리줌으로써 작업속도 차이가 많이납니다.

## 선언법
 * BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
 * String s = bf.readLine(); //String
 * int i = Integer.parseInt(bf.readLine()); //Int
 * - 선언은 위에 있는 예제와 같이 하시면 됩니다. 입력은 readLine();이라는 메서드를 활용하시면 되는데요. 여기서 주의할점이 두가지가 있습니다. 첫번째는 readLine()시 리턴값을 String으로 고정되기에 String이 아닌 다른타입으로 입력을 받을려면 형변환을 꼭 해주어야한다는 점입니다. 두번째는 예외처리를 꼭 해주어야한다는 점입니다. readLine을 할때마다 try & catch를 활용하여 예외처리를 해주어도 되지만 대개 throws IOException을 통하여 작업합니다.




## Read 데이터 가공
 * - StringTokenizer st = new StringTokenizer(s); //StringTokenizer인자값에 입력 문자열 넣음
 * int a = Integer.parseInt(st.nextToken()); //첫번째 호출
 * int b = Integer.parseInt(st.nextToken()); //두번째 호출
 * 
 * 
 * String array[] = s.split(" "); //공백마다 데이터 끊어서 배열에 넣음
 * -  Read한 데이터는 Line단위로만 나눠지기에 공백단위로 데이터를 가공하려면 따로 작업을 해주어야하는데요. 위의 두가지 방법이 대표적입니다. 첫번째 방법으로는 StringTokenizer에 nextToken()함수를 쓰면 readLine()을 통해 입력받은 값을 공백단위로 구분하여 순서대로 호출할 수 있습니다. 두번째방법으로는 String.split()함수를 활용하여 배열에 공백단위로 끊어서 데이터를 넣고 사용하는 방식입니다.
 * 
 * 


## BufferedWriter
- BufferedWriter 클래스에는 플래시 기능이 구현되어 있기 때문에 플래시를 해주어야 데이터들이 최종적으로 대상으로 출력된다. BufferedWriter 클래스는 버퍼의 사이즈 보다 데이터를 더 많이 출력하면 플러시를 하지 않아도 자동으로 플러시 처리가 되면서 출력 스트림에 출력된 내용들이 대상으로 출력된
- 일반적으로 출력을할때 System.out.println(""); 방식을 사용하고는 합니다. 적은양의 출력일 경우 성능차이가 미미하겠지만 많은 양의 출력에서는 입력과 마찬가지로 Buffer를 활용해주시는것이 좋습니다.
### BufferedWriter 사용법
- BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
String s = "abcdefg";//출력할 문자열
bw.write(s+"\n");//출력
bw.flush();//남아있는 데이터를 모두 출력시킴
bw.close();//스트림을 닫음

- BufferedWriter 의 경우 버퍼를 잡아 놓았기 때문에 반드시 flush() / close() 를 반드시 호출해 주어 뒤처리를 해주어야합니다. 그리고 bw.write에는 System.out.println();과 같이 자동개행기능이 없기때문에 개행을 해주어야할 경우에는 \n를 통해 따로 처리해주어야합니다.


## 바이너리
- 초기값 0(공간이 비어있다.), 1 공간이 있음이 아닌 -1로 한다.

# 객체 입출력 클래스
- 객체 입출력 클래스는 인스턴스의 전달하는 클래스들이다. 
- (2) 객체 입출력 클래스의 특징 인스턴스 자체를 특정 대상에 입출력하기 위해서는 인스턴스를 파일이나 네트워크상으로 출력하면 인스턴스를 연속되는 바이트로 변경하여야 하며 이런 작업을 직렬화라고 하고 반대로 파일에 바이트로 저장되어 있는 자료를 읽어서 인스턴스로 변환하는 작업을 역직렬화라고 한다.
- 객체 스트림은 프로그램 메모리상에 존재하는 객체를 직접 입출력해 줄 수 있는 스트림으로 현재 상태를 보존하기 위한 영속성을 지원할 수 있다.
- 자바에서 객체 안에 저장되어 있는 내용을 파일로 저장하거나 네트워크를 통하여 다른 곳으로 전송하려면 객체를 바이트 형태로 일일이 분해해야 한다. 이를 위하여 객체를 직접 입출력 할 수 있도록 해주는 객체 스트림이다.


# 직렬화
- 자바 시스템간 객체나 데이터를 전달하기 위해 바이트로 바꿨다가 다시 객체로 바꾸는 기술입니다.
- 주의해야 할 점은 serialVersionUID는 자바 시스템간에 동일해야 하는데, 만약 따로 설정을 하지 않으면, 클래스의 기본 해쉬값을 사용합니다. ** 직접 세팅하지 않아도 자동으로 생성이 된다. 설정을 해주지 않게 되면 나중에 위의 클래스의 멤버변수의 변경이 일어나면 에러가 발생하기 때문에 직접 설정을 해주는 것이 좋습니다.
- 일반적으로 메모리에 생성된 오브젝트의 인스턴스는 비 지속성을가지므로 파일이나 데이터베이스에 저장된 자료처럼 지속성을 가지기 위해서 객체 직렬화 기능을 제공한다. 객체에 직렬화를 적용하면 메모리에 생성된 인스턴스 정보를 파일 등을 통해서 지속성을 유지할 수 있다. 지속성은 프로그램 내에 생성된 각종 객체들을 해당 프로그램 종료 이후에도 존재하게 만들어서 프로그램에서 계속 사용할 수가 있다.
- 객체 - 바이트배열 - 파일/메모리/데이터베이스
- Serializable 인터페이스로 구현한 클래스 파일은 객체 직렬화가 가능하다. 일반적으로 인터페이스에는 추상 메소드가 있어서 구현한 클래스 파일에서 반드시 메소드를 구현해야 하지만 Serializable 인터페이스는 추상 메소드가 없는 인터페이스로 단지 마킹 기능을 가지는 용도로 사용하는 마커 인터페이스이다. 
- Serializable 인터페이스를 구현한 클래스는 클래스의 인스턴스 변수에 저장된 데이터의 영속성을 위해서 파일이나 네트워크로 전송할 수 있다. 대부분의 는 모두 직렬화가 가능한 클래스들이다 
- API . Serializable 인터페이스 구현한 클래스에 존재하는 모든 변수들은 직렬화 대상이 된다. String 클래스는 Serializable 인터페이스를 구현하고 있기 때문에 문자열 직렬화가 기능하다. 
- Serializable 인터페이스에서 특정 인스턴스를 직렬화 대상에서 제외하고 싶으면 인스턴스 앞에 transient 키워드를 지정하면 된다.

## 직렬화 형태
- //바이너리 단위로 데이터를 출력하고 파일을 생성한다. FileOutputStream fileOutput = new FileOutputStream(file);
- //인스턴스를 객체 직렬화로 출력한다. ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

# 역직렬화
- Serializable 인터페이스에서 상속받은 Externalizable 인터페이스를 구현한다. 
- ② 인터페이스의 개요 Externalizable Externalizable 인터페이스로 구현한 클래스에서는 readExternal 메소드와 writeExternal 메소드에서 정의한 인스턴스만이 역직렬화의 대상이 된다. 
- ③ 인터페이스의 구현 Externalizable 객체를 역직렬화하고 생성된 객체를 호출한다.





## File 예제
1. fileOutputStream = new FileOutputStream("D:\\javaio\\menber.dat"); 
  - 이런식으로 쓰거나
2. File file = new File("D:\\javaio\\serialization", "serialization.dat");
//데이터를 입력하고 파일을 생성한다. 
FileInputStream fileInput = new FileInputStream(file);
- 파일을 미리 만들어놓고 넣어주기 가능.



##  역직렬화 메소드
 * public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException{ 
 * name = in.readUTF( ); 
 * age = in.readInt( ); 
 * }  // 이렇게 메소드 안에 역직렬화 내용을 넣어주어야 함; get-set 사용 불가
 * 
 * public void writeExternal(ObjectOutput out) throws IOException { 
 * out.writeUTF(name); 
 * out.writeInt(age); 
 * } 

# ObjectInputStream, ObjectOutputStream 예제

1
1. 반드시 모델에 담아둬라
2. try/catch 문은 각각 하나씩 만들어 둬라.(나중에 close 대비)

 * package jg.begin.start.jae_0314;
 * 
 * import java.io.File;
 * import java.io.FileInputStream;
 * import java.io.FileNotFoundException;
 * import java.io.IOException;
 * import java.io.ObjectInputStream;
 * import java.io.ObjectOutputStream;
 * 
 * public class MemberSelect {
 *   public static void main(String[] args) {
 * 
 *     File file = null;
 *     file = new File("C:\\javaio", "membertable1.dat");
 * 
 *     try {
 *       FileInputStream fileInputStream = new FileInputStream(file);
 *       try {
 *         ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
 *         try {
 *           MemberDTO memberDTO = (MemberDTO)  objectInputStream.readObject();  // 1. 반드시 모델에 담아둬라
 *           System.out.println(memberDTO.getAge());
 *         } catch (ClassNotFoundException e) {
 *           // TODO Auto-generated catch block
 *           e.printStackTrace();
 *         }
 *       } catch (IOException e) {
 *         // TODO Auto-generated catch block
 *         e.printStackTrace();
 *       }
 * 
 *     } catch (FileNotFoundException e) {
 *       // TODO Auto-generated catch block
 *       e.printStackTrace();
 *     }
 *   }
 * 
 * }

 * 2 모델
 * package jg.begin.start.jae_0314;
 * 
 * import java.io.Serializable;
 * 
 * public class MemberDTO implements Serializable {
 *   /**
 *    * 
 *    */
 *   private static final long serialVersionUID = 1L;
 *   private String name;
 *   private int age;
 * 
 *   public MemberDTO(String name, int age) {
 *     super();
 *     this.name = name;
 *     this.age = age;
 *   }
 * 
 *   @Override
 *   public String toString() {
 *     return "MemberDTO [name=" + name + ", age=" + age + "]";
 *   }
 * 
 *   public String getName() {
 *     return name;
 *   }
 * 
 *   public void setName(String name) {
 *     this.name = name;
 *   }
 * 
 *   public int getAge() {
 *     return age;
 *   }
 * 
 *   public void setAge(int age) {
 *     this.age = age;
 *   }
 * 
 * }


# 서버-클라이언트
- 가. 서버 클라이언트에서 작업의 요청이 들어오면 요청을 처리하고(응답) 결과를 클라이언트에게 알려 준다.(서버가 클라이언트에게 요청)
- 나. 클라이언트 서버에게 작업을 요청하고 그 작업의 결과를 받아서 보여준다
- 서버의 응답: 404, 202 등등; 한번 서버가 응답하고 나서는 이후는 클라이언트의 요청만 계속 이뤄진다.

# 소켓
- 네트워크 소켓(network socket)은 컴퓨터 네트워크를 경유하는 프로세스 간 통신의 종착점이다. 오늘날 컴퓨터 간 통신의 대부분은 인터넷 프로토콜을 기반으로 하고 있으므로, 대부분의 네트워크 소켓은 인터넷 소켓이다. 네트워크 통신을 위한 프로그램들은 소켓을 생성하고, 이 소켓을 통해서 서로 데이터를 교환한다. 소켓은 RFC 147에 기술사항이 정의되어 있다.
- 포트를 이용하기 위해 사용하는 것
- 소켓은 서버가 로컬 IP를 가지고 Port를 열고(Bind) 클라이언트 접속을 기다립니다. (Listen) 그리고 클라이언트는 서버의 IP주소와 Port로 접속(Connection)해서 연결되면, 서버와 클라이언트는 Send, Recieve형태로 패킷을 주고받습니다. 서로의 통신이 끝나면 close로 접속을 끊습니다.
 - 저, 서버는 소켓(Socket)을 생성하여 포트(Port)와 연결하며 이를 Bind(묶다)라 한다. 그리고 포트에서 클라이언트의 접속을 기다리는데 이를 Listen(듣다)이라 한다. 서버는 클라이언트가 소켓을 붙이려하면 이를 Accept(수용하다)하여 접속을 허가한다. 이때부터 클라이언트의 요청(Send)을 서버는 받아(Receive)주며 통신이 성사된다.


## 인터넷 소켓 요소
- 인터넷 프로토콜 (TCP, UDP, raw IP)
- 로컬 IP 주소
- 로컬 포트
- 원격 IP 주소
- 원격 포트

## 인터넷 소켓 종류
- UDP 프로토콜을 사용하는 경우
- TCP 프로토콜을 사용하는 경우

# 컬렉션의 구조
## Collection: 자바의 주소를 사용; 순서나 집합적인 저장 공간
- Collection보다 Map의 속도가 더 빠르다
- 대표적 예: 리스트, 튜플
* 필드에 Collection이 불가피하게 필요할 때는 어떠한 방법을 사용할까? Java에서는 synchronized 키워드를 사용하여 스레드 간 race condition을 통제한다. 이 키워드를 기반으로 구현된 Collection들도 많이 존재한다. List를 대신하여 Vector를 사용할 수 있고, Map을 대신하여 HashTable을 사용할 수 있다. 하지만 이 Collection들은 제공하는 API가 적고 성능도 좋지 않다.
* 기본적으로는 Collections라는 util 클래스에서 제공되는 static 메소드를 통해 이를 해결할 수 있다. Collections.synchroziedList(), Collections.synchroziedSet(), Collections.synchroziedMap() 등이 존재한다. JDK 1.7 부터는 concurrent package를 통해 ConcurrentHashMap이라는 구현체를 제공한다. Collections util을 사용하는 것보다 synchronized 키워드가 적용된 범위가 좁아서 보다 좋은 성능을 낼 수 있는 자료구조이다.


1. List; 순서가 있는 저장 공간
  - List와 Set 모두 인덱스로 접근하지만 Set만 중복을 허용 X
- 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하
- 1-1. LinkedList
- 1-2. Stack
- 버퍼가 스택구조로 되어있음.
- 1-3. Vector; 동기화 보장
- 열거형
- java 1.0부터 이어져온 List객체, ArrayList가 상위호환(?)이라 잘 안쓴다. 특히 쓰레드의 개수와 상관없이 동기화(synchronize) 처리를 하므로 Thread-safe 하지만 싱글쓰레드 환경이어도 동기화처리를 하므로 성능이 좋지 않아 쓰이지 않는다.

- 1-4. ArrayList; 동기화 보장 안함
- 대신 내부적으로 배열(array) 구조를 이용하기때문에 데이터 추가/제거를 배열을 복사하는 방법으로 처리하기 때문에 추가/제거가 많을 경우 오버헤드가 많이 발생함. 특히 중간에 삽입될 때 데이터들이 뒤로 밀리면서 성능저하가 큼.
- 대신! 인덱스를 가지로 있어서 조회할 때 한 번에 접근이 가능하기 때문에 대용량 데이터를 한 번에 가져와서 여러번 참조해 사용할 때 최상의 성능을 내는 객체다. (+크기 조절이 마음대로..)




2. Set; 집합적인 저장 공간
  - List와 Set 모두 인덱스로 접근하지만 Set만 중복을 허용 X
- 저장 순서가 없다고 하는건 0부터 차례대로 증가하지 않는다는 뜻이지 저장되고 나면은 그 값이 고정된다. 
2-1. HashSet
- 가장 빠른 임의 접근 속도
- 순서를 전혀 예측할 수 없음
2-2. SortedSet
- 2-2-1 TreeSet
-  정렬된 순서대로 보관하며 정렬 방법을 지정할 수 있음



## Map: 시스템의 주소를 사용; 키와 값으로 데이터 핸들
- Collection보다 Map의 속도가 더 빠르다
- 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합이다.
-  순서는 유지되지 않고, 키는 중복을 허용하지 않으며 값의 중복
- 대표적 예: 딕셔너리
1. Hashtable; 동기화 보장하는 Map계열의 클래스
- HashMap 보다는 느리지만 동기화가 지원
- 키와 값으로 null이 허용되지 않음
2. HashMap; 동기화 보장하지 않는 Map 계열의 클래스
- 중복을 허용하지 않고 순서를 보장하지 않음
- 키와 값으로 null이 허용
3. SortedMap; 정렬을 위한 Map 계열의 클래스
- 3-1: TreeMap
- 이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장
- 정렬된 순서로 키/값 쌍을 저장하므로 빠른 검색이 가능
- 저장시 정렬(오름차순)을 하기 때문에 저장시간이 다소 오래 걸림
 

## 컬렉션의 특징
- 컬렉션을 사용하는 이유 중의 하나는 정렬과 같은 자료와 관련된 작업을 하기 위해서이다.
- 컬렉션은 하나의 컬렉션에 서로 다른 자료형을 저장 할 수 있으며 참조 자료형만 저장 가능하다.
- Collection 인터페이스 계열은 내부에 포함되는 요소는 순서를 가지는 특징을 가지고 있으며
- 이와 반대로 포함 요소가 순서에 관계없이 저장되는 것은 Map 인터페이스 계열이다.
- 원시 자료형은 Wrapper 클래스를 이용하거나 오토박싱으로 저장할 수 있다.
- 컬렉션은 다양한 형식의 자료구조가 제공되며 컬렉션의 크기는 size 메소드를 사용하여 구한다.
- 컬렉션으로 자료형을 교체할 때는 해당 컬렉션을 대표하는 인터페이스를 사용하는 것이 좋다.
- 배열과 컬렉션은 다음과 차이를 가지고 있다


## 배열과 컬렉션의 차이
- 배열은 단 하나의 자료형만 저장한다.  컬렉션은 복수의 자료형을 저장한다. 
- 하지만 컬렉션에서도 Generic을 사용하게 되면 배열과 비슷해질 수 있는데 <> 사이에 모델 클래스 값을 넣어주기 가능.
- 배열은 고정된 크기로 크기 변동이 불가능하다. 컬렉션은 가변적 크기로 크기가 정해져 있지 않다.

## 컬렉션 공통 메소드
- 가. add 메소드 add 메소드는 매개변수로 지정된 요소를 컬렉션에 추가한다. 
- 나. addAll 메소드 addAll 메소드는 매개변수로 지정된 컬렉션에 존재하는 모든 요소를 컬렉션에 추가한다. 
- 다. contains 메소드 contains 메소드는 매개변수로 지정된 인스턴스 요소가 컬렉션에 존재하는지를 판단한다. 
- 라. isEmpty 메소드 isEmpty 메소드는 컬렉션이 비어 있는지를 판단한다. 
- 마. remove 메소드 remove 메소드는 컬렉션에서 매개변수로 지정된 요소 인스턴스 제거한다. 
- 바. removeAll 메소드 removeAll 메소드는 매개변수로 지정된 컬렉션에 포함되어 있는 모든 요소들을 제거한다. 
- 사. size 메소드 size 메소드는 요소의 개수를 반환해 준다


## Collection에 Generic을 쓰게된 이유
 * package jg.begin.start.jae_0315;
 * 
 * import java.util.ArrayList;
 * 
 * public class A {
 * 
 *   public static void main(String[] args) {
 *     ArrayList arrayList = new ArrayList();
 * 
 *     B b = new B("전우치", 22);
 * 
 *     arrayList.add("홍길동");
 *     arrayList.add(33);
 *     arrayList.add(b);
 * 
 *     System.out.println(arrayList);
 * 
 *     String string = (String) arrayList.get(2);  // String형이 아니라 오류가 난다.
 *     System.out.println(string);
 *   }
 * }

# ① Iterator 인터페이스의 개요 
- Iterator 인터페이스는 특정 컬렉션의 요소를 순차적으로 접근할 수 있게 지원한다. 
- Iterator 인터페이스는 전 방향으로만 이동하면서 요소 작업한다.

# ② Iterator 인터페이스의 주요 메소드 
- A. hasNext 메소드 hasNext 메소드는 반복 처리로 한층 더 요소가 있는 경우에 true를 반환한다. 
- B. next 메소드 next 메소드는 반복 처리로 다음의 요소를 반환한다. 
- C. remove 메소드 remove 메소드는 반복자에 의해 마지막에 반환된 요소를 삭제한다. 


# 컬렉션 for문
for (Iterator 인스턴스 = collection.iterator( ); iterator.hasNext( );) { 
클래스 자료형 인스턴스 = [(클래스 자료형)] iterator.next( ); 
}


# ① Enumeration 인터페이스 
- A. Enumeration 인터페이스의 개요 Enumeration 인터페이스는 저장된 컬렉션을 열거하여 순서대로 반복한다. List 인터페이스 계열 중에서 Vector 클래스에서만 사용이 가능한다. 
- B. Enumeration 인터페이스의 주요 메소드 
- ㉮ hasMoreElements 메소드 hasMoreElements 메소드를 이용해서 데이터가 있는지를 검사하고 존재하면 true이고 없으면 false이다. 
- ㉯ nextElement 메소드 nextElement 메소드는 열거에 한개 이상의 요소가 남아 있는 경우에는 다음의 요소를 반환한다 

# 열거 While문
- while(Enumeration 인스턴스.hasMoreElements( )) { 
클래스 자료형 인스턴스 = [(클래스 자료형)] en.nextElement( ); }

## TreeSet
* 중복값 제거, 자동정렬

## HashTable
-  키의 값은 무조건 “” 사이에 넣는다; hashtable.put("name", name); 
- Hashtable<String, String> hashtable = new Hashtable<String, String>();
  -   hashtable.put("name", "홍길동");  // 앞에있는 name은 매개변수이고 '홍길동'은 매개변수의 값이 된다.

## HashMap 수정
-   ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>(); // 인덱스 없는 Hashmap과 키검색이 없는 ArrayList 상호보완
- HashMap<String, String> hashMap = new HashMap<String, String>();
- hashMap = arrayList.get(i);
- hashMap.replace("email", "2");  // hashmap 전체로 해서 앞에는 key값 뒤에는 value로 수정
- arrayList.set(i, hashMap); // set으로 해당 인덱스에 hasmMap 넣어주기



## 딕셔너리
- ‘’나 “” 둘다 가능하다. 하지만 일반적으로 ‘’를 많이 사용한다.
- 딕셔너리는 json방식과 유사하다. 하지만 json은 무조건 “”을 사용한다.

## json
- 딕셔너리는 json방식과 유사하다. 하지만 json은 무조건 “”을 사용한다.


# 동적 객체
- 메소드, 함수; 정적객체로 사용 불가(=매개변수로 받을 수 없다.)
- 속도가 떨어지고 즉각 반응하기 힘들다.(그래프 만드는 것 같은 작업이 필요한 것들은 프로토타입 형식을 사용한다.)

# 람다식
- 1회성 이지만, 함수를 매개변수로 쓰겠다; 익명으로 쓰지만 이름을 부여해도 상관 없다.
- sum(5,7) 처럼 함수의 이름 사용하지 않고(익명) 표현식으로 표현 -> 5+7
- R과 자바스크립트(클로저)는 프로토타입이 기본이라 복제 기능이 있어 람다식 자체가 의미가 없다.
- # 클로저; F( f() )
- 람다식은 나중에 실행될 목적으로 다른 곳에 전달될 수 있는 코드 블록이다. (= 매개변수) 
- 람다식을 이용하면 함수가 필요한 곳에 간단히 함수를 보낼 수 있다. (=매개변수)
- 람다식은 간단하게 정의하면 프로그래밍에서 식별값 없이 실행 할 수 있는 함수 표현 방법으로 Ruby, C#, Python .
- 2014 Java 8 . 년에 발표된 에 포함된 람다식은 메소드를 변수처럼 사용할 수 있는 개념이다 람다식은 식별자 없이 실행 가능한 메소드 표현식이므로 이름이 없는 익명 메소드를 의미한다. 람다 표현식이 도입되면서 함수형 언어와 비슷한 코드를 작성하는 게 가능해졌다

## 람다식 특징
- ① 입력에 의해서만 출력이 결정되도록 순수한 함수를 표현할 수 있게 되었다. 
- ② 람다식으로 표현함으로써 익명 함수를 정의할 수 있게 되었다.


## 람다식 장점
1. 가. 코드의 라인수가 줄어든다. 자바의 형식적인 특성을 감소시킬 수 있는 큰 장점이다. 
2. 나. 병렬 프로그래밍이 가능하다. 함수형 프로그래밍에서는 반복대상을 사용자코드에서 직접 지정하지 않으므로 이로 인해 컬렉션 API . 가 크게 효과적으로 개선되었다 
3. 다. 메소드로 행동방식을 전달할 수 있다. 람다식에서는 행동방식 그 자체를 구현하여 전달한다. 
4. 라. 의도의 명확성을 가지므로 가독성을 높인다. 람다식을 사용하면 의도를 명확하게 하고 버그가 적은 코드를 작성할 수 있다


## 람다식 형식
 * - 형식 ([ ]) -> { body( ;) } 파라미터 리스트 실행문 // ‘->’는 힙에 있는 객체 참도할 때 사용
 * ## 람다식 예제
 * package jg.begin.start.jae_0318;
 * 
 * public class A {
 * 
 *   public static void main(String[] args) {
 * 
 *     new Thread(new Runnable() {
 * 
 *       @Override
 *       public void run() {
 *         System.out.println("익명");
 * 
 *       }
 *     }).start();  // 익명으로 이렇게 사용할 필요 없다.
 * 
 *     new Thread(() -> System.out.println("람다")).start();
 *   }
 * }


## 람다식의 매개변수
### 가. 자료형의 선언 
- 람다식에서 매개변수의 자료형을 선언한다. 
- ☞예시 (int a) ->{System.out.println(a);}; 
- 매개변수의 자료형은 런타임 시에 대입되는 값에 따라 자동으로 인식되므로 때문에 람다식에서는 매개변수의 자료형을 일반적으로 언급하지 않는다.
- ☞예시 (a) ->{System.out.println(a);}; 


### 나. ( )( ) 퍼렌씨시스 의 생략 
- 하나의 매개변수만 있다면 ( )( ) . 퍼렌씨시스 를 생략할 수 있다 하나의 실행문만 있다면 { } ( ) .
- ☞예시 a -> System.out.println(a); 
### (2) 매개변수의 미지정 
- 매개변수가 없다면 람다식에서 ( )( ) . 퍼렌씨시스 를 반드시 사용해야 한다 
- ☞예시 ( ) ->{System.out.println(a);}; 

### (3) 매개변수의 return 문 
- { }( ) 코드 블록 를 실행하고 결과값을 리턴 해야 한다면 return 문으로 결과값을 지정할 수 있다. 
- ☞예시 (a,b) ->{return a+b;};  
- 코드블록에 return 문이 있을 경우에는 람다식에서는 return 문을 사용하지 않는다. 
  - ☞예시 (a,b) ->a+b;

# 프로토타입 기반
## 일급 객체

## 일급 함수

## 함수형 프로그래밍
- 함수를 매개변수로 쓰겠다.
- math(5,6,min); min은 옵션값; 사실상 함수다.

### (3) 스트림의 주요 메서드 
- 스트림의 요소를 순회해야 한다면 forEach 메소드를 활용할 수 있다. 
- ☞예시 Arrays.asList(1, 2, 3).stream( ).forEach(System.out::println); 
- ::는 참조의 뜻

#### 예제
 * package jg.begin.start.jae_0318;
 * 
 * import java.util.Arrays;
 * 
 * public class A {
 * 
 *   public static void main(String[] args) {
 * 
 *     Arrays.asList(1, 2, 3).stream().map(i -> i *  i).forEach(System.out::println);  // 1, 4, 9 출력
 *   }
 * }


-------------------
# 스트림
* ArrayList<Socket> roomNumber = new ArrayList<Socket>();
* 입력 스트림 : 키보드/ 파일/ 프로그램으로 입력받고 프로그램을 도착지로 향하는 것이 입력 스트림입니다.
* 출력 스트림 : 프로그램을 출발지로 모니터/ 파일/ 프로그램으로 향하는 것이 출력 스트림입니다. 
* 스트림 클래스는 그림,멀티미디어,문자등 모든 종류의 데이터를 주고 받는 바이트 기반 스트림과 문자만 주고받을 수 있도록 특화된 문자 기반 스트림 2종류로 나눌 수 있습니다. 
* Inputstream, Outputstream | Reader, Writer
* DataInputStream과 DataOutputStream 은 FilterInputStream과 FilterOutputStream을 상속하고 있어, 객체 생성시에 InputStream과 OutputStream을 매개변수 인자로 가진다.
* FileInputStream / FileOutputStream 과의 차이점은 자바 기본 자료형 데이터를 입/출력 할 수 있다는 것이다.
  FileInputStream / FileOutputStream 은 byte[] 단위의 데이터만 입/출력을 할 수 있었다. 
  하지만 DataStream Filter를 적용함으로써, 자바 기본 자료형(char, int, long, ...) 으로 데이터를 입력하고 출력할 수 있다.
* 생성자: DataInputStream(InputStream in),  DataOutputStream(OutputStream out)
* ArrayList<Socket> roomNumber = new ArrayList<Socket>();

# 클래스

## 내부 클래스
* Outer 클래스에서 Inner 클래스 멤버 사용 불가능
* Inner in = new Inner(); // 원형 : Exam03.Inner in = this.new Inner();
*  내부클래스 역시 외부클래스 입장에서 보면 멤버. 내부클래스도 나름의 속성과 기능을 가지고 있기 때문에 외부클래스를 new로 생성후 내부클래스도 다시 new로 생성해줘야한다.
  - 인스턴스 클래스
  	지역 변수와 같이 선언됨
  - 스태틱 클래스  
  	지역 변수와 같이 선언됨
  - 지역 클래스  
    지역 클래스: 메인 메소드 안에 들어있는 클래스.지역클래스는 컴파일러가 읽고나면 바로 변수가 사라지는 (지역변수의 특성) 특성을 가지고 있기 때문에 새로 생성되어 메인 내에서 사용되어야한다.
  - 익명 클래스 / 무명클래스 / Anonymous
    익명클래스(무명클래스, Anonymous) - 지역클래스의 일부 : 한방에 만들면서 쓴다.
    클래스명 정의를 안하는데 클래스인지 어떻게 식별하나? 메소드를 담는건 클래스밖에 없으니 메소드가 내부에 있는것을 보고안다. 







