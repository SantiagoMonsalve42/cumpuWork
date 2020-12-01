<%-- 
    Document   : ArchivosAspiranteVTA
    Created on : 23/03/2020, 20:13:34
    Author     : Administrador
--%>

<%@page import="modelo.dto.FormacionAspiranteDTO"%>
<%@page import="modelo.dto.SesionDTO"%>
<%@page import="modelo.dto.AspiranteDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="controlador.facade"%>
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
      <link link rel=stylesheet href="CSS/estilos.css" type="text/css" MEDIA=screen> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="formhojadevida">
           <%
           facade fac=new facade();
           List<AspiranteDTO> lista=fac.listarAspirantes();
           FormacionAspiranteDTO forma= new FormacionAspiranteDTO();
           SesionDTO objs;
           objs=(SesionDTO) sesion.getAttribute("bien");
           for(int i=0;i<lista.size();i++){
               if(objs.getCorreo().equalsIgnoreCase(lista.get(i).getCorreo())){
                   forma.setId_aspirante(lista.get(i).getId());
               }
           }
           
           forma=fac.leerFormacion(forma);
           if(forma != null){
             %>
           <h2>DATOS ACADEMICOS: </h2> 
           <h3>Formacion Academica: <%if(forma.getFormacion_academica()!=null){ out.print(forma.getFormacion_academica());}  %> </h3> 
           <h3>Titulo 1: <% if(forma.getTitulo1()!=null){out.print(forma.getTitulo1());}%></h3> 
           <h3>Titulo 2:<%if(forma.getTitulo2() !=null){out.print(forma.getTitulo2());}%> </h3> 
           <h3>Descripcion Perfil: <%if(forma.getDescripcion_perfil()!=null){out.print(forma.getDescripcion_perfil());}%></h3> 
            <%
           }
           %> 

        </form>
        <form id="formpdf" method="post" action="CargarPdfs?accion=Subir" enctype="multipart/form-data">
           
        <h2>INGRESE HOJA DE VIDA(PDF): </h2>
        <h5>SUBA AQUI SU PDF</h5>
        <input type="file" accept="application/pdf" name="hoja_de_vida">
         <br> <br>
         <input type="submit" value="Subir">
        <br>
        <%
           String nombrepdf=null;
           int act=0;
           List<FormacionAspiranteDTO> listafor=fac.listarFormaciones();
           if(listafor.size()>0){
               for(int i=0;i<listafor.size();i++){
                   if(listafor.get(i).getId_aspirante() == forma.getId_aspirante()){
                       String nombreaux=listafor.get(i).getHoja();
                       if(nombreaux.equals("")!=true){
                       nombrepdf=nombreaux;
                       act=1;
                       }
                   }
               }
           }
          if(act==1){
             %>
             <a HREF="pdfs<%out.println(nombrepdf);%>">Vea aqui su hoja de vida..</a>
         <% 
          }
        %>
         <br>
           <% String msj = (String) request.getAttribute("estado");
              if(msj!=null){
            if(msj.equalsIgnoreCase("bien")){
               %>
               <h4>Se ha creado o editado la hoja de vida correctamente</h4>
               <%
                  }
             if(msj.equalsIgnoreCase("mal")){
               %>
               <h4>No se pudo registrar o editar la hoja de vida</h4>
               <h6>Si va a editar el archivo subido anteriormente no puede ser el mismo que el va a subir ni puede tener el mismo nombre, ademas primero ingrese sus datos de formacion academica</h6>
               <%
                  }
                }

               %>
        </form>
        <form id="formpdf" method="post" action="CargarPdfs?accion=SubirF" enctype="multipart/form-data">
           
        <h2>INGRESE FOTO DE PERFIL(jpg/pgn): </h2>
        <h5>SUBA AQUI SU FOTO</h5>
        <input type="file" accept="image/*" name="foto">
         <br> <br>
         <input type="submit" value="Subir">
        <br>
        <%
           String nombrefoto=null;
           int act1=0;
           List<FormacionAspiranteDTO> listafor1=fac.listarFormaciones();
           if(listafor.size()>0){
               for(int i=0;i<listafor1.size();i++){
                   if(listafor1.get(i).getId_aspirante() == forma.getId_aspirante()){
                       String nombreaux=listafor1.get(i).getFoto();
                       if(nombreaux.equals("")!=true){
                       nombrefoto=nombreaux;
                       act1=1;
                       }
                   }
               }
           }
          if(act1==1){
             %>
             <a HREF="perfiles<%out.println(nombrefoto);%>" download="FotoPerfil">Descargue y vea aqui su foto de perfil..</a>
         <% 
          }
        %>
         <br>
           <% String msj1 = (String) request.getAttribute("estado1");
              if(msj1!=null){
            if(msj1.equalsIgnoreCase("bien")){
               %>
               <h4>Se ha creado o editado la foto de perfil correctamente</h4>
               <%
                  }
             if(msj1.equalsIgnoreCase("mal")){
               %>
               <h4>No se pudo registrar o editar la foto de perfil</h4>
               <h6>Si va a editar el archivo subido anteriormente no puede ser el mismo que el va a subir ni puede tener el mismo nombre, ademas primero ingrese sus datos de formacion academica</h6>
               <%
                  }
                }
}

               %>
        </form>
    </body>
</html>
