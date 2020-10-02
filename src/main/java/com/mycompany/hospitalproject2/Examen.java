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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }
    
}
