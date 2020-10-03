package com.mycompany.hospitalproject2.Controlador;

import com.mycompany.hospitalproject2.CitaLaboratorista;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
                lista.add(citLab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
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
