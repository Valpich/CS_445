<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside class="main-sidebar">
    <section class="sidebar">
        <c:if test="${not empty sessionScope.user}">
            <ul class="sidebar-menu">
                <div class="user-panel">
                    <div class="pull-left info">
                        <p>${sessionScope.user.lastName} ${sessionScope.user.firstName}</p>
                        <i class="fa fa-circle text-success"></i> Online
                    </div>
                </div>
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
                    <span> Admin </span>
                </a>
                <ul>
                    <li ><a href="${pageContext.request.contextPath}/users/listAll"> List all </a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>
