<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>IP Surveillance Camera</title>
</head>
<body>

<h1>IP Surveillance Camera</h1>

<spring:url value="/product/securityCamera/ipSurveillanceCamera/add" var="ipSurveillanceCameraAdd"/>
<button class="btn btn-primary" onclick="location.href='${ipSurveillanceCameraAdd}'">Add IP Surveillance Camera</button>

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

    <c:forEach var="ipSurveillanceCamera" items="${ipSurveillanceCameras}">

        <c:if test="${ipSurveillanceCamera.deleted == false}">

            <tr>
                <td>${ipSurveillanceCamera.description}</td>
                <td>${ipSurveillanceCamera.resolution}</td>
                <td>${ipSurveillanceCamera.id}</td>
                <td>${ipSurveillanceCamera.price}</td>

                <spring:url value="/ipSurveillanceCamera/${ipSurveillanceCamera.id}/update" var="updateUrl" />
                <spring:url value="/ipSurveillanceCamera/${ipSurveillanceCamera.id}/delete" var="deleteUrl" />

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
