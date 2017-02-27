package br.com.rudar.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the EPI_ORCAMENTO_ITEM_MP database table.
 * 
 */
@Entity
@Table(name="EPI_ORCAMENTO_ITEM_MP")
@NamedQuery(name="OrcamentoItemMp.findAll", query="SELECT e FROM OrcamentoItemMp e")
public class OrcamentoItemMp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="G_EPI_ORCAMENTO_ITEM_MP", sequenceName="G_EPI_ORCAMENTO_ITEM_MP", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_ORCAMENTO_ITEM_MP")
	@Column(name="COD_EPIORCAMENTOITEMMP")
	private Integer id;

	@Column(name="ITEM")
	private Integer item;

	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_CADPRODUTO")
	private Produto produto;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_CADUNIDADE")
	private Unidade unidade;



	@Column(name="NOME_PRODUTO")
	private String nomeProduto;

	@Column(name="OBSERVACAO")
	private String observacao;

	
	
	@Column(name="COMPRIMENTO")
	private BigDecimal comprimento;

	@Column(name="DIAMETRO")
	private BigDecimal diametro;
	
	@Column(name="ESPESSURA")
	private BigDecimal espessura;

	@Column(name="LARGURA")
	private BigDecimal largura;

	
	//private String unidade;
	

	@Column(name="PERFIL")
	private BigDecimal perfil;

	@Column(name="PESO",insertable=false,updatable=false)
	private BigDecimal peso;

	@Column(name="PESO_ESPECIFICO")
	private BigDecimal pesoEspecifico;

	@Column(name="PESO_INFORMADO")
	private BigDecimal pesoInformado;

	@Column(name="QUANTIDADE")
	private BigDecimal quantidade;

	
	
	@Column(name="VALOR_TOTAL",insertable=false,updatable=false)
	private Double valorTotal;

	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;

	
	
	//bi-directional many-to-one association to OrcamentoItem
	@ManyToOne
	@JoinColumn(name="COD_EPIORCAMENTOITEM")
	private OrcamentoItem orcamentoItem;

		
	//--------------------------------	GETs and SETs------------------------------//
	
	public OrcamentoItemMp() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public BigDecimal getComprimento() {
		return comprimento;
	}

	public void setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
	}


	public BigDecimal getDiametro() {
		return diametro;
	}

	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}


	public BigDecimal getEspessura() {
		return espessura;
	}

	public void setEspessura(BigDecimal espessura) {
		this.espessura = espessura;
	}


	public BigDecimal getLargura() {
		return largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}


	public BigDecimal getPerfil() {
		return perfil;
	}

	public void setPerfil(BigDecimal perfil) {
		this.perfil = perfil;
	}


	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}


	public BigDecimal getPesoEspecifico() {
		return pesoEspecifico;
	}

	public void setPesoEspecifico(BigDecimal pesoEspecifico) {
		this.pesoEspecifico = pesoEspecifico;
	}


	public BigDecimal getPesoInformado() {
		return pesoInformado;
	}

	public void setPesoInformado(BigDecimal pesoInformado) {
		this.pesoInformado = pesoInformado;
	}


	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}


	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	public OrcamentoItem getOrcamentoItem() {
		return orcamentoItem;
	}

	public void setOrcamentoItem(OrcamentoItem orcamentoItem) {
		this.orcamentoItem = orcamentoItem;
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
		OrcamentoItemMp other = (OrcamentoItemMp) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}