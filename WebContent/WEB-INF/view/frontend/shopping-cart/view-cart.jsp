<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>

<link href="<c:url value="/resources/css/frontend/view-book.css"/>"
	rel="stylesheet" type="text/css">

<link
	href="<c:url value="/resources/css/frontend/review-pages/review-book.css"/>"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="./../header.jsp"%>
	<div align="center" > <h2 class="font-weight-bold font-italic">
	Your Cart
	</h2> </div>

	<div align="center">
		<c:if test="${ msg != null }">
			<div>${ msg }</div>
		</c:if>
		<table border="1">
			<thead>
				<tr>
					<th>Index</th>
					<th>Book</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Subtotal</th>
					<th> <a href="#" onclick="clearCart()">
						Clear Cart
					</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cart" items="${ sessionScope.cart.items }"
					varStatus="loop">
					<tr>
						<td>${ loop.count }</td>
						<td>${ cart.key.title }</td>
						<td><input type="number" id="quantity-input" value="${ cart.value }" /></td>
						<td>$ ${ cart.key.price }</td>
						<td>$ <fmt:formatNumber type="number" maxFractionDigits="2"
								value="${ cart.key.price * cart.value }" /></td>
						<td><a href="#" onclick="updateCart(${ cart.key.bookId })">Update</a>
							<a href="#" onclick="removeBook(${ cart.key.bookId })">Remove</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2"></td>
					<td>${ cart.totalQuantity }book(s)</td>
					<td>TOTAL:</td>
					<td colspan="2">$ <fmt:formatNumber type="number"
							maxFractionDigits="2" value="${ cart.totalMoney }" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div align="center">
		<h2 class="font-weight-bold">Your Shipping Information</h2>

		<form class="card form-wrapper" onsubmit="return validateInformation()" action="shopping-cart/place-order" method="post">
			<div>
				<label style="min-width: 100px; display: inline-block"
					for="recipientName">Recipient Name: </label> <input
					style="min-width: 200px" id="recipientName" type="text" value="${ sessionScope.customer.fullname }"
					name="recipientName">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="recipientPhone">Recipient Phone: </label> <input
					style="min-width: 200px" id="recipientPhone" type="text" value="${ sessionScope.customer.phone }"
					name="recipientPhone">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="address">Address:
				</label> <input style="min-width: 200px" id="address" type="text" value="${ sessionScope.customer.address }"
					name="address">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="city">City:
				</label> <input style="min-width: 200px" id="city" type="text" name="city" value="${ sessionScope.customer.city }">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="zipCode">Zip
					Code: </label> <input style="min-width: 200px" id="zipCode" type="text" value="${ sessionScope.customer.zipcode }"
					name="zipCode">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="country">Country:
				</label> <input style="min-width: 200px" id="country" type="text" value="${ sessionScope.customer.country }"
					name="country">
			</div>
			
			<div>
				<label style="min-width: 100px; display: inline-block" for="payment-method">
					Payment Method:
				</label>
			
				<select id="payment-method" name="payment-method">
					<option value="Cash on Delivery">Cash on Delivery</option>
					<option value="Visa/Master Card">Visa/Master Card</option>
				</select>
			</div>
			
			<button class="btn btn-success mb-3" type="submit">Place Order</button>	
			<a class="btn btn-info"  href="${pageContext.servletContext.contextPath}/frontend">Continue shopping</a>
		</form>
	</div>


	<%@include file="./../footer.jsp"%>


	<script type="text/javascript"
		src="<c:url value="/resources/js/frontend/shopping-cart/shopping-cart.js" />"></script>
</body>
</html>