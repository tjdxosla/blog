<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<!-- content -->
<div class="container">
	<table class="table">
		<tr class="text-center">
			<th>글번호</th>
			<th class="col-sm-7">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>추천</th>
		</tr>
		<c:choose>
			<c:when test="${lastMap eq null}">
				<tr class="text-center">
					<td colspan="6">작성된 게시글이 존재 하지 않습니다.</td>
				</tr>			
			</c:when>
			<c:otherwise>
				<c:forEach var="list" items="${lastMap }">
					<tr>
						<td>${list.idx }</td>
						<td><a href="../board/view?idx=${list.idx }">${list.bTitle }</a></td>
						<td>${list.bName }</td>
						<td>${list.bdate }</td>
						<td>${list.bHit }</td>
						<td>${list.recommend }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>		
	</table>
</div>
<!-- content -->
<%@ include file="../inc/foot.jsp" %>