<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Digital Surveillance Camera</title>
</head>
<body>

<h1>Digital Surveillance Camera</h1>

<spring:url value="/product/securityCamera/digitalSurveillanceCamera/add" var="digital"/>
<button class="btn btn-primary" onclick="location.href='${digital}'">Add Digital Surveillance Camera</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>Resolution</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="digitalSurveillanceCamera" items="${digitalSurveillanceCameras}">

        <c:if test="${digitalSurveillanceCamera.deleted == false}">

            <tr>
                <td>${digitalSurveillanceCamera.description}</td>
                <td>${digitalSurveillanceCamera.resolution}</td>
                <td>${digitalSurveillanceCamera.id}</td>
                <td>${digitalSurveillanceCamera.price}</td>

                <spring:url value="/digitalSurveillanceCamera/${digitalSurveillanceCamera.id}/update" var="updateUrl" />
                <spring:url value="/digitalSurveillanceCamera/${digitalSurveillanceCamera.id}/delete" var="deleteUrl" />

                <td>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
                    <button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                </td>
            </tr>

        </c:if>

    </c:forEach>
</table>

</body>
</html>
