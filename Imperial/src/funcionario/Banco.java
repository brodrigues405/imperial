package funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Banco {
	
	@Id @GeneratedValue
	private Integer id;
	
	@Column(nullable=true, length=40)
	private String banco;
	
	@Column(nullable=true, length=40)
	private String agencia;
	
	@Column(nullable=true, length=40)
	private String conta;
	
	public Banco() {}

	public Banco(Integer id, String banco, String agencia, String conta) {
		super();
		this.id = id;
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
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
	 * @return the banco
	 */
	public String getBanco() {
		return banco;
	}

	/**
	 * @param banco the banco to set
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}

	/**
	 * @return the agencia
	 */
	public String getAgencia() {
		return agencia;
	}

	/**
	 * @param agencia the agencia to set
	 */
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	/**
	 * @return the conta
	 */
	public String getConta() {
		return conta;
	}

	/**
	 * @param conta the conta to set
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}
}
