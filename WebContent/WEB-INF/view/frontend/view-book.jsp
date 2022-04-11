<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Book</title>
<jsp:directive.include file="boostrap-link-css.jsp" />
<link href="<c:url value="/resources/css/frontend/view-book.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet"
	type="text/css">

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div class="container">
		<div class="row" align="center">
			<div class="img-wrapper col-2">
				<img width="100%" alt="book"
					src="data:image/jpeg;base64, ${ book.base64Img }">
			</div>

			<div class="col-10">
				<h2 class="font-weight-bold">
					<b><i> ${ book.title } </i> </b>
				</h2>
				<div class="text-left">
					<div class="row">
						<div class="col-2 font-weight-bold">Author:</div>
						<div class="col-10">${ book.author }</div>
					</div>
					<div class="row">
						<div class="col-2 font-weight-bold">Category:</div>
						<div class="col-10">${ book.category.name }</div>
					</div>
					<div class="row">
						<div class="col-2 font-weight-bold">ISBN:</div>
						<div class="col-10">${ book.isbn }</div>
					</div>
					<div class="row">
						<div class="col-2 font-weight-bold">Price:</div>
						<div class="col-10">$ ${ book.price }</div>
					</div>
					<div class="row">
						<div class="col-2 font-weight-bold">Description:</div>
						<div class="description col-10">${ book.description }</div>
					</div>
				</div>

				<div class="text-left d-flex align-items-center">
					<button class="btn btn-danger mr-2"
						onclick="addToCart(${ book.bookId })">Add To Cart</button>
					<a class="btn btn-info mr-2" href="review?id=${ book.bookId }">
						Review </a>
				</div>


			</div>

		</div>
		<div>Reivews about this book</div>
		<div class="review-block">

			<c:forEach items="${ reviews }" var="review">
				<div class="card mb-2">
					<div class="card-header">
						<div>${ review.headline }</div>
						<div class="reviewed-by">by ${ review.customer.fullname }</div>
					</div>
					<div class="card-body">${ review.comment }</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:directive.include file="footer.jsp" />
	<jsp:directive.include file="boostrap-script.jsp" />

	<script type="text/javascript"
		src="<c:url value="/resources/js/frontend/shopping-cart/shopping-cart.js" />"></script>
</body>
</html>