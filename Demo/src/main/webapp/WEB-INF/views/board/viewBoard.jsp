<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="#">
	<link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.min.css">
	<script src="/resources/js/jquery/jquery-3.7.1.min.js"></script>
	<title>view board page</title>
</head>
<body>
	<div class="container">
		<div class="row">	<!-- 카테고리 -->
			<div class="col-1"></div>
			<div class="col-1 tab">
				<span>카테고리</span>
			</div>
			<div class="col-9 cont">
				<span id="category"></span>
			</div>
			<div class="col-1"></div>
		</div>
		<div class="row">	<!-- 제목 -->
			<div class="col-1"></div>
			<div class="col-1 tab">
				<span>제목</span>
			</div>
			<div class="col-9 cont">
				<span name="title" id="title">${dto.title}</span>
			</div>
			<div class="col-1"></div>
		</div>
		<div class="row">	<!-- 작성자 -->
			<div class="col-1"></div>
			<div class="col-1 tab">
				<span>작성자</span>
			</div>
			<div class="col-9 cont">
				<span id="author" readonly>${dto.author}</span>
			</div>
			<div class="col-1"></div>
		</div>
		<div class="row">	<!-- 내용 -->
			<div class="col-1"></div>
			<div class="col-1 tab">
				<span>내용</span>
			</div>
			<div class="col-9 cont">
				<textarea id="content" readonly>${dto.content }</textarea>
			</div>
			<div class="col-1"></div>
		</div>
		<div class="row">	<!-- 첨부파일 -->
			<div class="col-1"></div>
			<div class="col-1 tab">
				<span>첨부파일</span>
			</div>
			<div class="col-9 cont imgDiv">
				<c:forEach var="filePath" items="${files }">
					<img class="img-thumbnail" src="${filePath}">
				</c:forEach>			
			</div>
			<div class="col-1"></div>
		</div>
		<div class="row" id="cmtDiv">
			<c:choose>
				<c:when test="${cmtList eq 'noComment'}">
					<div class="col">
						<span>해당 글에 작성된 댓글이 없습니다.</span>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-1"></div>
					<div class="col-10 row" id="cmtListDiv">
						<c:forEach var="cmt" items="${cmtList}">
							<div class="row cmtList">
								<div class="row cmtIdDiv">
									<span>${cmt.nickname}</span>
 								</div>		
								<div class="row cmtContDiv">
									<div class="col-8 cmtContent">
										<span>${cmt.content}</span>
										<input type="hidden" seq="${cmt.seq }">
										<input type="hidden" boardseq="${cmt.boardseq}">
									</div>
									<div class="col-2 cmtTime">
										<span><fmt:formatDate value="${cmt.regdate}" pattern="yyyy년 MM월 dd일" /></span><br/>
										<span><fmt:formatDate value="${cmt.regdate}" pattern="k시 m분 s초" /></span>						
									</div>
									<div class="col-2 cmtBtnDiv">
									<c:if test="${loginId ne '' }">
										<button type="button" class="btn btn-info" onclick="replyCmtForm(${cmt.seq}, this);">답글</button><br/>									
									</c:if>
									<c:if test="${loginId == cmt.id}">
										<button type="button" class="btn btn-danger delCmtBtn" onclick="delPwPop(${cmt.seq})">삭제</button>
										<button type="button" class="btn btn-success editCmtBtn" onclick="editCmt(${cmt.seq}, ${dto.seq}, this)">수정</button>											
									</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="col-1"></div>
				</c:otherwise>
			</c:choose>
		</div>
		<c:if test="${loginId ne '' }">
			<div class="row">	<!-- 댓글 / 회원인 경우에만 작성 가능 -->
				<div class="col-1"></div>
				<div class="col-10">
					<!-- <form name="cmtForm" action="/comment/write.do" method="post" id="cmtForm"> -->
						<input type="text" value="${loginId}" id="cmtId" readonly>
						<input type="password" placeholder="password" id="cmtPw" maxlength="20">
						<textarea id="cmtContent"></textarea>
						<button type="button" id="commentBtn" class="btn btn-primary">댓글작성</button>	
					<!-- </form> -->				
<!-- 				<div>
					<input type="hidden" id="delCmtSeq">
					<input type="hidden" id="delCmtPw">
					<input type="hidden" id="delCmtBoardseq">
					<input type="hidden" id="onEditing">
				</div> -->
				</div>
				<div class="col-1"></div>
				<form name="cmtForm" method="post" id="cmtForm">
					<input type="hidden" name="id" value="${loginId}">
					<input type="hidden" name="pw">
					<input type="hidden" name="content">
					<input type="hidden" name="boardseq" value="${dto.seq}">
					<input type="hidden" name="seq" value="0">
					<input type="hidden" name="pid" value="0">
				</form>
			</div>
		</c:if>
		<div class="row" id="btnDiv">
			<div class="col">
				<c:if test="${loginId == dto.author}">
			    	<button type="button" class="btn btn-success" id="editBtn">글 수정하기</button>
			    	<button type="button" class="btn btn-danger" id="delBtn">글 삭제하기</button>				
				</c:if>
	    		<button type="button" class="btn btn-secondary" id="listBtn">글 목록으로</button>				
			</div>
		</div>
	</div>
	<script>
		$(function(){
			// css
			$("div.tab, div.cont").css({"border" : "1px solid black", "padding" : "5px"});
			$("#btnDiv button").css({"display" : "inline-block", "width" : "20%", "margin": "5px"});
			$("#btnDiv, .tab, .imgDiv").css("text-align", "center");	
			$(".container").css("margin-top", "20px");
			$("#content").css({"width" : "100%", "height" : "300px", "border" : "none", "resize" : "none"});
			$("textarea").css("outline", "none");
			$(".img-thumbnail").css({"width":"200px", "height":"200px"});
			$(".cmtList").css({"border":"1px black solid", "margin":"5px"});
			$(".cmtIdDiv").css({"margin-bottom":"10px"});
			$("#cmtForm").css({"margin-top":"10px"});
			$("#cmtContent").css({"margin-top":"10px", "width":"80%", "height":"100px", "resize":"none"});
			$(".delCmtBtn").css({"margin-top":"5px", "margin-right":"5px", "margin-bottom":"5px"});
			
			
			// 초기 세팅
			//// 카테고리
			switch("${dto.category}") {
				case 'free' :
					$("#category").text("자유게시판");
				break;
				case 'notice' :
					$("#category").text("공지사항");
				break;
			}
						
			// 글 수정하기
			$("#editBtn").click(function(){
				window.location.replace("/board/editArticle?seq=${dto.seq}");
			});
			
			// 글 삭제하기
			$("#delBtn").click(function(){
				window.location.replace("/board/delArticle?seq=${dto.seq}&attachfile=${dto.attachfile}");
			});
			
			// 글 목록으로
			$("#listBtn").click(function(){
				window.location.replace("/board/toList");
			});
			
			// 댓글 작성
			$("#commentBtn").on("click", function() {
				// cmtForm 초기화(pw, content)
				cmtFormReset();
				
				var cmtPw = $("#cmtPw").val().trim();
				var cmtContent = $("#cmtContent").val().trim();
				
				// 유효성 검사
/* 				//// 댓글 비밀번호(4자리 이상)
				if(cmtPw.length < 4) {
					alert("댓글 비밀번호를 4자리 이상 입력해주세요.");
					return ;
				}
				
				
				//// 댓글 입력
				var cmtContent = $("#cmtContent").val().trim();
				if(cmtContent.length < 1) {
					alert("댓글 내용을 입력해주세요.");
					return ;
				} */
				
				validCheck(cmtPw, cmtContent);
				$("form[name='cmtForm'] input[name='pw']").val(cmtPw);
				$("form[name='cmtForm'] input[name='content']").val(cmtContent);
				
				$.ajax({
					type: "post",
					url: "/comment/write.do",
					data: $("#cmtForm").serialize(),
					success: function(data){
						$("#cmtPw, #cmtContent").val("");
						commentReload();
					},
					error: function(data){
						alert("ajax 실패");
						console.log(data);
					}
				});
			});
			
			
			
		})	// function end
		
		// 댓글 작성 후 리로드
		function commentReload() {
			$.ajax({
				type: "post",
				url: "/comment/list",
				data: {
					"boardseq" : "${dto.seq}"	
				},
				success: function(data) {
					var appendStr = "";
					for(var i=0; i < data.length; i++) {
						appendStr = appendStr + "<div class='row cmtList'>"
												+ "<div class='row cmtIdDiv'>"
												+	 "<span>" + data[i].nickname + "</span>"
												+ "</div>"
												+ "<div class='row cmtContDiv'>"
												+	"<div class='col-8 cmtContent'>"
												+		"<span>" + data[i].content + "</span>"
												+		"<input type='hidden' seq='" + data[i].seq + "'>"
												+		"<input type='hidden' boardseq='" + data[i].boardseq + "'>"
												+	"</div>"
												+	"<div class='col-2 cmtTime'>"
												+		"<span>" + cvtDateFormat(data[i].regdate) + "</span>"
												+	"</div>"
												+	"<div class='col-2 cmtBtnDiv'>"
												+		"<button type='button' class='btn btn-info' onclick='replyCmtForm(" + data[i].seq + ", this)'>답글</button><br/>";
						
												if("${loginId}" == data[i].id) {
													appendStr =	appendStr +	"<button type='button' class='btn btn-danger delCmtBtn' "
															+ 		"onclick='delPwPop(" + data[i].seq +", " + data[i].boardseq +")'>삭제</button>"
															+		"<button type='button' class='btn btn-success editCmtBtn' "
															+		"onclick='editCmt(" + data[i].seq + ", " + data[i].boardseq + ", this)'>수정</button>";
												}
						appendStr = appendStr + "</div> </div> </div>";
					}
					
					$("#cmtListDiv").children().remove();
					$("#cmtListDiv").append(appendStr);
					$(".cmtList").css({"border":"1px black solid", "margin":"5px"});
					$(".cmtIdDiv").css({"margin-bottom":"10px"});
					$("input[name='pw'], #cmtContent").val("");
					$("button.delCmtBtn").css({"margin-top":"5px", "margin-right":"5px", "margin-bottom":"5px"});
				},
				error: function(data) {
					alert("리로드 실패");
					console.log(data);
				}
			});
		}
		
		// 날짜 변환
		function cvtDateFormat(date) {
			date = new Date(date);
			return date.getFullYear() + '년 ' + (date.getUTCMonth()%12+1) + '월 ' + date.getUTCDate() + '일 <br>'
					+ date.getHours() + '시 ' + date.getMinutes() + '분 ' + date.getSeconds() + '초';
		}
		
		// 댓글 삭제
		function delCmt(cmtSeq) {
			$.ajax({
				type: "get",
				url: "/comment/delete.do",
				data: {"seq" : cmtSeq},
				success: function(data){
					commentReload();
				},
				error: function(data){
					console.log(data);
					alert("댓글 삭제에 실패하였습니다.");
				}
			});
		}
		
		
		// 댓글 비밀번호 체크
		function delPwCheck (pw) {
			var cmtSeq		= $("form[name='cmtForm'] input[name='seq']").val();
			
			if(pw.length < 4) {
				alert("비밀번호를 4자리 이상 입력해주세요.");
				return;
			}			
			
			$.ajax({
				type: "post",
				url: "/comment/passwordCheck",
				data:
				{
					"seq" : cmtSeq
					, "pw" : pw
				},
				success: function(data){
					if(data > 0 && confirm("정말 댓글을 삭제하시겠습니까?")) {
						delCmt(cmtSeq);					
					} else {
						alert("비밀번호가 일치하지 않습니다.");
					}
				},
				error: function(data) {
					alert("댓글 비밀번호 확인 오류");
				}
			});
			
		}
		
		
		// 댓글 비밀번호 팝업
		function delPwPop(cmtSeq) {
			window.open("/comment/toPwCheck", "댓글 비밀번호 입력", "width=700px,height=200px,left=610,top=340,scrollbars=yes");
			$("form[name='cmtForm'] input[name='seq']").val(cmtSeq);
		}
		
		// 댓글 수정 버튼
		function editCmt(cmtSeq, boardSeq, el) {
/* 			if($("#onEditing").val() == 1) {
				alert("현재 수정 중인 댓글이 있습니다.");
				return;
			}
			$("#onEditing").val(1); */
			
			var ce = $(el).parents("div.cmtList").clone();
			ce.find("div.cmtContent").append("<textarea type='text' id='editCmtContent_" + ce.find("div.cmtContent input[seq]").attr("seq")
												+ "' style='width:100%; resize:none;'>"
												+ ce.find("div.cmtContent").children()[0].innerText + "</textarea>");
			/* ce.find("div.cmtContDiv").after("<form name='editCmtForm' action='/comment/editProc.do' type='post' id='editCmtForm'>"
											+ "<input type='hidden' name='seq' value='" + ce.find("div.cmtContent input[seq]").attr("seq") + "'>"
											+ "<input type='hidden' name='content'>"
											+ "</form>"); */
			ce.find("div.cmtContent").children().first().remove();
			ce.find("div.cmtBtnDiv").children().remove();
			ce.find("div.cmtBtnDiv").append("<button type='button' class='btn btn-primary editProcBtn' onclick='editCmtProc("
											+ ce.find("div.cmtContent input[seq]").attr("seq") + ")'>수정</button>");
			ce.find("div.cmtBtnDiv").append("<button type='button' class='btn btn-secondary' onclick='cancelEditCmt(this)'>취소</button>");
			$(el).parents("div.cmtList").after(ce).hide();
			$("button.editProcBtn").css({"margin-top":"5px", "margin-right":"5px", "margin-bottom":"5px"});
		}
		
		// 댓글 수정 요청
		function editCmtProc(cmtSeq) {
			// cmtForm 초기화
			cmtFormReset();
			
			// 수정한 댓글 내용 form에 담기
			//$("#editCmtForm input[name='content']").val($("#editCmtContent").val());
			$("form[name='cmtForm'] input[name='seq']").val(cmtSeq);
			$("form[name='cmtForm'] input[name='content']").val($("#editCmtContent_" + cmtSeq).val());
			
			
			$.ajax({
				type: "get",
				url: "/comment/editProc.do",
				data: $("#editCmtForm").serialize(),
				success: function(data) {
					commentReload();
					//$("#onEditing").val(0);	// 수정 완료 후 수정중 플래그 0으로 만들기
				},
				error: function(data) {
					alert("댓글 수정 요청 실패");
				}
			});
		}
		
		// 댓글 수정 취소
		function cancelEditCmt(el) {
			$("#onEditing").val(0);
			$(el).parents("div.cmtList").prev().show();
			$(el).parents("div.cmtList").remove();
		}
		
		// 댓글 - 답글
		function replyCmtForm(cmtSeq, el) {
			if($("#replyDiv" + cmtSeq).length > 0) return;
			
			// 답글 폼 만들기
			//var formStr = "<form name='replyCmtForm' action='/comment/replyCmtProc.do' method='post'>"
			var formStr = "<div class='replyDiv' id='replyDiv" + cmtSeq + "'>"
						+		"<div class='row'>"
						+			"<div class='col'>	<span>대댓글 비밀번호 : <input type='password' id='replyCmtPw_" + cmtSeq + "'> </span>	</div>"
						+		"</div>"
						+		"<div class='row replyCmtContDiv'>"
						+			"<div class='col-10'>"
						+				"<textarea name='content' id='replyCmtContent_" + cmtSeq + "'></textarea>"
						+			"</div>"
						+			"<div class='col-2 replyCmtBtnDiv'>"
						+				"<button type='button' class='btn btn-primary' onclick='replyCmtProc(" + cmtSeq + ")'>대댓글</button>"
						+				"<button type='button' class='btn btn-secondary' onclick='cancelReplyCmt(this)'>취소</button>"
						+			"</div>"
						+			"<div>"
						+				"<input type='hidden' ame='pid' value='" + cmtSeq +"'>"
						+			"</div>"
						+		"</div>"
						+	"</div>";
						//+ "</form>";
						
			$(el).parents("div.cmtList").after(formStr);
			
			// css
			$("div.replyDiv").css({"border":"1px solid black", "padding":"10px"});
			$("div.replyCmtBtnDiv button:first-child").css({"margin-right":"5px"});
			$("div.replyCmtContDiv").css("margin-top", "10px");
			$("#replyCmtContent_"+cmtSeq).css({"width":"100%", "resize":"none"});
			
		}
		
		// 댓글 - 답글 요청
		function replyCmtProc(pid) {
			// cmtForm 초기화
			cmtFormReset();
			
			// 유효성 검사
			validCheck($("#replyCmtPw_" + pid).val(), $("#replyCmtContent_" + pid).val());
			
			// 답글 비밀번호, 내용, pid 수정
			$("form[name='cmtForm'] input[name='pw']").val($("#replyCmtPw_" + pid).val());
			$("form[name='cmtForm'] input[name='content']").val($("#replyCmtContent_" + pid).val());
			$("form[name='cmtForm'] input[name='pid']").val(pid);
			
			
			$.ajax({
				type: "post",
				url: "/comment/replyCmtProc.do",
				data: $("#cmtForm").serialize(),
				success: function(data) {
					alert("대댓글 요청 성공");
				},
				error: function(data) {
					alert("대댓글 요청 실패");
				}
			});
		}
		
		// // cmtForm 초기화(pw, content)
		function cmtFormReset() {
			$("form[name='cmtForm'] input[name='pw'], form[name='cmtForm'] input[name='content']").val("");
		}
		
		// 댓글 - 답글 창 닫기
		function cancelReplyCmt(el) {
			$(el).parents("div.replyDiv").remove();
		}
		
		// 댓글 유효성 검사
		function validCheck(cmtPw, cmtContent) {
			// 유효성 검사
			//// 댓글 비밀번호(4자리 이상)
			if(cmtPw.length < 4) {
				alert("댓글 비밀번호를 4자리 이상 입력해주세요.");
				return ;
			}
			
			//// 댓글 입력
			if(cmtContent.length < 1) {
				alert("댓글 내용을 입력해주세요.");
				return ;
			}
		}
	</script>
</body>
</html>