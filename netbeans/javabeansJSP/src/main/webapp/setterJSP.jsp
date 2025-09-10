<%-- 
    Document   : setterJSP
    Created on : 10 sep 2025, 11:13:18 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Modificar</title>
    </head>
    <body>
        <h1>JSP Modificar</h1>
        <br/>
        <jsp:useBean id="Rectangulo" class="beans.Rectangulo" scope="session" />
        <p>Modificamos los atributos</p>
        <br/>
        
        <% 
            int baseValor = 5;
            int alturaValor = 10;
        %>
        
        
        <jsp:setProperty name="Rectangulo" property="base" value="<%=baseValor%>" />
        <jsp:setProperty name="Rectangulo" property="altura" value="<%=alturaValor%>" />
        
        
        <span>Nuevo valor Base: <%=baseValor%></span>
        <br/>
        <span>Nuevo valor Altura: <%=alturaValor%></span>
        <br/>
        <a href="index.jsp">Regresar</a>
    </body>
</html>
