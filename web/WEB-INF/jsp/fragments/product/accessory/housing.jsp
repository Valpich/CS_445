<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Housing</title>
</head>
<body>

<h1>Housing</h1>

<spring:url value="/product/accessory/housing/add" var="housing"/>
<button class="btn btn-primary" onclick="location.href='${housing}'">Add Housing</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="housing" items="${housings}">
        <tr>
            <td>${lens.description}</td>
            <td>${lens.id}</td>
            <td>${lens.price}</td>

            <spring:url value="/housing/${housing.id}/update" var="updateUrl" />

            <td>
                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
                <button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
