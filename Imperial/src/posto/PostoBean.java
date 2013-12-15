package posto;

import util.WebUtil;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PostoBean {

	private Posto posto = new Posto();
	private List<Posto> postos = null;
	private List<Posto> postoFilter;
	private Posto postoSelecionado = new Posto();
	
	/**
	 * Metodo que executa o cadastro.
	 * 
	 */
	public void cadastrar() {
		if(new PostoFacade().cadastrar(this.posto)) {
			WebUtil.enviarMsg("Operação realizada com sucesso.");
			this.postos = null;
			this.posto = new Posto();
		}
		else {
			WebUtil.enviarMsg("Ocorreu um erro ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	/**
	 * Metodo que executa a exclusão.
	 * 
	 */
	public void excluir(Posto c) {
		if(new PostoFacade().excluir(Posto.class, c)) {
			WebUtil.enviarMsg("Operação realizada com sucesso.");
			this.postos = null;
			this.posto = new Posto();
		}
		else {
			WebUtil.enviarMsg("Ocorreu um erro ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	/**
	 * Metodo que executa a atualização do posto.
	 * 
	 */
	public void alterar() {
		if(new PostoFacade().atualizar(this.postoSelecionado)) {
			WebUtil.enviarMsg("Operação realizada com sucesso.");
			this.postos = null;
			this.posto = new Posto();
			this.postoSelecionado = new Posto();
		}
		else {
			WebUtil.enviarMsg("Ocorreu um erro ao realizar esta operação, por favor tente novamente.");
		}
	}

	/**
	 * @return the posto
	 */
	public Posto getposto() {
		return posto;
	}

	/**
	 * @param posto the posto to set
	 */
	public void setposto(Posto posto) {
		this.posto = posto;
	}

	/**
	 * @return the postos
	 */
	public List<Posto> getpostos() {
		
		if(this.postos == null) {
			this.postos = new PostoFacade().getCondominios();
		}
		
		return this.postos;
	}

	/**
	 * @param postos the postos to set
	 */
	public void setpostos(List<Posto> postos) {
		this.postos = postos;
	}

	/**
	 * @return the postoFilter
	 */
	public List<Posto> getpostoFilter() {
		return postoFilter;
	}

	/**
	 * @param postoFilter the postoFilter to set
	 */
	public void setpostoFilter(List<Posto> postoFilter) {
		this.postoFilter = postoFilter;
	}

	/**
	 * @return the postoSelecionado
	 */
	public Posto getPostoSelecionado() {
		return postoSelecionado;
	}

	/**
	 * @param postoSelecionado the postoSelecionado to set
	 */
	public void setPostoSelecionado(Posto postoSelecionado) {
		this.postoSelecionado = postoSelecionado;
	}
}
