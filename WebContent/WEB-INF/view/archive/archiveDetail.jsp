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
		<h1>�ڷ�� ��������</h1>
	</div>
	<div style="width: 650px;" align="right">
		<a href="./archiveMain.ino">����Ʈ��</a>
	</div>
	<hr style="width: 600px">

	<form action="./archiveModify.ino" >
		<div style="width: 150px; float: left;">�̸� :</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" name="name" value="${archiveDto.name }" readonly />
		</div>

		<div style="width: 150px; float: left;">���� :</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" name="title" value="${archiveDto.title }"
				readonly />
		</div>

		<div style="width: 150px; float: left;">�ۼ�����</div>
		<div style="width: 500px; float: left;" align="left">
			<input type="text" name="regdate" value="${archiveDto.regdate }"
				readonly />
		</div>

		<div style="width: 150px; float: left;">���� :</div>
		<div style="width: 500px; float: left;" align="left">
			<textarea name="content" rows="25" cols="50" readonly>${archiveDto.content }</textarea>
		</div>
		
		<div style="width: 150px; float: left;">���� �ٿ�ε�:</div>
		<div style="width: 500px; float: left;" align="left">
			<a download href="/upload/${archiveDto.fileLoad}" >${archiveDto.fileLoad}</a>
		</div>

		
		<div align="right">
    	<input type="hidden" name="num" value="${archiveDto.num}">
    	<button type="submit">����</button>
		<input type="button" value="���" name="cancel"
			onclick="location.href='./archiveMain.ino'">
		</div>

	</form>

</body>
</html>