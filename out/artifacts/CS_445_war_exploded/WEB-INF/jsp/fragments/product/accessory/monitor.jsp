<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Monitor</title>
</head>
<body>

<h1>Monitor</h1>

<spring:url value="/product/accessory/monitor/add" var="monitor"/>
<button class="btn btn-primary" onclick="location.href='${monitor}'">Add Monitor</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>Size</th>
        <th>Max Resolution</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="monitor" items="${monitors}">
        <tr>
            <td>${monitor.description}</td>
            <td>${monitor.size}</td>
            <td>${monitor.maxResolution}</td>
            <td>${monitor.id}</td>
            <td>${monitor.price}</td>

            <td>
                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
                <button class="btn btn-info" onclick="location.href='${userUrl}'">Update</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
