<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Agregar Artista</title>
</head>
<body>

    <h2>Agregar Artista</h2>

    <form:form method="post" action="/artistas/procesa/agregar" modelAttribute="artista">
        <table>
            <tr>
                <td><form:label path="nombre">Nombre:</form:label></td>
                <td><form:input path="nombre" /></td>
                <td><form:errors path="nombre" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="apellido">Apellido:</form:label></td>
                <td><form:input path="apellido" /></td>
                <td><form:errors path="apellido" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="biografia">Biografía:</form:label></td>
                <td><form:textarea path="biografia" /></td>
                <td><form:errors path="biografia" cssClass="error" /></td>
            </tr>

            <tr>
                <td colspan="3">
                    <input type="submit" value="Guardar" />
                </td>
            </tr>
        </table>
    </form:form>

    <div>
        <a href="/artistas">Volver a lista de artistas</a>
    </div>

</body>
</html>