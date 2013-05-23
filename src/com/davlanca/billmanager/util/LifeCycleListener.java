package com.davlanca.billmanager.util;
 
import java.util.logging.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
public class LifeCycleListener implements PhaseListener {
     
    private static final long serialVersionUID = -2504278325379445246L;
 
    private static final Logger log2 = Logger.getLogger(LifeCycleListener.class.getName());
    private static final Log log = LogFactory.getLog(LifeCycleListener.class);
     
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
 
    public void beforePhase(PhaseEvent event) {
        if (log.isTraceEnabled()){
            log.trace("BeforePhase: " + event.getPhaseId());
        }
        log2.info("BeforePhase: " + event.getPhaseId());
    }
 
    public void afterPhase(PhaseEvent event) {
        if (log.isTraceEnabled()){
            log.trace("AfterPhase: " + event.getPhaseId());
        }
        log2.info("AfterPhase: " + event.getPhaseId());
    }
 
}