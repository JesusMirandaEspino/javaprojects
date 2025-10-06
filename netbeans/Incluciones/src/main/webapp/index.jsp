<%-- 
    Document   : index
    Created on : 3 oct 2025, 10:47:35 a.m.
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
    <body>
        <h1>Ejemplo Inclusion Estatica</h1>
        <br/>
        <ul>
            <li> <%@include file="paginas/noticias1.html"  %> </li>
            <li> <%@include file="paginas/noticias2.jsp"  %> </li>
        </ul>
        
        <br/>
        <br/>
                <h2>Ejemplo Inclusion Dinamica</h2>
                    <br/>
                    <jsp:include page="paginas/recursoPublico.jsp" />
                    <br/>
                    <jsp:include page="WEB-INF/recursoPrivado.jsp">
                        <jsp:param name="colorFondo" value="yellow"/>
                    </jsp:include>
    </body>
    </body>
</html>
