<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Screen Data</title>
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
			alert("영화정보를 검색합니다.");
			
			let word = $("#txt").val();
			$.ajax({
				url:"/layout/searchScreen",
				type:"post",
				data:{"txt":word},
				dataType:"json",
				success:function(data)
				{
					alert("접속성공");
					console.log(data);
					
					let iarr = data.boxOfficeResult.dailyBoxOfficeList;
					let hdata = "";
					
					for(let i=0;i<iarr.length;i++)
					{
						hdata += "<tr>";
						hdata += "<td>"+iarr[i].rank+"</td>";
						hdata += "<td>"+iarr[i].rankInten+"</td>";
						hdata += "<td>"+iarr[i].movieNm+"</td>";
						hdata += "<td>"+iarr[i].openDt+"</td>";
						hdata += "<td>"+Number(iarr[i].audiAcc).toLocaleString()+"</td>";
						hdata += "<td>"+Number(iarr[i].salesAcc).toLocaleString()+"</td>";
						hdata += "<td></td>";
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
		<h1> Screen Data </h1>
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
						<td>순위</td>
						<td>전일대비</td>
						<td>영화제목</td>
						<td>개봉일</td>
						<td>누적관객수</td>
						<td>누적판매액</td>
						<td>포스터</td>
						
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