<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Custom Service</title>
</head>
<body>

<h1>Custom Service</h1>


<spring:url value="/service/customService/add" var="customService"/>
<button class="btn btn-primary" onclick="location.href='${customService}'">Add Custom Service</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="customService" items="${customServices}">

        <c:if test="${customService.deleted == false}">

            <tr>
                <td>${customService.description}</td>
                <td>${customService.id}</td>
                <td>${customService.price}</td>

                <spring:url value="/customService/${customService.id}/cart" var="cartUrl" />
                <spring:url value="/customService/${customService.id}/update" var="updateUrl" />
                <spring:url value="/customService/${customService.id}/delete" var="deleteUrl" />

                <td>
                    <button class="btn btn-primary" onclick="location.href='${cartUrl}'">Add Cart</button>
                    <button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>

        </c:if>


    </c:forEach>
</table>

</body>
</html>
