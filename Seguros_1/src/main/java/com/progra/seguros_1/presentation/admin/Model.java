/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.presentation.admin;

import com.progra.seguros_1.presentation.login.*;
import com.progra.seguros_1.logic.Poliza;
import com.progra.seguros_1.logic.Usuario;
import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Model {
    Usuario current;
    Poliza poliza;
    
    
    public Model(){
        this.current = new Usuario();
    }
    public Usuario getCurrent() {
        return current;
    }
    public void setCurrent(Usuario current) {
        this.current = current;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Model other = (Model) obj;
        return Objects.equals(this.current, other.current);
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.current);
        return hash;
    }
}
