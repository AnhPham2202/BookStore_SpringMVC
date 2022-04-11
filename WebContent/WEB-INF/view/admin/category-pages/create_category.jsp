<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Category</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
	<%@include file="./../header.jsp"%>

	<div align="center" class="font-weight-bold font-italic title">Create
		New Category</div>


	<div align="center">

		<c:if test="${ msg != null }">
			<div>${ msg }</div>
		</c:if>
		<form class="card form-wrapper" action="create-category" method="post"
			onsubmit="return validateFormInput()">
			<div>
				<label style="min-width: 100px; display: inline-block" for="name">Category
					Name: </label> <input id="name" type="text" name="name">
			</div>

			<div class="mt-3">
				<button class="btn btn-success" type="submit">Create</button>
				<button class="btn btn-secondary" type="button" onclick="history.back()">Cancel</button>
			</div>
		</form>
	</div>

	<%@include file="./../footer.jsp"%>
	<script
		src="<c:url value="/resources/js/category-pages/create-category.js" />"></script>
</body>
</html>