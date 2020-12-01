/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

public class AspiranteDTO implements Serializable{
    private int id;
    private String tipo_doc;
    private int num_documento;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String nacionalidad;
    private String ciudad;
    private String correo;
    private int tel_fijo;
    private int tel_movil;
    private String fecha_nac;
    private String sexo;
    private String profesion;
    private String contraseña;


   
  

 

   
    public AspiranteDTO(String tipo_doc, int num_documento, String nombre1, String nombre2, String apellido1, String apellido2, String nacionalidad, String ciudad, String correo, int tel_fijo, int tel_movil, String fecha_nac, String sexo, String profesion, String contraseña) {
        this.tipo_doc = tipo_doc;
        this.num_documento = num_documento;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nacionalidad = nacionalidad;
        this.ciudad = ciudad;
        this.correo = correo;
        this.tel_fijo = tel_fijo;
        this.tel_movil = tel_movil;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.profesion = profesion;
        this.contraseña = contraseña;
    }

    public AspiranteDTO() {
    }

    public AspiranteDTO(int id, String tipo_doc, int num_documento, String nombre1, String nombre2, String apellido1, String apellido2, String nacionalidad, String ciudad, String correo, int tel_fijo, int tel_movil, String fecha_nac, String sexo, String profesion, String contraseña) {
        this.id = id;
        this.tipo_doc = tipo_doc;
        this.num_documento = num_documento;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nacionalidad = nacionalidad;
        this.ciudad = ciudad;
        this.correo = correo;
        this.tel_fijo = tel_fijo;
        this.tel_movil = tel_movil;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.profesion = profesion;
        this.contraseña = contraseña;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public int getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(int num_documento) {
        this.num_documento = num_documento;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTel_fijo() {
        return tel_fijo;
    }

    public void setTel_fijo(int tel_fijo) {
        this.tel_fijo = tel_fijo;
    }

    public int getTel_movil() {
        return tel_movil;
    }

    public void setTel_movil(int tel_movil) {
        this.tel_movil = tel_movil;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



  
}
