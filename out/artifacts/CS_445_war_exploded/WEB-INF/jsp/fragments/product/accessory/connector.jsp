<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Connector</title>
</head>
<body>

<h1>Connector</h1>

<spring:url value="/product/accessory/connector/add" var="connector"/>
<button class="btn btn-primary" onclick="location.href='${connector}'">Add Connector</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="connector" items="${connectors}">

        <c:if test="${connector.deleted == false}">

            <tr>
                <td>${connector.description}</td>
                <td>${connector.id}</td>
                <td>${connector.price}</td>

                <spring:url value="/connector/${connector.id}/cart" var="cartUrl" />
                <spring:url value="/connector/${connector.id}/update" var="updateUrl" />
                <spring:url value="/connector/${connector.id}/delete" var="deleteUrl" />

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
