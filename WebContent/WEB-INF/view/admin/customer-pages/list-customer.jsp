<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Management</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
	<%@include file="./../header.jsp"%>
	<div align="center">
		<h2 class="font-weight-bold">Customer Management</h2>
		<a class="btn btn-info mb-3" href="create-customer">Create new customer</a>
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
					<th>City</th>
					<th>Country</th>
					<th>Registered Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${ listCustomer }" varStatus="loop">
					<tr>
						<td>${ loop.count }</td>
						<td>${ customer.customerId}</td>
						<td>${ customer.email}</td>
						<td>${ customer.fullname}</td>
						<td>${ customer.city}</td>
						<td>${ customer.country}</td>
						<td><fmt:formatDate value="${ customer.registerDate}"
								pattern="MM/dd/yyyy" /></td>
						<td><a href="update-customer?id=${ customer.customerId }">Edit</a>
							<a href="#" onclick="deleteCustomer(${ customer.customerId })">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@include file="./../footer.jsp"%>
	<script type="text/javascript"
		src="<c:url value="/resources/js/customer-pages/delete-customer.js" />"></script>
</body>
</html>