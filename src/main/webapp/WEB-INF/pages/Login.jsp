<%@include file="include/header.jsp" %>

<body>
<div class="coming-soon">
    <div class="container">
        <h1 class="title">Login</h1>
        <form method="post">
            <input class="form-control-lg" type="text" name="username" placeholder="Username"><br>
            <input class="form-control-lg" type="password" name="password" placeholder="password"><br>
            <input class="btn btn-lg btn-primary" type="submit" value="Submit">
            <a class="btn btn-lg btn-outline-secondary" href="${pageContext.request.contextPath}/">Back to frontpage</a>
        </form>
    </div>
</div>
</body>
</html>
