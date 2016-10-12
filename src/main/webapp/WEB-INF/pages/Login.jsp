<%@include file="include/head.jsp" %>

<div class="wrapper">
    <div class="container">
        <h1 class="title">Login</h1>
        <form class="form-signin" method="post">
            <input class="form-control form-control-lg" type="text" name="username" placeholder="Username" required autofocus>
            <input class="form-control form-control-lg" type="password" name="password" placeholder="password" required>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
            <a class="btn btn-lg btn-outline-secondary btn-block" href="${pageContext.request.contextPath}">Go home</a>
        </form>
    </div>
</div>

<%@include file="include/footer.jsp" %>
