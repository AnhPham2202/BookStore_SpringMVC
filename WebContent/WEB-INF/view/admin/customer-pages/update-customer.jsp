<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
	<%@include file="./../header.jsp"%>

	<div align="center" class="font-weight-bold font-italic title">Update
		Customer</div>

	<div align="center">
		<form class="card form-wrapper" action="" method="post"
			onsubmit="return validateFormInput()">
			<div>
				<label style="min-width: 100px; display: inline-block" for="email">Email:
				</label> <input value="${ customer.email }" style="min-width: 200px"
					id="email" type="text" name="email">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="fullName">Full Name: </label> <input
					value="${ customer.fullname }" style="min-width: 200px"
					id="fullName" type="text" name="fullName">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="password">Password: </label> <input
					value="${ customer.password }" style="min-width: 200px"
					id="password" type="text" name="password">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="phone">Phone
					Number: </label> <input value="${ customer.phone }"
					style="min-width: 200px" id="phone" type="text" name="phone">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="address">Address:
				</label> <input value="${ customer.address }" style="min-width: 200px"
					id="address" type="text" name="address">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="city">City:
				</label> <input value="${ customer.city }" style="min-width: 200px"
					id="city" type="text" name="city">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="country">Country:
				</label> <input value="${ customer.country }" style="min-width: 200px"
					id="country" type="text" name="country">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="zipCode">Zip
					Code: </label> <input value="${ customer.zipcode }"
					style="min-width: 200px" id="zipCode" type="text" name="zipCode">
			</div>
			
			<div class="mt-3">
				<button class="btn btn-success" type="submit">Update</button>
				<button class="btn btn-secondary" type="button" onclick="history.back()">Cancel</button>
			</div>
		</form>
	</div>

	<%@include file="./../footer.jsp"%>
	<script
		src="<c:url value="/resources/js/customer-pages/update-customer.js" />"></script>

</body>
</html>