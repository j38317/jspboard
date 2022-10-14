<%@page import="com.moon.app.BDMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF=8");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	BDMemberDto dto = (BDMemberDto)session.getAttribute("dto");

	if(dto==null){
		pageContext.forward("browser.jsp");
	}
%>
	<h1>메인화면</h1>
	<div>
		<span><%= dto.getBm_name() %>님 환영합니다. [등급 : <%= dto.getBm_role() %>]</span>
		<a href="logincontroller.jsp?command=logout">로그아웃</a>
	</div>
	<div>
		<div>
			<a href="logincontroller.jsp?command=userlist">전체 회원 정보 조회</a>
		</div>
		<br>
		<div>
			<a href="logincontroller.jsp?command=userlistenabled">가입 회원 정보 조회</a>
		</div>
	</div>

</body>
</html>