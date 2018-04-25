<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<script type="text/javascript" src="../resources/js/utile.js"></script>
<!-- content -->
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>글 번호</th>
			<td class="col-sm-9">${view.idx }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td class="col-sm-9">${view.bName }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td class="col-sm-9">${view.bdate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td class="col-sm-9">${view.bHit }</td>
		</tr>
		<tr>
			<th rowspan="5">내용</th>
			<td class="col-sm-9">${view.message }</td>
		</tr>		
	</table>
	<div class="viewButton">
		<a href="javascript:recommend('${view.idx }','${sessionScope.id }')"><button class="btn btn-primary" type="button">추천을 꾸욱~!!! <span class="badge">${view.recommend }</span></button></a>
		<a href="/"><button type="button" class="btn btn-primary">메인 페이지로 이동</button></a>
	</div>

</div>
<!-- content -->
<%@ include file="../inc/foot.jsp" %>