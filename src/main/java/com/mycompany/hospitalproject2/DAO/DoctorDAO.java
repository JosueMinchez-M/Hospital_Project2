package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Doctor;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joshua
 */
public class DoctorDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    
    public Doctor validar(String user, String pass){
        Doctor doctor = new Doctor();
        String sql = "SELECT * FROM Medico where codigo=? and password=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                doctor.setCodigo(rs.getString("codigo"));
                doctor.setNombre(rs.getString("nombre"));
                doctor.setColegiado(rs.getString("numero_colegiado"));
                doctor.setDpi(rs.getString("dpi"));
                doctor.setTelefono(rs.getString("telefono"));
                doctor.setCorreo(rs.getString("correo_electronico"));
                doctor.setHorario_Inicio(rs.getString("horario_inicio_trabajo"));
                doctor.setHorario_Fin(rs.getString("horario_fin_trabajo"));
                doctor.setInicio_trabajar(rs.getDate("fecha_inicio_trabajo"));
                doctor.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return doctor;
    }
}
