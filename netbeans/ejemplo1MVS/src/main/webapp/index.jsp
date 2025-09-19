<%-- 
    Document   : index
    Created on : 11 sep 2025, 8:39:40?a.m.
    Author     : jesus
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC</title>
    </head>
    <body>
        <h1>Ejemplo MVC</h1>
        <br/>
        <p>${mensaje}</p>
        
        
        <a href="${pageContext.request.contextPath}/ServletControlador" >Entrar sin parametros</a>
        <br/>     
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables" >Entrar agregar variables</a>
        <br/>     
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables" >Entrar con variables</a>
        <br/>     
        <br/>
        
    </body>
</html>
