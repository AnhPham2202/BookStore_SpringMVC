<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Management</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
<%@include file="./../header.jsp" %>
	<div align="center">
		<h2 class="font-weight-bold">Category Management</h2>
		<a  class="btn btn-info mb-3" href="create-category">Create new category</a>
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
					<th>Category</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="category" items="${ listCategories }" varStatus="loop">
					<tr>
						<td>${ loop.count }</td>
						<td>${ category.categoryId}</td>
						<td>${ category.name}</td>
						<td><a href="update-category/${ category.categoryId }">Edit</a> <a href="#"
							onclick="deleteCategory(${ category.categoryId })">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@include file="./../footer.jsp" %>

	<script type="text/javascript"
		src="<c:url value="/resources/js/category-pages/delete-category.js" />"></script>
</body>
</html>