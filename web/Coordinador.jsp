<%-- 
    Document   : Coordinador
    Created on : 23/03/2020, 17:20:11
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<% 
    HttpSession sesion= request.getSession();
    if(sesion.getAttribute("bien") ==null){
     response.sendRedirect("index.jsp");
    }
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Coordinador</title>
     <link link rel=stylesheet href="CSS/estilos.css" type="text/css" MEDIA=screen> 
    </head>
    <body>
        <form id="formdatoscoor1">
           <h2>DATOS PERSONALES:</h2> 
           <h3>Id: ${datos.getId()}</h3> 
           <h3>Nombre: ${datos.getNombre()}</h3> 
           <h3>Apellido: ${datos.getApellido()}</h3> 
           <h3>Correo: ${datos.getCorreo()}</h3> 
           <h3>Proyecto: ${datos.getProyecto()}</h3> 
       
        </form>
       <% String msj = (String) request.getAttribute("estado");
          String mensaje=msj;
                  request.setAttribute("estado", mensaje);
       %>
        <nav>
            <ul>
                <li>
                    <a href="Coordinador?menu=agregar&opcion=mostrar" target="Frame">AGREGAR</a> 
                </li>
                 <li>
                     <a href="AspirantesCoordiVTA.jsp" target="Frame">ASPIRANTES</a>
                </li>
                 <li>
                  <a href="Coordinador?menu=sesion&opcion=cerrar">CERRAR SESION</a>
                </li>
            </ul>
        </nav>
       <iframe name="Frame"></iframe>
       
    </body>
</html>
