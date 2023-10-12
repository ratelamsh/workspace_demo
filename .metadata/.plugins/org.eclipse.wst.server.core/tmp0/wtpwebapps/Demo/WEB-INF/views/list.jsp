<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>member list</title>
</head>
<body>
	<h1>회원 목록</h1>
 	<div class="container">
 		<div class="row">
 			<div class="col"><button class="btn btn-primary" id="regForm">회원가입 화면으로</button></div>
 		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">ID</th>
					<th scope="col">닉네임</th>
					<th scope="col">이름</th>
					<th scope="col">주소</th>
					<th scope="col">전화번호</th>
					<th scope="col">가입일자</th>
				</tr>
			</thead>
		
			<tbody>
				<c:forEach var="member" items="${list }" varStatus="status">
				<tr>
					<th scope="row">${status.count}</th>
					<td><c:out value="${member.m_id }"/></td>
					<td><c:out value="${member.m_nickname }"/></td>
					<td><c:out value="${member.m_name }"/></td>
					<td><c:out value="${member.m_address }"/></td>
					<td><c:out value="${member.m_phone }"/></td>
					<td><c:out value="${member.m_regdate }"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		$(function(){
			// 회원가입 화면으로 이동
			$("#regForm").click(function(){
				window.location.replace("/");
			});
		});
	</script>
</body>
</html>