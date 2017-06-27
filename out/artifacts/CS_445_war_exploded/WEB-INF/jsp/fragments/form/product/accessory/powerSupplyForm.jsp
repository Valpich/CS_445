<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty powerSupplyForm}">
            <h1>Add Power Supply</h1><br>
            <spring:url value="/powerSupply" var="powerSupply"/>
        </c:when>
        <c:otherwise>
            <h1>Update Power Supply</h1><br>
            <spring:url value="/powerSupplyUpdate" var="powerSupply"/>
        </c:otherwise>
    </c:choose>

    <form action='${powerSupply}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty powerSupplyForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${powerSupplyFormUpdate.description}" placeholder="">
                    <input hidden type="text" name="id" value="${powerSupplyFormUpdate.id}" >
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Maximum Output</label>

            <c:choose>
                <c:when test="${not empty powerSupplyForm}">
                    <input type="text" name="maximum_output" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="maximum_output" value="${powerSupplyFormUpdate.maximumOutput}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Voltage</label>

            <c:choose>
                <c:when test="${not empty powerSupplyForm}">
                    <input type="text" name="voltage" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="voltage" value="${powerSupplyFormUpdate.voltage}" placeholder="">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty powerSupplyForm}">
                    <input type="text" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="price" value="${powerSupplyFormUpdate.price}" placeholder="">
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