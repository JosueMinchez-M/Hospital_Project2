package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Administrador;
import com.mycompany.hospitalproject2.Paciente;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joshua
 */
public class AdministradorDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    
    public Administrador validar(String user, String pass){
        Administrador administrador = new Administrador();
        String sql = "SELECT * FROM Administrador where codigo=? and password=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                administrador.setCodigo(rs.getString("codigo"));
                administrador.setNombre(rs.getString("nombre"));
                administrador.setDpi(rs.getString("dpi"));
                administrador.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return administrador;
    }
}
