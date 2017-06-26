<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">
    <h1>Add Analog DVR</h1><br>

    <spring:url value="/analogDVR" var="analog"/>

    <form action='${analog}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>
            <input type="text" name="description" placeholder="">
        </div>
        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Analog Record Formats</label>
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
            <input type="text" name="price" placeholder="">
        </div>

        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Save Analog DVR</button>
        </div>

    </form>

</div>

</body>
</html>