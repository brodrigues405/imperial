package funcionario;

import infra.GenericRepository;

import java.util.List;

/**
 * Classe responsavel por executa as operacoes no 
 * banco de dados da entidade Funcionario.
 * 
 * @author v0rtex
 *
 */
public class FuncionarioRepository extends GenericRepository {

	/**
	 * Metodo que recupera todos os funcionarios do banco de dados.
	 * @return uma lista com todos os funcionarios.
	 */
	public List<Funcionario> getFuncionarios() {
		return this.em.createQuery("SELECT f FROM Funcionario f WHERE f.status = 'ATIVO'", Funcionario.class).getResultList();
	}

	/**
	 * Recupera um funcionario a partir do ID.
	 * 
	 * @param idFuncionario
	 * @return
	 */
	public Funcionario getFuncionario(Integer idFuncionario) {		
		return this.em.find(Funcionario.class, idFuncionario);
	}

}
