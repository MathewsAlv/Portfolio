<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <label for="titulo">Título:</label>
        <form:input path="titulo" id="titulo" />
      <form:errors path="titulo" cssClass="error" />
      <br /><br />

      <label for="artista">Artista:</label>
      <form:select path="artista" id="artista">
        <c:forEach var="artista" items="${listaArtistas}">
          <option value="${artista.id}">${artista.nombre} ${artista.apellido}</option>
        </c:forEach>
      </form:select>
      <form:errors path="artista" cssClass="error" />
      <br /><br />

      <label for="album">Álbum:</label>
      <form:input path="album" id="album" />
      <form:errors path="album" cssClass="error" />
      <br /><br />

      <label for="genero">Género:</label>
      <form:input path="genero" id="genero" />
      <form:errors path="genero" cssClass="error" />
      <br /><br />

      <label for="idioma">Idioma:</label>
      <form:input path="idioma" id="idioma" />
      <form:errors path="idioma" cssClass="error" />
      <br /><br />

      <input type="submit" value="Guardar Canción" />
    </form:form>
    <div>
        <a href="/canciones">Volver a lista de canciones</a>
    </div>


    
</body>
</html>