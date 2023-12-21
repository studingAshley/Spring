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

	if(${result == 1})
		{
		 alert("게시글이 수정되었습니다.");
		 location.href="bList";
		}
	else
		{
		alert("게시글 수정에 실패했습니다.");
		location.href=history.back();
		}
</script>

</body>
</html>