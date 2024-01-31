<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<title>CROSS</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="css/style_x_ui.css">
<link rel="stylesheet" href="node_modules/reset.css/reset.css">




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.js" ></script>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script src="js/cross/analystic.js"></script>


    
    
</head>
 <body>
 
 <div id="view-box" >
 
		<%@ include file="/WEB-INF/views/sidebar.jsp" %>
	

 <main>
 
	<div class="header">
		<span class="material-icons arrow_back">arrow_back</span>
		<h2>게시활동</h2>
	</div>
	
	<div class="analystic_wrab" style="padding:2rem;">
		<div class="hitCounters" style="margin-bottom:2rem; padding-bottom :2rem;">
			<span>노출수 : 100 </span><br><br>
			<span>조회수 : 100 </span>
		</div>
	
		<div class="hitChart">
			<canvas id="analysisChart"></canvas>
		</div>
	</div>
	<script type="text/javascript">
			$(document).ready(function() {


				const ctx = $('#analysisChart');

				let chartStatus = Chart.getChart("analysisChart");
				
/* 				if(chartStatus != undefined)
				{
					chartStatus.destroy();
					console.log("차트리셋");
				}
				 */
				let postid = 0;
				$.ajax({
					
					url:"selectedAnalysis",
					data:{"post_id":postid},
					dataType:"json",
					type:"post",
					success:function(data)
					{
			
						//console.log(data);
						
											
						
					 	let chartLabels=['0시', '6시', '12시', '18시'];
						let chartData2 = data;
						console.log(data)
						console.log(chartData2);
						  new Chart(ctx, {
						    type: 'bar',
						    data: {
						      labels: chartLabels,
						      datasets: [{
						        label: '시간대 조회수',
						        data: Object.values(chartData2) ,
						        parsing: {
						        	xAxisKey: 'viewhit',
						            yAxisKey: 'time'
						         },
						         backgroundColor: [
						             'rgb(255, 99, 132)',
						             'rgb(54, 162, 235)',
						             'rgb(255, 205, 86)',
						             'rgb(255, 99, 132)'
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
					
				});
			
		})
		

	</script>
 
       
 </main>
    <!-- main section end -->
    
 </div>


<!-- Modal -->


<!-- Modal End -->


  </body>

  
  
</html>