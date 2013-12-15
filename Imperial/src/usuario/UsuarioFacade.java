package usuario;

import infra.GenericFacade;

import java.util.List;

public class UsuarioFacade extends GenericFacade{
	
	public List<Usuario> getUsuarios() {
		return new UsuarioRepository().recuperaUsuarios();
	}

	public Usuario autenticar(String login, String senha) {
		return new UsuarioRepository().autenticar(login, senha);
	}

}
