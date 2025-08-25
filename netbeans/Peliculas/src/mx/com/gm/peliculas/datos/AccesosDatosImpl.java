/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.dominio.Pelicula;
import mx.com.gm.peliculas.excepciones.*;


/**
 *
 * @author jesus
 */
public class AccesosDatosImpl implements IAccessoDatos{

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx { 
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosException {
        File archivo = new File(nombreRecurso);
        List <Pelicula> peliculas = new ArrayList();
        try {
            BufferedReader entrada = new BufferedReader( new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosException("Excepcion al listar peliculas " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosException("Excepcion al listar peliculas " + ex.getMessage());
        }
        
        return peliculas;
        
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExeption {
        File archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.print(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion en el archivo"  + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosExeption("Excepcion al escribir peliculas " + ex.getMessage()); 
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosException {
        File archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader( new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while(linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula: "  + linea  + "Ecnontrada en el indice: "  + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosException("Excepcion al buscar peliculas " + ex.getMessage()); 
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosException("Excepcion al buscar peliculas " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
    }
    
}
