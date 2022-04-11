<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Order</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
	<%@include file="./../header.jsp"%>

	<div align="center" class="font-weight-bold font-italic title">Update Order</div>

	<div align="center">
		<form class="card form-wrapper" action="" method="post" onsubmit="return validateFormInput()">
			<div>
				<label style="min-width: 100px; display: inline-block"
					for="recipientName">Recipient Name: </label> <input
					style="min-width: 200px" id="recipientName" type="text" value="${ order.recipientName }"
					name="recipientName">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block"
					for="recipientPhone">Recipient Phone: </label> <input
					style="min-width: 200px" id="recipientPhone" type="text" value="${ order.recipientPhone }"
					name="recipientPhone">
			</div>

			<div>
				<label style="min-width: 100px; display: inline-block" for="address">Address:
				</label> <input style="min-width: 200px" id="address" type="text" value="${ order.shippingAddress }"
					name="address">
			</div>
			
			<div>
				<label style="min-width: 100px; display: inline-block" for="status">Status:
				</label> <input style="min-width: 200px" id="status" type="text" value="${ order.status }"
					name="status">
			</div>
			
			<div>
				<label style="min-width: 100px; display: inline-block" for="total">Total:
				</label> <input style="min-width: 200px" id="total" type="text" value="<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${ order.total }" />"
					name="total">
			</div>
			
			<div>
				<label style="min-width: 100px; display: inline-block" for="status">Status:
				</label> <input style="min-width: 200px" id="status" type="text" value="${ order.status }"
					name="status">
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
			<div class="mt-3">
				<button class="btn btn-success" type="submit">Save</button>
				<button class="btn btn-secondary" type="button" onclick="history.back()">Cancel</button>
			</div>
		</form>
	</div>
	
	<%@include file="./../footer.jsp"%>
	<script src="<c:url value="/resources/js/order-pages/order-management.js" />"></script>
</body>
</html>