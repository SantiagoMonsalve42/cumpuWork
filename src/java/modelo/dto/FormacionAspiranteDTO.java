/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;

public class FormacionAspiranteDTO implements Serializable{
    int id_aspirante;
    String formacion_academica;
    String titulo1;
    String titulo2;
    String descripcion_perfil;
    String foto;
    String hoja;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public FormacionAspiranteDTO() {
    }

    public FormacionAspiranteDTO(int id_aspirante, String formacion_academica, String titulo1, String titulo2, String descripcion_perfil, String foto, String hoja) {
        this.id_aspirante = id_aspirante;
        this.formacion_academica = formacion_academica;
        this.titulo1 = titulo1;
        this.titulo2 = titulo2;
        this.descripcion_perfil = descripcion_perfil;
        this.foto = foto;
        this.hoja = hoja;
    }

    
  

    public int getId_aspirante() {
        return id_aspirante;
    }

    public void setId_aspirante(int id_aspirante) {
        this.id_aspirante = id_aspirante;
    }

    public String getFormacion_academica() {
        return formacion_academica;
    }

    public void setFormacion_academica(String formacion_academica) {
        this.formacion_academica = formacion_academica;
    }

    public String getTitulo1() {
        return titulo1;
    }

    public void setTitulo1(String titulo1) {
        this.titulo1 = titulo1;
    }

    public String getTitulo2() {
        return titulo2;
    }

    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;
    }

    public String getDescripcion_perfil() {
        return descripcion_perfil;
    }

    public void setDescripcion_perfil(String descripcion_perfil) {
        this.descripcion_perfil = descripcion_perfil;
    }

    public String getHoja() {
        return hoja;
    }

    public void setHoja(String hoja) {
        this.hoja = hoja;
    }

}
