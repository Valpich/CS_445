<%@ page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>

<div class="container" role="main">

	<div class="col-sm-4">
		<jsp:include page="../fragments/leftbar.jsp" />
	</div>
	<div class="col-sm-8">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All Items</h1>

		<table class="table table-striped">
			<thead> Products
				<tr>
					<th>ID</th>
					<th>Price</th>
					<th>Description</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${sessionScope.cart.productList}">
				<tr>
					<td>
						${item.id}
					</td>
					<td>${item.price}</td>
					<td>${item.description}</td>
				</tr>
			</c:forEach>
		</table>

		<table class="table table-striped">
			<thead> Services
			<tr>
				<th>ID</th>
				<th>Price</th>
				<th>Description</th>
			</tr>
			</thead>
			<c:forEach var="item" items="${sessionScope.cart.serviceList}">
				<tr>
					<td>
							${item.id}
					</td>
					<td>${item.price}</td>
					<td>${item.description}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
	<jsp:include page="../fragments/footer.jsp" />

</body>
</html>