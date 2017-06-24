<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>A surveillance shop</title>

<spring:url value="/static/css/hello.css" var="coreCss" />
<spring:url value="/static/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/cart" var="urlCart" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Index CS 445 Project</a>
		</div>
		<c:if test="${not empty user}">
		<div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlCart}">Cart: ${sessionScope.cart.listCount}</a></li>
			</ul>
		</div>
		</c:if>
	</div>
</nav>