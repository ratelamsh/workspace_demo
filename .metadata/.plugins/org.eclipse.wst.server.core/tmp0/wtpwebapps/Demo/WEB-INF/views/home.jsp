<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>Home page</title>
</head>
<body>
	<div class="container">
		<div class="row" style="margin: 10px;">
			<div class="col-3" style="border:1px solid" id="rs">
				
			</div>
			<div class="col-6" style="border:1px solid">
				<form action="/member/insertMember.do" method="post" name="insertMember" id="insertMember">
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>ID</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_id">
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>비밀번호</span>
						</div>
						<div class="col-6">
							<input type="password" class="form-control" name="m_pw">
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>닉네임</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_nickname">
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>이름</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_name">
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>주소</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_address">
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>전화번호</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_phone">
						</div>
					</div>
				</form>
			</div>
			<div class="col-3" style="border:1px solid; padding: 2px;">
				<button class="btn btn-primary" type="button" form="insertTest" id="save">저장하기</button>
				<button class="btn btn-success" type="button" id="showList">목록출력</button>
				<button class="btn btn-secondary" type="button" id="testBtn">테스트 버튼</button>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script>
	$(function(){
		
		// context-path 체크용 테스트 버튼
		$("#testBtn").click(function(){
			console.log(location.href);
		});
		
		// 저장하기
		$("#save").click(function(){
			alert("click");
			//$("#insertTest").submit();
  			$.ajax({
				url: "./member/insertMember.do",
				contentType:'application/json',
				method: "post",
				data: JSON.stringify({
					m_id: $("input[name=m_id]").val(),
					m_pw: $("input[name=m_pw]").val(),
					m_nickname: $("input[name=m_nickname]").val(),
					m_name: $("input[name=m_name]").val(),
					m_address: $("input[name=m_address]").val(),
					m_phone: $("input[name=m_phone]").val()
				}),
				success:function(data){
					alert("success");
					window.location.replace("/member/list");
				},
				error:function(){
					alert("error");
				}
			});
		});
		
		// 목록출력
		$("#showList").click(function(data){
			window.location.replace("/member/list");
		});
	});
	
	</script>
</body>
</html>
