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
		<h1>�ڷ�� ����</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./archiveMain.ino">����Ʈ��</a>
	</div>
	<hr style="width: 600px">
	
	<form action="./archiveInsertPro.ino" method="POST" enctype="multipart/form-data" onsubmit="return validateForm()">
		<div style="width: 150px; float: left;">�̸� :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" id="name" name="name"/></div>
		
		<div style="width: 150px; float: left;">���� :</div>
		<div style="width: 500px; float: left;" align="left"><input type="text" id="title" name="title" /></div>
	
		<div style="width: 150px; float: left;">���� :</div>
		<div style="width: 500px; float: left;" align="left"><textarea id="content" name="content" rows="25" cols="55"  ></textarea></div>
		
		<div style="width: 150px; float: left;">�����߰� :</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="file" name="fileLoad"/>
		</div>
			
		<div align="right">
			<input type="submit" value="�۾���" />
			<input type="reset" value="�ٽþ���" />
			<input type="button" value="���" name="cencel" onclick="confirmCancel()" />
		&nbsp;&nbsp;&nbsp;
		</div>
	
	</form>
	<script>
	function confirmCancel() {
    var result = confirm("�ۼ��� ������ ����Ͻðڽ��ϱ�?");
    if (result) {
        window.location.href = "./archiveMain.ino";
    	}
	}
	
	function validateForm() {
        var name = document.getElementById("name").value;
        var title = document.getElementById("title").value;
        var content = document.getElementById("content").value;
        
        if (name.trim() === "" && null || title.trim() === "" && null || content.trim() === "" && null ) {
            alert("�̸�, ����, ������ �ʼ� �Է� �����Դϴ�.");
            return false; 
        }
        return true; 
    }
	
	function validateForm() {
        var name = document.getElementById("name").value.trim();
        var title = document.getElementById("title").value.trim();
        var content = document.getElementById("content").value.trim();
        
        
        if (name == ""  || name == null) {
            alert("�̸��� �ʼ� �Է� �����Դϴ�.");
            return false; 
        }
        if (title == ""  || title == null ) {
            alert("������ �ʼ� �Է� �����Դϴ�.");
            return false; 
        }
        if (content == ""  || content == null ) {
            alert("������ �ʼ� �Է� �����Դϴ�.");
            return false; 
        }
        return true; 
    }
	</script>
	
	
</body>
</html>