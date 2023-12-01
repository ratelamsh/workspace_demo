<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" type="image/x-icon" href="data:image/x-icon;">
	<link rel="stylesheet" href="/resources/css/bootstrap/bootstrap.min.css">
	<script src="/resources/js/jquery/jquery-3.7.1.min.js"></script>
	<title>member list</title>
</head>
<body>
 	<div class="container">
		<c:if test="${masteryn eq 'y'.charAt(0)}">
			<h1>[관리자 페이지]</h1>
		</c:if>
		<h1>회원 목록</h1>
 		<div class="row">
 			<div class="col-9">
				<form name="searchForm" action="/member/list" method="get" id="searchForm">
	 				<select name="searchType" class="custom-select" id="searchType">
	 					<option value="0">ID</option>
						<option value="1">NICKNAME</option>
						<option value="2">NAME</option>
						<option value="3">ADDRESS</option>
						<option value="4">PHONE</option>
						<option value="5">전체</option>
	 				</select>
	 				<input type="text" name="searchKeyword" class="form-control" id="searchKeyword" value="${srchInfo.searchKeyword }"> 	
	 				<button type="button" class="btn btn-dark" id="searchBtn">검색</button>
	 				<label for="pageSize">페이지 당 row 수</label>
	 				<select name="pageSize" class="custom-select" id="pageSize">
	 					<option value="2">2</option>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
						<option value="100">100</option>
	 				</select>
				</form>
 			</div>
 			<div class="col-3" style="text-align: right">
	 			<button class="btn btn-warning" id="logoutBtn">로그아웃</button>
	 			<c:if test="${masteryn eq 'y'.charAt(0)}">
	 				<button class="btn btn-danger" id="selDelMember">선택 회원 삭제</button>
 				</c:if>
			</div> 			
		</div>

		<table class="table">
			<thead>
				<tr>
					<c:if test="${masteryn eq 'y'.charAt(0)}">
						<th scope="col">선택</th>					
					</c:if>
					<th scope="col">#</th>
					<th scope="col">ID</th>
					<th scope="col">닉네임</th>
					<th scope="col">이름</th>
					<th scope="col">주소</th>
					<th scope="col">전화번호</th>
					<th scope="col">가입일자</th>
					<c:if test="${masteryn eq 'y'.charAt(0)}">
						<th scope="col">수정</th>
						<th scope="col">삭제</th>
					</c:if>
				</tr>
			</thead>
		
			<tbody>
				<c:forEach var="member" items="${list }" varStatus="status">
				<tr>
					<c:if test="${masteryn eq 'y'.charAt(0)}">
						<td><input type="checkbox" class="memCheckBox form-check-input" name="memCheckBox" value="${member.id }"></td>					
					</c:if>
					<th scope="row">${srchInfo.pagination.startIndex+status.count}</th>
					<td><c:out value="${member.id }"/></td>
					<td><c:out value="${member.nickname }"/></td>
					<td><c:out value="${member.name }"/></td>
					<td><c:out value="${member.address }"/></td>
					<td><c:out value="${member.phone }"/></td>
					<td>
						<%-- <c:out value="${member.regdate }"/> --%>
						<span><fmt:formatDate value="${member.regdate }" pattern="yyyy년 MM월 dd일" /></span><br/>
						<span><fmt:formatDate value="${member.regdate }" pattern="k시 m분 s초" /></span>		
					</td>
					<c:if test="${masteryn eq 'y'.charAt(0)}">
						<td><button type="button" class="btn btn-secondary BtnEditMember" id="BtnEditMember" value="${member.id }">수정</button></td>
						<td><button type="button" class="btn btn-danger BtnDelMember" id="BtnDelMember" value="${member.id }">삭제</button></td>					
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  	<c:if test="${srchInfo.pagination.curRange > 1 }">
		    	<li class="page-item"><a class="page-link" id="prevPage">Previous</a></li>
		    </c:if>
		    <c:forEach var="i" begin="${srchInfo.pagination.startPage }" end="${srchInfo.pagination.endPage }">
		    	<li class="page-item"><a class="page-link toPage" value="${i }" >${i }</a></li>
		    </c:forEach>
		    <c:if test="${srchInfo.pagination.rangeCnt > srchInfo.pagination.curRange}">
		    	<li class="page-item"><a class="page-link" id="nextPage">Next</a></li>
		    </c:if>
		  </ul>
		</nav>
	</div>
	<script>
		$(function(){
			// 삭제 버튼 클릭
			$(".BtnDelMember").click(function(){
				var param = "id=" + $(this).val();
				console.log('param : ' + param);
 				$.ajax({
					url: "${pageContext.request.contextPath}/member/delMember.do",
//					contentType: "application/json",
					method: "post",
//					data: JSON.stringify({
//						id: $(this).val()
//					}),
					data: param,
					success:function(data){
						alert("삭제 성공");
						window.location.replace("/member/list");
					},
					error:function(data){
						alert("삭제 실패");
					}
				})
			});
			
			
			// 선택 회원 삭제
			$("#selDelMember").on("click", function(){
				var selectedMember = [];
				$(".memCheckBox:checked").each(function(i) {
					selectedMember.push($(this).val());
				});
				console.log(selectedMember);
				console.log(JSON.stringify(selectedMember));
				
  				$.ajax({
					url: "${pageContext.request.contextPath}/member/selDelMember.do",
					method: "post",
					contentType: "application/json",
					data: JSON.stringify(selectedMember),
					success: function(data){
						alert("선택 삭제 성공");
						window.location.replace("/member/list");
					},
					error: function(data) {
						alert("선택 삭제 실패");
					}
				});
			});
			
			// 수정 버튼 클릭
 			$(".BtnEditMember").on("click", function(){
 				window.location.replace("/member/editMember?id="+$(this).val());
 			});
			
			// 검색 버튼 클릭
			$("#searchBtn").on("click", function(){
				search();
			});
			
			// 검색창에서 엔터
			$("searchKeyword").keypress(function(){
				search();
			});
			
			// 검색 함수
			function search() {				
				var searchType = $("#searchType").val();
				var searchKeyword = $("#searchKeyword").val();
				
				console.log("searchType : " + searchType + " / searchKeyword : " + searchKeyword);
				
				$("#searchForm").submit();
			}
			
			// 전 페이지의 내용 전달
			$("#searchType").val("${srchInfo.searchType}").prop("selected", true);
			$("#pageSize").val("${srchInfo.pagination.pageSize}").prop("selected", true);
			
			// 페이징
			//// 페이징 파라미터
			var searchType		= "";
			var searchKeyword	= "";
			var curPage			= "";
			var pageSize		= "";
			var url				= "";
			
			function setPaginationParam(opt, pageNo) {
				switch(opt) {
				case "prev" :
					curPage = "${(srchInfo.pagination.curRange-1)*srchInfo.pagination.rangeSize}";
				break;
				case "next" :
					curPage = "${(srchInfo.pagination.curRange*srchInfo.pagination.rangeSize)+1}";
				break;
				default :
					curPage = pageNo;
				break;
				}
				searchType		= $("#searchType").val();
				searchKeyword	= $("#searchKeyword").val();
				pageSize		= $("#pageSize").val();				
				url				= "/member/list?" + "searchType=" + searchType + "&searchKeyword=" + searchKeyword
										+ "&curPage=" + curPage + "&pageSize=" + pageSize;
			}
			
			//// 이전 페이지 클릭
			$("#prevPage").click(function(){
				setPaginationParam('prev');
				window.location.href=url;
				// window.location.replace(url);
				// window.open(url);
			});
			
			//// 다음 페이지 클릭
			$("#nextPage").click(function(){
				setPaginationParam('next');
				window.location.href=url;
			});
			
			//// 특정 페이지 클릭
			$(".toPage").click(function(){
				setPaginationParam('cur', $(this).attr("value"));
				window.location.href=url;
			});
			
			//// 한 페이지 row 수 변경
			$("#pageSize").on("change", function(){
				setPaginationParam('cur', 1);		
				window.location.href=url;
			});
			
			// 로그아웃 버튼
			$("#logoutBtn").click(function(){
				window.location.replace("/common/logout?id=${loginId}");
			});
			
			// css 수정
			//// 검색
			$("#searchKeyword").css("width","50%");
			$(".form-control").css("display","inline");
			//// 페이지
			$(".page-item").css("cursor", "pointer");
			$(".page-item").find("a[value=${srchInfo.pagination.curPage}]").css("color", "pink");
			// row select
			$("label").css("padding-left", "100px");

			
		});	// funcion() end
		
		
		
	</script>
</body>
</html>