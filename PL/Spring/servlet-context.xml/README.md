# [annotation-driven, component-scan, annotation-config 차이](https://gmlwjd9405.github.io/2018/12/18/spring-annotation-enable.html)

## [Component-scan](https://hamait.tistory.com/322)
```java
1. <context:component-scan/>


이 요소는 스프링 2.5 버전에 소개되어졌으며 , 만약 그 이전 버전의 스프링으로 작업하려면 , 모든 빈들은 수동적으로 XML 파일에 설정되어야 했었다.  
자바빈에 대해 어노테이션 지원은 없었다.  이것은 많은 XML 코딩을 초래했으며 ,유지보수에서도 심각한 문제가 있었다.
context:component-scan 요소는 XML 파일안의 모든 빈들의 선언을 제거했다. 

아래는 스프링 설정파일에서 선언된 모습이다.



1
<context:component-scan base-package="org.controller"/>

위의 선언은 특정 패키지(위에서는 org.controller) 안의 클래스들을 스캔하고 , 빈 인스턴스를 생성한다. 

아래와 같은 정확한 어노테이션이 존재해야지 빈을 생성할수있다. 



@Component
@Repository
@Service
@Controller




이것의  장점중 하나는   @Autowired and @Qualifier 어노테이션을 이해한다는것인데 
만약 당신이 <context:component-scan> 를 선언했다면 <context:annotation-config> 를
선언할필요가 없다는것이다.

```

## annotation-driven
```java
<mvc:annotation-driven/>
mvc:annotation-driven 는 스프링 MVC 컴포넌트들을 그것의 디폴트 설정을 가지고  활성화 하기위해 
사용된다. 만약  context:component-scan 을 XML 파일에서 빈을 생성하기위해 사용하면서 mvc:annotation-driven 를  
포함시키지 않아도 MVC 어플리케이션은 작동할것이다. 그러나  mvc:annotation-driven 은 특별한
일들을 하는데 이 태그는 당신의 @Controllers 에게 요청을 전파하기위해  요구되는  HandlerMapping 와  HandlerAdapter 를 등록한다.  
게다가 , 클래스패스상에 존재하는것에 기반한 아래와 같은 어떤 디폴트 작업을 적용한다.  


믿음과 대조적으로 이 두개 (component-scan 과 annotation-driven) 의 선언에 는 어떤 

의존성이 없다. context:component-scan 이 포함해주면  mvc:annotation-driven  선언안해

준 @Controller / @RequestMapping 도  요청을 핸들링하는것이나 이슈 없이 잘 동작한다. 

```

## [conetext-annotation-config](the <context:annotation-config /> only works on beans registered within the application context.)
* the <context:annotation-config /> only works on beans registered within the application context.
```java
3. <context:annotation-config/>


context:annotation-config 는 어플리케이션 컨텍스트안에 이미 등록된 빈들의 어노테이션을 활성화를 위해 사용된다. 
(그것들이 XML 으로 설정됬는지 혹은 패키지스캐닝을 통한건지는 중요하지 않다) 

그 의미는 이미 스프링 컨텍스트에 의해 생성되어 저장된  빈들에 대해서  @Autowired and @Qualifier 

어노테이션을 해석할거란 얘기다.

context:component-scan   또한 같은일을 할수있는데, 추가적으로 어플리케이션 컨텍스트에 빈을 등록하기위한 패키지들을 스캔한다.

context:annotation-config 은 빈을 등록하기위해 검색할수없다. 

<context:annotation-config /> 태그를 설정하면 아래의 기능을 각각 설정하는 수고를 덜게 해준다. 

```

# Resources
```java
<?xml version="1.0" encoding="UTF-8"?>
<beans:beans
	xmlns="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:beans="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

	<!-- DispatcherServlet Context: defines this servlet's request-processing 
		infrastructure -->

	<!-- Enables the Spring MVC @Controller programming model -->
	<annotation-driven />

	<!-- Handles HTTP GET requests for /resources/** by efficiently serving 
		up static resources in the ${webappRoot}/resources directory -->
	<resources mapping="/resources/**" location="/resources/" />
	<resources mapping="/css/**" location="/resources/css/"/>
	<resources mapping="/js/**" location="/resources/js/"/>
	<resources mapping="/fonts/**" location="/resources/fonts/"/>
	<resources mapping="/images/**" location="/resources/images/"/>
	<resources mapping="/sass/**" location="/resources/sass/"/>
	

	<!-- Resolves views selected for rendering by @Controllers to .jsp resources 
		in the /WEB-INF/views directory -->
	<beans:bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>

	<context:component-scan
		base-package="jae.ha.controller" />


</beans:beans>
```
