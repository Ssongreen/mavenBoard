<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h1>자료실 수정</h1>
	</div>
	<div style="width: 650px;" align="right">
		<a href="./archiveMain.ino">리스트로</a>
	</div>
	<hr style="width: 600px">

	<form action="" method="POST" enctype="multipart/form-data" onsubmit="return validateForm()">
		<div style="display: none;">
			<!-- 숨김 처리 -->
			<input type="number" name="num" value="${archiveDto.num}" readonly />
		</div>

		<div style="width: 150px; float: left;">이름 :</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" id="name" name="name" value="${archiveDto.name }" />
		</div>

		<div style="width: 150px; float: left;">제목 :</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" name="title" value="${archiveDto.title }" readonly />
		</div>

		<div style="width: 150px; float: left;">작성날자</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" name="regdate" value="${archiveDto.regdate }"
				readonly />
		</div>

		<div style="width: 150px; float: left;">내용 :</div>
		<div style="width: 500px; float: left;" align="left">
			<textarea id="content" name="content" rows="25" cols="50">${archiveDto.content }</textarea>

		</div>
		<div style="width: 150px; float: left;">첨부파일 :</div>
		<div style="width: 500px; float: left;" align="left">
			<c:choose>
				<c:when test="${empty archiveDto.fileLoad}">
					<input type="file" name="fileLoad" />
				</c:when>
				<c:otherwise>
            ${archiveDto.fileLoad}
            <input type="submit" value="삭제" name="deleteFile" onclick="javascript: form.action='./archiveDeleteFile.ino';" />
				</c:otherwise>
			</c:choose>
		</div>

		<div align="right">
			<input type="submit" value="수정" name="update" onclick="javascript: form.action='./archiveUpdate.ino';" />
			<input type="button" value="삭제" name="delete" onclick="confirmDelete()"/>
			<input type="button" value="취소" name="cancel"
				onclick="location.href='./archiveMain.ino'">
			&nbsp;&nbsp;&nbsp;
		</div>
	</form>
	<script type=""></script>
	<script>
    function confirmDelete() {
        var result = confirm("작성한 내용을 삭제하시겠습니까?");
        if (result) {
            window.location.href = "./archiveDelete.ino?num=${archiveDto.num}";
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
	<script>
    function fileDelete(num) {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/archiveDeleteFile.ino", true);
		
        var formData = new FormData();
        
        formData.append("num", num);
        xhr.send(formData);
        return false;
    }
</script>

</body>
</html>

