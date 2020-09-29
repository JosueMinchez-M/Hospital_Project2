package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Laboratorista;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joshua
 */
public class LaboratoristaDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    
    public Laboratorista validar(String user, String pass){
        Laboratorista laboratorista = new Laboratorista();
        String sql = "SELECT * FROM Laboratorista where codigo=? and password=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                laboratorista.setCodigo(rs.getString("codigo"));
                laboratorista.setNombre(rs.getString("nombre"));
                laboratorista.setNumero_registro(rs.getString("numero_registro_MS"));
                laboratorista.setDpi(rs.getString("dpi"));
                laboratorista.setTelefono(rs.getString("telefono"));
                laboratorista.setExamen_realizar(rs.getString("examen_realizar"));
                laboratorista.setCorreo(rs.getString("correo_electronico"));
                laboratorista.setFecha_trabajar(rs.getDate("fecha_inicio_a_trabajar"));
                laboratorista.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return laboratorista;
    }
}
