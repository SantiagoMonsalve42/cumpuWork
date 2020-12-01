<%-- 
    Document   : PerfilAspiranteVTA
    Created on : 23/03/2020, 20:13:08
    Author     : Administrador
--%>

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
        <form id="formeditasp" method="GET">
            <h1>EDITAR TELEFONOS DE CONTACTO</h1>
            <h2>*Ingrese nuevo telefono fijo:</h2>
            <input type="number" min="1000000" max="9999999" name="txt_telfijo" placeholder="telefono fijo" required>
            <h2>*Ingrese nuevo telefono movil:</h2>
            <input type="number" min="300000000" max="399999999" name="txt_telmovil" placeholder="telefono movil" required>
            <input hidden="true" name="menu" value="editar">
            <br>
            <br>
            <% String estado=(String) request.getAttribute("estado");
            if(estado!=null){
                if(estado.equalsIgnoreCase("bien")){
                    %>
                    <h4>Se ha editado correctamente, actualice para ver cambios..</h4>
                <%
                }
                if(estado.equalsIgnoreCase("mal")){
                    %>
                    <h4>Error en los datos ingresados...</h4>
                <% 
                
                }
               }
            %>
            
        <input type="submit" name="opcion" value="Editar">
       
        </form>
            
       <form id="formarchivos" name="archivos" action="Aspirante" method="POST">
            <h1>INGRESE DATOS ACADEMICOS:</h1>
             <h2>INGRESE FORMACION ACADEMICA: </h2>
             <select name="txt_formacion" required>
               <option value="Ninguna" id="ZM">Ninguna</option>
               <option value="Basica" id="ZW">Basica</option>
               <option value="Basica Media" id="ZW">Basica Media</option>
               <option value="Bachiller" id="ZW">Bachiller</option>
               <option value="Tecnico" id="ZW">Tecnico</option>
               <option value="Tecnologo" id="ZW">Tecnologo</option>
               <option value="Tecnologo especializado" id="ZW">Tecnologo especializado</option>
               <option value="Profesional" id="ZW">Profesional</option>
               <option value="Profesional especializado" id="ZW">Profesional especializado</option>
               <option value="Magister" id="ZW">Magister</option>
               <option value="Doctorado" id="ZW">Doctorado</option>
               <option value="Post Doctorado" id="ZW">Post Doctorado</option>
               
             </select> 
             <h2>INGRESE TITULO 1: </h2>
            <input type="text"  name="txt_titulo1" placeholder="titulo1" required>
            <h2>INGRESE TITULO 2: </h2>
            <input type="text"  name="txt_titulo2" placeholder="titulo2" required>
            <h2>INGRESE BREVE DESCRIPCION DE SU PERFIL: </h2>
            <input type="text"  name="txt_descripcion" placeholder="Descripcion" required>
            <br><br>
            <% String estadoedu=(String) request.getAttribute("estadoedu");
            if(estadoedu!=null){
                if(estadoedu.equalsIgnoreCase("bien")){
                    %>
                    <h4>Datos academicos ingresados correctamente...</h4>
                <%
                }
                if(estadoedu.equalsIgnoreCase("mal")){
                    %>
                    <h4>Error en los datos academicos</h4>
                <% 
                }
               
                if(estadoedu.equalsIgnoreCase("bien1")){
                    %>
                    <h4>Se han actualizado los datos academicos correctamente..</h4>
                <%
                }
                if(estadoedu.equalsIgnoreCase("mal1")){
                    %>
                    <h4>No se pudieron actualizar los datos academicos...</h4>
                <%
               }
               }
            %>
             <input type="submit" name="accion" value="Ingresar">
             <br><br>
             <input type="submit" name="accion" value="Editar">
        </form>
            
    </body>
</html>
