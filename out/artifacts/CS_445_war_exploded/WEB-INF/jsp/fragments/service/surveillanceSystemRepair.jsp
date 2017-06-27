<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Surveillance System Repair</title>
</head>
<body>

<h1>Surveillance System Repair</h1>


<spring:url value="/service/surveillanceSystemRepair/add" var="surveillanceSystemRepair"/>
<button class="btn btn-primary" onclick="location.href='${surveillanceSystemRepair}'">Add Surveillance System Repair</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="surveillanceSystemRepair" items="${surveillanceSystemRepairs}">

        <c:if test="${surveillanceSystemRepair.deleted == false}">

            <tr>
                <td>${surveillanceSystemRepair.description}</td>
                <td>${surveillanceSystemRepair.id}</td>
                <td>${surveillanceSystemRepair.price}</td>

                <spring:url value="/surveillanceSystemRepair/${surveillanceSystemRepair.id}/cart" var="cartUrl" />
                <spring:url value="/surveillanceSystemRepair/${surveillanceSystemRepair.id}/update" var="updateUrl" />
                <spring:url value="/surveillanceSystemRepair/${surveillanceSystemRepair.id}/delete" var="deleteUrl" />

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
