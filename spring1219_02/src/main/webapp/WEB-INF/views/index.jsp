<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1219 02 index 페이지 입니다</h1>
<ul>
<a href="/"><li>메인화면</li></a>
<a href="list"><li>공지사항리스트(noticeList)</li><a>
<c:if test="${session_id==null }">
	<a href="login"><li>로그인</li><a>
</c:if>
<c:if test="${session_id!=null }">
	<li>${session_name }</li>
	<a href="logout"><li>로그아웃</li><a>
</c:if>
<a href="bInsert"><li>글쓰기</li><a>


</ul>
</body>
</html>