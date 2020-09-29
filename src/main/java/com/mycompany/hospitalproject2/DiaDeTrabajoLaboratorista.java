package com.mycompany.hospitalproject2;

/**
 *
 * @author joshua
 */
public class DiaDeTrabajoLaboratorista {
    
    private String laboratoristaCodigo;
    private String diaTrabajo;

    public DiaDeTrabajoLaboratorista(){
        
    }
    
    public DiaDeTrabajoLaboratorista(String laboratoristaCodigo, String diaTrabajo) {
        this.laboratoristaCodigo = laboratoristaCodigo;
        this.diaTrabajo = diaTrabajo;
    }

    public String getLaboratoristaCodigo() {
        return laboratoristaCodigo;
    }

    public String getDiaTrabajo() {
        return diaTrabajo;
    }
    
    
}
