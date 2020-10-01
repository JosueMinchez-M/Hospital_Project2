package com.mycompany.hospitalproject2;

import java.sql.Date;

/**
 *
 * @author joshua
 */
public class EspecialidadMedico {
    
    private String codigo_medico;
    private String nombre;
    private String numeroColegiado;
    private String dpi;
    private String telefono;
    private String correo;
    private String horarioInicioTrabajo;
    private String horarioFinTrabajo;
    private Date fechaInicioTrabajo;
    private String especialidad;

    public void EspecialidadMedico(){
        
    }

    public EspecialidadMedico(String codigo_medico, String nombre, String numeroColegiado, String dpi, String telefono, String correo, String horarioInicioTrabajo, String horarioFinTrabajo, Date fechaInicioTrabajo, String especialidad) {
        this.codigo_medico = codigo_medico;
        this.nombre = nombre;
        this.numeroColegiado = numeroColegiado;
        this.dpi = dpi;
        this.telefono = telefono;
        this.correo = correo;
        this.horarioInicioTrabajo = horarioInicioTrabajo;
        this.horarioFinTrabajo = horarioFinTrabajo;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
        this.especialidad = especialidad;
    }

    public String getCodigo_medico() {
        return codigo_medico;
    }

    public void setCodigo_medico(String codigo_medico) {
        this.codigo_medico = codigo_medico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHorarioInicioTrabajo() {
        return horarioInicioTrabajo;
    }

    public void setHorarioInicioTrabajo(String horarioInicioTrabajo) {
        this.horarioInicioTrabajo = horarioInicioTrabajo;
    }

    public String getHorarioFinTrabajo() {
        return horarioFinTrabajo;
    }

    public void setHorarioFinTrabajo(String horarioFinTrabajo) {
        this.horarioFinTrabajo = horarioFinTrabajo;
    }

    public Date getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    public void setFechaInicioTrabajo(Date fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
}
