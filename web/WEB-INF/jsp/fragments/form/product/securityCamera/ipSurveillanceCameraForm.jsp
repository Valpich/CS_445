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
            <spring:url value="/ipSurveillanceCamera" var="ipSurveillanceCamera"/>
        </c:when>
        <c:otherwise>
            <h1>Update Ip Surveillance Camera</h1><br>
            <spring:url value="/ipSurveillanceCameraUpdate" var="ipSurveillanceCamera"/>
        </c:otherwise>
    </c:choose>

    <form action='${ipSurveillanceCamera}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty ipSurveillanceCameraForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${ipSurveillanceCameraFormUpdate.description}" placeholder="">
                    <input hidden type="text" name="id" value="${ipSurveillanceCameraFormUpdate.id}">
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
                    <input type="number" step="0.01" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="number" step="0.01" name="price" value="${ipSurveillanceCameraFormUpdate.price}" placeholder="">
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