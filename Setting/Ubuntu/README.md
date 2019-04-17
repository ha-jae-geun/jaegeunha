
# 자바
## 자바 jdk, jre
- $ sudo apt-get install default-jdk 
- $ sudo apt-get install default-jre (jre만을 원한다면)


# MySQL
1. MySQL 버전을 확인: sudo apt-cache search mysql-server
2. 설치: sudo apt-get install mysql-server-5.7
3. sql 리스닝 확인:/etc/init.d/mysql status
4. 재시작: sudo /etc/init.d/mysql restar
5. 상태  	service mysql start/stop/restart/status
- 출처: https://all-record.tistory.com/183 [세상의 모든 기록]

##사용
-  로그인: mysql -uroot -p


#톰켓 설치
##수동
1. Tomcat8 다운로드
- 다운로드 링크 : http://tomcat.apache.org/download-80.cgi

2. 링크 복사 : wget
- Binary Distributions
- tar.gz 마우스 우클릭메뉴 -> 링크 주소 복사

3. wget 다운 로드
- # wget 링크 붙이기

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
- # /usr/share/tomcat8/bin/./shutdown.sh
- # /usr/share/tomcat8/bin/./startup.sh

7. localhost:8080 확인
