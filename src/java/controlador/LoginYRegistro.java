/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.dto.AspiranteDTO;
import modelo.dto.CoordinadorProyectosDTO;
import modelo.dto.SesionDTO;


/**
 *
 * @author Administrador
 */
public class LoginYRegistro extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          facade facade=new facade();
          AspiranteDTO objasp=new AspiranteDTO();
          String accionador= request.getParameter("accionador");
          String TipoDocumento = null;
          int num_documento = 0;
          String Nombre1 = null;
          String Nombre2 = null;
          String Apellido1 = null;
          String Apellido2 = null;
          String Pais = null;
          String Residencia = null;
          String Correo = null;
          int tel_fijo = 0;
          int tel_movil = 0;
          String Nacimiento = null;
          String Sexo = null;
          String Profesion = null;
          String Contraseña = null;
          String error1=null; 
          if(accionador.equalsIgnoreCase("Registrarse")){

              try{
             Contraseña= request.getParameter("txt_clave");
             if(this.VerificarClave(Contraseña) == true){
                 Contraseña=this.asegurarClave(Contraseña);
                 objasp.setContraseña(Contraseña);
             }else{
                 error1+="1"; //1= clave erronea
             }
             
              }catch(Exception e){
             }
        
        try{
             Apellido1=request.getParameter("txt_apellido1");
             Apellido2=request.getParameter("txt_apellido2");
          objasp.setApellido1(Apellido1);
          objasp.setApellido2(Apellido2);
        }catch(Exception e){
          error1+="2";//2= error en los apellidos
        }
        try{
         tel_fijo=Integer.parseInt(request.getParameter("txt_telfijo"));
             tel_movil=Integer.parseInt(request.getParameter("txt_telmovil"));
          objasp.setTel_fijo(tel_fijo);
          objasp.setTel_movil(tel_movil);
        }catch(Exception e){
            error1+="3";//3=error en el telefono
        }
        
        try{
            Nombre1=request.getParameter("txt_nombre1");
             Nombre2=request.getParameter("txt_nombre2");
           objasp.setNombre1(Nombre1);
          objasp.setNombre2(Nombre2); 
        }catch(Exception e){
            error1+="5";//5= error en los nombres
        }
        
        try{
            Pais=request.getParameter("txt_nacionalidad");
             Residencia= request.getParameter("txt_ciudad");
           objasp.setCiudad(Residencia);
           objasp.setNacionalidad(Pais);
        }catch(Exception e){
            error1+="6";// error en ciudad o pais
        }
        
        try{
             TipoDocumento=request.getParameter("txt_tipodocumento");
             num_documento=Integer.parseInt(request.getParameter("txt_documento"));
          objasp.setNum_documento(num_documento);
          objasp.setTipo_doc(TipoDocumento);
        }catch(Exception e){
           error1+="7";// error en numero o tipo de doc  
        }
        
        try{
             Correo=request.getParameter("txt_correo");  
             if(this.verificarCorreo(Correo) == true)
              objasp.setCorreo(Correo);
             else
                 error1+="8";
        }catch(Exception e){
            // error en el correo 
        }       
        
        try{
             Nacimiento=request.getParameter("txt_nacimiento");
            objasp.setFecha_nac(Nacimiento);
        }catch(Exception e){
            error1+="9";// error en la fecha nacimiento
        }
        try{
             Profesion=request.getParameter("txt_profesion");
          objasp.setProfesion(Profesion);
        }catch(Exception e){
           error1+="a";// error en la profesion
        }
        try{
             Sexo= request.getParameter("txt_sexo");
          objasp.setSexo(Sexo);
        }catch(Exception e){
            error1+="b";// error en la profesion     
        }
        if(error1==null){
             if(facade.crearAspirante(objasp) == true){
                 error1="sik";
              request.setAttribute("msj",error1);
              
            request.getRequestDispatcher("Registro.jsp").forward(request,response);
             }
        }else{
            request.setAttribute("msj",error1);
            request.getRequestDispatcher("Registro.jsp").forward(request,response);
        }
            
          }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            facade facade=new facade();
            String accion= request.getParameter("accion");
            
            if(accion.equalsIgnoreCase("Login")){
            String correo= request.getParameter("txt_correo");
            String clave= request.getParameter("txt_clave");
            clave=this.asegurarClave(clave);
            
            List<AspiranteDTO> lista_aspirantes=null;
            List<CoordinadorProyectosDTO> lista_coordinadores=null;
            lista_aspirantes=facade.listarAspirantes();
            lista_coordinadores=facade.listarCoordinadores();
            
            String estadoerror=null;
            SesionDTO objsesion=new SesionDTO();
            if(lista_coordinadores!=null ||lista_aspirantes!=null){
            if(correo.equalsIgnoreCase("") || clave.equalsIgnoreCase("")){
                        estadoerror="maldatos";
                        request.setAttribute("mensaje",estadoerror);
                        request.getRequestDispatcher("index.jsp").forward(request,response);
            }else{
                int act1=0; //activador login valido aspirante..
                int act2=0; //activador login valido coordinador..
                 if(lista_aspirantes.size() > 0){
               for(int i=0;i<lista_aspirantes.size();i++){
                   if(clave.equalsIgnoreCase(lista_aspirantes.get(i).getContraseña()) && correo.equalsIgnoreCase(lista_aspirantes.get(i).getCorreo())){
                     act1=1;//login valido aspirante...
                     objsesion.setClave(clave);
                     objsesion.setCorreo(correo);
                     AspiranteDTO objasp=new AspiranteDTO();
                    
                     for(int j=0;j<lista_aspirantes.size();j++){
                        if(correo.equalsIgnoreCase(lista_aspirantes.get(j).getCorreo())){
                            objasp.setNum_documento(lista_aspirantes.get(j).getNum_documento());
                            objasp.setNombre1(lista_aspirantes.get(j).getNombre1());
                            objasp.setNombre2(lista_aspirantes.get(j).getNombre2());
                            objasp.setApellido1(lista_aspirantes.get(j).getApellido1());
                            objasp.setApellido2(lista_aspirantes.get(j).getApellido2());
                            objasp.setNacionalidad(lista_aspirantes.get(j).getNacionalidad());
                            objasp.setTel_fijo(lista_aspirantes.get(j).getTel_fijo());
                            objasp.setTel_movil(lista_aspirantes.get(j).getTel_movil());
                            objasp.setFecha_nac(lista_aspirantes.get(j).getFecha_nac());
                            objasp.setSexo(lista_aspirantes.get(j).getSexo());
                            objasp.setProfesion(lista_aspirantes.get(j).getProfesion());
                            request.setAttribute("datos",objasp);
                        } 
                     }
                   }
               }
               }
               if(lista_coordinadores.size()>0){
               for(int i=0;i<lista_coordinadores.size();i++){
                   if(clave.equalsIgnoreCase(lista_coordinadores.get(i).getClave()) && correo.equalsIgnoreCase(lista_coordinadores.get(i).getCorreo())){
                     act2=1;//login valido coordinador...
                     objsesion.setClave(clave);
                     objsesion.setCorreo(correo);
                      
               CoordinadorProyectosDTO objcor=new CoordinadorProyectosDTO();
               
                    for(int j=0;j<lista_coordinadores.size();j++){
              if(correo.equalsIgnoreCase(lista_coordinadores.get(j).getCorreo())){
               objcor.setId(lista_coordinadores.get(j).getId());
               objcor.setApellido(lista_coordinadores.get(j).getApellido()); 
               objcor.setCorreo(lista_coordinadores.get(j).getCorreo()); 
               objcor.setNombre(lista_coordinadores.get(j).getNombre());
               objcor.setProyecto(lista_coordinadores.get(j).getProyecto());
               
               request.setAttribute("datos",objcor);
              } 
              }
                   }
                   }
               }
                     HttpSession sesion=request.getSession();
                     sesion.setAttribute("bien",objsesion);
               if(act1==1){
                   request.getRequestDispatcher("Aspirante.jsp").forward(request,response); 
               }   
                else
                   if(act2==1){
                      request.getRequestDispatcher("Coordinador.jsp").forward(request,response);  
                   }
                   else{
                       estadoerror="mallogin";
                       request.setAttribute("mensaje",estadoerror);
                       request.getRequestDispatcher("index.jsp").forward(request,response);
                   }
              }
            }
            }
    }

            
            
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
  private String asegurarClave(String clave){
        try {
            MessageDigest sha256=MessageDigest.getInstance("SHA-256");
            sha256.update(clave.getBytes("UTF-8"));
            clave=String.format("%064x",new BigInteger(1,sha256.digest()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(LoginYRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clave;
    }
  private boolean VerificarClave(String clave){
      boolean rp=false;
      int letra=0,numero=0;
      
      for(int i=0;i<clave.length();i++){
        if(clave.charAt(i)>=65 && clave.charAt(i)<=90){ //verifica que haya mayuscula almenos una vez
            letra=1;
        }
        if(clave.charAt(i)>=48 && clave.charAt(i)<=57){//verifica que haya almenos un numero
            numero=1;
        }  
     }
      if(letra==1 && numero==1){
          rp=true;
      }
      return rp;
  }
  private boolean verificarCorreo(String correo){
     boolean rp=true;
     facade obj=new facade(); //si existe devuelve false si no es verdadero
     List<CoordinadorProyectosDTO> lista=null;
     List<AspiranteDTO> lista1=null;
     lista1=obj.listarAspirantes();
     lista=obj.listarCoordinadores();
     if(lista != null || lista1!=null){
         for(int i=0;i<lista.size();i++){
         if(correo.equals(lista.get(i).getCorreo()) == true)
             rp=false;
         }
         for(int j=0;j<lista1.size();j++){
         if(correo.equals(lista1.get(j).getCorreo())==true)
             rp=false;
         }
     }
     return rp;
  }
}
