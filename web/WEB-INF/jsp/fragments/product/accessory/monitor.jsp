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

        <c:if test="${monitor.deleted == false}">

            <tr>
                <td>${monitor.description}</td>
                <td>${monitor.size}</td>
                <td>${monitor.maxResolution}</td>
                <td>${monitor.id}</td>
                <td>${monitor.price}</td>

                <spring:url value="/monitor/${monitor.id}/update" var="updateUrl" />
                <spring:url value="/monitor/${monitor.id}/delete" var="deleteUrl" />

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
