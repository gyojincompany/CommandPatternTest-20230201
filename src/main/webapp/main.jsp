<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<%		
		String sessionId = (String) session.getAttribute("memberId");
		if(sessionId == null) {
			sessionId = "GUEST";
		}
	%>
	<%= sessionId %>님 로그인 하셨습니다. 반갑습니다.<br><br>
	메인 페이지 입니다!!<br><br>
	<%
		if(session.getAttribute("ValidSession") != null) {
			//response.sendRedirect("login.jsp");로그인 여부를 체크하여 다른 페이지로 이동
	%>
	<form action="logout.do">
		<input type="submit" value="로그아웃">
		<input type="button" value="정보수정" onclick="javascript:window.location='modifyInfo.do'">
		<input type="button" value="회원탈퇴" onclick="javascript:window.location='delete.do'">
	</form>
	
	<%		
	} else {
	%>    
		로그인 하시면 정보를 더 제공받을 수 있습니다. <br>
		<a href="login.do">로그인 페이지로 이동</a>
	<%
	}
	%>
</body>
</html>