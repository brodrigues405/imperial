package estoquehistorico;

import infra.GenericFacade;

import java.util.List;

public class EstoqueHistoricoFacade extends GenericFacade {

	public List<EstoqueHistorico> getItens() {
		return new EstoqueHistoricoRepository().getItens();
	}

}
