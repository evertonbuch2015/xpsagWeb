package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CTB_PLANO_CONTAS database table.
 * 
 */
@Entity
@Table(name="CTB_PLANO_CONTAS")
@NamedQuery(name="PlanoConta.findAll", query="SELECT p FROM PlanoConta p")
public class PlanoConta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name="CTB_PLANO_CONTAS_ID_GENERATOR", 
					   sequenceName="G_CTB_PLANO_CONTAS", allocationSize= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CTB_PLANO_CONTAS_ID_GENERATOR")
	@Column(name="COD_CTBPLANOCONTAS")
	private Integer id;

	
	private String cemp;

	@Column(name="CFIL")
	private String filial;

	@Column(name="COD_CTBPLANOCONTASSPED")
	private int codCtbplanocontassped;

	@Column(name="CODIGO_CONTABIL")
	private String codigoContabil;

	@Column(name="CODIGO_CONTABIL_SPED")
	private String codigoContabilSped;

	@Column(name="CODIGO_OPERACIONAL")
	private Integer codigoOperacional;

	
	@Column(name="DESC_LIVRO_AUXILIAR")
	private String descLivroAuxiliar;

	@Column(name="EXIGE_CENTRO_CUSTO")
	private Character exigeCentroCusto;

	private long grau;

	@Column(name="GRAVA_CONTA_FILIAL")
	private Character gravaContaFilial;

	@Column(name="LIVRO_AUXILIAR")
	private Character livroAuxiliar;

	private String natureza;

	private String nome;

	private Character situacao;

	private Character tipo;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public PlanoConta() {
	}

	
	
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getCemp() {
		return this.cemp;
	}

	public void setCemp(String cemp) {
		this.cemp = cemp;
	}

	
	public String getFilial() {
		return this.filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	
	public int getCodCtbplanocontassped() {
		return this.codCtbplanocontassped;
	}

	public void setCodCtbplanocontassped(int codCtbplanocontassped) {
		this.codCtbplanocontassped = codCtbplanocontassped;
	}

	
	public String getCodigoContabil() {
		return this.codigoContabil;
	}

	public void setCodigoContabil(String codigoContabil) {
		this.codigoContabil = codigoContabil;
	}

	
	public String getCodigoContabilSped() {
		return this.codigoContabilSped;
	}

	public void setCodigoContabilSped(String codigoContabilSped) {
		this.codigoContabilSped = codigoContabilSped;
	}

	
	public Integer getCodigoOperacional() {
		return this.codigoOperacional;
	}

	public void setCodigoOperacional(Integer codigoOperacional) {
		this.codigoOperacional = codigoOperacional;
	}

		
	public String getDescLivroAuxiliar() {
		return this.descLivroAuxiliar;
	}

	public void setDescLivroAuxiliar(String descLivroAuxiliar) {
		this.descLivroAuxiliar = descLivroAuxiliar;
	}

	
	public Character getExigeCentroCusto() {
		return this.exigeCentroCusto;
	}

	public void setExigeCentroCusto(Character exigeCentroCusto) {
		this.exigeCentroCusto = exigeCentroCusto;
	}

	
	public long getGrau() {
		return this.grau;
	}

	public void setGrau(long grau) {
		this.grau = grau;
	}

	
	public Character getGravaContaFilial() {
		return this.gravaContaFilial;
	}

	public void setGravaContaFilial(Character gravaContaFilial) {
		this.gravaContaFilial = gravaContaFilial;
	}

	
	public Character getLivroAuxiliar() {
		return this.livroAuxiliar;
	}

	public void setLivroAuxiliar(Character livroAuxiliar) {
		this.livroAuxiliar = livroAuxiliar;
	}

	
	public String getNatureza() {
		return this.natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Character getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	
	public Character getTipo() {
		return this.tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}




	
	
	//--------------------------------	Métodos Auxiliares------------------------------//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}




	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanoConta other = (PlanoConta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}