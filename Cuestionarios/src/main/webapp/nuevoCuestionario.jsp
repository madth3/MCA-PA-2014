<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuestionarios</title>
    </head>
    <body>
        <h1>Nuevo Cuestionario</h1>
        <springform:form action="cuestionarios/nuevo" method="POST" 
                         commandName="cuestionario" id="forma">
            <label>Nombre</label>
            <input type="text" size="30" name="nombre"/>
            <label>Reactivos</label>
            <input type="text" size="5" name="numeroReactivos"/>
            <input type="submit"/>
        </springform:form>
    </body>
</html>
