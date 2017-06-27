<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty surveillanceSystemRepairForm}">
            <h1>Add Surveillance System Repair</h1><br>
            <spring:url value="/surveillanceSystemRepair" var="surveillanceSystemRepair"/>
        </c:when>
        <c:otherwise>
            <h1>Update Surveillance System Repair</h1><br>
            <spring:url value="/surveillanceSystemRepairUpdate" var="surveillanceSystemRepair"/>
        </c:otherwise>
    </c:choose>

    <form action='${surveillanceSystemRepair}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty surveillanceSystemRepairForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${surveillanceSystemRepairFormUpdate.description}" placeholder="">
                    <input type="hidden" name="id" value="${surveillanceSystemRepairFormUpdate.id}">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty surveillanceSystemRepairForm}">
                    <input type="text" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="price" value="${surveillanceSystemRepairFormUpdate.price}" placeholder="">
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