package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Doctor;
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
public class DoctorDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
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
    public List listar(){
        String sql = "SELECT * FROM Medico";
        List <Doctor>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Doctor doc = new Doctor();
                doc.setCodigo(rs.getString(1));
                doc.setNombre(rs.getString(2));
                doc.setColegiado(rs.getString(3));
                doc.setDpi(rs.getString(4));
                doc.setTelefono(rs.getString(5));
                doc.setCorreo(rs.getString(6));
                doc.setHorario_Inicio(rs.getString(7));
                doc.setHorario_Fin(rs.getString(8));
                doc.setInicio_trabajar(rs.getDate(9));
                doc.setPassword(rs.getString(10));
                lista.add(doc);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Doctor doc){
        String sql = "INSERT INTO Medico(codigo, nombre, numero_colegiado, dpi, telefono, correo_electronico, "
                + "horario_inicio_trabajo, horario_fin_trabajo, fecha_inicio_trabajo, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, doc.getCodigo());
            ps.setString(2, doc.getNombre());
            ps.setString(3, doc.getColegiado());
            ps.setString(4, doc.getDpi());
            ps.setString(5, doc.getTelefono());
            ps.setString(6, doc.getCorreo());
            ps.setString(7, doc.getHorario_Inicio());
            ps.setString(8, doc.getHorario_Fin());
            ps.setDate(9, doc.getInicio_trabajar());
            ps.setString(10, doc.getPassword());           
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
    
    public Doctor listarId(String codDoctor){
        Doctor doc = new Doctor();
        String sql = "SELECT * FROM Medico WHERE codigo =?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codDoctor);
            rs = ps.executeQuery();
            while(rs.next()){
                doc.setCodigo(rs.getString("codigo"));
                doc.setNombre(rs.getString("nombre"));
                doc.setColegiado(rs.getString("numero_colegiado"));
                doc.setDpi(rs.getString("dpi"));
                doc.setTelefono(rs.getString("telefono"));
                doc.setCorreo(rs.getString("correo_electronico"));
                doc.setHorario_Inicio(rs.getString("horario_inicio_trabajo"));
                doc.setHorario_Fin(rs.getString("horario_fin_trabajo"));
                doc.setInicio_trabajar(rs.getDate("fecha_inicio_trabajo"));
                doc.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return doc;
    }
    public int actualizar(Doctor doc){
        String sql = "UPDATE Medico nombre=?, numero_colegiado=?, dpi=?, telefono=?, correo_electronico=?, "
                + "horario_inicio_trabajo=?, horario_fin_trabajo=?, fecha_inicio_trabajo=?, password=? WHERE codigo=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, doc.getNombre());
            ps.setString(2, doc.getColegiado());
            ps.setString(3, doc.getDpi());
            ps.setString(4, doc.getTelefono());
            ps.setString(5, doc.getCorreo());
            ps.setString(6, doc.getHorario_Inicio());
            ps.setString(7, doc.getHorario_Fin());
            ps.setDate(8, doc.getInicio_trabajar());
            ps.setString(9, doc.getPassword());  
            ps.setString(10, doc.getCodigo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
}
