package patrimonio;

import funcionario.Funcionario;
import posto.Posto;

import java.util.Date;

public class Patrimonio {
	
	private Integer id;
	private String descricao;
	private String marca;
	private String modelo;
	private String serie;
	private Date dataCompra;
	private Posto condominio;
	private Funcionario funcionario;
	private Float preco;
	
	public Patrimonio() {}

	public Patrimonio(Integer id, String descricao, String marca,
			String modelo, String serie, Date dataCompra,
			Posto condominio, Funcionario funcionario, Float preco) {
		this.id = id;
		this.descricao = descricao;
		this.marca = marca;
		this.modelo = modelo;
		this.serie = serie;
		this.dataCompra = dataCompra;
		this.condominio = condominio;
		this.funcionario = funcionario;
		this.preco = preco;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Posto getCondominio() {
		return condominio;
	}

	public void setCondominio(Posto condominio) {
		this.condominio = condominio;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}	
}