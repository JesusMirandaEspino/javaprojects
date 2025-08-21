/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import dominio.*;

/**
 *
 * @author jesus
 */
public class PersonaTest {
    public static void main(String[] args) {
        Persona persona1 = new Persona( "Bob", 5000.0, true);
        
        
        persona1.setSueldo(60000.2);
        
        
        System.out.println("Persona nombre: " + persona1.toString());
        
        
         Persona persona2 = new Persona( "Bob2", 55000.0, false);
        
        
        persona1.setSueldo(60000.2);
        
        
        System.out.println("Persona nombre: " + persona1.toString());
        System.out.println("Persona nombre: " + persona2.toString());
    }
}
