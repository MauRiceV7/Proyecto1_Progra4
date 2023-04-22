/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.data;
import com.progra.seguros_1.logic.Categoria;
import com.progra.seguros_1.logic.Cobertura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author mauri
 */
public class CoberturaDao {
    RelDatabase db;

    public CoberturaDao(RelDatabase db){
        this.db= db;
    }
    
    public Cobertura read(String id) throws Exception {
        String sql = "select " +
                "* " +
                "from  cobertura e " +
                "where e.id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "e");
        } else {
            throw new Exception("Categoria no Existe");
        }
    }
    
    public List<Cobertura> readAll(List<Categoria> categ) throws Exception{
        List<Cobertura> list = new ArrayList();
        try{
        String sql = "select " +
                "* " +
                "from  cobertura e";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        
        while(rs.next()){
            list.add(from(rs, "e", categ));
        }
        } catch (SQLException ex){
            
        }
        return list;
    }
    
    public List<Cobertura> findByPoliza(String numPlacaPoliza) throws Exception{
        List<Cobertura> list = new ArrayList();
        try{
        String sql = "select " +
                "idCobertura " +
                "from  polizaCobertura e inner join cobertura c on e.idCobertura=c.id " +
                "where e.idPoliza=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, numPlacaPoliza);
        ResultSet rs = db.executeQuery(stm); 
        CategoriaDao categoriaDao = new CategoriaDao(db);
        List<Categoria> listCateg = categoriaDao.readAll();
        while(rs.next()){
            list.add(from(rs, "c",listCateg));
        }
        } catch (SQLException ex){
            
        }
        return list;
    }
    
    public Cobertura from(ResultSet rs, String alias) {
        try {
            Cobertura e = new Cobertura();
            e.setId(rs.getInt(alias + ".id"));
            e.setDesc(rs.getString(alias + ".descripcion"));  
            e.setCostoMin(rs.getInt(alias+".costoMin"));
            e.setCostPor(rs.getInt(alias + ".costoPor"));
            e.setCategoria(null);
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Cobertura from(ResultSet rs, String alias, List<Categoria> categ) {
        try {
            Cobertura e = new Cobertura();
            e.setId(rs.getInt(alias + ".id"));
            e.setDesc(rs.getString(alias + ".descripcion"));  
            e.setCostoMin(rs.getInt(alias+".costoMin"));
            e.setCostPor(rs.getInt(alias + ".costoPor"));
            
            for(Categoria c: categ){
                if(c.getId() == rs.getInt(alias + ".categoria")){
                    e.setCategoria(c);
                    break;
                }
            }
            
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
}
