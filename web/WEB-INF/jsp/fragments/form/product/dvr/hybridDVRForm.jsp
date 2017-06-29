<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty hybridDVRForm}">
            <h1>Add Hybrid DVR</h1><br>
            <spring:url value="/hybridDVR" var="hybrid"/>
        </c:when>
        <c:otherwise>
            <h1>Update Hybrid DVR</h1><br>
            <spring:url value="/hybridDVRUpdate" var="hybrid"/>
        </c:otherwise>
    </c:choose>



    <form action='${hybrid}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty hybridDVRForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${hybridDVRFormUpdate.description}" placeholder="">
                    <input hidden type="text" name="id" value="${hybridDVRFormUpdate.id}">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Storage Types</label>

            <select class="custom-select" name="storage_types">
                <option type="text" value="DISK_DRIVE">Disk Drive</option>
                <option type="text" value="USB">USB</option>
                <option type="text" value="SSD">SSD</option>
                <option type="text" value="SD_MEMORY_CARD">SD Memomy Card</option>
                <option type="text" value="OTHER">Other</option>
            </select>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty hybridDVRForm}">
                    <input type="number" step="0.01" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="number" step="0.01" name="price" value="${hybridDVRFormUpdate.price}" placeholder="">
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