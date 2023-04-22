/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.data;
import com.progra.seguros_1.logic.Poliza;
import com.progra.seguros_1.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mauri
 */
public class PolizaDao {
    RelDatabase db;

    public PolizaDao(RelDatabase db){
        this.db= db;
    }
    public Poliza read(String numPlaca) throws Exception {
        String sql = "select " +
                "* " +
                "from poliza e" +
                "where e.numPlaca=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, numPlaca);
        ResultSet rs = db.executeQuery(stm);
        
        Poliza c;
        if (rs.next()) {
            c = from(rs, "e");
            return c;
        } else {
            throw new Exception("Poliza no Existe");
        }
    }

    public List<Poliza> findByUsuario(Usuario usuario) throws Exception {
        List<Poliza> resultado = new ArrayList<>();
        try {
            String sql = "select * " +
                    "from " +
                    "poliza e " +
                    "where e.cedulaUsuario=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, usuario.getId());
            ResultSet rs = db.executeQuery(stm);
            ModeloDao modeloDao = new ModeloDao(db);
            CoberturaDao coberturaDao = new CoberturaDao(db);
            Poliza poliza;
            while (rs.next()) {
                poliza = from(rs, "e");
                poliza.setUsuario(usuario);
                poliza.setModelo(modeloDao.read(rs.getString("e.modelo")));
                poliza.setCoberturas(coberturaDao.findByPoliza(poliza.getPlaca()));
                resultado.add(poliza);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    private Poliza from(ResultSet rs, String alias) {
        try {
            Poliza e = new Poliza();
            e.setPlaca(rs.getString(alias+".numPlaca"));
            e.setFecha(rs.getString(alias+".fecha"));
            e.setAno(rs.getString(alias+".ano"));
            e.setValor(rs.getFloat(alias+".valor"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
}
