<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

<a href="/timetable">Back to main menu</a>

<br>

<h1>Add a course</h1>

<form action="/timetable/add-course" method="post" commandName = "course">
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
    <input type="submit" name="Submit" value="Add Course">

</form>

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
