package infra;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Classe que faz o phaselistenner informando a fase do processamento.
 * 
 * @author v0rtex
 *
 */
public class MonitoradorPhaseListenner implements PhaseListener{

	private static final long serialVersionUID = 5805230253021612861L;

	@Override
	public void afterPhase(PhaseEvent evento) {
		System.out.println("\nMonitoradorPhaseListenner.afterPhase(): "+evento.getPhaseId());		
	}

	@Override
	public void beforePhase(PhaseEvent evento) {
		System.out.println("MonitoradorPhaseListenner.beforePhase(): "+evento.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}