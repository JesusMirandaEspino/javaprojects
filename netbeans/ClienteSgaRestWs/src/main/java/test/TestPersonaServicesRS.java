/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import domain.Persona;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.*;
import java.util.List;

/**
 *
 * @author jesus
 */
public class TestPersonaServicesRS {
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        cliente = ClientBuilder.newClient();
        
        webTarget = cliente.target(URL_BASE).path("/personas");
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada:" + persona);
        
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nPersonas recuperadas");
        imprimirPersonas(personas);
        
        
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Bob Wachimingo");
        nuevaPersona.setApellido("Miranda");
        nuevaPersona.setEmail("bobmiranda3@mail.com");
        nuevaPersona.setTelefono("99887700");
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post( Entity.entity(nuevaPersona, MediaType.APPLICATION_XML) );
        System.out.println("");
        System.out.println(response.getStatus());
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada:" + personaRecuperada);
        
        
        Persona personaModificar = personaRecuperada;
        personaRecuperada.setApellido("Guachimingo");
        String pathId = "/"  + personaModificar.getIdPersona();
        
       invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
       response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML ));
       
       
        System.out.println("");
        System.out.println("response:" + response.getStatus());
        System.out.println("Persona modifica:" + response.readEntity(Persona.class));
        
        
        Persona personaEliminar = personaModificar;
        String pathIdEliminar = "/"  + personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathIdEliminar).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        
        System.out.println("");
        System.out.println("response:" + response.getStatus());
        System.out.println("Persona Eliminada" + personaEliminar);
    }
    
    
    private static void imprimirPersonas(List<Persona> personas) {
        for(Persona p: personas){
            System.out.println("Persona:" + p);
        }
    }
    
}
