<%-- 
    Document   : index
    Created on : 20/03/2020, 17:53:51
    Author     : Administrador
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Instituto de extensión</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link link rel=stylesheet href="CSS/estilos.css" type="text/css" MEDIA=screen> 
    </head>
    <body>
       
        <form method="POST" action="LoginYRegistro?accion=Login">
            <div>
             <img src="imagenes/escudo.png">   
             <%
                 String msj = (String) request.getAttribute("mensaje");
                 if(msj!= null){
                     if(msj.equalsIgnoreCase("mallogin")){
                         %>
                         <h4>error en la clave o contraseña..</h4>
                        <%
                     }
                     if(msj.equalsIgnoreCase("maldatos")){
                         %>
                         <h4> error, ingrese los datos...</h4>
                        <%
                     }
                 }
             %>
            <input type="text" class="user" name="txt_correo" placeholder="Ingrese correo"><br><br>
            <input type="password" class="pwd" name="txt_clave" placeholder="ingrese clave"><br><br>
            
            </div>
            <span>
         <a href="Registro.jsp">Registrese</a>
         </span>
            <br/>
            <input type="submit"  value="Iniciar Sesion" name="accion">
        </form>
        
    </body>
</html>
