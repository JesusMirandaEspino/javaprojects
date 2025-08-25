/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.peliculas.dominio;

/**
 *
 * @author jesus
 */
public class Pelicula {
    private String Nombre;
    
    
    public Pelicula() {
    }

    @Override
    public String toString() {
        return this.Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Pelicula(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
