
# 자바
## 자바 jdk, jre
- $ sudo apt-get install default-jdk 
- $ sudo apt-get install default-jre (jre만을 원한다면)

## 자바 버전 설정
-  update-alternatives --config javac
- update-alternatives --config java
- 환경변수 설정: vi ~/.bash_profile

## openjdk 삭제
1.  sudo apt-get remove openjdk*
2. sudo apt-get autoremove --purge

##JAVA 환경변수 지정

- 환경변수를 지정하기 위해, Path를 알아야 합니다.
- JAVA관리를 위한 명령어를 통하면, 각 JAVA들의 path를 확인할 수 있습니다.
- 예를 들어, /usr/lib/jvm/java-8-openjdk-amd64 라는 Path를 확인하여, environment 에 아래와 같이 추가해줍니다.
- $ sudo nano /etc/environment

    - JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64"

- 저장을 하고 나서, 아래 명령어로 적용을 해주면 됩니다.
- $ source /etc/environment

- PATH가 제대로 지정되었는지 확인하기 위해서는 아래 명령을 사용합니다.
- $ echo $JAVA_HOME

##자바 컴파일러
###jre 
- windowpreference -> compiler -> 1.8 밑으로 ㅐ리기ㄴ



# MySQL
1. MySQL 버전을 확인: sudo apt-cache search mysql-server
2. 설치: sudo apt-get install mysql-server-5.7
3. sql 리스닝 확인:/etc/init.d/mysql status
4. 재시작: sudo /etc/init.d/mysql restar
5. 상태  	service mysql start/stop/restart/status
- 출처: https://all-record.tistory.com/183 [세상의 모든 기록]

## 사용
-  로그인: mysql -uroot -p




# 톰켓 설치
##수동
1. Tomcat8 다운로드
- 다운로드 링크 : http://tomcat.apache.org/download-80.cgi

2. 링크 복사 : wget
- Binary Distributions
- tar.gz 마우스 우클릭메뉴 -> 링크 주소 복사

3. wget 다운 로드
-  wget 링크 붙이기

4. 압축 해제 / 디렉토리 이동
- i : # tar xvfz apache-tomcat-8xxxx.tar.gz
- ii: mv /tmp/apache-tomcat-8.5.6 /usr/share/tomcat8

5. 환경변수 설정
- i : #vi /etc/profile
- ii : 
- export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_101
- export PATH=$PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin
- export CATALINA_HOME=/usr/share/tomcat8
- export CLASSPATH=$JAVA_HOME/jre/lib:$JAVA_HOME/lib/tools.jar:$CATALINA_HOME/lib/jsp-api.jar:$CATALINA_HOME/lib/servlet-api.jar
- export CLASS_PATH=$JAVA_HOME/lib:$CLASS_PATH

- iii: source /etc/profile

6. tomcat stop / start
- /usr/share/tomcat8/bin/./shutdown.sh
- /usr/share/tomcat8/bin/./startup.sh

7. localhost:8080 확인


## apache Tomcat 8 서비스를 부팅시 자동으로 서비스로 등록

- 마지막으로 리눅스 부팅시 자동으로 톰캣 서비스를 시작하도록 설정해 보겠습니다. 톰캣 서버 bin 디렉토리에 catalina.sh 파일이 있는데 이 파일을 /etc/init.d 디렉토리에 tomcat이라는 이름을 가진 파일로 복사 후, vim 에디터로 수정해 시작 스크립트로 만들어 봅시다.


- # cp /usr/local/server/tomcat/bin/catalina.sh /etc/init.d/tomcat
- # vi /etc/init.d/tomcat
- 톰캣 서버 시작 : /etc/init.d/tomcat start
- 톰캣 서버 종료 : /etc/init.d/tomcat stop

## 톰켓 프로세스 번호
- ps -ef |grep java
- kill 프로세스 번호


## Unknown version of Tomcat was specified
* chmod -R 755 /usr/local/apache-tomcat

## 톰켓 삭제
- sudo apt-get purge --auto-remove tomcat8






# Maven
- maven 확인: mvn -v

## 환경변수
-  /opt/profile 혹은 ~/.bashrc 나 ~/.bash_profie
- #vi /etc/profile에서 호나경변수 -> 이후 source /etc/profile 해주기
- export MAVEN_HOME=[압축푼위치]
- export PATH=$PATH:$MAVEN_HOME/bin

## pom.xml
- Maven version, Java 버전 바꾸기


