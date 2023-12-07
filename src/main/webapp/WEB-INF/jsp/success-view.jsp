<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<%@include file="header-view.jsp" %>
<c:forEach items="${requestScope.messages}" var="message">
    <label>${message}</label><br>
</c:forEach>
</body>
</html>