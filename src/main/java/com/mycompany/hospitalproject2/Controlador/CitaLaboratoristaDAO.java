package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.CitaLaboratorista;
import com.mycompany.hospitalproject2.Doctor;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joshua
 */
public class CitaLaboratoristaDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    public int agregar(CitaLaboratorista citaLab){
        String sql = "INSERT INTO CitaLaboratorista(codigo, Examen_laboratorio_codigo, fecha_citaLab, "
                + "hora_establecida_citaLab, Paciente_codigo, Laboratorista_codigo) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, citaLab.getCodigo());
            ps.setString(2, citaLab.getCodigoExamen());
            ps.setDate(3, citaLab.getFechaCitaLab());
            ps.setString(4, citaLab.getHoraEstablecida());
            ps.setString(5, citaLab.getCodigoPaciente());
            ps.setString(6, citaLab.getCodigoLaboratorista());         
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
}
