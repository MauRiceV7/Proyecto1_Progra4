/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.logic;

/**
 *
 * @author Jairo
 */


public class Poliza {
    private String fecha;
    private String placa;
    private String numero;
    private String Auto;
    private float valor;
    private Usuario usuario;
    private String ano;
    private Modelo modelo;
    
     public Poliza() {
        this.fecha = "";
        this.placa = "";
        this.numero = "";
        this.Auto = "";
        this.valor = 0;
        this.usuario = null; // Esto se saca de la base de datos 
        this.ano ="";
        this.modelo = null;
    }
     
    public Poliza(String fecha, String placa, String ano, String numero, String Auto, float valor, Usuario usuario, Modelo modelo) {
        this.fecha = fecha;
        this.placa = placa;
        this.numero = numero;
        this.Auto = Auto;
        this.valor = valor;
        this.usuario = usuario;
        this.ano = ano;
        this.modelo = modelo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAuto() {
        return Auto;
    }

    public void setAuto(String Auto) {
        this.Auto = Auto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
}
