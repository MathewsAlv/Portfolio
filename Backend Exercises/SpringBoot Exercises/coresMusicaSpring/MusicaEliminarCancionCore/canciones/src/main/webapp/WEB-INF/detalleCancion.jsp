<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*, java.text.*" %>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <body>
        <h1>Detalle de la Cancion ${cancion.titulo}</h1>

        <p><strong>Titulo:</strong> ${cancion.titulo}</p>
        <p><strong>Artista:</strong> ${cancion.artista.nombre} ${cancion.artista.apellido}</p>
        <p><strong>Album:</strong> ${cancion.album}</p>
        <p><strong>Genero:</strong> ${cancion.genero}</p>
        <p><strong>Idioma:</strong> ${cancion.idioma}</p>

        <a href="/canciones">Volver a lista de canciones</a>

        <a href="/canciones/formulario/editar/${idCancion}">Editar Song</a>

        <form action="/canciones/eliminar/${idCancion}" method="POST">
            <input type="hidden" name="_method" value="DELETE">
            <button>Eliminar Cancion</button>
        </form>
        
    </body>
    </html>