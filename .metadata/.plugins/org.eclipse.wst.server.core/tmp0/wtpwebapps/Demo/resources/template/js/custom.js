$("#category").css("width", "60%");

// 사이드바 - 회원 탈퇴
$("#signOut").click(function(){
	if(confirm("정말로 회원 탈퇴하시겠습니까?")) {
		if(confirm("회원 탈퇴 후에는 정보를 복구할 수 없습니다.")) {
			var tempForm = $("<form></form>");
			var loginId = $("#loginId").val();
			
			tempForm.attr("name", "delMember");
			tempForm.attr("method", "post");
			tempForm.attr("action", "/member/delMember.do");
			tempForm.append($("<input/>",{type:"text",name:"id",value:loginId}));
			tempForm.append($("<input/>",{type:"text",name:"self",value:"y"}));
			
			//tempForm.appendTo("body");
			
			tempForm.submit();
		}
	}
});