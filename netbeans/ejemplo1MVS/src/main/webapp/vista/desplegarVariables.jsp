<%-- 
    Document   : desplegarVariables
    Created on : 11 sep 2025, 8:43:34 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de variables</title>
    </head>
    <body>
        <h1>Despliegue de variables</h1>
        <br/>
        <span>Variable en alcance request: ${mensaje}</span>
        <br/>
        <span>Variable de alcance session:   </span>
        <br/>
        <span>Base: ${rectangulo.base}   </span>
        <br/>
        <span>Altura: ${rectangulo.altura}  </span>
    </body>
</html>
