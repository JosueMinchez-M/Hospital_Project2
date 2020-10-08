package com.mycompany.hospitalproject2;

import java.sql.Date;

/**
 *
 * @author joshua
 */
public class Resultado {
    
    private String codigo;
    private String paciente;
    private Date fecha;
    private String hora;
    private String medico;
    private String examen;
    private String laboratorista;
    private String orden;
    private String informe;

    public Resultado(String codigo, String paciente, Date fecha, String hora, String examen, String laboratorista, String orden, String informe, String medico) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.examen = examen;
        this.laboratorista = laboratorista;
        this.orden = orden;
        this.informe = informe;
        this.medico = medico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public String getLaboratorista() {
        return laboratorista;
    }

    public void setLaboratorista(String laboratorista) {
        this.laboratorista = laboratorista;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    
    
    
}
