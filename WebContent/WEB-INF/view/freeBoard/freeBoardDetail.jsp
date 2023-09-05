<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>detail here</title>
</head>
<body>

	<div>
		<h1>자유게시판</h1>
	</div>
	<div style="width: 650px;" align="right">
		<a href="./main.ino">리스트로</a>
	</div>
	<hr style="width: 600px">

	<form action="./freeBoardModify.ino">
		<div style="width: 150px; float: left;">이름 :</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" name="name" value="${freeBoardDto.name }" readonly />
		</div>

		<div style="width: 150px; float: left;">제목 :</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" name="title" value="${freeBoardDto.title }"
				readonly />
		</div>

		<div style="width: 150px; float: left;">작성날자</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" name="regdate" value="${freeBoardDto.regdate }"
				readonly />
		</div>

		<div style="width: 150px; float: left;">내용 :</div>
		<div style="width: 500px; float: left;" align="left">
			<textarea name="content" rows="25" cols="50" readonly>${freeBoardDto.content }</textarea>
		</div>
		<div align="right">
			<%-- <a href="./freeBoardModify.ino?num=${freeBoardDto.num }">수정</a> --%>
			<input type="hidden" name="num" value="${freeBoardDto.num }">
    		<button type="submit">수정</button>
		<input type="button" value="취소" name="cancel"
			onclick="location.href='./main.ino'">
		</div>

	</form>

</body>
</html>