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
<h1>1219 index 페이지 입니다</h1>
<ul>
<a href="/"><li>메인화면</li></a>
<a href="bList"><li>공지사항리스트(noticeList)</li><a>
<a href="bList2"><li>다중업로드공지사항리스트(noticeList)</li><a>
<a href="mInsert"><li>회원가입</li><a>
<a href="bView?bno=1050"><li>글번호</li><a>
<a href="login"><li>로그인</li><a>
<a href="bInsert2"><li>다중업로드</li><a>
<a href="bInsert"><li>글쓰기</li><a>

<a href="/board/bView"><li>공지사항보기(noticeView)</li><a>
<a href="/board/bInsert"><li>공지사항글쓰기(noticeInsert)</li><a>
</ul>
</body>
</html>