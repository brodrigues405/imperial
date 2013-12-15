package uniforme;

import infra.GenericRepository;

import java.util.List;

public class UniformeRepository extends GenericRepository {

	public List<Uniforme> getUniformes() {		
		return this.em.createQuery("SELECT u FROM Unuforme u", Uniforme.class).getResultList();
	}

}
