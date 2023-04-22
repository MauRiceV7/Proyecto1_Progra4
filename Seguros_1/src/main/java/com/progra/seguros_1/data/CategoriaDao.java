/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.data;
import com.progra.seguros_1.logic.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauri
 */
public class CategoriaDao {
    RelDatabase db;

    public CategoriaDao(RelDatabase db){
        this.db= db;
    }
    
    public Categoria read(String cedula) throws Exception {
        String sql = "select " +
                "* " +
                "from  categoria e " +
                "where e.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "e");
        } else {
            throw new Exception("Categoria no Existe");
        }
    }
    public List<Categoria> readAll() throws Exception{
        List<Categoria> list = new ArrayList();
        try{
        String sql = "select " +
                "* " +
                "from  categoria e";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        
        while(rs.next()){
            list.add(from(rs, "e"));
        }
        } catch (SQLException ex){
            
        }
        return list;
    }
    
    public Categoria from(ResultSet rs, String alias) {
        try {
            Categoria e = new Categoria();
            e.setId(rs.getInt(alias + ".id"));
            e.setDesc(rs.getString(alias + ".descripcion"));         
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
}
