package roupas;

import infra.GenericFacade;

import java.util.List;

public class RoupaFacade extends GenericFacade {
	
	public List<Roupa> getRoupas() {
		return new RoupaRepository().getRoupas();		
	}
}