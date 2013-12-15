package infra;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Classe que implementa os filtros da aplicacao.
 * 
 * @author v0rtex
 *
 */
@WebFilter(servletNames={"Faces Servlet"})
public class JPAFilter implements Filter {

	private EntityManagerFactory factory;
	
	/**
	 * Destroi o EntityManagerFactory quando a aplicacao for finalizada.
	 * 
	 */
	@Override
	public void destroy() {
		this.factory.close();		
	}

	/**
	 * Filtro responsavel pela instanciacao do EntityManager
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException, NoResultException {
		
		//Cria o EntityManager
		EntityManager manager = this.factory.createEntityManager();
		
		//Seta o EntityManager no request.
		request.setAttribute("EntityManager", manager);
		
		//Inicializa o EntityManager
		manager.getTransaction().begin();
		
		//Chama o Faces Servlet
		chain.doFilter(request, response);
		
		//Saindo
		try {
			manager.getTransaction().commit();
		}
		catch (IllegalStateException i) {		
			if(manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
		}
		catch (Exception e) {
			
			if(manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
			
			e.printStackTrace();
		}
		finally {
			manager.close();
		}			
	}

	/**
	 * Instancia o EntityManagerFactory quando a aplicacao foi inicializada.
	 * 
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory("imperialPU");
		System.out.println("Aqui!!!");
	}
}