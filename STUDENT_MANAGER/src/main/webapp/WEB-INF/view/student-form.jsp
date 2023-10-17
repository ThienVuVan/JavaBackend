<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Save student</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<style>
.error {
	color: red
}
</style>
<body>
	<div class="container">
		<div id="wrapper">
			<div class="border border-success rounded m-5 text-center p-2">
				<h2>Add new Student in ${course.title}</h2>
			</div>
		</div>
		<div>
			<h3>Save Customer</h3>
			<div class="error">${message}</div>
			<form:form
				action="${pageContext.request.contextPath}/student/${course.id}/save-student"
				modelAttribute="student" method="POST">
				<div class="form-group">
					<label>Student ID</label>
					<form:input path="id" cssClass="form-control" />
					<form:errors path="id" cssClass="error" />
				</div>
				<div class="form-group">
					<label>Student name</label>
					<form:input path="name" cssClass="form-control" />
					<form:errors path="name" cssClass="error" />
				</div>
				<div class="form-group">
					<label>Phone number</label>
					<form:input path="phone" cssClass="form-control" />
					<form:errors path="phone" cssClass="error" />
				</div>
				<div class="form-group">
					<div class="row">
						<label class="col-form-label col-sm-2 pt-0">Gender</label>
						<div class="col-sm-10">
							<div class="form-check">
								<form:radiobutton path="gender" value="Male" label="Male"
									cssClass="ml-5" />
								</br>
								<form:radiobutton path="gender" value="Female" label="Female"
									cssClass="ml-5" />
								<form:errors path="gender" cssClass="error" />
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label>GPA</label>
					<form:input path="gpa" cssClass="form-control" />
					<form:errors path="gpa" cssClass="error" />
				</div>
				<input type="submit" class="btn btn-success mb-5 mt-2" value="Save"
					class="save" />
			</form:form>
			<div style=""></div>
			<p>
				<a
					href="${pageContext.request.contextPath}/student/${course.id}/list"
					class="btn btn-dark">Back to List</a>
			</p>
		</div>
	</div>
</body>
</html>

</html>