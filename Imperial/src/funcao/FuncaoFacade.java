package funcao;

import infra.GenericFacade;
import java.util.List;

public class FuncaoFacade extends GenericFacade {
	
	public List<Funcao> getFuncoes() {		
		return new FuncaoRepository().getFuncoes();
	}

	public Funcao getFuncao(int id) {
		return new FuncaoRepository().getFuncao(id);
	}	
}
