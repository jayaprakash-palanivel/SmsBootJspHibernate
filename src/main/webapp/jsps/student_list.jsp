<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StudentList</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">
				<i class="fa fa-list fa-fw"></i>List of Students
			</h3>
			<c:if test="${!empty errorMessage}">
				<div class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<h4 align="center">${errorMessage}</h4>

				</div>
			</c:if>
			<c:if test="${!empty successMessage}">
				<div class="alert alert-success">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<h4 align="center">${successMessage}</h4>

				</div>
			</c:if>
			
			<form action="searchEmployee" method="post">
					<input type="text" name="firstName" placeholder="firstName" value="">
					<input type="text" name="email" placeholder="email" value=""> <input
						type="text" name="mobileNumber" placeholder="mobileNumber" value="">
					<input type='submit' value='Search'
						style="background-color: #1c4966; color: white">
				</form>
			
			
			<div class="row ">
				<a href="createStudent"
					style="font-size: 26px; color: #1c4966; margin-left: 95%;"> <i
					class="fa fa-plus-circle" title="Create New Student"></i>
				</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr style=" background-color: #0094b6; color:white " >
						<th>SNo</th>
						<th>Student Name</th>
						<th>Email</th>
						<th>MobileNumber</th>
						<th>D.O.B</th>
						<th>Address</th>
						<th>View</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${studentList}">

						<tr>
							<td><c:out value="${student.serialNo}" /></td>
							<td><c:out value="${student.studentName}" /></td>
							<td><c:out value="${student.emailId}" /></td>
							<td><c:out value="${student.mobileNumber}" /></td>
							<td><c:out value="${student.dateOfBirth}" /></td>
							<td><c:out value="${student.address}" /></td>
							<td>&nbsp;&nbsp;<a
								href="viewStudent?studentId=<c:out value='${student.studentId}' />"><i
									class=" fa fa-eye" style="font-size: 20px; color: #0e2433"></i></a>
							</td>
							<td>&nbsp;&nbsp;<a
								href="editStudent?studentId=<c:out value='${student.studentId}' />"><i
									class=" fa fa-edit" style="font-size: 20px; color: #0e2433"></i></a>
							</td>
							<td>&nbsp;&nbsp;&nbsp;<a
								href="deleteStudent?studentId=<c:out value='${student.studentId}' />"><i
									class="fa fa-trash-o" style="font-size: 20px; color: #0e2433"></i></a></td>


						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>