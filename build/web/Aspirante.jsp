<%-- 
    Document   : Aspirante
    Created on : 23/03/2020, 13:58:03
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
        <title>Perfil Aspirante</title>
     <link link rel=stylesheet href="CSS/estilos.css" type="text/css" MEDIA=screen> 
    </head>
    <body>
         <form id="formdatosasp1">
           <h2>DATOS PERSONALES:</h2> 
           <h5>Numero de Documento: ${datos.getNum_documento()} </h5> 
           <h5>Primer Nombre: ${datos.getNombre1()} </h5> 
           <h5>Segundo Nombre: ${datos.getNombre2()}</h5> 
           <h5>Primer Apellido: ${datos.getApellido1()}</h5> 
           <h5>Segundo Apellido: ${datos.getApellido2()}</h5> 
           <h5>Pais de nacimiento: ${datos.getNacionalidad()}</h5> 
           <h5>Telefono fijo: ${datos.getTel_fijo()}</h5> 
           <h5>Telefono movil: ${datos.getTel_movil()}</h5> 
           <h5>Fecha de nacimiento: ${datos.getFecha_nac()} </h5> 
           <h5>Sexo: ${datos.getSexo()}</h5> 
           <h5>Profesion: ${datos.getProfesion()}</h5> 
       
        </form>
         <nav>
            <ul><li>
                  <a href="Aspirante?menu=editar&opcion=Mostrar" target="Frame">EDITAR DATOS PERSONALES</a>
                </li>
                <li>
                  <a href="ArchivosAspiranteVTA.jsp" target="Frame">HOJA DE VIDA Y FORMACION ACADEMICA</a>
                </li>
                 <li>
                 <a href="Aspirante?menu=sesion&opcion=cerrar">CERRAR SESION</a>
                </li>
            </ul>
        </nav>
           
       <iframe name="Frame"></iframe>
    </body>
</html>

