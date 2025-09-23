/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.lifecycle;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jesus
 */
public class DebuggerListener implements PhaseListener{
    
    private static final Logger log = LoggerFactory.getLogger( DebuggerListener.class );


    @Override
    public void beforePhase(PhaseEvent event) {
        log.info("Antes de la fase"+ event.getPhaseId());
    }    
    
    @Override
    public void afterPhase(PhaseEvent event) {
        log.info("Despues de la fase"  + event.getPhaseId());
    }


    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
