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
        <tr>
            <td>${analogSurveillanceCamera.description}</td>
            <td>${analogSurveillanceCamera.resolution}</td>
            <td>${analogSurveillanceCamera.id}</td>
            <td>${analogSurveillanceCamera.price}</td>

            <td>
                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
