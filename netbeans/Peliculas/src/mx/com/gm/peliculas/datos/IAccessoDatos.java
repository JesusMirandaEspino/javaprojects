/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.dominio.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosExeption;
import mx.com.gm.peliculas.excepciones.LecturaDatosException;

/**
 *
 * @author jesus
 */
public interface IAccessoDatos {

     boolean existe(String nombreArchivo)throws AccesoDatosEx;
     
     List<Pelicula> listar(String nombreRecurso)throws LecturaDatosException;
     
     void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExeption;
     
     String buscar(String nombreRecurso, String buscar)throws LecturaDatosException;
     
     void crear(String nombreRecurso) throws AccesoDatosEx;
     
     void borrar(String nombreRecurso)throws AccesoDatosEx;
}
