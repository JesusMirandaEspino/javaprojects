<%-- 
    Document   : expresiones
    Created on : 8 sep 2025, 10:12:50 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Con expresiones</title>
    </head>
    <body>
        <h1>JSP Con expresiones</h1>
        <br/>
        Concatenacion: <%="saludos" + " " + "Desde un jsp" %>
        <br/>
        Operacion Matematica: <%=2 * 3 / 3 %>
        <br/>
        Id de la sesion: <%=session.getId()%>
        
        <br/>
        <h2>Scriplest</h2>
        <% out.println("Saludos desde un Scriptlet");  %>
        <br/><br/>
       <% String nombreAplicacion = request.getContextPath();  %>
       <% out.println("Nombre de la aplicacion: " + nombreAplicacion);  %>
        <br/><br/>
       <% 
            if( session != null && session.isNew()){
       %>
            Le session si es nueva
       <% 
           }
       %>
       <% 
           else{
       %>
        La session no es nueva
       <% 
           }
       %>
        <br/><br/>
    </body>
</html>
