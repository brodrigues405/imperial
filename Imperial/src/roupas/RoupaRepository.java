package roupas;

import infra.GenericRepository;

import java.util.List;

public class RoupaRepository extends GenericRepository {

	public RoupaRepository() {
		super();
	}

	public List<Roupa> getRoupas() {
		return this.em.createQuery("SELECT r FROM Roupa r", Roupa.class).getResultList();
	}

}
