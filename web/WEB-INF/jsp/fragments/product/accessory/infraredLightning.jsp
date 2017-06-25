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
        <tr>
            <td>${infraredLightning.description}</td>
            <td>${infraredLightning.id}</td>
            <td>${infraredLightning.price}</td>

            <td>
                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
