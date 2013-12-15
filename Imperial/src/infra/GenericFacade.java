package infra;


/**
 * Facade basico que implementa operacao de cadastrar, atualizar e excluir
 * sem validar nas regras de negocios, bom para ser chamado dentro de uma condicao
 * apos testar a regra de negocios.
 * 
 * @author v0rtex
 *
 */
public class GenericFacade implements IFacade {
	
	@Override
	public <T> boolean cadastrar(T t) {		
		if(new GenericRepository().cadastrar(t)){
			return true;
		}		
		return false;
		
	}

	@Override
	public <T> boolean atualizar(T t) {
		if(new GenericRepository().alterar(t)){
			return true;
		}
		return false;	
	}
	@Override
	public <T> boolean excluir(Class<?> classe, T id) {
		
		if(new GenericRepository().excluir(classe, (Integer)id)) {
			return true;
		}
		
		return false;
	}
}
