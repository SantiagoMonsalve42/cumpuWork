/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.dto.AspiranteDTO;
import modelo.dto.CoordinadorProyectosDTO;


/* ADMINistrador
 */
public class Coordinador extends HttpServlet {

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
       String accion=request.getParameter("opcion");
       String menu=request.getParameter("menu");
       if(menu.equalsIgnoreCase("agregar")){
       if(accion.equalsIgnoreCase("mostrar")){
          request.getRequestDispatcher("AgregarCoordiVTA.jsp").forward(request, response); //Actualiza la pagina   
       }else
       if(accion.equalsIgnoreCase("Registrarse")){
        String nombre=request.getParameter("txt_nombre");
        String apellido=request.getParameter("txt_apellido");
        String proyecto=request.getParameter("txt_proyecto");
        String correo=request.getParameter("txt_correo");
        String clave=request.getParameter("txt_clave");
        facade objfac=new facade();
        String estado;
        if(this.verificarCorreo(correo) == true && this.VerificarClave(clave) == true){
            CoordinadorProyectosDTO objcor=new CoordinadorProyectosDTO();
            clave=this.asegurarClave(clave);
            objcor.setApellido(apellido);
            objcor.setClave(clave);
            objcor.setCorreo(correo);
            objcor.setNombre(nombre);
            objcor.setProyecto(proyecto);
            if(objfac.crearCoordinador(objcor)){//se creo bien
                estado="bien";
                request.setAttribute("estado", estado);
       request.getRequestDispatcher("Coordinador?menu=agregar&opcion=mostrar").forward(request, response);
       
            }
        else{//mal
             estado="mal";
             request.setAttribute("estado", estado);
       request.getRequestDispatcher("Coordinador?menu=agregar&opcion=mostrar").forward(request, response);
        }
        }
        else{
            
             estado="mal";
             request.setAttribute("estado", estado);
       request.getRequestDispatcher("Coordinador?menu=agregar&opcion=mostrar").forward(request, response);   
        }
       }   
       }else
           if(menu.equalsIgnoreCase("sesion")){
               if(accion.equalsIgnoreCase("cerrar")){
                   HttpSession sesion=request.getSession();
                   sesion.invalidate();
                   response.sendRedirect("index.jsp");
               }
           }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String accion=request.getParameter("op");
      if(accion.equalsIgnoreCase("Actualizar")){
          request.getRequestDispatcher("AspirantesCoordiVTA.jsp").forward(request, response);
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
     if(lista != null && lista1!=null){
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
}
