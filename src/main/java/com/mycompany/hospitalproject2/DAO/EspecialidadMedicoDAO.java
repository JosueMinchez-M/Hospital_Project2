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
        } catch (Exception e) {
        }
        return respuesta;
    }
}
