<%-- 
    Document   : desplegar
    Created on : 6 oct 2025, 10:46:46 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Desplegar</title>
    </head>
    <body>
        <h1>Desplegar</h1>
        <br/><!-- comment -->
        
        
        <p>Variable: ${mensaje}</p>
        <br/>
        <br/>
        
        <p>Variable de session</p>
        <p>Base: ${rectangulo.base}</p>
        <p>Altura: ${rectangulo.altura}</p>
        <p>Area: ${rectangulo.area}</p>
        <br/>
        <br/>

            <a href="${pageContext.request.contextPath}/index.jsp">Ir al inicio</a>
        
    </body>
</html>
