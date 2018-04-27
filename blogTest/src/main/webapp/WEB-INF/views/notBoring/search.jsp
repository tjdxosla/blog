<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/head.jsp" %>	
<script type="text/javascript">
	function searchYoutube(){
		var q = $("#search").val();		
		document.location.href="https://www.youtube.com/results?search_query="+q;
	}
</script>

<div class="container">
	<div id="buttons" class="text-right">
		<label> <input id="query" value='' type="text" placeholder="검색"/><button id="search-button">Search</button></label>
	</div>
	<div id="search-result" class="text-center">
	</div>
	<div id="search-container" class="text-center">
	</div>
</div>

    
    <script src="../resources/js/auth.js"></script>
    <script src="../resources/js/search.js"></script>
    <script src="https://apis.google.com/js/client.js?onload=googleApiClientReady"></script>
<%@ include file="../inc/foot.jsp" %>

