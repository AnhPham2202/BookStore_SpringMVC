<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Management</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
	<%@include file="./../header.jsp"%>
	<div align="center">
		<h2 class="font-weight-bold">Order Management</h2>
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
					<th>Customer Name</th>
					<th>Book Amount</th>
					<th>Recipient Name</th>
					<th>Recipient Phone</th>
					<th>Ship To</th>
					<th>Payment Method</th>
					<th>Order Status</th>
					<th>Order Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${ listOrders }" varStatus="loop">
					<c:set var = "id" scope = "request" value = "${ 'id'.concat(order.orderId) }"/>
					<tr>
						<td>${ loop.count }</td>
						<td>${ order.orderId }</td>
						<td>${ order.customer.fullname }</td>
						<td>${ requestScope[id] }</td>
						<td>${ order.recipientName }</td>
						<td>${ order.recipientPhone }</td>
						<td>${ order.shippingAddress }</td>
						<td>${ order.paymentMethod }</td>
						<td>${ order.status }</td>
						<td><fmt:formatDate value="${ order.orderDate }"
								pattern="MM/dd/yyyy" /></td>
						<td>
							<a href="update-order?id=${ order.orderId }">Edit</a>
							<a href="#" onclick="removeOrder(${ order.orderId })">Remove</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@include file="./../footer.jsp"%>
	
	<script src="<c:url value="/resources/js/order-pages/order-management.js" />"></script>
</body>
</html>