package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Paciente;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joshua
 */
public class PacienteDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    
    public Paciente validar(String user, String pass){
        Paciente paciente = new Paciente();
        String sql = "SELECT * FROM Paciente where codigo=? and password=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                paciente.setCodigo(rs.getString("codigo"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                paciente.setDpi(rs.getString("dpi"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setPeso_kg(rs.getDouble("peso_kg"));
                paciente.setTipo_Sangre(rs.getString("tipo_sangre"));
                paciente.setCorreo(rs.getString("correo_electronico"));
                paciente.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return paciente;
    }
}
