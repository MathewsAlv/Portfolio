<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Canciones</title>
    </head>
    <body>
        <h1>Canciones</h1>

        <table>
            <tr>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Detalle</th>
            </tr>

            <c:forEach var="cancion" items="${listaCanciones}">
            <tr>
                <td>${cancion.titulo}</td>
                <td>${cancion.artista != null ? cancion.artista.nombre : 'Sin Artista'} ${cancion.artista.apellido}</td>
                <td><a href="/canciones/detalle/${cancion.id}">Ver Detalle</a></td>
            </tr>
        </c:forEach>
            
        </table>

        <a href="/canciones/formulario/agregar">Agregar Canciones</a>
        <a href="/artistas">Ir a Artistas</a>
        
    </body>
    </html>