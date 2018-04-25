<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<hr>
<c:choose>
	<c:when test="${sessionScope.login ne 1 or  empty sessionScope.login}">
		<div  class="classFooterLogin">
			<h5>제보할 글이 있다면?<a href="../member/login">로그인</a></h5>
			<h5>아이디가 없다면?<a href="../member/join">회원가입</a></h5>
		</div>	
	</c:when>
	<c:otherwise>		
		<div  class="classFooterLoginOn">
			<a href="../board/write"><button type="button" class="btn btn-primary">게시글 작성하기</button></a>			
			<a href="../member/edit"><button class="btn btn-primary">${sessionScope.id }</button></a>
			<a href="../member/logout"><button class="btn btn-danger">로그아웃</button></a>			
		</div>			
	</c:otherwise>
</c:choose>
</body>
</html>