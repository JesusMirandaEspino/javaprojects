<%-- 
    Document   : getterJSP
    Created on : 10 sep 2025, 11:13:30 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Obtener</title>
    </head>
    <body>
        <h1>JSP Obtener</h1>
        
        <jsp:useBean id="Rectangulo" class="beans.Rectangulo" scope="session" />
        
        <br/>
        <span>Valor base: <jsp:getProperty name="Rectangulo" property="base"/></span>
        <br/>
        <span>Valor Altura <jsp:getProperty name="Rectangulo" property="altura"/></span>        
        <br/>
        <span>Valor Area <jsp:getProperty name="Rectangulo" property="area"/></span> 
        <br/>
        
        <p>Expresiones implicias</p>
        <span>Nombre de la aplicacion: ${pageContext.request.contextPath}</span>
        <br/>
        <span>Nombre de usuario: ${header["User-Agent"]}</span>
        <br/>
        <span>Id session: ${cookie.JSESSIONID.value}</span>
        <br/>
        <span>Web Server: ${pageContext.servletContext.serverInfo}</span>
        <br/>
        <span>Parametro: ${param.usuario}</span>
        <br/>
        <a href="index.jsp">Regresar</a>
    </body>
</html>
