<%-- 
    Document   : alcanceVariables
    Created on : 11 sep 2025, 9:26:53 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance Variables</title>
    </head>
    <body>
        <h1>Alcance Variables</h1>
        <br/>
        <br/>
        <span>Variable de alcance request:   </span>
        <br/>
        <span>Base: ${rectanguloRequest.base}   </span>
        <br/>
        <span>Altura: ${rectanguloRequest.altura}  </span>


        <br/>
        <br/>
        <span>Variable de alcance Sesion   </span>
        <br/>
        <span>Base: ${rectanguloSesion.base}   </span>
        <br/>
        <span>Altura: ${rectanguloSesion.altura}  </span>
        
        <br/>
        <br/>
        <span>Variable de alcance Applicacion   </span>
        <br/>
        <span>Base: ${rectanguloApplication.base}   </span>
        <br/>
        <span>Altura: ${rectanguloApplication.altura}  </span> 
        
    </body>
</html>
