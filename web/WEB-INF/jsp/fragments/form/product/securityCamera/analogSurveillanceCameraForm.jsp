<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty analogSurveillanceCameraForm}">
            <h1>Add Analog Surveillance Camera</h1><br>
        </c:when>
        <c:otherwise>
            <h1>Update Analog Surveillance Camera</h1><br>
        </c:otherwise>
    </c:choose>

    <spring:url value="/analogSurveillanceCamera" var="analog"/>

    <form action='${analog}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty analogSurveillanceCameraForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${analogSurveillanceCameraFormUpdate.description}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Resolution</label>

            <c:choose>
                <c:when test="${not empty analogSurveillanceCameraForm}">
                    <input type="text" name="resolution" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="resolution" value="${analogSurveillanceCameraFormUpdate.resolution}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty analogSurveillanceCameraForm}">
                    <input type="text" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="price" value="${analogSurveillanceCameraFormUpdate.price}" placeholder="">
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