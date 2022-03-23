<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="./css/index.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
<%
if(!"OK".equals(session.getAttribute("loginState"))){
	response.sendRedirect("./login.jsp");
}
%>
	<div class="out">
		<div class= "container">
		<h3>${msg }</h3>
			<form action="./sd01" method="POST">
				 <div class="form-row">
				    <div class="form-group col-md-6">
				      <label for="inputEmail4">商品名稱:</label>
				      <input type="text" class="form-control"  name="comName" required>
				 </div>
				 <div class="form-group col-md-6">
				      <label for="inputPassword4">庫存數量:</label>
				      <input type="number" class="form-control" name="comNumber" required >
				    </div>
				 </div>
				 <div class="form-group">
				    <label for="inputAddress">商品價格:</label>
				    <input type="number" class="form-control" name="comPrice" required >
				 </div>
				 <div class="form-group">
				    <label for="exampleFormControlFile1">輸入圖片網址:</label>
				    <input type="text" class="form-control" name="comImage">
				 </div>
				 <input type="hidden" name="state" value="addCom">
				 <button type="submit" class="btn btn-primary">送出</button>
				 <button type="button" onclick="location.href='./index.jsp'" class="btn btn-primary">回首頁</button>
			 </form>
		</div>
	</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>