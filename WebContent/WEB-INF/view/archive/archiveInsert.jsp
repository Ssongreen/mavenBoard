<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>자료실 저장</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./archiveMain.ino">리스트로</a>
	</div>
	<hr style="width: 600px">
	
	<form action="./archiveInsertPro.ino" method="POST" enctype="multipart/form-data" onsubmit="return validateForm()">
		<div style="width: 150px; float: left;">이름 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" id="name" name="name"/></div>
		
		<div style="width: 150px; float: left;">제목 :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" id="title" name="title" /></div>
	
		<div style="width: 150px; float: left;">내용 :</div>
		<div style="width: 500px; float: left;" align="left"><textarea id="content" name="content" rows="25" cols="55"  ></textarea></div>
		
		<div style="width: 150px; float: left;">파일추가 :</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="file" name="fileLoad"/>
		</div>
			
		<div align="right">
			<input type="submit" value="글쓰기" />
			<input type="reset" value="다시쓰기" />
			<input type="button" value="취소" name="cencel" onclick="confirmCancel()" />
		&nbsp;&nbsp;&nbsp;
		</div>
	
	</form>
	<script>
	function confirmCancel() {
    var result = confirm("작성한 내용을 취소하시겠습니까?");
    if (result) {
        window.location.href = "./archiveMain.ino";
    	}
	}
	
	function validateForm() {
        var name = document.getElementById("name").value;
        var title = document.getElementById("title").value;
        var content = document.getElementById("content").value;
        
        if (name.trim() === "" && null || title.trim() === "" && null || content.trim() === "" && null ) {
            alert("이름, 제목, 내용은 필수 입력 사항입니다.");
            return false; 
        }
        return true; 
    }
	
	function validateForm() {
        var name = document.getElementById("name").value.trim();
        var title = document.getElementById("title").value.trim();
        var content = document.getElementById("content").value.trim();
        
        
        if (name == ""  || name == null) {
            alert("이름은 필수 입력 사항입니다.");
            return false; 
        }
        if (title == ""  || title == null ) {
            alert("제목은 필수 입력 사항입니다.");
            return false; 
        }
        if (content == ""  || content == null ) {
            alert("내용은 필수 입력 사항입니다.");
            return false; 
        }
        return true; 
    }
	</script>
	
	
</body>
</html>