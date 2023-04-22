/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.logic;

/**
 *
 * @author ESCINF
 */
public class Cobertura {
    private int id;
    private String desc;
    private int costoMin;
    private int costPor;
    private Categoria categoria;

    public Cobertura() {
    }

    public Cobertura(String desc, int costoMin, int costPor, Categoria categoria, int id) {
        this.desc = desc;
        this.costoMin = costoMin;
        this.costPor = costPor;
        this.categoria = categoria;
        this.id  = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCostoMin() {
        return costoMin;
    }

    public void setCostoMin(int costoMin) {
        this.costoMin = costoMin;
    }

    public int getCostPor() {
        return costPor;
    }

    public void setCostPor(int costPor) {
        this.costPor = costPor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
}
