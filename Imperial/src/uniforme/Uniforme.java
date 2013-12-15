package uniforme;

import funcao.Funcao;
import roupas.Roupa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Uniforme {

	@Id @GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String nomeUniforme;
	
	@OneToOne
	private Funcao funcao;
	
	@OneToMany
	private List<Roupa> roupas;
	
	public Uniforme() {
		this.funcao = new Funcao();
	}

	public Uniforme(Integer id, String nomeUniforme, List<Roupa> roupas, Funcao funcao) {
		super();
		this.id = id;
		this.nomeUniforme = nomeUniforme;
		this.roupas = roupas;
		this.funcao = funcao;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nomeUniforme
	 */
	public String getNomeUniforme() {
		return nomeUniforme;
	}

	/**
	 * @param nomeUniforme the nomeUniforme to set
	 */
	public void setNomeUniforme(String nomeUniforme) {
		this.nomeUniforme = nomeUniforme;
	}

	/**
	 * @return the roupas
	 */
	public List<Roupa> getRoupas() {
		return roupas;
	}

	/**
	 * @param roupas the roupas to set
	 */
	public void setRoupas(List<Roupa> roupas) {
		this.roupas = roupas;
	}

	/**
	 * @return the funcao
	 */
	public Funcao getFuncao() {
		return funcao;
	}

	/**
	 * @param funcao the funcao to set
	 */
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}	
}
