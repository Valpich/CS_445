<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Surveillance Design</title>
</head>
<body>

<h1>Surveillance Design</h1>


<spring:url value="/service/surveillanceDesign/add" var="surveillanceDesign"/>
<button class="btn btn-primary" onclick="location.href='${surveillanceDesign}'">Add Security System Installation</button>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="surveillanceDesign" items="${surveillanceDesigns}">

        <c:if test="${surveillanceDesign.deleted == false}">

            <tr>
                <td>${surveillanceDesign.description}</td>
                <td>${surveillanceDesign.id}</td>
                <td>${surveillanceDesign.price}</td>

                <spring:url value="/surveillanceDesign/${surveillanceDesign.id}/delete" var="deleteUrl" />
                <spring:url value="/surveillanceDesign/${surveillanceDesign.id}/update" var="updateUrl" />

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
