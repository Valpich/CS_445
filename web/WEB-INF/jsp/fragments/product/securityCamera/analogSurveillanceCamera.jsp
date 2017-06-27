<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Analog Surveillance Camera</title>
</head>
<body>

<h1>Analog Surveillance Camera</h1>

<spring:url value="/product/securityCamera/analogSurveillanceCamera/add" var="analog"/>
<button class="btn btn-primary" onclick="location.href='${analog}'">Add Analog Surveillance Camera</button>

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

    <c:forEach var="analogSurveillanceCamera" items="${analogSurveillanceCameras}">

        <c:if test="${analogSurveillanceCamera.deleted == false}">

            <tr>
                <td>${analogSurveillanceCamera.description}</td>
                <td>${analogSurveillanceCamera.resolution}</td>
                <td>${analogSurveillanceCamera.id}</td>
                <td>${analogSurveillanceCamera.price}</td>

                <spring:url value="/analogSurveillanceCamera/${analogSurveillanceCamera.id}/update" var="updateUrl" />
                <spring:url value="/analogSurveillanceCamera/${analogSurveillanceCamera.id}/delete" var="deleteUrl" />

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
