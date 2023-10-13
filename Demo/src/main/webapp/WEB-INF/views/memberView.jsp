<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<title>member view page</title>
</head>
<body>
	<div class="container">
		<div class="row" style="margin: 10px;">
			<div class="col-3" style="border:1px solid" id="rs">
				
			</div>
			<div class="col-6" style="border:1px solid">
				<form action="/member/editMember.do" method="post" name="editMemberForm" id="editMemberForm">
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>ID</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_id" value="${map.m_id }" readonly>
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>비밀번호</span>
						</div>
						<div class="col-6">
							<input type="password" class="form-control" name="m_pw" value="${map.m_pw }">
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>닉네임</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_nickname" value="${map.m_nickname }">
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>이름</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_name" value="${map.m_name }">
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>주소</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_address" value="${map.m_address }">
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-6">
							<span>전화번호</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_phone" value="${map.m_phone }">
						</div>
					</div>
				</form>
			</div>
			<div class="col-3" style="border:1px solid; padding: 2px;">
				<button class="btn btn-success" type="button" form="editMemberForm" id="save">수정하기</button>
				<button class="btn btn-dark" type="button" id="showList">목록출력</button>
			</div>
		</div>
	</div>

	<script>
	$(function(){
		
		// 수정하기
		$("#save").on("click", function(){
/* 			var data = JSON.stringify({m_id: $("input[name=m_id]").val(), m_pw: $("input[name=m_pw]").val(), m_nickname: $("input[name=m_nickname]").val(),
												m_name: $("input[name=m_name]").val(), m_address: $("input[name=m_address]").val(), m_phone: $("input[name=m_phone]").val()
										});
			console.log(data);
			$("<input type='hidden' name='memberDto' value='" + data + "'>").appendTo("#editMemberForm");
			alert('submit'); */
			$("#editMemberForm").submit();
		});
		
		// 목록출력
		$("#showList").click(function(){
			window.location.replace("/member/list");
		});
		
		// ID input 태그 색상 변경
		$("input[name='m_id']").css({"background-color":"grey", "color":"white"});
		
		
		
		
	}); // function() end
	</script>
</body>
</html>