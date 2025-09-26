/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonsJDBC;
import domain.Persona;
import java.util.List;

/**
 *
 * @author jesus
 */
public class ManejoPersonas {
    public static void main(String[] args) {
        PersonsJDBC personaJDBC = new PersonsJDBC();
        List<Persona> listaPersonas = personaJDBC.seleccionar();
        
           listaPersonas.forEach( persona -> {
               System.out.println("IdPersona: " + persona.getIdPersona());
               System.out.println("Nombre: " + persona.getNombre());
               System.out.println("Apellido: " + persona.getApellido());
               System.out.println("Email: " + persona.getEmail());
               System.out.println("Telefono: " + persona.getTelefono());
               System.out.println("----------------------------------------------------------------------------------");
           });
        
    }
}
