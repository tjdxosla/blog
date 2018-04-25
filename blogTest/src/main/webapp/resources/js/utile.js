/**
 * 
 */

function recommend(idx, userId){
		
	if(userId=="undefined"||userId==""){
		alert("회원만 추천 가능 합니다.");
		return false;
	}
	
	$.ajax({
		data:{
			idx:idx,
			userId:userId
		},
		url : "./recommend",
		success:function(data){
			if(data==0){
				alert("추천한 게시글 입니다.");
				return false;
			}else if(data==1){
				alert("추천이 완료 되었습니다.");
				window.location.reload();
			}
		}
	});	
}