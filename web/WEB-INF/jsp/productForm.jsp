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
        <c:if test="${not empty analogDVRForm}">
            <div>
                <jsp:include page="fragments/form/product/dvr/analogDVRForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty analogDVRFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/dvr/analogDVRForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty digitalDVRForm}">
            <div>
                <jsp:include page="fragments/form/product/dvr/digitalDVRForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty digitalDVRFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/dvr/digitalDVRForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty hybridDVRForm}">
            <div>
                <jsp:include page="fragments/form/product/dvr/hybridDVRForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty hybridDVRFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/dvr/hybridDVRForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty analogSurveillanceCameraForm}">
            <div>
                <jsp:include page="fragments/form/product/securityCamera/analogSurveillanceCameraForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty analogSurveillanceCameraFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/securityCamera/analogSurveillanceCameraForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty digitalSurveillanceCameraForm}">
            <div>
                <jsp:include page="fragments/form/product/securityCamera/digitalSurveillanceCameraForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty digitalSurveillanceCameraFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/securityCamera/digitalSurveillanceCameraForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty ipSurveillanceCameraForm}">
            <div>
                <jsp:include page="fragments/form/product/securityCamera/ipSurveillanceCameraForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty ipSurveillanceCameraFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/securityCamera/ipSurveillanceCameraForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty bracketForm}">
            <div>
                <jsp:include page="fragments/form/product/accessory/bracketForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty bracketFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/accessory/bracketForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty cableForm}">
            <div>
                <jsp:include page="fragments/form/product/accessory/cableForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty cableFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/accessory/cableForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty connectorForm}">
            <div>
                <jsp:include page="fragments/form/product/accessory/connectorForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty connectorFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/accessory/connectorForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty housingForm}">
            <div>
                <jsp:include page="fragments/form/product/accessory/housingForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty housingFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/accessory/housingForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty infraredLightningForm}">
            <div>
                <jsp:include page="fragments/form/product/accessory/infraredLightningForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty infraredLightningFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/accessory/infraredLightningForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty lensForm}">
            <div>
                <jsp:include page="fragments/form/product/accessory/lensForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty lensFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/accessory/lensForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty microphoneForm}">
            <div>
                <jsp:include page="fragments/form/product/accessory/microphoneForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty microphoneFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/accessory/microphoneForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty monitorForm}">
            <div>
                <jsp:include page="fragments/form/product/accessory/monitorForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty monitorFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/accessory/monitorForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty powerSupplyForm}">
            <div>
                <jsp:include page="fragments/form/product/accessory/powerSupplyForm.jsp" />
            </div>
        </c:if>

        <c:if test="${not empty powerSupplyFormUpdate}">
            <div>
                <jsp:include page="fragments/form/product/accessory/powerSupplyForm.jsp" />
            </div>
        </c:if>

    </div>
</div>



<jsp:include page="fragments/footer.jsp" />

</body>
</html>