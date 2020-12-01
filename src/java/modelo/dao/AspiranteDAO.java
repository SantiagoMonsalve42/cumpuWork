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

public class AspiranteDAO {
    private static final String SQL_INSERT = "INSERT INTO datosAspirante (tipodoc,numerodoc,nombre1,nombre2,apellido1,apellido2,nacionalidad,ciudad,"
          + "correo,tel_fijo,tel_cel,fecha_nacimiento,sexo,profesion,contraseña) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATEDATOS ="UPDATE datosAspirante SET tel_fijo = ?,tel_cel = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM datosAspirante WHERE id = ?";
    private static final String SQL_READ = "SELECT * FROM datosAspirante WHERE id = ? ";
    private static final String SQL_READALL = "SELECT * FROM datosAspirante";
    private static final ConexionMsql con = ConexionMsql.getInstance();
  
    public boolean create(AspiranteDTO C){
        PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1,C.getTipo_doc());
            ps.setInt(2,C.getNum_documento());
            ps.setString(3,C.getNombre1());
            ps.setString(4,C.getNombre2());
            ps.setString(5,C.getApellido1());
            ps.setString(6,C.getApellido2());
            ps.setString(7,C.getNacionalidad());
            ps.setString(8,C.getCiudad());
            ps.setString(9,C.getCorreo());
            ps.setInt(10,C.getTel_fijo());
            ps.setInt(11,C.getTel_movil());
            ps.setString(12,C.getFecha_nac());
            ps.setString(13,C.getSexo());
            ps.setString(14,C.getProfesion());
            ps.setString(15,C.getContraseña());
            if(ps.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }
    public boolean delete(AspiranteDTO a){
        PreparedStatement ps;
        try{
            ps=con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1,a.getId());
            if(ps.executeUpdate() >0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }
    public List<AspiranteDTO> readAll(){
     List<AspiranteDTO> lst = null;
     PreparedStatement psnt;
        try {
            psnt=con.getCnn().prepareStatement(SQL_READALL);
            ResultSet rs=psnt.executeQuery();
            lst= new ArrayList<>();
            while(rs.next()){
                AspiranteDTO objA=new AspiranteDTO();
                
                objA.setId(rs.getInt("id"));
                objA.setTipo_doc(rs.getString("tipodoc"));
                objA.setNum_documento(rs.getInt("numerodoc"));
                objA.setNombre1(rs.getString("nombre1"));
                objA.setNombre2(rs.getString("nombre2"));
                objA.setApellido1(rs.getString("apellido1"));
                objA.setApellido2(rs.getString("apellido2"));
                objA.setNacionalidad(rs.getString("nacionalidad"));
                objA.setCiudad(rs.getString("ciudad"));
                objA.setCorreo(rs.getString("correo"));
                objA.setTel_fijo(rs.getInt("tel_fijo"));
                objA.setTel_movil(rs.getInt("tel_cel"));
                objA.setFecha_nac(rs.getString("fecha_nacimiento"));
                objA.setSexo(rs.getString("sexo"));
                objA.setProfesion(rs.getString("profesion"));
                objA.setContraseña(rs.getString("contraseña"));
                lst.add(objA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
     return lst;
    }
    public boolean updateDatos(AspiranteDTO a){
         PreparedStatement ps;
        try {
            ps=con.getCnn().prepareStatement(SQL_UPDATEDATOS);
            ps.setInt(1,a.getTel_fijo());
            ps.setInt(2,a.getTel_movil());
            ps.setInt(3,a.getId());
            if(ps.executeUpdate() >0){
                return true;
            }
    }   catch (SQLException ex) {
            Logger.getLogger(AspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
    return false;
    }
    public AspiranteDTO read(AspiranteDTO objaux){
        AspiranteDTO objret=new AspiranteDTO();
        PreparedStatement psnt = null;
        try {
            psnt=con.getCnn().prepareStatement(SQL_READ);
            psnt.setInt(1, objaux.getId());
            ResultSet rs = psnt.executeQuery();
            while(rs.next()){
                objret.setId(rs.getInt("id"));
                objret.setTipo_doc(rs.getString("tipodoc"));
                objret.setNum_documento(rs.getInt("numerodoc"));
                objret.setNombre1(rs.getString("nombre1"));
                objret.setNombre2(rs.getString("nombre2"));
                objret.setApellido1(rs.getString("apellido1"));
                objret.setApellido2(rs.getString("apellido2"));
                objret.setNacionalidad(rs.getString("nacionalidad"));
                objret.setCiudad(rs.getString("ciudad"));
                objret.setCorreo(rs.getString("correo"));
                objret.setTel_fijo(rs.getInt("tel_fijo"));
                objret.setTel_movil(rs.getInt("tel_cel"));
                objret.setFecha_nac(rs.getString("fecha_nacimiento"));
                objret.setSexo(rs.getString("sexo"));
                objret.setProfesion(rs.getString("profesion"));
                objret.setContraseña(rs.getString("contraseña"));
        }} catch (SQLException ex) {
            Logger.getLogger(AspiranteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
      return objret;  
    }
}
