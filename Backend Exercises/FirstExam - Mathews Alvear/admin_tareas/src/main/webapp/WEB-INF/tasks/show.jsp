<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link rel="stylesheet" href="http://localhost:8080/css/taskShow.css">
            </head>

            <body>
                <main>
                    <h1>Tarea: ${tarea.name} </h1>
                    <h3>Creado por: ${tarea.creator}</h3>
                    <h3>Asignado a : ${tarea.instructor}</h3>
                    <div class="filterRow">
                        <h3> Priroridad: 
                            <c:choose>
                                <c:when test="${tarea.capacity == 1}">Alto</c:when>
                                <c:when test="${tarea.capacity == 2}">Medio</c:when>
                                <c:when test="${tarea.capacity == 3}">Bajo</c:when>
                            </c:choose>
                        </td>
                        </h3>
                    </div>
                    
                    <div>
                        <a href="/courses/${tarea.id}/edit">
                            <button>Editar</button>
                        </a>
                        
                        <form action="/courses/${tarea.id}" method="POST">
                            <input type="hidden" name="_method" value="DELETE">
                            <button>Eliminar</button>
                        </form>    

                        <form action="/courses/${tarea.id}" method="POST">
                            <input type="hidden" name="_method" value="DELETE">
                            <button>Completar</button>
                        </form>    
                        
                    </div>
                </main>
            </body>

            </html>