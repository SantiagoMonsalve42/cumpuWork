<%-- 
    Document   : PerfilCoordiVTA
    Created on : 23/03/2020, 20:10:31
    Author     : Administrador
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    HttpSession sesion= request.getSession();
    if(sesion.getAttribute("bien") ==null){
     response.sendRedirect("index.jsp");
    }else{
%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
     <link link rel=stylesheet href="CSS/estilos.css" type="text/css" MEDIA=screen> 
        <title>JSP Page</title>
    </head>
    <body>
         <form id="formdatoscoor" action="Coordinador?menu=agregar" method="GET">
            <h1>REGISTRAR COORDINADOR</h1>
            <h2>*Ingrese nombre:</h2>
            <input type="text"  name="txt_nombre" placeholder="nombre" required>
            <h2>*Ingrese apellido:</h2>
            <input type="text"  name="txt_apellido" placeholder="apellido" required>
             <h2>*Ingrese proyecto al que pertenece:</h2>
            <input type="text"  name="txt_proyecto" placeholder="proyecto" required>
             <h2>*Ingrese correo:</h2>
            <input type="text"  name="txt_correo" placeholder="correo" required>
            <h2>*Ingrese clave:</h2>
            <input type="password"  name="txt_clave" placeholder="clave" required>
            <input hidden="true" name="menu" value="agregar">
            <br>
        <br><br>
        <input type="submit" name="opcion" value="Registrarse">
          <% String msj = (String) request.getAttribute("estado");
        if(msj!=null){
            if(msj.equalsIgnoreCase("bien")){
               %>
               <h3>El perfil del coordinador se creo correctamente..</h3>
              <% 
            }
            if(msj.equalsIgnoreCase("mal")){
                 %>
               <h3>El perfil del coordinador no se pudo crear..</h3>
              <%  
            }
        }
}
        %>
        </form>
           
    </body>
</html>
