<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In Page</title>
</head>
<body>
	<%@include file="header.jsp"%>

	<div align="center">
		<c:if test="${ msg != null }">
			<div>${ msg }</div>
		</c:if>
	</div>
	<div align="center">
		<form class="card form-wrapper" action="" method="post" onsubmit="return validateFormInput()">
			<div>
				<label style="min-width: 100px; display: inline-block" for="email">Email:
				</label> <input id="email" type="text" name="email">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="password">Password: </label> <input id="password" type="text"
					name="password">
			</div>
			<button type="submit">Log In</button>
		</form>
	</div>
	<%@include file="footer.jsp"%>

	<script src="<c:url value="/resources/js/frontend/sign-in.js" />"></script>


</body>
</html>