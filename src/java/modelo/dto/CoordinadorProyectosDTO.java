/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;

public class CoordinadorProyectosDTO implements Serializable{
    int id;
    String nombre;
    String correo;
    String clave;
    String apellido;
    String proyecto;

    public CoordinadorProyectosDTO() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public CoordinadorProyectosDTO(int id, String nombre, String apellido, String proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.proyecto = proyecto;
    }

    public CoordinadorProyectosDTO(String nombre, String apellido, String proyecto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.proyecto = proyecto;
    }
    
}
