/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.servicio.CatalogosPeliculasImpl;
import mx.com.gm.peliculas.servicio.ICatalogoPeliculas;

/**
 *
 * @author jesus
 */
public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = 1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogosPeliculasImpl();
        while (opcion != 0) {
            System.out.println("Elige una opcion");
            System.out.println("1.- Catalogo de peliculas");
            System.out.println("2.- Agregar Pelicuas");
            System.out.println("3.- Buscar Pelicula");
            System.out.println("4.- Listar Peliculas");
            System.out.println("0.- Salir");
            
            opcion = Integer.parseInt(scanner.nextLine());
            
            
            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                    
                case 2:
                    System.out.println("Agrega el nombre de la Pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPeliculas(nombrePelicula);
                    break;   
                 
                case 3:
                    System.out.println("Agrege el nombre de la Pelicula a buscar");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;  
                    
                case 4:
                    catalogo.listarPeliculas();
                    break; 
                    
                case 0:
                    System.out.println("Hasta Pronto");
                    break;                  
                    
                    
                default:
                    System.out.println("Por favor Elegir una opcion");
            }
        }
        
    }
}
