<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank You!!!</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>
</head>
<body>
	<div align="center">
		<h1>
			<b> Thank you for your orders !!! </b>
		</h1>
		<div>
			<a href="${pageContext.servletContext.contextPath}/frontend">Come
				back to home page</a>
		</div>
	</div>
</body>
</html>