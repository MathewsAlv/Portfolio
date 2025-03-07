<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*, java.text.*" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Añadir Libro</title>
    </head>
    <body>
        <h2>Añadir libro</h2>
        <form method="POST" action="/libros/procesa/libro" >
            <label for="libroNombre">Nombre del libro:</label>
            <input type="text" id="libroNombre" name="libroNombre" required><br>

            <label for="autorNombre">Autor:</label>
            <input type="text" id="autorNombre" name="autorNombre" required><br>

            <button type="submit">Añadir</button>
        </form>

        <form action="/libros" method="get">
            <input type="submit" value="Volver a la lista de libros" />
        </form>
        
    </body>
    </html>