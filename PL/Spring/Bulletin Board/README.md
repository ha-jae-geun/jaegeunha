# 전체적인 흐름
```java
kr.co.controller

kr.co.dao 

kr.co.service 

kr.co.vo

여기서 controller의 역할은 웹에서 처리해야할 데이터를 받고, 

이 데이터를 담당할 service를 선택하여 호출합니다.

그리고 처리한 데이터를 다음 페이지에서 볼 수 있게 셋팅하며 이동할 페이지를 리턴합니다.

service는 데이터를 dao를 통해 넘겨주거나 받으면서 비즈니스 로직을 수행하는 역할을 합니다.

dao는 DB를 통해 데이터를 조회하거나 수정 삭제 하는 역할을 합니다.

vo는 DB에 있는 테이블 컬럼 값을 java에서 객체로 다루기 위해 사용합니다.
```

# SqlSession
* 마이바티스에서는 SqlSession를 생성하기 위해 SqlSessionFactory를 사용한다. 세션을 한번 생성하면 매핑구문을 실행하거나 커밋 또는 롤백을 하기 위해 세션을 사용할수 있다. 마지막으로 더 이상 필요하지 않은 상태가 되면 세션을 닫는다. 마이바티스 스프링 연동모듈을 사용하면 SqlSessionFactory를 직접 사용할 필요가 없다. 왜냐하면, 스프링 트랜잭션 설정에 따라 자동으로 커밋 혹은 롤백을 수행하고 닫혀지는, 쓰레드에 안전한 SqlSession 개체가 스프링 빈에 주입될 수 있기 때문이다.

```java
SqlSessionTemplate
SqlSessionTemplate은 마이바티스 스프링 연동모듈의 핵심이다. SqlSessionTemplate은 SqlSession을 
구현하고 코드에서 SqlSession를 대체하는 역할을 한다. SqlSessionTemplate 은 쓰레드에 안전하고 여러개의 DAO나 매퍼에서 공유할수 있다.

getMapper()에 의해 리턴된 매퍼가 가진 메서드를 포함해서 SQL을 처리하는 마이바티스 메서드를 호출할때
SqlSessionTemplate은 SqlSession이 현재의 스프링 트랜잭션에서 사용될수 있도록 보장한다. 추가적으로 
SqlSessionTemplate은 필요한 시점에 세션을 닫고, 커밋하거나 롤백하는 것을 포함한 세션의 생명주기를 관리한다. 
또한 마이바티스 예외를 스프링의 DataAccessException로 변환하는 작업또한 처리한다.

SqlSessionTemplate은 마이바티스의 디폴트 구현체인 DefaultSqlSession 대신 항상 사용된다. 왜냐하면 템플릿은 
스프링 트랜잭션의 일부처럼 사용될 수 있고 여러개 주입된 매퍼 클래스에 의해 사용되도록 쓰레드에 안전하다.
동일한 애플리케이션에서 두개의 클래스간의 전환은 데이터 무결성 이슈를 야기할수 있다.

SqlSessionTemplate은 생성자 인자로 SqlSessionFactory를 사용해서 생성될 수 있다.
```

## SelectList
```java
- selectOne

쿼리의 결과가 없으면 null을 반환한다. 또한, 쿼리의 결과로 레코드가 하나만 나와야 한다.
DB에 하나의 레코드만 있는 경우 사용. 그렇지 않으면 org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.TooManyResultsException 이 발생한다.
- selectList

쿼리의 결과를 List<E>로 반환한다. 결과가 없으면, 빈 List를 반환한다.
selectList()가 null을 반환하지는 않는다.

```


# XML CDAT
* 일단 CDATA가 무슨 뜻이냐 하면, 그것은 바로 'Character Data'. 즉, '문자 데이터'를 말하는 것입니다. 그런데 이 용어를 좀 더 정확하게 말하면 '(Unparsed) Character Data'. 즉, '파싱하지 않는 문자 데이터'라는 뜻입니다. 반대로, 파싱하는 문자 데이터는 'PCDATA'라고 부릅니다.
```xml
<b>, </b>, <strong> 이 세 개가 온데간데없습니다. 왜 그런 것일까요?

이유는 간단합니다. XML 파서가 <description>...</description> 내용도 어김없이 파싱할 
  대상으로 인식하기 때문입니다. 즉, 안에 있는 <b>와 <string>도 태그로 인식해 버려서 제대로 출력이 되지 않습니다.

그러면, 이를 막으려면 어떻게 하면 될까요? HTML 태그라면 < 대신 &lt;, > 대신 &gt;를 쓰면 되겠지만
  XML에서는 더 좋은 방법이 있습니다. 당연히 <description> 안의 내용은 파싱할 수 없게 만들면 됩니다.

<?xml version="1.0" encoding="UTF-8"?>
<dictionary>
  <term>
    <entry>볼드</entry>
    <description><![CDATA[글씨를 굵은 글씨로 강조한다. <b>...</b> 태그를 사용한다. <b> 대신 <strong>을 사용해도 된다.]]></description>
  </term>
</dictionary>

```

```java
- XML 파일 안에 명시되어 있는 CDATA Section이라고 불리는! [CDATA […]] 형식은

꺽쇠(<)와 같은 특수기호를 처리한다.



- jQuery나 그 외의 다른 XML 처리기능에서 CDATA Section을 지정하는 괄호는 

없는 것처럼 인식하기 때문에 CDATA Section을 사용한다고 해서 

jQuery의 XML 핸들러에 추가적인 처리가 요구되는 것은 아니다.



- CDATA Section은 특수기호 뿐만 아니라 한글을 포함한 문자열 데이터에 사용할 수 있다.


```

```xml
<select id="getBoardList" parameterType="Hashmap" resultType="hyeon.board.smboard.model.BoardVO">

select * 
	from (select rownum  rnum,num,name,subject,content, attached_file,answer_num,answer_lev,answer_seq,read_count,write_date
			from (select * from jboard order by answer_num desc,answer_seq asc))
<![CDATA[

			where rnum>=${startArticleNum} and rnum<=${endArticleNum}

]]>
	order by rnum

</select>
```

```xml
<select id="getSearchTotalNum" parameterType="Hashmap" resultType="int">
<![CDATA[

select count(*) from jboard

]]>

<where>
	<if test ="keyword != null and type.equals('all')">
	 (subject like '%${keyword}%' ) or ( name like '%${keyword}%') or ( content like '%${keyword}%')
	</if>
	
	<if test ="keyword != null and type.equals('name')">
	and (name like '%${keyword}%' )
	</if>
	
	<if test ="keyword != null and type.equals('subject')">
	and (subject like '%${keyword}%' ) 
	</if>
	
	<if test ="keyword != null and type.equals('content')">
	and (content like '%${keyword}%' ) 
		</if>
</where>


</select>
```
