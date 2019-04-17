
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
