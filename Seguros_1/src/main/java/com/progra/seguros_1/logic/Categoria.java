/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.logic;

/**
 *
 * @author ESCINF
 */
public class Categoria {
    private int id;
    private String desc;

    public Categoria(String desc, int id) {
        this.desc = desc;
        this.id = id;
    }

    public Categoria() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
