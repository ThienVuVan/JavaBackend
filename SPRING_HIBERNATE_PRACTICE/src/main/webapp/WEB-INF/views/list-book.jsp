<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail</title>
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
	<h1>${user.userId}- ${user.userName}</h1>
	<p>
		<button class="btn btn-primary"
			onclick="location.href='${pageContext.request.contextPath}/book/${user.userId}/addBook'">Add Book
		</button>
	</p>
	<table class="table">
		<thead>
			<tr>
				<th>bookId</th>
				<th>bookName</th>
				<th>delete</th>
			</tr>
		</thead>
		<c:forEach var="book" items="${books}">
			<c:url var="deleteLink" value="/book/delete">
				<c:param name="bookId" value="${book.bookId}" />
				<c:param name="userId" value="${user.userId}" />
			</c:url>
			<tr>
				<td>${book.bookId}</td>
				<td>${book.bookName}</td>
				<td><a href="${deleteLink}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>----------------------------------------</p>
	<p>
		<button class="btn btn-primary"
			onclick="location.href='${pageContext.request.contextPath}/user/list-user'">Back to list user
		</button>
	</p>

	<!-- Nạp tệp JavaScript Bootstrap -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.bundle.min.js"></script>
</body>
</html>
