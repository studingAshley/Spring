<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doBInsert</title>
</head>
<body>

<script>

	if(${result !=null})
	{
			alert("게시글이저장되었습니다.");
			location.href="bList";	
	}
	else
	{
		alert("게시글 저장에 실패했습니다.");
		location.href= history.back();
	}
</script>

</body>
</html>