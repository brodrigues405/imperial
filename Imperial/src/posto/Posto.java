package posto;

import endereco.Endereco;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Posto {

	@Id @GeneratedValue
	private Integer id;
	
	@Column(length=120)
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco local;
	
	public Posto() {
		this.local = new Endereco();
	}

	public Posto(Integer id, String nome, Endereco local) {
		super();
		this.id = id;
		this.nome = nome;
		this.local = local;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getLocal() {
		return local;
	}

	public void setLocal(Endereco local) {
		this.local = local;
	}
}