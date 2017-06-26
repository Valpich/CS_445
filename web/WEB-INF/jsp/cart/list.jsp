<%@ page session="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp"/>

<body>

<div class="container" role="main">

    <div class="col-sm-4">
        <jsp:include page="../fragments/leftbar.jsp"/>
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
        <c:if test="${not empty sessionScope.cart.serviceList || not empty sessionScope.cart.productList}">
            <h1>All Items</h1><c:if test="${not empty sessionScope.cart.productList}">
            <table class="table table-striped">
                <thead> Products
                <tr>
                    <th>ID</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Order type</th>
                    <th>Remove</th>
                </tr>
                </thead>
                <c:forEach var="item" items="${sessionScope.cart.productList}">
                    <tr>
                        <td>
                                ${item.id}
                        </td>
                        <td>${item.price}</td>
                        <td>${item.description}</td>
                        <td>${item.orderType}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart" method="post" name="formRemove">
                                <input type="hidden" name="id" value="${item.id}">
                                <button class="btn btn-alert" onclick="document.formRemove.submit()">Remove</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
            <c:if test="${not empty sessionScope.cart.serviceList}">
                <table class="table table-striped">
                    <thead> Services
                    <tr>
                        <th>ID</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Remove</th>
                    </tr>
                    </thead>
                    <c:forEach var="item" items="${sessionScope.cart.serviceList}">
                        <tr>
                            <td>
                                    ${item.id}
                            </td>
                            <td>${item.price}</td>
                            <td>${item.description}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/cart" method="post" name="formRemove">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <button class="btn btn-alert" onclick="document.formRemove.submit()">Remove</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <spring:url value="/cart/checkout" var="checkoutUrl"/>
            <button class="btn btn-warning" onclick="location.href='${checkoutUrl}'">Checkout</button>
        </c:if>
        <c:if test="${!(not empty sessionScope.cart.serviceList || not empty sessionScope.cart.productList)}">
            <h1>Cart is empty</h1>
        </c:if>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>