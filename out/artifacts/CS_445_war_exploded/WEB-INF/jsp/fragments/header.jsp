<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>A surveillance shop</title>

<spring:url value="/static/css/hello.css" var="coreCss" />
<spring:url value="/static/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />


<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Index CS 445 Project</a>
		</div>
	</div>
</nav>