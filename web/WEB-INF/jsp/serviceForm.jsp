<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragments/header.jsp" />

<body>

<div class="container" role="main">
    <div class="col-sm-4">
        <jsp:include page="fragments/leftbar.jsp" />
    </div>
    <div class="col-sm-8">
        <c:if test="${not empty customServiceForm}">
            <div>
                <jsp:include page="fragments/form/service/customServiceForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty customServiceFormUpdate}">
            <div>
                <jsp:include page="fragments/form/service/customServiceForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty securitySystemInstallation}">
            <div>
                <jsp:include page="fragments/form/service/securitySystemInstallationForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty securitySystemInstallationUpdate}">
            <div>
                <jsp:include page="fragments/form/service/securitySystemInstallationForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty surveillanceDesign}">
            <div>
                <jsp:include page="fragments/form/service/surveillanceDesignForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty surveillanceDesignUpdate}">
            <div>
                <jsp:include page="fragments/form/service/surveillanceDesignForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty surveillanceSystemRepair}">
            <div>
                <jsp:include page="fragments/form/service/surveillanceSystemRepairForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty surveillanceSystemRepairUpdate}">
            <div>
                <jsp:include page="fragments/form/service/surveillanceSystemRepairForm.jsp" />
            </div>
        </c:if>

    </div>
</div>



<jsp:include page="fragments/footer.jsp" />

</body>
</html>