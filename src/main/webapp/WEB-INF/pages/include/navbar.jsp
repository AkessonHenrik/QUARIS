<nav class="navbar navbar-fixed-top navbar-dark bg-inverse">
    <a class="navbar-brand" href="#">QUARIS</a>
    <c:if test='${isLogged}'>
        <ul class="nav navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/protected">Go to protected page</a>
            </li>
        </ul>
    </c:if>

    <form class="form-inline pull-xs-right">
        <c:if test='${!isLogged}'>
            <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-primary">Login</a>
            <a href="${pageContext.request.contextPath}/register" class="btn btn-outline-success">Register</a>
        </c:if>

        <c:if test='${isLogged}'>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-secondary">Log out</a>
        </c:if>
    </form>
</nav>

