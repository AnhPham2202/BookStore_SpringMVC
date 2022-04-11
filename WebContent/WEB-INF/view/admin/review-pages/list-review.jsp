<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review Management</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
	<%@include file="./../header.jsp"%>
	<div align="center">
		<h2 class="font-weight-bold">Review Management</h2>
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
					<th>Book</th>
					<th>Rating</th>
					<th>Headline</th>
					<th>Customer</th>
					<th>Review On </th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="review" items="${ listReviews }" varStatus="loop">
					<tr>
						<td>${ loop.count }</td>
						<td>${ review.reviewId}</td>
						<td>${ review.book.title }</td>
						<td>${ review.rating}</td>
						<td>${ review.headline}</td>
						<td>${ review.customer.fullname}</td>
						<td><fmt:formatDate value="${ review.reviewTime }"
								pattern="MM/dd/yyyy" /></td>
						<td>							<a href="#" onclick="removeReview(${ review.reviewId })">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@include file="./../footer.jsp"%>
	
	<script
		src="<c:url value="/resources/js/review-pages/review.js" />"></script>
</body>
</html>