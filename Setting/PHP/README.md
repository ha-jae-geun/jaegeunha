# 설치
* [전체](https://kamang-it.tistory.com/209)
* [BITNAMI WAMP](https://www.youtube.com/watch?v=WboIThLXOGg&list=PLuHgQVnccGMAMMNByX8Bf1BkVrShBhj1I&index=4)
1. apache server
2. php
3. mysql



## PHP INI 설정
* display_errors on
    * 개발할 때만 켜놔야 함. 비밀번호 유출 가능성
* opcache.enable=0
    * php 수정 후 즉각 개발 반영
* 항상 ini 변경후 아파치 서버 재시작
      * 아파치 서버는 ini 파일을 껐다 킬때만 반영한다.
* phpinfo.php 파일을 저장 하실 때 텍스트 문서가 아니라, 모든문서로 지정을 하시고 저장을 하신 후에


# MYSQL
## phpmyadmin
* phpMyAdmin은 MySQL을 월드 와이드 웹 상에서 관리할 목적으로 PHP로 작성한 오픈 소스 도구이다. 데이터베이스, 테이블, 필드, 열의 작성, 수정, 삭제, 또 SQL 상태 실행, 사용자 및 사용 권한 관리 등의 다양한 작업을 수행할 수 있다
