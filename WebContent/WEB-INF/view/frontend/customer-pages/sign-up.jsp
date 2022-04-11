<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
	<%@include file="./../header.jsp"%>

	<div align="center" class="font-weight-bold font-italic title">Sign Up</div>
	<c:if test="${ msg != null }">
		<div align="center">
			${ msg }
		</div>
	</c:if>
	<div align="center">
		<form class="card form-wrapper" action="" method="post" onsubmit="return validateFormInput()">
			<div>
				<label style="min-width: 100px; display: inline-block" for="email">Email:
				</label> <input style="min-width: 200px"
					id="email" type="text" name="email">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="fullName">Full Name: </label> <input
					style="min-width: 200px"
					id="fullName" type="text" name="fullName">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="password">Password: </label> <input
					style="min-width: 200px"
					id="password" type="text" name="password">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="confirmPassword">Confirm Password: </label> <input
					style="min-width: 200px"
					id="confirmPassword" type="text" name="confirmPassword">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="phone">Phone
					Number: </label> <input 
					style="min-width: 200px" id="phone" type="text" name="phone">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="address">Address:
				</label> <input style="min-width: 200px"
					id="address" type="text" name="address">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="city">City:
				</label> <input style="min-width: 200px"
					id="city" type="text" name="city">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="country">Country:
				</label> <input style="min-width: 200px"
					id="country" type="text" name="country">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="zipCode">Zip
					Code: </label> <input
					style="min-width: 200px" id="zipCode" type="text" name="zipCode">
			</div>

				<button class="btn btn-success mb-3" type="submit">Sign Up</button>
				<button class="btn btn-secondary" type="button" onclick="history.back()">Cancel</button>
		</form>
	</div>

	<%@include file="./../footer.jsp"%>
	<script
		src="<c:url value="/resources/js/frontend/customer-pages/sign-up.js" />"></script>

</body>
</html>