<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*, java.text.*" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Libros</title>
    </head>
    <body>
        <h1>Libros</h1>
        <ul>
            <c:forEach var="libros" items="${listaLibros}">
                <li> <a href="/libros/${libros}">${libros}</a> </li>
            </c:forEach>
        </ul>

        <form action="/libros/formulario" method="get">
            <input type="submit" value="Agregar Libro" />
        </form>

    </body>
    </html>