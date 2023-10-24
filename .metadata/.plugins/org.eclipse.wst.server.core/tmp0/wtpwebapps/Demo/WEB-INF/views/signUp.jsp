<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="#">
	<link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.min.css">
	<script src="/resources/js/jquery/jquery-3.7.1.min.js"></script>
	<title>Home page</title>
</head>
<body>
	<div class="container">
		<div class="row" style="margin: 10px;">
			<div class="col-3" style="border:1px solid; text-align: center;" id="rs">
				<h3>프로필 미리보기</h3>
				<img class="img-thumbnail" src="/resources/testFolder/userIcon.png" id="preview"/>
			</div>
			<div class="col-8" style="border:1px solid">
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-3">
							<span>프로필 사진</span>
						</div>
						<div class="col-6">
							<input type="file" class="form-control" id="m_pf" onchange="readURL(this)">
						</div>
						<div class="col-3">
							<span></span>
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-3">
							<span>ID</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_id">
						</div>
						<div class="col-3">
							<button type="button" class="btn btn-secondary" id="idCheckBtn">중복검사</button>
							<span></span>
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-3">
							<span>비밀번호</span>
						</div>
						<div class="col-6">
							<input type="password" class="form-control" name="m_pw">
						</div>
						<div class="col-3">
							<span>8자리 이상 - ??(대문자, 숫자, 특수문자 포함)</span>
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-3">
							<span>닉네임</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_nickname">
						</div>
						<div class="col-3">
							<span>두 글자 이상</span>
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-3">
							<span>이름</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_name">
						</div>
						<div class="col-3">
							<span>두 글자 이상</span>
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-3">
							<span>주소</span>
						</div>
						<div class="col-6">
							<input type="text" class="form-control" name="m_address">
						</div>
						<div class="col-3">
							<span></span>
						</div>
					</div>
					<div class="row" style="padding: 5px 0px 5px">
						<div class="col-3">
							<span>전화번호</span>
						</div>
						<div class="col-6">
							<select class="form-select phone" id="m_phone1" onchange="changePhone(this)">
								<option value="010">010</option>
								<option value="070">070</option>
								<option value="030">030</option>
								<option value="050">050</option>
								<option value="etc">기타</option>
							</select>
							<input type="text" class="form-control phone" id="m_phone4" maxlength="4">							
							-
							<input type="text" class="form-control phone" id="m_phone2" maxlength="4">
							-
							<input type="text" class="form-control phone" id="m_phone3" maxlength="4">
						</div>
						<div class="col-3">
							<span></span>
						</div>
					</div>
			</div>
			<div class="col-1" style="border:1px solid; padding: 2px;">
				<button class="btn btn-primary" type="button" form="insertMember" id="save">저장하기</button><br>
				<button class="btn btn-success" type="button" id="showList">목록출력</button>
				<button class="btn btn-danger" type="button" id="testBtn">테스트 버튼</button>
			</div>
		</div>
		<div id="formDiv" >
			<form action="/member/insertMember.do" method="post" name="insertMember" id="insertMemberForm" enctype="multipart/form-data">
				<div class="row" style="padding: 5px 0px 5px">
						<input type="file" name="upfile" class="form-control" id="upfile">
						<input type="text" class="form-control" name="id" id="id">
						<input type="password" class="form-control" name="pw" id="pw">
						<input type="text" class="form-control" name="nickname" id="nickname">
						<input type="text" class="form-control" name="name" id="name">
						<input type="text" class="form-control" name="address" id="address">
						<input type="text" class="form-control" name="phone" id="phone">
				</div>
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script>
	$(function(){
		
		// context-path 체크용 테스트 버튼
		$("#testBtn").click(function(){
			console.log(location.href);
		});
		/*
		// 저장하기
 		$("#save").click(function(){
			alert("click");
			//$("#insertTest").submit();
  			$.ajax({
				url: "./member/insertMember.do",
				contentType:'application/json',
				type: "post",
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
		*/
		
		// 저장할 때 모든 데이터 유효성 검사 후 input hidden에 넣고 서버로 요청
		$("#save").click(function(){
			// 유효성 검사
			//// 1. 프로필 사진 -> 프로필 사진 선택할 때 <input type="file">에 img 주입.

			//// 2. ID -> ID 중복검사 할 때 <input type="text">에 주입.
			if($("#id").val().length < 5) {
				alert("ID를 입력 후 중복검사를 해주세요.");
				return;
			}
			
			//// 3. 비밀번호
			var testPw = $("input[name='m_pw']").val();
			var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
			if(testPw.length < 8) {
				alert("비밀번호는 8자리 이상이어야 합니다.");
				return;
			} else {
				if(!regex.test(testPw)){
					alert("대문자, 소문자, 특수문자, 숫자 각 1개 이상 씩 입력하세요. (8~25자리)");
					return;
				} else {
					$("#pw").val(testPw);
				}
			}
			
			//// 4. 닉네임
			var testNickname = $("input[name='m_nickname']").val();
			if(testNickname.length < 2) {
				alert("닉네임은 2자리 이상이어야 합니다.");
				return;
			} else {
				$("#nickname").val($("input[name='m_nickname']").val());
			}
			
			//// 5. 이름
			var testName = $("input[name='m_name']").val();
			if(testName.length < 2) {
				alert("이름은 2자리 이상이어야 합니다.");
				return;
			} else {
				$("#name").val($("input[name='m_name']").val());
			}
			
			//// 6. 주소
			var testAddress = $("input[name='m_address']").val();
			if(testAddress.length < 1) {
				alert("주소를 입력해주세요.");
				return;
			} else {
				$("#address").val($("input[name='m_address']").val());
			}
			
			//// 7. 전화번호
			var regExp = /^[0-9]{4}$/;
			var testPhone = "";
 			if(!regExp.test($("#m_phone2").val()) || $("#m_phone2").val().length < 4 || !regExp.test($("#m_phone3").val()) || $("#m_phone3").val().length < 4) {
				// 2번째 3번째 번호가 4자리 보다 작을 때 리턴
				alert("전화번호를 확인하세요. 각 칸마다 4자리 확인.");
				return ;
			} else {
				// 1번째 번호가 기타인 경우
				regExp = /^[0-9]{3,4}$/;
				if($("#m_phone1").val() == "etc") {
					if(!regExp.test($("#m_phone4").val()) || $("#m_phone4").val().length < 3) {
						alert("첫 번째 자리 번호를 확인하세요.");
						return;
					}
					testPhone = $("#m_phone4").val() + $("#m_phone2").val() + $("#m_phone3").val();
					console.log(testPhone);
				} else {
					testPhone = $("#m_phone1").val() + $("#m_phone2").val() + $("#m_phone3").val();
					console.log(testPhone);
				}
			}
 			
 			// <form> 값 대입
 			
 			//// 비밀번호
 			$("#pw").val(testPw);
 			
 			//// 닉네임
 			$("#nickname").val(testNickname);
 			
 			//// 이름
 			$("#name").val(testName);
 			
 			//// 주소
 			$("#address").val(testAddress);
 			
 			//// 전화번호
 			$("#phone").val(testPhone);
 			
 			$("#insertMemberForm").submit();
		});
		
		
		
		// 목록출력
		$("#showList").click(function(data){
			window.location.replace("/member/list");
		});
		
		// ID 중복검사
		$("#idCheckBtn").click(function(){
			var testId = $("input[name='m_id']");
			if(testId.val().length > 5) {
				$.ajax({
					url: "/member/checkId",
					dataType: "text",
					type: "get",
					data: {id :testId.val() },
					success: function(data) {
						if(data > 0) {
							// 중복되는 ID가 있는 경우
							alert("중복되는 ID가 있습니다.");
							testId.val("");
						} else {
							// 중복되는 ID가 없는 경우 <form> 하위 <input>에 값 주입
							alert("ID를 사용할 수 있습니다.");
							$("#id").val(testId.val());						
						}
					},
					error: function(data) {
						console.log("실패");
						console.log(data);
					}
				});
			} else {
				// 규칙에 맞지 않는 ID 중복 검사 한 경우 input 값 지우기
				alert("ID는 5글자 이상 이어야 합니다.");
				testId.val("");
				$("#id").val("");
			}
			
		});
		
		
		// css
		$("#save, #showList").css("margin", "1px");
		$(".phone").css({"width" :"30%", "display" : "inline"});
		$("#m_phone4").hide();
	});	// function() end
	
	// 프로필 사진 미리보기
	function readURL(input) {
		if(input.files && input.files[0]) {
			/* console.log("input.files\n");
			console.log(input.files);
			console.log("input.files[0]\n")
			console.log(input.files[0]);
			console.log("$('upfile').files")
			console.log($("#upfile").files); */
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#preview").attr("src", e.target.result);
				/* console.log("프로필 사진 미리보기\n");
				console.log(e);
				console.log("$('#upfile')[0].files = input.files;"); */
				$("#upfile")[0].files = input.files;
			}
			reader.readAsDataURL(input.files[0]);
			
		} else {
			$("#presview").attr("src", "/resources/testFolder/iconImg.png");
		}
	};
	
	// 폰 앞자리가 기타인 경우
	function changePhone(input) {
		if(input.value == "etc") {
			$("#m_phone4").show();
			$("#m_phone1").css("display", "block");
		} else {
			$("#m_phone4").val('');
			$("#m_phone4").hide();
			$("#m_phone1").css("display", "inline");
		}
	
	}
	
	</script>
</body>
</html>
