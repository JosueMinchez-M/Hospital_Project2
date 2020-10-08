package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Cita;
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
            respuesta = 1;
        } catch (Exception e) {
            respuesta = 2;
        }
        return respuesta;
    }
    public List listar(String codigoCitaDoc){
        String sql = "SELECT * FROM Cita WHERE Paciente_codigo= '"+codigoCitaDoc.replaceAll("\\r|\\n", "")+"' "
                + "AND DATE(fecha_consulta) >= DATE(NOW())";
        List <Cita>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cita cit = new Cita();
                cit.setCodigo(rs.getString(1));
                cit.setEspecialidad(rs.getString(2));
                cit.setFecha(rs.getDate(3));
                cit.setHora(rs.getString(4));
                cit.setPaciente(rs.getString(5));
                cit.setMedico(rs.getString(6));
                lista.add(cit);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarCitaRealizadaMedico(String codigoCitaDoc){
        String sql = "SELECT * FROM Cita WHERE Paciente_codigo= '"+codigoCitaDoc.replaceAll("\\r|\\n", "")+"' "
                + "AND DATE(fecha_consulta) < DATE(NOW())";
        List <Cita>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cita cit = new Cita();
                cit.setCodigo(rs.getString(1));
                cit.setEspecialidad(rs.getString(2));
                cit.setFecha(rs.getDate(3));
                cit.setHora(rs.getString(4));
                cit.setPaciente(rs.getString(5));
                cit.setMedico(rs.getString(6));
                lista.add(cit);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarCitaRealizadaMedicoCodPacyMed(String codPaciente, String codDoc){
        String sql = "SELECT * FROM Cita WHERE Paciente_codigo= '"+codPaciente.replaceAll("\\r|\\n", "")+"' "
                + "AND Medico_codigo = '"+codDoc+"' AND DATE(fecha_consulta) < DATE(NOW())";
        List <Cita>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cita cit = new Cita();
                cit.setCodigo(rs.getString(1));
                cit.setEspecialidad(rs.getString(2));
                cit.setFecha(rs.getDate(3));
                cit.setHora(rs.getString(4));
                cit.setPaciente(rs.getString(5));
                cit.setMedico(rs.getString(6));
                lista.add(cit);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List listarCitaDoctor(String codigoCitaDoc){
        String sql = "SELECT * FROM Cita WHERE Medico_codigo= '"+codigoCitaDoc.replaceAll("\\r|\\n", "")+"'"; //AND DATE(fecha_consulta) >= DATE(NOW())
        List <Cita>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cita cit = new Cita();
                cit.setCodigo(rs.getString(1));
                cit.setEspecialidad(rs.getString(2));
                cit.setFecha(rs.getDate(3));
                cit.setHora(rs.getString(4));
                cit.setPaciente(rs.getString(5));
                cit.setMedico(rs.getString(6));
                lista.add(cit);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public Cita listarId(String codCita){
        Cita cit = new Cita();
        String sql = "SELECT * FROM Cita WHERE codigo ='"+codCita+"'";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cit.setCodigo(rs.getString("codigo"));
                cit.setEspecialidad(rs.getString("especialidad"));
                cit.setFecha(rs.getDate("fecha_consulta"));
                cit.setHora(rs.getString("hora_establecida_consulta"));
                cit.setPaciente(rs.getString("Paciente_codigo"));
                cit.setMedico(rs.getString("Medico_codigo"));
            }
        } catch (Exception e) {
        }
        return cit;
    }
    public List listarCitaBuscada(String codigoCitaDoc){
        String sql = "SELECT * FROM Cita WHERE codigo= '"+codigoCitaDoc.replaceAll("\\r|\\n", "")+"'"; //AND DATE(fecha_consulta) >= DATE(NOW())
        List <Cita>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cita cit = new Cita();
                cit.setCodigo(rs.getString(1));
                cit.setEspecialidad(rs.getString(2));
                cit.setFecha(rs.getDate(3));
                cit.setHora(rs.getString(4));
                cit.setPaciente(rs.getString(5));
                cit.setMedico(rs.getString(6));
                lista.add(cit);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarConsulta4(String codigoPaciente, String codMedico, String fechaMenor, String fechaMayor){
        String sql = "SELECT * FROM Cita WHERE Paciente_codigo= '"+codigoPaciente.replaceAll("\\r|\\n", "")+"' "
                + "AND Medico_codigo = '"+codMedico+"' AND fecha_consulta BETWEEN '"+fechaMenor+"' AND '"+fechaMayor+"' AND "
                + "DATE(fecha_consulta) < DATE(NOW()) ORDER BY fecha_consulta DESC";
        List <Cita>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cita cit = new Cita();
                cit.setCodigo(rs.getString(1));
                cit.setEspecialidad(rs.getString(2));
                cit.setFecha(rs.getDate(3));
                cit.setHora(rs.getString(4));
                cit.setPaciente(rs.getString(5));
                cit.setMedico(rs.getString(6));
                lista.add(cit);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarConsulta2Medico(String codMedico, String fechaMenor, String fechaMayor){
        String sql = "SELECT * FROM Cita WHERE Medico_codigo = '"+codMedico+"' AND fecha_consulta "
                + "BETWEEN '"+fechaMenor+"' AND '"+fechaMayor+"' ORDER BY fecha_consulta DESC";
        List <Cita>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cita cit = new Cita();
                cit.setCodigo(rs.getString(1));
                cit.setEspecialidad(rs.getString(2));
                cit.setFecha(rs.getDate(3));
                cit.setHora(rs.getString(4));
                cit.setPaciente(rs.getString(5));
                cit.setMedico(rs.getString(6));
                lista.add(cit);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarConsulta3Medico(String codMedico){
        String sql = "SELECT * FROM Cita WHERE Medico_codigo = '"+codMedico+"' AND DATE(fecha_consulta) = DATE(NOW())";
        List <Cita>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Cita cit = new Cita();
                cit.setCodigo(rs.getString(1));
                cit.setEspecialidad(rs.getString(2));
                cit.setFecha(rs.getDate(3));
                cit.setHora(rs.getString(4));
                cit.setPaciente(rs.getString(5));
                cit.setMedico(rs.getString(6));
                lista.add(cit);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
