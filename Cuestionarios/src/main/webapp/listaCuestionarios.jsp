<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cuestionarios</h1>
        <c:forEach items="${cuestionarios}" var="cuestionario">
        <li><c:out value="${cuestionario.nombre}"/></li>
        </c:forEach>
    </body>
</html>
