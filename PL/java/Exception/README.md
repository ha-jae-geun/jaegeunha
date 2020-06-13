# Error와 Exception... 에러와 예외...
```java
Error와 Exception은 같다고 생각할 수도 있지만, 사실 큰 차이가 있다.

- Error : 컴파일 시 문법적인 오류와 런타임 시 널포인트 참조와 같은 오류로 프로세스에 심각한 문제를 
야기 시켜 프로세스를 종료 시킬 수 있다.

- Exception : 컴퓨터 시스템의 동작 도중 예기치 않았던 이상 상태가 발생하여 수행 중인 프로그램이 영향을 받는 것.
예를 들면, 연산 도중 넘침에 의해 발생한 끼어들기 등이 이에 해당한다.

  프로그램이 실행 중 어떤 원인에 의해서 오작동을 하거나 비정상적으로 종료되는 경우를 프로그램 오류라 하고, 
  프로그램오류에는 에러(error)와 예외(exception) 두 가지로 구분할 수 있다. 
  에러는 메모리 부족이나 스택오버플로우와 같이 발생하면 복구할 수 없는 심각한 오류이고, 
  예외는 발생하더라도 수습할 수 있는 비교적 덜 심각한 오류이다. 이 예외는 프로그래머가 적절히 코드를 작성해주면 
  비정상적인 종류를 막을 수 있다.

  Error의 상황을 미리 미연에 방지하기 위해서 Exception 상황을 만들 수 있다. java에서는 try-catch문으로 
  Exception handling을 할 수 있다.


  
```


# 예외처리
- 인터프리터 방식
- 예외(수행 안멈춤; 정상 종료) -> 에러(수행 멈춤; 비정상 종료) -> 오류
- 비정상종료하지 말고 정상종료시켜서 에러 이유를 알려줘라.
- try, catch; Exception e

## 예외처리
- finally가 아니면 try catch를 개별적으로 잘 안쓰게됨

## try catch 특징
1. catch문은 예외가 발생될때만 실행 되므로 읽을땐 없다고 봐도 무방함!(가독성이 증가한다!!!)
2. catch문은 오로지 throw 로만 이동이 가능하고, goto문으로도 불가능.
3. catch문은 여러개 만들수 있다.(오버로딩과 비슷?!?! 하다.) 
4. 예외가 발생할만한 코드가 try안에 있어야되는데 없으면 throw시 catch문을 못찾아 에러남
5. 또한, throw했는데 객체타입을 catch문에서 받아줄 수 없을때 에러남


## 스택 되감기
 * try-catch 문에서 try{}블럭안에서 함수가 불리고 그 함수에서 throw를 한다고 가정해보자.
 * 그럼 throw 를 하게 되면 어떻게될까?
 * 그냥 goto문처럼 이동하는것일까?
 * ex) 
 * void Func()
 * {
 *      //어쩌구저쩌구~
 *      int a;
 *      throw a; 
 * }
 * 
 * try{
 *     Func();
 * }catch( int i ){
 *      //어쩌구저쩌구~
 * } 
 *  
 * => 답은 X 아니다이다!
 * 스택프레임에 쌓여있던 try{}안에서 함수를 호출한 호출원을 찾아 자기 자신의 스택을 정리한다.
 * 이것을 스택 되감기(Stack Unwiding) 이라고 한다.


## try-catch문의 단점
1. 프로그램의 성능이 눈에 띄게 느려진다(스택되감기 기능만 생각해도 알만함~)
2. try-catch를 쓰게 되면서 프로그램 용량이 커지게된다.( 소스길이가 증가함 )
3. 전통적인 if-else 문을 모조리 바꿀 수 없다( 못바꾸는 예가 있다 )
4. 동적할당한 메모리가 해제안될 수 있다.( throw때문에 )
5. 템플릿에는 쓸 수 없다.( 예외 객체에 어디에 받아야 하는지 모르기때문!! )

## Checked Exception과 Unchecked Exception의 가장 명확한 구분 기준
- 은 ‘꼭 처리를 해야 하느냐’이다. Checked Exception이 발생할 가능성이 있는 메소드라면 반드시 로직을 try/catch로 감싸거나 throw로 던져서 처리해야 한다. 반면에 Unchecked Exception은 명시적인 예외처리를 하지 않아도 된다. 이 예외는 피할 수 있지만 개발자가 부주의해서 발생하는 경우가 대부분이고, 미리 예측하지 못했던 상황에서 발생하는 예외가 아니기 때문에 굳이 로직으로 처리를 할 필요가 없도록 만들어져 있다.
- 또한 예외를 확인할 수 있는 시점에서도 구분할 수 있다. 일반적으로 컴파일 단계에서 명확하게 Exception 체크가 가능한 것을 Checked Exception이라 하며, 실행과정 중 어떠한 특정 논리에 의해 발견되는 Exception을 Unchecked Exception이라 한다. 따라서 컴파일 단계에서 확인할 수 없는 예외라 하여 Unchecked Exception이며, 실행과정 중 발견된다 하여서 Runtime Exception이라 하는 것이다.
- 그리고 한 가지 더 인지하고 있으면 좋은 것이 있다. 바로 예외발생시 트랜잭션의 roll-back 여부이다. 기본적으로 Checked Exception은 예외가 발생하면 트랜잭션을 roll-back하지 않고 예외를 던져준다. 하지만 Unchecked Exception은 예외 발생 시 트랜잭션을 roll-back한다는 점에서 차이가 있다. 트랜잭션의 전파방식 즉, 어떻게 묶어놓느냐에 따라서 Checked Exception이냐 Unchecked Exception이냐의 영향도가 크다. roll-back이 되는 범위가 달라지기 때문에 개발자가 이를 인지하지 못하면, 실행결과가 맞지 않거나 예상치 못한 예외가 발생할 수 있다. 그러므로 이를 인지하고 트랜잭션을 적용시킬 때 전파방식(propagation behavior)과 롤백규칙 등을 적절히 사용하면 더욱 효율적인 애플리케이션을 구현할 수 있을 것이다.


## 예외 복구
 * int maxretry = MAX_RETRY;  
 * while(maxretry -- > 0) {  
 *     try {
 *         // 예외가 발생할 가능성이 있는 시도
 *         return; // 작업성공시 리턴
 *     }
 *     catch (SomeException e) {
 *         // 로그 출력. 정해진 시간만큼 대기
 *     } 
 *     finally {
 *         // 리소스 반납 및 정리 작업
 *     }
 * }
 * throw new RetryFailedException(); // 최대 재시도 횟수를 넘기면 직접 예외 발생 
 * - 예외복구의 핵심은 예외가 발생하여도 애플리케이션은 정상적인 흐름으로 진행된다는 것이다. 위 [리스트 1]은 재시도를 통해 예외를 복구하는 코드이다. 이 예제는 네트워크가 환경이 좋지 않아서 서버에 접속이 안되는 상황의 시스템에 적용하면 효율 적이다. 예외가 발생하면 그 예외를 잡아서 일정 시간만큼 대기하고 다시 재시도를 반복한다. 그리고 최대 재시도 횟수를 넘기면 예외를 발생시킨다. 재시도를 통해 정상적인 흐름을 타게 한다거나, 예외가 발생하면 이를 미리 예측하여 다른 흐름으로 유도시키도록 구현하면 비록 예외가 발생하였어도 정상적으로 작업을 종료할 수 있을 것이다.

## 예외처리 회피
 * public void add() throws SQLException {  
 *     ... // 구현 로직
 * }
 * - 위 [리스트 2]는 간단해 보이지만 아주 신중해야하는 로직이다. 예외가 발생하면 throws를 통해 호출한쪽으로 예외를 던지고 그 처리를 회피하는 것이다. 하지만 무책임하게 던지는 것은 위험하다. 호출한 쪽에서 다시 예외를 받아 처리하도록 하거나, 해당 메소드에서 이 예외를 던지는 것이 최선의 방법이라는 확신이 있을 때만 사용해야 한다.

## 예외 전환
 * catch(SQLException e) {  
 *    ...
 *    throw DuplicateUserIdException();
 * }

- 예외 전환은 위 [리스트 3]에서 처럼 예외를 잡아서 다른 예외를 던지는 것이다. 호출한 쪽에서 예외를 받아서 처리할 때 좀 더 명확하게 인지할 수 있도록 돕기 위한 방법이다. 어떤 예외인지 분명해야 처리가 수월해지기 때문이다. 예를 들어 Checked Exception 중 복구가 불가능한 예외가 잡혔다면 이를 Unchecked Exception으로 전환하여서 다른 계층에서 일일이 예외를 선언할 필요가 없도록 할 수도 있다.
- 이상으로 예외를 처리하는 3가지 방법을 알아봤다. 하지만 예외를 처리하는 방법보다도 초급 개발자가 가장 잊지 말아야 할 것은 예외를 잡고 아무런 처리도 하지 않는 것은 정말 위험한 행위라는 것이다. try/catch문으로 예외를 잡아놓고 catch를 비워두면 물론 컴파일 오류는 나지 않겠지만, 예외가 발생했을 때 그 원인을 파악하기가 어려워 개발은 물론 유지보수에 아주 치명적인 민폐를 끼치는 일이라고 생각한다. 따라서 어떤 처리를 해야 하는지 모르더라도 무작정 catch하고 무시하거나, throw해버리는 행위를 할 때는 더욱 신중해야 할 것이다


## 에러 발생 원인
1. 사용자의 잘못 입력 => 방지: # 유효성 검사 / 레이아웃 지정
- 1. 자바스크립트가 유효성 검사함. 2. HTML5에서는 자체적으로 유효성 검사

2. 개발자의 실수
- 로직 실수
- 데이터 잘못 입력
- 경로상의 공백
- 대문자 i와 소문자 l

## 예외 클래스
- Error 클래스는 어플리케이션에서 발생된 예외처리를 할 수 없는 심각한 에러와 관련된 부분이다. JVM . 에서 발생한 에러는 심각한 에러이므로 어플리케이션 내에서는 예외처리를 할 수 없다

## 계층구조
- Throwable 
- Exception; 자식들이 존재; 수정 가능
- 컴파일 체크; 개발자에게 문제가 있음.
- ClassNotFound Exception: 
1. 외래어가 없다. 라이브러리를 알아야 한다.
2. 상호 연결되는 라이브러리 연결점에 버전이 달라 결과값이 안나온다.
3. 소멸도 가능
- 언 컴파일 체크; 개발자에게 문제가 있음; 사용자의 문제가 더 크다.
- NullPointException; 
1. 디버그해서 값을 모두 확인해보아야함. (개발자의 공백도 여기에 들어감)
2. 인코딩
- Error; 자식들이 존재; 수행이 멈추는 것; 수정이 불가; 새로 짜야함
- Runtime Exception은 Excpetion이지만 수정이 불가한 것이다.

```java
예외 (Exception)

메서드가 해야 할 일을 수행할 수 없는 상황에 부딪혔을 때 예외 처리를 해줘야 한다.

자바는 오류 코드를 전파할 때 메서드 호출 연쇄를 사용하지 않는다.

* 적절한 예외 클래스를 고른다. (그냥 Exception 클래스를 잡는건 반드시 피할 것)

모든 예외는 Throwable 클래스의 서브클래스다. **

비검사 예외는 RuntimeException의 서브클래스다.

다른 예외는 모두 검사 예외다. * 개발자는 반드시 검사예외를 잡아내야 한다.

비검사 예외는 개발자가 만든 논리 오류를 나타낸다.

NullPointerException은 검사 대상이 아니다. 거의 모든 메서드가 NullPointerException을 던질 수 있기 때문이다.

따라서 NullPointerException을 잡기보다 null참조를 따라가지 않게 하는 것이 더 중요하다.

Integer.parseInt(str) 호출을 생각해보자

Integer.parseInt(str) 메서드는 str이 유효한 정수를 담고 있지 않으면 비검사 예외인 NumberFormatException을 던진다. 

한편 Class.forName(str)은 str이 유효한 클래스 이름을 담고 있지 않으면 검사 예외인 ClassNotFoundException을 던진다.

NumberFormatException은 Integer.parseInt를 호출하기 전까지는 예외가 나오는지 모르기 때문임.

예외 선언

public void write(Object obj,String filename) throws IOException , ReflectiveOperationException

throws 절을 사용하고 뒤에 메서드가 던질 수 있는 예외를 나열해야 한다.

* 오버라이드하는 메서드에서 그보다 범위가 좁은 예외만 던질 수 있다.

* 슈퍼클래스에서 메서드에 throws 절이 없으면 오버라이드하는 메서드에서는 검사 예외를 던질 수 없다.

예외 잡기

try블록 *****

try{

문장

}catch(예외클래스1 ex){

핸들러

}catch(예외클래스2 ex){

핸들러

}catch(예외클래스3 ex){

핸들러

}

try-with-resources 문

예외 처리의 문제점은 리소스 관리다. (예를들면 file open, close) *****중요

try (리소스타입1 res1 = init1; 리소스타입2 res2 init2; ..){

문장

}

각 리소스는 반드시 AutoCloseable 인터페이스를 구현하는 클래스에 속해야한다. * AutoCloseable 인터페이스에는
close() 메서드만 선언되어 있다.

* 리소스 초기화순서의 역순으로 닫힌다.

이렇게 하면 예외 발생 여부에 상관없이 자동으로 리소스를 닫는다. 

예외 다시 던지기, 연쇄하기

예외가 일어났을 때 무슨일을 해야하는지 모르더라도 로그로 찍고 싶을때가 있다. 이럴 때는 예외를
다시 던져서 적합한 예외 핸들러가 처리할 수 있게 해야한다.

try{

작업수행

}catch(Exception ex){

logger.log(level , message, ex);

throw ex;

}


```

## Compiled Checked 클래스 
- Complile Checked . 계열은 컴파일 시에 예외처리 유무를 검사하는 클래스 계열이다 Complile Checked 계열에서 발생하는 예외처리는 개발자들의 문제라기보다는 사용자의 작업에 의해서 발생하는 경우가 많다. 
- ① ClassNotFoundException 클래스 ClassNotFoundException 클래스는 클래스 이름을 입력했을 경우에 클래스가 존재하지 않으면 발생한다. 
- ② FileNotFoundException 클래스 FileNotFoundException 클래스는 시스템에서 파일을 검색할 때 사용자가 없는 파일 이름을 입력했을 경우에 발생한다. 
- ③ IOException 클래스 IOException 클래스는 시스템 상황에 따라 입출력에 대한 예외가 발생할 경우에 발생한다. 
- ④ SOLException 클래스 SOLException 클래스는 데이터베이스의 SOL . 처리 작업을 할 경우에 발생한다

## Exception Compile UnChecked 클래스의 계열 
- Compile UnChecked 계열의 예외들은 컴파일 시에 예외처리 유무를 검사하지 않으므로 에러가 발생하지 않는다. Compile UnChecked 계열의 예외들은 컴파일 타임에는 예외가 발생하지 않고 실행시에만 에러가 발생하는 예외들이다. 컴파일 시에 예외처리 유무를 검사하지 않는 이유는 대부분의 발생되는 예외가 개발자의 부주의한 코드 작업 때문에 발생하기 때문이다. 개발자의 부주의한 코드 문제들은 코드를 이용한 검증 작업으로 예외 발생을 제거할 수 있다

- ① NullPointerException 클래스 NullPointerException 클래스는 변수값을 초기화하지 않고 해당 오브젝트의 변수나 메소드를 호출하는 경우에 발생한다. 
- ② ArraylndexOutOfBoundsException 클래스 ArraylndexOutOfBoundsException 클래스는 배열의 인덱스가 참조하지 못할 때에 발생한다. 
- ③ ArithmeticException 클래스 ArithmeticException 클래스는 정수를 0으로 나누었을 때 발생할 수 있는 예외들이다

## IOException
- 비정상

## Exception 클래스의 주요 메소드 
- ① printStackTrace 메소드 printStackTrace 메소드는 예외에 대한 출처를 알려주고 해당 결과의 위치를 정확히 출력한다. 
- ② getMessage 메소드 getMessage 메소드는 한 줄로 요약된 정보로 예외를 출력한다. 
- ③ getStackTrace 메소드 getStackTrace 메소드는 printStackTrace 메소드의 단점을 보완하여 출력하며 반환값이 있다. 


### 메소드 예제
 * package jg.begin.start.jae_0312;
 * 
 * public class A {
 * 
 *   static int num;
 * 
 *   public static void main(String[] args) throws Exception {
 * 
 *     try {
 * 
 *       num = 3 / 0;
 * 
 *     } catch (ArithmeticException e) {
 * 
 *       System.out.println(e.getMessage());
 *       // 1. by zero라는 간단한 정보만을 보여줌 2. syso와 같이 쓰여야 함.
 *       System.out.println(e.getStackTrace()); // 주소에 대한 위치가 나옴; 거의 안씀
 *       e.printStackTrace(); // 자주 사용
 * 
 *     }
 *   }
 * }

## 예외처리 방법

1. 메소드
- 일괄처리; throws
- 개별처리; throw


2. 코드 블록
- try catch

3. 사용자 정의
- 상속을 통하여 개발자가 만드는 것.

## 외부 입출력
- 예외에 관계없이 자원해제를 해주어야 한다.
- try...catch...finally
- 예외의 발생유무와 상관 없이 finally는 작동; 자원해제를 목적으로 주로 사용함.

## 여러개의 catch
 * try { 예외 발생 코드 1; 예외 발생 코드 2; ⁝ 예외 발생 코드 N; } 
 * catch(하위 예외 클래스명1 변수명) { 예외처리 코드; }
 * catch(중위 예외 클래스명2 변수명) { 예외처리 코드; } 
 * catch(상위 예외 클래스명N 변수명) { 예외처리 코드; }
 * - 에러 발생의 원인은 첫 번째 catch 문의 코드 블록에서 모든 예외가 처리되기 때문에 에러가 발생된다.

### 예제
 * try {
 * num = 3 / 0; System.out.println( 문자열의 길이 " :" + name.length( )); } 
 * catch (NullPointerException nullPointerException) { 
 * System.out.println(nullPointerException.getMessage( )); } 
 * catch (ArithmeticException arithmeticException) { 
 * System.out.println(arithmeticException.getMessage( )); 
 * } catch (Exception exception) { 
 * System.out.println( 모든 예외처리 가능 " "); }





## finally 예제
 *  finally {
 *         // try 블록 안에 한꺼번에 close()를 써주게 되면 앞에 있는 close()에서 오류가 났을 경우,
 *         // 그 다음에 오는 close()를 실행하지 않고 예외를 던지기 때문에 각각 try 문을 써줘야 한다.
 *         try {rs.close();} catch (Exception e) {}
 *         try {stmt.close();} catch (Exception e) {}
 *         try {con.close();} catch (Exception e) {}
 *   }


# throw
1. throw 키워드 : 메소드 내에서 상위 { }( 코드 블록 ) 으로 예외처리를 전달한다 .
2. throws 키워드 : 메소드에서 상위 메소드로 예외처리를 전달한다 .

## throw 메소드 이용 예외처리
 * package jg.begin.start.jae_0312;
 * 
 * public class A {
 * 
 *   static int num;
 * 
 *   public static void thro(int num) throws Exception {
 * 
 *     if (num < 100) {
 *       throw new Exception("값이 100보다 적다.");
 *     }
 *   }
 * 
 *   public static void main(String[] args) throws Exception {
 * 
 *     thro(99);
 *   }
 * }


### 사용자 지정 오류
 * package jg.begin.start.jae_0312;
 * 
 * class UserException extends Exception {
 * 
 *   /**
 *    * 
 *    /
 *   // 내장되어있는 고유 ID = 클래스의 유일성 담보
 *   private static final long serialVersionUID = 1L;
 * 
 *   public UserException(String mes) {
 *     super(mes); // super에 ssss라는 값을 담아두고 상속
 *     // 상위 매개변수를 상속하며 상속하지 않으면 이 호출된다 mes null .
 * 
 *   }
 * 
 * }
 * 
 * public class UserDefined {
 * 
 *   public static void userEx(int num) throws UserException {
 * 
 *     if (num < 100) {
 * 
 *       throw new UserException("ssss");
 *     }
 *   }
 * 
 *   public static void main(String[] args) {
 *     try {
 *       userEx(70);
 * 
 *     } catch (UserException e) {
 *       e.printStackTrace();
 *     }
 *   }
 * }
 * 
 *   public UserException() {
 *     super("내가 만든 예외"); // 매개변수로 값을 안받고 super로 바로 쓰기 가능
 *   }
 * 
 * - 반드시 Exception 클래스를 상속받아야 되면 일반적으로 문자열을 저장할 수 있는 생성자를 구현한다. 문자열은 super 키워드를 이용해서 Exception 클래스에서 초기화한다.
 * 


## Exception 생성자
 * -   public Exception() {
 *         super();
 *     }


2. public Exception(String message) {
 *         super(message);
 *     }

3. public Exception(String message, Throwable cause) {
 *         super(message, cause);
 *     }
