<%-- 
    Document   : jsltcore
    Created on : 6 oct 2025, 10:04:47?a.m.
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
        
        <c:set var="nombre" value="Bob" />
        <p>Variable nombre: <c:out value="${nombre}" /> </p>
         <br/>
        <br/>
        
    </body>
</html>
