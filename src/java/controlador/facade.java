/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.dao.AspiranteDAO;
import modelo.dao.CoordinadorProyectosDAO;
import modelo.dao.FormacionAspiranteDAO;
import modelo.dao.SesionDAO;
import modelo.dto.AspiranteDTO;
import modelo.dto.CoordinadorProyectosDTO;
import modelo.dto.FormacionAspiranteDTO;
import modelo.dto.SesionDTO;

/**
 *
 * @author Administrador
 */
public class facade {
    public boolean crearAspirante(AspiranteDTO objA) {
        boolean rta = false;
        if (objA != null) {
            AspiranteDAO dao = new AspiranteDAO();
            rta = dao.create(objA);
        }
        return rta;
    }
     public boolean crearCoordinador(CoordinadorProyectosDTO objc) {
        boolean rta = false;
        if (objc != null) {
            CoordinadorProyectosDAO dao = new CoordinadorProyectosDAO();
            rta = dao.create(objc);
        }
        return rta;
    }
     public boolean crearSesion(SesionDTO objS) {
        boolean rta = false;
        if (objS != null) {
            SesionDAO dao = new SesionDAO();
            rta = dao.create(objS);
        }
        return rta;
    }
    public boolean crearFormacion(FormacionAspiranteDTO objF) {
        boolean rta = false;
        if (objF != null) {
            FormacionAspiranteDAO dao = new FormacionAspiranteDAO();
            rta = dao.create(objF);
        }
        return rta;
    }
    public boolean eliminarAspirante(AspiranteDTO objA){
        boolean rta=false;
        if(objA != null){
            AspiranteDAO dao = new AspiranteDAO();
            rta=dao.delete(objA);
            
        }
        return rta;
    }
     public boolean eliminarCoordinador(CoordinadorProyectosDTO objA){
        boolean rta=false;
        if(objA != null){
            CoordinadorProyectosDAO dao = new CoordinadorProyectosDAO();
            rta=dao.delete(objA);
            
        }
        return rta;
    }
      public FormacionAspiranteDTO leerFormacion(FormacionAspiranteDTO objA){
        FormacionAspiranteDTO objRes = new FormacionAspiranteDTO();
        FormacionAspiranteDAO dao = new FormacionAspiranteDAO();
        objRes=dao.read(objA);
        return objRes;
    }
    public AspiranteDTO leerAspirante(AspiranteDTO objA){
        AspiranteDTO objRes = new AspiranteDTO();
        AspiranteDAO dao = new AspiranteDAO();
        objRes=dao.read(objA);
        return objRes;
    }
    public SesionDTO leerSesion(SesionDTO objA){
        SesionDTO objRes = new SesionDTO();
        SesionDAO dao = new SesionDAO();
        objRes=dao.read(objA);
        return objRes;
    }
    public CoordinadorProyectosDTO leerCoordinador(CoordinadorProyectosDTO objA){
        CoordinadorProyectosDTO objRes = new CoordinadorProyectosDTO();
        CoordinadorProyectosDAO dao = new CoordinadorProyectosDAO();
        objRes=dao.read(objA);
        return objRes;
    }
    public List<FormacionAspiranteDTO> listarFormaciones(){
        List<FormacionAspiranteDTO> list=null;
        FormacionAspiranteDAO dao = new FormacionAspiranteDAO();
        list=dao.readAll();
        return list;
    }
    public List<SesionDTO> listarSesiones(){
        List<SesionDTO> list=null;
        SesionDAO dao = new SesionDAO();
        list=dao.readAll();
        return list;
    }
    public List<AspiranteDTO> listarAspirantes(){
        List<AspiranteDTO> list=null;
        AspiranteDAO dao = new AspiranteDAO();
        list=dao.readAll();
        return list;
    }
    public List<CoordinadorProyectosDTO> listarCoordinadores(){
        List<CoordinadorProyectosDTO> list=null;
        CoordinadorProyectosDAO dao = new CoordinadorProyectosDAO();
        list=dao.readAll();
        return list;
    }
    public boolean editarDatosAspirante(AspiranteDTO objA){
        boolean rta=false;
        AspiranteDAO dao = new AspiranteDAO();
        if(objA != null){
            rta=dao.updateDatos(objA);
        }
        return rta;
    }
    public boolean editarDatosCoordinador(CoordinadorProyectosDTO objA){
        boolean rta=false;
        CoordinadorProyectosDAO dao = new CoordinadorProyectosDAO();
        if(objA != null){
            rta=dao.update(objA);
        }
        return rta;
    }
    public boolean editarPDF(FormacionAspiranteDTO objA){
        boolean rta=false;
        FormacionAspiranteDAO dao = new FormacionAspiranteDAO();
        if(objA != null){
            rta=dao.updatePdf(objA);
        }
        return rta;
    }
    public boolean editarFoto(FormacionAspiranteDTO objA){
        boolean rta=false;
        FormacionAspiranteDAO dao = new FormacionAspiranteDAO();
        if(objA != null){
            rta=dao.updateFoto(objA);
        }
        return rta;
    }
         public boolean editarFormacion(FormacionAspiranteDTO objA){
           boolean rta=false;
           FormacionAspiranteDAO dao = new FormacionAspiranteDAO();
           if(objA != null){
               rta=dao.update(objA);
           }
           return rta;
         }
}
