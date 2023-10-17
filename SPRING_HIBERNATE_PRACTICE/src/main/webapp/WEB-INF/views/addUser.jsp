<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add User</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
<style>
html {
  margin-left: auto;
  margin-right: auto;
  max-width: 800px;
  padding-left: 15px;
  padding-right: 15px;
}
.error{
	color: red;
}
</style>

</head>
<body>
	<h1>Add User</h1>
	<div class="container">
		<c:form action="${pageContext.request.contextPath}/user/saveUser" method="POST" modelAttribute="user" class="mt-4">
			<div class="mb-3">
				<label for="name" class="form-label">UserName:</label>
				<c:input id="name" path="userName" class="form-control"></c:input>
				<c:errors path="userName" class="error"></c:errors>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password:</label>
				<c:password id="password" path="password" class="form-control"></c:password>
				<c:errors path="password" class="error"></c:errors>
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</c:form>
	</div>

	<!-- Nạp tệp JavaScript Bootstrap -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.bundle.min.js"></script>
</body>
</html>
