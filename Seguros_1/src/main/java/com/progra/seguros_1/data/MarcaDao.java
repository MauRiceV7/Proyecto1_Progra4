/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.data;

import com.progra.seguros_1.logic.Marca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauri
 */
public class MarcaDao {
     RelDatabase db;

    public MarcaDao(RelDatabase db){
        this.db= db;
    }
    
    public Marca read(String cedula) throws Exception {
        String sql = "select " +
                "* " +
                "from  marca e " +
                "where e.nombre=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "e");
        } else {
            throw new Exception("Marca no Existe");
        }
    }
    public List<Marca> readAll() throws Exception{
        List<Marca> marcas = new ArrayList();
        String sql = "select " +
                "* " +
                "from  marca e ";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        while(rs.next()){
            marcas.add(from(rs, "e"));
        }
        
        return marcas;
    }
    
    public Marca from(ResultSet rs, String alias) {
        try {
            Marca e = new Marca();
            e.setId(rs.getInt(alias + ".id"));
            e.setNombre(rs.getString(alias + ".nombre"));    
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }    
}
