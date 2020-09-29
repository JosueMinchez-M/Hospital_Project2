package com.mycompany.hospitalproject2;

/**
 *
 * @author joshua
 */
public class Persona {
    
    private String codigo;
    private String nombre;
    private String dpi;
    private String password;
    
    public Persona(){
        
    }
    public Persona(String codigo, String nombre, String dpi, String password){
        this.codigo = codigo;
        this.nombre = nombre;
        this.dpi = dpi;
        this.password = password;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public String getPassword() {
        return password;
    }
    
    
}
