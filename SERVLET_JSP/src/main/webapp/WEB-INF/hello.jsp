<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Hello Jsp</p>
	<a href="profile.jsp">Information</a>
	
	<% 
	int x = 10;
	int y = 15;
	int z = x + y;
	%>
	<h1>
	<%= z %>
	</h1>
</body>
</html>