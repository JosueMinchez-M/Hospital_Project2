package com.mycompany.hospitalproject2;

import java.sql.Date;

/**
 *
 * @author joshua
 */
public class Informacion {
    
    private String codigo;
    private String paciente;
    private Date fecha;
    private String hora;

    public Informacion(String codigo, String paciente, Date fecha, String hora) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    
    
    
}
