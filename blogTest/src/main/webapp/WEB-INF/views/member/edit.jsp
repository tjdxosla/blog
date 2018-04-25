<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<script type="text/javascript" src="../resources/js/member.js"></script>
<c:if test="${not empty msg }">
<script>
	alert("${msg}");
	document.location.replace("./edit");
</script>

</c:if>
<!-- content -->
<div class="container">
<div class="text-center">
	<a href="./leave?id=${sessionScope.id }"><button type="button" class="btn btn-danger">회원탈퇴</button></a>
</div>
</div>
<!-- content -->
<%@ include file="../inc/foot.jsp" %>