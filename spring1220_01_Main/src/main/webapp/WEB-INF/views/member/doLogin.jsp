<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>

	if(${session_id == null})
	{
		alert("아이디 또는 패스워드가 일치하지 않습니다.");
		location.href=history.back();
	}
	else
	{
		location.href="/";
	}
</script>
</body>
</html>