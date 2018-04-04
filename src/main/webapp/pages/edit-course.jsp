<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit course</title>
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

<h1>Update an entry</h1>

Course Name: <c:out value="${course.courseName}"/>
<br>
Group ID: <c:out value="${course.groupId}"/>
<br>
From <c:choose>
    <c:when test="${course.startTime == 12}">
        <c:out value="${course.startTime}" />:00pm
    </c:when>
    <c:when test="${course.startTime > 12}">
        <c:out value="${course.startTime - 12}" />:00pm
    </c:when>
    <c:otherwise>
        <c:out value="${course.startTime}" />:00am
    </c:otherwise>
</c:choose>
to <c:choose>
    <c:when test="${course.endTime == 12}">
        <c:out value="${course.endTime}" />:00pm
    </c:when>
    <c:when test="${course.endTime > 12}">
        <c:out value="${course.endTime - 12}" />:00pm
    </c:when>
    <c:otherwise>
        <c:out value="${course.endTime}" />:00am
    </c:otherwise>
</c:choose>
<br>
Weekday: <c:choose>
    <c:when test="${course.weekDay == 1}">
        Monday
    </c:when>
    <c:when test="${course.weekDay == 2}">
        Tuesday
    </c:when>
    <c:when test="${course.weekDay == 3}">
        Wednesday
    </c:when>
    <c:when test="${course.weekDay == 4}">
        Thursday
    </c:when>
    <c:when test="${course.weekDay == 5}">
        Friday
    </c:when>
</c:choose>
<br>

<form action="/timetable/edit-course" method="post" commandName = "course">
    <input type="hidden" name="id" value="${course.id}" />
    Course Name: <input path ="courseName" type="text" name="courseName" size="35">
    <br>
    Course Time:
    Mon<input path="weekDay" type="checkbox" name="weekDay" value="1">
    Tue<input path="weekDay" type="checkbox" name="weekDay" value="2">
    Wed<input path="weekDay"  type="checkbox" name="weekDay" value="3">
    Thu<input path="weekDay"  type="checkbox" name="weekDay" value="4">
    Fri<input path="weekDay"  type="checkbox" name="weekDay" value="5">
    Sat<input path="weekDay"  type="checkbox" name="weekDay" value="6">
    Sun<input path="weekDay"  type="checkbox" name="weekDay" value="7">
    from
    <select path="startTime" name="startTime">
        <option value="9">9:00am</option>
        <option value="10">10:00am</option>
        <option value="11">11:00am</option>
        <option value="12">12:00pm</option>
        <option value="13">1:00pm</option>
        <option value="14">2:00pm</option>
        <option value="15">3:00pm</option>
        <option value="16">4:00pm</option>
        <option value="17">5:00pm</option>
        <option value="18">6:00pm</option>
        <option value="19">7:00pm</option>
    </select>
    to
    <select path="endTime" name="endTime">
        <option value="9">9:00am</option>
        <option value="10">10:00am</option>
        <option value="11">11:00am</option>
        <option value="12">12:00pm</option>
        <option value="13">1:00pm</option>
        <option value="14">2:00pm</option>
        <option value="15">3:00pm</option>
        <option value="16">4:00pm</option>
        <option value="17">5:00pm</option>
        <option value="18">6:00pm</option>
        <option value="19">7:00pm</option>
    </select>
    Groupd ID <input path ="groupId" type="text" name="groupId" size="35">
    <br>
    <br>
    <input type="submit" class="buttons" name="Submit" value="Update Course">
</form>
</body>
</html>