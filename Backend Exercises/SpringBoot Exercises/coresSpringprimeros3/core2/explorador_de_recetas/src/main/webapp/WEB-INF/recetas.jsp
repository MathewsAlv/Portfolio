<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*, java.text.*" %>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="http://localhost:8080/css/style.css">
            <title>Recetas</title>
        </head>
        <body>
            <h1>Recetas</h1>
            <ul>
                <c:forEach var="receta" items="${listaRecetas}">
                    <li>${receta}</li>
                </c:forEach>
            </ul>
    </body>
    </html>