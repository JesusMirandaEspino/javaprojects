<%-- 
    Document   : getterJsp
    Created on : 3 oct 2025, 11:32:30 a.m.
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
      
               <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
               
                <br/>
                Valor base: <jsp:getProperty name="rectangulo" property="base" />
                <br/>
                Valor altura: <jsp:getProperty name="rectangulo" property="altura" />
                <br/>
                Valor area: <jsp:getProperty name="rectangulo" property="area" />
                <br/>
                <br/>
                
                
                
                
                <p>Expresion Languaje</p>
                
                <span>${pageContext.request.contextPath}</span>
                
                
                
                
                <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
