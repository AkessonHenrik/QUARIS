<nav class="navbar navbar-fixed-top navbar-light bg-faded">
    <a class="navbar-brand" href="#">QUARIS</a>
    <c:if test='${isLogged}'>
        <ul class="nav navbar-nav">
            <li class="nav-item activea">
                <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin">Admin</a>
            </li>
        </ul>
    </c:if>

    <div class="float-xs-right">
        <c:if test='${!isLogged}'>
            <a href="${pageContext.request.contextPath}/auth/login" class="btn btn-outline-primary">Login</a>
            <a href="${pageContext.request.contextPath}/auth/register" class="btn btn-outline-success">Register</a>
        </c:if>

        <c:if test='${isLogged}'>
            <a href="${pageContext.request.contextPath}/auth/logout" class="btn btn-outline-secondary">Log out</a>
        </c:if>
    </div>
</nav>
