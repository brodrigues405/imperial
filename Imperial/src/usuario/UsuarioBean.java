package usuario;

import util.WebUtil;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private Usuario usuarioSelecionado;
	
	private List<Usuario> usuarios = null;
	private List<Usuario> usuarioFilter;

	private String login;
	private String senha;
	
	/**
	 * Metodo que executa o cadastro do usuario.
	 */
	public void cadastrarUsuario() {

		if(new UsuarioFacade().cadastrar(this.usuario)) {
			this.usuario = new Usuario();
			this.usuarios = null;
			WebUtil.enviarMsg("Operação realizada com sucesso.");
		}
		else {
			WebUtil.enviarMsg("Ocorreu um problema ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	/**
	 * Metodo que executa a exclusão do usuario.
	 * 
	 * @param u
	 */
	public void excluir(Usuario u) {
		if(new UsuarioFacade().excluir(Usuario.class, u.getId())) {
			this.usuarios = null;
			WebUtil.enviarMsg("Operação realizada com sucesso.");
		}
		else {
			WebUtil.enviarMsg("Ocorreu um problema ao realizar esta operação, por favor tente novamente.");
		}
	}
	
	/**
	 * Metodo que executa o update nousuario
	 */
	public void atualizar() {
		
		if(new UsuarioFacade().atualizar(this.usuarioSelecionado)) {
			this.usuarios = null;
			this.usuarioSelecionado = new Usuario();
			this.usuario = new Usuario();
			WebUtil.enviarMsg("Operação realizada com sucesso.");
		}
		else {
			WebUtil.enviarMsg("Ocorreu um problema ao realizar esta operação, por favor tente novamente.");
		}
	}

	/**
	 * Metodo que inicia a autenticacao do usuario.
	 */
	public void autenticar() {
		
		Usuario u = new UsuarioFacade().autenticar(this.login, this.senha);
		
		if(u != null) {
			
			//Seta os atributos da sessao.
			WebUtil.setSessao("login", u.getLogin());
			WebUtil.setSessao("tipo", u.getTipo().toString());
			WebUtil.setSessao("nome", u.getNome());
			
			//Redireciona o usuario para a pagina inicial.
			WebUtil.redirecionar("index.xhtml");			
		}
		else {
			WebUtil.enviarMsgErro("Login e/ou senha incorretos!");
		}
	}
	
	/**
	 * Metodo que executa o logout.
	 */
	public void logout() {

		//Monta uma lista com os atributos na sessao.
		List<String> atributos = new ArrayList<String>();
		atributos.add("login");
		atributos.add("tipo");
		atributos.add("nome");
		
		//Elimina os atributos da sessao.
		WebUtil.finalizaSessao(atributos);
		
		//Redireciona para a pagina de login.
		WebUtil.redirecionar("login.xhtml");
		
		WebUtil.enviarMsg("Sessão encerrada.");
	}
	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		
		if(this.usuarios == null) {
			this.usuarios = new UsuarioFacade().getUsuarios();
		}
		
		return this.usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the usuarioSelecionado
	 */
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	/**
	 * @param usuarioSelecionado the usuarioSelecionado to set
	 */
	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	/**
	 * @return the usuarioFilter
	 */
	public List<Usuario> getUsuarioFilter() {
		return usuarioFilter;
	}

	/**
	 * @param usuarioFilter the usuarioFilter to set
	 */
	public void setUsuarioFilter(List<Usuario> usuarioFilter) {
		this.usuarioFilter = usuarioFilter;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}