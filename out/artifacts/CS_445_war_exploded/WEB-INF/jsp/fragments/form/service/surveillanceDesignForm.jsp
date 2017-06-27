<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<body>

<div class="container">

    <c:choose>
        <c:when test="${not empty surveillanceDesignForm}">
            <h1>Add Surveillance Design</h1><br>
            <spring:url value="/surveillanceDesign" var="surveillanceDesign"/>
        </c:when>
        <c:otherwise>
            <h1>Update Surveillance Design</h1><br>
            <spring:url value="/surveillanceDesignUpdate" var="surveillanceDesign"/>
        </c:otherwise>
    </c:choose>

    <form action='${surveillanceDesign}' method="POST">

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Description</label>

            <c:choose>
                <c:when test="${not empty surveillanceDesignForm}">
                    <input type="text" name="description" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="description" value="${surveillanceDesignFormUpdate.description}" placeholder="">
                    <input type="hidden" name="id" value="${surveillanceDesignFormUpdate.id}">
                </c:otherwise>
            </c:choose>

        </div>

        <div class="col-sm-10">
            <label class="col-sm-2 control-label">Price</label>

            <c:choose>
                <c:when test="${not empty surveillanceDesignForm}">
                    <input type="text" name="price" placeholder="">
                </c:when>
                <c:otherwise>
                    <input type="text" name="price" value="${surveillanceDesignFormUpdate.price}" placeholder="">
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