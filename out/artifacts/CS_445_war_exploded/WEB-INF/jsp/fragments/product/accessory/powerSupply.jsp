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
        <tr>
            <td>${powerSupply.description}</td>
            <td>${powerSupply.maximum_output}</td>
            <td>${powerSupply.voltage}</td>
            <td>${powerSupply.id}</td>
            <td>${powerSupply.price}</td>

            <td>
                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
