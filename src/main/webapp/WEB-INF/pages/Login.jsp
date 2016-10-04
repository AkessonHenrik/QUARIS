<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="full" lang="en">
<head>
    <title>Login</title>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Raleway:200" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
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
