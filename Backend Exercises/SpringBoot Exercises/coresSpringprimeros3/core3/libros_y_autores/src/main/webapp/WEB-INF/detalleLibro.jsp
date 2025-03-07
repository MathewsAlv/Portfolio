<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*, java.text.*" %>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Libro especifico</title>
    </head>
    <body>
        <h1>Libros</h1>
        <c:choose> 
            <c:when test="${not empty nombreLibro}">
                <ul>
                    <c:forEach var="libro" items="${nombreLibro}">
                        <p>${libro}, ${autorNombre}</p>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <h3>${mensaje}</h3>
            </c:otherwise>
        </c:choose>   

        <form action="/libros" method="get">
            <input type="submit" value="Volver a la lista de libros" />
        </form>
    </body>
    </html>