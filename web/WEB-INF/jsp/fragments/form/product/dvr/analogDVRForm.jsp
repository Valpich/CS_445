<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty analogDVRForm}">
            <h1>Add Analog DVR</h1><br>
            <spring:url value="/analogDVR" var="analog"/>
        </c:when>
        <c:otherwise>
            <h1>Update Analog DVR</h1><br>
            <spring:url value="/analogDVRUpdate" var="analog"/>
        </c:otherwise>
    </c:choose>

    <form action='${analog}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty analogDVRForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${analogDVRFormUpdate.description}" placeholder="">
                    <input type="hidden" name="id" value="${analogDVRFormUpdate.id}">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Analog Record</label>
            <select class="custom-select" name="analog_record_formats">
                <option type="text" value="NTSC">NTSC</option>
                <option type="text" value="PAL">PAL</option>
                <option type="text" value="SECAM">SECAM</option>
            </select>
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
                <c:when test="${not empty analogDVRForm}">
                    <input type="text" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="price" value="${analogDVRFormUpdate.price}" placeholder="">
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