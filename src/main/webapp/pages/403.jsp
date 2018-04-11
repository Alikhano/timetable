<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Acess denied</title>
</head>
<body>
<h1>HTTP Status 403 - Access is denied</h1>

<style type="text/css">

    body {
        background-image:url("http://www.saywhatnowproductions.com/wp-content/uploads/2014/09/webplunder-background-image-technology-online-website-solutions.jpg");
    }

    .buttons {
        size: 50px;
        background:#e0ffff}

</style>

<c:choose>
    <c:when test="${empty username}">
        <h2>You do not have permission to access this page!</h2>
    </c:when>
    <c:otherwise>
        <h2>Username : ${username} <br/>
            You do not have permission to access this page!</h2>
    </c:otherwise>
</c:choose>

</body>
</html>