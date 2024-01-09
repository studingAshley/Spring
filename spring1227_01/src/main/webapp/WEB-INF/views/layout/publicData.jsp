<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Public Data</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	#main{width:1600px; margin:20px auto; text-align: center;}
	#body{width:1400px; height:700px; margin:20px auto; border:3px solid black; overflow: scroll; }
	table{width:1400px; margin:0 auto;}
	table,th,td{border:1px solid black; border-collapse: collapse;}
	th{height:40px; }
	td{height:35px;}
	td img{width:200px;}
</style>

<script>
	$(function(){
		$("#btn").click(function(){
			alert("공공데이터를 검색합니다.");
			
			let word = $("#txt").val();
			$.ajax({
				url:"/layout/searchData",
				type:"post",
				data:{"txt":word},
				dataType:"json",
				success:function(data)
				{
					alert("접속성공");
					console.log(data.response.body.items.item[0]);
					let iarr = data.response.body.items.item;
					let hdata = "";
					
					for(let i=0;i<iarr.length;i++)
					{
						hdata += "<tr>";
						hdata += "<td>"+iarr[i].galContentId+"</td>";
						hdata += "<td>"+iarr[i].galTitle+"</td>";
						hdata += "<td>"+iarr[i].galCreatedtime+"</td>";
						hdata += "<td>"+iarr[i].galPhotographyLocation+"</td>";
						hdata += "<td>"+iarr[i].galPhotographer+"</td>";
						hdata += "<td>"+iarr[i].galSearchKeyword+"</td>";
						hdata += "<td><img src='"+iarr[i].galWebImageUrl+"'></td>";
						hdata += "</tr>";						
					}


					$("#content").html(hdata);
				},
				error:function()
				{
					alert("네트워크연결실패");
				}
				
			})
		})
		
	})
</script>
</head>
<body>
	<div id="main">
		<h1> Public Data </h1>
		<input type="text" name="txt" id="txt" >
		<button id="btn">Search</button>
		<br><br>
		<div id="body">
			<table>
				
				<colgroup>
					<col width="8%">
					<col width="13%">
					<col width="10%">
					<col width="13%">
					<col width="13%">
					<col width="23%">
					<col width="20%">
					
				</colgroup>
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>촬영일</td>
						<td>촬영장소</td>
						<td>촬영자</td>
						<td>키워드</td>
						<td>사진</td>
						
					</tr>
				</thead>
				<tbody id="content">
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>