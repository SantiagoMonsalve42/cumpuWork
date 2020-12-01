/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dto.AspiranteDTO;
import modelo.dto.FormacionAspiranteDTO;
import modelo.dto.SesionDTO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Administrador
 */
@MultipartConfig
public class Aspirante extends HttpServlet {

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
        processRequest(request, response);
        String menu=request.getParameter("menu");
        String opcion=request.getParameter("opcion");
        if(menu.equalsIgnoreCase("editar")){
           if(opcion.equalsIgnoreCase("Mostrar")){
               request.getRequestDispatcher("EditarAspiranteVTA.jsp").forward(request, response);
           }else
           if(opcion.equalsIgnoreCase("Editar")){
               int tel_fijo=Integer.parseInt(request.getParameter("txt_telfijo"));
               int tel_movil=Integer.parseInt(request.getParameter("txt_telmovil"));
               HttpSession objsesion=request.getSession();
               SesionDTO objs=new SesionDTO();
               AspiranteDTO objinsert=new AspiranteDTO();
               objs=(SesionDTO) objsesion.getAttribute("bien");
               List<AspiranteDTO> LISTA=null;
               facade objf=new facade();
               String estado;
               LISTA=objf.listarAspirantes();
               int id=0;
               for(int i=0;i<LISTA.size();i++){
                   if(objs.getCorreo().equalsIgnoreCase(LISTA.get(i).getCorreo())){
                       id=LISTA.get(i).getId();
                   }
               }
               objinsert.setId(id);
               objinsert.setTel_fijo(tel_fijo);
               objinsert.setTel_movil(tel_movil);
               if(id!=0){
                 if(objf.editarDatosAspirante(objinsert) == true){
                     estado="bien";
                     request.setAttribute("estado",estado);
                     
                 request.getRequestDispatcher("Aspirante?menu=editar&opcion=Mostrar").forward(request, response);
                 }else{
                     estado="mal";
                     request.setAttribute("estado",estado);  
                     
                request.getRequestDispatcher("Aspirante?menu=editar&opcion=Mostrar").forward(request, response);
                  }
               }
           } 
        }else
         if(menu.equalsIgnoreCase("sesion")){
             if(opcion.equalsIgnoreCase("cerrar")){
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
        String accion=request.getParameter("accion");
       if(accion.equalsIgnoreCase("Ingresar")){
           String formacion=request.getParameter("txt_formacion");
           String titulo1=request.getParameter("txt_titulo1");
           String titulo2=request.getParameter("txt_titulo2");
           String descripcion=request.getParameter("txt_descripcion");
           String nombrepdf="";
           String nombrefoto="";
           facade fac=new facade();
           int id=0;
           HttpSession objsesion=request.getSession();
           SesionDTO objs=new SesionDTO();
           objs=(SesionDTO) objsesion.getAttribute("bien");
           List<AspiranteDTO> LISTA=fac.listarAspirantes();
           for(int i=0;i<LISTA.size();i++){
           if(objs.getCorreo().equalsIgnoreCase(LISTA.get(i).getCorreo()))
               id=LISTA.get(i).getId();
           }
           FormacionAspiranteDTO objaux=new FormacionAspiranteDTO();
           objaux.setHoja(nombrepdf);
           objaux.setFoto(nombrefoto);
           objaux.setTitulo2(titulo2);   
           objaux.setDescripcion_perfil(descripcion);
           objaux.setFormacion_academica(formacion);
           objaux.setTitulo1(titulo1);
           
           String estadoedu;
           
                      
           if(id !=0)
           objaux.setId_aspirante(id);
           if(fac.crearFormacion(objaux) == true){//se creo bien
                estadoedu="bien";
               request.setAttribute("estadoedu",estadoedu);
              request.getRequestDispatcher("EditarAspiranteVTA.jsp").forward(request, response);
           }else{
               estadoedu="mal";
               request.setAttribute("estadoedu",estadoedu);
              request.getRequestDispatcher("EditarAspiranteVTA.jsp").forward(request, response);
           } 
       }else
       if(accion.equalsIgnoreCase("Editar")){
           String formacion=request.getParameter("txt_formacion");
           String titulo1=request.getParameter("txt_titulo1");
           String titulo2=request.getParameter("txt_titulo2");
           String descripcion=request.getParameter("txt_descripcion");
            facade fac=new facade();
           int id=0;
           String estadoedu;
           HttpSession objsesion=request.getSession();
           SesionDTO objs=new SesionDTO();
           objs=(SesionDTO) objsesion.getAttribute("bien");
           List<AspiranteDTO> LISTA=fac.listarAspirantes();
           for(int i=0;i<LISTA.size();i++){
           if(objs.getCorreo().equalsIgnoreCase(LISTA.get(i).getCorreo()))
               id=LISTA.get(i).getId();
           }
           FormacionAspiranteDTO objaux=new FormacionAspiranteDTO();
           objaux.setTitulo2(titulo2);   
           objaux.setDescripcion_perfil(descripcion);
           objaux.setFormacion_academica(formacion);
           objaux.setTitulo1(titulo1);
           objaux.setId_aspirante(id);
           if(fac.editarFormacion(objaux) == true){
              estadoedu="bien1";
               request.setAttribute("estadoedu",estadoedu);
              request.getRequestDispatcher("EditarAspiranteVTA.jsp").forward(request, response); 
           }else{
               estadoedu="mal1";
               request.setAttribute("estadoedu",estadoedu);
              request.getRequestDispatcher("EditarAspiranteVTA.jsp").forward(request, response);
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

}
