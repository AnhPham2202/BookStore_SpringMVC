<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.bookstore.entity.Users"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div align="center">
	<div>
		<img src="<c:url value="/resources/images/BookstoreAdminLogo.png" />" />
	</div>

	<c:set var="requestPath"
		value="${requestScope['javax.servlet.forward.request_uri']}" />
	<c:choose>
		<c:when test='${ sessionScope.user == null }'>
			<div>
				Please Log In /> | <a href="user/log-in">Log In</a> | <a
					href="${pageContext.servletContext.contextPath}/sign-up">Create
					Quick Admin Account</a> | <a
					href="${pageContext.servletContext.contextPath}/frontend">Customer
					Module</a>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				Welcome, ${ sessionScope.user } /> | <a href="log-out"
					class="btn btn-danger">Log Out</a> | <a
					href="${pageContext.servletContext.contextPath}/frontend"
					class="btn btn-secondary">Customer Module</a>
			</div>
		</c:otherwise>
	</c:choose>




	<div id="headermenu">
		<div style="display: inline-block">
			<a class="btn btn-link"
				href="${pageContext.servletContext.contextPath}/admin/list_users">Users</a>
		</div>
		|
		<div style="display: inline-block">
			<a class="btn btn-link"
				href="${pageContext.servletContext.contextPath}/admin/list-categories">Categories</a>
		</div>
		|
		<div style="display: inline-block">
			<a class="btn btn-link"
				href="${pageContext.servletContext.contextPath}/admin/list-books">Books</a>
		</div>
		|
		<div style="display: inline-block">
			<a class="btn btn-link"
				href="${pageContext.servletContext.contextPath}/admin/list-customer">Customers</a>
		</div>
		|
		<div style="display: inline-block">
			<a class="btn btn-link"
				href="${pageContext.servletContext.contextPath}/admin/list-review">Reviews</a>
		</div>
		|
		<div style="display: inline-block">
			<a class="btn btn-link"
				href="${pageContext.servletContext.contextPath}/admin/list-order">Orders</a>
		</div>
	</div>
</div>