package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Reporte;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joshua
 */
public class ReporteDAO {
    
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    public int agregar(Reporte rep){
        String sql = "INSERT INTO Informe(codigo, informe_redactado, fecha_de_consulta, hora_de_cita, "
                + "Paciente_codigo, Medico_codigo) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, rep.getCodigo());
            ps.setString(2, rep.getInforme());
            ps.setDate(3, rep.getFecha());
            ps.setString(4, rep.getHora());
            ps.setString(5, rep.getPaciente());
            ps.setString(6, rep.getMedico());           
            ps.executeUpdate();
            respuesta = 1;
        } catch (Exception e) {
            respuesta = 2;
        }
        return respuesta;
    }
    public List listar(String codMedico){
        String sql = "SELECT Paciente_codigo, COUNT(*) FROM Informe WHERE Medico_codigo = '"+codMedico+"' GROUP "
                + "BY Paciente_codigo,Medico_codigo;";
        List <Reporte>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Reporte rep = new Reporte();
                rep.setPaciente(rs.getString(1));;
                rep.setHora(rs.getString(2));
                lista.add(rep);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarAdminConsulta1(){
        String sql = "SELECT Medico_codigo, COUNT(*) AS CantidadInformes FROM Informe GROUP BY Medico_codigo "
                + "ORDER BY CantidadInformes DESC LIMIT 10;";
        List <Reporte>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Reporte rep = new Reporte();
                rep.setPaciente(rs.getString(1));;
                rep.setHora(rs.getString(2));
                lista.add(rep);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
