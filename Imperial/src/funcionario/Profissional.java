package funcionario;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Profissional {
	
	@Id @GeneratedValue
	private Integer id;
	
	@Column(nullable=true)
	@Temporal(TemporalType.DATE)
	private Date admissao;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIME)
	private Date intervaloAlmoco;
	
	@Temporal(TemporalType.DATE)
	private Date demissao;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIME)
	private Date entrada;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIME)
	private Date saida;
	
	@Column(nullable=true)
	private String descancoSemanal;
	
	@Temporal(TemporalType.DATE)
	private Date feriasInicio;
	
	@Temporal(TemporalType.DATE)
	private Date feriasTermino;
	
	@Column(scale=2, precision=10)
	private BigDecimal salario;
	
	@Enumerated(EnumType.STRING)
	private Empresa empresa;
	
	public Profissional() {}

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
	 * @return the admissao
	 */
	public Date getAdmissao() {
		return admissao;
	}

	/**
	 * @param admissao the admissao to set
	 */
	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	/**
	 * @return the intervaloAlmoco
	 */
	public Date getIntervaloAlmoco() {
		return intervaloAlmoco;
	}

	/**
	 * @param intervaloAlmoco the intervaloAlmoco to set
	 */
	public void setIntervaloAlmoco(Date intervaloAlmoco) {
		this.intervaloAlmoco = intervaloAlmoco;
	}

	/**
	 * @return the demissao
	 */
	public Date getDemissao() {
		return demissao;
	}

	/**
	 * @param demissao the demissao to set
	 */
	public void setDemissao(Date demissao) {
		this.demissao = demissao;
	}

	/**
	 * @return the entrada
	 */
	public Date getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the saida
	 */
	public Date getSaida() {
		return saida;
	}

	/**
	 * @param saida the saida to set
	 */
	public void setSaida(Date saida) {
		this.saida = saida;
	}

	/**
	 * @return the descancoSemanal
	 */
	public String getDescancoSemanal() {
		return descancoSemanal;
	}

	/**
	 * @param descancoSemanal the descancoSemanal to set
	 */
	public void setDescancoSemanal(String descancoSemanal) {
		this.descancoSemanal = descancoSemanal;
	}

	/**
	 * @return the feriasInicio
	 */
	public Date getFeriasInicio() {
		return feriasInicio;
	}

	/**
	 * @param feriasInicio the feriasInicio to set
	 */
	public void setFeriasInicio(Date feriasInicio) {
		this.feriasInicio = feriasInicio;
	}

	/**
	 * @return the feriasTermino
	 */
	public Date getFeriasTermino() {
		return feriasTermino;
	}

	/**
	 * @param feriasTermino the feriasTermino to set
	 */
	public void setFeriasTermino(Date feriasTermino) {
		this.feriasTermino = feriasTermino;
	}

	/**
	 * @return the salario
	 */
	public BigDecimal getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}