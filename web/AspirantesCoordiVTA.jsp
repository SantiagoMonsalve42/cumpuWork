<%-- 
    Document   : AspirantesCoordiVTA
    Created on : 23/03/2020, 20:11:43
    Author     : Administrador
--%>

<%@page import="modelo.dto.FormacionAspiranteDTO"%>
<%@page import="modelo.dto.AspiranteDTO"%>
<%@page import="java.util.List"%>
<%@page import="controlador.facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
     <link link rel=stylesheet href="CSS/estilos.css" type="text/css" MEDIA=screen> 
        <title>JSP Page</title>
    </head>
    <body>
        <form id="formdatosasp" action="Coordinador" method="post">
        <input type="submit" name="op" value="Actualizar">
       <%
       facade fac=new facade();
       List<AspiranteDTO> aspirantes=fac.listarAspirantes();
       List<FormacionAspiranteDTO> estudios=fac.listarFormaciones();
       String nombrepdf;
       String nombrefoto;
       if(aspirantes.size()>0 || estudios.size()>0){
           if(aspirantes.size()>0){
               for(int i=0;i<aspirantes.size();i++){
                   int pos=i+1;
                   out.println("<h2> Datos Aspirante "+pos+":</h2>");
                   out.println("<h4> Nombre Completo:"+aspirantes.get(i).getNombre1()+" "+aspirantes.get(i).getNombre2()+" "+aspirantes.get(i).getApellido1()+" "+aspirantes.get(i).getApellido2()+"</h4>");
                   out.println("<h4> Sexo: "+aspirantes.get(i).getSexo()+"Telefono fijo:"+aspirantes.get(i).getTel_fijo()+"   Tel movil: "+aspirantes.get(i).getTel_movil()+"</h4>");
                   out.println("<h4> Pais de nacimiento: "+aspirantes.get(i).getNacionalidad()+"  Ciudad: de residencia: "+aspirantes.get(i).getCiudad()+"</h4>");
                   out.println("<h4> Numero de documento: "+aspirantes.get(i).getNum_documento()+" Profesion: "+aspirantes.get(i).getProfesion()+" </h4>");
                  
                   if(estudios.size()>0){
                       for(int j=0;j<estudios.size();j++){
                           if(estudios.get(j).getId_aspirante() == aspirantes.get(i).getId()){
                            out.println("<h4> Formacion academica: "+estudios.get(j).getFormacion_academica()+"</h4>");
                            out.println("<h4> Titulo 1: "+estudios.get(j).getTitulo1()+"   Titulo 2: "+estudios.get(j).getTitulo2()+"</h4>");
                            out.println("<h4> Descripcion del perfil: "+estudios.get(j).getDescripcion_perfil()+"</h4>");
                            nombrepdf=estudios.get(j).getHoja();
                            nombrefoto=estudios.get(j).getFoto();
                            out.println("<h4>Foto de Perfil: <h4>");
                            if(nombrefoto!=null){
                                %>
                               <img id="fotoperfil" src="perfiles<%out.println(nombrefoto);%>">
                                <%
                            }
                            if(nombrepdf!=null){
                                %>  
                                <a HREF="pdfs<%out.println(nombrepdf);%>">Vea aqui la hoja de vida del aspirante..</a><br>
                                <%
                            }
                            
                           }
                       }
                   }
                       %>
                       <br><br>
                                <%
               }
           }
       }
       %>
        </form>
    </body>
</html>
