package funcao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="FuncaoConverter")
public class FuncaoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {				
		
		Object retorno = null;
		
		if(!valor.equals("")) {
			retorno = new FuncaoFacade().getFuncao(Integer.parseInt(valor));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {		
		
		String r = "";
		
		if(objeto != null) {
			r = objeto.toString();
		}
		
		return r;
	}
}
