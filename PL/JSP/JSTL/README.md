# core
# fmt
```java
board폴더에 list.jsp파일을 만들어주고 코드를 입력해줍니다.

<c:forEach items="${list}" var = "list">에서 보시면 forEach는 받은 ${list}값 만큼 반복해주는건데

자바에서 for문이랑 비슷하다고 생각하시면 됩니다. 여기서 보시면 ${list}가 있지요 이것이


 
BoardController에서 이름을 list로 정한 service.list()를 가져온것입니다.

그리고 var는 ${list}를 list라는 이름으로 선언해준것이고요. 

<c:out value="${list.bno}" /> 이것은 이제 데이터를 불러왔으닌까 뿌려줘야겠지요.

list에 있는 bno를 가져와라 라고 생각하시면됩니다. 

forEach와 c:out를 쓰려면 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>를 맨위에 써주셔야해요

그리고 fmt날짜 포맷을 써주려면 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>써주시면 됩니다.

 

 

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
	 	<title>게시판</title>
	</head>
	<body>
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 작성
			</nav>
			<hr />
			
			<section id="container">
				<form role="form" method="post" action="/board/write">
					<table>
						<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
						
						<c:forEach items="${list}" var = "list">
							<tr>
								<td><c:out value="${list.bno}" /></td>
								<td><c:out value="${list.title}" /></td>
								<td><c:out value="${list.writer}" /></td>
								<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
						
					</table>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>
```
