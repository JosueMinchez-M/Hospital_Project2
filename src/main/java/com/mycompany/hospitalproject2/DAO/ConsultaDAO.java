package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Consulta;
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
public class ConsultaDAO {
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    public List listar(){
        String sql = "SELECT * FROM Consulta";
        List <Consulta>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Consulta consulta = new Consulta();
                consulta.setTipo(rs.getString(1));
                consulta.setCosto(rs.getInt(2));
                lista.add(consulta);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Consulta con){
        String sql = "INSERT INTO Consulta(tipo, costo) VALUES(?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, con.getTipo());
            ps.setInt(2, con.getCosto());          
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
    public Consulta listarId(String consulta){
        Consulta consul = new Consulta();
        String sql = "SELECT * FROM Consulta WHERE tipo =?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, consulta);
            rs = ps.executeQuery();
            while(rs.next()){
                consul.setTipo(rs.getString("tipo"));
                consul.setCosto(rs.getInt("costo"));
            }
        } catch (Exception e) {
        }
        return consul;
    }
    public int actualizar(Consulta con){
        String sql = "UPDATE Consulta SET costo=? WHERE tipo=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, con.getCosto());
            ps.setString(2, con.getTipo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return respuesta;
    }
}
