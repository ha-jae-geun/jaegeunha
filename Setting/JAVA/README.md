# 자바 설치
- Java SE
- 대부분의 사람들이 자바 프로그래밍 언어를 떠올릴때 바로 이 플랫폼이 됩니다.  Java SE의 API는 자바 프로그래밍 언어의 핵심 기능들을 제공하기 때문입니다. 기초적인 타입부터 네트워킹, 보안, 데이터베이스 처리, 그래픽 사용자 인터페이스 개발은 물론 XML 파싱에 이르는 고수준의 클래스들을 모두 다룰 수 있습니다.
코어 API에 더하여 자바 SE 플랫폼에서는 가상 머신, 개발도구, 배포 기술 그리고 자바 기술을 사용하는 어플리케이션에서 일반적으로 사용되는 부가적인 클래스 라이브러리들과 툴킷까지 제공하고 있습니다.

- Java EE
- 자바 EE 플랫폼은 자바 SE 플랫폼을 기반으로 그 위에 탑재됩니다. 자바 EE 플랫폼에서는 대규모, 다계층, 확장성, 신뢰성 그리고 보안 네트워킹 어플리케이션의 개발과 실행을 위한 API 및 환경을 제공하고 있습니다.

- Java ME 
- 자바 ME 플랫폼에서는 모바일 폰과 같이 자바 프로그래밍 언어 기반의 어플리케이션이 보다 조그만 가상 머신으로 동작시킬 수 있는 기능과 API를 제공합니다. 물론 자바 SE API의 하부 구조로 API가 구성되어 있기 때문에 일관성 있는 개발이 가능하게 됩니다. 작은 장치에서 동작하는 자바 어플리케이션 개발에 필요한 전용 클래스 라이브러리들을 제공하며 자바 EE 플랫폼 서비스의 클라이언트 역할을 수행하게 될때도 있습니다.

- Java FX
- 경량 사용자 인터페이스 API를 사용하여 리치 인터넷 어플리케이션을 만들 때 사용됩니다. JavaFX 어플리케이션은 하드웨어 수준에서 가속기능을 사용할 수 있는 그래픽과 미디어 엔진을 갖추고 있어 보다 클라이언트의 성능에 신경을 써야하는 분야에서 사용하면 좋습니다. JavaFX 어플리케이션 또한 자바 EE 플랫폼 서비스의 클라이언트 역할을 담당할 수 있습니다. 

## (1) Java SE; 웹과 연동 안됨
* Java SE Development Kit 8 Downloads
* Windows X86: 32비트
  * 는 의 약자로 일반적인 프로그램 개발을 위한 플랫폼이다 SE Java Standard Edition Java . 는 자바로 프로그래밍을 할 때 가장 기본적이고 핵심적인 패키지들이 포함되어 있다 Java SE . 는 웹 프로그래밍이나 모바일 프로그래밍을 할 때도 기본적으로 사용된다 Java SE . 를 이용하면 데스크톱에서 실행할 수 있는 어플리케이션 개발이 가능하지만 최근에는Java SE 인터넷이 연결되지 않은 프로그램이나 모바일용이 아닌 프로그래밍은 자바로는 거의 개발이 되지 않고 있는 추세이다. 

## (2) Java EE; 브라우저 연동; 많은 사전들이 들어있어 보통 SE를 받고 필요한 사전을 다운받는 방식을 사용; SE를 깔고 라이브러리로 이용 가능; 포트 충돌도 일으킬 수 있음
  * 는 의 약자로 엔터 프라이즈급 개발을 위한 플랫폼이다 EE Java Enteprise Edition . 는 엔터프라이즈 기반 어플리케이션으로 웹 어플리케이션에서 서버 측 프로그램을Java EE 위한 다양한 가 지원된다 API . 는 미들웨어 서버에서 제공하는 각종 기능에 대한 라이브러리를 제공한다 Java EE . 는 엔터프라이즈 웹 어플리케이션을 개발하기 위한 완벽한 를 제공한다 Java EE APl . 

## (3) Java ME; 테블릿 같은 모바일
  * 는 의 약자로 모바일 플랫폼 등 ME Java Mico Edition 임베디드 시스템용 개발을 위한 플랫폼이다. 는 모바일 및 임베디드 기반 어플리케이션으로 스마트폰이나 모바일 기기 등 소형기기를Java ME 지원한다. 는 와 에 대한 호환성이 제공된다 Java ME Java SE Java EE 

## JDK 설치의 의미 
- ‘클래스 정보, 변수정보, 메소드 정보, static 변수, 상수 pool’ 을 가지고 있음.
* JDK 를 설치한다는 것은 자바에서 컴파일러를 설치한다는 의미다 JDK . 프로그래밍을 위해서는 기본적으로 가 필요하다 Java JavaSE . 는 다른 말로 으로 불린다 JavaSE JRE . 는 의 약자로 자바 실행 환경이다 JRE Java Runtime Environment .
* 나중에 Program files 경로에 빈칸 없애는 기능 있음

## JDK 8의 주요 특징 
 * Lambda Expression ⎼ 은 함수형 프로그래밍이다 Lambda Expression . ⎼클래스를 사용하지 않고 메소드 정의 수준으로 인자로 전달할 로직을 표현할 수 있는 표기법을 람다식 또는 람다표현이라고 말하며 익명 메소드라고도 부른다. ⎼람다식으로 표현된 로직은 함수형 인터페이스로 자동으로 변환한다. 
 * 함수형; 즉 프로토타입 기반: 복제를 통한 프로그래밍(자바의 인터페이스)을 위함(파이썬의 장점 좆음)
 * 속도가 굉장히 빨라짐(하지만 11까지 나온 지금 파이썬에게 밀림)


## 디렉터리의 기능 
* 디렉터리 bin ⎼자바 개발에서 실행하는데 필요한 도구와 유틸리티가 있다; begin의 약자라고 생각하면 쉬움(즉 실행시켜주는 파일)
* 디렉터리 db ⎼데이터 관련 도구와 유틸리티가 있다. 
* 디렉터리 include ⎼네이티브 코드 프로그래밍에 필요한 헤더 파일이 있다. 
⎼네이티브 코드는 와 운영체제가 직접 실행할 수 있는 코드를 의미한다 CPU . 
* 디렉터리 jre ⎼자바 런타임 환경으로 클래스 라이브러리 등의 실행에 필요한 파일이 있다 JVM, 
* 디렉터리 lib ⎼ 의 기본 라이브러리 외에 추가 라이브러리와 개발 도구에서 필요한 여러 파일이 있다 


## 클래스 파일
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

# jdbc
## 외부에 있는 오라클 라이브러리로 JDBC 사용하기(가장 안정된 User Library)
1. C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 복사
- ojdbc6_g: 개발자 용;  서버에는 ojdbc6만 사용
2. windows-preference - java - build path - user libraries - new(이름 무작위) - add external jars - ojdbc 추가 - JDBC 프로젝트 마우스 우측해서 build configure - add libray - 추가한 lib 추가
- 패키지 임포트 -> JDBC 드라이버 Load -> Connection 객체 생성 -> Statement 객체 생성 -> query 수행 -> Result 객체로부터 데이터 추출 -> Resultset Close -> Statement 객체 Close -> Connection 객체 Close

## OJDBC
- 오라클 11은 OJCBC6, 오라클 12는 OJDBC7이 적합

## Datasource
- DataSource: 자바에서 제공, BasicDataSource: 아파치에서 제공하는 커넥션풀

# 이클립스
 * https://www.eclipse.org/downloads/
 * 자바 버전에 맞게 다운 받기
 * 자바는 힙 크기 조절해 주어야 함(new 사용이 많음)
 * OpenPerspective 자바 변경

## - UTF-8 일괄 설정 
- vmargs 밑에
- -Dfile.encoding=UTF-8
	* (ex. Windows에서 개발한 소스를, Linux에서 -Dfile.encoding을 명시하지 않고 실행)

 

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

# Window Preference
- General -  font/Syntax/Save

## JAD 설치
- 마켓 -> jad install -> 재실행 -> Window preference -> Edi tor -> File Assosiation -> Default
- Windows> Preferences > General > Editors > File Associations 클릭하게 되면
- 모든 확장가가 기본적으로 취하게 되는 프로그램명들을 설정할수 있게 되어있는데 .class 파일을 클릭해서 아래에 jadclipse file view를 기본으로 사용하겠다고 오른쪽 default 클릭해서 셋팅한다


# 웹
## 커넥션 풀
- http://jakarta.apache.org/ 
- collection, dbcp, pool, logging 다운
1. ① commons-collections4-4.0.jar ⎼확장 또는 자바 컬렉션 프레임워크를 확장한다. ⎼자바 컬렉션 프레임워크는 추가 되었으며 응용 프로그램의 개발을 가속화 많은 강력한 JDK 1.2 Java 데이터 구조를 추가할 수 있다. 
2. ② commons-dbcp2-2.0.jar ⎼데이터베이스 연결 풀링 서비스를 제공한다. ⎼연결 풀링 서비스는 관계 데이터베이스에서 새로운 연결을 위한 필요한 데이터베이스 트랜잭션을 수 행 시간에서 걸리는 시간을 최소화 할 수 있다. 
- 환경설정 -> 클래스; BasicDataSource
3. ③ commons-pool2-2.2.jar ⎼일반 인스턴스 풀링 구성 요소이다. ⎼아파치 커먼즈 풀 오픈 소스 소프트웨어 라이브러리는 인스턴스 풀링 및 개체 풀 구현을 제공한 API 다. 
- 커넥션을 담는 것
4. ④ commons-logging-1.2.jar ⎼로깅 구현의 다양한 클래스로 라이브러리 정보를 기록한다 API . ⎼log 인스턴스를 가져와서 쓰는 창구 역할로 실제 구현체는 의 나 그리고 기타 java logging API log4j 로거 모듈을 가져다 사용한다. ⎼ 은 로깅 요청을 기존에 존재하는 다양한 에 전 Common Logging(JCL) logging API implementations 달하는 역할을 한다. ⎼ 을 사용할 경우에 로깅 요청이 왔을 때 해당 라이브러리를 이용해서 를 출력할 수 있게 해 주 JCL log 며 전달받는 구현체를 바꿀 수 있어서 어떠한 를 사용하던 logging API logging API implementations 지에 상관없이 동일한 방법을 개발을 할 수 있다. 
- logging 사용하면 sys처럼 실행에 영향주지 않고 결과 확인 가능

## 2-1. DataSource 인터페이스의 기능 
- connection 풀을 DataSource 안에 담어두기 때문에 close 사용 필요
- ⎼커넥션 풀은 DataSource 인터페이스를 사용하여 구현할 수 있으며 DataSource 인터페이스는 데이터베이스에 대한 연결을 제공하는 서비스로 다양한 방식의 데이터베이스 연결을 제공하고 이에 대한 추상화 계층을 제공함으로써 업무 로직과 데이터베이스 연결 방식 간의 종속성을 배제한다.
- DataSource 인터페이스는 close 메서드로 커넥션을 풀로 복귀시킨다.  close 메서드로 반드시 자원을 해제해야 한다.
1. ① 기본 구현체 ⎼표준 커넥션 인스턴스를 생산한다. 
2. ② 커넥션 풀링 구현체 ⎼자동으로 커넥션 풀에 참여하는 커넥션 인스턴스를 생산하며 이 구현체는 커넥션 풀링 매니저와 함께 작업한다. 
3. ③ 분산 트랜잭션 구현체 ⎼분산 트랜잭션을 위한 커넥션 풀에 참여하는 커넥션 인스턴스를 생산하며 이 구현체는 트랜잭션 매니 저와 커넥션 풀링 매니저와 함께 작업하고 패키지의 javax.sql DataSource 인터페이스를 구현한다. 
- ⎼커넥션 풀을 사용시 주의할 점은 작업이 완료되었으면 기존처럼 Connection 인터페이스 인스턴스의 close 메서드를 사용하여 자원을 반납하지 않고 Connection 인터페이스 인스턴스를 저장소에 복귀시켜야 하는 것은 지금껏 사용했 던 커넥션이며 커넥션 풀링용 커넥션인 DataSource 인터페이스는 close 메서드로 커넥션을 풀로 복귀시킨다. 
- ⎼DataSource 인터페이스는 close 메서드로 반드시 자원을 해제해야 한다.

## 커넥터 풀
### tomcat-dbcp
-  톰켓을 사용하지 않을수도 있으니 잘 사용 안함.




## jstl 다운
- JSTL 1.2.3 접속; http://jakarta.apache.org
- 자카르타에서는 자주 사용하는 커스텀 태그를 JSTL(JSP Standard Tag Library) 형태로 제공해준다.
- 자바 코드를 최대한 줄이기 위해 거의 모든 자바 코드를 커스텀 태그로 구현하려면 개발이 효율적이기보다는
오히려 개발 시간이 훨씬 늘어날 것이며 기본 기능까지도 직접 커스텀 태그로 개발할 필요는 없다.
- JSTL 은 자주 사용되는 필요한 기능들을 모아 놓은 커스텀 태그이므로 태그는 코드를 간결하게 해주고 가독성을
높이는 장점이 있기 때문에 JSTL 을 잘 사용한다면 효율적인 코딩을 하는 데 많은 도움을 준다.
- JSTL은 용도에 따라 사용하는 기능이 달라지는데 크게 4 가지로 core, fmt, xml, sql 와 함수로 나누어진다.

### taglib 다운
- taglib 1.2
- 1.2버전: http://tomcat.apache.org/taglibs/standard/; impl, el, spec, compat 4개 다운
- C:\workspace\jsptest\begin\WebContent\WEB-INF\lib\taglibs-standard-compat-1.2.5.jar 밑의 org.apache.taglibs.standard.tag.compat.core 사용

### JSTL fmt
#### Properties Editor
- 프로퍼티 파일을 유니코드 값으로 변환하는 플러그인이다.
- 이클립스에서 add software

## fileupload
## cos_2008
1. 자카르타 아파치 http://commons.apache.org/proper/commons-fileupload/download_fileupload.cgi
2. 혹은 http://www.servlets.com/cos/ 에서 cos-20.08.zip 
3. https://mvnrepository.com/ 에서 file 검색
- .COS 라이브러리는 현재 자바에서 가장 널리 쓰여 지는 업로드 컴포넌트로 파일 업로드의 원리로 구현하였다.

### Multipart
- MultipartRequest 클래스는 COS 라이브러리에서 가장 핵심적인 역할을 하는 클래스이다.
- MultipartRequest 클래스는 파일 업로드를 직접적으로 담당하는 클래스로 파일 업로드를 담당하는 생성자와 여러 가지 메서드를 포함하고 있다.
- MultipartRequest 클래스는 안정성도 다른 파일 업로드 라이브러리보다 뛰어나며 파일 중복 처리의 경우도 파일 중복 처리 인터페이스를 가지고 있기 때문에 쉽게 처리가 가능하고 한글에 관련된 문제 또한 인코딩 방식을 입력하여 쉽게 처리가 가능하다.
- MultipartRequest 클래스는 여러 가지 장점을 가지고 있으면서 사용법도 쉬워서 파일 업로드에 자주 이용된다.

## Classifier4j
- Maven(https://mvnrepository.com/artifact/com.github.yaraju.Classifier4J/classifier4j) -> Classifier4j
- 데이터 Teach; 단어 
