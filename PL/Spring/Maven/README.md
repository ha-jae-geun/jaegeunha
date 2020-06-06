# [정아마추어](https://jeong-pro.tistory.com/168?category=793347)

```java
그래서 Build Tool(빌드 툴)이 뭔가요?
빌드 툴은 소프트웨어 프로젝트를 만드는데 필요한 모든 것들은 자동적으로 연관 지어 주는 것입니다.
소프트웨어 프로젝트를 만드는 데에는 한 개 혹은 여러 개의 이러한 작업들이 있습니다.

소스코드를 만드는 것
소스 코드로부터 Documentation(문서화)를 하는 것
소스코드를 컴파일링 하는 것
컴파일된 코드를 JAR, ZIP 파일로 패키징 하는 것
Repository 혹은 어떤 곳으로, 서버에 패키징 된 코드를 설치하는 것
 

빌드 프로세스를 자동화할 때의 장점은 사람이 만드는 에러를 최소화할 수 있습니다. 또한 반복적으로 수행되는 작업을 더 빠르게 할 수 있습니다.

메이븐 개요 (핵심 콘셉트)
메이븐은 POM 파일들을 중심으로 있습니다. POM 파일은 프로젝트의 소스들을 XML로 나타내고 있습니다. 
코드, 테스트 코드, Dependencies(의존성) 등으로 이루어져 있습니다. POM 파일은 root 디렉토리에 속해있어야 합니다.


메이븐 핵심 컨셉의 개요
 

POM 파일
당신이 POM 파일에 준 메이븐 명령어들을 실행하게 되면, 메이븐은 POM에 적힌 대로 명령어들을 실행합니다.

 

Life Cycles(생명주기), Phases and Goals 만들기
메이븐의 빌드 프로세스는 life cycles, phases 그리고 goals로 나누어져 있습니다. life cycle은 phases가 연속적으로 구성되어 있습니다.
그리고 phase는 goals들의 연속으로 이루어져 있습니다. 메이븐에 명령어를 주었을 때, 이 명령어의 이름은 life cycle, phase 
혹은 goal을 빌드하기 위한 것입니다. 

 

Dependencies(의존성)와 Repositories(저장소)
메이븐 실행의 첫 번째 목적은 프로젝트에 필요한 의존성을 확인하는 것입니다. 의존성은 외부의 JAR 파일들을 가지고 옵니다. 
만약에 의존성을 local(지역) 메이븐 repository에서 찾지 못하면, 중앙의 메이븐 repository(저장소)에서 다운로드하고 
local repository(지역 저장소)에 가지고 옵니다. local repository(지역 저장소)는 당신 컴퓨터의 하드디스크의 디렉토리 입니다. 
당신은 local repository의 위치를 제가 원하는 장소로 지정할 수도 있습니다. 의존성을 다운로드할  remote repository 역시 지정할
수 있습니다. 추가적인 내용은 뒤에 더 설명하겠습니다.

 

Build Plugins
빌드 플러그인들은 추가적인 goals를 빌드 phase에 넣을 때 사용됩니다. 메이븐의 기본 빌드 phase와 goasl들이 당신이 원하는 작업을 
커버하지 못한다면, 당신은 플러그인을 POM 파일에 추가할 수 있습니다. 추가적으로 당신의 자바 파일도 implement(구현) 할 수 있습니다.

 

Build Profiles
Build Profiles는 프로젝트를 다른 방식으로 빌드하려고 할 때 사용됩니다. 예를 들어 테스트를 위해서 프로젝트를 local computer에서 
사용해야 할 때가 있습니다. 혹은 프로젝트를 제품 환경을 위해서 배치해야 할 때가 있습니다. 이 둘의 빌드는 다른 것입니다. 
이렇게 다른 두 개의 build profiles를 POM 파일에 더할 때, 어떤 build profiles를 사용할 것인지 메이븐에 알려줄 수 있습니다.

 

Build Life Cycles
메이븐은 3개의 생명주기가 있다. 

default
clean
site
각 생명주기들은 서로 독립적으로 실행됩니다. 한 개 이상의 생명주기를 얻기 위해 메이븐을 사용할 수 있는데, 
이들은 연속적이지만 따로따로 실행됩니다.

 

default 생명주기는 모든 프로젝트를 컴파일링 하고 패키징 합니다.. clean 생명주기는 output 디렉토리, 포함된 소스 파일, 
컴파일된 클래스들, 이전의 JAR 파일 등 모든 임시파일들을 삭제합니다. site 생명주기는 문서화된 모든 것들을 관리합니다. 
사실은 site는 문서화된 것들로 완성된 웹사이트를 생성할 수도 있습니다.

 

Build Phases
각 생명주기는 연속된 build phases들로 나누어져 있고, 이는 다시 goals로 나누어져 있습니다. 

주로 사용되는 build phases 들입니다. 

Build Phase	Description
validate	Validates that the project is correct and all necessary information is available. 
This also makes sure the dependencies are downloaded.
compile	Compiles the source code of the project.
test	Runs the tests against the compiled source code using a suitable unit testing framework. 
These tests should not require the code be packaged or deployed.
package	Packs the compiled code in its distributable format, such as a JAR.
install	Install the package into the local repository, for use as a dependency in other projects locally.
deploy	Copies the final package to the remote repository for sharing with other developers and projects.
 

Build Goals
빌드 goals는 메이븐 빌드 프로세스의 최종적인 과정입니다. 한 개 혹은 여러 개의 빌드 phases들로 묶일 수 있습니다. 
만약 goal이 어떠한 phase에 의해 묶여지지 않는 다면, 당신은 오직 goal을 건너뛰는 것만 실행할 수 있습니다. 만약 goal이 
여러개의 phase로부터 묶여 있다면, 그 goald은 각 phase가 실행될 때 실행될 것입니다.
```
