<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
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
	<h1>Add New Book for ${user.userName}</h1>
	<div class="container">
		<form action="${pageContext.request.contextPath}/book/${user.userId}/saveBook" method="post" name="book" class="mt-4">
			<div class="mb-3">
				<label for="name" class="form-label">BookName:</label>
				<input type="text" id="name" name="bookName" class="form-control" required>
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
	</div>

	<!-- Nạp tệp JavaScript Bootstrap -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.bundle.min.js"></script>
</body>
</html>
