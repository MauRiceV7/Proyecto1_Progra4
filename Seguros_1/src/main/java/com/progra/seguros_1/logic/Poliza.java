/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.logic;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jairo
 */


public class Poliza {
    private String fecha;
    private String placa;
    private String numero;
    private float valor;
    private Usuario usuario;
    private String ano;
    private Modelo modelo;
    private List<Cobertura> coberturas;
    
     public Poliza() {
        this.fecha = "";
        this.placa = "";
        this.numero = "";
        this.valor = 0;
        this.usuario = null; // Esto se saca de la base de datos 
        this.ano ="";
        this.modelo = null;
        this.coberturas = new ArrayList();
    }
     
    public Poliza(String fecha, String placa, String ano, String numero, float valor, Usuario usuario, Modelo modelo, List<Cobertura> coberturas) {
        this.fecha = fecha;
        this.placa = placa;
        this.numero = numero;
        this.valor = valor;
        this.usuario = usuario;
        this.ano = ano;
        this.modelo = modelo;
        this.coberturas = coberturas;
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

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }
    
}
