<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Student</title>
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

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form:form action="manageStudent" method="post"
					modelAttribute="studentBo">


					<caption>
						<h1>
							<i class="fa fa-edit fa-fw"></i>Create Student
						</h1>

					</caption>
					<c:if test="${!empty errorMessage}">
						<div class="alert alert-success">

							<h4 align="center">${errorMessage}</h4>

						</div>
					</c:if>
					<form:hidden path="studentId" />

					<fieldset class="form-group">
						<label>Student Name <font color="red"> *</font></label>
						<form:input path="studentName" class="form-control" />
					</fieldset>
					<fieldset class="form-group">
						<label>Student Email<font color="red"> *</font></label>
						<form:input path="emailId" class="form-control" />
					</fieldset>
					<fieldset class="form-group">
						<label>Password <font color="red"> *</font></label>
						<form:input type="password" path="passWord" class="form-control" />
					</fieldset>
					<fieldset class="form-group">
						<label>Mobile Number<font color="red"> *</font></label>
						<form:input path="mobileNumber" class="form-control" />
					</fieldset>
					<fieldset class="form-group">
						<label>Date-Of-Birth <font color="red"> *</font></label>
						<form:input type="date" path="dateOfBirth" class="form-control" />
					</fieldset>

					<fieldset class="form-group">
						<label>Address<font color="red"> *</font></label>
						<form:input path="address" class="form-control" />
					</fieldset>
					<fieldset class="form-group">
						<label>City<font color="red"> *</font></label>
						<form:input path="city" class="form-control" />
					</fieldset>
					<fieldset class="form-group">
						<label>Country<font color="red"> *</font></label>
						<form:input path="country" class="form-control" />
					</fieldset>





					<button type="submit" class="btn btn-success">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>