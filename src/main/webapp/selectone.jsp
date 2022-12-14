<%@page import="com.moon.app.MVCBoardDto"%>
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
<% MVCBoardDto dto = (MVCBoardDto)request.getAttribute("dto"); %>
	<h1>게시글 보기</h1>
	<table border="1">
		<tr>
			<th>NAME</th>
			<td><%=dto.getBd_name() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><%=dto.getBd_title() %></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getBd_content() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='controller.jsp?command=bd_update&bd_no=<%=dto.getBd_no()%>'">
				<input type="button" value="삭제" onclick="location.href='controller.jsp?command=bd_delete&bd_no=<%=dto.getBd_no()%>'">
				<input type="button" value="목록" onclick="location.href='controller.jsp?command=main'">
			</td>
		</tr>
	</table>

</body>
</html>