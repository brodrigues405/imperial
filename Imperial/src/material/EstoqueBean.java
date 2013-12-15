package material;

import estoquehistorico.EstoqueHistorico;
import posto.PostoFacade;
import util.WebUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class EstoqueBean {

	private Estoque estoque = new Estoque();
	private List<Estoque> estoques = null;
	private Estoque estoqueSelecionado = new Estoque();
	private List<Estoque> estoqueFiltro;
	
	private List<Estoque> estoqueBaixo = null;
	
	private Integer idPosto;
	private Integer qtdTransferir;
	
	private BigDecimal total;
	
	public void cadastrar() {
		
		BigDecimal v = new BigDecimal(this.estoque.getValorUnidade().floatValue() * this.estoque.getQtd());	
		
		this.estoque.setValorTotal(v);
		
		if(new EstoqueFacade().cadastrar(this.estoque)) {
			WebUtil.enviarMsg("Operação realizada com sucesso.");
			limpar();
		}
		else {
			WebUtil.enviarMsg("Ocorreu um erro ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	public void excluir() {
		
		System.out.println(this.estoque.getId());
		if(new EstoqueFacade().excluir(Estoque.class, this.estoque.getId())) {
			WebUtil.enviarMsg("Operação realizada com sucesso.");
			limpar();
		}
		else {
			WebUtil.enviarMsg("Ocorreu um erro ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	public void alterar() {
		
		BigDecimal v = new BigDecimal(this.estoqueSelecionado.getValorUnidade().floatValue() *
				this.estoqueSelecionado.getQtd());
		
		this.estoqueSelecionado.setValorTotal(v);

		if(new EstoqueFacade().atualizar(this.estoqueSelecionado)) {
			WebUtil.enviarMsg("Operação realizada com sucesso.");
			limpar();
		}
		else {
			WebUtil.enviarMsg("Ocorreu um erro ao realizar esta operação, por favor tente novamente.");
		}
	}	

	public void mover() {
		
		EstoqueHistorico eh = new EstoqueHistorico();		
		eh.setDestino(new PostoFacade().getPosto(this.idPosto));		
		eh.setData(new Date());		
		eh.setEstoque(this.estoqueSelecionado);		
		eh.setQtdTransferida(this.qtdTransferir);
		
		if(new EstoqueFacade().cadastrar(eh)) {
			WebUtil.enviarMsg("Operação realizada com sucesso.");
			this.estoqueSelecionado.setQtd(this.estoqueSelecionado.getQtd() - eh.getQtdTransferida());
			new EstoqueFacade().atualizar(this.estoqueSelecionado);			
			eh = new EstoqueHistorico();			
			limpar();
		}
	}
	
	
	private void limpar() {
		this.estoque = new Estoque();
		this.estoques = null;
		this.estoqueSelecionado = new Estoque();
		this.idPosto = null;		
	}
	
	/**
	 * @return the estoque
	 */
	public Estoque getEstoque() {
		return estoque;
	}

	/**
	 * @param estoque the estoque to set
	 */
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	/**
	 * @return the estoques
	 */
	public List<Estoque> getEstoques() {
		
		if(this.estoques == null) {
			this.estoques = new EstoqueFacade().getEstoque();
		}
		
		return this.estoques;
	}

	/**
	 * @param estoques the estoques to set
	 */
	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	/**
	 * @return the estoqueSelecionado
	 */
	public Estoque getEstoqueSelecionado() {
		return estoqueSelecionado;
	}

	/**
	 * @param estoqueSelecionado the estoqueSelecionado to set
	 */
	public void setEstoqueSelecionado(Estoque estoqueSelecionado) {
		this.estoqueSelecionado = estoqueSelecionado;
	}

	/**
	 * @return the estoqueFiltro
	 */
	public List<Estoque> getEstoqueFiltro() {
		return estoqueFiltro;
	}

	/**
	 * @param estoqueFiltro the estoqueFiltro to set
	 */
	public void setEstoqueFiltro(List<Estoque> estoqueFiltro) {
		this.estoqueFiltro = estoqueFiltro;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		
		this.total = new BigDecimal(0);
		
		for (Estoque e : this.estoques) {
			this.total = this.total.add(e.getValorTotal());
		}
		
		
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * @return the estoqueBaixo
	 */
	public List<Estoque> getEstoqueBaixo() {
		
		if(this.estoqueBaixo == null) {
			this.estoqueBaixo = new EstoqueFacade().getEstoqueBaixo();
		}
		
		return estoqueBaixo;
	}

	/**
	 * @param estoqueBaixo the estoqueBaixo to set
	 */
	public void setEstoqueBaixo(List<Estoque> estoqueBaixo) {
		this.estoqueBaixo = estoqueBaixo;
	}

	/**
	 * @return the qtdTransferir
	 */
	public Integer getQtdTransferir() {
		return qtdTransferir;
	}

	/**
	 * @param qtdTransferir the qtdTransferir to set
	 */
	public void setQtdTransferir(Integer qtdTransferir) {
		this.qtdTransferir = qtdTransferir;
	}

	/**
	 * @return the idPosto
	 */
	public Integer getIdPosto() {
		return idPosto;
	}

	/**
	 * @param idPosto the idPosto to set
	 */
	public void setIdPosto(Integer idPosto) {
		this.idPosto = idPosto;
	}

}