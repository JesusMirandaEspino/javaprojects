/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lifecycle;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jesus
 */


public class DebuggerListener implements jakarta.faces.event.PhaseListener{
    
    Logger log = LogManager.getRootLogger();

    @Override
    public void afterPhase(PhaseEvent event) {
        if(log.isInfoEnabled())
            log.info("Despues de la fase: " + event.getPhaseId().toString());
        
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        if(log.isInfoEnabled())
            log.info("Antes de la fase: " + event.getPhaseId().toString());
        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE; 
    }
    
}
