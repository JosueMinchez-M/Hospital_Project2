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
        //this.especialidad = especialidad;
        this.correo = correo;
        this.horario_Inicio = horario_Inicio;
        this.horario_Fin = horario_Fin;
        this.inicio_trabajar = inicio_trabajar;
    }

    public Doctor(String colegiado, String telefono, String especialidad, String correo, String horario_Inicio, String horario_Fin, Date inicio_trabajar, String codigo, String nombre, String dpi, String password) {
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

    public void setColegiado(String colegiado) {
        this.colegiado = colegiado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHorario_Inicio() {
        return horario_Inicio;
    }

    public void setHorario_Inicio(String horario_Inicio) {
        this.horario_Inicio = horario_Inicio;
    }

    public String getHorario_Fin() {
        return horario_Fin;
    }

    public void setHorario_Fin(String horario_Fin) {
        this.horario_Fin = horario_Fin;
    }

    public Date getInicio_trabajar() {
        return inicio_trabajar;
    }

    public void setInicio_trabajar(Date inicio_trabajar) {
        this.inicio_trabajar = inicio_trabajar;
    }

    
}
