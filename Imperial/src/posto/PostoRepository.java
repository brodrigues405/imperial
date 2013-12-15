package posto;

import infra.GenericRepository;

import java.util.List;

public class PostoRepository extends GenericRepository {

	public PostoRepository() {
		super();
	}
	
	/**
	 * Metodo ue recupera todos os condominio do banco de dados.
	 * 
	 * @return
	 */
	public List<Posto> getPostos() {
		return this.em.createQuery("SELECT c FROM Posto c", Posto.class).getResultList();
	}

	public Posto getPosto(Integer id) {
		return this.em.find(Posto.class, id);
	}
		
}
