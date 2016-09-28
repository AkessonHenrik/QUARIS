<%--
  Created by IntelliJ IDEA.
  User: Henrik
  Date: 28.09.2016
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello Fruit</h1>
    ${requestScope.theFruit.name} is ${requestScope.theFruit.color}.
    <h2>Whaddup ${sessionScope.counter}</h2>
</body>
</html>
