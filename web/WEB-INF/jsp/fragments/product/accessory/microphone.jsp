<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
    <title>Microphone</title>
</head>
<body>

<h1>Microphone</h1>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Description</th>
        <th>Battery</th>
        <th>Microphone Type</th>
        <th>ID</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="microphone" items="${microphones}">
        <tr>
            <td>${microphone.description}</td>
            <td>${microphone.battery}</td>
            <td>${microphone.microphoneType}</td>
            <td>${microphone.id}</td>
            <td>${microphone.price}</td>

            <td>
                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Add Cart</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
