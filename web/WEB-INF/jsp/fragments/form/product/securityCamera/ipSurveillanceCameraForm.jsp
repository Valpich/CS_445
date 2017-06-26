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

            <c:choose>
                <c:when test="${not empty ipSurveillanceCameraForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${ipSurveillanceCameraFormUpdate.description}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Resolution</label>

            <c:choose>
                <c:when test="${not empty ipSurveillanceCameraForm}">
                    <input type="text" name="resolution" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="resolution" value="${ipSurveillanceCameraFormUpdate.resolution}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty ipSurveillanceCameraForm}">
                    <input type="text" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="price" value="${ipSurveillanceCameraFormUpdate.price}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>

    </form>

</div>

</body>
</html>