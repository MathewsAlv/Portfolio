<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link rel="stylesheet" href="http://localhost:8080/css/taskIndex.css">

            </head>

            <body>
                <main>
                    <h1>Bienvenido, ${currentUser.name} </h1>
                    <div class="filterRow">
                        <div class="mainButtons">
                            <a href=""><button>Low Sign Up</button></a>
                            <a href=""><button>High Sign Up</button></a>
                            <br></br>
                            <form action="/session/logout" method="POST">
                                <button type="submit">Logout</button>
                            </form>
                        </div>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <th>Tareas</th>
                                <th>Creador</th>
                                <th>Asignado a</th>
                                <th>Prioridad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${tareas}" var="tarea">
                                <tr>
                                    <td> <a href="/courses/${tarea.id}">${tarea.name}</a> </td>
                                    <td>${tarea.creator}</td>
                                    <td>${tarea.instructor}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${tarea.capacity == 1}">Alto</c:when>
                                            <c:when test="${tarea.capacity == 2}">Medio</c:when>
                                            <c:when test="${tarea.capacity == 3}">Bajo</c:when>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="/courses/new">
                        <button>Crear Tarea</button>
                    </a>
                </main>
            </body>

            </html>