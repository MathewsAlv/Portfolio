<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
    </head>
    <body>
        <h1>Registro</h1>

        <form:form method="post" action="/procesa/registro" modelAttribute="usuario">
            <div>
            <form:label path="nombreUsuario">Nombre de Usuario:</form:label>
            <form:input path="nombreUsuario" />
            <form:errors path="nombreUsuario" cssClass="error" />
        </div>

        <div>
            <form:label path="contraseña">Contraseña:</form:label>
            <form:password path="contraseña" />
            <form:errors path="contraseña" cssClass="error" />
        </div>

        <div>
            <form:label path="confirmacionContraseña">Confirmar Contraseña:</form:label>
            <form:password path="confirmacionContraseña" />
            <form:errors path="confirmacionContraseña" cssClass="error" />
        </div>

        <div>
            <form:label path="correo">Correo Electrónico:</form:label>
            <form:input path="correo" />
            <form:errors path="correo" cssClass="error" />
        </div>

        <div>
            <form:label path="nombre">Nombre:</form:label>
            <form:input path="nombre" />
            <form:errors path="nombre" cssClass="error" />
        </div>

        <div>
            <form:label path="apellido">Apellido:</form:label>
            <form:input path="apellido" />
            <form:errors path="apellido" cssClass="error" />
        </div>

        <div>
            <form:label path="fechaDeNacimiento">Fecha de Nacimiento:</form:label>
            <form:input path="fechaDeNacimiento" type="date" />
            <form:errors path="fechaDeNacimiento" cssClass="error" />
        </div>

        <div>
            <input type="submit" value="Registrarse" />
        </div>
        </form:form>
    </body>
    </html>
