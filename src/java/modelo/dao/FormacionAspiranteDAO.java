/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexiones.ConexionMsql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.FormacionAspiranteDTO;
//UPDATE coordinadorProyectos SET proyecto = ?  WHERE id = ?
public class FormacionAspiranteDAO {
   private static final String SQL_INSERT = "insert into formacionAspirante (id_aspirante,formacion_academica ,titulo1,titulo2,descripcion_perfil,hoja_de_vida,foto) values (?,?,?,?,?,?,?)"; 
   private static final String SQL_UPDATEPDF = "UPDATE formacionAspirante SET hoja_de_vida = ?  WHERE id_aspirante = ?";
   private static final String SQL_READ = "SELECT * FROM formacionAspirante where id_aspirante=?";
   private static final String SQL_READALL = "SELECT * FROM formacionAspirante";
   private static final String SQL_UPDATE="UPDATE formacionAspirante SET formacion_academica=?,titulo1=?,titulo2=?,descripcion_perfil=? WHERE id_aspirante=?";
   private static final String SQL_UPDATEFOTO="UPDATE formacionAspirante SET foto = ?  WHERE id_aspirante = ?";
   private static final ConexionMsql con = ConexionMsql.getInstance();
   
   public boolean update(FormacionAspiranteDTO objA){
     PreparedStatement ps;
     try{
          ps=con.getCnn().prepareStatement(SQL_UPDATE);
          ps.setString(1,objA.getFormacion_academica());
          ps.setString(2,objA.getTitulo1());
          ps.setString(3,objA.getTitulo2());
          ps.setString(4,objA.getDescripcion_perfil());
          ps.setInt(5, objA.getId_aspirante());
          if(ps.executeUpdate()>0){
              return true;
          }
     } catch (SQLException ex) {
           Logger.getLogger(FormacionAspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
         con.cerrarConexion();
     }
     return false;
   }
   public boolean create(FormacionAspiranteDTO objA){
       PreparedStatement ps;
       try{
            ps=con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1,objA.getId_aspirante());
            ps.setString(2,objA.getFormacion_academica());
            ps.setString(3,objA.getTitulo1());
            ps.setString(4,objA.getTitulo2());
            ps.setString(5,objA.getDescripcion_perfil());
            ps.setString(6,objA.getHoja());
            ps.setString(7,objA.getFoto());
            if(ps.executeUpdate() > 0)
                return true;
       } catch (SQLException ex) {
           Logger.getLogger(FormacionAspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return false;
   }
    public boolean updateFoto(FormacionAspiranteDTO objA){
    PreparedStatement ps;
       try{
            ps=con.getCnn().prepareStatement(SQL_UPDATEFOTO);
            ps.setString(1,objA.getFoto());
            ps.setInt(2,objA.getId_aspirante());
            if(ps.executeUpdate()>0){
                return true;
            }
       } catch (SQLException ex) {
           Logger.getLogger(FormacionAspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return false;
   }
   public boolean updatePdf(FormacionAspiranteDTO objA){
    PreparedStatement ps;
       try{
            ps=con.getCnn().prepareStatement(SQL_UPDATEPDF);
            ps.setString(1,objA.getHoja());
            ps.setInt(2,objA.getId_aspirante());
            if(ps.executeUpdate()>0){
                return true;
            }
       } catch (SQLException ex) {
           Logger.getLogger(FormacionAspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return false;
   }
   public FormacionAspiranteDTO read(FormacionAspiranteDTO objaux){
       FormacionAspiranteDTO objres=new FormacionAspiranteDTO();
       PreparedStatement ps;
      
       try {
           ps=con.getCnn().prepareStatement(SQL_READ);
           ps.setInt(1,objaux.getId_aspirante());
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
               objres.setDescripcion_perfil(rs.getString("descripcion_perfil"));
               objres.setFormacion_academica(rs.getString("formacion_academica"));
               objres.setHoja(rs.getString("hoja_de_vida"));
               objres.setId_aspirante(rs.getInt("id_aspirante"));
               objres.setTitulo1(rs.getString("titulo1"));
               objres.setTitulo2(rs.getString("titulo2"));
               objres.setFoto(rs.getString("foto"));
           }
       } catch (SQLException ex) {
           Logger.getLogger(FormacionAspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return objres;
   }
   public List<FormacionAspiranteDTO> readAll(){
        List<FormacionAspiranteDTO> lst = null;
        PreparedStatement ps;
        try{
            ps=con.getCnn().prepareStatement(SQL_READALL);
           ResultSet rs=ps.executeQuery();
           lst= new ArrayList<>();
           while(rs.next()){
           FormacionAspiranteDTO objresul=new FormacionAspiranteDTO();
           objresul.setDescripcion_perfil(rs.getString("descripcion_perfil"));
               objresul.setFormacion_academica(rs.getString("formacion_academica"));
               objresul.setHoja(rs.getString("hoja_de_vida"));
               objresul.setId_aspirante(rs.getInt("id_aspirante"));
               objresul.setTitulo1(rs.getString("titulo1"));
               objresul.setTitulo2(rs.getString("titulo2"));
               objresul.setFoto(rs.getString("foto"));
               lst.add(objresul);
           }
        } catch (SQLException ex) {
           Logger.getLogger(FormacionAspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
        return lst;
   }
}
