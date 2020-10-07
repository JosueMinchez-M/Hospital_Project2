package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Doctor;
import com.mycompany.hospitalproject2.Laboratorista;
import com.mycompany.hospitalproject2.conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joshua
 */
public class LaboratoristaDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta; 
    
    public Laboratorista validar(String user, String pass){
        Laboratorista laboratorista = new Laboratorista();
        String sql = "SELECT * FROM Laboratorista where codigo=? and password=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                laboratorista.setCodigo(rs.getString("codigo"));
                laboratorista.setNombre(rs.getString("nombre"));
                laboratorista.setNumero_registro(rs.getString("numero_registro_MS"));
                laboratorista.setDpi(rs.getString("dpi"));
                laboratorista.setTelefono(rs.getString("telefono"));
                laboratorista.setExamen_realizar(rs.getString("examen_realizar"));
                laboratorista.setCorreo(rs.getString("correo_electronico"));
                laboratorista.setFecha_trabajar(rs.getDate("fecha_inicio_a_trabajar"));
                laboratorista.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return laboratorista;
    }
    public List listar(){
        String sql = "SELECT * FROM Laboratorista";
        List <Laboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Laboratorista lab = new Laboratorista();
                lab.setCodigo(rs.getString(1));
                lab.setNombre(rs.getString(2));
                lab.setNumero_registro(rs.getString(3));
                lab.setDpi(rs.getString(4));
                lab.setTelefono(rs.getString(5));
                lab.setExamen_realizar(rs.getString(6));
                lab.setCorreo(rs.getString(7));
                lab.setFecha_trabajar(Date.valueOf(rs.getString(8)));
                lab.setPassword(rs.getString(9));
                lista.add(lab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Laboratorista lab){
        String sql = "INSERT INTO Laboratorista(codigo, nombre, numero_registro_MS, dpi, telefono, examen_realiza, "
                + "correo_electronico, fecha_inicio_a_trabajar, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lab.getCodigo());
            ps.setString(2, lab.getNombre());
            ps.setString(3, lab.getNumero_registro());
            ps.setString(4, lab.getDpi());
            ps.setString(5, lab.getTelefono());
            ps.setString(6, lab.getExamen_realizar());
            ps.setString(7, lab.getCorreo());
            ps.setDate(8, lab.getFecha_trabajar());
            ps.setString(9, lab.getPassword());           
            ps.executeUpdate();
            respuesta = 1;
        } catch (Exception e) {
            respuesta = 2;
        }
        return respuesta;
    }
    public Laboratorista listarId(String codLaboratorista){
        Laboratorista lab = new Laboratorista();
        String sql = "SELECT * FROM Laboratorista WHERE codigo =?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codLaboratorista);
            rs = ps.executeQuery();
            while(rs.next()){
                lab.setCodigo(rs.getString("codigo"));
                lab.setNombre(rs.getString("nombre"));
                lab.setNumero_registro(rs.getString("numero_registro_MS"));
                lab.setDpi(rs.getString("dpi"));
                lab.setTelefono(rs.getString("telefono"));
                lab.setExamen_realizar(rs.getString("examen_realiza"));
                lab.setCorreo(rs.getString("correo_electronico"));
                lab.setFecha_trabajar(Date.valueOf(rs.getString("fecha_inicio_a_trabajar")));
                lab.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return lab;
    }
    public int actualizar(Laboratorista lab){
        String sql = "UPDATE Laboratorista SET nombre=?, numero_registro_MS=?, dpi=?, telefono=?, examen_realiza=?, "
                + "correo_electronico=?, fecha_inicio_a_trabajar=?, password=? WHERE codigo=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lab.getNombre());
            ps.setString(2, lab.getNumero_registro());
            ps.setString(3, lab.getDpi());
            ps.setString(4, lab.getTelefono());
            ps.setString(5, lab.getExamen_realizar());
            ps.setString(6, lab.getCorreo());
            ps.setDate(7, lab.getFecha_trabajar());
            ps.setString(8, lab.getPassword()); 
            ps.setString(9, lab.getCodigo());
            ps.executeUpdate();
            respuesta = 3;
        } catch (Exception e) {
            respuesta = 4;
        }
        return respuesta;
    }
    public int actualizarSinPass(Laboratorista lab){
        String sql = "UPDATE Laboratorista SET nombre=?, numero_registro_MS=?, dpi=?, telefono=?, examen_realiza=?, "
                + "correo_electronico=?, fecha_inicio_a_trabajar=? WHERE codigo=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, lab.getNombre());
            ps.setString(2, lab.getNumero_registro());
            ps.setString(3, lab.getDpi());
            ps.setString(4, lab.getTelefono());
            ps.setString(5, lab.getExamen_realizar());
            ps.setString(6, lab.getCorreo());
            ps.setDate(7, lab.getFecha_trabajar());
            ps.setString(8, lab.getCodigo());
            ps.executeUpdate();
            respuesta = 3;
        } catch (Exception e) {
            respuesta = 4;
        }
        return respuesta;
    }
    public List listarTablaNombres(String datoBuscarNombre){
        String sql = "SELECT codigo, nombre, numero_registro_MS, dpi, "
                + "examen_realiza, correo_electronico, fecha_inicio_a_trabajar FROM Laboratorista "
                + "WHERE (UPPER(nombre) LIKE UPPER('%"+datoBuscarNombre+"%'))";
        List <Laboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Laboratorista lab = new Laboratorista();
                lab.setCodigo(rs.getString(1));
                lab.setNombre(rs.getString(2));
                lab.setNumero_registro(rs.getString(3));
                lab.setDpi(rs.getString(4));
                lab.setExamen_realizar(rs.getString(5));
                lab.setCorreo(rs.getString(6));
                lab.setFecha_trabajar(rs.getDate(7));
                lista.add(lab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarTablaExam(String datoBuscarNombre){
        String sql = "SELECT codigo, nombre, numero_registro_MS, dpi, "
                + "examen_realiza, correo_electronico, fecha_inicio_a_trabajar FROM Laboratorista "
                + "WHERE (UPPER(examen_realiza) LIKE UPPER('%"+datoBuscarNombre+"%'))";
        List <Laboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Laboratorista lab = new Laboratorista();
                lab.setCodigo(rs.getString(1));
                lab.setNombre(rs.getString(2));
                lab.setNumero_registro(rs.getString(3));
                lab.setDpi(rs.getString(4));
                lab.setExamen_realizar(rs.getString(5));
                lab.setCorreo(rs.getString(6));
                lab.setFecha_trabajar(rs.getDate(7));
                lista.add(lab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public List listarTablaRangoFech(String fechaMenor, String fechaMayor){
        String sql = "SELECT codigo, nombre, numero_registro_MS, dpi, "
                + "examen_realiza, correo_electronico, fecha_inicio_a_trabajar FROM Laboratorista "
                + "WHERE fecha_inicio_a_trabajar BETWEEN '"+fechaMenor+"' AND '"+fechaMayor+"'";
        List <Laboratorista>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Laboratorista lab = new Laboratorista();
                lab.setCodigo(rs.getString(1));
                lab.setNombre(rs.getString(2));
                lab.setNumero_registro(rs.getString(3));
                lab.setDpi(rs.getString(4));
                lab.setExamen_realizar(rs.getString(5));
                lab.setCorreo(rs.getString(6));
                lab.setFecha_trabajar(rs.getDate(7));
                lista.add(lab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
