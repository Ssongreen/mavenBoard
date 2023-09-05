<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h1>자료실</h1>
	</div>
	<div style="width: 650px;" align="right">
		<a href="./archiveInsert.ino">글쓰기</a>
	</div>
	<hr style="width: 600px">

	<c:forEach items="${archiveList }" var="archiveDto">
		<div style="width: 50px; float: left;">${archiveDto.num }</div>
		<div style="width: 300px; float: left;">
			<a href="./archiveDetail.ino?num=${archiveDto.num }">${archiveDto.title }</a>
		</div>
		<div style="width: 150px; float: left;">${archiveDto.name }</div>
		<div style="width: 150px; float: left;">${archiveDto.regdate }</div>
		<hr style="width: 600px">
	</c:forEach>
	 <form id="searchFormArchive" action="./archiveMain.ino">
		<select name="type">
			<option value="title"
			<c:out value="${pageMaker.cri.type eq 'title'?'selected':''}"/>>제목</option>
			<option value="name"
			<c:out value="${pageMaker.cri.type eq 'name'?'selected':''}"/>>작성자</option>
		</select> 
		<input type="text" id="keyword" name="keyword" />
		<button class="btn btn-default" type="submit" >검색</button>
		<!-- Paging -->
		<nav class="page navigation">
		<div class="pagination">
			<span class="paginate_button previous"> 
				<a class="page-link" href="?${pageMaker.cri.getListLink()}">처음으로</a>
			</span>
			<span class="paginate_button pev"> 
			<c:if test=" ${pageMaker.getCurrentPage() > 1}">
				<a class="page-link" href="?pageNum=${pageMaker.getCurrentPage() - 1}&${pageMaker.cri.getListLink()}">이전</a>
			</c:if>
				
			</span> 
			<c:forEach var="num" begin="${pageMaker.startPage >= 0 ? pageMaker.startPage : 0}" end="${pageMaker.endPage >= 0 ? pageMaker.endPage : 0}">
				<span class="paginate_button"> 
        			<a class="page-link" href="?pageNum=${num}&${pageMaker.cri.getListLink()}">${num}</a>
				</span>
			</c:forEach>
			<span class="paginate_button next" > 
				<c:if test="${pageMaker.getCurrentPage() < pageMaker.endPage}">
				<a class="page-link" href="?pageNum=${pageMaker.getCurrentPage() + 1}&${pageMaker.cri.getListLink()}">다음</a>
				</c:if>
			</span> 
			<span class="paginate_button end"> 
				<a class="page-link" href="?pageNum=${pageMaker.endPage}&${pageMaker.cri.getListLink()}">끝</a>
			</span>
		</div>
		</nav>
		<div id='actionForm' >
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		</div>
		</form>
	<style>
		nav {
			display: flex;
			justify-content: center;
		}
	</style>
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script>
	var searchFormArchive = $("#searchFormArchive");

	$("#searchForm button").on( "click", function(e) {
			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			
			searchForm.submit();
		});
</script>
</body>
</html>