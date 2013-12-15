package funcionario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;

import posto.PostoFacade;
import util.WebUtil;
import enuns.Status;
import funcao.FuncaoFacade;

@ManagedBean
@SessionScoped
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios;
	
	private List<Funcionario> funcionarioFilter;
	private Integer idFuncionario;
		
	/**
	 * Metodo que recupera a foto do formulario e seta no atributo foto
	 * do objeto funcionario.
	 * 
	 * @param evento
	 */
	public void manipularFoto(FileUploadEvent evento) {		
		this.funcionario.setFoto(evento.getFile().getContents());
		System.out.println(this.funcionario.getFoto());
	}
	
	/**
	 * Metodo responsavel pelo cadastro.
	 */
	public void cadastrar() {	
		
		String msg = "Erro ao cadastrar, por favor verifique os dados e tente novamente.";
		
		//Seta a funcao selecionada
		this.funcionario.setFuncao(new FuncaoFacade().getFuncao(this.funcionario.getFuncao().getId()));
		
		//Seta o posto selecionado.
		this.funcionario.setLocalTrabalho(new PostoFacade().getPosto(this.funcionario.getLocalTrabalho().getId()));
		
		//Seta como ativo o novo usuario.
		this.funcionario.setStatus(Status.ATIVO);
		
		//Executa a operacao
		if(new FuncionarioFacade().cadastrar(this.funcionario)) {
			msg = "Operação realizada com sucesso.";
			limparAtributos();
		}
		
		//Envia msg para a view
		WebUtil.enviarMsg(msg);
	}
	
	/**
	 * Metodo executado para limpar os atributos do bean.
	 */
	private void limparAtributos() {
		this.funcionario = new Funcionario();
		this.funcionarios = null;
		this.idFuncionario = null;
	}

	/**
	 * Metodo que executa a exclusao.
	 */
	public void excluir() {	
		
		String msg = "Erro ao cadastrar, por favor verifique os dados e tente novamente.";
		
		//Marca como inativo o usario
		this.funcionario.setStatus(Status.INATIVO);
		
		//Executa a operacao.
		if(new FuncionarioFacade().atualizar(this.funcionario)){
			msg = "Operação realizada com sucesso.";
			limparAtributos();
		}
		
		WebUtil.enviarMsg(msg);
	}
	
	/**
	 * //TODO - CONTINUAR!!!
	 */
	public void paginaAlterar() {		
		this.funcionario = new FuncionarioFacade().getFuncionario(idFuncionario);
		WebUtil.redirecionar("alterar-funcionario.xhtml");
	}
	
	/**
	 * Executa a alteração de um funcionario.
	 */
	public void alterar() {
		
		String msg = "Erro ao cadastrar, por favor verifique os dados e tente novamente.";
		
		if(new FuncionarioFacade().atualizar(this.funcionario)){
			msg = "Operação realizada com sucesso.";
			limparAtributos();
		}
		
		WebUtil.enviarMsg(msg);
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the funcionarios
	 */
	public List<Funcionario> getFuncionarios() {
		
		if(this.funcionarios == null) {
			this.funcionarios = new FuncionarioFacade().getFuncionarios();
		}
		
		return funcionarios;
	}

	/**
	 * @param funcionarios the funcionarios to set
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/**
	 * @return the funcionarioFilter
	 */
	public List<Funcionario> getFuncionarioFilter() {
		return funcionarioFilter;
	}

	/**
	 * @param funcionarioFilter the funcionarioFilter to set
	 */
	public void setFuncionarioFilter(List<Funcionario> funcionarioFilter) {
		this.funcionarioFilter = funcionarioFilter;
	}
}