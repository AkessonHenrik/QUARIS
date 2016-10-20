<%@include file="../include/head.jsp" %>

<div class="wrapper">
    <div class="container">
        <h1 class="title">Register</h1>
        <form class="form-signin" method="post">
            <label for="inputUsername" class="sr-only">Username</label>
            <input name="username" id="inputUsername" class="form-control form-control-lg" placeholder="Username" required autofocus>

            <label for="inputEmail" class="sr-only">Username</label>
            <input type="email" name="email" id="inputEmail" class="form-control form-control-lg" placeholder="Email" required>

            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" id="inputPassword" class="form-control form-control-lg" placeholder="Password" required>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            <a href="${pageContext.request.contextPath}" class="btn btn-secondary btn-block" type="submit">Go home</a>
        </form>
    </div>
</div>

<%@include file="../include/footer.jsp" %>
