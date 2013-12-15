package infra;

public interface IFacade {

	public <T> boolean cadastrar(T t);
	
	public <T> boolean atualizar(T t);
	
	public <T> boolean excluir(Class<?> classe, T id);
}
