<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Infrared Lightning</title>
</head>
<body>

<h1>Infrared Lightning</h1>

<spring:url value="/product/accessory/infraredLightning/add" var="infraredLightning"/>
<button class="btn btn-primary" onclick="location.href='${infraredLightning}'">Add Infrared Lightning</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="infraredLightning" items="${infraredLightnings}">

        <c:if test="${infraredLightning.deleted == false}">

            <tr>
                <td>${infraredLightning.description}</td>
                <td>${infraredLightning.id}</td>
                <td>${infraredLightning.price}</td>

                <spring:url value="/infraredLightning/${infraredLightning.id}/cart" var="cartUrl" />
                <spring:url value="/infraredLightning/${infraredLightning.id}/update" var="updateUrl" />
                <spring:url value="/infraredLightning/${infraredLightning.id}/delete" var="deleteUrl" />

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
