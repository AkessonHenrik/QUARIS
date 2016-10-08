<%@include file="include/head.jsp" %>

<%@include file="include/navbar.jsp" %>

<div class="coming-soon">
    <div class="container">
        <h1 class="title">Quaris</h1>

        <c:if test='${!isLogged}'>
            <a href="${pageContext.request.contextPath}/login" class="btn btn-lg btn-primary">Login</a>
            <a href="${pageContext.request.contextPath}/register" class="btn btn-lg btn-success">Register</a>
        </c:if>

        <c:if test='${isLogged}'>
            <a href="${pageContext.request.contextPath}/protected" class="btn btn-lg btn-primary">Go to protected page</a>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-lg btn-secondary">Log out</a>
        </c:if>
    </div>
    <div class="copyright">A multi-tier application project by Henrik & Fabien</div>
</div>

<%@include file="include/footer.jsp" %>
