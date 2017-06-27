<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Cable</title>
</head>
<body>

<h1>Cable</h1>

<spring:url value="/product/accessory/cable/add" var="cable"/>
<button class="btn btn-primary" onclick="location.href='${cable}'">Add Cable</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>Length</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="cable" items="${cables}">

        <c:if test="${cable.deleted == false}">

            <tr>
                <td>${cable.description}</td>
                <td>${cable.length}</td>
                <td>${cable.id}</td>
                <td>${cable.price}</td>

                <spring:url value="/cable/${cable.id}/cart" var="cartUrl" />
                <spring:url value="/cable/${cable.id}/update" var="updateUrl" />
                <spring:url value="/cable/${cable.id}/delete" var="deleteUrl" />

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
