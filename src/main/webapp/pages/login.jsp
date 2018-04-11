<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>

<style type="text/css">

    body {
        background-image:url("http://www.saywhatnowproductions.com/wp-content/uploads/2014/09/webplunder-background-image-technology-online-website-solutions.jpg");
    }

    .buttons {
        size: 50px;
        background:#e0ffff}

</style>

<h1>Login</h1>

<c:if test="${param.error == 'true'}">
    <div style="color:red;margin:10px 0px;">

        Login failed! Please try again<br/>
    </div>
</c:if>

<h3>Enter login and password:</h3>

<form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
    <table>
        <tr>
            <td>Login:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>

</body>
</html>
