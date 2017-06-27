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

            <c:if test="${not empty analogsDVR}">
                <div>
                    <jsp:include page="fragments/product/dvr/analogDVR.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty digitalsDVR}">
                <div>
                    <jsp:include page="fragments/product/dvr/digitalDVR.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty hybridsDVR}">
                <div>
                    <jsp:include page="fragments/product/dvr/hybridDVR.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty analogSurveillanceCameras}">
                <div>
                    <jsp:include page="fragments/product/securityCamera/analogSurveillanceCamera.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty digitalSurveillanceCameras}">
                <div>
                    <jsp:include page="fragments/product/securityCamera/digitalSurveillanceCamera.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty ipSurveillanceCameras}">
                <div>
                    <jsp:include page="fragments/product/securityCamera/ipSurveillanceCamera.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty brackets}">
                <div>
                    <jsp:include page="fragments/product/accessory/bracket.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty cables}">
                <div>
                    <jsp:include page="fragments/product/accessory/cable.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty connectors}">
                <div>
                    <jsp:include page="fragments/product/accessory/connector.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty housings}">
                <div>
                    <jsp:include page="fragments/product/accessory/housing.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty infraredLightnings}">
                <div>
                    <jsp:include page="fragments/product/accessory/infraredLightning.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty lenses}">
                <div>
                    <jsp:include page="fragments/product/accessory/lens.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty microphones}">
                <div>
                    <jsp:include page="fragments/product/accessory/microphone.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty monitors}">
                <div>
                    <jsp:include page="fragments/product/accessory/monitor.jsp" />
                </div>
            </c:if>

            <c:if test="${not empty powerSupplies}">
                <div>
                    <jsp:include page="fragments/product/accessory/powerSupply.jsp" />
                </div>
            </c:if>

        </div>
    </div>

    <jsp:include page="fragments/footer.jsp" />

</body>
</html>
