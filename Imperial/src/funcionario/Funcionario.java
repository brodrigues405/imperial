package funcionario;

import documentos.Documentos;
import enuns.EstadoCivil;
import enuns.Status;
import funcao.Funcao;
import posto.Posto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

@Entity
public class Funcionario {
	
	@Id @GeneratedValue
	private Integer id;
	
	@Column(nullable=true, length=250)
	private Integer codigo;
	
	@Column(nullable=true, length=250)
	private String nome;
	
	@Column(nullable=true, length=250)
	private String nomePai;
	
	@Column(nullable=true, length=250)
	private String nomeMae;
	
	@Past(message="A data de nascimento não pode ser superior ao dia de hoje.")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(nullable=true)
	private Integer idade;
	
	@Column(nullable=true, length=120)
	private String localNascimento;
	
	@Column(nullable=true, length=2)
	private String uf;
	
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	@Column(nullable=true, length=250)
	private String nomeConjuge;
	
	@Column(nullable=true, length=16)
	private String telefone;
	
	@Lob
	@Column(nullable=true)
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true )
	private Documentos documentos;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true )
	private Profissional profissional;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true )
	private Banco banco;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Funcao funcao;
	
	@Column(nullable=true)
	private String camisa;
	
	@Column(nullable=true)
	private String calca;
	
	@Column(nullable=true)
	private String sapato;
	
	@Temporal(TemporalType.DATE)
	private Date entrega;
	
	@Temporal(TemporalType.DATE)
	private Date troca;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Posto localTrabalho;	
	
	public Funcionario() {
		this.documentos = new Documentos();
		this.profissional = new Profissional();
		this.funcao = new Funcao();
		this.banco = new Banco();
		this.localTrabalho = new Posto();
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
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	 * @return the nomePai
	 */
	public String getNomePai() {
		return nomePai;
	}

	/**
	 * @param nomePai the nomePai to set
	 */
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	/**
	 * @return the nomeMae
	 */
	public String getNomeMae() {
		return nomeMae;
	}

	/**
	 * @param nomeMae the nomeMae to set
	 */
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the idade
	 */
	public Integer getIdade() {
		return idade;
	}

	/**
	 * @param idade the idade to set
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	/**
	 * @return the localNascimento
	 */
	public String getLocalNascimento() {
		return localNascimento;
	}

	/**
	 * @param localNascimento the localNascimento to set
	 */
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the estadoCivil
	 */
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * @return the nomeConjuge
	 */
	public String getNomeConjuge() {
		return nomeConjuge;
	}

	/**
	 * @param nomeConjuge the nomeConjuge to set
	 */
	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	/**
	 * @return the foto
	 */
	public byte[] getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	/**
	 * @return the documentos
	 */
	public Documentos getDocumentos() {
		return documentos;
	}

	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(Documentos documentos) {
		this.documentos = documentos;
	}

	/**
	 * @return the profissional
	 */
	public Profissional getProfissional() {
		return profissional;
	}

	/**
	 * @param profissional the profissional to set
	 */
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
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

	/**
	 * @return the banco
	 */
	public Banco getBanco() {
		return banco;
	}

	/**
	 * @param banco the banco to set
	 */
	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	/**
	 * @return the camisa
	 */
	public String getCamisa() {
		return camisa;
	}

	/**
	 * @param camisa the camisa to set
	 */
	public void setCamisa(String camisa) {
		this.camisa = camisa;
	}

	/**
	 * @return the calca
	 */
	public String getCalca() {
		return calca;
	}

	/**
	 * @param calca the calca to set
	 */
	public void setCalca(String calca) {
		this.calca = calca;
	}

	/**
	 * @return the sapato
	 */
	public String getSapato() {
		return sapato;
	}

	/**
	 * @param sapato the sapato to set
	 */
	public void setSapato(String sapato) {
		this.sapato = sapato;
	}

	/**
	 * @return the entrega
	 */
	public Date getEntrega() {
		return entrega;
	}

	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(Date entrega) {
		this.entrega = entrega;
	}

	/**
	 * @return the troca
	 */
	public Date getTroca() {
		return troca;
	}

	/**
	 * @param troca the troca to set
	 */
	public void setTroca(Date troca) {
		this.troca = troca;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the localTrabalho
	 */
	public Posto getLocalTrabalho() {
		return localTrabalho;
	}

	/**
	 * @param localTrabalho the localTrabalho to set
	 */
	public void setLocalTrabalho(Posto localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
}