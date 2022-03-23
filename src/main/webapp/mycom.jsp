<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link rel="stylesheet" href="./css/index.css" type="text/css">
</head>
<body>
<%
if(!"OK".equals(session.getAttribute("loginState"))){
	response.sendRedirect("./login.jsp");
}
%>


<div class="out" >
	<h2>商品列表</h2>
	<div>
	<!-- 彈出視窗的按鈕 -->
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  	新增商品
	</button>
	<button type="button" onclick="location.href='./index.jsp'" class="btn btn-primary">回首頁</button>
	
	</div>
	<div class="accordion" id="accordionExample">
	
		<c:forEach items="${comList}" var="com">
			<div class="card">
			    <div class="card-header" >
			      <h2 class="mb-0">
			        <button class="btn btn-link btn-block text-left " type="button" data-toggle="collapse" data-target="#collapse${com.id}" aria-expanded="false" aria-controls="collapse${com.id}">
		    	      ${com.comName}
		        	</button>
		      	</h2>
		    	</div>
		
		    <div id="collapse${com.id}" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
		      <div class="card-body">
		    	<div class= "container">
					<form action="./sd01" method="POST">
						 <div class="form-row">
						    <div class="form-group col-md-6">
						      <label for="inputEmail4">商品名稱:</label>
						      <input type="text" class="form-control"  name="comName"  value="${com.comName}" required>
						 </div>
						 <div class="form-group col-md-6">
						      <label for="inputPassword4">庫存數量:</label>
						      <input type="number" class="form-control" name="comNumber" value="${com.comNumber}" required >
						    </div>
						 </div>
						 <div class="form-group">
						    <label for="inputAddress">商品價格:</label>
						    <input type="number" class="form-control" name="comPrice" value="${com.comPrice}" required >
						 </div>
						 <div class="form-group">
						 	<label for="inputAddress">商品圖片網址:</label>
						 	<input type="text" class="form-control"  name="comImage"  value="${com.comImage}" required></br>
						 	<img src="${com.comImage}" width="400px">
						 </div>
						 <input type="hidden" name="state" value="updateCom">
						 <input type="hidden" name="comId" value="${com.id}">
						 <button type="submit" class="btn btn-primary">送出</button>
					</form>
				</div>
		      </div>
		    </div>
		  </div>
		</c:forEach>
	
	</div>
</div>


<!-- 彈出視窗的內容 -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">請輸入商品資料</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<div class= "container">
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
				    <label for="exampleFormControlFile1">請輸入圖片網址:</label>
				    <input type="text" class="form-control" name="comImage">
				 </div>
				 <input type="hidden" name="state" value="addCom">
				 <button type="submit" class="btn btn-primary">上傳</button>
				 <button type="button" class="btn btn-secondary" data-dismiss="modal">關閉</button>
			 </form>
		</div>
      </div>
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