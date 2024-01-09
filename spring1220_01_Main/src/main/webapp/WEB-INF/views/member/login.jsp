<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="/css/login.css">
    <script src="/js/login.js"></script>
    	
    
    <style>
       
    </style>


</head>
<body>
<div id="wrap">
    <div id="header">
        <h1>
            <a href="#" id="h_logo"></a>
        </h1>
    </div>
    <div id="container">
        <div id="content">
            <div style="margin-bottom: 7px"></div>
            <form action="login" name=login method="post">
                <fieldset style="border: 0">
                    <div class="id_area">
                        <div class="input_row" id="id_area">
                            <span class="input_box">
                                <input type="text" name="id" id="uId" class="int" placeholder="아이디">
                            </span>
                        </div>
                    </div>
                    <div class="pw_area">
                        <div class="input_row" id="pw_area">
                            <span class="input_box">
                                <input type="text" name="pw" id="uPw" class="int" placeholder="비밀번호">
                            </span>
                        </div>
                    </div>
                    <input class="btn_login" type="button" value="로그인">
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>