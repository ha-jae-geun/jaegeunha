
# $
- 자바 템플릿: 모든 환경에 해당; ${ :import ( ) }


# ?
- 변수의 역할을 하면 와일드카드라고 인식.

## 바인드 변수
- 바인드 변수 중 하나; ?가 변수로 쓰일 때.

# =
* = 는 대입; x=1; 서로 다른 자료형이면 대입

# _ 
 * 원래의 용도에서 확장 되었다.
 * 저장은 되는데 검색이 안되어 _ 를 사용
 * 출력할 때는 안보이고 _ 없이 검색 가능
 * 밑줄 문자인 언더스코어는 컴퓨터에서 공백 문자를 대신하여 사용하기 위하여 고안된 기호로서 _( ) 아스키 코드 번에 해당한다.
 * ( ) 지금도 프로그램 등에서 변수의 이름처럼 공백을 쓰지 못하는 경우에 공백 문자를 대신하여 사용되고 있다.
 * JDK 7부터 제공하는 언더스코어 JDK 7 ( )로 정수 리터럴 값의 자릿수 구분을 위한 구분자로 사용한다. 

## -1
- 컴퓨터는 1과 0밖에 없다. 그래서 1과 0이 아닌 공간을 만들 필요가 있었는데 그래서 -1을 사용한다. 하지만 컴퓨터가 음수를 이해하는 것은 아니다. 음수는 보수를 통해 만들긴 하지만 컴퓨터 자체에 음수가 있는 것은 아니다.
- 바이너리 값은 초기값 0(공간이 비어있다.), 1 공간이 있음이 아닌 -1로 한다.
- 배열도 -1로 초기화 한다.



# ; 
 * 영역의 종료

# :
 * 영역의 변경
 * System.out.println("클래스 클래스다.");

# []
 * 리스트; 배열
- 자료를 확인한다 // 안의 내용이 변경될 수 있음.
- 브래킷 연산자는 배열 선언이나 리스트 자료형 선언에 사용된다. 
- 브래킷 연산자는 자료형을 확인한다고 생각하면 된다. 


# ()
* 무조건 실행; 타입 검증
* 동작한다; 
* 클래스(); // 클래스를 동작한다.
 * 튜플
- 자료를 검증한다. // 안의 내용이 변경될 수 없음
- 퍼렌씨시스 연산자는 특정 연산자들을 묶어서 먼저 처리할 수 있도록 만들어 준다. 
- 퍼렌씨시스 연산자는 자료형을 검증한다라고 생각하면 된다


# {}
 * 세트
 * 코드 블록 {} 
 * 네임 스페이스; public class A

# {키와 값]
 * 딕셔너리

# ‘’
 * 자바에서는 char 표시할 때 ‘’만 쓸 수 있다. 이유는 main 매개변수 string을 보면 this.value = "".value; 라고 표기되어있기 때문이다.

# ""
- String number = ""; 
- ⎼String 클래스형인 numbe 변수에 아무 값도 할당받지 않은 상태인 빈 문자열 ""를 할당하여 문자열을 저장할 임시 공간을 설정한다. 
- String number = " "; // 공백문자라고 함. 
- 파이썬에선 “”은 전달의 의미(대화);  ‘ ‘ 은 혼자 선언의 의미(방백)


# .
- 자기 자신을 뜻한다.
- b => ./b  // 자기 자신 폴더 의미

# /
-  실수형을 지원하지 않아 강제로 자료형 변환 필요
	- float div = (float) a / b; 

# ==(더블 이퀄)
- 일반적으로 수를 비교
- 문자열을 비교할 때는 equals 라는 메소드로 비교한다.

# &
- 파이썬에서는  and, or, not 을 논리 연산자로 쓰고  &는 보통 비트 연산자로 사용한다.


# |
 - 버티컬바 |( ) 연산자

# ~     - Tilde; 틸드
- ~숫자;  // +1 한 값 앞에 마이너스 기호 붙이기
- 컴퓨터에는 마이너스 개념이 없어서 2의 보수를 통해 표현

# ^
 - 서컴플렉스;  Circumflex 

# +
- 연결 연산자를 사용할 때 앞에 문자열이 있으면 뒤에 정수도 안더해진다. ( +를 연결 연산자로 인식)
- System.out.println(“ “ + 정수 + 정수)

# <
- 컴파일러가 직접 처리하라는 기호

# bin
* 디렉터리 bin ⎼자바 개발에서 실행하는데 필요한 도구와 유틸리티가 있다; begin의 약자라고 생각하면 쉬움(즉 실행시켜주는 파일)

# http
 * hyper: 뛰어넘다; text: 무작위로 선택할 수 있는 것; 목차에 관계없이 접근
* hyper: 정보가 동일선 상에 위치하지 않고 다중으로 연결 상태; text: 목차없이 접근; transfer: 메소드; protocol: 규약

# Mark
- %d 같은 것을 의미


# MVC
 * M(Model): 멤버 변수가 모여 있음
 * V(View)
 * C(Control): 유일하게 변경할 수 있음; ex) API

# null
 * 모든 참조 타입의 기본값;

# reflection
- 서로 다른 영역에서 객체를 공유할 수 있음.

## reflection 예제
1. ${}
2. Class.forName; 오라클의 JDBC를 자바에서 사용

# switch 문
 * 비순차적 문장
 * 머신러닝 같이 데이터 검출을 목표로 할 때는 if 문을 쓰는 것이 맞다. 순차적으로 모두 확인해야 한다.
 * :(영역 변경) 뒤에 {} 생략 가능; 파이썬 방식
 * 조건식에 따라 case 옆 자료형이 달라짐.
 * byte, short, char, int, string, enum 만 조건식에 들어갈 수 있음.
 * byte, short, char, int를 이용하여 접근할 때 다중 if 문보다 향상되어 있다.
 * JDK 1.7버전부터 지원하는 String 클래스 자료형이다. 
 * switch 문은 순서에 관계없이 선택할 수 있으며 위치 이동을 제어한다. 
 * switch 문은 case 문의 값은 각각 달라야 하고 값의 크기와 순서는 무관하다.
 * 다른말로 인덱스로 접근하지 않는다.

# URL, URI
* URI; 파라미터값 추가




# 가변
 * 값의 크기가 무관하다 = 가변적이다.
 * switch 문은 case 문의 값은 각각 달라야 하고 값의 크기와 순서는 무관하다.
 * 다른말로 인덱스로 접근하지 않는다.

# 객체지향
 * 클래스 기반: 힙 만들 때 ‘new’ 사용
 * 자바는 프로토타입 패턴에 의거하여 클래스, 배열, 열거(enum), interface 사용
 * 프로토타입 기반: 힙 만들 때 복제

# 디렉토리
* 폴더: 나 혼자 쓰는 것, 디렉토리: 다른사람도 접근할 수 있는 것

# 로그
 * 주석은 프로그램 실행에도 영향을 주지 않지만 로그에도 남지 않는다.

# 리터럴
* 참조 자료형(레퍼런스); 간접 접근; 주소값과 실제값으로 나뉘고 유저가 선택한 값을 ‘리터럴’이라고 함; 힙에 저장(자바의 new)
 * 실제값
* 원시 자료형의 변수는 실제 데이터를 리터럴로 저장한다. 참조 자료형의 변수는 실제 데이터가 저장된 주소로 저장한다. 참조 자료형의 자료값을 주소값이라고 한다.

# 메소드
- 메소드는 복제 기능이 없다(= 객체를 통해서 사용하는 것이 없다)
- 함수는 복제, 메소드는 상속을 통해 재사용성을 가진다.
- 데이터를 분석할 때는 함수가 좋고, 컴퓨터를 교육 시킬 때는 메소드가 좋다. 메소드가 재사용성이 훨신 좋기 때문이다.

# 무결성
- 중복된 데이터를 안쓰는 것을 확인


# 변수
 * 소문자 l형으로 변수 만들지 않는다. 대문자 I 와 헷갈린다. 
 * 다 소문자; 두개의 명사 붙일 때 _ 사용

# 브라우저
 * 인터넷을 이용해서 사용자에게 보여주는 그래픽 화면


# 생성
있는 것을 다시 만들어 낸다

# 선언
없는 것을 처음 생성

# 수행 > 실행
 * 런타임을 ‘수행’했다고 한다. 수행이 더 큰 개념.
 * 실행: 결과를 보여줌

# 스택, 힙
* 오브젝트: 스택에 저장
* 스택의 자료를 힙에 저장: new; 힙에 저장됨으로 인해 접근이 가능하다.(파이썬에서는 자동으로 new를 안써도 생성해줌)
* 인스턴스: 힙에 저장됨

# 식별자
 * 개발자가 사용하는 단어 <>예약어
 *  변수:  일반적으로 변수의 첫 글자는 소문자로 작성한다. 변수가 두 단어가 합쳐질 경우에는 두 번째 단어의 첫 문자를 대문자로 작성한다.

# 아스키 코드
 * 10번 \n  과 13번 \r이 합쳐지면 엔터
 * 48번 0;  65번 대문자 A
 *   ​char a = (char) System.in.read();
	 *  이 함수가 입력되는 것은 0-255까지의 아스키코드 값이므로 char형으로 받고 싶다면 형변환을 하여서 받아야한다.​모든 아스키코드는 char에 담을 수도 있고 데이터의 손실또한 없다는 겁니다.
- int i = System.in.read() - 48; // 사용자가 입력한 숫자로 변환하기 위해 48(0)을 뺌


# 예약어 = 키워드
 * 미리 만들어 놓은 단어; 식별자로 쓸 수 없음.

# 원격 네트워크
- 브라우저를 이용하지 않은 연동
- 브라우저를 이용한 연동은 ‘웹’이라는 말이 들어간다.


# 인덱스
 * switch 문은 case 문의 값은 각각 달라야 하고 값의 크기와 순서는 무관하다.
 * 다른말로 인덱스로 접근하지 않는다.

# 인스턴스
- 참조 자료형은 메모리상에 인스턴스(객체라고 하면 오브젝트와 헷갈림)가 있는 주소를 저장한다. 


# 인코딩
 * A라는 문자가 들어오면 같은 형태의 글꼴로 인식할 수 있도록 코드로 변환해 주는 것
 * 가변적, 고정적 모두 존재
 * UTF-8; 가변적 인코딩 방식; UTF-16; 고정적 인코딩 방식

# 주석
 * 프로그램 실행에도 영향을 주지 않지만 로그에도 남지 않는다.

# 지정어: 개발자가 임의로 지정할 수 있는 단어

# 진수
 * 16진수: 2진수로 표현하는 것을 가변적으로 변화; 공간 활용 위해 사용.
 * 8진수: 주로 이미지 표현을 위해 사용함.

# 추상화: 적절한 단어의 사용

# 폴더
* 폴더: 나 혼자 쓰는 것, 디렉토리: 다른사람도 접근할 수 있는 것

# 프로토타입 기반
* 프로토타입 기반: 복제를 통한 프로그래밍(자바의 인터페이스)


# 함수
- 메소드는 복제 기능이 없다(= 객체를 통해서 사용하는 것이 없다)
- 함수는 복제, 메소드는 상속을 통해 재사용성을 가진다.
- 데이터를 분석할 때는 함수가 좋고, 컴퓨터를 교육 시킬 때는 메소드가 좋다. 메소드가 재사용성이 훨신 좋기 때문이다.


# 힙, 스텍
* 오브젝트: 스택에 저장
* 스택의 자료를 힙에 저장: new; 힙에 저장됨으로 인해 접근이 가능하다.(파이썬에서는 자동으로 new를 안써도 생성해줌)
* 인스턴스: 힙에 저장됨



