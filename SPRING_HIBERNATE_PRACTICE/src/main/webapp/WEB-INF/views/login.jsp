<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
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
	<div class="container">
		<h2 class="mt-5">Đăng nhập</h2>
		<form action="login" method="post" name="loginForm" class="mt-4">
			<div class="mb-3">
				<label for="username" class="form-label">Tên đăng nhập:</label>
				<input type="text" class="form-control" name="userName">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Mật khẩu:</label>
				<input type="password" class="form-control" name="password">
			</div>
			<div class="mb-3">
				<button type="submit" value="login" class="btn btn-primary">Đăng nhập</button>
			</div>
		</form>
		<span>${error}</span>
	</div>

	<!-- Nạp tệp JavaScript Bootstrap -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.bundle.min.js"></script>
</body>
</html>
