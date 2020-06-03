# select
```xml
	<select id="list" resultType="kr.co.vo.BoardVO">
		SELECT BNO
		, TITLE
		, WRITER
		, REGDATE
		FROM MP_BOARD
		ORDER BY BNO DESC
	</select>
```
```java
BNO, TITLE, WRITER, REGDATE를 조회할것인데 조회되는 순서는

ORDER BY BNO DESC 번호를 기준으로 내림차순으로 조회 하겠다는 뜻입니다.

그리고 resultType를 보시면 패키지명에 BoardVO라고 되어있지요

이것은 쿼리를 실행하고난 결과값을 BoardVO에 담아주겠다! 이런뜻으로 해석하시면 됩니다.

그럴려면 BoardVO의 위치를 알아야하기때문에 패키지명에 BoardVO로 써준것입니다.

boardMapper.xml에 들어가셔서 코드를 추가해줍니다.
```

# insert
```xml
src/main/resources/mappers에 boardMapper.xml에 들어가서 코드를 작성해줍니다.

   <!-- 게시판 글 작성 -->
   <insert id="insert">
	   INSERT INTO MP_BOARD(    BNO 
	   					      , TITLE 
	   					      , CONTENT 
	   					      , WRITER  )
	                 VALUES(    MP_BOARD_SEQ.NEXTVAL 
	                 		  , #{title}
	                 		  , #{content}
	                 		  , #{writer}  )
   
   </insert>
```
