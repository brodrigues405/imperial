package infra;

import util.WebUtil;

import javax.persistence.EntityManager;

/**
 * Classe que implementa as operacoes:
 * 
 * - Cadastrar;
 * - Excluir;
 * - Alterar;
 * 
 * Dependencias:
 * - JPAUtil 0.3;
 * - WebUtil 0.4;
 * 
 * @author v0rtex
 *
 */
public class GenericRepository {
	
	protected EntityManager em;

	/**
	 * Metodo construtor da classe.
	 * @param manager - O entityManager utilizado.
	 */
	public GenericRepository() {
		this.em = WebUtil.getEntityManager();
	}
	
	/**
	 * Efetua o cadastro de um usuario.
	 * 
	 * @param t
	 * @return
	 */
	public <T> boolean cadastrar(T t) {
		this.em.persist(t);
		return true;
	}

	/**
	 * Efetua a exclusão de um usuario.
	 * 
	 * @param t
	 * @return
	 */
	public boolean excluir(Class<?> classe, Integer id) {
		this.em.remove(em.find(classe, id));
		return true;
	}

	/**
	 * Efetua a alteração de um usuario.
	 * 
	 * @param t
	 * @return
	 */
	public <T> boolean alterar(T t) {
		this.em.merge(t);
		return true;
	}

}
