<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="POST">
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
        <tr>
            <td><a href="/register">Register</a></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>