# 오라클
- MySQL과 달리 오라클은 대용량 데이터 베이스라고 하는데, 대용량 데이터 타입(CLOB; 4GB까지 가능) 까지 가질 수 있다.
- 오라클 # 버전; 11g 사용; 12g는 명령어 다 바뀜
- SQL Developer도 같이 설치
- 10g: 한글 코드 2바이트로 인식; 11g: 한글 코드 3바이트로 인식
- 12g: 비정형 데이터 연동 원활하게 함
- 데이터베이스 11g 엔터프라이즈 / 표준 에디션: 오라클 관리자
- 데이터베이스 11g Express Edition: 개발자용; exe 파일로 쉽게 지우기 가능.; 개발자용

## 오라클 버전
### 오라클의 한글 및 기타 언어 지원( ) 영문 제외 
- ① 10g 버전 이하 ⎼영문: 1바이트 ⎼영문 이외의 한글 등: 2바이트 
- ② 11g 버전 이상 ⎼영문: 1바이트 ⎼영문 이외의 한글 등: 3바이트 

### 오라클 버전 확인
- OJDBC 알집 풀어서 C:\library\ojdbc6\META-INF 경로에 MANIFEST.MF 

## 오라클 명령어
- dba로 접속: 1. sqlplus 2. sys as sysdba | 1234  3. quit / exit(윈도우 빠지기)
- as: 1. 충돌 방지 2. 

### 오라클 유저
- 1. 데이터 베이스 추가 2. 이름: sys 3. 롤: SYSDBA 4. 로컬 이름: 127.0.0.1
- 유저 검색
- select username from all_users;
- 연습 계정: scott 추가: 1. app\product\18.0.0\dbhome\rdbms\admin\scott.sql 실행
- 유저 계정 변경
	- alter user scott account unlock; // 락 풀기
	- alter user scott identified by tiger; // tiger로 변경
	- conn scott/tiger // 접속
	- 벗어날 때: exit

## 포트 충돌
- 가. 포트 번호 확인(listener.ora) - - - 
- ⎼D:\app\s\product\11.2.0\dbhome_1\NETWORK\ADMIN ⎼(ADDRESS = (PROTOCOL = TCP)(HOST = SONG-PC)(PORT = 1521))

## SI 변경; 전역자
- 나. SID (tnsnames.ora) 확인 
- ⎼D:\app\s\product\11.2.0\dbhome_1\NETWORK\ADMIN ⎼(SERVICE_NAME = orcl)

### 오라클 서비스
- OracleServiceXE: 오라클과 직접 연동; 메모리 많이 안잡음
- Protocol Adapter Error 유발
- OracleXETNSLISTENER; 디벨로퍼, 이클립스 연동; 메모리 많이 잡음
- ① OracleServiceORCL ⎼오라클 서버의 인스턴스로서 반드시 필요한 서비스이다. 
- ② OracleOraDb11g_home1TNSListener ⎼오라클 리스너 서비스이며 원격지에서 오라클 서버에 접속하려면 반드시 필요한 서비스이다. 
- ③ OracleDBConsoleorcl ⎼오라클 서버를 웹 브라우저에서 관리할 수 있도록 해 주는 일종의 웹 어플리케이션이다. 
