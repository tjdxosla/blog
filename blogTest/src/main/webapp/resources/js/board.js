/**
 * 
 */
function boardCheck(frm){
	var f = frm;
	
	if(f.bName.value==""){
		alert("작성자 이름을 입력해 주세요");
		f.bName.focus();
		return false;
	}
	
	if(f.bTitle.value==""){
		alert("제목을 입력해 주세요");
		f.bTitle.focus();
		return false;		
	}
	
	if(f.message.value==""){
		alert("내용을 입력해 주세요");
		f.message.focus();
		return false;		
	}
	
	f.method="POST";
	f.submit();
}