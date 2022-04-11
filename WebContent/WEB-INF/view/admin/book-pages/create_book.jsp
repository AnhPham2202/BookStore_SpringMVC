<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Book</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<link rel="stylesheet"
	href='<c:url value="/resources/css/admin/book-pages/create-book.css" />'>


<%@include file="/resources/js/resource/boostrap.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#publish-date").datepicker();
	});
</script>
</head>
<body>
	<%@include file="./../header.jsp"%>

	<div align="center" class="font-weight-bold font-italic title">Create
		New Book</div>

	<div align="center">
		<form class="card form-wrapper" action="" method="post"
			onsubmit="return validateFromInput()" enctype="multipart/form-data">
			<div class="d-flex justify-content-between mb-2">
				<label style="min-width: 100px; display: inline-block"
					for="category">Category: </label> <select id="category"
					style="min-width: 200px" name="category">
					<c:forEach var="category" items="${ listCategories }">
						<option value="${ category.categoryId }">${ category.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="d-flex justify-content-between mb-2">
				<label style="min-width: 100px; display: inline-block" for="title">Title:
				</label> <input style="min-width: 200px" id="title" type="text" name="title">
			</div>

			<div class="d-flex justify-content-between mb-2">
				<label style="min-width: 100px; display: inline-block" for="author">Author:
				</label> <input style="min-width: 200px" id="author" type="text"
					name="author">
			</div>

			<div class="d-flex justify-content-between mb-2">
				<label style="min-width: 100px; display: inline-block" for="isbn">ISBN:
				</label> <input style="min-width: 200px" id="isbn" type="text" name="isbn">
			</div>
			<div class="d-flex justify-content-between mb-2">
				<label style="min-width: 100px; display: inline-block"
					for="publish-date">Publish Date: </label> <input
					style="min-width: 200px" id="publish-date" type="text"
					name="publish-date" autocomplete="off">
			</div>
			<div class="d-flex justify-content-between mb-2">
				<label style="min-width: 100px; display: inline-block"
					for="book-img">Book Image: </label> <input style="min-width: 200px"
					id="book-img" type="file" name="book-img" onchange="previewImg()">
			</div>

			<div class="d-flex justify-content-between mb-2">
				<label style="min-width: 100px; display: inline-block"
					for="book-img">Preview Image: </label>
				<div style="min-width: 300px; display: inline-block">
					<img height="100px" alt="img" id="preview">
				</div>
			</div>

			<div class="d-flex justify-content-between mb-2">
				<label style="min-width: 100px; display: inline-block" for="price">Price:
				</label> <input style="min-width: 200px" id="price" type="text" name="price">
			</div>
			<div class="d-flex justify-content-between mb-2">
				<label style="min-width: 100px; display: inline-block"
					for="description">Description: </label>
				<textarea style="min-width: 200px" rows="" cols=""
					name="description"></textarea>
			</div>
			<div class="mt-3">
				<button class="btn btn-success" type="submit">Create</button>
				<button class="btn btn-secondary" type="button" onclick="history.back()">Cancel</button>
			</div>
		</form>
	</div>

	<%@include file="./../footer.jsp"%>
	<script src="<c:url value="/resources/js/book-pages/create-book.js" />"></script>
</body>
</html>