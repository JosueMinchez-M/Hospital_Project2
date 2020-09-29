package com.mycompany.hospitalproject2;

import java.sql.Date;

/**
 *
 * @author joshua
 */
public class Cita extends Informacion{
    
    private String medico;
    private String especialidad;

    public Cita(String codigo, String paciente, Date fecha, String hora, String medico, String especialidad) {
        super(codigo, paciente, fecha, hora);
        this.medico = medico;
        this.especialidad = especialidad;
    }

    public String getMedico() {
        return medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    
}
