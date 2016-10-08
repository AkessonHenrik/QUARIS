<%@include file="include/head.jsp" %>

<%@include file="include/navbar.jsp" %>

<div class="container" style="margin-top: 80px;">

    <h1 class="title">Register</h1>
    <form class="form-signin" method="post">
        <label for="inputUsername" class="sr-only">Username</label>
        <input name="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>

        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="username" id="inputPassword" class="form-control" placeholder="Password" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <a href="${pageContext.request.contextPath}/index" class="btn btn-secondary btn-block" type="submit">Go home</a>
    </form>

</div>

<%@include file="include/footer.jsp" %>
