/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author jesus
 */
@Stateless
public class PersonaServicesImpl implements PersonaServiceRemote{

    @Override
    public List<Persona> listasPersonas() {
        List<Persona> personas = new ArrayList<>();
        personas.add( new Persona(1, "Bob","Cat", "bob@gmail.com", "1234567498"));
        personas.add( new Persona(2, "Bob2","Cat2", "bob2@gmail.com", "1234567498"));
        personas.add( new Persona(3, "Bob3","Cat3", "bob3@gmail.com", "1234567498"));
        
        return personas;
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return null;
    }

    @Override
    public void registrarPersona(Persona persona) {
        
    }

    @Override
    public void modificarPersona(Persona persona) {
        
    }

    @Override
    public void eliminarPersona(Persona persona) {
        
    }
    
}
