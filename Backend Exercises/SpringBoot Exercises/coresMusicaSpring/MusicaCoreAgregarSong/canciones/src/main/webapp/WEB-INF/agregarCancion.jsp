<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Cancion</title>
</head>
<body>
    <h2>Agregar Nueva Canción</h2>
    <form:form method="post" action="/canciones/procesa/agregar" modelAttribute="cancion">
        <table>
            <tr>
                <td><form:label path="titulo">Título:</form:label></td>
                <td><form:input path="titulo" /></td>
                <td><form:errors path="titulo"/></td>
            </tr>
            <tr>
                <td><form:label path="artista">Artista:</form:label></td>
                <td><form:input path="artista" /></td>
                <td><form:errors path="artista" /></td>
            </tr>
            <tr>
                <td><form:label path="album">Álbum:</form:label></td>
                <td><form:input path="album" /></td>
                <td><form:errors path="album" /></td>
            </tr>
            <tr>
                <td><form:label path="genero">Género:</form:label></td>
                <td><form:input path="genero" /></td>
                <td><form:errors path="genero" /></td>
            </tr>
            <tr>
                <td><form:label path="idioma">Idioma:</form:label></td>
                <td><form:input path="idioma" /></td>
                <td><form:errors path="idioma" /></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Agregar Canción" />
                </td>
            </tr>
        </table>

    </form:form>
    <div>
        <a href="/canciones">Volver a lista de canciones</a>
    </div>


    
</body>
</html>