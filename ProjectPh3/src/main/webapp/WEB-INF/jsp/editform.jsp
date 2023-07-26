<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit User Information</h1>
	<form:form method="post" action="../editsave" modelAttribute="user">
<form:hidden path="uid" />
		<br>
Name: <form:input path="uname" />
		<br>
Email: <form:input path="email" />
		<br>
		<input type="submit" value="Save changes">
	</form:form>
</body>
</html>