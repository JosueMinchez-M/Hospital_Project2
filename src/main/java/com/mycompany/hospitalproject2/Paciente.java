package com.mycompany.hospitalproject2;

import java.sql.Date;


/**
 *
 * @author joshua
 */
public class Paciente extends Persona{
    
    private String sexo;
    private Date fecha_nacimiento;
    private String telefono;
    private Double peso_kg;
    private String tipo_Sangre;
    private String correo;
    
    public Paciente(){
        
    }
    
    public Paciente(String codigo, String nombre, String dpi, String password, String sexo, Date fecha_nacimiento,
            String telefono, Double peso_kg, String tipo_Sangre, String correo){
        super(codigo, nombre, dpi, password);
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.peso_kg = peso_kg;
        this.tipo_Sangre = tipo_Sangre;
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getPeso_kg() {
        return peso_kg;
    }

    public void setPeso_kg(Double peso_kg) {
        this.peso_kg = peso_kg;
    }

    public String getTipo_Sangre() {
        return tipo_Sangre;
    }

    public void setTipo_Sangre(String tipo_Sangre) {
        this.tipo_Sangre = tipo_Sangre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
   
}
