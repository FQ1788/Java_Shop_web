<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<title>後臺</title>
<link rel="stylesheet" href="./css/index.css" type="text/css">
</head>
<body>
<% 
	if(!"OK".equals(session.getAttribute("loginState"))){
		response.sendRedirect("./login.jsp");
	}

%>
	<div class="out">
	<h2>
	<% out.println(session.getAttribute("studentName")); %>
	歡迎您使用後臺系統</h2>
		<div class="container">
		  <div class="row">
		   	<button type="button" class="btn btn-outline-info btn-lg btn-block" onclick="location.href='./sd01?state=inquireCom'">
		   		商品列表
		   	</button>
		  </div>
		  <div class="row">
		   	<button type="button" class="btn btn-outline-warning btn-lg btn-block" onclick="location.href='./addcommodity.jsp'">
		   		新增商品
		   	</button>
		  </div>
		  <div class="row">
		   	<button type="button" class="btn btn-outline-dark btn-lg btn-block" onclick="location.href='./logout.jsp'">
		   		登出
		   	</button>
		  </div>
		</div>
	</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>