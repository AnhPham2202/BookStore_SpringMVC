<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Profile</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
	<%@include file="./../header.jsp"%>

	<div align="center">
		<button class="btn btn-info mt-3 mb-3" onclick="enableEdit()">Update Customer</button>
	</div>

	<div align="center">
		<form class="card form-wrapper" action="update-customer" method="post" onsubmit="return validateFormInput()">
			<div>
				<label style="min-width: 100px; display: inline-block" for="email">Email:
				</label> <input readonly value="${ customer.email }"
					style="border: none; min-width: 200px" id="email" type="text"
					name="email">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="fullName">Full Name: </label> <input readonly
					value="${ customer.fullname }"
					style="border: none; min-width: 200px" id="fullName" type="text"
					name="fullName">
			</div>

			<div id="passwordWrapper" style="display: none">
				<label style="min-width: 100px; display: inline-block"
					for="password">Password: </label> <input
					style="min-width: 200px" id="password" type="text"
					name="password">
			</div>

			<div id="confirmWrapper" style="display: none">
				<label style="min-width: 100px; display: inline-block"
					for="confirmPassword">Confirm Password: </label> <input
					hidden="true" style="min-width: 200px"
					id="confirmPassword" type="text" name="confirmPassword">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="phone">Phone
					Number: </label> <input readonly value="${ customer.phone }"
					style="border: none; min-width: 200px" id="phone" type="text"
					name="phone">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="address">Address:
				</label> <input readonly value="${ customer.address }"
					style="border: none; min-width: 200px" id="address" type="text"
					name="address">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="city">City:
				</label> <input readonly value="${ customer.city }"
					style="border: none; min-width: 200px" id="city" type="text"
					name="city">
			</div>
			<div>
				<label style="min-width: 100px; display: inline-block" for="country">Country:
				</label> <input readonly value="${ customer.country }"
					style="border: none; min-width: 200px" id="country" type="text"
					name="country">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="zipCode">Zip
					Code: </label> <input readonly value="${ customer.zipcode }"
					style="border: none; min-width: 200px" id="zipCode" type="text"
					name="zipCode">
			</div>
			<div id="button-wrapper" style="display: none">
				<button class="btn btn-success" type="submit">Save</button>
				<button class="btn btn-secondary" type="button" onclick="history.back()">Cancel</button>

			</div>
		</form>
	</div>


	<%@include file="./../footer.jsp"%>
		<script src="<c:url value="/resources/js/frontend/profile/edit-profile.js" />"></script>

</body>
</html>