<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Power Supply</title>
</head>
<body>

<h1>Power Supply</h1>

<spring:url value="/product/accessory/powerSupply/add" var="powerSupply"/>
<button class="btn btn-primary" onclick="location.href='${powerSupply}'">Add Power Supply</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>Maximum Output</th>
        <th>Voltage</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="powerSupply" items="${powerSupplies}">

        <c:if test="${powerSupply.deleted == false}">

            <tr>
                <td>${powerSupply.description}</td>
                <td>${powerSupply.maximum_output}</td>
                <td>${powerSupply.voltage}</td>
                <td>${powerSupply.id}</td>
                <td>${powerSupply.price}</td>

                <spring:url value="/powerSupply/${powerSupply.id}/cart" var="cartUrl" />
                <spring:url value="/powerSupply/${powerSupply.id}/update" var="updateUrl" />
                <spring:url value="/powerSupply/${powerSupply.id}/delete" var="deleteUrl" />

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
