<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%-- <header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.techymeet.com" class="navbar-brand"> Todo
					App</a>
			</div>
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/login"
					class="nav-link">Login</a></li>
				<li><a href="<%=request.getContextPath()%>/register"
					class="nav-link">Signup</a></li>
			</ul>

		</nav>
	</header> --%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form action="loginConfirm" method="post" modelAttribute="loginBo">

					<caption>
						<h1>Login</h1>

					</caption>
					<c:if test="${!empty errorMessage}">
						<div class="alert alert-success">

							<h4 align="center">${errorMessage}</h4>

						</div>
					</c:if>

					<fieldset class="form-group">
						<label>UserName</label> <input type="text" class="form-control"
							name="userName" placeholder="Email-Id" required="required"
							minlength="5">
					</fieldset>

					<fieldset class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password" placeholder="Password"
							minlength="5">
					</fieldset>

					<button type="submit" class="btn btn-success">Login</button>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>