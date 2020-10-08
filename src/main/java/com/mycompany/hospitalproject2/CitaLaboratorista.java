package com.mycompany.hospitalproject2;

import java.sql.Date;

/**
 *
 * @author joshua
 */
public class CitaLaboratorista {
    private String codigo;
    private String codigoExamen;
    private Date fechaCitaLab;
    private String horaEstablecida;
    private String codigoPaciente;
    private String codigoLaboratorista;
    private String codigoMedico; 

    public CitaLaboratorista(){
        
    }
    public CitaLaboratorista(String codigo, String codigoExamen, Date fechaCitaLab, String horaEstablecida, String codigoPaciente, String codigoLaboratorista, String codigoMedico) {
        this.codigo = codigo;
        this.codigoExamen = codigoExamen;
        this.fechaCitaLab = fechaCitaLab;
        this.horaEstablecida = horaEstablecida;
        this.codigoPaciente = codigoPaciente;
        this.codigoLaboratorista = codigoLaboratorista;
        this.codigoMedico = codigoMedico;
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(String codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public Date getFechaCitaLab() {
        return fechaCitaLab;
    }

    public void setFechaCitaLab(Date fechaCitaLab) {
        this.fechaCitaLab = fechaCitaLab;
    }

    public String getHoraEstablecida() {
        return horaEstablecida;
    }

    public void setHoraEstablecida(String horaEstablecida) {
        this.horaEstablecida = horaEstablecida;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getCodigoLaboratorista() {
        return codigoLaboratorista;
    }

    public void setCodigoLaboratorista(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }
    
    
}
