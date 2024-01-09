<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<meta charset="UTF-8">
<title>Chart</title>


<script>

	$(function(){
		
		const ctx = $('#myChart');

		$("#cbtn").click(function(){

			let chartStatus = Chart.getChart("myChart");
			
			if(chartStatus != undefined)
			{
				chartStatus.destroy();
				console.log("차트리셋");
			}
			
			let cyear = $("#cyear").val();
			$.ajax({
				
				url:"/layout/incomeSelect",
				data:{"cyear":cyear},
				dataType:"json",
				type:"post",
				success:function(data)
				{
									
					console.log(data);
					let chartData2 = data;
										
					console.log(chartData2[0]);
					let chartLabels=['1월', '2월', '3월', '4월', '5월', '6월'];
					let charData = [[12, 19, 3, 5, 2, 3],[22, 9, 9, 0, 22, 1]];
					
					  new Chart(ctx, {
					    type: 'bar',
					    data: {
					      datasets: [{
					        label: cyear+'csale',
					        data: chartData2 ,
					        parsing: {
					        	xAxisKey: 'cmonth',
					            yAxisKey: 'csale'
					         },
					         backgroundColor: [
					             'rgb(255, 99, 132)',
					             'rgb(54, 162, 235)',
					             'rgb(255, 205, 86)',
					             'rgb(255, 99, 132)',
					             'rgb(54, 162, 235)',
					             'rgb(255, 205, 86)'
					           ],
					        borderWidth: 1
					      },
					      
						  ]
					    },
					    options: {
					      scales: {
					        y: {
					          beginAtZero: true
					        }
					      }
					    }
					  });
					  
					  
				},
				error:function()
				{
					alert("실패");
				}
			})
			
			
		})
		
		
		
		  
	})

</script>
<style>
.area{width:80%; margin:20px auto; border: 2px solid black;}
</style>

</head>
<body>
<select id="cyear">
	<option value="2022년">2022년</option>
	<option value="2023년">2023년</option>
</select>
<button id='cbtn'>차트데이터 가져오기</button>
<div class="area">
  <canvas id="myChart"></canvas>
</div>

</body>
</html>