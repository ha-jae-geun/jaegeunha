# annottion
* 이 어노테이션으로 인해 데이터의 유효성 검사 등을 쉽게 알 수 있고, 이와 관련한 코드가 깔끔해지게 됩니다.
* 일단 어노테이션의 용도는 다양한 목적이 있지만 메타 데이터의 비중이 가장 크다 할 수 있습니다.
* 메타-테이터(Meta-Data) : 데이터를 위한 데이터를 의미하며, 풀어 이야기하면 한 데이터에 대한 설명을 의미하는 데이터. (자신의 정보를 담고 있는 데이터)
* @ <-- 요놈은 기본적으로 컴파일러에게 이게 어노테이션이다라고 알린다. 

```java
 어노테이션의 용도 
 ⎼어노테이션은 크게 컴파일러 체크와 코드 분석을 위한 용도로 사용된다     .
 ⎼어노테이션의 컴파일러 체크는 컴파일 타임에 에러를 발생시켜 주어 개발자에서 위험 요소를 경고 해주거나 확인하는 목적으로도 사용된다. 
 ⎼어노테이션의 코드 분석은 메타데이터로서의 용도이며 메타데이터는 데이터에 대해 설명하는 데이터를 의미한다. 
 ⎼메타데이터로서 어노테이션의 효용을 가장 잘 느낄 수 있는 부분은 설정과 유효성 검사 부분이다 JEE .  


 ⎼어노테이션은 크게 다음과 같은 기능을 구현 할 수 있다. 
 ① 컴파일러를 위한 정보 ⎼주석이 오류를 감지 또는 경고를 억제하기 위해
 
1. 컴파일러에 의해 사용할 수 있다. ⎼컴파일러에게 코드 작성 문법 에러를 체크하도록 정보를 제공한다. 
 	예) @Override 어노테이션 ② 컴파일 시간 및 배포 시간 처리 
⎼소프트웨어 툴 등의 코드 파일 및 주석을 생성하기 위해 정보를 처리 할 수 있다 , 

2. XML . ⎼소프트웨어 툴이 빌드나 배치시 코드를 자동으로 생성할 수 있도록 정보를 제공한다. 
	예 설정 파일을 자동 생성 ) XML 
3. ③ 런타임 처리 ⎼일부 주석 런타임에 검사 할 수 있으며 실행시 특정 기능을 실행하도록 정보를 제공한다. 
	예 객체가 어플리케이션 내부에서 해야 할 역할 지정 등 ) (Servlet, Controller... ) 

(4) 어노테이션의 장점 
⎼어노테이션은 데이터에 대한 유효성 검사 조건을 어노테이션을 사용하여 클래스에 직접 명시함으로써 해당 데이터들에 대한 
유효 조건을 쉽게 파악할 수 있다. ⎼어노테이션은 코드의 코드가 깔끔해지고 어노테이션의 재사용도 가능해진다. 
① 코드의 가독성 증대 ⎼관련 코드 곁에 메타 데이터를 설정할 수 있으므로 코드의 가독성이 증대 된다. 
② 개발 효율성 증대 ⎼복잡한 스키마를 파악하지 않아도 되며 개발을 할 때 개발 툴과 컴파일러의 도움을 받을 수 있으므로 
XML 개발 효율성이 증대 된다. ⎼별도의 파서를 적용하지 않고도 간단히 런타임 시에 활용할 수 있는 편리함이 있다. 


(5) 어노테이션의 단점 
⎼어노테이션 처리 시 리플렉션을 통해 해당 클래스를 분석해야 하는 오버헤드가 있다. 
⎼어노테이션은 모듈이나 어플리케이션 전반적인 메타 데이터를 설정할 수 없다. 
⎼어노테이션의 범위는 클래스나 패키지 레벨로 한정되기 때문에 여러 클래스에 걸친 공통적인 설정이나 모듈 레벨 설정이 어렵다.
```

## Java에서 기본적으로 제공하는 어노테이션 종류
* Override
	* 선언한 메서드가 오버라이드 되었다는 것을 나타냅니다.
	* 만약 상위(부모) 클래스(또는 인터페이스)에서 해당 메서드를 찾을 수 없다면 컴파일 에러를 발생 시킵니다.
	* 따라서 만약 메서드가 슈퍼클래스와 매칭되지 않았으면 에러를 날려주지
* @Deprecated
	* 해당 메서드가 더 이상 사용되지 않음을 표시합니다.
	* 만약 사용할 경우 컴파일 경고를 발생 키십니다.
	* 해당 클래스/메소드 등은 더이상 지원하지 않으니 or  만들고 나니깐 별로 안좋은 부분이 많거나, 더 좋은 해결법이 생겼으니 사용하지 마시라는 의미야. 그럼에도 불구하고 네가 그걸 

* @SuppressWarnings
	* 선언한 곳의 컴파일 경고를 무시하도록 합니다.
* @SafeVarargs
	* Java7 부터 지원하며, 제너릭 같은 가변인자의 매개변수를 사용할 때의 경고를 무시합니다.
* @FunctionalInterface
	* Java8 부터 지원하며, 함수형 인터페이스를 지정하는 어노테이션입니다.
	* 만약 메서드가 존재하지 않거나, 1개 이상의 메서드(default 메서드 제외)가 존재할 경우 컴파일 오류를 발생 시킵니다.


## Annotation 선언위치(Placement)
* 어노테이션은 클래스, 인터페이스, 메소드, 메소드 파라미터, 필드, 지역변수 위에 위치할수있어.

## annotation 요소
```java
Annotation 요소 (Element)
자바 어노테이션은 값을 세팅할수있는 요소들을 가질수있는데  속성이나 파라미터 쯤이라고 볼수있지.
@Entity(tableName = "vehicles")
위에서는 tableName 이라는 이름의 요소를 하나 가지고있다는뜻이야. 값은 "vehicles" 이군. 

물론 아래와 같이 여러개의 요소를 가질수도있어.

@Entity(tableName = "vehicles", primaryKey = "id")
하나만 요소로 가질 경우 다음과 같이 짧게 줄여 쓸수도있지.

@InsertNew("yes")


```

## 메타 어노테이션
* 먼저 어노테이션의 구조를 보기 위해서 아래의 코드를 참고해 봅니다. (예를 위해 작성된 커스텀 어노테이션입니다.)
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
	boolean isCheck() default true;
}
```
* 먼저 1번, 2번의 어노테이션 선언에 쓰인 어노테이션은 메타 어노테이션(Meta Annotation)이라 하며 이를 이용해 커스텀 어노테이션을 작성할 수 있게 됩니다.

## 메타 어노테이션의 종류
```java
@Retention
자바 컴파일러가 어노테이션을 다루는 방법을 기술하며, 특정 시점까지 영향을 미치는지를 결정합니다.
종류는 다음과 같습니다.
RetentionPolicy.SOURCE : 컴파일 전까지만 유효. (컴파일 이후에는 사라짐)
RetentionPolicy.CLASS : 컴파일러가 클래스를 참조할 때까지 유효.
RetentionPolicy.RUNTIME : 컴파일 이후에도 JVM에 의해 계속 참조가 가능. (리플렉션 사용)


@Target
어노테이션이 적용할 위치를 선택합니다.
종류는 다음과 같습니다.
ElementType.PACKAGE : 패키지 선언
ElementType.TYPE : 타입 선언
ElementType.ANNOTATION_TYPE : 어노테이션 타입 선언
ElementType.CONSTRUCTOR : 생성자 선언
ElementType.FIELD : 멤버 변수 선언
ElementType.LOCAL_VARIABLE : 지역 변수 선언
ElementType.METHOD : 메서드 선언
ElementType.PARAMETER : 전달인자 선언
ElementType.TYPE_PARAMETER : 전달인자 타입 선언
ElementType.TYPE_USE : 타입 선언


@Documented
해당 어노테이션을 Javadoc에 포함시킵니다.


@Inherited
어노테이션의 상속을 가능하게 합니다.


@Repeatable
Java8 부터 지원하며, 연속적으로 어노테이션을 선언할 수 있게 해줍니다.


어노테이션은 기본적으로 인터페이스 형태를 취하고 있으며, 단지 interface 앞에 @ 표시를 해줍니다.
어노테이션의 필드에서는 enum, String이나 기본 자료형, 기본 자료형의 배열을 사용할 수 있습니다.
```
