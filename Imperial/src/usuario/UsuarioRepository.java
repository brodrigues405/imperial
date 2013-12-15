package usuario;

import infra.GenericRepository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UsuarioRepository extends GenericRepository {

	public UsuarioRepository() {
		super();
	}

	/**
	 * Recupera todos os usuarios do banco de dados.
	 * @return
	 */
	public List<Usuario> recuperaUsuarios() {

		String jpql = "SELECT u FROM Usuario u";
		TypedQuery<Usuario> query = this.em.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

	/**
	 * Executa o teste no login e senha do usuario.
	 * 
	 * @param login
	 * @param senha
	 * @return
	 */
	public Usuario autenticar(String login, String senha) {
		
		Usuario retorno = null;
		
		try {
			String jpql = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha";
			TypedQuery<Usuario> query = this.em.createQuery(jpql, Usuario.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			retorno = query.getSingleResult();
		}
		catch (NoResultException n) {
			retorno = null;
		}
		
		return retorno;
	}
}