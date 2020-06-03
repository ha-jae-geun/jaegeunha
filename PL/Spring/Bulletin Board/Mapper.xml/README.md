# 초기 폴더 생성
```java
src/main/resources에 mappers폴더를 하나만든후 boardMapper.xml파일을 하나만들어주고(아래 아니고 위)

아래 코드를 추가해줍니다.

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="boardMapper">
   
</mapper>


src/main/resources에 mybatis-config.xml 파일을 만들어주고 아래코드를 추가해줍니다.

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  
</configuration>
```

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

# read
```xml
WHERE BNO = #{bno}를 보시면 WHERE에 BNO값을 넣어줘서 제목을 클릭했을때 그 번호에 해당하는 게시물을 조회하게끔 쿼리를 BoardMapper.xml에 추가해줍니다. 

 

	<select id="read" parameterType="int" resultType="kr.co.vo.BoardVO">
		SELECT	BNO
			  , TITLE
			  , CONTENT
			  , WRITER
			  , REGDATE
		 FROM MP_BOARD
		 WHERE BNO = #{bno}
	</select>
```
