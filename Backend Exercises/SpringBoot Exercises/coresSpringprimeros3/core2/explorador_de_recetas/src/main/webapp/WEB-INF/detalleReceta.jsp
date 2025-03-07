<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="http://localhost:8080/css/style.css">
    <title>Document</title>
</head>
<body>
    <h1>Recetas Detalladas</h1>
    <c:choose>
        <c:when test="${not empty nombreReceta}">
            <h2>${nombre} tiene los siguientes ingredientes</h2>
            <ul>
                <c:forEach var="ingrediente" items="${ingredientes}">
                    <li>${ingrediente}</li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
                <h3>${mensaje}</h3>
        </c:otherwise>
    </c:choose>
    
</body>
</html>