<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All humans</title>
</head>
<body>
<h2>All humans</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operation</th>
    </tr>

    <c:forEach var="human" items="${allHumans}">

        <c:url var="updateButton" value="/updateHuman">
            <c:param name="humanId" value="${human.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteHuman">
            <c:param name="humanId" value="${human.id}"/>
        </c:url>
        <tr>
            <td>${human.name}</td>
            <td>${human.surname}</td>
            <td>${human.department}</td>
            <td>${human.salary}</td>
            <td>
                <input type="button" value="Update"
                onclick = "window.location.href='${updateButton}'"/>
                <input type="button" value="Delete"
                onclick = "window.location.href='${deleteButton}'"/>
            </td>
        </tr>

    </c:forEach>
</table>
<br>

<input type="button" value="Add" onclick="window.location.href = 'addHuman'"/>
</body>
</html>
