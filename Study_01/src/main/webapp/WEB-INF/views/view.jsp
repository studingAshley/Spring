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

<script src="js/cross/index.js"></script>


<script>
@import "../node_modules/bootstrap/scss/bootstrap";

	
})
</script>

    
    
</head>
 <body>
 
 <div id="view-box" style="display: flex; justify-content: center; border-left: 1px solid var(--twitter-background-color)" >
 

	 <nav style="margin-top: 20px;" >
	 	
	 	<div class="nav_logo-wrapper" >
       		<img class="nav_logo" src="images/cross.jpg">
        </div>
        
	 	<div class="profile-wrapper " style="">
	 		<div class="profile-img">
	 			<div style="" class="img-wrapper rounded-5">
	 				
	 			</div>
	 		</div>
	 		<div class="profile-name">
	 			<div style="margin: 4px;"><h2>Name</h2></div>
	 		</div>
	 		<div class="profile-follow" style="display: flex; margin-top:20px;">
	 			<div style="margin:0 4px;"><h4>팔로우</h4></div> 
	 			<div style="margin:0;">100</div>

	 			<div style="margin:0 4px 0 10px;"><h4>팔로워</h4></div> 
	 			<div style="margin:0;">100</div>
	 		</div>
	 	
	 	</div>
	 	
	 	

        <div class="Menu_options active">
            <span class="material-icons">home</span>
            <h2>홈</h2>
        </div>

        <div class="Menu_options">
            <span class="material-icons">person</span>
            <h2>프로필</h2>
        </div> 
        
        <div class="Menu_options">
            <span class="material-icons">bookmark</span>
            <h2>북마크</h2>
        </div> 
        
        <div class="Menu_options">
            <span class="material-icons">email</span>
            <h2>메시지</h2>
        </div>
       
        <div class="Menu_options">
            <span class="material-icons">notifications</span>
            <h2>알림</h2><span class="badge text-bg-light rounded-pill align-text-bottom">27</span>
        </div>

		 <div class="Menu_options">
            <span class="material-icons">tag</span>
            <h2>검색</h2>
        </div>
		
		<div><br></div>
	 
	 	<div class="Menu_options">
	 		<span class="material-icons">logout</span>
	 		<h2>로그아웃</h2>
	 	</div>
	 </nav>


 <main>
 
         <div class="header">
            <h2>게시글</h2>
        </div>
 
 
        <div class="post" style="position:relative;">
       	
	            <div class="post_profile-image rounded-5">
	                <img class="" src="images/profile01.jpg" alt="profile">
		            <div style="position: absolute; height: 100%;     width: 80px;"></div>
	            </div>

	            <div class="post_body">
	                <div class="post_header">
	                    <div class="post_header-text" style="">
	                        <h3>Java
	                            <span class="header-icon-section">
	                                <span class="material-icons post_badge">verified</span>@java
	                            </span>
	                        </h3>
	                        <div style="margin-left: 1rem; text-align: center;"><h3>24.01.01</h3></div>
	                        <div class="dropdown dropBtn">
		                        
		                        <div class="dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
		                            
		                        	<span class="material-icons mateBtn" >more_horiz</span>
		                        	<span class="visually-hidden">Toggle Dropdown</span>
		                        </div >
		                         <ul class="dropdown-menu dropdown-link-active-bg">
		                            <li><a class="dropdown-item" href="#">삭제하기</a></li>

		                         </ul>
		                         
		                    </div>
		                    
	                    </div>
	
	                    <div class="post_header-discription" onclick="location.href='viewContent'">
	                        <p>Java 18 is now available! #Java18 #JDK18 #openjdk </p>
	                        <br>
	                        <p>Download now: https://social.ora.cl/6012KoqQ0 <br>
	                            Release notes: https://social.ora.cl/6013KoqQF <br>
	                            API Javadoc: https://social.ora.cl/6015KoqQN <br>
	                            Features: https://social.ora.cl/6016KoqQ4 <br>
	                            </p>
	                    </div>
	                    
	                </div>
	                
	                
	                <div class="container">
				      <div class="row row-cols-auto ">
				        <div class="col-md-auto img-lg rounded-4"><img src="images/post-image.jpeg"  class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" ></div>
				        <div class="col-md-auto img-lg rounded-4"><img src="images/post-image.jpeg"  class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" ></div>
				      </div>
				    </div>
				    
	
	                <div class="post_footer">
	
	                    <span class="material-icons ms_icons">chat</span><h3>100</h3>
	                    <span class="material-icons ms_icons repeat">repeat</span><h3>100</h3>
	                    <span class="material-icons ms_icons favorite">favorite_border</span><h3>100</h3>
	                    <span class="material-icons ms_icons bookmark">bookmark_border</span><h3>100</h3>
	                    
	
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
                        <h3>Java
                            <span class="header-icon-section">
                                <span class="material-icons post_badge">verified</span>@java
                            </span>
                        </h3>
                        <div style="margin-left: 1rem; text-align: center;"><h3>등록일</h3></div>
                        <div class="dropdown dropBtn">
	                        
	                        <div class="dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
	                            
	                        	<span class="material-icons mateBtn" >more_horiz</span>
	                        	<span class="visually-hidden">Toggle Dropdown</span>
	                        </div >
	                         <ul class="dropdown-menu">
	                            <li><a class="dropdown-item" href="#">팔로우하기</a></li>
	                            <li><a class="dropdown-item" href="#">차단하기</a></li>
	                         </ul>
	                    </div>
                    </div>

                    <div class="post_header-discription" onclick="location.href='viewContent'">
                        <p>Java 18 is now available! #Java18 #JDK18 #openjdk </p>
                        <br>
                        <p>Download now: https://social.ora.cl/6012KoqQ0 <br>
                            Release notes: https://social.ora.cl/6013KoqQF <br>
                            API Javadoc: https://social.ora.cl/6015KoqQN <br>
                            Features: https://social.ora.cl/6016KoqQ4 <br>
                            </p>
                    </div>
                    
                </div>
                <div class="container img-sm">
				  <div class="row row-cols-auto">
				    <div class="col-md-auto">
				       <img src="images/post-image.jpeg"  class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" >
				    </div>
				    <div class="col-md-auto">
				       <img src="images/post-image.jpeg" class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" >
				    </div>
				 </div>
				 
				 <div class="row row-cols-auto">
				    <div class="col-md-auto">
				       <img src="images/post-image.jpeg"  class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" >
				    </div>
				    <div class="col-md-auto">
				       <img src="images/post-image.jpeg" class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" >
				    </div>
				 </div>
               </div>

                <div class="post_footer">

                    <span class="material-icons ms_icons">chat</span><h3>100</h3>
                    <span class="material-icons ms_icons repeat">repeat</span><h3>100</h3>
                    <span class="material-icons ms_icons favorite">favorite_border</span><h3>100</h3>
                    <span class="material-icons ms_icons bookmark">bookmark_border</span><h3>100</h3>
                    

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
                        <h3>Java
                            <span class="header-icon-section">
                                <span class="material-icons post_badge">verified</span>@java
                            </span>
                        </h3>
                        <div style="margin-left: 1rem; text-align: center;"><h3> 등록일 </h3></div>
                        <div class="dropdown dropBtn">
	                        
	                        <div class="dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
	                            
	                        	<span class="material-icons mateBtn" >more_horiz</span>
	                        	<span class="visually-hidden">Toggle Dropdown</span>
	                        </div >
	                         <ul class="dropdown-menu">
	                            <li><a class="dropdown-item" href="#">Action</a></li>
	                            <li><a class="dropdown-item" href="#">Action</a></li>
	                            <li><a class="dropdown-item" href="#">Action</a></li>
	                         </ul>
	                    </div>
                    </div>

                    <div class="post_header-discription" onclick="location.href='viewContent'">
                        <p>Java 18 is now available! #Java18 #JDK18 #openjdk </p>
                        <br>
                        <p>Download now: https://social.ora.cl/6012KoqQ0 <br>
                            Release notes: https://social.ora.cl/6013KoqQF <br>
                            API Javadoc: https://social.ora.cl/6015KoqQN <br>
                            Features: https://social.ora.cl/6016KoqQ4 <br>
                            </p>
                    </div>
                    
                </div>
                
                <div class="container">
			      <div class="row row-cols-auto">
			        <div class="col-md-auto img-md rounded-4"><img src="images/post-image.jpeg"  class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" ></div>
			        <div class="col-md-auto">
			          <div class="row row-cols-auto">
			            <div class="col-md-auto img-sm"><img src="images/post-image.jpeg"  class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" ></div>
			          </div>
			          <div class="row row-cols-auto">
			             <div class="col-md-auto img-sm"><img src="images/post-image.jpeg"  class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" ></div>
			          </div>
			        </div>
			      </div>
			    </div>
			    

                <div class="post_footer">

                    <span class="material-icons ms_icons">chat</span><h3>100</h3>
                    <span class="material-icons ms_icons repeat ">repeat</span><h3>100</h3>
                    <span class="material-icons ms_icons favorite">favorite_border</span><h3>100</h3>
                    <span class="material-icons ms_icons bookmark">bookmark_border</span><h3>100</h3>
                    

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
                        <h3>Java
                            <span class="header-icon-section">
                                <span class="material-icons post_badge">verified</span>@java
                            </span>
                        </h3>
                        <div style="margin-left: 1rem; text-align: center;"><h3>등록일</h3></div>
                        <div class="dropdown dropBtn">
	                        
	                        <div class="dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
	                            
	                        	<span class="material-icons mateBtn" >more_horiz</span>
	                        	<span class="visually-hidden">Toggle Dropdown</span>
	                        </div >
	                         <ul class="dropdown-menu">
	                            <li><a class="dropdown-item" href="#">Action</a></li>
	                            <li><a class="dropdown-item" href="#">Action</a></li>
	                            <li><a class="dropdown-item" href="#">Action</a></li>
	                         </ul>
	                    </div>
                    </div>

                    <div class="post_header-discription" onclick="location.href='viewContent'">
                        <p>Java 18 is now available! #Java18 #JDK18 #openjdk </p>
                        <br>
                        <p>Download now: https://social.ora.cl/6012KoqQ0 <br>
                            Release notes: https://social.ora.cl/6013KoqQF <br>
                            API Javadoc: https://social.ora.cl/6015KoqQN <br>
                            Features: https://social.ora.cl/6016KoqQ4 <br>
                            </p>
                    </div>
                    
                </div>
                
                <div class="container">
			      <div class="row row-cols-auto ">
			        <div class="col-md-auto img-xl rounded-4"><img src="images/post-image.jpeg"  class="rounded " alt="java18" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="images/post-image.jpeg" ></div>
			
			      </div>
			    </div>
			    

                <div class="post_footer">

                    <span class="material-icons ms_icons">chat</span><h3>100</h3>
                    <span class="material-icons ms_icons repeat">repeat</span><h3>100</h3>
                    <span class="material-icons ms_icons favorite">favorite</span><h3>100</h3>
                    <span class="material-icons ms_icons bookmark">bookmark</span><h3>100</h3>
                    

                </div>

            </div>

        </div>
        
       
    </main>
    <!-- main section end -->
    
 </div>



  </body>
  
 <script async src="https://cdn.jsdelivr.net/npm/es-module-shims@1/dist/es-module-shims.min.js" crossorigin="anonymous"></script>
    <script type="importmap">
    {
      "imports": {
        "@popperjs/core": "https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/esm/popper.min.js",
        "bootstrap": "https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.esm.min.js"
      }
    }
    </script>
    <script type="module">
      import * as bootstrap from 'bootstrap'

      new bootstrap.Popover(document.getElementById('popoverButton'))
    </script>
  
  
</html>