package com.mycompany.hospitalproject2;

import java.sql.Date;

/**
 *
 * @author joshua
 */
public class Resultado extends Informacion {
    
    private String medico;
    private String examen;
    private String laboratorista;
    private String orden;
    private String informe;

    public Resultado(String codigo, String paciente, Date fecha, String hora, String examen, String laboratorista, String orden, String informe, String medico) {
        super(codigo, paciente, fecha, hora);
        this.examen = examen;
        this.laboratorista = laboratorista;
        this.orden = orden;
        this.informe = informe;
        this.medico = medico;
    }

    public String getExamen() {
        return examen;
    }

    public String getLaboratorista() {
        return laboratorista;
    }

    public String getOrden() {
        return orden;
    }

    public String getInforme() {
        return informe;
    }

    public String getMedico() {
        return medico;
    }
    
    
}
