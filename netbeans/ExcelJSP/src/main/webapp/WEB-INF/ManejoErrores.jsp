<%-- 
    Document   : ManejoErrores
    Created on : 2 oct 2025, 11:16:09?a.m.
    Author     : jesus
--%>
<%@page isErrorPage="true"  %>"
<%@page import="java.io.*"  %>"


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores</title>
    </head>
    <body>
        <h1>Manejo de Errores</h1>
        <br/><!-- comment -->
        <p>Ocurrio un Error</p>
        <p> <% exception.getMessage(); %> </p>
        <br/>
        <textarea cols="30" rows="10" >
                <% exception.printStackTrace( new PrintWriter(out) );  %>     
        </textarea>

        
    </body>
</html>
