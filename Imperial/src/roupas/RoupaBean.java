package roupas;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.WebUtil;

@ManagedBean
@SessionScoped
public class RoupaBean {

	private Roupa roupa = new Roupa();
	private List<Roupa> roupas = null;
	private List<Roupa> roupaFilter;
	private Roupa roupaSelecionada;

	public void cadastrar() {
		
		//Atualiza o preco total da roupa antes de cadastrar
		this.roupa.setPrecoTotal(this.roupa.getPrecoUnidade()*this.roupa.getQtd());
		
		if(new RoupaFacade().cadastrar(this.roupa)) {
			this.roupa = new Roupa();
			this.roupas = null;
			WebUtil.enviarMsg("Operação realizada com sucesso.");
		}
		else {
			WebUtil.enviarMsg("Ocorreu um problema ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	

	public void excluir(Roupa r) {
		if(new RoupaFacade().excluir(Roupa.class, r.getId())) {
			this.roupas = null;
			WebUtil.enviarMsg("Operação realizada com sucesso.");
		}
		else {
			WebUtil.enviarMsg("Ocorreu um problema ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	public void atualizar() {
		
		//Atualiza o preco total da roupa antes de cadastrar
		this.roupaSelecionada.setPrecoTotal(this.roupaSelecionada.getPrecoUnidade()*this.roupaSelecionada.getQtd());
		System.out.println(":A");
		if(new RoupaFacade().atualizar(this.roupaSelecionada)) {
			this.roupas = null;
			this.roupaSelecionada = new Roupa();
			this.roupa = new Roupa();
			WebUtil.enviarMsg("Operação realizada com sucesso.");
		}
		else {
			WebUtil.enviarMsg("Ocorreu um problema ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	/**
	 * @return the roupa
	 */
	public Roupa getRoupa() {
		return roupa;
	}

	/**
	 * @param roupa the roupa to set
	 */
	public void setRoupa(Roupa roupa) {
		this.roupa = roupa;
	}

	/**
	 * @return the roupas
	 */
	public List<Roupa> getRoupas() {
		
		if(this.roupas == null) {
			this.roupas = new RoupaRepository().getRoupas();
		}
		
		return this.roupas;
	}

	/**
	 * @param roupas the roupas to set
	 */
	public void setRoupas(List<Roupa> roupas) {
		this.roupas = roupas;
	}

	/**
	 * @return the roupaFilter
	 */
	public List<Roupa> getRoupaFilter() {
		return roupaFilter;
	}

	/**
	 * @param roupaFilter the roupaFilter to set
	 */
	public void setRoupaFilter(List<Roupa> roupaFilter) {
		this.roupaFilter = roupaFilter;
	}

	/**
	 * @return the roupaSelecionada
	 */
	public Roupa getRoupaSelecionada() {
		return roupaSelecionada;
	}

	/**
	 * @param roupaSelecionada the roupaSelecionada to set
	 */
	public void setRoupaSelecionada(Roupa roupaSelecionada) {
		this.roupaSelecionada = roupaSelecionada;
	}
}
