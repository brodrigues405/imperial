package infra;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class ControleDeAcesso implements PhaseListener {

	/**
	 * serialVersionUID = -6884899274085848693L
	 */
	private static final long serialVersionUID = -6884899274085848693L;

	@Override
	public void afterPhase(PhaseEvent after){
		
		//Armazena a pagina que esta sendo acessada.
		String pagina = after.getFacesContext().getViewRoot().getViewId();
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession sessao = (HttpSession) ec.getSession(true);
		
		//Testa se o usuario esta autenticado
		if(!pagina.equalsIgnoreCase("/login.xhtml")) {
			if(sessao.getAttribute("tipo") == null) {
				
			}
		}	
	}

	@Override
	public void beforePhase(PhaseEvent before) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
