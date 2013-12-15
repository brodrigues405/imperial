package funcionario;

import infra.GenericFacade;

import java.util.List;

/**
 * classe responsavel pelo controle da aplicacao.
 * 
 * @author v0rtex
 *
 */
public class FuncionarioFacade extends GenericFacade {

	public List<Funcionario> getFuncionarios() {
		
		return new FuncionarioRepository().getFuncionarios();
	}

	public Funcionario getFuncionario(Integer idFuncionario) {
		return new FuncionarioRepository().getFuncionario(idFuncionario);
	}

}
