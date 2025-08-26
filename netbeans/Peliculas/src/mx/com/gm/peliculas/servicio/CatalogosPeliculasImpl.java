/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.peliculas.servicio;

import mx.com.gm.peliculas.datos.AccesosDatosImpl;
import mx.com.gm.peliculas.datos.IAccessoDatos;
import mx.com.gm.peliculas.dominio.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosException;

/**
 *
 * @author jesus
 */
public class CatalogosPeliculasImpl implements ICatalogoPeliculas{
    
    private final IAccessoDatos datos;

    public CatalogosPeliculasImpl() {
        this.datos  = new AccesosDatosImpl();
    }

    @Override
    public void agregarPeliculas(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = this.datos.existe(NOMBRE_PELICULA);
            datos.escribir(pelicula, nombrePelicula, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }


    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_PELICULA);
            
            peliculas.forEach(pelicula -> {
                System.out.println("pelicula: " + pelicula);
            });
            
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_PELICULA, buscar);
        } catch (LecturaDatosException ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
        
        System.out.println("Resultado: " + resultado);
    }
    

    @Override
    public void iniciarCatalogoPeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
