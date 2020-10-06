package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Paciente;
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
public class PacienteDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    public Paciente validar(String user, String pass){
        Paciente paciente = new Paciente();
        String sql = "SELECT * FROM Paciente where codigo=? and password=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                paciente.setCodigo(rs.getString("codigo"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                paciente.setDpi(rs.getString("dpi"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setPeso_kg(rs.getDouble("peso_kg"));
                paciente.setTipo_Sangre(rs.getString("tipo_sangre"));
                paciente.setCorreo(rs.getString("correo_electronico"));
                paciente.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return paciente;
    }
    
    public List listar(){
        String sql = "SELECT * FROM Paciente";
        List <Paciente>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Paciente paciente = new Paciente();
                paciente.setCodigo(rs.getString(1));
                paciente.setNombre(rs.getString(2));
                paciente.setSexo(rs.getString(3));
                paciente.setFecha_nacimiento(rs.getDate(4));
                paciente.setDpi(rs.getString(5));
                paciente.setTelefono(rs.getString(6));
                paciente.setPeso_kg(rs.getDouble(7));
                paciente.setTipo_Sangre(rs.getString(8));
                paciente.setCorreo(rs.getString(9));
                paciente.setPassword(rs.getString(10));
                lista.add(paciente);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Paciente paciente){
        String sql = "INSERT INTO Paciente(codigo, nombre, sexo, fecha_nacimiento, dpi, telefono, "
                + "peso_kg, tipo_sangre, correo_electronico, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, paciente.getCodigo());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getSexo());
            ps.setDate(4, paciente.getFecha_nacimiento());
            ps.setString(5, paciente.getDpi());
            ps.setString(6, paciente.getTelefono());
            ps.setDouble(7, paciente.getPeso_kg());
            ps.setString(8, paciente.getTipo_Sangre());
            ps.setString(9, paciente.getCorreo());
            ps.setString(10, paciente.getPassword());           
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
    
    public Paciente listarId(String codPac){
        Paciente pac = new Paciente();
        String sql = "SELECT * FROM Paciente WHERE codigo =?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codPac);
            rs = ps.executeQuery();
            while(rs.next()){
                pac.setCodigo(rs.getString("codigo"));
                pac.setNombre(rs.getString("nombre"));
                pac.setSexo(rs.getString("sexo"));
                pac.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                pac.setDpi(rs.getString("dpi"));
                pac.setTelefono(rs.getString("telefono"));
                pac.setPeso_kg(rs.getDouble("peso_kg"));
                pac.setTipo_Sangre(rs.getString("tipo_sangre"));
                pac.setCorreo(rs.getString("correo_electronico"));
                pac.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
        }
        return pac;
    }
    public int actualizar(Paciente paci){
        String sql = "UPDATE Paciente SET nombre=?, sexo=?, fecha_nacimiento=?, dpi=?, telefono=?, "
                + "peso_kg=?, tipo_sangre=?, correo_electronico=?, password=? WHERE codigo=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, paci.getNombre());
            ps.setString(2, paci.getSexo());
            ps.setDate(3, paci.getFecha_nacimiento());
            ps.setString(4, paci.getDpi());
            ps.setString(5, paci.getTelefono());
            ps.setDouble(6, paci.getPeso_kg());
            ps.setString(7, paci.getTipo_Sangre());
            ps.setString(8, paci.getCorreo());
            ps.setString(9, paci.getPassword());  
            ps.setString(10, paci.getCodigo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
    
    public int cantidadPacientes(){
        int cantidad = 0;
        String sql = "SELECT COUNT(*) FROM Paciente";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cantidad = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return cantidad;
    }
}
