/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.seguros_1.data;
import com.progra.seguros_1.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author mauri
 */
public class UsuarioDao {
    RelDatabase db;

    public UsuarioDao(RelDatabase db){
        this.db= db;
    }
    
    public Usuario read(String cedula) throws Exception {
        String sql = "select " +
                "* " +
                "from  Usuario e " +
                "where e.cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "e");
        } else {
            throw new Exception("Empleado no Existe");
        }
    }
    public Usuario from(ResultSet rs, String alias) {
        try {
            Usuario e = new Usuario();
            e.setId(rs.getString(alias + ".cedula"));
            e.setNombre(rs.getString(alias+".nombre"));
            e.setClave(rs.getString(alias + ".clave"));
            e.setTelefono(rs.getString(alias + ".telefono"));
            e.setCorreo(rs.getString(alias + ".correo"));
            e.setDatosTarjeta(rs.getString(alias + ".tarjeta"));
            e.setTipo(rs.getInt(alias + ".tipo"));
            
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }  
}
