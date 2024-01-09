/**
 * 
 */

 $(function(){
	
	let checkKeyUp = true;
	
	$("#saveBtn").click(function(){
		if(checkKeyUp==true)
		{
			alert("아이디 중복 확인을 하셔야 가입이 가능합니다");
			$("#chkTxt").text("아이디 중복 확인을 하셔야 가입이 가능합니다");
			$("#chkTxt").css({"color":"blcak","font-weight":"700"});
			return false;
		}
		
		
		$.ajax({
			
			url:"mInsert",
			type:"post",
			data:$("#memberFrm").serialize(),
			dataType:"text",
			//contentType :"json" // 보내는 데이터 타입
			success:function(data)
			{
				if(data=='가입완료')
				{
					alert("회원가입이완료되었습니다.");
					location.href="/";
				}
			},
			error:function()
			{
				alert("error");
			}
		});
			
		
	})
	
	
		$("#id").keyup(function(){
			e= $("#id").val();
			console.log(e);
			checkKeyUp=true;
		});
		
		 
	 $("#idCheckBtn").click(function(){
		
	
		$.ajax({
			
			url:"idCheck",
			type:"post",
			data:{"id":$("#id").val()},
			//data:{"id":$("#memberFrm").serialize(),"pw":$("#pw").val()},
			dataType:"text",
			//contentType :"json" // 보내는 데이터 타입
			success:function(data)
			{

				console.log("ajax data : "+data);
				if(data=='Available')
				{
					$("#chkTxt").text("사용가능한아이디");
					$("#chkTxt").css({"color":"green","font-weight":"700"});
					checkKeyUp=false;
				}
				else
				{
					$("#chkTxt").text("사용불가능한아이디");
					$("#chkTxt").css({"color":"red","font-weight":"700"});
					checkKeyUp=true;
				}
				
			},
			error:function()
			{
				alert("error");
			}
			
			
		}); 
	 });
 });