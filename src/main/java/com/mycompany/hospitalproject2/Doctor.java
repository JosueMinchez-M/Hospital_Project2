package com.mycompany.hospitalproject2;

import java.sql.Date;
/**
 *
 * @author joshua
 */
public class Doctor extends Persona{
    private String colegiado;
    private String telefono;
    private String especialidad;
    private String correo;
    private String horario_Inicio;
    private String horario_Fin;
    private Date inicio_trabajar;
    
    public Doctor(){
        
    }
    public Doctor(String codigo, String nombre, String dpi, String password, String colegiado, String telefono,
            String correo, String horario_Inicio, String horario_Fin, Date inicio_trabajar){
        super(codigo, nombre, dpi, password);
        this.colegiado = colegiado;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.correo = correo;
        this.horario_Inicio = horario_Inicio;
        this.horario_Fin = horario_Fin;
        this.inicio_trabajar = inicio_trabajar;
    }

    public String getColegiado() {
        return colegiado;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getHorario_Inicio() {
        return horario_Inicio;
    }

    public String getHorario_Fin() {
        return horario_Fin;
    }

    public Date getInicio_trabajar() {
        return inicio_trabajar;
    }
    
    
}
