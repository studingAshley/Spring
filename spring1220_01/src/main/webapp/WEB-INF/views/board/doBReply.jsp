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

	if(${result != 1})
	{
		alert("게시글 작성에 실패했습니다.");
		location.href=history.back();
	}
	else
	{
		//location.href="bView?bno=${bno}";
		location.href="bList";
	}
</script>
</body>
</html>