package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.CitaLaboratorista;
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
public class CitaLaboratoristaDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    public List listar(String codigoCitaLab){
        String sql = "SELECT * FROM CitaLaboratorista WHERE Paciente_codigo= '"+codigoCitaLab.replaceAll("\\r|\\n", "")+"' "
                + "AND DATE(fecha_citaLab) >= DATE(NOW())";
        List <CitaLaboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            //ps.setString(1, codigoCitaLab);
            rs = ps.executeQuery();
            while (rs.next()) {                
                CitaLaboratorista citLab = new CitaLaboratorista();
                citLab.setCodigo(rs.getString(1));
                citLab.setCodigoExamen(rs.getString(2));
                citLab.setFechaCitaLab(rs.getDate(3));
                citLab.setHoraEstablecida(rs.getString(4));
                citLab.setCodigoPaciente(rs.getString(5));
                citLab.setCodigoLaboratorista(rs.getString(6));
                citLab.setCodigoMedico(rs.getString(7));
                lista.add(citLab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarCitasRealizadasLab(String codigoCitaLab){
        String sql = "SELECT * FROM CitaLaboratorista WHERE Paciente_codigo= '"+codigoCitaLab.replaceAll("\\r|\\n", "")+"' "
                + "AND DATE(fecha_citaLab) < DATE(NOW())";
        List <CitaLaboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            //ps.setString(1, codigoCitaLab);
            rs = ps.executeQuery();
            while (rs.next()) {                
                CitaLaboratorista citLab = new CitaLaboratorista();
                citLab.setCodigo(rs.getString(1));
                citLab.setCodigoExamen(rs.getString(2));
                citLab.setFechaCitaLab(rs.getDate(3));
                citLab.setHoraEstablecida(rs.getString(4));
                citLab.setCodigoPaciente(rs.getString(5));
                citLab.setCodigoLaboratorista(rs.getString(6));
                citLab.setCodigoMedico(rs.getString(7));
                lista.add(citLab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(CitaLaboratorista citaLab){
        String sql = "INSERT INTO CitaLaboratorista(codigo, Examen_laboratorio_codigo, fecha_citaLab, "
                + "hora_establecida_citaLab, Paciente_codigo, Laboratorista_codigo, Medico_codigo) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, citaLab.getCodigo());
            ps.setString(2, citaLab.getCodigoExamen());
            ps.setDate(3, citaLab.getFechaCitaLab());
            ps.setString(4, citaLab.getHoraEstablecida());
            ps.setString(5, citaLab.getCodigoPaciente());
            ps.setString(6, citaLab.getCodigoLaboratorista());
            ps.setString(7, citaLab.getCodigoMedico());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
    public List listarCitaLab(String codigoCitaLab){
        String sql = "SELECT * FROM CitaLaboratorista WHERE Laboratorista_codigo= '"+codigoCitaLab.replaceAll("\\r|\\n", "")+"'"; //AND DATE(fecha_citaLab) >= DATE(NOW())
        List <CitaLaboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            //ps.setString(1, codigoCitaLab);
            rs = ps.executeQuery();
            while (rs.next()) {                
                CitaLaboratorista citLab = new CitaLaboratorista();
                citLab.setCodigo(rs.getString(1));
                citLab.setCodigoExamen(rs.getString(2));
                citLab.setFechaCitaLab(rs.getDate(3));
                citLab.setHoraEstablecida(rs.getString(4));
                citLab.setCodigoPaciente(rs.getString(5));
                citLab.setCodigoLaboratorista(rs.getString(6));
                citLab.setCodigoMedico(rs.getString(7));
                lista.add(citLab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarCitaLabPorCod(String codigoCitaLab){
        String sql = "SELECT * FROM CitaLaboratorista WHERE codigo= '"+codigoCitaLab.replaceAll("\\r|\\n", "")+"'"; //AND DATE(fecha_citaLab) >= DATE(NOW())
        List <CitaLaboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            //ps.setString(1, codigoCitaLab);
            rs = ps.executeQuery();
            while (rs.next()) {                
                CitaLaboratorista citLab = new CitaLaboratorista();
                citLab.setCodigo(rs.getString(1));
                citLab.setCodigoExamen(rs.getString(2));
                citLab.setFechaCitaLab(rs.getDate(3));
                citLab.setHoraEstablecida(rs.getString(4));
                citLab.setCodigoPaciente(rs.getString(5));
                citLab.setCodigoLaboratorista(rs.getString(6));
                citLab.setCodigoMedico(rs.getString(7));
                lista.add(citLab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public CitaLaboratorista listarId(String codCita){
        CitaLaboratorista citLab = new CitaLaboratorista();
        String sql = "SELECT * FROM CitaLaboratorista WHERE codigo ='"+codCita+"'";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                citLab.setCodigo(rs.getString("codigo"));
                citLab.setCodigoExamen(rs.getString("Examen_laboratorio_codigo"));
                citLab.setFechaCitaLab(rs.getDate("fecha_citaLab"));
                citLab.setHoraEstablecida(rs.getString("hora_establecida_citaLab"));
                citLab.setCodigoPaciente(rs.getString("Paciente_codigo"));
                citLab.setCodigoLaboratorista(rs.getString("Laboratorista_codigo"));
                citLab.setCodigoMedico(rs.getString("Medico_codigo"));
            }
        } catch (Exception e) {
        }
        return citLab;
    }
    
    public List listarConsulta1(String codigoCitaLab){
        String sql = "SELECT * FROM CitaLaboratorista WHERE Paciente_codigo= '"+codigoCitaLab.replaceAll("\\r|\\n", "")+"' "
                + "AND DATE(fecha_citaLab) < DATE(NOW()) ORDER BY fecha_citaLab DESC LIMIT 5";
        List <CitaLaboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            //ps.setString(1, codigoCitaLab);
            rs = ps.executeQuery();
            while (rs.next()) {                
                CitaLaboratorista citLab = new CitaLaboratorista();
                citLab.setCodigo(rs.getString(1));
                citLab.setCodigoExamen(rs.getString(2));
                citLab.setFechaCitaLab(rs.getDate(3));
                citLab.setHoraEstablecida(rs.getString(4));
                citLab.setCodigoPaciente(rs.getString(5));
                citLab.setCodigoLaboratorista(rs.getString(6));
                citLab.setCodigoMedico(rs.getString(7));
                lista.add(citLab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarConsulta2(String codigoCitaLab, String codExamen, String fechaMenor, String fechaMayor){
        String sql = "SELECT * FROM CitaLaboratorista WHERE Paciente_codigo= '"+codigoCitaLab.replaceAll("\\r|\\n", "")+"' "
                + "AND Examen_laboratorio_codigo = '"+codExamen+"' AND fecha_citaLab BETWEEN '"+fechaMenor+"' AND '"+fechaMayor+"' "
                + "AND DATE(fecha_citaLab) < DATE(NOW()) ORDER BY fecha_citaLab DESC";
        List <CitaLaboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                CitaLaboratorista citLab = new CitaLaboratorista();
                citLab.setCodigo(rs.getString(1));
                citLab.setCodigoExamen(rs.getString(2));
                citLab.setFechaCitaLab(rs.getDate(3));
                citLab.setHoraEstablecida(rs.getString(4));
                citLab.setCodigoPaciente(rs.getString(5));
                citLab.setCodigoLaboratorista(rs.getString(6));
                citLab.setCodigoMedico(rs.getString(7));
                lista.add(citLab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
