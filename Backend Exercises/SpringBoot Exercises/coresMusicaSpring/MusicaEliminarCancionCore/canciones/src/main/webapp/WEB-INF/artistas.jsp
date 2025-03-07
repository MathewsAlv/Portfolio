<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Artistas</title>
</head>
<body>
    <h2>Lista de Artistas</h2>
    <ul>
        <c:forEach var="artista" items="${listaArtista}">
            <li>
                <a href="/artistas/detalle/${artista.id}">
                    ${artista.nombre} ${artista.apellido}
                </a>
            </li>
        </c:forEach>
    </ul>


    <a href="/canciones">Ir a canciones</a>
    <a href="/artistas/formulario/agregar"">Agregar artista</a>
</body>
</html>