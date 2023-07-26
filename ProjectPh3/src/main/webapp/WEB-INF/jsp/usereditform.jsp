
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
</head>
<body>
    <h1>Enter User ID:</h1>
    <form action="getuser" method="post">
        <input type="text" name="uid" />
        <input type="submit" value="Get Details" />
    </form>

    <c:if test="${not empty user}">
        <h2>User Information</h2>
        <table border="1">
            <tr>
                <th>User ID</th>
                <th>Username</th>
                <th>Email</th>
            </tr>
            <tr>
                <td>${user.uid}</td>
                <td>${user.uname}</td>
                <td>${user.email}</td>
                <td><a href="edituser/${user.uid}">Edit</a></td>
            </tr>
        </table>
    </c:if>

    <c:if test="${not empty error}">
        <h2>Error</h2>
        <p>${error}</p>
    </c:if>
</body>
</html>
