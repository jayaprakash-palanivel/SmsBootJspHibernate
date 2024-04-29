<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>
	<br>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<caption>
					<h1>
						<i class="fa fa-edit fa-fw"></i>View Student
					</h1>

				</caption>

				<fieldset class="form-group">
					<b><label>Student Name </label></b>:${student.studentName}
				</fieldset>
				<fieldset class="form-group">
					<b><label>Student Email</label></b>:${student.emailId}
				</fieldset>
				<fieldset class="form-group">
					<b><label>Password </label></b>:${student.passWord}
				</fieldset>
				<fieldset class="form-group">
					<b><label>Mobile Number</label></b>:${student.mobileNumber}
				</fieldset>
				<fieldset class="form-group">
					<b><label>Date-Of-Birth </label></b>:${student.dateOfBirth}
				</fieldset>

				<fieldset class="form-group">
					<b><label>Address</label></b>:${student.address}
				</fieldset>
				<fieldset class="form-group">
					<b><label>City</label></b>:${student.city}
				</fieldset>
				<fieldset class="form-group">
					<b><label>Country</label></b>:${student.country}
				</fieldset>
				
				<button><a href="listStudent">Back</a></button>

			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>