package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Doctor;
import com.mycompany.hospitalproject2.Resultado;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joshua
 */
public class ResultadoDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    public int agregar(Resultado res){
        String sql = "INSERT INTO Resultado(codigo, orden, informe, fecha_realizo_examen, hora_cita, Paciente_codigo, "
                + "Medico_codigo, ExamenLaboratorio_codigo, Laboratorista_codigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, res.getCodigo());
            ps.setString(2, res.getOrden());
            ps.setString(3, res.getInforme());
            ps.setDate(4, res.getFecha());
            ps.setString(5, res.getHora());
            ps.setString(6, res.getPaciente());
            ps.setString(7, res.getMedico());
            ps.setString(8, res.getExamen());
            ps.setString(9, res.getLaboratorista());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
}
