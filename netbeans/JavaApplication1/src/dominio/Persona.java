/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author jesus
 */
public class Persona {
    
    
        
    static{
        System.out.println("Inicializando static. " );
    }
    
    {
        System.out.println("Inicializando bloque. " );
    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }

    public static void setContadorPersonas(int aContadorPersonas) {
        contadorPersonas = aContadorPersonas;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", sueldo=" + sueldo + ", eliminado=" + eliminado + ", COntadorPersona= " + contadorPersonas +'}';
    }
    private String nombre;
    private double sueldo;
    private boolean eliminado;
    private int idPersona;
    private static int contadorPersonas;
    
    public Persona( String nombre, double sueldo, boolean eliminado){
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.eliminado = eliminado;
        Persona.contadorPersonas++;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
 
}
