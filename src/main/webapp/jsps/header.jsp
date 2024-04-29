<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #1c4966">


			<div>
				<a class="navbar-brand" href="home"
					style="color: #fff; font-size: 18px; font-weight: bold; margin-left: 25px;"><i
					class="fa fa-book" aria-hidden="true"></i> SMSApp<b class=""></b></a>
			</div>
			<%-- <c:if test="${!empty userId}"> --%>
			<div>
				<a href="listStudent" class="navbar-brand"> Students</a>
			</div>
			<div>
				<a href="listProfessor" class="navbar-brand"> Professors</a>
			</div>
			<div>
				<a href="listDepartment" class="navbar-brand"> Department</a>
			</div>

			<div>
				<a href="listRole" class="navbar-brand"> Roles</a>
			</div>
			
			

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a class="navbar-brand"
					href="<%=request.getContextPath()%>/login" class="nav-link">Login</a></li>
				<li><a class="navbar-brand"
					href="<%=request.getContextPath()%>/register" class="nav-link">Signup</a></li>
			</ul>

		</nav>
	</header>

</body>
</html>