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
import modelo.dto.AspiranteDTO;
import modelo.dto.SesionDTO;

public class SesionDAO{
   private static final String SQL_INSERT = "insert into sesion (correo,clave) values (?,?)"; 
   private static final String SQL_READ = "SELECT * FROM sesion where id=?";
   private static final String SQL_READALL = "SELECT * FROM sesion";
   private static final ConexionMsql con = ConexionMsql.getInstance();
   
   public boolean create(SesionDTO objS){
       PreparedStatement ps;
       try {
           ps=con.getCnn().prepareStatement(SQL_INSERT);
           ps.setString(2,objS.getClave());
            ps.setString(1,objS.getCorreo());
            if(ps.executeUpdate() > 0)
                return true;
       } catch (SQLException ex) {
           Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return false;
   }
  public SesionDTO read(SesionDTO objS){
      SesionDTO objres=new SesionDTO();
      PreparedStatement ps;
      try{
          ps=con.getCnn().prepareStatement(SQL_READ);
          ps.setInt(1,objS.getId());
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
              objres.setClave(rs.getString("clave"));
              objres.setId(rs.getInt("id"));
              objres.setCorreo(rs.getString("correo"));
          }
      } catch (SQLException ex) {
           Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
          con.cerrarConexion();
      }
      return objres;
  }
  public List<SesionDTO> readAll(){
      List<SesionDTO> lst = null;
     PreparedStatement ps;
       try {
           ps=con.getCnn().prepareStatement(SQL_READALL);
           ResultSet rs=ps.executeQuery();
           lst= new ArrayList<>();
       while(rs.next()){
           SesionDTO obj=new SesionDTO();
           obj.setClave(rs.getString("clave"));
           obj.setCorreo(rs.getString("correo"));
           obj.setId(rs.getInt("id"));
           lst.add(obj);
       }
       } catch (SQLException ex) {
           Logger.getLogger(SesionDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           con.cerrarConexion();
       }
       return lst;
  }
}
