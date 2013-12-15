package documentos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Documentos {
	
	@Id @GeneratedValue
	private Integer id;
	
	//TODO Adicionar validacao do cpf
	@Column(nullable=false, length=14)
	private String cpf;
	
	@Column(nullable=false, length=14)
	private String rg;
	
	@Column(nullable=false, length=20)
	private String pis;
	
	@Column(nullable=false, length=25)
	private String titulo;
	
	@Column(nullable=false, length=8)
	private String zona;
	
	@Column(nullable=false, length=25)
	private String ctps;
	
	@Column(nullable=false, length=20)
	private String serie;
	
	@Column(nullable=false, length=30)
	private String reservista;
	
	@Column(nullable=false, length=25)
	private String categoria;
	
	public Documentos() {}

	public Documentos(Integer id, String cpf, String rg, String pis,
			String titulo, String zona, String ctps, String serie,
			String reservista, String categoria) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.pis = pis;
		this.titulo = titulo;
		this.zona = zona;
		this.ctps = ctps;
		this.serie = serie;
		this.reservista = reservista;
		this.categoria = categoria;
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
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return the pis
	 */
	public String getPis() {
		return pis;
	}

	/**
	 * @param pis the pis to set
	 */
	public void setPis(String pis) {
		this.pis = pis;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

	/**
	 * @return the ctps
	 */
	public String getCtps() {
		return ctps;
	}

	/**
	 * @param ctps the ctps to set
	 */
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	/**
	 * @return the serie
	 */
	public String getSerie() {
		return serie;
	}

	/**
	 * @param serie the serie to set
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/**
	 * @return the reservista
	 */
	public String getReservista() {
		return reservista;
	}

	/**
	 * @param reservista the reservista to set
	 */
	public void setReservista(String reservista) {
		this.reservista = reservista;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}