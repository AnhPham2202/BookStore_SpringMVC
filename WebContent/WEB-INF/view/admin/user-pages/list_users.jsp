<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
<%@include file="./../header.jsp" %>
	<div align="center">
		<h2 class="font-weight-bold">User Management</h2>
		<a class="btn btn-info mb-3" href="create_user">Create new user</a>
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
					<th>Email</th>
					<th>Full Name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${ listUsers }" varStatus="loop">
					<tr>
						<td>${ loop.count }</td>
						<td>${ user.userId}</td>
						<td>${ user.email}</td>
						<td>${ user.fullName}</td>
						<td><a href="update_user/${ user.userId }">Edit</a> <a href="#"
							onclick="deleteUser(${ user.userId })">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@include file="./../footer.jsp" %>

	<script type="text/javascript"
		src="<c:url value="/resources/js/delete-user.js" />"></script>
</body>
</html>