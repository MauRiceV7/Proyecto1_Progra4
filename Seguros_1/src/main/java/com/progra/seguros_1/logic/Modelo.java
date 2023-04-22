/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.logic;

/**
 *
 * @author ESCINF
 */
public class Modelo {
    private int id;
    private Marca marca;
    private String nombre;

    public Modelo(Marca marca, String nombre, int id) {
        this.marca = marca;
        this.nombre = nombre;
        this.id = id;
    }

    public Modelo() {
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
