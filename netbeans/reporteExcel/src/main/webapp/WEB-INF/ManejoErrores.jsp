<%-- 
    Document   : ManejoErrores
    Created on : 9 sep 2025, 10:47:40 a.m.
    Author     : jesus
--%>

<%@page isErrorPage="true" %>
<%@page import="java.io.*"  %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores Page</title>
    </head>
    <body>
        <h1>Manejo de Errores</h1>
        <br/>
        <p>Ocurrio una excepcion: <% exception.getMessage();%></p>
        
        <textarea cols="30" rows="5">
            <% exception.printStackTrace( new PrintWriter(out) ); %>
        </textarea>
        
    </body>
</html>
