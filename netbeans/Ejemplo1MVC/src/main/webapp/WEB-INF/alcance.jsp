<%-- 
    Document   : alcance
    Created on : 6 oct 2025, 11:10:42 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alncance</h1>
        <br/><!-- comment -->
        
        
        <p>Variable: ${mensaje}</p>
        <br/>
        <br/>
        
        <p>Variable de Request</p>
        <p>Base: ${rectanguloRequest.base}</p>
        <p>Altura: ${rectanguloRequest.altura}</p>
        <p>Area: ${rectanguloRequest.area}</p>
        <br/>
        <br/>
        
        
        <p>Variable de Sesion</p>
        <p>Base: ${rectanguloSesion.base}</p>
        <p>Altura: ${rectanguloSesion.altura}</p>
        <p>Area: ${rectanguloSesion.area}</p>
        <br/>
        <br/>
        
        
        <p>Variable de Aplicacion</p>
        <p>Base: ${rectanguloAplicacion.base}</p>
        <p>Altura: ${rectanguloAplicacion.altura}</p>
        <p>Area: ${rectanguloAplicacion.area}</p>
        <br/>
        <br/>

            <a href="${pageContext.request.contextPath}/index.jsp">Ir al inicio</a>
    </body>
</html>
