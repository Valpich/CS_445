<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Lens</title>
</head>
<body>

<h1>Lens</h1>

<spring:url value="/product/accessory/lens/add" var="lens"/>
<button class="btn btn-primary" onclick="location.href='${lens}'">Add Bracket</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>Focal</th>
        <th>Magnification</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="lens" items="${lenses}">
        <tr>
            <td>${lens.description}</td>
            <td>${lens.focal}</td>
            <td>${lens.magnification}</td>
            <td>${lens.id}</td>
            <td>${lens.price}</td>

            <td>
                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
                <button class="btn btn-info" onclick="location.href='${userUrl}'">Update</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>