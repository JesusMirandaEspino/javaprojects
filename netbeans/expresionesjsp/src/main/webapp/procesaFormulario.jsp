<%-- 
    Document   : procesaFormulario
    Created on : 8 sep 2025, 10:21:27 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Formulario</title>
        
        
        
        <% 
            String color = request.getParameter("color");
            if( color == null || color.trim().equals("") ){
            color = "white";
            }
        %>
        
    </head>
    <body bgcolor="<%=color%>">

        
        <h1>Procesar Formulario</h1>
        Usuario: <%= request.getParameter("usuario") %>
        <br/>
        Password: <%= request.getParameter("password") %>
        <br/>
        <br/>
        <h2>Scriplest</h2>
        Color de fondo aplicado: <%=color%>
        <br/><br/>
        <a href="index.html">Regresar<a/>
            
                    
    </body>
</html>
