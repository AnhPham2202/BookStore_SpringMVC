<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Page</title>
<jsp:directive.include file="boostrap-link-css.jsp" />
<link
	href="<c:url value="/resources/css/frontend/search-page.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet"
	type="text/css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<c:if test="${ searchResult != null }">
		<div class="container text-center result-text">
			${ searchResult }
		</div>
	</c:if>
	<div class="container">
		 <c:forEach var="book" items="${ listBook }">
		 	<div class="row wrapper">
		 		<div class="col-1">
		 			<img width="100%" alt="book" src="data:image/jpeg;base64, ${ book.base64Img }">
		 		</div>
		 		
		 		<div class="col-8">
		 			<a class="title" href="frontend/view-detail?id=${ book.bookId }">${ book.title }</a>
		 			<p class="author-text">by ${ book.author } </p>
		 			<div class="description-text">${ book.description}</div>
		 		</div>
		 		<div class="col-3 text-center">
					<p class="price-text">$${ book.price }</p>
					<button class="btn btn-success">Add to cart</button>
		 		</div>
		 	</div>
		 </c:forEach>
	</div>
 
 	<jsp:directive.include file="footer.jsp" />
 	<jsp:directive.include file="boostrap-script.jsp" />
 	
</body>
</html>