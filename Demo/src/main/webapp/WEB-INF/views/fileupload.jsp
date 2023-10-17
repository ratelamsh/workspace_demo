<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>File Upload</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<div class="container">
		<form name="fileTest" method="get" action="/member/uploadFile.do" enctype="multipart/form-data">
			<input type="file" name="upfile" class="form-control" id="inputGroupFile02">
			<button class="btn btn-primary" type="submit" id="fileBtn">파일전송</button>
		</form>
	</div>
	<script>
		$(function(){
			$("#fileBtn").css("margin", "10px");
		});	// funtion() end
	</script>
</body>
</html>