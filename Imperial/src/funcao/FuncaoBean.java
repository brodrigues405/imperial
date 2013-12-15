package funcao;

import util.WebUtil;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class FuncaoBean {

	private Funcao novaFuncao = new Funcao();
	private List<Funcao> funcoes = null;
	private List<Funcao> funcaoFilter;
	private Funcao funcao = new Funcao();
	
	public void cadastrar() {
		if(new FuncaoFacade().cadastrar(this.novaFuncao)) {
			this.novaFuncao = new Funcao();
			this.funcoes = null;
			WebUtil.enviarMsg("Operação realizada com sucesso.");
		}
		else {
			WebUtil.enviarMsg("Não foi possível executar esta operação, por favor verifique os campos e tente novamente.");
		}
	}
	
	public void alterar() {
		
		String msg = "Não foi possível executar esta operação, por favor verifique os campos e tente novamente.";
		
		if(new FuncaoFacade().atualizar(this.funcao)) {
			this.funcao = new Funcao();
			this.funcoes = null;
			msg = "Operação realizada com sucesso.";
		}
		
		WebUtil.enviarMsg(msg);
	}

	/**
	 * @return the novaFuncao
	 */
	public Funcao getNovaFuncao() {
		return novaFuncao;
	}

	/**
	 * @param novaFuncao the novaFuncao to set
	 */
	public void setNovaFuncao(Funcao novaFuncao) {
		this.novaFuncao = novaFuncao;
	}

	/**
	 * @return the funcoes
	 */
	public List<Funcao> getFuncoes() {
		
		if(this.funcoes == null) {
			this.funcoes = new FuncaoFacade().getFuncoes();
		}
		
		return funcoes;
	}

	/**
	 * @param funcoes the funcoes to set
	 */
	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}

	/**
	 * @return the funcaoFilter
	 */
	public List<Funcao> getFuncaoFilter() {
		return funcaoFilter;
	}

	/**
	 * @param funcaoFilter the funcaoFilter to set
	 */
	public void setFuncaoFilter(List<Funcao> funcaoFilter) {
		this.funcaoFilter = funcaoFilter;
	}

	/**
	 * @return the funcao
	 */
	public Funcao getFuncao() {
		return funcao;
	}

	/**
	 * @param funcao the funcao to set
	 */
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
}