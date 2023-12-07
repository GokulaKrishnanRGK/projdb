<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Classes</title>
</head>
<body>
<%@ include file="header-view.jsp"%>
<table>
    <thead>
    <tr>
        <c:forEach items="${requestScope.tableHeaders}" var="colName">
            <th>${colName}</th>
        </c:forEach>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.classes}" var="row">
        <tr>
            <c:forEach items="${requestScope.colNames}" var="varName">
                <td>${row[varName]}</td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>