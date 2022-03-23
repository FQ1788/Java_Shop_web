<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="./css/index.css" type="text/css">
<title>註冊</title>
</head>
<body>
	<div class= "container">
		<form action="./sd01" method="POST">
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputEmail4">帳號:</label>
		      <input type="text" class="form-control"  name="userAccount" required value="${User.userAccount}">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">密碼:</label>
		      <input type="password" class="form-control"  name="userPass" required value="${User.userPass}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputAddress">電子郵件:</label>
		    <input type="email" class="form-control" name="userEmail" required value="${User.userEmail}">
		  </div>
		  <div class="form-row">
		  	<div class="form-group col-md-6">
		    	<label for="inputAddress">姓名:</label>
			    <input type="text" class="form-control" name="userName" required value="${User.userName}">
			</div>
			<div class="form-group col-md-6">   
			    <label for="inputAddress">電話:</label>
			    <input type="tel" class="form-control" name="userTel" maxlength="10" required pattern="[0-9]{10}"   value="${User.userTel}">
		  	</div>
		  </div>
		  <div class="form-group">
		    <label for="inputAddress2">店名:</label>
		    <input type="text" class="form-control" name="storeName" required value="${User.storeName}">
		  </div>
		  <div class="form-row">
		    <div class="form-group col-md-3">
		      <label for="inputState">縣市:</label>
		      <select id="inputState" class="form-control" name="userCity" required>
		        <option selected>請選擇</option>
		        <option>台北市</option>
		        <option>新北市</option>
		        <option>台南市</option>
		        <option>高雄市</option>
		      </select>
		    </div>
		    <div class="form-group col-md-9">
		      <label for="inputCity">地址:</label>
		      <input type="text" class="form-control"  name="userAddress" required value="${User.userAddress}">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="form-check">
		    <font color="red">${mags}</font><br> 
		      <input type="checkbox" id="gridCheck" name="cbox1" value="ok">
		      <label class="form-check-label" for="gridCheck" >
		        我同意.....
		      </label>
		    </div>
		  </div>
		  <input type="hidden" name="state" value="addStudent">
		  <button type="submit" class="btn btn-primary">送出</button>
		  <button type="button" class="btn btn-primary" onclick="location.href='./login.jsp'">返回</button>
		</form>
	</div>
	
	
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>