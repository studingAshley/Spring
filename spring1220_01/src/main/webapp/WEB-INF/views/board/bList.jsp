<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/notice_list.css">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
  	$(function(){
  		$("#searchBtn").click(function(){
  			if($("#searchWord").val().length<1)
  			{
  				alert("검색어를 입력해주세요");
  				return false;
  			}
  			search.submit();
  		})
  	})
  </script>
</head>
<body>
<section>
    <a href="bList"><h1>NOTICE</h1></a>
    <div class="wrapper">
      <form action="bList" name="search" method="post">
        <select name="category" id="category">
        
          <option value="all" <c:if test="${category=='all'}">selected="selected"</c:if> >전체</option>
          <option value="btitle" <c:if test="${category=='btitle'}">  selected="selected"</c:if> >제목</option>
          <option value="bcont" <c:if test="${category=='bcont'}">  selected="selected"</c:if>  >내용</option>
        </select>

        <div class="title">
          <input type="text" size="16" name="searchWord" id="searchWord" value="${searchWord}">
        </div>
  
        <button type="button" id="searchBtn"><i class="fas fa-search"></i></button>
      </form>

    </div>
    

    <table>
      <colgroup>
        <col width="18%">
        <col width="50%">
        <col width="18%">
        <col width="10%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <!-- 내용부분 -->
      <c:forEach items="${list}" var="bdto" >
	      <tr>
	        <td><span class="table-notice">${bdto.bno }</span></td>
	        <td class="table-title"><c:forEach begin="1" end="${bdto.bindent}">&nbsp</c:forEach>
	        <a href="bView?bno=${bdto.bno}">${bdto.btitle }</a>
	        </td>
	        <td>${bdto.bdate }</td>
	        <td>${bdto.bhit }</td>
	      </tr>
      
      </c:forEach>
      
    </table>

    <ul class="page-num">
    	<a href="bList?page=1&category=${category}&searchWord=${searchWord}">      <li class="first"></li>    	  	</a>
    	<c:if test="${page>1 }">
	   		<a href="bList?page=${page-1}&category=${category}&searchWord=${searchWord}">     		<li class="prev"></li>     	</a>    	
    	</c:if>
      <c:forEach begin="${startPage}" end="${endPage}" step="1" varStatus="vs" var="i">
	      <a href="bList?page=${i}&category=${category}&searchWord=${searchWord}">
	      	<c:if test="${page==i}">
	      		<li class="num on">
	      	</c:if>
	      	<c:if test="${page!=i}">
		      <li class="num">
		    </c:if>
		      	<div>${i}</div>          
		      </li>
		  </a>
      </c:forEach>
      <c:if test="${page<maxPage }">
      <a href="bList?page=${page+1}&category=${category}&searchWord=${searchWord}">      	<li class="next"></li>      </a>
      </c:if>
      <a href="bList?page=${maxPage}&category=${category}&searchWord=${searchWord}">
	      <li class="last"></li>      
      </a>
    </ul>

	<c:if test="${session_id!=null }">
		    <a href="bWrite"><div class="write">쓰기</div></a>
	</c:if>

  </section>

</body>
</html>