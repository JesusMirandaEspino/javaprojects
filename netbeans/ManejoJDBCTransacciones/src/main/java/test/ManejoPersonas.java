/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.ConexionJDBC;
import datos.PersonsJDBC;
import domain.Persona;
import java.sql.*;
import java.util.List;

/**
 *
 * @author jesus
 */
public class ManejoPersonas {
    public static void main(String[] args) {
            Connection conexion = null;
        
        try {
            conexion = ConexionJDBC.getConexion();
            
            if(conexion.getAutoCommit() ){
                conexion.setAutoCommit(false);
            }
            
            PersonsJDBC personaJDBC = new PersonsJDBC(conexion);
            
            
            List<Persona> listaPersonas = personaJDBC.seleccionar();
        
            listaPersonas.forEach( persona -> {
               System.out.println("IdPersona: " + persona.getIdPersona());
               System.out.println("Nombre: " + persona.getNombre());
               System.out.println("Apellido: " + persona.getApellido());
               System.out.println("Email: " + persona.getEmail());
               System.out.println("Telefono: " + persona.getTelefono());
               System.out.println("----------------------------------------------------------------------------------");
            });
            
            
            conexion.commit();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
                try {
                    conexion.rollback();
                } catch (SQLException ex1) {
                     ex1.printStackTrace(System.out);
                }
        }
        
        

           
           
           //Persona persona1 = new Persona();
           
           //persona1.setNombre("SuperBob");
           //persona1.setApellido("Cat");
           //persona1.setEmail("super@gmail.com");
           //persona1.setTelefono("415678915");
           
           //var row = personaJDBC.insertar(persona1);
           
           //Persona persona1 = new Persona();
           
           //persona1.setIdPersona(8);
           //persona1.setNombre("BobSuperCat");
           //persona1.setApellido("supergatoloco");
           //persona1.setEmail("gatoloco@gmail.com");
           //persona1.setTelefono("3216549787");
           
           //var row = personaJDBC.borrar(persona1);
        
    }
}
