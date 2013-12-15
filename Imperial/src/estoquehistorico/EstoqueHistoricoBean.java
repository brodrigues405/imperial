package estoquehistorico;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@RequestScoped
@ManagedBean
public class EstoqueHistoricoBean {

	private List<EstoqueHistorico> itensMovidos = null;
	private List<EstoqueHistorico> itensFilter;

	/**
	 * @return the itensMovidos
	 */
	public List<EstoqueHistorico> getItensMovidos() {
		
		if(this.itensMovidos == null){
			this.itensMovidos = new EstoqueHistoricoFacade().getItens();
		}
			
		return this.itensMovidos;
	}

	/**
	 * @param itensMovidos the itensMovidos to set
	 */
	public void setItensMovidos(List<EstoqueHistorico> itensMovidos) {
		this.itensMovidos = itensMovidos;
	}

	/**
	 * @return the itensFilter
	 */
	public List<EstoqueHistorico> getItensFilter() {
		return itensFilter;
	}

	/**
	 * @param itensFilter the itensFilter to set
	 */
	public void setItensFilter(List<EstoqueHistorico> itensFilter) {
		this.itensFilter = itensFilter;
	}
	
	
}
