# Board 테이블 생성
```sql
MP_BOARD라는 테이블을 생성합니다.

순서대로 BNO : 게시판 번호, TITLE : 게시판 제목, CONTENT : 게시판 내용, WRITER : 작성자,

REGDATE : 등록일.. PRIMARY KEY(BNO)를 기본키라고하는데 기본키를 BNO로 하겠다는 말입니다.

나중에 이 기본키를 이용하여 수정, 삭제, 댓글 등등.. 하기위해 쓰일겁니다. 

 

CREATE TABLE MP_BOARD(
    BNO NUMBER NOT NULL,
    TITLE VARCHAR2(100)     NOT NULL,
    CONTENT VARCHAR2(2000)  NOT NULL,
    WRITER VARCHAR2(100)    NOT NULL,
    REGDATE DATE            DEFAULT SYSDATE,
    PRIMARY KEY(BNO)
);
```

# 시퀀스
```sql

이 명령어는 테이블의 게시판 번호를 1부터 자동으로 1씩 증가시켜준다는 말입니다.

CREATE SEQUENCE MP_BOARD_SEQ
START WITH 1
INCREMENT BY 1


INSERT INTO MP_BOARD(BNO, TITLE, CONTENT, WRITER)
     VALUES (MP_BOARD_SEQ.NEXTVAL, '제목입니다', '내용입니다', 'MELONPEACH');

SELECT * FROM MP_BOARD;
COMMIT;
```
