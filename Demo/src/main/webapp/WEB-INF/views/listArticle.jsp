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
	<title>article list</title>
</head>
<body>
	<div class="container">
		<c:if test="${masteryn eq 'y'.charAt(0)}">
			<h1>[관리자 메뉴 - 게시판 관리]</h1>	
		</c:if>
		<c:if test="${loginId ne ''}">
			<h1>${loginId }님 오늘도 행복한 하루 보내세요 *^^*</h1>
			<button type="button" class="btn btn-secondary" id="logoutBtn">로그아웃</button>
		</c:if>
		<!-- Article List -->
		<div class="searchTab">
			<button class="btn btn-warning" id="writeBtn">글 작성</button>
		</div>
		<form method="get" action="/board/toList" name="searchForm" id="searchForm">
			<div class="row">
				<div class="col">
					<select class="form-select" name="category" id="category" onchange="changeCategory(this)">
						<option value="free">자유게시판</option>
						<option value="notice">공지사항</option>
					</select>
					<select class="form-select" name="searchType" id="searchType">
						<option value="0">제목</option>
						<option value="1">작성자</option>
					</select>					
					<input type="text" class="form-control" name="searchKeyword">
					<button type="button" class="btn btn-primary" id="searchBtn">검색</button>
					<span>페이지 수</span>
					<select class="form-select" name="pageSize" id="pageSize" onchange="changePageSize(this)">
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
						<option value="100">100</option>
					</select>
					<input type="hidden" name="curPage" id="curPage" value="${srchInfo.pagination.curPage }">
				</div>
			</div>
		</form>
		<table class="table">
			<thead>
				<tr>
					<c:if test="${masteryn eq 'y'.charAt(0)}">
						<th scope="col">선택</th>					
					</c:if>
					<th>#</th>
					<th>게시판 종류</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<c:if test="${masteryn eq 'y'.charAt(0)}">
						<th scope="col">수정</th>					
						<th scope="col">삭제</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${list ne null }">
						<c:forEach var="dto" items="${list}" varStatus="status">
							<tr>
								<%-- <td>${status.count + srchInfo.pagination.startIndex}</td> --%>
								<c:if test="${masteryn eq 'y'.charAt(0)}">
									<td><input type="checkbox"></td>
								</c:if>
								<td>${srchInfo.pagination.listCnt - (status.count + srchInfo.pagination.startIndex -1)}</td>
								<td>
									<c:choose>
										<c:when test="${dto.category eq 'free'}">
											자유게시판
										</c:when>
										<c:when test="${dto.category eq 'notice'}">
											공지사항
										</c:when>
									</c:choose>
								</td>
								<td>
									<c:if test="${dto.pid > 0 }">
										<img src="/resources/image/replyArrow.png" style="height:15px">						
									</c:if>
									<a class="title" href="/board/viewArticle?seq=${dto.seq}&pid=${dto.pid}">${dto.title }
									<span class="commentCnt">[${dto.commentcnt}]</span></a>
								</td>
								<td class="authors" author="${dto.etc}" nickname="${dto.author }">${dto.author }</td>
								<td><fmt:formatDate value="${dto.regdate}" pattern="yyyy년 MM월 dd일 k시 m분 s초" /></td>
								<td>${dto.viewcnt }</td>
								<c:if test="${masteryn eq 'y'.charAt(0)}">
									<td><button type="button" class="btn btn-success editBtn" seq="${dto.seq}" pid="${dto.pid}">수정</button></td>					
									<td><button type="button" class="btn btn-danger delBtn">삭제</button></td>
								</c:if>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">조건에 맞는 게시글이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div class="layer_popup">
			<button type="button" class="btn btn-info" id="toMemberArticle">사용자 게시글 보기</button>
		</div>
		<c:if test="${srchInfo ne null}">
			<!-- Pagination -->
			<ul class="pagination">
				<c:if test="${srchInfo.pagination.curRange > 1}">
					<li class="page-item"><a class="page-link" onclick="toPrevPage(${(srchInfo.pagination.curRange-1) * srchInfo.pagination.rangeSize})">Previous</a></li>			
				</c:if>
				<c:forEach var="i" begin="${srchInfo.pagination.startPage}" end="${srchInfo.pagination.endPage}">
					<li class="page-item"><a class="page-link" onclick="toPage(${i})">${i}</a></li>
				</c:forEach>
				<c:if test="${srchInfo.pagination.rangeCnt > srchInfo.pagination.curRange}">
					<li class="page-item"><a class="page-link" onclick="toNextPage(${(srchInfo.pagination.curPage*srchInfo.pagination.rangeSize)+1})">Next</a></li>			
				</c:if>
			</ul>		
		</c:if>
	</div>
	<script>
		$(function() {
			// 글 작성 버튼
			$("#writeBtn").click(function(){
				window.location.replace("/board/toWrite");
			});
			
			// 검색 버튼
			$("#searchBtn").click(function(){
				$("#searchForm").submit();
			});
			
			// 로그아웃 버튼
			$("#logoutBtn").click(function(){
				window.location.replace("/common/logout?id=${loginId}");
			});
			
			// 초기 값 세팅
			if("${srchInfo}" != "") {
	 			$("#category").val("${srchInfo.category}");
				$("#searchType").val("${srchInfo.searchType}");
				$("#pageSize").val("${srchInfo.pagination.pageSize}");
				$("input[name='searchKeyword']").val("${srchInfo.searchKeyword}");
			}
			
			
			// css
			$("table").css({"text-align":"center"});
			$("a.title").parents("td").css({"text-align":"left"});
			$("a.title").css({"color":"black", "text-decoration":"none"});
			$("input[name='searchKeyword'], select").css({"width" : "20%", "display" : "inline", "margin" : "5px"});
			$("#searchBtn").css("margin-right", "20px");
			$(".layer_popup").hide();
			$(".page-link").css("cursor", "pointer");
			$("span.commentCnt").css({"color":"#FF5A5A", "font-weight":"bold"});
			
			
			
			// 요소 클릭 시 클릭한 요소 위치에 레이어팝업 띄우기
			$(".authors").on("click", function(e){
				target = $(e.target);
				console.log(target);
				var p = $(target).offset();
				$("#toMemberArticle").attr("author", target.attr("nickname"));
				
				var divTop	= p.top + 30;	// 상단 좌표
				var divLeft	= p.left;		// 좌측 좌표
				
				// 레이어 팝업 view
				$(".layer_popup").css({"z-index" : "10000", "top" : divTop, "left" : divLeft, "position" : "absolute"}).show();
			});
			
			// 다른 곳 클릭 시 레이어 팝업 사라짐
			$(document).click(function(){
				var authors = $(".authors");
				var toMemberArticle = $("#toMemberArticle");
				if((!authors.is(event.target) && !authors.has(event.target).length)) {
					$(".layer_popup").hide();
				}
			});
			
			// 페이지 이동
			$("#toMemberArticle").click(function(e){
				console.log("사용자 게시글로 이동");
				$("#searchType").val(1);
				$("input[name='searchKeyword']").val($(this).attr("author"));
			});
			
			// 수정 버튼
			$("button.editBtn").click(function(e){
				window.location.replace("/board/editArticle?seq=" + $(this).attr("seq") + "&pid=" + $(this).attr("pid"));
			});
			
			
		});	// function() end
		
		// 카테고리 변경 시 페이지 리로드
		function changeCategory(cate) {
				window.location.replace("/board/toList?category="+$(cate).val());
		}
		
		// 페이지 이동
		function toPage(page) {
			$("#curPage").val(page);
			$("#searchForm").submit();
		}
		
		// 페이지 사이즈 변경
		function changePageSize(pageSize) {
			$("#searchForm").submit();
		}
	</script>
</body>
</html>