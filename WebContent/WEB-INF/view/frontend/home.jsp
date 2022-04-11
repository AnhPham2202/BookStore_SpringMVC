<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evergreen Bookstore Administration</title>
<jsp:directive.include file="boostrap-link-css.jsp" />
<link href="<c:url value="/resources/css/frontend/home.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet"
	type="text/css">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<c:forEach var="category" items="${ listCategories }">
			<b> <a class="btn btn-light mt-3"
				href="${pageContext.servletContext.contextPath}/frontend/view-category?id=${ category.categoryId }">${ category.name }</a>
			</b>
		</c:forEach>

	</div>
	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">New Books:</h2>
		<div class="row container">
			<c:forEach var="book" items="${ books }">

				<div class="col-3">
					<div class="card">
						<div class="img-wrapper">
							<img class="card-img-top"
								src="data:image/jpeg;base64, ${ book.base64Img }"
								alt="Card image">
						</div>
						<div class="card-body">
							<h4 class="card-title">${ book.title }</h4>
							<div class="card-text">${ book.description }</div>

							<div>
								<c:forEach var="star" items="${ book.ratingStars }">
									<c:if test="${ star == 'yes' }">
										<i class="fa-solid fa-star" style="color: orange"></i>
									</c:if>

									<c:if test="${ star == 'no' }">
										<i class="fa-solid fa-star"></i>
									</c:if>

									<c:if test="${ star == 'half' }">
										<i class="fa-solid fa-star-half-stroke"></i>
									</c:if>
								</c:forEach>
							</div>
							<a
								href="${pageContext.servletContext.contextPath}/frontend/view-detail?id=${ book.bookId }"
								class="btn btn-success">More Detail</a>
						</div>
					</div>
				</div>

			</c:forEach>
		</div>

	</div>
	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">Best-Selling Books:</h2>
		
		<div class="row container">
			<c:forEach var="book" items="${ bestSellerBooks }">

				<div class="col-3">
					<div class="card">
						<div class="img-wrapper">
							<img class="card-img-top"
								src="data:image/jpeg;base64, ${ book.base64Img }"
								alt="Card image">
						</div>
						<div class="card-body">
							<h4 class="card-title">${ book.title }</h4>
							<div class="card-text">${ book.description }</div>

							<div>
								<c:forEach var="star" items="${ book.ratingStars }">
									<c:if test="${ star == 'yes' }">
										<i class="fa-solid fa-star" style="color: orange"></i>
									</c:if>

									<c:if test="${ star == 'no' }">
										<i class="fa-solid fa-star"></i>
									</c:if>

									<c:if test="${ star == 'half' }">
										<i class="fa-solid fa-star-half-stroke"></i>
									</c:if>
								</c:forEach>
							</div>
							<a
								href="${pageContext.servletContext.contextPath}/frontend/view-detail?id=${ book.bookId }"
								class="btn btn-success">More Detail</a>
						</div>
					</div>
				</div>

			</c:forEach>
		</div>

	</div>

	<div align="center">
		<hr width="60%" />
		<h2 class="pageheading">Most-favored books:</h2>
		
		<div class="row container">
			<c:forEach var="book" items="${ bestFavored }">

				<div class="col-3">
					<div class="card">
						<div class="img-wrapper">
							<img class="card-img-top"
								src="data:image/jpeg;base64, ${ book.base64Img }"
								alt="Card image">
						</div>
						<div class="card-body">
							<h4 class="card-title">${ book.title }</h4>
							<div class="card-text">${ book.description }</div>

							<div>
								<c:forEach var="star" items="${ book.ratingStars }">
									<c:if test="${ star == 'yes' }">
										<i class="fa-solid fa-star" style="color: orange"></i>
									</c:if>

									<c:if test="${ star == 'no' }">
										<i class="fa-solid fa-star"></i>
									</c:if>

									<c:if test="${ star == 'half' }">
										<i class="fa-solid fa-star-half-stroke"></i>
									</c:if>
								</c:forEach>
							</div>
							<a
								href="${pageContext.servletContext.contextPath}/frontend/view-detail?id=${ book.bookId }"
								class="btn btn-success">More Detail</a>
						</div>
					</div>
				</div>

			</c:forEach>
		</div>

	</div>

	<jsp:directive.include file="footer.jsp" />
	<jsp:directive.include file="boostrap-script.jsp" />

</body>
</html>