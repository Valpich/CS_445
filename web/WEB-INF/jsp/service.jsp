<%@ page session="true"%>
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
        <c:if test="${not empty customServices}">
            <div>
                <jsp:include page="fragments/service/customService.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty securitySystemInstallations}">
            <div>
                <jsp:include page="fragments/service/securitySystemInstallation.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty surveillanceDesigns}">
            <div>
                <jsp:include page="fragments/service/surveillanceDesign.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty surveillanceSystemRepairs}">
            <div>
                <jsp:include page="fragments/service/surveillanceSystemRepair.jsp" />
            </div>
        </c:if>

    </div>
</div>

<jsp:include page="fragments/footer.jsp" />

</body>
</html>
