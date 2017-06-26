<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Analog DVR</title>
</head>
<body>

<h1>Hybrid DVR</h1>

<spring:url value="/product/dvr/hybrid/add" var="hybridAdd"/>
<button class="btn btn-primary" onclick="location.href='${hybridAdd}'">Add Hybrid DVR</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>Storage Types</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="hybridDVR" items="${hybridsDVR}">
        <tr>
            <td>${hybridDVR.description}</td>
            <td>${hybridDVR.storageTypes}</td>
            <td>${hybridDVR.id}</td>
            <td>${hybridDVR.price}</td>

            <spring:url value="/hybridDVR/${hybridDVR.id}/update" var="updateUrl" />

            <td>
                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
                <button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
