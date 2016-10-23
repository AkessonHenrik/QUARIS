<%@ include file="include/jsp-config.jsp" %>

<t:layout-main>
    <jsp:body>
        <div class="coming-soon full">
            <div class="container">
                <h1 class="title">Quaris</h1>

                <div class="index-panel">
                    <c:if test="${_message == 'USER_CREATED'}">
                        <div class="alert alert-info" role="alert">
                            User created, you can now log in.
                        </div>
                    </c:if>
                    <c:if test="${_message == 'USER_LOGGED'}">
                        <div class="alert alert-success" role="alert">
                            You are logged in !
                        </div>
                    </c:if>
                    <c:if test="${_message == 'USER_LOGGED_OUT'}">
                        <div class="alert alert-warning" role="alert">
                            You are logged out !
                        </div>
                    </c:if>

                    <c:if test="${!isLogged}">
                        <a href="${pageContext.request.contextPath}/auth/login" class="btn btn-lg btn-primary">Login</a>
                        <a href="${pageContext.request.contextPath}/auth/register" class="btn btn-lg btn-success">Register</a>
                    </c:if>

                    <c:if test="${isLogged}">
                        <a href="${pageContext.request.contextPath}/admin" class="btn btn-lg btn-primary">Go to administration</a>
                        <a href="${pageContext.request.contextPath}/auth/logout" class="btn btn-lg btn-secondary">Log out</a>
                    </c:if>
                </div>
            </div>
            <div class="copyright">A multi-tier application project by Henrik & Fabien</div>
        </div>
    </jsp:body>
</t:layout-main>
