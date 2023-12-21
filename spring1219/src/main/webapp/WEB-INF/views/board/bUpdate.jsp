<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글수정</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
    	$(function(){
    		if(${session_id==null})
    		{
    			//alert("로그인 후 게시글을 수정할 수 있습니다.");	
    			//location.href= history.back();
    		}
    	})
    
    </script>
</head>
<body>
<section>
    <h1>게시글수정</h1>
    <hr>

    <form action="doBUpdate" name="upateFrm" method="post" encType="multipart/form-data">
      <table>
      <input type="hidden" name="bfile" value="${bdto.bfile}">
      <input type="hidden" name="bno" value="${bdto.bno}">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="id" value="${bdto.id}" readonly>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle" value="${bdto.btitle}">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bcont" cols="50" rows="10">${bdto.bcont }
           
            </textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
           	<img style="width:300px;" src="/upload/${bdto.bfile}">
          </td>
        </tr>
        <tr>
          <th>파일첨부</th>
          <td>
            <input type="file" name="files" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">수정완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='bList'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>