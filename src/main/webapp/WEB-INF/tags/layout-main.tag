<%@tag description="Main layout" pageEncoding="UTF-8" %>
<%@attribute name="head" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Quaris</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!--<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" type="text/css">-->
    <link href="https://fonts.googleapis.com/css?family=Raleway:200" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <jsp:invoke fragment="head"/>
</head>

<body>
    <%--<div id="pageheader">--%>
        <%--<jsp:invoke fragment="header"/>--%>
    <%--</div>--%>
    <%--<div id="main">--%>
    <%--<jsp:body>--%>
        <jsp:doBody/>
    <%--</jsp:body>--%>
    <%--</div>--%>
    <jsp:invoke fragment="scripts"/>
</body>
</html>

<%--<%@include file="include/head.jsp" %>--%>

<%--<div class="coming-soon full">--%>
<%--<div class="container">--%>
<%--<h1 class="title">Quaris</h1>--%>

<%--<div class="index-panel">--%>
<%--<c:if test="${_message == 'USER_CREATED'}">--%>
<%--<div class="alert alert-info" role="alert">--%>
<%--User created, you can now logged in.--%>
<%--</div>--%>
<%--</c:if>--%>
<%--<c:if test="${_message == 'USER_LOGGED'}">--%>
<%--<div class="alert alert-success" role="alert">--%>
<%--You are logged in !--%>
<%--</div>--%>
<%--</c:if>--%>
<%--<c:if test="${_message == 'USER_LOGGED_OUT'}">--%>
<%--<div class="alert alert-warning" role="alert">--%>
<%--You are logged out !--%>
<%--</div>--%>
<%--</c:if>--%>

<%--<c:if test="${!isLogged}">--%>
<%--<a href="${pageContext.request.contextPath}/auth/login" class="btn btn-lg btn-primary">Login</a>--%>
<%--<a href="${pageContext.request.contextPath}/auth/register" class="btn btn-lg btn-success">Register</a>--%>
<%--</c:if>--%>

<%--<c:if test="${isLogged}">--%>
<%--<a href="${pageContext.request.contextPath}/admin" class="btn btn-lg btn-primary">Go to administration</a>--%>
<%--<a href="${pageContext.request.contextPath}/auth/logout" class="btn btn-lg btn-secondary">Log out</a>--%>
<%--</c:if>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="copyright">A multi-tier application project by Henrik & Fabien</div>--%>
<%--</div>--%>

<%--<%@include file="include/footer.jsp" %>--%>
