package com.mycompany.hospitalproject2;

import java.sql.Date;

/**
 *
 * @author joshua
 */
public class Reporte{
    
    private String codigo;
    private String paciente;
    private Date fecha;
    private String hora;
    private String medico;
    private String informe;

    public Reporte(){
        
    }
    public Reporte(String codigo, String paciente, Date fecha, String hora, String medico, String informe) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
        this.informe = informe;
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

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }
    
}
