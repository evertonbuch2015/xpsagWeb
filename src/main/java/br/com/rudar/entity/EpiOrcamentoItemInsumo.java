package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EPI_ORCAMENTO_ITEM_INSUMO database table.
 * 
 */
@Entity
@Table(name="EPI_ORCAMENTO_ITEM_INSUMO")
@NamedQuery(name="EpiOrcamentoItemInsumo.findAll", query="SELECT e FROM EpiOrcamentoItemInsumo e")
public class EpiOrcamentoItemInsumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="G_EPI_ORCAMENTO_ITEM_INSUMO", sequenceName="G_EPI_ORCAMENTO_ITEM_INSUMO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_ORCAMENTO_ITEM_INSUMO")
	@Column(name="COD_EPIORCAMENTOITEMINSUMO")
	private Integer id;

	@Column(name="COD_CADPRODUTO")
	private int codCadproduto;

	@Column(name="COD_CADUNIDADE")
	private int codCadunidade;

	private int item;

	@Column(name="NOME_PRODUTO")
	private String nomeProduto;

	private String observacao;

	private BigDecimal quantidade;

	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;
	
	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;

	
	//bi-directional many-to-one association to EpiOrcamentoItem
	@ManyToOne
	@JoinColumn(name="COD_EPIORCAMENTOITEM")
	private EpiOrcamentoItem epiOrcamentoItem;
	
	
	
	//--------------------------------	GETs and SETs------------------------------//
	

	public EpiOrcamentoItemInsumo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCodCadproduto() {
		return this.codCadproduto;
	}

	public void setCodCadproduto(int codCadproduto) {
		this.codCadproduto = codCadproduto;
	}

	public int getCodCadunidade() {
		return this.codCadunidade;
	}

	public void setCodCadunidade(int codCadunidade) {
		this.codCadunidade = codCadunidade;
	}

	public int getItem() {
		return this.item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getNomeProduto() {
		return this.nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public EpiOrcamentoItem getEpiOrcamentoItem() {
		return this.epiOrcamentoItem;
	}

	public void setEpiOrcamentoItem(EpiOrcamentoItem epiOrcamentoItem) {
		this.epiOrcamentoItem = epiOrcamentoItem;
	}

}