/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author jesus
 */

@Remote
public interface PersonaServiceRemote {
    public List<Persona> listasPersonas();
    
    public Persona encontrarPersonaPorId(Persona persona);
    
    public Persona encontrarPersonaPorEmail(Persona persona); 
    
    public void registrarPersona(Persona persona); 
    
    public void modificarPersona(Persona persona); 
    
    public void eliminarPersona(Persona persona); 
}
