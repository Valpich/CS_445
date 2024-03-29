<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Bracket</title>
</head>
<body>

<h1>Bracket</h1>

<spring:url value="/product/accessory/bracket/add" var="bracket"/>
<button class="btn btn-primary" onclick="location.href='${bracket}'">Add Bracket</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="bracket" items="${brackets}">

        <c:if test="${bracket.deleted == false}">

            <tr>
                <td>${bracket.description}</td>
                <td>${bracket.id}</td>
                <td>${bracket.price}</td>

                <spring:url value="/bracket/${bracket.id}/cart" var="cartUrl" />
                <spring:url value="/bracket/${bracket.id}/update" var="updateUrl" />
                <spring:url value="/bracket/${bracket.id}/delete" var="deleteUrl" />

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
