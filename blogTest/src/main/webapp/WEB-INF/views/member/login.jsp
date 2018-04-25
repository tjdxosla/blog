<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>
<!-- content -->
<div class="container">
	<form class="form-signin" name="login_form" onSubmit="return login(document.login_form)">
		<h2 class="form-signin-heading">로그인</h2>
		<label for="inputEmail" class="sr-only">아이디(이메일주소)</label>
		<input type="email" id="id" class="form-control" placeholder="Enter Your Id" required autofocus name="id">
		<label for="inputPassword" class="sr-only">비밀번호</label>
		<input type="password" id="pass" class="form-control" placeholder="Password" required name="pass">
		<div class="checkbox">
			<label>
				<input type="checkbox" value="remember-me"> 자동 로그인
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
	</form>
</div>
<!-- content -->
<script src="../resources/js/member.js"></script>
<%@ include file="../inc/foot.jsp" %>