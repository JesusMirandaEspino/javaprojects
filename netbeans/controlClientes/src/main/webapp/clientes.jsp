<%-- 
    Document   : clientes
    Created on : 12 sep 2025, 10:08:21 a.m.
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
        <title>Control de clientes</title>
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp" />

        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp" />
        
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp" />
        
        <jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp" />
        
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp" />
        
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>    
    </body>
</html>
