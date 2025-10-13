<%-- 
    Document   : clientes
    Created on : 7 oct 2025, 10:33:47 a.m.
    Author     : jesus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://use.fontawesome.com/b027a84dc1.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">        
        <title>Clientes</title>
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>
        
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
        
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/>
        
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>       
    </body>
</html>
