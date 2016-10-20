<%@include file="../include/head.jsp" %>

<div class="wrapper">
    <div class="container">
        <h1 class="title">Login</h1>

        <c:if test="${_message == 'INVALID_LOGIN'}">
            <div class="alert alert-warning" role="alert">
                It appears you aren't registered. Please <a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/register">Register here</a>.
            </div>
        </c:if>
        <c:if test="${_message == 'NOT_ALLOWED'}">
            <div class="alert alert-warning" role="alert">
                You are not allowed to access this page.<br>
                Please log in or <a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/register">Register</a>.
            </div>
        </c:if>

        <form class="form-signin" action="${pageContext.request.contextPath}/auth/login" method="post">
            <input class="form-control form-control-lg" type="text" name="username" placeholder="Username" required autofocus>
            <input class="form-control form-control-lg" type="password" name="password" placeholder="Password" required>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
            <a class="btn btn-secondary btn-block" href="${pageContext.request.contextPath}">Go home</a>
        </form>
    </div>
</div>

<%@include file="../include/footer.jsp" %>
