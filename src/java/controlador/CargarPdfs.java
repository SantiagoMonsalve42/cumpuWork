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
public class CargarPdfs extends HttpServlet {

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
       System.out.println(accion);
       if(accion.equalsIgnoreCase("Subir")){
        String archivourl = "C:\\Users\\Administrador\\Documents\\NetBeansProjects\\ProyectoFinal\\web\\pdfs";
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            factory.setSizeThreshold(1024);
            
            factory.setRepository(new File(archivourl));
            ServletFileUpload upload = new ServletFileUpload(factory);
            File file;
            String nombre="\\";
            try{
                List<FileItem> partes = upload.parseRequest(request);
                for(FileItem items: partes){
                    file = new File(archivourl,items.getName());
                    items.write(file);
                    
                nombre+=file.getName();
                }
            }catch(Exception e){
                System.out.println("Error"+e.getMessage());
            }
        System.out.println(nombre);
        facade fac=new facade();
        int act=0;
        List<FormacionAspiranteDTO> lista=fac.listarFormaciones();
        HttpSession objsesion=request.getSession();
        SesionDTO objs=new SesionDTO();
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
        }//SE TRAE EL ID PARA EDITAR
        FormacionAspiranteDTO OBJedit=new FormacionAspiranteDTO();
        for(int i=0;i<lista.size();i++){
            if(nombre.equals(lista.get(i).getHoja())){
               act=1; //NO SE PUEDE AGREGAR..
            }
        }
        
        if(act==0){
            OBJedit.setId_aspirante(id);
            OBJedit.setHoja(nombre);
            if(fac.editarPDF(OBJedit)==true){//se agrego a la base bn
                 estado="bien";
                 request.setAttribute("estado",estado);
                 request.getRequestDispatcher("ArchivosAspiranteVTA.jsp").forward(request, response);
                 
            }else{
                 estado="mal";
                 request.setAttribute("estado",estado);
                 request.getRequestDispatcher("ArchivosAspiranteVTA.jsp").forward(request, response);
            }
        }else{
            estado="mal";
                 request.setAttribute("estado",estado);
                 request.getRequestDispatcher("ArchivosAspiranteVTA.jsp").forward(request, response);
        }
       }else
       if(accion.equalsIgnoreCase("SubirF")){
        String archivourl = "C:\\Users\\Administrador\\Documents\\NetBeansProjects\\ProyectoFinal\\web\\perfiles";
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            factory.setSizeThreshold(1024);
            
            factory.setRepository(new File(archivourl));
            ServletFileUpload upload = new ServletFileUpload(factory);
            File file;
            String nombre="\\";
            try{
                List<FileItem> partes = upload.parseRequest(request);
                for(FileItem items: partes){
                    file = new File(archivourl,items.getName());
                    items.write(file);
                    
                nombre+=file.getName();
                }
            }catch(Exception e){
                System.out.println("Error"+e.getMessage());
            }
        System.out.println(nombre);
        facade fac=new facade();
        int act=0;
        List<FormacionAspiranteDTO> lista=fac.listarFormaciones();
        HttpSession objsesion=request.getSession();
        SesionDTO objs=new SesionDTO();
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
        }//SE TRAE EL ID PARA EDITAR
        FormacionAspiranteDTO OBJedit=new FormacionAspiranteDTO();
        for(int i=0;i<lista.size();i++){
            if(nombre.equals(lista.get(i).getFoto())){
               act=1; //NO SE PUEDE AGREGAR..
            }
        }
        if(act==0){
            OBJedit.setId_aspirante(id);
            OBJedit.setFoto(nombre);
            if(fac.editarFoto(OBJedit)==true){//se agrego a la base bn
                 estado="bien";
                 request.setAttribute("estado1",estado);
                 request.getRequestDispatcher("ArchivosAspiranteVTA.jsp").forward(request, response);
                 
            }else{
                 estado="mal";
                 request.setAttribute("estado1",estado);
                 request.getRequestDispatcher("ArchivosAspiranteVTA.jsp").forward(request, response);
            }
        }else{
            estado="mal";
                 request.setAttribute("estado1",estado);
                 request.getRequestDispatcher("ArchivosAspiranteVTA.jsp").forward(request, response);
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
