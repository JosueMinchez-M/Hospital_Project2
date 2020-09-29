package com.mycompany.hospitalproject2;

/**
 *
 * @author joshua
 */
public class Examen {
    
    private String codigo;
    private String nombre;
    private String orden;
    private String descripcion;
    private double costo;
    private String informe;

    public Examen(){
        
    }
    
    public Examen(String codigo, String nombre, String orden, String descripcion, double costo, String informe) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.orden = orden;
        this.descripcion = descripcion;
        this.costo = costo;
        this.informe = informe;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrden() {
        return orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public String getInforme() {
        return informe;
    }
    
    
}
