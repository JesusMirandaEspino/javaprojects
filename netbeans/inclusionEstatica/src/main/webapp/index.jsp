<%-- 
    Document   : index
    Created on : 9 sep 2025, 12:18:25?p.m.
    Author     : jesus
--%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de Inclusion Estatica</title>
    </head>
    <body>
        <h1>Ejemplo de Inclusion Estatica</h1>
        <br/>
        <ul>
            <li><%@include file="paginas/noticias1.html"  %></li>
            <li><%@include file="paginas/noticias2.html"  %></li>
        </ul>

        <br/>
        <h2>Ejemplo de Inclusion Dinamica</h2>
        <jsp:include page="paginas/recursoPublic.jsp"/>
        
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="color" value="yellow" />
        </jsp:include>
    </body>
</html>
