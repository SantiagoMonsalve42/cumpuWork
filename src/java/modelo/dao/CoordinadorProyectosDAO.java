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
import modelo.dto.CoordinadorProyectosDTO;

public class CoordinadorProyectosDAO {
   private static final String SQL_INSERT = "insert into coordinadorProyectos (correo,clave,nombre,apellido,proyecto) values (?,?,?,?,?)"; 
   private static final String SQL_UPDATE = "UPDATE coordinadorProyectos SET proyecto = ?  WHERE id = ?";
   private static final String SQL_DELETE = "DELETE FROM coordinadorProyectos where id=?";
   private static final String SQL_READ = "SELECT * FROM coordinadorProyectos where id=?";
   private static final String SQL_READALL = "SELECT * FROM coordinadorProyectos";
   private static final ConexionMsql con = ConexionMsql.getInstance();
  
   public boolean create(CoordinadorProyectosDTO objC){
       PreparedStatement ps;
       try{
            ps=con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1,objC.getCorreo());
            ps.setString(2,objC.getClave());
            ps.setString(3,objC.getNombre());
            
            ps.setString(4,objC.getApellido());
            
            ps.setString(5,objC.getProyecto());
            if(ps.executeUpdate()>0)
                return true;
       } catch (SQLException ex) {
           Logger.getLogger(CoordinadorProyectosDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return false;
   }
   public boolean update(CoordinadorProyectosDTO objC){
       PreparedStatement ps;
       try{
          ps=con.getCnn().prepareStatement(SQL_UPDATE); 
             
          ps.setString(1,objC.getProyecto());
          
          ps.setInt(2,objC.getId());
          
          if(ps.executeUpdate()>0){
              return true;
              
          }
              
       } catch (SQLException ex) {
           Logger.getLogger(CoordinadorProyectosDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return false;
   }
   public boolean delete(CoordinadorProyectosDTO objC){
       PreparedStatement ps;
       try {
           ps=con.getCnn().prepareStatement(SQL_DELETE);
           ps.setInt(1,objC.getId());
           if(ps.executeUpdate()>0)
               return true;
       } catch (SQLException ex) {
           Logger.getLogger(CoordinadorProyectosDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return false;
   }
   public CoordinadorProyectosDTO read(CoordinadorProyectosDTO objaux){
       CoordinadorProyectosDTO objresul=new CoordinadorProyectosDTO() ;
       PreparedStatement ps;
      
       try {
           ps=con.getCnn().prepareStatement(SQL_READ);
           ps.setInt(1,objaux.getId());
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
              objresul.setApellido(rs.getString("apellido"));
              objresul.setId(rs.getInt("id"));
              objresul.setNombre(rs.getString("nombre"));
              objresul.setProyecto(rs.getString("proyecto"));
              objresul.setCorreo(rs.getString("correo"));
              objresul.setClave(rs.getString("clave"));
           }
       } catch (SQLException ex) {
           Logger.getLogger(CoordinadorProyectosDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return objresul;
   }
   public List<CoordinadorProyectosDTO> readAll(){
       List<CoordinadorProyectosDTO> lst = null;
        PreparedStatement ps;
        try{
            ps=con.getCnn().prepareStatement(SQL_READALL);
           ResultSet rs=ps.executeQuery();
           lst= new ArrayList<>();
           while(rs.next()){
              CoordinadorProyectosDTO objresul=new CoordinadorProyectosDTO();
              objresul.setApellido(rs.getString("apellido"));
              objresul.setId(rs.getInt("id"));
              objresul.setNombre(rs.getString("nombre"));
              objresul.setProyecto(rs.getString("proyecto"));
              objresul.setCorreo(rs.getString("correo"));
              objresul.setClave(rs.getString("clave"));
              lst.add(objresul);
           }
        } catch (SQLException ex) {
           Logger.getLogger(CoordinadorProyectosDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
            con.cerrarConexion();
        }
        return lst;
   }
}
