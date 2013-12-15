package funcao;

import infra.GenericRepository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class FuncaoRepository extends GenericRepository {

	public FuncaoRepository() {
		super();
	}
	
	/**
	 * Recupara todas as funções do banco de dados.
	 * @return uma lista com todas as funções.
	 */
	public List<Funcao> getFuncoes() {
		return this.em.createQuery("SELECT f FROM Funcao f", Funcao.class).getResultList();
	}

	public Funcao getFuncao(int id) {
		
		Funcao f = null;
		
		try {
			TypedQuery<Funcao> query = this.em.createQuery("SELECT f FROM Funcao f WHERE f.id = :id", Funcao.class);
			query.setParameter("id", id);
			f = query.getSingleResult();			
		}
		catch (NoResultException e) {
			f = null;
		}
		
		return f; 
	}

}