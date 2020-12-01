<%-- 
    Document   : Registro
    Created on : 20/03/2020, 17:55:29
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
     <link link rel=stylesheet href="CSS/estilos.css" type="text/css" MEDIA=screen> 
    </head>
    <body>
        
        <form method="GET" id="formregistro" action="LoginYRegistro?accion=Registrarse"  >
            <h1>REGISTRO</h1> 
            <h2>*Ingrese tipo de documento:</h2>
               <select name="txt_tipodocumento" required>
               <option value="cedula" id="ZM">Cedula de Ciudadania</option>
               <option value="tarjeta" id="ZW">Tarjeta de Identidad</option>
               <option value="cedulaextrangero" id="ZW">Cedula de Extranjeria</option>
               </select> 
            <h2>*Ingrese numero de documento:</h2>
            <input type="number" min="10000000" max="1100000000" name="txt_documento" placeholder="identificacion" required>
            <h2>*Ingrese primer nombre:</h2>
            <input type="text"  name="txt_nombre1" placeholder="primer nombre" required>
            <h2>Ingrese segundo nombre:</h2>
            <input type="text"  name="txt_nombre2" placeholder="segundo nombre" >
            <h2>*Ingrese primer apellido:</h2>
            <input type="text"  name="txt_apellido1" placeholder="primer apellido" required>
            <h2>Ingrese segundo apellido:</h2>
            <input type="text"  name="txt_apellido2" placeholder="segundo nombre">
             <h2>*Ingrese pais de nacimiento:</h2>
            <input type="text"  name="txt_nacionalidad" placeholder="pais" required>
            <h2>*Ingrese ciudad de residencia:</h2>
            <input type="text"  name="txt_ciudad" placeholder="ciudad" required>
             <h2>*Ingrese correo electronico:</h2>
            <input type="email"  name="txt_correo" placeholder="correo" required>
             <h2>*Ingrese telefono fijo:</h2>
            <input type="number" min="1000000" max="9999999" name="txt_telfijo" placeholder="telefono fijo"required>
             <h2>*Ingrese telefono movil:</h2>
            <input type="number" min="300000000" max="399999999"  name="txt_telmovil" placeholder="telefono movil"required>
            <h2>*Ingrese nacimiento:</h2>
            <input type="date"  name="txt_nacimiento" required>
            <h2>*Ingrese sexo:</h2>
            <select name="txt_sexo" required>
                <option value="masculino" id="ZM">Masculino</option>
               <option value="femenino" id="ZW">Femenino</option>
              
            </select> 
            <h2>*Ingrese profesion:</h2>
            <input type="text"  name="txt_profesion" placeholder="profesion"required>
            <h2>*Ingrese contraseña:</h2>
            <input type="password"  name="txt_clave" placeholder="contraseña"required>
                <h4>NOTA: una vez creada la cuenta, debe ingresar con la clave y el correo que ingreso en este formulario, la clave debe tener mayusculas y numeros </h4>
            <br><br>
            
            <input type="submit" name="accionador" value="Registrarse">
            
            <% String msj = (String) request.getAttribute("msj");
            if(msj!=null){
            
            for(int i=0;i<msj.length();i++){
                if(msj.charAt(i) == '1'){
                  %>
                 <h4>Error en la clave ingresados..</h4>
                 <%
                }
                if(msj.charAt(i) == '2'){
                  %>
                 <h4>Error en los apellidos ingresados..</h4>
                 <%
                }
                if(msj.charAt(i) == '3'){
                  %>
                 <h4>Error en los telefonos ingresado..</h4>
                 <%
                } 
                if(msj.charAt(i) == '4'){
                  %>
                 <h4>Error en el archivo de foto ingresado..</h4>
                 <%
                }
               if(msj.charAt(i) == '5'){
                  %>
                 <h4>Error en los nombres ingresados..</h4>
                 <%
                } 
                if(msj.charAt(i) == '6'){
                  %>
                 <h4>Error en la ciudad y/o el pais ingresado</h4>
                 <%
                }
                if(msj.charAt(i) == '7'){
                  %>
                 <h4>Error en el numero y/o tipo de documento</h4>
                 <%
                }
                if(msj.charAt(i) == '8'){
                  %>
                 <h4>Error en el corro ingresado, ya existe en la base de datos..</h4>
                 <%
                }
                if(msj.charAt(i) == '9'){
                  %>
                 <h4>Error en la fecha de nacimiento</h4>
                 <%
                }
                if(msj.charAt(i) == 'a'){
                  %>
                 <h4>Error en la profesion ingresada/h4>
                 <%
                }
                if(msj.charAt(i) == 'b'){
                  %>
                 <h4>Error en el sexo ingresado</h4>
                 <%
                }
               

            }
            if(msj.equals("sik")){
                %>
                
                <h4>Se creo correctamente el usuario...</h4>
                <a href="index.jsp">Inicie Sesion </a>
            <%
            }
            }
            %>
                 
            
       
            </form>
    </body>
</html>
