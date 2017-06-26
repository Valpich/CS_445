<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty lensForm}">
            <h1>Add Lens</h1><br>
        </c:when>
        <c:otherwise>
            <h1>Update Lens</h1><br>
        </c:otherwise>
    </c:choose>

    <spring:url value="/lens" var="lens"/>

    <form action='${lens}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty lensForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${lensFormUpdate.description}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Focal</label>

            <c:choose>
                <c:when test="${not empty lensForm}">
                    <input type="text" name="focal" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="focal" value="${lensFormUpdate.focal}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Magnification</label>

            <c:choose>
                <c:when test="${not empty lensForm}">
                    <input type="text" name="magnification" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${lensFormUpdate.magnification}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty lensForm}">
                    <input type="text" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="price" value="${lensFormUpdate.price}" placeholder="">
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