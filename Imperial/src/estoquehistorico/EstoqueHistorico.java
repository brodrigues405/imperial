package estoquehistorico;

import java.util.Date;

import material.Estoque;
import posto.Posto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EstoqueHistorico {

	@Id @GeneratedValue
	private Integer id;
	
	@OneToOne
	private Estoque estoque;
	
	private Integer qtdTransferida;
	
	@OneToOne
	private Posto destino;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public EstoqueHistorico() {}

	public EstoqueHistorico(Integer id, Estoque estoque,
			Integer qtdTransferida, Posto destino, Date data) {
		super();
		this.id = id;
		this.estoque = estoque;
		this.qtdTransferida = qtdTransferida;
		this.destino = destino;
		this.data = data;
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
	 * @return the estoque
	 */
	public Estoque getEstoque() {
		return estoque;
	}

	/**
	 * @param estoque the estoque to set
	 */
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	/**
	 * @return the qtdTransferida
	 */
	public Integer getQtdTransferida() {
		return qtdTransferida;
	}

	/**
	 * @param qtdTransferida the qtdTransferida to set
	 */
	public void setQtdTransferida(Integer qtdTransferida) {
		this.qtdTransferida = qtdTransferida;
	}

	/**
	 * @return the destino
	 */
	public Posto getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(Posto destino) {
		this.destino = destino;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
}