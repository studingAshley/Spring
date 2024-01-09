/**
 * 
 */
$(function(){
	
	$(".btn_login").click(function(){
		
		if($("#uId").val().length<1)
		{
			$("#uId").attr("placeholder","아이디를 입력하세요");
			$("#uId").focus();
			return false;
		}
		
		login.submit();
	})
	
})