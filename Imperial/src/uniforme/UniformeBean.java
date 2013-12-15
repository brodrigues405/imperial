package uniforme;

import funcao.FuncaoFacade;
import util.WebUtil;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UniformeBean {

	private Uniforme uniforme = new Uniforme();
	private List<Uniforme> uniformes = null;
	
	public void cadastrar() {

		this.uniforme.setFuncao(new FuncaoFacade().getFuncao(this.uniforme.getFuncao().getId()));
		this.uniforme.setNomeUniforme("Uniforme de "+this.uniforme.getFuncao().getDescricao());
		
		if(new UniformeFacade().cadastrar(this.uniforme)) {
			this.uniforme = new Uniforme();
			this.uniformes = null;
			WebUtil.enviarMsg("Operação realizada com sucesso.");
		}
		else {
			WebUtil.enviarMsg("Ocorreu um problema ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	public void excluir(Uniforme u) {
		
	}
	
	public void alterar() {
		
	}

	/**
	 * @return the uniforme
	 */
	public Uniforme getUniforme() {
		return uniforme;
	}

	/**
	 * @param uniforme the uniforme to set
	 */
	public void setUniforme(Uniforme uniforme) {
		this.uniforme = uniforme;
	}

	/**
	 * @return the uniformes
	 */
	public List<Uniforme> getUniformes() {
		
		if(this.uniformes == null) {
			this.uniformes = new UniformeFacade().getUniformes();
		}
		
		return uniformes;
	}

	/**
	 * @param uniformes the uniformes to set
	 */
	public void setUniformes(List<Uniforme> uniformes) {
		this.uniformes = uniformes;
	}
}
