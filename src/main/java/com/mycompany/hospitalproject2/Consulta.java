package com.mycompany.hospitalproject2;

/**
 *
 * @author joshua
 */
public class Consulta {
    
    private String tipo;
    private int costo;

    public Consulta(){
        
    }
    public Consulta(String tipo, int costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
}
