<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuestionarios</title>
    </head>
    <body>
        <h1>Ver Cuestionario</h1>
            <h2><c:out value="${cuestionario.nombre}"/></h2>
            <table>
            <c:forEach items="${preguntas}" var="pregunta">
                <tr>
                    <td><c:out value="${pregunta.num}"/></td>
                    <td><c:out value="${pregunta.texto}"/></td>
                </tr>
            </c:forEach>
            </table>
    </body>
</html>
