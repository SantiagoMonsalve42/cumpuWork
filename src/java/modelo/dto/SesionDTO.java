/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;

public class SesionDTO implements Serializable{
    int id;
    String correo;
    String clave;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public SesionDTO(int id, String correo, String clave) {
        this.id = id;
        this.correo = correo;
        this.clave = clave;
    }

    public SesionDTO(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public SesionDTO() {
    }
    
}
