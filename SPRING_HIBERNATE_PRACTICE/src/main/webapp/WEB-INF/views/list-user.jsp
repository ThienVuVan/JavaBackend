<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>List User</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
<style>
html {
  margin-left: auto;
  margin-right: auto;
  max-width: 800px;
  padding-left: 15px;
  padding-right: 15px;
}
</style>

</head>
<body>
	<h1>List User</h1>
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>passsword</th>
				<th>own books</th>
				<th>manage</th>
			</tr>
		</thead>
		<c:forEach var="user" items="${users}">
			<c:url var="detailLink" value="detail/${user.userId}"></c:url>
			<c:url var="deleteLink" value="/user/delete">
				<c:param name="userId" value="${user.userId}" />
			</c:url>
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.password}</td>
				<td><a href="${detailLink}">own books</a></td>
				<td><a href="${deleteLink}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<button class="btn btn-primary"
			onclick="location.href='${pageContext.request.contextPath}/user/addUser'">Add User
		</button>
	</p>

	<!-- Nạp tệp JavaScript Bootstrap -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.bundle.min.js"></script>
</body>
</html>
