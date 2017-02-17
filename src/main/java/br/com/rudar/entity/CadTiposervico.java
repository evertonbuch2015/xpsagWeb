package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CAD_TIPOSERVICO database table.
 * 
 */
@Entity
@Table(name="CAD_TIPOSERVICO")
@NamedQuery(name="CadTiposervico.findAll", query="SELECT c FROM CadTiposervico c")
public class CadTiposervico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAD_TIPOSERVICO_ID_GENERATOR",
					   sequenceName="G_CAD_TIPO_SERVICO", allocationSize= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAD_TIPOSERVICO_ID_GENERATOR")
	@Column(name="COD_CADTIPOSERVICO")
	private Integer id;

	private String cemp;

	@Column(name="CODIGO_ESTRUTURAL")
	private String codigoEstrutural;

	private long grau;

	private String nome;

	private String obs;

	@Column(name="PERC_QUEBRA")
	private double percQuebra;

	private String terceiro;

	private Character tipo;

	private double valor;

	
	//uni-directional many-to-one association to PlanoConta
	@ManyToOne
	@JoinColumn(name="COD_CTBPLANOCONTAS")
	private PlanoConta planoContas;

	
	//bi-directional many-to-one association to CadTipoServicoItem
	@OneToMany(mappedBy="tipoServico")
	private List<CadTipoServicoItem> tiposervicoItens;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	
	public CadTiposervico() {
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

	
	public String getCodigoEstrutural() {
		return this.codigoEstrutural;
	}

	public void setCodigoEstrutural(String codigoEstrutural) {
		this.codigoEstrutural = codigoEstrutural;
	}

	
	public long getGrau() {
		return this.grau;
	}

	public void setGrau(long grau) {
		this.grau = grau;
	}

	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	
	public double getPercQuebra() {
		return this.percQuebra;
	}

	public void setPercQuebra(double percQuebra) {
		this.percQuebra = percQuebra;
	}

	
	public String getTerceiro() {
		return this.terceiro;
	}

	public void setTerceiro(String terceiro) {
		this.terceiro = terceiro;
	}

	
	public Character getTipo() {
		return this.tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	
	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	public PlanoConta getPlanoContas() {
		return this.planoContas;
	}

	public void setPlanoContas(PlanoConta planoContas) {
		this.planoContas = planoContas;
	}

	
	public List<CadTipoServicoItem> getTiposervicoItens() {
		return this.tiposervicoItens;
	}

	public void setTiposervicoItens(List<CadTipoServicoItem> tiposervicoItens) {
		this.tiposervicoItens = tiposervicoItens;
	}

	
	public CadTipoServicoItem addTiposervicoIten(CadTipoServicoItem tiposervicoIten) {
		getTiposervicoItens().add(tiposervicoIten);
		tiposervicoIten.setTipoServico(this);

		return tiposervicoIten;
	}

	public CadTipoServicoItem removeTiposervicoIten(CadTipoServicoItem tiposervicoIten) {
		getTiposervicoItens().remove(tiposervicoIten);
		tiposervicoIten.setTipoServico(null);

		return tiposervicoIten;
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
		CadTiposervico other = (CadTiposervico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}