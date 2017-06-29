<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty monitorForm}">
            <h1>Add Monitor</h1><br>
            <spring:url value="/monitor" var="monitor"/>
        </c:when>
        <c:otherwise>
            <h1>Update Monitor</h1><br>
            <spring:url value="/monitorUpdate" var="monitor"/>
        </c:otherwise>
    </c:choose>

    <spring:url value="/monitor" var="monitor"/>

    <form action='${monitor}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty monitorForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${monitorFormUpdate.description}" placeholder="">
                    <input hidden type="text" name="id" value="${monitorFormUpdate.id}" >
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Size</label>

            <c:choose>
                <c:when test="${not empty monitorForm}">
                    <input type="number" step="0.01" name="size" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="number" step="0.01" name="size" value="${monitorFormUpdate.size}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Max Resolution</label>

            <c:choose>
                <c:when test="${not empty monitorForm}">
                    <input type="text" name="max_resolution" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="max_resolution" value="${monitorFormUpdate.maxResolution}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty monitorForm}">
                    <input type="number" step="0.01" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="number" step="0.01" name="price" value="${monitorFormUpdate.price}" placeholder="">
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