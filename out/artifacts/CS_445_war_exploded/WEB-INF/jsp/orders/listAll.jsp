<%@ page session="false" %>
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
        <c:forEach var="order" items="${orders}">
            <h1>Order #${order.id}</h1>
            <c:if test="${order.status == 'PROCESSING'}">
                <h3>Order is being proceed</h3>
            </c:if>
            <c:if test="${order.status == 'PREPARING_SHIPPING'}">
                <h3>Order is being prepared for shipment</h3>
            </c:if>
            <c:if test="${order.status == 'SHIPPED'}">
                <h3>Order has been shipped</h3>
            </c:if>
            <c:if test="${order.status == 'DELIVERED'}">
                <h3>Order has been delivered</h3>
            </c:if>
            <c:if test="${not empty order.orderedProducts || not empty order.orderedServices}">
                <h5>All Items</h5>
                <c:if test="${not empty order.orderedProducts}">
                <table class="table table-striped">
                    <thead> Products
                    <tr>
                        <th>ID</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Order type</th>
                    </tr>
                    </thead>
                    <c:forEach var="item" items="${order.orderedProducts}">
                        <tr>
                            <td>
                                    ${item.id}
                            </td>
                            <td>${item.price}</td>
                            <td>${item.description}</td>
                            <td>${item.orderType}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
                <c:if test="${not empty order.orderedServices}">
                    <table class="table table-striped">
                        <thead> Services
                        <tr>
                            <th>ID</th>
                            <th>Price</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <c:forEach var="item" items="${order.orderedServices}">
                            <tr>
                                <td>
                                        ${item.id}
                                </td>
                                <td>${item.price}</td>
                                <td>${item.description}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </c:if>
            <c:if test="${order.status == 'PROCESSING'}">
                <h3>Update order state</h3>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/PREPARING_SHIPPING'">Preparing shipping</button>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/SHIPPED'">Shipped</button>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/DELIVERED'">Delivered</button>
            </c:if>
            <c:if test="${order.status == 'PREPARING_SHIPPING'}">
                <h3>Update order state</h3>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/PROCESSING'">Processing</button>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/SHIPPED'">Shipped</button>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/DELIVERED'">Delivered</button>
            </c:if>
            <c:if test="${order.status == 'SHIPPED'}">
                <h3>Update order state</h3>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/PROCESSING'">Processing</button>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/PREPARING_SHIPPING'">Preparing shipping</button>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/DELIVERED'">Delivered</button>
            </c:if>
            <c:if test="${order.status == 'DELIVERED'}">
                <h3>Update order state</h3>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/PROCESSING'">Processing</button>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/PREPARING_SHIPPING'">Preparing shipping</button>
                <button class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/order/update/${order.id}/SHIPPED'">Shipped</button>
            </c:if>
        </c:forEach>
        <c:if test="${empty orders}">
            <h1>No order yet!</h1>
        </c:if>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>