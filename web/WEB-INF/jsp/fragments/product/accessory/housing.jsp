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

        <c:if test="${housing.deleted == false}">

                <tr>
                    <td>${housing.description}</td>
                    <td>${housing.id}</td>
                    <td>${housing.price}</td>

                    <spring:url value="/housing/${housing.id}/cart" var="cartUrl" />
                    <spring:url value="/housing/${housing.id}/update" var="updateUrl" />
                    <spring:url value="/housing/${housing.id}/delete" var="deleteUrl" />

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
