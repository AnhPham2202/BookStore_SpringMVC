<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Management</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet"
	href='<c:url value="/resources/css/index.css" />'>
<link rel="stylesheet"
	href='<c:url value="/resources/css/admin/book-pages/list-book.css" />'>

</head>
<body>
<%@include file="./../header.jsp" %>
	<div align="center">
		<h2 class="font-weight-bold">Book Management</h2>
		<a class="btn btn-info mb-3" href="create-book">Create new book</a>
	</div>
	<div align="center">
		<c:if test="${ msg != null }">
			<div>${ msg }</div>
		</c:if>
		<table border="1">
			<thead>
				<tr>
					<th>Index</th>
					<th>Id</th>
					<th>Image</th>
					<th>Title</th>
					<th>Author</th>
					<th>Category</th>
					<th>Price</th>
					<th>Last Updated</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${ listBooks }" varStatus="loop">
					<tr>
						<td>${ loop.count }</td>
						<td>${ book.bookId }</td>
						<td>
							<img height="100px" alt="img" src="data:image/jpeg;base64, ${ book.base64Img }">
						</td>
						<td>${ book.title }</td>
						<td>${ book.author }</td>
						<td>${ book.category.name }</td>
						<td>${ book.bookId }</td>
						<td>${ book.bookId }</td>
						<td><a href="update-book/${ book.bookId }">Edit</a> <a href="#"
							onclick="deleteBook(${ book.bookId })">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@include file="./../footer.jsp" %>

	<script type="text/javascript"
		src="<c:url value="/resources/js/book-pages/delete-book.js" />"></script>
</body>
</html>