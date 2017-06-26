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
        </c:when>
        <c:otherwise>
            <h1>Update Power Supply</h1><br>
        </c:otherwise>
    </c:choose>

    <spring:url value="/powerSupply" var="powerSupply"/>

    <form action='${powerSupply}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>
            <input type="text" name="description" placeholder="">
        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Maximum Output</label>
            <input type="text" name="maximum_output" placeholder="">
        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Voltage</label>
            <input type="text" name="voltage" placeholder="">
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