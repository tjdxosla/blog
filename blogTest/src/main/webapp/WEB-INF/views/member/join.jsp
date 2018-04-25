<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<script type="text/javascript" src="../resources/js/member.js"></script>
<c:if test="${not empty result and result eq 1}">
<script>
	alert("회원가입이 완료 되었습니다.");
	document.location.href="./login";
</script>
</c:if>
<!-- content -->
<div class="container">
	<form class="form-horizontal" name="join_form" onSubmit="return joinCheck(document.join_form)">
		<input type="hidden" name="idc" value="n">
		<h2 class="form-singup-heading">회원가입</h2>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">아이디(이메일주소):</label>
			<div class="col-sm-8">
				<input type="email" class="form-control" id="id" placeholder="Enter email" name="id">				
			</div>
			<a href="javascript:idCheck()"><button type="button"class="btn btn-danger" id="idCheck">중복확인</button></a>
		</div>		
		<div class="form-group">
			<label class="control-label col-sm-2" for="pass">비밀번호:</label>
			<div class="col-sm-8">
				<input type="password" class="form-control" id="pass" placeholder="Enter password" name="pass">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pass">비밀번호 확인:</label>
			<div class="col-sm-8">
				<input type="password" class="form-control" id="passCheck" placeholder="Enter password" name="passCheck">
			</div>
		</div>		
		<div class="form-group">
			<label class="control-label col-sm-2" for="pass">전화번호:</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="phone" placeholder="Enter password" name="phone">
			</div>			
		</div>
		<div class="btn-right">					
			<button type="submit" class="btn btn-primary">회원가입</button>
			<a href="/"><button type="button" class="btn btn-danger">취소</button></a>
		</div>			
	</form>
</div>
<!-- content -->
<%@ include file="../inc/foot.jsp" %>