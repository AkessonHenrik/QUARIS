<%@ include file="../include/jsp-config.jsp" %>

<t:layout-main>
    <jsp:body>
        <div class="wrapper">
            <div class="container">
                <h1 class="title">Register</h1>

                <c:if test="${_message == 'INVALID_USERNAME'}">
                    <div class="alert alert-warning" role="alert">
                        Your username is invalid. The length must be less than 32 characters.
                    </div>
                </c:if>
                <c:if test="${_message == 'INVALID_EMAIL'}">
                    <div class="alert alert-warning" role="alert">
                        Your email is invalid. It must be a valid email and the length must be less than 64 characters.
                    </div>
                </c:if>
                <c:if test="${_message == 'INVALID_PASSWORD'}">
                    <div class="alert alert-warning" role="alert">
                        Your password is too short. Please use at least 6 characters.
                    </div>
                </c:if>
                <c:if test="${_message == 'USERNAME_ALREADY_EXISTS'}">
                    <div class="alert alert-warning" role="alert">
                        Username already exists. Please try an other one.
                    </div>
                </c:if>

                <form class="form-signin" method="post">
                    <label for="inputUsername" class="sr-only">Username</label>
                    <input name="username" id="inputUsername" class="form-control form-control-lg" placeholder="Username" required autofocus>

                    <label for="inputEmail" class="sr-only">Email</label>
                    <input type="email" name="email" id="inputEmail" class="form-control form-control-lg" placeholder="Email" required>

                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" name="password" id="inputPassword" class="form-control form-control-lg" placeholder="Password" required>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    <a href="${pageContext.request.contextPath}" class="btn btn-secondary btn-block" type="submit">Go home</a>
                </form>
            </div>
        </div>
    </jsp:body>
</t:layout-main>