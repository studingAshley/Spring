<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>CROSS</title>
    
    <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/js/cross/index.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
 
    <link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
		crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/node_modules/reset.css/reset.css">    
    <link rel='stylesheet' type='text/css' href='/css/profile.css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="/css/style_x_ui.css">
    <link rel="stylesheet" href="/css/style_x_ui_ks.css">
    
      
    
</head>

<body>
	<div id="view-box"
		style="display: flex; justify-content: center; border-left: 1px solid var(--twitter-line-color);">
		<%@ include file="/WEB-INF/views/sidebar.jsp" %>
		<div class="middlecontainer" >
   		<%@ include file="/WEB-INF/views/profile/main.jsp" %>
        	<section class="tweets">
              <div class="heading">
                   <div class="heading_content">게시물</div>
                   <div class="heading_reply">답글</div>
                   <div class="heading_media">미디어</div>
                   <div class="heading_like">마음에 들어요<div class="like_underbar"></div></div>
               </div>
           	</section>
         
			<!-- Post -->
			<div id="post_wrap">


				<c:forEach var="pdto" items="${plist}" varStatus="status">
					<div class="post" style="position: relative;">

						<div class="post_profile-image rounded-5">
							<img class="" src="/upload/${ulist[status.index].profile_img}"
								alt="profile">
							<div style="position: absolute; height: 100%; width: 80px;">

								<c:if
									test="${plist[status.index].post_id == plist[status.index+1].pindent}">
									<div
										style="width: 3px; height: 98%; top: -3px; background-color: var(--twitter-line-color); position: absolute; left: 25%;">
									</div>
								</c:if>

							</div>
						</div>

						<div class="post_body">
							<div class="post_header">
								<div class="post_header-text">
									<h3>
										${ulist[status.index].name}<span class="header-icon-section">@${ulist[status.index].user_id}
										</span>
									</h3>
									<div style="margin-left: 1rem; text-align: center;">
										<h3>${plist[status.index].created}</h3>
									</div>
								</div>

								<div class="post_header-discription"
									onclick="location.href='/viewContent?post_id=${plist[status.index].post_id}'">
									<p>${plist[status.index].pcontent}</p>
									<c:if test="${plist[status.index].plocation!=null}">
										<div class="" style="color:gray">
											<div style="display: flex;">
												<span class="material-icons">location_on</span>
												<div>${plist[status.index].plocation}</div>
											</div>
										</div>
									</c:if>
									
									
								</div>
							</div>

							<c:if
								test="${fn:contains(mlist[status.index].file_type,'video')}">
								<div class="container video_contaner">
									<video controls loop muted preload="auto"
										src="/upload/${mlist[status.index].file_name}">
									</video>
								</div>
							</c:if>

							<c:if
								test="${fn:contains(mlist[status.index].file_type,'image')}">
								<c:set var="img"
									value="${fn:split(mlist[status.index].file_name,',')}" />
								<c:if test="${fn:length(img)==1}">
									<div class="container">
										<div class="row row-cols-auto ">
											<div class="col-md-auto img-xl rounded-4">
												<img src="/upload/${mlist[status.index].file_name}"
													class="rounded " alt="java18" data-bs-toggle="modal"
													data-bs-target="#exampleModal"
													data-bs-whatever="/upload/${mlist[status.index].file_name}">
											</div>

										</div>
									</div>
								</c:if>

								<c:if test="${fn:length(img)==2}">
									<div class="container">
										<div class="row row-cols-auto ">
											<div class="col-md-auto img-lg rounded-4">
												<img src="/upload/${img[0]}" class="rounded " alt="java18"
													data-bs-toggle="modal" data-bs-target="#exampleModal"
													data-bs-whatever="/upload/${img[0]}">
											</div>
											<div class="col-md-auto img-lg rounded-4">
												<img src="/upload/${img[1]}" class="rounded " alt="java18"
													data-bs-toggle="modal" data-bs-target="#exampleModal"
													data-bs-whatever="/upload/${img[1]}">
											</div>
										</div>
									</div>
								</c:if>

								<c:if test="${fn:length(img)==3}">
									<div class="container">
										<div class="row row-cols-auto">
											<div class="col-md-auto img-md rounded-4">
												<img src="/upload/${img[0]}" class="rounded " alt="java18"
													data-bs-toggle="modal" data-bs-target="#exampleModal"
													data-bs-whatever="/upload/${img[0]}">
											</div>
											<div class="col-md-auto">
												<div class="row row-cols-auto">
													<div class="col-md-auto img-sm">
														<img src="/upload/${img[1]}" class="rounded " alt="java18"
															data-bs-toggle="modal" data-bs-target="#exampleModal"
															data-bs-whatever="/upload/${img[1]}">
													</div>
												</div>
												<div class="row row-cols-auto">
													<div class="col-md-auto img-sm">
														<img src="/upload/${img[2]}" class="rounded " alt="java18"
															data-bs-toggle="modal" data-bs-target="#exampleModal"
															data-bs-whatever="/upload/${img[2]}">
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:if>

								<c:if test="${fn:length(img)==4}">
									<div class="container img-sm">
										<div class="row">
											<div class="col-md-auto">
												<img src="/upload/${img[0]}" class="rounded " alt="java18"
													data-bs-toggle="modal" data-bs-target="#exampleModal"
													data-bs-whatever="/upload/${img[0]}">
											</div>
											<div class="col-md-auto">
												<img src="/upload/${img[1]}" class="rounded " alt="java18"
													data-bs-toggle="modal" data-bs-target="#exampleModal"
													data-bs-whatever="/upload/${img[1]}">
											</div>
										</div>

										<div class="row">
											<div class="col-md-auto">
												<img src="/upload/${img[2]}" class="rounded " alt="java18"
													data-bs-toggle="modal" data-bs-target="#exampleModal"
													data-bs-whatever="/upload/${img[2]}">
											</div>
											<div class="col-md-auto">
												<img src="/upload/${img[3]}" class="rounded " alt="java18"
													data-bs-toggle="modal" data-bs-target="#exampleModal"
													data-bs-whatever="/upload/${img[3]}">
											</div>
										</div>
									</div>
								</c:if>

							</c:if>

							<div class="post_footer">

								<span class="material-icons ms_icons chat"
									data-bs-toggle="modal" data-bs-target="#writeModal" 
									data-post_id="${plist[status.index].post_id}" 
									data-group="${plist[status.index].pgroup}" 
									data-step="${plist[status.index].pstep}" 
									data-indent="${plist[status.index].pindent}">chat</span>
								<h3>${replycount[status.index]}</h3>
									
								<c:if test="${renoted[status.index]<1}">
									<span class="material-icons ms_icons repeat"
									data-post_id="${plist[status.index].post_id}">repeat</span>
							
								</c:if>
								<c:if test="${renoted[status.index]>=1}">
									<span class="material-icons ms_icons repeat toggle"
									data-post_id="${plist[status.index].post_id}">repeat</span>
							
								</c:if>
							
								<h3>${recount[status.index]}</h3>
								
								<c:if test="${favorited[status.index]<1}">
									<span class="material-icons ms_icons favorite"
									data-post_id="${plist[status.index].post_id}">favorite_border</span>
							
								</c:if>
								<c:if test="${favorited[status.index]>=1}">
									<span class="material-icons ms_icons favorite toggle"
									data-post_id="${plist[status.index].post_id}">favorite</span>
							
								</c:if>
									
								<h3>${facount[status.index]}</h3>
								
								<span class="material-icons ms_icons chart"
								data-post_id="${plist[status.index].post_id}">bar_chart</span>
								<h3>${plist[status.index].hit+1}</h3>

							</div>

						</div>

					</div>

				</c:forEach>
			
        </div>
        </div>
       

      <!-- Modal -->

	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-fullscreen">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">FileName</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body text-center">

					<div class="mb-3">
						<label for="recipient-name" class="col-form-label"><img></label>
					</div>


				</div>

			</div>
		</div>
	</div>




	<div class="modal" id="locationModal" tabindex="-1"
		aria-labelledby="locationModalLabel" aria-hidden="true"
		data-bs-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title fs-6 fw-bold font-family-sans-serif"
						id="locationModalLabel">지역 검색</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body text-center">

					<div class="mb-3">
						<label for="recipient-name" class="col-form-label ">검색:</label> <input
							type="text" class="form-control" id="locSearch"
							data-bs-keyboard="false">
					</div>
					<div class="mb-3">
						<label for="message-text" class="col-form-label  ">검색 결과:</label>
						<div style="">

							<div class="container text-center locArray"
								style="overflow-y: scroll; height: 100px;">

								<div class="row  align-items-start selAddr"
									data-location="Loacation1">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr"
									data-location="Loacation2">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr"
									data-location="Loacation3">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr"
									data-location="Loacation4">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr">
									<div class="col col-2 border-end border-secondary mt-1"
										data-location="Loacation5">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>


								<div class="w-100"></div>

								<div class="row  align-items-start selAddr">
									<div class="col col-2 border-end border-secondary mt-1"
										data-location="Loacation6">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr"
									data-location="Loacation7">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr"
									data-location="Loacation8">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>


								<div class="w-100"></div>

								<div class="row  align-items-start selAddr"
									data-location="Loacation9">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>
							</div>

						</div>
					</div>

				</div>

			</div>
		</div>
	</div>


	<div class="modal" id="writeModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="height: 2rem;">
					<h5 class="modal-title">답글쓰기</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="tweet_box">
						<form>
							<div class="tweet_box-input">
								<div id="modal_text-area" class="rounded" style="position: relative;">

									<textarea rows="" cols="" class="content" id="modal_write-box"
										style="outline: none; width: 380px; border: none; resize: none; overflow: hidden"></textarea>
									<div id="modal_position_wrap" class="invis">
										<div id="position-area" style="display: flex;">
											<span class="material-icons">location_on</span>
											<div id="modal_currLocation"></div>
										</div>
									</div>
									<div id="modal_image-area" style=""></div>

								</div>


							</div>


						</form>
					</div>

				</div>
				<div class="modal-footer">
					<div class="modal_box-footer" style="">


						<label for="modalFile" id="modalImgBtn" class="btn btn-sm btn-dark">사진등록</label>
						<input type="file" id="modalFile" multiple="multiple"> 
						<label for="modalRegPosition" id="modalregBtn" class="btn btn-sm btn-dark"
							data-bs-toggle="modal" data-bs-target="#locationModal2"
							data-bs-whatever="Test">위치등록</label> 
						<input type="button" id="madalRegPosition">
						<button class="modal_write-btn btn btn-sm btn-dark">게시하기</button>


					</div>
				</div>
			</div>
		</div>
	</div>








	<div class="modal" id="locationModal2" tabindex="-1"
		aria-labelledby="locationModalLabel2" aria-hidden="true"
		data-bs-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title fs-6 fw-bold font-family-sans-serif"
						id="locationModalLabel2">지역 검색</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body text-center">

					<div class="mb-3">
						<label for="recipient-name" class="col-form-label ">검색:</label> 
						<input	type="text" class="form-control" id="locSearch"
							data-bs-keyboard="false">
					</div>
					<div class="mb-3">
						<label for="message-text" class="col-form-label  ">검색 결과:</label>
						<div style="">

							<div class="container text-center locArray"
								style="overflow-y: scroll; height: 100px;">

								<div class="row  align-items-start selAddr2"
									data-location="Loacation1">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr2"
									data-location="Loacation2">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr2"
									data-location="Loacation3">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr2"
									data-location="Loacation4">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr2"
									data-location="Loacation5">
									<div class="col col-2 border-end border-secondary mt-1"
										data-location="Loacation5">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>


								<div class="w-100"></div>

								<div class="row  align-items-start selAddr2">
									<div class="col col-2 border-end border-secondary mt-1"
										data-location="Loacation6">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr2"
									data-location="Loacation7">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>

								<div class="w-100"></div>

								<div class="row  align-items-start selAddr2"
									data-location="Loacation8">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>


								<div class="w-100"></div>

								<div class="row  align-items-start selAddr2"
									data-location="Loacation9">
									<div class="col col-2 border-end border-secondary mt-1">우편번호</div>
									<div class="col col-5 mt-1">주소</div>
								</div>
							</div>

						</div>
					</div>

				</div>

			</div>
		</div>
	</div>




	<!-- Modal End -->  

 





</body>

</html>