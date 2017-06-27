<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty microphoneForm}">
            <h1>Add Microphone</h1><br>
            <spring:url value="/microphone" var="microphone"/>
        </c:when>
        <c:otherwise>
            <h1>Update Microphone</h1><br>
            <spring:url value="/microphoneUpdate" var="microphone"/>
        </c:otherwise>
    </c:choose>

    <form action='${microphone}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty microphoneForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${microphoneFormUpdate.description}" placeholder="">
                    <input hidden type="text" name="id" value="${microphoneFormUpdate.id}" >
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Battery</label>

            <select class="custom-select" name="battery">
                <option type="boolean" value="TRUE">True</option>
                <option type="boolean" value="FALSE">False</option>
            </select>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Microphone type</label>

            <select class="custom-select" name="microphone_type">
                <option type="text" value="CONDENSER">Condenser</option>
                <option type="text" value="DYNAMIC">Dynamic</option>
                <option type="text" value="RIBBON">Ribbon</option>
                <option type="text" value="CARBON">Carbon</option>
                <option type="text" value="PIEZOELECTRIC">Piezo Electric</option>
                <option type="text" value="FIBER_OPTIC">Fiber Optic</option>
                <option type="text" value="LASER">Laser</option>
                <option type="text" value="LIQUID">Liquid</option>
                <option type="text" value="MEMS">Mems</option>
            </select>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty microphoneForm}">
                    <input type="text" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="price" value="${microphoneFormUpdate.price}" placeholder="">
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