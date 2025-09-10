<%-- 
    Document   : reporteExcel
    Created on : 9 sep 2025, 10:26:08 a.m.
    Author     : jesus
--%>

<%@page errorPage="/WEB-INF/ManejoErrores.jsp" %>
<%@page import="utileria.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel;charset=UTF-8"%>
<%
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename="+nombreArchivo);
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reporte de  Excel</h1>
        <table border="1">
            <<tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>              
            </tr>
            
            <tr>
                <td>1.- Fundamentos de Java</td>
                <td>Sintaxis basica</td>
                <td><% Conversiones.formato(new Date()); %></td>                
            </tr>

            <tr>
                <td>2.- Programacion en Java</td>
                <td>Practica conceptos POO</td>
                <td><% Conversiones.formato(new Date()); %></td>                
            </tr>
            
        </table>
    </body>
</html>
