<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty ipSurveillanceCameraForm}">
            <h1>Add Ip Surveillance Camera</h1><br>
        </c:when>
        <c:otherwise>
            <h1>Update Ip Surveillance Camera</h1><br>
        </c:otherwise>
    </c:choose>

    <spring:url value="/ipSurveillanceCamera" var="ipSurveillanceCamera"/>

    <form action='${ipSurveillanceCamera}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>
            <input type="text" name="description" placeholder="">
        </div>
        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Resolution</label>
            <input type="text" name="resolution" placeholder="">
        </div>
        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>
            <input type="text" name="price" placeholder="">
        </div>

        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>

    </form>

</div>

</body>
</html>