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

        <c:if test="${hybridDVR.deleted == false}">

                <tr>
                    <td>${hybridDVR.description}</td>
                    <td>${hybridDVR.storageTypes}</td>
                    <td>${hybridDVR.id}</td>
                    <td>${hybridDVR.price}</td>

                    <spring:url value="/hybridDVR/${hybridDVR.id}/cart" var="cartUrl" />
                    <spring:url value="/hybridDVR/${hybridDVR.id}/update" var="updateUrl" />
                    <spring:url value="/hybridDVR/${hybridDVR.id}/delete" var="deleteUrl" />

                    <td>
                        <button class="btn btn-primary" onclick="location.href='${cartUrl}'">Add Cart</button>
                        <button class="btn btn-info" onclick="location.href='${updateUrl}'">Update</button>
                        <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                    </td>
                </tr>

        </c:if>

    </c:forEach>
</table>

</body>
</html>
