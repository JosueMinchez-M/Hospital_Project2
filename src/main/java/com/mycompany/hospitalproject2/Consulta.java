package com.mycompany.hospitalproject2;

/**
 *
 * @author joshua
 */
public class Consulta {
    
    private String tipo;
    private int costo;

    public Consulta(String tipo, int costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCosto() {
        return costo;
    }
    
    
}
