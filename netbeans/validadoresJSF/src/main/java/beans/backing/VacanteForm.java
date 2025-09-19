/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.backing;

import beans.model.Candidato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jesus
 */
@Named("VacanteForm")
@RequestScoped
public class VacanteForm {
    
        private static final Logger log = LoggerFactory.getLogger( VacanteForm.class );
    
    @Inject
    private Candidato candidato;
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }
    
    public String enviar(){
        log.info("Procesando solicitud para " + this.candidato.getNombre());
        if(this.candidato.getNombre().equals("bob")){
            return "exito";
        }else{
            return "fallo";
        }
    }
}
