package estoquehistorico;

import infra.GenericRepository;

import java.util.List;

public class EstoqueHistoricoRepository extends GenericRepository {

	public List<EstoqueHistorico> getItens() {
		return this.em.createQuery("SELECT e FROM EstoqueHistorico e", EstoqueHistorico.class).getResultList();
	}

}
