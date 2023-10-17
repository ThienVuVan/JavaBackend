<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>List Students</title>
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
				<h2>${course.title}</h2>
			</div>
		</div>
		<div>
			<div>
				<!-- put new button: Add student in this course -->
				<input type="button" value="Add student in this course"
					onclick="window.location.href='${pageContext.request.contextPath}/student/${course.id}/showFormForAdd'; return false;"
					class="btn btn-primary m-3 rounded-pill " />
				<!--  add our html table here -->
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Student ID</th>
							<th scope="col">Student Name</th>
							<th scope="col">Phone</th>
							<th scope="col">Gender</th>
							<th scope="col">GPA</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<!-- loop over and print students -->
					<c:forEach var="tempStudent" items="${students}">
						<!-- construct an "update" link with studentid -->
						<c:url var="updateLink"
							value="/student/${course.id}/showFormForUpdate">
							<c:param name="studentId" value="${tempStudent.id}" />
						</c:url>
						<!-- construct an "delete" link with studentid -->
						<c:url var="deleteLink" value="/student/${course.id}/delete">
							<c:param name="studentId" value="${tempStudent.id}" />
						</c:url>
						<tr>
							<td>${tempStudent.id}</td>
							<td>${tempStudent.name}</td>
							<td>${tempStudent.phone}</td>
							<td>${tempStudent.gender}</td>
							<td>${tempStudent.gpa}</td>
							<!-- display the update link -->
							<td><a href="${updateLink}">Update</a> | <!-- display the delete link -->
								<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<!--  add our html table here -->
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Rank</th>
							<th scope="col">Count</th>
						</tr>
					</thead>
					<!-- loop over and print Statistic -->
					<c:forEach var="map" items="${course.getStatistic()}">
						<tr>
							<td><c:out value="${map.key}" /></td>
							<td><c:out value="${map.value}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<p>
			<a href="${pageContext.request.contextPath}/course/list"
				class="btn btn-dark">Back to list course</a>
		</p>
	</div>
</body>

</html>
