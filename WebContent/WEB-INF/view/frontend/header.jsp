<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.bookstore.entity.Users"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div align="center">
	<div>
		<img src="<c:url value="/resources/images/BookstoreAdminLogo.png" />" />
	</div>


	<div>
		<c:set var="requestPath"
			value="${requestScope['javax.servlet.forward.request_uri']}" />
		<c:if
			test="${ (!fn:contains(requestPath, 'log-in')) and (!fn:contains(requestPath, 'sign-up')) and (!fn:contains(requestPath, 'shopping-cart'))  and (!fn:contains(requestPath, 'profile'))  }">
				<form method="post" onsubmit="onSearch(event)" class="mt-3 mb-3">
					<input id="searchInput" type="text" width="30%">
					<button class="btn btn-success" onclick="onSearch(event)">Search</button>
				</form>
		</c:if>
		<c:choose>
			<c:when test='${ sessionScope.customer == null }'>
				<div style="display: inline-block">
					<a href="${pageContext.servletContext.contextPath}/customer/log-in">Sign
						In</a> <a style="display: inline-block"
						href="${pageContext.servletContext.contextPath}/customer/sign-up">Register</a>
					<br />
				</div>
			</c:when>
			<c:otherwise>
				<div style="display: inline-block">
					Welcome, <b> <i> <a style="text-decoration: underline"
						href="${pageContext.servletContext.contextPath}/frontend/profile">
						${ sessionScope.customer.fullname }</a></i> </b> | <a class="btn btn-danger"
						href="${pageContext.servletContext.contextPath}/customer/log-out">Log
						Out</a> <br />
				</div>
			</c:otherwise>
		</c:choose>
		<a style="display: inline-block" class="btn btn-dark"
			href="${pageContext.servletContext.contextPath}/frontend/shopping-cart">Cart</a>
		|

		<c:if test="${ fn:contains(requestPath, 'frontend') }">
			<a class="btn btn-secondary" href="${pageContext.servletContext.contextPath}/admin">Amin
				Module</a>
		</c:if>
	</div>

</div>

<script src="<c:url value="/resources/js/frontend/search.js" />"></script>