/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.sga.servicio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.List;
import mx.com.gm.sga.domain.Persona;


/**
 *
 * @author jesus
 */

@Path("/personas")
@Stateless
public class PersonaServiceRS {
    @Inject
    PersonaService personaService;
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Persona> ListarPersonas(){
        return personaService.listarPersonas();
    }
    
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{idPersona}")
    public Persona encontrarPersonaPorId(@PathParam("idPersona")int idPersona){
        return personaService.encontrarPersonaPorId(new Persona(idPersona) );
    }
    
    @POST
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response agregarPersona(Persona persona){
        
        try {
            personaService.registrarPersona(persona);
            return Response.ok().entity(persona).build();        
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{idPersona}")
    public Response editarPersona(@PathParam("idPersona")int idPersona, Persona personaModificada){
        try {
            Persona persona = personaService.encontrarPersonaPorId(new Persona(idPersona));
            if(persona != null){
                personaService.modificarPersona(personaModificada);
                return Response.ok().entity(personaModificada).build(); 
        }else{
            return Response.status(Status.NOT_FOUND).build();
        } 
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    @DELETE
    @Path("{idPersona}")
    public Response eliminarPersonaPorId(@PathParam("idPersona")int idPersona){
        try {
            personaService.eliminarPersona(new Persona(idPersona));
            return Response.ok().build();        
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
    
    
}
