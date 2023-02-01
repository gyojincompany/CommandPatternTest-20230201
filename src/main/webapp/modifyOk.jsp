<%@page import="com.gyojincompany.exe.MemberDto"%>
<%@page import="com.gyojincompany.exe.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 결과</title>
</head>
<body>
		<h2>수정된 회원 정보</h2>
		<hr>
		아이디 : ${memberDto.id }<br>
		이름 : ${memberDto.name }<br>
		비밀번호 : ${memberDto.password }<br>
		이메일 : ${memberDto.email }<br>
		가입일 : ${memberDto.jointime }
	
	<br><br>
	<a href="main.jsp">메인화면으로 가기</a>
</body>
</html>