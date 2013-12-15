package posto;

import infra.GenericFacade;

import java.util.List;

public class PostoFacade extends GenericFacade {
	
	public List<Posto> getCondominios() {
		return new PostoRepository().getPostos();
	}

	public Posto getPosto(Integer id) {
		return new PostoRepository().getPosto(id);
	}
	

}
