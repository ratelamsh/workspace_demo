<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">
	
		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@ include file="/WEB-INF/views/common/topbar.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">
                
               
                
						<!-- Article List -->
						<div class="searchTab" style="text-align:right;">
							<c:if test="${loginId ne ''}">
								<div class="col">
									<button type="button" class="btn btn-warning" id="writeBtn">글 작성</button>
									<c:if test="${masteryn eq 'y'.charAt(0)}">
										<button type="button" class="btn btn-danger" id="selDelBtn">선택한 게시글 삭제</button>
									</c:if>
								</div>
							</c:if>
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
				                                            <td><input type="checkbox" name="delList" value="${dto.seq}#${dto.pid}#${dto.attachfile}#${dto.commentcnt > 0 ? 'y' : 'n'}"></td>
				                                        </c:if>
				                                        <td>${srchInfo.pagination.listCnt - (status.count + srchInfo.pagination.startIndex -1)}</td>
				                                        <td>
				                                            <c:choose>
				                                                <c:when test="${dto.category eq 'free'}">자유게시판</c:when>
				                                                <c:when test="${dto.category eq 'notice'}">공지사항</c:when>
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
				                                            <td><button type="button" class="btn btn-danger" onclick="delArticle(${dto.seq},${dto.pid},'${dto.attachfile}','${dto.commentcnt > 0 ? 'y' : 'n'}')">삭제</button></td>
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
					</form>
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->
    
	<!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="ModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="/common/logout">Logout</a>
                </div>
            </div>
        </div>
    </div>



    <!-- Custom scripts for all pages-->
    <script src="/resources/template/js/sb-admin-2.min.js"></script>
    
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
		
		// 선택 게시물 삭제
		$("#selDelBtn").click(function(){
			var frm = $("#searchForm");
			frm.attr("action", "/board/selDelArticle");
			frm.attr("method", "post");
			frm.submit();
		});
		
		// 관리자 메뉴
		$("#masterMenu").click(function(){
			window.location.replace("/master/home");
		});
		
		// 초기 값 세팅
		if("${srchInfo}" != "") {
 			$("#category").val("${srchInfo.category}");
			$("#searchType").val("${srchInfo.searchType}");
			$("#pageSize").val("${srchInfo.pagination.pageSize}");
			$("input[name='searchKeyword']").val("${srchInfo.searchKeyword}");
		}
		
		// css
/* 		$("table").css({"text-align":"center"});
		$("a.title").parents("td").css({"text-align":"left"});
		$("a.title").css({"color":"black", "text-decoration":"none"});
		$("input[name='searchKeyword'], select").css({"width" : "20%", "display" : "inline", "margin" : "5px"});
		$("#searchBtn").css("margin-right", "20px");
		$(".layer_popup").hide();
		$(".page-link").css("cursor", "pointer");
		$("span.commentCnt").css({"color":"#FF5A5A", "font-weight":"bold"});
		$("table").css({"margin-top":"30px"}); */
		
		// 요소 클릭 시 클릭한 요소 위치에 레이어팝업 띄우기
		$(".authors").on("click", function(e){
			target = $(e.target);
			console.log(target);
			var p = $(target).offset();
			$("#toMemberArticle").attr("author", target.attr("nickname"));
			
			var divTop	= p.top + 30;	// 상단 좌표
			var divLeft	= p.left;		// 좌측 좌표
			
			// 레이어 팝업 view
		//	$(".layer_popup").css({"z-index" : "10000", "top" : divTop, "left" : divLeft, "position" : "absolute"}).show();
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
	
	// 게시글 삭제
	function delArticle(seq, pid, attachfile, cmtYn) {
		window.location.replace("/board/delArticle?seq=" + seq + "&pid=" + pid + "&attachfile=" + attachfile + "&cmtYn=" + cmtYn);
	}
	</script>
	
</body>
</html>