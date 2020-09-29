package com.mycompany.hospitalproject2;

import java.sql.Date;

/**
 *
 * @author joshua
 */
public class Reporte extends Informacion{
    
    private String medico;
    private String informe;

    public Reporte(String codigo, String paciente, Date fecha, String hora, String medico, String informe) {
        super(codigo, paciente, fecha, hora);
        this.medico = medico;
        this.informe = informe;
    }

    public String getMedico() {
        return medico;
    }

    public String getInforme() {
        return informe;
    }
    
    
}
