# 스프링; https://spring.io/tools
- https://spring.io/tools -> tools -> Spring Tools 4 for Eclipse 2. atom 3. Visual Studio Code

# 블록,
* [3점대 4로 업그레이드](https://offbyone.tistory.com/16)
* [게시판 만들기](https://melonpeach.tistory.com/8?category=806570)

# 톰켓
1. pivotal-tc-server: Spring의 내장 톰켓; 사용 안함
2. WIndos - server 추가하기
3. 서버 더블 클릭 - Overview - Path 수정

# 스프링 버전 고르기
## Spring 3.0
- 자바 6.0, 7.0 + 톰켓6.0

## Spring Tools 3.9.8
* Spring Bean Configuration File 만들 수 

## Spring Tools 4 for 
- Spring Tool Suite 4부터는 legacy project 없이 spring boot version만 사용하여야 함. 

## 스프링 4.0버전
- 서블릿 3.0 
- ResetController 

## 스프링 ini 파일 설정
1. - UTF-8 일괄 설정: vmargs 밑에
- -Dfile.encoding=UTF-8
2. -Xms512m
3. -Xmx1024m



## Spring 초기 설정
1. workspace 설정
2. Open Perspective
3. JRE Library: buildpath -> library 지우기 -> add library -> jre library 추가
4. Project facets java 버전 
5. 자바 컴파일러 버전 확인
5. installed JRES 확인
6. Runtime Environments 설정
7. Server and Runtime 톰켓 설정
- General -  font/Syntax/Save
8. jadclipse plugin
	- jadclipse 는 바이트 코드 (.class) 파일을 .java로 Decopiling 해주는 플러그인으로 자동 설치가 되지 않으면 수동으로
	설치해야 한다.
	- class 확장자로 제공되는 라이브러리의 소스를 파악할 수 있다.
	- 이클립스에서 Java api 로 제공되는 파일들의 소스를 확인 할 때는 System 단어를 선택하고 F3 버튼을 클릭하면
	단어에 대한 설명이 나오는데 이 설명이 소스 파일이다.
	- 소스 파일들을 보기 위해서는 제공받는 라이브러리에 있는 소스 파일들을 임포트 해야 하는데 임포트 하지 않고
	바로 확인하기 위해서 jadClipse를 설치하는 것이다.

# 스프링 Maven 추가
- http://maven.apache.org/download.cgi -> apache-maven-3.6.1-bin.zip

## Maven 환경변수 설정
1. 환경변수 이름: MAVEN_HOME(매번 버전 바뀌면 Path 그때마다 바꿔줘야하기 때문에 해줌)
2. PATH 추가: %MAVEN_HOME%\bin
- 혹은 bin을 바로 PATH에서 추가해주어도 됨
3. cmd에서 mvn-version으로 확인
4. windows preference 에서 User setting(conf, usersetting로 경로 설정) Installations 수정하기 -> 파일열기 -> 
	- <localRepository>C:\repositories</localRepository> 추가하기

## Windos에서 import
- import - maven - existing maven project


# Maven pom.xml 수정
## 버전 수정
- <org.springframework-version>4.1.1.RELEASE</org.springframework-version>

### plugin 수정
- Maven 버전 수정
- <source>1.8</source>  // 자바 버전
- <target>1.8</target> // 자바 버전
- <encoding>UTF-8</encoding>

# 프로젝트 수정

## 서버 추가하기
* 프로젝트 마우스 우측 -> 여기에서 Add Libray.. 클릭 > Server Runtime선택후 Next클릭 > Apache Tomcat선택후 Finish클릭 > Apply and Close클릭

## Maven java library 추가하기 
1. window preference -> java -> user libraries -> external
2. 프로젝트 마우스 우측 -> buildpath에서 jre 지우고 add library해서 수정


## 프로젝트 - 마우스 우측 - properties - Maven project facet
- build path에서 project facet에서 자바 1.8 변경


## Maven 없는 repository 추가하기
1. effective Pom에서 repositories 복사
2. pom에서 dependencies 밑에 추가하고 경로에 maven에서 복사한 repository 

## 메이븐 업데이트
* 프로젝트명에 마우스 오른쭉 키를 누르고 팝업 메뉴에서 Maven -> Update Project

## Maven Ojdbc 혹은 MySQL 라이브러리 설정


# 중간 테스트
* 크롬에 localhost:8080 검색

# Maven login4j
- src/main/resources 경로에 log4j.dtd idoctype warning 제거하기


# JAD 설치
- 마켓 -> jad install -> 재실행 -> (Window preference -> general -> Editor -> File Assosiation)-> Decompiler Default -> 
 
# MyBatis
- 3.2 이상 버전은 JDK 1.6 이상 버전을 요구한다.
- 스프링과의 호환성을 보는 것도 중요하다.

## MyBatis 쓰는 이유
- 이 JDBC만 사용해서 DB 쿼리문을 작성하면 java소스와 쿼리소스가 겹치게 되고 관리가 어려워진다. Mybatis는 SQL 쿼리문을 xml 형식의 파일로 분리시켜 저장관리할 수 있고 java소스에서 xml 태그의 id만 호출하며 개발의 편리함을 제공한다. Mybatis는 xml형식의 쿼리파일을 저장 및 호출하는 역할을 내부적으로 처리하는 것이다.

## MyBatis 3.4.1

## MyBatis Spring 1.3.1

### mybatis config 폴더
- src/main/resources에서 폴더 생성 -> config.xml(template) 만들기
- alias만 설정

### mybatis mapper 폴더
- src/main/resources에서 폴더 생성 -> mapper.xml 만들기


# web.xml 설정
1. 필터 설정

# server.xml
## 스프링 라이브러리 Resource 설정
1.  <resources mapping="/js/**" location="/resources/js/"/>
- <resources mapping="/resources/**" location="/resources/" />
- <resources mapping="/css/**" location="/resources/css/" />
- <resources mapping="/img/**" location="/resources/img/" />
- <resources mapping="/js/**" location="/resources/js/" />
- <resources location="/resources/" mapping="/resources/**"/>
- 경로를 /로 해놓으면 resource안에 js 넣을 필요 없음.
- 이후에 resources 안에 폴더 만들고 서버 돌려서 info에 mapping 

# root-context.xml
## DB연동(DAO, DTO관련 빈 입력)
- pg442

# servlet-context.xml
- 뷰, 서비스 관련 빈 

## 스프링 서버
- window view - 서버 추가
- 서버에 프로젝트 추가
- 서버 더블클릭 후 경로 확인





## 주요 테스트 라이브러리
- (1) JSON.simple 라이브러리
- JSON.simple 라이브러리는 JSON 데이터가 대용량 데이터와 작은 용량 데이터 모두를 다양하게 처리하는 환경에서 적합하다.
- (2) GSON 라이브러리
- GSON 라이브러리는 마이크로 서비스와 분산아키텍처 설정등과 같이 작은 용량의 많은 JSON 파일을 처리하는 환경에 적합하다.
- (3) Jackson 라이브러리
- Jackson 라이브러리는 빅데이터처리와 같이 주로 큰 사이즈의 JSON 데이터를 처리하는 환경에 적합하다.
- jackson-core-asl 라이브러리와 jackson-databind 라이브러리를 pom에 등록하여 적용한다.
