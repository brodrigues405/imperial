package material;

import infra.GenericRepository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

public class EstoqueRepository extends GenericRepository {

	/**
	 * Recupera todos os itens do estoque estao cadastrados no sistema.
	 * 
	 * @return
	 */
	public List<Estoque> getEstoque() {
		return this.em.createQuery("SELECT e FROM Estoque e", Estoque.class).getResultList();
	}
	
	/**
	 * Metodo que retorna todos os produtos no estoque que estao em baixa.
	 *  
	 * @return
	 */
	public List<Estoque> getEstoquesBaixos() {
		
		List<Estoque> estoque = new ArrayList<Estoque>();
		
		String jpql = "SELECT e FROM Estoque e WHERE e.qtd <= e.minimo";
		
		TypedQuery<Estoque> query = this.em.createQuery(jpql, Estoque.class);
		
		estoque = query.getResultList();
		
		return estoque;
	}

	/**
	 * Metodo que recupera um item pelo ID. 
	 * 
	 * @param id
	 * @return
	 */
	public Estoque getItem(Integer id) {
		
		return this.em.find(Estoque.class, id);
	}
}