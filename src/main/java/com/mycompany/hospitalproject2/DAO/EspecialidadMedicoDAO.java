package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Doctor;
import com.mycompany.hospitalproject2.EspecialidadMedico;
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
public class EspecialidadMedicoDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    public List listar(){
        String sql = "SELECT * FROM especialidad_medico";
        List <Doctor>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Doctor doc = new Doctor();
                doc.setCodigo(rs.getString(1));
                doc.setEspecialidad(rs.getString(2));
                lista.add(doc);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(EspecialidadMedico especialidadMedico){
        String sql = "INSERT INTO especialidad_medico(Medico_codigo, Especialidad_titulo) VALUES(?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, especialidadMedico.getCodigo_medico());
            ps.setString(2, especialidadMedico.getEspecialidad());           
            ps.executeUpdate();
            respuesta = 1;
        } catch (Exception e) {
            respuesta = 2;
        }
        return respuesta;
    }
    public List listarInfoMedico(){
        String sql = "SELECT Medico.nombre, Medico.numero_colegiado, Medico.dpi, Medico.correo_electronico, "
                + "Medico.horario_inicio_trabajo, Medico.horario_fin_trabajo, Medico.fecha_inicio_trabajo, "
                + "especialidad_medico.Medico_codigo, especialidad_medico.Especialidad_titulo FROM "
                + "Medico INNER JOIN especialidad_medico ON Medico.codigo=especialidad_medico.Medico_codigo";
        List <Doctor>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Doctor doc = new Doctor();
                doc.setNombre(rs.getString(1));
                doc.setColegiado(rs.getString(2));
                doc.setDpi(rs.getString(3));
                doc.setCorreo(rs.getString(4));
                doc.setHorario_Inicio(rs.getString(5));
                doc.setHorario_Fin(rs.getString(6));
                doc.setInicio_trabajar(rs.getDate(7));
                doc.setCodigo(rs.getString(8));
                doc.setEspecialidad(rs.getString(9));
                lista.add(doc);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    //String datoBuscarNombre, String datoBuscarEspecialidad, String datoBuscarFechaMenor, String datoBuscarFechaMayor
    public List listarTablaNombres(String datoBuscarNombre){
        String sql = "SELECT Medico.nombre, Medico.numero_colegiado, Medico.dpi, Medico.correo_electronico, "
                + "Medico.horario_inicio_trabajo, Medico.horario_fin_trabajo, Medico.fecha_inicio_trabajo, "
                + "especialidad_medico.Medico_codigo, especialidad_medico.Especialidad_titulo FROM Medico,  "
                + "especialidad_medico WHERE Medico.codigo=especialidad_medico.Medico_codigo AND (UPPER(Medico.nombre) "
                + "LIKE UPPER('%"+datoBuscarNombre+"%') OR UPPER(especialidad_medico.Especialidad_titulo) LIKE UPPER ('') OR "
                + "Medico.fecha_inicio_trabajo BETWEEN '' AND '')";
        List <Doctor>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Doctor doc = new Doctor();
                doc.setNombre(rs.getString(1));
                doc.setColegiado(rs.getString(2));
                doc.setDpi(rs.getString(3));
                doc.setCorreo(rs.getString(4));
                doc.setHorario_Inicio(rs.getString(5));
                doc.setHorario_Fin(rs.getString(6));
                doc.setInicio_trabajar(rs.getDate(7));
                doc.setCodigo(rs.getString(8));
                doc.setEspecialidad(rs.getString(9));
                lista.add(doc);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarTablaEsp(String datoBuscarEspecialidad){
        String sql = "SELECT Medico.nombre, Medico.numero_colegiado, Medico.dpi, Medico.correo_electronico, "
                + "Medico.horario_inicio_trabajo, Medico.horario_fin_trabajo, Medico.fecha_inicio_trabajo, "
                + "especialidad_medico.Medico_codigo, especialidad_medico.Especialidad_titulo FROM Medico,  "
                + "especialidad_medico WHERE Medico.codigo=especialidad_medico.Medico_codigo AND (UPPER(Medico.nombre) "
                + "LIKE UPPER('') OR UPPER(especialidad_medico.Especialidad_titulo) LIKE UPPER ('%"+datoBuscarEspecialidad+"%') OR "
                + "Medico.fecha_inicio_trabajo BETWEEN '' AND '')";
        List <Doctor>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Doctor doc = new Doctor();
                doc.setNombre(rs.getString(1));
                doc.setColegiado(rs.getString(2));
                doc.setDpi(rs.getString(3));
                doc.setCorreo(rs.getString(4));
                doc.setHorario_Inicio(rs.getString(5));
                doc.setHorario_Fin(rs.getString(6));
                doc.setInicio_trabajar(rs.getDate(7));
                doc.setCodigo(rs.getString(8));
                doc.setEspecialidad(rs.getString(9));
                lista.add(doc);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarTablaFecha(String datoFechaMenor, String datoFechaMayor){
        String sql = "SELECT Medico.nombre, Medico.numero_colegiado, Medico.dpi, Medico.correo_electronico, "
                + "Medico.horario_inicio_trabajo, Medico.horario_fin_trabajo, Medico.fecha_inicio_trabajo, "
                + "especialidad_medico.Medico_codigo, especialidad_medico.Especialidad_titulo FROM Medico,  "
                + "especialidad_medico WHERE Medico.codigo=especialidad_medico.Medico_codigo AND (UPPER(Medico.nombre) "
                + "LIKE UPPER('') OR UPPER(especialidad_medico.Especialidad_titulo) LIKE UPPER ('') OR "
                + "Medico.fecha_inicio_trabajo BETWEEN '"+datoFechaMenor+"' AND '"+datoFechaMayor+"')";
        List <Doctor>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Doctor doc = new Doctor();
                doc.setNombre(rs.getString(1));
                doc.setColegiado(rs.getString(2));
                doc.setDpi(rs.getString(3));
                doc.setCorreo(rs.getString(4));
                doc.setHorario_Inicio(rs.getString(5));
                doc.setHorario_Fin(rs.getString(6));
                doc.setInicio_trabajar(rs.getDate(7));
                doc.setCodigo(rs.getString(8));
                doc.setEspecialidad(rs.getString(9));
                lista.add(doc);
            }
        } catch (Exception e) {
        }
        return lista;
    }
//    public EspecialidadMedico listarId(String codEsMed){
//        EspecialidadMedico eM = new EspecialidadMedico();
//        String sql = "SELECT * FROM especialidad_medico WHERE Medico_codigo =?";
//        try {
//            acceso = conexion.Conectar();
//            ps = acceso.prepareStatement(sql);
//            ps.setString(1, codEsMed);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                eM.setEspecialidad(rs.getString("Especialidad_titulo"));
//                eM.setCodigo_medico(rs.getString("Medico_codigo"));
//            }
//        } catch (Exception e) {
//        }
//        return eM;
//    }
}
