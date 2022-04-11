<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
<%@include file="./../header.jsp" %>

	<div align="center" class="font-weight-bold font-italic title">Update User</div>

	<div align="center">
		<c:if test="${ msg != null }"> 
			<div>
			 ${ msg }
			</div>
		</c:if>
		<form class="card form-wrapper" method="post"
			onsubmit="return validateFromInput()">
			<div>
				<label style="min-width: 100px; display: inline-block" for="email">Email:
				</label> <input id="email" type="text" name="email" value ="${ user.email }">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="fullName">Full Name: </label> <input id="fullName" type="text"
					name="fullName" value ="${ user.fullName }">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="password">Password: </label> <input id="password"
					type="password" name="password" value ="${ user.password }">
			</div>
			<div class="mt-3">
				<button class="btn btn-success" type="submit">Update</button>
				<button class="btn btn-secondary" type="button" onclick="history.back()">Cancel</button>
			</div>
		</form>
	</div>

<%@include file="./../footer.jsp" %>

	<script src="<c:url value="/resources/js/create-user.js" />"></script>
</body>
</html>