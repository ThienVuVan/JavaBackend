<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Save Course</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<div class="container">
		<div>
			<div class="border border-success rounded m-5 text-center p-2">
				<h2>Course Management</h2>
			</div>
		</div>
		<div>
			<h3>Save Course</h3>
			<form:form
				action="${pageContext.request.contextPath}/course/save-course"
				modelAttribute="course" method="POST">

				<div class="form-group">
					<label>Course ID</label>
					<form:input path="id" cssClass="form-control" />
					<form:errors path="id" cssClass="error" />
				</div>
				<div class="form-group">
					<label>Title</label>
					<form:input path="title" cssClass="form-control" />
					<form:errors path="title" cssClass="error" />
				</div>
				<div class="form-group">
					<label>Credit</label>
					<form:input path="credit" cssClass="form-control" />
					<form:errors path="credit" cssClass="error" />
				</div>

				<label>Enrollment</label>
				<form:input path="enrollment" cssClass="form-control" />
				<form:errors path="enrollment" cssClass="error" />
				<input type="submit" class="btn btn-success mb-5 mt-2" value="Save"
					class="save" />
			</form:form>
			<div style=""></div>
			<p>
				<a href="${pageContext.request.contextPath}/course/list"
					class="btn btn-dark">Back to List</a>
			</p>
		</div>
	</div>
</body>

</html>
