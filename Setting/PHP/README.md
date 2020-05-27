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
