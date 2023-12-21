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
<h1>1221 index 페이지 입니다</h1>
<ul>
<a href="/"><li>메인화면</li></a>
<a href="list"><li>기본리스트</li><a>
<a href="list2"><li>사원+부서 병합리스트</li><a>
<a href="list3"><li>멤버+보드 병합리스트</li><a>
<a href="mInsert"><li>회원가입</li><a>
<c:if test="${session_id==null}">
	<a href="login"><li>로그인</li><a>
</c:if>
<c:if test="${session_id!=null }">
	<a href="logout"><li>로그아웃</li><a>
	<li></li>${session_name }
</c:if>

</ul>
</body>
</html>