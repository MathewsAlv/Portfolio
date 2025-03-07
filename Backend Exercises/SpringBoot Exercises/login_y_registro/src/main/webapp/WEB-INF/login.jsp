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
        <h1>Login</h1>

        <form:form method="post" action="/procesa/login" modelAttribute="loginUsuario">
        <div>
            <form:label path="usuarioLogin">Nombre de Usuario:</form:label>
            <form:input path="usuarioLogin" />
            <form:errors path="usuarioLogin" cssClass="error" />
        </div>

        <div>
            <form:label path="contraseñaLogin">Contraseña:</form:label>
            <form:password path="contraseñaLogin" />
            <form:errors path="contraseñaLogin" cssClass="error" />
        </div>

        <div>
            <input type="submit" value="iniciar sesion" />
        </div>
        </form:form>
    </body>
    </html>
