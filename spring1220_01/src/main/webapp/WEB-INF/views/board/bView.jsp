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
      
       <tr>
        <td colspan="3"><div style="border: solid 1px black;"><input type="text" style="padding:3px; width :800px; height: 150px; border: none;"><input type="button" value="답글"></div></td>
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