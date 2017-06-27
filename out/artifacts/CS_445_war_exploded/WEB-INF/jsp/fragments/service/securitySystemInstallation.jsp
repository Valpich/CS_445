<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Security System Installation</title>
</head>
<body>

<h1>Security System Installation</h1>


<spring:url value="/service/securitySystemInstallation/add" var="securitySystemInstallation"/>
<button class="btn btn-primary" onclick="location.href='${securitySystemInstallation}'">Add Security System Installation</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="securitySystemInstallation" items="${securitySystemInstallations}">

        <c:if test="${securitySystemInstallation.deleted == false}">

            <tr>
                <td>${securitySystemInstallation.description}</td>
                <td>${securitySystemInstallation.id}</td>
                <td>${securitySystemInstallation.price}</td>

                <spring:url value="/securitySystemInstallation/${securitySystemInstallation.id}/cart" var="cartUrl" />
                <spring:url value="/securitySystemInstallation/${securitySystemInstallation.id}/update" var="updateUrl" />
                <spring:url value="/securitySystemInstallation/${securitySystemInstallation.id}/delete" var="deleteUrl" />

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
