<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/login.css" type="text/css">

<title>登入</title>
</head>
<body>
<% 
if("OK".equals(session.getAttribute("loginState")))
		{
		request.getRequestDispatcher("./index.jsp").forward(request, response);
}; 
%>

	<div class="container">
		<form action="./sd01" method="POST">
		
			<h2>請輸入帳號</h2>
			
			<div class="form-group">
				<label for="" class="text">帳號:</label>
				<input type="text" class="form-control" name="sName" required>
			</div>
			
			<div class="form-group">
				<label for="" class="text">密碼:</label>
				<input type="password" class="form-control" name="sPass" required>
			</div>
			<input type="hidden" name="state" value="login">
			<font color="red">${mags}<br><br></font>			
			<input type="submit" value="登入" class="btn">
			<a href="./addStudent.jsp">點我註冊</a>
		</form>
	</div>
	


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>