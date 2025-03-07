<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link rel="stylesheet" href="http://localhost:8080/css/taskEdit.css">
            </head>

            <body>

                <main>
                    <section>
                        <h1>Editar ${tarea.name}</h1>
                        <form:form action="/courses/${tarea.id}/edit/process" method="post" modelAttribute="tarea">
                            <div>
                                <form:label path="name">Tarea: </form:label>
                                <form:input path="name" type="text" />
                                <form:errors path="name" />
                            </div>
                            </div>
                                <form:hidden path="creator" value="${currentUser.name}" />
                                <form:errors path="creator" />
                            </div>
                            <div>
                                <form:label path="instructor">Assignee:</form:label>
                                <form:select path="instructor">
                                    <form:option value="" label=" Seleccionar persona " />
                                    <c:forEach items="${listaUser}" var="listaUser">
                                        <form:option value="${listaUser.name}" label="${listaUser.name}" />
                                    </c:forEach>
                                </form:select>
                                <form:errors path="instructor" />

                            </div>
                            </div>
                            <div>
                                <form:label path="capacity">Prioridad:</form:label>
                                <form:select path="capacity">
                                    <form:option value="1">Alto</form:option>
                                    <form:option value="2">Medio</form:option>
                                    <form:option value="3">Bajo</form:option>
                                </form:select>
                                <form:errors path="capacity" />
                            </div>

                            <button type="submit">Editar</button>
                        </form:form>
                    </section>
                </main>
            </body>

            </html>