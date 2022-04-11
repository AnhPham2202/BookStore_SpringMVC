<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message Page</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<h1>
	${ msg }
	</h1>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>