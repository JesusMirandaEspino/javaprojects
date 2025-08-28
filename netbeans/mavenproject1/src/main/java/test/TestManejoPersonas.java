/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.*;

/**
 *
 * @author jesus
 */
public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas =  personaDAO.seleccionar();
        
        personas.forEach( persona -> {
            System.out.println(persona.toString());
        } );
    }
}
