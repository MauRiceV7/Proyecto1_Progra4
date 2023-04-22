/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.data;

import com.progra.seguros_1.logic.Modelo;
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
public class ModeloDao {
    RelDatabase db;

    public ModeloDao(RelDatabase db){
        this.db= db;
    }
    
    public Modelo read(String id) throws Exception {
        String sql = "select " +
                "* " +
                "from  marca e " +
                "where e.id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        MarcaDao marcaDao = new MarcaDao(db);
        if (rs.next()) {
            return from(rs, "e", marcaDao.readAll());
        } else {
            throw new Exception("Marca no Existe");
        }
    }
    public List<Modelo> readAll(List<Marca> marcas) throws Exception{
        List<Modelo> modelos = new ArrayList();
        String sql = "select " +
                "* " +
                "from  modelo e ";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        while(rs.next()){
            modelos.add(from(rs, "e", marcas));
        }
        
        return modelos;
    }
    
    public Modelo from(ResultSet rs, String alias, List<Marca> marcas) {
        try {
            Modelo e = new Modelo();
            e.setId(rs.getInt(alias + ".id"));
            e.setNombre(rs.getString(alias + ".nombre")); 
            for(Marca c: marcas){
                if(c.getId() == rs.getInt(alias + ".marca")){
                    e.setMarca(c);
                    break;
                }
            }
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }     
}
