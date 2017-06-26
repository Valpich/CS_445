<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>

<div class="container">
    <div class="loginmodal-container">
        <h1>Login to Your Account</h1><br>
        <form method="POST">
            <input type="text" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" class="btn btn-primary">
        </form>

        <div class="login-help">
            <a href="${pageContext.request.contextPath}/users/add">Register</a>
        </div>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>