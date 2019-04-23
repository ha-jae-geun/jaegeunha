## ini


### - UTF-8 일괄 설정 
- vmargs 밑에
- -Dfile.encoding=UTF-8

# 스프링 구조

## 메이븐
- 자동 빌드 도구; 파이썬의 아나콘다

## AOP

## POJO

# Spring의 4가지 특징
## 의존성 주입(IoC / DI)
- 자바의 new를 xml에 심는 방식
⎼ 객체간의 의존 관계를 설정한다.

## 관점 지향 프로그래밍(AOP)
- 필터, 인터페이스
⎼ 기능들을 분리해서 각 모듈에 적용할 수 있다.

## 포터블 서비스 추상화(PSA)
- 특정 기술 환경인 어플리케이션계층과 서비스 계층 그리고 기술 서비스 계층 등에 종속되지 않는 포터블 코드를 생성할 수 있다.

## POJO;
- 스프링 컨테이너에 저장되는 자바 객체로 특정한 인터페이스를 구현하거나 클래스를 상속받지 않아도 된다.


# loc
1. DL(의존성 찾기) -> 패턴 EJB Spring
2. DI(의존성 주입) 
  - Setter
  - Const
  - Method(AOP; 관점 지연 방식)
 
 # pom.xml
1. build 영역
2. properties 영역
3. dependencies 영역
 
# 아나콘다
- 아나콘다에 포함되어 있는 라이브러리들이 불필요한 경우에는 기본 Python만 설치해도 무관합니다. 하지만, 요즘 유행하는 인공지능이나 빅데이터 관련 개발을 할 경우에는 결국 아나콘다에 포함된 라이브러리들을 설치할 가능성이 높기 때문에 애초에 아나콘다를 설치하는 것이 더 유리합니다. 일일이 라이브러리들을 설치하다보면 의존성 문제 등이 발생할 수도 있기 때문입니다.

# 모듈
- 파이썬, 루비 -> 의존성 풀, 컨텍스트화된 의존성 룩업

# 빈
- loc에서 빈에서 호출
- 컨테이너 담아 놓는 구조; 빈(new 키워드의 기능 가지고 있다.
  - BeanFactory 인터페이스 -> ApplicationContext
  
## 싱글톤 패턴
- 클래스의 실제이름

## 팩토리 패턴
- new 키워드를 통한 객체 생성을 모듈화 하겠다.

## 프록시 패턴
- 객체를 생성하고 담아놓고 호출해 사용한다.(AOP)
  - AOP: 로그 영역, 수행 영역, 실행 영역

## 커맨드 패턴
- 캡슐화

## 객체
- 다 컨테이너 -> 설정파일 -> 메타 정보

# 자바빈
- new를 사용안하고 new를 xml에 심는다.
- <bean class="jae.spring.test.Begin" id="begin"/>; id는 주로 클래스의 

## 자바빈을 쓰는 이유 = new를 안쓰는 이유
- 모델에 접근하기 위해서 모두 new를 사용하면 나중에 데이터가 커지면 문제가 생김 -> 객체화 해서 사용; 충돌 방지, 속도 

## 자바빈 불러오기
- ApplicationContext context = new ClassPathXmlApplicationContext("in.bean.xml");
- Begin begin = context.getBean("begin", Begin.class);
  - 앞에 begin은 bean의 id, 뒤에 .class 붙이면 강제 형변환 할 필요 없다.

## 자바빈의 int
- int형이 없으니 value 값에 "" 넣어주어야 한다.

## SpringCall1
		- ApplicationContext context = new ClassPathXmlApplicationContext("in/bean.xml");
		- Parameter parameter = (Parameter) context.getBean("parameter");
		- System.out.println(parameter);


## JavaCall1
		- Parameter parameter = new Parameter("홍길동");
		- System.out.println(parameter);
		
## JavaCall2
		- Parameter parameter = new Parameter();
		- ParameterBean parameterBean = new ParameterBean(parameter);
		- parameterBean.msg();
		
## SpringCall2
- ApplicationContext context = new ClassPathXmlApplicationContext("in/bean.xml");
- ParameterBean parameterBean = (ParameterBean) context.getBean("parameterBean");
		parameterBean.msg();

- ApplicationContext context = new GenericXmlApplicationContext("classpath:/context/Template.xml"); classpath 보다 generic을 쓰는 추세; 이때 classpath:를 쓰는 것을 권장한다.

## javabean2
- <bean class="jae.spring.test.Parameter" id="parameter"></bean>
- <bean class="jae.spring.test.ParameterBean" id="parameterBean">
- <constructor-arg ref="parameter"></constructor-arg>
- </bean>

## 프로퍼티
## property
- 메소드를 통해 관리되는 데이터를 프로퍼티(property) 라고 부르며 get, set 을 뗀 나머지 부분에서 첫문자를 소문자로 바꾼 이름을 프로퍼티 이름으로 취급한다.
- Bean을 주입 받을 경우에는 ref속성을 쓰고, 기본 데이터 타입 및 STring 클래스 타입의 경우는 value 속성을 사용한다.

## autowire
- autowire: byName: 이름 참조;  byTpye: 타입 참조



## 어노테이션
- 사용 위해: <context:annotation-config/>
- @Autowired: 타입 -> 이름; 스프링 지원
	- 어노테이션, 생성자, 필드, 메소드에 
- @Inject: 타입 -> 이름; 자바에서 지원
	- autowire 보다도 inject를 사용하는 추세; 다른 언어와의 
- @Resource: 이름 -> 타입; 자바에서 지원
- @

# bean.xml
## 네임스페이스
- beans: 프로퍼티
- p: 프로퍼티
- 1. context: 어노테이션 네임스페이스  2. <context:annotation-config/>

# String
- Spring에서 STring은 클래스가 아니라 java.lang.String이라고 말해야 한다.

# <context:component-scan base-package="jae.ha.spring"/>
- bean 사용 안하기 

## Component
- context: component-scan 사용
- base-package; 저 패키지 안에 있는 패키지는 영향 받지 않아도 되는 패키지 입력.
- set 생략 가능

## Controller
- 프론트에서 사용

## Service
- 비즈니스 메소드
- bean 만들 필요 없다.

## Repository
- DAO

# AOP
- 공통 기능 추출 -> 일괄처리
- 프록시 패턴을 이용하여 메소드를 조정한다.

## AOP 예제
1. 인코딩
2. 세션을 통한 로그인
3. DAO (마이바티스 사용)
4. WAS가 Web.xml을 걸쳐 오는 구조
5. Oracle 클 때 커밋 되는 것: 

## AOP의 종류
- 필터: 서블릿에서 사용; 스프링 web에서 사용
- 인터럽트: 스프링 web에서 사용
- 스프링 aop: 메소드 조정; 스프링 java에서 사용
	- DTO, DAO

## 그림
- aspect조인 포인트의 포인트컷(경로) + 어드바이스(동작) -> 조인 포인트 -> 타겟 - 타겟의 인스턴스(프록시) -> 인터셉트(write)

## 프록시 패턴
- connection pool 같이 담아 놓은 것을 갖다 쓰는 것.

## 조인 포인트
- before: 조인 포인트 실행전
- after: 조인 포인트 실행 후
- around: 실행전, 실행후, 예외처리 등 모든 시점에서 적용

### Weaving
- before, after, around를 정하는 것

### 타겟
- before, after를 실행시켜주는 클래스

### 프록시
- 타겟 안의 new 클래스

# 팩토리 패턴
- 주는 인스턴스에 따라 리턴에 주는 new가 다르다.

## ant 패턴
- xpath 기법 이용

## Aspect(조인 포인트의 포인트컷(경로) + 어드바이스(동작))
- 조인 포인트에의 포인트컷(위치: 어디에서); ex) jae.spring.log
	- 위치: 패키징 / 매핑명
- 어드바이스(동작: 무엇을 할 것인가); write
	- 어드바이스: aop

### aop의 객체
- 동적 객체 = 메소드



# resources 폴더
- html, js, json, img는 resource 폴더 안에 넣어주어야 한다.
	- 스프링은 무조건 MVC2 패턴으로 이루어져 있다.
	
## servlet-context.xml
- 서블릿에서 사용한 bean이 들어간다.
- 여기서 bean을 사용하려면 <beans:bean /> 이렇게 사용

## root-context.xml
- 데이터베이스 연동, DAO 연동에 필요한 bean이 들어간다.
- ⎼context 방식은 Spring MVC Project의 root-context.xml에서는 지원되지 못하므로 클래스 로드 방식으로 설정해야 한다.


