<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review Book</title>
<%@include file="/resources/js/resource/boostrap.jsp"%>
<link rel="stylesheet" href='<c:url value="/resources/css/index.css" />'>

<link href="<c:url value="/resources/css/frontend/view-book.css"/>"
	rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<link
	href="<c:url value="/resources/css/frontend/review-pages/review-book.css"/>"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="./../header.jsp"%>

	<div class="container">
		<div class="row" align="center">
			<div class="img-wrapper col-2">
				<img width="100%" alt="book"
					src="data:image/jpeg;base64, ${ book.base64Img }">
			</div>

			<div class="col-10">
				<h2 class="font-weight-bold">
					<b><i>Review ${ book.title } </i> </b>
				</h2>
				<div class="text-left">
					<form style="width: 100%; height: 100%" class="card form-wrapper" action="" method="post" id="review-form">
						<div class="rating-wrapper" >
							<button style="padding: 0px" type="button" class="btn">
								<span id="star1" class="fa fa-star star checked"></span>
							</button>
							<button style="padding: 0px" type="button" class="btn">
								<span id="star2" class="fa fa-star star "></span>
							</button>
							<button style="padding: 0px" type="button" class="btn">
								<span id="star3" class="fa fa-star star "></span>
							</button>
							<button style="padding: 0px" type="button" class="btn">
								<span id="star4" class="fa fa-star star "></span>
							</button>
							<button style="padding: 0px" type="button" class="btn">
								<span id="star5" class="fa fa-star star "></span>
							</button>
							
							<input id="rating" name="rating" hidden="true" value="1" />
						</div>
						<input class="mb-3" style="display: block" placeholder="Headline" id="headline" name="headline" />
						<textarea class="mb-3" style="display: block; height: inherit" id="comment"  name="comment"></textarea>

						<button class="btn btn-success"  type="submit">Post review</button>
					</form>
				</div>

			</div>

		</div>
	</div>

	<%@include file="./../footer.jsp"%>
	<script
		src="<c:url value="/resources/js/frontend/review-pages/review-book.js" />"></script>

</body>
</html>