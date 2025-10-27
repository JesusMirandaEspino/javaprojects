package mx.com.gm.sga.servicio;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import mx.com.gm.sga.domain.Persona;

@WebService
public interface PersonaServiceWs {
    
    @WebMethod
    public List<Persona> listarPersonas();
}
