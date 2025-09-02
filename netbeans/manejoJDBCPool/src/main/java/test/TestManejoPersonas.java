/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonaDAOJDBC;
import domain.PersonaDTO;
import java.util.*;

/**
 *
 * @author jesus
 */
public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAOJDBC personaDAO = new PersonaDAOJDBC();
        List<PersonaDTO> personas =  personaDAO.seleccionar();
        
        personas.forEach( persona -> {
            System.out.println(persona.toString());
        } );
        
        
        //PersonaDTO persona1 = new PersonaDTO("BobDarkMaster", "CatEvil2", "evilcatmaster@cat.com", "555554657"  );
        
        //personaDAO.insertar(persona1);
        
    }
}
