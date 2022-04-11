<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet"
	href='<c:url value="/resources/css/index.css" />'>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#publish-date" ).datepicker();
  } );
  </script>
</head>
<body>
<%@include file="./../header.jsp" %>

	<div align="center" class="font-weight-bold font-italic title">Update New Book</div>

	<div align="center">
		<form class="card form-wrapper" action="" method="post"  onsubmit="return validateFromInput()" enctype="multipart/form-data">
			<div>
				<label  style="min-width: 100px; display: inline-block" for="category">Category: </label>
				<select id="category" style="min-width: 300px" name="category" >
					<c:forEach var="category" items="${ listCategories }">
						<c:choose>
							<c:when test="${ category.categoryId == book.category.categoryId }">
								<option selected value="${ category.categoryId }">${ category.name }</option>
							</c:when>
							<c:otherwise>
								<option value="${ category.categoryId }">${ category.name }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>	
			</div>
			<div>
				<label  style="min-width: 100px; display: inline-block" for="title">Title: </label> 
				<input style="min-width: 300px" id="title" type="text" value="${ book.title }"
					name="title">
			</div>

			<div>
				<label  style="min-width: 100px; display: inline-block" for="author">Author: </label> <input style="min-width: 300px" id="author"
					type="text" name="author" value="${ book.author }">
			</div>

			<div>
				<label  style="min-width: 100px; display: inline-block" for="isbn">ISBN: </label> <input style="min-width: 300px" id="isbn"
					type="text" name="isbn" value="${ book.isbn }">
			</div>
			<div>
				<label  style="min-width: 100px; display: inline-block" for="publish-date">Publish Date: </label> 
				<input style="min-width: 300px" id="publish-date"
					type="text" name="publish-date" 
					value="<fmt:formatDate value='${book.publishDate}' pattern='MM/dd/yyyy' />">
			</div>
			<div>
				<label  style="min-width: 100px; display: inline-block" for="book-img">Book Image: </label> 
				<input onchange="previewImg()" style="min-width: 300px" id="book-img"
					type="file" name="book-img" value="">
			</div>
			
			<div>
				<label  style="min-width: 100px; display: inline-block" for="book-img">Preview Image: </label> 
				<div style="min-width: 300px; display: inline-block">
					<img id="preview" height="100px" alt="img" src="data:image/jpeg;base64, ${ book.base64Img }">
				</div>
			</div>
			<div>
				<label  style="min-width: 100px; display: inline-block" for="price">Price: </label> <input style="min-width: 300px" id="price"
					type="text" name="price" value="${ book.price }">
			</div>
			<div>
				<label  style="min-width: 100px; display: inline-block" for="description">Description: </label> 
				<textarea style="min-width: 300px" rows="" cols="" name="description" >${ book.description }</textarea>
			</div>
			<div class="mt-3">
				<button class="btn btn-success" type="submit">Update</button>
				<button class="btn btn-secondary" type="button" onclick="history.back()">Cancel</button>
			</div>
		</form>
	</div>

<%@include file="./../footer.jsp" %>
	<script src="<c:url value="/resources/js/book-pages/update-book.js" />"></script>
</body>
</html>