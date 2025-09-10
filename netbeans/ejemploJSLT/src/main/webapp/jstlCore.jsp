<%-- 
    Document   : jstlCore
    Created on : 10 sep 2025, 12:03:24?p.m.
    Author     : jesus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core</h1>
        <br/>
        <h2>Manipulacion de variables</h2>
        <c:set var="nombre" value="bob" />
        <p>Nombre: <c:out value="${nombre}" /> </p>
                
        <c:out value="<h4>Hola</h4>" escapeXml="false" />
        <c:set var="bandera" value="true" />
        
        <c:if test="${bandera}" >
            <p> La bandera es verdadera </p>
        </c:if>
            
            
        <c:if test="${param.opcion != 1}">
            <c:choose>
                <c:when test="${param.opcion == 1}" >
                    <p>Opcion 1 seleccionada</p>
                </c:when>
                <c:when test="${param.opcion == 2}" >
                    <p>Opcion 2 seleccionada</p>
                </c:when>
                <c:otherwise >
                    <p>Opcion desconocida</p>
                </c:otherwise>
            </c:choose>
                
        </c:if>    
            
        
    </body>
</html>
