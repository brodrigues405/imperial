package material;

import infra.GenericFacade;

import java.util.List;

public class EstoqueFacade extends GenericFacade {

	public List<Estoque> getEstoque() {
		return new EstoqueRepository().getEstoque();
	}

	public List<Estoque> getEstoqueBaixo() {
		return new EstoqueRepository().getEstoquesBaixos();
	}

	public Estoque getEstoqueItem(Integer idMaterial) {		
		return new EstoqueRepository().getItem(idMaterial);
	}	
}
