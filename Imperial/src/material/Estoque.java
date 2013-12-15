package material;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Estoque {

	@Id @GeneratedValue
 	private Integer id;
	
	@NotNull(message="A descrição não pode ser nula.")
	@Column(unique=true, nullable=false)
	private String descricao;	
	
	private Integer qtd;
	
	@Column(precision=5, scale=2)
	private BigDecimal valorUnidade;
	
	@Column(precision=10, scale=2)
	private BigDecimal valorTotal;
	
	private Integer minimo;
	
	public Estoque() {}

	public Estoque(Integer id, String descricao, Integer qtd,
			BigDecimal valorUnidade, Integer minimo, BigDecimal valorTotal) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.qtd = qtd;
		this.valorUnidade = valorUnidade;
		this.minimo = minimo;
		this.valorTotal = valorTotal;
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	 * @return the valorUnidade
	 */
	public BigDecimal getValorUnidade() {
		return valorUnidade;
	}

	/**
	 * @param valorUnidade the valorUnidade to set
	 */
	public void setValorUnidade(BigDecimal valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the minimo
	 */
	public Integer getMinimo() {
		return minimo;
	}

	/**
	 * @param minimo the minimo to set
	 */
	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}

}