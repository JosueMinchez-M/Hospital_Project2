package com.mycompany.hospitalproject2;

import java.sql.Date;

/**
 *
 * @author joshua
 */
public class Laboratorista extends Persona{
    
    private String numero_registro;
    private String telefono;
    private String examen_realizar;
    private String correo;
    private Date fecha_trabajar;
    
    public Laboratorista(){
        
    }
    
    public Laboratorista(String codigo, String nombre, String dpi, String password, String numero_registro, String telefono,
            String examen_realizar, String correo, Date fecha_trabajar){
        super(codigo, nombre, dpi, password);
        this.numero_registro = numero_registro;
        this.telefono = telefono;
        this.examen_realizar = examen_realizar;
        this.correo = correo;
        this.fecha_trabajar = fecha_trabajar;
    }

    public String getNumero_registro() {
        return numero_registro;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getExamen_realizar() {
        return examen_realizar;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFecha_trabajar() {
        return fecha_trabajar;
    }
    
}
