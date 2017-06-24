<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside class="main-sidebar">
    <section class="sidebar">
        <c:if test="${not empty sessionScope.user}">
            <ul>
                <span>${sessionScope.user.lastName} ${sessionScope.user.firstName}</span>
                <li ><a href="${pageContext.request.contextPath}/logout"> Logout </a></li>
            </ul>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <ul>
                <li ><a href="${pageContext.request.contextPath}/login"> Login / Register </a></li>
            </ul>
        </c:if>
        <ul class="sidebar-menu">
            <li >
                <span> User </span>
                </a>
                <ul>
                    <li ><a href="${pageContext.request.contextPath}/login"> Login </a></li>
                    <li ><a href="${pageContext.request.contextPath}/logout"> Details </a></li>
                    <li ><a href="${pageContext.request.contextPath}/logout"> Logout </a></li>
                </ul>
            </li>
            <li >
                <span> Products </span>
                </a>
                <ul>
                    <span> DVR </span>
                    <li ><a href="${pageContext.request.contextPath}/product/dvr/analog"> Analog </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/dvr/digital"> Digital </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/dvr/hybrid"> Hybrid </a></li>
                    <span> Surveillance Camera </span>
                    <li ><a href="${pageContext.request.contextPath}/product/surveillance-camera/analog"> Analog </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/surveillance-camera/digital"> Digital </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/surveillance-camera/ip"> IP </a></li>
                    <span> Accessory </span>
                    <li ><a href="${pageContext.request.contextPath}/product/accessory/bracket"> Bracket </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/accessory/cable"> Cable </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/accessory/connector"> Connector </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/accessory/housing"> Housing </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/accessory/infrared-lightning"> Infrared lightning </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/accessory/lens"> Lens </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/accessory/microphone"> Microphone </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/accessory/monitor"> Monitor </a></li>
                    <li ><a href="${pageContext.request.contextPath}/product/accessory/power-supply"> Power supply </a></li>
                </ul>
                <span> Services </span>
                </a>
                <ul>
                    <li ><a href="${pageContext.request.contextPath}/service/custom-service"> Custom service </a></li>
                    <li ><a href="${pageContext.request.contextPath}/service/security-system-installation"> Security system installation </a></li>
                    <li ><a href="${pageContext.request.contextPath}/service/surveillance-design"> Surveillance design </a></li>
                    <li ><a href="${pageContext.request.contextPath}/service/surveillance-system-repair"> Surveillance system repair </a></li>
                </ul>
            </li>
            <li >
                <span> Admin </span>
                </a>
                <ul>
                    <li ><a href="${pageContext.request.contextPath}/users/listAll"> List all </a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>
