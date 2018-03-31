<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Schedule</title>
</head>

</head>

<body>

<style type="text/css">
    body {
        background-image:url("http://www.saywhatnowproductions.com/wp-content/uploads/2014/09/webplunder-background-image-technology-online-website-solutions.jpg");
    }

    .buttons {
        background:#e0ffff
    }

</style>

<a href="/">Back to main menu</a>

<br/>

<h1>Schedule</h1>


<form action="/timetable/find-id" method="post" commandName = "listCourse">
    Please enter Group ID: <input type="text" name="groupId" size="35">
    <input type="submit" class="buttons" name="Find by Group ID" value="Find">

</form>

<form action="/timetable/find-weekday" method="post" commandName = "listCourse">
    Please enter weekday:  <select name="weekday">
    <option value="1">Monday</option>
    <option value="2">Tuesday</option>
    <option value="3">Wednesday</option>
    <option value="4">Thursday</option>
    <option value="5">Friday</option></select>
    <input type="submit" class="buttons" name="Find by weekday" value="Find">

</form>

<br/>

<form action="/timetable/find-name" method="post" commandName = "listCourse">
    Please enter the course name:<input type="text" name="name" size="35">
    <input type="submit" class="buttons" name="Find by Course Name" value="Find">
</form>

<br/>

<table border="1" cellspacing="0" bgcolor="#e0ffff">
    <tbody>
    <tr>
        <th align="center" valign="middle" width="80"></th>
        <th align="center" valign="middle" width="100">Monday</th>
        <th align="center" valign="middle">Tuesday</th>
        <th align="center" valign="middle">Wednesday</th>
        <th align="center" valign="middle">Thursday</th>
        <th align="center" valign="middle">Friday</th>
    </tr>

    <c:forEach begin="9" end="18" step="1" var="time">
        <tr>
            <td align="center" valign="middle" width="80">
                <c:choose>
                    <c:when test="${time == 12}">
                        <c:out value="${time}" />:00pm
                    </c:when>
                    <c:when test="${time > 12}">
                        <c:out value="${time - 12}" />:00pm
                    </c:when>
                    <c:otherwise>
                        <c:out value="${time}" />:00am
                    </c:otherwise>
                </c:choose></td>
            <c:if test="${!empty listCourse}">
            <c:forEach begin="1" end="5" step="1" var="day">
                <td align="center" valign="middle" width="150">
                    <c:forEach items="${listCourse}" var="course">
                        <c:if test="${course.startTime <= time
                            && course.endTime > time
                            && course.weekDay == day}">
                            <c:out value="${course.courseName}"/>
                            <br/>
                            <c:out value="${course.groupId}"/>
                        </c:if>
                    </c:forEach>
                </td>
            </c:forEach>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
