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
</head>
<body>
<section>
    <h1>NOTICE</h1>

    <table>
      <colgroup>
        <col width="15%">
        <col width="50%">
        <col width="15%">
        <col width="20%">
        

      </colgroup>
      <tr>
        <th > <strong>글번호</strong></th>
        <th colspan="3">  ${map.bdto.bno } </th>
      </tr>
      <tr>
        <th >제목</th>
        <th colspan="3"><strong>${map.bdto.btitle }</strong></th>
      </tr>
      <tr>
      	<th><strong>작성자</strong></th>
        <td>${map.bdto.id}</td>
        <td>조회수</td>
        <td>${map.bdto.bhit}</td>
      </tr>
      <tr>
        <td colspan="4" class="article">${map.bdto.bcont }</td>
      </tr>
        <c:set var="imgArr" value="${fn:split(map.bdto.bfile,',')}" />
   		<c:forEach var="imgName" items="${imgArr}" varStatus="vs">	
	   		<tr>
	   			<th>파일이름${vs.count}</th>
		      	<td>${imgName}</td>
	   		</tr>
		    <tr>
			    <th>이미지</th>
			    <td colspan="3" class="file"> <img style="width:300px;"src="/upload/${imgName}"></td>
		    </tr>
        </c:forEach>
      <tr>
      <c:if test="${map.bdtoNext != null}">
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span><a href="bView?bno=${map.bdtoNext.bno}"> ${map.bdtoNext.btitle} </a></td>
      </c:if>
       <c:if test="${map.bdtoNext != null}">
        <td colspan="3"><strong>마지막 글입니다</strong> </td>
      </c:if>
      </tr>
      <tr>
      <c:if test="${map.bdtoPrev != null}">
     	 <td colspan="3"><strong>이전글</strong> <span class="separator">|</span><a href="bView?bno=${map.bdtoPrev.bno}"> ${map.bdtoPrev.btitle } </a></td>
      </c:if>
      <c:if test="${map.bdtoPrev == null}">
        <td colspan="3"><strong>마지막 글입니다</strong> </td>
       </c:if>
      </tr>
    </table>

    <a href="bList"><div class="list">목록</div></a>
    <a href=""><div class="list">삭제</div></a>
    <a href=""><div class="list">수정</div></a>
    <a href=""><div class="list">답변달기</div></a>
  </section>
</body>
</html>