<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuestionarios</title>
    </head>
    <body>
        <h1>Cuestionarios</h1>
        
        <a href="../nuevoCuestionario.jsp">Crear nuevo</a>
        
        <c:forEach items="${cuestionarios}" var="cuestionario">
        <li><a href="ver/<c:out value="${cuestionario.id}"/>"><c:out value="${cuestionario.nombre}"/></a></li>
        </c:forEach>
    </body>
</html>
