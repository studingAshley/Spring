<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/css/findId.css">
				<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	</head>
	

	
		<body>
		<div class="logo">
		<a href="login" style="cursor: pointer; color: #50b7f5; text-decoration: none;"><img src="/images/cross.jpg" style="padding-top: 50px;"></a>
		
			<div class="mypage_main" >
		               <div class="find">
		               <ul class="mypage_password"><strong>아이디 찾기</strong>
		               	<div class="findid_content">
					<div>
					<input type="email" id="email" name="email" class="inp2" placeholder="이메일을 입력하세요">
					<span>@</span> 
					<select type="text" id="email1" name="email1" class="inp_2_1" list="emailList" placeholder="도메인 선택" style="font-size: 0.6em;color: gray;">
                    	<option selected >메일선택</option>
                    	<option>naver.com</option>
                    	<option>google.co.kr</option>
                    	<option>nate.com</option>
                    	<option>daum.com</option>
                    </select>
                    <br><br>
					<button id="emailCheck" class="emailCheck">코드발송</button>
					</div>
					<br><br>
					<div class="code" style="visibility: hidden; display: inline-block;">
					<input type="text" id="email" name="email" class="inp2" placeholder="인증번호를 입력하세요">
					<button id="emailChk2" class="emailChk2">확인</button>
					<br>
					인증번호가 일치합니다.
					</div>
					<br><br>
					<div class="code2" style="visibility: hidden; display: inline-block;">
					<input type="text" id="email" name="email" class="inp2" placeholder="aaa" disabled>
					<button id="Remain" class="Remain">로그인화면으로이동</button>
					</div>
					
		               	<!-- <li>새 비밀번호</li>
		               	<input type="password" class="new_pw">
		               	<li>비밀번호 확인</li>
		               	<input type="password" class="chk_pw"> -->
		               </ul>
		               <br>
		               <!-- <div class="savebtn">로그인화면으로이동</div> -->
		               </div>
		     </div>
		     <br><br>
		     	<!-- <div class="foot" style="margin-top: 100px;">
						<h3>Cross 새로운 소통의 시작</h3>
						<b>조원정보: 박기석팀장,배향연부팀장,소현우,홍여경,이지원,류진민</b>
				</div> -->
				
				<script>
				 $(function(){
					$(".Remain").click(function(){
						location.href="login";
					}); 
					$(".emailCheck").click(function(){
						alert("인증번호가 발송되었습니다.");
						$(".code").css("visibility","visible");
					})
					
					$(".emailChk2").click(function(){
						alert("인증번호가 확인되었습니다.");
						$(".code2").css("visibility","visible");
					}) 
					
					
				 });
				</script>
		</div>
	
		</body>
</html>