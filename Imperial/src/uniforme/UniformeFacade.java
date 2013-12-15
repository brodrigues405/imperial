package uniforme;

import infra.GenericFacade;

import java.util.List;

public class UniformeFacade extends GenericFacade {

	public List<Uniforme> getUniformes() {		
		return new UniformeRepository().getUniformes();
	}

}
