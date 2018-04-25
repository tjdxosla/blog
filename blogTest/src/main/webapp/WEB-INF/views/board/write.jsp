<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp"%>
<script src="../resources/js/board.js"></script>
<c:if test="${not empty result}">
<script type="text/javascript">
	alert("등록 되었습니다.");
	document.location.href="/";
</script>

</c:if>
<form class="form-horizontal" name="board_frm" role="form" onSubmit="return boardCheck(document.board_frm)" >
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="bName" name="bName" placeholder="First & Last Name" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Title</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="bTitle" name="bTitle" placeholder="Enter The Title" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="message" class="col-sm-2 control-label">Message</label>
		<div class="col-sm-8">
			<textarea class="form-control" rows="10" name="message"></textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-9">
			<button type="submit" class="btn btn-primary">Send</button>
		</div>
	</div>
</form>
<%@ include file="../inc/foot.jsp"%>