package roupas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Roupa {
	
	@Id  @GeneratedValue
	private Integer id;
	
	@Column(length=120, nullable=false)
	private String nome;
	
	@Column(length=10, nullable=false)
	private String tamanho;
	
	@Column(nullable=false)
	private Integer qtd;
	
	@Column(nullable=false)
	private Float precoUnidade;
	
	@Column(nullable=false)
	private Float precoTotal;
	
	public Roupa() {}

	public Roupa(Integer id, String nome, String tamanho, Integer qtd, Float precoUnidade, Float precoTotal) {
		super();
		this.id = id;
		this.nome = nome;
		this.tamanho = tamanho;
		this.qtd = qtd;
		this.precoUnidade = precoUnidade;
		this.precoTotal = precoTotal;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tamanho
	 */
	public String getTamanho() {
		return tamanho;
	}

	/**
	 * @param tamanho the tamanho to set
	 */
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	/**
	 * @return the qtd
	 */
	public Integer getQtd() {
		return qtd;
	}

	/**
	 * @param qtd the qtd to set
	 */
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	/**
	 * @return the precoUnidade
	 */
	public Float getPrecoUnidade() {
		return precoUnidade;
	}

	/**
	 * @param precoUnidade the precoUnidade to set
	 */
	public void setPrecoUnidade(Float precoUnidade) {
		this.precoUnidade = precoUnidade;
	}

	/**
	 * @return the precoTotal
	 */
	public Float getPrecoTotal() {
		return precoTotal;
	}

	/**
	 * @param precoTotal the precoTotal to set
	 */
	public void setPrecoTotal(Float precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	
}
