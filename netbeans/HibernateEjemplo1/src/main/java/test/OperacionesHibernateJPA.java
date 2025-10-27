/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

/**
 *
 * @author jesus
 */
public class OperacionesHibernateJPA {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.Listar();
        
        
        Persona persona = new Persona();
        persona.setIdPersona(14);
        //persona.setNombre("Bob");
        persona.setApellido("Toronja Loco");
        persona.setEmail("bobToronja@mail.com");
        //persona.setTelefono("55443322");
        
        //personaDAO.Insertar(persona);
        
        //personaDAO.Modificar(persona);
        
    }
}
