package com.mycompany.hospitalproject2;

/**
 *
 * @author joshua
 */
public class EspecialidadMedico {
    
    private String codigo_medico;
    private String especialidad;

    public void EspecialidadMedico(){
        
    }
    public EspecialidadMedico(String codigo_medico, String especialidad) {
        this.codigo_medico = codigo_medico;
        this.especialidad = especialidad;
    }

    public String getCodigo_medico() {
        return codigo_medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
}
