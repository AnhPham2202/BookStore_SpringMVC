<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>404 Not Found</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>

<link rel="stylesheet"
	href='<c:url value="/resources/css/error/404.css" />'>
</head>
<body>
<div class="container wrapper d-flex flex-column justify-content-center">
	<img alt="Not Found" src='<c:url value="/resources/images/404-not-found.jpg" />'>
	
	<div class="d-flex justify-content-center">
		<a href="${pageContext.servletContext.contextPath}/frontend" class="btn btn-success mr-5">Go to Customer Home Page</a>
		<a href="${pageContext.servletContext.contextPath}/admin" class="btn btn-info">Go to Admin Home Page</a>
	</div>
</div>
</body>
</html>