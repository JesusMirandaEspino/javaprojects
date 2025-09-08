<%!
    private String usuario = "Ruperto";
    private int contadorVisitas = 1;

    public String getUsusario(){
    return this.usuario;
    }

%>

<% 
    String nombre = "Bob";
%>



<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo de Expresiones JSPs</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo Expresiones JSPs!</h1>
        <br/>
        <a href="expresiones.jsp" >archivo expresiones JSP</a>
        <br/>
        <h4>Formulario HTML</h4>
        <br/>
        <form name="form1" action="procesaFormulario.jsp">
            Usuario: <input type="text"  name="usuario" />
            <br/>
            Password: <input type="password"  name="Password" />
            <br/>
            Color: <input type="text"  name="color" />
            <br/>
            <input type="submit" value="Enviar"/>
        </form>
        
        <br/>
        <p>Valor del usuario: <%=this.usuario %></p>
        <p>Valor del usuario por funcion: <%=this.getUsusario() %></p>
        <p>Contador: <%=this.contadorVisitas++ %></p>
        <br/>
        <br/>
        <a href="documentoJSP.jspx" >Documento JSPx</a>
    </body>
</html>
