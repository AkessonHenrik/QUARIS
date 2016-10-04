<%--
  Created by IntelliJ IDEA.
  User: Henrik
  Date: 28.09.2016
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="full">
<head>
    <title>Not allowed!</title>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Raleway:200" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="coming-soon">
    <div class="container">
        <h2 class="full">You are not allowed to acces this page</h2>
        <h2>Register or log in.</h2>
        <a class="btn btn-lg btn-outline-secondary" href="${pageContext.request.contextPath}/">Back to frontpage</a>
    </div>
</div>
</body>
</html>
