<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle del Artista</title>
</head>
<body>
    <h2>Detalle del Artista</h2>
    
    <p><strong>Nombre:</strong> ${artista.nombre}</p>
    <p><strong>Apellido:</strong> ${artista.apellido}</p>
    <p><strong>Biografia:</strong> ${artista.biografia}</p>

    <h3>Canciones Compuestas</h3>
    <ul>
        <c:forEach var="cancion" items="${artista.canciones}">
            <li>${cancion.titulo}</li>
        </c:forEach>
    </ul>

    <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>