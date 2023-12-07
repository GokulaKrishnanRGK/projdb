<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
</head>
<body>
<form action="/register" method="POST">
    <table>
        <tr>
            <td><label>Email: </label></td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td><label>Firstname: </label></td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td><label>Lastname: </label></td>
            <td><input type="text" name="lastName"/></td>
        </tr>
        <tr>
            <td><label>Profile: </label></td>
            <td><input type="text" name="profile"/></td>
        </tr>
        <tr>
            <td><label>Password: </label></td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td><label>Confirm Password: </label></td>
            <td><input type="text" name="confirmPassword"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Register"/></td>
        </tr>
        <tr>
            <td><a href="/login">Back to login..</a></td>
            <td></td>
        </tr>
    </table>
</form>
<c:forEach var="msg" items="${requestScope.resp.message}">
    <c:out value="${msg}"></c:out>
</c:forEach>
</body>
</html>