<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
			integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
			crossorigin="anonymous">
		<title>DEBATE CONTEST REGISTRATION - COLLEGE FEST</title>
	</head>
	<body>
		<div class="container">
			<h3 style="margin-top:5px; line-height:2.5; background-color:green; padding-left:20px">DEBATE CONTEST REGISTRATION - COLLEGE FEST</h3>
			<hr>
			<!-- Add a button -->
			<a href="add"
				class="btn btn-info col-2 btn-sm mb-3" > Add Student </a>
			<table class="table table-bordered table-striped">
				<thead style="background-color:green; color:white; border-color:green">
					<tr>
						<th>Student Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Course</th>
						<th>Country</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Students}" var="tempStud">
						<tr>
							<td><c:out value="${tempStud.studentId}" /></td>
							<td><c:out value="${tempStud.firstName}" /></td>
							<td><c:out value="${tempStud.lastName}" /></td>
							<td><c:out value="${tempStud.course}" /></td>
							<td><c:out value="${tempStud.country}" /></td>
							<td>
								<!-- Add "update" button/link --> <a
								href="update?studentId=${tempStud.studentId}"
								class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
								<a
								href="delete?studentId=${tempStud.studentId}"
								class="btn btn-danger btn-sm"
								onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
									Delete </a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>