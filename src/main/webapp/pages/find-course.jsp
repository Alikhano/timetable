<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Find a course</title>
</head>

</head>

<body>

<style type="text/css">
    body {
        background-image:url("http://www.saywhatnowproductions.com/wp-content/uploads/2014/09/webplunder-background-image-technology-online-website-solutions.jpg");
    }

</style>

<a href="/timetable">Back to timetable</a>

<br>

<table border="1" cellspacing="0">
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
            <TD align="center" valign="middle" width="80">
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
                </c:choose></TD>
            <c:if test="${!empty listCourse}">
                <c:forEach begin="1" end="5" step="1" var="day">
                    <td align="center" valign="middle" width="100">
                        <c:forEach items="${listCourse}" var="course">
                            <c:if test="${course.startTime <= time
                            && course.endTime > time
                            && course.weekDay == day}">
                                <c:out value="${course.courseName}"/>
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
