/**
 * join form check
 * param : join_form
 * function : validation
 */
function joinCheck(frm){
	var f = frm;
	
	if(f.id.value==""){
		alert("아이디(이메일)을 입력해 주세요");
		f.id.focus();
		return false;
	}

	if(f.pass.value==""){
		alert("비밀번호를 입력해 주세요");
		f.pass.focus();
		return false;
	}
	
	if(f.pass.value.length<=5){
		alert("비밀번호를 5자리 이상 입력해 주세요");
		f.pass.focus();
		return false;
	}
	
	if(f.passCheck.value==""){
		alert("비밀번호를 한번 더 입력해 주세요");
		f.passCheck.focus();
		return false;
	}	
	
	if(f.passCheck.value!=f.pass.value){
		alert("비밀번호를 동일하게 입력해 주세요");
		f.passCheck.value="";
		return false;
	}
	
	if(f.phone.value==""){
		alert("휴대폰 번호를 동일하게 입력해 주세요");
		f.phone.focus();
		return false;
	}
	
	f.method="POST";
	f.submit();	
}

function idCheck(){
	var id = $("#id").val();	
	
	if(id==""){
		alert("아이디(이메일)을 입력해 주세요");
		$("#id").focus();
		return false;
	}
	
	if(id.indexOf("@")==-1 || id.indexOf(".")==-1||id.indexOf("@.")!=-1||id.indexOf(".@")!=-1){
		alert("이메일 주소 정확하게 입력해 주세요");
		$("#id").focus();
		return false;
	}
	
    $.ajax({
        data : {
            id : id
        },
        url : "./idCheck",
        success : function(data) {
        	if(data==1){
        		alert("이미 가입한 아이디 입니다. 확인 바랍니다.");
        		$("#id").val("");
        		$("#idCheck").attr('class','btn btn-danger');
        	}else{
        		$("input[name=idc]").val("y");        		
        		$("#idCheck").attr('class','btn btn-success');
        		alert("가입 가능한 아이디 입니다.");
        	}
        }
    });

}

function login(frm) {
	
	var f = frm;
	
	if(f.id.value.indexOf("@")==-1 || f.id.value.indexOf(".")==-1|| f.id.value.indexOf("@.")!=-1|| f.id.value.indexOf(".@")!=-1){
		alert("이메일 주소 정확하게 입력해 주세요");
		$("#id").focus();
		return false;
	}
	
	f.method="POST";
	f.submit();	
}
