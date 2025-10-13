<%-- 
    Document   : index
    Created on : 6 oct 2025, 10:49:09 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC</h1>
        <br/><!-- comment -->
        
        
        <p>${mensaje}</p>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/servletControlador">Ir al controlador sin parametros</a>
        
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/servletControlador?accion=agregar">Ir al controlador con parametros</a>
        
        
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/servletControlador?accion=listar">Ir al controlador listar</a>
        
        
    </body>
</html>
