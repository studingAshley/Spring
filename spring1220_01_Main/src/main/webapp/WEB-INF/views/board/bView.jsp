<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/read.css">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>

<style>
.replyBox{width:100%; border-top:1px #d9d9d9 solid; overflow:hidden;}
.replyBox ul{position:relative; border-bottom:1px #d9d9d9 solid; margin:15px 0 0 0; padding:0 20px 15px 20px;}
.replyBox ul li.name{font-size:14px; font-weight:600; color:#555; padding:0 0 10px 0;}
.replyBox ul li.name span{font-size:12px; color:#888; font-weight:normal;}
.replyBox ul li.txt{width:100%; color:#888; line-height:1.5; font-size:13px; word-break:keep-all;}
.replyBox ul li.btn{text-align:right; height:20px; padding:3px 0 0 0;}
.replyBox ul li.btn .rebtn{display:inline-block; width:43px; height:23px; line-height:22px; color:#777; font-weight:600; text-align:center; background:url('../images/btn/btn_daybtn.gif') left top no-repeat;}
.replyBox ul li.btn .rebtn:hover{color:#777;}
</style>
<script>

</script>
</head>
<body>

<script>
	$(function(){
		
		$(".bDelete").click(function(){
			if(confirm("삭제하시겠습니까?"))
			{
				$("#bFrm").attr("action","bDelete").submit();
			}
			else
			{
				return false;
			}
		})
		
		$(".bUpdate").click(function(){

			$("#bFrm").attr("action","bUpdate").submit();

		})
		
		$(".bReply").click(function(){

			$("#bFrm").attr("action","bReply").submit();

		})
		
	})
</script>
<section>
    <h1>NOTICE</h1>

<form name="bFrm" id="bFrm" method="post" >
	<input type="hidden" name="bno" value="${map.bdto.bno }">
    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${map.bdto.btitle }</strong></td>
      </tr>
      <tr>
        <td>${map.bdto.id}</td>
        <td>조회수</td>
        <td>${map.bdto.bhit }</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${map.bdto.bcont }</td>
      </tr>
      <tr><td colspan="3"><strong>이미지표시<strong></td></tr>
       <tr>
        <td colspan="3" class="fileImg"><img style="width:300px;" src ="/upload/${map.bdto.bfile}"></td>
      </tr>
      <tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span><a href="bView?bno=${map.preBdto.bno}"> ${map.preBdto.btitle }</a></td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span><a href="bView?bno=${map.nextBdto.bno}">${map.nextBdto.btitle }</a></td>
      </tr>
      <tr colspan="3">
      	<td>
     	 <div class="replyWrite">
			<ul>
				<li class="in">
					<p class="txt">총 <span class="orange">3</span> 개의 댓글이 달려있습니다.</p>
					<p class="password">비밀번호&nbsp;&nbsp;<input type="password" class="replynum" /></p>
					<textarea class="replyType"  style="width:800px; height:150px;"></textarea>
				</li>
				<li class="btn"><a class="replyBtn" style="cursor: pointer; border: solid 1px black;">등록</a></li>
			</ul>
			<p class="ntic">※ 비밀번호를 입력하시면 댓글이 비밀글로 등록 됩니다.</p>
		</div>
      	</td>
      </tr>
       <tr>
        <td colspan="3">
        <div class="replyBox">
	        <ul>
	        	<li class="name"> <p> <span>[date]</span></p> </li>
				<li class="txt">content</li>
				<li class="btn">
					<a  class="rebtn modi" renoValue=""  style="cursor: pointer; border: solid 1px black;">수정</a>
					<a  class="rebtn del" renoValue=""  style="cursor: pointer; border: solid 1px black;">삭제</a>
				</li>
	        </ul>
	    </div>
        </td>
      </tr>
    </table>

    <a href="bList"><div class="list">목록</div></a>
    <c:if test="${session_id!=null }"> 
	    <c:if test="${session_id == map.bdto.id }">
			 <div class="list bDelete">삭제</div>
			 <div class="list bUpdate">수정</div>
	    </c:if>
   
	  	<div class="list bReply">답변달기</div>
    </c:if>
  </section>
 </form>
</body>
</html>