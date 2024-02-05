<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

<title>CROSS</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="css/style_x_ui.css">
<link rel="stylesheet" href="node_modules/reset.css/reset.css">




<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<script	src="/js/bootstrap.bundle.js"></script>
<script	src="/js/bootstrap.bundle.min.js"></script>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<script src="/js/cross/index.js"></script>
<script src="/js/cross/sidebar.js"></script>




</head>
<body>

	<div id="view-box">


		<%@ include file="/WEB-INF/views/sidebar.jsp"%>


		<main>

			<div class="header">
				<h2>게시글</h2>
			</div>



			<c:

			<div class="post" style="position: relative;">

				<div class="post_profile-image rounded-5">
					<img class="" src="images/profile01.jpg" alt="profile">
					<div style="position: absolute; height: 100%; width: 80px;"></div>
				</div>

				<div class="post_body">
					<div class="post_header">
						<div class="post_header-text" style="">
							<h3>
								Java <span class="header-icon-section"> <span
									class="material-icons post_badge">verified</span>@java
								</span>
							</h3>
							<div style="margin-left: 1rem; text-align: center;">
								<h3>24.01.01</h3>
							</div>
							<div class="dropdown dropBtn">

								<div class="dropdown-toggle" type="button"
									data-bs-toggle="dropdown" aria-expanded="false">

									<span class="material-icons mateBtn">more_horiz</span> <span
										class="visually-hidden">Toggle Dropdown</span>
								</div>
								<ul class="dropdown-menu dropdown-link-active-bg">
									<li><a class="dropdown-item" href="#">삭제하기</a></li>

								</ul>

							</div>

						</div>

						<div class="post_header-discription"
							onclick="location.href='viewContent'">
							<p>Java 18 is now available! #Java18 #JDK18 #openjdk</p>
							<br>
							<p>
								Download now: https://social.ora.cl/6012KoqQ0 <br> Release
								notes: https://social.ora.cl/6013KoqQF <br> API Javadoc:
								https://social.ora.cl/6015KoqQN <br> Features:
								https://social.ora.cl/6016KoqQ4 <br>
							</p>
						</div>

					</div>


					<div class="container">
						<div class="row row-cols-auto ">
							<div class="col-md-auto img-lg rounded-4">
								<img src="images/post-image.jpeg" class="rounded " alt="java18"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									data-bs-whatever="images/post-image.jpeg">
							</div>
							<div class="col-md-auto img-lg rounded-4">
								<img src="images/post-image.jpeg" class="rounded " alt="java18"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									data-bs-whatever="images/post-image.jpeg">
							</div>
						</div>
					</div>


					<div class="post_footer">

						<span class="material-icons ms_icons" data-bs-toggle="modal"
							data-bs-target="#writeModal">chat</span>
						<h3>100</h3>
						<span class="material-icons ms_icons repeat">repeat</span>
						<h3>100</h3>
						<span class="material-icons ms_icons favorite">favorite_border</span>
						<h3>100</h3>
						<span class="material-icons ms_icons bookmark">bookmark_border</span>
						<h3>100</h3>


					</div>

				</div>
			</div>




			<div class="post">
				<div class="post_profile-image">
					<img src="images/menu01.png" alt="profile">

				</div>

				<div class="post_body">
					<div class="post_header">
						<div class="post_header-text">
							<h3>
								Java <span class="header-icon-section"> <span
									class="material-icons post_badge">verified</span>@java
								</span>
							</h3>
							<div style="margin-left: 1rem; text-align: center;">
								<h3>등록일</h3>
							</div>
							<div class="dropdown dropBtn">

								<div class="dropdown-toggle" type="button"
									data-bs-toggle="dropdown" aria-expanded="false">

									<span class="material-icons mateBtn">more_horiz</span> <span
										class="visually-hidden">Toggle Dropdown</span>
								</div>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="#">팔로우하기</a></li>
									<li><a class="dropdown-item" href="#">차단하기</a></li>
								</ul>
							</div>
						</div>

						<div class="post_header-discription"
							onclick="location.href='viewContent'">
							<p>Java 18 is now available! #Java18 #JDK18 #openjdk</p>
							<br>
							<p>
								Download now: https://social.ora.cl/6012KoqQ0 <br> Release
								notes: https://social.ora.cl/6013KoqQF <br> API Javadoc:
								https://social.ora.cl/6015KoqQN <br> Features:
								https://social.ora.cl/6016KoqQ4 <br>
							</p>
						</div>

					</div>
					<div class="container img-sm">
						<div class="row row-cols-auto">
							<div class="col-md-auto">
								<img src="images/post-image.jpeg" class="rounded " alt="java18"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									data-bs-whatever="images/post-image.jpeg">
							</div>
							<div class="col-md-auto">
								<img src="images/post-image.jpeg" class="rounded " alt="java18"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									data-bs-whatever="images/post-image.jpeg">
							</div>
						</div>

						<div class="row row-cols-auto">
							<div class="col-md-auto">
								<img src="images/post-image.jpeg" class="rounded " alt="java18"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									data-bs-whatever="images/post-image.jpeg">
							</div>
							<div class="col-md-auto">
								<img src="images/post-image.jpeg" class="rounded " alt="java18"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									data-bs-whatever="images/post-image.jpeg">
							</div>
						</div>
					</div>

					<div class="post_footer">

						<span class="material-icons ms_icons" data-bs-toggle="modal"
							data-bs-target="#writeModal">chat</span>
						<h3>100</h3>
						<span class="material-icons ms_icons repeat">repeat</span>
						<h3>100</h3>
						<span class="material-icons ms_icons favorite">favorite_border</span>
						<h3>100</h3>
						<span class="material-icons ms_icons bookmark">bookmark_border</span>
						<h3>100</h3>


					</div>

				</div>

			</div>



			<div class="post">
				<div class="post_profile-image">
					<img src="images/menu01.png" alt="profile">

				</div>

				<div class="post_body">
					<div class="post_header">
						<div class="post_header-text">
							<h3>
								Java <span class="header-icon-section"> <span
									class="material-icons post_badge">verified</span>@java
								</span>
							</h3>
							<div style="margin-left: 1rem; text-align: center;">
								<h3>등록일</h3>
							</div>
							<div class="dropdown dropBtn">

								<div class="dropdown-toggle" type="button"
									data-bs-toggle="dropdown" aria-expanded="false">

									<span class="material-icons mateBtn">more_horiz</span> <span
										class="visually-hidden">Toggle Dropdown</span>
								</div>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="#">Action</a></li>
									<li><a class="dropdown-item" href="#">Action</a></li>
									<li><a class="dropdown-item" href="#">Action</a></li>
								</ul>
							</div>
						</div>

						<div class="post_header-discription"
							onclick="location.href='viewContent'">
							<p>Java 18 is now available! #Java18 #JDK18 #openjdk</p>
							<br>
							<p>
								Download now: https://social.ora.cl/6012KoqQ0 <br> Release
								notes: https://social.ora.cl/6013KoqQF <br> API Javadoc:
								https://social.ora.cl/6015KoqQN <br> Features:
								https://social.ora.cl/6016KoqQ4 <br>
							</p>
						</div>

					</div>

					<div class="container">
						<div class="row row-cols-auto">
							<div class="col-md-auto img-md rounded-4">
								<img src="images/post-image.jpeg" class="rounded " alt="java18"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									data-bs-whatever="images/post-image.jpeg">
							</div>
							<div class="col-md-auto">
								<div class="row row-cols-auto">
									<div class="col-md-auto img-sm">
										<img src="images/post-image.jpeg" class="rounded "
											alt="java18" data-bs-toggle="modal"
											data-bs-target="#exampleModal"
											data-bs-whatever="images/post-image.jpeg">
									</div>
								</div>
								<div class="row row-cols-auto">
									<div class="col-md-auto img-sm">
										<img src="images/post-image.jpeg" class="rounded "
											alt="java18" data-bs-toggle="modal"
											data-bs-target="#exampleModal"
											data-bs-whatever="images/post-image.jpeg">
									</div>
								</div>
							</div>
						</div>
					</div>


					<div class="post_footer">

						<span class="material-icons ms_icons" data-bs-toggle="modal"
							data-bs-target="#writeModal">chat</span>
						<h3>100</h3>
						<span class="material-icons ms_icons repeat ">repeat</span>
						<h3>100</h3>
						<span class="material-icons ms_icons favorite">favorite_border</span>
						<h3>100</h3>
						<span class="material-icons ms_icons bookmark">bookmark_border</span>
						<h3>100</h3>


					</div>

				</div>

			</div>






			<div class="post">
				<div class="post_profile-image">
					<img src="images/menu01.png" alt="profile">

				</div>

				<div class="post_body">
					<div class="post_header">
						<div class="post_header-text">
							<h3>
								Java <span class="header-icon-section"> <span
									class="material-icons post_badge">verified</span>@java
								</span>
							</h3>
							<div style="margin-left: 1rem; text-align: center;">
								<h3>등록일</h3>
							</div>
							<div class="dropdown dropBtn">

								<div class="dropdown-toggle" type="button"
									data-bs-toggle="dropdown" aria-expanded="false">

									<span class="material-icons mateBtn">more_horiz</span> <span
										class="visually-hidden">Toggle Dropdown</span>
								</div>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="#">Action</a></li>
									<li><a class="dropdown-item" href="#">Action</a></li>
									<li><a class="dropdown-item" href="#">Action</a></li>
								</ul>
							</div>
						</div>

						<div class="post_header-discription"
							onclick="location.href='viewContent'">
							<p>Java 18 is now available! #Java18 #JDK18 #openjdk</p>
							<br>
							<p>
								Download now: https://social.ora.cl/6012KoqQ0 <br> Release
								notes: https://social.ora.cl/6013KoqQF <br> API Javadoc:
								https://social.ora.cl/6015KoqQN <br> Features:
								https://social.ora.cl/6016KoqQ4 <br>
							</p>
						</div>

					</div>

					<div class="container">
						<div class="row row-cols-auto ">
							<div class="col-md-auto img-xl rounded-4">
								<img src="images/post-image.jpeg" class="rounded " alt="java18"
									data-bs-toggle="modal" data-bs-target="#exampleModal"
									data-bs-whatever="images/post-image.jpeg">
							</div>

						</div>
					</div>


					<div class="post_footer">

						<span class="material-icons ms_icons" data-bs-toggle="modal"
							data-bs-target="#writeModal">chat</span>
						<h3>100</h3>
						<span class="material-icons ms_icons repeat">repeat</span>
						<h3>100</h3>
						<span class="material-icons ms_icons favorite">favorite</span>
						<h3>100</h3>
						<span class="material-icons ms_icons bookmark">bookmark</span>
						<h3>100</h3>


					</div>

				</div>

			</div>


		</main>
		<!-- main section end -->

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
								<div id="modal_text-area" class="rounded"
									style="position: relative;">

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


						<label for="modalFile" id="modalImgBtn"
							class="btn btn-sm btn-dark">사진등록</label> <input type="file"
							id="modalFile" multiple="multiple"> <label
							for="modalRegPosition" id="modalregBtn"
							class="btn btn-sm btn-dark" data-bs-toggle="modal"
							data-bs-target="#locationModal2" data-bs-whatever="Test">위치등록</label>
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
						<label for="recipient-name" class="col-form-label ">검색:</label> <input
							type="text" class="form-control" id="locSearch"
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