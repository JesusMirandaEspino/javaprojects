/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.peliculas.servicio;

/**
 *
 * @author jesus
 */
public interface ICatalogoPeliculas {
    
    String NOMBRE_PELICULA = "peliculas.txt";
    
    void agregarPeliculas(String nombre);
    
    void listarPeliculas();
    
    void buscarPelicula(String buscar);
    
    void iniciarCatalogoPeliculas();
}
