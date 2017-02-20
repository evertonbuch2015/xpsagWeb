package br.com.rudar.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the CAD_TIPOSERVICO database table.
 * 
 */
@Entity
@Table(name="CAD_TIPOSERVICO")
@NamedQuery(name="Tiposervico.findAll", query="SELECT c FROM TipoServico c")
public class TipoServico implements Serializable {
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

	
	@Column(name="GRAU",insertable=false,updatable=false)
	private long grau;
	

	private String nome;

	private String obs;

	@Column(name="PERC_QUEBRA")
	private Double percQuebra;

	private String terceiro;

	private Character tipo;

	private Double valor;

	
	//uni-directional many-to-one association to PlanoContas
	@ManyToOne
	@JoinColumn(name="COD_CTBPLANOCONTAS")
	private PlanoContas planoContas;

	
	//bi-directional many-to-one association to TipoServicoItem
	@OneToMany(mappedBy="tipoServico", targetEntity = TipoServicoItem.class, 
			fetch = FetchType.LAZY,	
			cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE,CascadeType.DETACH})
	private List<TipoServicoItem> tipoServicoItens;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	
	public TipoServico() {
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

	
	public Double getPercQuebra() {
		return this.percQuebra;
	}

	public void setPercQuebra(Double percQuebra) {
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

	
	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
	public PlanoContas getPlanoContas() {
		return this.planoContas;
	}

	public void setPlanoContas(PlanoContas planoContas) {
		this.planoContas = planoContas;
	}

	
	public List<TipoServicoItem> getTipoServicoItens() {
		if(this.tipoServicoItens == null){
			this.tipoServicoItens = new ArrayList<>();
		}
		return this.tipoServicoItens;
	}

	public void setTipoServicoItens(List<TipoServicoItem> tipoServicoItens) {
		this.tipoServicoItens = tipoServicoItens;
	}

	
	//--------------------------------	Métodos Auxiliares------------------------------//
	
	public TipoServicoItem addTipoServicoItem(TipoServicoItem tipoServicoIten) {
		getTipoServicoItens().add(tipoServicoIten);
		tipoServicoIten.setTipoServico(this);

		return tipoServicoIten;
	}

	public TipoServicoItem removeTipoServicoItem(TipoServicoItem tipoServicoIten) {
		getTipoServicoItens().remove(tipoServicoIten);
		tipoServicoIten.setTipoServico(null);

		return tipoServicoIten;
	}

	
	
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
		TipoServico other = (TipoServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}