<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Cable</title>
</head>
<body>

<h1>Cable</h1>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>Length</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="cable" items="${cables}">
        <tr>
            <td>${cable.description}</td>
            <td>${cable.length}</td>
            <td>${cable.id}</td>
            <td>${cable.price}</td>

            <td>
                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
