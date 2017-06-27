<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Analog DVR</title>
</head>
<body>

<h1>Analog DVR</h1>


<spring:url value="/product/dvr/analog/add" var="analogAdd"/>
<button class="btn btn-primary" onclick="location.href='${analogAdd}'">Add Analog DVR</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>Storage Types</th>
        <th>Analog Record Formats</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="analogDVR" items="${analogsDVR}">

            <c:if test="${analogDVR.deleted == false}">

                <tr>
                    <td>${analogDVR.description}</td>
                    <td>${analogDVR.storageTypes}</td>
                    <td>${analogDVR.analogRecordFormats}</td>
                    <td>${analogDVR.id}</td>
                    <td>${analogDVR.price}</td>

                    <spring:url value="/analogDVR/${analogDVR.id}/cart" var="cartUrl" />
                    <spring:url value="/analogDVR/${analogDVR.id}/update" var="updateUrl" />
                    <spring:url value="/analogDVR/${analogDVR.id}/delete" var="deleteUrl" />

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
