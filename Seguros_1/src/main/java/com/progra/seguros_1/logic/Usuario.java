package com.progra.seguros_1.logic;

public class Usuario {
     private String id;
     private String clave;
     private String Nombre;
     private String telefono;
     private String correo;
     private String datosTarjeta;
     private Integer tipo;

     public Usuario(String id, String clave, String Nombre, String telefono, String correo, String datosTarjeta, Integer tipo) {
        this.id = id;
        this.clave = clave;
        this.Nombre = Nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.datosTarjeta = datosTarjeta;
        this.tipo = tipo;
    }
     
    public Usuario(){
        this.id = "";
        this.clave = "";
        this.tipo = 1;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
//     @Override
//    public String toString() {
//        return "Usuario{" + "id=" + id + ", clave=" + clave + '}';
//    }
    
    
}
