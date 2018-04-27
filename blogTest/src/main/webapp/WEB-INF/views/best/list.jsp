<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<c:when test="${bestMap eq null}">
				<tr class="text-center">
					<td colspan="6">작성된 게시글이 존재 하지 않습니다.</td>
				</tr>			
			</c:when>
			<c:otherwise>
				<c:forEach var="list" items="${bestMap }">
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
	<c:choose>
		<c:when test="${paging.numberOfRecords ne null and paging.numberOfRecords ne '' and paging.numberOfRecords ne 0 }">
			<div class="text-center margin-top">
				<ul class="pagination">
					<c:if test="${paging.currentPageNo gt 5 }">	<!-- 현재 페이지 번호가 5보다 클 때 -->
						<li><a href="javascript:goPage(${paging.prevPageNo },${paging.maxPost })">이전</a></li>	<!-- 이전 페이지 표시 -->
					</c:if>
					<!-- 다른 페이지 클릭 하였을 때 그 페이지의 내용 및 하단의 페이징 버튼 생성하기 -->
					<c:forEach var="i" begin="${paging.startPageNo }" end="${paging.endPageNo }" step="1">
						<c:choose>
							<c:when test="${i eq paging.currentPageNo }">
								<li class="active"><a href="javascript:goPage(${i },${paging.maxPost })">${i }</a></li>								
							</c:when>
							<c:otherwise>
								<li><a href="javas	cript:goPage(${i },${paging.maxPost })">${i }</a></li>
							</c:otherwise>
						</c:choose>						
					</c:forEach>
					
					<!-- 소수점 제거 -->
					<fmt:parseNumber var="currentPage" integerOnly="true" value="${(paging.currentPageNo-1)/5 }" />
					<fmt:parseNumber var="finalPage" integerOnly="true" value="${(paging.finalPageNo-1)/5 }" />
					
					<c:if test="${currentPage < finalPage }"><!-- 현재 페이지가 마지막 페이지 보다 작으면 다음을 출력한다 -->
						<li><a href="javascript:goPage(${paging.nextPageNo },${paging.maxPost })"></a></li>
					</c:if>
				</ul>
			</div>
		</c:when>
	</c:choose>
</div>
<script>
	function goPage(pages, lines){
		document.location.href="?pages="+pages;
	}
</script>
<!-- content -->
<%@ include file="../inc/foot.jsp" %>