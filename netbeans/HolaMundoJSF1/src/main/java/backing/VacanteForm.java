/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIInput;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.Candidato;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jesus
 */


@Named
@RequestScoped
public class VacanteForm {
    
    Logger log = LogManager.getRootLogger();
    
    @Inject
    private Candidato candidato;
    
    private boolean comentarioEnviado;
    
    public VacanteForm() {
        log.info("Creando el objeto candidato");
    }
    

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public String enviar(){
        if(this.candidato.getNombre().equals("bob")){
            if (this.candidato.getApellido().equals("cat")) {
                String msg = "Gracias, pero ya no te tenemos un bob";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null;
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            log.info("Entrando al caso de exito");
            return "exito";}
        else{
            log.info("Entrando al caso de fallo");
            return "fallo";
        }
    }
    
    
    public void codigoPostalListener(ValueChangeEvent valueChangeEvent){
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        String nuevoCodigoPostal = valueChangeEvent.getNewValue().toString();
        if("45422".equals(nuevoCodigoPostal)){
        
            UIInput coloniaInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:colonia");
            String nuevacolonia = "GatoLandia";
            coloniaInputText.setValue(nuevacolonia);
            coloniaInputText.setSubmittedValue(nuevacolonia);
            
            
            UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
            String nuevaciudad = "CatCity";
            ciudadInputText.setValue(nuevaciudad);
            ciudadInputText.setSubmittedValue(nuevaciudad);
            
        }
    }
    
    public void ocultarComentario(ActionEvent actionEvent){
        this.comentarioEnviado = !this.comentarioEnviado;
    }

    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }


}
