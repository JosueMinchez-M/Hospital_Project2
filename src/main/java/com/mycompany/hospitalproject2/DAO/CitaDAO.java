package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Cita;
import com.mycompany.hospitalproject2.Doctor;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joshua
 */
public class CitaDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    public int agregar(Cita cita){
        String sql = "INSERT INTO Cita(codigo, especialidad, fecha_consulta, hora_establecida_consulta, "
                + "Paciente_codigo, Medico_codigo) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, cita.getCodigo());
            ps.setString(2, cita.getEspecialidad());
            ps.setDate(3, cita.getFecha());
            ps.setString(4, cita.getHora());
            ps.setString(5, cita.getPaciente());
            ps.setString(6, cita.getMedico());           
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
}
