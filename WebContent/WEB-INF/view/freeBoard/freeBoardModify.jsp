<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h1>자유게시판</h1>
	</div>
	<div style="width: 650px;" align="right">
		<a href="./main.ino">리스트로</a>
	</div>
	<hr style="width: 600px">

	<form action="./freeBoardUpdate.ino" method="POST" onsubmit="return validateForm()">
		<div style="display: none;">
		<!-- 숨김 처리 -->
			<input type="number" name="num" value="${freeBoardDto.num}" readonly />
		</div>
		<div style="width: 150px; float: left;">이름 :</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" id="name" name="name" value="${freeBoardDto.name }" />
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
			<textarea id="content" name="content" rows="25" cols="50">${freeBoardDto.content }</textarea>
		</div>
		<div align="right">
            <input type="submit" value="수정" name="update" >
            <input type="button" value="삭제" name="delete" onclick="confirmDelete()"> 
            <input type="button" value="취소" name="cancel" onclick="location.href='./main.ino'">
            &nbsp;&nbsp;&nbsp;
        </div>
	</form>

	<script>
    function confirmDelete() {
        var result = confirm("작성한 내용을 삭제하시겠습니까?");
        if (result) {
            window.location.href = "./freeBoardDelete.ino?num=${freeBoardDto.num}";
        }
    }
    function validateForm() {
        var name = document.getElementById("name").value.trim();
        var content = document.getElementById("content").value.trim();
        if (name == ""  || name == null) {
            alert("이름은 필수 입력 사항입니다.");
            return false; 
        }
        if (content == ""  || content == null) {
            alert("내용은 필수 입력 사항입니다.");
            return false; 
        }
        return true; 
    }
</script>

</body>
</html>

