<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<title>List Course</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<div>
			<div class="border border-success rounded m-5 text-center p-2">
				<h2>Course Management</h2>
			</div>
		</div>
		<div>
			<div>
				<!-- put new button: Add Course-->
				<input type="button" value="Add Course"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="btn btn-primary m-3 rounded-pill " />
				<!--  add our html table here -->
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Course Id</th>
							<th scope="col">Title</th>
							<th scope="col">Credit</th>
							<th scope="col">Enrollment</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<!-- loop over and print our courses -->
					<c:forEach var="tempCourse" items="${courses}">

						<!-- construct an "update" link with course id -->
						<c:url var="updateLink" value="/course/showFormForUpdate">
							<c:param name="courseId" value="${tempCourse.id}" />
						</c:url>
						<!-- construct an "detail" link with course id -->
						<c:url var="detailLink" value="/course/detail/${tempCourse.id}">
						</c:url>
						<!-- construct an "delete" link with course id -->
						<c:url var="deleteLink" value="/course/delete">
							<c:param name="courseId" value="${tempCourse.id}" />
						</c:url>

						<tr>
							<td>${tempCourse.id}</td>
							<td>${tempCourse.title}</td>
							<td>${tempCourse.credit}</td>
							<td>${tempCourse.enrollment}</td>
							<td>
								<!-- display the update link --> <a href="${updateLink}">Update</a>
								|<!-- display the update link --> <a href="${detailLink}">Course's students</a>
								| <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this course?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>

</html>
