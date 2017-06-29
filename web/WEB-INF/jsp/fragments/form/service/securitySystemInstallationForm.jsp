<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty securitySystemInstallationForm}">
            <h1>Add Security System Installation</h1><br>
            <spring:url value="/securitySystemInstallation" var="securitySystemInstallation"/>
        </c:when>
        <c:otherwise>
            <h1>Update Security System Installation</h1><br>
            <spring:url value="/securitySystemInstallationUpdate" var="securitySystemInstallation"/>
        </c:otherwise>
    </c:choose>

    <form action='${securitySystemInstallation}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty securitySystemInstallationForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${securitySystemInstallationFormUpdate.description}" placeholder="">
                    <input type="hidden" name="id" value="${securitySystemInstallationFormUpdate.id}">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty securitySystemInstallationForm}">
                    <input type="number" step="0.01" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="number" step="0.01" name="price" value="${securitySystemInstallationFormUpdate.price}" placeholder="">
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