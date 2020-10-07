package com.mycompany.hospitalproject2.DAO;

import com.mycompany.hospitalproject2.Examen;
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
public class ExamenDAO {
    
    Conexion conexion = new Conexion();
    Connection acceso;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    public List listar(){
        String sql = "SELECT * FROM ExamenLaboratorio";
        List <Examen>lista = new ArrayList<>();
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Examen ex = new Examen();
                ex.setCodigo(rs.getString(1));
                ex.setNombre(rs.getString(2));
                ex.setOrden(rs.getString(3));
                ex.setDescripcion(rs.getString(4));
                ex.setCosto(rs.getDouble(5));
                ex.setInforme(rs.getString(6));
                lista.add(ex);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Examen examen){
        String sql = "INSERT INTO ExamenLaboratorio(codigo, nombre, requerimiento_orden_medico, descripcion, costo, "
                + "informe) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, examen.getCodigo());
            ps.setString(2, examen.getNombre());
            ps.setString(3, examen.getOrden());
            ps.setString(4, examen.getDescripcion());
            ps.setDouble(5, examen.getCosto());
            ps.setString(6, examen.getInforme());          
            ps.executeUpdate();
            respuesta = 1;
        } catch (Exception e) {
            respuesta = 2;
        }
        return respuesta;
    }
    
    public Examen listarId(String codExamen){
        Examen ex = new Examen();
        String sql = "SELECT * FROM ExamenLaboratorio WHERE codigo =?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, codExamen);
            rs = ps.executeQuery();
            while(rs.next()){
                ex.setCodigo(rs.getString("codigo"));
                ex.setNombre(rs.getString("nombre"));
                ex.setOrden(rs.getString("requerimiento_orden_medico"));
                ex.setDescripcion(rs.getString("descripcion"));
                ex.setCosto(rs.getDouble("costo"));
                ex.setInforme(rs.getString("informe"));
            }
        } catch (Exception e) {
        }
        return ex;
    }
    public int actualizar(Examen ex){
        String sql = "UPDATE ExamenLaboratorio SET nombre=?, requerimiento_orden_medico=?, descripcion=?, costo=?, "
                + "informe=? WHERE codigo=?";
        try {
            acceso = conexion.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, ex.getNombre());
            ps.setString(2, ex.getOrden());
            ps.setString(3, ex.getDescripcion());
            ps.setDouble(4, ex.getCosto());
            ps.setString(5, ex.getInforme());
            ps.setString(6, ex.getCodigo());
            ps.executeUpdate();
            respuesta = 3;
        } catch (Exception e) {
            respuesta=4;
        }
        return respuesta;
    }
}
